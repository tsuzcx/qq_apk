package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDiskIOException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class ShareImgUI
  extends AutoLoginActivity
  implements com.tencent.mm.am.h
{
  private DialogInterface.OnCancelListener OTa;
  private Boolean XXw;
  ArrayList<String> afDC;
  private ArrayList<p> afKT;
  String filePath;
  private MMHandler handler;
  private Intent intent;
  private ProgressDialog lzP;
  private int mErrorType;
  Intent ubG;
  Uri uri;
  
  public ShareImgUI()
  {
    AppMethodBeat.i(39140);
    this.lzP = null;
    this.OTa = null;
    this.intent = null;
    this.afKT = new ArrayList();
    this.mErrorType = 0;
    this.filePath = null;
    this.uri = null;
    this.afDC = null;
    this.ubG = null;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(250940);
        if (Util.isNullOrNil(ShareImgUI.this.filePath))
        {
          Log.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
          ShareImgUI.a(ShareImgUI.this, ShareImgUI.c(ShareImgUI.this));
          ShareImgUI.this.finish();
          AppMethodBeat.o(250940);
          return;
        }
        ShareImgUI.b(ShareImgUI.this);
        AppMethodBeat.o(250940);
      }
    };
    this.XXw = null;
    AppMethodBeat.o(39140);
  }
  
  /* Error */
  private String a(Uri paramUri, Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +351 -> 357
    //   9: ldc 109
    //   11: astore 4
    //   13: aload_2
    //   14: ldc 111
    //   16: invokeinterface 117 2 0
    //   21: istore_3
    //   22: aload 4
    //   24: astore 5
    //   26: iload_3
    //   27: iconst_m1
    //   28: if_icmpeq +60 -> 88
    //   31: aload_2
    //   32: iload_3
    //   33: invokeinterface 121 2 0
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
    //   64: ldc 123
    //   66: ldc 125
    //   68: invokevirtual 131	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 5
    //   73: ldc 133
    //   75: ldc 135
    //   77: aload 5
    //   79: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokeinterface 151 1 0
    //   94: aload_0
    //   95: invokevirtual 155	com/tencent/mm/ui/tools/ShareImgUI:getContentResolver	()Landroid/content/ContentResolver;
    //   98: aload_1
    //   99: ldc 157
    //   101: invokevirtual 163	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 169	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   109: astore_2
    //   110: invokestatic 175	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   113: pop
    //   114: invokestatic 181	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   117: ifeq +271 -> 388
    //   120: new 183	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   127: invokestatic 190	com/tencent/mm/loader/i/b:bmz	()Ljava/lang/String;
    //   130: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 196
    //   135: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore 4
    //   143: new 183	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   150: invokestatic 190	com/tencent/mm/loader/i/b:bmz	()Ljava/lang/String;
    //   153: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 201
    //   158: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 5
    //   163: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore 8
    //   171: new 203	com/tencent/mm/vfs/u
    //   174: dup
    //   175: aload 4
    //   177: invokespecial 206	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   180: astore 4
    //   182: aload 4
    //   184: invokevirtual 209	com/tencent/mm/vfs/u:jKS	()Z
    //   187: ifne +9 -> 196
    //   190: aload 4
    //   192: invokevirtual 212	com/tencent/mm/vfs/u:jKY	()Z
    //   195: pop
    //   196: new 203	com/tencent/mm/vfs/u
    //   199: dup
    //   200: aload 8
    //   202: invokespecial 206	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   205: astore 4
    //   207: aload 4
    //   209: invokevirtual 209	com/tencent/mm/vfs/u:jKS	()Z
    //   212: ifne +9 -> 221
    //   215: aload 4
    //   217: invokevirtual 215	com/tencent/mm/vfs/u:jKZ	()Z
    //   220: pop
    //   221: aload 8
    //   223: iconst_0
    //   224: invokestatic 221	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
    //   263: invokevirtual 227	java/io/InputStream:read	([BII)I
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
    //   288: invokevirtual 233	java/io/OutputStream:write	([BII)V
    //   291: goto -45 -> 246
    //   294: astore 8
    //   296: aload 4
    //   298: astore 7
    //   300: aload_1
    //   301: astore 6
    //   303: aload_2
    //   304: astore 5
    //   306: ldc 133
    //   308: new 183	java/lang/StringBuilder
    //   311: dup
    //   312: ldc 235
    //   314: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: aload 8
    //   319: invokevirtual 239	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokevirtual 243	java/io/InputStream:close	()V
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 244	android/content/res/AssetFileDescriptor:close	()V
    //   347: aload 4
    //   349: ifnull +8 -> 357
    //   352: aload 4
    //   354: invokevirtual 245	java/io/OutputStream:close	()V
    //   357: ldc 107
    //   359: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: aconst_null
    //   363: areturn
    //   364: astore 5
    //   366: ldc 133
    //   368: ldc 247
    //   370: iconst_1
    //   371: anewarray 249	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload 5
    //   378: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   381: aastore
    //   382: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: goto -341 -> 44
    //   388: aload_0
    //   389: aload 5
    //   391: invokevirtual 258	com/tencent/mm/ui/tools/ShareImgUI:deleteFile	(Ljava/lang/String;)Z
    //   394: pop
    //   395: new 183	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   402: aload_0
    //   403: invokevirtual 262	com/tencent/mm/ui/tools/ShareImgUI:getFilesDir	()Ljava/io/File;
    //   406: invokevirtual 267	java/io/File:getPath	()Ljava/lang/String;
    //   409: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc_w 269
    //   415: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 5
    //   420: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: astore 8
    //   428: aload_0
    //   429: aload 5
    //   431: iconst_0
    //   432: invokevirtual 273	com/tencent/mm/ui/tools/ShareImgUI:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   435: astore 4
    //   437: goto -208 -> 229
    //   440: aload 4
    //   442: astore 7
    //   444: aload_1
    //   445: astore 6
    //   447: aload_2
    //   448: astore 5
    //   450: aload 4
    //   452: invokevirtual 276	java/io/OutputStream:flush	()V
    //   455: aload 4
    //   457: astore 7
    //   459: aload_1
    //   460: astore 6
    //   462: aload_2
    //   463: astore 5
    //   465: aload 4
    //   467: invokevirtual 245	java/io/OutputStream:close	()V
    //   470: aload_2
    //   471: ifnull +7 -> 478
    //   474: aload_2
    //   475: invokevirtual 243	java/io/InputStream:close	()V
    //   478: aload_1
    //   479: ifnull +7 -> 486
    //   482: aload_1
    //   483: invokevirtual 244	android/content/res/AssetFileDescriptor:close	()V
    //   486: aload 4
    //   488: ifnull +8 -> 496
    //   491: aload 4
    //   493: invokevirtual 245	java/io/OutputStream:close	()V
    //   496: ldc 107
    //   498: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   523: ldc 133
    //   525: new 183	java/lang/StringBuilder
    //   528: dup
    //   529: ldc_w 278
    //   532: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   535: aload 8
    //   537: invokevirtual 279	java/io/IOException:getMessage	()Ljava/lang/String;
    //   540: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: aload_2
    //   550: ifnull +7 -> 557
    //   553: aload_2
    //   554: invokevirtual 243	java/io/InputStream:close	()V
    //   557: aload_1
    //   558: ifnull +7 -> 565
    //   561: aload_1
    //   562: invokevirtual 244	android/content/res/AssetFileDescriptor:close	()V
    //   565: aload 4
    //   567: ifnull -210 -> 357
    //   570: aload 4
    //   572: invokevirtual 245	java/io/OutputStream:close	()V
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
    //   601: ldc 133
    //   603: new 183	java/lang/StringBuilder
    //   606: dup
    //   607: ldc_w 281
    //   610: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   613: aload 8
    //   615: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   618: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: aload 4
    //   629: astore 7
    //   631: aload_1
    //   632: astore 6
    //   634: aload_2
    //   635: astore 5
    //   637: ldc 133
    //   639: aload 8
    //   641: invokevirtual 282	java/lang/Exception:toString	()Ljava/lang/String;
    //   644: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload_2
    //   648: ifnull +7 -> 655
    //   651: aload_2
    //   652: invokevirtual 243	java/io/InputStream:close	()V
    //   655: aload_1
    //   656: ifnull +7 -> 663
    //   659: aload_1
    //   660: invokevirtual 244	android/content/res/AssetFileDescriptor:close	()V
    //   663: aload 4
    //   665: ifnull -308 -> 357
    //   668: aload 4
    //   670: invokevirtual 245	java/io/OutputStream:close	()V
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
    //   694: invokevirtual 243	java/io/InputStream:close	()V
    //   697: aload_1
    //   698: ifnull +7 -> 705
    //   701: aload_1
    //   702: invokevirtual 244	android/content/res/AssetFileDescriptor:close	()V
    //   705: aload 7
    //   707: ifnull +8 -> 715
    //   710: aload 7
    //   712: invokevirtual 245	java/io/OutputStream:close	()V
    //   715: ldc 107
    //   717: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	840	2	paramCursor	Cursor
    //   21	267	3	i	int
    //   11	658	4	localObject1	Object
    //   680	41	4	localObject2	Object
    //   727	1	4	localObject3	Object
    //   737	1	4	localObject4	Object
    //   745	1	4	localObject5	Object
    //   759	73	4	localObject6	Object
    //   24	281	5	localObject7	Object
    //   364	66	5	localException1	Exception
    //   448	303	5	localCursor	Cursor
    //   234	514	6	localUri	Uri
    //   231	510	7	localObject8	Object
    //   169	53	8	str1	String
    //   294	24	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   426	76	8	str2	String
    //   504	32	8	localIOException1	java.io.IOException
    //   582	58	8	localException2	Exception
    //   756	1	8	localException3	Exception
    //   766	1	8	localException4	Exception
    //   774	1	8	localException5	Exception
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
    //   0: ldc_w 294
    //   3: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 94	com/tencent/mm/ui/tools/ShareImgUI:XXw	Ljava/lang/Boolean;
    //   10: ifnonnull +55 -> 65
    //   13: ldc_w 296
    //   16: invokestatic 302	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   19: checkcast 296	com/tencent/mm/plugin/expt/b/c
    //   22: getstatic 308	com/tencent/mm/plugin/expt/b/c$a:yWK	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   25: iconst_1
    //   26: invokeinterface 311 3 0
    //   31: iconst_1
    //   32: if_icmpeq +21 -> 53
    //   35: getstatic 317	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   38: ifne +15 -> 53
    //   41: getstatic 320	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   44: ifne +9 -> 53
    //   47: invokestatic 325	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   50: ifeq +63 -> 113
    //   53: iconst_1
    //   54: istore 4
    //   56: aload_0
    //   57: iload 4
    //   59: invokestatic 330	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   62: putfield 94	com/tencent/mm/ui/tools/ShareImgUI:XXw	Ljava/lang/Boolean;
    //   65: ldc 133
    //   67: new 183	java/lang/StringBuilder
    //   70: dup
    //   71: ldc_w 332
    //   74: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload_0
    //   78: getfield 94	com/tencent/mm/ui/tools/ShareImgUI:XXw	Ljava/lang/Boolean;
    //   81: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 94	com/tencent/mm/ui/tools/ShareImgUI:XXw	Ljava/lang/Boolean;
    //   94: invokevirtual 338	java/lang/Boolean:booleanValue	()Z
    //   97: ifne +22 -> 119
    //   100: bipush 10
    //   102: invokestatic 343	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   105: ldc_w 294
    //   108: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_1
    //   112: areturn
    //   113: iconst_0
    //   114: istore 4
    //   116: goto -60 -> 56
    //   119: aload_1
    //   120: invokestatic 348	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   123: ifne +57 -> 180
    //   126: new 203	com/tencent/mm/vfs/u
    //   129: dup
    //   130: aload_1
    //   131: invokespecial 206	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   134: astore 9
    //   136: aload 9
    //   138: invokevirtual 209	com/tencent/mm/vfs/u:jKS	()Z
    //   141: ifeq +39 -> 180
    //   144: aload 9
    //   146: invokevirtual 351	com/tencent/mm/vfs/u:jKQ	()Z
    //   149: ifeq +31 -> 180
    //   152: bipush 17
    //   154: invokestatic 343	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   157: ldc 133
    //   159: ldc_w 353
    //   162: aload_1
    //   163: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   166: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: ldc_w 294
    //   175: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload_1
    //   179: areturn
    //   180: bipush 11
    //   182: invokestatic 343	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   185: aload_0
    //   186: invokevirtual 155	com/tencent/mm/ui/tools/ShareImgUI:getContentResolver	()Landroid/content/ContentResolver;
    //   189: aload_2
    //   190: invokevirtual 357	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   193: astore 9
    //   195: aload 9
    //   197: ifnull +351 -> 548
    //   200: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   203: lstore 7
    //   205: aload_1
    //   206: invokestatic 348	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   209: ifeq +53 -> 262
    //   212: ldc_w 365
    //   215: astore 10
    //   217: aload 10
    //   219: invokestatic 348	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   222: ifeq +68 -> 290
    //   225: ldc 133
    //   227: ldc_w 367
    //   230: aload_1
    //   231: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   234: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: bipush 12
    //   242: invokestatic 343	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   245: aload 9
    //   247: invokestatic 371	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   250: aconst_null
    //   251: invokestatic 371	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   254: ldc_w 294
    //   257: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload_1
    //   261: areturn
    //   262: new 183	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   269: invokestatic 376	com/tencent/mm/plugin/openapi/a:gxj	()Ljava/lang/String;
    //   272: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokestatic 381	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   279: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: astore 10
    //   287: goto -70 -> 217
    //   290: aload 10
    //   292: invokestatic 384	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   295: ifeq +25 -> 320
    //   298: ldc 133
    //   300: ldc_w 386
    //   303: aload 10
    //   305: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   308: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   311: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload 10
    //   316: invokestatic 387	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   319: pop
    //   320: aload 10
    //   322: iconst_0
    //   323: invokestatic 221	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   326: astore_2
    //   327: sipush 4096
    //   330: newarray byte
    //   332: astore 11
    //   334: lconst_0
    //   335: lstore 5
    //   337: aload 9
    //   339: aload 11
    //   341: invokevirtual 390	java/io/InputStream:read	([B)I
    //   344: istore_3
    //   345: iload_3
    //   346: iconst_m1
    //   347: if_icmpeq +19 -> 366
    //   350: aload_2
    //   351: aload 11
    //   353: invokevirtual 393	java/io/OutputStream:write	([B)V
    //   356: lload 5
    //   358: iload_3
    //   359: i2l
    //   360: ladd
    //   361: lstore 5
    //   363: goto -26 -> 337
    //   366: ldc 133
    //   368: new 183	java/lang/StringBuilder
    //   371: dup
    //   372: ldc_w 395
    //   375: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   378: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   381: lload 7
    //   383: lsub
    //   384: invokevirtual 398	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   387: ldc_w 400
    //   390: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: lload 5
    //   395: l2f
    //   396: ldc_w 401
    //   399: fdiv
    //   400: invokevirtual 404	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   403: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: new 203	com/tencent/mm/vfs/u
    //   412: dup
    //   413: aload 10
    //   415: invokespecial 206	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   418: astore 11
    //   420: aload 11
    //   422: invokevirtual 209	com/tencent/mm/vfs/u:jKS	()Z
    //   425: ifeq +52 -> 477
    //   428: aload 11
    //   430: invokevirtual 351	com/tencent/mm/vfs/u:jKQ	()Z
    //   433: ifeq +44 -> 477
    //   436: ldc 133
    //   438: ldc_w 406
    //   441: aload 10
    //   443: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   446: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   449: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: bipush 13
    //   454: invokestatic 343	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   457: aload 10
    //   459: astore_1
    //   460: aload 9
    //   462: invokestatic 371	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   465: aload_2
    //   466: invokestatic 371	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   469: ldc_w 294
    //   472: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   475: aload_1
    //   476: areturn
    //   477: ldc 133
    //   479: ldc_w 408
    //   482: aload_1
    //   483: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   486: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   489: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: bipush 14
    //   494: invokestatic 343	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   497: goto -37 -> 460
    //   500: astore 10
    //   502: ldc 133
    //   504: aload 10
    //   506: ldc_w 365
    //   509: iconst_0
    //   510: anewarray 249	java/lang/Object
    //   513: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   516: ldc 133
    //   518: ldc_w 416
    //   521: aload_1
    //   522: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   525: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   528: invokestatic 242	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: bipush 16
    //   533: invokestatic 343	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   536: aload 9
    //   538: invokestatic 371	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   541: aload_2
    //   542: invokestatic 371	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   545: goto -76 -> 469
    //   548: ldc 133
    //   550: ldc_w 418
    //   553: aload_1
    //   554: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   557: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   560: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: bipush 15
    //   565: invokestatic 343	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   568: aconst_null
    //   569: astore_2
    //   570: goto -110 -> 460
    //   573: astore_1
    //   574: aconst_null
    //   575: astore_2
    //   576: aconst_null
    //   577: astore 9
    //   579: aload 9
    //   581: invokestatic 371	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   584: aload_2
    //   585: invokestatic 371	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   588: ldc_w 294
    //   591: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   594: aload_1
    //   595: athrow
    //   596: astore_1
    //   597: aconst_null
    //   598: astore_2
    //   599: goto -20 -> 579
    //   602: astore_1
    //   603: goto -24 -> 579
    //   606: astore_1
    //   607: goto -28 -> 579
    //   610: astore 10
    //   612: aconst_null
    //   613: astore_2
    //   614: aconst_null
    //   615: astore 9
    //   617: goto -115 -> 502
    //   620: astore 10
    //   622: aconst_null
    //   623: astore_2
    //   624: goto -122 -> 502
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	ShareImgUI
    //   0	627	1	paramString	String
    //   0	627	2	paramUri	Uri
    //   344	15	3	i	int
    //   54	61	4	bool	boolean
    //   335	59	5	l1	long
    //   203	179	7	l2	long
    //   134	482	9	localObject1	Object
    //   215	243	10	str	String
    //   500	5	10	localException1	Exception
    //   610	1	10	localException2	Exception
    //   620	1	10	localException3	Exception
    //   332	97	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   327	334	500	java/lang/Exception
    //   337	345	500	java/lang/Exception
    //   350	356	500	java/lang/Exception
    //   366	457	500	java/lang/Exception
    //   477	497	500	java/lang/Exception
    //   185	195	573	finally
    //   200	212	596	finally
    //   217	245	596	finally
    //   262	287	596	finally
    //   290	320	596	finally
    //   320	327	596	finally
    //   548	568	596	finally
    //   327	334	602	finally
    //   337	345	602	finally
    //   350	356	602	finally
    //   366	457	602	finally
    //   477	497	602	finally
    //   502	536	606	finally
    //   185	195	610	java/lang/Exception
    //   200	212	620	java/lang/Exception
    //   217	245	620	java/lang/Exception
    //   262	287	620	java/lang/Exception
    //   290	320	620	java/lang/Exception
    //   320	327	620	java/lang/Exception
    //   548	568	620	java/lang/Exception
  }
  
  private void a(final Bundle paramBundle, final b paramb)
  {
    AppMethodBeat.i(39146);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(250937);
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
              AppMethodBeat.i(251029);
              if (!ShareImgUI.a(ShareImgUI.this, this.afKX, localParcelable)) {
                this.afKZ[0] = true;
              }
              this.afLa.countDown();
              AppMethodBeat.o(251029);
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
              AppMethodBeat.o(250937);
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
              Log.i("MicroMsg.ShareImgUI", "hy: getMultiSendFilePathList done. using: %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.afKW) });
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
          AppMethodBeat.o(250937);
          return;
        }
      }
    }, "getMultiSendFilePathList");
    AppMethodBeat.o(39146);
  }
  
  private void aDM()
  {
    AppMethodBeat.i(39153);
    if ((this.lzP != null) && (this.lzP.isShowing())) {
      this.lzP.dismiss();
    }
    AppMethodBeat.o(39153);
  }
  
  private void aEc(int paramInt)
  {
    AppMethodBeat.i(39150);
    switch (paramInt)
    {
    default: 
      Toast.makeText(this, R.l.gWk, 1).show();
      AppMethodBeat.o(39150);
      return;
    case 1: 
      Toast.makeText(this, R.l.gWh, 1).show();
      AppMethodBeat.o(39150);
      return;
    }
    Toast.makeText(this, R.l.gWg, 1).show();
    AppMethodBeat.o(39150);
  }
  
  private static int bCu(String paramString)
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
  
  private void cbq()
  {
    AppMethodBeat.i(39144);
    if (this.intent == null)
    {
      Log.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
      aEc(0);
      finish();
      AppMethodBeat.o(39144);
      return;
    }
    String str = this.intent.getAction();
    Bundle localBundle = this.intent.getExtras();
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
      aEc(0);
      finish();
      AppMethodBeat.o(39144);
      return;
    }
    if (localBundle != null)
    {
      localObject = localBundle.getParcelable("android.intent.extra.STREAM");
      if ((localObject != null) && ((localObject instanceof Uri)))
      {
        this.uri = ((Uri)localObject);
        if (!Util.isUriSafeToBeCopySrc(this.uri))
        {
          Log.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", new Object[] { this.uri });
          aEc(0);
          finish();
          AppMethodBeat.o(39144);
          return;
        }
      }
    }
    getString(R.l.permission_tips_title);
    Object localObject = getString(R.l.gallery_permission_msg);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, (String)localObject);
    Log.i("MicroMsg.ShareImgUI", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      z(str, localBundle);
    }
    AppMethodBeat.o(39144);
  }
  
  private boolean cp(Intent paramIntent)
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
    ((Bundle)localObject2).putInt("_mmessage_sdkVersion", 638058496);
    ((Bundle)localObject2).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
    ((Bundle)localObject2).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
    localObject1 = new Intent();
    ((Intent)localObject1).setClass(this, SelectConversationUI.class);
    ((Intent)localObject1).putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras((Bundle)localObject2).putExtra("animation_pop_in", true));
    if ((bh.bCA()) && (!bh.aZG()))
    {
      bh.aZW().b(837, this);
      bh.aZW().a(837, this);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramIntent + "|" + str);
      paramIntent = new com.tencent.mm.modelsimple.i(5, (List)localObject2, getCallerPackage());
      com.tencent.mm.kernel.h.aZW().a(paramIntent, 0);
      this.afKT.add(paramIntent);
      fpM();
      this.ubG = ((Intent)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(39147);
      return true;
      Log.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
    }
  }
  
  private void fpM()
  {
    AppMethodBeat.i(39152);
    if ((this.lzP != null) && (this.lzP.isShowing()))
    {
      AppMethodBeat.o(39152);
      return;
    }
    if (this.OTa == null) {
      this.OTa = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(250942);
          ShareImgUI.e(ShareImgUI.this);
          ShareImgUI.this.finish();
          AppMethodBeat.o(250942);
        }
      };
    }
    getString(R.l.app_tip);
    this.lzP = com.tencent.mm.ui.base.k.a(this, getString(R.l.app_waiting), true, this.OTa);
    AppMethodBeat.o(39152);
  }
  
  private boolean jDl()
  {
    AppMethodBeat.i(39145);
    Intent localIntent = new Intent(this, ShareImgUI.class);
    if ("android.intent.action.SEND".equals(getIntent().getAction())) {
      if (!Util.isNullOrNil(this.filePath))
      {
        localIntent.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(this, new u(this.filePath)));
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
      if (Util.isNullOrNil(this.afDC)) {
        break;
      }
      ArrayList localArrayList = new ArrayList(this.afDC.size());
      Iterator localIterator = this.afDC.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(FileProviderHelper.getUriForFile(this, new u((String)localIterator.next())));
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
  
  private void jDm()
  {
    AppMethodBeat.i(39151);
    Toast.makeText(this, R.l.emoji_custom_gif_max_size_limit_cannot_send, 1).show();
    finish();
    AppMethodBeat.o(39151);
  }
  
  private String t(Uri paramUri)
  {
    AppMethodBeat.i(251159);
    if (paramUri == null)
    {
      Log.e("MicroMsg.ShareImgUI", "uri is null!");
      AppMethodBeat.o(251159);
      return null;
    }
    Object localObject = paramUri.getScheme();
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.ShareImgUI", "input uri error. %s", new Object[] { paramUri });
      AppMethodBeat.o(251159);
      return null;
    }
    if (((String)localObject).equalsIgnoreCase("file"))
    {
      Log.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_FILE");
      paramUri = paramUri.getPath();
      localObject = e.bqz(paramUri);
      if (localObject != null)
      {
        AppMethodBeat.o(251159);
        return localObject;
      }
      Log.e("MicroMsg.ShareImgUI", "[-] getFilePath : fail, safePath is null.");
      paramUri = new IllegalAccessException("safePath is null while process path: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(251159);
      throw paramUri;
    }
    if (((String)localObject).equalsIgnoreCase("content")) {
      try
      {
        Log.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_CONTENT: " + paramUri.toString());
        localObject = getContentResolver().query(paramUri, null, null, null, null);
        if (localObject == null)
        {
          Log.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor is null");
          AppMethodBeat.o(251159);
          return null;
        }
        if ((((Cursor)localObject).getCount() <= 0) || (!((Cursor)localObject).moveToFirst()))
        {
          ((Cursor)localObject).close();
          Log.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
          AppMethodBeat.o(251159);
          return null;
        }
        String str = paramUri.toString().toLowerCase();
        if ((str.startsWith("content://com.android.contacts/contacts/as_vcard")) || (str.startsWith("content://com.android.contacts/contacts/as_multi_vcard")) || (str.startsWith("content://com.mediatek.calendarimporter")) || ((this.intent != null) && (this.intent.getType().equals("text/x-vcalendar"))) || (af.lYj.lUm == 1))
        {
          paramUri = a(paramUri, (Cursor)localObject);
          AppMethodBeat.o(251159);
          return paramUri;
        }
        ((Cursor)localObject).close();
        paramUri = Util.getFilePath(this, paramUri);
        AppMethodBeat.o(251159);
        return paramUri;
      }
      catch (Exception paramUri)
      {
        Log.printErrStackTrace("MicroMsg.ShareImgUI", paramUri, "SCHEME_CONTENT", new Object[0]);
      }
    }
    Log.e("MicroMsg.ShareImgUI", "unknown scheme");
    AppMethodBeat.o(251159);
    return null;
  }
  
  private void z(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(251153);
    l.kK(3, 11);
    fpM();
    if (paramString.equals("android.intent.action.SEND"))
    {
      Log.i("MicroMsg.ShareImgUI", "send signal: ".concat(String.valueOf(paramString)));
      if (this.uri == null)
      {
        boolean bool = cp(getIntent());
        Log.i("MicroMsg.ShareImgUI", "dealWithText: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          aEc(0);
          finish();
        }
        AppMethodBeat.o(251153);
        return;
      }
      ThreadPool.post(new a(this.uri, new c()
      {
        public final void jCT()
        {
          AppMethodBeat.i(39131);
          ShareImgUI.a(ShareImgUI.this).sendEmptyMessage(0);
          AppMethodBeat.o(39131);
        }
      }), "ShareImgUI_getFilePath");
      AppMethodBeat.o(251153);
      return;
    }
    if ((paramString.equals("android.intent.action.SEND_MULTIPLE")) && (paramBundle != null) && (paramBundle.containsKey("android.intent.extra.STREAM")))
    {
      Log.i("MicroMsg.ShareImgUI", "send multi: ".concat(String.valueOf(paramString)));
      a(paramBundle, new b()
      {
        public final void cg(ArrayList<String> paramAnonymousArrayList)
        {
          AppMethodBeat.i(39132);
          ShareImgUI.this.afDC = paramAnonymousArrayList;
          if ((ShareImgUI.this.afDC == null) || (ShareImgUI.this.afDC.size() == 0))
          {
            Log.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
            ShareImgUI.a(ShareImgUI.this, 1);
            ShareImgUI.this.finish();
            AppMethodBeat.o(39132);
            return;
          }
          paramAnonymousArrayList = ShareImgUI.this.afDC.iterator();
          while (paramAnonymousArrayList.hasNext())
          {
            String str = (String)paramAnonymousArrayList.next();
            if (ImgUtil.isGif(str))
            {
              Log.i("MicroMsg.ShareImgUI", "%s is not image", new Object[] { str });
              ShareImgUI.a(ShareImgUI.this, 1);
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
          ShareImgUI.b(ShareImgUI.this);
          AppMethodBeat.o(39132);
        }
      });
      AppMethodBeat.o(251153);
      return;
    }
    Log.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
    aEc(0);
    finish();
    AppMethodBeat.o(251153);
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(39142);
    switch (ShareImgUI.9.vrD[parama.ordinal()])
    {
    default: 
      finish();
      com.tencent.mm.ui.base.b.nf(this);
      AppMethodBeat.o(39142);
      return;
    }
    this.intent = paramIntent;
    int i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("SystemShareControlBitset"), 0);
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
      fpM();
      bh.aZW().b(1200, this);
      bh.aZW().a(1200, this);
      parama = new ad(parama, 15, null);
      bh.aZW().a(parama, 0);
      this.afKT.add(parama);
      AppMethodBeat.o(39142);
      return;
    }
    cbq();
    AppMethodBeat.o(39142);
  }
  
  public final boolean ad(Intent paramIntent)
  {
    return true;
  }
  
  public final boolean gtu()
  {
    AppMethodBeat.i(39141);
    if ((!bh.bCA()) || (bh.aZG()))
    {
      Log.w("MicroMsg.ShareImgUI", "not login");
      this.intent = getIntent();
      cbq();
      AppMethodBeat.o(39141);
      return true;
    }
    AppMethodBeat.o(39141);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(251245);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.ShareImgUI", "ShareImgUI onCreate %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(251245);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39143);
    bh.aZW().b(1200, this);
    bh.aZW().b(837, this);
    aDM();
    super.onDestroy();
    AppMethodBeat.o(39143);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(251260);
    super.onPause();
    Log.i("MicroMsg.ShareImgUI", "ShareImgUI onPause %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(251260);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(251279);
    if (paramArrayOfInt.length <= 0)
    {
      Log.i("MicroMsg.ShareImgUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(251279);
      return;
    }
    Log.i("MicroMsg.ShareImgUI", "onRequestPermissionsResult requestCode[%d], grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(251279);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        if (this.intent == null) {
          this.intent = getIntent();
        }
        if ((this.intent != null) && (this.intent.getAction() != null))
        {
          z(this.intent.getAction(), this.intent.getExtras());
          AppMethodBeat.o(251279);
        }
      }
      else
      {
        com.tencent.mm.ui.base.k.a(this, getString(R.l.permission_gallery_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.gallery_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(250933);
            com.tencent.mm.pluginsdk.permission.b.lx(ShareImgUI.this.getContext());
            ShareImgUI.this.finish();
            AppMethodBeat.o(250933);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(250939);
            ShareImgUI.this.finish();
            AppMethodBeat.o(250939);
          }
        });
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(251253);
    super.onResume();
    Log.i("MicroMsg.ShareImgUI", "ShareImgUI onResume %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(251253);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(39154);
    int i;
    if (paramp != null)
    {
      i = paramp.getType();
      Log.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s, type: %d, hashCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i), Integer.valueOf(hashCode()) });
      if (paramp != null) {
        this.afKT.remove(paramp);
      }
      aDM();
      if ((paramp instanceof ad))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label215;
        }
        cbq();
      }
      label105:
      if ((paramp instanceof com.tencent.mm.modelsimple.i))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label222;
        }
        paramString = this.ubG;
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
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
      if (paramp.getReqResp() != null)
      {
        paramString = (abm)c.c.b(((com.tencent.mm.am.c)paramp.getReqResp()).otC);
        if ((paramString != null) && (!Util.isNullOrNil(paramString.Zkd)))
        {
          paramp = new Intent();
          paramp.putExtra("rawUrl", paramString.Zkd);
          paramp.putExtra("showShare", false);
          paramp.putExtra("show_bottom", false);
          paramp.putExtra("needRedirect", false);
          com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramp);
        }
        else
        {
          paramString = this.ubG;
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sb(0));
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
    private ShareImgUI.c afLd;
    private Uri mUri;
    
    public a(Uri paramUri, ShareImgUI.c paramc)
    {
      this.mUri = paramUri;
      this.afLd = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(39139);
      for (;;)
      {
        try
        {
          ShareImgUI.this.filePath = ShareImgUI.a(ShareImgUI.this, this.mUri);
          if ((Util.isNullOrNil(ShareImgUI.this.filePath)) || (!new u(ShareImgUI.this.filePath).jKS()) || ((Build.VERSION.SDK_INT >= 30) && (!new u(ShareImgUI.this.filePath).jKQ())))
          {
            str1 = ShareImgUI.this.getContentResolver().getType(this.mUri);
            if (ShareImgUI.bCC(str1) != 3) {
              continue;
            }
            ShareImgUI.this.filePath = e.b(ShareImgUI.this.getContentResolver(), this.mUri);
            if ((Util.isNullOrNil(ShareImgUI.this.filePath)) && (str1.equals("text/x-vcard")) && (!com.tencent.mm.pluginsdk.permission.b.k(ShareImgUI.this, "android.permission.READ_CONTACTS", false))) {
              ShareImgUI.d(ShareImgUI.this);
            }
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
          if (this.afLd == null) {
            continue;
          }
          this.afLd.jCT();
          AppMethodBeat.o(39139);
        }
        if (this.afLd == null) {
          break label509;
        }
        this.afLd.jCT();
        AppMethodBeat.o(39139);
        return;
        str1 = ShareImgUI.this.filePath;
        ShareImgUI.this.filePath = ShareImgUI.a(ShareImgUI.this, ShareImgUI.this.filePath, this.mUri);
        if ((y.ZC(ShareImgUI.this.filePath)) && (new u(ShareImgUI.this.filePath).jKQ())) {
          continue;
        }
        str2 = ShareImgUI.this.filePath;
        ShareImgUI.this.filePath = e.a(ShareImgUI.this.getContentResolver(), this.mUri, 1);
        com.tencent.mm.plugin.base.stub.f.GH(18);
        Log.e("MicroMsg.ShareImgUI", "GetFilePathRunnable getShareFilePath is not Success，use backup ShareUtil copyImg, path: %s , path2:%s , filePath: %s", new Object[] { str1, str2, ShareImgUI.this.filePath });
      }
      label509:
      AppMethodBeat.o(39139);
    }
  }
  
  static abstract interface b
  {
    public abstract void cg(ArrayList<String> paramArrayList);
  }
  
  public static abstract interface c
  {
    public abstract void jCT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI
 * JD-Core Version:    0.7.0.1
 */