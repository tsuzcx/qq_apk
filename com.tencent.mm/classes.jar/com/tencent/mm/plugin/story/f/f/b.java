package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "username", "", "(Ljava/lang/String;)V", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "hasStory", "", "hasUnread", "isInBlackList", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1;", "checkStoryUnread", "destroy", "", "notifyListener", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pause", "registerNotifyListener", "resume", "start", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.l, MStorage.IOnStorageChange
{
  public static final a FpW;
  private static final String TAG = "MicroMsg.SingleUserStateFetcher";
  private boolean BdH;
  private l.a FpR;
  private f FpS;
  private boolean FpT;
  private boolean FpU;
  private final c FpV;
  private final String username;
  
  static
  {
    AppMethodBeat.i(119041);
    FpW = new a((byte)0);
    TAG = "MicroMsg.SingleUserStateFetcher";
    AppMethodBeat.o(119041);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(119040);
    this.username = paramString;
    this.FpV = new c(this);
    AppMethodBeat.o(119040);
  }
  
  private final void fai()
  {
    AppMethodBeat.i(119039);
    Log.i(TAG, "notifyListener: " + this.BdH + ' ' + this.FpT);
    d.h((a)new b(this));
    AppMethodBeat.o(119039);
  }
  
  public final void a(l.a parama)
  {
    this.FpR = parama;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(119037);
    j.b localb = j.Fmy;
    j.b.fod().remove((MStorage.IOnStorageChange)this);
    EventCenter.instance.removeListener((IListener)this.FpV);
    AppMethodBeat.o(119037);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(119038);
    if (this.FpU)
    {
      AppMethodBeat.o(119038);
      return;
    }
    if ((paramString != null) && (paramMStorageEventData != null) && ((paramMStorageEventData.obj instanceof f)))
    {
      paramMStorageEventData = paramMStorageEventData.obj;
      if (paramMStorageEventData == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
        AppMethodBeat.o(119038);
        throw paramString;
      }
      paramMStorageEventData = (f)paramMStorageEventData;
      if ((p.j(this.username, paramMStorageEventData.getUserName()) ^ true))
      {
        AppMethodBeat.o(119038);
        return;
      }
      if ((p.j(paramString, "notify_story_read")) || (p.j(paramString, "notify_story_unread")) || (p.j(paramString, "notify_story_invalid")) || (p.j(paramString, "notify_story_valid")))
      {
        Log.i(TAG, "update user " + paramMStorageEventData.getUserName() + ' ' + paramMStorageEventData.field_syncId + ' ' + paramString);
        if (this.FpT != paramMStorageEventData.frA()) {}
        for (int i = 1;; i = 0)
        {
          this.FpS = paramMStorageEventData;
          this.BdH = paramMStorageEventData.isValid();
          this.FpT = paramMStorageEventData.frA();
          fai();
          if (i == 0) {
            break;
          }
          paramString = this.FpR;
          if (paramString == null) {
            break;
          }
          paramString.cs(this.username, this.FpT);
          AppMethodBeat.o(119038);
          return;
        }
      }
    }
    AppMethodBeat.o(119038);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(119036);
    Object localObject = this.FpS;
    if (localObject != null)
    {
      if ((this.BdH) && (!((f)localObject).isValid()))
      {
        Log.i(TAG, "LogStory: expired " + this.username);
        localObject = k.FmH;
        k.aRQ(this.username);
      }
      AppMethodBeat.o(119036);
      return;
    }
    AppMethodBeat.o(119036);
  }
  
  public final void start()
  {
    AppMethodBeat.i(119035);
    d.b("SingleUserStateFetcher_start", (a)new d(this));
    j.b localb = j.Fmy;
    j.b.fod().add((MStorage.IOnStorageChange)this);
    EventCenter.instance.addListener((IListener)this.FpV);
    AppMethodBeat.o(119035);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class c
    extends IListener<vx>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
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