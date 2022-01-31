package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.e.i;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsTrustFriendUI
  extends MMActivity
  implements f
{
  private static int qKy = 5;
  private View jGC;
  private com.tencent.mm.ui.base.p mfs;
  private TextView nCQ;
  private GridView nei;
  private boolean qIE;
  private List<String> qKw;
  private a qKx;
  
  private void ckC()
  {
    AppMethodBeat.i(127554);
    String str = (String)g.RL().Ru().get(352277, null);
    ArrayList localArrayList = new ArrayList();
    if (!bo.isNullOrNil(str)) {
      localArrayList = bo.P(str.split(","));
    }
    for (;;)
    {
      if ((this.qKw.size() == localArrayList.size()) && (this.qKw.containsAll(localArrayList)))
      {
        finish();
        AppMethodBeat.o(127554);
        return;
      }
      h.a(this, getString(2131302870), getString(2131297087), getString(2131297063), getString(2131297015), true, new SettingsTrustFriendUI.3(this), new SettingsTrustFriendUI.4(this));
      AppMethodBeat.o(127554);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130970705;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127551);
    setMMTitle(2131303484);
    this.nei = ((GridView)findViewById(2131827671));
    this.qKx = new a((byte)0);
    int i = getResources().getDimensionPixelSize(2131427802);
    this.nei.setColumnWidth(i);
    this.nei.setNumColumns(-1);
    this.nei.setStretchMode(1);
    this.nei.setHorizontalSpacing(getResources().getDimensionPixelSize(2131428449) * 2);
    this.nei.setVerticalSpacing(getResources().getDimensionPixelSize(2131428450));
    this.nei.setAdapter(this.qKx);
    ((ViewGroup)this.nei.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(127537);
        if (SettingsTrustFriendUI.b(SettingsTrustFriendUI.this))
        {
          SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(127537);
      }
    });
    this.nei.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(127538);
        if ((SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) && (paramAnonymousMotionEvent.getAction() == 1) && (SettingsTrustFriendUI.d(SettingsTrustFriendUI.this).pointToPosition((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY()) == -1))
        {
          SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
          AppMethodBeat.o(127538);
          return true;
        }
        AppMethodBeat.o(127538);
        return false;
      }
    });
    this.nei.setHorizontalScrollBarEnabled(false);
    this.nei.setVerticalScrollBarEnabled(false);
    this.nei.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(127539);
        if (SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) == 1)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("list_type", 12);
          paramAnonymousAdapterView.putExtra("titile", SettingsTrustFriendUI.this.getString(2131296502));
          paramAnonymousAdapterView.putExtra("scene", 2);
          paramAnonymousAdapterView.putExtra("max_limit_num", SettingsTrustFriendUI.AL());
          paramAnonymousAdapterView.putExtra("stay_in_wechat", true);
          paramAnonymousAdapterView.putExtra("already_select_contact", bo.d(SettingsTrustFriendUI.e(SettingsTrustFriendUI.this), ","));
          paramAnonymousAdapterView.putExtra("block_contact", r.Zn());
          paramAnonymousAdapterView.putExtra("list_attr", t.hJ(t.hJ(t.AdZ, 256), 16777216));
          paramAnonymousAdapterView.putExtra("without_openim", true);
          paramAnonymousAdapterView.putExtra("too_many_member_tip_string", SettingsTrustFriendUI.this.getString(2131303486, new Object[] { Integer.valueOf(SettingsTrustFriendUI.AL()) }));
          d.b(SettingsTrustFriendUI.this, ".ui.contact.SelectContactUI", paramAnonymousAdapterView, 1);
          AppMethodBeat.o(127539);
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
            AppMethodBeat.o(127539);
            return;
          } while ((SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) != 0) || (!SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)));
          SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).remove(SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItem(paramAnonymousInt));
          if (SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).size() == 0) {
            SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          }
        }
      }
    });
    this.nCQ = ((TextView)findViewById(2131827669));
    String str = getIntent().getStringExtra(e.i.yVh);
    if (!bo.isNullOrNil(str)) {
      this.nCQ.setText(str);
    }
    for (;;)
    {
      this.jGC = findViewById(2131827667);
      this.jGC.setVisibility(8);
      ((TextView)this.jGC.findViewById(2131827668)).setText(getString(2131303487, new Object[] { Integer.valueOf(3) }));
      this.jGC.findViewById(2131822762).setOnClickListener(new SettingsTrustFriendUI.9(this));
      findViewById(2131827670).setOnClickListener(new SettingsTrustFriendUI.10(this));
      setBackBtn(new SettingsTrustFriendUI.11(this));
      addTextOptionMenu(1, getString(2131296964), new SettingsTrustFriendUI.12(this), null, q.b.zby);
      showOptionMenu(true);
      AppMethodBeat.o(127551);
      return;
      this.nCQ.setText(getResources().getString(2131303488, new Object[] { Integer.valueOf(3) }));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(127552);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!bo.isNullOrNil(paramIntent))
      {
        this.qKw.clear();
        this.qKw.addAll(bo.P(paramIntent.split(",")));
        this.qKx.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(127552);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127548);
    super.onCreate(paramBundle);
    paramBundle = (String)g.RL().Ru().get(352277, null);
    if (!bo.isNullOrNil(paramBundle)) {
      this.qKw = bo.P(paramBundle.split(","));
    }
    if (this.qKw == null) {
      this.qKw = new ArrayList();
    }
    getContentView().post(new SettingsTrustFriendUI.1(this));
    initView();
    AppMethodBeat.o(127548);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(127555);
    if (paramInt == 4)
    {
      ckC();
      AppMethodBeat.o(127555);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(127555);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127553);
    ab.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.mfs != null) {
      this.mfs.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 869)
      {
        paramString = (aqu)((b)paramm.getReqResp()).fsW.fta;
        qKy = paramString.xga;
        paramString = paramString.wph;
        if (paramString.size() == this.qKw.size()) {
          if (paramString.size() == 0) {
            paramInt1 = 0;
          }
        }
        while (paramInt1 != 0)
        {
          this.qKw.clear();
          paramString = paramString.iterator();
          for (;;)
          {
            if (paramString.hasNext())
            {
              paramm = (clv)paramString.next();
              this.qKw.add(paramm.jJA);
              continue;
              paramm = paramString.iterator();
              for (;;)
              {
                if (paramm.hasNext())
                {
                  clv localclv = (clv)paramm.next();
                  if (!this.qKw.contains(localclv.jJA))
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
          this.qKx.notifyDataSetChanged();
        }
        if ((this.qKw.size() > 0) && (this.qKw.size() < 3)) {
          this.jGC.setVisibility(0);
        }
        g.RL().Ru().set(352277, bo.d(this.qKw, ","));
        AppMethodBeat.o(127553);
        return;
      }
      if (paramm.getType() == 583)
      {
        g.RL().Ru().set(352277, bo.d(this.qKw, ","));
        finish();
        AppMethodBeat.o(127553);
      }
    }
    else if (!bo.isNullOrNil(paramString))
    {
      h.bO(this, paramString);
    }
    AppMethodBeat.o(127553);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(127549);
    super.onStart();
    g.Rc().a(869, this);
    g.Rc().a(583, this);
    AppMethodBeat.o(127549);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(127550);
    super.onStop();
    g.Rc().b(869, this);
    g.Rc().b(583, this);
    AppMethodBeat.o(127550);
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
      AppMethodBeat.i(127544);
      int i = SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).size();
      if (SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) {}
      for (;;)
      {
        AppMethodBeat.o(127544);
        return i;
        if (i == 0) {
          i = 1;
        } else if ((i > 0) && (i < SettingsTrustFriendUI.AL())) {
          i += 2;
        } else if (i >= SettingsTrustFriendUI.AL()) {
          i += 1;
        } else {
          i = 0;
        }
      }
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(127545);
      if (getItemViewType(paramInt) == 0)
      {
        Object localObject = SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).get(paramInt);
        AppMethodBeat.o(127545);
        return localObject;
      }
      AppMethodBeat.o(127545);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(127546);
      int i = SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).size();
      if ((SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) || (paramInt < i))
      {
        AppMethodBeat.o(127546);
        return 0;
      }
      if (i == 0)
      {
        AppMethodBeat.o(127546);
        return 1;
      }
      if (i >= SettingsTrustFriendUI.AL())
      {
        AppMethodBeat.o(127546);
        return 2;
      }
      if (paramInt == i)
      {
        AppMethodBeat.o(127546);
        return 1;
      }
      if (paramInt == i + 1)
      {
        AppMethodBeat.o(127546);
        return 2;
      }
      AppMethodBeat.o(127546);
      return -1;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(127547);
      if (paramView == null)
      {
        paramView = SettingsTrustFriendUI.this.getLayoutInflater().inflate(2130970706, null);
        Object localObject1 = (ImageView)paramView.findViewById(2131827672);
        Object localObject2 = (ImageView)paramView.findViewById(2131827673);
        TextView localTextView = (TextView)paramView.findViewById(2131827674);
        paramViewGroup = new SettingsTrustFriendUI.a.a(this, (byte)0);
        paramViewGroup.qBN = ((ImageView)localObject1);
        paramViewGroup.qKC = ((ImageView)localObject2);
        paramViewGroup.jII = localTextView;
        paramView.setTag(paramViewGroup);
        if (getItemViewType(paramInt) != 0) {
          break label230;
        }
        localObject1 = (String)SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).get(paramInt);
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw((String)localObject1);
        paramViewGroup.qBN.setScaleType(ImageView.ScaleType.FIT_XY);
        a.b.c(paramViewGroup.qBN, (String)localObject1);
        paramViewGroup.jII.setText(com.tencent.mm.pluginsdk.ui.d.j.b(SettingsTrustFriendUI.this, ((ad)localObject2).Of(), paramViewGroup.jII.getTextSize()));
        if (!SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) {
          break label218;
        }
        paramViewGroup.qKC.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(127547);
        return paramView;
        paramViewGroup = (SettingsTrustFriendUI.a.a)paramView.getTag();
        break;
        label218:
        paramViewGroup.qKC.setVisibility(8);
        continue;
        label230:
        paramViewGroup.jII.setVisibility(4);
        paramViewGroup.qKC.setVisibility(8);
        paramViewGroup.qBN.setScaleType(ImageView.ScaleType.FIT_XY);
        if (getItemViewType(paramInt) == 1) {
          paramViewGroup.qBN.setImageResource(2130837890);
        } else if (getItemViewType(paramInt) == 2) {
          paramViewGroup.qBN.setImageResource(2130837891);
        }
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI
 * JD-Core Version:    0.7.0.1
 */