package com.tencent.mm.ui.tools;

import android.app.Activity;
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
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.pluginsdk.m.e;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.event.EventCenter;
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
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141010", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class AddFavoriteUI
  extends MMActivity
  implements i
{
  private dd XNn;
  ArrayList<String> XNo;
  private MMHandler XNp;
  private MMHandler XNq;
  String filePath;
  private MMHandler handler;
  private ProgressDialog iXX;
  private Intent intent;
  Uri uri;
  
  public AddFavoriteUI()
  {
    AppMethodBeat.i(38953);
    this.iXX = null;
    this.intent = null;
    this.filePath = null;
    this.uri = null;
    this.XNo = null;
    this.XNp = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(38946);
        AddFavoriteUI.d(AddFavoriteUI.this);
        Log.i("MicroMsg.AddFavoriteUI", "dealWithText: %b", new Object[] { Boolean.valueOf(AddFavoriteUI.e(AddFavoriteUI.this)) });
        AppMethodBeat.o(38946);
      }
    };
    this.XNq = new MMHandler()
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
        if ((Util.isNullOrNil(AddFavoriteUI.this.filePath)) || ((Util.isImageFilename(AddFavoriteUI.this.filePath)) && (!AddFavoriteUI.bAz(AddFavoriteUI.this.filePath))))
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
    //   0: ldc 119
    //   2: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +435 -> 441
    //   9: ldc 121
    //   11: astore 8
    //   13: aload_2
    //   14: ldc 123
    //   16: invokeinterface 129 2 0
    //   21: istore_3
    //   22: iload_3
    //   23: iconst_m1
    //   24: if_icmpeq +51 -> 75
    //   27: aload_2
    //   28: iload_3
    //   29: invokeinterface 133 2 0
    //   34: astore 5
    //   36: aload 5
    //   38: astore 4
    //   40: aload 5
    //   42: ifnull +14 -> 56
    //   45: aload 5
    //   47: ldc 135
    //   49: ldc 137
    //   51: invokevirtual 143	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 4
    //   56: ldc 145
    //   58: ldc 147
    //   60: aload 4
    //   62: invokestatic 151	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   65: invokevirtual 155	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload 4
    //   73: astore 8
    //   75: aload_2
    //   76: invokeinterface 163 1 0
    //   81: aload_0
    //   82: invokevirtual 167	com/tencent/mm/ui/tools/AddFavoriteUI:getContentResolver	()Landroid/content/ContentResolver;
    //   85: aload_1
    //   86: ldc 169
    //   88: invokevirtual 175	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 181	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   96: astore_2
    //   97: aload_1
    //   98: invokevirtual 185	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   101: l2i
    //   102: newarray byte
    //   104: astore 9
    //   106: aload_2
    //   107: aload 9
    //   109: invokevirtual 191	java/io/FileInputStream:read	([B)I
    //   112: ifle +313 -> 425
    //   115: invokestatic 197	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   118: pop
    //   119: invokestatic 203	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   122: ifne +143 -> 265
    //   125: aload_0
    //   126: aload 8
    //   128: invokevirtual 207	com/tencent/mm/ui/tools/AddFavoriteUI:deleteFile	(Ljava/lang/String;)Z
    //   131: pop
    //   132: aload 8
    //   134: invokestatic 213	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   137: astore 7
    //   139: aload 7
    //   141: astore 6
    //   143: aload_2
    //   144: astore 5
    //   146: aload_1
    //   147: astore 4
    //   149: aload 7
    //   151: aload 9
    //   153: invokevirtual 219	java/io/OutputStream:write	([B)V
    //   156: aload 7
    //   158: astore 6
    //   160: aload_2
    //   161: astore 5
    //   163: aload_1
    //   164: astore 4
    //   166: aload 7
    //   168: invokevirtual 222	java/io/OutputStream:flush	()V
    //   171: aload 7
    //   173: astore 6
    //   175: aload_2
    //   176: astore 5
    //   178: aload_1
    //   179: astore 4
    //   181: new 224	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   188: aload_0
    //   189: invokevirtual 229	com/tencent/mm/ui/tools/AddFavoriteUI:getFilesDir	()Ljava/io/File;
    //   192: invokevirtual 235	java/io/File:getPath	()Ljava/lang/String;
    //   195: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 241
    //   200: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload 8
    //   205: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: astore 8
    //   213: aload_2
    //   214: ifnull +7 -> 221
    //   217: aload_2
    //   218: invokevirtual 245	java/io/FileInputStream:close	()V
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   229: aload 7
    //   231: ifnull +8 -> 239
    //   234: aload 7
    //   236: invokevirtual 247	java/io/OutputStream:close	()V
    //   239: ldc 119
    //   241: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: aload 8
    //   246: areturn
    //   247: astore_1
    //   248: ldc 145
    //   250: aload_1
    //   251: aload_1
    //   252: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   255: iconst_0
    //   256: anewarray 252	java/lang/Object
    //   259: invokestatic 256	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: goto -23 -> 239
    //   265: new 224	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   272: invokestatic 261	com/tencent/mm/loader/j/b:aSL	()Ljava/lang/String;
    //   275: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc_w 263
    //   281: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: astore 5
    //   289: new 224	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   296: invokestatic 261	com/tencent/mm/loader/j/b:aSL	()Ljava/lang/String;
    //   299: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc_w 265
    //   305: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 8
    //   310: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore 4
    //   318: new 267	com/tencent/mm/vfs/q
    //   321: dup
    //   322: aload 5
    //   324: invokespecial 270	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   327: astore 5
    //   329: aload 5
    //   331: invokevirtual 273	com/tencent/mm/vfs/q:ifE	()Z
    //   334: ifne +9 -> 343
    //   337: aload 5
    //   339: invokevirtual 276	com/tencent/mm/vfs/q:ifK	()Z
    //   342: pop
    //   343: new 267	com/tencent/mm/vfs/q
    //   346: dup
    //   347: aload 4
    //   349: invokespecial 270	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   352: astore 5
    //   354: aload 5
    //   356: invokevirtual 273	com/tencent/mm/vfs/q:ifE	()Z
    //   359: ifne +9 -> 368
    //   362: aload 5
    //   364: invokevirtual 279	com/tencent/mm/vfs/q:ifM	()Z
    //   367: pop
    //   368: aload 4
    //   370: aload 9
    //   372: aload 9
    //   374: arraylength
    //   375: invokestatic 283	com/tencent/mm/vfs/u:f	(Ljava/lang/String;[BI)I
    //   378: istore_3
    //   379: iload_3
    //   380: ifne +45 -> 425
    //   383: aload_2
    //   384: ifnull +7 -> 391
    //   387: aload_2
    //   388: invokevirtual 245	java/io/FileInputStream:close	()V
    //   391: aload_1
    //   392: ifnull +7 -> 399
    //   395: aload_1
    //   396: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   399: ldc 119
    //   401: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   404: aload 4
    //   406: areturn
    //   407: astore_1
    //   408: ldc 145
    //   410: aload_1
    //   411: aload_1
    //   412: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   415: iconst_0
    //   416: anewarray 252	java/lang/Object
    //   419: invokestatic 256	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   422: goto -23 -> 399
    //   425: aload_2
    //   426: ifnull +7 -> 433
    //   429: aload_2
    //   430: invokevirtual 245	java/io/FileInputStream:close	()V
    //   433: aload_1
    //   434: ifnull +7 -> 441
    //   437: aload_1
    //   438: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   441: ldc 119
    //   443: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: aconst_null
    //   447: areturn
    //   448: astore_1
    //   449: ldc 145
    //   451: aload_1
    //   452: aload_1
    //   453: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   456: iconst_0
    //   457: anewarray 252	java/lang/Object
    //   460: invokestatic 256	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   463: goto -22 -> 441
    //   466: astore 8
    //   468: aconst_null
    //   469: astore 7
    //   471: aconst_null
    //   472: astore_2
    //   473: aconst_null
    //   474: astore_1
    //   475: aload 7
    //   477: astore 6
    //   479: aload_2
    //   480: astore 5
    //   482: aload_1
    //   483: astore 4
    //   485: ldc 145
    //   487: new 224	java/lang/StringBuilder
    //   490: dup
    //   491: ldc_w 285
    //   494: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   497: aload 8
    //   499: invokevirtual 287	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   502: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: aload_2
    //   512: ifnull +7 -> 519
    //   515: aload_2
    //   516: invokevirtual 245	java/io/FileInputStream:close	()V
    //   519: aload_1
    //   520: ifnull +7 -> 527
    //   523: aload_1
    //   524: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   527: aload 7
    //   529: ifnull -88 -> 441
    //   532: aload 7
    //   534: invokevirtual 247	java/io/OutputStream:close	()V
    //   537: goto -96 -> 441
    //   540: astore_1
    //   541: ldc 145
    //   543: aload_1
    //   544: aload_1
    //   545: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   548: iconst_0
    //   549: anewarray 252	java/lang/Object
    //   552: invokestatic 256	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   555: goto -114 -> 441
    //   558: astore 8
    //   560: aconst_null
    //   561: astore 7
    //   563: aconst_null
    //   564: astore_2
    //   565: aconst_null
    //   566: astore_1
    //   567: aload 7
    //   569: astore 6
    //   571: aload_2
    //   572: astore 5
    //   574: aload_1
    //   575: astore 4
    //   577: ldc 145
    //   579: new 224	java/lang/StringBuilder
    //   582: dup
    //   583: ldc_w 292
    //   586: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   589: aload 8
    //   591: invokevirtual 293	java/io/IOException:getMessage	()Ljava/lang/String;
    //   594: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: aload_2
    //   604: ifnull +7 -> 611
    //   607: aload_2
    //   608: invokevirtual 245	java/io/FileInputStream:close	()V
    //   611: aload_1
    //   612: ifnull +7 -> 619
    //   615: aload_1
    //   616: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   619: aload 7
    //   621: ifnull -180 -> 441
    //   624: aload 7
    //   626: invokevirtual 247	java/io/OutputStream:close	()V
    //   629: goto -188 -> 441
    //   632: astore_1
    //   633: ldc 145
    //   635: aload_1
    //   636: aload_1
    //   637: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   640: iconst_0
    //   641: anewarray 252	java/lang/Object
    //   644: invokestatic 256	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   647: goto -206 -> 441
    //   650: astore 8
    //   652: aconst_null
    //   653: astore 7
    //   655: aconst_null
    //   656: astore_2
    //   657: aconst_null
    //   658: astore_1
    //   659: aload 7
    //   661: astore 6
    //   663: aload_2
    //   664: astore 5
    //   666: aload_1
    //   667: astore 4
    //   669: ldc 145
    //   671: new 224	java/lang/StringBuilder
    //   674: dup
    //   675: ldc_w 295
    //   678: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   681: aload 8
    //   683: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   686: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   695: aload_2
    //   696: ifnull +7 -> 703
    //   699: aload_2
    //   700: invokevirtual 245	java/io/FileInputStream:close	()V
    //   703: aload_1
    //   704: ifnull +7 -> 711
    //   707: aload_1
    //   708: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   711: aload 7
    //   713: ifnull -272 -> 441
    //   716: aload 7
    //   718: invokevirtual 247	java/io/OutputStream:close	()V
    //   721: goto -280 -> 441
    //   724: astore_1
    //   725: ldc 145
    //   727: aload_1
    //   728: aload_1
    //   729: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   732: iconst_0
    //   733: anewarray 252	java/lang/Object
    //   736: invokestatic 256	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   739: goto -298 -> 441
    //   742: astore 7
    //   744: aconst_null
    //   745: astore 6
    //   747: aconst_null
    //   748: astore_2
    //   749: aconst_null
    //   750: astore_1
    //   751: aload_2
    //   752: ifnull +7 -> 759
    //   755: aload_2
    //   756: invokevirtual 245	java/io/FileInputStream:close	()V
    //   759: aload_1
    //   760: ifnull +7 -> 767
    //   763: aload_1
    //   764: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   767: aload 6
    //   769: ifnull +8 -> 777
    //   772: aload 6
    //   774: invokevirtual 247	java/io/OutputStream:close	()V
    //   777: ldc 119
    //   779: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   782: aload 7
    //   784: athrow
    //   785: astore_1
    //   786: ldc 145
    //   788: aload_1
    //   789: aload_1
    //   790: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   793: iconst_0
    //   794: anewarray 252	java/lang/Object
    //   797: invokestatic 256	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   800: goto -23 -> 777
    //   803: astore 7
    //   805: aconst_null
    //   806: astore 6
    //   808: aconst_null
    //   809: astore_2
    //   810: goto -59 -> 751
    //   813: astore 7
    //   815: aconst_null
    //   816: astore 6
    //   818: goto -67 -> 751
    //   821: astore 7
    //   823: aload 5
    //   825: astore_2
    //   826: aload 4
    //   828: astore_1
    //   829: goto -78 -> 751
    //   832: astore 8
    //   834: aconst_null
    //   835: astore 7
    //   837: aconst_null
    //   838: astore_2
    //   839: goto -180 -> 659
    //   842: astore 8
    //   844: aconst_null
    //   845: astore 7
    //   847: goto -188 -> 659
    //   850: astore 8
    //   852: goto -193 -> 659
    //   855: astore 8
    //   857: aconst_null
    //   858: astore 7
    //   860: aconst_null
    //   861: astore_2
    //   862: goto -295 -> 567
    //   865: astore 8
    //   867: aconst_null
    //   868: astore 7
    //   870: goto -303 -> 567
    //   873: astore 8
    //   875: goto -308 -> 567
    //   878: astore 8
    //   880: aconst_null
    //   881: astore 7
    //   883: aconst_null
    //   884: astore_2
    //   885: goto -410 -> 475
    //   888: astore 8
    //   890: aconst_null
    //   891: astore 7
    //   893: goto -418 -> 475
    //   896: astore 8
    //   898: goto -423 -> 475
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	901	0	this	AddFavoriteUI
    //   0	901	1	paramUri	Uri
    //   0	901	2	paramCursor	android.database.Cursor
    //   21	359	3	i	int
    //   38	789	4	localObject1	Object
    //   34	790	5	localObject2	Object
    //   141	676	6	localOutputStream1	java.io.OutputStream
    //   137	580	7	localOutputStream2	java.io.OutputStream
    //   742	41	7	localObject3	Object
    //   803	1	7	localObject4	Object
    //   813	1	7	localObject5	Object
    //   821	1	7	localObject6	Object
    //   835	57	7	localObject7	Object
    //   11	298	8	localObject8	Object
    //   466	32	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   558	32	8	localIOException1	java.io.IOException
    //   650	32	8	localException1	java.lang.Exception
    //   832	1	8	localException2	java.lang.Exception
    //   842	1	8	localException3	java.lang.Exception
    //   850	1	8	localException4	java.lang.Exception
    //   855	1	8	localIOException2	java.io.IOException
    //   865	1	8	localIOException3	java.io.IOException
    //   873	1	8	localIOException4	java.io.IOException
    //   878	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   888	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   896	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   104	269	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   217	221	247	java/lang/Exception
    //   225	229	247	java/lang/Exception
    //   234	239	247	java/lang/Exception
    //   387	391	407	java/lang/Exception
    //   395	399	407	java/lang/Exception
    //   429	433	448	java/lang/Exception
    //   437	441	448	java/lang/Exception
    //   81	92	466	java/io/FileNotFoundException
    //   515	519	540	java/lang/Exception
    //   523	527	540	java/lang/Exception
    //   532	537	540	java/lang/Exception
    //   81	92	558	java/io/IOException
    //   607	611	632	java/lang/Exception
    //   615	619	632	java/lang/Exception
    //   624	629	632	java/lang/Exception
    //   81	92	650	java/lang/Exception
    //   699	703	724	java/lang/Exception
    //   707	711	724	java/lang/Exception
    //   716	721	724	java/lang/Exception
    //   81	92	742	finally
    //   755	759	785	java/lang/Exception
    //   763	767	785	java/lang/Exception
    //   772	777	785	java/lang/Exception
    //   92	97	803	finally
    //   97	139	813	finally
    //   265	343	813	finally
    //   343	368	813	finally
    //   368	379	813	finally
    //   149	156	821	finally
    //   166	171	821	finally
    //   181	213	821	finally
    //   485	511	821	finally
    //   577	603	821	finally
    //   669	695	821	finally
    //   92	97	832	java/lang/Exception
    //   97	139	842	java/lang/Exception
    //   265	343	842	java/lang/Exception
    //   343	368	842	java/lang/Exception
    //   368	379	842	java/lang/Exception
    //   149	156	850	java/lang/Exception
    //   166	171	850	java/lang/Exception
    //   181	213	850	java/lang/Exception
    //   92	97	855	java/io/IOException
    //   97	139	865	java/io/IOException
    //   265	343	865	java/io/IOException
    //   343	368	865	java/io/IOException
    //   368	379	865	java/io/IOException
    //   149	156	873	java/io/IOException
    //   166	171	873	java/io/IOException
    //   181	213	873	java/io/IOException
    //   92	97	878	java/io/FileNotFoundException
    //   97	139	888	java/io/FileNotFoundException
    //   265	343	888	java/io/FileNotFoundException
    //   343	368	888	java/io/FileNotFoundException
    //   368	379	888	java/io/FileNotFoundException
    //   149	156	896	java/io/FileNotFoundException
    //   166	171	896	java/io/FileNotFoundException
    //   181	213	896	java/io/FileNotFoundException
  }
  
  private void axt(int paramInt)
  {
    AppMethodBeat.i(38966);
    switch (paramInt)
    {
    default: 
      Toast.makeText(this, R.l.eTt, 1).show();
      AppMethodBeat.o(38966);
      return;
    }
    Toast.makeText(this, R.l.eTq, 1).show();
    AppMethodBeat.o(38966);
  }
  
  private static int bAy(String paramString)
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
  
  private void dismissDialog()
  {
    AppMethodBeat.i(38968);
    if ((this.iXX != null) && (this.iXX.isShowing())) {
      this.iXX.dismiss();
    }
    AppMethodBeat.o(38968);
  }
  
  private void elK()
  {
    AppMethodBeat.i(38967);
    getString(R.l.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(38967);
  }
  
  private void hYg()
  {
    AppMethodBeat.i(38960);
    Intent localIntent = new Intent(this, AddFavoriteUI.class);
    localIntent.setAction("android.intent.action.SEND");
    if (Util.isNullOrNil(this.filePath)) {}
    for (Object localObject = null;; localObject = FileProviderHelper.getUriForFile(getContext(), new com.tencent.mm.vfs.q(this.filePath)))
    {
      localIntent.putExtra("android.intent.extra.STREAM", (Parcelable)localObject);
      localIntent.addFlags(268435456).addFlags(32768);
      localIntent.setType(getIntent().getType());
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), localIntent);
      AppMethodBeat.o(38960);
      return;
    }
  }
  
  private boolean hYh()
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
    ((Bundle)localObject3).putInt("_mmessage_sdkVersion", 637992960);
    ((Bundle)localObject3).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
    ((Bundle)localObject3).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
    if ((bh.beJ()) && (!bh.aGE()))
    {
      localObject2 = new dd();
      localObject3 = u.bBW(this.filePath) + "." + u.asq(this.filePath);
      if (i == 1)
      {
        j.b((dd)localObject2, (String)localObject1, 13);
        ((dd)localObject2).fyI.activity = this;
        ((dd)localObject2).fyI.fyQ = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38940);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38940);
          }
        };
        ((dd)localObject2).fyI.fyR = new a.c()
        {
          public final void bPL() {}
          
          public final void onHide()
          {
            AppMethodBeat.i(38941);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38941);
          }
          
          public final void onShow() {}
        };
        this.XNn = ((dd)localObject2);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localObject1 = new g(5, (List)localObject2, getCallerPackage());
        bh.aGY().a(837, this);
        com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
        elK();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(38961);
      return true;
      j.a((dd)localObject2, 13, this.filePath, (String)localObject3, "", false);
      break;
      Log.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
      finish();
    }
  }
  
  private void hYi()
  {
    AppMethodBeat.i(38965);
    axt(0);
    Toast.makeText(this, R.l.eTt, 1).show();
    AppMethodBeat.o(38965);
  }
  
  private void o(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(38962);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
      AppMethodBeat.o(38962);
      return;
    }
    long l1 = u.bBQ(paramString);
    Log.i("MicroMsg.AddFavoriteUI", "filelength: [%d]", new Object[] { Long.valueOf(l1) });
    if (l1 == 0L)
    {
      Log.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
      Toast.makeText(this, R.l.favorite_file_length_zero, 1).show();
      finish();
      AppMethodBeat.o(38962);
      return;
    }
    long l2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSizeLimit(paramBoolean, paramInt);
    int i = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavSizeLimitInMB(paramBoolean, paramInt);
    if (l1 > l2)
    {
      Log.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
      Toast.makeText(this, getString(R.l.favorite_too_large_format, new Object[] { Integer.valueOf(i) }), 1).show();
      finish();
      AppMethodBeat.o(38962);
      return;
    }
    if ((bh.beJ()) && (!bh.aGE()))
    {
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramString);
      dd localdd = new dd();
      String str = u.bBW(paramString) + "." + u.asq(paramString);
      Object localObject2;
      switch (paramInt)
      {
      case 3: 
      default: 
        localObject2 = new WXFileObject(paramString);
        localObject1 = new g(4, (List)localObject1, getCallerPackage());
        j.a(localdd, 13, paramString, str, "", paramBoolean);
        localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
        ((WXMediaMessage)localObject2).title = new com.tencent.mm.vfs.q(paramString).getName();
        if (Util.isNullOrNil(null))
        {
          ((WXMediaMessage)localObject2).description = Util.getSizeKB(l1);
          label365:
          if (l1 >= 30720L) {
            break label631;
          }
          ((WXMediaMessage)localObject2).thumbData = u.aY(paramString, 0, -1);
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
        ((Bundle)localObject2).putInt("_mmessage_sdkVersion", 637992960);
        ((Bundle)localObject2).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
        ((Bundle)localObject2).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        localdd.fyI.activity = this;
        localdd.fyI.fyQ = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38942);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38942);
          }
        };
        localdd.fyI.fyR = new a.c()
        {
          public final void bPL() {}
          
          public final void onHide()
          {
            AppMethodBeat.i(38943);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38943);
          }
          
          public final void onShow() {}
        };
        this.XNn = localdd;
        com.tencent.mm.kernel.h.aGY().a(837, this);
        com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
        elK();
        AppMethodBeat.o(38962);
        return;
        localObject2 = new WXImageObject();
        ((WXImageObject)localObject2).setImagePath(paramString);
        localObject1 = new g(1, (List)localObject1, getCallerPackage());
        j.a(localdd, 13, paramString);
        break;
        localObject2 = new WXVideoFileObject(paramString);
        localObject1 = new g(3, (List)localObject1, getCallerPackage());
        j.a(localdd, 13, paramString, null, 0, str, "", paramBoolean);
        break;
        ((WXMediaMessage)localObject2).description = null;
        break label365;
        label631:
        Log.i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
      }
    }
    Log.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
    finish();
    hYg();
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
      hYi();
      finish();
      AppMethodBeat.o(38959);
      return;
    }
    Object localObject1 = this.intent.getAction();
    Object localObject2 = IntentUtil.getExtras(this.intent);
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.AddFavoriteUI", "launch : fail, action is null");
      hYi();
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
          hYi();
          finish();
          AppMethodBeat.o(38959);
        }
      }
      else if (localObject3 != null)
      {
        Log.e("MicroMsg.AddFavoriteUI", "launch : fail, uri check fail, %s", new Object[] { localObject3 });
        hYi();
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
        elK();
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
      elK();
      ThreadPool.post(new a(this.uri, new b()
      {
        public final void hYj()
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
        axt(1);
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
        this.XNo = ((ArrayList)localObject1);
        if ((this.XNo != null) && (this.XNo.size() != 0)) {
          break label676;
        }
        Log.e("MicroMsg.AddFavoriteUI", "launch : fail, filePathList is null");
        axt(1);
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
      elK();
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
    hYi();
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
    NotifyReceiver.aqB();
    initView();
    AppMethodBeat.o(38954);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38958);
    Log.i("MicroMsg.AddFavoriteUI", "on Destroy");
    bh.aGY().b(837, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(38969);
    Log.i("MicroMsg.AddFavoriteUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    dismissDialog();
    if ((paramq instanceof g)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.XNn != null)
        {
          EventCenter.instance.publish(this.XNn);
          this.XNn = null;
          AppMethodBeat.o(38969);
        }
      }
      else if (paramq.getReqResp() != null)
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
          finish();
          AppMethodBeat.o(38969);
          return;
        }
        if (this.XNn != null)
        {
          EventCenter.instance.publish(this.XNn);
          this.XNn = null;
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
    private AddFavoriteUI.b XNs;
    private Uri mUri;
    
    public a(Uri paramUri, AddFavoriteUI.b paramb)
    {
      this.mUri = paramUri;
      this.XNs = paramb;
    }
    
    public final void run()
    {
      AppMethodBeat.i(38952);
      try
      {
        AddFavoriteUI.this.filePath = AddFavoriteUI.a(AddFavoriteUI.this, this.mUri);
        if ((Util.isNullOrNil(AddFavoriteUI.this.filePath)) || (!new com.tencent.mm.vfs.q(AddFavoriteUI.this.filePath).ifE()) || ((Build.VERSION.SDK_INT >= 30) && (!new com.tencent.mm.vfs.q(AddFavoriteUI.this.filePath).ifC()))) {
          if (AddFavoriteUI.bAA(AddFavoriteUI.this.getContentResolver().getType(this.mUri)) != 2) {
            break label149;
          }
        }
        label149:
        for (AddFavoriteUI.this.filePath = e.a(AddFavoriteUI.this.getContentResolver(), this.mUri, 1);; AddFavoriteUI.this.filePath = e.b(AddFavoriteUI.this.getContentResolver(), this.mUri)) {
          return;
        }
        AppMethodBeat.o(38952);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.printErrStackTrace("MicroMsg.AddFavoriteUI", localIllegalAccessException, "", new Object[0]);
        AddFavoriteUI.this.filePath = null;
        return;
      }
      finally
      {
        if (this.XNs != null) {
          this.XNs.hYj();
        }
        AppMethodBeat.o(38952);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void hYj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AddFavoriteUI
 * JD-Core Version:    0.7.0.1
 */