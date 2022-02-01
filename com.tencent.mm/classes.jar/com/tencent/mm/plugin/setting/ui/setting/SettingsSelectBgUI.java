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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.k;
import com.tencent.mm.bb.l;
import com.tencent.mm.bb.o;
import com.tencent.mm.bb.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsSelectBgUI
  extends MMActivity
  implements f
{
  private List<k> gvV;
  private String username;
  private boolean yWJ;
  private a yZh;
  private GridView yZi;
  private k yZj;
  private aw yZk;
  
  public SettingsSelectBgUI()
  {
    AppMethodBeat.i(74416);
    this.gvV = new ArrayList();
    this.yZk = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(74406);
        if (SettingsSelectBgUI.this.findViewById(2131304669).getWidth() <= 0)
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
  
  private void fK(List<k> paramList)
  {
    AppMethodBeat.i(74421);
    if (paramList.size() > 0)
    {
      this.yZj = ((k)paramList.remove(0));
      g.ajj().a(this.yZj, 0);
      AppMethodBeat.o(74421);
      return;
    }
    this.yZj = null;
    AppMethodBeat.o(74421);
  }
  
  public int getLayoutId()
  {
    return 2131495404;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74419);
    setMMTitle(2131763198);
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
    this.yWJ = getIntent().getBooleanExtra("isApplyToAll", true);
    this.username = getIntent().getStringExtra("username");
    this.yZk.ay(20L, 20L);
    AppMethodBeat.o(74419);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74417);
    super.onCreate(paramBundle);
    initView();
    g.ajj().a(159, this);
    g.ajj().a(160, this);
    if (g.ajR().isSDCardAvailable())
    {
      paramBundle = new l(1);
      g.ajj().a(paramBundle, 0);
    }
    AppMethodBeat.o(74417);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74418);
    super.onDestroy();
    if (this.yZj != null)
    {
      g.ajj().a(this.yZj);
      t.aKs().dn(this.yZj.imf, 1);
    }
    List localList = this.gvV;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      t.aKs().dn(localk.imf, 1);
    }
    localList.clear();
    g.ajj().b(159, this);
    g.ajj().b(160, this);
    this.yZh.dhl();
    t.aKs().remove(this.yZh);
    AppMethodBeat.o(74418);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74420);
    if ((!(paramn instanceof com.tencent.mm.ak.p)) || (((com.tencent.mm.ak.p)paramn).aFc() != 1))
    {
      ae.d("MicroMsg.SettingsSelectBgUI", "another scene");
      AppMethodBeat.o(74420);
      return;
    }
    int i = paramn.getType();
    if ((i != 159) && (i != 160))
    {
      AppMethodBeat.o(74420);
      return;
    }
    if (i == 160) {
      fK(this.gvV);
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
    extends r<o>
  {
    private Context context;
    private int oXj;
    
    public a(Context paramContext, int paramInt)
    {
      super(new o());
      AppMethodBeat.i(74410);
      this.context = paramContext;
      this.oXj = paramInt;
      AppMethodBeat.o(74410);
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(74413);
      setCursor(t.aKs().aKo());
      super.notifyDataSetChanged();
      AppMethodBeat.o(74413);
    }
    
    public final void ZE()
    {
      AppMethodBeat.i(74412);
      ZD();
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
        paramView = View.inflate(this.context, 2131495405, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.oXj, this.oXj));
        paramViewGroup = new b();
        paramViewGroup.zaS = ((LinearLayout)paramView.findViewById(2131304495));
        paramViewGroup.zaT = ((LinearLayout)paramView.findViewById(2131304494));
        paramViewGroup.zaU = ((LinearLayout)paramView.findViewById(2131304499));
        paramViewGroup.zaV = ((LinearLayout)paramView.findViewById(2131304500));
        paramViewGroup.zaW = ((LinearLayout)paramView.findViewById(2131304493));
        paramView.setTag(paramViewGroup);
        i = bu.a((Integer)g.ajR().ajA().get(12311, null), -2);
        locala = t.aKt().GD(SettingsSelectBgUI.f(SettingsSelectBgUI.this));
        if (paramInt != 0) {
          break label278;
        }
        if (((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2)) && ((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2) || (locala != null)) && ((locala == null) || (locala.ilF != -2))) {
          break label269;
        }
        paramViewGroup.ayy("using");
      }
      for (;;)
      {
        paramViewGroup = com.tencent.mm.sdk.platformtools.h.a(BitmapFactory.decodeResource(this.context.getResources(), 2131231652), true, 10.0F);
        ((ImageView)paramView.findViewById(2131304497)).setImageBitmap(paramViewGroup);
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        label269:
        paramViewGroup.ayy("downloaded");
      }
      label278:
      if (paramInt == 1)
      {
        if (((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0)) || ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0) && (locala == null)) || ((locala != null) && (locala.ilF == 0))) {
          paramViewGroup.ayy("using");
        }
        for (;;)
        {
          paramViewGroup = com.tencent.mm.sdk.platformtools.h.a(BitmapFactory.decodeResource(this.context.getResources(), 2131231651), true, 10.0F);
          ((ImageView)paramView.findViewById(2131304497)).setImageBitmap(paramViewGroup);
          AppMethodBeat.o(74414);
          return paramView;
          paramViewGroup.ayy("downloaded");
        }
      }
      o localo = (o)getItem(paramInt - 2);
      com.tencent.mm.bb.p localp = t.aKs();
      if (!g.ajR().isSDCardAvailable()) {}
      for (Bitmap localBitmap = BitmapFactory.decodeResource(SettingsSelectBgUI.this.getResources(), 2131233477); localBitmap == null; localBitmap = com.tencent.mm.sdk.platformtools.h.aRC(com.tencent.mm.bb.p.aKp() + com.tencent.mm.bb.p.dk(localo.id, localo.duK)))
      {
        paramInt = localo.id;
        i = localo.duK;
        if (localp.hKK.delete("packageinfo2", "id= ? and type =?", new String[] { String.valueOf(paramInt), String.valueOf(i) }) > 0) {
          localp.doNotify();
        }
        AppMethodBeat.o(74414);
        return paramView;
      }
      localBitmap = com.tencent.mm.sdk.platformtools.h.a(localBitmap, true, 10.0F);
      ((ImageView)paramView.findViewById(2131304497)).setImageBitmap(localBitmap);
      switch (localo.status)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup.ayy("downloading");
        continue;
        if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.ilF == localo.id))
        {
          paramViewGroup.ayy("using");
        }
        else
        {
          paramViewGroup.ayy("downloaded");
          continue;
          paramViewGroup.ayy("undownloaded");
          continue;
          if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.ilF != localo.id))
          {
            paramViewGroup.ayy("downloaded");
          }
          else
          {
            paramViewGroup.ayy("using");
            continue;
            paramViewGroup.ayy("canceling");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI
 * JD-Core Version:    0.7.0.1
 */