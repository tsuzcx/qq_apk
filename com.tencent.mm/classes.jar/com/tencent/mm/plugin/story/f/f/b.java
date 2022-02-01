package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.a.xc;
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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "username", "", "(Ljava/lang/String;)V", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "hasStory", "", "hasUnread", "isInBlackList", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1;", "checkStoryUnread", "destroy", "", "notifyListener", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pause", "registerNotifyListener", "resume", "start", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.l, MStorage.IOnStorageChange
{
  public static final a LJZ;
  private static final String TAG = "MicroMsg.SingleUserStateFetcher";
  private boolean GXF;
  private l.a LJU;
  private f LJV;
  private boolean LJW;
  private boolean LJX;
  private final c LJY;
  private final String username;
  
  static
  {
    AppMethodBeat.i(119041);
    LJZ = new a((byte)0);
    TAG = "MicroMsg.SingleUserStateFetcher";
    AppMethodBeat.o(119041);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(119040);
    this.username = paramString;
    this.LJY = new c(this);
    AppMethodBeat.o(119040);
  }
  
  private final void fOb()
  {
    AppMethodBeat.i(119039);
    Log.i(TAG, "notifyListener: " + this.GXF + ' ' + this.LJW);
    d.uiThread((a)new b(this));
    AppMethodBeat.o(119039);
  }
  
  public final void a(l.a parama)
  {
    this.LJU = parama;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(119037);
    j.b localb = j.LGA;
    j.b.gcx().remove((MStorage.IOnStorageChange)this);
    EventCenter.instance.removeListener((IListener)this.LJY);
    AppMethodBeat.o(119037);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(119038);
    if (this.LJX)
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
      if ((p.h(this.username, paramMStorageEventData.getUserName()) ^ true))
      {
        AppMethodBeat.o(119038);
        return;
      }
      if ((p.h(paramString, "notify_story_read")) || (p.h(paramString, "notify_story_unread")) || (p.h(paramString, "notify_story_invalid")) || (p.h(paramString, "notify_story_valid")))
      {
        Log.i(TAG, "update user " + paramMStorageEventData.getUserName() + ' ' + paramMStorageEventData.field_syncId + ' ' + paramString);
        if (this.LJW != paramMStorageEventData.gfW()) {}
        for (int i = 1;; i = 0)
        {
          this.LJV = paramMStorageEventData;
          this.GXF = paramMStorageEventData.isValid();
          this.LJW = paramMStorageEventData.gfW();
          fOb();
          if (i == 0) {
            break;
          }
          paramString = this.LJU;
          if (paramString == null) {
            break;
          }
          paramString.cG(this.username, this.LJW);
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
    Object localObject = this.LJV;
    if (localObject != null)
    {
      if ((this.GXF) && (!((f)localObject).isValid()))
      {
        Log.i(TAG, "LogStory: expired " + this.username);
        localObject = k.LGJ;
        k.bcU(this.username);
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
    j.b localb = j.LGA;
    j.b.gcx().add((MStorage.IOnStorageChange)this);
    EventCenter.instance.addListener((IListener)this.LJY);
    AppMethodBeat.o(119035);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class c
    extends IListener<xc>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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