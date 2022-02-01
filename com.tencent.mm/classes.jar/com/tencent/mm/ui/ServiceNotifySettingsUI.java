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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI
  extends MMActivity
  implements i
{
  private com.tencent.mm.ui.base.q Fxt;
  private a OKI;
  private String OKJ;
  private DataSetObserver Tr;
  private MMSwitchBtn jBx;
  private ListView mListView;
  private int mMode;
  private String mSceneId;
  
  private boolean gJC()
  {
    AppMethodBeat.i(33717);
    ar.a locala = ar.a.NYF;
    if (this.mMode == 1) {
      locala = ar.a.NYG;
    }
    bg.aVF();
    boolean bool = com.tencent.mm.model.c.azQ().getBoolean(locala, true);
    AppMethodBeat.o(33717);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return 2131496234;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33714);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.mMode = paramBundle.getIntExtra("mode", 0);
    this.mSceneId = paramBundle.getStringExtra("scene_id");
    this.OKJ = paramBundle.getStringExtra("from_scene");
    paramBundle.putExtra("scene_id", this.mSceneId);
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle))
    {
      setMMTitle(2131763744);
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
      this.jBx = ((MMSwitchBtn)findViewById(2131298639));
      this.mListView = ((ListView)findViewById(2131303242));
      paramBundle = (TextView)findViewById(2131303228);
      if (this.mMode != 1) {
        break label317;
      }
      i = 2131763715;
      label136:
      paramBundle.setText(i);
      paramBundle = (TextView)findViewById(2131309188);
      if (this.mMode != 1) {
        break label324;
      }
    }
    label317:
    label324:
    for (int i = 2131763716;; i = 2131763718)
    {
      paramBundle.setText(i);
      this.OKI = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
      this.mListView.setAdapter(this.OKI);
      this.Tr = new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(232711);
          View localView = ServiceNotifySettingsUI.this.findViewById(2131303228);
          if (ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            AppMethodBeat.o(232711);
            return;
          }
        }
      };
      this.OKI.registerDataSetObserver(this.Tr);
      if (this.mMode == 1)
      {
        bg.azz().a(1145, this);
        bg.azz().a(new r(12), 0);
        getString(2131755998);
        this.Fxt = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(232712);
            ServiceNotifySettingsUI.this.finish();
            AppMethodBeat.o(232712);
          }
        });
      }
      this.jBx.setCheck(gJC());
      AppMethodBeat.o(33714);
      return;
      setMMTitle(paramBundle);
      break;
      i = 2131763706;
      break label136;
    }
  }
  
  public void onDestroy()
  {
    int j = 3;
    AppMethodBeat.i(33715);
    bg.azz().b(1145, this);
    final boolean bool3 = gJC();
    final boolean bool1;
    final LinkedList localLinkedList;
    Object localObject2;
    final int i;
    label72:
    label88:
    boolean bool2;
    label110:
    Object localObject1;
    if (this.jBx.QDw != bool3)
    {
      bool1 = true;
      localLinkedList = new LinkedList();
      if (bool1)
      {
        localObject2 = new eft();
        if (!this.jBx.QDw) {
          break label526;
        }
        i = 1;
        ((eft)localObject2).NfL = i;
        if (this.mMode != 1) {
          break label531;
        }
        i = 2;
        ((eft)localObject2).oUv = i;
        localLinkedList.add(localObject2);
        if (bool3) {
          break label536;
        }
        bool2 = true;
        localObject1 = ar.a.NYF;
        if (this.mMode == 1) {
          localObject1 = ar.a.NYG;
        }
        bg.aVF();
        com.tencent.mm.model.c.azQ().set((ar.a)localObject1, Boolean.valueOf(bool2));
        EventCenter.instance.publish(new ri());
        if (this.mMode != 1) {
          break label547;
        }
        if (((eft)localObject2).NfL != 1) {
          break label542;
        }
        i = 3;
        label178:
        Log.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(i), this.mSceneId });
        com.tencent.mm.plugin.report.service.h.CyF.a(13798, new Object[] { Integer.valueOf(i), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(Util.nowSecond()) });
        if ("scene_service_notify_conversation".equals(this.OKJ))
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
          long l = Util.nowSecond();
          if (!this.jBx.QDw) {
            break label616;
          }
          i = 1;
          label298:
          ((com.tencent.mm.plugin.report.service.h)localObject1).a(21825, new Object[] { Integer.valueOf(3), null, Long.valueOf(l), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
        }
      }
      if (this.mMode != 1) {
        break label621;
      }
      i = 2;
      label371:
      localObject1 = this.OKI.OKP;
      if ((localObject1 == null) || (((LinkedList)localObject1).isEmpty())) {
        break label631;
      }
      if (this.mMode != 1) {
        break label626;
      }
    }
    for (;;)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ServiceNotifySettingsUI.a.a)((Iterator)localObject1).next();
        Object localObject3 = new eft();
        ((eft)localObject3).NfM = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((eft)localObject3).oUv = j;
        ((eft)localObject3).NfL = 1;
        localLinkedList.add(localObject3);
        localObject3 = new yw();
        ((yw)localObject3).efe.dCl = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((yw)localObject3).efe.action = 2;
        ((yw)localObject3).efe.option = i;
        EventCenter.instance.publish((IEvent)localObject3);
      }
      bool1 = false;
      break;
      label526:
      i = 0;
      break label72;
      label531:
      i = 0;
      break label88;
      label536:
      bool2 = false;
      break label110;
      label542:
      i = 2;
      break label178;
      label547:
      if (((eft)localObject2).NfL == 1) {}
      for (i = 11;; i = 10)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(13796, new Object[] { Integer.valueOf(i), "", "", Integer.valueOf(0), Long.valueOf(Util.nowSecond()) });
        break;
      }
      label616:
      i = 2;
      break label298;
      label621:
      i = 1;
      break label371;
      label626:
      j = 1;
    }
    label631:
    if (!localLinkedList.isEmpty())
    {
      bg.azz().a(1176, new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(33705);
          bg.azz().b(1176, this);
          Log.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          Object localObject;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            u.makeText(ServiceNotifySettingsUI.this, 2131763735, 0).show();
            if (bool1)
            {
              bg.aVF();
              com.tencent.mm.model.c.azQ().set(ar.a.NYF, Boolean.valueOf(bool3));
              EventCenter.instance.publish(new ri());
            }
            paramAnonymousString = localLinkedList.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousq = (eft)paramAnonymousString.next();
              localObject = new yw();
              ((yw)localObject).efe.dCl = paramAnonymousq.NfM;
              ((yw)localObject).efe.action = 1;
              ((yw)localObject).efe.option = i;
              EventCenter.instance.publish((IEvent)localObject);
            }
            AppMethodBeat.o(33705);
            return;
          }
          paramAnonymousString = com.tencent.mm.msgsubscription.api.b.jza;
          paramAnonymousString = com.tencent.mm.msgsubscription.api.b.Ru("name_wxa");
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localLinkedList.size())
          {
            paramAnonymousq = (eft)localLinkedList.get(paramAnonymousInt1);
            if ((paramAnonymousString != null) && (paramAnonymousq != null) && (!Util.isNullOrNil(paramAnonymousq.NfM)))
            {
              localObject = paramAnonymousq.NfM;
              if (paramAnonymousq.NfL != 1) {
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
      bg.azz().a(new com.tencent.mm.modelappbrand.q(localLinkedList), 0);
    }
    this.OKI.unregisterDataSetObserver(this.Tr);
    super.onDestroy();
    AppMethodBeat.o(33715);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(33716);
    if (this.Fxt != null) {
      this.Fxt.dismiss();
    }
    Log.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      u.makeText(this, 2131763722, 0).show();
      AppMethodBeat.o(33716);
      return;
    }
    paramString = ((r)paramq).aXQ();
    if (this.mMode == 1) {
      this.jBx.setCheck(paramString.Mbo);
    }
    for (;;)
    {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33706);
          if (ServiceNotifySettingsUI.b(ServiceNotifySettingsUI.this) == 1) {
            ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.Mbp);
          }
          AppMethodBeat.o(33706);
        }
      });
      AppMethodBeat.o(33716);
      return;
      this.jBx.setCheck(paramString.KPb);
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
    LinkedList<a> OKP;
    LinkedList<a> Oxv;
    private com.tencent.mm.av.a.a.c Oxy;
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
      this.Oxv = new LinkedList();
      this.OKP = new LinkedList();
      this.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33708);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
            i = 2131763728;
            if (paramInt != 1) {
              break label154;
            }
          }
          label154:
          for (int j = 2131763729;; j = 2131755921)
          {
            com.tencent.mm.ui.base.h.a(paramAnonymousView, i, 0, j, 2131756929, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33707);
                paramAnonymous2Int = 0;
                while (paramAnonymous2Int < ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).size())
                {
                  paramAnonymous2DialogInterface = (ServiceNotifySettingsUI.a.a)ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).get(paramAnonymous2Int);
                  if ((paramAnonymous2DialogInterface != null) && (this.gtu.equals(paramAnonymous2DialogInterface.username)))
                  {
                    ServiceNotifySettingsUI.a.b(ServiceNotifySettingsUI.a.this).add(ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).remove(paramAnonymous2Int));
                    ServiceNotifySettingsUI.a.this.notifyDataSetChanged();
                    paramAnonymous2DialogInterface = ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(this.gtu);
                    if (paramAnonymous2DialogInterface == null) {}
                    for (paramAnonymous2DialogInterface = ""; ServiceNotifySettingsUI.a.1.this.val$mode == 1; paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.field_appId)
                    {
                      Log.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(4), paramAnonymous2DialogInterface, ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this) });
                      com.tencent.mm.plugin.report.service.h.CyF.a(13798, new Object[] { Integer.valueOf(4), paramAnonymous2DialogInterface, Integer.valueOf(0), ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this), Long.valueOf(Util.nowSecond()) });
                      AppMethodBeat.o(33707);
                      return;
                    }
                    com.tencent.mm.plugin.report.service.h.CyF.a(13796, new Object[] { Integer.valueOf(12), paramAnonymous2DialogInterface, "", Integer.valueOf(0), Long.valueOf(Util.nowSecond()) });
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
            }, 2131100566);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33708);
            return;
            i = 2131763732;
            break;
          }
        }
      };
      paramContext = new c.a();
      paramContext.iaT = true;
      paramContext.jbu = com.tencent.mm.modelappbrand.a.a.aXX();
      this.Oxy = paramContext.bdv();
      AppMethodBeat.o(33709);
    }
    
    private a alm(int paramInt)
    {
      AppMethodBeat.i(33711);
      a locala = (a)this.Oxv.get(paramInt);
      AppMethodBeat.o(33711);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(33710);
      int i = this.Oxv.size();
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
      a locala = alm(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = this.mLayoutInflater.inflate(2131496233, paramViewGroup, false);
        paramView = new b((byte)0);
        paramView.gyr = ((ImageView)localView.findViewById(2131297121));
        paramView.titleTv = ((TextView)localView.findViewById(2131309199));
        paramView.OKS = ((TextView)localView.findViewById(2131307041));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        com.tencent.mm.av.q.bcV().a(locala.url, paramViewGroup.gyr, this.Oxy);
        paramViewGroup.titleTv.setText(locala.title);
        if (this.mMode != 1) {
          break label188;
        }
        paramViewGroup.OKS.setText(this.mContext.getString(2131763724));
      }
      for (;;)
      {
        paramViewGroup.OKS.setTag(locala.username);
        paramViewGroup.OKS.setOnClickListener(this.mOnClickListener);
        AppMethodBeat.o(33712);
        return localView;
        paramViewGroup = (b)paramView.getTag();
        localView = paramView;
        break;
        label188:
        paramViewGroup.OKS.setText(this.mContext.getString(2131763725));
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
      TextView OKS;
      ImageView gyr;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */