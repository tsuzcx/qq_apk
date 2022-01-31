package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.q.b;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(3)
public class MultiTalkSelectContactUI
  extends MMBaseSelectContactUI
{
  private String chatroomName;
  private HashSet<String> gpP;
  private HashSet<String> gpQ;
  private c oTM;
  private boolean oVg;
  private d oVh;
  private boolean oVi;
  
  public MultiTalkSelectContactUI()
  {
    AppMethodBeat.i(54161);
    this.oVi = false;
    this.oTM = new MultiTalkSelectContactUI.2(this);
    AppMethodBeat.o(54161);
  }
  
  private void Km()
  {
    AppMethodBeat.i(54173);
    if (this.gpQ.size() > 0)
    {
      enableOptionMenu(1, true);
      AppMethodBeat.o(54173);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(54173);
  }
  
  public final void Kc()
  {
    AppMethodBeat.i(54162);
    super.Kc();
    this.oVg = getIntent().getBooleanExtra("key_need_gallery", false);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!t.lA(this.chatroomName)) {
      finish();
    }
    this.gpQ = new HashSet();
    this.gpP = new HashSet();
    AppMethodBeat.o(54162);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(54171);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.gpQ.contains(parama.contact.field_username);
      AppMethodBeat.o(54171);
      return bool;
    }
    AppMethodBeat.o(54171);
    return false;
  }
  
  public final boolean apa()
  {
    return false;
  }
  
  public final boolean apb()
  {
    return false;
  }
  
  public final String apc()
  {
    AppMethodBeat.i(54166);
    String str = getIntent().getStringExtra("titile");
    AppMethodBeat.o(54166);
    return str;
  }
  
  public final p apd()
  {
    AppMethodBeat.i(54167);
    a locala = new a(this, this.chatroomName);
    AppMethodBeat.o(54167);
    return locala;
  }
  
  public final n ape()
  {
    AppMethodBeat.i(54168);
    b localb = new b(this, this.chatroomName);
    AppMethodBeat.o(54168);
    return localb;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(54172);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.gpP.contains(parama.contact.field_username);
      AppMethodBeat.o(54172);
      return bool;
    }
    AppMethodBeat.o(54172);
    return false;
  }
  
  public final void bOq()
  {
    AppMethodBeat.i(54170);
    super.bOq();
    hideVKB();
    AppMethodBeat.o(54170);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970323;
  }
  
  public void initView()
  {
    AppMethodBeat.i(54163);
    super.initView();
    setActionbarColor(getResources().getColor(2131689915));
    hideActionbarLine();
    this.oVh = new d(this);
    if (this.oVg) {
      this.oVh.setVisible(true);
    }
    for (;;)
    {
      int i = 2131297018;
      if (this.oVg) {
        i = 2131301700;
      }
      addTextOptionMenu(1, getString(i), new MultiTalkSelectContactUI.1(this), null, q.b.zby);
      Km();
      this.oCs.setBackgroundResource(2131689915);
      this.oCs.getInputText().setTextColor(-1);
      AppMethodBeat.o(54163);
      return;
      this.oVh.setVisible(false);
    }
  }
  
  public final void mL(int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(54169);
    o localo = dLW();
    Object localObject = localo.Qt(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(54169);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(54169);
      return;
    }
    ab.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username });
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    if (r.Zn().equals(localObject))
    {
      AppMethodBeat.o(54169);
      return;
    }
    dMc();
    d locald;
    int i;
    int j;
    if (this.gpQ.contains(localObject)) {
      if (this.oVg)
      {
        locald = this.oVh;
        if (locald.size != 0)
        {
          i = -1;
          paramInt = 0;
          if (paramInt >= locald.oVG.getChildCount()) {
            break label478;
          }
          if (!locald.oVG.getChildAt(paramInt).getTag().equals(localObject)) {
            break label328;
          }
          j = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        i = 0;
        label185:
        if (i < locald.oVH.getChildCount()) {
          if (!locald.oVH.getChildAt(i).getTag().equals(localObject)) {}
        }
      }
      for (paramInt = k;; paramInt = k)
      {
        if (i >= 0)
        {
          if (paramInt != 0)
          {
            locald.oVH.removeViewAt(i);
            locald.size -= 1;
          }
          if (j != 0)
          {
            if (locald.size <= 5)
            {
              locald.oVG.removeViewAt(i);
              locald.size -= 1;
            }
          }
          else
          {
            label283:
            locald.zJ(locald.size);
            locald.zK(locald.size);
          }
        }
        else
        {
          this.gpQ.remove(localObject);
        }
        for (;;)
        {
          localo.notifyDataSetChanged();
          Km();
          AppMethodBeat.o(54169);
          return;
          label328:
          paramInt += 1;
          break;
          i += 1;
          break label185;
          locald.oVG.removeViewAt(i);
          View localView = locald.oVH.getChildAt(0);
          locald.oVH.removeViewAt(0);
          locald.oVG.addView(localView);
          locald.size -= 1;
          break label283;
          if (this.gpP.size() + this.gpQ.size() == 9)
          {
            this.oVi = true;
            Toast.makeText(this, 2131301696, 0).show();
            AppMethodBeat.o(54169);
            return;
          }
          if (this.oVg) {
            this.oVh.UC((String)localObject);
          }
          this.gpQ.add(localObject);
        }
        k = 0;
        i = paramInt;
      }
      label478:
      j = 0;
      paramInt = i;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(54164);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("always_select_contact");
    if (!bo.isNullOrNil(paramBundle)) {
      this.gpP.addAll(bo.P(paramBundle.split(",")));
    }
    this.gpP.add(r.Zn());
    if (this.oVg) {
      this.oVh.UC(r.Zn());
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.oTM);
    AppMethodBeat.o(54164);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(54165);
    com.tencent.mm.sdk.b.a.ymk.d(this.oTM);
    super.onDestroy();
    AppMethodBeat.o(54165);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI
 * JD-Core Version:    0.7.0.1
 */