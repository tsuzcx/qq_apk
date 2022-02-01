package com.tencent.mm.plugin.sns.j;

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
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.flr;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/reportflow/SnsTagSearchSpanClickReportFlow;", "", "()V", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a QCu;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(306299);
    QCu = new a((byte)0);
    TAG = "MicroMsg.Sns.SnsTagSearchSpanClickReportFlow";
    AppMethodBeat.o(306299);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/reportflow/SnsTagSearchSpanClickReportFlow$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onDetailPageDescSpanBindView", "", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "view", "Landroid/view/View;", "onItemCommentSpanBindView", "comment", "Lcom/tencent/mm/protocal/protobuf/SnsCommentInfo;", "onItemCommentSpanGenerate", "context", "Landroid/content/Context;", "scene", "", "onItemDescSpanBindView", "childViewId", "struct", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineVendingStruct;", "onItemDescSpanGenerate", "onSnsSingleTextViewBindView", "commentInfo", "registerReporterData", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(Context paramContext, fdv paramfdv, SnsInfo paramSnsInfo, int paramInt)
    {
      AppMethodBeat.i(306309);
      s.u(paramContext, "context");
      s.u(paramfdv, "comment");
      s.u(paramSnsInfo, "snsInfo");
      flr localflr = new flr();
      int i;
      if (t.a(paramfdv))
      {
        i = 5;
        localflr.abMf = i;
        localflr.abMg = (paramSnsInfo.getUserName() + '#' + t.uA(paramSnsInfo.field_snsId) + '#' + paramfdv.Username + '#' + paramfdv.abDh);
        localflr.YKn = paramfdv.CreateTime;
        if (paramInt != 2) {
          break label226;
        }
      }
      label226:
      for (paramInt = 3;; paramInt = 1)
      {
        localflr.abMh = paramInt;
        localflr.abMi = paramSnsInfo.field_type;
        localflr.abMj = paramSnsInfo.localid;
        paramSnsInfo = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramContext = com.tencent.mm.plugin.secdata.ui.a.a.jC(paramContext);
        if (paramContext != null)
        {
          paramContext = paramContext.gUA();
          if (paramContext != null) {
            paramContext.c(s.X("Comment_", Integer.valueOf(paramfdv.hashCode())), (com.tencent.mm.bx.a)localflr);
          }
        }
        Log.i(a.access$getTAG$cp(), s.X("onItemCommentSpanGenerate Comment_", Integer.valueOf(paramfdv.hashCode())));
        AppMethodBeat.o(306309);
        return;
        i = 4;
        break;
      }
    }
    
    public static void a(View paramView, fdv paramfdv)
    {
      AppMethodBeat.i(306314);
      s.u(paramView, "view");
      s.u(paramfdv, "comment");
      Object localObject;
      if ((paramView instanceof SnsCommentCollapseLayout))
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject = ((SnsCommentCollapseLayout)paramView).getContext();
        s.s(localObject, "view.context");
        localObject = com.tencent.mm.plugin.secdata.ui.a.a.jC((Context)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.secdata.ui.a)localObject).gUA();
          if (localObject != null) {
            ((f)localObject).lJ(s.X("Comment_", Integer.valueOf(paramfdv.hashCode())), String.valueOf(((SnsCommentCollapseLayout)paramView).getNormalCommentTv().hashCode()));
          }
        }
        localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject = ((SnsCommentCollapseLayout)paramView).getContext();
        s.s(localObject, "view.context");
        localObject = com.tencent.mm.plugin.secdata.ui.a.a.jC((Context)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.secdata.ui.a)localObject).gUA();
          if (localObject != null)
          {
            ((f)localObject).lJ(s.X("Comment_", Integer.valueOf(paramfdv.hashCode())), String.valueOf(((SnsCommentCollapseLayout)paramView).get2LineCommentTv().hashCode()));
            AppMethodBeat.o(306314);
          }
        }
      }
      else if ((paramView instanceof TextView))
      {
        localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject = ((TextView)paramView).getContext();
        s.s(localObject, "view.context");
        localObject = com.tencent.mm.plugin.secdata.ui.a.a.jC((Context)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.secdata.ui.a)localObject).gUA();
          if (localObject != null) {
            ((f)localObject).lJ(s.X("Comment_", Integer.valueOf(paramfdv.hashCode())), String.valueOf(paramView.hashCode()));
          }
        }
        Log.i(a.access$getTAG$cp(), "onItemCommentSpanBindView Comment_" + paramfdv.hashCode() + ' ' + paramView.hashCode());
      }
      AppMethodBeat.o(306314);
    }
    
    public static void a(SnsInfo paramSnsInfo, View paramView)
    {
      AppMethodBeat.i(306318);
      s.u(paramSnsInfo, "snsInfo");
      s.u(paramView, "view");
      flr localflr = new flr();
      localflr.abMf = 3;
      localflr.abMg = (paramSnsInfo.getUserName() + '#' + t.uA(paramSnsInfo.field_snsId));
      localflr.YKn = paramSnsInfo.field_createTime;
      localflr.abMh = 3;
      localflr.abMi = paramSnsInfo.field_type;
      paramSnsInfo = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramSnsInfo = paramView.getContext();
      s.s(paramSnsInfo, "view.context");
      paramSnsInfo = com.tencent.mm.plugin.secdata.ui.a.a.jC(paramSnsInfo);
      if (paramSnsInfo != null)
      {
        paramSnsInfo = paramSnsInfo.gUA();
        if (paramSnsInfo != null) {
          paramSnsInfo.c(String.valueOf(paramView.hashCode()), (com.tencent.mm.bx.a)localflr);
        }
      }
      AppMethodBeat.o(306318);
    }
    
    public static void jQ(Context paramContext)
    {
      AppMethodBeat.i(306303);
      s.u(paramContext, "context");
      com.tencent.mm.plugin.secdata.ui.a.a locala = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramContext = com.tencent.mm.plugin.secdata.ui.a.a.jC(paramContext);
      if (paramContext != null) {
        paramContext.a((f)new d());
      }
      AppMethodBeat.o(306303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.a
 * JD-Core Version:    0.7.0.1
 */