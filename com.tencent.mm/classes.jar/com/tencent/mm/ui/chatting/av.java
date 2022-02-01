package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.y;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class av
  implements ad
{
  private static MStorageEvent<ad, Bundle> aemu;
  private MMFragment aems;
  private final Set<String> aemt;
  private a hlc;
  
  static
  {
    AppMethodBeat.i(34974);
    aemu = new MStorageEvent() {};
    AppMethodBeat.o(34974);
  }
  
  public av(a parama)
  {
    AppMethodBeat.i(34965);
    this.aemt = new HashSet();
    this.aems = parama.aezO;
    this.hlc = parama;
    AppMethodBeat.o(34965);
  }
  
  private y.a a(final WXMediaMessage paramWXMediaMessage, final com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(34972);
    paramWXMediaMessage = new y.a()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(34964);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = null;
          if (paramWXMediaMessage.getType() == 8)
          {
            if (paramWXMediaMessage.thumbData == null)
            {
              Log.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
              AppMethodBeat.o(34964);
              return;
            }
            String str = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(av.c(av.this).getContext(), paramWXMediaMessage, paramg.field_appId);
            paramAnonymousString = str;
            if (str == null)
            {
              Log.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
              AppMethodBeat.o(34964);
              return;
            }
          }
          ch.bDg().f(27, new Object[] { Integer.valueOf(1) });
          Log.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", new Object[] { paramWXMediaMessage.messageAction, paramWXMediaMessage.messageExt });
          n.a(paramWXMediaMessage, paramg.field_appId, paramg.field_appName, av.d(av.this).getTalkerUserName(), 1, paramAnonymousString);
        }
        AppMethodBeat.o(34964);
      }
    };
    AppMethodBeat.o(34972);
    return paramWXMediaMessage;
  }
  
  public static void a(av paramav)
  {
    AppMethodBeat.i(34969);
    aemu.add(paramav, null);
    AppMethodBeat.o(34969);
  }
  
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
    paramContext = paramContext.getSharedPreferences(MMApplicationContext.getTmpPreferencePath(), 0).edit();
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
  
  public static void b(av paramav)
  {
    AppMethodBeat.i(34970);
    aemu.remove(paramav);
    paramav.aemt.clear();
    b(paramav.aems.getContext(), null);
    AppMethodBeat.o(34970);
  }
  
  public static void bY(Bundle paramBundle)
  {
    AppMethodBeat.i(34966);
    aemu.event(paramBundle);
    aemu.doNotify();
    AppMethodBeat.o(34966);
  }
  
  private String t(com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(34971);
    paramg = this.aems.getString(R.l.confirm_dialog_source, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(this.aems.getContext(), paramg, null) });
    AppMethodBeat.o(34971);
    return paramg;
  }
  
  public final void bX(Bundle paramBundle)
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(34967);
    if ((this.hlc == null) || (!this.hlc.ffv))
    {
      Log.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
      AppMethodBeat.o(34967);
      return;
    }
    Object localObject2 = Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid");
    Object localObject1 = new GetMessageFromWX.Resp(paramBundle);
    paramBundle = ((GetMessageFromWX.Resp)localObject1).message;
    Object localObject4;
    Object localObject3;
    if (this.aemt.size() == 0)
    {
      localObject4 = this.aems.getContext();
      localObject3 = new HashSet();
      localObject4 = ((Context)localObject4).getSharedPreferences(MMApplicationContext.getTmpPreferencePath(), 0).getString("transactions_array_key", null);
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
      this.aemt.addAll((Collection)localObject3);
    }
    if (!this.aemt.contains(((GetMessageFromWX.Resp)localObject1).transaction))
    {
      Log.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + ((GetMessageFromWX.Resp)localObject1).transaction);
      AppMethodBeat.o(34967);
      return;
    }
    this.aemt.remove(((GetMessageFromWX.Resp)localObject1).transaction);
    b(this.aems.getContext(), this.aemt);
    localObject1 = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId = ((String)localObject2);
    Log.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = ".concat(String.valueOf(localObject2)));
    if (!as.gxn().get((IAutoDBItem)localObject1, new String[0]))
    {
      Log.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = ".concat(String.valueOf(localObject2)));
      AppMethodBeat.o(34967);
      return;
    }
    int i = paramBundle.getType();
    switch (i)
    {
    case 6: 
    default: 
      Log.e("MicroMsg.WXAppMessageReceiver", "unknown type = ".concat(String.valueOf(i)));
      i = 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        if (i == 0) {
          Log.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
        }
        AppMethodBeat.o(34967);
        return;
        localObject2 = this.aems.getController();
        localObject3 = paramBundle.description;
        t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        if (o.a((y)localObject2, (String)localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)) != null) {}
        for (i = 1;; i = 0) {
          break;
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.aems.getController();
          localObject3 = paramBundle.thumbData;
          t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
          paramBundle = o.a((y)localObject2, (byte[])localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));
          if (paramBundle != null) {
            break label654;
          }
          Log.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
        }
        for (i = k;; i = 1)
        {
          break;
          localObject2 = (WXImageObject)paramBundle.mediaObject;
          if ((((WXImageObject)localObject2).imageData != null) && (((WXImageObject)localObject2).imageData.length > 0))
          {
            localObject3 = this.aems.getController();
            localObject2 = ((WXImageObject)localObject2).imageData;
            t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
            paramBundle = o.a((y)localObject3, (byte[])localObject2, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));
            break label526;
          }
          localObject3 = this.aems.getController();
          localObject2 = ((WXImageObject)localObject2).imagePath;
          t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
          paramBundle = o.b((y)localObject3, (String)localObject2, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));
          break label526;
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.aems.getController();
          localObject3 = paramBundle.title;
          t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        }
        for (paramBundle = o.a((y)localObject2, (String)localObject3, false, 2, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));; paramBundle = o.a((y)localObject2, i, (String)localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)))
        {
          i = j;
          if (paramBundle != null) {
            break;
          }
          i = 0;
          break;
          localObject2 = this.aems.getController();
          i = R.k.app_attach_file_icon_music;
          localObject3 = paramBundle.title;
          t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.aems.getController();
          localObject3 = paramBundle.title;
          t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        }
        for (paramBundle = o.a((y)localObject2, (String)localObject3, false, 1, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));; paramBundle = o.a((y)localObject2, i, (String)localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)))
        {
          i = j;
          if (paramBundle != null) {
            break;
          }
          i = 0;
          break;
          localObject2 = this.aems.getController();
          i = R.k.app_attach_file_icon_video;
          localObject3 = paramBundle.title;
          t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        }
        localObject2 = this.aems.getController();
        localObject3 = paramBundle.title;
        localObject4 = paramBundle.description;
        t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
        i = j;
        if (o.a((y)localObject2, (String)localObject3, (String)localObject4, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)) == null) {
          i = 0;
        }
      }
    case 7: 
      label526:
      if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
      {
        localObject2 = this.aems.getController();
        localObject3 = paramBundle.title;
        t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
      }
      label654:
      for (paramBundle = o.a((y)localObject2, (String)localObject3, false, 0, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));; paramBundle = o.a((y)localObject2, i, (String)localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)))
      {
        i = j;
        if (paramBundle != null) {
          break;
        }
        i = 0;
        break;
        localObject2 = this.aems.getController();
        i = R.k.app_attach_file_icon_webpage;
        localObject3 = paramBundle.title;
        t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
      }
    }
    if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
    {
      localObject2 = this.aems.getController();
      localObject3 = paramBundle.thumbData;
      t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
    }
    for (paramBundle = o.a((y)localObject2, (byte[])localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1));; paramBundle = o.a((y)localObject2, i, (String)localObject3, false, a(paramBundle, (com.tencent.mm.pluginsdk.model.app.g)localObject1)))
    {
      i = j;
      if (paramBundle != null) {
        break;
      }
      i = 0;
      break;
      localObject2 = this.aems.getController();
      i = R.k.app_attach_file_icon_webpage;
      localObject3 = paramBundle.title;
      t((com.tencent.mm.pluginsdk.model.app.g)localObject1);
    }
  }
  
  public final boolean pX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(34968);
    Log.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + paramString1 + ", openId = " + paramString2);
    GetMessageFromWX.Req localReq = new GetMessageFromWX.Req();
    localReq.username = this.hlc.getTalkerUserName();
    localReq.transaction = com.tencent.mm.b.g.getMessageDigest(Util.nowMilliSecond().getBytes());
    localReq.openId = paramString2;
    localReq.lang = LocaleUtil.loadApplicationLanguage(this.aems.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.aems.getContext());
    bh.bCz();
    localReq.country = ((String)c.ban().d(274436, null));
    paramString2 = new Bundle();
    localReq.toBundle(paramString2);
    u.bS(paramString2);
    u.bT(paramString2);
    MMessageActV2.Args localArgs = new MMessageActV2.Args();
    localArgs.targetPkgName = paramString1;
    localArgs.bundle = paramString2;
    boolean bool = MMessageActV2.send(this.aems.getContext(), localArgs);
    this.aemt.add(localReq.transaction);
    b(this.aems.getContext(), this.aemt);
    AppMethodBeat.o(34968);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.av
 * JD-Core Version:    0.7.0.1
 */