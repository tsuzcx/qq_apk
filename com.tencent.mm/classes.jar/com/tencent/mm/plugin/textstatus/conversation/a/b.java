package com.tencent.mm.plugin.textstatus.conversation.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.a.b;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.plugin.textstatus.conversation.d.g;
import com.tencent.mm.plugin.textstatus.conversation.ui.TextStatusConversationFragment;
import com.tencent.mm.plugin.textstatus.h.f.h;
import com.tencent.mm.plugin.textstatus.ui.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusConversationClickListener;", "Lkotlin/Function3;", "Landroid/view/View;", "", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "", "fragment", "Lcom/tencent/mm/plugin/textstatus/conversation/ui/TextStatusConversationFragment;", "(Lcom/tencent/mm/plugin/textstatus/conversation/ui/TextStatusConversationFragment;)V", "invoke", "view", "position", "item", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements q<View, Integer, com.tencent.mm.plugin.textstatus.conversation.d.a, ah>
{
  public static final b.a Tio;
  private final TextStatusConversationFragment Tip;
  
  static
  {
    AppMethodBeat.i(290882);
    Tio = new b.a((byte)0);
    AppMethodBeat.o(290882);
  }
  
  public b(TextStatusConversationFragment paramTextStatusConversationFragment)
  {
    AppMethodBeat.i(290874);
    this.Tip = paramTextStatusConversationFragment;
    AppMethodBeat.o(290874);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusConversationClickListener$invoke$2", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "onChattingUIEnter", "", "onChattingUIExit", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a.b
  {
    b(com.tencent.mm.plugin.textstatus.conversation.d.a parama, b paramb, View paramView) {}
    
    public final void aNV()
    {
      AppMethodBeat.i(290920);
      Log.i("MicroMsg.TextStatus.TextStatusConversationClickListener", "onChattingUIEnter");
      Object localObject1 = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
      String str = this.Tiq.field_sessionId;
      localObject1 = (CharSequence)str;
      int i;
      Object localObject2;
      label81:
      StringBuilder localStringBuilder;
      if ((localObject1 == null) || (n.bp((CharSequence)localObject1)))
      {
        i = 1;
        if (i == 0)
        {
          localObject2 = com.tencent.mm.plugin.textstatus.conversation.g.a.bdK(str);
          if (localObject2 != null)
          {
            localObject1 = (CharSequence)((h)localObject2).field_nickname;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label292;
            }
            i = 1;
            if (i == 0)
            {
              localObject1 = (CharSequence)((h)localObject2).field_smallHeadImgUrl;
              if (localObject1 != null) {
                ((CharSequence)localObject1).length();
              }
            }
          }
          localStringBuilder = new StringBuilder("[checkContactExpired] isNeedGetContact=true sessionId=").append(str).append(" nickname=");
          if (localObject2 != null) {
            break label297;
          }
          localObject1 = null;
          label131:
          localStringBuilder = localStringBuilder.append(localObject1).append(" avatar=");
          if (localObject2 != null) {
            break label305;
          }
        }
      }
      label292:
      label297:
      label305:
      for (localObject1 = null;; localObject1 = ((h)localObject2).field_smallHeadImgUrl)
      {
        Log.i("MicroMsg.TextStatus.TextStatusContactService", localObject1);
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.hGM().bdP(str).field_talker;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        Log.i("MicroMsg.TextStatus.TextStatusContactService", s.X("[checkContactExpired] talker=", localObject1));
        com.tencent.mm.plugin.textstatus.conversation.g.a.a(v.Y(str, localObject1), null, false, 14);
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.hGL();
        localObject2 = this.Tiq.field_sessionId;
        s.s(localObject2, "item.field_sessionId");
        ((com.tencent.mm.plugin.textstatus.conversation.h.a)localObject1).aAB((String)localObject2);
        if (b.a(this.Tir).getActivity() != null)
        {
          localObject1 = this.Tiq;
          localObject2 = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
          localObject1 = ((com.tencent.mm.plugin.textstatus.conversation.d.a)localObject1).field_sessionId;
          s.s(localObject1, "item.field_sessionId");
          f.a.hp((String)localObject1, 53);
        }
        AppMethodBeat.o(290920);
        return;
        i = 0;
        break;
        i = 0;
        break label81;
        localObject1 = ((h)localObject2).field_nickname;
        break label131;
      }
    }
    
    public final boolean aNW()
    {
      AppMethodBeat.i(290929);
      Log.i("MicroMsg.TextStatus.TextStatusConversationClickListener", "onChattingUIExit");
      com.tencent.mm.ae.d.a(0L, (Runnable)new com.tencent.mm.ui.anim.c.a(this.$view));
      Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.hGL();
      Object localObject2 = this.Tiq.field_sessionId;
      s.s(localObject2, "item.field_sessionId");
      ((com.tencent.mm.plugin.textstatus.conversation.h.a)localObject1).aAB((String)localObject2);
      localObject1 = b.a(this.Tir).getActivity();
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        com.tencent.mm.plugin.textstatus.b.f.hGU();
        localObject2 = k.aeZF;
        ((l)k.nq((Context)localObject1).q(l.class)).aoz(1);
      }
      AppMethodBeat.o(290929);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.a.b
 * JD-Core Version:    0.7.0.1
 */