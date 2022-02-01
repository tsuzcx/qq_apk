package com.tencent.mm.plugin.sns.i;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.d;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.SnsComment2LinePreloadTextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/sns/reportflow/SnsTagSearchSpanClickReportFlow;", "", "()V", "Companion", "plugin-sns_release"})
public final class a
{
  public static final a DRI;
  private static final String TAG = "MicroMsg.Sns.SnsTagSearchSpanClickReportFlow";
  
  static
  {
    AppMethodBeat.i(201806);
    DRI = new a((byte)0);
    TAG = "MicroMsg.Sns.SnsTagSearchSpanClickReportFlow";
    AppMethodBeat.o(201806);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/sns/reportflow/SnsTagSearchSpanClickReportFlow$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onDetailPageDescSpanBindView", "", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "view", "Landroid/view/View;", "onItemCommentSpanBindView", "comment", "Lcom/tencent/mm/protocal/protobuf/SnsCommentInfo;", "onItemCommentSpanGenerate", "context", "Landroid/content/Context;", "scene", "", "onItemDescSpanBindView", "childViewId", "struct", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineVendingStruct;", "onItemDescSpanGenerate", "onSnsSingleTextViewBindView", "commentInfo", "registerReporterData", "plugin-sns_release"})
  public static final class a
  {
    public static void a(Context paramContext, dzo paramdzo, SnsInfo paramSnsInfo, int paramInt)
    {
      AppMethodBeat.i(201803);
      p.h(paramContext, "context");
      p.h(paramdzo, "comment");
      p.h(paramSnsInfo, "snsInfo");
      egl localegl = new egl();
      int i;
      if (r.a(paramdzo))
      {
        i = 5;
        localegl.Ngu = i;
        localegl.Ngv = (paramSnsInfo.getUserName() + "#" + r.Jb(paramSnsInfo.field_snsId) + "#" + paramdzo.Username + "#" + paramdzo.MYT);
        localegl.KMc = paramdzo.CreateTime;
        if (paramInt != 2) {
          break label240;
        }
      }
      label240:
      for (paramInt = 3;; paramInt = 1)
      {
        localegl.Ngw = paramInt;
        localegl.Ngx = paramSnsInfo.field_type;
        localegl.Ngy = paramSnsInfo.localid;
        paramSnsInfo = SecDataUIC.CWq;
        paramContext = SecDataUIC.a.gU(paramContext);
        if (paramContext != null)
        {
          paramContext = paramContext.eSr();
          if (paramContext != null) {
            paramContext.c("Comment_" + paramdzo.hashCode(), (com.tencent.mm.bw.a)localegl);
          }
        }
        Log.i(a.access$getTAG$cp(), "onItemCommentSpanGenerate Comment_" + paramdzo.hashCode());
        AppMethodBeat.o(201803);
        return;
        i = 4;
        break;
      }
    }
    
    public static void a(View paramView, dzo paramdzo)
    {
      AppMethodBeat.i(201804);
      p.h(paramView, "view");
      p.h(paramdzo, "comment");
      Object localObject;
      if ((paramView instanceof SnsCommentCollapseLayout))
      {
        localObject = SecDataUIC.CWq;
        localObject = ((SnsCommentCollapseLayout)paramView).getContext();
        p.g(localObject, "view.context");
        localObject = SecDataUIC.a.gU((Context)localObject);
        if (localObject != null)
        {
          localObject = ((SecDataUIC)localObject).eSr();
          if (localObject != null) {
            ((f)localObject).jS("Comment_" + paramdzo.hashCode(), String.valueOf(((SnsCommentCollapseLayout)paramView).getNormalCommentTv().hashCode()));
          }
        }
        localObject = SecDataUIC.CWq;
        localObject = ((SnsCommentCollapseLayout)paramView).getContext();
        p.g(localObject, "view.context");
        localObject = SecDataUIC.a.gU((Context)localObject);
        if (localObject != null)
        {
          localObject = ((SecDataUIC)localObject).eSr();
          if (localObject != null)
          {
            ((f)localObject).jS("Comment_" + paramdzo.hashCode(), String.valueOf(((SnsCommentCollapseLayout)paramView).get2LineCommentTv().hashCode()));
            AppMethodBeat.o(201804);
            return;
          }
        }
        AppMethodBeat.o(201804);
        return;
      }
      if ((paramView instanceof TextView))
      {
        localObject = SecDataUIC.CWq;
        localObject = ((TextView)paramView).getContext();
        p.g(localObject, "view.context");
        localObject = SecDataUIC.a.gU((Context)localObject);
        if (localObject != null)
        {
          localObject = ((SecDataUIC)localObject).eSr();
          if (localObject != null) {
            ((f)localObject).jS("Comment_" + paramdzo.hashCode(), String.valueOf(paramView.hashCode()));
          }
        }
        Log.i(a.access$getTAG$cp(), "onItemCommentSpanBindView Comment_" + paramdzo.hashCode() + ' ' + paramView.hashCode());
      }
      AppMethodBeat.o(201804);
    }
    
    public static void a(SnsInfo paramSnsInfo, View paramView)
    {
      AppMethodBeat.i(201805);
      p.h(paramSnsInfo, "snsInfo");
      p.h(paramView, "view");
      egl localegl = new egl();
      localegl.Ngu = 3;
      localegl.Ngv = (paramSnsInfo.getUserName() + "#" + r.Jb(paramSnsInfo.field_snsId));
      localegl.KMc = paramSnsInfo.field_createTime;
      localegl.Ngw = 3;
      localegl.Ngx = paramSnsInfo.field_type;
      paramSnsInfo = SecDataUIC.CWq;
      paramSnsInfo = paramView.getContext();
      p.g(paramSnsInfo, "view.context");
      paramSnsInfo = SecDataUIC.a.gU(paramSnsInfo);
      if (paramSnsInfo != null)
      {
        paramSnsInfo = paramSnsInfo.eSr();
        if (paramSnsInfo != null)
        {
          paramSnsInfo.c(String.valueOf(paramView.hashCode()), (com.tencent.mm.bw.a)localegl);
          AppMethodBeat.o(201805);
          return;
        }
      }
      AppMethodBeat.o(201805);
    }
    
    public static void gZ(Context paramContext)
    {
      AppMethodBeat.i(201802);
      p.h(paramContext, "context");
      SecDataUIC.a locala = SecDataUIC.CWq;
      paramContext = SecDataUIC.a.gU(paramContext);
      if (paramContext != null)
      {
        paramContext.a((f)new d());
        AppMethodBeat.o(201802);
        return;
      }
      AppMethodBeat.o(201802);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.a
 * JD-Core Version:    0.7.0.1
 */