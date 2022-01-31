package com.tencent.mm.plugin.story.model.f;

import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "username", "", "(Ljava/lang/String;)V", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "hasStory", "", "hasUnread", "isInBlackList", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1;", "checkStoryUnread", "destroy", "", "notifyListener", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pause", "registerNotifyListener", "resume", "start", "Companion", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.k, com.tencent.mm.sdk.e.k.a
{
  private static final String TAG = "MicroMsg.SingleUserStateFetcher";
  public static final b.a szw;
  private boolean isInBlackList;
  private boolean pyz;
  private com.tencent.mm.plugin.story.api.k.a szs;
  private f szt;
  private boolean szu;
  private final b.c szv;
  private final String username;
  
  static
  {
    AppMethodBeat.i(109390);
    szw = new b.a((byte)0);
    TAG = "MicroMsg.SingleUserStateFetcher";
    AppMethodBeat.o(109390);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(109389);
    this.username = paramString;
    this.szv = new b.c(this);
    AppMethodBeat.o(109389);
  }
  
  private final void coB()
  {
    AppMethodBeat.i(109388);
    ab.i(TAG, "notifyListener: " + this.pyz + ' ' + this.szu);
    com.tencent.mm.ab.b.b((a.f.a.a)new b.b(this));
    AppMethodBeat.o(109388);
  }
  
  public final void a(com.tencent.mm.plugin.story.api.k.a parama)
  {
    this.szs = parama;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(109387);
    if (this.isInBlackList)
    {
      AppMethodBeat.o(109387);
      return;
    }
    if ((paramString != null) && (paramm != null) && ((paramm.obj instanceof f)))
    {
      paramm = paramm.obj;
      if (paramm == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
        AppMethodBeat.o(109387);
        throw paramString;
      }
      paramm = (f)paramm;
      if ((a.f.b.j.e(this.username, paramm.getUserName()) ^ true))
      {
        AppMethodBeat.o(109387);
        return;
      }
      if ((a.f.b.j.e(paramString, "notify_story_read")) || (a.f.b.j.e(paramString, "notify_story_unread")) || (a.f.b.j.e(paramString, "notify_story_invalid")) || (a.f.b.j.e(paramString, "notify_story_valid")))
      {
        ab.i(TAG, "update user " + paramm.getUserName() + ' ' + paramm.field_syncId + ' ' + paramString);
        if (this.szu != paramm.cEU()) {}
        for (int i = 1;; i = 0)
        {
          this.szt = paramm;
          this.pyz = paramm.isValid();
          this.szu = paramm.cEU();
          coB();
          if (i == 0) {
            break;
          }
          paramString = this.szs;
          if (paramString == null) {
            break;
          }
          paramString.by(this.username, this.szu);
          AppMethodBeat.o(109387);
          return;
        }
      }
    }
    AppMethodBeat.o(109387);
  }
  
  public final boolean acA(String paramString)
  {
    return this.szu;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(109386);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAC().remove((com.tencent.mm.sdk.e.k.a)this);
    com.tencent.mm.sdk.b.a.ymk.d((c)this.szv);
    AppMethodBeat.o(109386);
  }
  
  public final void pause() {}
  
  public final void resume()
  {
    AppMethodBeat.i(109385);
    Object localObject = this.szt;
    if (localObject != null)
    {
      if ((this.pyz) && (!((f)localObject).isValid()))
      {
        ab.i(TAG, "LogStory: expired " + this.username);
        localObject = com.tencent.mm.plugin.story.model.k.svr;
        com.tencent.mm.plugin.story.model.k.acS(this.username);
      }
      AppMethodBeat.o(109385);
      return;
    }
    AppMethodBeat.o(109385);
  }
  
  public final void start()
  {
    AppMethodBeat.i(109384);
    com.tencent.mm.ab.b.a("SingleUserStateFetcher_start", (a.f.a.a)new b.d(this));
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAC().add((com.tencent.mm.sdk.e.k.a)this);
    com.tencent.mm.sdk.b.a.ymk.c((c)this.szv);
    AppMethodBeat.o(109384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.b
 * JD-Core Version:    0.7.0.1
 */