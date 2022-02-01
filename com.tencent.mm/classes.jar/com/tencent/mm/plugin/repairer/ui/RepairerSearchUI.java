package com.tencent.mm.plugin.repairer.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.uic.c;
import com.tencent.mm.plugin.repairer.ui.uic.d;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.b;
import com.tencent.mm.ui.search.FTSSearchView.c;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerSearchUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "ftsSearchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getFtsSearchView", "()Lcom/tencent/mm/ui/search/FTSSearchView;", "setFtsSearchView", "(Lcom/tencent/mm/ui/search/FTSSearchView;)V", "getLayoutId", "", "initSearchView", "", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "onTagClick", "index", "tag", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public class RepairerSearchUI
  extends BaseRepairerUI
  implements FTSEditTextView.c, FTSSearchView.b
{
  FTSSearchView Hye;
  
  private static final boolean a(RepairerSearchUI paramRepairerSearchUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(277891);
    s.u(paramRepairerSearchUI, "this$0");
    paramRepairerSearchUI.finish();
    AppMethodBeat.o(277891);
    return true;
  }
  
  public final boolean aWU()
  {
    return false;
  }
  
  public final void eeU() {}
  
  public final void fq(boolean paramBoolean) {}
  
  public int getLayoutId()
  {
    return b.d.Owd;
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(277936);
    finish();
    AppMethodBeat.o(277936);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(277929);
    finish();
    AppMethodBeat.o(277929);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(277965);
    showVKB();
    AppMethodBeat.o(277965);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277923);
    super.onCreate(paramBundle);
    setBackBtn(new RepairerSearchUI..ExternalSyntheticLambda0(this));
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.observe((q)this, (b)new RepairerSearchUI.a(this));
    }
    AppMethodBeat.o(277923);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(277940);
    hideVKB();
    super.onDestroy();
    AppMethodBeat.o(277940);
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(277954);
    if (paramString1 != null)
    {
      paramString1 = n.bq((CharSequence)paramString1).toString();
      if (paramString1 != null)
      {
        paramString2 = getStateCenter();
        if (paramString2 != null) {
          paramString2.dispatch((IStateAction)new com.tencent.mm.plugin.repairer.ui.d.e(paramString1));
        }
      }
    }
    AppMethodBeat.o(277954);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(277910);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(c.class);
    paramHashSet.add(com.tencent.mm.plugin.repairer.ui.uic.e.class);
    paramHashSet.add(d.class);
    AppMethodBeat.o(277910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerSearchUI
 * JD-Core Version:    0.7.0.1
 */