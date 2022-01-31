package com.tencent.mm.plugin.s;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Pair;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public abstract class h
{
  private MediaCodec.BufferInfo aFT = new MediaCodec.BufferInfo();
  long aGU;
  private int aGi;
  private int aGj;
  private ByteBuffer[] axb;
  MediaExtractor eIP;
  protected MediaCodec eIT;
  private ByteBuffer[] inputBuffers;
  private String jkV;
  private volatile Object lock = new Object();
  protected g mep;
  protected ah meq;
  private boolean mer = false;
  b mes = null;
  protected long met = 0L;
  MediaFormat meu;
  int mev;
  private f mew;
  private boolean mex = false;
  private boolean mey = false;
  protected String path;
  protected int state;
  
  public h(g paramg, ah paramah)
  {
    this.mep = paramg;
    this.meq = paramah;
    this.state = 0;
    this.aGi = -1;
    this.aGj = -1;
  }
  
  private void bit()
  {
    if (this.mes != null) {
      this.met = (this.mes.bin() * 1000L);
    }
  }
  
  private boolean g(long paramLong1, long paramLong2)
  {
    y.d("MicroMsg.TrackDataSource", "%s drain output buffer time[%d %d] index %d", new Object[] { ayN(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.aGj) });
    if (this.aGj < 0)
    {
      synchronized (this.lock)
      {
        this.aGj = this.eIT.dequeueOutputBuffer(this.aFT, 0L);
        if (this.aGj < 0) {
          break label291;
        }
        if ((this.aFT.flags & 0x4) != 0)
        {
          y.i("MicroMsg.TrackDataSource", "%s process end of stream", new Object[] { ayN() });
          setState(9);
          this.aGj = -1;
          return false;
        }
      }
      ??? = this.axb[this.aGj];
      if (??? != null)
      {
        ((ByteBuffer)???).position(this.aFT.offset);
        ((ByteBuffer)???).limit(this.aFT.offset + this.aFT.size);
      }
    }
    if (this.state == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        setState(2);
      }
      y.d("MicroMsg.TrackDataSource", "%s process output buffer index %d ", new Object[] { ayN(), Integer.valueOf(this.aGj) });
      synchronized (this.lock)
      {
        if (!a(paramLong1, paramLong2, this.eIT, this.axb[this.aGj], this.aGj, this.aFT)) {
          break;
        }
        this.aGj = -1;
        return true;
      }
      label291:
      if (this.aGj == -2)
      {
        this.meu = this.eIT.getOutputFormat();
        b(this.eIT);
        return true;
      }
      if (this.aGj == -3)
      {
        this.axb = this.eIT.getOutputBuffers();
        return true;
      }
      y.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d]", new Object[] { ayN(), Integer.valueOf(this.aGj) });
      return false;
    }
    return false;
  }
  
  /* Error */
  protected final int C(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 86
    //   2: ldc 174
    //   4: iconst_4
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: lload_1
    //   18: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   21: aastore
    //   22: dup
    //   23: iconst_2
    //   24: lload_3
    //   25: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: aastore
    //   29: dup
    //   30: iconst_3
    //   31: aload_0
    //   32: getfield 68	com/tencent/mm/plugin/s/h:state	I
    //   35: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: invokestatic 109	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   46: ifnull +109 -> 155
    //   49: aload_0
    //   50: lload_1
    //   51: lload_3
    //   52: invokespecial 176	com/tencent/mm/plugin/s/h:g	(JJ)Z
    //   55: ifeq +17 -> 72
    //   58: aload_0
    //   59: getfield 68	com/tencent/mm/plugin/s/h:state	I
    //   62: invokestatic 182	com/tencent/mm/plugin/s/d:tK	(I)Z
    //   65: istore 9
    //   67: iload 9
    //   69: ifeq -20 -> 49
    //   72: ldc 86
    //   74: ldc 184
    //   76: iconst_4
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_0
    //   83: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: aload_0
    //   90: getfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   93: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: aload_0
    //   100: getfield 68	com/tencent/mm/plugin/s/h:state	I
    //   103: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: dup
    //   108: iconst_3
    //   109: aload_0
    //   110: getfield 47	com/tencent/mm/plugin/s/h:mer	Z
    //   113: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   116: aastore
    //   117: invokestatic 109	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload_0
    //   121: getfield 68	com/tencent/mm/plugin/s/h:state	I
    //   124: invokestatic 182	com/tencent/mm/plugin/s/d:tK	(I)Z
    //   127: ifne +10 -> 137
    //   130: aload_0
    //   131: getfield 47	com/tencent/mm/plugin/s/h:mer	Z
    //   134: ifeq +218 -> 352
    //   137: ldc 86
    //   139: ldc 191
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_0
    //   148: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 125	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: ldc 86
    //   157: ldc 193
    //   159: iconst_2
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_0
    //   166: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: aload_0
    //   173: getfield 68	com/tencent/mm/plugin/s/h:state	I
    //   176: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: aastore
    //   180: invokestatic 109	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_0
    //   184: getfield 68	com/tencent/mm/plugin/s/h:state	I
    //   187: ireturn
    //   188: astore 10
    //   190: aload_0
    //   191: getfield 60	com/tencent/mm/plugin/s/h:mex	Z
    //   194: ifeq +130 -> 324
    //   197: ldc 86
    //   199: ldc 195
    //   201: iconst_2
    //   202: anewarray 4	java/lang/Object
    //   205: dup
    //   206: iconst_0
    //   207: aload_0
    //   208: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   211: aastore
    //   212: dup
    //   213: iconst_1
    //   214: aload 10
    //   216: invokevirtual 198	java/lang/Exception:toString	()Ljava/lang/String;
    //   219: aastore
    //   220: invokestatic 201	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: aload_0
    //   224: getfield 68	com/tencent/mm/plugin/s/h:state	I
    //   227: invokestatic 182	com/tencent/mm/plugin/s/d:tK	(I)Z
    //   230: ifne +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 204	com/tencent/mm/plugin/s/h:biu	()V
    //   237: aload_0
    //   238: getfield 64	com/tencent/mm/plugin/s/h:mep	Lcom/tencent/mm/plugin/s/g;
    //   241: astore 10
    //   243: aload_0
    //   244: invokevirtual 207	com/tencent/mm/plugin/s/h:type	()Ljava/lang/String;
    //   247: astore 11
    //   249: aload 10
    //   251: getfield 212	com/tencent/mm/plugin/s/g:meo	Z
    //   254: ifne -182 -> 72
    //   257: aload 10
    //   259: getfield 215	com/tencent/mm/plugin/s/g:mel	Z
    //   262: ifeq -190 -> 72
    //   265: getstatic 221	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   268: ldc2_w 222
    //   271: ldc2_w 224
    //   274: lconst_1
    //   275: iconst_0
    //   276: invokevirtual 228	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   279: getstatic 221	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   282: sipush 13836
    //   285: iconst_3
    //   286: anewarray 4	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: sipush 506
    //   294: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: aastore
    //   298: dup
    //   299: iconst_1
    //   300: invokestatic 233	com/tencent/mm/sdk/platformtools/bk:UX	()J
    //   303: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   306: aastore
    //   307: dup
    //   308: iconst_2
    //   309: aload 11
    //   311: aastore
    //   312: invokevirtual 237	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   315: aload 10
    //   317: iconst_1
    //   318: putfield 212	com/tencent/mm/plugin/s/g:meo	Z
    //   321: goto -249 -> 72
    //   324: aload_0
    //   325: iconst_1
    //   326: putfield 60	com/tencent/mm/plugin/s/h:mex	Z
    //   329: ldc 86
    //   331: aload 10
    //   333: ldc 239
    //   335: iconst_1
    //   336: anewarray 4	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: aload_0
    //   342: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   345: aastore
    //   346: invokestatic 243	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: goto -126 -> 223
    //   352: aload_0
    //   353: getfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   356: ifge +179 -> 535
    //   359: aload_0
    //   360: aload_0
    //   361: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   364: lconst_0
    //   365: invokevirtual 247	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   368: putfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   371: aload_0
    //   372: getfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   375: ifge +160 -> 535
    //   378: ldc 86
    //   380: ldc 249
    //   382: iconst_1
    //   383: anewarray 4	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload_0
    //   389: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   392: aastore
    //   393: invokestatic 109	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: goto -241 -> 155
    //   399: astore 10
    //   401: aload_0
    //   402: getfield 62	com/tencent/mm/plugin/s/h:mey	Z
    //   405: ifeq +964 -> 1369
    //   408: ldc 86
    //   410: ldc 251
    //   412: iconst_2
    //   413: anewarray 4	java/lang/Object
    //   416: dup
    //   417: iconst_0
    //   418: aload_0
    //   419: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   422: aastore
    //   423: dup
    //   424: iconst_1
    //   425: aload 10
    //   427: invokevirtual 198	java/lang/Exception:toString	()Ljava/lang/String;
    //   430: aastore
    //   431: invokestatic 201	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: aload_0
    //   435: getfield 68	com/tencent/mm/plugin/s/h:state	I
    //   438: invokestatic 182	com/tencent/mm/plugin/s/d:tK	(I)Z
    //   441: ifne +7 -> 448
    //   444: aload_0
    //   445: invokevirtual 204	com/tencent/mm/plugin/s/h:biu	()V
    //   448: aload_0
    //   449: getfield 64	com/tencent/mm/plugin/s/h:mep	Lcom/tencent/mm/plugin/s/g;
    //   452: astore 10
    //   454: aload_0
    //   455: invokevirtual 207	com/tencent/mm/plugin/s/h:type	()Ljava/lang/String;
    //   458: astore 11
    //   460: aload 10
    //   462: getfield 254	com/tencent/mm/plugin/s/g:men	Z
    //   465: ifne -310 -> 155
    //   468: aload 10
    //   470: getfield 215	com/tencent/mm/plugin/s/g:mel	Z
    //   473: ifeq -318 -> 155
    //   476: getstatic 221	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   479: ldc2_w 222
    //   482: ldc2_w 255
    //   485: lconst_1
    //   486: iconst_0
    //   487: invokevirtual 228	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   490: getstatic 221	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   493: sipush 13836
    //   496: iconst_3
    //   497: anewarray 4	java/lang/Object
    //   500: dup
    //   501: iconst_0
    //   502: sipush 505
    //   505: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   508: aastore
    //   509: dup
    //   510: iconst_1
    //   511: invokestatic 233	com/tencent/mm/sdk/platformtools/bk:UX	()J
    //   514: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   517: aastore
    //   518: dup
    //   519: iconst_2
    //   520: aload 11
    //   522: aastore
    //   523: invokevirtual 237	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   526: aload 10
    //   528: iconst_1
    //   529: putfield 254	com/tencent/mm/plugin/s/g:men	Z
    //   532: goto -377 -> 155
    //   535: aload_0
    //   536: getfield 258	com/tencent/mm/plugin/s/h:inputBuffers	[Ljava/nio/ByteBuffer;
    //   539: aload_0
    //   540: getfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   543: aaload
    //   544: astore 10
    //   546: aload_0
    //   547: getfield 260	com/tencent/mm/plugin/s/h:mew	Lcom/tencent/mm/plugin/s/f;
    //   550: ifnull +216 -> 766
    //   553: aload_0
    //   554: getfield 260	com/tencent/mm/plugin/s/h:mew	Lcom/tencent/mm/plugin/s/f;
    //   557: aload 10
    //   559: invokevirtual 265	com/tencent/mm/plugin/s/f:C	(Ljava/nio/ByteBuffer;)I
    //   562: istore 5
    //   564: aload_0
    //   565: getfield 260	com/tencent/mm/plugin/s/h:mew	Lcom/tencent/mm/plugin/s/f;
    //   568: getfield 269	com/tencent/mm/plugin/s/f:mec	Lcom/tencent/mm/plugin/a/g;
    //   571: getfield 274	com/tencent/mm/plugin/a/g:eUD	J
    //   574: lstore_1
    //   575: aload_0
    //   576: getfield 260	com/tencent/mm/plugin/s/h:mew	Lcom/tencent/mm/plugin/s/f;
    //   579: getfield 269	com/tencent/mm/plugin/s/f:mec	Lcom/tencent/mm/plugin/a/g;
    //   582: getfield 277	com/tencent/mm/plugin/a/g:eUE	I
    //   585: istore 6
    //   587: ldc 86
    //   589: ldc_w 279
    //   592: iconst_5
    //   593: anewarray 4	java/lang/Object
    //   596: dup
    //   597: iconst_0
    //   598: aload_0
    //   599: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   602: aastore
    //   603: dup
    //   604: iconst_1
    //   605: aload_0
    //   606: getfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   609: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   612: aastore
    //   613: dup
    //   614: iconst_2
    //   615: iload 5
    //   617: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   620: aastore
    //   621: dup
    //   622: iconst_3
    //   623: lload_1
    //   624: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   627: aastore
    //   628: dup
    //   629: iconst_4
    //   630: iload 6
    //   632: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   635: aastore
    //   636: invokestatic 109	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   639: iload 5
    //   641: ifgt +26 -> 667
    //   644: aload_0
    //   645: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   648: aload_0
    //   649: getfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   652: iconst_0
    //   653: iconst_0
    //   654: lconst_0
    //   655: iconst_4
    //   656: invokevirtual 283	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   659: aload_0
    //   660: iconst_1
    //   661: putfield 47	com/tencent/mm/plugin/s/h:mer	Z
    //   664: goto -509 -> 155
    //   667: aload_0
    //   668: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   671: aload_0
    //   672: getfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   675: iconst_0
    //   676: iload 5
    //   678: lload_1
    //   679: iconst_0
    //   680: invokevirtual 283	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   683: aload_0
    //   684: iconst_m1
    //   685: putfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   688: aload_0
    //   689: getfield 260	com/tencent/mm/plugin/s/h:mew	Lcom/tencent/mm/plugin/s/f;
    //   692: astore 10
    //   694: aload 10
    //   696: aload 10
    //   698: getfield 286	com/tencent/mm/plugin/s/f:med	I
    //   701: iconst_1
    //   702: iadd
    //   703: putfield 286	com/tencent/mm/plugin/s/f:med	I
    //   706: aload 10
    //   708: getfield 286	com/tencent/mm/plugin/s/f:med	I
    //   711: aload 10
    //   713: getfield 289	com/tencent/mm/plugin/s/f:mee	I
    //   716: if_icmpge -561 -> 155
    //   719: aload 10
    //   721: aload 10
    //   723: getfield 293	com/tencent/mm/plugin/s/f:eUA	Ljava/util/List;
    //   726: aload 10
    //   728: getfield 286	com/tencent/mm/plugin/s/f:med	I
    //   731: invokeinterface 299 2 0
    //   736: checkcast 271	com/tencent/mm/plugin/a/g
    //   739: putfield 269	com/tencent/mm/plugin/s/f:mec	Lcom/tencent/mm/plugin/a/g;
    //   742: ldc_w 301
    //   745: ldc_w 303
    //   748: iconst_1
    //   749: anewarray 4	java/lang/Object
    //   752: dup
    //   753: iconst_0
    //   754: aload 10
    //   756: getfield 269	com/tencent/mm/plugin/s/f:mec	Lcom/tencent/mm/plugin/a/g;
    //   759: aastore
    //   760: invokestatic 109	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   763: goto -608 -> 155
    //   766: aload_0
    //   767: getfield 64	com/tencent/mm/plugin/s/h:mep	Lcom/tencent/mm/plugin/s/g;
    //   770: getfield 306	com/tencent/mm/plugin/s/g:mem	Z
    //   773: ifeq +41 -> 814
    //   776: aload_0
    //   777: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   780: aload_0
    //   781: getfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   784: iconst_0
    //   785: iconst_0
    //   786: aload_0
    //   787: getfield 308	com/tencent/mm/plugin/s/h:aGU	J
    //   790: ldc2_w 81
    //   793: lmul
    //   794: iconst_4
    //   795: invokevirtual 283	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   798: aload_0
    //   799: iconst_1
    //   800: putfield 47	com/tencent/mm/plugin/s/h:mer	Z
    //   803: aload_0
    //   804: getfield 64	com/tencent/mm/plugin/s/h:mep	Lcom/tencent/mm/plugin/s/g;
    //   807: iconst_0
    //   808: putfield 306	com/tencent/mm/plugin/s/g:mem	Z
    //   811: goto -656 -> 155
    //   814: aload_0
    //   815: getfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   818: aload 10
    //   820: iconst_0
    //   821: invokevirtual 316	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   824: istore 5
    //   826: aload_0
    //   827: getfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   830: invokevirtual 319	android/media/MediaExtractor:getSampleTime	()J
    //   833: lstore_1
    //   834: aload_0
    //   835: getfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   838: invokevirtual 323	android/media/MediaExtractor:getSampleFlags	()I
    //   841: istore 6
    //   843: ldc 86
    //   845: ldc_w 279
    //   848: iconst_5
    //   849: anewarray 4	java/lang/Object
    //   852: dup
    //   853: iconst_0
    //   854: aload_0
    //   855: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   858: aastore
    //   859: dup
    //   860: iconst_1
    //   861: aload_0
    //   862: getfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   865: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   868: aastore
    //   869: dup
    //   870: iconst_2
    //   871: iload 5
    //   873: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   876: aastore
    //   877: dup
    //   878: iconst_3
    //   879: lload_1
    //   880: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   883: aastore
    //   884: dup
    //   885: iconst_4
    //   886: iload 6
    //   888: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   891: aastore
    //   892: invokestatic 109	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   895: aload_0
    //   896: iload 6
    //   898: lload_1
    //   899: invokevirtual 327	com/tencent/mm/plugin/s/h:F	(IJ)Z
    //   902: pop
    //   903: iload 5
    //   905: ifgt +33 -> 938
    //   908: aload_0
    //   909: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   912: aload_0
    //   913: getfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   916: iconst_0
    //   917: iconst_0
    //   918: aload_0
    //   919: getfield 308	com/tencent/mm/plugin/s/h:aGU	J
    //   922: ldc2_w 81
    //   925: lmul
    //   926: iconst_4
    //   927: invokevirtual 283	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   930: aload_0
    //   931: iconst_1
    //   932: putfield 47	com/tencent/mm/plugin/s/h:mer	Z
    //   935: goto -780 -> 155
    //   938: aload_0
    //   939: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   942: aload_0
    //   943: getfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   946: iconst_0
    //   947: iload 5
    //   949: lload_1
    //   950: iconst_0
    //   951: invokevirtual 283	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   954: aload_0
    //   955: iconst_m1
    //   956: putfield 70	com/tencent/mm/plugin/s/h:aGi	I
    //   959: aload_0
    //   960: getfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   963: invokevirtual 331	android/media/MediaExtractor:advance	()Z
    //   966: pop
    //   967: aload_0
    //   968: getfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   971: invokevirtual 319	android/media/MediaExtractor:getSampleTime	()J
    //   974: lstore_3
    //   975: aload_0
    //   976: getfield 64	com/tencent/mm/plugin/s/h:mep	Lcom/tencent/mm/plugin/s/g;
    //   979: getfield 334	com/tencent/mm/plugin/s/g:joR	Z
    //   982: ifne +162 -> 1144
    //   985: aload_0
    //   986: lload_1
    //   987: lload_3
    //   988: invokevirtual 337	com/tencent/mm/plugin/s/h:D	(JJ)Z
    //   991: ifeq +117 -> 1108
    //   994: ldc 86
    //   996: ldc_w 339
    //   999: iconst_4
    //   1000: anewarray 4	java/lang/Object
    //   1003: dup
    //   1004: iconst_0
    //   1005: aload_0
    //   1006: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   1009: aastore
    //   1010: dup
    //   1011: iconst_1
    //   1012: aload_0
    //   1013: getfield 64	com/tencent/mm/plugin/s/h:mep	Lcom/tencent/mm/plugin/s/g;
    //   1016: getfield 334	com/tencent/mm/plugin/s/g:joR	Z
    //   1019: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1022: aastore
    //   1023: dup
    //   1024: iconst_2
    //   1025: lload_3
    //   1026: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1029: aastore
    //   1030: dup
    //   1031: iconst_3
    //   1032: aload_0
    //   1033: getfield 51	com/tencent/mm/plugin/s/h:met	J
    //   1036: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1039: aastore
    //   1040: invokestatic 342	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1043: aload_0
    //   1044: getfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   1047: invokevirtual 319	android/media/MediaExtractor:getSampleTime	()J
    //   1050: lstore 7
    //   1052: lload 7
    //   1054: lload_1
    //   1055: lsub
    //   1056: invokestatic 348	java/lang/Math:abs	(J)J
    //   1059: ldc2_w 349
    //   1062: lcmp
    //   1063: iflt +45 -> 1108
    //   1066: ldc 86
    //   1068: ldc_w 352
    //   1071: iconst_3
    //   1072: anewarray 4	java/lang/Object
    //   1075: dup
    //   1076: iconst_0
    //   1077: aload_0
    //   1078: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   1081: aastore
    //   1082: dup
    //   1083: iconst_1
    //   1084: lload 7
    //   1086: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1089: aastore
    //   1090: dup
    //   1091: iconst_2
    //   1092: lload_1
    //   1093: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1096: aastore
    //   1097: invokestatic 342	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1100: aload_0
    //   1101: getfield 64	com/tencent/mm/plugin/s/h:mep	Lcom/tencent/mm/plugin/s/g;
    //   1104: iconst_1
    //   1105: putfield 306	com/tencent/mm/plugin/s/g:mem	Z
    //   1108: ldc 86
    //   1110: ldc_w 354
    //   1113: iconst_3
    //   1114: anewarray 4	java/lang/Object
    //   1117: dup
    //   1118: iconst_0
    //   1119: aload_0
    //   1120: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   1123: aastore
    //   1124: dup
    //   1125: iconst_1
    //   1126: lload_1
    //   1127: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1130: aastore
    //   1131: dup
    //   1132: iconst_2
    //   1133: lload_3
    //   1134: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1137: aastore
    //   1138: invokestatic 109	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1141: goto -986 -> 155
    //   1144: aload_0
    //   1145: getfield 51	com/tencent/mm/plugin/s/h:met	J
    //   1148: lconst_0
    //   1149: lcmp
    //   1150: ifne +127 -> 1277
    //   1153: aload_0
    //   1154: lload_1
    //   1155: lload_3
    //   1156: invokevirtual 337	com/tencent/mm/plugin/s/h:D	(JJ)Z
    //   1159: ifeq -51 -> 1108
    //   1162: ldc 86
    //   1164: ldc_w 356
    //   1167: iconst_3
    //   1168: anewarray 4	java/lang/Object
    //   1171: dup
    //   1172: iconst_0
    //   1173: aload_0
    //   1174: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   1177: aastore
    //   1178: dup
    //   1179: iconst_1
    //   1180: lload_3
    //   1181: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1184: aastore
    //   1185: dup
    //   1186: iconst_2
    //   1187: aload_0
    //   1188: getfield 51	com/tencent/mm/plugin/s/h:met	J
    //   1191: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1194: aastore
    //   1195: invokestatic 342	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1198: aload_0
    //   1199: getfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   1202: invokevirtual 319	android/media/MediaExtractor:getSampleTime	()J
    //   1205: lstore 7
    //   1207: lload 7
    //   1209: lload_1
    //   1210: lsub
    //   1211: invokestatic 348	java/lang/Math:abs	(J)J
    //   1214: ldc2_w 357
    //   1217: lcmp
    //   1218: iflt +52 -> 1270
    //   1221: ldc 86
    //   1223: ldc_w 352
    //   1226: iconst_3
    //   1227: anewarray 4	java/lang/Object
    //   1230: dup
    //   1231: iconst_0
    //   1232: aload_0
    //   1233: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   1236: aastore
    //   1237: dup
    //   1238: iconst_1
    //   1239: lload 7
    //   1241: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1244: aastore
    //   1245: dup
    //   1246: iconst_2
    //   1247: lload_1
    //   1248: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1251: aastore
    //   1252: invokestatic 342	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1255: aload_0
    //   1256: getfield 66	com/tencent/mm/plugin/s/h:meq	Lcom/tencent/mm/sdk/platformtools/ah;
    //   1259: iconst_5
    //   1260: bipush 254
    //   1262: bipush 254
    //   1264: invokevirtual 364	com/tencent/mm/sdk/platformtools/ah:obtainMessage	(III)Landroid/os/Message;
    //   1267: invokevirtual 369	android/os/Message:sendToTarget	()V
    //   1270: aload_0
    //   1271: invokespecial 371	com/tencent/mm/plugin/s/h:bit	()V
    //   1274: goto -166 -> 1108
    //   1277: lload_3
    //   1278: lconst_0
    //   1279: lcmp
    //   1280: iflt +20 -> 1300
    //   1283: lload_3
    //   1284: ldc2_w 81
    //   1287: ldiv
    //   1288: ldc2_w 372
    //   1291: ladd
    //   1292: aload_0
    //   1293: getfield 51	com/tencent/mm/plugin/s/h:met	J
    //   1296: lcmp
    //   1297: ifle -189 -> 1108
    //   1300: ldc 86
    //   1302: ldc_w 356
    //   1305: iconst_3
    //   1306: anewarray 4	java/lang/Object
    //   1309: dup
    //   1310: iconst_0
    //   1311: aload_0
    //   1312: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   1315: aastore
    //   1316: dup
    //   1317: iconst_1
    //   1318: lload_3
    //   1319: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1322: aastore
    //   1323: dup
    //   1324: iconst_2
    //   1325: aload_0
    //   1326: getfield 51	com/tencent/mm/plugin/s/h:met	J
    //   1329: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1332: aastore
    //   1333: invokestatic 342	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1336: aload_0
    //   1337: lload_1
    //   1338: ldc2_w 374
    //   1341: invokevirtual 337	com/tencent/mm/plugin/s/h:D	(JJ)Z
    //   1344: ifeq +18 -> 1362
    //   1347: aload_0
    //   1348: getfield 66	com/tencent/mm/plugin/s/h:meq	Lcom/tencent/mm/sdk/platformtools/ah;
    //   1351: iconst_5
    //   1352: bipush 253
    //   1354: bipush 253
    //   1356: invokevirtual 364	com/tencent/mm/sdk/platformtools/ah:obtainMessage	(III)Landroid/os/Message;
    //   1359: invokevirtual 369	android/os/Message:sendToTarget	()V
    //   1362: aload_0
    //   1363: invokespecial 371	com/tencent/mm/plugin/s/h:bit	()V
    //   1366: goto -258 -> 1108
    //   1369: aload_0
    //   1370: iconst_1
    //   1371: putfield 62	com/tencent/mm/plugin/s/h:mey	Z
    //   1374: ldc 86
    //   1376: aload 10
    //   1378: ldc_w 377
    //   1381: iconst_1
    //   1382: anewarray 4	java/lang/Object
    //   1385: dup
    //   1386: iconst_0
    //   1387: aload_0
    //   1388: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   1391: aastore
    //   1392: invokestatic 243	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1395: goto -961 -> 434
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1398	0	this	h
    //   0	1398	1	paramLong1	long
    //   0	1398	3	paramLong2	long
    //   562	386	5	i	int
    //   585	312	6	j	int
    //   1050	190	7	l	long
    //   65	3	9	bool	boolean
    //   188	27	10	localException1	Exception
    //   241	91	10	localg	g
    //   399	27	10	localException2	Exception
    //   452	925	10	localObject	Object
    //   247	274	11	str	String
    // Exception table:
    //   from	to	target	type
    //   49	67	188	java/lang/Exception
    //   72	137	399	java/lang/Exception
    //   137	155	399	java/lang/Exception
    //   352	396	399	java/lang/Exception
    //   535	639	399	java/lang/Exception
    //   644	664	399	java/lang/Exception
    //   667	763	399	java/lang/Exception
    //   766	811	399	java/lang/Exception
    //   814	903	399	java/lang/Exception
    //   908	935	399	java/lang/Exception
    //   938	1108	399	java/lang/Exception
    //   1108	1141	399	java/lang/Exception
    //   1144	1270	399	java/lang/Exception
    //   1270	1274	399	java/lang/Exception
    //   1283	1300	399	java/lang/Exception
    //   1300	1362	399	java/lang/Exception
    //   1362	1366	399	java/lang/Exception
  }
  
  protected final boolean D(long paramLong1, long paramLong2)
  {
    long l1 = bk.UZ();
    try
    {
      if ((paramLong1 / 1000L + 1000L < this.aGU) && (paramLong2 == -1L))
      {
        this.mep.joQ = true;
        this.mer = false;
        this.eIP.release();
        RandomAccessFile localRandomAccessFile = e.bP(this.path, false);
        FileDescriptor localFileDescriptor = localRandomAccessFile.getFD();
        this.eIP = new MediaExtractor();
        this.eIP.setDataSource(localFileDescriptor);
        localRandomAccessFile.close();
        this.eIP.selectTrack(this.mev);
        this.eIP.seekTo(paramLong1, 2);
        long l2 = this.eIP.getSampleTime();
        y.w("MicroMsg.TrackDataSource", "%s it don't play end. currTime[%d] afterSeek[%d] nextSampleTime[%d] onlineCacheMs[%d] cost[%d]", new Object[] { ayN(), Long.valueOf(paramLong1), Long.valueOf(l2), Long.valueOf(paramLong2), Long.valueOf(this.met), Long.valueOf(bk.cp(l1)) });
        return true;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.TrackDataSource", "%s reset extractor error %s", new Object[] { ayN(), localException.toString() });
    }
    return false;
  }
  
  protected boolean F(int paramInt, long paramLong)
  {
    return false;
  }
  
  abstract boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
  
  abstract boolean a(MediaCodec paramMediaCodec);
  
  public final String ayN()
  {
    return type() + "_" + this.mep.ayN();
  }
  
  protected void b(MediaCodec paramMediaCodec) {}
  
  protected void b(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    y.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d]", new Object[] { ayN(), paramString, Integer.valueOf(paramInt) });
    this.mev = paramInt;
    this.jkV = paramString;
    this.aGU = (paramMediaFormat.getLong("durationUs") / 1000L);
    this.meu = paramMediaFormat;
  }
  
  public final void biu()
  {
    y.i("MicroMsg.TrackDataSource", "%s flush codec", new Object[] { ayN() });
    this.aGj = -1;
    this.aGi = -1;
    try
    {
      if (this.eIT != null) {
        this.eIT.flush();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected final boolean biv()
  {
    try
    {
      y.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", new Object[] { ayN(), this.jkV });
      this.eIT = MediaCodec.createDecoderByType(this.jkV);
      a(this.eIT);
      this.eIT.start();
      this.inputBuffers = this.eIT.getInputBuffers();
      this.axb = this.eIT.getOutputBuffers();
      return true;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.TrackDataSource", localException, "%s prepare decoder init decoder error ", new Object[] { ayN() });
      this.mep.Ii(type());
    }
    return false;
  }
  
  /* Error */
  protected final void nm()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   4: ifnull +126 -> 130
    //   7: ldc 86
    //   9: ldc_w 478
    //   12: iconst_1
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_0
    //   19: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   22: aastore
    //   23: invokestatic 125	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: invokevirtual 204	com/tencent/mm/plugin/s/h:biu	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 131	com/tencent/mm/plugin/s/h:axb	[Ljava/nio/ByteBuffer;
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 258	com/tencent/mm/plugin/s/h:inputBuffers	[Ljava/nio/ByteBuffer;
    //   40: invokestatic 380	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   43: lstore_1
    //   44: aload_0
    //   45: getfield 58	com/tencent/mm/plugin/s/h:lock	Ljava/lang/Object;
    //   48: astore_3
    //   49: aload_3
    //   50: monitorenter
    //   51: ldc 86
    //   53: ldc_w 480
    //   56: iconst_2
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_0
    //   63: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: lload_1
    //   70: invokestatic 422	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   73: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: aastore
    //   77: invokestatic 125	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_0
    //   81: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   84: invokevirtual 483	android/media/MediaCodec:stop	()V
    //   87: aload_0
    //   88: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   91: invokevirtual 484	android/media/MediaCodec:release	()V
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   99: aload_3
    //   100: monitorexit
    //   101: ldc 86
    //   103: ldc_w 486
    //   106: iconst_2
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: lload_1
    //   120: invokestatic 422	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   123: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: aastore
    //   127: invokestatic 125	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: return
    //   131: astore 4
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   138: aload 4
    //   140: athrow
    //   141: astore 4
    //   143: aload_3
    //   144: monitorexit
    //   145: aload 4
    //   147: athrow
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   154: invokevirtual 484	android/media/MediaCodec:release	()V
    //   157: aload_0
    //   158: aconst_null
    //   159: putfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   162: goto -63 -> 99
    //   165: astore 4
    //   167: aload_0
    //   168: aconst_null
    //   169: putfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   172: aload 4
    //   174: athrow
    //   175: astore 4
    //   177: aload_0
    //   178: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   181: invokevirtual 484	android/media/MediaCodec:release	()V
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   189: aload 4
    //   191: athrow
    //   192: astore 4
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   199: aload 4
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	h
    //   43	77	1	l	long
    //   48	96	3	localObject1	Object
    //   131	8	4	localObject2	Object
    //   141	5	4	localObject3	Object
    //   148	1	4	localException	Exception
    //   165	8	4	localObject4	Object
    //   175	15	4	localObject5	Object
    //   192	8	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   87	94	131	finally
    //   51	80	141	finally
    //   94	99	141	finally
    //   99	101	141	finally
    //   133	141	141	finally
    //   143	145	141	finally
    //   157	162	141	finally
    //   167	175	141	finally
    //   184	192	141	finally
    //   194	202	141	finally
    //   80	87	148	java/lang/Exception
    //   150	157	165	finally
    //   80	87	175	finally
    //   177	184	192	finally
  }
  
  protected void onPause() {}
  
  protected void onStart() {}
  
  public final void pause()
  {
    y.i("MicroMsg.TrackDataSource", "%s start to pause", new Object[] { ayN() });
    setState(4);
    onPause();
  }
  
  /* Error */
  public final boolean prepare()
  {
    // Byte code:
    //   0: ldc 86
    //   2: ldc_w 498
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: aload_0
    //   19: getfield 388	com/tencent/mm/plugin/s/h:path	Ljava/lang/String;
    //   22: aastore
    //   23: invokestatic 125	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: invokestatic 380	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   29: lstore 5
    //   31: lconst_0
    //   32: lstore_3
    //   33: ldc 86
    //   35: ldc_w 500
    //   38: iconst_1
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   48: aastore
    //   49: invokestatic 125	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload_0
    //   53: getfield 388	com/tencent/mm/plugin/s/h:path	Ljava/lang/String;
    //   56: iconst_0
    //   57: invokestatic 394	com/tencent/mm/vfs/e:bP	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   60: astore 9
    //   62: aload 9
    //   64: invokevirtual 400	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   67: astore 10
    //   69: aload_0
    //   70: new 312	android/media/MediaExtractor
    //   73: dup
    //   74: invokespecial 401	android/media/MediaExtractor:<init>	()V
    //   77: putfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   80: aload_0
    //   81: getfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   84: aload 10
    //   86: invokevirtual 405	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   89: aload 9
    //   91: invokevirtual 408	java/io/RandomAccessFile:close	()V
    //   94: aload_0
    //   95: getfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   98: invokevirtual 503	android/media/MediaExtractor:getTrackCount	()I
    //   101: istore_2
    //   102: aload_0
    //   103: iconst_m1
    //   104: putfield 410	com/tencent/mm/plugin/s/h:mev	I
    //   107: iconst_0
    //   108: istore_1
    //   109: iload_1
    //   110: iload_2
    //   111: if_icmpge +49 -> 160
    //   114: aload_0
    //   115: getfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   118: iload_1
    //   119: invokevirtual 507	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   122: astore 9
    //   124: aload 9
    //   126: ldc_w 509
    //   129: invokevirtual 513	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 10
    //   134: aload 10
    //   136: ifnull +399 -> 535
    //   139: aload 10
    //   141: aload_0
    //   142: invokevirtual 207	com/tencent/mm/plugin/s/h:type	()Ljava/lang/String;
    //   145: invokevirtual 519	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   148: ifeq +387 -> 535
    //   151: aload_0
    //   152: aload 9
    //   154: aload 10
    //   156: iload_1
    //   157: invokevirtual 521	com/tencent/mm/plugin/s/h:b	(Landroid/media/MediaFormat;Ljava/lang/String;I)V
    //   160: aload_0
    //   161: getfield 410	com/tencent/mm/plugin/s/h:mev	I
    //   164: ifge +51 -> 215
    //   167: ldc 86
    //   169: ldc_w 523
    //   172: iconst_3
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: iload_2
    //   186: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: aastore
    //   190: dup
    //   191: iconst_2
    //   192: aload_0
    //   193: getfield 410	com/tencent/mm/plugin/s/h:mev	I
    //   196: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aastore
    //   200: invokestatic 342	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: aload_0
    //   204: getfield 64	com/tencent/mm/plugin/s/h:mep	Lcom/tencent/mm/plugin/s/g;
    //   207: ldc_w 525
    //   210: invokevirtual 528	com/tencent/mm/plugin/s/g:Ih	(Ljava/lang/String;)V
    //   213: iconst_0
    //   214: ireturn
    //   215: aload_0
    //   216: getfield 310	com/tencent/mm/plugin/s/h:eIP	Landroid/media/MediaExtractor;
    //   219: aload_0
    //   220: getfield 410	com/tencent/mm/plugin/s/h:mev	I
    //   223: invokevirtual 413	android/media/MediaExtractor:selectTrack	(I)V
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield 260	com/tencent/mm/plugin/s/h:mew	Lcom/tencent/mm/plugin/s/f;
    //   231: invokestatic 380	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   234: lstore 7
    //   236: ldc 86
    //   238: ldc_w 530
    //   241: iconst_3
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload_0
    //   248: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   251: aastore
    //   252: dup
    //   253: iconst_1
    //   254: aload_0
    //   255: getfield 441	com/tencent/mm/plugin/s/h:jkV	Ljava/lang/String;
    //   258: aastore
    //   259: dup
    //   260: iconst_2
    //   261: aload_0
    //   262: getfield 68	com/tencent/mm/plugin/s/h:state	I
    //   265: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   268: aastore
    //   269: invokestatic 125	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: aload_0
    //   273: getfield 68	com/tencent/mm/plugin/s/h:state	I
    //   276: invokestatic 182	com/tencent/mm/plugin/s/d:tK	(I)Z
    //   279: ifne +68 -> 347
    //   282: aload_0
    //   283: getfield 58	com/tencent/mm/plugin/s/h:lock	Ljava/lang/Object;
    //   286: astore 9
    //   288: aload 9
    //   290: monitorenter
    //   291: aload_0
    //   292: aload_0
    //   293: getfield 441	com/tencent/mm/plugin/s/h:jkV	Ljava/lang/String;
    //   296: invokestatic 461	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   299: putfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   302: aload_0
    //   303: aload_0
    //   304: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   307: invokevirtual 463	com/tencent/mm/plugin/s/h:a	(Landroid/media/MediaCodec;)Z
    //   310: pop
    //   311: aload_0
    //   312: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   315: invokevirtual 466	android/media/MediaCodec:start	()V
    //   318: aload_0
    //   319: aload_0
    //   320: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   323: invokevirtual 469	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   326: putfield 258	com/tencent/mm/plugin/s/h:inputBuffers	[Ljava/nio/ByteBuffer;
    //   329: aload_0
    //   330: aload_0
    //   331: getfield 111	com/tencent/mm/plugin/s/h:eIT	Landroid/media/MediaCodec;
    //   334: invokevirtual 166	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   337: putfield 131	com/tencent/mm/plugin/s/h:axb	[Ljava/nio/ByteBuffer;
    //   340: aload 9
    //   342: monitorexit
    //   343: invokestatic 380	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   346: lstore_3
    //   347: aload_0
    //   348: iconst_1
    //   349: invokevirtual 129	com/tencent/mm/plugin/s/h:setState	(I)V
    //   352: ldc 86
    //   354: ldc_w 532
    //   357: iconst_4
    //   358: anewarray 4	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: aload_0
    //   364: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   367: aastore
    //   368: dup
    //   369: iconst_1
    //   370: lload 5
    //   372: invokestatic 422	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   375: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   378: aastore
    //   379: dup
    //   380: iconst_2
    //   381: lload 7
    //   383: lload 5
    //   385: lsub
    //   386: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   389: aastore
    //   390: dup
    //   391: iconst_3
    //   392: lload_3
    //   393: lload 5
    //   395: lsub
    //   396: invokestatic 98	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   399: aastore
    //   400: invokestatic 125	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   403: iconst_1
    //   404: ireturn
    //   405: astore 9
    //   407: ldc 86
    //   409: aload 9
    //   411: ldc_w 534
    //   414: iconst_1
    //   415: anewarray 4	java/lang/Object
    //   418: dup
    //   419: iconst_0
    //   420: aload_0
    //   421: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   424: aastore
    //   425: invokestatic 243	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   428: aload_0
    //   429: getfield 64	com/tencent/mm/plugin/s/h:mep	Lcom/tencent/mm/plugin/s/g;
    //   432: aload 9
    //   434: invokevirtual 198	java/lang/Exception:toString	()Ljava/lang/String;
    //   437: invokevirtual 528	com/tencent/mm/plugin/s/g:Ih	(Ljava/lang/String;)V
    //   440: iconst_0
    //   441: ireturn
    //   442: astore 9
    //   444: ldc 86
    //   446: ldc_w 536
    //   449: iconst_2
    //   450: anewarray 4	java/lang/Object
    //   453: dup
    //   454: iconst_0
    //   455: aload_0
    //   456: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   459: aastore
    //   460: dup
    //   461: iconst_1
    //   462: aload 9
    //   464: invokevirtual 537	java/lang/Throwable:toString	()Ljava/lang/String;
    //   467: aastore
    //   468: invokestatic 201	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   471: aload_0
    //   472: getfield 64	com/tencent/mm/plugin/s/h:mep	Lcom/tencent/mm/plugin/s/g;
    //   475: aload 9
    //   477: invokevirtual 537	java/lang/Throwable:toString	()Ljava/lang/String;
    //   480: invokevirtual 528	com/tencent/mm/plugin/s/g:Ih	(Ljava/lang/String;)V
    //   483: iconst_0
    //   484: ireturn
    //   485: astore 10
    //   487: aload 9
    //   489: monitorexit
    //   490: aload 10
    //   492: athrow
    //   493: astore 9
    //   495: ldc 86
    //   497: ldc_w 539
    //   500: iconst_2
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: aload_0
    //   507: invokevirtual 92	com/tencent/mm/plugin/s/h:ayN	()Ljava/lang/String;
    //   510: aastore
    //   511: dup
    //   512: iconst_1
    //   513: aload 9
    //   515: invokevirtual 198	java/lang/Exception:toString	()Ljava/lang/String;
    //   518: aastore
    //   519: invokestatic 201	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   522: aload_0
    //   523: getfield 64	com/tencent/mm/plugin/s/h:mep	Lcom/tencent/mm/plugin/s/g;
    //   526: aload_0
    //   527: invokevirtual 207	com/tencent/mm/plugin/s/h:type	()Ljava/lang/String;
    //   530: invokevirtual 475	com/tencent/mm/plugin/s/g:Ii	(Ljava/lang/String;)V
    //   533: iconst_0
    //   534: ireturn
    //   535: iload_1
    //   536: iconst_1
    //   537: iadd
    //   538: istore_1
    //   539: goto -430 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	542	0	this	h
    //   108	431	1	i	int
    //   101	85	2	j	int
    //   32	361	3	l1	long
    //   29	365	5	l2	long
    //   234	148	7	l3	long
    //   405	28	9	localException1	Exception
    //   442	46	9	localThrowable	java.lang.Throwable
    //   493	21	9	localException2	Exception
    //   67	88	10	localObject2	Object
    //   485	6	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   33	107	405	java/lang/Exception
    //   114	134	405	java/lang/Exception
    //   139	160	405	java/lang/Exception
    //   160	213	405	java/lang/Exception
    //   215	236	405	java/lang/Exception
    //   33	107	442	java/lang/Throwable
    //   114	134	442	java/lang/Throwable
    //   139	160	442	java/lang/Throwable
    //   160	213	442	java/lang/Throwable
    //   215	236	442	java/lang/Throwable
    //   291	343	485	finally
    //   487	490	485	finally
    //   236	272	493	java/lang/Exception
    //   272	291	493	java/lang/Exception
    //   343	347	493	java/lang/Exception
    //   490	493	493	java/lang/Exception
  }
  
  public void release()
  {
    y.i("MicroMsg.TrackDataSource", "%s release", new Object[] { ayN() });
    if (this.eIP != null)
    {
      this.eIP.release();
      this.eIP = null;
    }
    if (this.eIT != null)
    {
      this.eIT.release();
      this.eIT = null;
    }
    f localf;
    if (this.mew != null)
    {
      localf = this.mew;
      if (localf.meb == null) {}
    }
    try
    {
      localf.meb.close();
      label83:
      localf.eUA.clear();
      localf.eUA = null;
      localf.eUB.clear();
      localf.eUB = null;
      localf.mec = null;
      y.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { ayN() });
      return;
    }
    catch (IOException localIOException)
    {
      break label83;
    }
  }
  
  public final void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  protected final void setState(int paramInt)
  {
    y.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", new Object[] { ayN(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
  }
  
  public final void start()
  {
    y.i("MicroMsg.TrackDataSource", "%s start to play", new Object[] { ayN() });
    setState(3);
    onStart();
  }
  
  public final long tO(int paramInt)
  {
    y.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", new Object[] { ayN(), Integer.valueOf(paramInt), Boolean.valueOf(this.mer) });
    biu();
    this.mer = false;
    if (this.mew != null) {}
    for (;;)
    {
      long l;
      int i;
      try
      {
        f localf = this.mew;
        l = paramInt * 1000;
        i = 0;
        if (i < localf.eUB.size())
        {
          Pair localPair = (Pair)localf.eUB.get(i);
          if (l >= ((Long)localPair.second).longValue())
          {
            if (l != ((Long)localPair.second).longValue()) {
              break label590;
            }
            localf.med = ((Integer)localPair.first).intValue();
            localf.mec = ((com.tencent.mm.plugin.a.g)localf.eUA.get(localf.med));
            if (this.mew.mec.eUD < 0L) {
              D(paramInt * 1000L, -1L);
            }
            if (this.mew.mec.eUD < 0L)
            {
              D(0L, -1L);
              this.mep.bis();
            }
            l = this.mew.mec.eUD;
            y.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", new Object[] { ayN(), Long.valueOf(l) });
            return l / 1000L;
          }
        }
        if ((i == 0) || (i == localf.eUB.size() - 1))
        {
          localf.med = ((Integer)((Pair)localf.eUB.get(i)).first).intValue();
          localf.mec = ((com.tencent.mm.plugin.a.g)localf.eUA.get(localf.med));
          continue;
        }
        localException1.med = ((Integer)((Pair)localException1.eUB.get(i - 1)).first).intValue();
      }
      catch (Exception localException1)
      {
        y.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "%s extractor seek exception %s", new Object[] { ayN(), localException1.toString() });
        return 0L;
      }
      localException1.mec = ((com.tencent.mm.plugin.a.g)localException1.eUA.get(localException1.med));
      continue;
      try
      {
        this.eIP.seekTo(paramInt * 1000, 0);
        if (this.eIP.getSampleTime() < 0L) {
          D(paramInt * 1000L, -1L);
        }
        if (this.eIP.getSampleTime() < 0L)
        {
          D(0L, -1L);
          this.mep.bis();
        }
        l = this.eIP.getSampleTime();
        y.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d]", new Object[] { ayN(), Long.valueOf(l), Long.valueOf(this.eIP.getCachedDuration()) });
        l /= 1000L;
        return l;
      }
      catch (Exception localException2)
      {
        y.printErrStackTrace("MicroMsg.TrackDataSource", localException2, "%s extractor seek exception %s", new Object[] { ayN(), localException2.toString() });
        return 0L;
      }
      label590:
      i += 1;
    }
  }
  
  abstract String type();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.s.h
 * JD-Core Version:    0.7.0.1
 */