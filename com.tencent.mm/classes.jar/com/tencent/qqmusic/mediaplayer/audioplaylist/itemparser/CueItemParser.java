package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

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
    this.mUri = paramString;
    this.mTrackInfoList = new LinkedList();
  }
  
  private long convertTimeStrToMs(String paramString)
  {
    paramString = paramString.split(":");
    long l1 = Long.parseLong(paramString[0]);
    long l2 = Long.parseLong(paramString[1]);
    return Long.parseLong(paramString[2]) * 10L + (l1 * 60L + l2) * 1000L;
  }
  
  private String guessCharsetEncoding(String paramString)
  {
    Logger.i("CueItemParser", "CueItemParser.guessCharsetEncoding, filePath: " + paramString);
    return guessCharsetEncoding(new FileInputStream(paramString));
  }
  
  public boolean isParseSuccess()
  {
    return !this.mTrackInfoList.isEmpty();
  }
  
  public Iterator<TrackInfo> iterator()
  {
    return this.mTrackInfoList.iterator();
  }
  
  /* Error */
  public void parse()
  {
    // Byte code:
    //   0: ldc 8
    //   2: new 52	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 96
    //   8: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 21	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   15: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 70	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: new 98	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: getfield 21	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   32: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 17
    //   37: aconst_null
    //   38: astore 12
    //   40: aconst_null
    //   41: astore 14
    //   43: aconst_null
    //   44: astore 15
    //   46: iconst_0
    //   47: istore_2
    //   48: iconst_0
    //   49: istore 6
    //   51: lconst_0
    //   52: lstore 7
    //   54: iconst_0
    //   55: istore_3
    //   56: aconst_null
    //   57: astore 11
    //   59: aload_0
    //   60: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   63: invokeinterface 102 1 0
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 21	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   73: invokespecial 104	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:guessCharsetEncoding	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 13
    //   78: aload_0
    //   79: new 106	java/io/LineNumberReader
    //   82: dup
    //   83: new 108	java/io/InputStreamReader
    //   86: dup
    //   87: new 72	java/io/FileInputStream
    //   90: dup
    //   91: aload 17
    //   93: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: aload 13
    //   98: invokespecial 114	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   101: invokespecial 117	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   104: putfield 119	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   107: iconst_0
    //   108: istore_1
    //   109: iconst_0
    //   110: istore 4
    //   112: iload 4
    //   114: istore_3
    //   115: aload_0
    //   116: getfield 119	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   119: invokevirtual 122	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   122: astore 18
    //   124: iload 4
    //   126: istore_3
    //   127: aload_0
    //   128: getfield 119	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   131: invokevirtual 126	java/io/LineNumberReader:getLineNumber	()I
    //   134: istore 5
    //   136: iload 5
    //   138: istore_3
    //   139: aload 18
    //   141: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +953 -> 1097
    //   147: aload 14
    //   149: astore 13
    //   151: iload_2
    //   152: ifne +36 -> 188
    //   155: aload 14
    //   157: astore 13
    //   159: iload 5
    //   161: istore_3
    //   162: aload 18
    //   164: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   167: invokevirtual 137	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   170: ldc 139
    //   172: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   175: ifeq +13 -> 188
    //   178: iload 5
    //   180: istore_3
    //   181: aload 18
    //   183: invokestatic 146	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 13
    //   188: aload 12
    //   190: astore 14
    //   192: iload_2
    //   193: ifne +36 -> 229
    //   196: aload 12
    //   198: astore 14
    //   200: iload 5
    //   202: istore_3
    //   203: aload 18
    //   205: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   208: invokevirtual 137	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   211: ldc 148
    //   213: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   216: ifeq +13 -> 229
    //   219: iload 5
    //   221: istore_3
    //   222: aload 18
    //   224: invokestatic 146	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 14
    //   229: iload 5
    //   231: istore_3
    //   232: iload_2
    //   233: istore 4
    //   235: lload 7
    //   237: lstore 9
    //   239: aload 18
    //   241: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   244: invokevirtual 137	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   247: ldc 150
    //   249: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   252: ifeq +285 -> 537
    //   255: iload_2
    //   256: istore 4
    //   258: iload_2
    //   259: ifeq +6 -> 265
    //   262: iconst_0
    //   263: istore 4
    //   265: lload 7
    //   267: lconst_0
    //   268: lcmp
    //   269: ifeq +18 -> 287
    //   272: aload 11
    //   274: ifnull +13 -> 287
    //   277: iload 5
    //   279: istore_3
    //   280: aload 11
    //   282: lload 7
    //   284: invokevirtual 156	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   287: iload 5
    //   289: istore_3
    //   290: aload 18
    //   292: invokestatic 146	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   295: astore 16
    //   297: iload 5
    //   299: istore_3
    //   300: aload 17
    //   302: invokevirtual 159	java/io/File:getParent	()Ljava/lang/String;
    //   305: astore 15
    //   307: aload 15
    //   309: astore 12
    //   311: iload 5
    //   313: istore_3
    //   314: aload 15
    //   316: ldc 161
    //   318: invokevirtual 164	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   321: ifne +28 -> 349
    //   324: iload 5
    //   326: istore_3
    //   327: new 52	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   334: aload 15
    //   336: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc 161
    //   341: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: astore 12
    //   349: aload 16
    //   351: astore 15
    //   353: iload 5
    //   355: istore_3
    //   356: aload 16
    //   358: ldc 161
    //   360: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   363: ifeq +14 -> 377
    //   366: iload 5
    //   368: istore_3
    //   369: aload 16
    //   371: iconst_1
    //   372: invokevirtual 169	java/lang/String:substring	(I)Ljava/lang/String;
    //   375: astore 15
    //   377: iload 5
    //   379: istore_3
    //   380: new 52	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   387: aload 12
    //   389: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 15
    //   394: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: astore 15
    //   402: iload 5
    //   404: istore_3
    //   405: new 98	java/io/File
    //   408: dup
    //   409: aload 15
    //   411: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   414: invokevirtual 172	java/io/File:exists	()Z
    //   417: ifne +60 -> 477
    //   420: iload 5
    //   422: istore_3
    //   423: new 92	java/io/IOException
    //   426: dup
    //   427: new 52	java/lang/StringBuilder
    //   430: dup
    //   431: ldc 174
    //   433: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   436: aload_0
    //   437: getfield 21	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   440: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokespecial 175	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   449: athrow
    //   450: astore 11
    //   452: new 177	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/ParseException
    //   455: dup
    //   456: ldc 179
    //   458: aload 11
    //   460: iload_3
    //   461: invokespecial 182	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/ParseException:<init>	(Ljava/lang/String;Ljava/lang/Exception;I)V
    //   464: athrow
    //   465: astore 11
    //   467: aload_0
    //   468: getfield 119	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   471: invokevirtual 185	java/io/LineNumberReader:close	()V
    //   474: aload 11
    //   476: athrow
    //   477: iload 5
    //   479: istore_3
    //   480: new 187	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder
    //   483: dup
    //   484: invokespecial 188	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:<init>	()V
    //   487: astore 12
    //   489: iload 5
    //   491: istore_3
    //   492: aload 12
    //   494: new 190	com/tencent/qqmusic/mediaplayer/upstream/FileDataSource
    //   497: dup
    //   498: aload 15
    //   500: invokespecial 191	com/tencent/qqmusic/mediaplayer/upstream/FileDataSource:<init>	(Ljava/lang/String;)V
    //   503: invokevirtual 195	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)I
    //   506: istore_2
    //   507: iload_2
    //   508: ifne +207 -> 715
    //   511: iload 5
    //   513: istore_3
    //   514: aload 12
    //   516: invokevirtual 199	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:getAudioInformation	()Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   519: invokevirtual 205	com/tencent/qqmusic/mediaplayer/AudioInformation:getDuration	()J
    //   522: lstore 7
    //   524: iload 5
    //   526: istore_3
    //   527: aload 12
    //   529: invokevirtual 208	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:release	()I
    //   532: pop
    //   533: lload 7
    //   535: lstore 9
    //   537: iload 5
    //   539: istore_3
    //   540: aload 18
    //   542: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   545: invokevirtual 137	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   548: ldc 210
    //   550: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   553: ifeq +792 -> 1345
    //   556: iload 5
    //   558: istore_3
    //   559: new 152	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   562: dup
    //   563: getstatic 216	com/tencent/qqmusic/mediaplayer/audioplaylist/AudioPlayListItemInfo:TYPE_CUE	I
    //   566: invokespecial 219	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:<init>	(I)V
    //   569: astore 11
    //   571: iload 5
    //   573: istore_3
    //   574: aload 11
    //   576: aload 15
    //   578: invokevirtual 222	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setFilePath	(Ljava/lang/String;)V
    //   581: iconst_1
    //   582: istore_2
    //   583: iload 6
    //   585: iconst_1
    //   586: iadd
    //   587: istore 6
    //   589: iload_2
    //   590: ifeq +35 -> 625
    //   593: iload 5
    //   595: istore_3
    //   596: aload 18
    //   598: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   601: invokevirtual 137	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   604: ldc 148
    //   606: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   609: ifeq +16 -> 625
    //   612: iload 5
    //   614: istore_3
    //   615: aload 11
    //   617: aload 18
    //   619: invokestatic 146	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   622: invokevirtual 225	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setTitle	(Ljava/lang/String;)V
    //   625: iload_2
    //   626: ifeq +35 -> 661
    //   629: iload 5
    //   631: istore_3
    //   632: aload 18
    //   634: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   637: invokevirtual 137	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   640: ldc 139
    //   642: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   645: ifeq +16 -> 661
    //   648: iload 5
    //   650: istore_3
    //   651: aload 11
    //   653: aload 18
    //   655: invokestatic 146	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   658: invokevirtual 228	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setPerformer	(Ljava/lang/String;)V
    //   661: iload 6
    //   663: iconst_1
    //   664: if_icmpne +115 -> 779
    //   667: iload 5
    //   669: istore_3
    //   670: aload 18
    //   672: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   675: invokevirtual 137	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   678: ldc 230
    //   680: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   683: ifeq +96 -> 779
    //   686: iload 5
    //   688: istore_3
    //   689: aload 18
    //   691: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   694: ldc 232
    //   696: invokevirtual 235	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   699: ifne +53 -> 752
    //   702: iload 5
    //   704: istore_3
    //   705: new 92	java/io/IOException
    //   708: dup
    //   709: ldc 237
    //   711: invokespecial 175	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   714: athrow
    //   715: iload 5
    //   717: istore_3
    //   718: ldc 8
    //   720: new 52	java/lang/StringBuilder
    //   723: dup
    //   724: ldc 239
    //   726: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   729: iload_2
    //   730: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   733: ldc 244
    //   735: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: aload 15
    //   740: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   749: goto -225 -> 524
    //   752: iload 5
    //   754: istore_3
    //   755: aload 11
    //   757: aload_0
    //   758: aload 18
    //   760: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   763: ldc 232
    //   765: invokevirtual 37	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   768: iconst_1
    //   769: aaload
    //   770: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   773: invokespecial 249	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   776: invokevirtual 252	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setStartPosition	(J)V
    //   779: iload 6
    //   781: iconst_2
    //   782: if_icmplt +569 -> 1351
    //   785: iload 5
    //   787: istore_3
    //   788: aload 18
    //   790: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   793: invokevirtual 137	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   796: ldc 230
    //   798: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   801: ifeq +550 -> 1351
    //   804: iload 5
    //   806: istore_3
    //   807: aload 18
    //   809: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   812: ldc 254
    //   814: invokevirtual 235	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   817: ifeq +160 -> 977
    //   820: iload 5
    //   822: istore_3
    //   823: aload 18
    //   825: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   828: ldc 254
    //   830: invokevirtual 37	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   833: iconst_1
    //   834: aaload
    //   835: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   838: astore 12
    //   840: iload 5
    //   842: istore_3
    //   843: aload_0
    //   844: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   847: iload 6
    //   849: iconst_2
    //   850: isub
    //   851: invokeinterface 258 2 0
    //   856: checkcast 152	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   859: aload_0
    //   860: aload 12
    //   862: invokespecial 249	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   865: invokevirtual 156	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   868: iconst_1
    //   869: istore_1
    //   870: iload_1
    //   871: istore 4
    //   873: aload 11
    //   875: astore 12
    //   877: iload 6
    //   879: ifle +475 -> 1354
    //   882: iload 5
    //   884: istore_3
    //   885: iload_1
    //   886: istore 4
    //   888: aload 11
    //   890: astore 12
    //   892: aload 18
    //   894: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   897: invokevirtual 137	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   900: ldc 230
    //   902: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   905: ifeq +449 -> 1354
    //   908: iload 5
    //   910: istore_3
    //   911: iload_1
    //   912: istore 4
    //   914: aload 11
    //   916: astore 12
    //   918: aload 18
    //   920: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   923: ldc 232
    //   925: invokevirtual 235	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   928: ifeq +426 -> 1354
    //   931: iload 5
    //   933: istore_3
    //   934: aload_0
    //   935: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   938: aload 11
    //   940: invokeinterface 262 2 0
    //   945: pop
    //   946: iload 5
    //   948: istore_3
    //   949: new 152	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   952: dup
    //   953: getstatic 216	com/tencent/qqmusic/mediaplayer/audioplaylist/AudioPlayListItemInfo:TYPE_CUE	I
    //   956: invokespecial 219	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:<init>	(I)V
    //   959: astore 12
    //   961: iload 5
    //   963: istore_3
    //   964: aload 12
    //   966: aload 15
    //   968: invokevirtual 222	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setFilePath	(Ljava/lang/String;)V
    //   971: iconst_0
    //   972: istore 4
    //   974: goto +380 -> 1354
    //   977: iload 5
    //   979: istore_3
    //   980: aload 18
    //   982: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   985: ldc 232
    //   987: invokevirtual 235	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   990: ifeq +72 -> 1062
    //   993: iload 5
    //   995: istore_3
    //   996: aload 18
    //   998: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   1001: ldc 232
    //   1003: invokevirtual 37	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1006: iconst_1
    //   1007: aaload
    //   1008: invokevirtual 134	java/lang/String:trim	()Ljava/lang/String;
    //   1011: astore 12
    //   1013: iload 5
    //   1015: istore_3
    //   1016: aload 11
    //   1018: aload_0
    //   1019: aload 12
    //   1021: invokespecial 249	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   1024: invokevirtual 252	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setStartPosition	(J)V
    //   1027: iload_1
    //   1028: ifne +352 -> 1380
    //   1031: iload 5
    //   1033: istore_3
    //   1034: aload_0
    //   1035: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1038: iload 6
    //   1040: iconst_2
    //   1041: isub
    //   1042: invokeinterface 258 2 0
    //   1047: checkcast 152	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   1050: aload_0
    //   1051: aload 12
    //   1053: invokespecial 249	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   1056: invokevirtual 156	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   1059: goto +321 -> 1380
    //   1062: iload 5
    //   1064: istore_3
    //   1065: new 92	java/io/IOException
    //   1068: dup
    //   1069: new 52	java/lang/StringBuilder
    //   1072: dup
    //   1073: ldc_w 264
    //   1076: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1079: iload 6
    //   1081: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1084: ldc_w 266
    //   1087: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokespecial 175	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1096: athrow
    //   1097: iload 5
    //   1099: istore_3
    //   1100: aload_0
    //   1101: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1104: invokeinterface 83 1 0
    //   1109: ifne +195 -> 1304
    //   1112: iload 5
    //   1114: istore_3
    //   1115: aload_0
    //   1116: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1119: aload_0
    //   1120: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1123: invokeinterface 269 1 0
    //   1128: iconst_1
    //   1129: isub
    //   1130: invokeinterface 258 2 0
    //   1135: checkcast 152	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   1138: astore 11
    //   1140: lload 7
    //   1142: lconst_0
    //   1143: lcmp
    //   1144: ifeq +239 -> 1383
    //   1147: iload 5
    //   1149: istore_3
    //   1150: aload 11
    //   1152: invokevirtual 273	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getRange	()Landroid/util/Pair;
    //   1155: ifnull +228 -> 1383
    //   1158: iload 5
    //   1160: istore_3
    //   1161: aload 11
    //   1163: invokevirtual 273	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getRange	()Landroid/util/Pair;
    //   1166: getfield 279	android/util/Pair:second	Ljava/lang/Object;
    //   1169: checkcast 39	java/lang/Long
    //   1172: invokevirtual 282	java/lang/Long:longValue	()J
    //   1175: lconst_0
    //   1176: lcmp
    //   1177: ifne +206 -> 1383
    //   1180: iload 5
    //   1182: istore_3
    //   1183: aload 11
    //   1185: lload 7
    //   1187: invokevirtual 156	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   1190: goto +193 -> 1383
    //   1193: iload 5
    //   1195: istore_3
    //   1196: iload_1
    //   1197: aload_0
    //   1198: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1201: invokeinterface 269 1 0
    //   1206: if_icmpge +98 -> 1304
    //   1209: iload 5
    //   1211: istore_3
    //   1212: aload_0
    //   1213: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1216: iload_1
    //   1217: invokeinterface 258 2 0
    //   1222: checkcast 152	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   1225: astore 11
    //   1227: iload 5
    //   1229: istore_3
    //   1230: aload 12
    //   1232: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1235: ifne +27 -> 1262
    //   1238: iload 5
    //   1240: istore_3
    //   1241: aload 11
    //   1243: invokevirtual 285	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getAlbum	()Ljava/lang/String;
    //   1246: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1249: ifeq +13 -> 1262
    //   1252: iload 5
    //   1254: istore_3
    //   1255: aload 11
    //   1257: aload 12
    //   1259: invokevirtual 288	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setAlbum	(Ljava/lang/String;)V
    //   1262: iload 5
    //   1264: istore_3
    //   1265: aload 14
    //   1267: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1270: ifne +27 -> 1297
    //   1273: iload 5
    //   1275: istore_3
    //   1276: aload 11
    //   1278: invokevirtual 291	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getPerformer	()Ljava/lang/String;
    //   1281: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1284: ifeq +13 -> 1297
    //   1287: iload 5
    //   1289: istore_3
    //   1290: aload 11
    //   1292: aload 14
    //   1294: invokevirtual 228	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setPerformer	(Ljava/lang/String;)V
    //   1297: iload_1
    //   1298: iconst_1
    //   1299: iadd
    //   1300: istore_1
    //   1301: goto -108 -> 1193
    //   1304: aload_0
    //   1305: getfield 119	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   1308: invokevirtual 185	java/io/LineNumberReader:close	()V
    //   1311: return
    //   1312: astore 11
    //   1314: ldc 8
    //   1316: ldc_w 293
    //   1319: aload 11
    //   1321: invokestatic 296	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1324: return
    //   1325: astore 12
    //   1327: ldc 8
    //   1329: ldc_w 293
    //   1332: aload 12
    //   1334: invokestatic 296	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1337: goto -863 -> 474
    //   1340: astore 11
    //   1342: goto -890 -> 452
    //   1345: iload 4
    //   1347: istore_2
    //   1348: goto -759 -> 589
    //   1351: goto -481 -> 870
    //   1354: iload 4
    //   1356: istore_1
    //   1357: aload 12
    //   1359: astore 11
    //   1361: iload 5
    //   1363: istore 4
    //   1365: lload 9
    //   1367: lstore 7
    //   1369: aload 14
    //   1371: astore 12
    //   1373: aload 13
    //   1375: astore 14
    //   1377: goto -1265 -> 112
    //   1380: goto -510 -> 870
    //   1383: iconst_0
    //   1384: istore_1
    //   1385: goto -192 -> 1193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1388	0	this	CueItemParser
    //   108	1277	1	i	int
    //   47	1301	2	j	int
    //   55	1235	3	k	int
    //   110	1254	4	m	int
    //   134	1228	5	n	int
    //   49	1031	6	i1	int
    //   52	1316	7	l1	long
    //   237	1129	9	l2	long
    //   57	224	11	localObject1	java.lang.Object
    //   450	9	11	localIOException1	java.io.IOException
    //   465	10	11	localObject2	java.lang.Object
    //   569	722	11	localTrackInfo	TrackInfo
    //   1312	8	11	localException1	java.lang.Exception
    //   1340	1	11	localIOException2	java.io.IOException
    //   1359	1	11	localException2	java.lang.Exception
    //   38	1220	12	localObject3	java.lang.Object
    //   1325	33	12	localException3	java.lang.Exception
    //   1371	1	12	localObject4	java.lang.Object
    //   76	1298	13	localObject5	java.lang.Object
    //   41	1335	14	localObject6	java.lang.Object
    //   44	923	15	localObject7	java.lang.Object
    //   295	75	16	str1	String
    //   35	266	17	localFile	java.io.File
    //   122	875	18	str2	String
    // Exception table:
    //   from	to	target	type
    //   115	124	450	java/io/IOException
    //   127	136	450	java/io/IOException
    //   139	147	450	java/io/IOException
    //   162	178	450	java/io/IOException
    //   181	188	450	java/io/IOException
    //   203	219	450	java/io/IOException
    //   222	229	450	java/io/IOException
    //   239	255	450	java/io/IOException
    //   280	287	450	java/io/IOException
    //   290	297	450	java/io/IOException
    //   300	307	450	java/io/IOException
    //   314	324	450	java/io/IOException
    //   327	349	450	java/io/IOException
    //   356	366	450	java/io/IOException
    //   369	377	450	java/io/IOException
    //   380	402	450	java/io/IOException
    //   405	420	450	java/io/IOException
    //   423	450	450	java/io/IOException
    //   480	489	450	java/io/IOException
    //   492	507	450	java/io/IOException
    //   514	524	450	java/io/IOException
    //   527	533	450	java/io/IOException
    //   540	556	450	java/io/IOException
    //   559	571	450	java/io/IOException
    //   574	581	450	java/io/IOException
    //   596	612	450	java/io/IOException
    //   615	625	450	java/io/IOException
    //   632	648	450	java/io/IOException
    //   651	661	450	java/io/IOException
    //   670	686	450	java/io/IOException
    //   689	702	450	java/io/IOException
    //   705	715	450	java/io/IOException
    //   718	749	450	java/io/IOException
    //   755	779	450	java/io/IOException
    //   788	804	450	java/io/IOException
    //   807	820	450	java/io/IOException
    //   823	840	450	java/io/IOException
    //   843	868	450	java/io/IOException
    //   892	908	450	java/io/IOException
    //   918	931	450	java/io/IOException
    //   934	946	450	java/io/IOException
    //   949	961	450	java/io/IOException
    //   964	971	450	java/io/IOException
    //   980	993	450	java/io/IOException
    //   996	1013	450	java/io/IOException
    //   1016	1027	450	java/io/IOException
    //   1034	1059	450	java/io/IOException
    //   1065	1097	450	java/io/IOException
    //   1100	1112	450	java/io/IOException
    //   1115	1140	450	java/io/IOException
    //   1150	1158	450	java/io/IOException
    //   1161	1180	450	java/io/IOException
    //   1183	1190	450	java/io/IOException
    //   1196	1209	450	java/io/IOException
    //   1212	1227	450	java/io/IOException
    //   1230	1238	450	java/io/IOException
    //   1241	1252	450	java/io/IOException
    //   1255	1262	450	java/io/IOException
    //   1265	1273	450	java/io/IOException
    //   1276	1287	450	java/io/IOException
    //   1290	1297	450	java/io/IOException
    //   68	107	465	finally
    //   115	124	465	finally
    //   127	136	465	finally
    //   139	147	465	finally
    //   162	178	465	finally
    //   181	188	465	finally
    //   203	219	465	finally
    //   222	229	465	finally
    //   239	255	465	finally
    //   280	287	465	finally
    //   290	297	465	finally
    //   300	307	465	finally
    //   314	324	465	finally
    //   327	349	465	finally
    //   356	366	465	finally
    //   369	377	465	finally
    //   380	402	465	finally
    //   405	420	465	finally
    //   423	450	465	finally
    //   452	465	465	finally
    //   480	489	465	finally
    //   492	507	465	finally
    //   514	524	465	finally
    //   527	533	465	finally
    //   540	556	465	finally
    //   559	571	465	finally
    //   574	581	465	finally
    //   596	612	465	finally
    //   615	625	465	finally
    //   632	648	465	finally
    //   651	661	465	finally
    //   670	686	465	finally
    //   689	702	465	finally
    //   705	715	465	finally
    //   718	749	465	finally
    //   755	779	465	finally
    //   788	804	465	finally
    //   807	820	465	finally
    //   823	840	465	finally
    //   843	868	465	finally
    //   892	908	465	finally
    //   918	931	465	finally
    //   934	946	465	finally
    //   949	961	465	finally
    //   964	971	465	finally
    //   980	993	465	finally
    //   996	1013	465	finally
    //   1016	1027	465	finally
    //   1034	1059	465	finally
    //   1065	1097	465	finally
    //   1100	1112	465	finally
    //   1115	1140	465	finally
    //   1150	1158	465	finally
    //   1161	1180	465	finally
    //   1183	1190	465	finally
    //   1196	1209	465	finally
    //   1212	1227	465	finally
    //   1230	1238	465	finally
    //   1241	1252	465	finally
    //   1255	1262	465	finally
    //   1265	1273	465	finally
    //   1276	1287	465	finally
    //   1290	1297	465	finally
    //   1304	1311	1312	java/lang/Exception
    //   467	474	1325	java/lang/Exception
    //   68	107	1340	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.CueItemParser
 * JD-Core Version:    0.7.0.1
 */