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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.a.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelappbrand.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.egq;
import com.tencent.mm.protocal.protobuf.foz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.Iterator;
import java.util.LinkedList;

public class AppBrandNotifySettingsUI
  extends MMActivity
{
  private s LRv;
  private DataSetObserver QT;
  private a VQu;
  private ListView mListView;
  private String nBW;
  private IListener<p> qTt;
  private int vmC;
  
  public AppBrandNotifySettingsUI()
  {
    AppMethodBeat.i(223104);
    this.qTt = new IListener() {};
    AppMethodBeat.o(223104);
  }
  
  protected int getLayoutId()
  {
    return R.i.ebF;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(223107);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.nBW = paramBundle.getStringExtra("report_session_id");
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle)) {
      setMMTitle(R.l.eus);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(229500);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(229500);
          return false;
        }
      });
      this.mListView = ((ListView)findViewById(R.h.listview));
      this.VQu = new a(getLayoutInflater());
      this.mListView.setAdapter(this.VQu);
      getString(R.l.app_tip);
      this.LRv = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(272787);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(272787);
        }
      });
      this.QT = new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(286749);
          View localView = AppBrandNotifySettingsUI.this.findViewById(R.h.dLo);
          if (AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            AppMethodBeat.o(286749);
            return;
          }
        }
      };
      this.VQu.registerDataSetObserver(this.QT);
      com.tencent.mm.kernel.h.aHE();
      this.vmC = b.getUin();
      paramBundle = com.tencent.mm.modelappbrand.c.lyq;
      aa.a(com.tencent.mm.modelappbrand.c.a.bgN(), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(280894);
          Log.d("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if (AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this) != null) {
            AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            w.makeText(AppBrandNotifySettingsUI.this, R.l.eOf, 0).show();
            AppMethodBeat.o(280894);
            return 0;
          }
          paramAnonymousString = (chb)d.c.b(paramAnonymousd.lBS);
          if (paramAnonymousString.ToB == null)
          {
            Log.e("MicroMsg.AppBrandNotifySettingsUI", "wxa_msg_config_list not exist");
            AppMethodBeat.o(280894);
            return 0;
          }
          AppBrandNotifySettingsUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(255679);
              if (paramAnonymousString.ToB == null)
              {
                Log.i("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo, configList is null");
                AppMethodBeat.o(255679);
                return;
              }
              AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this, paramAnonymousString.ToB);
              AppBrandNotifySettingsUI.cj(paramAnonymousString.ToB);
              AppMethodBeat.o(255679);
            }
          });
          AppMethodBeat.o(280894);
          return 0;
        }
      }, true, this);
      EventCenter.instance.addListener(this.qTt);
      AppMethodBeat.o(223107);
      return;
      setMMTitle(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(223120);
    Object localObject1 = (com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = this.VQu.VQA;
    if ((localObject2 != null) && (!((LinkedList)localObject2).isEmpty()))
    {
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)((Iterator)localObject2).next();
        foz localfoz = new foz();
        Object localObject3 = ((com.tencent.mm.plugin.appbrand.service.q)localObject1).aeW(locala.username);
        if (localObject3 == null)
        {
          Log.i("MicroMsg.AppBrandNotifySettingsUI", "get attribute fail, username: %s", new Object[] { locala.username });
        }
        else
        {
          localObject3 = ((WxaAttributes)localObject3).field_appId;
          if (locala.VQE) {}
          for (int i = 1;; i = 0)
          {
            localfoz.appid = ((String)localObject3);
            localfoz.status = i;
            localLinkedList.add(localfoz);
            Log.d("MicroMsg.AppBrandNotifySettingsUI", "stev report(%s), eventId : %d, appId %s, status %d", new Object[] { Integer.valueOf(19724), Integer.valueOf(5), localObject3, Integer.valueOf(i) });
            com.tencent.mm.plugin.report.service.h.IzE.a(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject3, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.nBW });
            break;
          }
        }
      }
    }
    if (!localLinkedList.isEmpty())
    {
      localObject1 = new egq();
      ((egq)localObject1).ToB = localLinkedList;
      ((egq)localObject1).scene = 1;
      localObject2 = com.tencent.mm.modelappbrand.d.lyr;
      aa.a(d.a.a((egq)localObject1), new AppBrandNotifySettingsUI.5(this, localLinkedList), true);
    }
    this.VQu.unregisterDataSetObserver(this.QT);
    EventCenter.instance.removeListener(this.qTt);
    super.onDestroy();
    AppMethodBeat.o(223120);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    LinkedList<a> VQA;
    private AppBrandNotifySettingsUI.a.b.a VQB;
    private com.tencent.mm.ay.a.a.c VQC;
    LinkedList<a> VQz;
    private LayoutInflater mLayoutInflater;
    
    public a(LayoutInflater paramLayoutInflater)
    {
      AppMethodBeat.i(228977);
      this.mLayoutInflater = paramLayoutInflater;
      this.VQz = new LinkedList();
      this.VQA = new LinkedList();
      this.VQB = new AppBrandNotifySettingsUI.a.b.a()
      {
        public final void a(AppBrandNotifySettingsUI.a.a paramAnonymousa, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(280649);
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(280649);
            return;
          }
          Iterator localIterator = AppBrandNotifySettingsUI.a.a(AppBrandNotifySettingsUI.a.this).iterator();
          while (localIterator.hasNext())
          {
            AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)localIterator.next();
            if ((locala != null) && (Util.nullAsNil(locala.username).equals(paramAnonymousa.username)))
            {
              if (paramAnonymousa.VQE != paramAnonymousBoolean)
              {
                AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).add(locala);
                AppMethodBeat.o(280649);
                return;
              }
              AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).remove(locala);
              AppMethodBeat.o(280649);
              return;
            }
          }
          AppMethodBeat.o(280649);
        }
      };
      paramLayoutInflater = new com.tencent.mm.ay.a.a.c.a();
      paramLayoutInflater.kPz = true;
      paramLayoutInflater.lRT = com.tencent.mm.modelappbrand.a.a.bhg();
      this.VQC = paramLayoutInflater.bmL();
      AppMethodBeat.o(228977);
    }
    
    public final a atA(int paramInt)
    {
      AppMethodBeat.i(228981);
      a locala = (a)this.VQz.get(paramInt);
      AppMethodBeat.o(228981);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(228980);
      int i = this.VQz.size();
      AppMethodBeat.o(228980);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(228994);
      a locala = atA(paramInt);
      if (paramView == null)
      {
        paramView = this.mLayoutInflater.inflate(R.i.ebG, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        paramViewGroup.jiu = ((ImageView)paramView.findViewById(R.h.avatarIv));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(R.h.titleTv));
        paramViewGroup.VQJ = ((MMSwitchBtn)paramView.findViewById(R.h.dro));
        paramViewGroup.mND = paramView.findViewById(R.h.drp);
        paramView.setTag(paramViewGroup);
        com.tencent.mm.ay.q.bml().a(locala.url, paramViewGroup.jiu, this.VQC);
        paramViewGroup.titleTv.setText(locala.title);
        paramViewGroup.VQJ.setCheck(locala.VQE);
        if (paramViewGroup.VQJ.getTag() != null) {
          break label236;
        }
        b localb = new b((byte)0);
        localb.VQF = locala;
        localb.VQG = this.VQB;
        paramViewGroup.VQJ.setSwitchListener(localb.VQH);
        paramViewGroup.VQJ.setTag(localb);
        label196:
        if (paramInt != this.VQz.size() - 1) {
          break label254;
        }
        paramViewGroup.mND.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(228994);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        label236:
        ((b)paramViewGroup.VQJ.getTag()).VQF = locala;
        break label196;
        label254:
        paramViewGroup.mND.setVisibility(0);
      }
    }
    
    static final class a
    {
      boolean VQE;
      String title;
      String url;
      String username;
    }
    
    static final class b
    {
      AppBrandNotifySettingsUI.a.a VQF;
      a VQG;
      MMSwitchBtn.a VQH;
      
      private b()
      {
        AppMethodBeat.i(242696);
        this.VQH = new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(281590);
            if (AppBrandNotifySettingsUI.a.b.this.VQG != null) {
              AppBrandNotifySettingsUI.a.b.this.VQG.a(AppBrandNotifySettingsUI.a.b.this.VQF, paramAnonymousBoolean);
            }
            AppMethodBeat.o(281590);
          }
        };
        AppMethodBeat.o(242696);
      }
      
      public static abstract interface a
      {
        public abstract void a(AppBrandNotifySettingsUI.a.a parama, boolean paramBoolean);
      }
    }
    
    static final class c
    {
      MMSwitchBtn VQJ;
      ImageView jiu;
      View mND;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.AppBrandNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */