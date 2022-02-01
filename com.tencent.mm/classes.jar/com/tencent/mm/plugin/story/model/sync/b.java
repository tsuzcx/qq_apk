package com.tencent.mm.plugin.story.model.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "username", "", "(Ljava/lang/String;)V", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "hasStory", "", "hasUnread", "isInBlackList", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1;", "checkStoryUnread", "destroy", "", "notifyListener", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pause", "registerNotifyListener", "resume", "start", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements l, MStorage.IOnStorageChange
{
  public static final b.a Sno;
  private static final String TAG;
  private boolean MVC;
  private l.a Snp;
  private com.tencent.mm.plugin.story.h.f Snq;
  private boolean Snr;
  private boolean Sns;
  private final SingleUserStateFetcher.snsPermissionNotifyListener.1 Snt;
  private final String username;
  
  static
  {
    AppMethodBeat.i(119041);
    Sno = new b.a((byte)0);
    TAG = "MicroMsg.SingleUserStateFetcher";
    AppMethodBeat.o(119041);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(119040);
    this.username = paramString;
    this.Snt = new SingleUserStateFetcher.snsPermissionNotifyListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(119040);
  }
  
  private final void jZ()
  {
    AppMethodBeat.i(119039);
    Log.i(TAG, "notifyListener: " + this.MVC + ' ' + this.Snr);
    d.uiThread((a)new b(this));
    AppMethodBeat.o(119039);
  }
  
  public final void a(l.a parama)
  {
    this.Snp = parama;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(119037);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.hvS().remove((MStorage.IOnStorageChange)this);
    this.Snt.dead();
    AppMethodBeat.o(119037);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(119038);
    if (this.Sns)
    {
      AppMethodBeat.o(119038);
      return;
    }
    if ((paramString != null) && (paramMStorageEventData != null) && ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.story.h.f)))
    {
      paramMStorageEventData = paramMStorageEventData.obj;
      if (paramMStorageEventData == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
        AppMethodBeat.o(119038);
        throw paramString;
      }
      paramMStorageEventData = (com.tencent.mm.plugin.story.h.f)paramMStorageEventData;
      if (!s.p(this.username, paramMStorageEventData.getUserName()))
      {
        AppMethodBeat.o(119038);
        return;
      }
      switch (paramString.hashCode())
      {
      }
    }
    do
    {
      AppMethodBeat.o(119038);
      return;
      if (paramString.equals("notify_story_unread")) {
        break;
      }
      AppMethodBeat.o(119038);
      return;
      if (paramString.equals("notify_story_invalid")) {
        break;
      }
      AppMethodBeat.o(119038);
      return;
      if (paramString.equals("notify_story_valid")) {
        break;
      }
      AppMethodBeat.o(119038);
      return;
    } while (!paramString.equals("notify_story_read"));
    Log.i(TAG, "update user " + paramMStorageEventData.getUserName() + ' ' + paramMStorageEventData.field_syncId + ' ' + paramString);
    if (this.Snr != paramMStorageEventData.hzn()) {}
    for (int i = 1;; i = 0)
    {
      this.Snq = paramMStorageEventData;
      this.MVC = paramMStorageEventData.isValid();
      this.Snr = paramMStorageEventData.hzn();
      jZ();
      if (i == 0) {
        break;
      }
      paramString = this.Snp;
      if (paramString == null) {
        break;
      }
      paramString.dm(this.username, this.Snr);
      break;
    }
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(119036);
    Object localObject = this.Snq;
    if ((localObject != null) && (this.MVC) && (!((com.tencent.mm.plugin.story.h.f)localObject).isValid()))
    {
      Log.i(TAG, s.X("LogStory: expired ", this.username));
      localObject = j.Skm;
      j.bbH(this.username);
    }
    AppMethodBeat.o(119036);
  }
  
  public final void start()
  {
    AppMethodBeat.i(119035);
    d.d("SingleUserStateFetcher_start", (a)new c(this));
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.hvS().add((MStorage.IOnStorageChange)this);
    this.Snt.alive();
    AppMethodBeat.o(119035);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.sync.b
 * JD-Core Version:    0.7.0.1
 */