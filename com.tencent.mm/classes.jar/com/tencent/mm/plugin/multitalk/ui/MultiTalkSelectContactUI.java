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
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.multitalk.c.b.1;
import com.tencent.mm.plugin.multitalk.c.b.2;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.t;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.plugin.multitalk.ui.widget.d.2;
import com.tencent.mm.plugin.multitalk.ui.widget.d.3;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
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
  private com.tencent.mm.sdk.b.c had;
  private HashSet<String> iVw;
  private HashSet<String> iVx;
  boolean wed;
  private ArrayList<String> wee;
  private Activity wef;
  private boolean weg;
  private com.tencent.mm.plugin.multitalk.ui.widget.h weh;
  private RecyclerView wei;
  private boolean wej;
  private d wek;
  private View.OnClickListener wel;
  
  public MultiTalkSelectContactUI()
  {
    AppMethodBeat.i(114694);
    this.wed = true;
    this.wej = false;
    this.wel = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178897);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((paramAnonymousView instanceof ImageView))
        {
          localObject = (String)paramAnonymousView.getTag();
          paramAnonymousView = MultiTalkSelectContactUI.this.fId();
          if (u.aAm().equals(localObject))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178897);
            return;
          }
          MultiTalkSelectContactUI.f(MultiTalkSelectContactUI.this);
          if (MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).contains(localObject))
          {
            if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this)) {
              MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).BC((String)localObject);
            }
            MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).remove(localObject);
            MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this).remove(localObject);
          }
          ((k)MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter()).b(MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this), MultiTalkSelectContactUI.h(MultiTalkSelectContactUI.this));
          localObject = MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).ca(((Integer)locala.mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.notifyDataSetChanged();
          MultiTalkSelectContactUI.j(MultiTalkSelectContactUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(178897);
      }
    };
    this.had = new com.tencent.mm.sdk.b.c() {};
    this.wef = this;
    AppMethodBeat.o(114694);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(114706);
    if (this.iVx.size() > 0)
    {
      updateOptionMenuText(1, getString(2131761432, new Object[] { Integer.valueOf(this.iVw.size() + this.iVx.size()) }));
      enableOptionMenu(1, true);
      AppMethodBeat.o(114706);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(114706);
  }
  
  public final void Zd()
  {
    AppMethodBeat.i(114695);
    super.Zd();
    this.weg = getIntent().getBooleanExtra("key_need_gallery", false);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!w.vF(this.chatroomName)) {
      finish();
    }
    this.iVx = new HashSet();
    this.iVw = new HashSet();
    this.wee = new ArrayList();
    AppMethodBeat.o(114695);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114704);
    if ((parama.KmP) && (parama.contact != null))
    {
      boolean bool = this.iVx.contains(parama.contact.field_username);
      AppMethodBeat.o(114704);
      return bool;
    }
    AppMethodBeat.o(114704);
    return false;
  }
  
  public final boolean aRu()
  {
    return false;
  }
  
  public final boolean aRv()
  {
    return false;
  }
  
  public final String aRw()
  {
    AppMethodBeat.i(114699);
    String str = getIntent().getStringExtra("titile");
    AppMethodBeat.o(114699);
    return str;
  }
  
  public final com.tencent.mm.ui.contact.q aRx()
  {
    AppMethodBeat.i(114700);
    a locala = new a(this, this.chatroomName);
    AppMethodBeat.o(114700);
    return locala;
  }
  
  public final com.tencent.mm.ui.contact.o aRy()
  {
    AppMethodBeat.i(114701);
    b localb = new b(this, this.chatroomName);
    AppMethodBeat.o(114701);
    return localb;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114705);
    if ((parama.KmP) && (parama.contact != null))
    {
      boolean bool = this.iVw.contains(parama.contact.field_username);
      AppMethodBeat.o(114705);
      return bool;
    }
    AppMethodBeat.o(114705);
    return false;
  }
  
  public void djK()
  {
    AppMethodBeat.i(114703);
    super.djK();
    hideVKB();
    if (this.wed) {
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
    this.wek = new d(this);
    Object localObject;
    ListView localListView;
    int i;
    if ((!this.wek.wfi) && (com.tencent.mm.plugin.multitalk.c.b.dra()))
    {
      localObject = this.wek;
      localListView = this.xfg;
      ((d)localObject).iCR = ListView.inflate(((d)localObject).mContext, 2131494974, null);
      ((d)localObject).iCR.getViewTreeObserver().addOnDrawListener(((d)localObject).wfo);
      ((d)localObject).iCR.setOnClickListener(new d.2((d)localObject));
      ((d)localObject).wfj = ((WxImageView)((d)localObject).iCR.findViewById(2131302258));
      ((d)localObject).wfl = ((TextView)((d)localObject).iCR.findViewById(2131302224));
      ((d)localObject).wfk = ((TextView)((d)localObject).iCR.findViewById(2131302225));
      ((d)localObject).wfm = ((WxImageView)((d)localObject).iCR.findViewById(2131302455));
      ((d)localObject).wfm.setBackground(ao.k(aj.getContext(), 2131690349, -1));
      if ((bt.isNullOrNil(com.tencent.mm.plugin.multitalk.c.b.drh())) || (bt.isNullOrNil(com.tencent.mm.plugin.multitalk.c.b.dri()))) {
        break label432;
      }
      ((d)localObject).wfk.setText(com.tencent.mm.plugin.multitalk.c.b.drh());
      ((d)localObject).wfl.setText(com.tencent.mm.plugin.multitalk.c.b.dri());
      i = 1;
    }
    for (;;)
    {
      if (!bt.isNullOrNil(com.tencent.mm.plugin.multitalk.c.b.getIconUrl()))
      {
        com.tencent.mm.aw.q.aIJ().a(com.tencent.mm.plugin.multitalk.c.b.getIconUrl(), null, new d.3((d)localObject));
        label242:
        localListView.removeFooterView(((d)localObject).iCR);
        if (i == 0) {
          break label546;
        }
        ((d)localObject).wfi = true;
        localListView.addFooterView(((d)localObject).iCR);
        label268:
        setActionbarColor(getResources().getColor(2131100196));
        hideActionbarLine();
        getController().setNavigationbarColor(Color.parseColor("#232323"));
        this.weh = new com.tencent.mm.plugin.multitalk.ui.widget.h(this);
        localObject = getString(2131761432, new Object[] { Integer.valueOf(this.iVw.size() + this.iVx.size()) });
        if (!this.weg) {
          break label563;
        }
        localObject = getString(2131761441, new Object[] { Integer.valueOf(this.iVw.size() + this.iVx.size()) });
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
              paramAnonymousMenuItem.add(u.aAm());
              paramAnonymousMenuItem = bt.m(paramAnonymousMenuItem, ",");
              if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this))
              {
                n.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 1, "", MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).wgr);
                z.dqx().c(MultiTalkSelectContactUI.this, paramAnonymousMenuItem, MultiTalkSelectContactUI.e(MultiTalkSelectContactUI.this));
              }
              else
              {
                n.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 2, t.dql(), 0);
                MultiTalkSelectContactUI.this.setResult(-1, MultiTalkSelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
                MultiTalkSelectContactUI.this.wed = false;
                MultiTalkSelectContactUI.this.finish();
              }
            }
          }
        }, null, s.b.JbS);
        Zm();
        this.vIo.setBackgroundResource(2131100208);
        this.vIo.getInputText().setTextColor(-1);
        AppMethodBeat.o(114696);
        return;
        if (com.tencent.mm.plugin.multitalk.c.b.drb())
        {
          ((d)localObject).wfk.setText(2131761456);
          ((d)localObject).wfl.setText(2131761215);
          i = 1;
          break;
        }
        if (!com.tencent.mm.plugin.multitalk.c.b.drc()) {
          break label566;
        }
        ((d)localObject).wfk.setText(2131761457);
        ((d)localObject).wfl.setText(2131766232);
        i = 1;
        break;
        if (com.tencent.mm.plugin.multitalk.c.b.drb())
        {
          ((d)localObject).wfj.setBackground(ao.k(aj.getContext(), 2131690663, -1));
          break label242;
        }
        if (!com.tencent.mm.plugin.multitalk.c.b.drc()) {
          break label242;
        }
        ((d)localObject).wfj.setBackground(ao.k(aj.getContext(), 2131690683, -1));
        break label242;
        ((d)localObject).wfi = true;
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
    d locald = this.wek;
    if ((locald.iCR != null) && (locald.wfo != null))
    {
      locald.iCR.getViewTreeObserver().removeOnDrawListener(locald.wfo);
      locald.mContext = null;
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.had);
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
    if (!bt.isNullOrNil((String)localObject)) {
      this.iVw.addAll(bt.U(((String)localObject).split(",")));
    }
    this.iVw.add(u.aAm());
    this.wee.addAll(this.iVw);
    if (this.weg) {
      this.weh.arG(u.aAm());
    }
    this.wei = ((RecyclerView)findViewById(2131304844));
    localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.wei.setLayoutManager((RecyclerView.i)localObject);
    this.wei.setAdapter(new k(this));
    ((k)this.wei.getAdapter()).b(this.wee, this.wel);
    com.tencent.mm.sdk.b.a.IbL.c(this.had);
    AppMethodBeat.o(178900);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(114702);
    Object localObject1 = fId();
    Object localObject2 = ((com.tencent.mm.ui.contact.p)localObject1).aen(paramInt - getContentLV().getHeaderViewsCount());
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
    if (u.aAm().equals(localObject2))
    {
      AppMethodBeat.o(114702);
      return;
    }
    fIk();
    if (this.iVw.contains(localObject2))
    {
      AppMethodBeat.o(114702);
      return;
    }
    int i;
    Object localObject3;
    View.OnClickListener localOnClickListener;
    Object localObject4;
    if (this.iVx.contains(localObject2))
    {
      if (this.weg) {
        this.weh.BC((String)localObject2);
      }
      this.iVx.remove(localObject2);
      i = this.wee.indexOf(localObject2);
      this.wee.remove(localObject2);
      localObject2 = (k)this.wei.getAdapter();
      localObject3 = this.wee;
      localOnClickListener = this.wel;
      d.g.b.p.h(localObject3, "userNameList");
      d.g.b.p.h(localOnClickListener, "onClickListener");
      ((k)localObject2).sec.clear();
      ((k)localObject2).sec.add(u.aAm());
      int j = ((Collection)localObject3).size();
      paramInt = 0;
      while (paramInt < j)
      {
        localObject4 = ((ArrayList)localObject3).get(paramInt);
        d.g.b.p.g(localObject4, "userNameList[i]");
        if ((!((k)localObject2).arH((String)localObject4)) && ((d.g.b.p.i((String)((ArrayList)localObject3).get(paramInt), u.aAm()) ^ true))) {
          ((k)localObject2).sec.add(((ArrayList)localObject3).get(paramInt));
        }
        paramInt += 1;
      }
      ((k)localObject2).whu = localOnClickListener;
      if (((k)localObject2).sec.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((k)localObject2).cj(((k)localObject2).sWU + paramInt);
          paramInt += 1;
        }
      }
      ((k)localObject2).cl(((k)localObject2).sWU + i);
    }
    for (;;)
    {
      localObject2 = this.wei;
      localObject3 = com.tencent.mm.hellhoundlib.b.c.a(this.wei.getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).ahp(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject2).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((com.tencent.mm.ui.contact.p)localObject1).notifyDataSetChanged();
      Zm();
      AppMethodBeat.o(114702);
      return;
      if (this.iVw.size() + this.iVx.size() == com.tencent.mm.plugin.multitalk.c.e.drp())
      {
        this.wej = true;
        if (com.tencent.mm.plugin.multitalk.c.b.dra())
        {
          localObject1 = "";
          localObject2 = "";
          if ((!bt.isNullOrNil(com.tencent.mm.plugin.multitalk.c.b.drf())) && (!bt.isNullOrNil(com.tencent.mm.plugin.multitalk.c.b.drg())))
          {
            localObject1 = com.tencent.mm.plugin.multitalk.c.b.drf();
            localObject2 = com.tencent.mm.plugin.multitalk.c.b.drg();
          }
          while ((bt.isNullOrNil((String)localObject1)) || (bt.isNullOrNil((String)localObject2)))
          {
            ad.e("MicroMsg.MeetingLinkHelper", "cannot get dialog wording, ignore");
            AppMethodBeat.o(114702);
            return;
            if (com.tencent.mm.plugin.multitalk.c.b.drb())
            {
              localObject1 = getString(2131761427);
              localObject2 = getString(2131761419);
            }
            else if (com.tencent.mm.plugin.multitalk.c.b.drc())
            {
              localObject1 = getString(2131761428);
              localObject2 = getString(2131761420);
            }
          }
          com.tencent.mm.ui.base.h.a(this, (String)localObject1, "", (String)localObject2, getString(2131755691), new b.1(this), new b.2(), 2131099769);
          com.tencent.mm.plugin.multitalk.c.c.a(com.tencent.mm.plugin.multitalk.c.b.drk(), 0, 1, 0, 0, 0, 0, 0, 0, "", 0);
          AppMethodBeat.o(114702);
          return;
        }
        Toast.makeText(this, aj.getContext().getString(2131761437, new Object[] { Integer.valueOf(com.tencent.mm.plugin.multitalk.c.e.drp()) }), 0).show();
        AppMethodBeat.o(114702);
        return;
      }
      if (this.weg) {
        this.weh.arG((String)localObject2);
      }
      this.iVx.add(localObject2);
      this.wee.add(localObject2);
      localObject2 = (k)this.wei.getAdapter();
      localObject3 = this.wee;
      localOnClickListener = this.wel;
      d.g.b.p.h(localObject3, "userNameList");
      d.g.b.p.h(localOnClickListener, "onClickListener");
      ((k)localObject2).sec.clear();
      ((k)localObject2).sec.add(u.aAm());
      i = ((Collection)localObject3).size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject4 = ((ArrayList)localObject3).get(paramInt);
        d.g.b.p.g(localObject4, "userNameList[i]");
        if ((!((k)localObject2).arH((String)localObject4)) && ((d.g.b.p.i((String)((ArrayList)localObject3).get(paramInt), u.aAm()) ^ true))) {
          ((k)localObject2).sec.add(((ArrayList)localObject3).get(paramInt));
        }
        paramInt += 1;
      }
      ((k)localObject2).whu = localOnClickListener;
      if (((k)localObject2).sec.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((k)localObject2).cj(((k)localObject2).sWU + paramInt);
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