package com.tencent.mm.plugin.story.model.f;

import a.f.a.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
final class d$b
  implements k.a
{
  d$b(d paramd) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(109393);
    ab.i(d.access$getTAG$cp(), "chatRoomStgListener ".concat(String.valueOf(paramString)));
    if ((!d.i(this.szL)) && (j.e(paramString, d.a(this.szL)))) {
      b.a("StoryStateFetcher_updateChatRoom", (a)new d.b.1(this));
    }
    AppMethodBeat.o(109393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.d.b
 * JD-Core Version:    0.7.0.1
 */