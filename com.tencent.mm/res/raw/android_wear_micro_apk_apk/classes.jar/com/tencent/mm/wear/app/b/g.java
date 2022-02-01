package com.tencent.mm.wear.app.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.e.a.m;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.a.c;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class g
{
  private c adZ = new com.tencent.mm.wear.app.a.a();
  private String aeA = "language_default";
  private String aeB = "@invalid@";
  private byte[] aey;
  private m aez;
  
  public g()
  {
    SharedPreferences localSharedPreferences = MMApplication.getContext().getSharedPreferences("connect_core_shared_pre_name", 0);
    this.aeB = localSharedPreferences.getString("key_connect_username", "@invalid@");
    this.aeA = localSharedPreferences.getString("key_connect_language", "language_default");
  }
  
  protected final void a(m paramm)
  {
    this.aez = paramm;
    this.aeA = paramm.XG;
    this.aeB = paramm.Xh;
    paramm = MMApplication.getContext().getSharedPreferences("connect_core_shared_pre_name", 0);
    paramm.edit().putString("key_connect_language", this.aeA).commit();
    paramm.edit().putString("key_connect_username", this.aeB).commit();
    MMActivity.A(MMApplication.getContext());
  }
  
  protected final void j(byte[] paramArrayOfByte)
  {
    this.aey = paramArrayOfByte;
  }
  
  public final byte[] k(byte[] paramArrayOfByte)
  {
    Cipher localCipher = null;
    Object localObject = localCipher;
    if (paramArrayOfByte != null)
    {
      localObject = localCipher;
      if (this.aey == null) {}
    }
    try
    {
      com.tencent.mm.wear.a.c.d.d("MicroMsg.MMConnectionCore", "sessionKey is not null %s", new Object[] { com.tencent.mm.a.d.g(this.aey) });
      localObject = new SecretKeySpec(this.aey, "AES");
      localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      localCipher.init(1, (Key)localObject);
      localObject = localCipher.doFinal(paramArrayOfByte);
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.mm.wear.a.c.d.a("MicroMsg.MMConnectionCore", paramArrayOfByte);
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
      if (this.aey == null) {}
    }
    try
    {
      com.tencent.mm.wear.a.c.d.d("MicroMsg.MMConnectionCore", "sessionKey is not null %s", new Object[] { com.tencent.mm.a.d.g(this.aey) });
      localObject1 = com.tencent.mm.c.b.a.a.a(paramArrayOfByte, this.aey);
      return localObject1;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.mm.wear.a.c.d.a("MicroMsg.MMConnectionCore", paramArrayOfByte);
    }
    return null;
  }
  
  public final c mF()
  {
    return this.adZ;
  }
  
  public final m mG()
  {
    return this.aez;
  }
  
  public final boolean mH()
  {
    if (this.aez == null) {}
    while (("language_default".equals(this.aez.XG)) || ("zh_CN".equals(this.aez.XG))) {
      return false;
    }
    return true;
  }
  
  public final String mI()
  {
    return this.aeA;
  }
  
  public final String mJ()
  {
    return this.aeB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.b.g
 * JD-Core Version:    0.7.0.1
 */