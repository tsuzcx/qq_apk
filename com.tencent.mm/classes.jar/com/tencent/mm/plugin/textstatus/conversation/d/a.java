package com.tencent.mm.plugin.textstatus.conversation.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.h.f.h;
import com.tencent.mm.plugin.textstatus.j.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusConversation;", "()V", "contact", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContact;", "getContact", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContact;", "setContact", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContact;)V", "nickname", "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "nicknameSpan", "", "getNicknameSpan", "()Ljava/lang/CharSequence;", "setNicknameSpan", "(Ljava/lang/CharSequence;)V", "reportTag", "getReportTag", "setReportTag", "equals", "", "other", "", "getContentSpan", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "hashCode", "", "isTopPlace", "prepare", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  public static final a.a TiP;
  private static final IAutoDBItem.MAutoDBInfo info;
  public CharSequence AFy;
  private h TiQ;
  public String TiR;
  public String nickname;
  
  static
  {
    AppMethodBeat.i(290945);
    TiP = new a.a((byte)0);
    info = b.aJm();
    AppMethodBeat.o(290945);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      bool1 = bool2;
      if (((a)paramObject).systemRowid == this.systemRowid) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(290954);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(290954);
    return localMAutoDBInfo;
  }
  
  public final int hashCode()
  {
    return (int)this.systemRowid;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(290966);
    if (s.p(this.field_sessionId, "textstatussayhisessionholder"))
    {
      this.nickname = MMApplicationContext.getContext().getString(a.h.TgL);
      this.AFy = ((CharSequence)this.nickname);
      AppMethodBeat.o(290966);
      return;
    }
    Object localObject = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
    this.TiQ = com.tencent.mm.plugin.textstatus.conversation.g.a.bdK(this.field_sessionId);
    localObject = this.TiQ;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((h)localObject).field_nickname)
    {
      this.nickname = ((String)localObject);
      this.AFy = ((CharSequence)p.b(MMApplicationContext.getContext(), (CharSequence)this.nickname));
      AppMethodBeat.o(290966);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.d.a
 * JD-Core Version:    0.7.0.1
 */