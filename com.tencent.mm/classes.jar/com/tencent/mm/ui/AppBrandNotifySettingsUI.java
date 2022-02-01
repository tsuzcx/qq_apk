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
import com.tencent.mm.aw.q;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.eho;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.Iterator;
import java.util.LinkedList;

public class AppBrandNotifySettingsUI
  extends MMActivity
{
  private p AVf;
  private a ISO;
  private DataSetObserver Tf;
  private String jDl;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.n> mAa;
  private ListView mListView;
  private int qjh;
  
  public AppBrandNotifySettingsUI()
  {
    AppMethodBeat.i(193592);
    this.mAa = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(193592);
  }
  
  protected int getLayoutId()
  {
    return 2131493100;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193593);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.jDl = paramBundle.getStringExtra("report_session_id");
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
          AppMethodBeat.i(193578);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(193578);
          return false;
        }
      });
      this.mListView = ((ListView)findViewById(2131301457));
      this.ISO = new a(getLayoutInflater());
      this.mListView.setAdapter(this.ISO);
      getString(2131755906);
      this.AVf = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(193579);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(193579);
        }
      });
      this.Tf = new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(193580);
          View localView = AppBrandNotifySettingsUI.this.findViewById(2131301445);
          if (AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            AppMethodBeat.o(193580);
            return;
          }
        }
      };
      this.ISO.registerDataSetObserver(this.Tf);
      com.tencent.mm.kernel.g.ajA();
      this.qjh = com.tencent.mm.kernel.a.getUin();
      paramBundle = com.tencent.mm.modelappbrand.c.hKp;
      x.a(com.tencent.mm.modelappbrand.c.a.aDC(), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, b paramAnonymousb, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(193583);
          ad.d("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if (AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this) != null) {
            AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(AppBrandNotifySettingsUI.this, 2131761752, 0).show();
            AppMethodBeat.o(193583);
            return 0;
          }
          paramAnonymousString = (bly)paramAnonymousb.hNL.hNQ;
          if (paramAnonymousString.GGx == null)
          {
            ad.e("MicroMsg.AppBrandNotifySettingsUI", "wxa_msg_config_list not exist");
            AppMethodBeat.o(193583);
            return 0;
          }
          AppBrandNotifySettingsUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193582);
              if (paramAnonymousString.GGx == null)
              {
                ad.i("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo, configList is null");
                AppMethodBeat.o(193582);
                return;
              }
              AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this, paramAnonymousString.GGx);
              AppBrandNotifySettingsUI.bo(paramAnonymousString.GGx);
              AppMethodBeat.o(193582);
            }
          });
          AppMethodBeat.o(193583);
          return 0;
        }
      }, true, this);
      com.tencent.mm.sdk.b.a.IbL.c(this.mAa);
      AppMethodBeat.o(193593);
      return;
      setMMTitle(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(193594);
    Object localObject1 = (com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = this.ISO.ISU;
    if ((localObject2 != null) && (!((LinkedList)localObject2).isEmpty()))
    {
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)((Iterator)localObject2).next();
        eho localeho = new eho();
        Object localObject3 = ((com.tencent.mm.plugin.appbrand.service.n)localObject1).Nt(locala.username);
        if (localObject3 == null)
        {
          ad.i("MicroMsg.AppBrandNotifySettingsUI", "get attribute fail, username: %s", new Object[] { locala.username });
        }
        else
        {
          localObject3 = ((WxaAttributes)localObject3).field_appId;
          if (locala.ISY) {}
          for (int i = 1;; i = 0)
          {
            localeho.duW = ((String)localObject3);
            localeho.status = i;
            localLinkedList.add(localeho);
            ad.d("MicroMsg.AppBrandNotifySettingsUI", "stev report(%s), eventId : %d, appId %s, status %d", new Object[] { Integer.valueOf(19724), Integer.valueOf(5), localObject3, Integer.valueOf(i) });
            com.tencent.mm.plugin.report.service.g.yhR.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject3, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.jDl });
            break;
          }
        }
      }
    }
    if (!localLinkedList.isEmpty())
    {
      localObject1 = new dcs();
      ((dcs)localObject1).GGx = localLinkedList;
      ((dcs)localObject1).scene = 1;
      localObject2 = d.hKq;
      x.a(d.a.a((dcs)localObject1), new AppBrandNotifySettingsUI.5(this, localLinkedList), true);
    }
    this.ISO.unregisterDataSetObserver(this.Tf);
    com.tencent.mm.sdk.b.a.IbL.d(this.mAa);
    super.onDestroy();
    AppMethodBeat.o(193594);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    LinkedList<a> IST;
    LinkedList<a> ISU;
    private AppBrandNotifySettingsUI.a.b.a ISV;
    private com.tencent.mm.aw.a.a.c ISW;
    private LayoutInflater mLayoutInflater;
    
    public a(LayoutInflater paramLayoutInflater)
    {
      AppMethodBeat.i(193587);
      this.mLayoutInflater = paramLayoutInflater;
      this.IST = new LinkedList();
      this.ISU = new LinkedList();
      this.ISV = new AppBrandNotifySettingsUI.a.b.a()
      {
        public final void a(AppBrandNotifySettingsUI.a.a paramAnonymousa, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(193584);
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(193584);
            return;
          }
          Iterator localIterator = AppBrandNotifySettingsUI.a.a(AppBrandNotifySettingsUI.a.this).iterator();
          while (localIterator.hasNext())
          {
            AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)localIterator.next();
            if ((locala != null) && (bt.nullAsNil(locala.username).equals(paramAnonymousa.username)))
            {
              if (paramAnonymousa.ISY != paramAnonymousBoolean)
              {
                AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).add(locala);
                AppMethodBeat.o(193584);
                return;
              }
              AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).remove(locala);
              AppMethodBeat.o(193584);
              return;
            }
          }
          AppMethodBeat.o(193584);
        }
      };
      paramLayoutInflater = new com.tencent.mm.aw.a.a.c.a();
      paramLayoutInflater.hfi = true;
      paramLayoutInflater.idH = com.tencent.mm.modelappbrand.a.a.aDU();
      this.ISW = paramLayoutInflater.aJc();
      AppMethodBeat.o(193587);
    }
    
    public final a abr(int paramInt)
    {
      AppMethodBeat.i(193589);
      a locala = (a)this.IST.get(paramInt);
      AppMethodBeat.o(193589);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(193588);
      int i = this.IST.size();
      AppMethodBeat.o(193588);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(193590);
      a locala = abr(paramInt);
      if (paramView == null)
      {
        paramView = this.mLayoutInflater.inflate(2131493101, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        paramViewGroup.fRd = ((ImageView)paramView.findViewById(2131296998));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131305906));
        paramViewGroup.ITd = ((MMSwitchBtn)paramView.findViewById(2131296893));
        paramViewGroup.iVT = paramView.findViewById(2131296895);
        paramView.setTag(paramViewGroup);
        q.aIJ().a(locala.url, paramViewGroup.fRd, this.ISW);
        paramViewGroup.titleTv.setText(locala.title);
        paramViewGroup.ITd.setCheck(locala.ISY);
        if (paramViewGroup.ITd.getTag() != null) {
          break label231;
        }
        b localb = new b((byte)0);
        localb.ISZ = locala;
        localb.ITa = this.ISV;
        paramViewGroup.ITd.setSwitchListener(localb.ITb);
        paramViewGroup.ITd.setTag(localb);
        label191:
        if (paramInt != this.IST.size() - 1) {
          break label249;
        }
        paramViewGroup.iVT.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(193590);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        label231:
        ((b)paramViewGroup.ITd.getTag()).ISZ = locala;
        break label191;
        label249:
        paramViewGroup.iVT.setVisibility(0);
      }
    }
    
    static final class a
    {
      boolean ISY;
      String title;
      String url;
      String username;
    }
    
    static final class b
    {
      AppBrandNotifySettingsUI.a.a ISZ;
      a ITa;
      MMSwitchBtn.a ITb;
      
      private b()
      {
        AppMethodBeat.i(193586);
        this.ITb = new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(193585);
            if (AppBrandNotifySettingsUI.a.b.this.ITa != null) {
              AppBrandNotifySettingsUI.a.b.this.ITa.a(AppBrandNotifySettingsUI.a.b.this.ISZ, paramAnonymousBoolean);
            }
            AppMethodBeat.o(193585);
          }
        };
        AppMethodBeat.o(193586);
      }
      
      public static abstract interface a
      {
        public abstract void a(AppBrandNotifySettingsUI.a.a parama, boolean paramBoolean);
      }
    }
    
    static final class c
    {
      MMSwitchBtn ITd;
      ImageView fRd;
      View iVT;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.AppBrandNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */