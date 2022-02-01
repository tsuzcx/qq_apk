package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.k;
import com.tencent.mm.ui.r.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsTrustFriendUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private static int wjt = 5;
  private View mxV;
  private p pMe;
  private GridView qXf;
  private TextView smp;
  private boolean whl;
  private List<String> wjr;
  private a wjs;
  
  private void dop()
  {
    AppMethodBeat.i(74490);
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(352277, null);
    ArrayList localArrayList = new ArrayList();
    if (!bt.isNullOrNil(str)) {
      localArrayList = bt.S(str.split(","));
    }
    for (;;)
    {
      if ((this.wjr.size() == localArrayList.size()) && (this.wjr.containsAll(localArrayList)))
      {
        finish();
        AppMethodBeat.o(74490);
        return;
      }
      h.a(this, getString(2131762782), getString(2131755906), getString(2131755880), getString(2131755832), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74470);
          SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
          AppMethodBeat.o(74470);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74471);
          SettingsTrustFriendUI.this.finish();
          AppMethodBeat.o(74471);
        }
      });
      AppMethodBeat.o(74490);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495408;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74487);
    setMMTitle(2131763466);
    this.qXf = ((GridView)findViewById(2131306084));
    this.wjs = new a((byte)0);
    int i = getResources().getDimensionPixelSize(2131165510);
    this.qXf.setColumnWidth(i);
    this.qXf.setNumColumns(-1);
    this.qXf.setStretchMode(1);
    this.qXf.setHorizontalSpacing(getResources().getDimensionPixelSize(2131166411) * 2);
    this.qXf.setVerticalSpacing(getResources().getDimensionPixelSize(2131166412));
    this.qXf.setAdapter(this.wjs);
    ((ViewGroup)this.qXf.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74473);
        if (SettingsTrustFriendUI.b(SettingsTrustFriendUI.this))
        {
          SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(74473);
      }
    });
    this.qXf.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(74474);
        if ((SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) && (paramAnonymousMotionEvent.getAction() == 1) && (SettingsTrustFriendUI.d(SettingsTrustFriendUI.this).pointToPosition((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY()) == -1))
        {
          SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
          AppMethodBeat.o(74474);
          return true;
        }
        AppMethodBeat.o(74474);
        return false;
      }
    });
    this.qXf.setHorizontalScrollBarEnabled(false);
    this.qXf.setVerticalScrollBarEnabled(false);
    this.qXf.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(74475);
        if (SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) == 1)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("list_type", 12);
          paramAnonymousAdapterView.putExtra("titile", SettingsTrustFriendUI.this.getString(2131755234));
          paramAnonymousAdapterView.putExtra("scene", 2);
          paramAnonymousAdapterView.putExtra("max_limit_num", SettingsTrustFriendUI.wjt);
          paramAnonymousAdapterView.putExtra("stay_in_wechat", true);
          paramAnonymousAdapterView.putExtra("already_select_contact", bt.n(SettingsTrustFriendUI.e(SettingsTrustFriendUI.this), ","));
          paramAnonymousAdapterView.putExtra("block_contact", com.tencent.mm.model.u.aqG());
          paramAnonymousAdapterView.putExtra("list_attr", com.tencent.mm.ui.contact.u.jw(com.tencent.mm.ui.contact.u.jw(com.tencent.mm.ui.contact.u.GWH, 256), 16777216));
          paramAnonymousAdapterView.putExtra("KBlockOpenImFav", true);
          paramAnonymousAdapterView.putExtra("without_openim", true);
          paramAnonymousAdapterView.putExtra("too_many_member_tip_string", SettingsTrustFriendUI.this.getString(2131763468, new Object[] { Integer.valueOf(SettingsTrustFriendUI.wjt) }));
          d.c(SettingsTrustFriendUI.this, ".ui.contact.SelectContactUI", paramAnonymousAdapterView, 1);
          AppMethodBeat.o(74475);
          return;
        }
        if (SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) == 2) {
          if (!SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) {
            SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, true);
          }
        }
        for (;;)
        {
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
          do
          {
            AppMethodBeat.o(74475);
            return;
          } while ((SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) != 0) || (!SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)));
          SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).remove(SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItem(paramAnonymousInt));
          if (SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).size() == 0) {
            SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          }
        }
      }
    });
    this.smp = ((TextView)findViewById(2131306083));
    String str = getIntent().getStringExtra(e.k.FIh);
    if (!bt.isNullOrNil(str)) {
      this.smp.setText(str);
    }
    for (;;)
    {
      this.mxV = findViewById(2131306087);
      this.mxV.setVisibility(8);
      ((TextView)this.mxV.findViewById(2131306866)).setText(getString(2131763469, new Object[] { Integer.valueOf(3) }));
      this.mxV.findViewById(2131298370).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74476);
          SettingsTrustFriendUI.f(SettingsTrustFriendUI.this).setVisibility(8);
          AppMethodBeat.o(74476);
        }
      });
      findViewById(2131306085).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74477);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=w_security_center_website/trusted_friend_guide");
          d.b(SettingsTrustFriendUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          AppMethodBeat.o(74477);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74478);
          SettingsTrustFriendUI.g(SettingsTrustFriendUI.this);
          AppMethodBeat.o(74478);
          return true;
        }
      });
      addTextOptionMenu(1, getString(2131755779), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74479);
          SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
          AppMethodBeat.o(74479);
          return true;
        }
      }, null, r.b.FOB);
      showOptionMenu(true);
      AppMethodBeat.o(74487);
      return;
      this.smp.setText(getResources().getString(2131763470, new Object[] { Integer.valueOf(3) }));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74488);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!bt.isNullOrNil(paramIntent))
      {
        this.wjr.clear();
        this.wjr.addAll(bt.S(paramIntent.split(",")));
        this.wjs.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(74488);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74484);
    super.onCreate(paramBundle);
    paramBundle = (String)com.tencent.mm.kernel.g.afB().afk().get(352277, null);
    if (!bt.isNullOrNil(paramBundle)) {
      this.wjr = bt.S(paramBundle.split(","));
    }
    if (this.wjr == null) {
      this.wjr = new ArrayList();
    }
    getContentView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74468);
        SettingsTrustFriendUI.a(SettingsTrustFriendUI.this);
        AppMethodBeat.o(74468);
      }
    });
    initView();
    AppMethodBeat.o(74484);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74491);
    if (paramInt == 4)
    {
      dop();
      AppMethodBeat.o(74491);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(74491);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74489);
    ad.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.pMe != null) {
      this.pMe.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 869)
      {
        paramString = (bbj)((b)paramn.getReqResp()).gUT.gUX;
        wjt = paramString.DyW;
        paramString = paramString.CxO;
        if (paramString.size() == this.wjr.size()) {
          if (paramString.size() == 0) {
            paramInt1 = 0;
          }
        }
        while (paramInt1 != 0)
        {
          this.wjr.clear();
          paramString = paramString.iterator();
          for (;;)
          {
            if (paramString.hasNext())
            {
              paramn = (dev)paramString.next();
              this.wjr.add(paramn.mAQ);
              continue;
              paramn = paramString.iterator();
              for (;;)
              {
                if (paramn.hasNext())
                {
                  dev localdev = (dev)paramn.next();
                  if (!this.wjr.contains(localdev.mAQ))
                  {
                    paramInt1 = 1;
                    break;
                  }
                }
              }
              paramInt1 = 0;
              break;
            }
          }
          this.wjs.notifyDataSetChanged();
        }
        if ((this.wjr.size() > 0) && (this.wjr.size() < 3)) {
          this.mxV.setVisibility(0);
        }
        com.tencent.mm.kernel.g.afB().afk().set(352277, bt.n(this.wjr, ","));
        AppMethodBeat.o(74489);
        return;
      }
      if (paramn.getType() == 583)
      {
        com.tencent.mm.kernel.g.afB().afk().set(352277, bt.n(this.wjr, ","));
        finish();
        AppMethodBeat.o(74489);
      }
    }
    else if (!bt.isNullOrNil(paramString))
    {
      h.cf(this, paramString);
    }
    AppMethodBeat.o(74489);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(74485);
    super.onStart();
    com.tencent.mm.kernel.g.aeS().a(869, this);
    com.tencent.mm.kernel.g.aeS().a(583, this);
    AppMethodBeat.o(74485);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(74486);
    super.onStop();
    com.tencent.mm.kernel.g.aeS().b(869, this);
    com.tencent.mm.kernel.g.aeS().b(583, this);
    AppMethodBeat.o(74486);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(74480);
      int i = SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).size();
      if (SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) {}
      for (;;)
      {
        AppMethodBeat.o(74480);
        return i;
        if (i == 0) {
          i = 1;
        } else if ((i > 0) && (i < SettingsTrustFriendUI.wjt)) {
          i += 2;
        } else if (i >= SettingsTrustFriendUI.wjt) {
          i += 1;
        } else {
          i = 0;
        }
      }
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(74481);
      if (getItemViewType(paramInt) == 0)
      {
        Object localObject = SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).get(paramInt);
        AppMethodBeat.o(74481);
        return localObject;
      }
      AppMethodBeat.o(74481);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(74482);
      int i = SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).size();
      if ((SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) || (paramInt < i))
      {
        AppMethodBeat.o(74482);
        return 0;
      }
      if (i == 0)
      {
        AppMethodBeat.o(74482);
        return 1;
      }
      if (i >= SettingsTrustFriendUI.wjt)
      {
        AppMethodBeat.o(74482);
        return 2;
      }
      if (paramInt == i)
      {
        AppMethodBeat.o(74482);
        return 1;
      }
      if (paramInt == i + 1)
      {
        AppMethodBeat.o(74482);
        return 2;
      }
      AppMethodBeat.o(74482);
      return -1;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(74483);
      if (paramView == null)
      {
        paramView = SettingsTrustFriendUI.this.getLayoutInflater().inflate(2131495409, null);
        Object localObject1 = (ImageView)paramView.findViewById(2131306081);
        Object localObject2 = (ImageView)paramView.findViewById(2131306082);
        TextView localTextView = (TextView)paramView.findViewById(2131306086);
        paramViewGroup = new a((byte)0);
        paramViewGroup.vWv = ((ImageView)localObject1);
        paramViewGroup.wjx = ((ImageView)localObject2);
        paramViewGroup.mzY = localTextView;
        paramView.setTag(paramViewGroup);
        if (getItemViewType(paramInt) != 0) {
          break label230;
        }
        localObject1 = (String)SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).get(paramInt);
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)localObject1);
        paramViewGroup.vWv.setScaleType(ImageView.ScaleType.FIT_XY);
        a.b.c(paramViewGroup.vWv, (String)localObject1);
        paramViewGroup.mzY.setText(com.tencent.mm.pluginsdk.ui.span.k.b(SettingsTrustFriendUI.this, ((af)localObject2).ZX(), paramViewGroup.mzY.getTextSize()));
        if (!SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) {
          break label218;
        }
        paramViewGroup.wjx.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(74483);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label218:
        paramViewGroup.wjx.setVisibility(8);
        continue;
        label230:
        paramViewGroup.mzY.setVisibility(4);
        paramViewGroup.wjx.setVisibility(8);
        paramViewGroup.vWv.setScaleType(ImageView.ScaleType.FIT_XY);
        if (getItemViewType(paramInt) == 1) {
          paramViewGroup.vWv.setImageResource(2131231164);
        } else if (getItemViewType(paramInt) == 2) {
          paramViewGroup.vWv.setImageResource(2131231165);
        }
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
    
    final class a
    {
      TextView mzY;
      ImageView vWv;
      ImageView wjx;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI
 * JD-Core Version:    0.7.0.1
 */