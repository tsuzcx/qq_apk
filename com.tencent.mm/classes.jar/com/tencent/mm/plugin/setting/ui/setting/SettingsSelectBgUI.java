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
import com.tencent.mm.al.n;
import com.tencent.mm.bc.a;
import com.tencent.mm.bc.k;
import com.tencent.mm.bc.l;
import com.tencent.mm.bc.o;
import com.tencent.mm.bc.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsSelectBgUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private List<k> fVX;
  private String username;
  private boolean wgB;
  private a wiW;
  private GridView wiX;
  private k wiY;
  private av wiZ;
  
  public SettingsSelectBgUI()
  {
    AppMethodBeat.i(74416);
    this.fVX = new ArrayList();
    this.wiZ = new av(new av.a()
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
  
  private void fh(List<k> paramList)
  {
    AppMethodBeat.i(74421);
    if (paramList.size() > 0)
    {
      this.wiY = ((k)paramList.remove(0));
      com.tencent.mm.kernel.g.aeS().a(this.wiY, 0);
      AppMethodBeat.o(74421);
      return;
    }
    this.wiY = null;
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
    this.wgB = getIntent().getBooleanExtra("isApplyToAll", true);
    this.username = getIntent().getStringExtra("username");
    this.wiZ.av(20L, 20L);
    AppMethodBeat.o(74419);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74417);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.aeS().a(159, this);
    com.tencent.mm.kernel.g.aeS().a(160, this);
    if (com.tencent.mm.kernel.g.afB().isSDCardAvailable())
    {
      paramBundle = new l(1);
      com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
    }
    AppMethodBeat.o(74417);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74418);
    super.onDestroy();
    if (this.wiY != null)
    {
      com.tencent.mm.kernel.g.aeS().a(this.wiY);
      t.azY().dk(this.wiY.hpw, 1);
    }
    List localList = this.fVX;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      t.azY().dk(localk.hpw, 1);
    }
    localList.clear();
    com.tencent.mm.kernel.g.aeS().b(159, this);
    com.tencent.mm.kernel.g.aeS().b(160, this);
    this.wiW.cHX();
    t.azY().remove(this.wiW);
    AppMethodBeat.o(74418);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74420);
    if ((!(paramn instanceof com.tencent.mm.al.p)) || (((com.tencent.mm.al.p)paramn).auQ() != 1))
    {
      ad.d("MicroMsg.SettingsSelectBgUI", "another scene");
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
      fh(this.fVX);
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
    extends com.tencent.mm.ui.q<o>
  {
    private Context context;
    private int nKm;
    
    public a(Context paramContext, int paramInt)
    {
      super(new o());
      AppMethodBeat.i(74410);
      this.context = paramContext;
      this.nKm = paramInt;
      AppMethodBeat.o(74410);
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(74413);
      setCursor(t.azY().azU());
      super.notifyDataSetChanged();
      AppMethodBeat.o(74413);
    }
    
    public final void We()
    {
      AppMethodBeat.i(74412);
      Wd();
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
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.nKm, this.nKm));
        paramViewGroup = new b();
        paramViewGroup.wkH = ((LinearLayout)paramView.findViewById(2131304495));
        paramViewGroup.wkI = ((LinearLayout)paramView.findViewById(2131304494));
        paramViewGroup.wkJ = ((LinearLayout)paramView.findViewById(2131304499));
        paramViewGroup.wkK = ((LinearLayout)paramView.findViewById(2131304500));
        paramViewGroup.wkL = ((LinearLayout)paramView.findViewById(2131304493));
        paramView.setTag(paramViewGroup);
        i = bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(12311, null), -2);
        locala = t.azZ().yR(SettingsSelectBgUI.f(SettingsSelectBgUI.this));
        if (paramInt != 0) {
          break label278;
        }
        if (((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2)) && ((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2) || (locala != null)) && ((locala == null) || (locala.hoW != -2))) {
          break label269;
        }
        paramViewGroup.amZ("using");
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
        paramViewGroup.amZ("downloaded");
      }
      label278:
      if (paramInt == 1)
      {
        if (((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0)) || ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0) && (locala == null)) || ((locala != null) && (locala.hoW == 0))) {
          paramViewGroup.amZ("using");
        }
        for (;;)
        {
          paramViewGroup = f.a(BitmapFactory.decodeResource(this.context.getResources(), 2131231651), true, 10.0F);
          ((ImageView)paramView.findViewById(2131304497)).setImageBitmap(paramViewGroup);
          AppMethodBeat.o(74414);
          return paramView;
          paramViewGroup.amZ("downloaded");
        }
      }
      o localo = (o)getItem(paramInt - 2);
      com.tencent.mm.bc.p localp = t.azY();
      if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable()) {}
      for (Bitmap localBitmap = BitmapFactory.decodeResource(SettingsSelectBgUI.this.getResources(), 2131233477); localBitmap == null; localBitmap = f.aFi(com.tencent.mm.bc.p.azV() + com.tencent.mm.bc.p.dh(localo.id, localo.dkC)))
      {
        paramInt = localo.id;
        i = localo.dkC;
        if (localp.gPa.delete("packageinfo2", "id= ? and type =?", new String[] { String.valueOf(paramInt), String.valueOf(i) }) > 0) {
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
        paramViewGroup.amZ("downloading");
        continue;
        if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.hoW == localo.id))
        {
          paramViewGroup.amZ("using");
        }
        else
        {
          paramViewGroup.amZ("downloaded");
          continue;
          paramViewGroup.amZ("undownloaded");
          continue;
          if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.hoW != localo.id))
          {
            paramViewGroup.amZ("downloaded");
          }
          else
          {
            paramViewGroup.amZ("using");
            continue;
            paramViewGroup.amZ("canceling");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI
 * JD-Core Version:    0.7.0.1
 */