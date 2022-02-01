package com.tencent.mm.plugin.music.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.i;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.protocal.protobuf.dte;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k$b
  implements b.a
{
  public final void a(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(271076);
    s.u(paramMultiTaskInfo, "info");
    AppMethodBeat.o(271076);
  }
  
  public final void b(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(271090);
    s.u(paramMultiTaskInfo, "info");
    if (!((cn)com.tencent.mm.kernel.h.az(cn.class)).canEnterMvAndShowToast())
    {
      AppMethodBeat.o(271090);
      return;
    }
    Object localObject = new dte();
    for (;;)
    {
      dtj localdtj;
      int i;
      try
      {
        ((dte)localObject).parseFrom(paramMultiTaskInfo.field_data);
        com.tencent.mm.aw.a.c(i.a(((dte)localObject).musicType, ((dte)localObject).ZWS, ((dte)localObject).name, ((dte)localObject).rDl, ((dte)localObject).rDm, ((dte)localObject).aaYE, ((dte)localObject).aaYF, ((dte)localObject).musicId, ((dte)localObject).aaYG, ((dte)localObject).aaYH, ((dte)localObject).aaYI, ((dte)localObject).appId, com.tencent.mm.aw.h.a(((dte)localObject).musicId, ((dte)localObject).oPb)));
        dtk localdtk = new dtk();
        paramMultiTaskInfo = com.tencent.mm.plugin.comm.a.xeG;
        localdtk.zIO = com.tencent.mm.plugin.comm.a.dsT();
        localdtk.aaYP = 86;
        localdtk.scene = 7;
        Intent localIntent = new Intent();
        localdtj = ((dte)localObject).oPb;
        localIntent.putExtra("key_scene", 12);
        localIntent.putExtra("key_mv_feed_id", localdtj.YqN);
        localIntent.putExtra("key_mv_nonce_id", localdtj.YqO);
        localIntent.putExtra("key_mv_cover_url", localdtj.YqP);
        localIntent.putExtra("key_mv_poster", localdtj.YqQ);
        if (localdtj == null)
        {
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_song_name", paramMultiTaskInfo);
          if (localdtj != null) {
            break label518;
          }
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_song_lyric", paramMultiTaskInfo);
          if (localdtj != null) {
            break label536;
          }
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_singer_name", paramMultiTaskInfo);
          if (localdtj != null) {
            break label554;
          }
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_album_name", paramMultiTaskInfo);
          if (localdtj != null) {
            break label572;
          }
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_music_genre", paramMultiTaskInfo);
          if (localdtj != null) {
            break label590;
          }
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_issue_date", paramMultiTaskInfo);
          if (localdtj != null) {
            break label614;
          }
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_album_cover_url", paramMultiTaskInfo);
          if (localdtj != null) {
            break label632;
          }
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_identification", paramMultiTaskInfo);
          if (localdtj != null) {
            break label650;
          }
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_extra_info", paramMultiTaskInfo);
          if (localdtj != null) {
            break label668;
          }
          i = 0;
          localIntent.putExtra("key_mv_music_duration", i);
          if (localdtj != null) {
            break label677;
          }
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_thumb_path", paramMultiTaskInfo);
          if (localdtj != null) {
            break label695;
          }
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_music_operation_url", paramMultiTaskInfo);
          if (localdtj != null) {
            break label713;
          }
          paramMultiTaskInfo = "";
          localIntent.putExtra("key_mv_song_mid", paramMultiTaskInfo);
          localIntent.putExtra("key_mv_report_data", localdtk.toByteArray());
          localIntent.setFlags(268435456);
          c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", localIntent);
          AppMethodBeat.o(271090);
          return;
        }
      }
      finally
      {
        Log.e("MicroMsg.MusicPlayerMultiTaskHelper", "MusicMultiTaskData parse failed");
        AppMethodBeat.o(271090);
        return;
      }
      localObject = localdtj.songName;
      paramMultiTaskInfo = (MultiTaskInfo)localObject;
      if (localObject == null)
      {
        paramMultiTaskInfo = "";
        continue;
        label518:
        localObject = localdtj.songLyric;
        paramMultiTaskInfo = (MultiTaskInfo)localObject;
        if (localObject == null)
        {
          paramMultiTaskInfo = "";
          continue;
          label536:
          localObject = localdtj.singerName;
          paramMultiTaskInfo = (MultiTaskInfo)localObject;
          if (localObject == null)
          {
            paramMultiTaskInfo = "";
            continue;
            label554:
            localObject = localdtj.albumName;
            paramMultiTaskInfo = (MultiTaskInfo)localObject;
            if (localObject == null)
            {
              paramMultiTaskInfo = "";
              continue;
              label572:
              localObject = localdtj.musicGenre;
              paramMultiTaskInfo = (MultiTaskInfo)localObject;
              if (localObject == null)
              {
                paramMultiTaskInfo = "";
                continue;
                label590:
                localObject = Long.valueOf(localdtj.issueDate).toString();
                paramMultiTaskInfo = (MultiTaskInfo)localObject;
                if (localObject == null)
                {
                  paramMultiTaskInfo = "";
                  continue;
                  label614:
                  localObject = localdtj.RfH;
                  paramMultiTaskInfo = (MultiTaskInfo)localObject;
                  if (localObject == null)
                  {
                    paramMultiTaskInfo = "";
                    continue;
                    label632:
                    localObject = localdtj.identification;
                    paramMultiTaskInfo = (MultiTaskInfo)localObject;
                    if (localObject == null)
                    {
                      paramMultiTaskInfo = "";
                      continue;
                      label650:
                      localObject = localdtj.extraInfo;
                      paramMultiTaskInfo = (MultiTaskInfo)localObject;
                      if (localObject == null)
                      {
                        paramMultiTaskInfo = "";
                        continue;
                        label668:
                        i = localdtj.LNC;
                        continue;
                        label677:
                        localObject = localdtj.oPc;
                        paramMultiTaskInfo = (MultiTaskInfo)localObject;
                        if (localObject == null)
                        {
                          paramMultiTaskInfo = "";
                          continue;
                          label695:
                          localObject = localdtj.musicOperationUrl;
                          paramMultiTaskInfo = (MultiTaskInfo)localObject;
                          if (localObject == null)
                          {
                            paramMultiTaskInfo = "";
                            continue;
                            label713:
                            localObject = localdtj.oOZ;
                            paramMultiTaskInfo = (MultiTaskInfo)localObject;
                            if (localObject == null) {
                              paramMultiTaskInfo = "";
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void c(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(271096);
    s.u(paramMultiTaskInfo, "info");
    AppMethodBeat.o(271096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.k.b
 * JD-Core Version:    0.7.0.1
 */