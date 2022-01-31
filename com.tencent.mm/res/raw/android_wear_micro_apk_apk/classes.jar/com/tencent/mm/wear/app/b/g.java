package com.tencent.mm.wear.app.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.e.a.m;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class g
{
  private byte[] aaX;
  private m aaY;
  private String aaZ = "language_default";
  private com.tencent.mm.wear.app.a.c aay = new com.tencent.mm.wear.app.a.a();
  private String aba = "@invalid@";
  
  public g()
  {
    SharedPreferences localSharedPreferences = MMApplication.getContext().getSharedPreferences("connect_core_shared_pre_name", 0);
    this.aba = localSharedPreferences.getString("key_connect_username", "@invalid@");
    this.aaZ = localSharedPreferences.getString("key_connect_language", "language_default");
  }
  
  protected final void a(m paramm)
  {
    this.aaY = paramm;
    this.aaZ = paramm.VL;
    this.aba = paramm.Vm;
    paramm = MMApplication.getContext().getSharedPreferences("connect_core_shared_pre_name", 0);
    paramm.edit().putString("key_connect_language", this.aaZ).commit();
    paramm.edit().putString("key_connect_username", this.aba).commit();
    MMActivity.z(MMApplication.getContext());
  }
  
  protected final void j(byte[] paramArrayOfByte)
  {
    this.aaX = paramArrayOfByte;
  }
  
  public final byte[] k(byte[] paramArrayOfByte)
  {
    Cipher localCipher = null;
    Object localObject = localCipher;
    if (paramArrayOfByte != null)
    {
      localObject = localCipher;
      if (this.aaX == null) {}
    }
    try
    {
      d.e("MicroMsg.MMConnectionCore", "sessionKey is not null %s", new Object[] { com.tencent.mm.a.c.g(this.aaX) });
      localObject = new SecretKeySpec(this.aaX, "AES");
      localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      localCipher.init(1, (Key)localObject);
      localObject = localCipher.doFinal(paramArrayOfByte);
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      d.a("MicroMsg.MMConnectionCore", paramArrayOfByte);
    }
    return null;
  }
  
  public final byte[] l(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfByte != null)
    {
      localObject1 = localObject2;
      if (this.aaX == null) {}
    }
    try
    {
      d.e("MicroMsg.MMConnectionCore", "sessionKey is not null %s", new Object[] { com.tencent.mm.a.c.g(this.aaX) });
      localObject1 = com.tencent.mm.c.a.a.a.a(paramArrayOfByte, this.aaX);
      return localObject1;
    }
    catch (Exception paramArrayOfByte)
    {
      d.a("MicroMsg.MMConnectionCore", paramArrayOfByte);
    }
    return null;
  }
  
  public final com.tencent.mm.wear.app.a.c lS()
  {
    return this.aay;
  }
  
  public final m lT()
  {
    return this.aaY;
  }
  
  public final boolean lU()
  {
    if (this.aaY == null) {}
    while (("language_default".equals(this.aaY.VL)) || ("zh_CN".equals(this.aaY.VL))) {
      return false;
    }
    return true;
  }
  
  public final String lV()
  {
    return this.aaZ;
  }
  
  public final String lW()
  {
    return this.aba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.b.g
 * JD-Core Version:    0.7.0.1
 */