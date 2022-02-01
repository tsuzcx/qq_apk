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
import com.tencent.mm.g.a.md;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.multitalk.d.b.1;
import com.tencent.mm.plugin.multitalk.d.b.2;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.t;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.plugin.multitalk.ui.widget.d.2;
import com.tencent.mm.plugin.multitalk.ui.widget.d.3;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
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
  private com.tencent.mm.sdk.b.c hcQ;
  private HashSet<String> iYp;
  private HashSet<String> iYq;
  boolean wtG;
  private ArrayList<String> wtH;
  private Activity wtI;
  private boolean wtJ;
  private com.tencent.mm.plugin.multitalk.ui.widget.h wtK;
  private RecyclerView wtL;
  private boolean wtM;
  private d wtN;
  private View.OnClickListener wtO;
  
  public MultiTalkSelectContactUI()
  {
    AppMethodBeat.i(114694);
    this.wtG = true;
    this.wtM = false;
    this.wtO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178897);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((paramAnonymousView instanceof ImageView))
        {
          localObject = (String)paramAnonymousView.getTag();
          paramAnonymousView = MultiTalkSelectContactUI.this.fMv();
          if (v.aAC().equals(localObject))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178897);
            return;
          }
          MultiTalkSelectContactUI.f(MultiTalkSelectContactUI.this);
          if (MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).contains(localObject))
          {
            if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this)) {
              MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).Ce((String)localObject);
            }
            MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).remove(localObject);
            MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this).remove(localObject);
          }
          ((k)MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter()).b(MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this), MultiTalkSelectContactUI.h(MultiTalkSelectContactUI.this));
          localObject = MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).ca(((Integer)locala.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.notifyDataSetChanged();
          MultiTalkSelectContactUI.j(MultiTalkSelectContactUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(178897);
      }
    };
    this.hcQ = new com.tencent.mm.sdk.b.c() {};
    this.wtI = this;
    AppMethodBeat.o(114694);
  }
  
  private void Zv()
  {
    AppMethodBeat.i(114706);
    if (this.iYq.size() > 0)
    {
      updateOptionMenuText(1, getString(2131761432, new Object[] { Integer.valueOf(this.iYp.size() + this.iYq.size()) }));
      enableOptionMenu(1, true);
      AppMethodBeat.o(114706);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(114706);
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(114695);
    super.Zm();
    this.wtJ = getIntent().getBooleanExtra("key_need_gallery", false);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!x.wb(this.chatroomName)) {
      finish();
    }
    this.iYq = new HashSet();
    this.iYp = new HashSet();
    this.wtH = new ArrayList();
    AppMethodBeat.o(114695);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114704);
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.iYq.contains(parama.contact.field_username);
      AppMethodBeat.o(114704);
      return bool;
    }
    AppMethodBeat.o(114704);
    return false;
  }
  
  public final boolean aRT()
  {
    return false;
  }
  
  public final boolean aRU()
  {
    return false;
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(114699);
    String str = getIntent().getStringExtra("titile");
    AppMethodBeat.o(114699);
    return str;
  }
  
  public final com.tencent.mm.ui.contact.q aRW()
  {
    AppMethodBeat.i(114700);
    a locala = new a(this, this.chatroomName);
    AppMethodBeat.o(114700);
    return locala;
  }
  
  public final com.tencent.mm.ui.contact.o aRX()
  {
    AppMethodBeat.i(114701);
    b localb = new b(this, this.chatroomName);
    AppMethodBeat.o(114701);
    return localb;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114705);
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.iYp.contains(parama.contact.field_username);
      AppMethodBeat.o(114705);
      return bool;
    }
    AppMethodBeat.o(114705);
    return false;
  }
  
  public void dmJ()
  {
    AppMethodBeat.i(114703);
    super.dmJ();
    hideVKB();
    if (this.wtG) {
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
    return 2131494978;
  }
  
  public void initView()
  {
    AppMethodBeat.i(114696);
    super.initView();
    this.wtN = new d(this);
    Object localObject;
    ListView localListView;
    int i;
    if ((!this.wtN.wuL) && (com.tencent.mm.plugin.multitalk.d.b.dum()))
    {
      localObject = this.wtN;
      localListView = this.xuY;
      ((d)localObject).iFK = ListView.inflate(((d)localObject).mContext, 2131494974, null);
      ((d)localObject).iFK.getViewTreeObserver().addOnDrawListener(((d)localObject).wuR);
      ((d)localObject).iFK.setOnClickListener(new d.2((d)localObject));
      ((d)localObject).wuM = ((WxImageView)((d)localObject).iFK.findViewById(2131302258));
      ((d)localObject).wuO = ((TextView)((d)localObject).iFK.findViewById(2131302224));
      ((d)localObject).wuN = ((TextView)((d)localObject).iFK.findViewById(2131302225));
      ((d)localObject).wuP = ((WxImageView)((d)localObject).iFK.findViewById(2131302455));
      ((d)localObject).wuP.setBackground(ao.k(ak.getContext(), 2131690349, -1));
      if ((bu.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.dut())) || (bu.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.duu()))) {
        break label432;
      }
      ((d)localObject).wuN.setText(com.tencent.mm.plugin.multitalk.d.b.dut());
      ((d)localObject).wuO.setText(com.tencent.mm.plugin.multitalk.d.b.duu());
      i = 1;
    }
    for (;;)
    {
      if (!bu.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.getIconUrl()))
      {
        com.tencent.mm.av.q.aJb().a(com.tencent.mm.plugin.multitalk.d.b.getIconUrl(), null, new d.3((d)localObject));
        label242:
        localListView.removeFooterView(((d)localObject).iFK);
        if (i == 0) {
          break label546;
        }
        ((d)localObject).wuL = true;
        localListView.addFooterView(((d)localObject).iFK);
        label268:
        setActionbarColor(getResources().getColor(2131100196));
        hideActionbarLine();
        getController().setNavigationbarColor(Color.parseColor("#232323"));
        this.wtK = new com.tencent.mm.plugin.multitalk.ui.widget.h(this);
        localObject = getString(2131761432, new Object[] { Integer.valueOf(this.iYp.size() + this.iYq.size()) });
        if (!this.wtJ) {
          break label563;
        }
        localObject = getString(2131761441, new Object[] { Integer.valueOf(this.iYp.size() + this.iYq.size()) });
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
            if (!az.isNetworkConnected(ak.getContext())) {
              com.tencent.mm.bh.e.a(MultiTalkSelectContactUI.this, 2131764895, null);
            }
            for (;;)
            {
              MultiTalkSelectContactUI.this.hideVKB();
              AppMethodBeat.o(114692);
              return true;
              paramAnonymousMenuItem = new LinkedList();
              paramAnonymousMenuItem.addAll(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this));
              paramAnonymousMenuItem.add(v.aAC());
              paramAnonymousMenuItem = bu.m(paramAnonymousMenuItem, ",");
              if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this))
              {
                n.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 1, "", MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).wvU);
                z.dtK().c(MultiTalkSelectContactUI.this, paramAnonymousMenuItem, MultiTalkSelectContactUI.e(MultiTalkSelectContactUI.this));
              }
              else
              {
                n.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 2, t.dty(), 0);
                MultiTalkSelectContactUI.this.setResult(-1, MultiTalkSelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
                MultiTalkSelectContactUI.this.wtG = false;
                MultiTalkSelectContactUI.this.finish();
              }
            }
          }
        }, null, s.b.JwA);
        Zv();
        this.vUs.setBackgroundResource(2131100208);
        this.vUs.getInputText().setTextColor(-1);
        AppMethodBeat.o(114696);
        return;
        if (com.tencent.mm.plugin.multitalk.d.b.dun())
        {
          ((d)localObject).wuN.setText(2131761456);
          ((d)localObject).wuO.setText(2131761215);
          i = 1;
          break;
        }
        if (!com.tencent.mm.plugin.multitalk.d.b.duo()) {
          break label566;
        }
        ((d)localObject).wuN.setText(2131761457);
        ((d)localObject).wuO.setText(2131766232);
        i = 1;
        break;
        if (com.tencent.mm.plugin.multitalk.d.b.dun())
        {
          ((d)localObject).wuM.setBackground(ao.k(ak.getContext(), 2131690663, -1));
          break label242;
        }
        if (!com.tencent.mm.plugin.multitalk.d.b.duo()) {
          break label242;
        }
        ((d)localObject).wuM.setBackground(ao.k(ak.getContext(), 2131690683, -1));
        break label242;
        ((d)localObject).wuL = true;
        ae.e("MicroMsg.MeetingLinkFooter", "not get wording, not show footer");
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
    d locald = this.wtN;
    if ((locald.iFK != null) && (locald.wuR != null))
    {
      locald.iFK.getViewTreeObserver().removeOnDrawListener(locald.wuR);
      locald.mContext = null;
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.hcQ);
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
    if (!bu.isNullOrNil((String)localObject)) {
      this.iYp.addAll(bu.U(((String)localObject).split(",")));
    }
    this.iYp.add(v.aAC());
    this.wtH.addAll(this.iYp);
    if (this.wtJ) {
      this.wtK.asT(v.aAC());
    }
    this.wtL = ((RecyclerView)findViewById(2131304844));
    localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.wtL.setLayoutManager((RecyclerView.i)localObject);
    this.wtL.setAdapter(new k(this));
    ((k)this.wtL.getAdapter()).b(this.wtH, this.wtO);
    com.tencent.mm.sdk.b.a.IvT.c(this.hcQ);
    AppMethodBeat.o(178900);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(114702);
    Object localObject1 = fMv();
    Object localObject2 = ((com.tencent.mm.ui.contact.p)localObject1).aeW(paramInt - getContentLV().getHeaderViewsCount());
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
    ae.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject2).contact.field_username });
    localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject2).contact.field_username;
    if (v.aAC().equals(localObject2))
    {
      AppMethodBeat.o(114702);
      return;
    }
    fMC();
    if (this.iYp.contains(localObject2))
    {
      AppMethodBeat.o(114702);
      return;
    }
    int i;
    Object localObject3;
    View.OnClickListener localOnClickListener;
    Object localObject4;
    if (this.iYq.contains(localObject2))
    {
      if (this.wtJ) {
        this.wtK.Ce((String)localObject2);
      }
      this.iYq.remove(localObject2);
      i = this.wtH.indexOf(localObject2);
      this.wtH.remove(localObject2);
      localObject2 = (k)this.wtL.getAdapter();
      localObject3 = this.wtH;
      localOnClickListener = this.wtO;
      d.g.b.p.h(localObject3, "userNameList");
      d.g.b.p.h(localOnClickListener, "onClickListener");
      ((k)localObject2).smS.clear();
      ((k)localObject2).smS.add(v.aAC());
      int j = ((Collection)localObject3).size();
      paramInt = 0;
      while (paramInt < j)
      {
        localObject4 = ((ArrayList)localObject3).get(paramInt);
        d.g.b.p.g(localObject4, "userNameList[i]");
        if ((!((k)localObject2).asU((String)localObject4)) && ((d.g.b.p.i((String)((ArrayList)localObject3).get(paramInt), v.aAC()) ^ true))) {
          ((k)localObject2).smS.add(((ArrayList)localObject3).get(paramInt));
        }
        paramInt += 1;
      }
      ((k)localObject2).wwY = localOnClickListener;
      if (((k)localObject2).smS.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((k)localObject2).cj(((k)localObject2).tii + paramInt);
          paramInt += 1;
        }
      }
      ((k)localObject2).cl(((k)localObject2).tii + i);
    }
    for (;;)
    {
      localObject2 = this.wtL;
      localObject3 = com.tencent.mm.hellhoundlib.b.c.a(this.wtL.getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).ahE(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject2).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.contact.p)localObject1).notifyDataSetChanged();
      Zv();
      AppMethodBeat.o(114702);
      return;
      if (this.iYp.size() + this.iYq.size() == com.tencent.mm.plugin.multitalk.d.e.duB())
      {
        this.wtM = true;
        if (com.tencent.mm.plugin.multitalk.d.b.dum())
        {
          localObject1 = "";
          localObject2 = "";
          if ((!bu.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.dur())) && (!bu.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.dus())))
          {
            localObject1 = com.tencent.mm.plugin.multitalk.d.b.dur();
            localObject2 = com.tencent.mm.plugin.multitalk.d.b.dus();
          }
          while ((bu.isNullOrNil((String)localObject1)) || (bu.isNullOrNil((String)localObject2)))
          {
            ae.e("MicroMsg.MeetingLinkHelper", "cannot get dialog wording, ignore");
            AppMethodBeat.o(114702);
            return;
            if (com.tencent.mm.plugin.multitalk.d.b.dun())
            {
              localObject1 = getString(2131761427);
              localObject2 = getString(2131761419);
            }
            else if (com.tencent.mm.plugin.multitalk.d.b.duo())
            {
              localObject1 = getString(2131761428);
              localObject2 = getString(2131761420);
            }
          }
          com.tencent.mm.ui.base.h.a(this, (String)localObject1, "", (String)localObject2, getString(2131755691), new b.1(this), new b.2(), 2131099769);
          com.tencent.mm.plugin.multitalk.d.c.a(com.tencent.mm.plugin.multitalk.d.b.duw(), 0, 1, 0, 0, 0, 0, 0, 0, "", 0);
          AppMethodBeat.o(114702);
          return;
        }
        Toast.makeText(this, ak.getContext().getString(2131761437, new Object[] { Integer.valueOf(com.tencent.mm.plugin.multitalk.d.e.duB()) }), 0).show();
        AppMethodBeat.o(114702);
        return;
      }
      if (this.wtJ) {
        this.wtK.asT((String)localObject2);
      }
      this.iYq.add(localObject2);
      this.wtH.add(localObject2);
      localObject2 = (k)this.wtL.getAdapter();
      localObject3 = this.wtH;
      localOnClickListener = this.wtO;
      d.g.b.p.h(localObject3, "userNameList");
      d.g.b.p.h(localOnClickListener, "onClickListener");
      ((k)localObject2).smS.clear();
      ((k)localObject2).smS.add(v.aAC());
      i = ((Collection)localObject3).size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject4 = ((ArrayList)localObject3).get(paramInt);
        d.g.b.p.g(localObject4, "userNameList[i]");
        if ((!((k)localObject2).asU((String)localObject4)) && ((d.g.b.p.i((String)((ArrayList)localObject3).get(paramInt), v.aAC()) ^ true))) {
          ((k)localObject2).smS.add(((ArrayList)localObject3).get(paramInt));
        }
        paramInt += 1;
      }
      ((k)localObject2).wwY = localOnClickListener;
      if (((k)localObject2).smS.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((k)localObject2).cj(((k)localObject2).tii + paramInt);
          paramInt += 1;
        }
      }
      ((k)localObject2).ck(((k)localObject2).getItemCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI
 * JD-Core Version:    0.7.0.1
 */