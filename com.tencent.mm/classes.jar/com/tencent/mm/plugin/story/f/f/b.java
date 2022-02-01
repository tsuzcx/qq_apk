package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "username", "", "(Ljava/lang/String;)V", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "hasStory", "", "hasUnread", "isInBlackList", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1;", "checkStoryUnread", "destroy", "", "notifyListener", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pause", "registerNotifyListener", "resume", "start", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.l, k.a
{
  private static final String TAG = "MicroMsg.SingleUserStateFetcher";
  public static final b.a zvI;
  private final String username;
  private boolean vJc;
  private l.a zvD;
  private f zvE;
  private boolean zvF;
  private boolean zvG;
  private final c zvH;
  
  static
  {
    AppMethodBeat.i(119041);
    zvI = new b.a((byte)0);
    TAG = "MicroMsg.SingleUserStateFetcher";
    AppMethodBeat.o(119041);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(119040);
    this.username = paramString;
    this.zvH = new c(this);
    AppMethodBeat.o(119040);
  }
  
  private final void dHn()
  {
    AppMethodBeat.i(119039);
    ac.i(TAG, "notifyListener: " + this.vJc + ' ' + this.zvF);
    com.tencent.mm.ac.c.g((d.g.a.a)new b(this));
    AppMethodBeat.o(119039);
  }
  
  public final void a(l.a parama)
  {
    this.zvD = parama;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(119038);
    if (this.zvG)
    {
      AppMethodBeat.o(119038);
      return;
    }
    if ((paramString != null) && (paramm != null) && ((paramm.obj instanceof f)))
    {
      paramm = paramm.obj;
      if (paramm == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
        AppMethodBeat.o(119038);
        throw paramString;
      }
      paramm = (f)paramm;
      if ((d.g.b.k.g(this.username, paramm.getUserName()) ^ true))
      {
        AppMethodBeat.o(119038);
        return;
      }
      if ((d.g.b.k.g(paramString, "notify_story_read")) || (d.g.b.k.g(paramString, "notify_story_unread")) || (d.g.b.k.g(paramString, "notify_story_invalid")) || (d.g.b.k.g(paramString, "notify_story_valid")))
      {
        ac.i(TAG, "update user " + paramm.getUserName() + ' ' + paramm.field_syncId + ' ' + paramString);
        if (this.zvF != paramm.dZc()) {}
        for (int i = 1;; i = 0)
        {
          this.zvE = paramm;
          this.vJc = paramm.isValid();
          this.zvF = paramm.dZc();
          dHn();
          if (i == 0) {
            break;
          }
          paramString = this.zvD;
          if (paramString == null) {
            break;
          }
          paramString.bP(this.username, this.zvF);
          AppMethodBeat.o(119038);
          return;
        }
      }
    }
    AppMethodBeat.o(119038);
  }
  
  public final boolean awm(String paramString)
  {
    return this.zvF;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(119037);
    j.b localb = j.zsh;
    j.b.dVF().remove((k.a)this);
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.zvH);
    AppMethodBeat.o(119037);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(119036);
    Object localObject = this.zvE;
    if (localObject != null)
    {
      if ((this.vJc) && (!((f)localObject).isValid()))
      {
        ac.i(TAG, "LogStory: expired " + this.username);
        localObject = com.tencent.mm.plugin.story.f.k.zsq;
        com.tencent.mm.plugin.story.f.k.aww(this.username);
      }
      AppMethodBeat.o(119036);
      return;
    }
    AppMethodBeat.o(119036);
  }
  
  public final void start()
  {
    AppMethodBeat.i(119035);
    com.tencent.mm.ac.c.b("SingleUserStateFetcher_start", (d.g.a.a)new d(this));
    j.b localb = j.zsh;
    j.b.dVF().add((k.a)this);
    com.tencent.mm.sdk.b.a.GpY.c((com.tencent.mm.sdk.b.c)this.zvH);
    AppMethodBeat.o(119035);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<ub>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.b
 * JD-Core Version:    0.7.0.1
 */