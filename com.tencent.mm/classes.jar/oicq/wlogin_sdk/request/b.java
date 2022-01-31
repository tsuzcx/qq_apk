package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.security.SecureRandom;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class b
{
  private Context mContext = null;
  public i xpP = new i();
  private j xpQ = new j(this.xpP);
  private f xpR = new f(this.xpP);
  private g xpS = new g(this.xpP);
  private h xpT = new h(this.xpP);
  private e xpU = new e(this.xpP);
  public d xpV = null;
  private int xpW = 66560;
  private int xpX = 1404;
  
  public b(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    i locali = this.xpP;
    locali._context = paramContext;
    locali.xqD = paramInt;
    locali.xqX = new c(paramContext);
    paramContext = new byte[16];
    locali.xqu.nextBytes(paramContext);
    System.arraycopy(paramContext, 0, locali.xqx, 0, 16);
    cUz();
  }
  
  private int cUz()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = util.iB(this.mContext);
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          localObject1 = util.iu(this.mContext);
          if ((localObject1 == null) || (localObject1.length <= 0))
          {
            localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
            this.xpP.xqQ = 0;
            util.b(this.mContext, (byte[])localObject1);
            this.xpP.xqP = 1;
            this.xpP.xqR = 1;
            this.xpP.xqE = new byte[localObject1.length];
            System.arraycopy(localObject1, 0, this.xpP.xqE, 0, localObject1.length);
            Object localObject3 = new byte[localObject1.length + 1];
            localObject3[0] = 35;
            System.arraycopy(localObject1, 0, localObject3, 1, localObject1.length);
            this.xpP.xqv = util.cg((byte[])localObject3);
            i.xqF = (byte[])this.xpP.xqE.clone();
            this.xpP.xqG = util.iv(this.mContext);
            i = util.ix(this.mContext);
            this.xpP.xqH = util.iw(this.mContext);
            if (i != this.xpP.xqH)
            {
              util.iy(this.mContext);
              util.aq(this.mContext, this.xpP.xqH);
            }
            this.xpP.xqJ = util.iz(this.mContext).getBytes();
            this.xpP.xqS = util.iA(this.mContext);
            this.xpP.xqI = util.iC(this.mContext);
            this.xpP.xqL = util.bW(this.mContext, new String(this.xpP.xqI));
            this.xpP.xqM = util.bX(this.mContext, new String(this.xpP.xqI));
            localObject1 = Build.MODEL;
            if (localObject1 != null) {
              break label479;
            }
            this.xpP.xqN = new byte[0];
            if ((util.isFileExist("/system/bin/su")) || (util.isFileExist("/system/xbin/su")) || (util.isFileExist("/sbin/su"))) {
              break label493;
            }
            i = 0;
            localObject1 = this.xpP;
            if (i == 0) {
              break label498;
            }
            i = 1;
            ((i)localObject1).xqO = i;
            localObject3 = Build.VERSION.RELEASE;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            util.ahk("WtloginHelper init ok: android version:" + (String)localObject1 + " release time:" + util.cUQ());
            return 0;
          }
          this.xpP.xqQ = 1;
          continue;
        }
        this.xpP.xqQ = 1;
      }
      finally {}
      this.xpP.xqP = 0;
      this.xpP.xqR = 0;
      continue;
      label479:
      this.xpP.xqN = localObject2.getBytes();
      continue;
      label493:
      int i = 1;
      continue;
      label498:
      i = 0;
    }
  }
  
  public final byte[] a(long paramLong, a parama, String paramString)
  {
    util.ahk("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 ...");
    String str = paramString;
    if (paramString.length() > 16) {
      str = paramString.substring(0, 16);
    }
    try
    {
      switch (cUA()[parama.ordinal()])
      {
      case 1: 
        return null;
      }
    }
    finally {}
    if ((str == null) || (str.length() == 0))
    {
      util.ahk("USER_WITH_PWD userPasswd null");
      return null;
    }
    parama = oicq.wlogin_sdk.tools.c.ahi(str);
    for (int i = 0;; i = 1)
    {
      this.xpP.xqH = util.iw(this.mContext);
      this.xpP.xqJ = util.iz(this.mContext).getBytes();
      this.xpP._uin = paramLong;
      this.xpP.xqA = 522017402L;
      this.xpP.xqB = 8256;
      this.xpP.xqy = new oicq.wlogin_sdk.a.f();
      this.xpV = this.xpQ;
      if (i != 0) {}
      for (parama = this.xpQ.a(paramLong, this.xpP.xqV, parama, this.xpX, this.xpW, this.xpP.xqS);; parama = this.xpQ.a(paramLong, this.xpP.xqV, paramString, parama, this.xpX, this.xpW, this.xpP.xqS))
      {
        for (;;)
        {
          util.ahk("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 end");
          return parama;
          if ((str == null) || (str.length() == 0))
          {
            util.ahk("USER_WITH_MD5 userPasswd null");
            return null;
          }
          try
          {
            parama = (byte[])str.getBytes("ISO-8859-1").clone();
            i = 0;
          }
          catch (Exception parama)
          {
            return null;
          }
        }
        parama = this.xpP.iF(paramLong);
        if ((parama == null) || (parama._en_A1 == null) || (parama._en_A1.length <= 0)) {
          util.ahk("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: null");
        }
        for (parama = null; (parama == null) || (parama.length < 16); parama = (byte[])parama._en_A1.clone())
        {
          util.ahk("USER_WITH_A1 tmp_pwd null");
          return null;
          util.ahk("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: not null");
        }
        paramString = new byte[4];
        util.d(paramString, 0, i.cUD());
      }
      break;
    }
  }
  
  public final byte[] f(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    util.ahk("user:" + paramLong + " CheckPicture ...");
    try
    {
      this.xpV = this.xpS;
      paramArrayOfByte = this.xpS.bY(paramArrayOfByte);
      util.ahk("user:" + paramLong + " CheckPicture end");
      return paramArrayOfByte;
    }
    finally {}
  }
  
  /* Error */
  public final byte[] iC(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	oicq/wlogin_sdk/request/b:xpP	Loicq/wlogin_sdk/request/i;
    //   6: getfield 398	oicq/wlogin_sdk/request/i:xqz	Loicq/wlogin_sdk/a/g;
    //   9: astore_3
    //   10: aload_3
    //   11: getfield 403	oicq/wlogin_sdk/a/g:xrk	I
    //   14: newarray byte
    //   16: astore 4
    //   18: aload_3
    //   19: getfield 403	oicq/wlogin_sdk/a/g:xrk	I
    //   22: ifgt +40 -> 62
    //   25: aload_0
    //   26: monitorexit
    //   27: new 275	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 386
    //   34: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: lload_1
    //   38: invokevirtual 302	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   41: ldc_w 405
    //   44: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload 4
    //   49: arraylength
    //   50: invokevirtual 408	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 294	oicq/wlogin_sdk/tools/util:ahk	(Ljava/lang/String;)V
    //   59: aload 4
    //   61: areturn
    //   62: aload_3
    //   63: getfield 411	oicq/wlogin_sdk/a/g:xqk	[B
    //   66: aload_3
    //   67: getfield 414	oicq/wlogin_sdk/a/g:xrm	I
    //   70: aload 4
    //   72: iconst_0
    //   73: aload_3
    //   74: getfield 403	oicq/wlogin_sdk/a/g:xrk	I
    //   77: invokestatic 109	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   80: goto -55 -> 25
    //   83: astore_3
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	b
    //   0	88	1	paramLong	long
    //   9	65	3	localg	oicq.wlogin_sdk.a.g
    //   83	4	3	localObject	Object
    //   16	55	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	25	83	finally
    //   25	27	83	finally
    //   62	80	83	finally
    //   84	86	83	finally
  }
  
  public final void iD(long paramLong)
  {
    util.ahk("user:" + paramLong + " ClearUserSigInfo");
    this.xpP.j(Long.valueOf(paramLong));
  }
  
  public static enum a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.b
 * JD-Core Version:    0.7.0.1
 */