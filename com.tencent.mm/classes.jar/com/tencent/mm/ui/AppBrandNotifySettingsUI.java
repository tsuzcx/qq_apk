package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.dvt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.Iterator;
import java.util.LinkedList;

public class AppBrandNotifySettingsUI
  extends MMActivity
{
  private a FGp;
  private DataSetObserver Qv;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.n> lyl;
  private ListView mListView;
  private String mSceneId;
  private int pcr;
  private p yqi;
  
  public AppBrandNotifySettingsUI()
  {
    AppMethodBeat.i(191394);
    this.lyl = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(191394);
  }
  
  protected int getLayoutId()
  {
    return 2131493100;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(191395);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.mSceneId = paramBundle.getStringExtra("scene_id");
    paramBundle.putExtra("scene_id", this.mSceneId);
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle)) {
      setMMTitle(2131757130);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(191380);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(191380);
          return false;
        }
      });
      this.mListView = ((ListView)findViewById(2131301457));
      this.FGp = new a(getLayoutInflater());
      this.mListView.setAdapter(this.FGp);
      getString(2131755906);
      this.yqi = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(191381);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(191381);
        }
      });
      this.Qv = new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(191382);
          View localView = AppBrandNotifySettingsUI.this.findViewById(2131301445);
          if (AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            AppMethodBeat.o(191382);
            return;
          }
        }
      };
      this.FGp.registerDataSetObserver(this.Qv);
      g.afz();
      this.pcr = com.tencent.mm.kernel.a.getUin();
      paramBundle = com.tencent.mm.modelappbrand.c.gRx;
      x.a(com.tencent.mm.modelappbrand.c.a.atI(), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, b paramAnonymousb, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(191385);
          ad.d("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if (AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this) != null) {
            AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(AppBrandNotifySettingsUI.this, 2131761752, 0).show();
            AppMethodBeat.o(191385);
            return 0;
          }
          paramAnonymousString = (bdy)paramAnonymousb.gUT.gUX;
          if (paramAnonymousString.DBE == null)
          {
            ad.e("MicroMsg.AppBrandNotifySettingsUI", "wxa_msg_config_list not exist");
            AppMethodBeat.o(191385);
            return 0;
          }
          AppBrandNotifySettingsUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(191384);
              if (paramAnonymousString.DBE == null)
              {
                ad.i("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo, configList is null");
                AppMethodBeat.o(191384);
                return;
              }
              AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this, paramAnonymousString.DBE);
              AppBrandNotifySettingsUI.bg(paramAnonymousString.DBE);
              AppMethodBeat.o(191384);
            }
          });
          AppMethodBeat.o(191385);
          return 0;
        }
      }, true, this);
      com.tencent.mm.sdk.b.a.ESL.c(this.lyl);
      AppMethodBeat.o(191395);
      return;
      setMMTitle(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(191396);
    Object localObject1 = (m)g.ab(m.class);
    final LinkedList localLinkedList = new LinkedList();
    Object localObject2 = this.FGp.FGv;
    if ((localObject2 != null) && (!((LinkedList)localObject2).isEmpty()))
    {
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)((Iterator)localObject2).next();
        dvt localdvt = new dvt();
        Object localObject3 = ((m)localObject1).FW(locala.username);
        if (localObject3 == null)
        {
          ad.i("MicroMsg.AppBrandNotifySettingsUI", "get attribute fail, username: %s", new Object[] { locala.username });
        }
        else
        {
          localObject3 = ((WxaAttributes)localObject3).field_appId;
          if (locala.FGz) {}
          for (int i = 1;; i = 0)
          {
            localdvt.dlB = ((String)localObject3);
            localdvt.status = i;
            localLinkedList.add(localdvt);
            ad.d("MicroMsg.AppBrandNotifySettingsUI", "stev report(%s), eventId : %d, appId %s, status %d", new Object[] { Integer.valueOf(19724), Integer.valueOf(5), localObject3, Integer.valueOf(i) });
            com.tencent.mm.plugin.report.service.h.vKh.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject3, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null });
            break;
          }
        }
      }
    }
    if (!localLinkedList.isEmpty())
    {
      localObject1 = new crw();
      ((crw)localObject1).DBE = localLinkedList;
      ((crw)localObject1).scene = 1;
      localObject2 = d.gRy;
      x.a(d.a.a((crw)localObject1), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(191383);
          ad.d("MicroMsg.AppBrandNotifySettingsUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(AppBrandNotifySettingsUI.this, 2131761765, 0).show();
            AppMethodBeat.o(191383);
            return 0;
          }
          AppBrandNotifySettingsUI.bg(localLinkedList);
          AppMethodBeat.o(191383);
          return 0;
        }
      }, true);
    }
    this.FGp.unregisterDataSetObserver(this.Qv);
    com.tencent.mm.sdk.b.a.ESL.d(this.lyl);
    super.onDestroy();
    AppMethodBeat.o(191396);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    LinkedList<a> FGu;
    LinkedList<a> FGv;
    private AppBrandNotifySettingsUI.a.b.a FGw;
    private com.tencent.mm.aw.a.a.c FGx;
    private LayoutInflater mLayoutInflater;
    
    public a(LayoutInflater paramLayoutInflater)
    {
      AppMethodBeat.i(191389);
      this.mLayoutInflater = paramLayoutInflater;
      this.FGu = new LinkedList();
      this.FGv = new LinkedList();
      this.FGw = new AppBrandNotifySettingsUI.a.b.a()
      {
        public final void a(AppBrandNotifySettingsUI.a.a paramAnonymousa, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(191386);
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(191386);
            return;
          }
          Iterator localIterator = AppBrandNotifySettingsUI.a.a(AppBrandNotifySettingsUI.a.this).iterator();
          while (localIterator.hasNext())
          {
            AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)localIterator.next();
            if ((locala != null) && (bt.nullAsNil(locala.username).equals(paramAnonymousa.username)))
            {
              if (paramAnonymousa.FGz != paramAnonymousBoolean)
              {
                AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).add(locala);
                AppMethodBeat.o(191386);
                return;
              }
              AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).remove(locala);
              AppMethodBeat.o(191386);
              return;
            }
          }
          AppMethodBeat.o(191386);
        }
      };
      paramLayoutInflater = new com.tencent.mm.aw.a.a.c.a();
      paramLayoutInflater.gkG = true;
      paramLayoutInflater.hkj = com.tencent.mm.modelappbrand.a.a.aua();
      this.FGx = paramLayoutInflater.azc();
      AppMethodBeat.o(191389);
    }
    
    public final a WY(int paramInt)
    {
      AppMethodBeat.i(191391);
      a locala = (a)this.FGu.get(paramInt);
      AppMethodBeat.o(191391);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(191390);
      int i = this.FGu.size();
      AppMethodBeat.o(191390);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(191392);
      a locala = WY(paramInt);
      if (paramView == null)
      {
        paramView = this.mLayoutInflater.inflate(2131493101, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        paramViewGroup.fuj = ((ImageView)paramView.findViewById(2131296998));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131305906));
        paramViewGroup.FGE = ((MMSwitchBtn)paramView.findViewById(2131296893));
        paramViewGroup.icB = paramView.findViewById(2131296895);
        paramView.setTag(paramViewGroup);
        o.ayJ().a(locala.url, paramViewGroup.fuj, this.FGx);
        paramViewGroup.titleTv.setText(locala.title);
        paramViewGroup.FGE.setCheck(locala.FGz);
        if (paramViewGroup.FGE.getTag() != null) {
          break label231;
        }
        b localb = new b((byte)0);
        localb.FGA = locala;
        localb.FGB = this.FGw;
        paramViewGroup.FGE.setSwitchListener(localb.FGC);
        paramViewGroup.FGE.setTag(localb);
        label191:
        if (paramInt != this.FGu.size() - 1) {
          break label249;
        }
        paramViewGroup.icB.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(191392);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        label231:
        ((b)paramViewGroup.FGE.getTag()).FGA = locala;
        break label191;
        label249:
        paramViewGroup.icB.setVisibility(0);
      }
    }
    
    static final class a
    {
      boolean FGz;
      String title;
      String url;
      String username;
    }
    
    static final class b
    {
      AppBrandNotifySettingsUI.a.a FGA;
      a FGB;
      MMSwitchBtn.a FGC;
      
      private b()
      {
        AppMethodBeat.i(191388);
        this.FGC = new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(191387);
            if (AppBrandNotifySettingsUI.a.b.this.FGB != null) {
              AppBrandNotifySettingsUI.a.b.this.FGB.a(AppBrandNotifySettingsUI.a.b.this.FGA, paramAnonymousBoolean);
            }
            AppMethodBeat.o(191387);
          }
        };
        AppMethodBeat.o(191388);
      }
      
      public static abstract interface a
      {
        public abstract void a(AppBrandNotifySettingsUI.a.a parama, boolean paramBoolean);
      }
    }
    
    static final class c
    {
      MMSwitchBtn FGE;
      ImageView fuj;
      View icB;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.AppBrandNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */