package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.as.a.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;

public class ShakeItemListUI
  extends MMActivity
{
  private a eqj = null;
  private ListView fiu;
  private n.d hZq = new ShakeItemListUI.8(this);
  private int id;
  private View iwe;
  public long obB = 0L;
  private boolean obC = false;
  private ShakeItemListUI.a obD;
  private int showType;
  
  public static int xr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return R.l.shake_friends_history_empty;
    case 100: 
      return R.l.shake_history_empty;
    case -1: 
    case 0: 
      return R.l.shake_friends_history_empty;
    case -5: 
    case 4: 
      return R.l.shake_music_history_empty;
    case -6: 
    case 5: 
      return R.l.shake_tv_history_empty;
    }
    return R.l.shake_ibeacon_history_empty;
  }
  
  protected final int getLayoutId()
  {
    return R.i.shake_friend;
  }
  
  protected final void initView()
  {
    this.eqj = new a(this);
    au.Hx();
    int i = bk.a((Integer)c.Dz().get(12290, null), 0);
    this.showType = getIntent().getIntExtra("_key_show_type_", 0);
    Object localObject = getIntent().getStringExtra("_key_title_");
    if (!bk.bl((String)localObject)) {
      setMMTitle((String)localObject);
    }
    this.obC = getIntent().getBooleanExtra("_key_show_from_shake_", false);
    addTextOptionMenu(0, getString(R.l.app_clear), new ShakeItemListUI.1(this));
    this.fiu = ((ListView)findViewById(R.h.nearby_friend_lv));
    this.iwe = getLayoutInflater().inflate(R.i.shake_friends_views_fooder, null);
    this.iwe.findViewById(R.h.shake_friends_see_olders).setOnClickListener(new ShakeItemListUI.2(this));
    this.fiu.addFooterView(this.iwe);
    if (this.showType == -1)
    {
      this.iwe.findViewById(R.h.shake_friends_see_olders).setVisibility(0);
      this.obD = new ShakeItemListUI.a(this, this);
      this.obD.xq(this.showType);
      if (this.obD.getCount() > 0) {
        break label317;
      }
      this.fiu.setVisibility(8);
      localObject = (TextView)findViewById(R.h.nearby_friend_not_found);
      ((TextView)localObject).setText(xr(this.showType));
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      setBackBtn(new ShakeItemListUI.5(this));
      new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          BackwardSupportUtil.c.a(ShakeItemListUI.c(ShakeItemListUI.this));
        }
      };
      this.fiu.setOnTouchListener(new ShakeItemListUI.7(this));
      return;
      this.iwe.findViewById(R.h.shake_friends_see_olders).setVisibility(8);
      break;
      label317:
      this.fiu.setAdapter(this.obD);
      this.fiu.setOnItemClickListener(new ShakeItemListUI.3(this, i));
      localObject = new j(this);
      this.fiu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (paramAnonymousInt < ShakeItemListUI.c(ShakeItemListUI.this).getHeaderViewsCount())
          {
            y.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
            return true;
          }
          this.hZt.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeItemListUI.this, ShakeItemListUI.e(ShakeItemListUI.this));
          return true;
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    m.bzU().c(this.obD);
    this.obD.yd();
    y.i("MicroMsg.ShakeItemListUI", "onResume");
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.id = ((d)this.obD.getItem(paramView.position)).field_shakeItemID;
    paramContextMenu.add(paramView.position, 0, 0, R.l.app_delete);
  }
  
  protected void onDestroy()
  {
    this.obD.bcS();
    ShakeItemListUI.a locala = this.obD;
    if (locala.ffG != null)
    {
      locala.ffG.detach();
      locala.ffG = null;
    }
    m.bzU().d(this.obD);
    y.i("MicroMsg.ShakeItemListUI", "onPause");
    if (this.eqj != null) {
      this.eqj.detach();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected final void xq(int paramInt)
  {
    this.obD.xq(paramInt);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.iwe == null);
      this.iwe.findViewById(R.h.shake_friends_see_olders).setVisibility(8);
      return;
    } while (this.iwe == null);
    this.iwe.findViewById(R.h.shake_friends_see_olders).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI
 * JD-Core Version:    0.7.0.1
 */