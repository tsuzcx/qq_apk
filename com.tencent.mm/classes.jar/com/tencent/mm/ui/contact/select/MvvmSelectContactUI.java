package com.tencent.mm.ui.contact.select;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.l;
import com.tencent.mm.ui.contact.select.b.c;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.mvvm.BaseMvvmSelectContactUI;
import com.tencent.mm.ui.mvvm.a.i;
import com.tencent.mm.ui.mvvm.b.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/select/MvvmSelectContactUI;", "Lcom/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI;", "()V", "handleSelectionFromOtherPage", "", "state", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "selectLabel", "label", "", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MvvmSelectContactUI
  extends BaseMvvmSelectContactUI
{
  public static final MvvmSelectContactUI.a aflv;
  
  static
  {
    AppMethodBeat.i(253107);
    aflv = new MvvmSelectContactUI.a((byte)0);
    AppMethodBeat.o(253107);
  }
  
  public final void aLa(String paramString)
  {
    AppMethodBeat.i(253127);
    s.u(paramString, "label");
    com.tencent.mm.plugin.report.service.h.OAn.b(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Object localObject = getStateCenter();
    Intent localIntent;
    if (localObject != null)
    {
      localObject = (i)((UIStateCenter)localObject).getState();
      if (localObject != null)
      {
        localIntent = new Intent();
        localIntent.setClassName((Context)this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        localIntent.putExtra("label", paramString);
        paramString = new HashSet();
        paramString.addAll((Collection)((i)localObject).MS(w.hasAttr(((i)localObject).afhe, 8192)));
        localIntent.putExtra("always_select_contact", Util.listToString((List)new ArrayList((Collection)paramString), ","));
        if (!((i)localObject).gZe()) {
          break label217;
        }
        localIntent.putExtra("list_attr", w.R(new int[] { 16384, 64, 131072 }));
        if (((i)localObject).afbe == 14) {
          localIntent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", 2147483647));
        }
      }
    }
    for (;;)
    {
      startActivityForResult(localIntent, 3);
      AppMethodBeat.o(253127);
      return;
      label217:
      localIntent.putExtra("list_attr", 16384);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(253134);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && (paramInt1 == 3))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      Object localObject = (CharSequence)paramIntent;
      if ((localObject == null) || (n.bp((CharSequence)localObject))) {
        paramInt2 = 1;
      }
      while (paramInt2 == 0)
      {
        localObject = getStateCenter();
        if (localObject != null)
        {
          localObject = (i)((UIStateCenter)localObject).getState();
          if (localObject != null) {
            if (((i)localObject).gZe())
            {
              localObject = getStateCenter();
              if (localObject != null)
              {
                ((UIStateCenter)localObject).dispatch((IStateAction)new com.tencent.mm.ui.contact.select.a.a(n.b((CharSequence)paramIntent, new String[] { "," }), paramInt1));
                AppMethodBeat.o(253134);
                return;
                paramInt2 = 0;
              }
            }
            else
            {
              localObject = getStateCenter();
              if (localObject != null) {
                ((UIStateCenter)localObject).dispatch((IStateAction)new com.tencent.mm.ui.mvvm.a.h(n.b((CharSequence)paramIntent, new String[] { "," }), paramInt1));
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(253134);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253118);
    super.onCreate(paramBundle);
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.observe((q)this, (kotlin.g.a.b)new b(this));
    }
    f.Ozc.idkeyStat(1728L, 1L, 1L, false);
    AppMethodBeat.o(253118);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(253111);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.remove(com.tencent.mm.ui.mvvm.b.a.class);
    paramHashSet.remove(com.tencent.mm.ui.mvvm.b.b.class);
    paramHashSet.add(l.i(com.tencent.mm.ui.contact.select.b.b.class, d.class));
    paramHashSet.add(com.tencent.mm.ui.contact.select.b.a.class);
    paramHashSet.add(c.class);
    AppMethodBeat.o(253111);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<i, ah>
  {
    b(MvvmSelectContactUI paramMvvmSelectContactUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.select.MvvmSelectContactUI
 * JD-Core Version:    0.7.0.1
 */