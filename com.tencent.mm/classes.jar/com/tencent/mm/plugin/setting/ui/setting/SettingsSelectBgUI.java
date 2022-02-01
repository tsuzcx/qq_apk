package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.bb.m;
import com.tencent.mm.bb.n;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsSelectBgUI
  extends MMActivity
  implements i
{
  private boolean Dbz;
  private a Dea;
  private GridView Deb;
  private m Dec;
  private MTimerHandler Ded;
  private List<m> hiK;
  private String username;
  
  public SettingsSelectBgUI()
  {
    AppMethodBeat.i(74416);
    this.hiK = new ArrayList();
    this.Ded = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(74406);
        if (SettingsSelectBgUI.this.findViewById(2131307721).getWidth() <= 0)
        {
          AppMethodBeat.o(74406);
          return true;
        }
        SettingsSelectBgUI.a(SettingsSelectBgUI.this);
        AppMethodBeat.o(74406);
        return false;
      }
    }, true);
    AppMethodBeat.o(74416);
  }
  
  private void gI(List<m> paramList)
  {
    AppMethodBeat.i(74421);
    if (paramList.size() > 0)
    {
      this.Dec = ((m)paramList.remove(0));
      g.azz().a(this.Dec, 0);
      AppMethodBeat.o(74421);
      return;
    }
    this.Dec = null;
    AppMethodBeat.o(74421);
  }
  
  public int getLayoutId()
  {
    return 2131496266;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74419);
    setMMTitle(2131765366);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74407);
        SettingsSelectBgUI.this.finish();
        AppMethodBeat.o(74407);
        return true;
      }
    });
    this.Dbz = getIntent().getBooleanExtra("isApplyToAll", true);
    this.username = getIntent().getStringExtra("username");
    this.Ded.startTimer(20L);
    AppMethodBeat.o(74419);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74417);
    super.onCreate(paramBundle);
    initView();
    g.azz().a(159, this);
    g.azz().a(160, this);
    if (g.aAh().isSDCardAvailable())
    {
      paramBundle = new n(1);
      g.azz().a(paramBundle, 0);
    }
    AppMethodBeat.o(74417);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74418);
    super.onDestroy();
    if (this.Dec != null)
    {
      g.azz().a(this.Dec);
      v.bev().dx(this.Dec.jho, 1);
    }
    List localList = this.hiK;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      v.bev().dx(localm.jho, 1);
    }
    localList.clear();
    g.azz().b(159, this);
    g.azz().b(160, this);
    this.Dea.ebf();
    v.bev().remove(this.Dea);
    AppMethodBeat.o(74418);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(74420);
    if ((!(paramq instanceof com.tencent.mm.ak.s)) || (((com.tencent.mm.ak.s)paramq).aYR() != 1))
    {
      Log.d("MicroMsg.SettingsSelectBgUI", "another scene");
      AppMethodBeat.o(74420);
      return;
    }
    int i = paramq.getType();
    if ((i != 159) && (i != 160))
    {
      AppMethodBeat.o(74420);
      return;
    }
    if (i == 160) {
      gI(this.hiK);
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(74420);
      return;
    }
    AppMethodBeat.o(74420);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends com.tencent.mm.ui.s<com.tencent.mm.bb.q>
  {
    private Context context;
    private int qmd;
    
    public a(Context paramContext, int paramInt)
    {
      super(new com.tencent.mm.bb.q());
      AppMethodBeat.i(74410);
      this.context = paramContext;
      this.qmd = paramInt;
      AppMethodBeat.o(74410);
    }
    
    public final void anp()
    {
      AppMethodBeat.i(74413);
      setCursor(v.bev().ber());
      super.notifyDataSetChanged();
      AppMethodBeat.o(74413);
    }
    
    public final void anq()
    {
      AppMethodBeat.i(74412);
      anp();
      AppMethodBeat.o(74412);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74411);
      int i = getCursor().getCount();
      AppMethodBeat.o(74411);
      return i + 2;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(74414);
      int i;
      com.tencent.mm.bb.a locala;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131496267, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.qmd, this.qmd));
        paramViewGroup = new b();
        paramViewGroup.DfK = ((LinearLayout)paramView.findViewById(2131307501));
        paramViewGroup.DfL = ((LinearLayout)paramView.findViewById(2131307500));
        paramViewGroup.DfM = ((LinearLayout)paramView.findViewById(2131307505));
        paramViewGroup.DfN = ((LinearLayout)paramView.findViewById(2131307506));
        paramViewGroup.DfO = ((LinearLayout)paramView.findViewById(2131307499));
        paramView.setTag(paramViewGroup);
        i = Util.nullAs((Integer)g.aAh().azQ().get(12311, null), -2);
        locala = v.bew().Pp(SettingsSelectBgUI.f(SettingsSelectBgUI.this));
        if (paramInt != 0) {
          break label278;
        }
        if (((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2)) && ((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2) || (locala != null)) && ((locala == null) || (locala.jgE != -2))) {
          break label269;
        }
        paramViewGroup.aNi("using");
      }
      for (;;)
      {
        paramViewGroup = BitmapUtil.getRoundedCornerBitmap(BitmapFactory.decodeResource(this.context.getResources(), 2131231718), true, 10.0F);
        ((ImageView)paramView.findViewById(2131307503)).setImageBitmap(paramViewGroup);
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        label269:
        paramViewGroup.aNi("downloaded");
      }
      label278:
      if (paramInt == 1)
      {
        if (((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0)) || ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0) && (locala == null)) || ((locala != null) && (locala.jgE == 0))) {
          paramViewGroup.aNi("using");
        }
        for (;;)
        {
          paramViewGroup = BitmapUtil.getRoundedCornerBitmap(BitmapFactory.decodeResource(this.context.getResources(), 2131231717), true, 10.0F);
          ((ImageView)paramView.findViewById(2131307503)).setImageBitmap(paramViewGroup);
          AppMethodBeat.o(74414);
          return paramView;
          paramViewGroup.aNi("downloaded");
        }
      }
      com.tencent.mm.bb.q localq = (com.tencent.mm.bb.q)getItem(paramInt - 2);
      r localr = v.bev();
      if (!g.aAh().isSDCardAvailable()) {}
      for (Bitmap localBitmap = BitmapFactory.decodeResource(SettingsSelectBgUI.this.getResources(), 2131234280); localBitmap == null; localBitmap = BitmapUtil.getBitmapNative(r.bes() + r.du(localq.id, localq.dMe)))
      {
        paramInt = localq.id;
        i = localq.dMe;
        if (localr.iFy.delete("packageinfo2", "id= ? and type =?", new String[] { String.valueOf(paramInt), String.valueOf(i) }) > 0) {
          localr.doNotify();
        }
        AppMethodBeat.o(74414);
        return paramView;
      }
      localBitmap = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, 10.0F);
      ((ImageView)paramView.findViewById(2131307503)).setImageBitmap(localBitmap);
      switch (localq.status)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup.aNi("downloading");
        continue;
        if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.jgE == localq.id))
        {
          paramViewGroup.aNi("using");
        }
        else
        {
          paramViewGroup.aNi("downloaded");
          continue;
          paramViewGroup.aNi("undownloaded");
          continue;
          if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.jgE != localq.id))
          {
            paramViewGroup.aNi("downloaded");
          }
          else
          {
            paramViewGroup.aNi("using");
            continue;
            paramViewGroup.aNi("canceling");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI
 * JD-Core Version:    0.7.0.1
 */