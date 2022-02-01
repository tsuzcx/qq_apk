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
  public i NPR;
  private j NPS;
  private f NPT;
  private g NPU;
  private h NPV;
  private e NPW;
  public d NPX;
  private int NPY;
  private int NPZ;
  private Context mContext;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88047);
    this.NPR = new i();
    this.NPS = new j(this.NPR);
    this.NPT = new f(this.NPR);
    this.NPU = new g(this.NPR);
    this.NPV = new h(this.NPR);
    this.NPW = new e(this.NPR);
    this.NPX = null;
    this.mContext = null;
    this.NPY = 66560;
    this.NPZ = 1404;
    this.mContext = paramContext;
    i locali = this.NPR;
    locali._context = paramContext;
    locali.NQF = paramInt;
    locali.NQZ = new c(paramContext);
    paramContext = new byte[16];
    locali.NQw.nextBytes(paramContext);
    System.arraycopy(paramContext, 0, locali.NQz, 0, 16);
    gxP();
    AppMethodBeat.o(88047);
  }
  
  private int gxP()
  {
    AppMethodBeat.i(88052);
    for (;;)
    {
      try
      {
        Object localObject1 = util.lV(this.mContext);
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          localObject1 = util.lO(this.mContext);
          if ((localObject1 == null) || (localObject1.length <= 0))
          {
            localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
            this.NPR.NQS = 0;
            util.b(this.mContext, (byte[])localObject1);
            this.NPR.NQR = 1;
            this.NPR.NQT = 1;
            this.NPR.NQG = new byte[localObject1.length];
            System.arraycopy(localObject1, 0, this.NPR.NQG, 0, localObject1.length);
            Object localObject3 = new byte[localObject1.length + 1];
            localObject3[0] = 35;
            System.arraycopy(localObject1, 0, localObject3, 1, localObject1.length);
            this.NPR.NQx = util.dq((byte[])localObject3);
            i.NQH = (byte[])this.NPR.NQG.clone();
            this.NPR.NQI = util.lP(this.mContext);
            i = util.lR(this.mContext);
            this.NPR.NQJ = util.lQ(this.mContext);
            if (i != this.NPR.NQJ)
            {
              util.lS(this.mContext);
              util.aX(this.mContext, this.NPR.NQJ);
            }
            this.NPR.NQL = util.lT(this.mContext).getBytes();
            this.NPR.NQU = util.lU(this.mContext);
            this.NPR.NQK = util.lW(this.mContext);
            this.NPR.NQN = util.cK(this.mContext, new String(this.NPR.NQK));
            this.NPR.NQO = util.cL(this.mContext, new String(this.NPR.NQK));
            localObject1 = Build.MODEL;
            if (localObject1 != null) {
              break label492;
            }
            this.NPR.NQP = new byte[0];
            if ((util.isFileExist("/system/bin/su")) || (util.isFileExist("/system/xbin/su")) || (util.isFileExist("/sbin/su"))) {
              break label506;
            }
            i = 0;
            localObject1 = this.NPR;
            if (i == 0) {
              break label511;
            }
            i = 1;
            ((i)localObject1).NQQ = i;
            localObject3 = Build.VERSION.RELEASE;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            util.bdE("WtloginHelper init ok: android version:" + (String)localObject1 + " release time:" + util.gyg());
            return 0;
          }
          this.NPR.NQS = 1;
          continue;
        }
        this.NPR.NQS = 1;
      }
      finally
      {
        AppMethodBeat.o(88052);
      }
      this.NPR.NQR = 0;
      this.NPR.NQT = 0;
      continue;
      label492:
      this.NPR.NQP = localObject2.getBytes();
      continue;
      label506:
      int i = 1;
      continue;
      label511:
      i = 0;
    }
  }
  
  /* Error */
  public final byte[] FJ(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 309
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 45	oicq/wlogin_sdk/request/b:NPR	Loicq/wlogin_sdk/request/i;
    //   12: getfield 313	oicq/wlogin_sdk/request/i:NQB	Loicq/wlogin_sdk/a/g;
    //   15: astore_3
    //   16: aload_3
    //   17: getfield 318	oicq/wlogin_sdk/a/g:NRm	I
    //   20: newarray byte
    //   22: astore 4
    //   24: aload_3
    //   25: getfield 318	oicq/wlogin_sdk/a/g:NRm	I
    //   28: ifgt +46 -> 74
    //   31: aload_0
    //   32: monitorexit
    //   33: new 263	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 320
    //   40: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: lload_1
    //   44: invokevirtual 323	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   47: ldc_w 325
    //   50: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 4
    //   55: arraylength
    //   56: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 282	oicq/wlogin_sdk/tools/util:bdE	(Ljava/lang/String;)V
    //   65: ldc_w 309
    //   68: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: areturn
    //   74: aload_3
    //   75: getfield 331	oicq/wlogin_sdk/a/g:NQm	[B
    //   78: aload_3
    //   79: getfield 334	oicq/wlogin_sdk/a/g:NRo	I
    //   82: aload 4
    //   84: iconst_0
    //   85: aload_3
    //   86: getfield 318	oicq/wlogin_sdk/a/g:NRm	I
    //   89: invokestatic 116	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   92: goto -61 -> 31
    //   95: astore_3
    //   96: aload_0
    //   97: monitorexit
    //   98: ldc_w 309
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
  
  public final void FK(long paramLong)
  {
    AppMethodBeat.i(88051);
    util.bdE("user:" + paramLong + " ClearUserSigInfo");
    this.NPR.h(Long.valueOf(paramLong));
    AppMethodBeat.o(88051);
  }
  
  public final byte[] a(long paramLong, a parama, String paramString)
  {
    AppMethodBeat.i(88048);
    util.bdE("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 ...");
    String str = paramString;
    if (paramString.length() > 16) {
      str = paramString.substring(0, 16);
    }
    try
    {
      switch (gxQ()[parama.ordinal()])
      {
      case 1: 
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(88048);
    }
    if ((str == null) || (str.length() == 0))
    {
      util.bdE("USER_WITH_PWD userPasswd null");
      AppMethodBeat.o(88048);
      return null;
    }
    parama = oicq.wlogin_sdk.tools.c.bdC(str);
    for (int i = 0;; i = 1)
    {
      this.NPR.NQJ = util.lQ(this.mContext);
      this.NPR.NQL = util.lT(this.mContext).getBytes();
      this.NPR._uin = paramLong;
      this.NPR.NQC = 522017402L;
      this.NPR.NQD = 8256;
      this.NPR.NQA = new oicq.wlogin_sdk.a.f();
      this.NPX = this.NPS;
      if (i != 0) {}
      for (parama = this.NPS.a(paramLong, this.NPR.NQX, parama, this.NPZ, this.NPY, this.NPR.NQU);; parama = this.NPS.a(paramLong, this.NPR.NQX, paramString, parama, this.NPZ, this.NPY, this.NPR.NQU))
      {
        for (;;)
        {
          util.bdE("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 end");
          AppMethodBeat.o(88048);
          return parama;
          if ((str == null) || (str.length() == 0))
          {
            util.bdE("USER_WITH_MD5 userPasswd null");
            AppMethodBeat.o(88048);
            return null;
          }
          try
          {
            parama = (byte[])str.getBytes("ISO-8859-1").clone();
            i = 0;
          }
          catch (Exception parama)
          {
            AppMethodBeat.o(88048);
            return null;
          }
        }
        parama = this.NPR.FM(paramLong);
        if ((parama == null) || (parama._en_A1 == null) || (parama._en_A1.length <= 0)) {
          util.bdE("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: null");
        }
        for (parama = null; (parama == null) || (parama.length < 16); parama = (byte[])parama._en_A1.clone())
        {
          util.bdE("USER_WITH_A1 tmp_pwd null");
          AppMethodBeat.o(88048);
          return null;
          util.bdE("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: not null");
        }
        paramString = new byte[4];
        util.d(paramString, 0, i.gxT());
      }
      break;
    }
  }
  
  public final byte[] g(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88049);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(88049);
      return null;
    }
    util.bdE("user:" + paramLong + " CheckPicture ...");
    try
    {
      this.NPX = this.NPU;
      paramArrayOfByte = this.NPU.di(paramArrayOfByte);
      util.bdE("user:" + paramLong + " CheckPicture end");
      AppMethodBeat.o(88049);
      return paramArrayOfByte;
    }
    finally
    {
      AppMethodBeat.o(88049);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(88044);
      NQb = new a("USER_WITH_PWD", 0);
      NQc = new a("USER_WITH_MD5", 1);
      NQd = new a("USER_WITH_A1", 2);
      NQe = new a[] { NQb, NQc, NQd };
      AppMethodBeat.o(88044);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.b
 * JD-Core Version:    0.7.0.1
 */