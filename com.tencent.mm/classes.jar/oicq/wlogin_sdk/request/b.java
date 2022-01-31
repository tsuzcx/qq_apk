package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class b
{
  public i CMc;
  private j CMd;
  private f CMe;
  private g CMf;
  private h CMg;
  private e CMh;
  public d CMi;
  private int CMj;
  private int CMk;
  private Context mContext;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(96408);
    this.CMc = new i();
    this.CMd = new j(this.CMc);
    this.CMe = new f(this.CMc);
    this.CMf = new g(this.CMc);
    this.CMg = new h(this.CMc);
    this.CMh = new e(this.CMc);
    this.CMi = null;
    this.mContext = null;
    this.CMj = 66560;
    this.CMk = 1404;
    this.mContext = paramContext;
    i locali = this.CMc;
    locali._context = paramContext;
    locali.CMQ = paramInt;
    locali.CNk = new c(paramContext);
    paramContext = new byte[16];
    locali.CMH.nextBytes(paramContext);
    System.arraycopy(paramContext, 0, locali.CMK, 0, 16);
    eqY();
    AppMethodBeat.o(96408);
  }
  
  private int eqY()
  {
    AppMethodBeat.i(96413);
    for (;;)
    {
      try
      {
        Object localObject1 = util.kj(this.mContext);
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          localObject1 = util.kc(this.mContext);
          if ((localObject1 == null) || (localObject1.length <= 0))
          {
            localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
            this.CMc.CNd = 0;
            util.b(this.mContext, (byte[])localObject1);
            this.CMc.CNc = 1;
            this.CMc.CNe = 1;
            this.CMc.CMR = new byte[localObject1.length];
            System.arraycopy(localObject1, 0, this.CMc.CMR, 0, localObject1.length);
            Object localObject3 = new byte[localObject1.length + 1];
            localObject3[0] = 35;
            System.arraycopy(localObject1, 0, localObject3, 1, localObject1.length);
            this.CMc.CMI = util.cR((byte[])localObject3);
            i.CMS = (byte[])this.CMc.CMR.clone();
            this.CMc.CMT = util.kd(this.mContext);
            i = util.kf(this.mContext);
            this.CMc.CMU = util.ke(this.mContext);
            if (i != this.CMc.CMU)
            {
              util.kg(this.mContext);
              util.aI(this.mContext, this.CMc.CMU);
            }
            this.CMc.CMW = util.kh(this.mContext).getBytes();
            this.CMc.CNf = util.ki(this.mContext);
            this.CMc.CMV = util.kk(this.mContext);
            this.CMc.CMY = util.ck(this.mContext, new String(this.CMc.CMV));
            this.CMc.CMZ = util.cl(this.mContext, new String(this.CMc.CMV));
            localObject1 = Build.MODEL;
            if (localObject1 != null) {
              break label492;
            }
            this.CMc.CNa = new byte[0];
            if ((util.isFileExist("/system/bin/su")) || (util.isFileExist("/system/xbin/su")) || (util.isFileExist("/sbin/su"))) {
              break label506;
            }
            i = 0;
            localObject1 = this.CMc;
            if (i == 0) {
              break label511;
            }
            i = 1;
            ((i)localObject1).CNb = i;
            localObject3 = Build.VERSION.RELEASE;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            util.azC("WtloginHelper init ok: android version:" + (String)localObject1 + " release time:" + util.erp());
            return 0;
          }
          this.CMc.CNd = 1;
          continue;
        }
        this.CMc.CNd = 1;
      }
      finally
      {
        AppMethodBeat.o(96413);
      }
      this.CMc.CNc = 0;
      this.CMc.CNe = 0;
      continue;
      label492:
      this.CMc.CNa = localObject2.getBytes();
      continue;
      label506:
      int i = 1;
      continue;
      label511:
      i = 0;
    }
  }
  
  public final byte[] a(long paramLong, a parama, String paramString)
  {
    AppMethodBeat.i(96409);
    util.azC("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 ...");
    String str = paramString;
    if (paramString.length() > 16) {
      str = paramString.substring(0, 16);
    }
    try
    {
      switch (eqZ()[parama.ordinal()])
      {
      case 1: 
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(96409);
    }
    if ((str == null) || (str.length() == 0))
    {
      util.azC("USER_WITH_PWD userPasswd null");
      AppMethodBeat.o(96409);
      return null;
    }
    parama = oicq.wlogin_sdk.tools.c.azA(str);
    for (int i = 0;; i = 1)
    {
      this.CMc.CMU = util.ke(this.mContext);
      this.CMc.CMW = util.kh(this.mContext).getBytes();
      this.CMc._uin = paramLong;
      this.CMc.CMN = 522017402L;
      this.CMc.CMO = 8256;
      this.CMc.CML = new oicq.wlogin_sdk.a.f();
      this.CMi = this.CMd;
      if (i != 0) {}
      for (parama = this.CMd.a(paramLong, this.CMc.CNi, parama, this.CMk, this.CMj, this.CMc.CNf);; parama = this.CMd.a(paramLong, this.CMc.CNi, paramString, parama, this.CMk, this.CMj, this.CMc.CNf))
      {
        for (;;)
        {
          util.azC("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 end");
          AppMethodBeat.o(96409);
          return parama;
          if ((str == null) || (str.length() == 0))
          {
            util.azC("USER_WITH_MD5 userPasswd null");
            AppMethodBeat.o(96409);
            return null;
          }
          try
          {
            parama = (byte[])str.getBytes("ISO-8859-1").clone();
            i = 0;
          }
          catch (Exception parama)
          {
            AppMethodBeat.o(96409);
            return null;
          }
        }
        parama = this.CMc.pD(paramLong);
        if ((parama == null) || (parama._en_A1 == null) || (parama._en_A1.length <= 0)) {
          util.azC("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: null");
        }
        for (parama = null; (parama == null) || (parama.length < 16); parama = (byte[])parama._en_A1.clone())
        {
          util.azC("USER_WITH_A1 tmp_pwd null");
          AppMethodBeat.o(96409);
          return null;
          util.azC("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: not null");
        }
        paramString = new byte[4];
        util.d(paramString, 0, i.erc());
      }
      break;
    }
  }
  
  public final byte[] f(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96410);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(96410);
      return null;
    }
    util.azC("user:" + paramLong + " CheckPicture ...");
    try
    {
      this.CMi = this.CMf;
      paramArrayOfByte = this.CMf.cJ(paramArrayOfByte);
      util.azC("user:" + paramLong + " CheckPicture end");
      AppMethodBeat.o(96410);
      return paramArrayOfByte;
    }
    finally
    {
      AppMethodBeat.o(96410);
    }
  }
  
  /* Error */
  public final byte[] pA(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 410
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 45	oicq/wlogin_sdk/request/b:CMc	Loicq/wlogin_sdk/request/i;
    //   12: getfield 414	oicq/wlogin_sdk/request/i:CMM	Loicq/wlogin_sdk/a/g;
    //   15: astore_3
    //   16: aload_3
    //   17: getfield 419	oicq/wlogin_sdk/a/g:CNx	I
    //   20: newarray byte
    //   22: astore 4
    //   24: aload_3
    //   25: getfield 419	oicq/wlogin_sdk/a/g:CNx	I
    //   28: ifgt +46 -> 74
    //   31: aload_0
    //   32: monitorexit
    //   33: new 263	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 400
    //   40: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: lload_1
    //   44: invokevirtual 315	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   47: ldc_w 421
    //   50: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 4
    //   55: arraylength
    //   56: invokevirtual 424	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 282	oicq/wlogin_sdk/tools/util:azC	(Ljava/lang/String;)V
    //   65: ldc_w 410
    //   68: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: areturn
    //   74: aload_3
    //   75: getfield 427	oicq/wlogin_sdk/a/g:CMx	[B
    //   78: aload_3
    //   79: getfield 430	oicq/wlogin_sdk/a/g:CNz	I
    //   82: aload 4
    //   84: iconst_0
    //   85: aload_3
    //   86: getfield 419	oicq/wlogin_sdk/a/g:CNx	I
    //   89: invokestatic 116	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   92: goto -61 -> 31
    //   95: astore_3
    //   96: aload_0
    //   97: monitorexit
    //   98: ldc_w 410
    //   101: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_3
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	b
    //   0	106	1	paramLong	long
    //   15	71	3	localg	oicq.wlogin_sdk.a.g
    //   95	10	3	localObject	Object
    //   22	61	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	31	95	finally
    //   31	33	95	finally
    //   74	92	95	finally
    //   96	98	95	finally
  }
  
  public final void pB(long paramLong)
  {
    AppMethodBeat.i(96412);
    util.azC("user:" + paramLong + " ClearUserSigInfo");
    this.CMc.i(Long.valueOf(paramLong));
    AppMethodBeat.o(96412);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(96405);
      CMm = new a("USER_WITH_PWD", 0);
      CMn = new a("USER_WITH_MD5", 1);
      CMo = new a("USER_WITH_A1", 2);
      CMp = new a[] { CMm, CMn, CMo };
      AppMethodBeat.o(96405);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.b
 * JD-Core Version:    0.7.0.1
 */