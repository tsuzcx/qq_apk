package com.tencent.mm.plugin.music.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.h;
import com.tencent.mm.ay.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.taskbar.api.c.a;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "()V", "ADD_HISTORY_DURATION_LIMIT", "", "getADD_HISTORY_DURATION_LIMIT", "()I", "fillMultiTaskData", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "extras", "Landroid/os/Bundle;", "onClose", "", "way", "ended", "reset", "Companion", "plugin-music_release"})
public final class k
  extends com.tencent.mm.plugin.multitask.b.a
{
  private static final b AkG;
  public static final k.a AkH;
  private final int AkF = 10000;
  
  static
  {
    AppMethodBeat.i(219986);
    AkH = new k.a((byte)0);
    AkG = new b();
    AppMethodBeat.o(219986);
  }
  
  public static final void euA()
  {
    AppMethodBeat.i(219987);
    com.tencent.mm.plugin.taskbar.api.c localc = (com.tencent.mm.plugin.taskbar.api.c)g.af(com.tencent.mm.plugin.taskbar.api.c.class);
    if (localc != null)
    {
      localc.a(6, (c.a)AkG);
      AppMethodBeat.o(219987);
      return;
    }
    AppMethodBeat.o(219987);
  }
  
  public static final void euB()
  {
    AppMethodBeat.i(219988);
    com.tencent.mm.plugin.taskbar.api.c localc = (com.tencent.mm.plugin.taskbar.api.c)g.af(com.tencent.mm.plugin.taskbar.api.c.class);
    if (localc != null)
    {
      localc.b(6, (c.a)AkG);
      AppMethodBeat.o(219988);
      return;
    }
    AppMethodBeat.o(219988);
  }
  
  public final boolean O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(219985);
    Object localObject = com.tencent.mm.plugin.music.e.k.euj();
    p.g(localObject, "MusicPlayerManager.Instance()");
    localObject = ((com.tencent.mm.plugin.music.e.k)localObject).etW();
    if (localObject != null) {}
    for (paramInt = ((d)localObject).etn();; paramInt = 0)
    {
      Log.i("MicroMsg.MusicPlayerMultiTaskHelper", "onClose ".concat(String.valueOf(paramInt)));
      if (this.Abp != null) {
        break;
      }
      AppMethodBeat.o(219985);
      return true;
    }
    if (paramInt > this.AkF)
    {
      Log.i("MicroMsg.MusicPlayerMultiTaskHelper", "add historyTaskInfo");
      ai(null);
    }
    this.Abp = null;
    AppMethodBeat.o(219985);
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "plugin-music_release"})
  public static final class b
    implements c.a
  {
    public final void a(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(219982);
      p.h(paramMultiTaskInfo, "info");
      AppMethodBeat.o(219982);
    }
    
    public final void b(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(219983);
      p.h(paramMultiTaskInfo, "info");
      if (!((aj)g.ah(aj.class)).canEnterMvAndShowToast())
      {
        AppMethodBeat.o(219983);
        return;
      }
      Object localObject = new cso();
      for (;;)
      {
        try
        {
          ((cso)localObject).parseFrom(paramMultiTaskInfo.field_data);
          com.tencent.mm.ay.a.c(i.a(((cso)localObject).musicType, ((cso)localObject).Djf, ((cso)localObject).name, ((cso)localObject).lDR, ((cso)localObject).lDS, ((cso)localObject).Mxy, ((cso)localObject).Mxz, ((cso)localObject).dSF, ((cso)localObject).MxA, ((cso)localObject).MxB, ((cso)localObject).MxC, ((cso)localObject).appId, h.a(((cso)localObject).dSF, ((cso)localObject).jfy)));
          cst localcst = new cst();
          paramMultiTaskInfo = com.tencent.mm.plugin.comm.a.qCo;
          localcst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
          localcst.MxI = 86;
          localcst.scene = 7;
          Intent localIntent = new Intent();
          css localcss = ((cso)localObject).jfy;
          localIntent.putExtra("key_scene", 12);
          localIntent.putExtra("key_mv_feed_id", localcss.Ktn);
          localIntent.putExtra("key_mv_nonce_id", localcss.Kto);
          localIntent.putExtra("key_mv_cover_url", localcss.Ktp);
          localIntent.putExtra("key_mv_poster", localcss.Ktq);
          if (localcss != null)
          {
            localObject = localcss.BPc;
            paramMultiTaskInfo = (MultiTaskInfo)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramMultiTaskInfo = "";
          }
          localIntent.putExtra("key_mv_song_name", paramMultiTaskInfo);
          if (localcss != null)
          {
            localObject = localcss.songLyric;
            paramMultiTaskInfo = (MultiTaskInfo)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramMultiTaskInfo = "";
          }
          localIntent.putExtra("key_mv_song_lyric", paramMultiTaskInfo);
          if (localcss != null)
          {
            localObject = localcss.singerName;
            paramMultiTaskInfo = (MultiTaskInfo)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramMultiTaskInfo = "";
          }
          localIntent.putExtra("key_mv_singer_name", paramMultiTaskInfo);
          if (localcss != null)
          {
            localObject = localcss.albumName;
            paramMultiTaskInfo = (MultiTaskInfo)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramMultiTaskInfo = "";
          }
          localIntent.putExtra("key_mv_album_name", paramMultiTaskInfo);
          if (localcss != null)
          {
            localObject = localcss.musicGenre;
            paramMultiTaskInfo = (MultiTaskInfo)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramMultiTaskInfo = "";
          }
          localIntent.putExtra("key_mv_music_genre", paramMultiTaskInfo);
          if (localcss != null)
          {
            l = localcss.issueDate;
            localIntent.putExtra("key_mv_issue_date", l);
            if (localcss != null)
            {
              localObject = localcss.EsK;
              paramMultiTaskInfo = (MultiTaskInfo)localObject;
              if (localObject != null) {}
            }
            else
            {
              paramMultiTaskInfo = "";
            }
            localIntent.putExtra("key_mv_album_cover_url", paramMultiTaskInfo);
            if (localcss != null)
            {
              localObject = localcss.identification;
              paramMultiTaskInfo = (MultiTaskInfo)localObject;
              if (localObject != null) {}
            }
            else
            {
              paramMultiTaskInfo = "";
            }
            localIntent.putExtra("key_mv_identification", paramMultiTaskInfo);
            if (localcss != null)
            {
              localObject = localcss.extraInfo;
              paramMultiTaskInfo = (MultiTaskInfo)localObject;
              if (localObject != null) {}
            }
            else
            {
              paramMultiTaskInfo = "";
            }
            localIntent.putExtra("key_mv_extra_info", paramMultiTaskInfo);
            if (localcss == null) {
              break label635;
            }
            i = localcss.Alz;
            localIntent.putExtra("key_mv_music_duration", i);
            if (localcss != null)
            {
              localObject = localcss.jfz;
              paramMultiTaskInfo = (MultiTaskInfo)localObject;
              if (localObject != null) {}
            }
            else
            {
              paramMultiTaskInfo = "";
            }
            localIntent.putExtra("key_mv_thumb_path", paramMultiTaskInfo);
            localIntent.putExtra("key_mv_report_data", localcst.toByteArray());
            localIntent.setFlags(268435456);
            com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", localIntent);
            AppMethodBeat.o(219983);
            return;
          }
        }
        catch (Throwable paramMultiTaskInfo)
        {
          Log.e("MicroMsg.MusicPlayerMultiTaskHelper", "MusicMultiTaskData parse failed");
          AppMethodBeat.o(219983);
          return;
        }
        long l = 0L;
        continue;
        label635:
        int i = 0;
      }
    }
    
    public final void c(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(219984);
      p.h(paramMultiTaskInfo, "info");
      AppMethodBeat.o(219984);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.k
 * JD-Core Version:    0.7.0.1
 */