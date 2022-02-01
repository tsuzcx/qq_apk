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
import com.tencent.mm.g.a.qo;
import com.tencent.mm.g.a.xu;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.dmf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private p BmD;
  private a JAh;
  private DataSetObserver Tf;
  private MMSwitchBtn iFu;
  private ListView mListView;
  private int mMode;
  private String mSceneId;
  
  private boolean fBJ()
  {
    AppMethodBeat.i(33717);
    am.a locala = am.a.IQE;
    if (this.mMode == 1) {
      locala = am.a.IQF;
    }
    bc.aCg();
    boolean bool = com.tencent.mm.model.c.ajA().getBoolean(locala, true);
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
      this.iFu = ((MMSwitchBtn)findViewById(2131298255));
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
      this.JAh = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
      this.mListView.setAdapter(this.JAh);
      getString(2131755906);
      this.BmD = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(33703);
          ServiceNotifySettingsUI.this.finish();
          AppMethodBeat.o(33703);
        }
      });
      this.Tf = new DataSetObserver()
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
      this.JAh.registerDataSetObserver(this.Tf);
      i = 3;
      if (this.mMode == 1) {
        i = 12;
      }
      bc.ajj().a(1145, this);
      bc.ajj().a(new r(i), 0);
      this.iFu.setCheck(fBJ());
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
    bc.ajj().b(1145, this);
    final boolean bool3 = fBJ();
    final boolean bool1;
    final LinkedList localLinkedList;
    Object localObject2;
    final int i;
    label72:
    label88:
    boolean bool2;
    label110:
    Object localObject1;
    if (this.iFu.Lon != bool3)
    {
      bool1 = true;
      localLinkedList = new LinkedList();
      if (bool1)
      {
        localObject2 = new dmf();
        if (!this.iFu.Lon) {
          break label428;
        }
        i = 1;
        ((dmf)localObject2).HTD = i;
        if (this.mMode != 1) {
          break label433;
        }
        i = 2;
        ((dmf)localObject2).nJA = i;
        localLinkedList.add(localObject2);
        if (bool3) {
          break label438;
        }
        bool2 = true;
        localObject1 = am.a.IQE;
        if (this.mMode == 1) {
          localObject1 = am.a.IQF;
        }
        bc.aCg();
        com.tencent.mm.model.c.ajA().set((am.a)localObject1, Boolean.valueOf(bool2));
        com.tencent.mm.sdk.b.a.IvT.l(new qo());
        if (this.mMode != 1) {
          break label449;
        }
        if (((dmf)localObject2).HTD != 1) {
          break label444;
        }
        i = 3;
        label178:
        ae.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(i), this.mSceneId });
        com.tencent.mm.plugin.report.service.g.yxI.f(13798, new Object[] { Integer.valueOf(i), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(bu.aRi()) });
      }
      if (this.mMode != 1) {
        break label518;
      }
      i = 2;
      label273:
      localObject1 = this.JAh.JAn;
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
        Object localObject3 = new dmf();
        ((dmf)localObject3).HTE = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((dmf)localObject3).nJA = j;
        ((dmf)localObject3).HTD = 1;
        localLinkedList.add(localObject3);
        localObject3 = new xu();
        ((xu)localObject3).dNm.dkZ = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((xu)localObject3).dNm.action = 2;
        ((xu)localObject3).dNm.option = i;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
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
      if (((dmf)localObject2).HTD == 1) {}
      for (i = 11;; i = 10)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(13796, new Object[] { Integer.valueOf(i), "", "", Integer.valueOf(0), Long.valueOf(bu.aRi()) });
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
      bc.ajj().a(1176, new com.tencent.mm.ak.f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(33705);
          bc.ajj().b(1176, this);
          ae.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          Object localObject;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(ServiceNotifySettingsUI.this, 2131761765, 0).show();
            if (bool1)
            {
              bc.aCg();
              com.tencent.mm.model.c.ajA().set(am.a.IQE, Boolean.valueOf(bool3));
              com.tencent.mm.sdk.b.a.IvT.l(new qo());
            }
            paramAnonymousString = localLinkedList.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousn = (dmf)paramAnonymousString.next();
              localObject = new xu();
              ((xu)localObject).dNm.dkZ = paramAnonymousn.HTE;
              ((xu)localObject).dNm.action = 1;
              ((xu)localObject).dNm.option = i;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
            }
            AppMethodBeat.o(33705);
            return;
          }
          paramAnonymousString = com.tencent.mm.msgsubscription.storage.f.iEK;
          paramAnonymousString = com.tencent.mm.msgsubscription.storage.f.II("name_wxa");
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localLinkedList.size())
          {
            paramAnonymousn = (dmf)localLinkedList.get(paramAnonymousInt1);
            if ((paramAnonymousString != null) && (paramAnonymousn != null) && (!bu.isNullOrNil(paramAnonymousn.HTE)))
            {
              localObject = paramAnonymousn.HTE;
              if (paramAnonymousn.HTD != 1) {
                break label285;
              }
            }
            label285:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousString.Z((String)localObject, bool);
              paramAnonymousInt1 += 1;
              break;
            }
          }
          AppMethodBeat.o(33705);
        }
      });
      bc.ajj().a(new com.tencent.mm.modelappbrand.q(localLinkedList), 0);
    }
    this.JAh.unregisterDataSetObserver(this.Tf);
    super.onDestroy();
    AppMethodBeat.o(33715);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(33716);
    if (this.BmD != null) {
      this.BmD.dismiss();
    }
    ae.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(this, 2131761752, 0).show();
      AppMethodBeat.o(33716);
      return;
    }
    paramString = ((r)paramn).aEd();
    if (this.mMode == 1) {
      this.iFu.setCheck(paramString.GWG);
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
            ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.GWH);
            AppMethodBeat.o(33706);
            return;
          }
          ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.FVr);
          AppMethodBeat.o(33706);
        }
      });
      AppMethodBeat.o(33716);
      return;
      this.iFu.setCheck(paramString.FVq);
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
    LinkedList<a> JAn;
    LinkedList<a> JnB;
    private com.tencent.mm.av.a.a.c JnE;
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
      this.JnB = new LinkedList();
      this.JAn = new LinkedList();
      this.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33708);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = (String)paramAnonymousView.getTag();
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33708);
            return;
          }
          paramAnonymousView = paramAnonymousView.getContext();
          int i;
          if (paramInt == 1)
          {
            i = 2131761758;
            if (paramInt != 1) {
              break label154;
            }
          }
          label154:
          for (int j = 2131761759;; j = 2131755835)
          {
            h.a(paramAnonymousView, i, 0, j, 2131756766, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33707);
                paramAnonymous2Int = 0;
                while (paramAnonymous2Int < ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).size())
                {
                  paramAnonymous2DialogInterface = (ServiceNotifySettingsUI.a.a)ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).get(paramAnonymous2Int);
                  if ((paramAnonymous2DialogInterface != null) && (this.fOj.equals(paramAnonymous2DialogInterface.username)))
                  {
                    ServiceNotifySettingsUI.a.b(ServiceNotifySettingsUI.a.this).add(ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).remove(paramAnonymous2Int));
                    ServiceNotifySettingsUI.a.this.notifyDataSetChanged();
                    paramAnonymous2DialogInterface = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(this.fOj);
                    if (paramAnonymous2DialogInterface == null) {}
                    for (paramAnonymous2DialogInterface = ""; ServiceNotifySettingsUI.a.1.this.val$mode == 1; paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.field_appId)
                    {
                      ae.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(4), paramAnonymous2DialogInterface, ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this) });
                      com.tencent.mm.plugin.report.service.g.yxI.f(13798, new Object[] { Integer.valueOf(4), paramAnonymous2DialogInterface, Integer.valueOf(0), ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this), Long.valueOf(bu.aRi()) });
                      AppMethodBeat.o(33707);
                      return;
                    }
                    com.tencent.mm.plugin.report.service.g.yxI.f(13796, new Object[] { Integer.valueOf(12), paramAnonymous2DialogInterface, "", Integer.valueOf(0), Long.valueOf(bu.aRi()) });
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
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33708);
            return;
            i = 2131761762;
            break;
          }
        }
      };
      paramContext = new c.a();
      paramContext.hhW = true;
      paramContext.igz = com.tencent.mm.modelappbrand.a.a.aEk();
      this.JnE = paramContext.aJu();
      AppMethodBeat.o(33709);
    }
    
    private a acE(int paramInt)
    {
      AppMethodBeat.i(33711);
      a locala = (a)this.JnB.get(paramInt);
      AppMethodBeat.o(33711);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(33710);
      int i = this.JnB.size();
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
      a locala = acE(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = this.mLayoutInflater.inflate(2131495372, paramViewGroup, false);
        paramView = new b((byte)0);
        paramView.fTj = ((ImageView)localView.findViewById(2131296998));
        paramView.titleTv = ((TextView)localView.findViewById(2131305906));
        paramView.JAq = ((TextView)localView.findViewById(2131304145));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        com.tencent.mm.av.q.aJb().a(locala.url, paramViewGroup.fTj, this.JnE);
        paramViewGroup.titleTv.setText(locala.title);
        if (this.mMode != 1) {
          break label188;
        }
        paramViewGroup.JAq.setText(this.mContext.getString(2131761754));
      }
      for (;;)
      {
        paramViewGroup.JAq.setTag(locala.username);
        paramViewGroup.JAq.setOnClickListener(this.mOnClickListener);
        AppMethodBeat.o(33712);
        return localView;
        paramViewGroup = (b)paramView.getTag();
        localView = paramView;
        break;
        label188:
        paramViewGroup.JAq.setText(this.mContext.getString(2131761755));
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
      TextView JAq;
      ImageView fTj;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */