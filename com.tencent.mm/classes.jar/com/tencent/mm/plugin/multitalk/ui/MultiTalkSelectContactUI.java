package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.multitalk.c.a.1;
import com.tencent.mm.plugin.multitalk.c.a.2;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.plugin.multitalk.ui.widget.d.2;
import com.tencent.mm.plugin.multitalk.ui.widget.d.3;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
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
  private com.tencent.mm.sdk.b.c gGt;
  private HashSet<String> iCm;
  private HashSet<String> iCn;
  boolean uZb;
  private ArrayList<String> uZc;
  private Activity uZd;
  private boolean uZe;
  private com.tencent.mm.plugin.multitalk.ui.widget.h uZf;
  private RecyclerView uZg;
  private boolean uZh;
  private d uZi;
  private View.OnClickListener uZj;
  
  public MultiTalkSelectContactUI()
  {
    AppMethodBeat.i(114694);
    this.uZb = true;
    this.uZh = false;
    this.uZj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178897);
        if ((paramAnonymousView instanceof ImageView))
        {
          Object localObject = (String)paramAnonymousView.getTag();
          paramAnonymousView = MultiTalkSelectContactUI.this.frq();
          if (u.axw().equals(localObject))
          {
            AppMethodBeat.o(178897);
            return;
          }
          MultiTalkSelectContactUI.f(MultiTalkSelectContactUI.this);
          if (MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).contains(localObject))
          {
            if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this)) {
              MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).yD((String)localObject);
            }
            MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).remove(localObject);
            MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this).remove(localObject);
          }
          ((com.tencent.mm.plugin.multitalk.ui.widget.k)MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter()).b(MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this), MultiTalkSelectContactUI.h(MultiTalkSelectContactUI.this));
          localObject = MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).ca(((Integer)locala.lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.notifyDataSetChanged();
          MultiTalkSelectContactUI.j(MultiTalkSelectContactUI.this);
        }
        AppMethodBeat.o(178897);
      }
    };
    this.gGt = new com.tencent.mm.sdk.b.c() {};
    this.uZd = this;
    AppMethodBeat.o(114694);
  }
  
  private void WT()
  {
    AppMethodBeat.i(114706);
    if (this.iCn.size() > 0)
    {
      updateOptionMenuText(1, getString(2131761432, new Object[] { Integer.valueOf(this.iCm.size() + this.iCn.size()) }));
      enableOptionMenu(1, true);
      AppMethodBeat.o(114706);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(114706);
  }
  
  public final void WJ()
  {
    AppMethodBeat.i(114695);
    super.WJ();
    this.uZe = getIntent().getBooleanExtra("key_need_gallery", false);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!w.sQ(this.chatroomName)) {
      finish();
    }
    this.iCn = new HashSet();
    this.iCm = new HashSet();
    this.uZc = new ArrayList();
    AppMethodBeat.o(114695);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114704);
    if ((parama.Iwh) && (parama.contact != null))
    {
      boolean bool = this.iCn.contains(parama.contact.field_username);
      AppMethodBeat.o(114704);
      return bool;
    }
    AppMethodBeat.o(114704);
    return false;
  }
  
  public final boolean aOi()
  {
    return false;
  }
  
  public final boolean aOj()
  {
    return false;
  }
  
  public final String aOk()
  {
    AppMethodBeat.i(114699);
    String str = getIntent().getStringExtra("titile");
    AppMethodBeat.o(114699);
    return str;
  }
  
  public final q aOl()
  {
    AppMethodBeat.i(114700);
    a locala = new a(this, this.chatroomName);
    AppMethodBeat.o(114700);
    return locala;
  }
  
  public final com.tencent.mm.ui.contact.o aOm()
  {
    AppMethodBeat.i(114701);
    b localb = new b(this, this.chatroomName);
    AppMethodBeat.o(114701);
    return localb;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114705);
    if ((parama.Iwh) && (parama.contact != null))
    {
      boolean bool = this.iCm.contains(parama.contact.field_username);
      AppMethodBeat.o(114705);
      return bool;
    }
    AppMethodBeat.o(114705);
    return false;
  }
  
  public void dax()
  {
    AppMethodBeat.i(114703);
    super.dax();
    hideVKB();
    if (this.uZb) {
      com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    }
    AppMethodBeat.o(114703);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494978;
  }
  
  public void initView()
  {
    AppMethodBeat.i(114696);
    super.initView();
    this.uZi = new d(this);
    Object localObject;
    ListView localListView;
    int i;
    if ((!this.uZi.vab) && (com.tencent.mm.plugin.multitalk.c.a.dgT()))
    {
      localObject = this.uZi;
      localListView = this.vXs;
      ((d)localObject).ijA = ListView.inflate(((d)localObject).mContext, 2131494974, null);
      ((d)localObject).ijA.getViewTreeObserver().addOnDrawListener(((d)localObject).vah);
      ((d)localObject).ijA.setOnClickListener(new d.2((d)localObject));
      ((d)localObject).vac = ((WxImageView)((d)localObject).ijA.findViewById(2131302258));
      ((d)localObject).vae = ((TextView)((d)localObject).ijA.findViewById(2131302224));
      ((d)localObject).vad = ((TextView)((d)localObject).ijA.findViewById(2131302225));
      ((d)localObject).vaf = ((WxImageView)((d)localObject).ijA.findViewById(2131302455));
      ((d)localObject).vaf.setBackground(am.k(ai.getContext(), 2131690349, -1));
      if ((bs.isNullOrNil(com.tencent.mm.plugin.multitalk.c.a.dha())) || (bs.isNullOrNil(com.tencent.mm.plugin.multitalk.c.a.dhb()))) {
        break label432;
      }
      ((d)localObject).vad.setText(com.tencent.mm.plugin.multitalk.c.a.dha());
      ((d)localObject).vae.setText(com.tencent.mm.plugin.multitalk.c.a.dhb());
      i = 1;
    }
    for (;;)
    {
      if (!bs.isNullOrNil(com.tencent.mm.plugin.multitalk.c.a.cvw()))
      {
        com.tencent.mm.av.o.aFB().a(com.tencent.mm.plugin.multitalk.c.a.cvw(), null, new d.3((d)localObject));
        label242:
        localListView.removeFooterView(((d)localObject).ijA);
        if (i == 0) {
          break label546;
        }
        ((d)localObject).vab = true;
        localListView.addFooterView(((d)localObject).ijA);
        label268:
        setActionbarColor(getResources().getColor(2131100196));
        hideActionbarLine();
        getController().setNavigationbarColor(Color.parseColor("#232323"));
        this.uZf = new com.tencent.mm.plugin.multitalk.ui.widget.h(this);
        localObject = getString(2131761432, new Object[] { Integer.valueOf(this.iCm.size() + this.iCn.size()) });
        if (!this.uZe) {
          break label563;
        }
        localObject = getString(2131761441, new Object[] { Integer.valueOf(this.iCm.size() + this.iCn.size()) });
      }
      label432:
      label563:
      for (;;)
      {
        addTextOptionMenu(1, (String)localObject, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(114692);
            if (!ax.isNetworkConnected(ai.getContext())) {
              com.tencent.mm.bh.e.a(MultiTalkSelectContactUI.this, 2131764895, null);
            }
            for (;;)
            {
              MultiTalkSelectContactUI.this.hideVKB();
              AppMethodBeat.o(114692);
              return true;
              paramAnonymousMenuItem = new LinkedList();
              paramAnonymousMenuItem.addAll(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this));
              paramAnonymousMenuItem.add(u.axw());
              paramAnonymousMenuItem = bs.n(paramAnonymousMenuItem, ",");
              if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this))
              {
                com.tencent.mm.plugin.multitalk.model.e.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 1, "", MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).vbi);
                com.tencent.mm.plugin.multitalk.model.p.dgx().c(MultiTalkSelectContactUI.this, paramAnonymousMenuItem, MultiTalkSelectContactUI.e(MultiTalkSelectContactUI.this));
              }
              else
              {
                com.tencent.mm.plugin.multitalk.model.e.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 2, j.dgm(), 0);
                MultiTalkSelectContactUI.this.setResult(-1, MultiTalkSelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
                MultiTalkSelectContactUI.this.uZb = false;
                MultiTalkSelectContactUI.this.finish();
              }
            }
          }
        }, null, s.b.Hom);
        WT();
        this.uFo.setBackgroundResource(2131100208);
        this.uFo.getInputText().setTextColor(-1);
        AppMethodBeat.o(114696);
        return;
        if (com.tencent.mm.plugin.multitalk.c.a.dgU())
        {
          ((d)localObject).vad.setText(2131761456);
          ((d)localObject).vae.setText(2131761215);
          i = 1;
          break;
        }
        if (!com.tencent.mm.plugin.multitalk.c.a.dgV()) {
          break label566;
        }
        ((d)localObject).vad.setText(2131761457);
        ((d)localObject).vae.setText(2131766232);
        i = 1;
        break;
        if (com.tencent.mm.plugin.multitalk.c.a.dgU())
        {
          ((d)localObject).vac.setBackground(am.k(ai.getContext(), 2131690663, -1));
          break label242;
        }
        if (!com.tencent.mm.plugin.multitalk.c.a.dgV()) {
          break label242;
        }
        ((d)localObject).vac.setBackground(am.k(ai.getContext(), 2131690683, -1));
        break label242;
        ((d)localObject).vab = true;
        ac.e("MicroMsg.MeetingLinkFooter", "not get wording, not show footer");
        break label268;
      }
      label546:
      label566:
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
    d locald = this.uZi;
    if ((locald.ijA != null) && (locald.vah != null))
    {
      locald.ijA.getViewTreeObserver().removeOnDrawListener(locald.vah);
      locald.mContext = null;
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.gGt);
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
    com.tencent.mm.plugin.ball.f.f.e(true, false, true);
    AppMethodBeat.o(178902);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(178900);
    super.onStart();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bs.isNullOrNil((String)localObject)) {
      this.iCm.addAll(bs.S(((String)localObject).split(",")));
    }
    this.iCm.add(u.axw());
    this.uZc.addAll(this.iCm);
    if (this.uZe) {
      this.uZf.amF(u.axw());
    }
    this.uZg = ((RecyclerView)findViewById(2131304844));
    localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.uZg.setLayoutManager((RecyclerView.i)localObject);
    this.uZg.setAdapter(new com.tencent.mm.plugin.multitalk.ui.widget.k(this));
    ((com.tencent.mm.plugin.multitalk.ui.widget.k)this.uZg.getAdapter()).b(this.uZc, this.uZj);
    com.tencent.mm.sdk.b.a.GpY.c(this.gGt);
    AppMethodBeat.o(178900);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(114702);
    Object localObject1 = frq();
    Object localObject2 = ((com.tencent.mm.ui.contact.p)localObject1).abQ(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject2 == null)
    {
      AppMethodBeat.o(114702);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject2).contact == null)
    {
      AppMethodBeat.o(114702);
      return;
    }
    ac.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject2).contact.field_username });
    localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject2).contact.field_username;
    if (u.axw().equals(localObject2))
    {
      AppMethodBeat.o(114702);
      return;
    }
    frx();
    if (this.iCm.contains(localObject2))
    {
      AppMethodBeat.o(114702);
      return;
    }
    int i;
    Object localObject3;
    View.OnClickListener localOnClickListener;
    Object localObject4;
    if (this.iCn.contains(localObject2))
    {
      if (this.uZe) {
        this.uZf.yD((String)localObject2);
      }
      this.iCn.remove(localObject2);
      i = this.uZc.indexOf(localObject2);
      this.uZc.remove(localObject2);
      localObject2 = (com.tencent.mm.plugin.multitalk.ui.widget.k)this.uZg.getAdapter();
      localObject3 = this.uZc;
      localOnClickListener = this.uZj;
      d.g.b.k.h(localObject3, "userNameList");
      d.g.b.k.h(localOnClickListener, "onClickListener");
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).rpr.clear();
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).rpr.add(u.axw());
      int j = ((Collection)localObject3).size();
      paramInt = 0;
      while (paramInt < j)
      {
        localObject4 = ((ArrayList)localObject3).get(paramInt);
        d.g.b.k.g(localObject4, "userNameList[i]");
        if ((!((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).amI((String)localObject4)) && ((d.g.b.k.g((String)((ArrayList)localObject3).get(paramInt), u.axw()) ^ true))) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).rpr.add(((ArrayList)localObject3).get(paramInt));
        }
        paramInt += 1;
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).vcj = localOnClickListener;
      if (((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).rpr.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).cj(((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).rZI + paramInt);
          paramInt += 1;
        }
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).cl(((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).rZI + i);
    }
    for (;;)
    {
      localObject2 = this.uZg;
      localObject3 = com.tencent.mm.hellhoundlib.b.c.a(this.uZg.getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aeD(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject2).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.contact.p)localObject1).notifyDataSetChanged();
      WT();
      AppMethodBeat.o(114702);
      return;
      if (this.iCm.size() + this.iCn.size() == com.tencent.mm.plugin.multitalk.c.c.dhi())
      {
        this.uZh = true;
        if (com.tencent.mm.plugin.multitalk.c.a.dgT())
        {
          localObject1 = "";
          localObject2 = "";
          if ((!bs.isNullOrNil(com.tencent.mm.plugin.multitalk.c.a.dgY())) && (!bs.isNullOrNil(com.tencent.mm.plugin.multitalk.c.a.dgZ())))
          {
            localObject1 = com.tencent.mm.plugin.multitalk.c.a.dgY();
            localObject2 = com.tencent.mm.plugin.multitalk.c.a.dgZ();
          }
          while ((bs.isNullOrNil((String)localObject1)) || (bs.isNullOrNil((String)localObject2)))
          {
            ac.e("MicroMsg.MeetingLinkHelper", "cannot get dialog wording, ignore");
            AppMethodBeat.o(114702);
            return;
            if (com.tencent.mm.plugin.multitalk.c.a.dgU())
            {
              localObject1 = getString(2131761427);
              localObject2 = getString(2131761419);
            }
            else if (com.tencent.mm.plugin.multitalk.c.a.dgV())
            {
              localObject1 = getString(2131761428);
              localObject2 = getString(2131761420);
            }
          }
          com.tencent.mm.ui.base.h.a(this, (String)localObject1, "", (String)localObject2, getString(2131755691), new a.1(this), new a.2(), 2131099769);
          com.tencent.mm.plugin.multitalk.c.b.a(com.tencent.mm.plugin.multitalk.c.a.dhd(), 0, 1, 0, 0, 0, 0, 0, 0, "", 0);
          AppMethodBeat.o(114702);
          return;
        }
        Toast.makeText(this, ai.getContext().getString(2131761437, new Object[] { Integer.valueOf(com.tencent.mm.plugin.multitalk.c.c.dhi()) }), 0).show();
        AppMethodBeat.o(114702);
        return;
      }
      if (this.uZe) {
        this.uZf.amF((String)localObject2);
      }
      this.iCn.add(localObject2);
      this.uZc.add(localObject2);
      localObject2 = (com.tencent.mm.plugin.multitalk.ui.widget.k)this.uZg.getAdapter();
      localObject3 = this.uZc;
      localOnClickListener = this.uZj;
      d.g.b.k.h(localObject3, "userNameList");
      d.g.b.k.h(localOnClickListener, "onClickListener");
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).rpr.clear();
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).rpr.add(u.axw());
      i = ((Collection)localObject3).size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject4 = ((ArrayList)localObject3).get(paramInt);
        d.g.b.k.g(localObject4, "userNameList[i]");
        if ((!((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).amI((String)localObject4)) && ((d.g.b.k.g((String)((ArrayList)localObject3).get(paramInt), u.axw()) ^ true))) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).rpr.add(((ArrayList)localObject3).get(paramInt));
        }
        paramInt += 1;
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).vcj = localOnClickListener;
      if (((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).rpr.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).cj(((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).rZI + paramInt);
          paramInt += 1;
        }
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).ck(((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).getItemCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI
 * JD-Core Version:    0.7.0.1
 */