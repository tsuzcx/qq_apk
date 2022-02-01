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
  public i OmX;
  private j OmY;
  private f OmZ;
  private g Ona;
  private h Onb;
  private e Onc;
  public d Ond;
  private int One;
  private int Onf;
  private Context mContext;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88047);
    this.OmX = new i();
    this.OmY = new j(this.OmX);
    this.OmZ = new f(this.OmX);
    this.Ona = new g(this.OmX);
    this.Onb = new h(this.OmX);
    this.Onc = new e(this.OmX);
    this.Ond = null;
    this.mContext = null;
    this.One = 66560;
    this.Onf = 1404;
    this.mContext = paramContext;
    i locali = this.OmX;
    locali._context = paramContext;
    locali.OnL = paramInt;
    locali.Oof = new c(paramContext);
    paramContext = new byte[16];
    locali.OnC.nextBytes(paramContext);
    System.arraycopy(paramContext, 0, locali.OnF, 0, 16);
    gCr();
    AppMethodBeat.o(88047);
  }
  
  private int gCr()
  {
    AppMethodBeat.i(88052);
    for (;;)
    {
      try
      {
        Object localObject1 = util.mb(this.mContext);
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          localObject1 = util.lU(this.mContext);
          if ((localObject1 == null) || (localObject1.length <= 0))
          {
            localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
            this.OmX.OnY = 0;
            util.b(this.mContext, (byte[])localObject1);
            this.OmX.OnX = 1;
            this.OmX.OnZ = 1;
            this.OmX.OnM = new byte[localObject1.length];
            System.arraycopy(localObject1, 0, this.OmX.OnM, 0, localObject1.length);
            Object localObject3 = new byte[localObject1.length + 1];
            localObject3[0] = 35;
            System.arraycopy(localObject1, 0, localObject3, 1, localObject1.length);
            this.OmX.OnD = util.dt((byte[])localObject3);
            i.OnN = (byte[])this.OmX.OnM.clone();
            this.OmX.OnO = util.lV(this.mContext);
            i = util.lX(this.mContext);
            this.OmX.OnP = util.lW(this.mContext);
            if (i != this.OmX.OnP)
            {
              util.lY(this.mContext);
              util.aX(this.mContext, this.OmX.OnP);
            }
            this.OmX.OnR = util.lZ(this.mContext).getBytes();
            this.OmX.Ooa = util.ma(this.mContext);
            this.OmX.OnQ = util.mc(this.mContext);
            this.OmX.OnT = util.cL(this.mContext, new String(this.OmX.OnQ));
            this.OmX.OnU = util.cM(this.mContext, new String(this.OmX.OnQ));
            localObject1 = Build.MODEL;
            if (localObject1 != null) {
              break label492;
            }
            this.OmX.OnV = new byte[0];
            if ((util.isFileExist("/system/bin/su")) || (util.isFileExist("/system/xbin/su")) || (util.isFileExist("/sbin/su"))) {
              break label506;
            }
            i = 0;
            localObject1 = this.OmX;
            if (i == 0) {
              break label511;
            }
            i = 1;
            ((i)localObject1).OnW = i;
            localObject3 = Build.VERSION.RELEASE;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            util.bfi("WtloginHelper init ok: android version:" + (String)localObject1 + " release time:" + util.gCI());
            return 0;
          }
          this.OmX.OnY = 1;
          continue;
        }
        this.OmX.OnY = 1;
      }
      finally
      {
        AppMethodBeat.o(88052);
      }
      this.OmX.OnX = 0;
      this.OmX.OnZ = 0;
      continue;
      label492:
      this.OmX.OnV = localObject2.getBytes();
      continue;
      label506:
      int i = 1;
      continue;
      label511:
      i = 0;
    }
  }
  
  /* Error */
  public final byte[] Gl(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 309
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 45	oicq/wlogin_sdk/request/b:OmX	Loicq/wlogin_sdk/request/i;
    //   12: getfield 313	oicq/wlogin_sdk/request/i:OnH	Loicq/wlogin_sdk/a/g;
    //   15: astore_3
    //   16: aload_3
    //   17: getfield 318	oicq/wlogin_sdk/a/g:Oos	I
    //   20: newarray byte
    //   22: astore 4
    //   24: aload_3
    //   25: getfield 318	oicq/wlogin_sdk/a/g:Oos	I
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
    //   62: invokestatic 282	oicq/wlogin_sdk/tools/util:bfi	(Ljava/lang/String;)V
    //   65: ldc_w 309
    //   68: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: areturn
    //   74: aload_3
    //   75: getfield 331	oicq/wlogin_sdk/a/g:Ons	[B
    //   78: aload_3
    //   79: getfield 334	oicq/wlogin_sdk/a/g:Oou	I
    //   82: aload 4
    //   84: iconst_0
    //   85: aload_3
    //   86: getfield 318	oicq/wlogin_sdk/a/g:Oos	I
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
  
  public final void Gm(long paramLong)
  {
    AppMethodBeat.i(88051);
    util.bfi("user:" + paramLong + " ClearUserSigInfo");
    this.OmX.j(Long.valueOf(paramLong));
    AppMethodBeat.o(88051);
  }
  
  public final byte[] a(long paramLong, a parama, String paramString)
  {
    AppMethodBeat.i(88048);
    util.bfi("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 ...");
    String str = paramString;
    if (paramString.length() > 16) {
      str = paramString.substring(0, 16);
    }
    try
    {
      switch (gCs()[parama.ordinal()])
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
      util.bfi("USER_WITH_PWD userPasswd null");
      AppMethodBeat.o(88048);
      return null;
    }
    parama = oicq.wlogin_sdk.tools.c.bfg(str);
    for (int i = 0;; i = 1)
    {
      this.OmX.OnP = util.lW(this.mContext);
      this.OmX.OnR = util.lZ(this.mContext).getBytes();
      this.OmX._uin = paramLong;
      this.OmX.OnI = 522017402L;
      this.OmX.OnJ = 8256;
      this.OmX.OnG = new oicq.wlogin_sdk.a.f();
      this.Ond = this.OmY;
      if (i != 0) {}
      for (parama = this.OmY.a(paramLong, this.OmX.Ood, parama, this.Onf, this.One, this.OmX.Ooa);; parama = this.OmY.a(paramLong, this.OmX.Ood, paramString, parama, this.Onf, this.One, this.OmX.Ooa))
      {
        for (;;)
        {
          util.bfi("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256 end");
          AppMethodBeat.o(88048);
          return parama;
          if ((str == null) || (str.length() == 0))
          {
            util.bfi("USER_WITH_MD5 userPasswd null");
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
        parama = this.OmX.Go(paramLong);
        if ((parama == null) || (parama._en_A1 == null) || (parama._en_A1.length <= 0)) {
          util.bfi("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: null");
        }
        for (parama = null; (parama == null) || (parama.length < 16); parama = (byte[])parama._en_A1.clone())
        {
          util.bfi("USER_WITH_A1 tmp_pwd null");
          AppMethodBeat.o(88048);
          return null;
          util.bfi("userAccount:" + paramLong + " appid:522017402 GetA1ByAccount return: not null");
        }
        paramString = new byte[4];
        util.d(paramString, 0, i.gCv());
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
    util.bfi("user:" + paramLong + " CheckPicture ...");
    try
    {
      this.Ond = this.Ona;
      paramArrayOfByte = this.Ona.dl(paramArrayOfByte);
      util.bfi("user:" + paramLong + " CheckPicture end");
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
      Onh = new a("USER_WITH_PWD", 0);
      Oni = new a("USER_WITH_MD5", 1);
      Onj = new a("USER_WITH_A1", 2);
      Onk = new a[] { Onh, Oni, Onj };
      AppMethodBeat.o(88044);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.b
 * JD-Core Version:    0.7.0.1
 */