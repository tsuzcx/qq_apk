package com.tencent.mm.plugin.vlog.ui.timelineeditor.report;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ff;
import com.tencent.mm.autogen.mmdata.rpt.gk;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport21874;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderShowInWXProfileStruct;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;)V", "clickTabContextId", "", "enterTime", "", "finderContextId", "fromCommonScene", "", "jumpId", "pageUdfObj", "Lorg/json/JSONObject;", "getPluginLayout", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "setPluginLayout", "sessionId", "getSessionId", "()Ljava/lang/String;", "sessionId$delegate", "Lkotlin/Lazy;", "udfContent", "init", "", "intent", "Landroid/content/Intent;", "onPause", "onResume", "reportId", "reset", "setTemplateInfo", "template", "Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends e<gk>
{
  public static final a UqS;
  private String DUN;
  private String FST;
  public String Fjx;
  private BasePluginLayout UqP;
  private int UqT;
  private long enterTime;
  private final j nWN;
  private JSONObject odL;
  private String zIB;
  
  static
  {
    AppMethodBeat.i(282097);
    UqS = new a((byte)0);
    AppMethodBeat.o(282097);
  }
  
  public c(BasePluginLayout paramBasePluginLayout)
  {
    AppMethodBeat.i(282086);
    this.UqP = paramBasePluginLayout;
    this.nWN = k.cm((a)b.UqU);
    this.FST = "";
    this.DUN = "";
    this.zIB = "";
    this.UqT = -1;
    this.odL = new JSONObject();
    this.Fjx = "";
    AppMethodBeat.o(282086);
  }
  
  private final String getSessionId()
  {
    AppMethodBeat.i(282090);
    String str = (String)this.nWN.getValue();
    AppMethodBeat.o(282090);
    return str;
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(282109);
    s.u(paramc, "status");
    AppMethodBeat.o(282109);
  }
  
  public final void ak(Intent paramIntent)
  {
    AppMethodBeat.i(282115);
    s.u(paramIntent, "intent");
    String str2 = paramIntent.getStringExtra("key_finder_context_id");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = paramIntent.getStringExtra("key_context_id");
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    this.FST = str1;
    str2 = paramIntent.getStringExtra("key_jump_id");
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.DUN = str1;
    str2 = paramIntent.getStringExtra("key_click_tab_context_id");
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.zIB = str1;
    this.UqT = paramIntent.getIntExtra("key_from_comment_scene", 0);
    AppMethodBeat.o(282115);
  }
  
  public final String hUA()
  {
    return "21874";
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(282136);
    super.onPause();
    if (this.enterTime <= 0L)
    {
      AppMethodBeat.o(282136);
      return;
    }
    ff localff = new ff();
    localff.pF(getSessionId());
    localff.pG(this.FST);
    localff.pL(this.zIB);
    localff.pJ(z.bAW());
    localff.pH("101");
    localff.pM(String.valueOf(this.UqT));
    localff.iGK = 1;
    localff.pI(String.valueOf(cn.bDw()));
    localff.iGM = (cn.bDw() - this.enterTime);
    localff.pK(this.Fjx);
    localff.pN(n.m(this.DUN, ",", ";", false));
    localff.bMH();
    AppMethodBeat.o(282136);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(282123);
    super.onResume();
    ff localff = new ff();
    localff.pF(getSessionId());
    localff.pG(this.FST);
    localff.pL(this.zIB);
    localff.pJ(z.bAW());
    localff.pH("101");
    localff.pM(String.valueOf(this.UqT));
    localff.iGK = 0;
    localff.pI(String.valueOf(cn.bDw()));
    localff.iGM = 0L;
    localff.pK(this.Fjx);
    localff.pN(n.m(this.DUN, ",", ";", false));
    localff.bMH();
    this.enterTime = cn.bDw();
    this.odL = new JSONObject();
    AppMethodBeat.o(282123);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport21874$Companion;", "", "()V", "ReportID", "", "TAG", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<String>
  {
    public static final b UqU;
    
    static
    {
      AppMethodBeat.i(282098);
      UqU = new b();
      AppMethodBeat.o(282098);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.report.c
 * JD-Core Version:    0.7.0.1
 */