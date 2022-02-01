package com.tencent.mm.plugin.sns.cover.preview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.cover.a.f.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/preview/SnsBackPreviewFactory;", "", "()V", "SNS_BACK_PREVIEW_BLOCK", "", "SNS_BACK_PREVIEW_DEFAULT", "SNS_BACK_PREVIEW_FINDER_IMAGE", "SNS_BACK_PREVIEW_FINDER_VIDEO", "SNS_BACK_PREVIEW_IMAGE", "SNS_BACK_PREVIEW_VIDEO", "SNS_BACK_PREVIEW_WECOM", "TAG", "", "getSnsBackViewByType", "Lcom/tencent/mm/plugin/sns/cover/api/AbsSnsBackPreview;", "context", "Landroid/content/Context;", "type", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a QlC;
  
  static
  {
    AppMethodBeat.i(307454);
    QlC = new a();
    AppMethodBeat.o(307454);
  }
  
  public static com.tencent.mm.plugin.sns.cover.a.a aW(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(307444);
    s.u(paramContext, "context");
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      com.tencent.mm.plugin.sns.cover.b.a locala = com.tencent.mm.plugin.sns.cover.b.a.QkS;
      if (com.tencent.mm.plugin.sns.cover.b.a.hes()) {
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(307444);
          return null;
        }
      }
      break;
    case 1: 
      paramContext = (com.tencent.mm.plugin.sns.cover.a.a)new c(paramContext);
      AppMethodBeat.o(307444);
      return paramContext;
    case 5: 
      paramContext = (com.tencent.mm.plugin.sns.cover.a.a)new d(paramContext);
      AppMethodBeat.o(307444);
      return paramContext;
    case 0: 
      paramContext = (com.tencent.mm.plugin.sns.cover.a.a)new b(paramContext);
      AppMethodBeat.o(307444);
      return paramContext;
    case 6: 
      paramContext = (com.tencent.mm.plugin.sns.cover.a.a)new f(paramContext);
      AppMethodBeat.o(307444);
      return paramContext;
      paramContext = (com.tencent.mm.plugin.sns.cover.a.a)new e(paramContext);
      AppMethodBeat.o(307444);
      return paramContext;
      paramContext = com.tencent.mm.plugin.sns.cover.a.f.her().QkR.go(paramContext);
      AppMethodBeat.o(307444);
      return paramContext;
      paramContext = com.tencent.mm.plugin.sns.cover.a.f.her().QkR.gp(paramContext);
      AppMethodBeat.o(307444);
      return paramContext;
    }
    paramContext = (com.tencent.mm.plugin.sns.cover.a.a)new c(paramContext);
    AppMethodBeat.o(307444);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.preview.a
 * JD-Core Version:    0.7.0.1
 */