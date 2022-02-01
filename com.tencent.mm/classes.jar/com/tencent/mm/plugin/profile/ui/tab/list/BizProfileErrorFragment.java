package com.tencent.mm.plugin.profile.ui.tab.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileErrorFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", "errorMsg", "", "errorTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "msgType", "", "getMsgType", "()I", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setErrorMsg", "", "app_release"})
public final class BizProfileErrorFragment
  extends BaseBizProfileFragment
{
  private MMNeat7extView Hhn;
  public String errorMsg;
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(290089);
    p.k(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(R.i.eeW, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(R.h.dtz);
    p.j(paramViewGroup, "view.findViewById(R.id.biz_profile_err_msg_text)");
    this.Hhn = ((MMNeat7extView)paramViewGroup);
    paramViewGroup = this.Hhn;
    if (paramViewGroup == null) {
      p.bGy("errorTextView");
    }
    paramBundle = this.Hhn;
    if (paramBundle == null) {
      p.bGy("errorTextView");
    }
    Context localContext = paramViewGroup.getContext();
    String str = this.errorMsg;
    if (str == null) {
      p.bGy("errorMsg");
    }
    paramBundle.aL((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.k(localContext, (CharSequence)str, (int)paramViewGroup.getTextSize()));
    AppMethodBeat.o(290089);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BizProfileErrorFragment
 * JD-Core Version:    0.7.0.1
 */