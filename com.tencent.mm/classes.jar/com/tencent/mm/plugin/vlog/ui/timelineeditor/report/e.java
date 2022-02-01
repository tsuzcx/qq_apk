package com.tencent.mm.plugin.vlog.ui.timelineeditor.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.f.b.a.ew;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.audio.EditorAudioSelectFinderVideoView;
import com.tencent.mm.plugin.vlog.model.w;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport21875;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderShowInWXProfileStruct;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;)V", "editId", "", "filterFakeMusicUseClick", "", "filterFakeMusicUseExpose", "getPluginLayout", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "setPluginLayout", "init", "", "reportFinderMusicUseClick", "expose", "reportFinderMusicUseExpose", "reportId", "reportMusicUseClick", "reportMusicUseExpose", "reset", "setEditId", "setFinderContextId", "finderContextId", "setSessionId", "sessionId", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public class e
  extends g<ew>
{
  public static final a NEJ;
  private BasePluginLayout NED;
  private boolean NEH;
  private boolean NEI;
  private String editId;
  
  static
  {
    AppMethodBeat.i(245981);
    NEJ = new a((byte)0);
    AppMethodBeat.o(245981);
  }
  
  public e(BasePluginLayout paramBasePluginLayout)
  {
    AppMethodBeat.i(245980);
    this.NED = paramBasePluginLayout;
    this.editId = "";
    AppMethodBeat.o(245980);
  }
  
  protected final void AD(boolean paramBoolean)
  {
    AppMethodBeat.i(245972);
    ew localew = (ew)this.NEK;
    if (localew != null) {
      localew.mq(0);
    }
    localew = (ew)this.NEK;
    if (localew != null) {
      localew.tk(String.valueOf(cm.bfE()));
    }
    localew = (ew)this.NEK;
    if (localew != null) {
      localew.tl("like_fav_feed_music");
    }
    localew = (ew)this.NEK;
    Object localObject;
    if (localew != null)
    {
      localObject = new i();
      if (!paramBoolean) {
        break label146;
      }
    }
    label146:
    for (int i = 1;; i = 0)
    {
      localObject = ((i)localObject).al("if_show_reddot", i).g("editId", this.editId).toString();
      p.j(localObject, "JSONObject()\n           …)\n            .toString()");
      localew.tm(n.l((String)localObject, ",", ";", false));
      report();
      AppMethodBeat.o(245972);
      return;
    }
  }
  
  protected final void AE(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(245974);
    ew localew = (ew)this.NEK;
    if (localew != null) {
      localew.mq(1);
    }
    localew = (ew)this.NEK;
    if (localew != null) {
      localew.tk(String.valueOf(cm.bfE()));
    }
    localew = (ew)this.NEK;
    if (localew != null) {
      localew.tl("like_fav_feed_music");
    }
    localew = (ew)this.NEK;
    Object localObject;
    if (localew != null)
    {
      localObject = new i();
      if (!paramBoolean) {
        break label146;
      }
    }
    for (;;)
    {
      localObject = ((i)localObject).al("if_show_reddot", i).g("editId", this.editId).toString();
      p.j(localObject, "JSONObject()\n           …)\n            .toString()");
      localew.tm(n.l((String)localObject, ",", ";", false));
      report();
      AppMethodBeat.o(245974);
      return;
      label146:
      i = 0;
    }
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(245978);
    p.k(paramc, "status");
    switch (f.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label261:
    label474:
    do
    {
      AppMethodBeat.o(245978);
      return;
      if (paramc == d.c.HSo)
      {
        this.NEH = true;
        this.NEI = true;
      }
      paramc = (com.tencent.mm.plugin.vlog.ui.a)this.NED.bp(com.tencent.mm.plugin.vlog.ui.a.class);
      boolean bool;
      if (paramc != null)
      {
        bool = paramc.guy();
        if (this.NEH)
        {
          this.NEH = false;
          AppMethodBeat.o(245978);
          return;
        }
        paramc = (ew)this.NEK;
        if (paramc != null) {
          paramc.mq(0);
        }
        paramc = (ew)this.NEK;
        if (paramc != null) {
          paramc.tk(String.valueOf(cm.bfE()));
        }
        paramc = (ew)this.NEK;
        if (paramc != null) {
          paramc.tl("music_use");
        }
        paramc = (ew)this.NEK;
        if (paramc != null)
        {
          paramBundle = new i();
          if (!bool) {
            break label261;
          }
        }
        for (i = 1;; i = 0)
        {
          paramBundle = paramBundle.al("tips", i).g("editId", this.editId).toString();
          p.j(paramBundle, "JSONObject()\n           …)\n            .toString()");
          paramc.tm(n.l(paramBundle, ",", ";", false));
          report();
          AppMethodBeat.o(245978);
          return;
        }
      }
      AppMethodBeat.o(245978);
      return;
      paramBundle = (com.tencent.mm.plugin.vlog.ui.a)this.NED.bp(com.tencent.mm.plugin.vlog.ui.a.class);
      if (paramBundle != null)
      {
        if (paramc == d.c.HRT)
        {
          bool = paramBundle.Nrl;
          if (this.NEI) {
            this.NEI = false;
          }
        }
        else
        {
          if (w.gts()) {
            AD(paramBundle.AQb.fyo());
          }
          AppMethodBeat.o(245978);
          return;
        }
        paramc = (ew)this.NEK;
        if (paramc != null) {
          paramc.mq(1);
        }
        paramc = (ew)this.NEK;
        if (paramc != null) {
          paramc.tk(String.valueOf(cm.bfE()));
        }
        paramc = (ew)this.NEK;
        if (paramc != null) {
          paramc.tl("music_use");
        }
        paramc = (ew)this.NEK;
        Object localObject;
        if (paramc != null)
        {
          localObject = new i();
          if (!bool) {
            break label474;
          }
        }
        for (;;)
        {
          localObject = ((i)localObject).al("tips", i).g("editId", this.editId).toString();
          p.j(localObject, "JSONObject()\n           …)\n            .toString()");
          paramc.tm(n.l((String)localObject, ",", ";", false));
          report();
          break;
          i = 0;
        }
      }
      AppMethodBeat.o(245978);
      return;
      paramc = (com.tencent.mm.plugin.vlog.ui.a)this.NED.bp(com.tencent.mm.plugin.vlog.ui.a.class);
    } while (paramc == null);
    if (paramc.AQb.getSelectFinderVideoPanel().bVd()) {
      AE(paramc.AQb.HYI);
    }
    AppMethodBeat.o(245978);
  }
  
  public final void awV(String paramString)
  {
    AppMethodBeat.i(245967);
    p.k(paramString, "finderContextId");
    ew localew = (ew)this.NEK;
    if (localew != null)
    {
      localew.ti(paramString);
      AppMethodBeat.o(245967);
      return;
    }
    AppMethodBeat.o(245967);
  }
  
  public final String gwC()
  {
    return "21875";
  }
  
  public final BasePluginLayout gwF()
  {
    return this.NED;
  }
  
  public void init()
  {
    AppMethodBeat.i(245971);
    this.NEK = ((com.tencent.mm.plugin.report.a)new ew());
    ew localew = (ew)this.NEK;
    if (localew != null)
    {
      localew.tj("101");
      AppMethodBeat.o(245971);
      return;
    }
    AppMethodBeat.o(245971);
  }
  
  public final void setEditId(String paramString)
  {
    AppMethodBeat.i(245970);
    p.k(paramString, "editId");
    this.editId = paramString;
    AppMethodBeat.o(245970);
  }
  
  public final void setSessionId(String paramString)
  {
    AppMethodBeat.i(245969);
    p.k(paramString, "sessionId");
    ew localew = (ew)this.NEK;
    if (localew != null)
    {
      localew.th(paramString);
      AppMethodBeat.o(245969);
      return;
    }
    AppMethodBeat.o(245969);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport21875$Companion;", "", "()V", "ReportID", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e
 * JD-Core Version:    0.7.0.1
 */