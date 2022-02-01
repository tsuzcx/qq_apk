package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.LineNumberReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CueItemParser
  extends AudioPlayListItemParser
{
  public static final String TAG = "CueItemParser";
  private LineNumberReader mReader;
  protected List<TrackInfo> mTrackInfoList;
  
  public CueItemParser(String paramString)
  {
    AppMethodBeat.i(76607);
    this.mUri = paramString;
    this.mTrackInfoList = new LinkedList();
    AppMethodBeat.o(76607);
  }
  
  private long convertTimeStrToMs(String paramString)
  {
    AppMethodBeat.i(76608);
    paramString = paramString.split(":");
    long l1 = Long.parseLong(paramString[0]);
    long l2 = Long.parseLong(paramString[1]);
    long l3 = Long.parseLong(paramString[2]);
    AppMethodBeat.o(76608);
    return l3 * 10L + (l1 * 60L + l2) * 1000L;
  }
  
  private String guessCharsetEncoding(String paramString)
  {
    AppMethodBeat.i(76611);
    Logger.i("CueItemParser", "CueItemParser.guessCharsetEncoding, filePath: ".concat(String.valueOf(paramString)));
    paramString = guessCharsetEncoding(new FileInputStream(paramString));
    AppMethodBeat.o(76611);
    return paramString;
  }
  
  public boolean isParseSuccess()
  {
    AppMethodBeat.i(76610);
    if (!this.mTrackInfoList.isEmpty())
    {
      AppMethodBeat.o(76610);
      return true;
    }
    AppMethodBeat.o(76610);
    return false;
  }
  
  public Iterator<TrackInfo> iterator()
  {
    AppMethodBeat.i(76609);
    Iterator localIterator = this.mTrackInfoList.iterator();
    AppMethodBeat.o(76609);
    return localIterator;
  }
  
  /* Error */
  public void parse()
  {
    // Byte code:
    //   0: ldc 104
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 8
    //   7: new 106	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 108
    //   13: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 28	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   20: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 76	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: new 119	java/io/File
    //   32: dup
    //   33: aload_0
    //   34: getfield 28	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   37: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore 17
    //   42: aconst_null
    //   43: astore 12
    //   45: aconst_null
    //   46: astore 14
    //   48: aconst_null
    //   49: astore 15
    //   51: iconst_0
    //   52: istore_2
    //   53: iconst_0
    //   54: istore 6
    //   56: lconst_0
    //   57: lstore 7
    //   59: iconst_0
    //   60: istore_3
    //   61: aconst_null
    //   62: astore 11
    //   64: aload_0
    //   65: getfield 33	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   68: invokeinterface 123 1 0
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 28	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   78: invokespecial 125	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:guessCharsetEncoding	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 13
    //   83: aload_0
    //   84: new 127	java/io/LineNumberReader
    //   87: dup
    //   88: new 129	java/io/InputStreamReader
    //   91: dup
    //   92: new 78	java/io/FileInputStream
    //   95: dup
    //   96: aload 17
    //   98: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   101: aload 13
    //   103: invokespecial 135	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   106: invokespecial 138	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   109: putfield 140	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   112: iconst_0
    //   113: istore_1
    //   114: iconst_0
    //   115: istore 4
    //   117: iload 4
    //   119: istore_3
    //   120: aload_0
    //   121: getfield 140	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   124: invokevirtual 143	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   127: astore 18
    //   129: iload 4
    //   131: istore_3
    //   132: aload_0
    //   133: getfield 140	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   136: invokevirtual 147	java/io/LineNumberReader:getLineNumber	()I
    //   139: istore 5
    //   141: iload 5
    //   143: istore_3
    //   144: aload 18
    //   146: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +1017 -> 1166
    //   152: aload 14
    //   154: astore 13
    //   156: iload_2
    //   157: ifne +36 -> 193
    //   160: aload 14
    //   162: astore 13
    //   164: iload 5
    //   166: istore_3
    //   167: aload 18
    //   169: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   172: invokevirtual 158	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   175: ldc 160
    //   177: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   180: ifeq +13 -> 193
    //   183: iload 5
    //   185: istore_3
    //   186: aload 18
    //   188: invokestatic 167	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   191: astore 13
    //   193: aload 12
    //   195: astore 14
    //   197: iload_2
    //   198: ifne +36 -> 234
    //   201: aload 12
    //   203: astore 14
    //   205: iload 5
    //   207: istore_3
    //   208: aload 18
    //   210: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   213: invokevirtual 158	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   216: ldc 169
    //   218: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   221: ifeq +13 -> 234
    //   224: iload 5
    //   226: istore_3
    //   227: aload 18
    //   229: invokestatic 167	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 14
    //   234: iload 5
    //   236: istore_3
    //   237: iload_2
    //   238: istore 4
    //   240: lload 7
    //   242: lstore 9
    //   244: aload 18
    //   246: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   249: invokevirtual 158	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   252: ldc 171
    //   254: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   257: ifeq +314 -> 571
    //   260: iload_2
    //   261: istore 4
    //   263: iload_2
    //   264: ifeq +6 -> 270
    //   267: iconst_0
    //   268: istore 4
    //   270: lload 7
    //   272: lconst_0
    //   273: lcmp
    //   274: ifeq +18 -> 292
    //   277: aload 11
    //   279: ifnull +13 -> 292
    //   282: iload 5
    //   284: istore_3
    //   285: aload 11
    //   287: lload 7
    //   289: invokevirtual 177	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   292: iload 5
    //   294: istore_3
    //   295: aload 18
    //   297: invokestatic 167	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   300: astore 16
    //   302: iload 5
    //   304: istore_3
    //   305: aload 17
    //   307: invokevirtual 180	java/io/File:getParent	()Ljava/lang/String;
    //   310: astore 15
    //   312: aload 15
    //   314: astore 12
    //   316: iload 5
    //   318: istore_3
    //   319: aload 15
    //   321: ldc 182
    //   323: invokevirtual 185	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   326: ifne +28 -> 354
    //   329: iload 5
    //   331: istore_3
    //   332: new 106	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   339: aload 15
    //   341: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc 182
    //   346: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: astore 12
    //   354: aload 16
    //   356: astore 15
    //   358: iload 5
    //   360: istore_3
    //   361: aload 16
    //   363: ldc 182
    //   365: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   368: ifeq +14 -> 382
    //   371: iload 5
    //   373: istore_3
    //   374: aload 16
    //   376: iconst_1
    //   377: invokevirtual 190	java/lang/String:substring	(I)Ljava/lang/String;
    //   380: astore 15
    //   382: iload 5
    //   384: istore_3
    //   385: new 106	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   392: aload 12
    //   394: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 15
    //   399: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: astore 15
    //   407: iload 5
    //   409: istore_3
    //   410: new 119	java/io/File
    //   413: dup
    //   414: aload 15
    //   416: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   419: invokevirtual 193	java/io/File:exists	()Z
    //   422: ifne +89 -> 511
    //   425: iload 5
    //   427: istore_3
    //   428: new 101	java/io/IOException
    //   431: dup
    //   432: new 106	java/lang/StringBuilder
    //   435: dup
    //   436: ldc 195
    //   438: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   441: aload_0
    //   442: getfield 28	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   445: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokespecial 196	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   454: astore 11
    //   456: iload 5
    //   458: istore_3
    //   459: ldc 104
    //   461: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   464: iload 5
    //   466: istore_3
    //   467: aload 11
    //   469: athrow
    //   470: astore 11
    //   472: new 198	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/ParseException
    //   475: dup
    //   476: ldc 200
    //   478: aload 11
    //   480: iload_3
    //   481: invokespecial 203	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/ParseException:<init>	(Ljava/lang/String;Ljava/lang/Exception;I)V
    //   484: astore 11
    //   486: ldc 104
    //   488: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   491: aload 11
    //   493: athrow
    //   494: astore 11
    //   496: aload_0
    //   497: getfield 140	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   500: invokevirtual 206	java/io/LineNumberReader:close	()V
    //   503: ldc 104
    //   505: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   508: aload 11
    //   510: athrow
    //   511: iload 5
    //   513: istore_3
    //   514: new 208	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder
    //   517: dup
    //   518: invokespecial 209	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:<init>	()V
    //   521: astore 12
    //   523: iload 5
    //   525: istore_3
    //   526: aload 12
    //   528: new 211	com/tencent/qqmusic/mediaplayer/upstream/FileDataSource
    //   531: dup
    //   532: aload 15
    //   534: invokespecial 212	com/tencent/qqmusic/mediaplayer/upstream/FileDataSource:<init>	(Ljava/lang/String;)V
    //   537: invokevirtual 216	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)I
    //   540: istore_2
    //   541: iload_2
    //   542: ifne +223 -> 765
    //   545: iload 5
    //   547: istore_3
    //   548: aload 12
    //   550: invokevirtual 220	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:getAudioInformation	()Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   553: invokevirtual 226	com/tencent/qqmusic/mediaplayer/AudioInformation:getDuration	()J
    //   556: lstore 7
    //   558: iload 5
    //   560: istore_3
    //   561: aload 12
    //   563: invokevirtual 229	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:release	()I
    //   566: pop
    //   567: lload 7
    //   569: lstore 9
    //   571: iload 5
    //   573: istore_3
    //   574: aload 18
    //   576: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   579: invokevirtual 158	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   582: ldc 231
    //   584: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   587: ifeq +837 -> 1424
    //   590: iload 5
    //   592: istore_3
    //   593: new 173	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   596: dup
    //   597: getstatic 237	com/tencent/qqmusic/mediaplayer/audioplaylist/AudioPlayListItemInfo:TYPE_CUE	I
    //   600: invokespecial 239	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:<init>	(I)V
    //   603: astore 11
    //   605: iload 5
    //   607: istore_3
    //   608: aload 11
    //   610: aload 15
    //   612: invokevirtual 242	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setFilePath	(Ljava/lang/String;)V
    //   615: iconst_1
    //   616: istore_2
    //   617: iload 6
    //   619: iconst_1
    //   620: iadd
    //   621: istore 6
    //   623: iload_2
    //   624: ifeq +35 -> 659
    //   627: iload 5
    //   629: istore_3
    //   630: aload 18
    //   632: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   635: invokevirtual 158	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   638: ldc 169
    //   640: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   643: ifeq +16 -> 659
    //   646: iload 5
    //   648: istore_3
    //   649: aload 11
    //   651: aload 18
    //   653: invokestatic 167	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   656: invokevirtual 245	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setTitle	(Ljava/lang/String;)V
    //   659: iload_2
    //   660: ifeq +35 -> 695
    //   663: iload 5
    //   665: istore_3
    //   666: aload 18
    //   668: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   671: invokevirtual 158	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   674: ldc 160
    //   676: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   679: ifeq +16 -> 695
    //   682: iload 5
    //   684: istore_3
    //   685: aload 11
    //   687: aload 18
    //   689: invokestatic 167	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   692: invokevirtual 248	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setPerformer	(Ljava/lang/String;)V
    //   695: iload 6
    //   697: iconst_1
    //   698: if_icmpne +133 -> 831
    //   701: iload 5
    //   703: istore_3
    //   704: aload 18
    //   706: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   709: invokevirtual 158	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   712: ldc 250
    //   714: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   717: ifeq +114 -> 831
    //   720: iload 5
    //   722: istore_3
    //   723: aload 18
    //   725: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   728: ldc 252
    //   730: invokevirtual 255	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   733: ifne +71 -> 804
    //   736: iload 5
    //   738: istore_3
    //   739: new 101	java/io/IOException
    //   742: dup
    //   743: ldc_w 257
    //   746: invokespecial 196	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   749: astore 11
    //   751: iload 5
    //   753: istore_3
    //   754: ldc 104
    //   756: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   759: iload 5
    //   761: istore_3
    //   762: aload 11
    //   764: athrow
    //   765: iload 5
    //   767: istore_3
    //   768: ldc 8
    //   770: new 106	java/lang/StringBuilder
    //   773: dup
    //   774: ldc_w 259
    //   777: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   780: iload_2
    //   781: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   784: ldc_w 264
    //   787: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: aload 15
    //   792: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 267	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: goto -243 -> 558
    //   804: iload 5
    //   806: istore_3
    //   807: aload 11
    //   809: aload_0
    //   810: aload 18
    //   812: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   815: ldc 252
    //   817: invokevirtual 48	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   820: iconst_1
    //   821: aaload
    //   822: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   825: invokespecial 269	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   828: invokevirtual 272	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setStartPosition	(J)V
    //   831: iload 6
    //   833: iconst_2
    //   834: if_icmplt +596 -> 1430
    //   837: iload 5
    //   839: istore_3
    //   840: aload 18
    //   842: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   845: invokevirtual 158	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   848: ldc 250
    //   850: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   853: ifeq +577 -> 1430
    //   856: iload 5
    //   858: istore_3
    //   859: aload 18
    //   861: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   864: ldc_w 274
    //   867: invokevirtual 255	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   870: ifeq +161 -> 1031
    //   873: iload 5
    //   875: istore_3
    //   876: aload 18
    //   878: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   881: ldc_w 274
    //   884: invokevirtual 48	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   887: iconst_1
    //   888: aaload
    //   889: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   892: astore 12
    //   894: iload 5
    //   896: istore_3
    //   897: aload_0
    //   898: getfield 33	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   901: iload 6
    //   903: iconst_2
    //   904: isub
    //   905: invokeinterface 278 2 0
    //   910: checkcast 173	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   913: aload_0
    //   914: aload 12
    //   916: invokespecial 269	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   919: invokevirtual 177	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   922: iconst_1
    //   923: istore_1
    //   924: iload_1
    //   925: istore 4
    //   927: aload 11
    //   929: astore 12
    //   931: iload 6
    //   933: ifle +500 -> 1433
    //   936: iload 5
    //   938: istore_3
    //   939: iload_1
    //   940: istore 4
    //   942: aload 11
    //   944: astore 12
    //   946: aload 18
    //   948: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   951: invokevirtual 158	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   954: ldc 250
    //   956: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   959: ifeq +474 -> 1433
    //   962: iload 5
    //   964: istore_3
    //   965: iload_1
    //   966: istore 4
    //   968: aload 11
    //   970: astore 12
    //   972: aload 18
    //   974: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   977: ldc 252
    //   979: invokevirtual 255	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   982: ifeq +451 -> 1433
    //   985: iload 5
    //   987: istore_3
    //   988: aload_0
    //   989: getfield 33	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   992: aload 11
    //   994: invokeinterface 282 2 0
    //   999: pop
    //   1000: iload 5
    //   1002: istore_3
    //   1003: new 173	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   1006: dup
    //   1007: getstatic 237	com/tencent/qqmusic/mediaplayer/audioplaylist/AudioPlayListItemInfo:TYPE_CUE	I
    //   1010: invokespecial 239	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:<init>	(I)V
    //   1013: astore 12
    //   1015: iload 5
    //   1017: istore_3
    //   1018: aload 12
    //   1020: aload 15
    //   1022: invokevirtual 242	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setFilePath	(Ljava/lang/String;)V
    //   1025: iconst_0
    //   1026: istore 4
    //   1028: goto +405 -> 1433
    //   1031: iload 5
    //   1033: istore_3
    //   1034: aload 18
    //   1036: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   1039: ldc 252
    //   1041: invokevirtual 255	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1044: ifeq +72 -> 1116
    //   1047: iload 5
    //   1049: istore_3
    //   1050: aload 18
    //   1052: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   1055: ldc 252
    //   1057: invokevirtual 48	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1060: iconst_1
    //   1061: aaload
    //   1062: invokevirtual 155	java/lang/String:trim	()Ljava/lang/String;
    //   1065: astore 12
    //   1067: iload 5
    //   1069: istore_3
    //   1070: aload 11
    //   1072: aload_0
    //   1073: aload 12
    //   1075: invokespecial 269	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   1078: invokevirtual 272	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setStartPosition	(J)V
    //   1081: iload_1
    //   1082: ifne +377 -> 1459
    //   1085: iload 5
    //   1087: istore_3
    //   1088: aload_0
    //   1089: getfield 33	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1092: iload 6
    //   1094: iconst_2
    //   1095: isub
    //   1096: invokeinterface 278 2 0
    //   1101: checkcast 173	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   1104: aload_0
    //   1105: aload 12
    //   1107: invokespecial 269	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   1110: invokevirtual 177	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   1113: goto +346 -> 1459
    //   1116: iload 5
    //   1118: istore_3
    //   1119: new 101	java/io/IOException
    //   1122: dup
    //   1123: new 106	java/lang/StringBuilder
    //   1126: dup
    //   1127: ldc_w 284
    //   1130: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1133: iload 6
    //   1135: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1138: ldc_w 286
    //   1141: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1147: invokespecial 196	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1150: astore 11
    //   1152: iload 5
    //   1154: istore_3
    //   1155: ldc 104
    //   1157: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1160: iload 5
    //   1162: istore_3
    //   1163: aload 11
    //   1165: athrow
    //   1166: iload 5
    //   1168: istore_3
    //   1169: aload_0
    //   1170: getfield 33	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1173: invokeinterface 91 1 0
    //   1178: ifne +195 -> 1373
    //   1181: iload 5
    //   1183: istore_3
    //   1184: aload_0
    //   1185: getfield 33	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1188: aload_0
    //   1189: getfield 33	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1192: invokeinterface 289 1 0
    //   1197: iconst_1
    //   1198: isub
    //   1199: invokeinterface 278 2 0
    //   1204: checkcast 173	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   1207: astore 11
    //   1209: lload 7
    //   1211: lconst_0
    //   1212: lcmp
    //   1213: ifeq +249 -> 1462
    //   1216: iload 5
    //   1218: istore_3
    //   1219: aload 11
    //   1221: invokevirtual 293	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getRange	()Landroid/util/Pair;
    //   1224: ifnull +238 -> 1462
    //   1227: iload 5
    //   1229: istore_3
    //   1230: aload 11
    //   1232: invokevirtual 293	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getRange	()Landroid/util/Pair;
    //   1235: getfield 299	android/util/Pair:second	Ljava/lang/Object;
    //   1238: checkcast 50	java/lang/Long
    //   1241: invokevirtual 302	java/lang/Long:longValue	()J
    //   1244: lconst_0
    //   1245: lcmp
    //   1246: ifne +216 -> 1462
    //   1249: iload 5
    //   1251: istore_3
    //   1252: aload 11
    //   1254: lload 7
    //   1256: invokevirtual 177	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   1259: goto +203 -> 1462
    //   1262: iload 5
    //   1264: istore_3
    //   1265: iload_1
    //   1266: aload_0
    //   1267: getfield 33	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1270: invokeinterface 289 1 0
    //   1275: if_icmpge +98 -> 1373
    //   1278: iload 5
    //   1280: istore_3
    //   1281: aload_0
    //   1282: getfield 33	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1285: iload_1
    //   1286: invokeinterface 278 2 0
    //   1291: checkcast 173	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   1294: astore 11
    //   1296: iload 5
    //   1298: istore_3
    //   1299: aload 12
    //   1301: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1304: ifne +27 -> 1331
    //   1307: iload 5
    //   1309: istore_3
    //   1310: aload 11
    //   1312: invokevirtual 305	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getAlbum	()Ljava/lang/String;
    //   1315: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1318: ifeq +13 -> 1331
    //   1321: iload 5
    //   1323: istore_3
    //   1324: aload 11
    //   1326: aload 12
    //   1328: invokevirtual 308	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setAlbum	(Ljava/lang/String;)V
    //   1331: iload 5
    //   1333: istore_3
    //   1334: aload 14
    //   1336: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1339: ifne +27 -> 1366
    //   1342: iload 5
    //   1344: istore_3
    //   1345: aload 11
    //   1347: invokevirtual 311	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getPerformer	()Ljava/lang/String;
    //   1350: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1353: ifeq +13 -> 1366
    //   1356: iload 5
    //   1358: istore_3
    //   1359: aload 11
    //   1361: aload 14
    //   1363: invokevirtual 248	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setPerformer	(Ljava/lang/String;)V
    //   1366: iload_1
    //   1367: iconst_1
    //   1368: iadd
    //   1369: istore_1
    //   1370: goto -108 -> 1262
    //   1373: aload_0
    //   1374: getfield 140	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   1377: invokevirtual 206	java/io/LineNumberReader:close	()V
    //   1380: ldc 104
    //   1382: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1385: return
    //   1386: astore 11
    //   1388: ldc 8
    //   1390: ldc_w 313
    //   1393: aload 11
    //   1395: invokestatic 316	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1398: ldc 104
    //   1400: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1403: return
    //   1404: astore 12
    //   1406: ldc 8
    //   1408: ldc_w 313
    //   1411: aload 12
    //   1413: invokestatic 316	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1416: goto -913 -> 503
    //   1419: astore 11
    //   1421: goto -949 -> 472
    //   1424: iload 4
    //   1426: istore_2
    //   1427: goto -804 -> 623
    //   1430: goto -506 -> 924
    //   1433: iload 4
    //   1435: istore_1
    //   1436: aload 12
    //   1438: astore 11
    //   1440: iload 5
    //   1442: istore 4
    //   1444: lload 9
    //   1446: lstore 7
    //   1448: aload 14
    //   1450: astore 12
    //   1452: aload 13
    //   1454: astore 14
    //   1456: goto -1339 -> 117
    //   1459: goto -535 -> 924
    //   1462: iconst_0
    //   1463: istore_1
    //   1464: goto -202 -> 1262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1467	0	this	CueItemParser
    //   113	1351	1	i	int
    //   52	1375	2	j	int
    //   60	1299	3	k	int
    //   115	1328	4	m	int
    //   139	1302	5	n	int
    //   54	1080	6	i1	int
    //   57	1390	7	l1	long
    //   242	1203	9	l2	long
    //   62	406	11	localIOException1	java.io.IOException
    //   470	9	11	localIOException2	java.io.IOException
    //   484	8	11	localParseException	ParseException
    //   494	15	11	localObject1	java.lang.Object
    //   603	757	11	localObject2	java.lang.Object
    //   1386	8	11	localException1	java.lang.Exception
    //   1419	1	11	localIOException3	java.io.IOException
    //   1438	1	11	localException2	java.lang.Exception
    //   43	1284	12	localObject3	java.lang.Object
    //   1404	33	12	localException3	java.lang.Exception
    //   1450	1	12	localObject4	java.lang.Object
    //   81	1372	13	localObject5	java.lang.Object
    //   46	1409	14	localObject6	java.lang.Object
    //   49	972	15	localObject7	java.lang.Object
    //   300	75	16	str1	String
    //   40	266	17	localFile	java.io.File
    //   127	924	18	str2	String
    // Exception table:
    //   from	to	target	type
    //   120	129	470	java/io/IOException
    //   132	141	470	java/io/IOException
    //   144	152	470	java/io/IOException
    //   167	183	470	java/io/IOException
    //   186	193	470	java/io/IOException
    //   208	224	470	java/io/IOException
    //   227	234	470	java/io/IOException
    //   244	260	470	java/io/IOException
    //   285	292	470	java/io/IOException
    //   295	302	470	java/io/IOException
    //   305	312	470	java/io/IOException
    //   319	329	470	java/io/IOException
    //   332	354	470	java/io/IOException
    //   361	371	470	java/io/IOException
    //   374	382	470	java/io/IOException
    //   385	407	470	java/io/IOException
    //   410	425	470	java/io/IOException
    //   428	456	470	java/io/IOException
    //   459	464	470	java/io/IOException
    //   467	470	470	java/io/IOException
    //   514	523	470	java/io/IOException
    //   526	541	470	java/io/IOException
    //   548	558	470	java/io/IOException
    //   561	567	470	java/io/IOException
    //   574	590	470	java/io/IOException
    //   593	605	470	java/io/IOException
    //   608	615	470	java/io/IOException
    //   630	646	470	java/io/IOException
    //   649	659	470	java/io/IOException
    //   666	682	470	java/io/IOException
    //   685	695	470	java/io/IOException
    //   704	720	470	java/io/IOException
    //   723	736	470	java/io/IOException
    //   739	751	470	java/io/IOException
    //   754	759	470	java/io/IOException
    //   762	765	470	java/io/IOException
    //   768	801	470	java/io/IOException
    //   807	831	470	java/io/IOException
    //   840	856	470	java/io/IOException
    //   859	873	470	java/io/IOException
    //   876	894	470	java/io/IOException
    //   897	922	470	java/io/IOException
    //   946	962	470	java/io/IOException
    //   972	985	470	java/io/IOException
    //   988	1000	470	java/io/IOException
    //   1003	1015	470	java/io/IOException
    //   1018	1025	470	java/io/IOException
    //   1034	1047	470	java/io/IOException
    //   1050	1067	470	java/io/IOException
    //   1070	1081	470	java/io/IOException
    //   1088	1113	470	java/io/IOException
    //   1119	1152	470	java/io/IOException
    //   1155	1160	470	java/io/IOException
    //   1163	1166	470	java/io/IOException
    //   1169	1181	470	java/io/IOException
    //   1184	1209	470	java/io/IOException
    //   1219	1227	470	java/io/IOException
    //   1230	1249	470	java/io/IOException
    //   1252	1259	470	java/io/IOException
    //   1265	1278	470	java/io/IOException
    //   1281	1296	470	java/io/IOException
    //   1299	1307	470	java/io/IOException
    //   1310	1321	470	java/io/IOException
    //   1324	1331	470	java/io/IOException
    //   1334	1342	470	java/io/IOException
    //   1345	1356	470	java/io/IOException
    //   1359	1366	470	java/io/IOException
    //   73	112	494	finally
    //   120	129	494	finally
    //   132	141	494	finally
    //   144	152	494	finally
    //   167	183	494	finally
    //   186	193	494	finally
    //   208	224	494	finally
    //   227	234	494	finally
    //   244	260	494	finally
    //   285	292	494	finally
    //   295	302	494	finally
    //   305	312	494	finally
    //   319	329	494	finally
    //   332	354	494	finally
    //   361	371	494	finally
    //   374	382	494	finally
    //   385	407	494	finally
    //   410	425	494	finally
    //   428	456	494	finally
    //   459	464	494	finally
    //   467	470	494	finally
    //   472	494	494	finally
    //   514	523	494	finally
    //   526	541	494	finally
    //   548	558	494	finally
    //   561	567	494	finally
    //   574	590	494	finally
    //   593	605	494	finally
    //   608	615	494	finally
    //   630	646	494	finally
    //   649	659	494	finally
    //   666	682	494	finally
    //   685	695	494	finally
    //   704	720	494	finally
    //   723	736	494	finally
    //   739	751	494	finally
    //   754	759	494	finally
    //   762	765	494	finally
    //   768	801	494	finally
    //   807	831	494	finally
    //   840	856	494	finally
    //   859	873	494	finally
    //   876	894	494	finally
    //   897	922	494	finally
    //   946	962	494	finally
    //   972	985	494	finally
    //   988	1000	494	finally
    //   1003	1015	494	finally
    //   1018	1025	494	finally
    //   1034	1047	494	finally
    //   1050	1067	494	finally
    //   1070	1081	494	finally
    //   1088	1113	494	finally
    //   1119	1152	494	finally
    //   1155	1160	494	finally
    //   1163	1166	494	finally
    //   1169	1181	494	finally
    //   1184	1209	494	finally
    //   1219	1227	494	finally
    //   1230	1249	494	finally
    //   1252	1259	494	finally
    //   1265	1278	494	finally
    //   1281	1296	494	finally
    //   1299	1307	494	finally
    //   1310	1321	494	finally
    //   1324	1331	494	finally
    //   1334	1342	494	finally
    //   1345	1356	494	finally
    //   1359	1366	494	finally
    //   1373	1380	1386	java/lang/Exception
    //   496	503	1404	java/lang/Exception
    //   73	112	1419	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.CueItemParser
 * JD-Core Version:    0.7.0.1
 */