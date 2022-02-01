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
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.multitalk.c.a.1;
import com.tencent.mm.plugin.multitalk.c.a.2;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.plugin.multitalk.ui.widget.d.2;
import com.tencent.mm.plugin.multitalk.ui.widget.d.3;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.b;
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
  private HashSet<String> icf;
  private HashSet<String> icg;
  private com.tencent.mm.sdk.b.c tPg;
  boolean tQB;
  private ArrayList<String> tQC;
  private Activity tQD;
  private boolean tQE;
  private com.tencent.mm.plugin.multitalk.ui.widget.h tQF;
  private RecyclerView tQG;
  private boolean tQH;
  private d tQI;
  private View.OnClickListener tQJ;
  
  public MultiTalkSelectContactUI()
  {
    AppMethodBeat.i(114694);
    this.tQB = true;
    this.tQH = false;
    this.tQJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178897);
        if ((paramAnonymousView instanceof ImageView))
        {
          Object localObject = (String)paramAnonymousView.getTag();
          paramAnonymousView = MultiTalkSelectContactUI.this.fbz();
          if (u.aqG().equals(localObject))
          {
            AppMethodBeat.o(178897);
            return;
          }
          MultiTalkSelectContactUI.f(MultiTalkSelectContactUI.this);
          if (MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).contains(localObject))
          {
            if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this)) {
              MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).ux((String)localObject);
            }
            MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).remove(localObject);
            MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this).remove(localObject);
          }
          ((com.tencent.mm.plugin.multitalk.ui.widget.k)MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter()).b(MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this), MultiTalkSelectContactUI.h(MultiTalkSelectContactUI.this));
          localObject = MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).ca(((Integer)locala.lS(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.notifyDataSetChanged();
          MultiTalkSelectContactUI.j(MultiTalkSelectContactUI.this);
        }
        AppMethodBeat.o(178897);
      }
    };
    this.tPg = new MultiTalkSelectContactUI.3(this);
    this.tQD = this;
    AppMethodBeat.o(114694);
  }
  
  private void VV()
  {
    AppMethodBeat.i(114706);
    if (this.icg.size() > 0)
    {
      updateOptionMenuText(1, getString(2131761432, new Object[] { Integer.valueOf(this.icf.size() + this.icg.size()) }));
      enableOptionMenu(1, true);
      AppMethodBeat.o(114706);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(114706);
  }
  
  public final void VL()
  {
    AppMethodBeat.i(114695);
    super.VL();
    this.tQE = getIntent().getBooleanExtra("key_need_gallery", false);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!w.pF(this.chatroomName)) {
      finish();
    }
    this.icg = new HashSet();
    this.icf = new HashSet();
    this.tQC = new ArrayList();
    AppMethodBeat.o(114695);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114704);
    if ((parama.GVT) && (parama.contact != null))
    {
      boolean bool = this.icg.contains(parama.contact.field_username);
      AppMethodBeat.o(114704);
      return bool;
    }
    AppMethodBeat.o(114704);
    return false;
  }
  
  public final boolean aHt()
  {
    return false;
  }
  
  public final boolean aHu()
  {
    return false;
  }
  
  public final String aHv()
  {
    AppMethodBeat.i(114699);
    String str = getIntent().getStringExtra("titile");
    AppMethodBeat.o(114699);
    return str;
  }
  
  public final q aHw()
  {
    AppMethodBeat.i(114700);
    a locala = new a(this, this.chatroomName);
    AppMethodBeat.o(114700);
    return locala;
  }
  
  public final com.tencent.mm.ui.contact.o aHx()
  {
    AppMethodBeat.i(114701);
    b localb = new b(this, this.chatroomName);
    AppMethodBeat.o(114701);
    return localb;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114705);
    if ((parama.GVT) && (parama.contact != null))
    {
      boolean bool = this.icf.contains(parama.contact.field_username);
      AppMethodBeat.o(114705);
      return bool;
    }
    AppMethodBeat.o(114705);
    return false;
  }
  
  public void cMR()
  {
    AppMethodBeat.i(114703);
    super.cMR();
    hideVKB();
    if (this.tQB) {
      com.tencent.mm.plugin.ball.f.f.d(false, true, true);
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
    this.tQI = new d(this);
    Object localObject;
    ListView localListView;
    int i;
    if ((!this.tQI.tRt) && (com.tencent.mm.plugin.multitalk.c.a.cTj()))
    {
      localObject = this.tQI;
      localListView = this.uOC;
      ((d)localObject).hIZ = ListView.inflate(((d)localObject).mContext, 2131494974, null);
      ((d)localObject).hIZ.getViewTreeObserver().addOnDrawListener(((d)localObject).tRz);
      ((d)localObject).hIZ.setOnClickListener(new d.2((d)localObject));
      ((d)localObject).tRu = ((WxImageView)((d)localObject).hIZ.findViewById(2131302258));
      ((d)localObject).tRw = ((TextView)((d)localObject).hIZ.findViewById(2131302224));
      ((d)localObject).tRv = ((TextView)((d)localObject).hIZ.findViewById(2131302225));
      ((d)localObject).tRx = ((WxImageView)((d)localObject).hIZ.findViewById(2131302455));
      ((d)localObject).tRx.setBackground(am.i(aj.getContext(), 2131690349, -1));
      if ((bt.isNullOrNil(com.tencent.mm.plugin.multitalk.c.a.cTq())) || (bt.isNullOrNil(com.tencent.mm.plugin.multitalk.c.a.cTr()))) {
        break label432;
      }
      ((d)localObject).tRv.setText(com.tencent.mm.plugin.multitalk.c.a.cTq());
      ((d)localObject).tRw.setText(com.tencent.mm.plugin.multitalk.c.a.cTr());
      i = 1;
    }
    for (;;)
    {
      if (!bt.isNullOrNil(com.tencent.mm.plugin.multitalk.c.a.cmt()))
      {
        com.tencent.mm.aw.o.ayJ().a(com.tencent.mm.plugin.multitalk.c.a.cmt(), null, new d.3((d)localObject));
        label242:
        localListView.removeFooterView(((d)localObject).hIZ);
        if (i == 0) {
          break label546;
        }
        ((d)localObject).tRt = true;
        localListView.addFooterView(((d)localObject).hIZ);
        label268:
        setActionbarColor(getResources().getColor(2131100196));
        hideActionbarLine();
        getController().setNavigationbarColor(Color.parseColor("#232323"));
        this.tQF = new com.tencent.mm.plugin.multitalk.ui.widget.h(this);
        localObject = getString(2131761432, new Object[] { Integer.valueOf(this.icf.size() + this.icg.size()) });
        if (!this.tQE) {
          break label563;
        }
        localObject = getString(2131761441, new Object[] { Integer.valueOf(this.icf.size() + this.icg.size()) });
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
            if (!ay.isNetworkConnected(aj.getContext())) {
              com.tencent.mm.bi.e.a(MultiTalkSelectContactUI.this, 2131764895, null);
            }
            for (;;)
            {
              MultiTalkSelectContactUI.this.hideVKB();
              AppMethodBeat.o(114692);
              return true;
              paramAnonymousMenuItem = new LinkedList();
              paramAnonymousMenuItem.addAll(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this));
              paramAnonymousMenuItem.add(u.aqG());
              paramAnonymousMenuItem = bt.n(paramAnonymousMenuItem, ",");
              if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this))
              {
                com.tencent.mm.plugin.multitalk.model.e.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 1, "", MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).tSB);
                com.tencent.mm.plugin.multitalk.model.p.cSO().c(MultiTalkSelectContactUI.this, paramAnonymousMenuItem, MultiTalkSelectContactUI.e(MultiTalkSelectContactUI.this));
              }
              else
              {
                com.tencent.mm.plugin.multitalk.model.e.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 2, j.cSD(), 0);
                MultiTalkSelectContactUI.this.setResult(-1, MultiTalkSelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
                MultiTalkSelectContactUI.this.tQB = false;
                MultiTalkSelectContactUI.this.finish();
              }
            }
          }
        }, null, r.b.FOB);
        VV();
        this.twW.setBackgroundResource(2131100208);
        this.twW.getInputText().setTextColor(-1);
        AppMethodBeat.o(114696);
        return;
        if (com.tencent.mm.plugin.multitalk.c.a.cTk())
        {
          ((d)localObject).tRv.setText(2131761456);
          ((d)localObject).tRw.setText(2131761215);
          i = 1;
          break;
        }
        if (!com.tencent.mm.plugin.multitalk.c.a.cTl()) {
          break label566;
        }
        ((d)localObject).tRv.setText(2131761457);
        ((d)localObject).tRw.setText(2131766232);
        i = 1;
        break;
        if (com.tencent.mm.plugin.multitalk.c.a.cTk())
        {
          ((d)localObject).tRu.setBackground(am.i(aj.getContext(), 2131690663, -1));
          break label242;
        }
        if (!com.tencent.mm.plugin.multitalk.c.a.cTl()) {
          break label242;
        }
        ((d)localObject).tRu.setBackground(am.i(aj.getContext(), 2131690683, -1));
        break label242;
        ((d)localObject).tRt = true;
        ad.e("MicroMsg.MeetingLinkFooter", "not get wording, not show footer");
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
    d locald = this.tQI;
    if ((locald.hIZ != null) && (locald.tRz != null))
    {
      locald.hIZ.getViewTreeObserver().removeOnDrawListener(locald.tRz);
      locald.mContext = null;
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.tPg);
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
    com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    AppMethodBeat.o(178902);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(178900);
    super.onStart();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bt.isNullOrNil((String)localObject)) {
      this.icf.addAll(bt.S(((String)localObject).split(",")));
    }
    this.icf.add(u.aqG());
    this.tQC.addAll(this.icf);
    if (this.tQE) {
      this.tQF.ahK(u.aqG());
    }
    this.tQG = ((RecyclerView)findViewById(2131304844));
    localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.tQG.setLayoutManager((RecyclerView.i)localObject);
    this.tQG.setAdapter(new com.tencent.mm.plugin.multitalk.ui.widget.k(this));
    ((com.tencent.mm.plugin.multitalk.ui.widget.k)this.tQG.getAdapter()).b(this.tQC, this.tQJ);
    com.tencent.mm.sdk.b.a.ESL.c(this.tPg);
    AppMethodBeat.o(178900);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pT(int paramInt)
  {
    AppMethodBeat.i(114702);
    Object localObject1 = fbz();
    Object localObject2 = ((com.tencent.mm.ui.contact.p)localObject1).ZC(paramInt - getContentLV().getHeaderViewsCount());
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
    ad.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject2).contact.field_username });
    localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject2).contact.field_username;
    if (u.aqG().equals(localObject2))
    {
      AppMethodBeat.o(114702);
      return;
    }
    fbG();
    if (this.icf.contains(localObject2))
    {
      AppMethodBeat.o(114702);
      return;
    }
    int i;
    Object localObject3;
    View.OnClickListener localOnClickListener;
    Object localObject4;
    if (this.icg.contains(localObject2))
    {
      if (this.tQE) {
        this.tQF.ux((String)localObject2);
      }
      this.icg.remove(localObject2);
      i = this.tQC.indexOf(localObject2);
      this.tQC.remove(localObject2);
      localObject2 = (com.tencent.mm.plugin.multitalk.ui.widget.k)this.tQG.getAdapter();
      localObject3 = this.tQC;
      localOnClickListener = this.tQJ;
      d.g.b.k.h(localObject3, "userNameList");
      d.g.b.k.h(localOnClickListener, "onClickListener");
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).qHA.clear();
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).qHA.add(u.aqG());
      int j = ((Collection)localObject3).size();
      paramInt = 0;
      while (paramInt < j)
      {
        localObject4 = ((ArrayList)localObject3).get(paramInt);
        d.g.b.k.g(localObject4, "userNameList[i]");
        if ((!((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).ahN((String)localObject4)) && ((d.g.b.k.g((String)((ArrayList)localObject3).get(paramInt), u.aqG()) ^ true))) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).qHA.add(((ArrayList)localObject3).get(paramInt));
        }
        paramInt += 1;
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).tTB = localOnClickListener;
      if (((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).qHA.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).ck(((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).qYg + paramInt);
          paramInt += 1;
        }
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).cm(((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).qYg + i);
    }
    for (;;)
    {
      localObject2 = this.tQG;
      localObject3 = com.tencent.mm.hellhoundlib.b.c.a(this.tQG.getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).adn(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject2).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.contact.p)localObject1).notifyDataSetChanged();
      VV();
      AppMethodBeat.o(114702);
      return;
      if (this.icf.size() + this.icg.size() == com.tencent.mm.plugin.multitalk.c.c.cTy())
      {
        this.tQH = true;
        if (com.tencent.mm.plugin.multitalk.c.a.cTj())
        {
          localObject1 = "";
          localObject2 = "";
          if ((!bt.isNullOrNil(com.tencent.mm.plugin.multitalk.c.a.cTo())) && (!bt.isNullOrNil(com.tencent.mm.plugin.multitalk.c.a.cTp())))
          {
            localObject1 = com.tencent.mm.plugin.multitalk.c.a.cTo();
            localObject2 = com.tencent.mm.plugin.multitalk.c.a.cTp();
          }
          while ((bt.isNullOrNil((String)localObject1)) || (bt.isNullOrNil((String)localObject2)))
          {
            ad.e("MicroMsg.MeetingLinkHelper", "cannot get dialog wording, ignore");
            AppMethodBeat.o(114702);
            return;
            if (com.tencent.mm.plugin.multitalk.c.a.cTk())
            {
              localObject1 = getString(2131761427);
              localObject2 = getString(2131761419);
            }
            else if (com.tencent.mm.plugin.multitalk.c.a.cTl())
            {
              localObject1 = getString(2131761428);
              localObject2 = getString(2131761420);
            }
          }
          com.tencent.mm.ui.base.h.a(this, (String)localObject1, "", (String)localObject2, getString(2131755691), new a.1(this), new a.2(), 2131099769);
          com.tencent.mm.plugin.multitalk.c.b.a(com.tencent.mm.plugin.multitalk.c.a.cTt(), 0, 1, 0, 0, 0, 0, 0, 0, "", 0);
          AppMethodBeat.o(114702);
          return;
        }
        Toast.makeText(this, aj.getContext().getString(2131761437, new Object[] { Integer.valueOf(com.tencent.mm.plugin.multitalk.c.c.cTy()) }), 0).show();
        AppMethodBeat.o(114702);
        return;
      }
      if (this.tQE) {
        this.tQF.ahK((String)localObject2);
      }
      this.icg.add(localObject2);
      this.tQC.add(localObject2);
      localObject2 = (com.tencent.mm.plugin.multitalk.ui.widget.k)this.tQG.getAdapter();
      localObject3 = this.tQC;
      localOnClickListener = this.tQJ;
      d.g.b.k.h(localObject3, "userNameList");
      d.g.b.k.h(localOnClickListener, "onClickListener");
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).qHA.clear();
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).qHA.add(u.aqG());
      i = ((Collection)localObject3).size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject4 = ((ArrayList)localObject3).get(paramInt);
        d.g.b.k.g(localObject4, "userNameList[i]");
        if ((!((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).ahN((String)localObject4)) && ((d.g.b.k.g((String)((ArrayList)localObject3).get(paramInt), u.aqG()) ^ true))) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).qHA.add(((ArrayList)localObject3).get(paramInt));
        }
        paramInt += 1;
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).tTB = localOnClickListener;
      if (((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).qHA.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).ck(((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).qYg + paramInt);
          paramInt += 1;
        }
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).cl(((com.tencent.mm.plugin.multitalk.ui.widget.k)localObject2).getItemCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI
 * JD-Core Version:    0.7.0.1
 */