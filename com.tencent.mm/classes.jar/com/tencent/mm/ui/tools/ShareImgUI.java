package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareImgUI
  extends AutoLoginActivity
  implements com.tencent.mm.ai.f
{
  ArrayList<String> Aqm;
  Intent Axw;
  private ProgressDialog eeN;
  String filePath;
  private ak handler;
  private Intent intent;
  Uri uri;
  
  public ShareImgUI()
  {
    AppMethodBeat.i(34944);
    this.eeN = null;
    this.intent = null;
    this.filePath = null;
    this.uri = null;
    this.Aqm = null;
    this.Axw = null;
    this.handler = new ShareImgUI.3(this);
    AppMethodBeat.o(34944);
  }
  
  private void QO(int paramInt)
  {
    AppMethodBeat.i(34954);
    switch (paramInt)
    {
    default: 
      Toast.makeText(this, 2131303677, 1).show();
      AppMethodBeat.o(34954);
      return;
    }
    Toast.makeText(this, 2131303674, 1).show();
    AppMethodBeat.o(34954);
  }
  
  /* Error */
  private String a(Uri paramUri, android.database.Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc 94
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +351 -> 357
    //   9: ldc 96
    //   11: astore 4
    //   13: aload_2
    //   14: ldc 98
    //   16: invokeinterface 104 2 0
    //   21: istore_3
    //   22: aload 4
    //   24: astore 5
    //   26: iload_3
    //   27: iconst_m1
    //   28: if_icmpeq +60 -> 88
    //   31: aload_2
    //   32: iload_3
    //   33: invokeinterface 108 2 0
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
    //   64: ldc 110
    //   66: ldc 112
    //   68: invokevirtual 118	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 5
    //   73: ldc 120
    //   75: ldc 122
    //   77: aload 5
    //   79: invokestatic 126	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 130	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokeinterface 138 1 0
    //   94: aload_0
    //   95: invokevirtual 142	com/tencent/mm/ui/tools/ShareImgUI:getContentResolver	()Landroid/content/ContentResolver;
    //   98: aload_1
    //   99: ldc 144
    //   101: invokevirtual 150	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 156	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   109: astore_2
    //   110: invokestatic 162	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   113: pop
    //   114: invokestatic 168	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   117: ifeq +271 -> 388
    //   120: new 170	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   127: getstatic 176	com/tencent/mm/compatible/util/e:eQz	Ljava/lang/String;
    //   130: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 182
    //   135: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore 4
    //   143: new 170	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   150: getstatic 176	com/tencent/mm/compatible/util/e:eQz	Ljava/lang/String;
    //   153: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 188
    //   158: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 5
    //   163: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore 8
    //   171: new 190	com/tencent/mm/vfs/b
    //   174: dup
    //   175: aload 4
    //   177: invokespecial 193	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   180: astore 4
    //   182: aload 4
    //   184: invokevirtual 196	com/tencent/mm/vfs/b:exists	()Z
    //   187: ifne +9 -> 196
    //   190: aload 4
    //   192: invokevirtual 199	com/tencent/mm/vfs/b:mkdirs	()Z
    //   195: pop
    //   196: new 190	com/tencent/mm/vfs/b
    //   199: dup
    //   200: aload 8
    //   202: invokespecial 193	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   205: astore 4
    //   207: aload 4
    //   209: invokevirtual 196	com/tencent/mm/vfs/b:exists	()Z
    //   212: ifne +9 -> 221
    //   215: aload 4
    //   217: invokevirtual 202	com/tencent/mm/vfs/b:createNewFile	()Z
    //   220: pop
    //   221: aload 8
    //   223: iconst_0
    //   224: invokestatic 208	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
    //   263: invokevirtual 214	java/io/InputStream:read	([BII)I
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
    //   288: invokevirtual 220	java/io/OutputStream:write	([BII)V
    //   291: goto -45 -> 246
    //   294: astore 8
    //   296: aload 4
    //   298: astore 7
    //   300: aload_1
    //   301: astore 6
    //   303: aload_2
    //   304: astore 5
    //   306: ldc 120
    //   308: new 170	java/lang/StringBuilder
    //   311: dup
    //   312: ldc 222
    //   314: invokespecial 223	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: aload 8
    //   319: invokevirtual 226	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokevirtual 230	java/io/InputStream:close	()V
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 231	android/content/res/AssetFileDescriptor:close	()V
    //   347: aload 4
    //   349: ifnull +8 -> 357
    //   352: aload 4
    //   354: invokevirtual 232	java/io/OutputStream:close	()V
    //   357: ldc 94
    //   359: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: aconst_null
    //   363: areturn
    //   364: astore 5
    //   366: ldc 120
    //   368: ldc 234
    //   370: iconst_1
    //   371: anewarray 236	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload 5
    //   378: invokevirtual 237	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   381: aastore
    //   382: invokestatic 241	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: goto -341 -> 44
    //   388: aload_0
    //   389: aload 5
    //   391: invokevirtual 245	com/tencent/mm/ui/tools/ShareImgUI:deleteFile	(Ljava/lang/String;)Z
    //   394: pop
    //   395: new 170	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   402: aload_0
    //   403: invokevirtual 249	com/tencent/mm/ui/tools/ShareImgUI:getFilesDir	()Ljava/io/File;
    //   406: invokevirtual 254	java/io/File:getPath	()Ljava/lang/String;
    //   409: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc_w 256
    //   415: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 5
    //   420: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: astore 8
    //   428: aload_0
    //   429: aload 5
    //   431: iconst_0
    //   432: invokevirtual 260	com/tencent/mm/ui/tools/ShareImgUI:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   435: astore 4
    //   437: goto -208 -> 229
    //   440: aload 4
    //   442: astore 7
    //   444: aload_1
    //   445: astore 6
    //   447: aload_2
    //   448: astore 5
    //   450: aload 4
    //   452: invokevirtual 263	java/io/OutputStream:flush	()V
    //   455: aload 4
    //   457: astore 7
    //   459: aload_1
    //   460: astore 6
    //   462: aload_2
    //   463: astore 5
    //   465: aload 4
    //   467: invokevirtual 232	java/io/OutputStream:close	()V
    //   470: aload_2
    //   471: ifnull +7 -> 478
    //   474: aload_2
    //   475: invokevirtual 230	java/io/InputStream:close	()V
    //   478: aload_1
    //   479: ifnull +7 -> 486
    //   482: aload_1
    //   483: invokevirtual 231	android/content/res/AssetFileDescriptor:close	()V
    //   486: aload 4
    //   488: ifnull +8 -> 496
    //   491: aload 4
    //   493: invokevirtual 232	java/io/OutputStream:close	()V
    //   496: ldc 94
    //   498: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   523: ldc 120
    //   525: new 170	java/lang/StringBuilder
    //   528: dup
    //   529: ldc_w 265
    //   532: invokespecial 223	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   535: aload 8
    //   537: invokevirtual 266	java/io/IOException:getMessage	()Ljava/lang/String;
    //   540: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: aload_2
    //   550: ifnull +7 -> 557
    //   553: aload_2
    //   554: invokevirtual 230	java/io/InputStream:close	()V
    //   557: aload_1
    //   558: ifnull +7 -> 565
    //   561: aload_1
    //   562: invokevirtual 231	android/content/res/AssetFileDescriptor:close	()V
    //   565: aload 4
    //   567: ifnull -210 -> 357
    //   570: aload 4
    //   572: invokevirtual 232	java/io/OutputStream:close	()V
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
    //   601: ldc 120
    //   603: new 170	java/lang/StringBuilder
    //   606: dup
    //   607: ldc_w 268
    //   610: invokespecial 223	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   613: aload 8
    //   615: invokevirtual 237	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   618: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: aload 4
    //   629: astore 7
    //   631: aload_1
    //   632: astore 6
    //   634: aload_2
    //   635: astore 5
    //   637: ldc 120
    //   639: aload 8
    //   641: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   644: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload_2
    //   648: ifnull +7 -> 655
    //   651: aload_2
    //   652: invokevirtual 230	java/io/InputStream:close	()V
    //   655: aload_1
    //   656: ifnull +7 -> 663
    //   659: aload_1
    //   660: invokevirtual 231	android/content/res/AssetFileDescriptor:close	()V
    //   663: aload 4
    //   665: ifnull -308 -> 357
    //   668: aload 4
    //   670: invokevirtual 232	java/io/OutputStream:close	()V
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
    //   694: invokevirtual 230	java/io/InputStream:close	()V
    //   697: aload_1
    //   698: ifnull +7 -> 705
    //   701: aload_1
    //   702: invokevirtual 231	android/content/res/AssetFileDescriptor:close	()V
    //   705: aload 7
    //   707: ifnull +8 -> 715
    //   710: aload 7
    //   712: invokevirtual 232	java/io/OutputStream:close	()V
    //   715: ldc 94
    //   717: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void a(Bundle paramBundle, ShareImgUI.b paramb)
  {
    AppMethodBeat.i(34950);
    com.tencent.mm.sdk.g.d.post(new ShareImgUI.4(this, paramBundle, paramb, System.currentTimeMillis()), "getMultiSendFilePathList");
    AppMethodBeat.o(34950);
  }
  
  private boolean aW(Intent paramIntent)
  {
    AppMethodBeat.i(34951);
    if (paramIntent == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareImgUI", "intent is null");
      AppMethodBeat.o(34951);
      return false;
    }
    String str = w.n(paramIntent, "android.intent.extra.TEXT");
    paramIntent = w.n(paramIntent, "android.intent.extra.SUBJECT");
    if ((str == null) || (str.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareImgUI", "text is null");
      AppMethodBeat.o(34951);
      return false;
    }
    Object localObject2 = new WXMediaMessage(new WXTextObject(str));
    ((WXMediaMessage)localObject2).description = str;
    Object localObject1 = new SendMessageToWX.Req();
    ((SendMessageToWX.Req)localObject1).transaction = null;
    ((SendMessageToWX.Req)localObject1).message = ((WXMediaMessage)localObject2);
    localObject2 = new Bundle();
    ((SendMessageToWX.Req)localObject1).toBundle((Bundle)localObject2);
    ((Bundle)localObject2).putInt("_mmessage_sdkVersion", 620954624);
    ((Bundle)localObject2).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
    ((Bundle)localObject2).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
    localObject1 = new Intent();
    ((Intent)localObject1).setClass(this, SelectConversationUI.class);
    ((Intent)localObject1).putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras((Bundle)localObject2).putExtra("animation_pop_in", true));
    if ((aw.aaB()) && (!aw.QP()))
    {
      aw.Rc().a(837, this);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramIntent + "|" + str);
      paramIntent = new com.tencent.mm.modelsimple.f(5, (List)localObject2, getCallerPackage());
      com.tencent.mm.kernel.g.Rc().a(paramIntent, 0);
      showDialog();
      this.Axw = ((Intent)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(34951);
      return true;
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
    }
  }
  
  private void atg()
  {
    AppMethodBeat.i(34948);
    if (this.intent == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
      QO(0);
      finish();
      AppMethodBeat.o(34948);
      return;
    }
    String str = this.intent.getAction();
    Bundle localBundle = this.intent.getExtras();
    if (bo.isNullOrNil(str))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
      QO(0);
      finish();
      AppMethodBeat.o(34948);
      return;
    }
    if (localBundle != null)
    {
      Parcelable localParcelable = localBundle.getParcelable("android.intent.extra.STREAM");
      if ((localParcelable != null) && ((localParcelable instanceof Uri)))
      {
        this.uri = ((Uri)localParcelable);
        if (!bo.o(this.uri))
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", new Object[] { this.uri });
          QO(0);
          finish();
          AppMethodBeat.o(34948);
          return;
        }
      }
    }
    showDialog();
    if (str.equals("android.intent.action.SEND"))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareImgUI", "send signal: ".concat(String.valueOf(str)));
      if (this.uri == null)
      {
        boolean bool = aW(getIntent());
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareImgUI", "dealWithText: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          QO(0);
          finish();
        }
        AppMethodBeat.o(34948);
        return;
      }
      com.tencent.mm.sdk.g.d.post(new ShareImgUI.a(this, this.uri, new ShareImgUI.1(this)), "ShareImgUI_getFilePath");
      AppMethodBeat.o(34948);
      return;
    }
    if ((str.equals("android.intent.action.SEND_MULTIPLE")) && (localBundle != null) && (localBundle.containsKey("android.intent.extra.STREAM")))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareImgUI", "send multi: ".concat(String.valueOf(str)));
      a(localBundle, new ShareImgUI.2(this));
      AppMethodBeat.o(34948);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
    QO(0);
    finish();
    AppMethodBeat.o(34948);
  }
  
  private static int auN(String paramString)
  {
    AppMethodBeat.i(34953);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareImgUI", "map : mimeType is null");
      AppMethodBeat.o(34953);
      return -1;
    }
    paramString = paramString.toLowerCase();
    if (paramString.equalsIgnoreCase("image/gif"))
    {
      AppMethodBeat.o(34953);
      return 5;
    }
    if (paramString.contains("image"))
    {
      AppMethodBeat.o(34953);
      return 0;
    }
    if (paramString.contains("video"))
    {
      AppMethodBeat.o(34953);
      return 1;
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
    AppMethodBeat.o(34953);
    return 3;
  }
  
  private boolean dNX()
  {
    AppMethodBeat.i(34949);
    Intent localIntent = new Intent(this, ShareImgUI.class);
    if ("android.intent.action.SEND".equals(getIntent().getAction())) {
      if (!bo.isNullOrNil(this.filePath))
      {
        localIntent.putExtra("android.intent.extra.STREAM", com.tencent.mm.vfs.e.avH(this.filePath));
        localIntent.setAction("android.intent.action.SEND");
        localIntent.setType(getIntent().getType());
      }
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), localIntent);
      AppMethodBeat.o(34949);
      return true;
      AppMethodBeat.o(34949);
      return false;
      if (!"android.intent.action.SEND_MULTIPLE".equals(getIntent().getAction())) {
        break label248;
      }
      if (bo.es(this.Aqm)) {
        break;
      }
      ArrayList localArrayList = new ArrayList(this.Aqm.size());
      Iterator localIterator = this.Aqm.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(com.tencent.mm.vfs.e.avH((String)localIterator.next()));
      }
      localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
      localIntent.setAction("android.intent.action.SEND_MULTIPLE");
      localIntent.setType(getIntent().getType());
    }
    AppMethodBeat.o(34949);
    return false;
    label248:
    AppMethodBeat.o(34949);
    return false;
  }
  
  private void dNY()
  {
    AppMethodBeat.i(34955);
    Toast.makeText(this, 2131299130, 1).show();
    finish();
    AppMethodBeat.o(34955);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(34957);
    if ((this.eeN != null) && (this.eeN.isShowing())) {
      this.eeN.dismiss();
    }
    AppMethodBeat.o(34957);
  }
  
  private void showDialog()
  {
    AppMethodBeat.i(34956);
    getString(2131297087);
    this.eeN = h.b(this, getString(2131297112), true, new ShareImgUI.6(this));
    AppMethodBeat.o(34956);
  }
  
  public final boolean O(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(34946);
    switch (ShareImgUI.7.jLR[parama.ordinal()])
    {
    default: 
      finish();
      com.tencent.mm.ui.base.b.ig(this);
      AppMethodBeat.o(34946);
      return;
    }
    this.intent = paramIntent;
    int i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SystemShareControlBitset"), 0);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareImgUI", "now permission = %d", new Object[] { Integer.valueOf(i) });
    if ((i & 0x1) > 0)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ShareImgUI", "now allowed to share to friend");
      finish();
      AppMethodBeat.o(34946);
      return;
    }
    parama = w.n(paramIntent, "android.intent.extra.TEXT");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareImgUI", "postLogin, text = %s", new Object[] { parama });
    if (!bo.isNullOrNil(parama))
    {
      parama = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[] { URLEncoder.encode(parama) });
      showDialog();
      aw.Rc().a(1200, this);
      parama = new com.tencent.mm.modelsimple.ab(parama, 15, null);
      aw.Rc().a(parama, 0);
      AppMethodBeat.o(34946);
      return;
    }
    atg();
    AppMethodBeat.o(34946);
  }
  
  public final boolean bXc()
  {
    AppMethodBeat.i(34945);
    if ((!aw.aaB()) || (aw.QP()))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ShareImgUI", "not login");
      this.intent = getIntent();
      atg();
      AppMethodBeat.o(34945);
      return true;
    }
    AppMethodBeat.o(34945);
    return false;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34947);
    aw.Rc().b(1200, this);
    aw.Rc().b(837, this);
    dismissDialog();
    super.onDestroy();
    AppMethodBeat.o(34947);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(34958);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    dismissDialog();
    if ((paramm instanceof com.tencent.mm.modelsimple.ab))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        atg();
      }
    }
    else if ((paramm instanceof com.tencent.mm.modelsimple.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label198;
      }
      if (paramm.getReqResp() != null)
      {
        paramString = (st)((com.tencent.mm.ai.b)paramm.getReqResp()).fsW.fta;
        if ((paramString == null) || (bo.isNullOrNil(paramString.wLm))) {
          break label198;
        }
        paramm = new Intent();
        paramm.putExtra("rawUrl", paramString.wLm);
        paramm.putExtra("showShare", false);
        paramm.putExtra("show_bottom", false);
        paramm.putExtra("needRedirect", false);
        com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramm);
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(34958);
      return;
      finish();
      break;
      label198:
      startActivity(this.Axw);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI
 * JD-Core Version:    0.7.0.1
 */