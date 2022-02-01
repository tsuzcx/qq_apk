package com.tencent.mm.plugin.sns.i;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.d;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.SnsComment2LinePreloadTextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.eqn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/reportflow/SnsTagSearchSpanClickReportFlow;", "", "()V", "Companion", "plugin-sns_release"})
public final class a
{
  public static final a KeP;
  private static final String TAG = "MicroMsg.Sns.SnsTagSearchSpanClickReportFlow";
  
  static
  {
    AppMethodBeat.i(199838);
    KeP = new a((byte)0);
    TAG = "MicroMsg.Sns.SnsTagSearchSpanClickReportFlow";
    AppMethodBeat.o(199838);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/reportflow/SnsTagSearchSpanClickReportFlow$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onDetailPageDescSpanBindView", "", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "view", "Landroid/view/View;", "onItemCommentSpanBindView", "comment", "Lcom/tencent/mm/protocal/protobuf/SnsCommentInfo;", "onItemCommentSpanGenerate", "context", "Landroid/content/Context;", "scene", "", "onItemDescSpanBindView", "childViewId", "struct", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineVendingStruct;", "onItemDescSpanGenerate", "onSnsSingleTextViewBindView", "commentInfo", "registerReporterData", "plugin-sns_release"})
  public static final class a
  {
    public static void a(Context paramContext, ejo paramejo, SnsInfo paramSnsInfo, int paramInt)
    {
      AppMethodBeat.i(269802);
      p.k(paramContext, "context");
      p.k(paramejo, "comment");
      p.k(paramSnsInfo, "snsInfo");
      eqn localeqn = new eqn();
      int i;
      if (t.a(paramejo))
      {
        i = 5;
        localeqn.UsY = i;
        localeqn.UsZ = (paramSnsInfo.getUserName() + "#" + t.Qu(paramSnsInfo.field_snsId) + "#" + paramejo.Username + "#" + paramejo.Uln);
        localeqn.RMZ = paramejo.CreateTime;
        if (paramInt != 2) {
          break label240;
        }
      }
      label240:
      for (paramInt = 3;; paramInt = 1)
      {
        localeqn.Uta = paramInt;
        localeqn.Utb = paramSnsInfo.field_type;
        localeqn.Utc = paramSnsInfo.localid;
        paramSnsInfo = com.tencent.mm.plugin.secdata.ui.a.JbV;
        paramContext = com.tencent.mm.plugin.secdata.ui.a.a.hU(paramContext);
        if (paramContext != null)
        {
          paramContext = paramContext.fFs();
          if (paramContext != null) {
            paramContext.c("Comment_" + paramejo.hashCode(), (com.tencent.mm.cd.a)localeqn);
          }
        }
        Log.i(a.access$getTAG$cp(), "onItemCommentSpanGenerate Comment_" + paramejo.hashCode());
        AppMethodBeat.o(269802);
        return;
        i = 4;
        break;
      }
    }
    
    public static void a(View paramView, ejo paramejo)
    {
      AppMethodBeat.i(269805);
      p.k(paramView, "view");
      p.k(paramejo, "comment");
      Object localObject;
      if ((paramView instanceof SnsCommentCollapseLayout))
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject = ((SnsCommentCollapseLayout)paramView).getContext();
        p.j(localObject, "view.context");
        localObject = com.tencent.mm.plugin.secdata.ui.a.a.hU((Context)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.secdata.ui.a)localObject).fFs();
          if (localObject != null) {
            ((f)localObject).kk("Comment_" + paramejo.hashCode(), String.valueOf(((SnsCommentCollapseLayout)paramView).getNormalCommentTv().hashCode()));
          }
        }
        localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject = ((SnsCommentCollapseLayout)paramView).getContext();
        p.j(localObject, "view.context");
        localObject = com.tencent.mm.plugin.secdata.ui.a.a.hU((Context)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.secdata.ui.a)localObject).fFs();
          if (localObject != null)
          {
            ((f)localObject).kk("Comment_" + paramejo.hashCode(), String.valueOf(((SnsCommentCollapseLayout)paramView).get2LineCommentTv().hashCode()));
            AppMethodBeat.o(269805);
            return;
          }
        }
        AppMethodBeat.o(269805);
        return;
      }
      if ((paramView instanceof TextView))
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject = ((TextView)paramView).getContext();
        p.j(localObject, "view.context");
        localObject = com.tencent.mm.plugin.secdata.ui.a.a.hU((Context)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.secdata.ui.a)localObject).fFs();
          if (localObject != null) {
            ((f)localObject).kk("Comment_" + paramejo.hashCode(), String.valueOf(paramView.hashCode()));
          }
        }
        Log.i(a.access$getTAG$cp(), "onItemCommentSpanBindView Comment_" + paramejo.hashCode() + ' ' + paramView.hashCode());
      }
      AppMethodBeat.o(269805);
    }
    
    public static void a(SnsInfo paramSnsInfo, View paramView)
    {
      AppMethodBeat.i(269807);
      p.k(paramSnsInfo, "snsInfo");
      p.k(paramView, "view");
      eqn localeqn = new eqn();
      localeqn.UsY = 3;
      localeqn.UsZ = (paramSnsInfo.getUserName() + "#" + t.Qu(paramSnsInfo.field_snsId));
      localeqn.RMZ = paramSnsInfo.field_createTime;
      localeqn.Uta = 3;
      localeqn.Utb = paramSnsInfo.field_type;
      paramSnsInfo = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramSnsInfo = paramView.getContext();
      p.j(paramSnsInfo, "view.context");
      paramSnsInfo = com.tencent.mm.plugin.secdata.ui.a.a.hU(paramSnsInfo);
      if (paramSnsInfo != null)
      {
        paramSnsInfo = paramSnsInfo.fFs();
        if (paramSnsInfo != null)
        {
          paramSnsInfo.c(String.valueOf(paramView.hashCode()), (com.tencent.mm.cd.a)localeqn);
          AppMethodBeat.o(269807);
          return;
        }
      }
      AppMethodBeat.o(269807);
    }
    
    public static void ia(Context paramContext)
    {
      AppMethodBeat.i(269801);
      p.k(paramContext, "context");
      com.tencent.mm.plugin.secdata.ui.a.a locala = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramContext = com.tencent.mm.plugin.secdata.ui.a.a.hU(paramContext);
      if (paramContext != null)
      {
        paramContext.a((f)new d());
        AppMethodBeat.o(269801);
        return;
      }
      AppMethodBeat.o(269801);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.a
 * JD-Core Version:    0.7.0.1
 */