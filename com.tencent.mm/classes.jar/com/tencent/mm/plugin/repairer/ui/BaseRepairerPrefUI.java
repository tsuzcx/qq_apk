package com.tencent.mm.plugin.repairer.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.dwp;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerPrefUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "repairerItem", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "getRepairerItem", "()Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "setRepairerItem", "(Lcom/tencent/mm/protocal/protobuf/RepairerItem;)V", "createRepairerItem", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSearchIconLongClick", "view", "Landroid/view/View;", "ui-repairer_release"})
public abstract class BaseRepairerPrefUI
  extends MMSecDataActivity
{
  dwp IvK = new dwp();
  
  public dwp fBe()
  {
    return new dwp();
  }
  
  public int getLayoutId()
  {
    return b.b.IwU;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    Set localSet = super.importUIComponents();
    if (localSet != null) {
      return ak.c(localSet, com.tencent.mm.plugin.repairer.ui.c.a.class);
    }
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      paramIntent = g.Xox;
      paramIntent = (com.tencent.mm.plugin.repairer.ui.c.a)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.repairer.ui.c.a.class);
      LinkedList localLinkedList = this.IvK.Ucr;
      p.j(localLinkedList, "repairerItem.subItemList");
      paramIntent.aa((List)localLinkedList);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = getIntent().getByteArrayExtra("key_config_item_list");
    if ((paramBundle == null) || (this.IvK.parseFrom(paramBundle) == null))
    {
      paramBundle = (BaseRepairerPrefUI)this;
      paramBundle.IvK = paramBundle.fBe();
      paramBundle = x.aazN;
    }
    if (this.IvK.type == 1)
    {
      localObject = this.IvK.name;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      setMMTitle(paramBundle);
    }
    addIconOptionMenu(0, 0, b.c.actionbar_icon_light_search, (MenuItem.OnMenuItemClickListener)new b(this), (View.OnLongClickListener)new c(this));
    paramBundle = g.Xox;
    paramBundle = (com.tencent.mm.plugin.repairer.ui.c.a)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.repairer.ui.c.a.class);
    Object localObject = this.IvK.Ucr;
    p.j(localObject, "repairerItem.subItemList");
    paramBundle.aa((List)localObject);
  }
  
  public void onSearchIconLongClick(View paramView)
  {
    p.k(paramView, "view");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(BaseRepairerPrefUI paramBaseRepairerPrefUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226614);
      this.IvL.onBackPressed();
      AppMethodBeat.o(226614);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(BaseRepairerPrefUI paramBaseRepairerPrefUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226566);
      this.IvL.startActivityForResult(new Intent((Context)this.IvL, RepairerSearchUI.class).putExtra("key_config_item_list", this.IvL.IvK.toByteArray()), 1);
      AppMethodBeat.o(226566);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class c
    implements View.OnLongClickListener
  {
    c(BaseRepairerPrefUI paramBaseRepairerPrefUI) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(226816);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/BaseRepairerPrefUI$onCreate$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
      localObject = this.IvL;
      p.j(paramView, "it");
      ((BaseRepairerPrefUI)localObject).onSearchIconLongClick(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/repairer/ui/BaseRepairerPrefUI$onCreate$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(226816);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.BaseRepairerPrefUI
 * JD-Core Version:    0.7.0.1
 */