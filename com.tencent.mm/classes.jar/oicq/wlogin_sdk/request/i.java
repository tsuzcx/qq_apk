package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public final class i
{
  public static byte[] NQH = new byte[0];
  public f NQA;
  public g NQB;
  public long NQC;
  public int NQD;
  public long NQE;
  public int NQF;
  byte[] NQG;
  byte[] NQI;
  int NQJ;
  byte[] NQK;
  byte[] NQL;
  byte[] NQM;
  byte[] NQN;
  byte[] NQO;
  byte[] NQP;
  int NQQ;
  int NQR;
  int NQS;
  int NQT;
  byte[] NQU;
  ErrMsg NQV;
  byte[] NQW;
  byte[] NQX;
  byte[] NQY;
  c NQZ;
  public SecureRandom NQw;
  public byte[] NQx;
  public byte[] NQy;
  public byte[] NQz;
  public Context _context;
  public long _uin;
  
  public i()
  {
    AppMethodBeat.i(88082);
    this.NQw = new SecureRandom();
    this.NQx = util.gyd();
    this.NQy = null;
    this.NQz = new byte[16];
    this.NQA = new f();
    this.NQB = new g();
    this._uin = 0L;
    this.NQC = 0L;
    this.NQD = 0;
    this.NQE = -1L;
    this.NQF = 0;
    this._context = null;
    this.NQG = new byte[0];
    this.NQI = new byte[0];
    this.NQJ = 0;
    this.NQK = new byte[0];
    this.NQL = new byte[0];
    this.NQM = new byte[0];
    this.NQN = new byte[0];
    this.NQO = new byte[0];
    this.NQP = new byte[0];
    this.NQQ = 0;
    this.NQR = 0;
    this.NQS = 0;
    this.NQT = 0;
    this.NQU = new byte[0];
    this.NQV = new ErrMsg();
    this.NQW = new byte[0];
    this.NQX = new byte[4];
    this.NQY = new byte[0];
    this.NQZ = null;
    AppMethodBeat.o(88082);
  }
  
  public static long gxT()
  {
    AppMethodBeat.i(88083);
    long l = System.currentTimeMillis() / 1000L;
    AppMethodBeat.o(88083);
    return l;
  }
  
  /* Error */
  public final oicq.wlogin_sdk.sharemem.WloginSigInfo FM(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 158
    //   4: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 160
    //   9: new 162	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 164
    //   15: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: lload_1
    //   19: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   22: ldc 173
    //   24: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 184	oicq/wlogin_sdk/tools/util:nH	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 142	oicq/wlogin_sdk/request/i:NQZ	Loicq/wlogin_sdk/request/c;
    //   37: lload_1
    //   38: invokevirtual 188	oicq/wlogin_sdk/request/c:FM	(J)Loicq/wlogin_sdk/sharemem/WloginSigInfo;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +12 -> 55
    //   46: ldc 158
    //   48: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: areturn
    //   55: ldc 158
    //   57: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -9 -> 51
    //   63: astore_3
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_3
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	i
    //   0	68	1	paramLong	long
    //   41	13	3	localWloginSigInfo	oicq.wlogin_sdk.sharemem.WloginSigInfo
    //   63	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	63	finally
    //   46	51	63	finally
    //   55	60	63	finally
  }
  
  /* Error */
  public final int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[] paramArrayOfByte14, byte[] paramArrayOfByte15, byte[] paramArrayOfByte16, byte[][] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 191
    //   4: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 162	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 193
    //   13: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: lload_1
    //   17: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: ldc 195
    //   22: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: lload_3
    //   26: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: ldc 195
    //   31: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: lload 5
    //   36: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: ldc 195
    //   41: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: lload 7
    //   46: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: ldc 195
    //   51: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: lload 9
    //   56: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   59: ldc 195
    //   61: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: lload 11
    //   66: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: ldc 195
    //   71: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 13
    //   76: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   79: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc 195
    //   84: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 14
    //   89: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   92: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: ldc 195
    //   97: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 15
    //   102: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   105: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   108: ldc 195
    //   110: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 16
    //   115: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   118: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   121: ldc 195
    //   123: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 17
    //   128: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   131: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: ldc 195
    //   136: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 18
    //   141: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   144: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   147: ldc 195
    //   149: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 19
    //   154: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   157: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: ldc 195
    //   162: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 20
    //   167: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   170: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   173: ldc 195
    //   175: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 21
    //   180: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   183: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   186: ldc 195
    //   188: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload 22
    //   193: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   196: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   199: ldc 195
    //   201: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 23
    //   206: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   209: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: ldc 195
    //   214: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 24
    //   219: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   222: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: ldc 195
    //   227: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload 25
    //   232: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   235: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   238: ldc 195
    //   240: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 26
    //   245: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   248: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   251: ldc 195
    //   253: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 27
    //   258: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   261: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   264: ldc 195
    //   266: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 28
    //   271: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   274: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   277: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 202	oicq/wlogin_sdk/tools/util:bdE	(Ljava/lang/String;)V
    //   283: ldc 204
    //   285: astore 31
    //   287: iconst_0
    //   288: istore 30
    //   290: iload 30
    //   292: aload 29
    //   294: arraylength
    //   295: if_icmplt +79 -> 374
    //   298: ldc 206
    //   300: aload 31
    //   302: invokestatic 212	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   305: invokevirtual 216	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   308: invokestatic 202	oicq/wlogin_sdk/tools/util:bdE	(Ljava/lang/String;)V
    //   311: aload_0
    //   312: getfield 142	oicq/wlogin_sdk/request/i:NQZ	Loicq/wlogin_sdk/request/c;
    //   315: lload_1
    //   316: lload_3
    //   317: lload 5
    //   319: lload 7
    //   321: lload 9
    //   323: lload 11
    //   325: aload 13
    //   327: aload 14
    //   329: aload 15
    //   331: aload 16
    //   333: aload 17
    //   335: aload 18
    //   337: aload 19
    //   339: aload 20
    //   341: aload 21
    //   343: aload 22
    //   345: aload 23
    //   347: aload 24
    //   349: aload 25
    //   351: aload 26
    //   353: aload 27
    //   355: aload 28
    //   357: aload 29
    //   359: invokevirtual 218	oicq/wlogin_sdk/request/c:a	(JJJJJJ[B[B[B[B[B[B[B[B[B[B[B[B[B[B[B[B[[B)I
    //   362: istore 30
    //   364: ldc 191
    //   366: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   369: aload_0
    //   370: monitorexit
    //   371: iload 30
    //   373: ireturn
    //   374: new 162	java/lang/StringBuilder
    //   377: dup
    //   378: aload 31
    //   380: invokestatic 212	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   383: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   386: ldc 220
    //   388: iconst_2
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: iload 30
    //   396: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   399: aastore
    //   400: dup
    //   401: iconst_1
    //   402: aload 29
    //   404: iload 30
    //   406: aaload
    //   407: invokestatic 199	oicq/wlogin_sdk/tools/util:ds	([B)J
    //   410: invokestatic 230	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   413: aastore
    //   414: invokestatic 234	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   417: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: astore 31
    //   425: iload 30
    //   427: iconst_1
    //   428: iadd
    //   429: istore 30
    //   431: goto -141 -> 290
    //   434: astore 13
    //   436: aload_0
    //   437: monitorexit
    //   438: aload 13
    //   440: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	i
    //   0	441	1	paramLong1	long
    //   0	441	3	paramLong2	long
    //   0	441	5	paramLong3	long
    //   0	441	7	paramLong4	long
    //   0	441	9	paramLong5	long
    //   0	441	11	paramLong6	long
    //   0	441	13	paramArrayOfByte1	byte[]
    //   0	441	14	paramArrayOfByte2	byte[]
    //   0	441	15	paramArrayOfByte3	byte[]
    //   0	441	16	paramArrayOfByte4	byte[]
    //   0	441	17	paramArrayOfByte5	byte[]
    //   0	441	18	paramArrayOfByte6	byte[]
    //   0	441	19	paramArrayOfByte7	byte[]
    //   0	441	20	paramArrayOfByte8	byte[]
    //   0	441	21	paramArrayOfByte9	byte[]
    //   0	441	22	paramArrayOfByte10	byte[]
    //   0	441	23	paramArrayOfByte11	byte[]
    //   0	441	24	paramArrayOfByte12	byte[]
    //   0	441	25	paramArrayOfByte13	byte[]
    //   0	441	26	paramArrayOfByte14	byte[]
    //   0	441	27	paramArrayOfByte15	byte[]
    //   0	441	28	paramArrayOfByte16	byte[]
    //   0	441	29	paramArrayOfByte	byte[][]
    //   288	142	30	i	int
    //   285	139	31	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	283	434	finally
    //   290	369	434	finally
    //   374	425	434	finally
  }
  
  public final void h(Long paramLong)
  {
    try
    {
      AppMethodBeat.i(88086);
      this.NQZ.h(paramLong);
      AppMethodBeat.o(88086);
      return;
    }
    finally
    {
      paramLong = finally;
      throw paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.i
 * JD-Core Version:    0.7.0.1
 */