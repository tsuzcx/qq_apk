package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.be.n;
import com.tencent.mm.be.o;
import com.tencent.mm.be.r;
import com.tencent.mm.be.w;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.pulldown.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsSelectBgUI
  extends MMActivity
  implements i
{
  private boolean Jha;
  private a JjE;
  private GridView JjF;
  private n JjG;
  private MTimerHandler JjH;
  private List<n> jUI;
  private String username;
  
  public SettingsSelectBgUI()
  {
    AppMethodBeat.i(74416);
    this.jUI = new ArrayList();
    this.JjH = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(74406);
        if (SettingsSelectBgUI.this.findViewById(b.f.settings_select_bg_gv).getWidth() <= 0)
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
  
  private void ho(List<n> paramList)
  {
    AppMethodBeat.i(74421);
    if (paramList.size() > 0)
    {
      this.JjG = ((n)paramList.remove(0));
      com.tencent.mm.kernel.h.aGY().a(this.JjG, 0);
      AppMethodBeat.o(74421);
      return;
    }
    this.JjG = null;
    AppMethodBeat.o(74421);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_select_bg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74419);
    setMMTitle(b.i.settings_chatting_bg_select_bg);
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
    this.Jha = getIntent().getBooleanExtra("isApplyToAll", true);
    this.username = getIntent().getStringExtra("username");
    this.JjH.startTimer(20L);
    AppMethodBeat.o(74419);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74417);
    super.onCreate(paramBundle);
    initView();
    if (getBounceView() != null) {
      getBounceView().setBg(getResources().getDrawable(b.e.settings_select_bg_bg));
    }
    com.tencent.mm.kernel.h.aGY().a(159, this);
    com.tencent.mm.kernel.h.aGY().a(160, this);
    if (com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
    {
      paramBundle = new o(1);
      com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
    }
    AppMethodBeat.o(74417);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74418);
    super.onDestroy();
    if (this.JjG != null)
    {
      com.tencent.mm.kernel.h.aGY().a(this.JjG);
      w.bnU().dU(this.JjG.lXR, 1);
    }
    List localList = this.jUI;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      w.bnU().dU(localn.lXR, 1);
    }
    localList.clear();
    com.tencent.mm.kernel.h.aGY().b(159, this);
    com.tencent.mm.kernel.h.aGY().b(160, this);
    this.JjE.eKd();
    w.bnU().remove(this.JjE);
    AppMethodBeat.o(74418);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74420);
    if ((!(paramq instanceof com.tencent.mm.an.s)) || (((com.tencent.mm.an.s)paramq).big() != 1))
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
      ho(this.jUI);
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
    extends v<r>
  {
    private Context context;
    private int tHY;
    
    public a(Context paramContext, int paramInt)
    {
      super(new r());
      AppMethodBeat.i(74410);
      this.context = paramContext;
      this.tHY = paramInt;
      AppMethodBeat.o(74410);
    }
    
    public final void atr()
    {
      AppMethodBeat.i(74413);
      v(w.bnU().bnQ());
      super.notifyDataSetChanged();
      AppMethodBeat.o(74413);
    }
    
    public final void ats()
    {
      AppMethodBeat.i(74412);
      atr();
      AppMethodBeat.o(74412);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74411);
      int i = hK().getCount();
      AppMethodBeat.o(74411);
      return i + 2;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(74414);
      int i;
      com.tencent.mm.be.a locala;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, b.g.settings_select_bg_view, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.tHY, this.tHY));
        paramViewGroup = new b();
        paramViewGroup.Jlq = ((LinearLayout)paramView.findViewById(b.f.select_bg_downloading_ll));
        paramViewGroup.Jlr = ((LinearLayout)paramView.findViewById(b.f.select_bg_downloaded_ll));
        paramViewGroup.Jls = ((LinearLayout)paramView.findViewById(b.f.select_bg_undownloaded_ll));
        paramViewGroup.Jlt = ((LinearLayout)paramView.findViewById(b.f.select_bg_using_ll));
        paramViewGroup.Jlu = ((LinearLayout)paramView.findViewById(b.f.select_bg_canceling_ll));
        paramView.setTag(paramViewGroup);
        i = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(12311, null), -2);
        locala = w.bnV().WM(SettingsSelectBgUI.f(SettingsSelectBgUI.this));
        if (paramInt != 0) {
          break label286;
        }
        if (((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2)) && ((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2) || (locala != null)) && ((locala == null) || (locala.lXh != -2))) {
          break label277;
        }
        paramViewGroup.aXR("using");
      }
      for (;;)
      {
        paramViewGroup = BitmapUtil.getRoundedCornerBitmap(BitmapFactory.decodeResource(this.context.getResources(), b.e.chatting_bg_purecolor_thumb), true, 10.0F);
        ((ImageView)paramView.findViewById(b.f.select_bg_pkg_iv)).setImageBitmap(paramViewGroup);
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        label277:
        paramViewGroup.aXR("downloaded");
      }
      label286:
      if (paramInt == 1)
      {
        if (((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0)) || ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0) && (locala == null)) || ((locala != null) && (locala.lXh == 0))) {
          paramViewGroup.aXR("using");
        }
        for (;;)
        {
          paramViewGroup = BitmapUtil.getRoundedCornerBitmap(BitmapFactory.decodeResource(this.context.getResources(), b.e.chatting_bg_default_thumb), true, 10.0F);
          ((ImageView)paramView.findViewById(b.f.select_bg_pkg_iv)).setImageBitmap(paramViewGroup);
          AppMethodBeat.o(74414);
          return paramView;
          paramViewGroup.aXR("downloaded");
        }
      }
      r localr = (r)getItem(paramInt - 2);
      com.tencent.mm.be.s locals = w.bnU();
      if (!com.tencent.mm.kernel.h.aHG().isSDCardAvailable()) {}
      for (Bitmap localBitmap = BitmapFactory.decodeResource(SettingsSelectBgUI.this.getResources(), b.e.nosdcard_chatting_bg_thumb); localBitmap == null; localBitmap = BitmapUtil.getBitmapNative(com.tencent.mm.be.s.bnR() + com.tencent.mm.be.s.dR(localr.id, localr.fES)))
      {
        paramInt = localr.id;
        i = localr.fES;
        if (locals.lvy.delete("packageinfo2", "id= ? and type =?", new String[] { String.valueOf(paramInt), String.valueOf(i) }) > 0) {
          locals.doNotify();
        }
        AppMethodBeat.o(74414);
        return paramView;
      }
      localBitmap = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, 10.0F);
      ((ImageView)paramView.findViewById(b.f.select_bg_pkg_iv)).setImageBitmap(localBitmap);
      switch (localr.status)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup.aXR("downloading");
        continue;
        if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.lXh == localr.id))
        {
          paramViewGroup.aXR("using");
        }
        else
        {
          paramViewGroup.aXR("downloaded");
          continue;
          paramViewGroup.aXR("undownloaded");
          continue;
          if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.lXh != localr.id))
          {
            paramViewGroup.aXR("downloaded");
          }
          else
          {
            paramViewGroup.aXR("using");
            continue;
            paramViewGroup.aXR("canceling");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI
 * JD-Core Version:    0.7.0.1
 */