package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(3)
public class AddFavoriteUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private dn afDB;
  ArrayList<String> afDC;
  private MMHandler afDD;
  private MMHandler afDE;
  String filePath;
  private MMHandler handler;
  private Intent intent;
  private ProgressDialog lzP;
  Uri uri;
  
  public AddFavoriteUI()
  {
    AppMethodBeat.i(38953);
    this.lzP = null;
    this.intent = null;
    this.filePath = null;
    this.uri = null;
    this.afDC = null;
    this.afDD = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(38946);
        AddFavoriteUI.d(AddFavoriteUI.this);
        Log.i("MicroMsg.AddFavoriteUI", "dealWithText: %b", new Object[] { Boolean.valueOf(AddFavoriteUI.e(AddFavoriteUI.this)) });
        AppMethodBeat.o(38946);
      }
    };
    this.afDE = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(38947);
        AddFavoriteUI.d(AddFavoriteUI.this);
        AddFavoriteUI.f(AddFavoriteUI.this);
        AppMethodBeat.o(38947);
      }
    };
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(38948);
        AddFavoriteUI.d(AddFavoriteUI.this);
        if ((Util.isNullOrNil(AddFavoriteUI.this.filePath)) || ((Util.isImageFilename(AddFavoriteUI.this.filePath)) && (!AddFavoriteUI.bCv(AddFavoriteUI.this.filePath))))
        {
          Log.e("MicroMsg.AddFavoriteUI", "launch : fail, filePath is null or file is not a valid img.");
          AddFavoriteUI.g(AddFavoriteUI.this);
          AddFavoriteUI.this.finish();
          AppMethodBeat.o(38948);
          return;
        }
        AddFavoriteUI.h(AddFavoriteUI.this);
        AppMethodBeat.o(38948);
      }
    };
    AppMethodBeat.o(38953);
  }
  
  /* Error */
  private String a(Uri paramUri, android.database.Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +434 -> 440
    //   9: ldc 109
    //   11: astore 8
    //   13: aload_2
    //   14: ldc 111
    //   16: invokeinterface 117 2 0
    //   21: istore_3
    //   22: iload_3
    //   23: iconst_m1
    //   24: if_icmpeq +51 -> 75
    //   27: aload_2
    //   28: iload_3
    //   29: invokeinterface 121 2 0
    //   34: astore 5
    //   36: aload 5
    //   38: astore 4
    //   40: aload 5
    //   42: ifnull +14 -> 56
    //   45: aload 5
    //   47: ldc 123
    //   49: ldc 125
    //   51: invokevirtual 131	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 4
    //   56: ldc 133
    //   58: ldc 135
    //   60: aload 4
    //   62: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   65: invokevirtual 143	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload 4
    //   73: astore 8
    //   75: aload_2
    //   76: invokeinterface 151 1 0
    //   81: aload_0
    //   82: invokevirtual 155	com/tencent/mm/ui/tools/AddFavoriteUI:getContentResolver	()Landroid/content/ContentResolver;
    //   85: aload_1
    //   86: ldc 157
    //   88: invokevirtual 163	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 169	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   96: astore_2
    //   97: aload_1
    //   98: invokevirtual 173	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   101: l2i
    //   102: newarray byte
    //   104: astore 9
    //   106: aload_2
    //   107: aload 9
    //   109: invokevirtual 179	java/io/FileInputStream:read	([B)I
    //   112: ifle +312 -> 424
    //   115: invokestatic 185	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   118: pop
    //   119: invokestatic 191	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   122: ifne +144 -> 266
    //   125: aload_0
    //   126: aload 8
    //   128: invokevirtual 195	com/tencent/mm/ui/tools/AddFavoriteUI:deleteFile	(Ljava/lang/String;)Z
    //   131: pop
    //   132: aload 8
    //   134: iconst_0
    //   135: invokestatic 201	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   138: astore 7
    //   140: aload 7
    //   142: astore 6
    //   144: aload_2
    //   145: astore 5
    //   147: aload_1
    //   148: astore 4
    //   150: aload 7
    //   152: aload 9
    //   154: invokevirtual 207	java/io/OutputStream:write	([B)V
    //   157: aload 7
    //   159: astore 6
    //   161: aload_2
    //   162: astore 5
    //   164: aload_1
    //   165: astore 4
    //   167: aload 7
    //   169: invokevirtual 210	java/io/OutputStream:flush	()V
    //   172: aload 7
    //   174: astore 6
    //   176: aload_2
    //   177: astore 5
    //   179: aload_1
    //   180: astore 4
    //   182: new 212	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   189: aload_0
    //   190: invokevirtual 217	com/tencent/mm/ui/tools/AddFavoriteUI:getFilesDir	()Ljava/io/File;
    //   193: invokevirtual 223	java/io/File:getPath	()Ljava/lang/String;
    //   196: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 229
    //   201: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 8
    //   206: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: astore 8
    //   214: aload_2
    //   215: ifnull +7 -> 222
    //   218: aload_2
    //   219: invokevirtual 233	java/io/FileInputStream:close	()V
    //   222: aload_1
    //   223: ifnull +7 -> 230
    //   226: aload_1
    //   227: invokevirtual 234	android/content/res/AssetFileDescriptor:close	()V
    //   230: aload 7
    //   232: ifnull +8 -> 240
    //   235: aload 7
    //   237: invokevirtual 235	java/io/OutputStream:close	()V
    //   240: ldc 107
    //   242: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload 8
    //   247: areturn
    //   248: astore_1
    //   249: ldc 133
    //   251: aload_1
    //   252: aload_1
    //   253: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   256: iconst_0
    //   257: anewarray 240	java/lang/Object
    //   260: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: goto -23 -> 240
    //   266: new 212	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   273: invokestatic 249	com/tencent/mm/loader/i/b:bmz	()Ljava/lang/String;
    //   276: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc 251
    //   281: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: astore 5
    //   289: new 212	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   296: invokestatic 249	com/tencent/mm/loader/i/b:bmz	()Ljava/lang/String;
    //   299: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc 253
    //   304: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 8
    //   309: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: astore 4
    //   317: new 255	com/tencent/mm/vfs/u
    //   320: dup
    //   321: aload 5
    //   323: invokespecial 258	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   326: astore 5
    //   328: aload 5
    //   330: invokevirtual 261	com/tencent/mm/vfs/u:jKS	()Z
    //   333: ifne +9 -> 342
    //   336: aload 5
    //   338: invokevirtual 264	com/tencent/mm/vfs/u:jKY	()Z
    //   341: pop
    //   342: new 255	com/tencent/mm/vfs/u
    //   345: dup
    //   346: aload 4
    //   348: invokespecial 258	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   351: astore 5
    //   353: aload 5
    //   355: invokevirtual 261	com/tencent/mm/vfs/u:jKS	()Z
    //   358: ifne +9 -> 367
    //   361: aload 5
    //   363: invokevirtual 267	com/tencent/mm/vfs/u:jKZ	()Z
    //   366: pop
    //   367: aload 4
    //   369: aload 9
    //   371: aload 9
    //   373: arraylength
    //   374: invokestatic 271	com/tencent/mm/vfs/y:f	(Ljava/lang/String;[BI)I
    //   377: istore_3
    //   378: iload_3
    //   379: ifne +45 -> 424
    //   382: aload_2
    //   383: ifnull +7 -> 390
    //   386: aload_2
    //   387: invokevirtual 233	java/io/FileInputStream:close	()V
    //   390: aload_1
    //   391: ifnull +7 -> 398
    //   394: aload_1
    //   395: invokevirtual 234	android/content/res/AssetFileDescriptor:close	()V
    //   398: ldc 107
    //   400: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: aload 4
    //   405: areturn
    //   406: astore_1
    //   407: ldc 133
    //   409: aload_1
    //   410: aload_1
    //   411: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   414: iconst_0
    //   415: anewarray 240	java/lang/Object
    //   418: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   421: goto -23 -> 398
    //   424: aload_2
    //   425: ifnull +7 -> 432
    //   428: aload_2
    //   429: invokevirtual 233	java/io/FileInputStream:close	()V
    //   432: aload_1
    //   433: ifnull +7 -> 440
    //   436: aload_1
    //   437: invokevirtual 234	android/content/res/AssetFileDescriptor:close	()V
    //   440: ldc 107
    //   442: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: aconst_null
    //   446: areturn
    //   447: astore_1
    //   448: ldc 133
    //   450: aload_1
    //   451: aload_1
    //   452: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   455: iconst_0
    //   456: anewarray 240	java/lang/Object
    //   459: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: goto -22 -> 440
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
    //   484: ldc 133
    //   486: new 212	java/lang/StringBuilder
    //   489: dup
    //   490: ldc_w 273
    //   493: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   496: aload 8
    //   498: invokevirtual 275	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   501: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload_2
    //   511: ifnull +7 -> 518
    //   514: aload_2
    //   515: invokevirtual 233	java/io/FileInputStream:close	()V
    //   518: aload_1
    //   519: ifnull +7 -> 526
    //   522: aload_1
    //   523: invokevirtual 234	android/content/res/AssetFileDescriptor:close	()V
    //   526: aload 7
    //   528: ifnull -88 -> 440
    //   531: aload 7
    //   533: invokevirtual 235	java/io/OutputStream:close	()V
    //   536: goto -96 -> 440
    //   539: astore_1
    //   540: ldc 133
    //   542: aload_1
    //   543: aload_1
    //   544: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   547: iconst_0
    //   548: anewarray 240	java/lang/Object
    //   551: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   554: goto -114 -> 440
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
    //   576: ldc 133
    //   578: new 212	java/lang/StringBuilder
    //   581: dup
    //   582: ldc_w 280
    //   585: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   588: aload 8
    //   590: invokevirtual 281	java/io/IOException:getMessage	()Ljava/lang/String;
    //   593: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   602: aload_2
    //   603: ifnull +7 -> 610
    //   606: aload_2
    //   607: invokevirtual 233	java/io/FileInputStream:close	()V
    //   610: aload_1
    //   611: ifnull +7 -> 618
    //   614: aload_1
    //   615: invokevirtual 234	android/content/res/AssetFileDescriptor:close	()V
    //   618: aload 7
    //   620: ifnull -180 -> 440
    //   623: aload 7
    //   625: invokevirtual 235	java/io/OutputStream:close	()V
    //   628: goto -188 -> 440
    //   631: astore_1
    //   632: ldc 133
    //   634: aload_1
    //   635: aload_1
    //   636: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   639: iconst_0
    //   640: anewarray 240	java/lang/Object
    //   643: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   646: goto -206 -> 440
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
    //   668: ldc 133
    //   670: new 212	java/lang/StringBuilder
    //   673: dup
    //   674: ldc_w 283
    //   677: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   680: aload 8
    //   682: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   685: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: aload_2
    //   695: ifnull +7 -> 702
    //   698: aload_2
    //   699: invokevirtual 233	java/io/FileInputStream:close	()V
    //   702: aload_1
    //   703: ifnull +7 -> 710
    //   706: aload_1
    //   707: invokevirtual 234	android/content/res/AssetFileDescriptor:close	()V
    //   710: aload 7
    //   712: ifnull -272 -> 440
    //   715: aload 7
    //   717: invokevirtual 235	java/io/OutputStream:close	()V
    //   720: goto -280 -> 440
    //   723: astore_1
    //   724: ldc 133
    //   726: aload_1
    //   727: aload_1
    //   728: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   731: iconst_0
    //   732: anewarray 240	java/lang/Object
    //   735: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   738: goto -298 -> 440
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
    //   755: invokevirtual 233	java/io/FileInputStream:close	()V
    //   758: aload_1
    //   759: ifnull +7 -> 766
    //   762: aload_1
    //   763: invokevirtual 234	android/content/res/AssetFileDescriptor:close	()V
    //   766: aload 6
    //   768: ifnull +8 -> 776
    //   771: aload 6
    //   773: invokevirtual 235	java/io/OutputStream:close	()V
    //   776: ldc 107
    //   778: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   781: aload 7
    //   783: athrow
    //   784: astore_1
    //   785: ldc 133
    //   787: aload_1
    //   788: aload_1
    //   789: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   792: iconst_0
    //   793: anewarray 240	java/lang/Object
    //   796: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   799: goto -23 -> 776
    //   802: astore 7
    //   804: aconst_null
    //   805: astore 6
    //   807: aconst_null
    //   808: astore_2
    //   809: goto -59 -> 750
    //   812: astore 7
    //   814: aconst_null
    //   815: astore 6
    //   817: goto -67 -> 750
    //   820: astore 7
    //   822: aload 5
    //   824: astore_2
    //   825: aload 4
    //   827: astore_1
    //   828: goto -78 -> 750
    //   831: astore 8
    //   833: aconst_null
    //   834: astore 7
    //   836: aconst_null
    //   837: astore_2
    //   838: goto -180 -> 658
    //   841: astore 8
    //   843: aconst_null
    //   844: astore 7
    //   846: goto -188 -> 658
    //   849: astore 8
    //   851: goto -193 -> 658
    //   854: astore 8
    //   856: aconst_null
    //   857: astore 7
    //   859: aconst_null
    //   860: astore_2
    //   861: goto -295 -> 566
    //   864: astore 8
    //   866: aconst_null
    //   867: astore 7
    //   869: goto -303 -> 566
    //   872: astore 8
    //   874: goto -308 -> 566
    //   877: astore 8
    //   879: aconst_null
    //   880: astore 7
    //   882: aconst_null
    //   883: astore_2
    //   884: goto -410 -> 474
    //   887: astore 8
    //   889: aconst_null
    //   890: astore 7
    //   892: goto -418 -> 474
    //   895: astore 8
    //   897: goto -423 -> 474
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	900	0	this	AddFavoriteUI
    //   0	900	1	paramUri	Uri
    //   0	900	2	paramCursor	android.database.Cursor
    //   21	358	3	i	int
    //   38	788	4	localObject1	Object
    //   34	789	5	localObject2	Object
    //   142	674	6	localOutputStream1	java.io.OutputStream
    //   138	578	7	localOutputStream2	java.io.OutputStream
    //   741	41	7	localObject3	Object
    //   802	1	7	localObject4	Object
    //   812	1	7	localObject5	Object
    //   820	1	7	localObject6	Object
    //   834	57	7	localObject7	Object
    //   11	297	8	localObject8	Object
    //   465	32	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   557	32	8	localIOException1	java.io.IOException
    //   649	32	8	localException1	Exception
    //   831	1	8	localException2	Exception
    //   841	1	8	localException3	Exception
    //   849	1	8	localException4	Exception
    //   854	1	8	localIOException2	java.io.IOException
    //   864	1	8	localIOException3	java.io.IOException
    //   872	1	8	localIOException4	java.io.IOException
    //   877	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   887	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   895	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   104	268	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   218	222	248	java/lang/Exception
    //   226	230	248	java/lang/Exception
    //   235	240	248	java/lang/Exception
    //   386	390	406	java/lang/Exception
    //   394	398	406	java/lang/Exception
    //   428	432	447	java/lang/Exception
    //   436	440	447	java/lang/Exception
    //   81	92	465	java/io/FileNotFoundException
    //   514	518	539	java/lang/Exception
    //   522	526	539	java/lang/Exception
    //   531	536	539	java/lang/Exception
    //   81	92	557	java/io/IOException
    //   606	610	631	java/lang/Exception
    //   614	618	631	java/lang/Exception
    //   623	628	631	java/lang/Exception
    //   81	92	649	java/lang/Exception
    //   698	702	723	java/lang/Exception
    //   706	710	723	java/lang/Exception
    //   715	720	723	java/lang/Exception
    //   81	92	741	finally
    //   754	758	784	java/lang/Exception
    //   762	766	784	java/lang/Exception
    //   771	776	784	java/lang/Exception
    //   92	97	802	finally
    //   97	140	812	finally
    //   266	342	812	finally
    //   342	367	812	finally
    //   367	378	812	finally
    //   150	157	820	finally
    //   167	172	820	finally
    //   182	214	820	finally
    //   484	510	820	finally
    //   576	602	820	finally
    //   668	694	820	finally
    //   92	97	831	java/lang/Exception
    //   97	140	841	java/lang/Exception
    //   266	342	841	java/lang/Exception
    //   342	367	841	java/lang/Exception
    //   367	378	841	java/lang/Exception
    //   150	157	849	java/lang/Exception
    //   167	172	849	java/lang/Exception
    //   182	214	849	java/lang/Exception
    //   92	97	854	java/io/IOException
    //   97	140	864	java/io/IOException
    //   266	342	864	java/io/IOException
    //   342	367	864	java/io/IOException
    //   367	378	864	java/io/IOException
    //   150	157	872	java/io/IOException
    //   167	172	872	java/io/IOException
    //   182	214	872	java/io/IOException
    //   92	97	877	java/io/FileNotFoundException
    //   97	140	887	java/io/FileNotFoundException
    //   266	342	887	java/io/FileNotFoundException
    //   342	367	887	java/io/FileNotFoundException
    //   367	378	887	java/io/FileNotFoundException
    //   150	157	895	java/io/FileNotFoundException
    //   167	172	895	java/io/FileNotFoundException
    //   182	214	895	java/io/FileNotFoundException
  }
  
  private void aDM()
  {
    AppMethodBeat.i(38968);
    if ((this.lzP != null) && (this.lzP.isShowing())) {
      this.lzP.dismiss();
    }
    AppMethodBeat.o(38968);
  }
  
  private void aEc(int paramInt)
  {
    AppMethodBeat.i(38966);
    switch (paramInt)
    {
    default: 
      Toast.makeText(this, R.l.gWk, 1).show();
      AppMethodBeat.o(38966);
      return;
    }
    Toast.makeText(this, R.l.gWh, 1).show();
    AppMethodBeat.o(38966);
  }
  
  private static int bCu(String paramString)
  {
    AppMethodBeat.i(38964);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AddFavoriteUI", "map : mimeType is null");
      AppMethodBeat.o(38964);
      return -1;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.contains("image")) || (paramString.equals("application/vnd.google.panorama360+jpg")))
    {
      AppMethodBeat.o(38964);
      return 2;
    }
    if (paramString.contains("video"))
    {
      AppMethodBeat.o(38964);
      return 4;
    }
    Log.d("MicroMsg.AddFavoriteUI", "map : unknown mimetype, send as file");
    AppMethodBeat.o(38964);
    return 8;
  }
  
  private void fpM()
  {
    AppMethodBeat.i(38967);
    getString(R.l.app_tip);
    this.lzP = k.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(38967);
  }
  
  private void jCQ()
  {
    AppMethodBeat.i(38960);
    Intent localIntent = new Intent(this, AddFavoriteUI.class);
    localIntent.setAction("android.intent.action.SEND");
    if (Util.isNullOrNil(this.filePath)) {}
    for (Object localObject = null;; localObject = FileProviderHelper.getUriForFile(getContext(), new u(this.filePath)))
    {
      localIntent.putExtra("android.intent.extra.STREAM", (Parcelable)localObject);
      localIntent.addFlags(268435456).addFlags(32768);
      localIntent.setType(getIntent().getType());
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), localIntent);
      AppMethodBeat.o(38960);
      return;
    }
  }
  
  private boolean jCR()
  {
    AppMethodBeat.i(38961);
    this.intent = getIntent();
    if (this.intent == null)
    {
      Log.e("MicroMsg.AddFavoriteUI", "intent is null");
      AppMethodBeat.o(38961);
      return false;
    }
    Object localObject1 = IntentUtil.getStringExtra(this.intent, "android.intent.extra.TEXT");
    if ((localObject1 == null) || (((String)localObject1).length() == 0))
    {
      Log.i("MicroMsg.AddFavoriteUI", "text is null");
      AppMethodBeat.o(38961);
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
    ((Bundle)localObject3).putInt("_mmessage_sdkVersion", 638058496);
    ((Bundle)localObject3).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
    ((Bundle)localObject3).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
    if ((bh.bCA()) && (!bh.aZG()))
    {
      localObject2 = new dn();
      localObject3 = y.bEq(this.filePath) + "." + y.alV(this.filePath);
      if (i == 1)
      {
        l.b((dn)localObject2, (String)localObject1, 13);
        ((dn)localObject2).hDr.activity = this;
        ((dn)localObject2).hDr.hDz = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38940);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38940);
          }
        };
        ((dn)localObject2).hDr.hDA = new a.c()
        {
          public final void cpT() {}
          
          public final void onHide()
          {
            AppMethodBeat.i(38941);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38941);
          }
          
          public final void onShow() {}
        };
        this.afDB = ((dn)localObject2);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localObject1 = new i(5, (List)localObject2, getCallerPackage());
        bh.aZW().a(837, this);
        com.tencent.mm.kernel.h.aZW().a((p)localObject1, 0);
        fpM();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(38961);
      return true;
      l.a((dn)localObject2, 13, this.filePath, (String)localObject3, "", false);
      break;
      Log.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
      finish();
    }
  }
  
  private void jCS()
  {
    AppMethodBeat.i(38965);
    aEc(0);
    Toast.makeText(this, R.l.gWk, 1).show();
    AppMethodBeat.o(38965);
  }
  
  private void p(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(38962);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
      AppMethodBeat.o(38962);
      return;
    }
    long l1 = y.bEl(paramString);
    Log.i("MicroMsg.AddFavoriteUI", "filelength: [%d]", new Object[] { Long.valueOf(l1) });
    if (l1 == 0L)
    {
      Log.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
      Toast.makeText(this, R.l.favorite_file_length_zero, 1).show();
      finish();
      AppMethodBeat.o(38962);
      return;
    }
    long l2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSizeLimit(paramBoolean, paramInt);
    int i = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSizeLimitInMB(paramBoolean, paramInt);
    if (l1 > l2)
    {
      Log.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
      Toast.makeText(this, getString(R.l.favorite_too_large_format, new Object[] { Integer.valueOf(i) }), 1).show();
      finish();
      AppMethodBeat.o(38962);
      return;
    }
    if ((bh.bCA()) && (!bh.aZG()))
    {
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramString);
      dn localdn = new dn();
      String str = y.bEq(paramString) + "." + y.alV(paramString);
      Object localObject2;
      switch (paramInt)
      {
      case 3: 
      default: 
        localObject2 = new WXFileObject(paramString);
        localObject1 = new i(4, (List)localObject1, getCallerPackage());
        l.a(localdn, 13, paramString, str, "", paramBoolean);
        localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
        ((WXMediaMessage)localObject2).title = new u(paramString).getName();
        if (Util.isNullOrNil(null))
        {
          ((WXMediaMessage)localObject2).description = Util.getSizeKB(l1);
          label365:
          if (l1 >= 30720L) {
            break label631;
          }
          ((WXMediaMessage)localObject2).thumbData = y.bi(paramString, 0, -1);
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
        ((Bundle)localObject2).putInt("_mmessage_sdkVersion", 638058496);
        ((Bundle)localObject2).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
        ((Bundle)localObject2).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        localdn.hDr.activity = this;
        localdn.hDr.hDz = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38942);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38942);
          }
        };
        localdn.hDr.hDA = new a.c()
        {
          public final void cpT() {}
          
          public final void onHide()
          {
            AppMethodBeat.i(38943);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38943);
          }
          
          public final void onShow() {}
        };
        this.afDB = localdn;
        com.tencent.mm.kernel.h.aZW().a(837, this);
        com.tencent.mm.kernel.h.aZW().a((p)localObject1, 0);
        fpM();
        AppMethodBeat.o(38962);
        return;
        localObject2 = new WXImageObject();
        ((WXImageObject)localObject2).setImagePath(paramString);
        localObject1 = new i(1, (List)localObject1, getCallerPackage());
        l.a(localdn, 13, paramString);
        break;
        localObject2 = new WXVideoFileObject(paramString);
        localObject1 = new i(3, (List)localObject1, getCallerPackage());
        l.a(localdn, 13, paramString, null, 0, str, "", paramBoolean);
        break;
        ((WXMediaMessage)localObject2).description = null;
        break label365;
        label631:
        Log.i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
      }
    }
    Log.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
    finish();
    jCQ();
    AppMethodBeat.o(38962);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38959);
    this.intent = getIntent();
    if (this.intent == null)
    {
      Log.e("MicroMsg.AddFavoriteUI", "launch : fail, intent is null");
      jCS();
      finish();
      AppMethodBeat.o(38959);
      return;
    }
    Object localObject1 = this.intent.getAction();
    Object localObject2 = IntentUtil.getExtras(this.intent);
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.AddFavoriteUI", "launch : fail, action is null");
      jCS();
      finish();
      AppMethodBeat.o(38959);
      return;
    }
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = ((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
      if ((localObject3 instanceof Uri))
      {
        this.uri = ((Uri)localObject3);
        if (!Util.isUriSafeToBeCopySrc(this.uri))
        {
          Log.e("MicroMsg.AddFavoriteUI", "launch : fail, not accept, %s", new Object[] { this.uri });
          jCS();
          finish();
          AppMethodBeat.o(38959);
        }
      }
      else if (localObject3 != null)
      {
        Log.e("MicroMsg.AddFavoriteUI", "launch : fail, uri check fail, %s", new Object[] { localObject3 });
        jCS();
        finish();
        AppMethodBeat.o(38959);
        return;
      }
    }
    if (((String)localObject1).equals("android.intent.action.SEND"))
    {
      Log.i("MicroMsg.AddFavoriteUI", "send signal: ".concat(String.valueOf(localObject1)));
      if (this.uri == null)
      {
        fpM();
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38938);
            AddFavoriteUI.a(AddFavoriteUI.this).sendEmptyMessage(0);
            AppMethodBeat.o(38938);
          }
        }, "AddFavoriteUI_dealWithTextHandler");
        AppMethodBeat.o(38959);
        return;
      }
      fpM();
      ThreadPool.post(new a(this.uri, new b()
      {
        public final void jCT()
        {
          AppMethodBeat.i(38944);
          AddFavoriteUI.b(AddFavoriteUI.this).sendEmptyMessage(0);
          AppMethodBeat.o(38944);
        }
      }), "AddFavoriteUI_getFilePath");
      AppMethodBeat.o(38959);
      return;
    }
    if ((((String)localObject1).equals("android.intent.action.SEND_MULTIPLE")) && (localObject2 != null) && (((Bundle)localObject2).containsKey("android.intent.extra.STREAM")))
    {
      localObject3 = getIntent().resolveType(this);
      Log.i("MicroMsg.AddFavoriteUI", "send multi: %s, mimeType %s", new Object[] { localObject1, localObject3 });
      if (!Util.nullAs((String)localObject3, "").contains("image"))
      {
        Log.e("MicroMsg.AddFavoriteUI", "launch : fail, mimeType not contains image");
        aEc(1);
        finish();
        AppMethodBeat.o(38959);
        return;
      }
      localObject2 = ((Bundle)localObject2).getParcelableArrayList("android.intent.extra.STREAM");
      label473:
      int i;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject1 = new ArrayList();
        localObject2 = ((ArrayList)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Parcelable)((Iterator)localObject2).next();
          if ((localObject3 == null) || (!(localObject3 instanceof Uri)))
          {
            Log.e("MicroMsg.AddFavoriteUI", "getMultiSendFilePath failed, error parcelable, %s", new Object[] { localObject3 });
            i = 0;
            label475:
            if (i != 0) {
              break label608;
            }
            localObject1 = null;
          }
        }
      }
      for (;;)
      {
        this.afDC = ((ArrayList)localObject1);
        if ((this.afDC != null) && (this.afDC.size() != 0)) {
          break label676;
        }
        Log.e("MicroMsg.AddFavoriteUI", "launch : fail, filePathList is null");
        aEc(1);
        finish();
        AppMethodBeat.o(38959);
        return;
        localObject3 = (Uri)localObject3;
        if ((Util.isUriSafeToBeCopySrc((Uri)localObject3)) && (((Uri)localObject3).getScheme() != null))
        {
          localObject3 = Util.getFilePath(this, (Uri)localObject3);
          if (Util.isNullOrNil((String)localObject3)) {
            break label473;
          }
          if ((Util.isImageFilename((String)localObject3)) && (ImgUtil.isImgFile((String)localObject3)))
          {
            Log.i("MicroMsg.AddFavoriteUI", "multisend file path: ".concat(String.valueOf(localObject3)));
            ((ArrayList)localObject1).add(localObject3);
            i = 1;
            break label475;
            label608:
            break;
          }
          Log.w("MicroMsg.AddFavoriteUI", "multisend tries to send illegal img: ".concat(String.valueOf(localObject3)));
          break label473;
        }
        Log.e("MicroMsg.AddFavoriteUI", "unaccepted uri: ".concat(String.valueOf(localObject3)));
        break label473;
        if (((ArrayList)localObject1).size() <= 0)
        {
          localObject1 = null;
          continue;
          Log.e("MicroMsg.AddFavoriteUI", "getParcelableArrayList failed");
          localObject1 = null;
        }
      }
      label676:
      fpM();
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38945);
          AddFavoriteUI.c(AddFavoriteUI.this).sendEmptyMessage(0);
          AppMethodBeat.o(38945);
        }
      }, "AddFavoriteUI_dealWithMultiItemHandler");
      AppMethodBeat.o(38959);
      return;
    }
    Log.e("MicroMsg.AddFavoriteUI", "launch : fail, uri is null");
    jCS();
    finish();
    AppMethodBeat.o(38959);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38954);
    Log.i("MicroMsg.AddFavoriteUI", "on create");
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    int i = IntentUtil.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      Log.e("MicroMsg.AddFavoriteUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(i)));
      finish();
      AppMethodBeat.o(38954);
      return;
    case 1: 
      finish();
      AppMethodBeat.o(38954);
      return;
    }
    NotifyReceiver.aKz();
    initView();
    AppMethodBeat.o(38954);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38958);
    Log.i("MicroMsg.AddFavoriteUI", "on Destroy");
    bh.aZW().b(837, this);
    super.onDestroy();
    AppMethodBeat.o(38958);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(38956);
    Log.i("MicroMsg.AddFavoriteUI", "on NewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(38956);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(38957);
    Log.i("MicroMsg.AddFavoriteUI", "on RestoreInstanceState");
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(38957);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(38955);
    Log.i("MicroMsg.AddFavoriteUI", "on SaveInstanceState");
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(38955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(38969);
    Log.i("MicroMsg.AddFavoriteUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    aDM();
    if ((paramp instanceof i)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.afDB != null)
        {
          this.afDB.publish();
          this.afDB = null;
          AppMethodBeat.o(38969);
        }
      }
      else if (paramp.getReqResp() != null)
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
          finish();
          AppMethodBeat.o(38969);
          return;
        }
        if (this.afDB != null)
        {
          this.afDB.publish();
          this.afDB = null;
        }
      }
    }
    AppMethodBeat.o(38969);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements Runnable
  {
    private AddFavoriteUI.b afDG;
    private Uri mUri;
    
    public a(Uri paramUri, AddFavoriteUI.b paramb)
    {
      this.mUri = paramUri;
      this.afDG = paramb;
    }
    
    public final void run()
    {
      AppMethodBeat.i(38952);
      try
      {
        AddFavoriteUI.this.filePath = AddFavoriteUI.a(AddFavoriteUI.this, this.mUri);
        if ((Util.isNullOrNil(AddFavoriteUI.this.filePath)) || (!new u(AddFavoriteUI.this.filePath).jKS()) || ((Build.VERSION.SDK_INT >= 30) && (!new u(AddFavoriteUI.this.filePath).jKQ()))) {
          if (AddFavoriteUI.bCw(AddFavoriteUI.this.getContentResolver().getType(this.mUri)) != 2) {
            break label149;
          }
        }
        label149:
        for (AddFavoriteUI.this.filePath = e.a(AddFavoriteUI.this.getContentResolver(), this.mUri, 1);; AddFavoriteUI.this.filePath = e.b(AddFavoriteUI.this.getContentResolver(), this.mUri)) {
          return;
        }
        AppMethodBeat.o(38952);
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AddFavoriteUI", localException, "", new Object[0]);
        AddFavoriteUI.this.filePath = null;
        return;
      }
      finally
      {
        if (this.afDG != null) {
          this.afDG.jCT();
        }
        AppMethodBeat.o(38952);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void jCT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AddFavoriteUI
 * JD-Core Version:    0.7.0.1
 */