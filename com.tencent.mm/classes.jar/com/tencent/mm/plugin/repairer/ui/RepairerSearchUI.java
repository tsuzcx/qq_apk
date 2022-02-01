package com.tencent.mm.plugin.repairer.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dwp;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/RepairerSearchUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "ftsSearchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getFtsSearchView", "()Lcom/tencent/mm/ui/search/FTSSearchView;", "setFtsSearchView", "(Lcom/tencent/mm/ui/search/FTSSearchView;)V", "repairerItem", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "getRepairerItem", "()Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "setRepairerItem", "(Lcom/tencent/mm/protocal/protobuf/RepairerItem;)V", "repairerItemIndexList", "Ljava/util/LinkedList;", "getRepairerItemIndexList", "()Ljava/util/LinkedList;", "buildSearchIndex", "", "indexList", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initSearchView", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "onTagClick", "index", "tag", "ui-repairer_release"})
public class RepairerSearchUI
  extends MMSecDataActivity
  implements FTSEditTextView.b, a.b
{
  private com.tencent.mm.ui.search.a BMN;
  private dwp IvK;
  private final LinkedList<dwp> Ixd;
  
  public RepairerSearchUI()
  {
    AppMethodBeat.i(227240);
    this.IvK = new dwp();
    this.Ixd = new LinkedList();
    AppMethodBeat.o(227240);
  }
  
  private void a(dwp paramdwp, LinkedList<dwp> paramLinkedList)
  {
    AppMethodBeat.i(227223);
    p.k(paramdwp, "repairerItem");
    p.k(paramLinkedList, "indexList");
    paramdwp = paramdwp.Ucr;
    p.j(paramdwp, "repairerItem.subItemList");
    paramdwp = ((Iterable)paramdwp).iterator();
    while (paramdwp.hasNext())
    {
      dwp localdwp = (dwp)paramdwp.next();
      if (localdwp.type == 1)
      {
        p.j(localdwp, "it");
        a(localdwp, paramLinkedList);
      }
      else
      {
        paramLinkedList.add(localdwp);
      }
    }
    AppMethodBeat.o(227223);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(227235);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(227235);
        throw paramString1;
      }
      paramString1 = n.bb((CharSequence)paramString1).toString();
      if (paramString1 != null)
      {
        int i;
        if (((CharSequence)paramString1).length() > 0)
        {
          i = 1;
          if (i == 0) {
            break label155;
          }
        }
        label155:
        for (;;)
        {
          label65:
          if (paramString1 != null)
          {
            paramString2 = new LinkedList();
            paramList = ((Iterable)this.Ixd).iterator();
            for (;;)
            {
              if (paramList.hasNext())
              {
                paramc = (dwp)paramList.next();
                String str = paramc.name;
                p.j(str, "it.name");
                if (n.g((CharSequence)str, (CharSequence)paramString1))
                {
                  paramString2.add(paramc);
                  continue;
                  i = 0;
                  break;
                  paramString1 = null;
                  break label65;
                }
              }
            }
            paramString1 = g.Xox;
            ((com.tencent.mm.plugin.repairer.ui.c.a)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.repairer.ui.c.a.class)).aa((List)paramString2);
            AppMethodBeat.o(227235);
            return;
          }
        }
      }
    }
    paramString1 = (RepairerSearchUI)this;
    paramString2 = g.Xox;
    ((com.tencent.mm.plugin.repairer.ui.c.a)g.b((AppCompatActivity)paramString1).i(com.tencent.mm.plugin.repairer.ui.c.a.class)).aa((List)new LinkedList());
    AppMethodBeat.o(227235);
  }
  
  public final boolean aDV()
  {
    return false;
  }
  
  public final void dvg() {}
  
  public final void eF(boolean paramBoolean) {}
  
  public int getLayoutId()
  {
    return b.b.IwU;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(227210);
    Set localSet = super.importUIComponents();
    if (localSet != null)
    {
      localSet = ak.c(localSet, com.tencent.mm.plugin.repairer.ui.c.a.class);
      AppMethodBeat.o(227210);
      return localSet;
    }
    AppMethodBeat.o(227210);
    return null;
  }
  
  public void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(227225);
    finish();
    AppMethodBeat.o(227225);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(227224);
    finish();
    AppMethodBeat.o(227224);
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(227236);
    showVKB();
    AppMethodBeat.o(227236);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(227218);
    super.onCreate(paramBundle);
    this.BMN = new com.tencent.mm.ui.search.a((Context)this);
    paramBundle = this.BMN;
    if (paramBundle != null) {
      paramBundle.setSearchViewListener((a.b)this);
    }
    paramBundle = this.BMN;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getFtsEditText();
      if (paramBundle != null) {
        paramBundle.setHint("搜索配置");
      }
    }
    paramBundle = this.BMN;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getFtsEditText();
      if (paramBundle != null) {
        paramBundle.hXB();
      }
    }
    paramBundle = this.BMN;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getFtsEditText();
      if (paramBundle != null) {
        paramBundle.setFtsEditTextListener((FTSEditTextView.b)this);
      }
    }
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.setCustomView((View)this.BMN);
    }
    paramBundle = this.BMN;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getFtsEditText();
      if (paramBundle != null) {
        paramBundle.aDU();
      }
    }
    paramBundle = this.BMN;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getFtsEditText();
      if (paramBundle != null) {
        paramBundle.aDT();
      }
    }
    paramBundle = getIntent().getByteArrayExtra("key_config_item_list");
    if (paramBundle != null) {
      this.IvK.parseFrom(paramBundle);
    }
    a(this.IvK, this.Ixd);
    AppMethodBeat.o(227218);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(227226);
    hideVKB();
    super.onDestroy();
    AppMethodBeat.o(227226);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerSearchUI
 * JD-Core Version:    0.7.0.1
 */