package com.tencent.mm.plugin.music.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.i;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "plugin-music_release"})
public final class k$b
  implements b.a
{
  public final void a(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(259676);
    p.k(paramMultiTaskInfo, "info");
    AppMethodBeat.o(259676);
  }
  
  public final void b(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(259677);
    p.k(paramMultiTaskInfo, "info");
    if (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).canEnterMvAndShowToast())
    {
      AppMethodBeat.o(259677);
      return;
    }
    Object localObject = new dbn();
    for (;;)
    {
      try
      {
        ((dbn)localObject).parseFrom(paramMultiTaskInfo.field_data);
        com.tencent.mm.bb.a.c(i.a(((dbn)localObject).musicType, ((dbn)localObject).SOM, ((dbn)localObject).name, ((dbn)localObject).ozs, ((dbn)localObject).ozt, ((dbn)localObject).TIO, ((dbn)localObject).TIQ, ((dbn)localObject).fMd, ((dbn)localObject).TIR, ((dbn)localObject).TIS, ((dbn)localObject).TIT, ((dbn)localObject).appId, com.tencent.mm.bb.h.a(((dbn)localObject).fMd, ((dbn)localObject).lVY)));
        dbs localdbs = new dbs();
        paramMultiTaskInfo = com.tencent.mm.plugin.comm.a.ubo;
        localdbs.wmL = com.tencent.mm.plugin.comm.a.cPn();
        localdbs.TIZ = 86;
        localdbs.scene = 7;
        Intent localIntent = new Intent();
        dbr localdbr = ((dbn)localObject).lVY;
        localIntent.putExtra("key_scene", 12);
        localIntent.putExtra("key_mv_feed_id", localdbr.Ruu);
        localIntent.putExtra("key_mv_nonce_id", localdbr.Ruv);
        localIntent.putExtra("key_mv_cover_url", localdbr.Ruw);
        localIntent.putExtra("key_mv_poster", localdbr.Rux);
        if (localdbr != null)
        {
          localObject = localdbr.HLH;
          paramMultiTaskInfo = (MultiTaskInfo)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMultiTaskInfo = "";
        }
        localIntent.putExtra("key_mv_song_name", paramMultiTaskInfo);
        if (localdbr != null)
        {
          localObject = localdbr.songLyric;
          paramMultiTaskInfo = (MultiTaskInfo)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMultiTaskInfo = "";
        }
        localIntent.putExtra("key_mv_song_lyric", paramMultiTaskInfo);
        if (localdbr != null)
        {
          localObject = localdbr.singerName;
          paramMultiTaskInfo = (MultiTaskInfo)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMultiTaskInfo = "";
        }
        localIntent.putExtra("key_mv_singer_name", paramMultiTaskInfo);
        if (localdbr != null)
        {
          localObject = localdbr.albumName;
          paramMultiTaskInfo = (MultiTaskInfo)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMultiTaskInfo = "";
        }
        localIntent.putExtra("key_mv_album_name", paramMultiTaskInfo);
        if (localdbr != null)
        {
          localObject = localdbr.musicGenre;
          paramMultiTaskInfo = (MultiTaskInfo)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMultiTaskInfo = "";
        }
        localIntent.putExtra("key_mv_music_genre", paramMultiTaskInfo);
        if (localdbr != null)
        {
          localObject = String.valueOf(localdbr.issueDate);
          paramMultiTaskInfo = (MultiTaskInfo)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMultiTaskInfo = "";
        }
        localIntent.putExtra("key_mv_issue_date", paramMultiTaskInfo);
        if (localdbr != null)
        {
          localObject = localdbr.KGh;
          paramMultiTaskInfo = (MultiTaskInfo)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMultiTaskInfo = "";
        }
        localIntent.putExtra("key_mv_album_cover_url", paramMultiTaskInfo);
        if (localdbr != null)
        {
          localObject = localdbr.identification;
          paramMultiTaskInfo = (MultiTaskInfo)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMultiTaskInfo = "";
        }
        localIntent.putExtra("key_mv_identification", paramMultiTaskInfo);
        if (localdbr != null)
        {
          localObject = localdbr.extraInfo;
          paramMultiTaskInfo = (MultiTaskInfo)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMultiTaskInfo = "";
        }
        localIntent.putExtra("key_mv_extra_info", paramMultiTaskInfo);
        if (localdbr != null)
        {
          i = localdbr.FSG;
          localIntent.putExtra("key_mv_music_duration", i);
          if (localdbr != null)
          {
            localObject = localdbr.lVZ;
            paramMultiTaskInfo = (MultiTaskInfo)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramMultiTaskInfo = "";
          }
          localIntent.putExtra("key_mv_thumb_path", paramMultiTaskInfo);
          localIntent.putExtra("key_mv_report_data", localdbs.toByteArray());
          localIntent.setFlags(268435456);
          c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", localIntent);
          AppMethodBeat.o(259677);
          return;
        }
      }
      catch (Throwable paramMultiTaskInfo)
      {
        Log.e("MicroMsg.MusicPlayerMultiTaskHelper", "MusicMultiTaskData parse failed");
        AppMethodBeat.o(259677);
        return;
      }
      int i = 0;
    }
  }
  
  public final void c(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(259679);
    p.k(paramMultiTaskInfo, "info");
    AppMethodBeat.o(259679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.k.b
 * JD-Core Version:    0.7.0.1
 */