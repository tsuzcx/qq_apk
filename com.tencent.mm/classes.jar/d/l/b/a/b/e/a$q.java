package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.b;
import d.l.b.a.b.h.d;
import d.l.b.a.b.h.f;
import d.l.b.a.b.h.g;
import d.l.b.a.b.h.h;
import d.l.b.a.b.h.i.a;
import d.l.b.a.b.h.i.b;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.c.a;
import d.l.b.a.b.h.q;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$q
  extends i.c<q>
  implements s
{
  public static d.l.b.a.b.h.s<q> JFJ;
  private static final q JIH;
  private final d JFI;
  private int JFK;
  private byte JFN = -1;
  private int JFO = -1;
  public List<Integer> JGK;
  public int JGd;
  public List<a.r> JGw;
  public int JHm;
  public a.p JII;
  public int JIJ;
  public a.p JIK;
  public int JIL;
  public List<a.a> JIM;
  
  static
  {
    AppMethodBeat.i(58897);
    JFJ = new b() {};
    q localq = new q();
    JIH = localq;
    localq.fCn();
    AppMethodBeat.o(58897);
  }
  
  private a$q()
  {
    this.JFI = d.JMs;
  }
  
  /* Error */
  private a$q(d.l.b.a.b.h.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 66	d/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 83
    //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 68	d/l/b/a/b/e/a$q:JFN	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 70	d/l/b/a/b/e/a$q:JFO	I
    //   19: aload_0
    //   20: invokespecial 61	d/l/b/a/b/e/a$q:fCn	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 87	d/l/b/a/b/h/d:fHp	()Ld/l/b/a/b/h/d$b;
    //   28: astore 10
    //   30: aload 10
    //   32: iconst_1
    //   33: invokestatic 93	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
    //   36: astore 11
    //   38: iconst_0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +1042 -> 1085
    //   46: iload_3
    //   47: istore 4
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 99	d/l/b/a/b/h/e:xR	()I
    //   59: istore 7
    //   61: iload 7
    //   63: lookupswitch	default:+1200->1263, 0:+1203->1266, 8:+125->188, 16:+277->340, 26:+357->420, 34:+428->491, 40:+553->616, 50:+593->656, 56:+721->784, 66:+761->824, 248:+838->901, 250:+914->977
    //   161: istore 4
    //   163: iload_3
    //   164: istore 5
    //   166: iload_3
    //   167: istore 6
    //   169: aload_0
    //   170: aload_1
    //   171: aload 11
    //   173: aload_2
    //   174: iload 7
    //   176: invokevirtual 102	d/l/b/a/b/e/a$q:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
    //   179: ifne +1081 -> 1260
    //   182: iconst_1
    //   183: istore 8
    //   185: goto -144 -> 41
    //   188: iload_3
    //   189: istore 4
    //   191: iload_3
    //   192: istore 5
    //   194: iload_3
    //   195: istore 6
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   202: iconst_1
    //   203: ior
    //   204: putfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   207: iload_3
    //   208: istore 4
    //   210: iload_3
    //   211: istore 5
    //   213: iload_3
    //   214: istore 6
    //   216: aload_0
    //   217: aload_1
    //   218: invokevirtual 107	d/l/b/a/b/h/e:xS	()I
    //   221: putfield 109	d/l/b/a/b/e/a$q:JGd	I
    //   224: goto -183 -> 41
    //   227: astore_1
    //   228: iload 4
    //   230: istore_3
    //   231: aload_1
    //   232: aload_0
    //   233: putfield 113	d/l/b/a/b/h/k:JNa	Ld/l/b/a/b/h/q;
    //   236: iload 4
    //   238: istore_3
    //   239: ldc 83
    //   241: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: iload 4
    //   246: istore_3
    //   247: aload_1
    //   248: athrow
    //   249: astore_1
    //   250: iload_3
    //   251: iconst_4
    //   252: iand
    //   253: iconst_4
    //   254: if_icmpne +14 -> 268
    //   257: aload_0
    //   258: aload_0
    //   259: getfield 115	d/l/b/a/b/e/a$q:JGw	Ljava/util/List;
    //   262: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   265: putfield 115	d/l/b/a/b/e/a$q:JGw	Ljava/util/List;
    //   268: iload_3
    //   269: sipush 128
    //   272: iand
    //   273: sipush 128
    //   276: if_icmpne +14 -> 290
    //   279: aload_0
    //   280: aload_0
    //   281: getfield 123	d/l/b/a/b/e/a$q:JIM	Ljava/util/List;
    //   284: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   287: putfield 123	d/l/b/a/b/e/a$q:JIM	Ljava/util/List;
    //   290: iload_3
    //   291: sipush 256
    //   294: iand
    //   295: sipush 256
    //   298: if_icmpne +14 -> 312
    //   301: aload_0
    //   302: aload_0
    //   303: getfield 125	d/l/b/a/b/e/a$q:JGK	Ljava/util/List;
    //   306: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   309: putfield 125	d/l/b/a/b/e/a$q:JGK	Ljava/util/List;
    //   312: aload 11
    //   314: invokevirtual 128	d/l/b/a/b/h/f:flush	()V
    //   317: aload_0
    //   318: aload 10
    //   320: invokevirtual 134	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   323: putfield 77	d/l/b/a/b/e/a$q:JFI	Ld/l/b/a/b/h/d;
    //   326: aload_0
    //   327: getfield 138	d/l/b/a/b/h/i$c:JMK	Ld/l/b/a/b/h/h;
    //   330: invokevirtual 143	d/l/b/a/b/h/h:fHF	()V
    //   333: ldc 83
    //   335: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_1
    //   339: athrow
    //   340: iload_3
    //   341: istore 4
    //   343: iload_3
    //   344: istore 5
    //   346: iload_3
    //   347: istore 6
    //   349: aload_0
    //   350: aload_0
    //   351: getfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   354: iconst_2
    //   355: ior
    //   356: putfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   359: iload_3
    //   360: istore 4
    //   362: iload_3
    //   363: istore 5
    //   365: iload_3
    //   366: istore 6
    //   368: aload_0
    //   369: aload_1
    //   370: invokevirtual 107	d/l/b/a/b/h/e:xS	()I
    //   373: putfield 145	d/l/b/a/b/e/a$q:JHm	I
    //   376: goto -335 -> 41
    //   379: astore_1
    //   380: iload 5
    //   382: istore 4
    //   384: iload 4
    //   386: istore_3
    //   387: new 80	d/l/b/a/b/h/k
    //   390: dup
    //   391: aload_1
    //   392: invokevirtual 149	java/io/IOException:getMessage	()Ljava/lang/String;
    //   395: invokespecial 152	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   398: astore_1
    //   399: iload 4
    //   401: istore_3
    //   402: aload_1
    //   403: aload_0
    //   404: putfield 113	d/l/b/a/b/h/k:JNa	Ld/l/b/a/b/h/q;
    //   407: iload 4
    //   409: istore_3
    //   410: ldc 83
    //   412: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   415: iload 4
    //   417: istore_3
    //   418: aload_1
    //   419: athrow
    //   420: iload_3
    //   421: istore 7
    //   423: iload_3
    //   424: iconst_4
    //   425: iand
    //   426: iconst_4
    //   427: if_icmpeq +28 -> 455
    //   430: iload_3
    //   431: istore 4
    //   433: iload_3
    //   434: istore 5
    //   436: iload_3
    //   437: istore 6
    //   439: aload_0
    //   440: new 154	java/util/ArrayList
    //   443: dup
    //   444: invokespecial 155	java/util/ArrayList:<init>	()V
    //   447: putfield 115	d/l/b/a/b/e/a$q:JGw	Ljava/util/List;
    //   450: iload_3
    //   451: iconst_4
    //   452: ior
    //   453: istore 7
    //   455: iload 7
    //   457: istore 4
    //   459: iload 7
    //   461: istore 5
    //   463: iload 7
    //   465: istore 6
    //   467: aload_0
    //   468: getfield 115	d/l/b/a/b/e/a$q:JGw	Ljava/util/List;
    //   471: aload_1
    //   472: getstatic 158	d/l/b/a/b/e/a$r:JFJ	Ld/l/b/a/b/h/s;
    //   475: aload_2
    //   476: invokevirtual 161	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   479: invokeinterface 167 2 0
    //   484: pop
    //   485: iload 7
    //   487: istore_3
    //   488: goto -447 -> 41
    //   491: iload_3
    //   492: istore 4
    //   494: iload_3
    //   495: istore 5
    //   497: iload_3
    //   498: istore 6
    //   500: aload_0
    //   501: getfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   504: iconst_4
    //   505: iand
    //   506: iconst_4
    //   507: if_icmpne +747 -> 1254
    //   510: iload_3
    //   511: istore 4
    //   513: iload_3
    //   514: istore 5
    //   516: iload_3
    //   517: istore 6
    //   519: aload_0
    //   520: getfield 169	d/l/b/a/b/e/a$q:JII	Ld/l/b/a/b/e/a$p;
    //   523: invokevirtual 175	d/l/b/a/b/e/a$p:fFd	()Ld/l/b/a/b/e/a$p$b;
    //   526: astore 9
    //   528: iload_3
    //   529: istore 4
    //   531: iload_3
    //   532: istore 5
    //   534: iload_3
    //   535: istore 6
    //   537: aload_0
    //   538: aload_1
    //   539: getstatic 176	d/l/b/a/b/e/a$p:JFJ	Ld/l/b/a/b/h/s;
    //   542: aload_2
    //   543: invokevirtual 161	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   546: checkcast 171	d/l/b/a/b/e/a$p
    //   549: putfield 169	d/l/b/a/b/e/a$q:JII	Ld/l/b/a/b/e/a$p;
    //   552: aload 9
    //   554: ifnull +40 -> 594
    //   557: iload_3
    //   558: istore 4
    //   560: iload_3
    //   561: istore 5
    //   563: iload_3
    //   564: istore 6
    //   566: aload 9
    //   568: aload_0
    //   569: getfield 169	d/l/b/a/b/e/a$q:JII	Ld/l/b/a/b/e/a$p;
    //   572: invokevirtual 182	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   575: pop
    //   576: iload_3
    //   577: istore 4
    //   579: iload_3
    //   580: istore 5
    //   582: iload_3
    //   583: istore 6
    //   585: aload_0
    //   586: aload 9
    //   588: invokevirtual 186	d/l/b/a/b/e/a$p$b:fFm	()Ld/l/b/a/b/e/a$p;
    //   591: putfield 169	d/l/b/a/b/e/a$q:JII	Ld/l/b/a/b/e/a$p;
    //   594: iload_3
    //   595: istore 4
    //   597: iload_3
    //   598: istore 5
    //   600: iload_3
    //   601: istore 6
    //   603: aload_0
    //   604: aload_0
    //   605: getfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   608: iconst_4
    //   609: ior
    //   610: putfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   613: goto -572 -> 41
    //   616: iload_3
    //   617: istore 4
    //   619: iload_3
    //   620: istore 5
    //   622: iload_3
    //   623: istore 6
    //   625: aload_0
    //   626: aload_0
    //   627: getfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   630: bipush 8
    //   632: ior
    //   633: putfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   636: iload_3
    //   637: istore 4
    //   639: iload_3
    //   640: istore 5
    //   642: iload_3
    //   643: istore 6
    //   645: aload_0
    //   646: aload_1
    //   647: invokevirtual 107	d/l/b/a/b/h/e:xS	()I
    //   650: putfield 188	d/l/b/a/b/e/a$q:JIJ	I
    //   653: goto -612 -> 41
    //   656: iload_3
    //   657: istore 4
    //   659: iload_3
    //   660: istore 5
    //   662: iload_3
    //   663: istore 6
    //   665: aload_0
    //   666: getfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   669: bipush 16
    //   671: iand
    //   672: bipush 16
    //   674: if_icmpne +574 -> 1248
    //   677: iload_3
    //   678: istore 4
    //   680: iload_3
    //   681: istore 5
    //   683: iload_3
    //   684: istore 6
    //   686: aload_0
    //   687: getfield 190	d/l/b/a/b/e/a$q:JIK	Ld/l/b/a/b/e/a$p;
    //   690: invokevirtual 175	d/l/b/a/b/e/a$p:fFd	()Ld/l/b/a/b/e/a$p$b;
    //   693: astore 9
    //   695: iload_3
    //   696: istore 4
    //   698: iload_3
    //   699: istore 5
    //   701: iload_3
    //   702: istore 6
    //   704: aload_0
    //   705: aload_1
    //   706: getstatic 176	d/l/b/a/b/e/a$p:JFJ	Ld/l/b/a/b/h/s;
    //   709: aload_2
    //   710: invokevirtual 161	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   713: checkcast 171	d/l/b/a/b/e/a$p
    //   716: putfield 190	d/l/b/a/b/e/a$q:JIK	Ld/l/b/a/b/e/a$p;
    //   719: aload 9
    //   721: ifnull +40 -> 761
    //   724: iload_3
    //   725: istore 4
    //   727: iload_3
    //   728: istore 5
    //   730: iload_3
    //   731: istore 6
    //   733: aload 9
    //   735: aload_0
    //   736: getfield 190	d/l/b/a/b/e/a$q:JIK	Ld/l/b/a/b/e/a$p;
    //   739: invokevirtual 182	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   742: pop
    //   743: iload_3
    //   744: istore 4
    //   746: iload_3
    //   747: istore 5
    //   749: iload_3
    //   750: istore 6
    //   752: aload_0
    //   753: aload 9
    //   755: invokevirtual 186	d/l/b/a/b/e/a$p$b:fFm	()Ld/l/b/a/b/e/a$p;
    //   758: putfield 190	d/l/b/a/b/e/a$q:JIK	Ld/l/b/a/b/e/a$p;
    //   761: iload_3
    //   762: istore 4
    //   764: iload_3
    //   765: istore 5
    //   767: iload_3
    //   768: istore 6
    //   770: aload_0
    //   771: aload_0
    //   772: getfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   775: bipush 16
    //   777: ior
    //   778: putfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   781: goto -740 -> 41
    //   784: iload_3
    //   785: istore 4
    //   787: iload_3
    //   788: istore 5
    //   790: iload_3
    //   791: istore 6
    //   793: aload_0
    //   794: aload_0
    //   795: getfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   798: bipush 32
    //   800: ior
    //   801: putfield 104	d/l/b/a/b/e/a$q:JFK	I
    //   804: iload_3
    //   805: istore 4
    //   807: iload_3
    //   808: istore 5
    //   810: iload_3
    //   811: istore 6
    //   813: aload_0
    //   814: aload_1
    //   815: invokevirtual 107	d/l/b/a/b/h/e:xS	()I
    //   818: putfield 192	d/l/b/a/b/e/a$q:JIL	I
    //   821: goto -780 -> 41
    //   824: iload_3
    //   825: istore 7
    //   827: iload_3
    //   828: sipush 128
    //   831: iand
    //   832: sipush 128
    //   835: if_icmpeq +30 -> 865
    //   838: iload_3
    //   839: istore 4
    //   841: iload_3
    //   842: istore 5
    //   844: iload_3
    //   845: istore 6
    //   847: aload_0
    //   848: new 154	java/util/ArrayList
    //   851: dup
    //   852: invokespecial 155	java/util/ArrayList:<init>	()V
    //   855: putfield 123	d/l/b/a/b/e/a$q:JIM	Ljava/util/List;
    //   858: iload_3
    //   859: sipush 128
    //   862: ior
    //   863: istore 7
    //   865: iload 7
    //   867: istore 4
    //   869: iload 7
    //   871: istore 5
    //   873: iload 7
    //   875: istore 6
    //   877: aload_0
    //   878: getfield 123	d/l/b/a/b/e/a$q:JIM	Ljava/util/List;
    //   881: aload_1
    //   882: getstatic 195	d/l/b/a/b/e/a$a:JFJ	Ld/l/b/a/b/h/s;
    //   885: aload_2
    //   886: invokevirtual 161	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   889: invokeinterface 167 2 0
    //   894: pop
    //   895: iload 7
    //   897: istore_3
    //   898: goto -857 -> 41
    //   901: iload_3
    //   902: istore 7
    //   904: iload_3
    //   905: sipush 256
    //   908: iand
    //   909: sipush 256
    //   912: if_icmpeq +30 -> 942
    //   915: iload_3
    //   916: istore 4
    //   918: iload_3
    //   919: istore 5
    //   921: iload_3
    //   922: istore 6
    //   924: aload_0
    //   925: new 154	java/util/ArrayList
    //   928: dup
    //   929: invokespecial 155	java/util/ArrayList:<init>	()V
    //   932: putfield 125	d/l/b/a/b/e/a$q:JGK	Ljava/util/List;
    //   935: iload_3
    //   936: sipush 256
    //   939: ior
    //   940: istore 7
    //   942: iload 7
    //   944: istore 4
    //   946: iload 7
    //   948: istore 5
    //   950: iload 7
    //   952: istore 6
    //   954: aload_0
    //   955: getfield 125	d/l/b/a/b/e/a$q:JGK	Ljava/util/List;
    //   958: aload_1
    //   959: invokevirtual 107	d/l/b/a/b/h/e:xS	()I
    //   962: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   965: invokeinterface 167 2 0
    //   970: pop
    //   971: iload 7
    //   973: istore_3
    //   974: goto -933 -> 41
    //   977: iload_3
    //   978: istore 4
    //   980: iload_3
    //   981: istore 5
    //   983: iload_3
    //   984: istore 6
    //   986: aload_1
    //   987: aload_1
    //   988: invokevirtual 107	d/l/b/a/b/h/e:xS	()I
    //   991: invokevirtual 205	d/l/b/a/b/h/e:fR	(I)I
    //   994: istore 7
    //   996: iload_3
    //   997: sipush 256
    //   1000: iand
    //   1001: sipush 256
    //   1004: if_icmpeq +241 -> 1245
    //   1007: iload_3
    //   1008: istore 4
    //   1010: iload_3
    //   1011: istore 5
    //   1013: iload_3
    //   1014: istore 6
    //   1016: aload_1
    //   1017: invokevirtual 208	d/l/b/a/b/h/e:xV	()I
    //   1020: ifle +225 -> 1245
    //   1023: iload_3
    //   1024: istore 4
    //   1026: iload_3
    //   1027: istore 5
    //   1029: iload_3
    //   1030: istore 6
    //   1032: aload_0
    //   1033: new 154	java/util/ArrayList
    //   1036: dup
    //   1037: invokespecial 155	java/util/ArrayList:<init>	()V
    //   1040: putfield 125	d/l/b/a/b/e/a$q:JGK	Ljava/util/List;
    //   1043: iload_3
    //   1044: sipush 256
    //   1047: ior
    //   1048: istore_3
    //   1049: aload_1
    //   1050: invokevirtual 208	d/l/b/a/b/h/e:xV	()I
    //   1053: ifle +23 -> 1076
    //   1056: aload_0
    //   1057: getfield 125	d/l/b/a/b/e/a$q:JGK	Ljava/util/List;
    //   1060: aload_1
    //   1061: invokevirtual 107	d/l/b/a/b/h/e:xS	()I
    //   1064: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1067: invokeinterface 167 2 0
    //   1072: pop
    //   1073: goto -24 -> 1049
    //   1076: aload_1
    //   1077: iload 7
    //   1079: invokevirtual 211	d/l/b/a/b/h/e:fS	(I)V
    //   1082: goto -1041 -> 41
    //   1085: iload_3
    //   1086: iconst_4
    //   1087: iand
    //   1088: iconst_4
    //   1089: if_icmpne +14 -> 1103
    //   1092: aload_0
    //   1093: aload_0
    //   1094: getfield 115	d/l/b/a/b/e/a$q:JGw	Ljava/util/List;
    //   1097: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1100: putfield 115	d/l/b/a/b/e/a$q:JGw	Ljava/util/List;
    //   1103: iload_3
    //   1104: sipush 128
    //   1107: iand
    //   1108: sipush 128
    //   1111: if_icmpne +14 -> 1125
    //   1114: aload_0
    //   1115: aload_0
    //   1116: getfield 123	d/l/b/a/b/e/a$q:JIM	Ljava/util/List;
    //   1119: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1122: putfield 123	d/l/b/a/b/e/a$q:JIM	Ljava/util/List;
    //   1125: iload_3
    //   1126: sipush 256
    //   1129: iand
    //   1130: sipush 256
    //   1133: if_icmpne +14 -> 1147
    //   1136: aload_0
    //   1137: aload_0
    //   1138: getfield 125	d/l/b/a/b/e/a$q:JGK	Ljava/util/List;
    //   1141: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1144: putfield 125	d/l/b/a/b/e/a$q:JGK	Ljava/util/List;
    //   1147: aload 11
    //   1149: invokevirtual 128	d/l/b/a/b/h/f:flush	()V
    //   1152: aload_0
    //   1153: aload 10
    //   1155: invokevirtual 134	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   1158: putfield 77	d/l/b/a/b/e/a$q:JFI	Ld/l/b/a/b/h/d;
    //   1161: aload_0
    //   1162: getfield 138	d/l/b/a/b/h/i$c:JMK	Ld/l/b/a/b/h/h;
    //   1165: invokevirtual 143	d/l/b/a/b/h/h:fHF	()V
    //   1168: ldc 83
    //   1170: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1173: return
    //   1174: astore_1
    //   1175: aload_0
    //   1176: aload 10
    //   1178: invokevirtual 134	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   1181: putfield 77	d/l/b/a/b/e/a$q:JFI	Ld/l/b/a/b/h/d;
    //   1184: goto -23 -> 1161
    //   1187: astore_1
    //   1188: aload_0
    //   1189: aload 10
    //   1191: invokevirtual 134	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   1194: putfield 77	d/l/b/a/b/e/a$q:JFI	Ld/l/b/a/b/h/d;
    //   1197: ldc 83
    //   1199: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1202: aload_1
    //   1203: athrow
    //   1204: astore_2
    //   1205: aload_0
    //   1206: aload 10
    //   1208: invokevirtual 134	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   1211: putfield 77	d/l/b/a/b/e/a$q:JFI	Ld/l/b/a/b/h/d;
    //   1214: goto -888 -> 326
    //   1217: astore_1
    //   1218: aload_0
    //   1219: aload 10
    //   1221: invokevirtual 134	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   1224: putfield 77	d/l/b/a/b/e/a$q:JFI	Ld/l/b/a/b/h/d;
    //   1227: ldc 83
    //   1229: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1232: aload_1
    //   1233: athrow
    //   1234: astore_1
    //   1235: goto -985 -> 250
    //   1238: astore_1
    //   1239: iload_3
    //   1240: istore 4
    //   1242: goto -858 -> 384
    //   1245: goto -196 -> 1049
    //   1248: aconst_null
    //   1249: astore 9
    //   1251: goto -556 -> 695
    //   1254: aconst_null
    //   1255: astore 9
    //   1257: goto -729 -> 528
    //   1260: goto -178 -> 1082
    //   1263: goto -1103 -> 160
    //   1266: iconst_1
    //   1267: istore 8
    //   1269: goto -1228 -> 41
    //   1272: astore_1
    //   1273: iload 6
    //   1275: istore_3
    //   1276: goto -1026 -> 250
    //   1279: astore_1
    //   1280: iload_3
    //   1281: istore 4
    //   1283: goto -1055 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1286	0	this	q
    //   0	1286	1	parame	d.l.b.a.b.h.e
    //   0	1286	2	paramg	g
    //   24	1257	3	i	int
    //   47	1235	4	j	int
    //   50	978	5	k	int
    //   53	1221	6	m	int
    //   59	1019	7	n	int
    //   39	1229	8	i1	int
    //   526	730	9	localb	a.p.b
    //   28	1192	10	localb1	d.l.b.a.b.h.d.b
    //   36	1112	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	227	d/l/b/a/b/h/k
    //   169	182	227	d/l/b/a/b/h/k
    //   197	207	227	d/l/b/a/b/h/k
    //   216	224	227	d/l/b/a/b/h/k
    //   349	359	227	d/l/b/a/b/h/k
    //   368	376	227	d/l/b/a/b/h/k
    //   439	450	227	d/l/b/a/b/h/k
    //   467	485	227	d/l/b/a/b/h/k
    //   500	510	227	d/l/b/a/b/h/k
    //   519	528	227	d/l/b/a/b/h/k
    //   537	552	227	d/l/b/a/b/h/k
    //   566	576	227	d/l/b/a/b/h/k
    //   585	594	227	d/l/b/a/b/h/k
    //   603	613	227	d/l/b/a/b/h/k
    //   625	636	227	d/l/b/a/b/h/k
    //   645	653	227	d/l/b/a/b/h/k
    //   665	677	227	d/l/b/a/b/h/k
    //   686	695	227	d/l/b/a/b/h/k
    //   704	719	227	d/l/b/a/b/h/k
    //   733	743	227	d/l/b/a/b/h/k
    //   752	761	227	d/l/b/a/b/h/k
    //   770	781	227	d/l/b/a/b/h/k
    //   793	804	227	d/l/b/a/b/h/k
    //   813	821	227	d/l/b/a/b/h/k
    //   847	858	227	d/l/b/a/b/h/k
    //   877	895	227	d/l/b/a/b/h/k
    //   924	935	227	d/l/b/a/b/h/k
    //   954	971	227	d/l/b/a/b/h/k
    //   986	996	227	d/l/b/a/b/h/k
    //   1016	1023	227	d/l/b/a/b/h/k
    //   1032	1043	227	d/l/b/a/b/h/k
    //   231	236	249	finally
    //   239	244	249	finally
    //   247	249	249	finally
    //   387	399	249	finally
    //   402	407	249	finally
    //   410	415	249	finally
    //   418	420	249	finally
    //   55	61	379	java/io/IOException
    //   169	182	379	java/io/IOException
    //   197	207	379	java/io/IOException
    //   216	224	379	java/io/IOException
    //   349	359	379	java/io/IOException
    //   368	376	379	java/io/IOException
    //   439	450	379	java/io/IOException
    //   467	485	379	java/io/IOException
    //   500	510	379	java/io/IOException
    //   519	528	379	java/io/IOException
    //   537	552	379	java/io/IOException
    //   566	576	379	java/io/IOException
    //   585	594	379	java/io/IOException
    //   603	613	379	java/io/IOException
    //   625	636	379	java/io/IOException
    //   645	653	379	java/io/IOException
    //   665	677	379	java/io/IOException
    //   686	695	379	java/io/IOException
    //   704	719	379	java/io/IOException
    //   733	743	379	java/io/IOException
    //   752	761	379	java/io/IOException
    //   770	781	379	java/io/IOException
    //   793	804	379	java/io/IOException
    //   813	821	379	java/io/IOException
    //   847	858	379	java/io/IOException
    //   877	895	379	java/io/IOException
    //   924	935	379	java/io/IOException
    //   954	971	379	java/io/IOException
    //   986	996	379	java/io/IOException
    //   1016	1023	379	java/io/IOException
    //   1032	1043	379	java/io/IOException
    //   1147	1152	1174	java/io/IOException
    //   1147	1152	1187	finally
    //   312	317	1204	java/io/IOException
    //   312	317	1217	finally
    //   1049	1073	1234	finally
    //   1076	1082	1234	finally
    //   1049	1073	1238	java/io/IOException
    //   1076	1082	1238	java/io/IOException
    //   55	61	1272	finally
    //   169	182	1272	finally
    //   197	207	1272	finally
    //   216	224	1272	finally
    //   349	359	1272	finally
    //   368	376	1272	finally
    //   439	450	1272	finally
    //   467	485	1272	finally
    //   500	510	1272	finally
    //   519	528	1272	finally
    //   537	552	1272	finally
    //   566	576	1272	finally
    //   585	594	1272	finally
    //   603	613	1272	finally
    //   625	636	1272	finally
    //   645	653	1272	finally
    //   665	677	1272	finally
    //   686	695	1272	finally
    //   704	719	1272	finally
    //   733	743	1272	finally
    //   752	761	1272	finally
    //   770	781	1272	finally
    //   793	804	1272	finally
    //   813	821	1272	finally
    //   847	858	1272	finally
    //   877	895	1272	finally
    //   924	935	1272	finally
    //   954	971	1272	finally
    //   986	996	1272	finally
    //   1016	1023	1272	finally
    //   1032	1043	1272	finally
    //   1049	1073	1279	d/l/b/a/b/h/k
    //   1076	1082	1279	d/l/b/a/b/h/k
  }
  
  private a$q(i.b<q, ?> paramb)
  {
    super(paramb);
    this.JFI = paramb.JFI;
  }
  
  public static q e(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(58894);
    paramInputStream = (q)JFJ.i(paramInputStream, paramg);
    AppMethodBeat.o(58894);
    return paramInputStream;
  }
  
  private void fCn()
  {
    AppMethodBeat.i(58890);
    this.JGd = 6;
    this.JHm = 0;
    this.JGw = Collections.emptyList();
    this.JII = a.p.fEQ();
    this.JIJ = 0;
    this.JIK = a.p.fEQ();
    this.JIL = 0;
    this.JIM = Collections.emptyList();
    this.JGK = Collections.emptyList();
    AppMethodBeat.o(58890);
  }
  
  public static q fFo()
  {
    return JIH;
  }
  
  public final void a(f paramf)
  {
    int k = 0;
    AppMethodBeat.i(58892);
    yf();
    i.c.a locala = fHM();
    if ((this.JFK & 0x1) == 1) {
      paramf.by(1, this.JGd);
    }
    if ((this.JFK & 0x2) == 2) {
      paramf.by(2, this.JHm);
    }
    int i = 0;
    while (i < this.JGw.size())
    {
      paramf.a(3, (q)this.JGw.get(i));
      i += 1;
    }
    if ((this.JFK & 0x4) == 4) {
      paramf.a(4, this.JII);
    }
    if ((this.JFK & 0x8) == 8) {
      paramf.by(5, this.JIJ);
    }
    if ((this.JFK & 0x10) == 16) {
      paramf.a(6, this.JIK);
    }
    if ((this.JFK & 0x20) == 32) {
      paramf.by(7, this.JIL);
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.JIM.size()) {
        break;
      }
      paramf.a(8, (q)this.JIM.get(i));
      i += 1;
    }
    while (j < this.JGK.size())
    {
      paramf.by(31, ((Integer)this.JGK.get(j)).intValue());
      j += 1;
    }
    locala.b(200, paramf);
    paramf.e(this.JFI);
    AppMethodBeat.o(58892);
  }
  
  public final boolean fCL()
  {
    return (this.JFK & 0x1) == 1;
  }
  
  public final d.l.b.a.b.h.s<q> fCl()
  {
    return JFJ;
  }
  
  public final boolean fDI()
  {
    return (this.JFK & 0x2) == 2;
  }
  
  public final boolean fFp()
  {
    return (this.JFK & 0x4) == 4;
  }
  
  public final boolean fFq()
  {
    return (this.JFK & 0x8) == 8;
  }
  
  public final boolean fFr()
  {
    return (this.JFK & 0x10) == 16;
  }
  
  public final boolean fFs()
  {
    return (this.JFK & 0x20) == 32;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58891);
    int i = this.JFN;
    if (i == 1)
    {
      AppMethodBeat.o(58891);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58891);
      return false;
    }
    if (!fDI())
    {
      this.JFN = 0;
      AppMethodBeat.o(58891);
      return false;
    }
    i = 0;
    while (i < this.JGw.size())
    {
      if (!((a.r)this.JGw.get(i)).isInitialized())
      {
        this.JFN = 0;
        AppMethodBeat.o(58891);
        return false;
      }
      i += 1;
    }
    if ((fFp()) && (!this.JII.isInitialized()))
    {
      this.JFN = 0;
      AppMethodBeat.o(58891);
      return false;
    }
    if ((fFr()) && (!this.JIK.isInitialized()))
    {
      this.JFN = 0;
      AppMethodBeat.o(58891);
      return false;
    }
    i = 0;
    while (i < this.JIM.size())
    {
      if (!((a.a)this.JIM.get(i)).isInitialized())
      {
        this.JFN = 0;
        AppMethodBeat.o(58891);
        return false;
      }
      i += 1;
    }
    if (!this.JMK.isInitialized())
    {
      this.JFN = 0;
      AppMethodBeat.o(58891);
      return false;
    }
    this.JFN = 1;
    AppMethodBeat.o(58891);
    return true;
  }
  
  public final int yf()
  {
    AppMethodBeat.i(58893);
    int i = this.JFO;
    if (i != -1)
    {
      AppMethodBeat.o(58893);
      return i;
    }
    if ((this.JFK & 0x1) == 1) {}
    for (int j = f.bA(1, this.JGd) + 0;; j = 0)
    {
      i = j;
      if ((this.JFK & 0x2) == 2) {
        i = j + f.bA(2, this.JHm);
      }
      j = 0;
      while (j < this.JGw.size())
      {
        i += f.c(3, (q)this.JGw.get(j));
        j += 1;
      }
      j = i;
      if ((this.JFK & 0x4) == 4) {
        j = i + f.c(4, this.JII);
      }
      i = j;
      if ((this.JFK & 0x8) == 8) {
        i = j + f.bA(5, this.JIJ);
      }
      j = i;
      if ((this.JFK & 0x10) == 16) {
        j = i + f.c(6, this.JIK);
      }
      i = j;
      if ((this.JFK & 0x20) == 32) {
        i = j + f.bA(7, this.JIL);
      }
      j = 0;
      while (j < this.JIM.size())
      {
        i += f.c(8, (q)this.JIM.get(j));
        j += 1;
      }
      int k = 0;
      int m;
      for (j = 0; k < this.JGK.size(); j = m + j)
      {
        m = f.fW(((Integer)this.JGK.get(k)).intValue());
        k += 1;
      }
      i = i + j + this.JGK.size() * 2 + this.JMK.yf() + this.JFI.size();
      this.JFO = i;
      AppMethodBeat.o(58893);
      return i;
    }
  }
  
  public static final class a
    extends i.b<a.q, a>
    implements s
  {
    private int JFK;
    private List<Integer> JGK;
    private int JGd;
    private List<a.r> JGw;
    private int JHm;
    private a.p JII;
    private int JIJ;
    private a.p JIK;
    private int JIL;
    private List<a.a> JIM;
    
    private a()
    {
      AppMethodBeat.i(58867);
      this.JGd = 6;
      this.JGw = Collections.emptyList();
      this.JII = a.p.fEQ();
      this.JIK = a.p.fEQ();
      this.JIM = Collections.emptyList();
      this.JGK = Collections.emptyList();
      AppMethodBeat.o(58867);
    }
    
    private a aeU(int paramInt)
    {
      this.JFK |= 0x1;
      this.JGd = paramInt;
      return this;
    }
    
    private a aeV(int paramInt)
    {
      this.JFK |= 0x2;
      this.JHm = paramInt;
      return this;
    }
    
    private a aeW(int paramInt)
    {
      this.JFK |= 0x10;
      this.JIJ = paramInt;
      return this;
    }
    
    private a aeX(int paramInt)
    {
      this.JFK |= 0x40;
      this.JIL = paramInt;
      return this;
    }
    
    private void fDb()
    {
      AppMethodBeat.i(58873);
      if ((this.JFK & 0x4) != 4)
      {
        this.JGw = new ArrayList(this.JGw);
        this.JFK |= 0x4;
      }
      AppMethodBeat.o(58873);
    }
    
    private void fDl()
    {
      AppMethodBeat.i(58877);
      if ((this.JFK & 0x100) != 256)
      {
        this.JGK = new ArrayList(this.JGK);
        this.JFK |= 0x100;
      }
      AppMethodBeat.o(58877);
    }
    
    private a fFt()
    {
      AppMethodBeat.i(58868);
      a locala = new a().e(fFu());
      AppMethodBeat.o(58868);
      return locala;
    }
    
    private a.q fFu()
    {
      int j = 1;
      AppMethodBeat.i(58869);
      a.q localq = new a.q(this, (byte)0);
      int k = this.JFK;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.q.a(localq, this.JGd);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.q.b(localq, this.JHm);
        if ((this.JFK & 0x4) == 4)
        {
          this.JGw = Collections.unmodifiableList(this.JGw);
          this.JFK &= 0xFFFFFFFB;
        }
        a.q.a(localq, this.JGw);
        j = i;
        if ((k & 0x8) == 8) {
          j = i | 0x4;
        }
        a.q.a(localq, this.JII);
        i = j;
        if ((k & 0x10) == 16) {
          i = j | 0x8;
        }
        a.q.c(localq, this.JIJ);
        j = i;
        if ((k & 0x20) == 32) {
          j = i | 0x10;
        }
        a.q.b(localq, this.JIK);
        i = j;
        if ((k & 0x40) == 64) {
          i = j | 0x20;
        }
        a.q.d(localq, this.JIL);
        if ((this.JFK & 0x80) == 128)
        {
          this.JIM = Collections.unmodifiableList(this.JIM);
          this.JFK &= 0xFFFFFF7F;
        }
        a.q.b(localq, this.JIM);
        if ((this.JFK & 0x100) == 256)
        {
          this.JGK = Collections.unmodifiableList(this.JGK);
          this.JFK &= 0xFFFFFEFF;
        }
        a.q.c(localq, this.JGK);
        a.q.e(localq, i);
        AppMethodBeat.o(58869);
        return localq;
        j = 0;
      }
    }
    
    private void fFv()
    {
      AppMethodBeat.i(58876);
      if ((this.JFK & 0x80) != 128)
      {
        this.JIM = new ArrayList(this.JIM);
        this.JFK |= 0x80;
      }
      AppMethodBeat.o(58876);
    }
    
    private a n(a.p paramp)
    {
      AppMethodBeat.i(58874);
      if (((this.JFK & 0x8) == 8) && (this.JII != a.p.fEQ())) {}
      for (this.JII = a.p.f(this.JII).j(paramp).fFm();; this.JII = paramp)
      {
        this.JFK |= 0x8;
        AppMethodBeat.o(58874);
        return this;
      }
    }
    
    private a o(a.p paramp)
    {
      AppMethodBeat.i(58875);
      if (((this.JFK & 0x20) == 32) && (this.JIK != a.p.fEQ())) {}
      for (this.JIK = a.p.f(this.JIK).j(paramp).fFm();; this.JIK = paramp)
      {
        this.JFK |= 0x20;
        AppMethodBeat.o(58875);
        return this;
      }
    }
    
    /* Error */
    private a v(d.l.b.a.b.h.e parame, g paramg)
    {
      // Byte code:
      //   0: ldc 161
      //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 165	d/l/b/a/b/e/a$q:JFJ	Ld/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 170 3 0
      //   17: checkcast 9	d/l/b/a/b/e/a$q
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 102	d/l/b/a/b/e/a$q$a:e	(Ld/l/b/a/b/e/a$q;)Ld/l/b/a/b/e/a$q$a;
      //   26: pop
      //   27: ldc 161
      //   29: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 174	d/l/b/a/b/h/k:JNa	Ld/l/b/a/b/h/q;
      //   39: checkcast 9	d/l/b/a/b/e/a$q
      //   42: astore_2
      //   43: ldc 161
      //   45: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 102	d/l/b/a/b/e/a$q$a:e	(Ld/l/b/a/b/e/a$q;)Ld/l/b/a/b/e/a$q$a;
      //   60: pop
      //   61: ldc 161
      //   63: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: aload_1
      //   67: athrow
      //   68: astore_1
      //   69: aload_3
      //   70: astore_2
      //   71: goto -20 -> 51
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	a
      //   0	74	1	parame	d.l.b.a.b.h.e
      //   0	74	2	paramg	g
      //   6	64	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	d/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a e(a.q paramq)
    {
      AppMethodBeat.i(58870);
      if (paramq == a.q.fFo())
      {
        AppMethodBeat.o(58870);
        return this;
      }
      if (paramq.fCL()) {
        aeU(paramq.JGd);
      }
      if (paramq.fDI()) {
        aeV(paramq.JHm);
      }
      if (!a.q.a(paramq).isEmpty())
      {
        if (this.JGw.isEmpty())
        {
          this.JGw = a.q.a(paramq);
          this.JFK &= 0xFFFFFFFB;
        }
      }
      else
      {
        if (paramq.fFp()) {
          n(paramq.JII);
        }
        if (paramq.fFq()) {
          aeW(paramq.JIJ);
        }
        if (paramq.fFr()) {
          o(paramq.JIK);
        }
        if (paramq.fFs()) {
          aeX(paramq.JIL);
        }
        if (!a.q.b(paramq).isEmpty())
        {
          if (!this.JIM.isEmpty()) {
            break label294;
          }
          this.JIM = a.q.b(paramq);
          this.JFK &= 0xFFFFFF7F;
        }
        label202:
        if (!a.q.c(paramq).isEmpty())
        {
          if (!this.JGK.isEmpty()) {
            break label315;
          }
          this.JGK = a.q.c(paramq);
          this.JFK &= 0xFFFFFEFF;
        }
      }
      for (;;)
      {
        a(paramq);
        this.JFI = this.JFI.a(a.q.d(paramq));
        AppMethodBeat.o(58870);
        return this;
        fDb();
        this.JGw.addAll(a.q.a(paramq));
        break;
        label294:
        fFv();
        this.JIM.addAll(a.q.b(paramq));
        break label202;
        label315:
        fDl();
        this.JGK.addAll(a.q.c(paramq));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58871);
      if ((this.JFK & 0x2) == 2) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58871);
        return false;
      }
      i = 0;
      while (i < this.JGw.size())
      {
        if (!((a.r)this.JGw.get(i)).isInitialized())
        {
          AppMethodBeat.o(58871);
          return false;
        }
        i += 1;
      }
      if ((this.JFK & 0x8) == 8) {}
      for (i = 1; (i != 0) && (!this.JII.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58871);
        return false;
      }
      if ((this.JFK & 0x20) == 32) {}
      for (i = 1; (i != 0) && (!this.JIK.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58871);
        return false;
      }
      i = 0;
      while (i < this.JIM.size())
      {
        if (!((a.a)this.JIM.get(i)).isInitialized())
        {
          AppMethodBeat.o(58871);
          return false;
        }
        i += 1;
      }
      if (!this.JMK.isInitialized())
      {
        AppMethodBeat.o(58871);
        return false;
      }
      AppMethodBeat.o(58871);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.a.q
 * JD-Core Version:    0.7.0.1
 */