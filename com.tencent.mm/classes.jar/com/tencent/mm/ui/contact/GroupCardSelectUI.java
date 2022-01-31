package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI
  extends MMActivity
{
  private TextView emptyTipTv;
  private List<ad> maY;
  private boolean vLp = true;
  private boolean vLq;
  private boolean vLr = false;
  private List<String> vLs = null;
  private int vLt;
  private ListView vLu;
  private a vLv;
  private HashMap<String, Long> vLw;
  
  private void a(int paramInt, ad paramad, long paramLong)
  {
    int i = 0;
    while ((i < paramInt) && (paramLong <= ((Long)this.vLw.get(((ad)this.maY.get(i)).field_username)).longValue())) {
      i += 1;
    }
    this.maY.add(i, paramad);
  }
  
  private void cHC()
  {
    au.Hx();
    this.vLw = c.FB().cuE();
    this.maY = new LinkedList();
    List localList = com.tencent.mm.model.s.GV();
    if (localList.size() == 0) {
      return;
    }
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      if (!this.vLw.containsKey(localad.field_username))
      {
        if (!com.tencent.mm.n.a.gR(localad.field_type)) {
          break label150;
        }
        this.maY.add(localad);
      }
      else
      {
        a(i, localad, ((Long)this.vLw.get(localad.field_username)).longValue());
        i += 1;
      }
    }
    label150:
    for (;;)
    {
      break;
      localList.clear();
      return;
    }
  }
  
  private void xU()
  {
    StringBuilder localStringBuilder;
    if (this.vLr)
    {
      localStringBuilder = new StringBuilder().append(getString(R.l.app_ok));
      if (this.vLs.size() <= 0) {
        break label77;
      }
    }
    label77:
    for (String str = String.format("(%s)", new Object[] { Integer.valueOf(this.vLs.size()) });; str = "")
    {
      updateOptionMenuText(1, str);
      return;
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.group_card_select;
  }
  
  protected final void initView()
  {
    this.vLu = ((ListView)findViewById(R.h.group_card_select_list));
    this.vLv = new a();
    this.vLu.setAdapter(this.vLv);
    this.vLu.setOnItemClickListener(new GroupCardSelectUI.1(this));
    this.emptyTipTv = ((TextView)findViewById(R.h.group_card_empty_tip_tv));
    if (this.vLv.getCount() <= 0) {
      this.emptyTipTv.setVisibility(0);
    }
    for (;;)
    {
      setBackBtn(new GroupCardSelectUI.2(this));
      return;
      this.emptyTipTv.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(getString(R.l.address_select_group_card));
    this.vLp = getIntent().getBooleanExtra("group_select_type", true);
    this.vLq = getIntent().getBooleanExtra("group_select_need_result", false);
    this.vLr = getIntent().getBooleanExtra("group_multi_select", false);
    if (this.vLr)
    {
      paramBundle = getIntent().getStringExtra("already_select_contact");
      if (!bk.bl(paramBundle)) {
        break label161;
      }
    }
    label161:
    for (this.vLs = new LinkedList();; this.vLs = ah.h(paramBundle.split(",")))
    {
      this.vLt = getIntent().getIntExtra("max_limit_num", 0);
      cHC();
      initView();
      if (this.vLr)
      {
        a(1, getString(R.l.app_ok), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Conv_User", bk.c(GroupCardSelectUI.e(GroupCardSelectUI.this), ","));
            GroupCardSelectUI.this.setResult(-1, paramAnonymousMenuItem);
            GroupCardSelectUI.this.finish();
            return true;
          }
        }, s.b.uNx);
        enableOptionMenu(1, true);
        xU();
      }
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  final class a
    extends BaseAdapter
  {
    public a() {}
    
    public final int getCount()
    {
      return GroupCardSelectUI.c(GroupCardSelectUI.this).size();
    }
    
    public final Object getItem(int paramInt)
    {
      return GroupCardSelectUI.c(GroupCardSelectUI.this).get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ad localad = (ad)GroupCardSelectUI.c(GroupCardSelectUI.this).get(paramInt);
      if (paramView == null)
      {
        paramViewGroup = new GroupCardSelectUI.b(GroupCardSelectUI.this);
        paramView = View.inflate(GroupCardSelectUI.this, R.i.group_card_select_item, null);
        paramViewGroup.lCr = ((TextView)paramView.findViewById(R.h.group_card_item_count_tv));
        paramViewGroup.vLy = ((TextView)paramView.findViewById(R.h.group_card_item_nick));
        paramViewGroup.ffK = ((ImageView)paramView.findViewById(R.h.group_card_item_avatar_iv));
        paramViewGroup.mTF = ((CheckBox)paramView.findViewById(R.h.select_cb));
        paramView.setTag(paramViewGroup);
        a.b.a(paramViewGroup.ffK, localad.field_username);
        paramViewGroup.vLy.setText(j.b(GroupCardSelectUI.this, r.gV(localad.field_username), com.tencent.mm.cb.a.aa(GroupCardSelectUI.this.mController.uMN, R.f.NormalTextSize)));
        paramViewGroup.lCr.setText("(" + m.gM(localad.field_username) + ")");
        if (!com.tencent.mm.model.s.hb(localad.field_username)) {
          break label306;
        }
        Drawable localDrawable = GroupCardSelectUI.this.getResources().getDrawable(R.k.open_im_main_logo);
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        paramViewGroup.vLy.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      }
      for (;;)
      {
        if (GroupCardSelectUI.d(GroupCardSelectUI.this))
        {
          paramViewGroup.mTF.setVisibility(0);
          if (!GroupCardSelectUI.e(GroupCardSelectUI.this).contains(localad.field_username)) {
            break label320;
          }
          paramViewGroup.mTF.setChecked(true);
        }
        return paramView;
        paramViewGroup = (GroupCardSelectUI.b)paramView.getTag();
        break;
        label306:
        paramViewGroup.vLy.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      label320:
      paramViewGroup.mTF.setChecked(false);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI
 * JD-Core Version:    0.7.0.1
 */