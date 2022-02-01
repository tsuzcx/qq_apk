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
  public i UbW;
  private j UbX;
  private f UbY;
  private g UbZ;
  private h Uca;
  private e Ucb;
  public d Ucc;
  private int Ucd;
  private int Uce;
  private Context mContext;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88047);
    this.UbW = new i();
    this.UbX = new j(this.UbW);
    this.UbY = new f(this.UbW);
    this.UbZ = new g(this.UbW);
    this.Uca = new h(this.UbW);
    this.Ucb = new e(this.UbW);
    this.Ucc = null;
    this.mContext = null;
    this.Ucd = 66560;
    this.Uce = 1404;
    this.mContext = paramContext;
    i locali = this.UbW;
    locali._context = paramContext;
    locali.UcK = paramInt;
    locali.Ude = new c(paramContext);
    paramContext = new byte[16];
    locali.UcB.nextBytes(paramContext);
    System.arraycopy(paramContext, 0, locali.UcE, 0, 16);
    hPv();
    AppMethodBeat.o(88047);
  }
  
  private int hPv()
  {
    AppMethodBeat.i(88052);
    for (;;)
    {
      try
      {
        Object localObject1 = util.lZ(this.mContext);
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          localObject1 = util.lS(this.mContext);
          if ((localObject1 == null) || (localObject1.length <= 0))
          {
            localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
            this.UbW.UcX = 0;
            util.b(this.mContext, (byte[])localObject1);
            this.UbW.UcW = 1;
            this.UbW.UcY = 1;
            this.UbW.UcL = new byte[localObject1.length];
            System.arraycopy(localObject1, 0, this.UbW.UcL, 0, localObject1.length);
            Object localObject3 = new byte[localObject1.length + 1];
            localObject3[0] = 35;
            System.arraycopy(localObject1, 0, localObject3, 1, localObject1.length);
            this.UbW.UcC = util.dv((byte[])localObject3);
            i.UcM = (byte[])this.UbW.UcL.clone();
            this.UbW.UcN = util.lT(this.mContext);
            i = util.lV(this.mContext);
            this.UbW.UcO = util.lU(this.mContext);
            if (i != this.UbW.UcO)
            {
              util.lW(this.mContext);
              util.aY(this.mContext, this.UbW.UcO);
            }
            this.UbW.UcQ = util.lX(this.mContext).getBytes();
            this.UbW.UcZ = util.lY(this.mContext);
            this.UbW.UcP = util.ma(this.mContext);
            this.UbW.UcS = util.df(this.mContext, new String(this.UbW.UcP));
            this.UbW.UcT = util.dg(this.mContext, new String(this.UbW.UcP));
            localObject1 = Build.MODEL;
            if (localObject1 != null) {
              break label492;
            }
            this.UbW.UcU = new byte[0];
            if ((util.isFileExist("/system/bin/su")) || (util.isFileExist("/system/xbin/su")) || (util.isFileExist("/sbin/su"))) {
              break label506;
            }
            i = 0;
            localObject1 = this.UbW;
            if (i == 0) {
              break label511;
            }
            i = 1;
            ((i)localObject1).UcV = i;
            localObject3 = Build.VERSION.RELEASE;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            util.buY("WtloginHelper init ok: android version:" + (String)localObject1 + " release time:" + util.hPM());
            return 0;
          }
          this.UbW.UcX = 1;
          continue;
        }
        this.UbW.UcX = 1;
      }
      finally
      {
        AppMethodBeat.o(88052);
      }
      this.UbW.UcW = 0;
      this.UbW.UcY = 0;
      continue;
      label492:
      this.UbW.UcU = localObject2.getBytes();
      continue;
      label506:
      int i = 1;
      continue;
      label511:
      i = 0;
    }
  }
  
  /* Error */
  public final byte[] Pr(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 309
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 45	oicq/wlogin_sdk/request/b:UbW	Loicq/wlogin_sdk/request/i;
    //   12: getfield 313	oicq/wlogin_sdk/request/i:UcG	Loicq/wlogin_sdk/a/g;
    //   15: astore_3
    //   16: aload_3
    //   17: getfield 318	oicq/wlogin_sdk/a/g:Udr	I
    //   20: newarray byte
    //   22: astore 4
    //   24: aload_3
    //   25: getfield 318	oicq/wlogin_sdk/a/g:Udr	I
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
    //   62: invokestatic 282	oicq/wlogin_sdk/tools/util:buY	(Ljava/lang/String;)V
    //   65: ldc_w 309
    //   68: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: areturn
    //   74: aload_3
    //   75: getfield 331	oicq/wlogin_sdk/a/g:Ucr	[B
    //   78: aload_3
    //   79: getfield 334	oicq/wlogin_sdk/a/g:Udt	I
    //   82: aload 4
    //   84: iconst_0
    //   85: aload_3
    //   86: getfield 318	oicq/wlogin_sdk/a/g:Udr	I
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
  
  public final void Ps(long paramLong)
  {
    AppMethodBeat.i(88051);
    util.buY("user:" + paramLong + " ClearUserSigInfo");
    this.UbW.q(Long.valueOf(paramLong));
    AppMethodBeat.o(88051);
  }
  
  public final byte[] a(long paramLong, a parama, String paramString)
  {
    AppMethodBeat.i(88048);
    util.buY("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 ...");
    String str = paramString;
    if (paramString.length() > 16) {
      str = paramString.substring(0, 16);
    }
    try
    {
      switch (hPw()[parama.ordinal()])
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
      util.buY("USER_WITH_PWD userPasswd null");
      AppMethodBeat.o(88048);
      return null;
    }
    parama = oicq.wlogin_sdk.tools.c.buW(str);
    for (int i = 0;; i = 1)
    {
      this.UbW.UcO = util.lU(this.mContext);
      this.UbW.UcQ = util.lX(this.mContext).getBytes();
      this.UbW._uin = paramLong;
      this.UbW.UcH = 522017402L;
      this.UbW.UcI = 8256;
      this.UbW.UcF = new oicq.wlogin_sdk.a.f();
      this.Ucc = this.UbX;
      if (i != 0) {}
      for (parama = this.UbX.a(paramLong, this.UbW.Udc, parama, this.Uce, this.Ucd, this.UbW.UcZ);; parama = this.UbX.a(paramLong, this.UbW.Udc, paramString, parama, this.Uce, this.Ucd, this.UbW.UcZ))
      {
        for (;;)
        {
          util.buY("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 end");
          AppMethodBeat.o(88048);
          return parama;
          if ((str == null) || (str.length() == 0))
          {
            util.buY("USER_WITH_MD5 userPasswd null");
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
        parama = this.UbW.Pu(paramLong);
        if ((parama == null) || (parama._en_A1 == null) || (parama._en_A1.length <= 0)) {
          util.buY("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: null");
        }
        for (parama = null; (parama == null) || (parama.length < 16); parama = (byte[])parama._en_A1.clone())
        {
          util.buY("USER_WITH_A1 tmp_pwd null");
          AppMethodBeat.o(88048);
          return null;
          util.buY("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: not null");
        }
        paramString = new byte[4];
        util.d(paramString, 0, i.hPz());
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
    util.buY("user:" + paramLong + " CheckPicture ...");
    try
    {
      this.Ucc = this.UbZ;
      paramArrayOfByte = this.UbZ.dn(paramArrayOfByte);
      util.buY("user:" + paramLong + " CheckPicture end");
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
      Ucg = new a("USER_WITH_PWD", 0);
      Uch = new a("USER_WITH_MD5", 1);
      Uci = new a("USER_WITH_A1", 2);
      Ucj = new a[] { Ucg, Uch, Uci };
      AppMethodBeat.o(88044);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.b
 * JD-Core Version:    0.7.0.1
 */