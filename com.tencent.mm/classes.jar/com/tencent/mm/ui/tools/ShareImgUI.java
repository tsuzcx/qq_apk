package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareImgUI
  extends AutoLoginActivity
  implements f
{
  private ProgressDialog dnm = null;
  String filePath = null;
  private ah handler = new ShareImgUI.3(this);
  private Intent intent = null;
  Uri uri = null;
  ArrayList<String> vYa = null;
  Intent weG = null;
  
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
  
  private void Zw()
  {
    if (this.intent == null)
    {
      y.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
      Id(0);
      finish();
      return;
    }
    Object localObject1 = this.intent.getAction();
    Object localObject2 = this.intent.getExtras();
    if (bk.bl((String)localObject1))
    {
      y.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
      Id(0);
      finish();
      return;
    }
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = ((Bundle)localObject2).getParcelable("android.intent.extra.STREAM");
      if ((localObject3 != null) && ((localObject3 instanceof Uri)))
      {
        this.uri = ((Uri)localObject3);
        if (!bk.m(this.uri))
        {
          y.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", new Object[] { this.uri });
          Id(0);
          finish();
          return;
        }
      }
    }
    showDialog();
    if (((String)localObject1).equals("android.intent.action.SEND"))
    {
      y.i("MicroMsg.ShareImgUI", "send signal: " + (String)localObject1);
      if (this.uri == null)
      {
        localObject2 = getIntent();
        if (localObject2 == null) {
          y.e("MicroMsg.ShareImgUI", "intent is null");
        }
        for (boolean bool = false;; bool = false)
        {
          y.i("MicroMsg.ShareImgUI", "dealWithText: %b", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            break;
          }
          Id(0);
          finish();
          return;
          localObject1 = t.j((Intent)localObject2, "android.intent.extra.TEXT");
          localObject2 = t.j((Intent)localObject2, "android.intent.extra.SUBJECT");
          if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
            break label264;
          }
          y.i("MicroMsg.ShareImgUI", "text is null");
        }
        label264:
        Object localObject4 = new WXMediaMessage(new WXTextObject((String)localObject1));
        ((WXMediaMessage)localObject4).description = ((String)localObject1);
        localObject3 = new SendMessageToWX.Req();
        ((SendMessageToWX.Req)localObject3).transaction = null;
        ((SendMessageToWX.Req)localObject3).message = ((WXMediaMessage)localObject4);
        localObject4 = new Bundle();
        ((SendMessageToWX.Req)localObject3).toBundle((Bundle)localObject4);
        ((Bundle)localObject4).putInt("_mmessage_sdkVersion", 620824064);
        ((Bundle)localObject4).putString("_mmessage_appPackage", "com.tencent.mm.openapi");
        ((Bundle)localObject4).putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        localObject3 = new Intent();
        ((Intent)localObject3).setClass(this, SelectConversationUI.class);
        ((Intent)localObject3).putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras((Bundle)localObject4).putExtra("animation_pop_in", true));
        if ((au.Hz()) && (!au.CW()))
        {
          au.Dk().a(837, this);
          localObject4 = new ArrayList();
          ((ArrayList)localObject4).add((String)localObject2 + "|" + (String)localObject1);
          localObject1 = new com.tencent.mm.modelsimple.d(5, (List)localObject4, czt());
          com.tencent.mm.kernel.g.Dk().a((m)localObject1, 0);
          showDialog();
          this.weG = ((Intent)localObject3);
        }
        for (;;)
        {
          bool = true;
          break;
          y.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
          MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
        }
      }
      com.tencent.mm.sdk.f.e.post(new ShareImgUI.a(this, this.uri, new ShareImgUI.c()
      {
        public final void cIP()
        {
          ShareImgUI.a(ShareImgUI.this).sendEmptyMessage(0);
        }
      }), "ShareImgUI_getFilePath");
      return;
    }
    if ((((String)localObject1).equals("android.intent.action.SEND_MULTIPLE")) && (localObject2 != null) && (((Bundle)localObject2).containsKey("android.intent.extra.STREAM")))
    {
      y.i("MicroMsg.ShareImgUI", "send multi: " + (String)localObject1);
      com.tencent.mm.sdk.f.e.post(new ShareImgUI.4(this, (Bundle)localObject2, new ShareImgUI.2(this), System.currentTimeMillis()), "getMultiSendFilePathList");
      return;
    }
    y.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
    Id(0);
    finish();
  }
  
  /* Error */
  private String a(Uri paramUri, android.database.Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +367 -> 368
    //   4: ldc_w 376
    //   7: astore 4
    //   9: aload_2
    //   10: ldc_w 378
    //   13: invokeinterface 384 2 0
    //   18: istore_3
    //   19: aload 4
    //   21: astore 5
    //   23: iload_3
    //   24: iconst_m1
    //   25: if_icmpeq +70 -> 95
    //   28: aload_2
    //   29: iload_3
    //   30: invokeinterface 388 2 0
    //   35: astore 5
    //   37: aload 5
    //   39: astore 4
    //   41: aload 4
    //   43: astore 5
    //   45: aload 4
    //   47: ifnull +25 -> 72
    //   50: aload 4
    //   52: astore 5
    //   54: aload 4
    //   56: ifnull +16 -> 72
    //   59: aload 4
    //   61: ldc_w 390
    //   64: ldc_w 392
    //   67: invokevirtual 396	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 5
    //   72: ldc 86
    //   74: new 151	java/lang/StringBuilder
    //   77: dup
    //   78: ldc_w 398
    //   81: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload 5
    //   86: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 166	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_2
    //   96: invokeinterface 401 1 0
    //   101: aload_0
    //   102: invokevirtual 405	com/tencent/mm/ui/tools/ShareImgUI:getContentResolver	()Landroid/content/ContentResolver;
    //   105: aload_1
    //   106: ldc_w 407
    //   109: invokevirtual 413	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 419	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   117: astore_2
    //   118: invokestatic 423	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   121: pop
    //   122: invokestatic 428	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   125: ifeq +272 -> 397
    //   128: new 151	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   135: getstatic 433	com/tencent/mm/compatible/util/e:bkH	Ljava/lang/String;
    //   138: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc_w 435
    //   144: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore 4
    //   152: new 151	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   159: getstatic 433	com/tencent/mm/compatible/util/e:bkH	Ljava/lang/String;
    //   162: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 437
    //   168: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 5
    //   173: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: astore 8
    //   181: new 439	com/tencent/mm/vfs/b
    //   184: dup
    //   185: aload 4
    //   187: invokespecial 440	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   190: astore 4
    //   192: aload 4
    //   194: invokevirtual 443	com/tencent/mm/vfs/b:exists	()Z
    //   197: ifne +9 -> 206
    //   200: aload 4
    //   202: invokevirtual 446	com/tencent/mm/vfs/b:mkdirs	()Z
    //   205: pop
    //   206: new 439	com/tencent/mm/vfs/b
    //   209: dup
    //   210: aload 8
    //   212: invokespecial 440	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   215: astore 4
    //   217: aload 4
    //   219: invokevirtual 443	com/tencent/mm/vfs/b:exists	()Z
    //   222: ifne +9 -> 231
    //   225: aload 4
    //   227: invokevirtual 449	com/tencent/mm/vfs/b:createNewFile	()Z
    //   230: pop
    //   231: aload 8
    //   233: iconst_0
    //   234: invokestatic 454	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   237: astore 4
    //   239: aload 4
    //   241: astore 7
    //   243: aload_1
    //   244: astore 6
    //   246: aload_2
    //   247: astore 5
    //   249: sipush 5120
    //   252: newarray byte
    //   254: astore 9
    //   256: aload 4
    //   258: astore 7
    //   260: aload_1
    //   261: astore 6
    //   263: aload_2
    //   264: astore 5
    //   266: aload_2
    //   267: aload 9
    //   269: iconst_0
    //   270: sipush 5120
    //   273: invokevirtual 460	java/io/InputStream:read	([BII)I
    //   276: istore_3
    //   277: iload_3
    //   278: iconst_m1
    //   279: if_icmpeq +170 -> 449
    //   282: aload 4
    //   284: astore 7
    //   286: aload_1
    //   287: astore 6
    //   289: aload_2
    //   290: astore 5
    //   292: aload 4
    //   294: aload 9
    //   296: iconst_0
    //   297: iload_3
    //   298: invokevirtual 466	java/io/OutputStream:write	([BII)V
    //   301: goto -45 -> 256
    //   304: astore 8
    //   306: aload 4
    //   308: astore 7
    //   310: aload_1
    //   311: astore 6
    //   313: aload_2
    //   314: astore 5
    //   316: ldc 86
    //   318: new 151	java/lang/StringBuilder
    //   321: dup
    //   322: ldc_w 468
    //   325: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: aload 8
    //   330: invokevirtual 471	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 94	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload_2
    //   343: ifnull +7 -> 350
    //   346: aload_2
    //   347: invokevirtual 472	java/io/InputStream:close	()V
    //   350: aload_1
    //   351: ifnull +7 -> 358
    //   354: aload_1
    //   355: invokevirtual 473	android/content/res/AssetFileDescriptor:close	()V
    //   358: aload 4
    //   360: ifnull +8 -> 368
    //   363: aload 4
    //   365: invokevirtual 474	java/io/OutputStream:close	()V
    //   368: aconst_null
    //   369: astore_1
    //   370: aload_1
    //   371: areturn
    //   372: astore 5
    //   374: ldc 86
    //   376: ldc_w 476
    //   379: iconst_1
    //   380: anewarray 135	java/lang/Object
    //   383: dup
    //   384: iconst_0
    //   385: aload 5
    //   387: invokevirtual 477	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   390: aastore
    //   391: invokestatic 479	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: goto -353 -> 41
    //   397: aload_0
    //   398: aload 5
    //   400: invokevirtual 482	com/tencent/mm/ui/tools/ShareImgUI:deleteFile	(Ljava/lang/String;)Z
    //   403: pop
    //   404: new 151	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   411: aload_0
    //   412: invokevirtual 486	com/tencent/mm/ui/tools/ShareImgUI:getFilesDir	()Ljava/io/File;
    //   415: invokevirtual 491	java/io/File:getPath	()Ljava/lang/String;
    //   418: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: ldc_w 493
    //   424: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 5
    //   429: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: astore 8
    //   437: aload_0
    //   438: aload 5
    //   440: iconst_0
    //   441: invokevirtual 497	com/tencent/mm/ui/tools/ShareImgUI:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   444: astore 4
    //   446: goto -207 -> 239
    //   449: aload 4
    //   451: astore 7
    //   453: aload_1
    //   454: astore 6
    //   456: aload_2
    //   457: astore 5
    //   459: aload 4
    //   461: invokevirtual 500	java/io/OutputStream:flush	()V
    //   464: aload 4
    //   466: astore 7
    //   468: aload_1
    //   469: astore 6
    //   471: aload_2
    //   472: astore 5
    //   474: aload 4
    //   476: invokevirtual 474	java/io/OutputStream:close	()V
    //   479: aload_2
    //   480: ifnull +7 -> 487
    //   483: aload_2
    //   484: invokevirtual 472	java/io/InputStream:close	()V
    //   487: aload_1
    //   488: ifnull +7 -> 495
    //   491: aload_1
    //   492: invokevirtual 473	android/content/res/AssetFileDescriptor:close	()V
    //   495: aload 8
    //   497: astore_1
    //   498: aload 4
    //   500: ifnull -130 -> 370
    //   503: aload 4
    //   505: invokevirtual 474	java/io/OutputStream:close	()V
    //   508: aload 8
    //   510: areturn
    //   511: astore_1
    //   512: aload 8
    //   514: areturn
    //   515: astore 8
    //   517: aconst_null
    //   518: astore 4
    //   520: aconst_null
    //   521: astore_1
    //   522: aconst_null
    //   523: astore_2
    //   524: aload 4
    //   526: astore 7
    //   528: aload_1
    //   529: astore 6
    //   531: aload_2
    //   532: astore 5
    //   534: ldc 86
    //   536: new 151	java/lang/StringBuilder
    //   539: dup
    //   540: ldc_w 502
    //   543: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   546: aload 8
    //   548: invokevirtual 503	java/io/IOException:getMessage	()Ljava/lang/String;
    //   551: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 94	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   560: aload_2
    //   561: ifnull +7 -> 568
    //   564: aload_2
    //   565: invokevirtual 472	java/io/InputStream:close	()V
    //   568: aload_1
    //   569: ifnull +7 -> 576
    //   572: aload_1
    //   573: invokevirtual 473	android/content/res/AssetFileDescriptor:close	()V
    //   576: aload 4
    //   578: ifnull -210 -> 368
    //   581: aload 4
    //   583: invokevirtual 474	java/io/OutputStream:close	()V
    //   586: goto -218 -> 368
    //   589: astore_1
    //   590: goto -222 -> 368
    //   593: astore 8
    //   595: aconst_null
    //   596: astore 4
    //   598: aconst_null
    //   599: astore_1
    //   600: aconst_null
    //   601: astore_2
    //   602: aload 4
    //   604: astore 7
    //   606: aload_1
    //   607: astore 6
    //   609: aload_2
    //   610: astore 5
    //   612: ldc 86
    //   614: new 151	java/lang/StringBuilder
    //   617: dup
    //   618: ldc_w 505
    //   621: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   624: aload 8
    //   626: invokevirtual 477	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   629: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 94	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: aload 4
    //   640: astore 7
    //   642: aload_1
    //   643: astore 6
    //   645: aload_2
    //   646: astore 5
    //   648: ldc 86
    //   650: aload 8
    //   652: invokevirtual 506	java/lang/Exception:toString	()Ljava/lang/String;
    //   655: invokestatic 94	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   658: aload_2
    //   659: ifnull +7 -> 666
    //   662: aload_2
    //   663: invokevirtual 472	java/io/InputStream:close	()V
    //   666: aload_1
    //   667: ifnull +7 -> 674
    //   670: aload_1
    //   671: invokevirtual 473	android/content/res/AssetFileDescriptor:close	()V
    //   674: aload 4
    //   676: ifnull -308 -> 368
    //   679: aload 4
    //   681: invokevirtual 474	java/io/OutputStream:close	()V
    //   684: goto -316 -> 368
    //   687: astore_1
    //   688: goto -320 -> 368
    //   691: astore 4
    //   693: aconst_null
    //   694: astore 7
    //   696: aconst_null
    //   697: astore_1
    //   698: aconst_null
    //   699: astore_2
    //   700: aload_2
    //   701: ifnull +7 -> 708
    //   704: aload_2
    //   705: invokevirtual 472	java/io/InputStream:close	()V
    //   708: aload_1
    //   709: ifnull +7 -> 716
    //   712: aload_1
    //   713: invokevirtual 473	android/content/res/AssetFileDescriptor:close	()V
    //   716: aload 7
    //   718: ifnull +8 -> 726
    //   721: aload 7
    //   723: invokevirtual 474	java/io/OutputStream:close	()V
    //   726: aload 4
    //   728: athrow
    //   729: astore_1
    //   730: goto -4 -> 726
    //   733: astore 4
    //   735: aconst_null
    //   736: astore 7
    //   738: aconst_null
    //   739: astore_2
    //   740: goto -40 -> 700
    //   743: astore 4
    //   745: aconst_null
    //   746: astore 7
    //   748: goto -48 -> 700
    //   751: astore 4
    //   753: aload 6
    //   755: astore_1
    //   756: aload 5
    //   758: astore_2
    //   759: goto -59 -> 700
    //   762: astore 8
    //   764: aconst_null
    //   765: astore 4
    //   767: aconst_null
    //   768: astore_2
    //   769: goto -167 -> 602
    //   772: astore 8
    //   774: aconst_null
    //   775: astore 4
    //   777: goto -175 -> 602
    //   780: astore 8
    //   782: goto -180 -> 602
    //   785: astore 8
    //   787: aconst_null
    //   788: astore 4
    //   790: aconst_null
    //   791: astore_2
    //   792: goto -268 -> 524
    //   795: astore 8
    //   797: aconst_null
    //   798: astore 4
    //   800: goto -276 -> 524
    //   803: astore 8
    //   805: goto -281 -> 524
    //   808: astore_1
    //   809: goto -441 -> 368
    //   812: astore 8
    //   814: aconst_null
    //   815: astore 4
    //   817: aconst_null
    //   818: astore_1
    //   819: aconst_null
    //   820: astore_2
    //   821: goto -515 -> 306
    //   824: astore 8
    //   826: aconst_null
    //   827: astore 4
    //   829: aconst_null
    //   830: astore_2
    //   831: goto -525 -> 306
    //   834: astore 8
    //   836: aconst_null
    //   837: astore 4
    //   839: goto -533 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	842	0	this	ShareImgUI
    //   0	842	1	paramUri	Uri
    //   0	842	2	paramCursor	android.database.Cursor
    //   18	280	3	i	int
    //   7	673	4	localObject1	Object
    //   691	36	4	localObject2	Object
    //   733	1	4	localObject3	Object
    //   743	1	4	localObject4	Object
    //   751	1	4	localObject5	Object
    //   765	73	4	localObject6	Object
    //   21	294	5	localObject7	Object
    //   372	67	5	localException1	java.lang.Exception
    //   457	300	5	localCursor	android.database.Cursor
    //   244	510	6	localUri	Uri
    //   241	506	7	localObject8	Object
    //   179	53	8	str1	String
    //   304	25	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   435	78	8	str2	String
    //   515	32	8	localIOException1	java.io.IOException
    //   593	58	8	localException2	java.lang.Exception
    //   762	1	8	localException3	java.lang.Exception
    //   772	1	8	localException4	java.lang.Exception
    //   780	1	8	localException5	java.lang.Exception
    //   785	1	8	localIOException2	java.io.IOException
    //   795	1	8	localIOException3	java.io.IOException
    //   803	1	8	localIOException4	java.io.IOException
    //   812	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   824	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   834	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   254	41	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   249	256	304	java/io/FileNotFoundException
    //   266	277	304	java/io/FileNotFoundException
    //   292	301	304	java/io/FileNotFoundException
    //   459	464	304	java/io/FileNotFoundException
    //   474	479	304	java/io/FileNotFoundException
    //   28	37	372	java/lang/Exception
    //   483	487	511	java/lang/Exception
    //   491	495	511	java/lang/Exception
    //   503	508	511	java/lang/Exception
    //   101	113	515	java/io/IOException
    //   564	568	589	java/lang/Exception
    //   572	576	589	java/lang/Exception
    //   581	586	589	java/lang/Exception
    //   101	113	593	java/lang/Exception
    //   662	666	687	java/lang/Exception
    //   670	674	687	java/lang/Exception
    //   679	684	687	java/lang/Exception
    //   101	113	691	finally
    //   704	708	729	java/lang/Exception
    //   712	716	729	java/lang/Exception
    //   721	726	729	java/lang/Exception
    //   113	118	733	finally
    //   118	206	743	finally
    //   206	231	743	finally
    //   231	239	743	finally
    //   397	446	743	finally
    //   249	256	751	finally
    //   266	277	751	finally
    //   292	301	751	finally
    //   316	342	751	finally
    //   459	464	751	finally
    //   474	479	751	finally
    //   534	560	751	finally
    //   612	638	751	finally
    //   648	658	751	finally
    //   113	118	762	java/lang/Exception
    //   118	206	772	java/lang/Exception
    //   206	231	772	java/lang/Exception
    //   231	239	772	java/lang/Exception
    //   397	446	772	java/lang/Exception
    //   249	256	780	java/lang/Exception
    //   266	277	780	java/lang/Exception
    //   292	301	780	java/lang/Exception
    //   459	464	780	java/lang/Exception
    //   474	479	780	java/lang/Exception
    //   113	118	785	java/io/IOException
    //   118	206	795	java/io/IOException
    //   206	231	795	java/io/IOException
    //   231	239	795	java/io/IOException
    //   397	446	795	java/io/IOException
    //   249	256	803	java/io/IOException
    //   266	277	803	java/io/IOException
    //   292	301	803	java/io/IOException
    //   459	464	803	java/io/IOException
    //   474	479	803	java/io/IOException
    //   346	350	808	java/lang/Exception
    //   354	358	808	java/lang/Exception
    //   363	368	808	java/lang/Exception
    //   101	113	812	java/io/FileNotFoundException
    //   113	118	824	java/io/FileNotFoundException
    //   118	206	834	java/io/FileNotFoundException
    //   206	231	834	java/io/FileNotFoundException
    //   231	239	834	java/io/FileNotFoundException
    //   397	446	834	java/io/FileNotFoundException
  }
  
  private static boolean aef(String paramString)
  {
    MMBitmapFactory.DecodeResultLogger localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
    boolean bool = o.a(paramString, localDecodeResultLogger);
    if ((!bool) && (localDecodeResultLogger.getDecodeResult() >= 2000))
    {
      paramString = MMBitmapFactory.KVStatHelper.getKVStatString(paramString, 3, localDecodeResultLogger);
      com.tencent.mm.plugin.report.service.h.nFQ.aC(12712, paramString);
    }
    return bool;
  }
  
  private static int aeg(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.ShareImgUI", "map : mimeType is null");
      return -1;
    }
    paramString = paramString.toLowerCase();
    if (paramString.equalsIgnoreCase("image/gif")) {
      return 5;
    }
    if (paramString.contains("image")) {
      return 0;
    }
    if (paramString.contains("video")) {
      return 1;
    }
    y.d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
    return 3;
  }
  
  private boolean cJi()
  {
    boolean bool2 = false;
    Intent localIntent = new Intent(this, ShareImgUI.class);
    boolean bool1;
    if ("android.intent.action.SEND".equals(getIntent().getAction()))
    {
      bool1 = bool2;
      if (!bk.bl(this.filePath))
      {
        localIntent.putExtra("android.intent.extra.STREAM", com.tencent.mm.vfs.e.aeP(this.filePath));
        localIntent.setAction("android.intent.action.SEND");
        localIntent.setType(getIntent().getType());
      }
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), localIntent);
      bool1 = true;
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!"android.intent.action.SEND_MULTIPLE".equals(getIntent().getAction()));
        bool1 = bool2;
      } while (bk.dk(this.vYa));
      ArrayList localArrayList = new ArrayList(this.vYa.size());
      Iterator localIterator = this.vYa.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(com.tencent.mm.vfs.e.aeP((String)localIterator.next()));
      }
      localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
      localIntent.setAction("android.intent.action.SEND_MULTIPLE");
      localIntent.setType(getIntent().getType());
    }
  }
  
  private void cJj()
  {
    Toast.makeText(this, R.l.emoji_custom_gif_max_size_limit_cannot_send, 1).show();
    finish();
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
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.app_waiting), true, new ShareImgUI.6(this));
  }
  
  protected final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    switch (ShareImgUI.7.hSj[parama.ordinal()])
    {
    default: 
      finish();
      com.tencent.mm.ui.base.b.gK(this);
      return;
    }
    this.intent = paramIntent;
    int i = bk.getInt(com.tencent.mm.m.g.AA().getValue("SystemShareControlBitset"), 0);
    y.i("MicroMsg.ShareImgUI", "now permission = %d", new Object[] { Integer.valueOf(i) });
    if ((i & 0x1) > 0)
    {
      y.e("MicroMsg.ShareImgUI", "now allowed to share to friend");
      finish();
      return;
    }
    parama = t.j(paramIntent, "android.intent.extra.TEXT");
    y.i("MicroMsg.ShareImgUI", "postLogin, text = %s", new Object[] { parama });
    if (!bk.bl(parama))
    {
      parama = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[] { URLEncoder.encode(parama) });
      showDialog();
      au.Dk().a(1200, this);
      parama = new aa(parama, 15, null);
      au.Dk().a(parama, 0);
      return;
    }
    Zw();
  }
  
  protected final boolean boC()
  {
    if ((!au.Hz()) || (au.CW()))
    {
      y.w("MicroMsg.ShareImgUI", "not login");
      this.intent = getIntent();
      Zw();
      return true;
    }
    return false;
  }
  
  protected void onDestroy()
  {
    au.Dk().b(1200, this);
    au.Dk().b(837, this);
    dismissDialog();
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    dismissDialog();
    if ((paramm instanceof aa))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        Zw();
      }
    }
    else if ((paramm instanceof com.tencent.mm.modelsimple.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label186;
      }
      if (paramm.edi != null)
      {
        paramString = (pp)((com.tencent.mm.ah.b)paramm.edi).ecF.ecN;
        if ((paramString == null) || (bk.bl(paramString.sNw))) {
          break label186;
        }
        paramm = new Intent();
        paramm.putExtra("rawUrl", paramString.sNw);
        paramm.putExtra("showShare", false);
        paramm.putExtra("show_bottom", false);
        paramm.putExtra("needRedirect", false);
        com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramm);
      }
    }
    for (;;)
    {
      finish();
      return;
      finish();
      break;
      label186:
      startActivity(this.weG);
    }
  }
  
  protected final boolean w(Intent paramIntent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareImgUI
 * JD-Core Version:    0.7.0.1
 */