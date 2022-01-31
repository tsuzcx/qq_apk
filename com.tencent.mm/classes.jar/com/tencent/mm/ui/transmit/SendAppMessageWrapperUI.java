package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.MotionEvent;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class SendAppMessageWrapperUI
  extends MMActivity
{
  private String aWf = null;
  private am byQ = new am(new SendAppMessageWrapperUI.1(this), true);
  private int kkh = 0;
  private int scene = 0;
  private com.tencent.mm.ui.base.p tipDialog;
  private String toUser = null;
  private WXMediaMessage vlu = null;
  private com.tencent.mm.pluginsdk.model.app.f whH = null;
  private boolean whI = false;
  private boolean whJ = false;
  
  private q.a a(WXMediaMessage paramWXMediaMessage)
  {
    return new SendAppMessageWrapperUI.3(this, paramWXMediaMessage);
  }
  
  private void a(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    Object localObject1;
    if ((paramWXMediaMessage == null) || (!(paramWXMediaMessage.mediaObject instanceof WXImageObject)))
    {
      y.w("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg msg not img");
      localObject1 = null;
    }
    while (bk.bl((String)localObject1))
    {
      y.e("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg imgPath is null");
      return;
      localObject1 = (WXImageObject)paramWXMediaMessage.mediaObject;
      if (!bk.bE(((WXImageObject)localObject1).imageData))
      {
        y.d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + ((WXImageObject)localObject1).imageData.length);
        localObject1 = com.tencent.mm.pluginsdk.model.app.l.bj(((WXImageObject)localObject1).imageData);
      }
      else
      {
        localObject1 = ((WXImageObject)localObject1).imagePath;
      }
    }
    if (com.tencent.mm.vfs.e.aeQ((String)localObject1) > 26214400L) {}
    for (int i = 0;; i = 1)
    {
      if ((!this.whJ) && (cJC()))
      {
        paramWXMediaMessage = null;
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          localObject2 = (String)paramLinkedList.next();
          localObject2 = new com.tencent.mm.as.l(6, q.Gj(), (String)localObject2, (String)localObject1, i, null, 0, paramWXMediaMessage, "", true, R.g.chat_img_to_bg_mask);
          au.Dk().a((m)localObject2, 0);
        }
        break;
      }
      Object localObject2 = this.whH.field_appId;
      String str1 = paramWXMediaMessage.mediaTagName;
      String str2 = paramWXMediaMessage.messageExt;
      paramWXMediaMessage = paramWXMediaMessage.messageAction;
      if (!bk.bl((String)localObject2)) {}
      for (paramWXMediaMessage = "<msg>" + com.tencent.mm.as.f.c((String)localObject2, str1, str2, paramWXMediaMessage) + "</msg>";; paramWXMediaMessage = null) {
        break;
      }
    }
  }
  
  private void b(WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(((WXVideoFileObject)paramWXMediaMessage.mediaObject).filePath);
    if (localArrayList.size() > 0)
    {
      paramWXMediaMessage = paramLinkedList.iterator();
      while (paramWXMediaMessage.hasNext())
      {
        paramLinkedList = (String)paramWXMediaMessage.next();
        y.i("MicroMsg.SendAppMessageWrapperUI", "sendMultiVedeo");
        paramLinkedList = new j(this, localArrayList, getIntent(), paramLinkedList, 1, new SendAppMessageWrapperUI.8(this));
        com.tencent.mm.sdk.f.e.post(paramLinkedList, "ChattingUI_importMultiVideo");
        getString(R.l.app_tip);
        this.tipDialog = h.b(this, getString(R.l.app_waiting), true, new SendAppMessageWrapperUI.9(this, paramLinkedList));
      }
    }
  }
  
  private void cJB()
  {
    if ((!this.whJ) && (cJC())) {}
    for (Intent localIntent = com.tencent.mm.modelsns.a.a(this.vlu, "", ""); localIntent == null; localIntent = com.tencent.mm.modelsns.a.a(this.vlu, this.whH.field_appId, this.whH.field_appName))
    {
      finish();
      return;
    }
    String str = null;
    if ((this.vlu.getType() == 5) || (this.vlu.getType() == 2) || (this.vlu.getType() == 38))
    {
      y.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", new Object[] { this.whH.field_appId });
      str = u.ij("app_" + this.whH.field_appId);
      u.b localb = u.Hc().v(str, true);
      localb.h("prePublishId", "app_" + this.whH.field_appId);
      if ((this.vlu.mediaObject instanceof WXWebpageObject)) {
        localb.h("url", ((WXWebpageObject)this.vlu.mediaObject).webpageUrl);
      }
    }
    localIntent.putExtra("reportSessionId", str);
    com.tencent.mm.br.d.b(this, "sns", ".ui.SnsUploadUI", localIntent, 1);
  }
  
  private static boolean cJC()
  {
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100414");
    if ((localc.isValid()) && ("1".equals(localc.ctr().get("blockInOldSDK")))) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.SendAppMessageWrapperUI", "blockInvalidToken block %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected final void initView() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + paramInt1 + " resultCode " + paramInt2);
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), 0), false);
        finish();
      }
    }
    while ((paramInt1 != 2) || (paramInt2 != -1)) {
      for (;;)
      {
        return;
        ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), 0), true);
      }
    }
    WXVideoFileObject localWXVideoFileObject = (WXVideoFileObject)this.vlu.mediaObject;
    localWXVideoFileObject.filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
    if ((!bk.bl(localWXVideoFileObject.filePath)) && (com.tencent.mm.vfs.e.bK(localWXVideoFileObject.filePath)))
    {
      cJB();
      return;
    }
    setResult(-5);
    finish();
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 969	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: invokevirtual 973	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:getSupportActionBar	()Landroid/support/v7/app/ActionBar;
    //   9: invokevirtual 978	android/support/v7/app/ActionBar:hide	()V
    //   12: aload_0
    //   13: invokestatic 983	com/tencent/mm/sdk/platformtools/ae:cqR	()Ljava/lang/String;
    //   16: iconst_0
    //   17: invokevirtual 987	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   20: astore_1
    //   21: aload_1
    //   22: ldc_w 989
    //   25: iconst_0
    //   26: invokeinterface 995 3 0
    //   31: ifne +42 -> 73
    //   34: ldc 76
    //   36: ldc_w 997
    //   39: invokestatic 121	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: iconst_1
    //   44: putfield 40	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:whI	Z
    //   47: aload_0
    //   48: iconst_m1
    //   49: invokevirtual 1000	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:setRequestedOrientation	(I)V
    //   52: aload_1
    //   53: invokeinterface 1004 1 0
    //   58: ldc_w 989
    //   61: iconst_1
    //   62: invokeinterface 1010 3 0
    //   67: invokeinterface 1013 1 0
    //   72: pop
    //   73: aload_0
    //   74: invokevirtual 465	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:getIntent	()Landroid/content/Intent;
    //   77: invokevirtual 471	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   80: astore_1
    //   81: new 1015	com/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 1017	com/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req:<init>	(Landroid/os/Bundle;)V
    //   89: astore 4
    //   91: aload_0
    //   92: aload_1
    //   93: ldc_w 766
    //   96: invokevirtual 1019	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: putfield 34	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:toUser	Ljava/lang/String;
    //   102: aload_0
    //   103: aload_1
    //   104: ldc_w 1021
    //   107: iconst_0
    //   108: invokevirtual 1022	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   111: putfield 42	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:whJ	Z
    //   114: aload_0
    //   115: aload_1
    //   116: ldc_w 1024
    //   119: iconst_0
    //   120: invokevirtual 1025	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   123: putfield 38	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:scene	I
    //   126: aload_1
    //   127: ldc_w 1027
    //   130: invokevirtual 1019	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore 5
    //   135: aload 5
    //   137: ifnonnull +1317 -> 1454
    //   140: aload_1
    //   141: ldc_w 1029
    //   144: invokevirtual 1019	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokestatic 1035	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   150: ldc_w 1037
    //   153: invokevirtual 1040	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore 5
    //   158: aload_0
    //   159: new 189	com/tencent/mm/pluginsdk/model/app/f
    //   162: dup
    //   163: invokespecial 1041	com/tencent/mm/pluginsdk/model/app/f:<init>	()V
    //   166: putfield 32	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:whH	Lcom/tencent/mm/pluginsdk/model/app/f;
    //   169: aload_0
    //   170: getfield 32	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:whH	Lcom/tencent/mm/pluginsdk/model/app/f;
    //   173: aload 5
    //   175: putfield 192	com/tencent/mm/pluginsdk/model/app/f:field_appId	Ljava/lang/String;
    //   178: invokestatic 1047	com/tencent/mm/pluginsdk/model/app/ap:brn	()Lcom/tencent/mm/pluginsdk/model/app/i;
    //   181: aload_0
    //   182: getfield 32	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:whH	Lcom/tencent/mm/pluginsdk/model/app/f;
    //   185: iconst_0
    //   186: anewarray 159	java/lang/String
    //   189: invokevirtual 1052	com/tencent/mm/pluginsdk/model/app/i:b	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   192: pop
    //   193: aload_0
    //   194: getfield 32	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:whH	Lcom/tencent/mm/pluginsdk/model/app/f;
    //   197: getfield 314	com/tencent/mm/pluginsdk/model/app/f:field_appName	Ljava/lang/String;
    //   200: ifnonnull +94 -> 294
    //   203: aload_0
    //   204: getstatic 1055	com/tencent/mm/R$l:confirm_dialog_unknown_source	I
    //   207: invokevirtual 394	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:getString	(I)Ljava/lang/String;
    //   210: astore_1
    //   211: aload_0
    //   212: aload_0
    //   213: getstatic 1058	com/tencent/mm/R$l:confirm_dialog_source	I
    //   216: iconst_1
    //   217: anewarray 221	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_1
    //   223: aastore
    //   224: invokevirtual 434	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   227: putfield 30	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:aWf	Ljava/lang/String;
    //   230: aload_0
    //   231: aload 4
    //   233: getfield 1061	com/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req:message	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   236: putfield 36	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vlu	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   239: ldc 76
    //   241: ldc_w 1063
    //   244: iconst_2
    //   245: anewarray 221	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload_0
    //   251: getfield 36	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vlu	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   254: getfield 201	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:messageAction	Ljava/lang/String;
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: aload_0
    //   261: getfield 36	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vlu	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   264: getfield 198	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:messageExt	Ljava/lang/String;
    //   267: aastore
    //   268: invokestatic 1065	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload_0
    //   272: getfield 38	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:scene	I
    //   275: iconst_1
    //   276: if_icmpne +1154 -> 1430
    //   279: aload_0
    //   280: getfield 36	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vlu	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   283: getfield 72	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   286: ifnonnull +27 -> 313
    //   289: aload_0
    //   290: invokevirtual 482	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:finish	()V
    //   293: return
    //   294: aload_0
    //   295: getfield 817	com/tencent/mm/ui/MMActivity:mController	Lcom/tencent/mm/ui/s;
    //   298: getfield 723	com/tencent/mm/ui/s:uMN	Landroid/support/v7/app/AppCompatActivity;
    //   301: aload_0
    //   302: getfield 32	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:whH	Lcom/tencent/mm/pluginsdk/model/app/f;
    //   305: aconst_null
    //   306: invokestatic 1068	com/tencent/mm/pluginsdk/model/app/g:b	(Landroid/content/Context;Lcom/tencent/mm/pluginsdk/model/app/f;Ljava/lang/String;)Ljava/lang/String;
    //   309: astore_1
    //   310: goto -99 -> 211
    //   313: aload_0
    //   314: getfield 36	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vlu	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   317: invokevirtual 243	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:getType	()I
    //   320: bipush 38
    //   322: if_icmpne +490 -> 812
    //   325: aload_0
    //   326: getfield 36	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vlu	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   329: getfield 72	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   332: checkcast 633	com/tencent/mm/opensdk/modelmsg/WXVideoFileObject
    //   335: astore 9
    //   337: aload_0
    //   338: getfield 36	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vlu	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   341: getfield 198	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:messageExt	Ljava/lang/String;
    //   344: astore 7
    //   346: aload 9
    //   348: getfield 636	com/tencent/mm/opensdk/modelmsg/WXVideoFileObject:filePath	Ljava/lang/String;
    //   351: astore 8
    //   353: aload 9
    //   355: getfield 636	com/tencent/mm/opensdk/modelmsg/WXVideoFileObject:filePath	Ljava/lang/String;
    //   358: invokestatic 90	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   361: ifne +387 -> 748
    //   364: aload 9
    //   366: getfield 636	com/tencent/mm/opensdk/modelmsg/WXVideoFileObject:filePath	Ljava/lang/String;
    //   369: invokestatic 961	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   372: ifeq +376 -> 748
    //   375: new 1070	android/media/MediaMetadataRetriever
    //   378: dup
    //   379: invokespecial 1071	android/media/MediaMetadataRetriever:<init>	()V
    //   382: astore 4
    //   384: aload 4
    //   386: astore_1
    //   387: aload 4
    //   389: aload 8
    //   391: invokevirtual 1074	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   394: aload 4
    //   396: astore_1
    //   397: aload 4
    //   399: bipush 9
    //   401: invokevirtual 1077	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   404: iconst_m1
    //   405: invokestatic 303	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   408: istore_3
    //   409: bipush 10
    //   411: istore_2
    //   412: aload 4
    //   414: astore_1
    //   415: ldc_w 1079
    //   418: aload 5
    //   420: invokevirtual 385	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   423: ifeq +18 -> 441
    //   426: aload 4
    //   428: astore_1
    //   429: invokestatic 290	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   432: ldc_w 1081
    //   435: bipush 10
    //   437: invokevirtual 1082	com/tencent/mm/m/e:getInt	(Ljava/lang/String;I)I
    //   440: istore_2
    //   441: aload 4
    //   443: astore_1
    //   444: ldc 76
    //   446: ldc_w 1084
    //   449: iconst_2
    //   450: anewarray 221	java/lang/Object
    //   453: dup
    //   454: iconst_0
    //   455: iload_3
    //   456: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: aastore
    //   460: dup
    //   461: iconst_1
    //   462: iload_2
    //   463: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   466: aastore
    //   467: invokestatic 1065	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   470: iload_3
    //   471: i2d
    //   472: iload_2
    //   473: i2d
    //   474: ldc2_w 1085
    //   477: dadd
    //   478: ldc2_w 1087
    //   481: dmul
    //   482: dcmpl
    //   483: iflt +47 -> 530
    //   486: aload 4
    //   488: astore_1
    //   489: aload_0
    //   490: bipush 251
    //   492: invokevirtual 517	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:setResult	(I)V
    //   495: aload 4
    //   497: astore_1
    //   498: aload_0
    //   499: invokevirtual 482	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:finish	()V
    //   502: aload 4
    //   504: invokevirtual 1091	android/media/MediaMetadataRetriever:release	()V
    //   507: return
    //   508: astore_1
    //   509: ldc 76
    //   511: aload_1
    //   512: ldc_w 1093
    //   515: iconst_1
    //   516: anewarray 221	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: aload_1
    //   522: invokevirtual 1096	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   525: aastore
    //   526: invokestatic 1100	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   529: return
    //   530: aload 4
    //   532: invokevirtual 1091	android/media/MediaMetadataRetriever:release	()V
    //   535: ldc_w 1079
    //   538: aload 5
    //   540: invokevirtual 385	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   543: ifeq +228 -> 771
    //   546: aload 9
    //   548: getfield 636	com/tencent/mm/opensdk/modelmsg/WXVideoFileObject:filePath	Ljava/lang/String;
    //   551: invokestatic 90	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   554: ifne +206 -> 760
    //   557: aload 9
    //   559: getfield 636	com/tencent/mm/opensdk/modelmsg/WXVideoFileObject:filePath	Ljava/lang/String;
    //   562: invokestatic 961	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   565: ifeq +195 -> 760
    //   568: aload 9
    //   570: getfield 636	com/tencent/mm/opensdk/modelmsg/WXVideoFileObject:filePath	Ljava/lang/String;
    //   573: astore_1
    //   574: aload_1
    //   575: ifnull +180 -> 755
    //   578: new 1102	java/io/File
    //   581: dup
    //   582: aload_1
    //   583: invokespecial 1103	java/io/File:<init>	(Ljava/lang/String;)V
    //   586: astore_1
    //   587: aload_1
    //   588: invokevirtual 1106	java/io/File:exists	()Z
    //   591: ifeq +164 -> 755
    //   594: aload_1
    //   595: invokestatic 1112	com/tencent/xweb/util/c:n	(Ljava/io/File;)Ljava/lang/String;
    //   598: astore_1
    //   599: aload 7
    //   601: aload_1
    //   602: invokestatic 1116	com/tencent/mm/sdk/platformtools/bk:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   605: ifeq +155 -> 760
    //   608: aload_0
    //   609: invokespecial 963	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:cJB	()V
    //   612: return
    //   613: astore_1
    //   614: ldc 76
    //   616: aload_1
    //   617: ldc_w 1093
    //   620: iconst_1
    //   621: anewarray 221	java/lang/Object
    //   624: dup
    //   625: iconst_0
    //   626: aload_1
    //   627: invokevirtual 1096	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   630: aastore
    //   631: invokestatic 1100	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   634: goto -99 -> 535
    //   637: astore 6
    //   639: aconst_null
    //   640: astore 4
    //   642: aload 4
    //   644: astore_1
    //   645: ldc 76
    //   647: aload 6
    //   649: ldc_w 1118
    //   652: iconst_2
    //   653: anewarray 221	java/lang/Object
    //   656: dup
    //   657: iconst_0
    //   658: aload 8
    //   660: aastore
    //   661: dup
    //   662: iconst_1
    //   663: aload 6
    //   665: invokevirtual 1096	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   668: aastore
    //   669: invokestatic 1100	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   672: aload 4
    //   674: ifnull -139 -> 535
    //   677: aload 4
    //   679: invokevirtual 1091	android/media/MediaMetadataRetriever:release	()V
    //   682: goto -147 -> 535
    //   685: astore_1
    //   686: ldc 76
    //   688: aload_1
    //   689: ldc_w 1093
    //   692: iconst_1
    //   693: anewarray 221	java/lang/Object
    //   696: dup
    //   697: iconst_0
    //   698: aload_1
    //   699: invokevirtual 1096	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   702: aastore
    //   703: invokestatic 1100	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   706: goto -171 -> 535
    //   709: astore 4
    //   711: aconst_null
    //   712: astore_1
    //   713: aload_1
    //   714: ifnull +7 -> 721
    //   717: aload_1
    //   718: invokevirtual 1091	android/media/MediaMetadataRetriever:release	()V
    //   721: aload 4
    //   723: athrow
    //   724: astore_1
    //   725: ldc 76
    //   727: aload_1
    //   728: ldc_w 1093
    //   731: iconst_1
    //   732: anewarray 221	java/lang/Object
    //   735: dup
    //   736: iconst_0
    //   737: aload_1
    //   738: invokevirtual 1096	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   741: aastore
    //   742: invokestatic 1100	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   745: goto -24 -> 721
    //   748: aload_0
    //   749: invokevirtual 482	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:finish	()V
    //   752: goto -217 -> 535
    //   755: aconst_null
    //   756: astore_1
    //   757: goto -158 -> 599
    //   760: aload_0
    //   761: bipush 251
    //   763: invokevirtual 517	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:setResult	(I)V
    //   766: aload_0
    //   767: invokevirtual 482	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:finish	()V
    //   770: return
    //   771: new 467	android/content/Intent
    //   774: dup
    //   775: invokespecial 932	android/content/Intent:<init>	()V
    //   778: astore_1
    //   779: aload_1
    //   780: ldc_w 955
    //   783: aload 8
    //   785: invokevirtual 888	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   788: pop
    //   789: aload_1
    //   790: ldc_w 1120
    //   793: ldc 168
    //   795: invokevirtual 888	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   798: pop
    //   799: aload_0
    //   800: ldc_w 1122
    //   803: ldc_w 1124
    //   806: aload_1
    //   807: iconst_2
    //   808: invokestatic 897	com/tencent/mm/br/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;I)V
    //   811: return
    //   812: aload_0
    //   813: getfield 36	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vlu	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   816: invokevirtual 243	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:getType	()I
    //   819: bipush 39
    //   821: if_icmpne +604 -> 1425
    //   824: aload_0
    //   825: getfield 36	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vlu	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   828: getfield 72	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   831: checkcast 1126	com/tencent/mm/opensdk/modelmsg/WXGameVideoFileObject
    //   834: astore_1
    //   835: aload_1
    //   836: getfield 1127	com/tencent/mm/opensdk/modelmsg/WXGameVideoFileObject:filePath	Ljava/lang/String;
    //   839: invokestatic 90	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   842: ifne +62 -> 904
    //   845: aload_1
    //   846: getfield 1127	com/tencent/mm/opensdk/modelmsg/WXGameVideoFileObject:filePath	Ljava/lang/String;
    //   849: invokestatic 961	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   852: ifeq +52 -> 904
    //   855: aload_1
    //   856: getfield 1127	com/tencent/mm/opensdk/modelmsg/WXGameVideoFileObject:filePath	Ljava/lang/String;
    //   859: astore_1
    //   860: invokestatic 290	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   863: ldc_w 1129
    //   866: ldc_w 1130
    //   869: invokevirtual 1082	com/tencent/mm/m/e:getInt	(Ljava/lang/String;I)I
    //   872: istore_2
    //   873: aload_1
    //   874: invokestatic 136	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   877: iload_2
    //   878: i2l
    //   879: lcmp
    //   880: ifle +46 -> 926
    //   883: ldc_w 1132
    //   886: ldc_w 1134
    //   889: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   892: iconst_1
    //   893: istore_2
    //   894: iload_2
    //   895: ifeq +36 -> 931
    //   898: iconst_1
    //   899: istore_2
    //   900: iload_2
    //   901: ifeq +524 -> 1425
    //   904: aload_0
    //   905: aload_0
    //   906: invokevirtual 465	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:getIntent	()Landroid/content/Intent;
    //   909: invokevirtual 471	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   912: bipush 251
    //   914: invokestatic 476	com/tencent/mm/pluginsdk/model/app/ReportUtil:c	(Landroid/os/Bundle;I)Lcom/tencent/mm/pluginsdk/model/app/ReportUtil$ReportArgs;
    //   917: iconst_0
    //   918: invokestatic 479	com/tencent/mm/pluginsdk/model/app/ReportUtil:a	(Landroid/content/Context;Lcom/tencent/mm/pluginsdk/model/app/ReportUtil$ReportArgs;Z)V
    //   921: aload_0
    //   922: invokevirtual 482	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:finish	()V
    //   925: return
    //   926: iconst_0
    //   927: istore_2
    //   928: goto -34 -> 894
    //   931: aload_1
    //   932: invokestatic 1140	com/tencent/mm/modelsns/a$a:nh	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/a$a;
    //   935: astore_1
    //   936: aload_1
    //   937: getfield 1143	com/tencent/mm/modelsns/a$a:videoWidth	I
    //   940: ifle +46 -> 986
    //   943: aload_1
    //   944: getfield 1146	com/tencent/mm/modelsns/a$a:videoHeight	I
    //   947: ifle +39 -> 986
    //   950: aload_1
    //   951: getfield 1143	com/tencent/mm/modelsns/a$a:videoWidth	I
    //   954: i2f
    //   955: aload_1
    //   956: getfield 1146	com/tencent/mm/modelsns/a$a:videoHeight	I
    //   959: i2f
    //   960: fdiv
    //   961: ldc_w 1147
    //   964: fcmpl
    //   965: ifgt +21 -> 986
    //   968: aload_1
    //   969: getfield 1143	com/tencent/mm/modelsns/a$a:videoWidth	I
    //   972: i2f
    //   973: aload_1
    //   974: getfield 1146	com/tencent/mm/modelsns/a$a:videoHeight	I
    //   977: i2f
    //   978: fdiv
    //   979: ldc_w 1148
    //   982: fcmpg
    //   983: ifge +195 -> 1178
    //   986: ldc_w 1132
    //   989: ldc_w 1150
    //   992: iconst_2
    //   993: anewarray 221	java/lang/Object
    //   996: dup
    //   997: iconst_0
    //   998: aload_1
    //   999: getfield 1143	com/tencent/mm/modelsns/a$a:videoWidth	I
    //   1002: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1005: aastore
    //   1006: dup
    //   1007: iconst_1
    //   1008: aload_1
    //   1009: getfield 1146	com/tencent/mm/modelsns/a$a:videoHeight	I
    //   1012: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1015: aastore
    //   1016: invokestatic 1065	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1019: iconst_1
    //   1020: istore_2
    //   1021: iload_2
    //   1022: ifne +151 -> 1173
    //   1025: ldc_w 1132
    //   1028: ldc_w 1152
    //   1031: iconst_1
    //   1032: anewarray 221	java/lang/Object
    //   1035: dup
    //   1036: iconst_0
    //   1037: aload_1
    //   1038: getfield 1155	com/tencent/mm/modelsns/a$a:eAx	I
    //   1041: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1044: aastore
    //   1045: invokestatic 1065	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1048: aload_1
    //   1049: getfield 1155	com/tencent/mm/modelsns/a$a:eAx	I
    //   1052: sipush 1000
    //   1055: if_icmpgt +128 -> 1183
    //   1058: iconst_1
    //   1059: istore_2
    //   1060: iload_2
    //   1061: ifne +112 -> 1173
    //   1064: ldc_w 1132
    //   1067: ldc_w 1157
    //   1070: iconst_1
    //   1071: anewarray 221	java/lang/Object
    //   1074: dup
    //   1075: iconst_0
    //   1076: aload_1
    //   1077: aastore
    //   1078: invokestatic 230	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1081: aload_1
    //   1082: getfield 1160	com/tencent/mm/modelsns/a$a:eAu	Ljava/lang/String;
    //   1085: invokestatic 90	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1088: ifne +59 -> 1147
    //   1091: aload_1
    //   1092: getfield 1160	com/tencent/mm/modelsns/a$a:eAu	Ljava/lang/String;
    //   1095: astore 4
    //   1097: aload 4
    //   1099: invokestatic 90	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1102: ifeq +101 -> 1203
    //   1105: iconst_1
    //   1106: istore_2
    //   1107: iload_2
    //   1108: ifne +39 -> 1147
    //   1111: ldc_w 1162
    //   1114: aload_1
    //   1115: getfield 1165	com/tencent/mm/modelsns/a$a:eAv	Ljava/lang/String;
    //   1118: invokevirtual 1168	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1121: ifeq +26 -> 1147
    //   1124: aload_1
    //   1125: getfield 1171	com/tencent/mm/modelsns/a$a:eAw	Ljava/lang/String;
    //   1128: invokestatic 90	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   1131: ifne +284 -> 1415
    //   1134: ldc_w 1173
    //   1137: aload_1
    //   1138: getfield 1171	com/tencent/mm/modelsns/a$a:eAw	Ljava/lang/String;
    //   1141: invokevirtual 1168	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1144: ifne +271 -> 1415
    //   1147: ldc_w 1132
    //   1150: ldc_w 1175
    //   1153: iconst_1
    //   1154: anewarray 221	java/lang/Object
    //   1157: dup
    //   1158: iconst_0
    //   1159: aload_1
    //   1160: getfield 1165	com/tencent/mm/modelsns/a$a:eAv	Ljava/lang/String;
    //   1163: aastore
    //   1164: invokestatic 1065	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1167: iconst_1
    //   1168: istore_2
    //   1169: iload_2
    //   1170: ifeq +250 -> 1420
    //   1173: iconst_1
    //   1174: istore_2
    //   1175: goto -275 -> 900
    //   1178: iconst_0
    //   1179: istore_2
    //   1180: goto -159 -> 1021
    //   1183: aload_1
    //   1184: getfield 1155	com/tencent/mm/modelsns/a$a:eAx	I
    //   1187: sipush 10500
    //   1190: if_icmplt +8 -> 1198
    //   1193: iconst_1
    //   1194: istore_2
    //   1195: goto -135 -> 1060
    //   1198: iconst_0
    //   1199: istore_2
    //   1200: goto -140 -> 1060
    //   1203: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1206: ifnonnull +148 -> 1354
    //   1209: new 1181	java/util/HashSet
    //   1212: dup
    //   1213: invokespecial 1182	java/util/HashSet:<init>	()V
    //   1216: astore 5
    //   1218: aload 5
    //   1220: putstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1223: aload 5
    //   1225: ldc_w 1184
    //   1228: invokeinterface 1187 2 0
    //   1233: pop
    //   1234: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1237: ldc_w 1189
    //   1240: invokeinterface 1187 2 0
    //   1245: pop
    //   1246: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1249: ldc_w 1191
    //   1252: invokeinterface 1187 2 0
    //   1257: pop
    //   1258: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1261: ldc_w 1193
    //   1264: invokeinterface 1187 2 0
    //   1269: pop
    //   1270: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1273: ldc_w 1195
    //   1276: invokeinterface 1187 2 0
    //   1281: pop
    //   1282: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1285: ldc_w 1197
    //   1288: invokeinterface 1187 2 0
    //   1293: pop
    //   1294: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1297: ldc_w 1199
    //   1300: invokeinterface 1187 2 0
    //   1305: pop
    //   1306: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1309: ldc_w 1201
    //   1312: invokeinterface 1187 2 0
    //   1317: pop
    //   1318: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1321: ldc_w 1203
    //   1324: invokeinterface 1187 2 0
    //   1329: pop
    //   1330: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1333: ldc_w 1205
    //   1336: invokeinterface 1187 2 0
    //   1341: pop
    //   1342: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1345: ldc_w 1207
    //   1348: invokeinterface 1187 2 0
    //   1353: pop
    //   1354: aload 4
    //   1356: invokevirtual 1210	java/lang/String:trim	()Ljava/lang/String;
    //   1359: astore 4
    //   1361: aload 4
    //   1363: ldc_w 1212
    //   1366: invokevirtual 1215	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1369: istore_2
    //   1370: iload_2
    //   1371: iflt +12 -> 1383
    //   1374: iload_2
    //   1375: aload 4
    //   1377: invokevirtual 418	java/lang/String:length	()I
    //   1380: if_icmplt +8 -> 1388
    //   1383: iconst_1
    //   1384: istore_2
    //   1385: goto -278 -> 1107
    //   1388: getstatic 1179	com/tencent/mm/modelsns/a:eAt	Ljava/util/Set;
    //   1391: aload 4
    //   1393: iload_2
    //   1394: invokevirtual 1218	java/lang/String:substring	(I)Ljava/lang/String;
    //   1397: invokeinterface 1221 2 0
    //   1402: ifne +8 -> 1410
    //   1405: iconst_1
    //   1406: istore_2
    //   1407: goto -300 -> 1107
    //   1410: iconst_0
    //   1411: istore_2
    //   1412: goto -305 -> 1107
    //   1415: iconst_0
    //   1416: istore_2
    //   1417: goto -248 -> 1169
    //   1420: iconst_0
    //   1421: istore_2
    //   1422: goto -522 -> 900
    //   1425: aload_0
    //   1426: invokespecial 963	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:cJB	()V
    //   1429: return
    //   1430: aload_0
    //   1431: getfield 56	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:byQ	Lcom/tencent/mm/sdk/platformtools/am;
    //   1434: ldc2_w 1222
    //   1437: ldc2_w 1222
    //   1440: invokevirtual 1227	com/tencent/mm/sdk/platformtools/am:S	(JJ)V
    //   1443: return
    //   1444: astore 4
    //   1446: goto -733 -> 713
    //   1449: astore 6
    //   1451: goto -809 -> 642
    //   1454: goto -1296 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1457	0	this	SendAppMessageWrapperUI
    //   0	1457	1	paramBundle	android.os.Bundle
    //   411	1011	2	i	int
    //   408	63	3	j	int
    //   89	589	4	localObject1	Object
    //   709	13	4	localObject2	Object
    //   1095	297	4	str1	String
    //   1444	1	4	localObject3	Object
    //   133	1091	5	localObject4	Object
    //   637	27	6	localException1	java.lang.Exception
    //   1449	1	6	localException2	java.lang.Exception
    //   344	256	7	str2	String
    //   351	433	8	str3	String
    //   335	234	9	localWXVideoFileObject	WXVideoFileObject
    // Exception table:
    //   from	to	target	type
    //   502	507	508	java/lang/Exception
    //   530	535	613	java/lang/Exception
    //   375	384	637	java/lang/Exception
    //   677	682	685	java/lang/Exception
    //   375	384	709	finally
    //   717	721	724	java/lang/Exception
    //   387	394	1444	finally
    //   397	409	1444	finally
    //   415	426	1444	finally
    //   429	441	1444	finally
    //   444	470	1444	finally
    //   489	495	1444	finally
    //   498	502	1444	finally
    //   645	672	1444	finally
    //   387	394	1449	java/lang/Exception
    //   397	409	1449	java/lang/Exception
    //   415	426	1449	java/lang/Exception
    //   429	441	1449	java/lang/Exception
    //   444	470	1449	java/lang/Exception
    //   489	495	1449	java/lang/Exception
    //   498	502	1449	java/lang/Exception
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.whI)
    {
      y.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
      SharedPreferences localSharedPreferences = getSharedPreferences(ae.cqR(), 0);
      setRequestedOrientation(1);
      localSharedPreferences.edit().putBoolean("settings_landscape_mode", false).commit();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    XM();
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI
 * JD-Core Version:    0.7.0.1
 */