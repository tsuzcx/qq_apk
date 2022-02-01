package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.sqlite.SQLiteDiskIOException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.mm.vfs.k;
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
  implements f
{
  ArrayList<String> Laa;
  private ProgressDialog fOC;
  String filePath;
  private aq handler;
  private Intent intent;
  Intent mHz;
  Uri uri;
  
  public ShareImgUI()
  {
    AppMethodBeat.i(39140);
    this.fOC = null;
    this.intent = null;
    this.filePath = null;
    this.uri = null;
    this.Laa = null;
    this.mHz = null;
    this.handler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(39133);
        if (bu.isNullOrNil(ShareImgUI.this.filePath))
        {
          ae.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
          ShareImgUI.d(ShareImgUI.this);
          ShareImgUI.this.finish();
          AppMethodBeat.o(39133);
          return;
        }
        ShareImgUI.c(ShareImgUI.this);
        AppMethodBeat.o(39133);
      }
    };
    AppMethodBeat.o(39140);
  }
  
  /* Error */
  private String a(Uri paramUri, android.database.Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc 95
    //   2: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +351 -> 357
    //   9: ldc 97
    //   11: astore 4
    //   13: aload_2
    //   14: ldc 99
    //   16: invokeinterface 105 2 0
    //   21: istore_3
    //   22: aload 4
    //   24: astore 5
    //   26: iload_3
    //   27: iconst_m1
    //   28: if_icmpeq +60 -> 88
    //   31: aload_2
    //   32: iload_3
    //   33: invokeinterface 109 2 0
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
    //   64: ldc 111
    //   66: ldc 113
    //   68: invokevirtual 119	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 5
    //   73: ldc 121
    //   75: ldc 123
    //   77: aload 5
    //   79: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 131	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 136	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokeinterface 139 1 0
    //   94: aload_0
    //   95: invokevirtual 143	com/tencent/mm/ui/tools/ShareImgUI:getContentResolver	()Landroid/content/ContentResolver;
    //   98: aload_1
    //   99: ldc 145
    //   101: invokevirtual 151	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 157	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   109: astore_2
    //   110: invokestatic 163	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   113: pop
    //   114: invokestatic 169	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   117: ifeq +271 -> 388
    //   120: new 171	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   127: invokestatic 178	com/tencent/mm/loader/j/b:asj	()Ljava/lang/String;
    //   130: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 184
    //   135: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore 4
    //   143: new 171	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   150: invokestatic 178	com/tencent/mm/loader/j/b:asj	()Ljava/lang/String;
    //   153: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 189
    //   158: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 5
    //   163: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore 8
    //   171: new 191	com/tencent/mm/vfs/k
    //   174: dup
    //   175: aload 4
    //   177: invokespecial 194	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   180: astore 4
    //   182: aload 4
    //   184: invokevirtual 197	com/tencent/mm/vfs/k:exists	()Z
    //   187: ifne +9 -> 196
    //   190: aload 4
    //   192: invokevirtual 200	com/tencent/mm/vfs/k:mkdirs	()Z
    //   195: pop
    //   196: new 191	com/tencent/mm/vfs/k
    //   199: dup
    //   200: aload 8
    //   202: invokespecial 194	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   205: astore 4
    //   207: aload 4
    //   209: invokevirtual 197	com/tencent/mm/vfs/k:exists	()Z
    //   212: ifne +9 -> 221
    //   215: aload 4
    //   217: invokevirtual 203	com/tencent/mm/vfs/k:createNewFile	()Z
    //   220: pop
    //   221: aload 8
    //   223: iconst_0
    //   224: invokestatic 209	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
    //   263: invokevirtual 215	java/io/InputStream:read	([BII)I
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
    //   288: invokevirtual 221	java/io/OutputStream:write	([BII)V
    //   291: goto -45 -> 246
    //   294: astore 8
    //   296: aload 4
    //   298: astore 7
    //   300: aload_1
    //   301: astore 6
    //   303: aload_2
    //   304: astore 5
    //   306: ldc 121
    //   308: new 171	java/lang/StringBuilder
    //   311: dup
    //   312: ldc 223
    //   314: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: aload 8
    //   319: invokevirtual 227	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 230	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokevirtual 231	java/io/InputStream:close	()V
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 232	android/content/res/AssetFileDescriptor:close	()V
    //   347: aload 4
    //   349: ifnull +8 -> 357
    //   352: aload 4
    //   354: invokevirtual 233	java/io/OutputStream:close	()V
    //   357: ldc 95
    //   359: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: aconst_null
    //   363: areturn
    //   364: astore 5
    //   366: ldc 121
    //   368: ldc 235
    //   370: iconst_1
    //   371: anewarray 237	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload 5
    //   378: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   381: aastore
    //   382: invokestatic 242	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: goto -341 -> 44
    //   388: aload_0
    //   389: aload 5
    //   391: invokevirtual 246	com/tencent/mm/ui/tools/ShareImgUI:deleteFile	(Ljava/lang/String;)Z
    //   394: pop
    //   395: new 171	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   402: aload_0
    //   403: invokevirtual 250	com/tencent/mm/ui/tools/ShareImgUI:getFilesDir	()Ljava/io/File;
    //   406: invokevirtual 255	java/io/File:getPath	()Ljava/lang/String;
    //   409: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc_w 257
    //   415: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 5
    //   420: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: astore 8
    //   428: aload_0
    //   429: aload 5
    //   431: iconst_0
    //   432: invokevirtual 261	com/tencent/mm/ui/tools/ShareImgUI:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   435: astore 4
    //   437: goto -208 -> 229
    //   440: aload 4
    //   442: astore 7
    //   444: aload_1
    //   445: astore 6
    //   447: aload_2
    //   448: astore 5
    //   450: aload 4
    //   452: invokevirtual 264	java/io/OutputStream:flush	()V
    //   455: aload 4
    //   457: astore 7
    //   459: aload_1
    //   460: astore 6
    //   462: aload_2
    //   463: astore 5
    //   465: aload 4
    //   467: invokevirtual 233	java/io/OutputStream:close	()V
    //   470: aload_2
    //   471: ifnull +7 -> 478
    //   474: aload_2
    //   475: invokevirtual 231	java/io/InputStream:close	()V
    //   478: aload_1
    //   479: ifnull +7 -> 486
    //   482: aload_1
    //   483: invokevirtual 232	android/content/res/AssetFileDescriptor:close	()V
    //   486: aload 4
    //   488: ifnull +8 -> 496
    //   491: aload 4
    //   493: invokevirtual 233	java/io/OutputStream:close	()V
    //   496: ldc 95
    //   498: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   523: ldc 121
    //   525: new 171	java/lang/StringBuilder
    //   528: dup
    //   529: ldc_w 266
    //   532: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   535: aload 8
    //   537: invokevirtual 267	java/io/IOException:getMessage	()Ljava/lang/String;
    //   540: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 230	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: aload_2
    //   550: ifnull +7 -> 557
    //   553: aload_2
    //   554: invokevirtual 231	java/io/InputStream:close	()V
    //   557: aload_1
    //   558: ifnull +7 -> 565
    //   561: aload_1
    //   562: invokevirtual 232	android/content/res/AssetFileDescriptor:close	()V
    //   565: aload 4
    //   567: ifnull -210 -> 357
    //   570: aload 4
    //   572: invokevirtual 233	java/io/OutputStream:close	()V
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
    //   601: ldc 121
    //   603: new 171	java/lang/StringBuilder
    //   606: dup
    //   607: ldc_w 269
    //   610: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   613: aload 8
    //   615: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   618: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 230	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: aload 4
    //   629: astore 7
    //   631: aload_1
    //   632: astore 6
    //   634: aload_2
    //   635: astore 5
    //   637: ldc 121
    //   639: aload 8
    //   641: invokevirtual 270	java/lang/Exception:toString	()Ljava/lang/String;
    //   644: invokestatic 230	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload_2
    //   648: ifnull +7 -> 655
    //   651: aload_2
    //   652: invokevirtual 231	java/io/InputStream:close	()V
    //   655: aload_1
    //   656: ifnull +7 -> 663
    //   659: aload_1
    //   660: invokevirtual 232	android/content/res/AssetFileDescriptor:close	()V
    //   663: aload 4
    //   665: ifnull -308 -> 357
    //   668: aload 4
    //   670: invokevirtual 233	java/io/OutputStream:close	()V
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
    //   694: invokevirtual 231	java/io/InputStream:close	()V
    //   697: aload_1
    //   698: ifnull +7 -> 705
    //   701: aload_1
    //   702: invokevirtual 232	android/content/res/AssetFileDescriptor:close	()V
    //   705: aload 7
    //   707: ifnull +8 -> 715
    //   710: aload 7
    //   712: invokevirtual 233	java/io/OutputStream:close	()V
    //   715: ldc 95
    //   717: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void a(final Bundle paramBundle, final b paramb)
  {
    AppMethodBeat.i(39146);
    com.tencent.mm.sdk.g.b.c(new Runnable()
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
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(39134);
              if (!ShareImgUI.a(ShareImgUI.this, this.LhE, localParcelable)) {
                this.LhG[0] = true;
              }
              this.LhH.countDown();
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
              ae.d("MicroMsg.ShareImgUI", "hy: has non path img");
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
              ae.printErrStackTrace("MicroMsg.ShareImgUI", localInterruptedException, "hy: timeout when getmulti", new Object[0]);
              ShareImgUI.a(ShareImgUI.this, paramb, null);
              continue;
              ae.i("MicroMsg.ShareImgUI", "hy: getMultiSendFilePathList done. using: %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.LhD) });
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
          ae.e("MicroMsg.ShareImgUI", "getParcelableArrayList failed");
          ShareImgUI.a(ShareImgUI.this, paramb, null);
          AppMethodBeat.o(39135);
          return;
        }
      }
    }, "getMultiSendFilePathList");
    AppMethodBeat.o(39146);
  }
  
  private void aWi()
  {
    AppMethodBeat.i(39144);
    if (this.intent == null)
    {
      ae.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
      afA(0);
      finish();
      AppMethodBeat.o(39144);
      return;
    }
    String str = this.intent.getAction();
    Bundle localBundle = this.intent.getExtras();
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
      afA(0);
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
        if (!bu.z(this.uri))
        {
          ae.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", new Object[] { this.uri });
          afA(0);
          finish();
          AppMethodBeat.o(39144);
          return;
        }
      }
    }
    showDialog();
    if (str.equals("android.intent.action.SEND"))
    {
      ae.i("MicroMsg.ShareImgUI", "send signal: ".concat(String.valueOf(str)));
      if (this.uri == null)
      {
        boolean bool = bw(getIntent());
        ae.i("MicroMsg.ShareImgUI", "dealWithText: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          afA(0);
          finish();
        }
        AppMethodBeat.o(39144);
        return;
      }
      com.tencent.mm.sdk.g.b.c(new a(this.uri, new c()
      {
        public final void fOE()
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
      ae.i("MicroMsg.ShareImgUI", "send multi: ".concat(String.valueOf(str)));
      a(localBundle, new b()
      {
        public final void aZ(ArrayList<String> paramAnonymousArrayList)
        {
          AppMethodBeat.i(39132);
          ShareImgUI.this.Laa = paramAnonymousArrayList;
          if ((ShareImgUI.this.Laa == null) || (ShareImgUI.this.Laa.size() == 0))
          {
            ae.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
            ShareImgUI.b(ShareImgUI.this);
            ShareImgUI.this.finish();
            AppMethodBeat.o(39132);
            return;
          }
          paramAnonymousArrayList = ShareImgUI.this.Laa.iterator();
          while (paramAnonymousArrayList.hasNext())
          {
            String str = (String)paramAnonymousArrayList.next();
            if (u.aRG(str))
            {
              ae.i("MicroMsg.ShareImgUI", "%s is not image", new Object[] { str });
              ShareImgUI.b(ShareImgUI.this);
              ShareImgUI.this.finish();
              AppMethodBeat.o(39132);
              return;
            }
          }
          paramAnonymousArrayList = ShareImgUI.this.getIntent().resolveType(ShareImgUI.this);
          if ((paramAnonymousArrayList == null) || (!paramAnonymousArrayList.contains("image")))
          {
            ae.i("MicroMsg.ShareImgUI", "mime type is not image, try to set it");
            ShareImgUI.this.getIntent().setDataAndType(ShareImgUI.this.getIntent().getData(), "image/*");
          }
          ShareImgUI.c(ShareImgUI.this);
          AppMethodBeat.o(39132);
        }
      });
      AppMethodBeat.o(39144);
      return;
    }
    ae.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
    afA(0);
    finish();
    AppMethodBeat.o(39144);
  }
  
  private static int aYH(String paramString)
  {
    AppMethodBeat.i(39149);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.ShareImgUI", "map : mimeType is null");
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
    ae.d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
    AppMethodBeat.o(39149);
    return 3;
  }
  
  private void afA(int paramInt)
  {
    AppMethodBeat.i(39150);
    switch (paramInt)
    {
    default: 
      Toast.makeText(this, 2131763659, 1).show();
      AppMethodBeat.o(39150);
      return;
    }
    Toast.makeText(this, 2131763656, 1).show();
    AppMethodBeat.o(39150);
  }
  
  private boolean bw(Intent paramIntent)
  {
    AppMethodBeat.i(39147);
    if (paramIntent == null)
    {
      ae.e("MicroMsg.ShareImgUI", "intent is null");
      AppMethodBeat.o(39147);
      return false;
    }
    String str = z.getStringExtra(paramIntent, "android.intent.extra.TEXT");
    paramIntent = z.getStringExtra(paramIntent, "android.intent.extra.SUBJECT");
    if ((str == null) || (str.length() == 0))
    {
      ae.i("MicroMsg.ShareImgUI", "text is null");
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
    ((Bundle)localObject2).putInt("_mmessage_sdkVersion", 637928960);
    ((Bundle)localObject2).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
    ((Bundle)localObject2).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
    localObject1 = new Intent();
    ((Intent)localObject1).setClass(this, SelectConversationUI.class);
    ((Intent)localObject1).putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras((Bundle)localObject2).putExtra("animation_pop_in", true));
    if ((bc.aCh()) && (!bc.aiT()))
    {
      bc.ajj().a(837, this);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramIntent + "|" + str);
      paramIntent = new com.tencent.mm.modelsimple.g(5, (List)localObject2, getCallerPackage());
      com.tencent.mm.kernel.g.ajj().a(paramIntent, 0);
      showDialog();
      this.mHz = ((Intent)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(39147);
      return true;
      ae.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
    }
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(39153);
    if ((this.fOC != null) && (this.fOC.isShowing())) {
      this.fOC.dismiss();
    }
    AppMethodBeat.o(39153);
  }
  
  private boolean fOX()
  {
    AppMethodBeat.i(39145);
    Intent localIntent = new Intent(this, ShareImgUI.class);
    if ("android.intent.action.SEND".equals(getIntent().getAction())) {
      if (!bu.isNullOrNil(this.filePath))
      {
        localIntent.putExtra("android.intent.extra.STREAM", o.a(this, new k(this.filePath)));
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
      if (bu.ht(this.Laa)) {
        break;
      }
      ArrayList localArrayList = new ArrayList(this.Laa.size());
      Iterator localIterator = this.Laa.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(o.a(this, new k((String)localIterator.next())));
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
  
  private void fOY()
  {
    AppMethodBeat.i(39151);
    Toast.makeText(this, 2131758246, 1).show();
    finish();
    AppMethodBeat.o(39151);
  }
  
  private void showDialog()
  {
    AppMethodBeat.i(39152);
    getString(2131755906);
    this.fOC = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39137);
        ShareImgUI.this.finish();
        AppMethodBeat.o(39137);
      }
    });
    AppMethodBeat.o(39152);
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(39142);
    switch (ShareImgUI.7.nSR[parama.ordinal()])
    {
    default: 
      finish();
      com.tencent.mm.ui.base.b.kl(this);
      AppMethodBeat.o(39142);
      return;
    }
    this.intent = paramIntent;
    int i = bu.getInt(com.tencent.mm.n.g.acL().getValue("SystemShareControlBitset"), 0);
    ae.i("MicroMsg.ShareImgUI", "now permission = %d", new Object[] { Integer.valueOf(i) });
    if ((i & 0x1) > 0)
    {
      ae.e("MicroMsg.ShareImgUI", "now allowed to share to friend");
      finish();
      AppMethodBeat.o(39142);
      return;
    }
    parama = z.getStringExtra(paramIntent, "android.intent.extra.TEXT");
    ae.i("MicroMsg.ShareImgUI", "postLogin, text = %s", new Object[] { parama });
    if (!bu.isNullOrNil(parama))
    {
      parama = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[] { URLEncoder.encode(parama) });
      showDialog();
      bc.ajj().a(1200, this);
      parama = new ac(parama, 15, null);
      bc.ajj().a(parama, 0);
      AppMethodBeat.o(39142);
      return;
    }
    aWi();
    AppMethodBeat.o(39142);
  }
  
  public final boolean ab(Intent paramIntent)
  {
    return true;
  }
  
  public final boolean dxS()
  {
    AppMethodBeat.i(39141);
    if ((!bc.aCh()) || (bc.aiT()))
    {
      ae.w("MicroMsg.ShareImgUI", "not login");
      this.intent = getIntent();
      aWi();
      AppMethodBeat.o(39141);
      return true;
    }
    AppMethodBeat.o(39141);
    return false;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39143);
    bc.ajj().b(1200, this);
    bc.ajj().b(837, this);
    dismissDialog();
    super.onDestroy();
    AppMethodBeat.o(39143);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(39154);
    ae.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    dismissDialog();
    if ((paramn instanceof ac))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        aWi();
      }
    }
    else if ((paramn instanceof com.tencent.mm.modelsimple.g))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label171;
      }
      paramString = this.mHz;
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(39154);
      return;
      finish();
      break;
      label171:
      if (paramn.getReqResp() != null)
      {
        paramString = (xy)((com.tencent.mm.ak.b)paramn.getReqResp()).hQE.hQJ;
        if ((paramString != null) && (!bu.isNullOrNil(paramString.GpX)))
        {
          paramn = new Intent();
          paramn.putExtra("rawUrl", paramString.GpX);
          paramn.putExtra("showShare", false);
          paramn.putExtra("show_bottom", false);
          paramn.putExtra("needRedirect", false);
          d.b(this, "webview", ".ui.tools.WebViewUI", paramn);
        }
        else
        {
          paramString = this.mHz;
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareImgUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    private ShareImgUI.c LhK;
    private Uri mUri;
    
    public a(Uri paramUri, ShareImgUI.c paramc)
    {
      this.mUri = paramUri;
      this.LhK = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(39139);
      try
      {
        ShareImgUI.this.filePath = ShareImgUI.a(ShareImgUI.this, this.mUri);
        if ((bu.isNullOrNil(ShareImgUI.this.filePath)) || (!new k(ShareImgUI.this.filePath).exists())) {
          if (ShareImgUI.aYO(ShareImgUI.this.getContentResolver().getType(this.mUri)) != 3) {
            break label120;
          }
        }
        label120:
        for (ShareImgUI.this.filePath = com.tencent.mm.pluginsdk.l.e.b(ShareImgUI.this.getContentResolver(), this.mUri);; ShareImgUI.this.filePath = com.tencent.mm.pluginsdk.l.e.a(ShareImgUI.this.getContentResolver(), this.mUri, 1))
        {
          if (this.LhK != null) {
            this.LhK.fOE();
          }
          AppMethodBeat.o(39139);
          return;
        }
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        ae.printErrStackTrace("MicroMsg.ShareImgUI", localNullPointerException, "", new Object[0]);
        AppMethodBeat.o(39139);
        return;
      }
      catch (SQLiteDiskIOException localSQLiteDiskIOException)
      {
        ae.printErrStackTrace("MicroMsg.ShareImgUI", localSQLiteDiskIOException, "", new Object[0]);
        AppMethodBeat.o(39139);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        ae.printErrStackTrace("MicroMsg.ShareImgUI", localIllegalAccessException, "", new Object[0]);
        AppMethodBeat.o(39139);
      }
    }
  }
  
  static abstract interface b
  {
    public abstract void aZ(ArrayList<String> paramArrayList);
  }
  
  public static abstract interface c
  {
    public abstract void fOE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI
 * JD-Core Version:    0.7.0.1
 */