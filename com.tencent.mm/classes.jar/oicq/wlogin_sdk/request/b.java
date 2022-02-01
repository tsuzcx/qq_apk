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
  public i ajGp;
  private j ajGq;
  private f ajGr;
  private g ajGs;
  private h ajGt;
  private e ajGu;
  public d ajGv;
  private int ajGw;
  private int ajGx;
  private Context mContext;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88047);
    this.ajGp = new i();
    this.ajGq = new j(this.ajGp);
    this.ajGr = new f(this.ajGp);
    this.ajGs = new g(this.ajGp);
    this.ajGt = new h(this.ajGp);
    this.ajGu = new e(this.ajGp);
    this.ajGv = null;
    this.mContext = null;
    this.ajGw = 66560;
    this.ajGx = 1404;
    this.mContext = paramContext;
    i locali = this.ajGp;
    locali._context = paramContext;
    locali.ajHd = paramInt;
    locali.ajHx = new c(paramContext);
    paramContext = new byte[16];
    locali.ajGU.nextBytes(paramContext);
    System.arraycopy(paramContext, 0, locali.ajGX, 0, 16);
    kGe();
    AppMethodBeat.o(88047);
  }
  
  private int kGe()
  {
    AppMethodBeat.i(88052);
    for (;;)
    {
      try
      {
        Object localObject1 = util.pw(this.mContext);
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          localObject1 = util.pp(this.mContext);
          if ((localObject1 == null) || (localObject1.length <= 0))
          {
            localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
            this.ajGp.ajHq = 0;
            util.b(this.mContext, (byte[])localObject1);
            this.ajGp.ajHp = 1;
            this.ajGp.ajHr = 1;
            this.ajGp.ajHe = new byte[localObject1.length];
            System.arraycopy(localObject1, 0, this.ajGp.ajHe, 0, localObject1.length);
            Object localObject3 = new byte[localObject1.length + 1];
            localObject3[0] = 35;
            System.arraycopy(localObject1, 0, localObject3, 1, localObject1.length);
            this.ajGp.ajGV = util.dX((byte[])localObject3);
            i.ajHf = (byte[])this.ajGp.ajHe.clone();
            this.ajGp.ajHg = util.pq(this.mContext);
            i = util.ps(this.mContext);
            this.ajGp.ajHh = util.pr(this.mContext);
            if (i != this.ajGp.ajHh)
            {
              util.pt(this.mContext);
              util.bL(this.mContext, this.ajGp.ajHh);
            }
            this.ajGp.ajHj = util.pu(this.mContext).getBytes();
            this.ajGp.ajHs = util.pv(this.mContext);
            this.ajGp.ajHi = util.px(this.mContext);
            this.ajGp.ajHl = util.dy(this.mContext, new String(this.ajGp.ajHi));
            this.ajGp.ajHm = util.dz(this.mContext, new String(this.ajGp.ajHi));
            localObject1 = Build.MODEL;
            if (localObject1 != null) {
              break label492;
            }
            this.ajGp.ajHn = new byte[0];
            if ((util.isFileExist("/system/bin/su")) || (util.isFileExist("/system/xbin/su")) || (util.isFileExist("/sbin/su"))) {
              break label506;
            }
            i = 0;
            localObject1 = this.ajGp;
            if (i == 0) {
              break label511;
            }
            i = 1;
            ((i)localObject1).ajHo = i;
            localObject3 = Build.VERSION.RELEASE;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            util.bKf("WtloginHelper init ok: android version:" + (String)localObject1 + " release time:" + util.kGv());
            return 0;
          }
          this.ajGp.ajHq = 1;
          continue;
        }
        this.ajGp.ajHq = 1;
      }
      finally
      {
        AppMethodBeat.o(88052);
      }
      this.ajGp.ajHp = 0;
      this.ajGp.ajHr = 0;
      continue;
      label492:
      this.ajGp.ajHn = localObject2.getBytes();
      continue;
      label506:
      int i = 1;
      continue;
      label511:
      i = 0;
    }
  }
  
  /* Error */
  public final byte[] BT(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 309
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 45	oicq/wlogin_sdk/request/b:ajGp	Loicq/wlogin_sdk/request/i;
    //   12: getfield 313	oicq/wlogin_sdk/request/i:ajGZ	Loicq/wlogin_sdk/a/g;
    //   15: astore_3
    //   16: aload_3
    //   17: getfield 318	oicq/wlogin_sdk/a/g:ajHK	I
    //   20: newarray byte
    //   22: astore 4
    //   24: aload_3
    //   25: getfield 318	oicq/wlogin_sdk/a/g:ajHK	I
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
    //   62: invokestatic 282	oicq/wlogin_sdk/tools/util:bKf	(Ljava/lang/String;)V
    //   65: ldc_w 309
    //   68: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: areturn
    //   74: aload_3
    //   75: getfield 331	oicq/wlogin_sdk/a/g:ajGK	[B
    //   78: aload_3
    //   79: getfield 334	oicq/wlogin_sdk/a/g:ajHM	I
    //   82: aload 4
    //   84: iconst_0
    //   85: aload_3
    //   86: getfield 318	oicq/wlogin_sdk/a/g:ajHK	I
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
  
  public final void BU(long paramLong)
  {
    AppMethodBeat.i(88051);
    util.bKf("user:" + paramLong + " ClearUserSigInfo");
    this.ajGp.x(Long.valueOf(paramLong));
    AppMethodBeat.o(88051);
  }
  
  public final byte[] a(long paramLong, a parama, String paramString)
  {
    AppMethodBeat.i(88048);
    util.bKf("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 ...");
    String str = paramString;
    if (paramString.length() > 16) {
      str = paramString.substring(0, 16);
    }
    for (;;)
    {
      try
      {
        int i = kGf()[parama.ordinal()];
        switch (i)
        {
        default: 
          return null;
        case 1: 
          if ((str == null) || (str.length() == 0))
          {
            util.bKf("USER_WITH_PWD userPasswd null");
            return null;
          }
          parama = oicq.wlogin_sdk.tools.c.bKd(str);
          i = 0;
          this.ajGp.ajHh = util.pr(this.mContext);
          this.ajGp.ajHj = util.pu(this.mContext).getBytes();
          this.ajGp._uin = paramLong;
          this.ajGp.ajHa = 522017402L;
          this.ajGp.ajHb = 8256;
          this.ajGp.ajGY = new oicq.wlogin_sdk.a.f();
          this.ajGv = this.ajGq;
          if (i == 0) {
            continue;
          }
          parama = this.ajGq.a(paramLong, this.ajGp.ajHv, parama, this.ajGx, this.ajGw, this.ajGp.ajHs);
          util.bKf("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 end");
          AppMethodBeat.o(88048);
          return parama;
        case 2: 
          if ((str == null) || (str.length() == 0))
          {
            util.bKf("USER_WITH_MD5 userPasswd null");
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
        parama = this.ajGp.BW(paramLong);
        if ((parama == null) || (parama._en_A1 == null) || (parama._en_A1.length <= 0))
        {
          util.bKf("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: null");
          parama = null;
          if ((parama == null) || (parama.length < 16))
          {
            util.bKf("USER_WITH_A1 tmp_pwd null");
            return null;
          }
        }
        else
        {
          util.bKf("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: not null");
          parama = (byte[])parama._en_A1.clone();
          continue;
          paramString = new byte[4];
          util.d(paramString, 0, i.kGi());
          parama = this.ajGq.a(paramLong, this.ajGp.ajHv, paramString, parama, this.ajGx, this.ajGw, this.ajGp.ajHs);
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
  
  public final byte[] g(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88049);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(88049);
      return null;
    }
    util.bKf("user:" + paramLong + " CheckPicture ...");
    try
    {
      this.ajGv = this.ajGs;
      paramArrayOfByte = this.ajGs.dP(paramArrayOfByte);
      util.bKf("user:" + paramLong + " CheckPicture end");
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
      ajGz = new a("USER_WITH_PWD", 0);
      ajGA = new a("USER_WITH_MD5", 1);
      ajGB = new a("USER_WITH_A1", 2);
      ajGC = new a[] { ajGz, ajGA, ajGB };
      AppMethodBeat.o(88044);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.request.b
 * JD-Core Version:    0.7.0.1
 */