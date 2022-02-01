package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.sqlite.SQLiteDiskIOException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.m.e;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.mm.vfs.u;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareImgUI
  extends AutoLoginActivity
  implements i
{
  private DialogInterface.OnCancelListener IOJ;
  ArrayList<String> XNo;
  private ArrayList<com.tencent.mm.an.q> XUE;
  private Boolean XUF;
  String filePath;
  private MMHandler handler;
  private ProgressDialog iXX;
  private Intent intent;
  Intent qVX;
  Uri uri;
  
  public ShareImgUI()
  {
    AppMethodBeat.i(39140);
    this.iXX = null;
    this.IOJ = null;
    this.intent = null;
    this.XUE = new ArrayList();
    this.filePath = null;
    this.uri = null;
    this.XNo = null;
    this.qVX = null;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(39133);
        if (Util.isNullOrNil(ShareImgUI.this.filePath))
        {
          Log.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
          ShareImgUI.d(ShareImgUI.this);
          ShareImgUI.this.finish();
          AppMethodBeat.o(39133);
          return;
        }
        ShareImgUI.c(ShareImgUI.this);
        AppMethodBeat.o(39133);
      }
    };
    this.XUF = null;
    AppMethodBeat.o(39140);
  }
  
  /* Error */
  private String a(Uri paramUri, android.database.Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc 112
    //   2: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +351 -> 357
    //   9: ldc 114
    //   11: astore 4
    //   13: aload_2
    //   14: ldc 116
    //   16: invokeinterface 122 2 0
    //   21: istore_3
    //   22: aload 4
    //   24: astore 5
    //   26: iload_3
    //   27: iconst_m1
    //   28: if_icmpeq +60 -> 88
    //   31: aload_2
    //   32: iload_3
    //   33: invokeinterface 126 2 0
    //   38: astore 5
    //   40: aload 5
    //   42: astore 4
    //   44: aload 4
    //   46: astore 5
    //   48: aload 4
    //   50: ifnull +23 -> 73
    //   53: aload 4
    //   55: astore 5
    //   57: aload 4
    //   59: ifnull +14 -> 73
    //   62: aload 4
    //   64: ldc 128
    //   66: ldc 130
    //   68: invokevirtual 136	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 5
    //   73: ldc 138
    //   75: ldc 140
    //   77: aload 5
    //   79: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokeinterface 156 1 0
    //   94: aload_0
    //   95: invokevirtual 160	com/tencent/mm/ui/tools/ShareImgUI:getContentResolver	()Landroid/content/ContentResolver;
    //   98: aload_1
    //   99: ldc 162
    //   101: invokevirtual 168	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 174	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   109: astore_2
    //   110: invokestatic 180	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   113: pop
    //   114: invokestatic 186	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   117: ifeq +271 -> 388
    //   120: new 188	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   127: invokestatic 195	com/tencent/mm/loader/j/b:aSL	()Ljava/lang/String;
    //   130: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 201
    //   135: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore 4
    //   143: new 188	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   150: invokestatic 195	com/tencent/mm/loader/j/b:aSL	()Ljava/lang/String;
    //   153: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 206
    //   158: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 5
    //   163: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore 8
    //   171: new 208	com/tencent/mm/vfs/q
    //   174: dup
    //   175: aload 4
    //   177: invokespecial 211	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   180: astore 4
    //   182: aload 4
    //   184: invokevirtual 214	com/tencent/mm/vfs/q:ifE	()Z
    //   187: ifne +9 -> 196
    //   190: aload 4
    //   192: invokevirtual 217	com/tencent/mm/vfs/q:ifK	()Z
    //   195: pop
    //   196: new 208	com/tencent/mm/vfs/q
    //   199: dup
    //   200: aload 8
    //   202: invokespecial 211	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   205: astore 4
    //   207: aload 4
    //   209: invokevirtual 214	com/tencent/mm/vfs/q:ifE	()Z
    //   212: ifne +9 -> 221
    //   215: aload 4
    //   217: invokevirtual 220	com/tencent/mm/vfs/q:ifM	()Z
    //   220: pop
    //   221: aload 8
    //   223: iconst_0
    //   224: invokestatic 226	com/tencent/mm/vfs/u:dI	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   227: astore 4
    //   229: aload 4
    //   231: astore 7
    //   233: aload_1
    //   234: astore 6
    //   236: aload_2
    //   237: astore 5
    //   239: sipush 5120
    //   242: newarray byte
    //   244: astore 9
    //   246: aload 4
    //   248: astore 7
    //   250: aload_1
    //   251: astore 6
    //   253: aload_2
    //   254: astore 5
    //   256: aload_2
    //   257: aload 9
    //   259: iconst_0
    //   260: sipush 5120
    //   263: invokevirtual 232	java/io/InputStream:read	([BII)I
    //   266: istore_3
    //   267: iload_3
    //   268: iconst_m1
    //   269: if_icmpeq +171 -> 440
    //   272: aload 4
    //   274: astore 7
    //   276: aload_1
    //   277: astore 6
    //   279: aload_2
    //   280: astore 5
    //   282: aload 4
    //   284: aload 9
    //   286: iconst_0
    //   287: iload_3
    //   288: invokevirtual 238	java/io/OutputStream:write	([BII)V
    //   291: goto -45 -> 246
    //   294: astore 8
    //   296: aload 4
    //   298: astore 7
    //   300: aload_1
    //   301: astore 6
    //   303: aload_2
    //   304: astore 5
    //   306: ldc 138
    //   308: new 188	java/lang/StringBuilder
    //   311: dup
    //   312: ldc 240
    //   314: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: aload 8
    //   319: invokevirtual 244	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 247	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokevirtual 248	java/io/InputStream:close	()V
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 249	android/content/res/AssetFileDescriptor:close	()V
    //   347: aload 4
    //   349: ifnull +8 -> 357
    //   352: aload 4
    //   354: invokevirtual 250	java/io/OutputStream:close	()V
    //   357: ldc 112
    //   359: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: aconst_null
    //   363: areturn
    //   364: astore 5
    //   366: ldc 138
    //   368: ldc 252
    //   370: iconst_1
    //   371: anewarray 254	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload 5
    //   378: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   381: aastore
    //   382: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: goto -341 -> 44
    //   388: aload_0
    //   389: aload 5
    //   391: invokevirtual 263	com/tencent/mm/ui/tools/ShareImgUI:deleteFile	(Ljava/lang/String;)Z
    //   394: pop
    //   395: new 188	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   402: aload_0
    //   403: invokevirtual 267	com/tencent/mm/ui/tools/ShareImgUI:getFilesDir	()Ljava/io/File;
    //   406: invokevirtual 272	java/io/File:getPath	()Ljava/lang/String;
    //   409: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc_w 274
    //   415: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 5
    //   420: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: astore 8
    //   428: aload_0
    //   429: aload 5
    //   431: iconst_0
    //   432: invokevirtual 278	com/tencent/mm/ui/tools/ShareImgUI:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   435: astore 4
    //   437: goto -208 -> 229
    //   440: aload 4
    //   442: astore 7
    //   444: aload_1
    //   445: astore 6
    //   447: aload_2
    //   448: astore 5
    //   450: aload 4
    //   452: invokevirtual 281	java/io/OutputStream:flush	()V
    //   455: aload 4
    //   457: astore 7
    //   459: aload_1
    //   460: astore 6
    //   462: aload_2
    //   463: astore 5
    //   465: aload 4
    //   467: invokevirtual 250	java/io/OutputStream:close	()V
    //   470: aload_2
    //   471: ifnull +7 -> 478
    //   474: aload_2
    //   475: invokevirtual 248	java/io/InputStream:close	()V
    //   478: aload_1
    //   479: ifnull +7 -> 486
    //   482: aload_1
    //   483: invokevirtual 249	android/content/res/AssetFileDescriptor:close	()V
    //   486: aload 4
    //   488: ifnull +8 -> 496
    //   491: aload 4
    //   493: invokevirtual 250	java/io/OutputStream:close	()V
    //   496: ldc 112
    //   498: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   501: aload 8
    //   503: areturn
    //   504: astore 8
    //   506: aconst_null
    //   507: astore 4
    //   509: aconst_null
    //   510: astore_1
    //   511: aconst_null
    //   512: astore_2
    //   513: aload 4
    //   515: astore 7
    //   517: aload_1
    //   518: astore 6
    //   520: aload_2
    //   521: astore 5
    //   523: ldc 138
    //   525: new 188	java/lang/StringBuilder
    //   528: dup
    //   529: ldc_w 283
    //   532: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   535: aload 8
    //   537: invokevirtual 284	java/io/IOException:getMessage	()Ljava/lang/String;
    //   540: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 247	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: aload_2
    //   550: ifnull +7 -> 557
    //   553: aload_2
    //   554: invokevirtual 248	java/io/InputStream:close	()V
    //   557: aload_1
    //   558: ifnull +7 -> 565
    //   561: aload_1
    //   562: invokevirtual 249	android/content/res/AssetFileDescriptor:close	()V
    //   565: aload 4
    //   567: ifnull -210 -> 357
    //   570: aload 4
    //   572: invokevirtual 250	java/io/OutputStream:close	()V
    //   575: goto -218 -> 357
    //   578: astore_1
    //   579: goto -222 -> 357
    //   582: astore 8
    //   584: aconst_null
    //   585: astore 4
    //   587: aconst_null
    //   588: astore_1
    //   589: aconst_null
    //   590: astore_2
    //   591: aload 4
    //   593: astore 7
    //   595: aload_1
    //   596: astore 6
    //   598: aload_2
    //   599: astore 5
    //   601: ldc 138
    //   603: new 188	java/lang/StringBuilder
    //   606: dup
    //   607: ldc_w 286
    //   610: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   613: aload 8
    //   615: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   618: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 247	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: aload 4
    //   629: astore 7
    //   631: aload_1
    //   632: astore 6
    //   634: aload_2
    //   635: astore 5
    //   637: ldc 138
    //   639: aload 8
    //   641: invokevirtual 287	java/lang/Exception:toString	()Ljava/lang/String;
    //   644: invokestatic 247	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload_2
    //   648: ifnull +7 -> 655
    //   651: aload_2
    //   652: invokevirtual 248	java/io/InputStream:close	()V
    //   655: aload_1
    //   656: ifnull +7 -> 663
    //   659: aload_1
    //   660: invokevirtual 249	android/content/res/AssetFileDescriptor:close	()V
    //   663: aload 4
    //   665: ifnull -308 -> 357
    //   668: aload 4
    //   670: invokevirtual 250	java/io/OutputStream:close	()V
    //   673: goto -316 -> 357
    //   676: astore_1
    //   677: goto -320 -> 357
    //   680: astore 4
    //   682: aconst_null
    //   683: astore 7
    //   685: aconst_null
    //   686: astore_1
    //   687: aconst_null
    //   688: astore_2
    //   689: aload_2
    //   690: ifnull +7 -> 697
    //   693: aload_2
    //   694: invokevirtual 248	java/io/InputStream:close	()V
    //   697: aload_1
    //   698: ifnull +7 -> 705
    //   701: aload_1
    //   702: invokevirtual 249	android/content/res/AssetFileDescriptor:close	()V
    //   705: aload 7
    //   707: ifnull +8 -> 715
    //   710: aload 7
    //   712: invokevirtual 250	java/io/OutputStream:close	()V
    //   715: ldc 112
    //   717: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   720: aload 4
    //   722: athrow
    //   723: astore_1
    //   724: goto -9 -> 715
    //   727: astore 4
    //   729: aconst_null
    //   730: astore 7
    //   732: aconst_null
    //   733: astore_2
    //   734: goto -45 -> 689
    //   737: astore 4
    //   739: aconst_null
    //   740: astore 7
    //   742: goto -53 -> 689
    //   745: astore 4
    //   747: aload 6
    //   749: astore_1
    //   750: aload 5
    //   752: astore_2
    //   753: goto -64 -> 689
    //   756: astore 8
    //   758: aconst_null
    //   759: astore 4
    //   761: aconst_null
    //   762: astore_2
    //   763: goto -172 -> 591
    //   766: astore 8
    //   768: aconst_null
    //   769: astore 4
    //   771: goto -180 -> 591
    //   774: astore 8
    //   776: goto -185 -> 591
    //   779: astore 8
    //   781: aconst_null
    //   782: astore 4
    //   784: aconst_null
    //   785: astore_2
    //   786: goto -273 -> 513
    //   789: astore 8
    //   791: aconst_null
    //   792: astore 4
    //   794: goto -281 -> 513
    //   797: astore 8
    //   799: goto -286 -> 513
    //   802: astore_1
    //   803: goto -446 -> 357
    //   806: astore 8
    //   808: aconst_null
    //   809: astore 4
    //   811: aconst_null
    //   812: astore_1
    //   813: aconst_null
    //   814: astore_2
    //   815: goto -519 -> 296
    //   818: astore 8
    //   820: aconst_null
    //   821: astore 4
    //   823: aconst_null
    //   824: astore_2
    //   825: goto -529 -> 296
    //   828: astore 8
    //   830: aconst_null
    //   831: astore 4
    //   833: goto -537 -> 296
    //   836: astore_1
    //   837: goto -341 -> 496
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	840	0	this	ShareImgUI
    //   0	840	1	paramUri	Uri
    //   0	840	2	paramCursor	android.database.Cursor
    //   21	267	3	i	int
    //   11	658	4	localObject1	Object
    //   680	41	4	localObject2	Object
    //   727	1	4	localObject3	Object
    //   737	1	4	localObject4	Object
    //   745	1	4	localObject5	Object
    //   759	73	4	localObject6	Object
    //   24	281	5	localObject7	Object
    //   364	66	5	localException1	java.lang.Exception
    //   448	303	5	localCursor	android.database.Cursor
    //   234	514	6	localUri	Uri
    //   231	510	7	localObject8	Object
    //   169	53	8	str1	String
    //   294	24	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   426	76	8	str2	String
    //   504	32	8	localIOException1	java.io.IOException
    //   582	58	8	localException2	java.lang.Exception
    //   756	1	8	localException3	java.lang.Exception
    //   766	1	8	localException4	java.lang.Exception
    //   774	1	8	localException5	java.lang.Exception
    //   779	1	8	localIOException2	java.io.IOException
    //   789	1	8	localIOException3	java.io.IOException
    //   797	1	8	localIOException4	java.io.IOException
    //   806	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   818	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   828	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   244	41	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   239	246	294	java/io/FileNotFoundException
    //   256	267	294	java/io/FileNotFoundException
    //   282	291	294	java/io/FileNotFoundException
    //   450	455	294	java/io/FileNotFoundException
    //   465	470	294	java/io/FileNotFoundException
    //   31	40	364	java/lang/Exception
    //   94	105	504	java/io/IOException
    //   553	557	578	java/lang/Exception
    //   561	565	578	java/lang/Exception
    //   570	575	578	java/lang/Exception
    //   94	105	582	java/lang/Exception
    //   651	655	676	java/lang/Exception
    //   659	663	676	java/lang/Exception
    //   668	673	676	java/lang/Exception
    //   94	105	680	finally
    //   693	697	723	java/lang/Exception
    //   701	705	723	java/lang/Exception
    //   710	715	723	java/lang/Exception
    //   105	110	727	finally
    //   110	196	737	finally
    //   196	221	737	finally
    //   221	229	737	finally
    //   388	437	737	finally
    //   239	246	745	finally
    //   256	267	745	finally
    //   282	291	745	finally
    //   306	331	745	finally
    //   450	455	745	finally
    //   465	470	745	finally
    //   523	549	745	finally
    //   601	627	745	finally
    //   637	647	745	finally
    //   105	110	756	java/lang/Exception
    //   110	196	766	java/lang/Exception
    //   196	221	766	java/lang/Exception
    //   221	229	766	java/lang/Exception
    //   388	437	766	java/lang/Exception
    //   239	246	774	java/lang/Exception
    //   256	267	774	java/lang/Exception
    //   282	291	774	java/lang/Exception
    //   450	455	774	java/lang/Exception
    //   465	470	774	java/lang/Exception
    //   105	110	779	java/io/IOException
    //   110	196	789	java/io/IOException
    //   196	221	789	java/io/IOException
    //   221	229	789	java/io/IOException
    //   388	437	789	java/io/IOException
    //   239	246	797	java/io/IOException
    //   256	267	797	java/io/IOException
    //   282	291	797	java/io/IOException
    //   450	455	797	java/io/IOException
    //   465	470	797	java/io/IOException
    //   335	339	802	java/lang/Exception
    //   343	347	802	java/lang/Exception
    //   352	357	802	java/lang/Exception
    //   94	105	806	java/io/FileNotFoundException
    //   105	110	818	java/io/FileNotFoundException
    //   110	196	828	java/io/FileNotFoundException
    //   196	221	828	java/io/FileNotFoundException
    //   221	229	828	java/io/FileNotFoundException
    //   388	437	828	java/io/FileNotFoundException
    //   474	478	836	java/lang/Exception
    //   482	486	836	java/lang/Exception
    //   491	496	836	java/lang/Exception
  }
  
  /* Error */
  private String a(String paramString, Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 394
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 99	com/tencent/mm/ui/tools/ShareImgUI:XUF	Ljava/lang/Boolean;
    //   10: ifnonnull +55 -> 65
    //   13: ldc_w 396
    //   16: invokestatic 402	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   19: checkcast 396	com/tencent/mm/plugin/expt/b/b
    //   22: getstatic 408	com/tencent/mm/plugin/expt/b/b$a:vGR	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   25: iconst_1
    //   26: invokeinterface 411 3 0
    //   31: iconst_1
    //   32: if_icmpeq +21 -> 53
    //   35: getstatic 417	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   38: ifne +15 -> 53
    //   41: getstatic 420	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   44: ifne +9 -> 53
    //   47: invokestatic 425	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   50: ifeq +63 -> 113
    //   53: iconst_1
    //   54: istore 4
    //   56: aload_0
    //   57: iload 4
    //   59: invokestatic 430	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   62: putfield 99	com/tencent/mm/ui/tools/ShareImgUI:XUF	Ljava/lang/Boolean;
    //   65: ldc 138
    //   67: new 188	java/lang/StringBuilder
    //   70: dup
    //   71: ldc_w 432
    //   74: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload_0
    //   78: getfield 99	com/tencent/mm/ui/tools/ShareImgUI:XUF	Ljava/lang/Boolean;
    //   81: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 99	com/tencent/mm/ui/tools/ShareImgUI:XUF	Ljava/lang/Boolean;
    //   94: invokevirtual 438	java/lang/Boolean:booleanValue	()Z
    //   97: ifne +22 -> 119
    //   100: bipush 10
    //   102: invokestatic 443	com/tencent/mm/plugin/base/stub/f:Gi	(I)V
    //   105: ldc_w 394
    //   108: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_1
    //   112: areturn
    //   113: iconst_0
    //   114: istore 4
    //   116: goto -60 -> 56
    //   119: aload_1
    //   120: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   123: ifne +57 -> 180
    //   126: new 208	com/tencent/mm/vfs/q
    //   129: dup
    //   130: aload_1
    //   131: invokespecial 211	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   134: astore 9
    //   136: aload 9
    //   138: invokevirtual 214	com/tencent/mm/vfs/q:ifE	()Z
    //   141: ifeq +39 -> 180
    //   144: aload 9
    //   146: invokevirtual 446	com/tencent/mm/vfs/q:ifC	()Z
    //   149: ifeq +31 -> 180
    //   152: bipush 17
    //   154: invokestatic 443	com/tencent/mm/plugin/base/stub/f:Gi	(I)V
    //   157: ldc 138
    //   159: ldc_w 448
    //   162: aload_1
    //   163: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   166: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: ldc_w 394
    //   175: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload_1
    //   179: areturn
    //   180: bipush 11
    //   182: invokestatic 443	com/tencent/mm/plugin/base/stub/f:Gi	(I)V
    //   185: aload_0
    //   186: invokevirtual 160	com/tencent/mm/ui/tools/ShareImgUI:getContentResolver	()Landroid/content/ContentResolver;
    //   189: aload_2
    //   190: invokevirtual 452	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   193: astore 9
    //   195: aload 9
    //   197: ifnull +350 -> 547
    //   200: invokestatic 458	java/lang/System:currentTimeMillis	()J
    //   203: lstore 7
    //   205: aload_1
    //   206: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   209: ifeq +53 -> 262
    //   212: ldc_w 460
    //   215: astore 10
    //   217: aload 10
    //   219: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   222: ifeq +68 -> 290
    //   225: ldc 138
    //   227: ldc_w 462
    //   230: aload_1
    //   231: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   234: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic 247	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: bipush 12
    //   242: invokestatic 443	com/tencent/mm/plugin/base/stub/f:Gi	(I)V
    //   245: aload 9
    //   247: invokestatic 466	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   250: aconst_null
    //   251: invokestatic 466	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   254: ldc_w 394
    //   257: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload_1
    //   261: areturn
    //   262: new 188	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   269: invokestatic 471	com/tencent/mm/plugin/ab/a:fmv	()Ljava/lang/String;
    //   272: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokestatic 476	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   279: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: astore 10
    //   287: goto -70 -> 217
    //   290: aload 10
    //   292: invokestatic 479	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   295: ifeq +25 -> 320
    //   298: ldc 138
    //   300: ldc_w 481
    //   303: aload 10
    //   305: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   308: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   311: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload 10
    //   316: invokestatic 482	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   319: pop
    //   320: aload 10
    //   322: invokestatic 486	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   325: astore_2
    //   326: sipush 4096
    //   329: newarray byte
    //   331: astore 11
    //   333: lconst_0
    //   334: lstore 5
    //   336: aload 9
    //   338: aload 11
    //   340: invokevirtual 489	java/io/InputStream:read	([B)I
    //   343: istore_3
    //   344: iload_3
    //   345: iconst_m1
    //   346: if_icmpeq +19 -> 365
    //   349: aload_2
    //   350: aload 11
    //   352: invokevirtual 492	java/io/OutputStream:write	([B)V
    //   355: lload 5
    //   357: iload_3
    //   358: i2l
    //   359: ladd
    //   360: lstore 5
    //   362: goto -26 -> 336
    //   365: ldc 138
    //   367: new 188	java/lang/StringBuilder
    //   370: dup
    //   371: ldc_w 494
    //   374: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   377: invokestatic 458	java/lang/System:currentTimeMillis	()J
    //   380: lload 7
    //   382: lsub
    //   383: invokevirtual 497	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   386: ldc_w 499
    //   389: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: lload 5
    //   394: l2f
    //   395: ldc_w 500
    //   398: fdiv
    //   399: invokevirtual 503	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   402: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: new 208	com/tencent/mm/vfs/q
    //   411: dup
    //   412: aload 10
    //   414: invokespecial 211	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   417: astore 11
    //   419: aload 11
    //   421: invokevirtual 214	com/tencent/mm/vfs/q:ifE	()Z
    //   424: ifeq +52 -> 476
    //   427: aload 11
    //   429: invokevirtual 446	com/tencent/mm/vfs/q:ifC	()Z
    //   432: ifeq +44 -> 476
    //   435: ldc 138
    //   437: ldc_w 505
    //   440: aload 10
    //   442: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   445: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   448: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: bipush 13
    //   453: invokestatic 443	com/tencent/mm/plugin/base/stub/f:Gi	(I)V
    //   456: aload 10
    //   458: astore_1
    //   459: aload 9
    //   461: invokestatic 466	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   464: aload_2
    //   465: invokestatic 466	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   468: ldc_w 394
    //   471: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: aload_1
    //   475: areturn
    //   476: ldc 138
    //   478: ldc_w 507
    //   481: aload_1
    //   482: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   485: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   488: invokestatic 509	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   491: bipush 14
    //   493: invokestatic 443	com/tencent/mm/plugin/base/stub/f:Gi	(I)V
    //   496: goto -37 -> 459
    //   499: astore 10
    //   501: ldc 138
    //   503: aload 10
    //   505: ldc_w 460
    //   508: iconst_0
    //   509: anewarray 254	java/lang/Object
    //   512: invokestatic 513	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   515: ldc 138
    //   517: ldc_w 515
    //   520: aload_1
    //   521: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   524: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   527: invokestatic 247	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: bipush 16
    //   532: invokestatic 443	com/tencent/mm/plugin/base/stub/f:Gi	(I)V
    //   535: aload 9
    //   537: invokestatic 466	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   540: aload_2
    //   541: invokestatic 466	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   544: goto -76 -> 468
    //   547: ldc 138
    //   549: ldc_w 517
    //   552: aload_1
    //   553: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   556: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   559: invokestatic 509	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: bipush 15
    //   564: invokestatic 443	com/tencent/mm/plugin/base/stub/f:Gi	(I)V
    //   567: aconst_null
    //   568: astore_2
    //   569: goto -110 -> 459
    //   572: astore_1
    //   573: aconst_null
    //   574: astore_2
    //   575: aconst_null
    //   576: astore 9
    //   578: aload 9
    //   580: invokestatic 466	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   583: aload_2
    //   584: invokestatic 466	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   587: ldc_w 394
    //   590: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   593: aload_1
    //   594: athrow
    //   595: astore_1
    //   596: aconst_null
    //   597: astore_2
    //   598: goto -20 -> 578
    //   601: astore_1
    //   602: goto -24 -> 578
    //   605: astore_1
    //   606: goto -28 -> 578
    //   609: astore 10
    //   611: aconst_null
    //   612: astore_2
    //   613: aconst_null
    //   614: astore 9
    //   616: goto -115 -> 501
    //   619: astore 10
    //   621: aconst_null
    //   622: astore_2
    //   623: goto -122 -> 501
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	626	0	this	ShareImgUI
    //   0	626	1	paramString	String
    //   0	626	2	paramUri	Uri
    //   343	15	3	i	int
    //   54	61	4	bool	boolean
    //   334	59	5	l1	long
    //   203	178	7	l2	long
    //   134	481	9	localObject1	Object
    //   215	242	10	str	String
    //   499	5	10	localException1	java.lang.Exception
    //   609	1	10	localException2	java.lang.Exception
    //   619	1	10	localException3	java.lang.Exception
    //   331	97	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   326	333	499	java/lang/Exception
    //   336	344	499	java/lang/Exception
    //   349	355	499	java/lang/Exception
    //   365	456	499	java/lang/Exception
    //   476	496	499	java/lang/Exception
    //   185	195	572	finally
    //   200	212	595	finally
    //   217	245	595	finally
    //   262	287	595	finally
    //   290	320	595	finally
    //   320	326	595	finally
    //   547	567	595	finally
    //   326	333	601	finally
    //   336	344	601	finally
    //   349	355	601	finally
    //   365	456	601	finally
    //   476	496	601	finally
    //   501	535	605	finally
    //   185	195	609	java/lang/Exception
    //   200	212	619	java/lang/Exception
    //   217	245	619	java/lang/Exception
    //   262	287	619	java/lang/Exception
    //   290	320	619	java/lang/Exception
    //   320	326	619	java/lang/Exception
    //   547	567	619	java/lang/Exception
  }
  
  private void a(final Bundle paramBundle, final b paramb)
  {
    AppMethodBeat.i(39146);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(39135);
        Object localObject1 = paramBundle.getParcelableArrayList("android.intent.extra.STREAM");
        Object localObject5;
        Object localObject3;
        Object localObject4;
        Object localObject6;
        final Parcelable localParcelable;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          localObject5 = new CountDownLatch(((ArrayList)localObject1).size());
          localObject3 = new boolean[1];
          localObject3[0] = 0;
          localObject4 = new ConcurrentLinkedQueue();
          localObject6 = ((ArrayList)localObject1).iterator();
          if (((Iterator)localObject6).hasNext())
          {
            localParcelable = (Parcelable)((Iterator)localObject6).next();
            if (localParcelable == null) {
              break label288;
            }
          }
        }
        Object localObject2;
        label288:
        for (localObject1 = localParcelable.toString();; localObject2 = "null")
        {
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(39134);
              if (!ShareImgUI.a(ShareImgUI.this, this.XUJ, localParcelable)) {
                this.XUL[0] = true;
              }
              this.XUM.countDown();
              AppMethodBeat.o(39134);
            }
          }, "getMultiSendFilePathListItem".concat(String.valueOf(localObject1)));
          break;
          try
          {
            ((CountDownLatch)localObject5).await();
            localObject6 = new ArrayList((Collection)localObject4);
            if (localObject3[0] != 0)
            {
              Log.d("MicroMsg.ShareImgUI", "hy: has non path img");
              localObject3 = ShareImgUI.this;
              localObject1 = paramb;
              localObject4 = null;
              ShareImgUI.a((ShareImgUI)localObject3, (ShareImgUI.b)localObject1, (ArrayList)localObject4);
              AppMethodBeat.o(39135);
              return;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.ShareImgUI", localInterruptedException, "hy: timeout when getmulti", new Object[0]);
              ShareImgUI.a(ShareImgUI.this, paramb, null);
              continue;
              Log.i("MicroMsg.ShareImgUI", "hy: getMultiSendFilePathList done. using: %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.XUI) });
              localObject4 = ShareImgUI.this;
              localObject5 = paramb;
              localObject2 = localObject5;
              localObject3 = localObject4;
              if (((ArrayList)localObject6).size() > 0)
              {
                localObject2 = localObject5;
                localObject3 = localObject4;
                localObject4 = localObject6;
              }
            }
          }
          Log.e("MicroMsg.ShareImgUI", "getParcelableArrayList failed");
          ShareImgUI.a(ShareImgUI.this, paramb, null);
          AppMethodBeat.o(39135);
          return;
        }
      }
    }, "getMultiSendFilePathList");
    AppMethodBeat.o(39146);
  }
  
  private void axt(int paramInt)
  {
    AppMethodBeat.i(39150);
    switch (paramInt)
    {
    default: 
      Toast.makeText(this, R.l.eTt, 1).show();
      AppMethodBeat.o(39150);
      return;
    }
    Toast.makeText(this, R.l.eTq, 1).show();
    AppMethodBeat.o(39150);
  }
  
  private static int bAy(String paramString)
  {
    AppMethodBeat.i(39149);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.ShareImgUI", "map : mimeType is null");
      AppMethodBeat.o(39149);
      return -1;
    }
    paramString = paramString.toLowerCase();
    if (paramString.equalsIgnoreCase("image/gif"))
    {
      AppMethodBeat.o(39149);
      return 5;
    }
    if (paramString.contains("image"))
    {
      AppMethodBeat.o(39149);
      return 0;
    }
    if (paramString.contains("video"))
    {
      AppMethodBeat.o(39149);
      return 1;
    }
    Log.d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
    AppMethodBeat.o(39149);
    return 3;
  }
  
  private void bBT()
  {
    AppMethodBeat.i(39144);
    if (this.intent == null)
    {
      Log.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
      axt(0);
      finish();
      AppMethodBeat.o(39144);
      return;
    }
    String str = this.intent.getAction();
    Bundle localBundle = this.intent.getExtras();
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
      axt(0);
      finish();
      AppMethodBeat.o(39144);
      return;
    }
    if (localBundle != null)
    {
      Parcelable localParcelable = localBundle.getParcelable("android.intent.extra.STREAM");
      if ((localParcelable != null) && ((localParcelable instanceof Uri)))
      {
        this.uri = ((Uri)localParcelable);
        if (!Util.isUriSafeToBeCopySrc(this.uri))
        {
          Log.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", new Object[] { this.uri });
          axt(0);
          finish();
          AppMethodBeat.o(39144);
          return;
        }
      }
    }
    elK();
    if (str.equals("android.intent.action.SEND"))
    {
      Log.i("MicroMsg.ShareImgUI", "send signal: ".concat(String.valueOf(str)));
      if (this.uri == null)
      {
        boolean bool = bK(getIntent());
        Log.i("MicroMsg.ShareImgUI", "dealWithText: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          axt(0);
          finish();
        }
        AppMethodBeat.o(39144);
        return;
      }
      ThreadPool.post(new a(this.uri, new c()
      {
        public final void hYj()
        {
          AppMethodBeat.i(39131);
          ShareImgUI.a(ShareImgUI.this).sendEmptyMessage(0);
          AppMethodBeat.o(39131);
        }
      }), "ShareImgUI_getFilePath");
      AppMethodBeat.o(39144);
      return;
    }
    if ((str.equals("android.intent.action.SEND_MULTIPLE")) && (localBundle != null) && (localBundle.containsKey("android.intent.extra.STREAM")))
    {
      Log.i("MicroMsg.ShareImgUI", "send multi: ".concat(String.valueOf(str)));
      a(localBundle, new b()
      {
        public final void bG(ArrayList<String> paramAnonymousArrayList)
        {
          AppMethodBeat.i(39132);
          ShareImgUI.this.XNo = paramAnonymousArrayList;
          if ((ShareImgUI.this.XNo == null) || (ShareImgUI.this.XNo.size() == 0))
          {
            Log.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
            ShareImgUI.b(ShareImgUI.this);
            ShareImgUI.this.finish();
            AppMethodBeat.o(39132);
            return;
          }
          paramAnonymousArrayList = ShareImgUI.this.XNo.iterator();
          while (paramAnonymousArrayList.hasNext())
          {
            String str = (String)paramAnonymousArrayList.next();
            if (ImgUtil.isGif(str))
            {
              Log.i("MicroMsg.ShareImgUI", "%s is not image", new Object[] { str });
              ShareImgUI.b(ShareImgUI.this);
              ShareImgUI.this.finish();
              AppMethodBeat.o(39132);
              return;
            }
          }
          paramAnonymousArrayList = ShareImgUI.this.getIntent().resolveType(ShareImgUI.this);
          if ((paramAnonymousArrayList == null) || (!paramAnonymousArrayList.contains("image")))
          {
            Log.i("MicroMsg.ShareImgUI", "mime type is not image, try to set it");
            ShareImgUI.this.getIntent().setDataAndType(ShareImgUI.this.getIntent().getData(), "image/*");
          }
          ShareImgUI.c(ShareImgUI.this);
          AppMethodBeat.o(39132);
        }
      });
      AppMethodBeat.o(39144);
      return;
    }
    Log.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
    axt(0);
    finish();
    AppMethodBeat.o(39144);
  }
  
  private boolean bK(Intent paramIntent)
  {
    AppMethodBeat.i(39147);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.ShareImgUI", "intent is null");
      AppMethodBeat.o(39147);
      return false;
    }
    String str = IntentUtil.getStringExtra(paramIntent, "android.intent.extra.TEXT");
    paramIntent = IntentUtil.getStringExtra(paramIntent, "android.intent.extra.SUBJECT");
    if ((str == null) || (str.length() == 0))
    {
      Log.i("MicroMsg.ShareImgUI", "text is null");
      AppMethodBeat.o(39147);
      return false;
    }
    Object localObject2 = new WXMediaMessage(new WXTextObject(str));
    ((WXMediaMessage)localObject2).description = str;
    Object localObject1 = new SendMessageToWX.Req();
    ((SendMessageToWX.Req)localObject1).transaction = null;
    ((SendMessageToWX.Req)localObject1).message = ((WXMediaMessage)localObject2);
    localObject2 = new Bundle();
    ((SendMessageToWX.Req)localObject1).toBundle((Bundle)localObject2);
    ((Bundle)localObject2).putInt("_mmessage_sdkVersion", 637992960);
    ((Bundle)localObject2).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
    ((Bundle)localObject2).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
    localObject1 = new Intent();
    ((Intent)localObject1).setClass(this, SelectConversationUI.class);
    ((Intent)localObject1).putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras((Bundle)localObject2).putExtra("animation_pop_in", true));
    if ((bh.beJ()) && (!bh.aGE()))
    {
      bh.aGY().b(837, this);
      bh.aGY().a(837, this);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramIntent + "|" + str);
      paramIntent = new g(5, (List)localObject2, getCallerPackage());
      com.tencent.mm.kernel.h.aGY().a(paramIntent, 0);
      this.XUE.add(paramIntent);
      elK();
      this.qVX = ((Intent)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(39147);
      return true;
      Log.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
    }
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(39153);
    if ((this.iXX != null) && (this.iXX.isShowing())) {
      this.iXX.dismiss();
    }
    AppMethodBeat.o(39153);
  }
  
  private void elK()
  {
    AppMethodBeat.i(39152);
    if ((this.iXX != null) && (this.iXX.isShowing()))
    {
      AppMethodBeat.o(39152);
      return;
    }
    if (this.IOJ == null) {
      this.IOJ = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(39137);
          ShareImgUI.e(ShareImgUI.this);
          ShareImgUI.this.finish();
          AppMethodBeat.o(39137);
        }
      };
    }
    getString(R.l.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, this.IOJ);
    AppMethodBeat.o(39152);
  }
  
  private boolean hYC()
  {
    AppMethodBeat.i(39145);
    Intent localIntent = new Intent(this, ShareImgUI.class);
    if ("android.intent.action.SEND".equals(getIntent().getAction())) {
      if (!Util.isNullOrNil(this.filePath))
      {
        localIntent.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(this, new com.tencent.mm.vfs.q(this.filePath)));
        localIntent.setAction("android.intent.action.SEND");
        localIntent.setType(getIntent().getType());
      }
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), localIntent);
      AppMethodBeat.o(39145);
      return true;
      AppMethodBeat.o(39145);
      return false;
      if (!"android.intent.action.SEND_MULTIPLE".equals(getIntent().getAction())) {
        break label264;
      }
      if (Util.isNullOrNil(this.XNo)) {
        break;
      }
      ArrayList localArrayList = new ArrayList(this.XNo.size());
      Iterator localIterator = this.XNo.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(FileProviderHelper.getUriForFile(this, new com.tencent.mm.vfs.q((String)localIterator.next())));
      }
      localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
      localIntent.setAction("android.intent.action.SEND_MULTIPLE");
      localIntent.setType(getIntent().getType());
    }
    AppMethodBeat.o(39145);
    return false;
    label264:
    AppMethodBeat.o(39145);
    return false;
  }
  
  private void hYD()
  {
    AppMethodBeat.i(39151);
    Toast.makeText(this, R.l.emoji_custom_gif_max_size_limit_cannot_send, 1).show();
    finish();
    AppMethodBeat.o(39151);
  }
  
  public final boolean Z(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(39142);
    switch (7.sfH[parama.ordinal()])
    {
    default: 
      finish();
      b.lb(this);
      AppMethodBeat.o(39142);
      return;
    }
    this.intent = paramIntent;
    int i = Util.getInt(com.tencent.mm.n.h.axc().getValue("SystemShareControlBitset"), 0);
    Log.i("MicroMsg.ShareImgUI", "now permission = %d", new Object[] { Integer.valueOf(i) });
    if ((i & 0x1) > 0)
    {
      Log.e("MicroMsg.ShareImgUI", "now allowed to share to friend");
      finish();
      AppMethodBeat.o(39142);
      return;
    }
    parama = IntentUtil.getStringExtra(paramIntent, "android.intent.extra.TEXT");
    Log.i("MicroMsg.ShareImgUI", "postLogin, text = %s", new Object[] { parama });
    if (!Util.isNullOrNil(parama))
    {
      parama = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[] { URLEncoder.encode(parama) });
      elK();
      bh.aGY().b(1200, this);
      bh.aGY().a(1200, this);
      parama = new ac(parama, 15, null);
      bh.aGY().a(parama, 0);
      this.XUE.add(parama);
      AppMethodBeat.o(39142);
      return;
    }
    bBT();
    AppMethodBeat.o(39142);
  }
  
  public final boolean fje()
  {
    AppMethodBeat.i(39141);
    if ((!bh.beJ()) || (bh.aGE()))
    {
      Log.w("MicroMsg.ShareImgUI", "not login");
      this.intent = getIntent();
      bBT();
      AppMethodBeat.o(39141);
      return true;
    }
    AppMethodBeat.o(39141);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(230886);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.ShareImgUI", "ShareImgUI onCreate %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(230886);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39143);
    bh.aGY().b(1200, this);
    bh.aGY().b(837, this);
    dismissDialog();
    super.onDestroy();
    AppMethodBeat.o(39143);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(230895);
    super.onPause();
    Log.i("MicroMsg.ShareImgUI", "ShareImgUI onPause %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(230895);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(230891);
    super.onResume();
    Log.i("MicroMsg.ShareImgUI", "ShareImgUI onResume %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(230891);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(39154);
    int i;
    if (paramq != null)
    {
      i = paramq.getType();
      Log.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s, type: %d, hashCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i), Integer.valueOf(hashCode()) });
      if (paramq != null) {
        this.XUE.remove(paramq);
      }
      dismissDialog();
      if ((paramq instanceof ac))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label215;
        }
        bBT();
      }
      label105:
      if ((paramq instanceof g))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label222;
        }
        paramString = this.qVX;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(39154);
      return;
      i = -1;
      break;
      label215:
      finish();
      break label105;
      label222:
      if (paramq.getReqResp() != null)
      {
        paramString = (zo)d.c.b(((d)paramq.getReqResp()).lBS);
        if ((paramString != null) && (!Util.isNullOrNil(paramString.SlS)))
        {
          paramq = new Intent();
          paramq.putExtra("rawUrl", paramString.SlS);
          paramq.putExtra("showShare", false);
          paramq.putExtra("show_bottom", false);
          paramq.putExtra("needRedirect", false);
          c.b(this, "webview", ".ui.tools.WebViewUI", paramq);
        }
        else
        {
          paramString = this.qVX;
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements Runnable
  {
    private ShareImgUI.c XUP;
    private Uri mUri;
    
    public a(Uri paramUri, ShareImgUI.c paramc)
    {
      this.mUri = paramUri;
      this.XUP = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(39139);
      for (;;)
      {
        try
        {
          ShareImgUI.this.filePath = ShareImgUI.a(ShareImgUI.this, this.mUri);
          if ((Util.isNullOrNil(ShareImgUI.this.filePath)) || (!new com.tencent.mm.vfs.q(ShareImgUI.this.filePath).ifE()) || ((Build.VERSION.SDK_INT >= 30) && (!new com.tencent.mm.vfs.q(ShareImgUI.this.filePath).ifC())))
          {
            if (ShareImgUI.bAG(ShareImgUI.this.getContentResolver().getType(this.mUri)) != 3) {
              continue;
            }
            ShareImgUI.this.filePath = e.b(ShareImgUI.this.getContentResolver(), this.mUri);
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          String str1;
          String str2;
          Log.printErrStackTrace("MicroMsg.ShareImgUI", localNullPointerException, "", new Object[0]);
          ShareImgUI.this.filePath = null;
          return;
          Log.i("MicroMsg.ShareImgUI", "GetFilePathRunnable getShareFilePath is Success: " + ShareImgUI.this.filePath);
          continue;
        }
        catch (SQLiteDiskIOException localSQLiteDiskIOException)
        {
          Log.printErrStackTrace("MicroMsg.ShareImgUI", localSQLiteDiskIOException, "", new Object[0]);
          ShareImgUI.this.filePath = null;
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.printErrStackTrace("MicroMsg.ShareImgUI", localIllegalAccessException, "", new Object[0]);
          ShareImgUI.this.filePath = null;
          return;
        }
        finally
        {
          if (this.XUP == null) {
            continue;
          }
          this.XUP.hYj();
          AppMethodBeat.o(39139);
        }
        if (this.XUP == null) {
          break label464;
        }
        this.XUP.hYj();
        AppMethodBeat.o(39139);
        return;
        str1 = ShareImgUI.this.filePath;
        ShareImgUI.this.filePath = ShareImgUI.a(ShareImgUI.this, ShareImgUI.this.filePath, this.mUri);
        if ((u.agG(ShareImgUI.this.filePath)) && (new com.tencent.mm.vfs.q(ShareImgUI.this.filePath).ifC())) {
          continue;
        }
        str2 = ShareImgUI.this.filePath;
        ShareImgUI.this.filePath = e.a(ShareImgUI.this.getContentResolver(), this.mUri, 1);
        com.tencent.mm.plugin.base.stub.f.Gi(18);
        Log.e("MicroMsg.ShareImgUI", "GetFilePathRunnable getShareFilePath is not Success，use backup ShareUtil copyImg, path: %s , path2:%s , filePath: %s", new Object[] { str1, str2, ShareImgUI.this.filePath });
      }
      label464:
      AppMethodBeat.o(39139);
    }
  }
  
  static abstract interface b
  {
    public abstract void bG(ArrayList<String> paramArrayList);
  }
  
  public static abstract interface c
  {
    public abstract void hYj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI
 * JD-Core Version:    0.7.0.1
 */