package com.tencent.xweb.util;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.xwalk.core.Log;

public final class b
{
  public static boolean aZ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156990);
    boolean bool = new a(paramString1, paramString2, paramString3, "SHA1withECDSA").verify();
    AppMethodBeat.o(156990);
    return bool;
  }
  
  static final class a
  {
    String IRA;
    String IRx;
    String IRy;
    String IRz;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.IRx = paramString1;
      this.IRy = paramString2;
      this.IRz = paramString3;
      this.IRA = paramString4;
    }
    
    public final boolean verify()
    {
      AppMethodBeat.i(156989);
      try
      {
        Object localObject1 = new X509EncodedKeySpec(Base64.decode(this.IRz, 0));
        Object localObject2 = KeyFactory.getInstance("EC").generatePublic((KeySpec)localObject1);
        localObject1 = Signature.getInstance(this.IRA);
        ((Signature)localObject1).initVerify((PublicKey)localObject2);
        localObject2 = Base64.decode(this.IRy, 0);
        ((Signature)localObject1).update(this.IRx.getBytes());
        boolean bool = ((Signature)localObject1).verify((byte[])localObject2);
        AppMethodBeat.o(156989);
        return bool;
      }
      catch (Exception localException)
      {
        Log.e("ECCUtil", "verify failed " + localException.getMessage());
        AppMethodBeat.o(156989);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.b
 * JD-Core Version:    0.7.0.1
 */