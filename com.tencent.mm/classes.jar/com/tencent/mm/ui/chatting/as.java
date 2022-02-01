package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cb;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.s;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class as
  implements ab
{
  private static l<ab, Bundle> JZN;
  private MMFragment JZL;
  private final Set<String> JZM;
  private a cXJ;
  
  static
  {
    AppMethodBeat.i(34974);
    JZN = new l() {};
    AppMethodBeat.o(34974);
  }
  
  public as(a parama)
  {
    AppMethodBeat.i(34965);
    this.JZM = new HashSet();
    this.JZL = parama.Kkd;
    this.cXJ = parama;
    AppMethodBeat.o(34965);
  }
  
  private y.a a(final WXMediaMessage paramWXMediaMessage, final com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(34972);
    paramWXMediaMessage = new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(34964);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = null;
          if (paramWXMediaMessage.getType() == 8)
          {
            if (paramWXMediaMessage.thumbData == null)
            {
              ae.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
              AppMethodBeat.o(34964);
              return;
            }
            String str = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(as.c(as.this).getContext(), paramWXMediaMessage, paramg.field_appId);
            paramAnonymousString = str;
            if (str == null)
            {
              ae.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
              AppMethodBeat.o(34964);
              return;
            }
          }
          cb.aCN().d(27, new Object[] { Integer.valueOf(1) });
          ae.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", new Object[] { paramWXMediaMessage.messageAction, paramWXMediaMessage.messageExt });
          m.a(paramWXMediaMessage, paramg.field_appId, paramg.field_appName, as.d(as.this).getTalkerUserName(), 1, paramAnonymousString);
        }
        AppMethodBeat.o(34964);
      }
    };
    AppMethodBeat.o(34972);
    return paramWXMediaMessage;
  }
  
  public static void a(as paramas)
  {
    AppMethodBeat.i(34969);
    JZN.a(paramas, null);
    AppMethodBeat.o(34969);
  }
  
  @TargetApi(9)
  private static void b(Context paramContext, Set<String> paramSet)
  {
    AppMethodBeat.i(34973);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSet != null)
    {
      localObject1 = localObject2;
      if (paramSet.size() > 0)
      {
        localObject1 = new StringBuilder();
        paramSet = paramSet.iterator();
        while (paramSet.hasNext())
        {
          ((StringBuilder)localObject1).append((String)paramSet.next());
          ((StringBuilder)localObject1).append(";");
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramContext = paramContext.getSharedPreferences(ak.foz(), 0).edit();
    paramContext.putString("transactions_array_key", (String)localObject1);
    if (Build.VERSION.SDK_INT > 8)
    {
      paramContext.apply();
      AppMethodBeat.o(34973);
      return;
    }
    paramContext.commit();
    AppMethodBeat.o(34973);
  }
  
  public static void b(as paramas)
  {
    AppMethodBeat.i(34970);
    JZN.remove(paramas);
    paramas.JZM.clear();
    b(paramas.JZL.getContext(), null);
    AppMethodBeat.o(34970);
  }
  
  public static void bi(Bundle paramBundle)
  {
    AppMethodBeat.i(34966);
    JZN.dW(paramBundle);
    JZN.doNotify();
    AppMethodBeat.o(34966);
  }
  
  private String s(com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(34971);
    paramg = this.JZL.getString(2131757563, new Object[] { h.a(this.JZL.getContext(), paramg, null) });
    AppMethodBeat.o(34971);
    return paramg;
  }
  
  public final void bh(Bundle paramBundle)
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(34967);
    if ((this.cXJ == null) || (!this.cXJ.cCq))
    {
      ae.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
      AppMethodBeat.o(34967);
      return;
    }
    Object localObject2 = Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid");
    Object localObject1 = new GetMessageFromWX.Resp(paramBundle);
    paramBundle = ((GetMessageFromWX.Resp)localObject1).message;
    Object localObject4;
    Object localObject3;
    if (this.JZM.size() == 0)
    {
      localObject4 = this.JZL.getContext();
      localObject3 = new HashSet();
      localObject4 = ((Context)localObject4).getSharedPreferences(ak.foz(), 0).getString("transactions_array_key", null);
      if ((localObject4 != null) && (((String)localObject4).length() > 0))
      {
        localObject4 = ((String)localObject4).split(";");
        int m = localObject4.length;
        i = 0;
        while (i < m)
        {
          ((Set)localObject3).add(localObject4[i]);
          i += 1;
        }
      }
      this.JZM.addAll((Collection)localObject3);
    }
    if (!this.JZM.contains(((GetMessageFromWX.Resp)localObject1).transaction))
    {
      ae.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + ((GetMessageFromWX.Resp)localObject1).transaction);
      AppMethodBeat.o(34967);
      return;
    }
    this.JZM.remove(((GetMessageFromWX.Resp)localObject1).transaction);
    b(this.JZL.getContext(), this.JZM);
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((String)localObject2);
    ae.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = ".concat(String.valueOf(localObject2)));
    if (!ao.dBg().get((com.tencent.mm.sdk.e.c)localObject1, new String[0]))
    {
      ae.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = ".concat(String.valueOf(localObject2)));
      AppMethodBeat.o(34967);
      return;
    }
    int i = paramBundle.getType();
    switch (i)
    {
    case 6: 
    default: 
      ae.e("MicroMsg.WXAppMessageReceiver", "unknown type = ".concat(String.valueOf(i)));
      i = 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        if (i == 0) {
          ae.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
        }
        AppMethodBeat.o(34967);
        return;
        localObject2 = this.JZL.getController();
        localObject3 = paramBundle.description;
        s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        if (o.a((s)localObject2, (String)localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)) != null) {}
        for (i = 1;; i = 0) {
          break;
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.JZL.getController();
          localObject3 = paramBundle.thumbData;
          s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
          paramBundle = o.a((s)localObject2, (byte[])localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));
          if (paramBundle != null) {
            break label654;
          }
          ae.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
        }
        for (i = k;; i = 1)
        {
          break;
          localObject2 = (WXImageObject)paramBundle.mediaObject;
          if ((((WXImageObject)localObject2).imageData != null) && (((WXImageObject)localObject2).imageData.length > 0))
          {
            localObject3 = this.JZL.getController();
            localObject2 = ((WXImageObject)localObject2).imageData;
            s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
            paramBundle = o.a((s)localObject3, (byte[])localObject2, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));
            break label526;
          }
          localObject3 = this.JZL.getController();
          localObject2 = ((WXImageObject)localObject2).imagePath;
          s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
          paramBundle = o.b((s)localObject3, (String)localObject2, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));
          break label526;
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.JZL.getController();
          localObject3 = paramBundle.title;
          s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        }
        for (paramBundle = o.a((s)localObject2, (String)localObject3, false, 2, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));; paramBundle = o.a((s)localObject2, 2131689564, (String)localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)))
        {
          i = j;
          if (paramBundle != null) {
            break;
          }
          i = 0;
          break;
          localObject2 = this.JZL.getController();
          localObject3 = paramBundle.title;
          s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.JZL.getController();
          localObject3 = paramBundle.title;
          s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        }
        for (paramBundle = o.a((s)localObject2, (String)localObject3, false, 1, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));; paramBundle = o.a((s)localObject2, 2131689581, (String)localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)))
        {
          i = j;
          if (paramBundle != null) {
            break;
          }
          i = 0;
          break;
          localObject2 = this.JZL.getController();
          localObject3 = paramBundle.title;
          s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        }
        localObject2 = this.JZL.getController();
        localObject3 = paramBundle.title;
        localObject4 = paramBundle.description;
        s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        i = j;
        if (o.a((s)localObject2, (String)localObject3, (String)localObject4, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)) == null) {
          i = 0;
        }
      }
    case 7: 
      label526:
      if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
      {
        localObject2 = this.JZL.getController();
        localObject3 = paramBundle.title;
        s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
      }
      label654:
      for (paramBundle = o.a((s)localObject2, (String)localObject3, false, 0, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));; paramBundle = o.a((s)localObject2, 2131689584, (String)localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)))
      {
        i = j;
        if (paramBundle != null) {
          break;
        }
        i = 0;
        break;
        localObject2 = this.JZL.getController();
        localObject3 = paramBundle.title;
        s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
      }
    }
    if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
    {
      localObject2 = this.JZL.getController();
      localObject3 = paramBundle.thumbData;
      s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
    }
    for (paramBundle = o.a((s)localObject2, (byte[])localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));; paramBundle = o.a((s)localObject2, 2131689584, (String)localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)))
    {
      i = j;
      if (paramBundle != null) {
        break;
      }
      i = 0;
      break;
      localObject2 = this.JZL.getController();
      localObject3 = paramBundle.title;
      s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
    }
  }
  
  public final boolean mr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(34968);
    ae.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + paramString1 + ", openId = " + paramString2);
    GetMessageFromWX.Req localReq = new GetMessageFromWX.Req();
    localReq.username = this.cXJ.getTalkerUserName();
    localReq.transaction = com.tencent.mm.b.g.getMessageDigest(bu.fpO().getBytes());
    localReq.openId = paramString2;
    paramString2 = this.JZL.getSharedPreferences(ak.fow(), 0);
    this.JZL.getContext();
    localReq.lang = ad.f(paramString2);
    bc.aCg();
    localReq.country = ((String)com.tencent.mm.model.c.ajA().get(274436, null));
    paramString2 = new Bundle();
    localReq.toBundle(paramString2);
    q.bc(paramString2);
    q.bd(paramString2);
    MMessageActV2.Args localArgs = new MMessageActV2.Args();
    localArgs.targetPkgName = paramString1;
    localArgs.bundle = paramString2;
    boolean bool = MMessageActV2.send(this.JZL.getContext(), localArgs);
    this.JZM.add(localReq.transaction);
    b(this.JZL.getContext(), this.JZM);
    AppMethodBeat.o(34968);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.as
 * JD-Core Version:    0.7.0.1
 */