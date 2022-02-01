package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.model.ad;
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
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MultiTalkSelectContactUI
  extends MMBaseSelectContactUI
{
  boolean FvF;
  private ArrayList<String> FvG;
  private Activity FvH;
  private boolean FvI;
  private l FvJ;
  private RecyclerView FvK;
  private boolean FvL;
  private d FvM;
  private View.OnClickListener FvN;
  private String chatroomName;
  private IListener kLS;
  private HashSet<String> mNh;
  private HashSet<String> mNi;
  
  public MultiTalkSelectContactUI()
  {
    AppMethodBeat.i(114694);
    this.FvF = true;
    this.FvL = false;
    this.FvN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178897);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((paramAnonymousView instanceof ImageView))
        {
          localObject = (String)paramAnonymousView.getTag();
          paramAnonymousView = MultiTalkSelectContactUI.this.hUP();
          if (z.bcZ().equals(localObject))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178897);
            return;
          }
          MultiTalkSelectContactUI.f(MultiTalkSelectContactUI.this);
          if (MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).contains(localObject))
          {
            if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this)) {
              MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).Sd((String)localObject);
            }
            MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).remove(localObject);
            MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this).remove(localObject);
          }
          ((com.tencent.mm.plugin.multitalk.ui.widget.q)MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter()).b(MultiTalkSelectContactUI.g(MultiTalkSelectContactUI.this), MultiTalkSelectContactUI.h(MultiTalkSelectContactUI.this));
          localObject = MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this);
          com.tencent.mm.hellhoundlib.b.a locala = c.a(MultiTalkSelectContactUI.i(MultiTalkSelectContactUI.this).getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.notifyDataSetChanged();
          MultiTalkSelectContactUI.j(MultiTalkSelectContactUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(178897);
      }
    };
    this.kLS = new MultiTalkSelectContactUI.3(this);
    this.FvH = this;
    AppMethodBeat.o(114694);
  }
  
  private void atk()
  {
    AppMethodBeat.i(114706);
    if (this.mNi.size() > 0)
    {
      updateOptionMenuText(1, getString(a.h.multitalk_ok, new Object[] { Integer.valueOf(this.mNh.size() + this.mNi.size()) }));
      enableOptionMenu(1, true);
      AppMethodBeat.o(114706);
      return;
    }
    enableOptionMenu(1, false);
    AppMethodBeat.o(114706);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(199846);
    paramView = hUP();
    Object localObject1 = paramView.awM(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject1 == null)
    {
      AppMethodBeat.o(199846);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject1).contact == null)
    {
      AppMethodBeat.o(199846);
      return;
    }
    Log.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_username });
    localObject1 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_username;
    if (z.bcZ().equals(localObject1))
    {
      AppMethodBeat.o(199846);
      return;
    }
    hUZ();
    if (this.mNh.contains(localObject1))
    {
      AppMethodBeat.o(199846);
      return;
    }
    int i;
    Object localObject2;
    View.OnClickListener localOnClickListener;
    Object localObject3;
    if (this.mNi.contains(localObject1))
    {
      if (this.FvI) {
        this.FvJ.Sd((String)localObject1);
      }
      this.mNi.remove(localObject1);
      i = this.FvG.indexOf(localObject1);
      this.FvG.remove(localObject1);
      localObject1 = (com.tencent.mm.plugin.multitalk.ui.widget.q)this.FvK.getAdapter();
      localObject2 = this.FvG;
      localOnClickListener = this.FvN;
      kotlin.g.b.p.k(localObject2, "userNameList");
      kotlin.g.b.p.k(localOnClickListener, "onClickListener");
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).xMG.clear();
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).xMG.add(z.bcZ());
      int j = ((Collection)localObject2).size();
      paramInt = 0;
      while (paramInt < j)
      {
        localObject3 = ((ArrayList)localObject2).get(paramInt);
        kotlin.g.b.p.j(localObject3, "userNameList[i]");
        if ((!((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).aQR((String)localObject3)) && ((kotlin.g.b.p.h((String)((ArrayList)localObject2).get(paramInt), z.bcZ()) ^ true))) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).xMG.add(((ArrayList)localObject2).get(paramInt));
        }
        paramInt += 1;
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).FAO = localOnClickListener;
      if (((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).xMG.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).cL(((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).BcO + paramInt);
          paramInt += 1;
        }
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).cN(((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).BcO + i);
    }
    for (;;)
    {
      localObject1 = this.FvK;
      localObject2 = c.a(this.FvK.getAdapter().getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/multitalk/ui/MultiTalkSelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "scrollToPosition", "(I)V");
      paramView.notifyDataSetChanged();
      atk();
      AppMethodBeat.o(199846);
      return;
      if (this.mNh.size() + this.mNi.size() == com.tencent.mm.plugin.multitalk.d.e.eZN())
      {
        this.FvL = true;
        com.tencent.mm.plugin.multitalk.d.b.hD(this);
        AppMethodBeat.o(199846);
        return;
      }
      if (this.FvI) {
        this.FvJ.aQL((String)localObject1);
      }
      this.mNi.add(localObject1);
      this.FvG.add(localObject1);
      localObject1 = (com.tencent.mm.plugin.multitalk.ui.widget.q)this.FvK.getAdapter();
      localObject2 = this.FvG;
      localOnClickListener = this.FvN;
      kotlin.g.b.p.k(localObject2, "userNameList");
      kotlin.g.b.p.k(localOnClickListener, "onClickListener");
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).xMG.clear();
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).xMG.add(z.bcZ());
      i = ((Collection)localObject2).size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject3 = ((ArrayList)localObject2).get(paramInt);
        kotlin.g.b.p.j(localObject3, "userNameList[i]");
        if ((!((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).aQR((String)localObject3)) && ((kotlin.g.b.p.h((String)((ArrayList)localObject2).get(paramInt), z.bcZ()) ^ true))) {
          ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).xMG.add(((ArrayList)localObject2).get(paramInt));
        }
        paramInt += 1;
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).FAO = localOnClickListener;
      if (((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).xMG.size() < 5)
      {
        paramInt = 0;
        while (paramInt < 5)
        {
          ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).cL(((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).BcO + paramInt);
          paramInt += 1;
        }
      }
      ((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).cM(((com.tencent.mm.plugin.multitalk.ui.widget.q)localObject1).getItemCount());
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114704);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.mNi.contains(parama.contact.field_username);
      AppMethodBeat.o(114704);
      return bool;
    }
    AppMethodBeat.o(114704);
    return false;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(114695);
    super.ata();
    this.FvI = getIntent().getBooleanExtra("key_need_gallery", false);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!ab.Lj(this.chatroomName)) {
      finish();
    }
    this.mNi = new HashSet();
    this.mNh = new HashSet();
    this.FvG = new ArrayList();
    AppMethodBeat.o(114695);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(114705);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.mNh.contains(parama.contact.field_username);
      AppMethodBeat.o(114705);
      return bool;
    }
    AppMethodBeat.o(114705);
    return false;
  }
  
  public final boolean bwH()
  {
    return false;
  }
  
  public final boolean bwI()
  {
    return false;
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(114699);
    String str = getIntent().getStringExtra("titile");
    AppMethodBeat.o(114699);
    return str;
  }
  
  public final r bwK()
  {
    AppMethodBeat.i(114700);
    a locala = new a(this, this.chatroomName);
    AppMethodBeat.o(114700);
    return locala;
  }
  
  public final com.tencent.mm.ui.contact.p bwL()
  {
    AppMethodBeat.i(114701);
    b localb = new b(this, this.chatroomName);
    AppMethodBeat.o(114701);
    return localb;
  }
  
  public void eQp()
  {
    AppMethodBeat.i(114703);
    super.eQp();
    hideVKB();
    if (this.FvF) {
      f.d(false, true, true);
    }
    AppMethodBeat.o(114703);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.f.multitalk_select_contact_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(114696);
    super.initView();
    this.FvM = new d(this);
    Object localObject;
    ListView localListView;
    int i;
    if ((!this.FvM.Fxn) && (com.tencent.mm.plugin.multitalk.d.b.eZA()))
    {
      localObject = this.FvM;
      localListView = this.Hpw;
      ((d)localObject).mrI = ListView.inflate(((d)localObject).mContext, a.f.multitalk_link_meeting, null);
      ((d)localObject).mrI.getViewTreeObserver().addOnDrawListener(((d)localObject).Fxt);
      ((d)localObject).mrI.setOnClickListener(new d.2((d)localObject));
      ((d)localObject).Fxo = ((WxImageView)((d)localObject).mrI.findViewById(a.e.metting_link_icon));
      ((d)localObject).Fxq = ((TextView)((d)localObject).mrI.findViewById(a.e.meeting_detail_tv));
      ((d)localObject).Fxp = ((TextView)((d)localObject).mrI.findViewById(a.e.meeting_link_tv));
      ((d)localObject).Fxr = ((WxImageView)((d)localObject).mrI.findViewById(a.e.more_arrow));
      ((d)localObject).Fxr.setBackground(au.o(MMApplicationContext.getContext(), a.g.icons_filled_arrow, -1));
      if ((Util.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.eZH())) || (Util.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.eZI()))) {
        break label437;
      }
      ((d)localObject).Fxp.setText(com.tencent.mm.plugin.multitalk.d.b.eZH());
      ((d)localObject).Fxq.setText(com.tencent.mm.plugin.multitalk.d.b.eZI());
      i = 1;
    }
    for (;;)
    {
      if (!Util.isNullOrNil(com.tencent.mm.plugin.multitalk.d.b.getIconUrl()))
      {
        com.tencent.mm.ay.q.bml().a(com.tencent.mm.plugin.multitalk.d.b.getIconUrl(), null, new d.3((d)localObject));
        label244:
        localListView.removeFooterView(((d)localObject).mrI);
        if (i == 0) {
          break label551;
        }
        ((d)localObject).Fxn = true;
        localListView.addFooterView(((d)localObject).mrI);
        label270:
        setActionbarColor(getResources().getColor(a.b.dark_actionbar_color));
        hideActionbarLine();
        setNavigationbarColor(Color.parseColor("#232323"));
        this.FvJ = new l(this);
        localObject = getString(a.h.multitalk_ok, new Object[] { Integer.valueOf(this.mNh.size() + this.mNi.size()) });
        if (!this.FvI) {
          break label568;
        }
        localObject = getString(a.h.multitalk_start_talk, new Object[] { Integer.valueOf(this.mNh.size() + this.mNi.size()) });
      }
      label437:
      label568:
      for (;;)
      {
        addTextOptionMenu(1, (String)localObject, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(114692);
            if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
              com.tencent.mm.bj.e.a(MultiTalkSelectContactUI.this, a.h.voip_net_unavailable, null);
            }
            for (;;)
            {
              MultiTalkSelectContactUI.this.hideVKB();
              AppMethodBeat.o(114692);
              return true;
              paramAnonymousMenuItem = new LinkedList();
              paramAnonymousMenuItem.addAll(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this));
              paramAnonymousMenuItem.add(z.bcZ());
              paramAnonymousMenuItem = Util.listToString(paramAnonymousMenuItem, ",");
              if (MultiTalkSelectContactUI.b(MultiTalkSelectContactUI.this))
              {
                com.tencent.mm.plugin.multitalk.model.p.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 1, "", MultiTalkSelectContactUI.d(MultiTalkSelectContactUI.this).Fzj);
                ad.eYc().e(MultiTalkSelectContactUI.this, paramAnonymousMenuItem, MultiTalkSelectContactUI.e(MultiTalkSelectContactUI.this));
              }
              else
              {
                com.tencent.mm.plugin.multitalk.model.p.a(MultiTalkSelectContactUI.a(MultiTalkSelectContactUI.this).size(), MultiTalkSelectContactUI.c(MultiTalkSelectContactUI.this), 2, v.eXM(), 0);
                MultiTalkSelectContactUI.this.setResult(-1, MultiTalkSelectContactUI.this.getIntent().putExtra("Select_Contact", paramAnonymousMenuItem));
                MultiTalkSelectContactUI.this.FvF = false;
                MultiTalkSelectContactUI.this.finish();
              }
            }
          }
        }, null, w.b.Wao);
        atk();
        this.ETP.setBackgroundResource(a.b.default_bg_color);
        this.ETP.getInputText().setTextColor(-1);
        hUU();
        AppMethodBeat.o(114696);
        return;
        if (com.tencent.mm.plugin.multitalk.d.b.eZB())
        {
          ((d)localObject).Fxp.setText(a.h.multitalk_use_meeting);
          ((d)localObject).Fxq.setText(a.h.meeting_detail);
          i = 1;
          break;
        }
        if (!com.tencent.mm.plugin.multitalk.d.b.eZC()) {
          break label571;
        }
        ((d)localObject).Fxp.setText(a.h.multitalk_use_work);
        ((d)localObject).Fxq.setText(a.h.wework_detail);
        i = 1;
        break;
        if (com.tencent.mm.plugin.multitalk.d.b.eZB())
        {
          ((d)localObject).Fxo.setBackground(au.o(MMApplicationContext.getContext(), a.g.icons_outlined_tencentmeeting_logo, -1));
          break label244;
        }
        if (!com.tencent.mm.plugin.multitalk.d.b.eZC()) {
          break label244;
        }
        ((d)localObject).Fxo.setBackground(au.o(MMApplicationContext.getContext(), a.g.icons_outlined_wxwork_logo, -1));
        break label244;
        ((d)localObject).Fxn = true;
        Log.e("MicroMsg.MeetingLinkFooter", "not get wording, not show footer");
        break label270;
      }
      label551:
      label571:
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
    d locald = this.FvM;
    if ((locald.mrI != null) && (locald.Fxt != null))
    {
      locald.mrI.getViewTreeObserver().removeOnDrawListener(locald.Fxt);
      locald.mContext = null;
    }
    EventCenter.instance.removeListener(this.kLS);
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
    f.d(true, false, true);
    AppMethodBeat.o(178902);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(178900);
    super.onStart();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.mNh.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    this.mNh.add(z.bcZ());
    this.FvG.addAll(this.mNh);
    if (this.FvI) {
      this.FvJ.aQL(z.bcZ());
    }
    this.FvK = ((RecyclerView)findViewById(a.e.small_avatar_list));
    localObject = new LinearLayoutManager();
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.FvK.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.FvK.setAdapter(new com.tencent.mm.plugin.multitalk.ui.widget.q(this));
    ((com.tencent.mm.plugin.multitalk.ui.widget.q)this.FvK.getAdapter()).b(this.FvG, this.FvN);
    EventCenter.instance.addListener(this.kLS);
    AppMethodBeat.o(178900);
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