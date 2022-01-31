package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141010", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class AddFavoriteUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private cm Aql;
  ArrayList<String> Aqm;
  private ak Aqn;
  private ak Aqo;
  private ProgressDialog eeN;
  String filePath;
  private ak handler;
  private Intent intent;
  Uri uri;
  
  public AddFavoriteUI()
  {
    AppMethodBeat.i(34759);
    this.eeN = null;
    this.intent = null;
    this.filePath = null;
    this.uri = null;
    this.Aqm = null;
    this.Aqn = new ak()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34752);
        AddFavoriteUI.d(AddFavoriteUI.this);
        ab.i("MicroMsg.AddFavoriteUI", "dealWithText: %b", new Object[] { Boolean.valueOf(AddFavoriteUI.e(AddFavoriteUI.this)) });
        AppMethodBeat.o(34752);
      }
    };
    this.Aqo = new AddFavoriteUI.11(this);
    this.handler = new AddFavoriteUI.12(this);
    AppMethodBeat.o(34759);
  }
  
  private void QO(int paramInt)
  {
    AppMethodBeat.i(34773);
    switch (paramInt)
    {
    default: 
      Toast.makeText(this, 2131303677, 1).show();
      AppMethodBeat.o(34773);
      return;
    }
    Toast.makeText(this, 2131303674, 1).show();
    AppMethodBeat.o(34773);
  }
  
  /* Error */
  private String a(Uri paramUri, android.database.Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +435 -> 441
    //   9: ldc 113
    //   11: astore 8
    //   13: aload_2
    //   14: ldc 115
    //   16: invokeinterface 121 2 0
    //   21: istore_3
    //   22: iload_3
    //   23: iconst_m1
    //   24: if_icmpeq +51 -> 75
    //   27: aload_2
    //   28: iload_3
    //   29: invokeinterface 125 2 0
    //   34: astore 5
    //   36: aload 5
    //   38: astore 4
    //   40: aload 5
    //   42: ifnull +14 -> 56
    //   45: aload 5
    //   47: ldc 127
    //   49: ldc 129
    //   51: invokevirtual 135	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 4
    //   56: ldc 137
    //   58: ldc 139
    //   60: aload 4
    //   62: invokestatic 143	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   65: invokevirtual 147	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 152	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload 4
    //   73: astore 8
    //   75: aload_2
    //   76: invokeinterface 155 1 0
    //   81: aload_0
    //   82: invokevirtual 159	com/tencent/mm/ui/tools/AddFavoriteUI:getContentResolver	()Landroid/content/ContentResolver;
    //   85: aload_1
    //   86: ldc 161
    //   88: invokevirtual 167	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 173	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   96: astore_2
    //   97: aload_1
    //   98: invokevirtual 177	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   101: l2i
    //   102: newarray byte
    //   104: astore 9
    //   106: aload_2
    //   107: aload 9
    //   109: invokevirtual 183	java/io/FileInputStream:read	([B)I
    //   112: ifle +313 -> 425
    //   115: invokestatic 189	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   118: pop
    //   119: invokestatic 195	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   122: ifne +145 -> 267
    //   125: aload_0
    //   126: aload 8
    //   128: invokevirtual 199	com/tencent/mm/ui/tools/AddFavoriteUI:deleteFile	(Ljava/lang/String;)Z
    //   131: pop
    //   132: aload_0
    //   133: aload 8
    //   135: iconst_0
    //   136: invokevirtual 203	com/tencent/mm/ui/tools/AddFavoriteUI:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   139: astore 7
    //   141: aload 7
    //   143: astore 6
    //   145: aload_2
    //   146: astore 5
    //   148: aload_1
    //   149: astore 4
    //   151: aload 7
    //   153: aload 9
    //   155: invokevirtual 209	java/io/FileOutputStream:write	([B)V
    //   158: aload 7
    //   160: astore 6
    //   162: aload_2
    //   163: astore 5
    //   165: aload_1
    //   166: astore 4
    //   168: aload 7
    //   170: invokevirtual 212	java/io/FileOutputStream:flush	()V
    //   173: aload 7
    //   175: astore 6
    //   177: aload_2
    //   178: astore 5
    //   180: aload_1
    //   181: astore 4
    //   183: new 214	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   190: aload_0
    //   191: invokevirtual 219	com/tencent/mm/ui/tools/AddFavoriteUI:getFilesDir	()Ljava/io/File;
    //   194: invokevirtual 225	java/io/File:getPath	()Ljava/lang/String;
    //   197: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 231
    //   202: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 8
    //   207: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: astore 8
    //   215: aload_2
    //   216: ifnull +7 -> 223
    //   219: aload_2
    //   220: invokevirtual 235	java/io/FileInputStream:close	()V
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 236	android/content/res/AssetFileDescriptor:close	()V
    //   231: aload 7
    //   233: ifnull +8 -> 241
    //   236: aload 7
    //   238: invokevirtual 237	java/io/FileOutputStream:close	()V
    //   241: ldc 111
    //   243: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload 8
    //   248: areturn
    //   249: astore_1
    //   250: ldc 137
    //   252: aload_1
    //   253: aload_1
    //   254: invokevirtual 240	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   257: iconst_0
    //   258: anewarray 242	java/lang/Object
    //   261: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: goto -23 -> 241
    //   267: new 214	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   274: getstatic 251	com/tencent/mm/compatible/util/e:eQz	Ljava/lang/String;
    //   277: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc 253
    //   282: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: astore 5
    //   290: new 214	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   297: getstatic 251	com/tencent/mm/compatible/util/e:eQz	Ljava/lang/String;
    //   300: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: ldc 255
    //   305: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 8
    //   310: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore 4
    //   318: new 221	java/io/File
    //   321: dup
    //   322: aload 5
    //   324: invokespecial 258	java/io/File:<init>	(Ljava/lang/String;)V
    //   327: astore 5
    //   329: aload 5
    //   331: invokevirtual 261	java/io/File:exists	()Z
    //   334: ifne +9 -> 343
    //   337: aload 5
    //   339: invokevirtual 264	java/io/File:mkdir	()Z
    //   342: pop
    //   343: new 221	java/io/File
    //   346: dup
    //   347: aload 4
    //   349: invokespecial 258	java/io/File:<init>	(Ljava/lang/String;)V
    //   352: astore 5
    //   354: aload 5
    //   356: invokevirtual 261	java/io/File:exists	()Z
    //   359: ifne +9 -> 368
    //   362: aload 5
    //   364: invokevirtual 267	java/io/File:createNewFile	()Z
    //   367: pop
    //   368: aload 4
    //   370: aload 9
    //   372: aload 9
    //   374: arraylength
    //   375: invokestatic 273	com/tencent/mm/vfs/e:b	(Ljava/lang/String;[BI)I
    //   378: istore_3
    //   379: iload_3
    //   380: ifne +45 -> 425
    //   383: aload_2
    //   384: ifnull +7 -> 391
    //   387: aload_2
    //   388: invokevirtual 235	java/io/FileInputStream:close	()V
    //   391: aload_1
    //   392: ifnull +7 -> 399
    //   395: aload_1
    //   396: invokevirtual 236	android/content/res/AssetFileDescriptor:close	()V
    //   399: ldc 111
    //   401: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   404: aload 4
    //   406: areturn
    //   407: astore_1
    //   408: ldc 137
    //   410: aload_1
    //   411: aload_1
    //   412: invokevirtual 240	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   415: iconst_0
    //   416: anewarray 242	java/lang/Object
    //   419: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   422: goto -23 -> 399
    //   425: aload_2
    //   426: ifnull +7 -> 433
    //   429: aload_2
    //   430: invokevirtual 235	java/io/FileInputStream:close	()V
    //   433: aload_1
    //   434: ifnull +7 -> 441
    //   437: aload_1
    //   438: invokevirtual 236	android/content/res/AssetFileDescriptor:close	()V
    //   441: ldc 111
    //   443: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: aconst_null
    //   447: areturn
    //   448: astore_1
    //   449: ldc 137
    //   451: aload_1
    //   452: aload_1
    //   453: invokevirtual 240	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   456: iconst_0
    //   457: anewarray 242	java/lang/Object
    //   460: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   485: ldc 137
    //   487: new 214	java/lang/StringBuilder
    //   490: dup
    //   491: ldc_w 275
    //   494: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   497: aload 8
    //   499: invokevirtual 277	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   502: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 280	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: aload_2
    //   512: ifnull +7 -> 519
    //   515: aload_2
    //   516: invokevirtual 235	java/io/FileInputStream:close	()V
    //   519: aload_1
    //   520: ifnull +7 -> 527
    //   523: aload_1
    //   524: invokevirtual 236	android/content/res/AssetFileDescriptor:close	()V
    //   527: aload 7
    //   529: ifnull -88 -> 441
    //   532: aload 7
    //   534: invokevirtual 237	java/io/FileOutputStream:close	()V
    //   537: goto -96 -> 441
    //   540: astore_1
    //   541: ldc 137
    //   543: aload_1
    //   544: aload_1
    //   545: invokevirtual 240	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   548: iconst_0
    //   549: anewarray 242	java/lang/Object
    //   552: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   577: ldc 137
    //   579: new 214	java/lang/StringBuilder
    //   582: dup
    //   583: ldc_w 282
    //   586: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   589: aload 8
    //   591: invokevirtual 283	java/io/IOException:getMessage	()Ljava/lang/String;
    //   594: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 280	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: aload_2
    //   604: ifnull +7 -> 611
    //   607: aload_2
    //   608: invokevirtual 235	java/io/FileInputStream:close	()V
    //   611: aload_1
    //   612: ifnull +7 -> 619
    //   615: aload_1
    //   616: invokevirtual 236	android/content/res/AssetFileDescriptor:close	()V
    //   619: aload 7
    //   621: ifnull -180 -> 441
    //   624: aload 7
    //   626: invokevirtual 237	java/io/FileOutputStream:close	()V
    //   629: goto -188 -> 441
    //   632: astore_1
    //   633: ldc 137
    //   635: aload_1
    //   636: aload_1
    //   637: invokevirtual 240	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   640: iconst_0
    //   641: anewarray 242	java/lang/Object
    //   644: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   669: ldc 137
    //   671: new 214	java/lang/StringBuilder
    //   674: dup
    //   675: ldc_w 285
    //   678: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   681: aload 8
    //   683: invokevirtual 240	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   686: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: invokestatic 280	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   695: aload_2
    //   696: ifnull +7 -> 703
    //   699: aload_2
    //   700: invokevirtual 235	java/io/FileInputStream:close	()V
    //   703: aload_1
    //   704: ifnull +7 -> 711
    //   707: aload_1
    //   708: invokevirtual 236	android/content/res/AssetFileDescriptor:close	()V
    //   711: aload 7
    //   713: ifnull -272 -> 441
    //   716: aload 7
    //   718: invokevirtual 237	java/io/FileOutputStream:close	()V
    //   721: goto -280 -> 441
    //   724: astore_1
    //   725: ldc 137
    //   727: aload_1
    //   728: aload_1
    //   729: invokevirtual 240	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   732: iconst_0
    //   733: anewarray 242	java/lang/Object
    //   736: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   756: invokevirtual 235	java/io/FileInputStream:close	()V
    //   759: aload_1
    //   760: ifnull +7 -> 767
    //   763: aload_1
    //   764: invokevirtual 236	android/content/res/AssetFileDescriptor:close	()V
    //   767: aload 6
    //   769: ifnull +8 -> 777
    //   772: aload 6
    //   774: invokevirtual 237	java/io/FileOutputStream:close	()V
    //   777: ldc 111
    //   779: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   782: aload 7
    //   784: athrow
    //   785: astore_1
    //   786: ldc 137
    //   788: aload_1
    //   789: aload_1
    //   790: invokevirtual 240	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   793: iconst_0
    //   794: anewarray 242	java/lang/Object
    //   797: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   143	674	6	localFileOutputStream1	java.io.FileOutputStream
    //   139	578	7	localFileOutputStream2	java.io.FileOutputStream
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
    //   219	223	249	java/lang/Exception
    //   227	231	249	java/lang/Exception
    //   236	241	249	java/lang/Exception
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
    //   97	141	813	finally
    //   267	343	813	finally
    //   343	368	813	finally
    //   368	379	813	finally
    //   151	158	821	finally
    //   168	173	821	finally
    //   183	215	821	finally
    //   485	511	821	finally
    //   577	603	821	finally
    //   669	695	821	finally
    //   92	97	832	java/lang/Exception
    //   97	141	842	java/lang/Exception
    //   267	343	842	java/lang/Exception
    //   343	368	842	java/lang/Exception
    //   368	379	842	java/lang/Exception
    //   151	158	850	java/lang/Exception
    //   168	173	850	java/lang/Exception
    //   183	215	850	java/lang/Exception
    //   92	97	855	java/io/IOException
    //   97	141	865	java/io/IOException
    //   267	343	865	java/io/IOException
    //   343	368	865	java/io/IOException
    //   368	379	865	java/io/IOException
    //   151	158	873	java/io/IOException
    //   168	173	873	java/io/IOException
    //   183	215	873	java/io/IOException
    //   92	97	878	java/io/FileNotFoundException
    //   97	141	888	java/io/FileNotFoundException
    //   267	343	888	java/io/FileNotFoundException
    //   343	368	888	java/io/FileNotFoundException
    //   368	379	888	java/io/FileNotFoundException
    //   151	158	896	java/io/FileNotFoundException
    //   168	173	896	java/io/FileNotFoundException
    //   183	215	896	java/io/FileNotFoundException
  }
  
  private static int auN(String paramString)
  {
    AppMethodBeat.i(34771);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AddFavoriteUI", "map : mimeType is null");
      AppMethodBeat.o(34771);
      return -1;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.contains("image")) || (paramString.equals("application/vnd.google.panorama360+jpg")))
    {
      AppMethodBeat.o(34771);
      return 2;
    }
    if (paramString.contains("video"))
    {
      AppMethodBeat.o(34771);
      return 4;
    }
    ab.d("MicroMsg.AddFavoriteUI", "map : unknown mimetype, send as file");
    AppMethodBeat.o(34771);
    return 8;
  }
  
  private void bN(int paramInt, String paramString)
  {
    AppMethodBeat.i(34769);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
      AppMethodBeat.o(34769);
      return;
    }
    long l = com.tencent.mm.vfs.e.avI(paramString);
    ab.i("MicroMsg.AddFavoriteUI", "filelength: [%d]", new Object[] { Long.valueOf(l) });
    if (l == 0L)
    {
      ab.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
      Toast.makeText(this, 2131299733, 1).show();
      finish();
      AppMethodBeat.o(34769);
      return;
    }
    if (l > 26214400L)
    {
      ab.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
      Toast.makeText(this, 2131299848, 1).show();
      finish();
      AppMethodBeat.o(34769);
      return;
    }
    if ((aw.aaB()) && (!aw.QP()))
    {
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramString);
      cm localcm = new cm();
      String str = com.tencent.mm.vfs.e.avM(paramString) + "." + com.tencent.mm.vfs.e.cP(paramString);
      Object localObject2;
      switch (paramInt)
      {
      case 3: 
      default: 
        localObject2 = new WXFileObject(paramString);
        localObject1 = new com.tencent.mm.modelsimple.f(4, (List)localObject1, getCallerPackage());
        com.tencent.mm.pluginsdk.model.e.a(localcm, paramString, str, "");
        localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
        ((WXMediaMessage)localObject2).title = new File(paramString).getName();
        if (bo.isNullOrNil(null))
        {
          ((WXMediaMessage)localObject2).description = bo.hk(l);
          label309:
          if (l >= 30720L) {
            break label837;
          }
          ((WXMediaMessage)localObject2).thumbData = com.tencent.mm.vfs.e.i(paramString, 0, -1);
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
        ((Bundle)localObject2).putInt("_mmessage_sdkVersion", 620954624);
        ((Bundle)localObject2).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
        ((Bundle)localObject2).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        localcm.cpR.activity = this;
        localcm.cpR.cpZ = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(34748);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(34748);
          }
        };
        localcm.cpR.cqa = new AddFavoriteUI.6(this);
        this.Aql = localcm;
        g.Rc().a(837, this);
        g.Rc().a((m)localObject1, 0);
        showDialog();
        AppMethodBeat.o(34769);
        return;
        localObject2 = new WXImageObject();
        ((WXImageObject)localObject2).setImagePath(paramString);
        localObject1 = new com.tencent.mm.modelsimple.f(1, (List)localObject1, getCallerPackage());
        com.tencent.mm.pluginsdk.model.e.a(localcm, 13, paramString);
        break;
        localObject2 = new WXVideoFileObject(paramString);
        localObject1 = new com.tencent.mm.modelsimple.f(3, (List)localObject1, getCallerPackage());
        if (bo.isNullOrNil(paramString))
        {
          ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
          localcm.cpR.cpX = 2131299713;
          break;
        }
        ab.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { str, "", paramString, Integer.valueOf(13) });
        if (new com.tencent.mm.vfs.b(paramString).length() > com.tencent.mm.m.b.MX())
        {
          localcm.cpR.cpX = 2131299848;
          break;
        }
        acq localacq = new acq();
        acw localacw = new acw();
        aca localaca = new aca();
        localaca.anE(paramString);
        localaca.MI(4);
        localaca.anA(com.tencent.mm.vfs.e.cP(paramString));
        localaca.anF(null);
        localaca.MH(0);
        localaca.anq(str);
        localaca.anr("");
        localacw.aon(com.tencent.mm.model.r.Zn());
        localacw.aoo(com.tencent.mm.model.r.Zn());
        localacw.MR(13);
        localacw.nI(bo.aoy());
        localacq.a(localacw);
        localacq.wVc.add(localaca);
        localcm.cpR.title = localaca.title;
        localcm.cpR.desc = localaca.title;
        localcm.cpR.cpT = localacq;
        localcm.cpR.type = 4;
        break;
        ((WXMediaMessage)localObject2).description = null;
        break label309;
        label837:
        ab.i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
      }
    }
    ab.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
    finish();
    dNA();
    AppMethodBeat.o(34769);
  }
  
  private void dNA()
  {
    AppMethodBeat.i(34766);
    Intent localIntent = new Intent(this, AddFavoriteUI.class);
    localIntent.setAction("android.intent.action.SEND");
    if (bo.isNullOrNil(this.filePath)) {}
    for (Object localObject = null;; localObject = Uri.fromFile(new File(this.filePath)))
    {
      localIntent.putExtra("android.intent.extra.STREAM", (Parcelable)localObject);
      localIntent.addFlags(268435456).addFlags(32768);
      localIntent.setType(getIntent().getType());
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), localIntent);
      AppMethodBeat.o(34766);
      return;
    }
  }
  
  private boolean dNB()
  {
    AppMethodBeat.i(34768);
    this.intent = getIntent();
    if (this.intent == null)
    {
      ab.e("MicroMsg.AddFavoriteUI", "intent is null");
      AppMethodBeat.o(34768);
      return false;
    }
    Object localObject1 = w.n(this.intent, "android.intent.extra.TEXT");
    if ((localObject1 == null) || (((String)localObject1).length() == 0))
    {
      ab.i("MicroMsg.AddFavoriteUI", "text is null");
      AppMethodBeat.o(34768);
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
    ((Bundle)localObject3).putInt("_mmessage_sdkVersion", 620954624);
    ((Bundle)localObject3).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
    ((Bundle)localObject3).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
    if ((aw.aaB()) && (!aw.QP()))
    {
      localObject2 = new cm();
      localObject3 = com.tencent.mm.vfs.e.avM(this.filePath) + "." + com.tencent.mm.vfs.e.cP(this.filePath);
      if (i == 1)
      {
        com.tencent.mm.pluginsdk.model.e.b((cm)localObject2, (String)localObject1, 13);
        ((cm)localObject2).cpR.activity = this;
        ((cm)localObject2).cpR.cpZ = new AddFavoriteUI.3(this);
        ((cm)localObject2).cpR.cqa = new a.c()
        {
          public final void cPa() {}
          
          public final void onHide()
          {
            AppMethodBeat.i(34747);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(34747);
          }
          
          public final void onShow() {}
        };
        this.Aql = ((cm)localObject2);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localObject1 = new com.tencent.mm.modelsimple.f(5, (List)localObject2, getCallerPackage());
        aw.Rc().a(837, this);
        g.Rc().a((m)localObject1, 0);
        showDialog();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34768);
      return true;
      com.tencent.mm.pluginsdk.model.e.a((cm)localObject2, this.filePath, (String)localObject3, "");
      break;
      ab.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
      finish();
    }
  }
  
  private void dNC()
  {
    AppMethodBeat.i(34772);
    QO(0);
    Toast.makeText(this, 2131303677, 1).show();
    AppMethodBeat.o(34772);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(34775);
    if ((this.eeN != null) && (this.eeN.isShowing())) {
      this.eeN.dismiss();
    }
    AppMethodBeat.o(34775);
  }
  
  private void showDialog()
  {
    AppMethodBeat.i(34774);
    getString(2131297087);
    this.eeN = h.b(this, getString(2131297112), true, new AddFavoriteUI.7(this));
    AppMethodBeat.o(34774);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34765);
    this.intent = getIntent();
    if (this.intent == null)
    {
      ab.e("MicroMsg.AddFavoriteUI", "launch : fail, intent is null");
      dNC();
      finish();
      AppMethodBeat.o(34765);
      return;
    }
    Object localObject1 = this.intent.getAction();
    Object localObject2 = w.aL(this.intent);
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.e("MicroMsg.AddFavoriteUI", "launch : fail, action is null");
      dNC();
      finish();
      AppMethodBeat.o(34765);
      return;
    }
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = ((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
      if ((localObject3 instanceof Uri))
      {
        this.uri = ((Uri)localObject3);
        if (!bo.o(this.uri))
        {
          ab.e("MicroMsg.AddFavoriteUI", "launch : fail, not accept, %s", new Object[] { this.uri });
          dNC();
          finish();
          AppMethodBeat.o(34765);
        }
      }
      else if (localObject3 != null)
      {
        ab.e("MicroMsg.AddFavoriteUI", "launch : fail, uri check fail, %s", new Object[] { localObject3 });
        dNC();
        finish();
        AppMethodBeat.o(34765);
        return;
      }
    }
    if (((String)localObject1).equals("android.intent.action.SEND"))
    {
      ab.i("MicroMsg.AddFavoriteUI", "send signal: ".concat(String.valueOf(localObject1)));
      if (this.uri == null)
      {
        showDialog();
        com.tencent.mm.sdk.g.d.post(new AddFavoriteUI.1(this), "AddFavoriteUI_dealWithTextHandler");
        AppMethodBeat.o(34765);
        return;
      }
      showDialog();
      com.tencent.mm.sdk.g.d.post(new AddFavoriteUI.a(this, this.uri, new AddFavoriteUI.8(this)), "AddFavoriteUI_getFilePath");
      AppMethodBeat.o(34765);
      return;
    }
    if ((((String)localObject1).equals("android.intent.action.SEND_MULTIPLE")) && (localObject2 != null) && (((Bundle)localObject2).containsKey("android.intent.extra.STREAM")))
    {
      localObject3 = getIntent().resolveType(this);
      ab.i("MicroMsg.AddFavoriteUI", "send multi: %s, mimeType %s", new Object[] { localObject1, localObject3 });
      if (!bo.bf((String)localObject3, "").contains("image"))
      {
        ab.e("MicroMsg.AddFavoriteUI", "launch : fail, mimeType not contains image");
        QO(1);
        finish();
        AppMethodBeat.o(34765);
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
            ab.e("MicroMsg.AddFavoriteUI", "getMultiSendFilePath failed, error parcelable, %s", new Object[] { localObject3 });
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
        this.Aqm = ((ArrayList)localObject1);
        if ((this.Aqm != null) && (this.Aqm.size() != 0)) {
          break label676;
        }
        ab.e("MicroMsg.AddFavoriteUI", "launch : fail, filePathList is null");
        QO(1);
        finish();
        AppMethodBeat.o(34765);
        return;
        localObject3 = (Uri)localObject3;
        if ((bo.o((Uri)localObject3)) && (((Uri)localObject3).getScheme() != null))
        {
          localObject3 = bo.h(this, (Uri)localObject3);
          if (bo.isNullOrNil((String)localObject3)) {
            break label473;
          }
          if ((bo.aqi((String)localObject3)) && (com.tencent.mm.sdk.platformtools.r.aoX((String)localObject3)))
          {
            ab.i("MicroMsg.AddFavoriteUI", "multisend file path: ".concat(String.valueOf(localObject3)));
            ((ArrayList)localObject1).add(localObject3);
            i = 1;
            break label475;
            label608:
            break;
          }
          ab.w("MicroMsg.AddFavoriteUI", "multisend tries to send illegal img: ".concat(String.valueOf(localObject3)));
          break label473;
        }
        ab.e("MicroMsg.AddFavoriteUI", "unaccepted uri: ".concat(String.valueOf(localObject3)));
        break label473;
        if (((ArrayList)localObject1).size() <= 0)
        {
          localObject1 = null;
          continue;
          ab.e("MicroMsg.AddFavoriteUI", "getParcelableArrayList failed");
          localObject1 = null;
        }
      }
      label676:
      showDialog();
      com.tencent.mm.sdk.g.d.post(new AddFavoriteUI.9(this), "AddFavoriteUI_dealWithMultiItemHandler");
      AppMethodBeat.o(34765);
      return;
    }
    ab.e("MicroMsg.AddFavoriteUI", "launch : fail, uri is null");
    dNC();
    finish();
    AppMethodBeat.o(34765);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34760);
    ab.i("MicroMsg.AddFavoriteUI", "on create");
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    int i = w.a(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      ab.e("MicroMsg.AddFavoriteUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(i)));
      finish();
      AppMethodBeat.o(34760);
      return;
    case 1: 
      finish();
      AppMethodBeat.o(34760);
      return;
    }
    NotifyReceiver.In();
    initView();
    AppMethodBeat.o(34760);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34764);
    ab.i("MicroMsg.AddFavoriteUI", "on Destroy");
    aw.Rc().b(837, this);
    super.onDestroy();
    AppMethodBeat.o(34764);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(34762);
    ab.i("MicroMsg.AddFavoriteUI", "on NewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(34762);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(34763);
    ab.i("MicroMsg.AddFavoriteUI", "on RestoreInstanceState");
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(34763);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(34761);
    ab.i("MicroMsg.AddFavoriteUI", "on SaveInstanceState");
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(34761);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(34776);
    ab.i("MicroMsg.AddFavoriteUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    dismissDialog();
    if ((paramm instanceof com.tencent.mm.modelsimple.f)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.Aql != null)
        {
          com.tencent.mm.sdk.b.a.ymk.l(this.Aql);
          this.Aql = null;
          AppMethodBeat.o(34776);
        }
      }
      else if (paramm.getReqResp() != null)
      {
        paramString = (st)((com.tencent.mm.ai.b)paramm.getReqResp()).fsW.fta;
        if ((paramString != null) && (!bo.isNullOrNil(paramString.wLm)))
        {
          paramm = new Intent();
          paramm.putExtra("rawUrl", paramString.wLm);
          paramm.putExtra("showShare", false);
          paramm.putExtra("show_bottom", false);
          paramm.putExtra("needRedirect", false);
          com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramm);
          finish();
          AppMethodBeat.o(34776);
          return;
        }
        if (this.Aql != null)
        {
          com.tencent.mm.sdk.b.a.ymk.l(this.Aql);
          this.Aql = null;
        }
      }
    }
    AppMethodBeat.o(34776);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AddFavoriteUI
 * JD-Core Version:    0.7.0.1
 */