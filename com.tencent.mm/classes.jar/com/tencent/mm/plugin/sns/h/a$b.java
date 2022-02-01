package com.tencent.mm.plugin.sns.h;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.t;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/keywords/SnsKeywordMatcher$KeywordClickableSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "keyword", "", "(Ljava/lang/String;)V", "callBack", "Lkotlin/Function1;", "", "getCallBack", "()Lkotlin/jvm/functions/Function1;", "setCallBack", "(Lkotlin/jvm/functions/Function1;)V", "getKeyword", "()Ljava/lang/String;", "onClick", "widget", "Landroid/view/View;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  extends t
{
  b<? super String, ah> Qpe;
  private final String hAB;
  
  public a$b(String paramString)
  {
    super(2, null);
    AppMethodBeat.i(306437);
    this.hAB = paramString;
    AppMethodBeat.o(306437);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(306444);
    s.u(paramView, "widget");
    paramView = this.Qpe;
    if (paramView != null) {
      paramView.invoke(this.hAB);
    }
    AppMethodBeat.o(306444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.a.b
 * JD-Core Version:    0.7.0.1
 */