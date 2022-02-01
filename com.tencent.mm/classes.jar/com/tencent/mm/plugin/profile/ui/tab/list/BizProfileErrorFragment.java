package com.tencent.mm.plugin.profile.ui.tab.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileErrorFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", "errorMsg", "", "errorTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "msgType", "", "getMsgType", "()I", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setErrorMsg", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizProfileErrorFragment
  extends BaseBizProfileFragment
{
  private MMNeat7extView Nez;
  public String errorMsg;
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(306022);
    s.u(paramLayoutInflater, "inflater");
    View localView = paramLayoutInflater.inflate(R.i.ghP, paramViewGroup, false);
    paramLayoutInflater = localView.findViewById(R.h.ftQ);
    s.s(paramLayoutInflater, "view.findViewById(R.id.biz_profile_err_msg_text)");
    this.Nez = ((MMNeat7extView)paramLayoutInflater);
    paramLayoutInflater = this.Nez;
    if (paramLayoutInflater == null)
    {
      s.bIx("errorTextView");
      paramLayoutInflater = null;
      paramViewGroup = this.Nez;
      if (paramViewGroup != null) {
        break label136;
      }
      s.bIx("errorTextView");
      paramViewGroup = null;
    }
    label136:
    for (;;)
    {
      Context localContext = paramLayoutInflater.getContext();
      String str = this.errorMsg;
      paramBundle = str;
      if (str == null)
      {
        s.bIx("errorMsg");
        paramBundle = null;
      }
      paramViewGroup.aZ((CharSequence)p.j(localContext, (CharSequence)paramBundle, (int)paramLayoutInflater.getTextSize()));
      AppMethodBeat.o(306022);
      return localView;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.BizProfileErrorFragment
 * JD-Core Version:    0.7.0.1
 */