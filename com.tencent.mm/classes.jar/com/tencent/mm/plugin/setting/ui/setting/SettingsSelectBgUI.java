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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.a;
import com.tencent.mm.bb.k;
import com.tencent.mm.bb.l;
import com.tencent.mm.bb.o;
import com.tencent.mm.bb.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsSelectBgUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private List<k> fZS;
  private String username;
  private boolean xrR;
  private a xum;
  private GridView xun;
  private k xuo;
  private au xup;
  
  public SettingsSelectBgUI()
  {
    AppMethodBeat.i(74416);
    this.fZS = new ArrayList();
    this.xup = new au(new au.a()
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
  
  private void fp(List<k> paramList)
  {
    AppMethodBeat.i(74421);
    if (paramList.size() > 0)
    {
      this.xuo = ((k)paramList.remove(0));
      com.tencent.mm.kernel.g.agi().a(this.xuo, 0);
      AppMethodBeat.o(74421);
      return;
    }
    this.xuo = null;
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
    this.xrR = getIntent().getBooleanExtra("isApplyToAll", true);
    this.username = getIntent().getStringExtra("username");
    this.xup.au(20L, 20L);
    AppMethodBeat.o(74419);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74417);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.agi().a(159, this);
    com.tencent.mm.kernel.g.agi().a(160, this);
    if (com.tencent.mm.kernel.g.agR().isSDCardAvailable())
    {
      paramBundle = new l(1);
      com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
    }
    AppMethodBeat.o(74417);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74418);
    super.onDestroy();
    if (this.xuo != null)
    {
      com.tencent.mm.kernel.g.agi().a(this.xuo);
      t.aGO().dk(this.xuo.hPY, 1);
    }
    List localList = this.fZS;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      t.aGO().dk(localk.hPY, 1);
    }
    localList.clear();
    com.tencent.mm.kernel.g.agi().b(159, this);
    com.tencent.mm.kernel.g.agi().b(160, this);
    this.xum.cVi();
    t.aGO().remove(this.xum);
    AppMethodBeat.o(74418);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74420);
    if ((!(paramn instanceof com.tencent.mm.ak.p)) || (((com.tencent.mm.ak.p)paramn).aBJ() != 1))
    {
      ac.d("MicroMsg.SettingsSelectBgUI", "another scene");
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
      fp(this.fZS);
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
    private int onm;
    
    public a(Context paramContext, int paramInt)
    {
      super(new o());
      AppMethodBeat.i(74410);
      this.context = paramContext;
      this.onm = paramInt;
      AppMethodBeat.o(74410);
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(74413);
      setCursor(t.aGO().aGK());
      super.notifyDataSetChanged();
      AppMethodBeat.o(74413);
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(74412);
      Xb();
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
      a locala;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131495405, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.onm, this.onm));
        paramViewGroup = new b();
        paramViewGroup.xvX = ((LinearLayout)paramView.findViewById(2131304495));
        paramViewGroup.xvY = ((LinearLayout)paramView.findViewById(2131304494));
        paramViewGroup.xvZ = ((LinearLayout)paramView.findViewById(2131304499));
        paramViewGroup.xwa = ((LinearLayout)paramView.findViewById(2131304500));
        paramViewGroup.xwb = ((LinearLayout)paramView.findViewById(2131304493));
        paramView.setTag(paramViewGroup);
        i = bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(12311, null), -2);
        locala = t.aGP().CW(SettingsSelectBgUI.f(SettingsSelectBgUI.this));
        if (paramInt != 0) {
          break label278;
        }
        if (((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2)) && ((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2) || (locala != null)) && ((locala == null) || (locala.hPy != -2))) {
          break label269;
        }
        paramViewGroup.asi("using");
      }
      for (;;)
      {
        paramViewGroup = f.a(BitmapFactory.decodeResource(this.context.getResources(), 2131231652), true, 10.0F);
        ((ImageView)paramView.findViewById(2131304497)).setImageBitmap(paramViewGroup);
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        label269:
        paramViewGroup.asi("downloaded");
      }
      label278:
      if (paramInt == 1)
      {
        if (((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0)) || ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0) && (locala == null)) || ((locala != null) && (locala.hPy == 0))) {
          paramViewGroup.asi("using");
        }
        for (;;)
        {
          paramViewGroup = f.a(BitmapFactory.decodeResource(this.context.getResources(), 2131231651), true, 10.0F);
          ((ImageView)paramView.findViewById(2131304497)).setImageBitmap(paramViewGroup);
          AppMethodBeat.o(74414);
          return paramView;
          paramViewGroup.asi("downloaded");
        }
      }
      o localo = (o)getItem(paramInt - 2);
      com.tencent.mm.bb.p localp = t.aGO();
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable()) {}
      for (Bitmap localBitmap = BitmapFactory.decodeResource(SettingsSelectBgUI.this.getResources(), 2131233477); localBitmap == null; localBitmap = f.aKz(com.tencent.mm.bb.p.aGL() + com.tencent.mm.bb.p.dh(localo.id, localo.dib)))
      {
        paramInt = localo.id;
        i = localo.dib;
        if (localp.hpA.delete("packageinfo2", "id= ? and type =?", new String[] { String.valueOf(paramInt), String.valueOf(i) }) > 0) {
          localp.doNotify();
        }
        AppMethodBeat.o(74414);
        return paramView;
      }
      localBitmap = f.a(localBitmap, true, 10.0F);
      ((ImageView)paramView.findViewById(2131304497)).setImageBitmap(localBitmap);
      switch (localo.status)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup.asi("downloading");
        continue;
        if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.hPy == localo.id))
        {
          paramViewGroup.asi("using");
        }
        else
        {
          paramViewGroup.asi("downloaded");
          continue;
          paramViewGroup.asi("undownloaded");
          continue;
          if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.hPy != localo.id))
          {
            paramViewGroup.asi("downloaded");
          }
          else
          {
            paramViewGroup.asi("using");
            continue;
            paramViewGroup.asi("canceling");
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