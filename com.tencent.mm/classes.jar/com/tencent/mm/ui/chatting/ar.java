package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.by;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.s;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ar
  implements aa
{
  private static l<aa, Bundle> HRg;
  private MMFragment HRe;
  private final Set<String> HRf;
  private a cLy;
  
  static
  {
    AppMethodBeat.i(34974);
    HRg = new l() {};
    AppMethodBeat.o(34974);
  }
  
  public ar(a parama)
  {
    AppMethodBeat.i(34965);
    this.HRf = new HashSet();
    this.HRe = parama.HZF;
    this.cLy = parama;
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
              ac.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
              AppMethodBeat.o(34964);
              return;
            }
            String str = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(ar.c(ar.this).getContext(), paramWXMediaMessage, paramg.field_appId);
            paramAnonymousString = str;
            if (str == null)
            {
              ac.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
              AppMethodBeat.o(34964);
              return;
            }
          }
          by.azu().d(27, new Object[] { Integer.valueOf(1) });
          ac.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", new Object[] { paramWXMediaMessage.messageAction, paramWXMediaMessage.messageExt });
          m.a(paramWXMediaMessage, paramg.field_appId, paramg.field_appName, ar.d(ar.this).getTalkerUserName(), 1, paramAnonymousString);
        }
        AppMethodBeat.o(34964);
      }
    };
    AppMethodBeat.o(34972);
    return paramWXMediaMessage;
  }
  
  public static void a(ar paramar)
  {
    AppMethodBeat.i(34969);
    HRg.a(paramar, null);
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
    paramContext = paramContext.getSharedPreferences(ai.eVa(), 0).edit();
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
  
  public static void b(ar paramar)
  {
    AppMethodBeat.i(34970);
    HRg.remove(paramar);
    paramar.HRf.clear();
    b(paramar.HRe.getContext(), null);
    AppMethodBeat.o(34970);
  }
  
  public static void bc(Bundle paramBundle)
  {
    AppMethodBeat.i(34966);
    HRg.dS(paramBundle);
    HRg.doNotify();
    AppMethodBeat.o(34966);
  }
  
  private String s(com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(34971);
    paramg = this.HRe.getString(2131757563, new Object[] { h.a(this.HRe.getContext(), paramg, null) });
    AppMethodBeat.o(34971);
    return paramg;
  }
  
  public final void bb(Bundle paramBundle)
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(34967);
    if ((this.cLy == null) || (!this.cLy.cqM))
    {
      ac.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
      AppMethodBeat.o(34967);
      return;
    }
    Object localObject2 = Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid");
    Object localObject1 = new GetMessageFromWX.Resp(paramBundle);
    paramBundle = ((GetMessageFromWX.Resp)localObject1).message;
    Object localObject4;
    Object localObject3;
    if (this.HRf.size() == 0)
    {
      localObject4 = this.HRe.getContext();
      localObject3 = new HashSet();
      localObject4 = ((Context)localObject4).getSharedPreferences(ai.eVa(), 0).getString("transactions_array_key", null);
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
      this.HRf.addAll((Collection)localObject3);
    }
    if (!this.HRf.contains(((GetMessageFromWX.Resp)localObject1).transaction))
    {
      ac.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + ((GetMessageFromWX.Resp)localObject1).transaction);
      AppMethodBeat.o(34967);
      return;
    }
    this.HRf.remove(((GetMessageFromWX.Resp)localObject1).transaction);
    b(this.HRe.getContext(), this.HRf);
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((String)localObject2);
    ac.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = ".concat(String.valueOf(localObject2)));
    if (!ap.dny().get((com.tencent.mm.sdk.e.c)localObject1, new String[0]))
    {
      ac.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = ".concat(String.valueOf(localObject2)));
      AppMethodBeat.o(34967);
      return;
    }
    int i = paramBundle.getType();
    switch (i)
    {
    case 6: 
    default: 
      ac.e("MicroMsg.WXAppMessageReceiver", "unknown type = ".concat(String.valueOf(i)));
      i = 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        if (i == 0) {
          ac.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
        }
        AppMethodBeat.o(34967);
        return;
        localObject2 = this.HRe.getController();
        localObject3 = paramBundle.description;
        s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        if (o.a((s)localObject2, (String)localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)) != null) {}
        for (i = 1;; i = 0) {
          break;
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.HRe.getController();
          localObject3 = paramBundle.thumbData;
          s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
          paramBundle = o.a((s)localObject2, (byte[])localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));
          if (paramBundle != null) {
            break label654;
          }
          ac.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
        }
        for (i = k;; i = 1)
        {
          break;
          localObject2 = (WXImageObject)paramBundle.mediaObject;
          if ((((WXImageObject)localObject2).imageData != null) && (((WXImageObject)localObject2).imageData.length > 0))
          {
            localObject3 = this.HRe.getController();
            localObject2 = ((WXImageObject)localObject2).imageData;
            s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
            paramBundle = o.a((s)localObject3, (byte[])localObject2, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));
            break label526;
          }
          localObject3 = this.HRe.getController();
          localObject2 = ((WXImageObject)localObject2).imagePath;
          s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
          paramBundle = o.b((s)localObject3, (String)localObject2, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));
          break label526;
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.HRe.getController();
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
          localObject2 = this.HRe.getController();
          localObject3 = paramBundle.title;
          s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.HRe.getController();
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
          localObject2 = this.HRe.getController();
          localObject3 = paramBundle.title;
          s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        }
        localObject2 = this.HRe.getController();
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
        localObject2 = this.HRe.getController();
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
        localObject2 = this.HRe.getController();
        localObject3 = paramBundle.title;
        s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
      }
    }
    if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
    {
      localObject2 = this.HRe.getController();
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
      localObject2 = this.HRe.getController();
      localObject3 = paramBundle.title;
      s((com.tencent.mm.pluginsdk.model.app.g)localObject1);
    }
  }
  
  public final boolean lM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(34968);
    ac.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + paramString1 + ", openId = " + paramString2);
    GetMessageFromWX.Req localReq = new GetMessageFromWX.Req();
    localReq.username = this.cLy.getTalkerUserName();
    localReq.transaction = com.tencent.mm.b.g.getMessageDigest(bs.eWj().getBytes());
    localReq.openId = paramString2;
    paramString2 = this.HRe.getSharedPreferences(ai.eUX(), 0);
    this.HRe.getContext();
    localReq.lang = ab.f(paramString2);
    az.ayM();
    localReq.country = ((String)com.tencent.mm.model.c.agA().get(274436, null));
    paramString2 = new Bundle();
    localReq.toBundle(paramString2);
    q.aW(paramString2);
    q.aX(paramString2);
    MMessageActV2.Args localArgs = new MMessageActV2.Args();
    localArgs.targetPkgName = paramString1;
    localArgs.bundle = paramString2;
    boolean bool = MMessageActV2.send(this.HRe.getContext(), localArgs);
    this.HRf.add(localReq.transaction);
    b(this.HRe.getContext(), this.HRf);
    AppMethodBeat.o(34968);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ar
 * JD-Core Version:    0.7.0.1
 */