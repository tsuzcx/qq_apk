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
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dwq;
import com.tencent.mm.protocal.protobuf.fdy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.Iterator;
import java.util.LinkedList;

public class AppBrandNotifySettingsUI
  extends MMActivity
{
  private com.tencent.mm.ui.base.q Fxt;
  private a Oxq;
  private DataSetObserver Tr;
  private String kIg;
  private ListView mListView;
  private IListener<o> nRQ;
  private int rGT;
  
  public AppBrandNotifySettingsUI()
  {
    AppMethodBeat.i(232454);
    this.nRQ = new IListener() {};
    AppMethodBeat.o(232454);
  }
  
  protected int getLayoutId()
  {
    return 2131493142;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232455);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.kIg = paramBundle.getStringExtra("report_session_id");
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle)) {
      setMMTitle(2131757334);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(232440);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(232440);
          return false;
        }
      });
      this.mListView = ((ListView)findViewById(2131303242));
      this.Oxq = new a(getLayoutInflater());
      this.mListView.setAdapter(this.Oxq);
      getString(2131755998);
      this.Fxt = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(232441);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(232441);
        }
      });
      this.Tr = new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(232442);
          View localView = AppBrandNotifySettingsUI.this.findViewById(2131303228);
          if (AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            AppMethodBeat.o(232442);
            return;
          }
        }
      };
      this.Oxq.registerDataSetObserver(this.Tr);
      g.aAf();
      this.rGT = com.tencent.mm.kernel.a.getUin();
      paramBundle = com.tencent.mm.modelappbrand.c.iIo;
      aa.a(com.tencent.mm.modelappbrand.c.a.aXF(), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(232445);
          Log.d("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if (AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this) != null) {
            AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            u.makeText(AppBrandNotifySettingsUI.this, 2131763722, 0).show();
            AppMethodBeat.o(232445);
            return 0;
          }
          paramAnonymousString = (bzh)paramAnonymousd.iLL.iLR;
          if (paramAnonymousString.MeZ == null)
          {
            Log.e("MicroMsg.AppBrandNotifySettingsUI", "wxa_msg_config_list not exist");
            AppMethodBeat.o(232445);
            return 0;
          }
          AppBrandNotifySettingsUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(232444);
              if (paramAnonymousString.MeZ == null)
              {
                Log.i("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo, configList is null");
                AppMethodBeat.o(232444);
                return;
              }
              AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this, paramAnonymousString.MeZ);
              AppBrandNotifySettingsUI.bK(paramAnonymousString.MeZ);
              AppMethodBeat.o(232444);
            }
          });
          AppMethodBeat.o(232445);
          return 0;
        }
      }, true, this);
      EventCenter.instance.addListener(this.nRQ);
      AppMethodBeat.o(232455);
      return;
      setMMTitle(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(232456);
    Object localObject1 = (com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class);
    final LinkedList localLinkedList = new LinkedList();
    Object localObject2 = this.Oxq.Oxw;
    if ((localObject2 != null) && (!((LinkedList)localObject2).isEmpty()))
    {
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)((Iterator)localObject2).next();
        fdy localfdy = new fdy();
        Object localObject3 = ((com.tencent.mm.plugin.appbrand.service.q)localObject1).Xk(locala.username);
        if (localObject3 == null)
        {
          Log.i("MicroMsg.AppBrandNotifySettingsUI", "get attribute fail, username: %s", new Object[] { locala.username });
        }
        else
        {
          localObject3 = ((WxaAttributes)localObject3).field_appId;
          if (locala.OxA) {}
          for (int i = 1;; i = 0)
          {
            localfdy.dNI = ((String)localObject3);
            localfdy.status = i;
            localLinkedList.add(localfdy);
            Log.d("MicroMsg.AppBrandNotifySettingsUI", "stev report(%s), eventId : %d, appId %s, status %d", new Object[] { Integer.valueOf(19724), Integer.valueOf(5), localObject3, Integer.valueOf(i) });
            com.tencent.mm.plugin.report.service.h.CyF.a(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject3, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.kIg });
            break;
          }
        }
      }
    }
    if (!localLinkedList.isEmpty())
    {
      localObject1 = new dwq();
      ((dwq)localObject1).MeZ = localLinkedList;
      ((dwq)localObject1).scene = 1;
      localObject2 = com.tencent.mm.modelappbrand.d.iIp;
      aa.a(d.a.a((dwq)localObject1), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(232443);
          Log.d("MicroMsg.AppBrandNotifySettingsUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            u.makeText(AppBrandNotifySettingsUI.this, 2131763735, 0).show();
            AppMethodBeat.o(232443);
            return 0;
          }
          AppBrandNotifySettingsUI.bK(localLinkedList);
          AppMethodBeat.o(232443);
          return 0;
        }
      }, true);
    }
    this.Oxq.unregisterDataSetObserver(this.Tr);
    EventCenter.instance.removeListener(this.nRQ);
    super.onDestroy();
    AppMethodBeat.o(232456);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    LinkedList<a> Oxv;
    LinkedList<a> Oxw;
    private AppBrandNotifySettingsUI.a.b.a Oxx;
    private com.tencent.mm.av.a.a.c Oxy;
    private LayoutInflater mLayoutInflater;
    
    public a(LayoutInflater paramLayoutInflater)
    {
      AppMethodBeat.i(232449);
      this.mLayoutInflater = paramLayoutInflater;
      this.Oxv = new LinkedList();
      this.Oxw = new LinkedList();
      this.Oxx = new AppBrandNotifySettingsUI.a.b.a()
      {
        public final void a(AppBrandNotifySettingsUI.a.a paramAnonymousa, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(232446);
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(232446);
            return;
          }
          Iterator localIterator = AppBrandNotifySettingsUI.a.a(AppBrandNotifySettingsUI.a.this).iterator();
          while (localIterator.hasNext())
          {
            AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)localIterator.next();
            if ((locala != null) && (Util.nullAsNil(locala.username).equals(paramAnonymousa.username)))
            {
              if (paramAnonymousa.OxA != paramAnonymousBoolean)
              {
                AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).add(locala);
                AppMethodBeat.o(232446);
                return;
              }
              AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).remove(locala);
              AppMethodBeat.o(232446);
              return;
            }
          }
          AppMethodBeat.o(232446);
        }
      };
      paramLayoutInflater = new com.tencent.mm.av.a.a.c.a();
      paramLayoutInflater.iaT = true;
      paramLayoutInflater.jbu = com.tencent.mm.modelappbrand.a.a.aXX();
      this.Oxy = paramLayoutInflater.bdv();
      AppMethodBeat.o(232449);
    }
    
    public final a akG(int paramInt)
    {
      AppMethodBeat.i(232451);
      a locala = (a)this.Oxv.get(paramInt);
      AppMethodBeat.o(232451);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(232450);
      int i = this.Oxv.size();
      AppMethodBeat.o(232450);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(232452);
      a locala = akG(paramInt);
      if (paramView == null)
      {
        paramView = this.mLayoutInflater.inflate(2131493143, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        paramViewGroup.gyr = ((ImageView)paramView.findViewById(2131297121));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131309199));
        paramViewGroup.OxF = ((MMSwitchBtn)paramView.findViewById(2131296993));
        paramViewGroup.jWr = paramView.findViewById(2131296995);
        paramView.setTag(paramViewGroup);
        com.tencent.mm.av.q.bcV().a(locala.url, paramViewGroup.gyr, this.Oxy);
        paramViewGroup.titleTv.setText(locala.title);
        paramViewGroup.OxF.setCheck(locala.OxA);
        if (paramViewGroup.OxF.getTag() != null) {
          break label231;
        }
        b localb = new b((byte)0);
        localb.OxB = locala;
        localb.OxC = this.Oxx;
        paramViewGroup.OxF.setSwitchListener(localb.OxD);
        paramViewGroup.OxF.setTag(localb);
        label191:
        if (paramInt != this.Oxv.size() - 1) {
          break label249;
        }
        paramViewGroup.jWr.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(232452);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        label231:
        ((b)paramViewGroup.OxF.getTag()).OxB = locala;
        break label191;
        label249:
        paramViewGroup.jWr.setVisibility(0);
      }
    }
    
    static final class a
    {
      boolean OxA;
      String title;
      String url;
      String username;
    }
    
    static final class b
    {
      AppBrandNotifySettingsUI.a.a OxB;
      a OxC;
      MMSwitchBtn.a OxD;
      
      private b()
      {
        AppMethodBeat.i(232448);
        this.OxD = new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(232447);
            if (AppBrandNotifySettingsUI.a.b.this.OxC != null) {
              AppBrandNotifySettingsUI.a.b.this.OxC.a(AppBrandNotifySettingsUI.a.b.this.OxB, paramAnonymousBoolean);
            }
            AppMethodBeat.o(232447);
          }
        };
        AppMethodBeat.o(232448);
      }
      
      public static abstract interface a
      {
        public abstract void a(AppBrandNotifySettingsUI.a.a parama, boolean paramBoolean);
      }
    }
    
    static final class c
    {
      MMSwitchBtn OxF;
      ImageView gyr;
      View jWr;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.AppBrandNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */