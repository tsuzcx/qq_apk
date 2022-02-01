package com.tencent.mm.plugin.vlog.ui.timelineeditor.report;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.gk;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.audio.EditorAudioSelectFinderVideoView;
import com.tencent.mm.plugin.vlog.model.w;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport21875;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderShowInWXProfileStruct;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;)V", "editId", "", "filterFakeMusicUseClick", "", "filterFakeMusicUseExpose", "getPluginLayout", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "setPluginLayout", "init", "", "intent", "Landroid/content/Intent;", "reportFinderMusicUseClick", "expose", "reportFinderMusicUseExpose", "reportId", "reportMusicUseClick", "reportMusicUseExpose", "reset", "setEditId", "setFinderContextId", "finderContextId", "setSessionId", "sessionId", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends e<gk>
{
  public static final a UqV;
  private BasePluginLayout UqP;
  private boolean UqW;
  private boolean UqX;
  private String editId;
  
  static
  {
    AppMethodBeat.i(282105);
    UqV = new a((byte)0);
    AppMethodBeat.o(282105);
  }
  
  public d(BasePluginLayout paramBasePluginLayout)
  {
    AppMethodBeat.i(282100);
    this.UqP = paramBasePluginLayout;
    this.editId = "";
    AppMethodBeat.o(282100);
  }
  
  protected final void Gc(boolean paramBoolean)
  {
    AppMethodBeat.i(282155);
    gk localgk = (gk)this.UqZ;
    if (localgk != null) {
      localgk.iGK = 0;
    }
    localgk = (gk)this.UqZ;
    if (localgk != null) {
      localgk.qX(String.valueOf(cn.bDw()));
    }
    localgk = (gk)this.UqZ;
    if (localgk != null) {
      localgk.qY("like_fav_feed_music");
    }
    localgk = (gk)this.UqZ;
    Object localObject;
    if (localgk != null)
    {
      localObject = new i();
      if (!paramBoolean) {
        break label145;
      }
    }
    label145:
    for (int i = 1;; i = 0)
    {
      localObject = ((i)localObject).au("if_show_reddot", i).m("editId", this.editId).toString();
      s.s(localObject, "JSONObject()\n           …)\n            .toString()");
      localgk.qZ(n.m((String)localObject, ",", ";", false));
      report();
      AppMethodBeat.o(282155);
      return;
    }
  }
  
  protected final void Gd(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(282163);
    gk localgk = (gk)this.UqZ;
    if (localgk != null) {
      localgk.iGK = 1;
    }
    localgk = (gk)this.UqZ;
    if (localgk != null) {
      localgk.qX(String.valueOf(cn.bDw()));
    }
    localgk = (gk)this.UqZ;
    if (localgk != null) {
      localgk.qY("like_fav_feed_music");
    }
    localgk = (gk)this.UqZ;
    Object localObject;
    if (localgk != null)
    {
      localObject = new i();
      if (!paramBoolean) {
        break label145;
      }
    }
    for (;;)
    {
      localObject = ((i)localObject).au("if_show_reddot", i).m("editId", this.editId).toString();
      s.s(localObject, "JSONObject()\n           …)\n            .toString()");
      localgk.qZ(n.m((String)localObject, ",", ";", false));
      report();
      AppMethodBeat.o(282163);
      return;
      label145:
      i = 0;
    }
  }
  
  public void a(a.c paramc, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(282178);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(282178);
      return;
      if (paramc == a.c.NOU)
      {
        this.UqW = true;
        this.UqX = true;
      }
      paramc = (com.tencent.mm.plugin.vlog.ui.a)this.UqP.bZ(com.tencent.mm.plugin.vlog.ui.a.class);
      if (paramc != null)
      {
        boolean bool = paramc.hSn();
        if (this.UqW)
        {
          this.UqW = false;
          AppMethodBeat.o(282178);
          return;
        }
        paramc = (gk)this.UqZ;
        if (paramc != null) {
          paramc.iGK = 0;
        }
        paramc = (gk)this.UqZ;
        if (paramc != null) {
          paramc.qX(String.valueOf(cn.bDw()));
        }
        paramc = (gk)this.UqZ;
        if (paramc != null) {
          paramc.qY("music_use");
        }
        paramc = (gk)this.UqZ;
        if (paramc != null)
        {
          paramBundle = new i();
          if (!bool) {
            break label260;
          }
        }
        label260:
        for (i = 1;; i = 0)
        {
          paramBundle = paramBundle.au("tips", i).m("editId", this.editId).toString();
          s.s(paramBundle, "JSONObject()\n           …)\n            .toString()");
          paramc.qZ(n.m(paramBundle, ",", ";", false));
          report();
          AppMethodBeat.o(282178);
          return;
        }
        paramBundle = (com.tencent.mm.plugin.vlog.ui.a)this.UqP.bZ(com.tencent.mm.plugin.vlog.ui.a.class);
        if (paramBundle != null)
        {
          if (paramc == a.c.NOz)
          {
            bool = paramBundle.UeW;
            if (this.UqX) {
              this.UqX = false;
            }
          }
          else
          {
            if (w.hQS()) {
              Gc(paramBundle.Gso.bZY());
            }
            AppMethodBeat.o(282178);
            return;
          }
          paramc = (gk)this.UqZ;
          if (paramc != null) {
            paramc.iGK = 1;
          }
          paramc = (gk)this.UqZ;
          if (paramc != null) {
            paramc.qX(String.valueOf(cn.bDw()));
          }
          paramc = (gk)this.UqZ;
          if (paramc != null) {
            paramc.qY("music_use");
          }
          paramc = (gk)this.UqZ;
          Object localObject;
          if (paramc != null)
          {
            localObject = new i();
            if (!bool) {
              break label466;
            }
          }
          for (;;)
          {
            localObject = ((i)localObject).au("tips", i).m("editId", this.editId).toString();
            s.s(localObject, "JSONObject()\n           …)\n            .toString()");
            paramc.qZ(n.m((String)localObject, ",", ";", false));
            report();
            break;
            label466:
            i = 0;
          }
          paramc = (com.tencent.mm.plugin.vlog.ui.a)this.UqP.bZ(com.tencent.mm.plugin.vlog.ui.a.class);
          if ((paramc != null) && (paramc.Gso.getSelectFinderVideoPanel().cvt())) {
            Gd(paramc.Gso.NVr);
          }
        }
      }
    }
  }
  
  public void ak(Intent paramIntent)
  {
    AppMethodBeat.i(282144);
    s.u(paramIntent, "intent");
    this.UqZ = ((com.tencent.mm.plugin.report.a)new gk());
    paramIntent = (gk)this.UqZ;
    if (paramIntent != null) {
      paramIntent.qW("101");
    }
    AppMethodBeat.o(282144);
  }
  
  public final void aqZ(String paramString)
  {
    AppMethodBeat.i(282118);
    s.u(paramString, "finderContextId");
    gk localgk = (gk)this.UqZ;
    if (localgk != null) {
      localgk.qV(paramString);
    }
    AppMethodBeat.o(282118);
  }
  
  public final String hUA()
  {
    return "21875";
  }
  
  public final BasePluginLayout hUD()
  {
    return this.UqP;
  }
  
  public final void setEditId(String paramString)
  {
    AppMethodBeat.i(282130);
    s.u(paramString, "editId");
    this.editId = paramString;
    AppMethodBeat.o(282130);
  }
  
  public final void setSessionId(String paramString)
  {
    AppMethodBeat.i(282122);
    s.u(paramString, "sessionId");
    gk localgk = (gk)this.UqZ;
    if (localgk != null) {
      localgk.qU(paramString);
    }
    AppMethodBeat.o(282122);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport21875$Companion;", "", "()V", "ReportID", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.report.d
 * JD-Core Version:    0.7.0.1
 */