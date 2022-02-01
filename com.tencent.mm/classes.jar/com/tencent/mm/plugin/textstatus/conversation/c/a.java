package com.tencent.mm.plugin.textstatus.conversation.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.af.b;
import com.tencent.mm.modelmulti.t.a;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.byp.c.c;
import com.tencent.mm.plugin.byp.c.e;
import com.tencent.mm.plugin.byp.c.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.textstatus.conversation.f.d;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/config/TextStatusPrivateMsgConfig;", "Lcom/tencent/mm/plugin/byp/config/IPrivateMsgConfig;", "()V", "conversationUpdater", "Lcom/tencent/mm/plugin/textstatus/conversation/middler/TextStatusConversationUpdater;", "getConversationUpdater", "()Lcom/tencent/mm/plugin/textstatus/conversation/middler/TextStatusConversationUpdater;", "conversationUpdater$delegate", "Lkotlin/Lazy;", "getContactInterceptor", "Lcom/tencent/mm/plugin/textstatus/conversation/middler/TextStatusGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/textstatus/conversation/middler/TextStatusGetContactInterceptor;", "getContactInterceptor$delegate", "sendMsgInterceptor", "Lcom/tencent/mm/plugin/textstatus/conversation/config/TextStatusPrivateMsgConfig$TextStatusCreateSendMsgInterceptor;", "getSendMsgInterceptor", "()Lcom/tencent/mm/plugin/textstatus/conversation/config/TextStatusPrivateMsgConfig$TextStatusCreateSendMsgInterceptor;", "sendMsgInterceptor$delegate", "getAvatarInterceptors", "Landroid/util/Pair;", "", "", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "getContactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "getConversationUpdateCallback", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "getICreateSendMsgInterceptor", "Lcom/tencent/mm/plugin/byp/config/IPrivateMsgConfig$ICreateSendMsgInterceptor;", "getSyncHandler", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "name", "TextStatusCreateSendMsgInterceptor", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  implements e
{
  private final j AGW;
  private final j AGX;
  private final j AGY;
  
  public a()
  {
    AppMethodBeat.i(290843);
    this.AGW = k.cm((kotlin.g.a.a)a.b.TiM);
    this.AGX = k.cm((kotlin.g.a.a)a.d.TiO);
    this.AGY = k.cm((kotlin.g.a.a)a.c.TiN);
    AppMethodBeat.o(290843);
  }
  
  public final i dit()
  {
    AppMethodBeat.i(290852);
    i locali = (i)this.AGW.getValue();
    AppMethodBeat.o(290852);
    return locali;
  }
  
  public final bx.a diu()
  {
    AppMethodBeat.i(290856);
    Object localObject = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
    localObject = com.tencent.mm.plugin.textstatus.conversation.g.a.diu();
    AppMethodBeat.o(290856);
    return localObject;
  }
  
  public final List<com.tencent.mm.plugin.byp.a.a> div()
  {
    AppMethodBeat.i(290863);
    List localList = kotlin.a.p.listOf(new d());
    AppMethodBeat.o(290863);
    return localList;
  }
  
  public final e.a diw()
  {
    AppMethodBeat.i(290867);
    e.a locala = (e.a)this.AGX.getValue();
    AppMethodBeat.o(290867);
    return locala;
  }
  
  public final af.b dix()
  {
    AppMethodBeat.i(290871);
    af.b localb = (af.b)this.AGY.getValue();
    AppMethodBeat.o(290871);
    return localb;
  }
  
  public final Pair<List<String>, j.a> diy()
  {
    AppMethodBeat.i(290876);
    Object localObject = kotlin.a.p.listOf("@statussquaremsg");
    j.a locala = com.tencent.mm.pluginsdk.ui.a.b.iKa();
    if ((locala instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      localObject = new Pair(localObject, new com.tencent.mm.plugin.textstatus.conversation.f.a(((com.tencent.mm.pluginsdk.ui.b)locala).XXP));
      AppMethodBeat.o(290876);
      return localObject;
    }
    AppMethodBeat.o(290876);
    return null;
  }
  
  public final String name()
  {
    return "MicroMsg.TextStatus.TextStatusMsgConfig";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/config/TextStatusPrivateMsgConfig$TextStatusCreateSendMsgInterceptor;", "Lcom/tencent/mm/plugin/byp/config/BaseSendMsgInterceptors;", "()V", "checkIfYourFile", "", "params", "Lcom/tencent/mm/modelmulti/SendMsgCgiFactory$SendMsgParams;", "createEmojiCgi", "Lcom/tencent/mm/modelmulti/SendMsgCgiFactory$BuildResult;", "getBizType", "", "getSenderBySessionId", "", "sessionId", "getTalkerBySessionId", "support", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends c
  {
    public final String akk(String paramString)
    {
      AppMethodBeat.i(290848);
      s.u(paramString, "sessionId");
      paramString = ((com.tencent.mm.plugin.textstatus.a.t)h.ax(com.tencent.mm.plugin.textstatus.a.t.class)).aAw(paramString);
      s.s(paramString, "service(ITextStatusSessi…alkerFromLocal(sessionId)");
      AppMethodBeat.o(290848);
      return paramString;
    }
    
    public final String akl(String paramString)
    {
      AppMethodBeat.i(290851);
      s.u(paramString, "sessionId");
      paramString = ((com.tencent.mm.plugin.textstatus.a.t)h.ax(com.tencent.mm.plugin.textstatus.a.t.class)).hFy();
      s.s(paramString, "service(ITextStatusSessi…tSessionSender(sessionId)");
      AppMethodBeat.o(290851);
      return paramString;
    }
    
    public final boolean b(t.e parame)
    {
      AppMethodBeat.i(290869);
      s.u(parame, "params");
      if (((parame instanceof com.tencent.mm.modelimage.t)) && (at.bvO(((com.tencent.mm.modelimage.t)parame).fileName)))
      {
        AppMethodBeat.o(290869);
        return true;
      }
      AppMethodBeat.o(290869);
      return false;
    }
    
    public final int dis()
    {
      return 4;
    }
    
    public final t.a f(t.e parame)
    {
      AppMethodBeat.i(290859);
      t.a locala = new t.a();
      if ((parame instanceof com.tencent.mm.plugin.emoji.a))
      {
        String str1 = ((com.tencent.mm.plugin.emoji.a)parame).toUser;
        Object localObject = (com.tencent.mm.plugin.emoji.a)parame;
        s.s(str1, "sessionId");
        ((t.e)localObject).toUser = akk(str1);
        ((com.tencent.mm.plugin.emoji.a)parame).hQQ = akl(str1);
        localObject = ((com.tencent.mm.plugin.emoji.a)parame).hQQ;
        s.s(localObject, "params.fromUser");
        String str2 = ((com.tencent.mm.plugin.emoji.a)parame).toUser;
        s.s(str2, "params.toUser");
        EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.a)parame).mgK;
        s.s(localEmojiInfo, "params.emojiInfo");
        locala.hEi = ((com.tencent.mm.am.p)new com.tencent.mm.plugin.byp.b.b(4, str1, (String)localObject, str2, localEmojiInfo, ((com.tencent.mm.plugin.emoji.a)parame).msgId));
      }
      AppMethodBeat.o(290859);
      return locala;
    }
    
    public final boolean g(t.e parame)
    {
      AppMethodBeat.i(290840);
      s.checkNotNull(parame);
      if ((au.bwY(parame.toUser)) || (b(parame)))
      {
        AppMethodBeat.o(290840);
        return true;
      }
      AppMethodBeat.o(290840);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.c.a
 * JD-Core Version:    0.7.0.1
 */