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
  public i abFl;
  private j abFm;
  private f abFn;
  private g abFo;
  private h abFp;
  private e abFq;
  public d abFr;
  private int abFs;
  private int abFt;
  private Context mContext;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88047);
    this.abFl = new i();
    this.abFm = new j(this.abFl);
    this.abFn = new f(this.abFl);
    this.abFo = new g(this.abFl);
    this.abFp = new h(this.abFl);
    this.abFq = new e(this.abFl);
    this.abFr = null;
    this.mContext = null;
    this.abFs = 66560;
    this.abFt = 1404;
    this.mContext = paramContext;
    i locali = this.abFl;
    locali._context = paramContext;
    locali.abFZ = paramInt;
    locali.abGt = new c(paramContext);
    paramContext = new byte[16];
    locali.abFQ.nextBytes(paramContext);
    System.arraycopy(paramContext, 0, locali.abFT, 0, 16);
    iUD();
    AppMethodBeat.o(88047);
  }
  
  private int iUD()
  {
    AppMethodBeat.i(88052);
    for (;;)
    {
      try
      {
        Object localObject1 = util.mW(this.mContext);
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          localObject1 = util.mP(this.mContext);
          if ((localObject1 == null) || (localObject1.length <= 0))
          {
            localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
            this.abFl.abGm = 0;
            util.b(this.mContext, (byte[])localObject1);
            this.abFl.abGl = 1;
            this.abFl.abGn = 1;
            this.abFl.abGa = new byte[localObject1.length];
            System.arraycopy(localObject1, 0, this.abFl.abGa, 0, localObject1.length);
            Object localObject3 = new byte[localObject1.length + 1];
            localObject3[0] = 35;
            System.arraycopy(localObject1, 0, localObject3, 1, localObject1.length);
            this.abFl.abFR = util.dU((byte[])localObject3);
            i.abGb = (byte[])this.abFl.abGa.clone();
            this.abFl.abGc = util.mQ(this.mContext);
            i = util.mS(this.mContext);
            this.abFl.abGd = util.mR(this.mContext);
            if (i != this.abFl.abGd)
            {
              util.mT(this.mContext);
              util.br(this.mContext, this.abFl.abGd);
            }
            this.abFl.abGf = util.mU(this.mContext).getBytes();
            this.abFl.abGo = util.mV(this.mContext);
            this.abFl.abGe = util.mX(this.mContext);
            this.abFl.abGh = util.dp(this.mContext, new String(this.abFl.abGe));
            this.abFl.abGi = util.dq(this.mContext, new String(this.abFl.abGe));
            localObject1 = Build.MODEL;
            if (localObject1 != null) {
              break label492;
            }
            this.abFl.abGj = new byte[0];
            if ((util.isFileExist("/system/bin/su")) || (util.isFileExist("/system/xbin/su")) || (util.isFileExist("/sbin/su"))) {
              break label506;
            }
            i = 0;
            localObject1 = this.abFl;
            if (i == 0) {
              break label511;
            }
            i = 1;
            ((i)localObject1).abGk = i;
            localObject3 = Build.VERSION.RELEASE;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            util.bIb("WtloginHelper init ok: android version:" + (String)localObject1 + " release time:" + util.iUU());
            return 0;
          }
          this.abFl.abGm = 1;
          continue;
        }
        this.abFl.abGm = 1;
      }
      finally
      {
        AppMethodBeat.o(88052);
      }
      this.abFl.abGl = 0;
      this.abFl.abGn = 0;
      continue;
      label492:
      this.abFl.abGj = localObject2.getBytes();
      continue;
      label506:
      int i = 1;
      continue;
      label511:
      i = 0;
    }
  }
  
  /* Error */
  public final byte[] XH(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 309
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 45	oicq/wlogin_sdk/request/b:abFl	Loicq/wlogin_sdk/request/i;
    //   12: getfield 313	oicq/wlogin_sdk/request/i:abFV	Loicq/wlogin_sdk/a/g;
    //   15: astore_3
    //   16: aload_3
    //   17: getfield 318	oicq/wlogin_sdk/a/g:abGG	I
    //   20: newarray byte
    //   22: astore 4
    //   24: aload_3
    //   25: getfield 318	oicq/wlogin_sdk/a/g:abGG	I
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
    //   62: invokestatic 282	oicq/wlogin_sdk/tools/util:bIb	(Ljava/lang/String;)V
    //   65: ldc_w 309
    //   68: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: areturn
    //   74: aload_3
    //   75: getfield 331	oicq/wlogin_sdk/a/g:abFG	[B
    //   78: aload_3
    //   79: getfield 334	oicq/wlogin_sdk/a/g:abGI	I
    //   82: aload 4
    //   84: iconst_0
    //   85: aload_3
    //   86: getfield 318	oicq/wlogin_sdk/a/g:abGG	I
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
  }
  
  public final void XI(long paramLong)
  {
    AppMethodBeat.i(88051);
    util.bIb("user:" + paramLong + " ClearUserSigInfo");
    this.abFl.p(Long.valueOf(paramLong));
    AppMethodBeat.o(88051);
  }
  
  public final byte[] a(long paramLong, a parama, String paramString)
  {
    AppMethodBeat.i(88048);
    util.bIb("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 ...");
    String str = paramString;
    if (paramString.length() > 16) {
      str = paramString.substring(0, 16);
    }
    for (;;)
    {
      try
      {
        int i = iUE()[parama.ordinal()];
        switch (i)
        {
        default: 
          return null;
        case 1: 
          if ((str == null) || (str.length() == 0))
          {
            util.bIb("USER_WITH_PWD userPasswd null");
            return null;
          }
          parama = oicq.wlogin_sdk.tools.c.bHZ(str);
          i = 0;
          this.abFl.abGd = util.mR(this.mContext);
          this.abFl.abGf = util.mU(this.mContext).getBytes();
          this.abFl._uin = paramLong;
          this.abFl.abFW = 522017402L;
          this.abFl.abFX = 8256;
          this.abFl.abFU = new oicq.wlogin_sdk.a.f();
          this.abFr = this.abFm;
          if (i == 0) {
            continue;
          }
          parama = this.abFm.a(paramLong, this.abFl.abGr, parama, this.abFt, this.abFs, this.abFl.abGo);
          util.bIb("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 end");
          AppMethodBeat.o(88048);
          return parama;
        case 2: 
          if ((str == null) || (str.length() == 0))
          {
            util.bIb("USER_WITH_MD5 userPasswd null");
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
        parama = this.abFl.XK(paramLong);
        if ((parama == null) || (parama._en_A1 == null) || (parama._en_A1.length <= 0))
        {
          util.bIb("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: null");
          parama = null;
          if ((parama == null) || (parama.length < 16))
          {
            util.bIb("USER_WITH_A1 tmp_pwd null");
            return null;
          }
        }
        else
        {
          util.bIb("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: not null");
          parama = (byte[])parama._en_A1.clone();
          continue;
          paramString = new byte[4];
          util.d(paramString, 0, i.iUH());
          parama = this.abFm.a(paramLong, this.abFl.abGr, paramString, parama, this.abFt, this.abFs, this.abFl.abGo);
          continue;
        }
        i = 1;
      }
      finally
      {
        AppMethodBeat.o(88048);
      }
    }
  }
  
  public final byte[] f(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88049);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(88049);
      return null;
    }
    util.bIb("user:" + paramLong + " CheckPicture ...");
    try
    {
      this.abFr = this.abFo;
      paramArrayOfByte = this.abFo.dM(paramArrayOfByte);
      util.bIb("user:" + paramLong + " CheckPicture end");
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
      abFv = new a("USER_WITH_PWD", 0);
      abFw = new a("USER_WITH_MD5", 1);
      abFx = new a("USER_WITH_A1", 2);
      abFy = new a[] { abFv, abFw, abFx };
      AppMethodBeat.o(88044);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.request.b
 * JD-Core Version:    0.7.0.1
 */