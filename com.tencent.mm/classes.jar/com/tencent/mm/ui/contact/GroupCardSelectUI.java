package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI
  extends MMActivity
{
  private boolean XsA = true;
  private boolean XsB;
  private boolean XsC;
  private boolean XsD;
  private ArrayList<String> XsE;
  private int XsF;
  private int XsG;
  private ListView XsH;
  private n XsI;
  private HashMap<String, Long> XsJ;
  private List<String> Xsy = null;
  private boolean Xsz = false;
  private TextView emptyTipTv;
  private List<as> jbu;
  
  private void a(int paramInt, as paramas, long paramLong)
  {
    AppMethodBeat.i(37860);
    int i = 0;
    while ((i < paramInt) && (paramLong <= ((Long)this.XsJ.get(((as)this.jbu.get(i)).field_username)).longValue())) {
      i += 1;
    }
    this.jbu.add(i, paramas);
    AppMethodBeat.o(37860);
  }
  
  private void atk()
  {
    AppMethodBeat.i(37861);
    StringBuilder localStringBuilder;
    if (this.Xsz)
    {
      localStringBuilder = new StringBuilder().append(getString(R.l.app_ok));
      if (this.Xsy.size() <= 0) {
        break label89;
      }
    }
    label89:
    for (String str = String.format("(%s)", new Object[] { Integer.valueOf(this.Xsy.size()) });; str = "")
    {
      updateOptionMenuText(1, str);
      AppMethodBeat.o(37861);
      return;
    }
  }
  
  private boolean c(as paramas)
  {
    AppMethodBeat.i(285554);
    if (this.XsF == 2147483647)
    {
      AppMethodBeat.o(285554);
      return true;
    }
    if (paramas == null)
    {
      AppMethodBeat.o(285554);
      return false;
    }
    ah localah = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramas.field_username);
    if (localah == null)
    {
      Log.e("MicroMsg.GroupCardSelectUI", "isValidByMaxNum %s member is null", new Object[] { paramas.field_username });
      AppMethodBeat.o(285554);
      return false;
    }
    if (localah.field_memberCount < this.XsF)
    {
      AppMethodBeat.o(285554);
      return true;
    }
    AppMethodBeat.o(285554);
    return false;
  }
  
  private void hUJ()
  {
    AppMethodBeat.i(37859);
    bh.beI();
    this.XsJ = c.bbR().hyG();
    this.jbu = new LinkedList();
    List localList = ab.bdX();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(37859);
      return;
    }
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      as localas = (as)localIterator.next();
      if ((!ab.PR(localas.field_username)) && ((this.XsE == null) || (!this.XsE.contains(localas.field_username))))
      {
        ah localah;
        if (!this.XsJ.containsKey(localas.field_username))
        {
          if (!d.rk(localas.field_type)) {
            break label397;
          }
          if (this.XsC)
          {
            localah = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(localas.field_username);
            if (localah == null) {
              Log.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
            } else if ((localah.Rh(z.bcZ())) && (c(localas))) {
              this.jbu.add(localas);
            }
          }
          else
          {
            if (!c(localas)) {
              break label397;
            }
            this.jbu.add(localas);
          }
        }
        else if (this.XsC)
        {
          localah = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(localas.field_username);
          if (localah == null) {
            Log.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
          } else {
            if (!localah.Rh(z.bcZ())) {
              break;
            }
          }
        }
        else if (c(localas))
        {
          a(i, localas, ((Long)this.XsJ.get(localas.field_username)).longValue());
          i += 1;
        }
      }
    }
    label397:
    for (;;)
    {
      break;
      localList.clear();
      AppMethodBeat.o(37859);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.ehw;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37858);
    this.XsH = ((ListView)findViewById(R.h.dIe));
    this.XsI = new n(this, this.jbu, this.Xsy, this.Xsz);
    this.XsH.setAdapter(this.XsI);
    this.XsH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37851);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        int i = paramAnonymousInt;
        if (GroupCardSelectUI.a(GroupCardSelectUI.this))
        {
          i = GroupCardSelectUI.b(GroupCardSelectUI.this).getHeaderViewsCount();
          if (paramAnonymousInt == 0)
          {
            GroupCardSelectUI.c(GroupCardSelectUI.this);
            a.a(this, "com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(37851);
            return;
          }
          i = paramAnonymousInt - i;
        }
        paramAnonymousAdapterView = (as)GroupCardSelectUI.d(GroupCardSelectUI.this).getItem(i);
        if (paramAnonymousAdapterView == null)
        {
          Log.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
          a.a(this, "com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37851);
          return;
        }
        GroupCardSelectUI.a(GroupCardSelectUI.this, paramAnonymousAdapterView);
        GroupCardSelectUI.e(GroupCardSelectUI.this);
        a.a(this, "com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(37851);
      }
    });
    this.emptyTipTv = ((TextView)findViewById(R.h.dIa));
    ListView localListView;
    View localView;
    TextView localTextView;
    if (this.XsI.getCount() <= 0)
    {
      this.emptyTipTv.setVisibility(0);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37852);
          GroupCardSelectUI.this.finish();
          AppMethodBeat.o(37852);
          return true;
        }
      });
      if (this.XsD)
      {
        localListView = this.XsH;
        localView = ad.kS(this).inflate(R.i.ehy, null);
        ((TextView)localView.findViewById(R.h.content_tv)).setText(R.l.etO);
        localTextView = (TextView)localView.findViewById(R.h.dSJ);
        if (this.XsI.getCount() > 0) {
          break label205;
        }
        localTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      localListView.addHeaderView(localView);
      AppMethodBeat.o(37858);
      return;
      this.emptyTipTv.setVisibility(8);
      break;
      label205:
      localTextView.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37854);
    super.onCreate(paramBundle);
    this.XsA = getIntent().getBooleanExtra("group_select_type", true);
    this.XsB = getIntent().getBooleanExtra("group_select_need_result", false);
    this.XsC = getIntent().getBooleanExtra("group_select_only_need_self_owner", false);
    this.XsE = getIntent().getStringArrayListExtra("group_select_block_chatroom");
    this.XsD = getIntent().getBooleanExtra("group_select_show_create_new_group", false);
    this.XsF = getIntent().getIntExtra("group_select_chatroom_max_num", 2147483647);
    if ((this.XsC) && (!this.XsD))
    {
      setMMTitle(getString(R.l.enP));
      this.Xsz = getIntent().getBooleanExtra("group_multi_select", false);
      if (this.Xsz)
      {
        paramBundle = getIntent().getStringExtra("already_select_contact");
        if (!Util.isNullOrNil(paramBundle)) {
          break label263;
        }
      }
    }
    label263:
    for (this.Xsy = new LinkedList();; this.Xsy = ae.j(paramBundle.split(",")))
    {
      this.XsG = getIntent().getIntExtra("max_limit_num", 0);
      hUJ();
      initView();
      if (this.Xsz)
      {
        addTextOptionMenu(1, getString(R.l.app_ok), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(37853);
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Conv_User", Util.listToString(GroupCardSelectUI.f(GroupCardSelectUI.this), ","));
            GroupCardSelectUI.this.setResult(-1, paramAnonymousMenuItem);
            GroupCardSelectUI.this.finish();
            AppMethodBeat.o(37853);
            return true;
          }
        }, null, w.b.Wao);
        enableOptionMenu(1, true);
        atk();
      }
      AppMethodBeat.o(37854);
      return;
      setMMTitle(getString(R.l.enO));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37855);
    super.onDestroy();
    AppMethodBeat.o(37855);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37857);
    super.onPause();
    AppMethodBeat.o(37857);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37856);
    super.onResume();
    AppMethodBeat.o(37856);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    TextView Efd;
    CheckBox GUH;
    TextView XsM;
    ImageView mWb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI
 * JD-Core Version:    0.7.0.1
 */