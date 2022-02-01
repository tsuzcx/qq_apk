package com.tencent.mm.plugin.profile.ui.tab.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileErrorFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", "errorMsg", "", "errorTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "msgType", "", "getMsgType", "()I", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setErrorMsg", "", "app_release"})
public final class BizProfileErrorFragment
  extends BaseBizProfileFragment
{
  private MMNeat7extView BmS;
  public String errorMsg;
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(230723);
    p.h(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131493727, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(2131297459);
    p.g(paramViewGroup, "view.findViewById(R.id.biz_profile_err_msg_text)");
    this.BmS = ((MMNeat7extView)paramViewGroup);
    paramViewGroup = this.BmS;
    if (paramViewGroup == null) {
      p.btv("errorTextView");
    }
    paramBundle = this.BmS;
    if (paramBundle == null) {
      p.btv("errorTextView");
    }
    Context localContext = paramViewGroup.getContext();
    String str = this.errorMsg;
    if (str == null) {
      p.btv("errorMsg");
    }
    paramBundle.aw((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.j(localContext, (CharSequence)str, (int)paramViewGroup.getTextSize()));
    AppMethodBeat.o(230723);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BizProfileErrorFragment
 * JD-Core Version:    0.7.0.1
 */