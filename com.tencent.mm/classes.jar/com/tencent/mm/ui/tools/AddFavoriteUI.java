package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.model.bc;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.vfs.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141010", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class AddFavoriteUI
  extends MMActivity
  implements f
{
  private cw KZZ;
  ArrayList<String> Laa;
  private aq Lab;
  private aq Lac;
  private ProgressDialog fOC;
  String filePath;
  private aq handler;
  private Intent intent;
  Uri uri;
  
  public AddFavoriteUI()
  {
    AppMethodBeat.i(38953);
    this.fOC = null;
    this.intent = null;
    this.filePath = null;
    this.uri = null;
    this.Laa = null;
    this.Lab = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(38946);
        AddFavoriteUI.d(AddFavoriteUI.this);
        ae.i("MicroMsg.AddFavoriteUI", "dealWithText: %b", new Object[] { Boolean.valueOf(AddFavoriteUI.e(AddFavoriteUI.this)) });
        AppMethodBeat.o(38946);
      }
    };
    this.Lac = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(38947);
        AddFavoriteUI.d(AddFavoriteUI.this);
        AddFavoriteUI.f(AddFavoriteUI.this);
        AppMethodBeat.o(38947);
      }
    };
    this.handler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(38948);
        AddFavoriteUI.d(AddFavoriteUI.this);
        if ((bu.isNullOrNil(AddFavoriteUI.this.filePath)) || ((bu.aSP(AddFavoriteUI.this.filePath)) && (!AddFavoriteUI.aYI(AddFavoriteUI.this.filePath))))
        {
          ae.e("MicroMsg.AddFavoriteUI", "launch : fail, filePath is null or file is not a valid img.");
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
    //   6: ifnull +436 -> 442
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
    //   68: invokestatic 160	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   112: ifle +314 -> 426
    //   115: invokestatic 197	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   118: pop
    //   119: invokestatic 203	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   122: ifne +144 -> 266
    //   125: aload_0
    //   126: aload 8
    //   128: invokevirtual 207	com/tencent/mm/ui/tools/AddFavoriteUI:deleteFile	(Ljava/lang/String;)Z
    //   131: pop
    //   132: aload 8
    //   134: iconst_0
    //   135: invokestatic 213	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   138: astore 7
    //   140: aload 7
    //   142: astore 6
    //   144: aload_2
    //   145: astore 5
    //   147: aload_1
    //   148: astore 4
    //   150: aload 7
    //   152: aload 9
    //   154: invokevirtual 219	java/io/OutputStream:write	([B)V
    //   157: aload 7
    //   159: astore 6
    //   161: aload_2
    //   162: astore 5
    //   164: aload_1
    //   165: astore 4
    //   167: aload 7
    //   169: invokevirtual 222	java/io/OutputStream:flush	()V
    //   172: aload 7
    //   174: astore 6
    //   176: aload_2
    //   177: astore 5
    //   179: aload_1
    //   180: astore 4
    //   182: new 224	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   189: aload_0
    //   190: invokevirtual 229	com/tencent/mm/ui/tools/AddFavoriteUI:getFilesDir	()Ljava/io/File;
    //   193: invokevirtual 235	java/io/File:getPath	()Ljava/lang/String;
    //   196: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 241
    //   201: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 8
    //   206: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: astore 8
    //   214: aload_2
    //   215: ifnull +7 -> 222
    //   218: aload_2
    //   219: invokevirtual 245	java/io/FileInputStream:close	()V
    //   222: aload_1
    //   223: ifnull +7 -> 230
    //   226: aload_1
    //   227: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   230: aload 7
    //   232: ifnull +8 -> 240
    //   235: aload 7
    //   237: invokevirtual 247	java/io/OutputStream:close	()V
    //   240: ldc 119
    //   242: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload 8
    //   247: areturn
    //   248: astore_1
    //   249: ldc 145
    //   251: aload_1
    //   252: aload_1
    //   253: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   256: iconst_0
    //   257: anewarray 252	java/lang/Object
    //   260: invokestatic 256	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: goto -23 -> 240
    //   266: new 224	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   273: invokestatic 261	com/tencent/mm/loader/j/b:asj	()Ljava/lang/String;
    //   276: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 263
    //   282: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: astore 5
    //   290: new 224	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   297: invokestatic 261	com/tencent/mm/loader/j/b:asj	()Ljava/lang/String;
    //   300: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: ldc_w 265
    //   306: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload 8
    //   311: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: astore 4
    //   319: new 267	com/tencent/mm/vfs/k
    //   322: dup
    //   323: aload 5
    //   325: invokespecial 270	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   328: astore 5
    //   330: aload 5
    //   332: invokevirtual 273	com/tencent/mm/vfs/k:exists	()Z
    //   335: ifne +9 -> 344
    //   338: aload 5
    //   340: invokevirtual 276	com/tencent/mm/vfs/k:mkdirs	()Z
    //   343: pop
    //   344: new 267	com/tencent/mm/vfs/k
    //   347: dup
    //   348: aload 4
    //   350: invokespecial 270	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   353: astore 5
    //   355: aload 5
    //   357: invokevirtual 273	com/tencent/mm/vfs/k:exists	()Z
    //   360: ifne +9 -> 369
    //   363: aload 5
    //   365: invokevirtual 279	com/tencent/mm/vfs/k:createNewFile	()Z
    //   368: pop
    //   369: aload 4
    //   371: aload 9
    //   373: aload 9
    //   375: arraylength
    //   376: invokestatic 283	com/tencent/mm/vfs/o:f	(Ljava/lang/String;[BI)I
    //   379: istore_3
    //   380: iload_3
    //   381: ifne +45 -> 426
    //   384: aload_2
    //   385: ifnull +7 -> 392
    //   388: aload_2
    //   389: invokevirtual 245	java/io/FileInputStream:close	()V
    //   392: aload_1
    //   393: ifnull +7 -> 400
    //   396: aload_1
    //   397: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   400: ldc 119
    //   402: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: aload 4
    //   407: areturn
    //   408: astore_1
    //   409: ldc 145
    //   411: aload_1
    //   412: aload_1
    //   413: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   416: iconst_0
    //   417: anewarray 252	java/lang/Object
    //   420: invokestatic 256	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: goto -23 -> 400
    //   426: aload_2
    //   427: ifnull +7 -> 434
    //   430: aload_2
    //   431: invokevirtual 245	java/io/FileInputStream:close	()V
    //   434: aload_1
    //   435: ifnull +7 -> 442
    //   438: aload_1
    //   439: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   442: ldc 119
    //   444: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   447: aconst_null
    //   448: areturn
    //   449: astore_1
    //   450: ldc 145
    //   452: aload_1
    //   453: aload_1
    //   454: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   457: iconst_0
    //   458: anewarray 252	java/lang/Object
    //   461: invokestatic 256	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   464: goto -22 -> 442
    //   467: astore 8
    //   469: aconst_null
    //   470: astore 7
    //   472: aconst_null
    //   473: astore_2
    //   474: aconst_null
    //   475: astore_1
    //   476: aload 7
    //   478: astore 6
    //   480: aload_2
    //   481: astore 5
    //   483: aload_1
    //   484: astore 4
    //   486: ldc 145
    //   488: new 224	java/lang/StringBuilder
    //   491: dup
    //   492: ldc_w 285
    //   495: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   498: aload 8
    //   500: invokevirtual 287	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   503: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 290	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload_2
    //   513: ifnull +7 -> 520
    //   516: aload_2
    //   517: invokevirtual 245	java/io/FileInputStream:close	()V
    //   520: aload_1
    //   521: ifnull +7 -> 528
    //   524: aload_1
    //   525: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   528: aload 7
    //   530: ifnull -88 -> 442
    //   533: aload 7
    //   535: invokevirtual 247	java/io/OutputStream:close	()V
    //   538: goto -96 -> 442
    //   541: astore_1
    //   542: ldc 145
    //   544: aload_1
    //   545: aload_1
    //   546: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   549: iconst_0
    //   550: anewarray 252	java/lang/Object
    //   553: invokestatic 256	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   556: goto -114 -> 442
    //   559: astore 8
    //   561: aconst_null
    //   562: astore 7
    //   564: aconst_null
    //   565: astore_2
    //   566: aconst_null
    //   567: astore_1
    //   568: aload 7
    //   570: astore 6
    //   572: aload_2
    //   573: astore 5
    //   575: aload_1
    //   576: astore 4
    //   578: ldc 145
    //   580: new 224	java/lang/StringBuilder
    //   583: dup
    //   584: ldc_w 292
    //   587: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   590: aload 8
    //   592: invokevirtual 293	java/io/IOException:getMessage	()Ljava/lang/String;
    //   595: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 290	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aload_2
    //   605: ifnull +7 -> 612
    //   608: aload_2
    //   609: invokevirtual 245	java/io/FileInputStream:close	()V
    //   612: aload_1
    //   613: ifnull +7 -> 620
    //   616: aload_1
    //   617: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   620: aload 7
    //   622: ifnull -180 -> 442
    //   625: aload 7
    //   627: invokevirtual 247	java/io/OutputStream:close	()V
    //   630: goto -188 -> 442
    //   633: astore_1
    //   634: ldc 145
    //   636: aload_1
    //   637: aload_1
    //   638: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   641: iconst_0
    //   642: anewarray 252	java/lang/Object
    //   645: invokestatic 256	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   648: goto -206 -> 442
    //   651: astore 8
    //   653: aconst_null
    //   654: astore 7
    //   656: aconst_null
    //   657: astore_2
    //   658: aconst_null
    //   659: astore_1
    //   660: aload 7
    //   662: astore 6
    //   664: aload_2
    //   665: astore 5
    //   667: aload_1
    //   668: astore 4
    //   670: ldc 145
    //   672: new 224	java/lang/StringBuilder
    //   675: dup
    //   676: ldc_w 295
    //   679: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   682: aload 8
    //   684: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   687: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 290	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: aload_2
    //   697: ifnull +7 -> 704
    //   700: aload_2
    //   701: invokevirtual 245	java/io/FileInputStream:close	()V
    //   704: aload_1
    //   705: ifnull +7 -> 712
    //   708: aload_1
    //   709: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   712: aload 7
    //   714: ifnull -272 -> 442
    //   717: aload 7
    //   719: invokevirtual 247	java/io/OutputStream:close	()V
    //   722: goto -280 -> 442
    //   725: astore_1
    //   726: ldc 145
    //   728: aload_1
    //   729: aload_1
    //   730: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   733: iconst_0
    //   734: anewarray 252	java/lang/Object
    //   737: invokestatic 256	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   740: goto -298 -> 442
    //   743: astore 7
    //   745: aconst_null
    //   746: astore 6
    //   748: aconst_null
    //   749: astore_2
    //   750: aconst_null
    //   751: astore_1
    //   752: aload_2
    //   753: ifnull +7 -> 760
    //   756: aload_2
    //   757: invokevirtual 245	java/io/FileInputStream:close	()V
    //   760: aload_1
    //   761: ifnull +7 -> 768
    //   764: aload_1
    //   765: invokevirtual 246	android/content/res/AssetFileDescriptor:close	()V
    //   768: aload 6
    //   770: ifnull +8 -> 778
    //   773: aload 6
    //   775: invokevirtual 247	java/io/OutputStream:close	()V
    //   778: ldc 119
    //   780: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   783: aload 7
    //   785: athrow
    //   786: astore_1
    //   787: ldc 145
    //   789: aload_1
    //   790: aload_1
    //   791: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   794: iconst_0
    //   795: anewarray 252	java/lang/Object
    //   798: invokestatic 256	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   801: goto -23 -> 778
    //   804: astore 7
    //   806: aconst_null
    //   807: astore 6
    //   809: aconst_null
    //   810: astore_2
    //   811: goto -59 -> 752
    //   814: astore 7
    //   816: aconst_null
    //   817: astore 6
    //   819: goto -67 -> 752
    //   822: astore 7
    //   824: aload 5
    //   826: astore_2
    //   827: aload 4
    //   829: astore_1
    //   830: goto -78 -> 752
    //   833: astore 8
    //   835: aconst_null
    //   836: astore 7
    //   838: aconst_null
    //   839: astore_2
    //   840: goto -180 -> 660
    //   843: astore 8
    //   845: aconst_null
    //   846: astore 7
    //   848: goto -188 -> 660
    //   851: astore 8
    //   853: goto -193 -> 660
    //   856: astore 8
    //   858: aconst_null
    //   859: astore 7
    //   861: aconst_null
    //   862: astore_2
    //   863: goto -295 -> 568
    //   866: astore 8
    //   868: aconst_null
    //   869: astore 7
    //   871: goto -303 -> 568
    //   874: astore 8
    //   876: goto -308 -> 568
    //   879: astore 8
    //   881: aconst_null
    //   882: astore 7
    //   884: aconst_null
    //   885: astore_2
    //   886: goto -410 -> 476
    //   889: astore 8
    //   891: aconst_null
    //   892: astore 7
    //   894: goto -418 -> 476
    //   897: astore 8
    //   899: goto -423 -> 476
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	902	0	this	AddFavoriteUI
    //   0	902	1	paramUri	Uri
    //   0	902	2	paramCursor	android.database.Cursor
    //   21	360	3	i	int
    //   38	790	4	localObject1	Object
    //   34	791	5	localObject2	Object
    //   142	676	6	localOutputStream1	java.io.OutputStream
    //   138	580	7	localOutputStream2	java.io.OutputStream
    //   743	41	7	localObject3	Object
    //   804	1	7	localObject4	Object
    //   814	1	7	localObject5	Object
    //   822	1	7	localObject6	Object
    //   836	57	7	localObject7	Object
    //   11	299	8	localObject8	Object
    //   467	32	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   559	32	8	localIOException1	java.io.IOException
    //   651	32	8	localException1	java.lang.Exception
    //   833	1	8	localException2	java.lang.Exception
    //   843	1	8	localException3	java.lang.Exception
    //   851	1	8	localException4	java.lang.Exception
    //   856	1	8	localIOException2	java.io.IOException
    //   866	1	8	localIOException3	java.io.IOException
    //   874	1	8	localIOException4	java.io.IOException
    //   879	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   889	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   897	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   104	270	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   218	222	248	java/lang/Exception
    //   226	230	248	java/lang/Exception
    //   235	240	248	java/lang/Exception
    //   388	392	408	java/lang/Exception
    //   396	400	408	java/lang/Exception
    //   430	434	449	java/lang/Exception
    //   438	442	449	java/lang/Exception
    //   81	92	467	java/io/FileNotFoundException
    //   516	520	541	java/lang/Exception
    //   524	528	541	java/lang/Exception
    //   533	538	541	java/lang/Exception
    //   81	92	559	java/io/IOException
    //   608	612	633	java/lang/Exception
    //   616	620	633	java/lang/Exception
    //   625	630	633	java/lang/Exception
    //   81	92	651	java/lang/Exception
    //   700	704	725	java/lang/Exception
    //   708	712	725	java/lang/Exception
    //   717	722	725	java/lang/Exception
    //   81	92	743	finally
    //   756	760	786	java/lang/Exception
    //   764	768	786	java/lang/Exception
    //   773	778	786	java/lang/Exception
    //   92	97	804	finally
    //   97	140	814	finally
    //   266	344	814	finally
    //   344	369	814	finally
    //   369	380	814	finally
    //   150	157	822	finally
    //   167	172	822	finally
    //   182	214	822	finally
    //   486	512	822	finally
    //   578	604	822	finally
    //   670	696	822	finally
    //   92	97	833	java/lang/Exception
    //   97	140	843	java/lang/Exception
    //   266	344	843	java/lang/Exception
    //   344	369	843	java/lang/Exception
    //   369	380	843	java/lang/Exception
    //   150	157	851	java/lang/Exception
    //   167	172	851	java/lang/Exception
    //   182	214	851	java/lang/Exception
    //   92	97	856	java/io/IOException
    //   97	140	866	java/io/IOException
    //   266	344	866	java/io/IOException
    //   344	369	866	java/io/IOException
    //   369	380	866	java/io/IOException
    //   150	157	874	java/io/IOException
    //   167	172	874	java/io/IOException
    //   182	214	874	java/io/IOException
    //   92	97	879	java/io/FileNotFoundException
    //   97	140	889	java/io/FileNotFoundException
    //   266	344	889	java/io/FileNotFoundException
    //   344	369	889	java/io/FileNotFoundException
    //   369	380	889	java/io/FileNotFoundException
    //   150	157	897	java/io/FileNotFoundException
    //   167	172	897	java/io/FileNotFoundException
    //   182	214	897	java/io/FileNotFoundException
  }
  
  private static int aYH(String paramString)
  {
    AppMethodBeat.i(38964);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.AddFavoriteUI", "map : mimeType is null");
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
    ae.d("MicroMsg.AddFavoriteUI", "map : unknown mimetype, send as file");
    AppMethodBeat.o(38964);
    return 8;
  }
  
  private void afA(int paramInt)
  {
    AppMethodBeat.i(38966);
    switch (paramInt)
    {
    default: 
      Toast.makeText(this, 2131763659, 1).show();
      AppMethodBeat.o(38966);
      return;
    }
    Toast.makeText(this, 2131763656, 1).show();
    AppMethodBeat.o(38966);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(38968);
    if ((this.fOC != null) && (this.fOC.isShowing())) {
      this.fOC.dismiss();
    }
    AppMethodBeat.o(38968);
  }
  
  private void fOB()
  {
    AppMethodBeat.i(38960);
    Intent localIntent = new Intent(this, AddFavoriteUI.class);
    localIntent.setAction("android.intent.action.SEND");
    if (bu.isNullOrNil(this.filePath)) {}
    for (Object localObject = null;; localObject = com.tencent.mm.sdk.platformtools.o.a(getContext(), new k(this.filePath)))
    {
      localIntent.putExtra("android.intent.extra.STREAM", (Parcelable)localObject);
      localIntent.addFlags(268435456).addFlags(32768);
      localIntent.setType(getIntent().getType());
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), localIntent);
      AppMethodBeat.o(38960);
      return;
    }
  }
  
  private boolean fOC()
  {
    AppMethodBeat.i(38961);
    this.intent = getIntent();
    if (this.intent == null)
    {
      ae.e("MicroMsg.AddFavoriteUI", "intent is null");
      AppMethodBeat.o(38961);
      return false;
    }
    Object localObject1 = z.getStringExtra(this.intent, "android.intent.extra.TEXT");
    if ((localObject1 == null) || (((String)localObject1).length() == 0))
    {
      ae.i("MicroMsg.AddFavoriteUI", "text is null");
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
    ((Bundle)localObject3).putInt("_mmessage_sdkVersion", 637928960);
    ((Bundle)localObject3).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
    ((Bundle)localObject3).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
    if ((bc.aCh()) && (!bc.aiT()))
    {
      localObject2 = new cw();
      localObject3 = com.tencent.mm.vfs.o.aZW(this.filePath) + "." + com.tencent.mm.vfs.o.aaw(this.filePath);
      if (i == 1)
      {
        com.tencent.mm.pluginsdk.model.g.b((cw)localObject2, (String)localObject1, 13);
        ((cw)localObject2).doL.activity = this;
        ((cw)localObject2).doL.doS = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38940);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38940);
          }
        };
        ((cw)localObject2).doL.doT = new a.c()
        {
          public final void biX() {}
          
          public final void onHide()
          {
            AppMethodBeat.i(38941);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38941);
          }
          
          public final void onShow() {}
        };
        this.KZZ = ((cw)localObject2);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        localObject1 = new com.tencent.mm.modelsimple.g(5, (List)localObject2, getCallerPackage());
        bc.ajj().a(837, this);
        com.tencent.mm.kernel.g.ajj().a((n)localObject1, 0);
        showDialog();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(38961);
      return true;
      com.tencent.mm.pluginsdk.model.g.a((cw)localObject2, this.filePath, (String)localObject3, "", false);
      break;
      ae.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
      finish();
    }
  }
  
  private void fOD()
  {
    AppMethodBeat.i(38965);
    afA(0);
    Toast.makeText(this, 2131763659, 1).show();
    AppMethodBeat.o(38965);
  }
  
  private void n(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(38962);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
      AppMethodBeat.o(38962);
      return;
    }
    long l = com.tencent.mm.vfs.o.aZR(paramString);
    ae.i("MicroMsg.AddFavoriteUI", "filelength: [%d]", new Object[] { Long.valueOf(l) });
    if (l == 0L)
    {
      ae.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
      Toast.makeText(this, 2131758905, 1).show();
      finish();
      AppMethodBeat.o(38962);
      return;
    }
    int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSizeLimit(paramBoolean, paramInt);
    int j = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavSizeLimitInMB(paramBoolean, paramInt);
    if (l > i)
    {
      ae.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
      Toast.makeText(this, getString(2131759025, new Object[] { Integer.valueOf(j) }), 1).show();
      finish();
      AppMethodBeat.o(38962);
      return;
    }
    if ((bc.aCh()) && (!bc.aiT()))
    {
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramString);
      cw localcw = new cw();
      String str = com.tencent.mm.vfs.o.aZW(paramString) + "." + com.tencent.mm.vfs.o.aaw(paramString);
      Object localObject2;
      switch (paramInt)
      {
      case 3: 
      default: 
        localObject2 = new WXFileObject(paramString);
        localObject1 = new com.tencent.mm.modelsimple.g(4, (List)localObject1, getCallerPackage());
        com.tencent.mm.pluginsdk.model.g.a(localcw, paramString, str, "", paramBoolean);
        localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
        ((WXMediaMessage)localObject2).title = new k(paramString).getName();
        if (bu.isNullOrNil(null))
        {
          ((WXMediaMessage)localObject2).description = bu.sL(l);
          label367:
          if (l >= 30720L) {
            break label632;
          }
          ((WXMediaMessage)localObject2).thumbData = com.tencent.mm.vfs.o.bb(paramString, 0, -1);
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
        ((Bundle)localObject2).putInt("_mmessage_sdkVersion", 637928960);
        ((Bundle)localObject2).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
        ((Bundle)localObject2).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        localcw.doL.activity = this;
        localcw.doL.doS = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38942);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38942);
          }
        };
        localcw.doL.doT = new a.c()
        {
          public final void biX() {}
          
          public final void onHide()
          {
            AppMethodBeat.i(38943);
            AddFavoriteUI.this.finish();
            AppMethodBeat.o(38943);
          }
          
          public final void onShow() {}
        };
        this.KZZ = localcw;
        com.tencent.mm.kernel.g.ajj().a(837, this);
        com.tencent.mm.kernel.g.ajj().a((n)localObject1, 0);
        showDialog();
        AppMethodBeat.o(38962);
        return;
        localObject2 = new WXImageObject();
        ((WXImageObject)localObject2).setImagePath(paramString);
        localObject1 = new com.tencent.mm.modelsimple.g(1, (List)localObject1, getCallerPackage());
        com.tencent.mm.pluginsdk.model.g.a(localcw, 13, paramString);
        break;
        localObject2 = new WXVideoFileObject(paramString);
        localObject1 = new com.tencent.mm.modelsimple.g(3, (List)localObject1, getCallerPackage());
        com.tencent.mm.pluginsdk.model.g.a(localcw, 13, paramString, null, str, "", paramBoolean);
        break;
        ((WXMediaMessage)localObject2).description = null;
        break label367;
        label632:
        ae.i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
      }
    }
    ae.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
    finish();
    fOB();
    AppMethodBeat.o(38962);
  }
  
  private void showDialog()
  {
    AppMethodBeat.i(38967);
    getString(2131755906);
    this.fOC = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(38967);
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
      ae.e("MicroMsg.AddFavoriteUI", "launch : fail, intent is null");
      fOD();
      finish();
      AppMethodBeat.o(38959);
      return;
    }
    Object localObject1 = this.intent.getAction();
    Object localObject2 = z.bl(this.intent);
    if (bu.isNullOrNil((String)localObject1))
    {
      ae.e("MicroMsg.AddFavoriteUI", "launch : fail, action is null");
      fOD();
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
        if (!bu.z(this.uri))
        {
          ae.e("MicroMsg.AddFavoriteUI", "launch : fail, not accept, %s", new Object[] { this.uri });
          fOD();
          finish();
          AppMethodBeat.o(38959);
        }
      }
      else if (localObject3 != null)
      {
        ae.e("MicroMsg.AddFavoriteUI", "launch : fail, uri check fail, %s", new Object[] { localObject3 });
        fOD();
        finish();
        AppMethodBeat.o(38959);
        return;
      }
    }
    if (((String)localObject1).equals("android.intent.action.SEND"))
    {
      ae.i("MicroMsg.AddFavoriteUI", "send signal: ".concat(String.valueOf(localObject1)));
      if (this.uri == null)
      {
        showDialog();
        com.tencent.mm.sdk.g.b.c(new Runnable()
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
      showDialog();
      com.tencent.mm.sdk.g.b.c(new a(this.uri, new b()
      {
        public final void fOE()
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
      ae.i("MicroMsg.AddFavoriteUI", "send multi: %s, mimeType %s", new Object[] { localObject1, localObject3 });
      if (!bu.bI((String)localObject3, "").contains("image"))
      {
        ae.e("MicroMsg.AddFavoriteUI", "launch : fail, mimeType not contains image");
        afA(1);
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
            ae.e("MicroMsg.AddFavoriteUI", "getMultiSendFilePath failed, error parcelable, %s", new Object[] { localObject3 });
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
        this.Laa = ((ArrayList)localObject1);
        if ((this.Laa != null) && (this.Laa.size() != 0)) {
          break label676;
        }
        ae.e("MicroMsg.AddFavoriteUI", "launch : fail, filePathList is null");
        afA(1);
        finish();
        AppMethodBeat.o(38959);
        return;
        localObject3 = (Uri)localObject3;
        if ((bu.z((Uri)localObject3)) && (((Uri)localObject3).getScheme() != null))
        {
          localObject3 = bu.k(this, (Uri)localObject3);
          if (bu.isNullOrNil((String)localObject3)) {
            break label473;
          }
          if ((bu.aSP((String)localObject3)) && (u.aRF((String)localObject3)))
          {
            ae.i("MicroMsg.AddFavoriteUI", "multisend file path: ".concat(String.valueOf(localObject3)));
            ((ArrayList)localObject1).add(localObject3);
            i = 1;
            break label475;
            label608:
            break;
          }
          ae.w("MicroMsg.AddFavoriteUI", "multisend tries to send illegal img: ".concat(String.valueOf(localObject3)));
          break label473;
        }
        ae.e("MicroMsg.AddFavoriteUI", "unaccepted uri: ".concat(String.valueOf(localObject3)));
        break label473;
        if (((ArrayList)localObject1).size() <= 0)
        {
          localObject1 = null;
          continue;
          ae.e("MicroMsg.AddFavoriteUI", "getParcelableArrayList failed");
          localObject1 = null;
        }
      }
      label676:
      showDialog();
      com.tencent.mm.sdk.g.b.c(new Runnable()
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
    ae.e("MicroMsg.AddFavoriteUI", "launch : fail, uri is null");
    fOD();
    finish();
    AppMethodBeat.o(38959);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38954);
    ae.i("MicroMsg.AddFavoriteUI", "on create");
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    int i = z.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      ae.e("MicroMsg.AddFavoriteUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(i)));
      finish();
      AppMethodBeat.o(38954);
      return;
    case 1: 
      finish();
      AppMethodBeat.o(38954);
      return;
    }
    NotifyReceiver.WR();
    initView();
    AppMethodBeat.o(38954);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38958);
    ae.i("MicroMsg.AddFavoriteUI", "on Destroy");
    bc.ajj().b(837, this);
    super.onDestroy();
    AppMethodBeat.o(38958);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(38956);
    ae.i("MicroMsg.AddFavoriteUI", "on NewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(38956);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(38957);
    ae.i("MicroMsg.AddFavoriteUI", "on RestoreInstanceState");
    super.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(38957);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(38955);
    ae.i("MicroMsg.AddFavoriteUI", "on SaveInstanceState");
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(38955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(38969);
    ae.i("MicroMsg.AddFavoriteUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    dismissDialog();
    if ((paramn instanceof com.tencent.mm.modelsimple.g)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.KZZ != null)
        {
          com.tencent.mm.sdk.b.a.IvT.l(this.KZZ);
          this.KZZ = null;
          AppMethodBeat.o(38969);
        }
      }
      else if (paramn.getReqResp() != null)
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
          finish();
          AppMethodBeat.o(38969);
          return;
        }
        if (this.KZZ != null)
        {
          com.tencent.mm.sdk.b.a.IvT.l(this.KZZ);
          this.KZZ = null;
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
    private AddFavoriteUI.b Lae;
    private Uri mUri;
    
    public a(Uri paramUri, AddFavoriteUI.b paramb)
    {
      this.mUri = paramUri;
      this.Lae = paramb;
    }
    
    public final void run()
    {
      AppMethodBeat.i(38952);
      try
      {
        AddFavoriteUI.this.filePath = AddFavoriteUI.a(AddFavoriteUI.this, this.mUri);
        if ((bu.isNullOrNil(AddFavoriteUI.this.filePath)) || (!new k(AddFavoriteUI.this.filePath).exists())) {
          if (AddFavoriteUI.aYJ(AddFavoriteUI.this.getContentResolver().getType(this.mUri)) != 2) {
            break label121;
          }
        }
        label121:
        for (AddFavoriteUI.this.filePath = e.a(AddFavoriteUI.this.getContentResolver(), this.mUri, 1);; AddFavoriteUI.this.filePath = e.b(AddFavoriteUI.this.getContentResolver(), this.mUri))
        {
          if (this.Lae != null) {
            this.Lae.fOE();
          }
          AppMethodBeat.o(38952);
          return;
        }
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        ae.printErrStackTrace("MicroMsg.AddFavoriteUI", localIllegalAccessException, "", new Object[0]);
        AppMethodBeat.o(38952);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void fOE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.AddFavoriteUI
 * JD-Core Version:    0.7.0.1
 */