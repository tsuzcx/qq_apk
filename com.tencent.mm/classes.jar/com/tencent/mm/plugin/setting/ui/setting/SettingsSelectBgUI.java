package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.am.r;
import com.tencent.mm.modelpackage.o;
import com.tencent.mm.modelpackage.t;
import com.tencent.mm.modelpackage.u;
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
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsSelectBgUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private boolean PsF;
  private a Pwb;
  private GridView Pwc;
  private o Pwd;
  private MTimerHandler Pwe;
  private List<o> muZ;
  private String username;
  
  public SettingsSelectBgUI()
  {
    AppMethodBeat.i(74416);
    this.muZ = new ArrayList();
    this.Pwe = new MTimerHandler(new MTimerHandler.CallBack()
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
  
  private void kq(List<o> paramList)
  {
    AppMethodBeat.i(74421);
    if (paramList.size() > 0)
    {
      this.Pwd = ((o)paramList.remove(0));
      com.tencent.mm.kernel.h.aZW().a(this.Pwd, 0);
      AppMethodBeat.o(74421);
      return;
    }
    this.Pwd = null;
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
    this.PsF = getIntent().getBooleanExtra("isApplyToAll", true);
    this.username = getIntent().getStringExtra("username");
    this.Pwe.startTimer(20L);
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
    com.tencent.mm.kernel.h.aZW().a(159, this);
    com.tencent.mm.kernel.h.aZW().a(160, this);
    if (com.tencent.mm.kernel.h.baE().isSDCardAvailable())
    {
      paramBundle = new com.tencent.mm.modelpackage.p(1);
      com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
    }
    AppMethodBeat.o(74417);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74418);
    super.onDestroy();
    if (this.Pwd != null)
    {
      com.tencent.mm.kernel.h.aZW().a(this.Pwd);
      u.bLH().eM(this.Pwd.oQV, 1);
    }
    List localList = this.muZ;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      u.bLH().eM(localo.oQV, 1);
    }
    localList.clear();
    com.tencent.mm.kernel.h.aZW().b(159, this);
    com.tencent.mm.kernel.h.aZW().b(160, this);
    this.Pwb.fSd();
    u.bLH().remove(this.Pwb);
    AppMethodBeat.o(74418);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(74420);
    if ((!(paramp instanceof r)) || (((r)paramp).bFO() != 1))
    {
      Log.d("MicroMsg.SettingsSelectBgUI", "another scene");
      AppMethodBeat.o(74420);
      return;
    }
    int i = paramp.getType();
    if ((i != 159) && (i != 160))
    {
      AppMethodBeat.o(74420);
      return;
    }
    if (i == 160) {
      kq(this.muZ);
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
    extends x<com.tencent.mm.modelpackage.s>
  {
    private Context context;
    private int wLI;
    
    public a(Context paramContext, int paramInt)
    {
      super(new com.tencent.mm.modelpackage.s());
      AppMethodBeat.i(74410);
      this.context = paramContext;
      this.wLI = paramInt;
      AppMethodBeat.o(74410);
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(74413);
      w(u.bLH().bLD());
      super.notifyDataSetChanged();
      AppMethodBeat.o(74413);
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(74412);
      aNy();
      AppMethodBeat.o(74412);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74411);
      int i = Fv().getCount();
      AppMethodBeat.o(74411);
      return i + 2;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(74414);
      int i;
      com.tencent.mm.modelpackage.a locala;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, b.g.settings_select_bg_view, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.wLI, this.wLI));
        paramViewGroup = new f();
        paramViewGroup.PxP = ((LinearLayout)paramView.findViewById(b.f.select_bg_downloading_ll));
        paramViewGroup.PxQ = ((LinearLayout)paramView.findViewById(b.f.select_bg_downloaded_ll));
        paramViewGroup.PxR = ((LinearLayout)paramView.findViewById(b.f.select_bg_undownloaded_ll));
        paramViewGroup.PxS = ((LinearLayout)paramView.findViewById(b.f.select_bg_using_ll));
        paramViewGroup.PxT = ((LinearLayout)paramView.findViewById(b.f.select_bg_canceling_ll));
        paramView.setTag(paramViewGroup);
        i = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(12311, null), -2);
        locala = u.bLI().OM(SettingsSelectBgUI.f(SettingsSelectBgUI.this));
        if (paramInt != 0) {
          break label286;
        }
        if (((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2)) && ((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2) || (locala != null)) && ((locala == null) || (locala.oQj != -2))) {
          break label277;
        }
        paramViewGroup.aVJ("using");
      }
      for (;;)
      {
        paramViewGroup = BitmapUtil.getRoundedCornerBitmap(BitmapFactory.decodeResource(this.context.getResources(), b.e.chatting_bg_purecolor_thumb), true, 10.0F);
        ((ImageView)paramView.findViewById(b.f.select_bg_pkg_iv)).setImageBitmap(paramViewGroup);
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup = (f)paramView.getTag();
        break;
        label277:
        paramViewGroup.aVJ("downloaded");
      }
      label286:
      if (paramInt == 1)
      {
        if (((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0)) || ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0) && (locala == null)) || ((locala != null) && (locala.oQj == 0))) {
          paramViewGroup.aVJ("using");
        }
        for (;;)
        {
          paramViewGroup = BitmapUtil.getRoundedCornerBitmap(BitmapFactory.decodeResource(this.context.getResources(), b.e.chatting_bg_default_thumb), true, 10.0F);
          ((ImageView)paramView.findViewById(b.f.select_bg_pkg_iv)).setImageBitmap(paramViewGroup);
          AppMethodBeat.o(74414);
          return paramView;
          paramViewGroup.aVJ("downloaded");
        }
      }
      com.tencent.mm.modelpackage.s locals = (com.tencent.mm.modelpackage.s)getItem(paramInt - 2);
      t localt = u.bLH();
      if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable()) {}
      for (Bitmap localBitmap = BitmapFactory.decodeResource(SettingsSelectBgUI.this.getResources(), b.e.nosdcard_chatting_bg_thumb); localBitmap == null; localBitmap = BitmapUtil.getBitmapNative(t.bLE() + t.eJ(locals.id, locals.hJK)))
      {
        paramInt = locals.id;
        i = locals.hJK;
        if (localt.omV.delete("packageinfo2", "id= ? and type =?", new String[] { String.valueOf(paramInt), String.valueOf(i) }) > 0) {
          localt.doNotify();
        }
        AppMethodBeat.o(74414);
        return paramView;
      }
      localBitmap = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, 10.0F);
      ((ImageView)paramView.findViewById(b.f.select_bg_pkg_iv)).setImageBitmap(localBitmap);
      switch (locals.status)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup.aVJ("downloading");
        continue;
        if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.oQj == locals.id))
        {
          paramViewGroup.aVJ("using");
        }
        else
        {
          paramViewGroup.aVJ("downloaded");
          continue;
          paramViewGroup.aVJ("undownloaded");
          continue;
          if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.oQj != locals.id))
          {
            paramViewGroup.aVJ("downloaded");
          }
          else
          {
            paramViewGroup.aVJ("using");
            continue;
            paramViewGroup.aVJ("canceling");
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