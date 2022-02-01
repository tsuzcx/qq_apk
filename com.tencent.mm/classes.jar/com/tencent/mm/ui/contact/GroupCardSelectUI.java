package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.n.b;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI
  extends MMActivity
{
  private boolean GVA;
  private ArrayList<String> GVB;
  private int GVC;
  private int GVD;
  private ListView GVE;
  private m GVF;
  private HashMap<String, Long> GVG;
  private List<String> GVw = null;
  private boolean GVx = false;
  private boolean GVy = true;
  private boolean GVz;
  private TextView emptyTipTv;
  private List<af> fsY;
  
  private void VV()
  {
    AppMethodBeat.i(37861);
    StringBuilder localStringBuilder;
    if (this.GVx)
    {
      localStringBuilder = new StringBuilder().append(getString(2131755835));
      if (this.GVw.size() <= 0) {
        break label85;
      }
    }
    label85:
    for (String str = String.format("(%s)", new Object[] { Integer.valueOf(this.GVw.size()) });; str = "")
    {
      updateOptionMenuText(1, str);
      AppMethodBeat.o(37861);
      return;
    }
  }
  
  private void a(int paramInt, af paramaf, long paramLong)
  {
    AppMethodBeat.i(37860);
    int i = 0;
    while ((i < paramInt) && (paramLong <= ((Long)this.GVG.get(((af)this.fsY.get(i)).field_username)).longValue())) {
      i += 1;
    }
    this.fsY.add(i, paramaf);
    AppMethodBeat.o(37860);
  }
  
  private boolean c(af paramaf)
  {
    AppMethodBeat.i(191667);
    if (this.GVC == 2147483647)
    {
      AppMethodBeat.o(191667);
      return true;
    }
    if (paramaf == null)
    {
      AppMethodBeat.o(191667);
      return false;
    }
    com.tencent.mm.storage.w localw = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(paramaf.field_username);
    if (localw == null)
    {
      ad.e("MicroMsg.GroupCardSelectUI", "isValidByMaxNum %s member is null", new Object[] { paramaf.field_username });
      AppMethodBeat.o(191667);
      return false;
    }
    if (localw.field_memberCount < this.GVC)
    {
      AppMethodBeat.o(191667);
      return true;
    }
    AppMethodBeat.o(191667);
    return false;
  }
  
  private void fbw()
  {
    AppMethodBeat.i(37859);
    az.arV();
    this.GVG = com.tencent.mm.model.c.apR().eLh();
    this.fsY = new LinkedList();
    List localList = com.tencent.mm.model.w.ars();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(37859);
      return;
    }
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      af localaf = (af)localIterator.next();
      if ((!com.tencent.mm.model.w.so(localaf.field_username)) && ((this.GVB == null) || (!this.GVB.contains(localaf.field_username))))
      {
        com.tencent.mm.storage.w localw;
        if (!this.GVG.containsKey(localaf.field_username))
        {
          if (!b.ls(localaf.field_type)) {
            break label399;
          }
          if (this.GVA)
          {
            localw = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(localaf.field_username);
            if (localw == null) {
              ad.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { bt.by(localaf.field_username, "") });
            } else if ((localw.ty(u.aqG())) && (c(localaf))) {
              this.fsY.add(localaf);
            }
          }
          else
          {
            if (!c(localaf)) {
              break label399;
            }
            this.fsY.add(localaf);
          }
        }
        else if (this.GVA)
        {
          localw = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(localaf.field_username);
          if (localw == null) {
            ad.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { bt.by(localaf.field_username, "") });
          } else {
            if (!localw.ty(u.aqG())) {
              break;
            }
          }
        }
        else if (c(localaf))
        {
          a(i, localaf, ((Long)this.GVG.get(localaf.field_username)).longValue());
          i += 1;
        }
      }
    }
    label399:
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
    return 2131494421;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37858);
    this.GVE = ((ListView)findViewById(2131300626));
    this.GVF = new m(this, this.fsY, this.GVw, this.GVx);
    this.GVE.setAdapter(this.GVF);
    this.GVE.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37851);
        paramAnonymousAdapterView = (af)GroupCardSelectUI.a(GroupCardSelectUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ad.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
          AppMethodBeat.o(37851);
          return;
        }
        GroupCardSelectUI.a(GroupCardSelectUI.this, paramAnonymousAdapterView);
        GroupCardSelectUI.b(GroupCardSelectUI.this);
        AppMethodBeat.o(37851);
      }
    });
    this.emptyTipTv = ((TextView)findViewById(2131300622));
    if (this.GVF.getCount() <= 0) {
      this.emptyTipTv.setVisibility(0);
    }
    for (;;)
    {
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
      AppMethodBeat.o(37858);
      return;
      this.emptyTipTv.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37854);
    super.onCreate(paramBundle);
    this.GVy = getIntent().getBooleanExtra("group_select_type", true);
    this.GVz = getIntent().getBooleanExtra("group_select_need_result", false);
    this.GVA = getIntent().getBooleanExtra("group_select_only_need_self_owner", false);
    this.GVB = getIntent().getStringArrayListExtra("group_select_block_chatroom");
    this.GVC = getIntent().getIntExtra("group_select_chatroom_max_num", 2147483647);
    if (this.GVA)
    {
      setMMTitle(getString(2131755949));
      this.GVx = getIntent().getBooleanExtra("group_multi_select", false);
      if (this.GVx)
      {
        paramBundle = getIntent().getStringExtra("already_select_contact");
        if (!bt.isNullOrNil(paramBundle)) {
          break label240;
        }
      }
    }
    label240:
    for (this.GVw = new LinkedList();; this.GVw = ae.l(paramBundle.split(",")))
    {
      this.GVD = getIntent().getIntExtra("max_limit_num", 0);
      fbw();
      initView();
      if (this.GVx)
      {
        addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(37853);
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Conv_User", bt.n(GroupCardSelectUI.c(GroupCardSelectUI.this), ","));
            GroupCardSelectUI.this.setResult(-1, paramAnonymousMenuItem);
            GroupCardSelectUI.this.finish();
            AppMethodBeat.o(37853);
            return true;
          }
        }, null, r.b.FOB);
        enableOptionMenu(1, true);
        VV();
      }
      AppMethodBeat.o(37854);
      return;
      setMMTitle(getString(2131755225));
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
    TextView GVI;
    ImageView ikp;
    TextView sNC;
    CheckBox uxt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI
 * JD-Core Version:    0.7.0.1
 */