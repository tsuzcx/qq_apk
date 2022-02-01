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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.av.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.protocal.protobuf.bhq;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.ebk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.Iterator;
import java.util.LinkedList;

public class AppBrandNotifySettingsUI
  extends MMActivity
{
  private a Hfx;
  private DataSetObserver Rq;
  private String jjx;
  private ListView mListView;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.n> mag;
  private int pFC;
  private p zDG;
  
  public AppBrandNotifySettingsUI()
  {
    AppMethodBeat.i(196250);
    this.mag = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(196250);
  }
  
  protected int getLayoutId()
  {
    return 2131493100;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(196251);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.jjx = paramBundle.getStringExtra("report_session_id");
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
          AppMethodBeat.i(196236);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(196236);
          return false;
        }
      });
      this.mListView = ((ListView)findViewById(2131301457));
      this.Hfx = new a(getLayoutInflater());
      this.mListView.setAdapter(this.Hfx);
      getString(2131755906);
      this.zDG = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(196237);
          AppBrandNotifySettingsUI.this.finish();
          AppMethodBeat.o(196237);
        }
      });
      this.Rq = new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(196238);
          View localView = AppBrandNotifySettingsUI.this.findViewById(2131301445);
          if (AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            AppMethodBeat.o(196238);
            return;
          }
        }
      };
      this.Hfx.registerDataSetObserver(this.Rq);
      g.agP();
      this.pFC = com.tencent.mm.kernel.a.getUin();
      paramBundle = com.tencent.mm.modelappbrand.c.hrX;
      x.a(com.tencent.mm.modelappbrand.c.a.aAz(), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, b paramAnonymousb, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(196241);
          ac.d("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if (AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this) != null) {
            AppBrandNotifySettingsUI.b(AppBrandNotifySettingsUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(AppBrandNotifySettingsUI.this, 2131761752, 0).show();
            AppMethodBeat.o(196241);
            return 0;
          }
          paramAnonymousString = (bhq)paramAnonymousb.hvs.hvw;
          if (paramAnonymousString.EXa == null)
          {
            ac.e("MicroMsg.AppBrandNotifySettingsUI", "wxa_msg_config_list not exist");
            AppMethodBeat.o(196241);
            return 0;
          }
          AppBrandNotifySettingsUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(196240);
              if (paramAnonymousString.EXa == null)
              {
                ac.i("MicroMsg.AppBrandNotifySettingsUI", "getNotifyMsgInfo, configList is null");
                AppMethodBeat.o(196240);
                return;
              }
              AppBrandNotifySettingsUI.a(AppBrandNotifySettingsUI.this, paramAnonymousString.EXa);
              AppBrandNotifySettingsUI.bn(paramAnonymousString.EXa);
              AppMethodBeat.o(196240);
            }
          });
          AppMethodBeat.o(196241);
          return 0;
        }
      }, true, this);
      com.tencent.mm.sdk.b.a.GpY.c(this.mag);
      AppMethodBeat.o(196251);
      return;
      setMMTitle(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(196252);
    Object localObject1 = (m)g.ab(m.class);
    final LinkedList localLinkedList = new LinkedList();
    Object localObject2 = this.Hfx.HfD;
    if ((localObject2 != null) && (!((LinkedList)localObject2).isEmpty()))
    {
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)((Iterator)localObject2).next();
        ebk localebk = new ebk();
        Object localObject3 = ((m)localObject1).Ka(locala.username);
        if (localObject3 == null)
        {
          ac.i("MicroMsg.AppBrandNotifySettingsUI", "get attribute fail, username: %s", new Object[] { locala.username });
        }
        else
        {
          localObject3 = ((WxaAttributes)localObject3).field_appId;
          if (locala.HfH) {}
          for (int i = 1;; i = 0)
          {
            localebk.djj = ((String)localObject3);
            localebk.status = i;
            localLinkedList.add(localebk);
            ac.d("MicroMsg.AppBrandNotifySettingsUI", "stev report(%s), eventId : %d, appId %s, status %d", new Object[] { Integer.valueOf(19724), Integer.valueOf(5), localObject3, Integer.valueOf(i) });
            com.tencent.mm.plugin.report.service.h.wUl.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localObject3, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.jjx });
            break;
          }
        }
      }
    }
    if (!localLinkedList.isEmpty())
    {
      localObject1 = new cxf();
      ((cxf)localObject1).EXa = localLinkedList;
      ((cxf)localObject1).scene = 1;
      localObject2 = d.hrY;
      x.a(d.a.a((cxf)localObject1), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(196239);
          ac.d("MicroMsg.AppBrandNotifySettingsUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(AppBrandNotifySettingsUI.this, 2131761765, 0).show();
            AppMethodBeat.o(196239);
            return 0;
          }
          AppBrandNotifySettingsUI.bn(localLinkedList);
          AppMethodBeat.o(196239);
          return 0;
        }
      }, true);
    }
    this.Hfx.unregisterDataSetObserver(this.Rq);
    com.tencent.mm.sdk.b.a.GpY.d(this.mag);
    super.onDestroy();
    AppMethodBeat.o(196252);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    LinkedList<a> HfC;
    LinkedList<a> HfD;
    private AppBrandNotifySettingsUI.a.b.a HfE;
    private com.tencent.mm.av.a.a.c HfF;
    private LayoutInflater mLayoutInflater;
    
    public a(LayoutInflater paramLayoutInflater)
    {
      AppMethodBeat.i(196245);
      this.mLayoutInflater = paramLayoutInflater;
      this.HfC = new LinkedList();
      this.HfD = new LinkedList();
      this.HfE = new AppBrandNotifySettingsUI.a.b.a()
      {
        public final void a(AppBrandNotifySettingsUI.a.a paramAnonymousa, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(196242);
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(196242);
            return;
          }
          Iterator localIterator = AppBrandNotifySettingsUI.a.a(AppBrandNotifySettingsUI.a.this).iterator();
          while (localIterator.hasNext())
          {
            AppBrandNotifySettingsUI.a.a locala = (AppBrandNotifySettingsUI.a.a)localIterator.next();
            if ((locala != null) && (bs.nullAsNil(locala.username).equals(paramAnonymousa.username)))
            {
              if (paramAnonymousa.HfH != paramAnonymousBoolean)
              {
                AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).add(locala);
                AppMethodBeat.o(196242);
                return;
              }
              AppBrandNotifySettingsUI.a.b(AppBrandNotifySettingsUI.a.this).remove(locala);
              AppMethodBeat.o(196242);
              return;
            }
          }
          AppMethodBeat.o(196242);
        }
      };
      paramLayoutInflater = new com.tencent.mm.av.a.a.c.a();
      paramLayoutInflater.gLt = true;
      paramLayoutInflater.hKM = com.tencent.mm.modelappbrand.a.a.aAR();
      this.HfF = paramLayoutInflater.aFT();
      AppMethodBeat.o(196245);
    }
    
    public final a Zi(int paramInt)
    {
      AppMethodBeat.i(196247);
      a locala = (a)this.HfC.get(paramInt);
      AppMethodBeat.o(196247);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(196246);
      int i = this.HfC.size();
      AppMethodBeat.o(196246);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(196248);
      a locala = Zi(paramInt);
      if (paramView == null)
      {
        paramView = this.mLayoutInflater.inflate(2131493101, paramViewGroup, false);
        paramViewGroup = new c((byte)0);
        paramViewGroup.fxQ = ((ImageView)paramView.findViewById(2131296998));
        paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131305906));
        paramViewGroup.HfM = ((MMSwitchBtn)paramView.findViewById(2131296893));
        paramViewGroup.iCJ = paramView.findViewById(2131296895);
        paramView.setTag(paramViewGroup);
        o.aFB().a(locala.url, paramViewGroup.fxQ, this.HfF);
        paramViewGroup.titleTv.setText(locala.title);
        paramViewGroup.HfM.setCheck(locala.HfH);
        if (paramViewGroup.HfM.getTag() != null) {
          break label231;
        }
        b localb = new b((byte)0);
        localb.HfI = locala;
        localb.HfJ = this.HfE;
        paramViewGroup.HfM.setSwitchListener(localb.HfK);
        paramViewGroup.HfM.setTag(localb);
        label191:
        if (paramInt != this.HfC.size() - 1) {
          break label249;
        }
        paramViewGroup.iCJ.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(196248);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        label231:
        ((b)paramViewGroup.HfM.getTag()).HfI = locala;
        break label191;
        label249:
        paramViewGroup.iCJ.setVisibility(0);
      }
    }
    
    static final class a
    {
      boolean HfH;
      String title;
      String url;
      String username;
    }
    
    static final class b
    {
      AppBrandNotifySettingsUI.a.a HfI;
      a HfJ;
      MMSwitchBtn.a HfK;
      
      private b()
      {
        AppMethodBeat.i(196244);
        this.HfK = new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(196243);
            if (AppBrandNotifySettingsUI.a.b.this.HfJ != null) {
              AppBrandNotifySettingsUI.a.b.this.HfJ.a(AppBrandNotifySettingsUI.a.b.this.HfI, paramAnonymousBoolean);
            }
            AppMethodBeat.o(196243);
          }
        };
        AppMethodBeat.o(196244);
      }
      
      public static abstract interface a
      {
        public abstract void a(AppBrandNotifySettingsUI.a.a parama, boolean paramBoolean);
      }
    }
    
    static final class c
    {
      MMSwitchBtn HfM;
      ImageView fxQ;
      View iCJ;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AppBrandNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */