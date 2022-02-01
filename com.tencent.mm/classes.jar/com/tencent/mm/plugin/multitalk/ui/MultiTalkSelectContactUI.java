package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.multitalk.b.m;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.plugin.multitalk.ui.widget.d.2;
import com.tencent.mm.plugin.multitalk.ui.widget.d.3;
import com.tencent.mm.plugin.multitalk.ui.widget.l;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MultiTalkSelectContactUI
  extends MMBaseSelectContactUI
{
  private String chatroomName;
  private IListener hXn;
  private HashSet<String> jVU;
  private HashSet<String> jVV;
  boolean zQc;
  private ArrayList<String> zQd;
  private Activity zQe;
  private boolean zQf;
  private l zQg;
  private RecyclerView zQh;
  private boolean zQi;
  private d zQj;
  private View.OnClickListener zQk;
  
  public MultiTalkSelectContactUI()
  {
    AppMethodBeat.i(114694);
    this.zQc = true;
    this.zQi = false;
    this.zQk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178897);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((paramAnonymousView instanceof ImageView))
        {
          localObject = (String)paramAnonymousView.getTag();
          paramAnonymousView = MultiTalkSelectContactUI.this.gUP();
          if (z.aTY().equals(localObject))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178897);
            return;
          }
          MultiTalkSelectContactUI.f(MultiTalkSelectContactUI.this);
          if (MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).contains(localObject))
          {
            if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this)) {
              MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).KK((String)localObject);
            }
            MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).remove(localObject);
            MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this).remove(localObject);
          }
          ((com.tencent.mm.plugin.multitalk.ui.widget.q)MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter()).b(MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this), MultiTalkSelectContactUI.h(MultiTalkSelectContactUI.this));
          localObject = MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = c.a(MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.notifyDataSetChanged();
          MultiTalkSelectContactUI.j(MultiTalkSelectContactUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(178897);
      }
    };
    this.hXn = new IListener() {};
    this.zQe = this;
    AppMethodBeat.o(114694);
  }
  
  private void ani()
  {
    AppMethodBeat.i(114706);
    if (this.jVV.size() > 0)
    {
      updateOptionMenuText(1, getString(2131763288, new Object[] { Integer.valueOf(this.jVU.size() + this.jVV.size()) }));
      enableOptionMenu(1, true);
      AppMethodBeat.o(114706);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(114706);
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(239454);
    paramView = gUP();
    Object localObject1 = paramView.anH(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject1 == null)
    {
      AppMethodBeat.o(239454);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject1).contact == null)
    {
      AppMethodBeat.o(239454);
      return;
    }
    Log.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_username });
    localObject1 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_username;
    if (z.aTY().equals(localObject1))
    {
      AppMethodBeat.o(239454);
      return;
    }
    gUW();
    if (this.jVU.contains(localObject1))
    {
      AppMethodBeat.o(239454);
      return;
    }
    int i;
    Object localObject2;
    View.OnClickListener localOnClickListener;
    Object localObject3;
    if (this.jVV.contains(localObject1))
    {
      if (this.zQf) {
        this.zQg.KK((String)localObject1);
      }
      this.jVV.remove(localObject1);
      i = this.zQd.indexOf(localObject1);
      this.zQd.remove(localObject1);
      localObject1 = (com.tencent.mm.plugin.multitalk.ui.widget.q)this.zQh.getAdapter();
      localObject2 = this.zQd;
      localOnClickListener = this.zQk;
      kotlin.g.b.p.h(localObject2, "userNameList");
      kotlin.g.b.p.h(localOnClickListener, "onClickListener");
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).uae.clear();
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).uae.add(z.aTY());
      int j = ((Collection)localObject2).size();
      paramInt = 0;
      while (paramInt < j)
      {
        localObject3 = ((ArrayList)localObject2).get(paramInt);
        kotlin.g.b.p.g(localObject3, "userNameList[i]");
        if ((!((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).aGC((String)localObject3)) && ((kotlin.g.b.p.j((String)((ArrayList)localObject2).get(paramInt), z.aTY()) ^ true))) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).uae.add(((ArrayList)localObject2).get(paramInt));
        }
        paramInt += 1;
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).zVf = localOnClickListener;
      if (((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).uae.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).ci(((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).wqJ + paramInt);
          paramInt += 1;
        }
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).ck(((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).wqJ + i);
    }
    for (;;)
    {
      localObject1 = this.zQh;
      localObject2 = c.a(this.zQh.getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      paramView.notifyDataSetChanged();
      ani();
      AppMethodBeat.o(239454);
      return;
      if (this.jVU.size() + this.jVV.size() == com.tencent.mm.plugin.multitalk.d.e.epZ())
      {
        this.zQi = true;
        com.tencent.mm.plugin.multitalk.d.b.gG(this);
        AppMethodBeat.o(239454);
        return;
      }
      if (this.zQf) {
        this.zQg.aGw((String)localObject1);
      }
      this.jVV.add(localObject1);
      this.zQd.add(localObject1);
      localObject1 = (com.tencent.mm.plugin.multitalk.ui.widget.q)this.zQh.getAdapter();
      localObject2 = this.zQd;
      localOnClickListener = this.zQk;
      kotlin.g.b.p.h(localObject2, "userNameList");
      kotlin.g.b.p.h(localOnClickListener, "onClickListener");
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).uae.clear();
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).uae.add(z.aTY());
      i = ((Collection)localObject2).size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject3 = ((ArrayList)localObject2).get(paramInt);
        kotlin.g.b.p.g(localObject3, "userNameList[i]");
        if ((!((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).aGC((String)localObject3)) && ((kotlin.g.b.p.j((String)((ArrayList)localObject2).get(paramInt), z.aTY()) ^ true))) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).uae.add(((ArrayList)localObject2).get(paramInt));
        }
        paramInt += 1;
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).zVf = localOnClickListener;
      if (((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).uae.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).ci(((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).wqJ + paramInt);
          paramInt += 1;
        }
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).cj(((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).getItemCount());
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114704);
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.jVV.contains(parama.contact.field_username);
      AppMethodBeat.o(114704);
      return bool;
    }
    AppMethodBeat.o(114704);
    return false;
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(114695);
    super.amZ();
    this.zQf = getIntent().getBooleanExtra("key_need_gallery", false);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!ab.Eq(this.chatroomName)) {
      finish();
    }
    this.jVV = new HashSet();
    this.jVU = new HashSet();
    this.zQd = new ArrayList();
    AppMethodBeat.o(114695);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114705);
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.jVU.contains(parama.contact.field_username);
      AppMethodBeat.o(114705);
      return bool;
    }
    AppMethodBeat.o(114705);
    return false;
  }
  
  public final boolean bmA()
  {
    return false;
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(114699);
    String str = getIntent().getStringExtra("titile");
    AppMethodBeat.o(114699);
    return str;
  }
  
  public final com.tencent.mm.ui.contact.q bmC()
  {
    AppMethodBeat.i(114700);
    a locala = new a(this, this.chatroomName);
    AppMethodBeat.o(114700);
    return locala;
  }
  
  public final o bmD()
  {
    AppMethodBeat.i(114701);
    b localb = new b(this, this.chatroomName);
    AppMethodBeat.o(114701);
    return localb;
  }
  
  public final boolean bmz()
  {
    return false;
  }
  
  public void egJ()
  {
    AppMethodBeat.i(114703);
    super.egJ();
    hideVKB();
    if (this.zQc) {
      f.e(false, true, true);
    }
    AppMethodBeat.o(114703);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495754;
  }
  
  public void initView()
  {
    AppMethodBeat.i(114696);
    super.initView();
    this.zQj = new d(this);
    Object localObject;
    ListView localListView;
    int i;
    if ((!this.zQj.zRI) && (com.tencent.mm.plugin.multitalk.d.b.epM()))
    {
      localObject = this.zQj;
      localListView = this.Bvb;
      ((d)localObject).jBN = ListView.inflate(((d)localObject).mContext, 2131495728, null);
      ((d)localObject).jBN.getViewTreeObserver().addOnDrawListener(((d)localObject).zRO);
      ((d)localObject).jBN.setOnClickListener(new d.2((d)localObject));
      ((d)localObject).zRJ = ((WxImageView)((d)localObject).jBN.findViewById(2131304644));
      ((d)localObject).zRL = ((TextView)((d)localObject).jBN.findViewById(2131304576));
      ((d)localObject).zRK = ((TextView)((d)localObject).jBN.findViewById(2131304577));
      ((d)localObject).zRM = ((WxImageView)((d)localObject).jBN.findViewById(2131304861));
      ((d)localObject).zRM.setBackground(ar.m(MMApplicationContext.getContext(), 2131690481, -1));
      if ((Util.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.epT())) || (Util.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.epU()))) {
        break label491;
      }
      ((d)localObject).zRK.setText(com.tencent.mm.plugin.multitalk.d.b.epT());
      ((d)localObject).zRL.setText(com.tencent.mm.plugin.multitalk.d.b.epU());
      i = 1;
    }
    for (;;)
    {
      if (!Util.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.getIconUrl()))
      {
        com.tencent.mm.av.q.bcV().a(com.tencent.mm.plugin.multitalk.d.b.getIconUrl(), null, new d.3((d)localObject));
        label244:
        localListView.removeFooterView(((d)localObject).jBN);
        if (i == 0) {
          break label605;
        }
        ((d)localObject).zRI = true;
        localListView.addFooterView(((d)localObject).jBN);
        label270:
        setActionbarColor(getResources().getColor(2131100229));
        hideActionbarLine();
        getController().setNavigationbarColor(Color.parseColor("#232323"));
        this.zQg = new l(this);
        localObject = getString(2131763288, new Object[] { Integer.valueOf(this.jVU.size() + this.jVV.size()) });
        if (!this.zQf) {
          break label622;
        }
        localObject = getString(2131763303, new Object[] { Integer.valueOf(this.jVU.size() + this.jVV.size()) });
      }
      label491:
      label622:
      for (;;)
      {
        addTextOptionMenu(1, (String)localObject, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(114692);
            if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
              com.tencent.mm.bh.e.a(MultiTalkSelectContactUI.this, 2131767334, null);
            }
            for (;;)
            {
              MultiTalkSelectContactUI.this.hideVKB();
              AppMethodBeat.o(114692);
              return true;
              paramAnonymousMenuItem = new LinkedList();
              paramAnonymousMenuItem.addAll(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this));
              paramAnonymousMenuItem.add(z.aTY());
              paramAnonymousMenuItem = Util.listToString(paramAnonymousMenuItem, ",");
              if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this))
              {
                com.tencent.mm.plugin.multitalk.model.p.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 1, "", MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).zTH);
                ac.eom().c(MultiTalkSelectContactUI.this, paramAnonymousMenuItem, MultiTalkSelectContactUI.e(MultiTalkSelectContactUI.this));
              }
              else
              {
                com.tencent.mm.plugin.multitalk.model.p.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 2, v.enW(), 0);
                MultiTalkSelectContactUI.this.setResult(-1, MultiTalkSelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
                MultiTalkSelectContactUI.this.zQc = false;
                MultiTalkSelectContactUI.this.finish();
              }
            }
          }
        }, null, t.b.OGU);
        ani();
        this.zoy.setBackgroundResource(2131100241);
        this.zoy.getInputText().setTextColor(-1);
        if (this.zoy != null)
        {
          localObject = this.zoy;
          if (((MultiSelectContactView)localObject).KcC != null)
          {
            ((MultiSelectContactView)localObject).KcC.setHintTextColor(((MultiSelectContactView)localObject).getResources().getColor(2131099676));
            ((MultiSelectContactView)localObject).KcC.setTextColor(((MultiSelectContactView)localObject).getResources().getColor(2131099676));
          }
        }
        m.czc();
        AppMethodBeat.o(114696);
        return;
        if (com.tencent.mm.plugin.multitalk.d.b.epN())
        {
          ((d)localObject).zRK.setText(2131763318);
          ((d)localObject).zRL.setText(2131763002);
          i = 1;
          break;
        }
        if (!com.tencent.mm.plugin.multitalk.d.b.epO()) {
          break label625;
        }
        ((d)localObject).zRK.setText(2131763319);
        ((d)localObject).zRL.setText(2131768740);
        i = 1;
        break;
        if (com.tencent.mm.plugin.multitalk.d.b.epN())
        {
          ((d)localObject).zRJ.setBackground(ar.m(MMApplicationContext.getContext(), 2131690917, -1));
          break label244;
        }
        if (!com.tencent.mm.plugin.multitalk.d.b.epO()) {
          break label244;
        }
        ((d)localObject).zRJ.setBackground(ar.m(MMApplicationContext.getContext(), 2131690945, -1));
        break label244;
        ((d)localObject).zRI = true;
        Log.e("MicroMsg.MeetingLinkFooter", "not get wording, not show footer");
        break label270;
      }
      label605:
      label625:
      i = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114697);
    super.onCreate(paramBundle);
    AppMethodBeat.o(114697);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114698);
    d locald = this.zQj;
    if ((locald.jBN != null) && (locald.zRO != null))
    {
      locald.jBN.getViewTreeObserver().removeOnDrawListener(locald.zRO);
      locald.mContext = null;
    }
    EventCenter.instance.removeListener(this.hXn);
    super.onDestroy();
    AppMethodBeat.o(114698);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(178901);
    super.onPause();
    AppMethodBeat.o(178901);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(178902);
    super.onResume();
    f.e(true, false, true);
    AppMethodBeat.o(178902);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(178900);
    super.onStart();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.jVU.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    this.jVU.add(z.aTY());
    this.zQd.addAll(this.jVU);
    if (this.zQf) {
      this.zQg.aGw(z.aTY());
    }
    this.zQh = ((RecyclerView)findViewById(2131307930));
    localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.zQh.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.zQh.setAdapter(new com.tencent.mm.plugin.multitalk.ui.widget.q(this));
    ((com.tencent.mm.plugin.multitalk.ui.widget.q)this.zQh.getAdapter()).b(this.zQd, this.zQk);
    EventCenter.instance.addListener(this.hXn);
    AppMethodBeat.o(178900);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI
 * JD-Core Version:    0.7.0.1
 */