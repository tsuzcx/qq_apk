package com.tencent.mm.plugin.textstatus.conversation.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.j.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusGreetingItem;", "()V", "btnText", "", "getBtnText", "()Ljava/lang/String;", "setBtnText", "(Ljava/lang/String;)V", "canChatting", "", "getCanChatting", "()Z", "setCanChatting", "(Z)V", "descText", "getDescText", "setDescText", "nickName", "getNickName", "setNickName", "reportTag", "getReportTag", "setReportTag", "showHeaderType", "", "getShowHeaderType", "()I", "setShowHeaderType", "(I)V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "prepare", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c
{
  public static final d.a TiW;
  private static final IAutoDBItem.MAutoDBInfo info;
  public String TiR;
  private String TiX;
  public int TiY;
  
  static
  {
    AppMethodBeat.i(290957);
    TiW = new d.a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = c.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(BaseTextS…GreetingItem::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(290957);
  }
  
  public d()
  {
    AppMethodBeat.i(290933);
    String str = MMApplicationContext.getContext().getString(a.h.TgD);
    s.s(str, "getContext().getString(R…xt_status_greeting_check)");
    this.TiX = str;
    this.TiR = "";
    AppMethodBeat.o(290933);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.d.d
 * JD-Core Version:    0.7.0.1
 */