package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "username", "", "(Ljava/lang/String;)V", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "hasStory", "", "hasUnread", "isInBlackList", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1;", "checkStoryUnread", "destroy", "", "notifyListener", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pause", "registerNotifyListener", "resume", "start", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.l, k.a
{
  private static final String TAG = "MicroMsg.SingleUserStateFetcher";
  public static final a yiJ;
  private boolean uAj;
  private final String username;
  private l.a yiE;
  private f yiF;
  private boolean yiG;
  private boolean yiH;
  private final c yiI;
  
  static
  {
    AppMethodBeat.i(119041);
    yiJ = new a((byte)0);
    TAG = "MicroMsg.SingleUserStateFetcher";
    AppMethodBeat.o(119041);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(119040);
    this.username = paramString;
    this.yiI = new c(this);
    AppMethodBeat.o(119040);
  }
  
  private final void dsP()
  {
    AppMethodBeat.i(119039);
    ad.i(TAG, "notifyListener: " + this.uAj + ' ' + this.yiG);
    com.tencent.mm.ad.c.g((d.g.a.a)new b(this));
    AppMethodBeat.o(119039);
  }
  
  public final void a(l.a parama)
  {
    this.yiE = parama;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(119038);
    if (this.yiH)
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
        ad.i(TAG, "update user " + paramm.getUserName() + ' ' + paramm.field_syncId + ' ' + paramString);
        if (this.yiG != paramm.dKB()) {}
        for (int i = 1;; i = 0)
        {
          this.yiF = paramm;
          this.uAj = paramm.isValid();
          this.yiG = paramm.dKB();
          dsP();
          if (i == 0) {
            break;
          }
          paramString = this.yiE;
          if (paramString == null) {
            break;
          }
          paramString.bI(this.username, this.yiG);
          AppMethodBeat.o(119038);
          return;
        }
      }
    }
    AppMethodBeat.o(119038);
  }
  
  public final boolean ard(String paramString)
  {
    return this.yiG;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(119037);
    j.b localb = j.yfh;
    j.b.dHe().remove((k.a)this);
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.yiI);
    AppMethodBeat.o(119037);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(119036);
    Object localObject = this.yiF;
    if (localObject != null)
    {
      if ((this.uAj) && (!((f)localObject).isValid()))
      {
        ad.i(TAG, "LogStory: expired " + this.username);
        localObject = com.tencent.mm.plugin.story.f.k.yfq;
        com.tencent.mm.plugin.story.f.k.arn(this.username);
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
    j.b localb = j.yfh;
    j.b.dHe().add((k.a)this);
    com.tencent.mm.sdk.b.a.ESL.c((com.tencent.mm.sdk.b.c)this.yiI);
    AppMethodBeat.o(119035);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<ts>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.b
 * JD-Core Version:    0.7.0.1
 */