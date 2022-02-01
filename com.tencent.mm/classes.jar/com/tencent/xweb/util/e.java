package com.tencent.xweb.util;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.xwalk.core.Log;

public final class e
{
  public static boolean bR(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156990);
    boolean bool = new a(paramString1, paramString2, paramString3, "SHA1withECDSA").verify();
    AppMethodBeat.o(156990);
    return bool;
  }
  
  static final class a
  {
    String aimA;
    String aimB;
    String aimC;
    String aimz;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.aimz = paramString1;
      this.aimA = paramString2;
      this.aimB = paramString3;
      this.aimC = paramString4;
    }
    
    public final boolean verify()
    {
      AppMethodBeat.i(156989);
      try
      {
        Object localObject1 = new X509EncodedKeySpec(Base64.decode(this.aimB, 0));
        Object localObject3 = KeyFactory.getInstance("EC").generatePublic((KeySpec)localObject1);
        localObject1 = Signature.getInstance(this.aimC);
        ((Signature)localObject1).initVerify((PublicKey)localObject3);
        localObject3 = Base64.decode(this.aimA, 0);
        ((Signature)localObject1).update(this.aimz.getBytes());
        boolean bool = ((Signature)localObject1).verify((byte[])localObject3);
        AppMethodBeat.o(156989);
        return bool;
      }
      finally
      {
        Log.e("ECCUtil", "verify failed " + localObject2.getMessage());
        AppMethodBeat.o(156989);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.util.e
 * JD-Core Version:    0.7.0.1
 */