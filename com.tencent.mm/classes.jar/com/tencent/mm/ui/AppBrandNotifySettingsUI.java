package com.tencent.mm.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.d.a;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.e.a;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.protocal.protobuf.faq;
import com.tencent.mm.protocal.protobuf.glz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.Iterator;
import java.util.LinkedList;

public class AppBrandNotifySettingsUI
  extends MMActivity
{
  private w Sub;
  private a aduC;
  private DataSetObserver bxk;
  private ListView mListView;
  private String qBl;
  private IListener<com.tencent.mm.autogen.a.r> tYk;
  private int yze;
  
  public AppBrandNotifySettingsUI()
  {
    AppMethodBeat.i(249153);
    this.tYk = new IListener(f.hfK) {};
    AppMethodBeat.o(249153);
  }
  
  protected int getLayoutId()
  {
    return R.i.gen;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249174);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.qBl = paramBundle.getStringExtra("report_session_id");
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle)) {
      setMMTitle(R.l.gwQ);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(249215);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(249215);
          return false;
        }
      });
      this.mListView = ((ListView)findViewById(R.h.listview));
      this.aduC = new a(getLayoutInflater());
      this.mListView.setAdapter(this.aduC);
      getString(R.l.app_tip);
      this.Sub = k.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(249207);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(249207);
        }
      });
      this.bxk = new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(249203);
          View localView = AppBrandNotifySettingsUI.this.findViewById(R.h.fMT);
          if (AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            AppMethodBeat.o(249203);
            return;
          }
        }
      };
      this.aduC.registerDataSetObserver(this.bxk);
      com.tencent.mm.kernel.h.baC();
      this.yze = b.getUin();
      paramBundle = d.opR;
      z.a(d.a.bEF(), new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(249127);
          Log.d("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if (AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this) != null) {
            AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            aa.makeText(AppBrandNotifySettingsUI.this, R.l.gQr, 0).show();
            AppMethodBeat.o(249127);
            return 0;
          }
          paramAnonymousString = (cxc)c.c.b(paramAnonymousc.otC);
          if (paramAnonymousString.aaCI == null)
          {
            Log.e("MicroMsg.AppBrandNotifySettingsUI", "wxa_msg_config_list not exist");
            AppMethodBeat.o(249127);
            return 0;
          }
          AppBrandNotifySettingsUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(249458);
              if (paramAnonymousString.aaCI == null)
              {
                Log.i("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo, configList is null");
                AppMethodBeat.o(249458);
                return;
              }
              AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this, paramAnonymousString.aaCI);
              AppBrandNotifySettingsUI.cx(paramAnonymousString.aaCI);
              AppMethodBeat.o(249458);
            }
          });
          AppMethodBeat.o(249127);
          return 0;
        }
      }, true, this);
      this.tYk.alive();
      AppMethodBeat.o(249174);
      return;
      setMMTitle(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(249178);
    Object localObject1 = (s)com.tencent.mm.kernel.h.ax(s.class);
    final LinkedList localLinkedList = new LinkedList();
    Object localObject2 = this.aduC.aduI;
    if ((localObject2 != null) && (!((LinkedList)localObject2).isEmpty()))
    {
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)((Iterator)localObject2).next();
        glz localglz = new glz();
        Object localObject3 = ((s)localObject1).Xy(locala.username);
        if (localObject3 == null)
        {
          Log.i("MicroMsg.AppBrandNotifySettingsUI", "get attribute fail, username: %s", new Object[] { locala.username });
        }
        else
        {
          localObject3 = ((WxaAttributes)localObject3).field_appId;
          if (locala.aduM) {}
          for (int i = 1;; i = 0)
          {
            localglz.appid = ((String)localObject3);
            localglz.status = i;
            localLinkedList.add(localglz);
            Log.d("MicroMsg.AppBrandNotifySettingsUI", "stev report(%s), eventId : %d, appId %s, status %d", new Object[] { Integer.valueOf(19724), Integer.valueOf(5), localObject3, Integer.valueOf(i) });
            com.tencent.mm.plugin.report.service.h.OAn.b(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject3, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.qBl });
            break;
          }
        }
      }
    }
    if (!localLinkedList.isEmpty())
    {
      localObject1 = new faq();
      ((faq)localObject1).aaCI = localLinkedList;
      ((faq)localObject1).scene = 1;
      localObject2 = e.opS;
      z.a(e.a.a((faq)localObject1), new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(249189);
          Log.d("MicroMsg.AppBrandNotifySettingsUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            aa.makeText(AppBrandNotifySettingsUI.this, R.l.gQH, 0).show();
            AppMethodBeat.o(249189);
            return 0;
          }
          AppBrandNotifySettingsUI.cx(localLinkedList);
          AppMethodBeat.o(249189);
          return 0;
        }
      }, true);
    }
    this.aduC.unregisterDataSetObserver(this.bxk);
    this.tYk.dead();
    super.onDestroy();
    AppMethodBeat.o(249178);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    LinkedList<a> aduH;
    LinkedList<a> aduI;
    private AppBrandNotifySettingsUI.a.b.a aduJ;
    private com.tencent.mm.modelimage.loader.a.c aduK;
    private LayoutInflater mLayoutInflater;
    
    public a(LayoutInflater paramLayoutInflater)
    {
      AppMethodBeat.i(252731);
      this.mLayoutInflater = paramLayoutInflater;
      this.aduH = new LinkedList();
      this.aduI = new LinkedList();
      this.aduJ = new AppBrandNotifySettingsUI.a.b.a()
      {
        public final void a(AppBrandNotifySettingsUI.a.a paramAnonymousa, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(250057);
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(250057);
            return;
          }
          Iterator localIterator = AppBrandNotifySettingsUI.a.a(AppBrandNotifySettingsUI.a.this).iterator();
          while (localIterator.hasNext())
          {
            AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)localIterator.next();
            if ((locala != null) && (Util.nullAsNil(locala.username).equals(paramAnonymousa.username)))
            {
              if (paramAnonymousa.aduM != paramAnonymousBoolean)
              {
                AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).add(locala);
                AppMethodBeat.o(250057);
                return;
              }
              AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).remove(locala);
              AppMethodBeat.o(250057);
              return;
            }
          }
          AppMethodBeat.o(250057);
        }
      };
      paramLayoutInflater = new c.a();
      paramLayoutInflater.nrc = true;
      paramLayoutInflater.oKF = com.tencent.mm.modelappbrand.a.a.bEX();
      this.aduK = paramLayoutInflater.bKx();
      AppMethodBeat.o(252731);
    }
    
    public final a azR(int paramInt)
    {
      AppMethodBeat.i(252744);
      a locala = (a)this.aduH.get(paramInt);
      AppMethodBeat.o(252744);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(252740);
      int i = this.aduH.size();
      AppMethodBeat.o(252740);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(252749);
      a locala = azR(paramInt);
      if (paramView == null)
      {
        paramView = this.mLayoutInflater.inflate(R.i.geo, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        paramViewGroup.lKK = ((ImageView)paramView.findViewById(R.h.avatarIv));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(R.h.titleTv));
        paramViewGroup.aduR = ((MMSwitchBtn)paramView.findViewById(R.h.frD));
        paramViewGroup.pKl = paramView.findViewById(R.h.frE);
        paramView.setTag(paramViewGroup);
        com.tencent.mm.modelimage.r.bKe().a(locala.url, paramViewGroup.lKK, this.aduK);
        paramViewGroup.titleTv.setText(locala.title);
        paramViewGroup.aduR.setCheck(locala.aduM);
        if (paramViewGroup.aduR.getTag() != null) {
          break label236;
        }
        b localb = new b((byte)0);
        localb.aduN = locala;
        localb.aduO = this.aduJ;
        paramViewGroup.aduR.setSwitchListener(localb.aduP);
        paramViewGroup.aduR.setTag(localb);
        label196:
        if (paramInt != this.aduH.size() - 1) {
          break label254;
        }
        paramViewGroup.pKl.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(252749);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        label236:
        ((b)paramViewGroup.aduR.getTag()).aduN = locala;
        break label196;
        label254:
        paramViewGroup.pKl.setVisibility(0);
      }
    }
    
    static final class a
    {
      boolean aduM;
      String title;
      String url;
      String username;
    }
    
    static final class b
    {
      AppBrandNotifySettingsUI.a.a aduN;
      a aduO;
      MMSwitchBtn.a aduP;
      
      private b()
      {
        AppMethodBeat.i(249506);
        this.aduP = new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(249465);
            if (AppBrandNotifySettingsUI.a.b.this.aduO != null) {
              AppBrandNotifySettingsUI.a.b.this.aduO.a(AppBrandNotifySettingsUI.a.b.this.aduN, paramAnonymousBoolean);
            }
            AppMethodBeat.o(249465);
          }
        };
        AppMethodBeat.o(249506);
      }
      
      public static abstract interface a
      {
        public abstract void a(AppBrandNotifySettingsUI.a.a parama, boolean paramBoolean);
      }
    }
    
    static final class c
    {
      MMSwitchBtn aduR;
      ImageView lKK;
      View pKl;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AppBrandNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */