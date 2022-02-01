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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsSelectBgUI
  extends MMActivity
  implements f
{
  private List<k> gto;
  private String username;
  private boolean yGA;
  private a yIX;
  private GridView yIY;
  private k yIZ;
  private av yJa;
  
  public SettingsSelectBgUI()
  {
    AppMethodBeat.i(74416);
    this.gto = new ArrayList();
    this.yJa = new av(new av.a()
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
  
  private void fC(List<k> paramList)
  {
    AppMethodBeat.i(74421);
    if (paramList.size() > 0)
    {
      this.yIZ = ((k)paramList.remove(0));
      com.tencent.mm.kernel.g.aiU().a(this.yIZ, 0);
      AppMethodBeat.o(74421);
      return;
    }
    this.yIZ = null;
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
    this.yGA = getIntent().getBooleanExtra("isApplyToAll", true);
    this.username = getIntent().getStringExtra("username");
    this.yJa.az(20L, 20L);
    AppMethodBeat.o(74419);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74417);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.kernel.g.aiU().a(159, this);
    com.tencent.mm.kernel.g.aiU().a(160, this);
    if (com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
    {
      paramBundle = new l(1);
      com.tencent.mm.kernel.g.aiU().a(paramBundle, 0);
    }
    AppMethodBeat.o(74417);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74418);
    super.onDestroy();
    if (this.yIZ != null)
    {
      com.tencent.mm.kernel.g.aiU().a(this.yIZ);
      t.aJZ().dn(this.yIZ.ijm, 1);
    }
    List localList = this.gto;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      t.aJZ().dn(localk.ijm, 1);
    }
    localList.clear();
    com.tencent.mm.kernel.g.aiU().b(159, this);
    com.tencent.mm.kernel.g.aiU().b(160, this);
    this.yIX.det();
    t.aJZ().remove(this.yIX);
    AppMethodBeat.o(74418);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74420);
    if ((!(paramn instanceof com.tencent.mm.al.p)) || (((com.tencent.mm.al.p)paramn).aEM() != 1))
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
      fC(this.gto);
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
    private int oQH;
    
    public a(Context paramContext, int paramInt)
    {
      super(new o());
      AppMethodBeat.i(74410);
      this.context = paramContext;
      this.oQH = paramInt;
      AppMethodBeat.o(74410);
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(74413);
      setCursor(t.aJZ().aJV());
      super.notifyDataSetChanged();
      AppMethodBeat.o(74413);
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(74412);
      Zu();
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
      com.tencent.mm.bc.a locala;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131495405, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.oQH, this.oQH));
        paramViewGroup = new b();
        paramViewGroup.yKI = ((LinearLayout)paramView.findViewById(2131304495));
        paramViewGroup.yKJ = ((LinearLayout)paramView.findViewById(2131304494));
        paramViewGroup.yKK = ((LinearLayout)paramView.findViewById(2131304499));
        paramViewGroup.yKL = ((LinearLayout)paramView.findViewById(2131304500));
        paramViewGroup.yKM = ((LinearLayout)paramView.findViewById(2131304493));
        paramView.setTag(paramViewGroup);
        i = bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(12311, null), -2);
        locala = t.aKa().Gb(SettingsSelectBgUI.f(SettingsSelectBgUI.this));
        if (paramInt != 0) {
          break label278;
        }
        if (((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2)) && ((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) || (i != -2) || (locala != null)) && ((locala == null) || (locala.iiM != -2))) {
          break label269;
        }
        paramViewGroup.axi("using");
      }
      for (;;)
      {
        paramViewGroup = com.tencent.mm.sdk.platformtools.g.a(BitmapFactory.decodeResource(this.context.getResources(), 2131231652), true, 10.0F);
        ((ImageView)paramView.findViewById(2131304497)).setImageBitmap(paramViewGroup);
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup = (b)paramView.getTag();
        break;
        label269:
        paramViewGroup.axi("downloaded");
      }
      label278:
      if (paramInt == 1)
      {
        if (((SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0)) || ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (i == 0) && (locala == null)) || ((locala != null) && (locala.iiM == 0))) {
          paramViewGroup.axi("using");
        }
        for (;;)
        {
          paramViewGroup = com.tencent.mm.sdk.platformtools.g.a(BitmapFactory.decodeResource(this.context.getResources(), 2131231651), true, 10.0F);
          ((ImageView)paramView.findViewById(2131304497)).setImageBitmap(paramViewGroup);
          AppMethodBeat.o(74414);
          return paramView;
          paramViewGroup.axi("downloaded");
        }
      }
      o localo = (o)getItem(paramInt - 2);
      com.tencent.mm.bc.p localp = t.aJZ();
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable()) {}
      for (Bitmap localBitmap = BitmapFactory.decodeResource(SettingsSelectBgUI.this.getResources(), 2131233477); localBitmap == null; localBitmap = com.tencent.mm.sdk.platformtools.g.aQf(com.tencent.mm.bc.p.aJW() + com.tencent.mm.bc.p.dk(localo.id, localo.dtF)))
      {
        paramInt = localo.id;
        i = localo.dtF;
        if (localp.hHS.delete("packageinfo2", "id= ? and type =?", new String[] { String.valueOf(paramInt), String.valueOf(i) }) > 0) {
          localp.doNotify();
        }
        AppMethodBeat.o(74414);
        return paramView;
      }
      localBitmap = com.tencent.mm.sdk.platformtools.g.a(localBitmap, true, 10.0F);
      ((ImageView)paramView.findViewById(2131304497)).setImageBitmap(localBitmap);
      switch (localo.status)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(74414);
        return paramView;
        paramViewGroup.axi("downloading");
        continue;
        if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.iiM == localo.id))
        {
          paramViewGroup.axi("using");
        }
        else
        {
          paramViewGroup.axi("downloaded");
          continue;
          paramViewGroup.axi("undownloaded");
          continue;
          if ((!SettingsSelectBgUI.c(SettingsSelectBgUI.this)) && (locala != null) && (locala.iiM != localo.id))
          {
            paramViewGroup.axi("downloaded");
          }
          else
          {
            paramViewGroup.axi("using");
            continue;
            paramViewGroup.axi("canceling");
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