package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.model.az;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.msgsubscription.storage.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private a FSb;
  private DataSetObserver Qv;
  private MMSwitchBtn hII;
  private ListView mListView;
  private int mMode;
  private String mSceneId;
  private p yqi;
  
  private boolean eRK()
  {
    AppMethodBeat.i(33717);
    ae.a locala = ae.a.FlZ;
    if (this.mMode == 1) {
      locala = ae.a.Fma;
    }
    az.arV();
    boolean bool = com.tencent.mm.model.c.afk().getBoolean(locala, true);
    AppMethodBeat.o(33717);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return 2131495373;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33714);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.mMode = paramBundle.getIntExtra("mode", 0);
    this.mSceneId = paramBundle.getStringExtra("scene_id");
    paramBundle.putExtra("scene_id", this.mSceneId);
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle))
    {
      setMMTitle(2131761774);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(33702);
          ServiceNotifySettingsUI.this.finish();
          AppMethodBeat.o(33702);
          return false;
        }
      });
      this.hII = ((MMSwitchBtn)findViewById(2131298255));
      this.mListView = ((ListView)findViewById(2131301457));
      paramBundle = (TextView)findViewById(2131301445);
      if (this.mMode != 1) {
        break label309;
      }
      i = 2131761746;
      label126:
      paramBundle.setText(i);
      paramBundle = (TextView)findViewById(2131305897);
      if (this.mMode != 1) {
        break label316;
      }
    }
    label309:
    label316:
    for (int i = 2131761747;; i = 2131761749)
    {
      paramBundle.setText(i);
      this.FSb = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
      this.mListView.setAdapter(this.FSb);
      getString(2131755906);
      this.yqi = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(33703);
          ServiceNotifySettingsUI.this.finish();
          AppMethodBeat.o(33703);
        }
      });
      this.Qv = new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(33704);
          View localView = ServiceNotifySettingsUI.this.findViewById(2131301445);
          if (ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            AppMethodBeat.o(33704);
            return;
          }
        }
      };
      this.FSb.registerDataSetObserver(this.Qv);
      i = 3;
      if (this.mMode == 1) {
        i = 12;
      }
      az.aeS().a(1145, this);
      az.aeS().a(new r(i), 0);
      this.hII.setCheck(eRK());
      AppMethodBeat.o(33714);
      return;
      setMMTitle(paramBundle);
      break;
      i = 2131761737;
      break label126;
    }
  }
  
  public void onDestroy()
  {
    int j = 3;
    AppMethodBeat.i(33715);
    az.aeS().b(1145, this);
    final boolean bool3 = eRK();
    final boolean bool1;
    final LinkedList localLinkedList;
    Object localObject2;
    final int i;
    label72:
    label88:
    boolean bool2;
    label110:
    Object localObject1;
    if (this.hII.HAh != bool3)
    {
      bool1 = true;
      localLinkedList = new LinkedList();
      if (bool1)
      {
        localObject2 = new daj();
        if (!this.hII.HAh) {
          break label428;
        }
        i = 1;
        ((daj)localObject2).Esd = i;
        if (this.mMode != 1) {
          break label433;
        }
        i = 2;
        ((daj)localObject2).mBH = i;
        localLinkedList.add(localObject2);
        if (bool3) {
          break label438;
        }
        bool2 = true;
        localObject1 = ae.a.FlZ;
        if (this.mMode == 1) {
          localObject1 = ae.a.Fma;
        }
        az.arV();
        com.tencent.mm.model.c.afk().set((ae.a)localObject1, Boolean.valueOf(bool2));
        com.tencent.mm.sdk.b.a.ESL.l(new pt());
        if (this.mMode != 1) {
          break label449;
        }
        if (((daj)localObject2).Esd != 1) {
          break label444;
        }
        i = 3;
        label178:
        ad.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(i), this.mSceneId });
        com.tencent.mm.plugin.report.service.h.vKh.f(13798, new Object[] { Integer.valueOf(i), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(bt.aGK()) });
      }
      if (this.mMode != 1) {
        break label518;
      }
      i = 2;
      label273:
      localObject1 = this.FSb.FSh;
      if ((localObject1 == null) || (((LinkedList)localObject1).isEmpty())) {
        break label528;
      }
      if (this.mMode != 1) {
        break label523;
      }
    }
    for (;;)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ServiceNotifySettingsUI.a.a)((Iterator)localObject1).next();
        Object localObject3 = new daj();
        ((daj)localObject3).Ese = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((daj)localObject3).mBH = j;
        ((daj)localObject3).Esd = 1;
        localLinkedList.add(localObject3);
        localObject3 = new wm();
        ((wm)localObject3).dBX.dbj = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((wm)localObject3).dBX.action = 2;
        ((wm)localObject3).dBX.option = i;
        com.tencent.mm.sdk.b.a.ESL.l((b)localObject3);
      }
      bool1 = false;
      break;
      label428:
      i = 0;
      break label72;
      label433:
      i = 0;
      break label88;
      label438:
      bool2 = false;
      break label110;
      label444:
      i = 2;
      break label178;
      label449:
      if (((daj)localObject2).Esd == 1) {}
      for (i = 11;; i = 10)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(13796, new Object[] { Integer.valueOf(i), "", "", Integer.valueOf(0), Long.valueOf(bt.aGK()) });
        break;
      }
      label518:
      i = 1;
      break label273;
      label523:
      j = 1;
    }
    label528:
    if (!localLinkedList.isEmpty())
    {
      az.aeS().a(1176, new com.tencent.mm.al.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(33705);
          az.aeS().b(1176, this);
          ad.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          Object localObject;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(ServiceNotifySettingsUI.this, 2131761765, 0).show();
            if (bool1)
            {
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FlZ, Boolean.valueOf(bool3));
              com.tencent.mm.sdk.b.a.ESL.l(new pt());
            }
            paramAnonymousString = localLinkedList.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousn = (daj)paramAnonymousString.next();
              localObject = new wm();
              ((wm)localObject).dBX.dbj = paramAnonymousn.Ese;
              ((wm)localObject).dBX.action = 1;
              ((wm)localObject).dBX.option = i;
              com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
            }
            AppMethodBeat.o(33705);
            return;
          }
          paramAnonymousString = f.hHV;
          paramAnonymousString = f.AN("name_wxa");
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localLinkedList.size())
          {
            paramAnonymousn = (daj)localLinkedList.get(paramAnonymousInt1);
            if ((paramAnonymousString != null) && (paramAnonymousn != null) && (!bt.isNullOrNil(paramAnonymousn.Ese)))
            {
              localObject = paramAnonymousn.Ese;
              if (paramAnonymousn.Esd != 1) {
                break label285;
              }
            }
            label285:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousString.Y((String)localObject, bool);
              paramAnonymousInt1 += 1;
              break;
            }
          }
          AppMethodBeat.o(33705);
        }
      });
      az.aeS().a(new com.tencent.mm.modelappbrand.q(localLinkedList), 0);
    }
    this.FSb.unregisterDataSetObserver(this.Qv);
    super.onDestroy();
    AppMethodBeat.o(33715);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(33716);
    if (this.yqi != null) {
      this.yqi.dismiss();
    }
    ad.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(this, 2131761752, 0).show();
      AppMethodBeat.o(33716);
      return;
    }
    paramString = ((r)paramn).atT();
    if (this.mMode == 1) {
      this.hII.setCheck(paramString.Dyn);
    }
    for (;;)
    {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33706);
          if (ServiceNotifySettingsUI.b(ServiceNotifySettingsUI.this) == 1)
          {
            ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.Dyo);
            AppMethodBeat.o(33706);
            return;
          }
          ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.CFa);
          AppMethodBeat.o(33706);
        }
      });
      AppMethodBeat.o(33716);
      return;
      this.hII.setCheck(paramString.CEZ);
    }
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
    private com.tencent.mm.aw.a.a.c FGx;
    LinkedList<a> FSh;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int mMode;
    private View.OnClickListener mOnClickListener;
    private String mSceneId;
    
    public a(Context paramContext, LayoutInflater paramLayoutInflater, final int paramInt, String paramString)
    {
      AppMethodBeat.i(33709);
      this.mContext = paramContext;
      this.mMode = paramInt;
      this.mSceneId = paramString;
      this.mLayoutInflater = paramLayoutInflater;
      this.FGu = new LinkedList();
      this.FSh = new LinkedList();
      this.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33708);
          final String str = (String)paramAnonymousView.getTag();
          if (TextUtils.isEmpty(str))
          {
            AppMethodBeat.o(33708);
            return;
          }
          paramAnonymousView = paramAnonymousView.getContext();
          int i;
          if (paramInt == 1)
          {
            i = 2131761758;
            if (paramInt != 1) {
              break label98;
            }
          }
          label98:
          for (int j = 2131761759;; j = 2131755835)
          {
            com.tencent.mm.ui.base.h.a(paramAnonymousView, i, 0, j, 2131756766, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33707);
                paramAnonymous2Int = 0;
                while (paramAnonymous2Int < ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).size())
                {
                  paramAnonymous2DialogInterface = (ServiceNotifySettingsUI.a.a)ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).get(paramAnonymous2Int);
                  if ((paramAnonymous2DialogInterface != null) && (str.equals(paramAnonymous2DialogInterface.username)))
                  {
                    ServiceNotifySettingsUI.a.b(ServiceNotifySettingsUI.a.this).add(ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).remove(paramAnonymous2Int));
                    ServiceNotifySettingsUI.a.this.notifyDataSetChanged();
                    paramAnonymous2DialogInterface = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW(str);
                    if (paramAnonymous2DialogInterface == null) {}
                    for (paramAnonymous2DialogInterface = ""; ServiceNotifySettingsUI.a.1.this.val$mode == 1; paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.field_appId)
                    {
                      ad.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(4), paramAnonymous2DialogInterface, ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this) });
                      com.tencent.mm.plugin.report.service.h.vKh.f(13798, new Object[] { Integer.valueOf(4), paramAnonymous2DialogInterface, Integer.valueOf(0), ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this), Long.valueOf(bt.aGK()) });
                      AppMethodBeat.o(33707);
                      return;
                    }
                    com.tencent.mm.plugin.report.service.h.vKh.f(13796, new Object[] { Integer.valueOf(12), paramAnonymous2DialogInterface, "", Integer.valueOf(0), Long.valueOf(bt.aGK()) });
                    AppMethodBeat.o(33707);
                    return;
                  }
                  paramAnonymous2Int += 1;
                }
                AppMethodBeat.o(33707);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            }, 2131100464);
            AppMethodBeat.o(33708);
            return;
            i = 2131761762;
            break;
          }
        }
      };
      paramContext = new c.a();
      paramContext.gkG = true;
      paramContext.hkj = com.tencent.mm.modelappbrand.a.a.aua();
      this.FGx = paramContext.azc();
      AppMethodBeat.o(33709);
    }
    
    private a XB(int paramInt)
    {
      AppMethodBeat.i(33711);
      a locala = (a)this.FGu.get(paramInt);
      AppMethodBeat.o(33711);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(33710);
      int i = this.FGu.size();
      AppMethodBeat.o(33710);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(33712);
      a locala = XB(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = this.mLayoutInflater.inflate(2131495372, paramViewGroup, false);
        paramView = new b((byte)0);
        paramView.fuj = ((ImageView)localView.findViewById(2131296998));
        paramView.titleTv = ((TextView)localView.findViewById(2131305906));
        paramView.FSk = ((TextView)localView.findViewById(2131304145));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        o.ayJ().a(locala.url, paramViewGroup.fuj, this.FGx);
        paramViewGroup.titleTv.setText(locala.title);
        if (this.mMode != 1) {
          break label188;
        }
        paramViewGroup.FSk.setText(this.mContext.getString(2131761754));
      }
      for (;;)
      {
        paramViewGroup.FSk.setTag(locala.username);
        paramViewGroup.FSk.setOnClickListener(this.mOnClickListener);
        AppMethodBeat.o(33712);
        return localView;
        paramViewGroup = (b)paramView.getTag();
        localView = paramView;
        break;
        label188:
        paramViewGroup.FSk.setText(this.mContext.getString(2131761755));
      }
    }
    
    static final class a
    {
      String title;
      String url;
      String username;
    }
    
    static final class b
    {
      TextView FSk;
      ImageView fuj;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */