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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private p AVf;
  private a Jfw;
  private DataSetObserver Tf;
  private MMSwitchBtn iCB;
  private ListView mListView;
  private int mMode;
  private String mSceneId;
  
  private boolean fxH()
  {
    AppMethodBeat.i(33717);
    al.a locala = al.a.Iwg;
    if (this.mMode == 1) {
      locala = al.a.Iwh;
    }
    ba.aBQ();
    boolean bool = com.tencent.mm.model.c.ajl().getBoolean(locala, true);
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
      this.iCB = ((MMSwitchBtn)findViewById(2131298255));
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
      this.Jfw = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
      this.mListView.setAdapter(this.Jfw);
      getString(2131755906);
      this.AVf = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
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
      this.Jfw.registerDataSetObserver(this.Tf);
      i = 3;
      if (this.mMode == 1) {
        i = 12;
      }
      ba.aiU().a(1145, this);
      ba.aiU().a(new r(i), 0);
      this.iCB.setCheck(fxH());
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
    ba.aiU().b(1145, this);
    final boolean bool3 = fxH();
    final boolean bool1;
    final LinkedList localLinkedList;
    Object localObject2;
    final int i;
    label72:
    label88:
    boolean bool2;
    label110:
    Object localObject1;
    if (this.iCB.KRP != bool3)
    {
      bool1 = true;
      localLinkedList = new LinkedList();
      if (bool1)
      {
        localObject2 = new dli();
        if (!this.iCB.KRP) {
          break label428;
        }
        i = 1;
        ((dli)localObject2).HzQ = i;
        if (this.mMode != 1) {
          break label433;
        }
        i = 2;
        ((dli)localObject2).nEf = i;
        localLinkedList.add(localObject2);
        if (bool3) {
          break label438;
        }
        bool2 = true;
        localObject1 = al.a.Iwg;
        if (this.mMode == 1) {
          localObject1 = al.a.Iwh;
        }
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set((al.a)localObject1, Boolean.valueOf(bool2));
        com.tencent.mm.sdk.b.a.IbL.l(new qn());
        if (this.mMode != 1) {
          break label449;
        }
        if (((dli)localObject2).HzQ != 1) {
          break label444;
        }
        i = 3;
        label178:
        ad.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(i), this.mSceneId });
        com.tencent.mm.plugin.report.service.g.yhR.f(13798, new Object[] { Integer.valueOf(i), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(bt.aQJ()) });
      }
      if (this.mMode != 1) {
        break label518;
      }
      i = 2;
      label273:
      localObject1 = this.Jfw.JfC;
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
        Object localObject3 = new dli();
        ((dli)localObject3).HzR = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((dli)localObject3).nEf = j;
        ((dli)localObject3).HzQ = 1;
        localLinkedList.add(localObject3);
        localObject3 = new xq();
        ((xq)localObject3).dLX.djX = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((xq)localObject3).dLX.action = 2;
        ((xq)localObject3).dLX.option = i;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
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
      if (((dli)localObject2).HzQ == 1) {}
      for (i = 11;; i = 10)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(13796, new Object[] { Integer.valueOf(i), "", "", Integer.valueOf(0), Long.valueOf(bt.aQJ()) });
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
      ba.aiU().a(1176, new com.tencent.mm.al.f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(33705);
          ba.aiU().b(1176, this);
          ad.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          Object localObject;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(ServiceNotifySettingsUI.this, 2131761765, 0).show();
            if (bool1)
            {
              ba.aBQ();
              com.tencent.mm.model.c.ajl().set(al.a.Iwg, Boolean.valueOf(bool3));
              com.tencent.mm.sdk.b.a.IbL.l(new qn());
            }
            paramAnonymousString = localLinkedList.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousn = (dli)paramAnonymousString.next();
              localObject = new xq();
              ((xq)localObject).dLX.djX = paramAnonymousn.HzR;
              ((xq)localObject).dLX.action = 1;
              ((xq)localObject).dLX.option = i;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            }
            AppMethodBeat.o(33705);
            return;
          }
          paramAnonymousString = com.tencent.mm.msgsubscription.storage.f.iBR;
          paramAnonymousString = com.tencent.mm.msgsubscription.storage.f.Ig("name_wxa");
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localLinkedList.size())
          {
            paramAnonymousn = (dli)localLinkedList.get(paramAnonymousInt1);
            if ((paramAnonymousString != null) && (paramAnonymousn != null) && (!bt.isNullOrNil(paramAnonymousn.HzR)))
            {
              localObject = paramAnonymousn.HzR;
              if (paramAnonymousn.HzQ != 1) {
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
      ba.aiU().a(new com.tencent.mm.modelappbrand.q(localLinkedList), 0);
    }
    this.Jfw.unregisterDataSetObserver(this.Tf);
    super.onDestroy();
    AppMethodBeat.o(33715);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(33716);
    if (this.AVf != null) {
      this.AVf.dismiss();
    }
    ad.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(this, 2131761752, 0).show();
      AppMethodBeat.o(33716);
      return;
    }
    paramString = ((r)paramn).aDN();
    if (this.mMode == 1) {
      this.iCB.setCheck(paramString.GDg);
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
            ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.GDh);
            AppMethodBeat.o(33706);
            return;
          }
          ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.FCW);
          AppMethodBeat.o(33706);
        }
      });
      AppMethodBeat.o(33716);
      return;
      this.iCB.setCheck(paramString.FCV);
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
    LinkedList<a> IST;
    private com.tencent.mm.aw.a.a.c ISW;
    LinkedList<a> JfC;
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
      this.IST = new LinkedList();
      this.JfC = new LinkedList();
      this.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33708);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
                  if ((paramAnonymous2DialogInterface != null) && (this.fNr.equals(paramAnonymous2DialogInterface.username)))
                  {
                    ServiceNotifySettingsUI.a.b(ServiceNotifySettingsUI.a.this).add(ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).remove(paramAnonymous2Int));
                    ServiceNotifySettingsUI.a.this.notifyDataSetChanged();
                    paramAnonymous2DialogInterface = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(this.fNr);
                    if (paramAnonymous2DialogInterface == null) {}
                    for (paramAnonymous2DialogInterface = ""; ServiceNotifySettingsUI.a.1.this.val$mode == 1; paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.field_appId)
                    {
                      ad.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(4), paramAnonymous2DialogInterface, ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this) });
                      com.tencent.mm.plugin.report.service.g.yhR.f(13798, new Object[] { Integer.valueOf(4), paramAnonymous2DialogInterface, Integer.valueOf(0), ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this), Long.valueOf(bt.aQJ()) });
                      AppMethodBeat.o(33707);
                      return;
                    }
                    com.tencent.mm.plugin.report.service.g.yhR.f(13796, new Object[] { Integer.valueOf(12), paramAnonymous2DialogInterface, "", Integer.valueOf(0), Long.valueOf(bt.aQJ()) });
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
      paramContext.hfi = true;
      paramContext.idH = com.tencent.mm.modelappbrand.a.a.aDU();
      this.ISW = paramContext.aJc();
      AppMethodBeat.o(33709);
    }
    
    private a abW(int paramInt)
    {
      AppMethodBeat.i(33711);
      a locala = (a)this.IST.get(paramInt);
      AppMethodBeat.o(33711);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(33710);
      int i = this.IST.size();
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
      a locala = abW(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = this.mLayoutInflater.inflate(2131495372, paramViewGroup, false);
        paramView = new b((byte)0);
        paramView.fRd = ((ImageView)localView.findViewById(2131296998));
        paramView.titleTv = ((TextView)localView.findViewById(2131305906));
        paramView.JfF = ((TextView)localView.findViewById(2131304145));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        com.tencent.mm.aw.q.aIJ().a(locala.url, paramViewGroup.fRd, this.ISW);
        paramViewGroup.titleTv.setText(locala.title);
        if (this.mMode != 1) {
          break label188;
        }
        paramViewGroup.JfF.setText(this.mContext.getString(2131761754));
      }
      for (;;)
      {
        paramViewGroup.JfF.setTag(locala.username);
        paramViewGroup.JfF.setOnClickListener(this.mOnClickListener);
        AppMethodBeat.o(33712);
        return localView;
        paramViewGroup = (b)paramView.getTag();
        localView = paramView;
        break;
        label188:
        paramViewGroup.JfF.setText(this.mContext.getString(2131761755));
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
      TextView JfF;
      ImageView fRd;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */