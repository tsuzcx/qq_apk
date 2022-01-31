package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141010", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class AddFavoriteUI
  extends MMActivity
  implements f
{
  private ProgressDialog dnm = null;
  String filePath = null;
  private ah handler = new AddFavoriteUI.12(this);
  private Intent intent = null;
  Uri uri = null;
  private cj vXZ;
  ArrayList<String> vYa = null;
  private ah vYb = new ah()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AddFavoriteUI.d(AddFavoriteUI.this);
      y.i("MicroMsg.AddFavoriteUI", "dealWithText: %b", new Object[] { Boolean.valueOf(AddFavoriteUI.e(AddFavoriteUI.this)) });
    }
  };
  private ah vYc = new AddFavoriteUI.11(this);
  
  private void Id(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Toast.makeText(this, R.l.shareimg_get_res_fail, 1).show();
      return;
    }
    Toast.makeText(this, R.l.shareimg_err_not_support_type, 1).show();
  }
  
  /* Error */
  private String a(Uri paramUri, android.database.Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +444 -> 445
    //   4: ldc 105
    //   6: astore 8
    //   8: aload_2
    //   9: ldc 107
    //   11: invokeinterface 113 2 0
    //   16: istore_3
    //   17: iload_3
    //   18: iconst_m1
    //   19: if_icmpeq +58 -> 77
    //   22: aload_2
    //   23: iload_3
    //   24: invokeinterface 117 2 0
    //   29: astore 5
    //   31: aload 5
    //   33: astore 4
    //   35: aload 5
    //   37: ifnull +14 -> 51
    //   40: aload 5
    //   42: ldc 119
    //   44: ldc 121
    //   46: invokevirtual 127	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 4
    //   51: ldc 129
    //   53: new 131	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 133
    //   59: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload 4
    //   64: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 150	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload 4
    //   75: astore 8
    //   77: aload_2
    //   78: invokeinterface 153 1 0
    //   83: aload_0
    //   84: invokevirtual 157	com/tencent/mm/ui/tools/AddFavoriteUI:getContentResolver	()Landroid/content/ContentResolver;
    //   87: aload_1
    //   88: ldc 159
    //   90: invokevirtual 165	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 171	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   98: astore_2
    //   99: aload_1
    //   100: invokevirtual 175	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   103: l2i
    //   104: newarray byte
    //   106: astore 9
    //   108: aload_2
    //   109: aload 9
    //   111: invokevirtual 181	java/io/FileInputStream:read	([B)I
    //   114: ifle +315 -> 429
    //   117: invokestatic 187	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   120: pop
    //   121: invokestatic 193	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   124: ifne +149 -> 273
    //   127: aload_0
    //   128: aload 8
    //   130: invokevirtual 197	com/tencent/mm/ui/tools/AddFavoriteUI:deleteFile	(Ljava/lang/String;)Z
    //   133: pop
    //   134: aload_0
    //   135: aload 8
    //   137: iconst_0
    //   138: invokevirtual 201	com/tencent/mm/ui/tools/AddFavoriteUI:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   141: astore 7
    //   143: aload 7
    //   145: astore 6
    //   147: aload_2
    //   148: astore 5
    //   150: aload_1
    //   151: astore 4
    //   153: aload 7
    //   155: aload 9
    //   157: invokevirtual 207	java/io/FileOutputStream:write	([B)V
    //   160: aload 7
    //   162: astore 6
    //   164: aload_2
    //   165: astore 5
    //   167: aload_1
    //   168: astore 4
    //   170: aload 7
    //   172: invokevirtual 210	java/io/FileOutputStream:flush	()V
    //   175: aload 7
    //   177: astore 6
    //   179: aload_2
    //   180: astore 5
    //   182: aload_1
    //   183: astore 4
    //   185: new 131	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   192: aload_0
    //   193: invokevirtual 215	com/tencent/mm/ui/tools/AddFavoriteUI:getFilesDir	()Ljava/io/File;
    //   196: invokevirtual 220	java/io/File:getPath	()Ljava/lang/String;
    //   199: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 222
    //   204: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 8
    //   209: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: astore 8
    //   217: aload 8
    //   219: astore 4
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 223	java/io/FileInputStream:close	()V
    //   229: aload_1
    //   230: ifnull +7 -> 237
    //   233: aload_1
    //   234: invokevirtual 224	android/content/res/AssetFileDescriptor:close	()V
    //   237: aload 4
    //   239: astore_2
    //   240: aload 7
    //   242: ifnull +11 -> 253
    //   245: aload 7
    //   247: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   250: aload 4
    //   252: astore_2
    //   253: aload_2
    //   254: areturn
    //   255: astore_1
    //   256: ldc 129
    //   258: aload_1
    //   259: aload_1
    //   260: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   263: iconst_0
    //   264: anewarray 230	java/lang/Object
    //   267: invokestatic 234	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload 4
    //   272: areturn
    //   273: new 131	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   280: getstatic 239	com/tencent/mm/compatible/util/e:bkH	Ljava/lang/String;
    //   283: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc 241
    //   288: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: astore 5
    //   296: new 131	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   303: getstatic 239	com/tencent/mm/compatible/util/e:bkH	Ljava/lang/String;
    //   306: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc 243
    //   311: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 8
    //   316: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: astore 4
    //   324: new 217	java/io/File
    //   327: dup
    //   328: aload 5
    //   330: invokespecial 244	java/io/File:<init>	(Ljava/lang/String;)V
    //   333: astore 5
    //   335: aload 5
    //   337: invokevirtual 247	java/io/File:exists	()Z
    //   340: ifne +9 -> 349
    //   343: aload 5
    //   345: invokevirtual 250	java/io/File:mkdir	()Z
    //   348: pop
    //   349: new 217	java/io/File
    //   352: dup
    //   353: aload 4
    //   355: invokespecial 244	java/io/File:<init>	(Ljava/lang/String;)V
    //   358: astore 5
    //   360: aload 5
    //   362: invokevirtual 247	java/io/File:exists	()Z
    //   365: ifne +9 -> 374
    //   368: aload 5
    //   370: invokevirtual 253	java/io/File:createNewFile	()Z
    //   373: pop
    //   374: aload 4
    //   376: aload 9
    //   378: aload 9
    //   380: arraylength
    //   381: invokestatic 259	com/tencent/mm/vfs/e:b	(Ljava/lang/String;[BI)I
    //   384: istore_3
    //   385: iload_3
    //   386: ifne +43 -> 429
    //   389: aload_2
    //   390: ifnull +7 -> 397
    //   393: aload_2
    //   394: invokevirtual 223	java/io/FileInputStream:close	()V
    //   397: aload 4
    //   399: astore_2
    //   400: aload_1
    //   401: ifnull -148 -> 253
    //   404: aload_1
    //   405: invokevirtual 224	android/content/res/AssetFileDescriptor:close	()V
    //   408: aload 4
    //   410: areturn
    //   411: astore_1
    //   412: ldc 129
    //   414: aload_1
    //   415: aload_1
    //   416: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   419: iconst_0
    //   420: anewarray 230	java/lang/Object
    //   423: invokestatic 234	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   426: aload 4
    //   428: areturn
    //   429: aload_2
    //   430: ifnull +7 -> 437
    //   433: aload_2
    //   434: invokevirtual 223	java/io/FileInputStream:close	()V
    //   437: aload_1
    //   438: ifnull +7 -> 445
    //   441: aload_1
    //   442: invokevirtual 224	android/content/res/AssetFileDescriptor:close	()V
    //   445: aconst_null
    //   446: areturn
    //   447: astore_1
    //   448: ldc 129
    //   450: aload_1
    //   451: aload_1
    //   452: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   455: iconst_0
    //   456: anewarray 230	java/lang/Object
    //   459: invokestatic 234	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: goto -17 -> 445
    //   465: astore 8
    //   467: aconst_null
    //   468: astore 7
    //   470: aconst_null
    //   471: astore_2
    //   472: aconst_null
    //   473: astore_1
    //   474: aload 7
    //   476: astore 6
    //   478: aload_2
    //   479: astore 5
    //   481: aload_1
    //   482: astore 4
    //   484: ldc 129
    //   486: new 131	java/lang/StringBuilder
    //   489: dup
    //   490: ldc_w 261
    //   493: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   496: aload 8
    //   498: invokevirtual 262	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   501: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 265	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload_2
    //   511: ifnull +7 -> 518
    //   514: aload_2
    //   515: invokevirtual 223	java/io/FileInputStream:close	()V
    //   518: aload_1
    //   519: ifnull +7 -> 526
    //   522: aload_1
    //   523: invokevirtual 224	android/content/res/AssetFileDescriptor:close	()V
    //   526: aload 7
    //   528: ifnull -83 -> 445
    //   531: aload 7
    //   533: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   536: goto -91 -> 445
    //   539: astore_1
    //   540: ldc 129
    //   542: aload_1
    //   543: aload_1
    //   544: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   547: iconst_0
    //   548: anewarray 230	java/lang/Object
    //   551: invokestatic 234	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   554: goto -109 -> 445
    //   557: astore 8
    //   559: aconst_null
    //   560: astore 7
    //   562: aconst_null
    //   563: astore_2
    //   564: aconst_null
    //   565: astore_1
    //   566: aload 7
    //   568: astore 6
    //   570: aload_2
    //   571: astore 5
    //   573: aload_1
    //   574: astore 4
    //   576: ldc 129
    //   578: new 131	java/lang/StringBuilder
    //   581: dup
    //   582: ldc_w 267
    //   585: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   588: aload 8
    //   590: invokevirtual 268	java/io/IOException:getMessage	()Ljava/lang/String;
    //   593: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 265	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   602: aload_2
    //   603: ifnull +7 -> 610
    //   606: aload_2
    //   607: invokevirtual 223	java/io/FileInputStream:close	()V
    //   610: aload_1
    //   611: ifnull +7 -> 618
    //   614: aload_1
    //   615: invokevirtual 224	android/content/res/AssetFileDescriptor:close	()V
    //   618: aload 7
    //   620: ifnull -175 -> 445
    //   623: aload 7
    //   625: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   628: goto -183 -> 445
    //   631: astore_1
    //   632: ldc 129
    //   634: aload_1
    //   635: aload_1
    //   636: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   639: iconst_0
    //   640: anewarray 230	java/lang/Object
    //   643: invokestatic 234	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   646: goto -201 -> 445
    //   649: astore 8
    //   651: aconst_null
    //   652: astore 7
    //   654: aconst_null
    //   655: astore_2
    //   656: aconst_null
    //   657: astore_1
    //   658: aload 7
    //   660: astore 6
    //   662: aload_2
    //   663: astore 5
    //   665: aload_1
    //   666: astore 4
    //   668: ldc 129
    //   670: new 131	java/lang/StringBuilder
    //   673: dup
    //   674: ldc_w 270
    //   677: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   680: aload 8
    //   682: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   685: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 265	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: aload_2
    //   695: ifnull +7 -> 702
    //   698: aload_2
    //   699: invokevirtual 223	java/io/FileInputStream:close	()V
    //   702: aload_1
    //   703: ifnull +7 -> 710
    //   706: aload_1
    //   707: invokevirtual 224	android/content/res/AssetFileDescriptor:close	()V
    //   710: aload 7
    //   712: ifnull -267 -> 445
    //   715: aload 7
    //   717: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   720: goto -275 -> 445
    //   723: astore_1
    //   724: ldc 129
    //   726: aload_1
    //   727: aload_1
    //   728: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   731: iconst_0
    //   732: anewarray 230	java/lang/Object
    //   735: invokestatic 234	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   738: goto -293 -> 445
    //   741: astore 7
    //   743: aconst_null
    //   744: astore 6
    //   746: aconst_null
    //   747: astore_2
    //   748: aconst_null
    //   749: astore_1
    //   750: aload_2
    //   751: ifnull +7 -> 758
    //   754: aload_2
    //   755: invokevirtual 223	java/io/FileInputStream:close	()V
    //   758: aload_1
    //   759: ifnull +7 -> 766
    //   762: aload_1
    //   763: invokevirtual 224	android/content/res/AssetFileDescriptor:close	()V
    //   766: aload 6
    //   768: ifnull +8 -> 776
    //   771: aload 6
    //   773: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   776: aload 7
    //   778: athrow
    //   779: astore_1
    //   780: ldc 129
    //   782: aload_1
    //   783: aload_1
    //   784: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   787: iconst_0
    //   788: anewarray 230	java/lang/Object
    //   791: invokestatic 234	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   794: goto -18 -> 776
    //   797: astore 7
    //   799: aconst_null
    //   800: astore 6
    //   802: aconst_null
    //   803: astore_2
    //   804: goto -54 -> 750
    //   807: astore 7
    //   809: aconst_null
    //   810: astore 6
    //   812: goto -62 -> 750
    //   815: astore 7
    //   817: aload 5
    //   819: astore_2
    //   820: aload 4
    //   822: astore_1
    //   823: goto -73 -> 750
    //   826: astore 8
    //   828: aconst_null
    //   829: astore 7
    //   831: aconst_null
    //   832: astore_2
    //   833: goto -175 -> 658
    //   836: astore 8
    //   838: aconst_null
    //   839: astore 7
    //   841: goto -183 -> 658
    //   844: astore 8
    //   846: goto -188 -> 658
    //   849: astore 8
    //   851: aconst_null
    //   852: astore 7
    //   854: aconst_null
    //   855: astore_2
    //   856: goto -290 -> 566
    //   859: astore 8
    //   861: aconst_null
    //   862: astore 7
    //   864: goto -298 -> 566
    //   867: astore 8
    //   869: goto -303 -> 566
    //   872: astore 8
    //   874: aconst_null
    //   875: astore 7
    //   877: aconst_null
    //   878: astore_2
    //   879: goto -405 -> 474
    //   882: astore 8
    //   884: aconst_null
    //   885: astore 7
    //   887: goto -413 -> 474
    //   890: astore 8
    //   892: goto -418 -> 474
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	895	0	this	AddFavoriteUI
    //   0	895	1	paramUri	Uri
    //   0	895	2	paramCursor	android.database.Cursor
    //   16	370	3	i	int
    //   33	788	4	localObject1	Object
    //   29	789	5	localObject2	Object
    //   145	666	6	localFileOutputStream1	java.io.FileOutputStream
    //   141	575	7	localFileOutputStream2	java.io.FileOutputStream
    //   741	36	7	localObject3	Object
    //   797	1	7	localObject4	Object
    //   807	1	7	localObject5	Object
    //   815	1	7	localObject6	Object
    //   829	57	7	localObject7	Object
    //   6	309	8	localObject8	Object
    //   465	32	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   557	32	8	localIOException1	java.io.IOException
    //   649	32	8	localException1	java.lang.Exception
    //   826	1	8	localException2	java.lang.Exception
    //   836	1	8	localException3	java.lang.Exception
    //   844	1	8	localException4	java.lang.Exception
    //   849	1	8	localIOException2	java.io.IOException
    //   859	1	8	localIOException3	java.io.IOException
    //   867	1	8	localIOException4	java.io.IOException
    //   872	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   882	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   890	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   106	273	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   225	229	255	java/lang/Exception
    //   233	237	255	java/lang/Exception
    //   245	250	255	java/lang/Exception
    //   393	397	411	java/lang/Exception
    //   404	408	411	java/lang/Exception
    //   433	437	447	java/lang/Exception
    //   441	445	447	java/lang/Exception
    //   83	94	465	java/io/FileNotFoundException
    //   514	518	539	java/lang/Exception
    //   522	526	539	java/lang/Exception
    //   531	536	539	java/lang/Exception
    //   83	94	557	java/io/IOException
    //   606	610	631	java/lang/Exception
    //   614	618	631	java/lang/Exception
    //   623	628	631	java/lang/Exception
    //   83	94	649	java/lang/Exception
    //   698	702	723	java/lang/Exception
    //   706	710	723	java/lang/Exception
    //   715	720	723	java/lang/Exception
    //   83	94	741	finally
    //   754	758	779	java/lang/Exception
    //   762	766	779	java/lang/Exception
    //   771	776	779	java/lang/Exception
    //   94	99	797	finally
    //   99	143	807	finally
    //   273	349	807	finally
    //   349	374	807	finally
    //   374	385	807	finally
    //   153	160	815	finally
    //   170	175	815	finally
    //   185	217	815	finally
    //   484	510	815	finally
    //   576	602	815	finally
    //   668	694	815	finally
    //   94	99	826	java/lang/Exception
    //   99	143	836	java/lang/Exception
    //   273	349	836	java/lang/Exception
    //   349	374	836	java/lang/Exception
    //   374	385	836	java/lang/Exception
    //   153	160	844	java/lang/Exception
    //   170	175	844	java/lang/Exception
    //   185	217	844	java/lang/Exception
    //   94	99	849	java/io/IOException
    //   99	143	859	java/io/IOException
    //   273	349	859	java/io/IOException
    //   349	374	859	java/io/IOException
    //   374	385	859	java/io/IOException
    //   153	160	867	java/io/IOException
    //   170	175	867	java/io/IOException
    //   185	217	867	java/io/IOException
    //   94	99	872	java/io/FileNotFoundException
    //   99	143	882	java/io/FileNotFoundException
    //   273	349	882	java/io/FileNotFoundException
    //   349	374	882	java/io/FileNotFoundException
    //   374	385	882	java/io/FileNotFoundException
    //   153	160	890	java/io/FileNotFoundException
    //   170	175	890	java/io/FileNotFoundException
    //   185	217	890	java/io/FileNotFoundException
  }
  
  private static boolean aef(String paramString)
  {
    MMBitmapFactory.DecodeResultLogger localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
    boolean bool = o.a(paramString, localDecodeResultLogger);
    if ((!bool) && (localDecodeResultLogger.getDecodeResult() >= 2000))
    {
      paramString = MMBitmapFactory.KVStatHelper.getKVStatString(paramString, 5, localDecodeResultLogger);
      com.tencent.mm.plugin.report.service.h.nFQ.aC(12712, paramString);
    }
    return bool;
  }
  
  private static int aeg(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AddFavoriteUI", "map : mimeType is null");
      return -1;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.contains("image")) || (paramString.equals("application/vnd.google.panorama360+jpg"))) {
      return 2;
    }
    if (paramString.contains("video")) {
      return 4;
    }
    y.d("MicroMsg.AddFavoriteUI", "map : unknown mimetype, send as file");
    return 8;
  }
  
  private ArrayList<String> ar(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelableArrayList("android.intent.extra.STREAM");
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      paramBundle = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Parcelable)((Iterator)localObject1).next();
        if ((localObject2 == null) || (!(localObject2 instanceof Uri))) {
          y.e("MicroMsg.AddFavoriteUI", "getMultiSendFilePath failed, error parcelable, %s", new Object[] { localObject2 });
        }
        for (;;)
        {
          for (int i = 0;; i = 1)
          {
            if (i != 0) {
              break label178;
            }
            return null;
            localObject2 = (Uri)localObject2;
            if ((!bk.m((Uri)localObject2)) || (((Uri)localObject2).getScheme() == null)) {
              break label206;
            }
            localObject2 = bk.h(this, (Uri)localObject2);
            if (bk.bl((String)localObject2)) {
              break;
            }
            if ((!bk.aae((String)localObject2)) || (!aef((String)localObject2))) {
              break label180;
            }
            y.i("MicroMsg.AddFavoriteUI", "multisend file path: " + (String)localObject2);
            paramBundle.add(localObject2);
          }
          label178:
          break;
          label180:
          y.w("MicroMsg.AddFavoriteUI", "multisend tries to send illegal img: " + (String)localObject2);
          continue;
          label206:
          y.e("MicroMsg.AddFavoriteUI", "unaccepted uri: " + localObject2);
        }
      }
      if (paramBundle.size() > 0) {
        return paramBundle;
      }
      return null;
    }
    y.e("MicroMsg.AddFavoriteUI", "getParcelableArrayList failed");
    return null;
  }
  
  private void bh(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
      return;
    }
    long l = com.tencent.mm.vfs.e.aeQ(paramString);
    y.i("MicroMsg.AddFavoriteUI", "filelength: [%d]", new Object[] { Long.valueOf(l) });
    if (l == 0L)
    {
      y.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
      Toast.makeText(this, R.l.favorite_file_length_zero, 1).show();
      finish();
      return;
    }
    if (l > 26214400L)
    {
      y.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
      Toast.makeText(this, R.l.favorite_too_large, 1).show();
      finish();
      return;
    }
    if ((au.Hz()) && (!au.CW()))
    {
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramString);
      cj localcj = new cj();
      String str = com.tencent.mm.vfs.e.aeV(paramString) + "." + com.tencent.mm.vfs.e.bM(paramString);
      Object localObject2;
      switch (paramInt)
      {
      case 3: 
      default: 
        localObject2 = new WXFileObject(paramString);
        localObject1 = new com.tencent.mm.modelsimple.d(4, (List)localObject1, czt());
        com.tencent.mm.pluginsdk.model.e.a(localcj, paramString, str, "");
        localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
        ((WXMediaMessage)localObject2).title = new File(paramString).getName();
        if (bk.bl(null))
        {
          ((WXMediaMessage)localObject2).description = bk.cm(l);
          label285:
          if (l >= 30720L) {
            break label807;
          }
          ((WXMediaMessage)localObject2).thumbData = com.tencent.mm.vfs.e.c(paramString, 0, -1);
        }
        break;
      }
      for (;;)
      {
        paramString = new SendMessageToWX.Req();
        paramString.transaction = null;
        paramString.message = ((WXMediaMessage)localObject2);
        localObject2 = new Bundle();
        paramString.toBundle((Bundle)localObject2);
        ((Bundle)localObject2).putInt("_mmessage_sdkVersion", 620824064);
        ((Bundle)localObject2).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
        ((Bundle)localObject2).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        localcj.bIw.activity = this;
        localcj.bIw.bIE = new AddFavoriteUI.5(this);
        localcj.bIw.bIF = new AddFavoriteUI.6(this);
        this.vXZ = localcj;
        g.Dk().a(837, this);
        g.Dk().a((m)localObject1, 0);
        showDialog();
        return;
        localObject2 = new WXImageObject();
        ((WXImageObject)localObject2).setImagePath(paramString);
        localObject1 = new com.tencent.mm.modelsimple.d(1, (List)localObject1, czt());
        com.tencent.mm.pluginsdk.model.e.a(localcj, 13, paramString);
        break;
        localObject2 = new WXVideoFileObject(paramString);
        localObject1 = new com.tencent.mm.modelsimple.d(3, (List)localObject1, czt());
        if (bk.bl(paramString))
        {
          y.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
          localcj.bIw.bIC = R.l.favorite_fail_argument_error;
          break;
        }
        y.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { str, "", paramString, Integer.valueOf(13) });
        if (new com.tencent.mm.vfs.b(paramString).length() > com.tencent.mm.m.b.Ai())
        {
          localcj.bIw.bIC = R.l.favorite_too_large;
          break;
        }
        yj localyj = new yj();
        yp localyp = new yp();
        xv localxv = new xv();
        localxv.XI(paramString);
        localxv.EH(4);
        localxv.XE(com.tencent.mm.vfs.e.bM(paramString));
        localxv.XJ(null);
        localxv.EG(0);
        localxv.Xu(str);
        localxv.Xv("");
        localyp.Yq(q.Gj());
        localyp.Yr(q.Gj());
        localyp.EQ(13);
        localyp.hl(bk.UY());
        localyj.a(localyp);
        localyj.sXc.add(localxv);
        localcj.bIw.title = localxv.title;
        localcj.bIw.desc = localxv.title;
        localcj.bIw.bIy = localyj;
        localcj.bIw.type = 4;
        break;
        ((WXMediaMessage)localObject2).description = null;
        break label285;
        label807:
        y.i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
      }
    }
    y.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
    finish();
    cIM();
  }
  
  private void cIM()
  {
    Intent localIntent = new Intent(this, AddFavoriteUI.class);
    localIntent.setAction("android.intent.action.SEND");
    if (bk.bl(this.filePath)) {}
    for (Object localObject = null;; localObject = Uri.fromFile(new File(this.filePath)))
    {
      localIntent.putExtra("android.intent.extra.STREAM", (Parcelable)localObject);
      localIntent.addFlags(268435456).addFlags(32768);
      localIntent.setType(getIntent().getType());
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), localIntent);
      return;
    }
  }
  
  private boolean cIN()
  {
    this.intent = getIntent();
    if (this.intent == null)
    {
      y.e("MicroMsg.AddFavoriteUI", "intent is null");
      return false;
    }
    Object localObject1 = t.j(this.intent, "android.intent.extra.TEXT");
    if ((localObject1 == null) || (((String)localObject1).length() == 0))
    {
      y.i("MicroMsg.AddFavoriteUI", "text is null");
      return false;
    }
    Object localObject3 = new WXMediaMessage(new WXTextObject((String)localObject1));
    ((WXMediaMessage)localObject3).description = ((String)localObject1);
    Object localObject2 = new SendMessageToWX.Req();
    ((SendMessageToWX.Req)localObject2).transaction = null;
    ((SendMessageToWX.Req)localObject2).message = ((WXMediaMessage)localObject3);
    int i = ((SendMessageToWX.Req)localObject2).message.getType();
    localObject3 = new Bundle();
    ((SendMessageToWX.Req)localObject2).toBundle((Bundle)localObject3);
    ((Bundle)localObject3).putInt("_mmessage_sdkVersion", 620824064);
    ((Bundle)localObject3).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
    ((Bundle)localObject3).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
    if ((au.Hz()) && (!au.CW()))
    {
      localObject2 = new cj();
      localObject3 = com.tencent.mm.vfs.e.aeV(this.filePath) + "." + com.tencent.mm.vfs.e.bM(this.filePath);
      if (i == 1)
      {
        com.tencent.mm.pluginsdk.model.e.b((cj)localObject2, (String)localObject1, 13);
        ((cj)localObject2).bIw.activity = this;
        ((cj)localObject2).bIw.bIE = new AddFavoriteUI.3(this);
        ((cj)localObject2).bIw.bIF = new AddFavoriteUI.4(this);
        this.vXZ = ((cj)localObject2);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localObject1 = new com.tencent.mm.modelsimple.d(5, (List)localObject2, czt());
        au.Dk().a(837, this);
        g.Dk().a((m)localObject1, 0);
        showDialog();
      }
    }
    for (;;)
    {
      return true;
      com.tencent.mm.pluginsdk.model.e.a((cj)localObject2, this.filePath, (String)localObject3, "");
      break;
      y.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
      finish();
    }
  }
  
  private void cIO()
  {
    Id(0);
    Toast.makeText(this, R.l.shareimg_get_res_fail, 1).show();
  }
  
  private void dismissDialog()
  {
    if ((this.dnm != null) && (this.dnm.isShowing())) {
      this.dnm.dismiss();
    }
  }
  
  private void showDialog()
  {
    getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.app_waiting), true, new AddFavoriteUI.7(this));
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected final void initView()
  {
    this.intent = getIntent();
    if (this.intent == null)
    {
      y.e("MicroMsg.AddFavoriteUI", "launch : fail, intent is null");
      cIO();
      finish();
      return;
    }
    String str = this.intent.getAction();
    Bundle localBundle = t.al(this.intent);
    if (bk.bl(str))
    {
      y.e("MicroMsg.AddFavoriteUI", "launch : fail, action is null");
      cIO();
      finish();
      return;
    }
    Object localObject;
    if (localBundle != null)
    {
      localObject = localBundle.getParcelable("android.intent.extra.STREAM");
      if ((localObject instanceof Uri))
      {
        this.uri = ((Uri)localObject);
        if (!bk.m(this.uri))
        {
          y.e("MicroMsg.AddFavoriteUI", "launch : fail, not accept, %s", new Object[] { this.uri });
          cIO();
          finish();
        }
      }
      else if (localObject != null)
      {
        y.e("MicroMsg.AddFavoriteUI", "launch : fail, uri check fail, %s", new Object[] { localObject });
        cIO();
        finish();
        return;
      }
    }
    if (str.equals("android.intent.action.SEND"))
    {
      y.i("MicroMsg.AddFavoriteUI", "send signal: " + str);
      if (this.uri == null)
      {
        showDialog();
        com.tencent.mm.sdk.f.e.post(new AddFavoriteUI.1(this), "AddFavoriteUI_dealWithTextHandler");
        return;
      }
      showDialog();
      com.tencent.mm.sdk.f.e.post(new AddFavoriteUI.a(this, this.uri, new AddFavoriteUI.8(this)), "AddFavoriteUI_getFilePath");
      return;
    }
    if ((str.equals("android.intent.action.SEND_MULTIPLE")) && (localBundle != null) && (localBundle.containsKey("android.intent.extra.STREAM")))
    {
      localObject = getIntent().resolveType(this);
      y.i("MicroMsg.AddFavoriteUI", "send multi: %s, mimeType %s", new Object[] { str, localObject });
      if (!bk.aM((String)localObject, "").contains("image"))
      {
        y.e("MicroMsg.AddFavoriteUI", "launch : fail, mimeType not contains image");
        Id(1);
        finish();
        return;
      }
      this.vYa = ar(localBundle);
      if ((this.vYa == null) || (this.vYa.size() == 0))
      {
        y.e("MicroMsg.AddFavoriteUI", "launch : fail, filePathList is null");
        Id(1);
        finish();
        return;
      }
      showDialog();
      com.tencent.mm.sdk.f.e.post(new AddFavoriteUI.9(this), "AddFavoriteUI_dealWithMultiItemHandler");
      return;
    }
    y.e("MicroMsg.AddFavoriteUI", "launch : fail, uri is null");
    cIO();
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    y.i("MicroMsg.AddFavoriteUI", "on create");
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    int i = t.a(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      y.e("MicroMsg.AddFavoriteUI", "onCreate, should not reach here, resultCode = " + i);
      finish();
      return;
    case 1: 
      finish();
      return;
    }
    NotifyReceiver.vY();
    initView();
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.AddFavoriteUI", "on Destroy");
    au.Dk().b(837, this);
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.i("MicroMsg.AddFavoriteUI", "on NewIntent");
    super.onNewIntent(paramIntent);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    y.i("MicroMsg.AddFavoriteUI", "on RestoreInstanceState");
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    y.i("MicroMsg.AddFavoriteUI", "on SaveInstanceState");
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.AddFavoriteUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    dismissDialog();
    if ((paramm instanceof com.tencent.mm.modelsimple.d))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label74;
      }
      if (this.vXZ != null)
      {
        com.tencent.mm.sdk.b.a.udP.m(this.vXZ);
        this.vXZ = null;
      }
    }
    label74:
    do
    {
      do
      {
        return;
      } while (paramm.edi == null);
      paramString = (pp)((com.tencent.mm.ah.b)paramm.edi).ecF.ecN;
      if ((paramString != null) && (!bk.bl(paramString.sNw)))
      {
        paramm = new Intent();
        paramm.putExtra("rawUrl", paramString.sNw);
        paramm.putExtra("showShare", false);
        paramm.putExtra("show_bottom", false);
        paramm.putExtra("needRedirect", false);
        com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramm);
        finish();
        return;
      }
    } while (this.vXZ == null);
    com.tencent.mm.sdk.b.a.udP.m(this.vXZ);
    this.vXZ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AddFavoriteUI
 * JD-Core Version:    0.7.0.1
 */