package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "username", "", "(Ljava/lang/String;)V", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "hasStory", "", "hasUnread", "isInBlackList", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1;", "checkStoryUnread", "destroy", "", "notifyListener", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pause", "registerNotifyListener", "resume", "start", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.l, k.a
{
  public static final b.a ANE;
  private static final String TAG = "MicroMsg.SingleUserStateFetcher";
  private f ANA;
  private boolean ANB;
  private boolean ANC;
  private final c AND;
  private l.a ANz;
  private final String username;
  private boolean wQj;
  
  static
  {
    AppMethodBeat.i(119041);
    ANE = new b.a((byte)0);
    TAG = "MicroMsg.SingleUserStateFetcher";
    AppMethodBeat.o(119041);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(119040);
    this.username = paramString;
    this.AND = new c(this);
    AppMethodBeat.o(119040);
  }
  
  private final void dTz()
  {
    AppMethodBeat.i(119039);
    ad.i(TAG, "notifyListener: " + this.wQj + ' ' + this.ANB);
    com.tencent.mm.ad.c.g((d.g.a.a)new b(this));
    AppMethodBeat.o(119039);
  }
  
  public final void a(l.a parama)
  {
    this.ANz = parama;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(119038);
    if (this.ANC)
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
      if ((p.i(this.username, paramm.getUserName()) ^ true))
      {
        AppMethodBeat.o(119038);
        return;
      }
      if ((p.i(paramString, "notify_story_read")) || (p.i(paramString, "notify_story_unread")) || (p.i(paramString, "notify_story_invalid")) || (p.i(paramString, "notify_story_valid")))
      {
        ad.i(TAG, "update user " + paramm.getUserName() + ' ' + paramm.field_syncId + ' ' + paramString);
        if (this.ANB != paramm.elr()) {}
        for (int i = 1;; i = 0)
        {
          this.ANA = paramm;
          this.wQj = paramm.isValid();
          this.ANB = paramm.elr();
          dTz();
          if (i == 0) {
            break;
          }
          paramString = this.ANz;
          if (paramString == null) {
            break;
          }
          paramString.bW(this.username, this.ANB);
          AppMethodBeat.o(119038);
          return;
        }
      }
    }
    AppMethodBeat.o(119038);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(119037);
    j.b localb = j.AKb;
    j.b.ehU().remove((k.a)this);
    com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)this.AND);
    AppMethodBeat.o(119037);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(119036);
    Object localObject = this.ANA;
    if (localObject != null)
    {
      if ((this.wQj) && (!((f)localObject).isValid()))
      {
        ad.i(TAG, "LogStory: expired " + this.username);
        localObject = k.AKk;
        k.aBB(this.username);
      }
      AppMethodBeat.o(119036);
      return;
    }
    AppMethodBeat.o(119036);
  }
  
  public final void start()
  {
    AppMethodBeat.i(119035);
    com.tencent.mm.ad.c.b("SingleUserStateFetcher_start", (d.g.a.a)new d(this));
    j.b localb = j.AKb;
    j.b.ehU().add((k.a)this);
    com.tencent.mm.sdk.b.a.IbL.c((com.tencent.mm.sdk.b.c)this.AND);
    AppMethodBeat.o(119035);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<uu>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
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