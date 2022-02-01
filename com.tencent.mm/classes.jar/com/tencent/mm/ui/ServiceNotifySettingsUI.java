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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.wx;
import com.tencent.mm.model.az;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private a HrQ;
  private DataSetObserver Rq;
  private MMSwitchBtn ijk;
  private ListView mListView;
  private int mMode;
  private String mSceneId;
  private p zDG;
  
  private boolean fhu()
  {
    AppMethodBeat.i(33717);
    ah.a locala = ah.a.GJO;
    if (this.mMode == 1) {
      locala = ah.a.GJP;
    }
    az.ayM();
    boolean bool = com.tencent.mm.model.c.agA().getBoolean(locala, true);
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
      this.ijk = ((MMSwitchBtn)findViewById(2131298255));
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
      this.HrQ = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
      this.mListView.setAdapter(this.HrQ);
      getString(2131755906);
      this.zDG = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(33703);
          ServiceNotifySettingsUI.this.finish();
          AppMethodBeat.o(33703);
        }
      });
      this.Rq = new DataSetObserver()
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
      this.HrQ.registerDataSetObserver(this.Rq);
      i = 3;
      if (this.mMode == 1) {
        i = 12;
      }
      az.agi().a(1145, this);
      az.agi().a(new r(i), 0);
      this.ijk.setCheck(fhu());
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
    az.agi().b(1145, this);
    boolean bool3 = fhu();
    boolean bool1;
    LinkedList localLinkedList;
    Object localObject2;
    int i;
    label72:
    label88:
    boolean bool2;
    label110:
    Object localObject1;
    if (this.ijk.JaE != bool3)
    {
      bool1 = true;
      localLinkedList = new LinkedList();
      if (bool1)
      {
        localObject2 = new dfv();
        if (!this.ijk.JaE) {
          break label428;
        }
        i = 1;
        ((dfv)localObject2).FPf = i;
        if (this.mMode != 1) {
          break label433;
        }
        i = 2;
        ((dfv)localObject2).ndI = i;
        localLinkedList.add(localObject2);
        if (bool3) {
          break label438;
        }
        bool2 = true;
        localObject1 = ah.a.GJO;
        if (this.mMode == 1) {
          localObject1 = ah.a.GJP;
        }
        az.ayM();
        com.tencent.mm.model.c.agA().set((ah.a)localObject1, Boolean.valueOf(bool2));
        com.tencent.mm.sdk.b.a.GpY.l(new qc());
        if (this.mMode != 1) {
          break label449;
        }
        if (((dfv)localObject2).FPf != 1) {
          break label444;
        }
        i = 3;
        label178:
        ac.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(i), this.mSceneId });
        com.tencent.mm.plugin.report.service.h.wUl.f(13798, new Object[] { Integer.valueOf(i), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(bs.aNx()) });
      }
      if (this.mMode != 1) {
        break label518;
      }
      i = 2;
      label273:
      localObject1 = this.HrQ.HrW;
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
        Object localObject3 = new dfv();
        ((dfv)localObject3).FPg = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((dfv)localObject3).ndI = j;
        ((dfv)localObject3).FPf = 1;
        localLinkedList.add(localObject3);
        localObject3 = new wx();
        ((wx)localObject3).dzL.cYF = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((wx)localObject3).dzL.action = 2;
        ((wx)localObject3).dzL.option = i;
        com.tencent.mm.sdk.b.a.GpY.l((b)localObject3);
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
      if (((dfv)localObject2).FPf == 1) {}
      for (i = 11;; i = 10)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(13796, new Object[] { Integer.valueOf(i), "", "", Integer.valueOf(0), Long.valueOf(bs.aNx()) });
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
      az.agi().a(1176, new ServiceNotifySettingsUI.4(this, bool1, bool3, localLinkedList, i));
      az.agi().a(new com.tencent.mm.modelappbrand.q(localLinkedList), 0);
    }
    this.HrQ.unregisterDataSetObserver(this.Rq);
    super.onDestroy();
    AppMethodBeat.o(33715);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(33716);
    if (this.zDG != null) {
      this.zDG.dismiss();
    }
    ac.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(this, 2131761752, 0).show();
      AppMethodBeat.o(33716);
      return;
    }
    paramString = ((r)paramn).aAK();
    if (this.mMode == 1) {
      this.ijk.setCheck(paramString.ETJ);
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
            ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.ETK);
            AppMethodBeat.o(33706);
            return;
          }
          ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.DXA);
          AppMethodBeat.o(33706);
        }
      });
      AppMethodBeat.o(33716);
      return;
      this.ijk.setCheck(paramString.DXz);
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
    LinkedList<a> HfC;
    private com.tencent.mm.av.a.a.c HfF;
    LinkedList<a> HrW;
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
      this.HfC = new LinkedList();
      this.HrW = new LinkedList();
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
                    paramAnonymous2DialogInterface = ((m)com.tencent.mm.kernel.g.ab(m.class)).Ka(str);
                    if (paramAnonymous2DialogInterface == null) {}
                    for (paramAnonymous2DialogInterface = ""; ServiceNotifySettingsUI.a.1.this.val$mode == 1; paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.field_appId)
                    {
                      ac.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(4), paramAnonymous2DialogInterface, ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this) });
                      com.tencent.mm.plugin.report.service.h.wUl.f(13798, new Object[] { Integer.valueOf(4), paramAnonymous2DialogInterface, Integer.valueOf(0), ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this), Long.valueOf(bs.aNx()) });
                      AppMethodBeat.o(33707);
                      return;
                    }
                    com.tencent.mm.plugin.report.service.h.wUl.f(13796, new Object[] { Integer.valueOf(12), paramAnonymous2DialogInterface, "", Integer.valueOf(0), Long.valueOf(bs.aNx()) });
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
      paramContext.gLt = true;
      paramContext.hKM = com.tencent.mm.modelappbrand.a.a.aAR();
      this.HfF = paramContext.aFT();
      AppMethodBeat.o(33709);
    }
    
    private a ZM(int paramInt)
    {
      AppMethodBeat.i(33711);
      a locala = (a)this.HfC.get(paramInt);
      AppMethodBeat.o(33711);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(33710);
      int i = this.HfC.size();
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
      a locala = ZM(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = this.mLayoutInflater.inflate(2131495372, paramViewGroup, false);
        paramView = new b((byte)0);
        paramView.fxQ = ((ImageView)localView.findViewById(2131296998));
        paramView.titleTv = ((TextView)localView.findViewById(2131305906));
        paramView.HrZ = ((TextView)localView.findViewById(2131304145));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        o.aFB().a(locala.url, paramViewGroup.fxQ, this.HfF);
        paramViewGroup.titleTv.setText(locala.title);
        if (this.mMode != 1) {
          break label188;
        }
        paramViewGroup.HrZ.setText(this.mContext.getString(2131761754));
      }
      for (;;)
      {
        paramViewGroup.HrZ.setTag(locala.username);
        paramViewGroup.HrZ.setOnClickListener(this.mOnClickListener);
        AppMethodBeat.o(33712);
        return localView;
        paramViewGroup = (b)paramView.getTag();
        localView = paramView;
        break;
        label188:
        paramViewGroup.HrZ.setText(this.mContext.getString(2131761755));
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
      TextView HrZ;
      ImageView fxQ;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */