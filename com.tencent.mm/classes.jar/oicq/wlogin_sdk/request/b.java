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
  public i KhJ;
  private j KhK;
  private f KhL;
  private g KhM;
  private h KhN;
  private e KhO;
  public d KhP;
  private int KhQ;
  private int KhR;
  private Context mContext;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88047);
    this.KhJ = new i();
    this.KhK = new j(this.KhJ);
    this.KhL = new f(this.KhJ);
    this.KhM = new g(this.KhJ);
    this.KhN = new h(this.KhJ);
    this.KhO = new e(this.KhJ);
    this.KhP = null;
    this.mContext = null;
    this.KhQ = 66560;
    this.KhR = 1404;
    this.mContext = paramContext;
    i locali = this.KhJ;
    locali._context = paramContext;
    locali.Kix = paramInt;
    locali.KiR = new c(paramContext);
    paramContext = new byte[16];
    locali.Kio.nextBytes(paramContext);
    System.arraycopy(paramContext, 0, locali.Kir, 0, 16);
    fMB();
    AppMethodBeat.o(88047);
  }
  
  private int fMB()
  {
    AppMethodBeat.i(88052);
    for (;;)
    {
      try
      {
        Object localObject1 = util.lu(this.mContext);
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          localObject1 = util.ln(this.mContext);
          if ((localObject1 == null) || (localObject1.length <= 0))
          {
            localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
            this.KhJ.KiK = 0;
            util.b(this.mContext, (byte[])localObject1);
            this.KhJ.KiJ = 1;
            this.KhJ.KiL = 1;
            this.KhJ.Kiy = new byte[localObject1.length];
            System.arraycopy(localObject1, 0, this.KhJ.Kiy, 0, localObject1.length);
            Object localObject3 = new byte[localObject1.length + 1];
            localObject3[0] = 35;
            System.arraycopy(localObject1, 0, localObject3, 1, localObject1.length);
            this.KhJ.Kip = util.dj((byte[])localObject3);
            i.Kiz = (byte[])this.KhJ.Kiy.clone();
            this.KhJ.KiA = util.lo(this.mContext);
            i = util.lq(this.mContext);
            this.KhJ.KiB = util.lp(this.mContext);
            if (i != this.KhJ.KiB)
            {
              util.lr(this.mContext);
              util.aO(this.mContext, this.KhJ.KiB);
            }
            this.KhJ.KiD = util.ls(this.mContext).getBytes();
            this.KhJ.KiM = util.lt(this.mContext);
            this.KhJ.KiC = util.lv(this.mContext);
            this.KhJ.KiF = util.cC(this.mContext, new String(this.KhJ.KiC));
            this.KhJ.KiG = util.cD(this.mContext, new String(this.KhJ.KiC));
            localObject1 = Build.MODEL;
            if (localObject1 != null) {
              break label492;
            }
            this.KhJ.KiH = new byte[0];
            if ((util.isFileExist("/system/bin/su")) || (util.isFileExist("/system/xbin/su")) || (util.isFileExist("/sbin/su"))) {
              break label506;
            }
            i = 0;
            localObject1 = this.KhJ;
            if (i == 0) {
              break label511;
            }
            i = 1;
            ((i)localObject1).KiI = i;
            localObject3 = Build.VERSION.RELEASE;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            util.aRk("WtloginHelper init ok: android version:" + (String)localObject1 + " release time:" + util.fMS());
            return 0;
          }
          this.KhJ.KiK = 1;
          continue;
        }
        this.KhJ.KiK = 1;
      }
      finally
      {
        AppMethodBeat.o(88052);
      }
      this.KhJ.KiJ = 0;
      this.KhJ.KiL = 0;
      continue;
      label492:
      this.KhJ.KiH = localObject2.getBytes();
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
    AppMethodBeat.i(88048);
    util.aRk("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 ...");
    String str = paramString;
    if (paramString.length() > 16) {
      str = paramString.substring(0, 16);
    }
    try
    {
      switch (fMC()[parama.ordinal()])
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
      util.aRk("USER_WITH_PWD userPasswd null");
      AppMethodBeat.o(88048);
      return null;
    }
    parama = oicq.wlogin_sdk.tools.c.aRi(str);
    for (int i = 0;; i = 1)
    {
      this.KhJ.KiB = util.lp(this.mContext);
      this.KhJ.KiD = util.ls(this.mContext).getBytes();
      this.KhJ._uin = paramLong;
      this.KhJ.Kiu = 522017402L;
      this.KhJ.Kiv = 8256;
      this.KhJ.Kis = new oicq.wlogin_sdk.a.f();
      this.KhP = this.KhK;
      if (i != 0) {}
      for (parama = this.KhK.a(paramLong, this.KhJ.KiP, parama, this.KhR, this.KhQ, this.KhJ.KiM);; parama = this.KhK.a(paramLong, this.KhJ.KiP, paramString, parama, this.KhR, this.KhQ, this.KhJ.KiM))
      {
        for (;;)
        {
          util.aRk("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 end");
          AppMethodBeat.o(88048);
          return parama;
          if ((str == null) || (str.length() == 0))
          {
            util.aRk("USER_WITH_MD5 userPasswd null");
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
        parama = this.KhJ.xT(paramLong);
        if ((parama == null) || (parama._en_A1 == null) || (parama._en_A1.length <= 0)) {
          util.aRk("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: null");
        }
        for (parama = null; (parama == null) || (parama.length < 16); parama = (byte[])parama._en_A1.clone())
        {
          util.aRk("USER_WITH_A1 tmp_pwd null");
          AppMethodBeat.o(88048);
          return null;
          util.aRk("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: not null");
        }
        paramString = new byte[4];
        util.d(paramString, 0, i.fMF());
      }
      break;
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
    util.aRk("user:" + paramLong + " CheckPicture ...");
    try
    {
      this.KhP = this.KhM;
      paramArrayOfByte = this.KhM.db(paramArrayOfByte);
      util.aRk("user:" + paramLong + " CheckPicture end");
      AppMethodBeat.o(88049);
      return paramArrayOfByte;
    }
    finally
    {
      AppMethodBeat.o(88049);
    }
  }
  
  /* Error */
  public final byte[] xQ(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 410
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 45	oicq/wlogin_sdk/request/b:KhJ	Loicq/wlogin_sdk/request/i;
    //   12: getfield 414	oicq/wlogin_sdk/request/i:Kit	Loicq/wlogin_sdk/a/g;
    //   15: astore_3
    //   16: aload_3
    //   17: getfield 419	oicq/wlogin_sdk/a/g:Kje	I
    //   20: newarray byte
    //   22: astore 4
    //   24: aload_3
    //   25: getfield 419	oicq/wlogin_sdk/a/g:Kje	I
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
    //   62: invokestatic 282	oicq/wlogin_sdk/tools/util:aRk	(Ljava/lang/String;)V
    //   65: ldc_w 410
    //   68: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: areturn
    //   74: aload_3
    //   75: getfield 427	oicq/wlogin_sdk/a/g:Kie	[B
    //   78: aload_3
    //   79: getfield 430	oicq/wlogin_sdk/a/g:Kjg	I
    //   82: aload 4
    //   84: iconst_0
    //   85: aload_3
    //   86: getfield 419	oicq/wlogin_sdk/a/g:Kje	I
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
  
  public final void xR(long paramLong)
  {
    AppMethodBeat.i(88051);
    util.aRk("user:" + paramLong + " ClearUserSigInfo");
    this.KhJ.g(Long.valueOf(paramLong));
    AppMethodBeat.o(88051);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(88044);
      KhT = new a("USER_WITH_PWD", 0);
      KhU = new a("USER_WITH_MD5", 1);
      KhV = new a("USER_WITH_A1", 2);
      KhW = new a[] { KhT, KhU, KhV };
      AppMethodBeat.o(88044);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.b
 * JD-Core Version:    0.7.0.1
 */