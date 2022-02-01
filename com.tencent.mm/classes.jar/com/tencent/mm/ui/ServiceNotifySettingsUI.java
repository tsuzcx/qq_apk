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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.a.aad;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.protocal.protobuf.epv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.LifecycleEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI
  extends MMActivity
  implements i
{
  private s LRv;
  private DataSetObserver QT;
  private a Weh;
  private String Wei;
  private ListView mListView;
  private int mMode;
  private String mSceneId;
  private MMSwitchBtn mru;
  
  private boolean hIz()
  {
    AppMethodBeat.i(33717);
    ar.a locala = ar.a.VmF;
    if (this.mMode == 1) {
      locala = ar.a.VmG;
    }
    bh.beI();
    boolean bool = com.tencent.mm.model.c.aHp().getBoolean(locala, true);
    AppMethodBeat.o(33717);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return R.i.ekO;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33714);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.mMode = paramBundle.getIntExtra("mode", 0);
    this.mSceneId = paramBundle.getStringExtra("scene_id");
    this.Wei = paramBundle.getStringExtra("from_scene");
    paramBundle.putExtra("scene_id", this.mSceneId);
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle))
    {
      setMMTitle(R.l.eOD);
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
      this.mru = ((MMSwitchBtn)findViewById(R.h.checkbox));
      this.mListView = ((ListView)findViewById(R.h.listview));
      paramBundle = (TextView)findViewById(R.h.dLo);
      if (this.mMode != 1) {
        break label409;
      }
      i = R.l.eNX;
      label141:
      paramBundle.setText(i);
      paramBundle = (TextView)findViewById(R.h.dXv);
      if (this.mMode != 1) {
        break label416;
      }
    }
    label409:
    label416:
    for (int i = R.l.eNY;; i = R.l.eNZ)
    {
      paramBundle.setText(i);
      if ((this.mMode == 0) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wcg, 0) == 1))
      {
        paramBundle = findViewById(R.h.dZV);
        paramBundle.setVisibility(0);
        paramBundle = (MMSwitchBtn)paramBundle.findViewById(R.h.dZU);
        ar.a locala = ar.a.VEh;
        bh.beI();
        paramBundle.setCheck(com.tencent.mm.model.c.aHp().getBoolean(locala, true));
        paramBundle.setSwitchListener(new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(281484);
            ServiceNotifySettingsUI.FK(paramAnonymousBoolean);
            AppMethodBeat.o(281484);
          }
        });
      }
      this.Weh = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
      this.mListView.setAdapter(this.Weh);
      this.QT = new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(33704);
          View localView = ServiceNotifySettingsUI.this.findViewById(R.h.dLo);
          if (ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            AppMethodBeat.o(33704);
            return;
          }
        }
      };
      this.Weh.registerDataSetObserver(this.QT);
      if (this.mMode == 1)
      {
        bh.aGY().a(1145, this);
        bh.aGY().a(new r(12), 0);
        getString(R.l.app_tip);
        this.LRv = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(289269);
            ServiceNotifySettingsUI.this.finish();
            AppMethodBeat.o(289269);
          }
        });
      }
      this.mru.setCheck(hIz());
      AppMethodBeat.o(33714);
      return;
      setMMTitle(paramBundle);
      break;
      i = R.l.eNS;
      break label141;
    }
  }
  
  public void onDestroy()
  {
    int j = 3;
    AppMethodBeat.i(33715);
    bh.aGY().b(1145, this);
    final boolean bool3 = hIz();
    final boolean bool1;
    final LinkedList localLinkedList;
    Object localObject2;
    final int i;
    label72:
    label88:
    boolean bool2;
    label110:
    Object localObject1;
    if (this.mru.YbZ != bool3)
    {
      bool1 = true;
      localLinkedList = new LinkedList();
      if (bool1)
      {
        localObject2 = new epv();
        if (!this.mru.YbZ) {
          break label524;
        }
        i = 1;
        ((epv)localObject2).Usq = i;
        if (this.mMode != 1) {
          break label529;
        }
        i = 2;
        ((epv)localObject2).rWu = i;
        localLinkedList.add(localObject2);
        if (bool3) {
          break label534;
        }
        bool2 = true;
        localObject1 = ar.a.VmF;
        if (this.mMode == 1) {
          localObject1 = ar.a.VmG;
        }
        bh.beI();
        com.tencent.mm.model.c.aHp().set((ar.a)localObject1, Boolean.valueOf(bool2));
        ((com.tencent.mm.v.b)LifecycleEventCenter.getEvent(com.tencent.mm.v.b.class)).publish();
        if (this.mMode != 1) {
          break label545;
        }
        if (((epv)localObject2).Usq != 1) {
          break label540;
        }
        i = 3;
        label176:
        Log.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(i), this.mSceneId });
        com.tencent.mm.plugin.report.service.h.IzE.a(13798, new Object[] { Integer.valueOf(i), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(Util.nowSecond()) });
        if ("scene_service_notify_conversation".equals(this.Wei))
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
          long l = Util.nowSecond();
          if (!this.mru.YbZ) {
            break label614;
          }
          i = 1;
          label296:
          ((com.tencent.mm.plugin.report.service.h)localObject1).a(21825, new Object[] { Integer.valueOf(3), null, Long.valueOf(l), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
        }
      }
      if (this.mMode != 1) {
        break label619;
      }
      i = 2;
      label369:
      localObject1 = this.Weh.Weo;
      if ((localObject1 == null) || (((LinkedList)localObject1).isEmpty())) {
        break label629;
      }
      if (this.mMode != 1) {
        break label624;
      }
    }
    for (;;)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ServiceNotifySettingsUI.a.a)((Iterator)localObject1).next();
        Object localObject3 = new epv();
        ((epv)localObject3).Usr = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((epv)localObject3).rWu = j;
        ((epv)localObject3).Usq = 1;
        localLinkedList.add(localObject3);
        localObject3 = new aad();
        ((aad)localObject3).fZt.fuO = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((aad)localObject3).fZt.action = 2;
        ((aad)localObject3).fZt.option = i;
        EventCenter.instance.publish((IEvent)localObject3);
      }
      bool1 = false;
      break;
      label524:
      i = 0;
      break label72;
      label529:
      i = 0;
      break label88;
      label534:
      bool2 = false;
      break label110;
      label540:
      i = 2;
      break label176;
      label545:
      if (((epv)localObject2).Usq == 1) {}
      for (i = 11;; i = 10)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(13796, new Object[] { Integer.valueOf(i), "", "", Integer.valueOf(0), Long.valueOf(Util.nowSecond()) });
        break;
      }
      label614:
      i = 2;
      break label296;
      label619:
      i = 1;
      break label369;
      label624:
      j = 1;
    }
    label629:
    if (!localLinkedList.isEmpty())
    {
      bh.aGY().a(1176, new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(274624);
          bh.aGY().b(1176, this);
          Log.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          Object localObject;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            w.makeText(ServiceNotifySettingsUI.this, R.l.eOu, 0).show();
            if (bool1)
            {
              bh.beI();
              com.tencent.mm.model.c.aHp().set(ar.a.VmF, Boolean.valueOf(bool3));
              ((com.tencent.mm.v.b)LifecycleEventCenter.getEvent(com.tencent.mm.v.b.class)).publish();
            }
            paramAnonymousString = localLinkedList.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousq = (epv)paramAnonymousString.next();
              localObject = new aad();
              ((aad)localObject).fZt.fuO = paramAnonymousq.Usr;
              ((aad)localObject).fZt.action = 1;
              ((aad)localObject).fZt.option = i;
              EventCenter.instance.publish((IEvent)localObject);
            }
            AppMethodBeat.o(274624);
            return;
          }
          paramAnonymousString = com.tencent.mm.msgsubscription.api.b.moG;
          paramAnonymousString = com.tencent.mm.msgsubscription.api.b.YR("name_wxa");
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localLinkedList.size())
          {
            paramAnonymousq = (epv)localLinkedList.get(paramAnonymousInt1);
            if ((paramAnonymousString != null) && (paramAnonymousq != null) && (!Util.isNullOrNil(paramAnonymousq.Usr)))
            {
              localObject = paramAnonymousq.Usr;
              if (paramAnonymousq.Usq != 1) {
                break label283;
              }
            }
            label283:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousString.ab((String)localObject, bool);
              paramAnonymousInt1 += 1;
              break;
            }
          }
          AppMethodBeat.o(274624);
        }
      });
      bh.aGY().a(new com.tencent.mm.modelappbrand.q(localLinkedList), 0);
    }
    this.Weh.unregisterDataSetObserver(this.QT);
    super.onDestroy();
    AppMethodBeat.o(33715);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(33716);
    if (this.LRv != null) {
      this.LRv.dismiss();
    }
    Log.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      w.makeText(this, R.l.eOf, 0).show();
      AppMethodBeat.o(33716);
      return;
    }
    paramString = ((r)paramq).bgZ();
    if (this.mMode == 1) {
      this.mru.setCheck(paramString.TkL);
    }
    for (;;)
    {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197689);
          if (ServiceNotifySettingsUI.b(ServiceNotifySettingsUI.this) == 1) {
            ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.TkM);
          }
          AppMethodBeat.o(197689);
        }
      });
      AppMethodBeat.o(33716);
      return;
      this.mru.setCheck(paramString.RPZ);
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
    private com.tencent.mm.ay.a.a.c VQC;
    LinkedList<a> VQz;
    LinkedList<a> Weo;
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
      this.VQz = new LinkedList();
      this.Weo = new LinkedList();
      this.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33708);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
            i = R.l.eOo;
            if (paramInt != 1) {
              break label159;
            }
          }
          label159:
          for (int j = R.l.eOp;; j = R.l.app_ok)
          {
            com.tencent.mm.ui.base.h.a(paramAnonymousView, i, 0, j, R.l.cancel, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33707);
                paramAnonymous2Int = 0;
                while (paramAnonymous2Int < ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).size())
                {
                  paramAnonymous2DialogInterface = (ServiceNotifySettingsUI.a.a)ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).get(paramAnonymous2Int);
                  if ((paramAnonymous2DialogInterface != null) && (this.iXG.equals(paramAnonymous2DialogInterface.username)))
                  {
                    ServiceNotifySettingsUI.a.b(ServiceNotifySettingsUI.a.this).add(ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).remove(paramAnonymous2Int));
                    ServiceNotifySettingsUI.a.this.notifyDataSetChanged();
                    paramAnonymous2DialogInterface = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(this.iXG);
                    if (paramAnonymous2DialogInterface == null) {}
                    for (paramAnonymous2DialogInterface = ""; ServiceNotifySettingsUI.a.1.this.val$mode == 1; paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.field_appId)
                    {
                      Log.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(4), paramAnonymous2DialogInterface, ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this) });
                      com.tencent.mm.plugin.report.service.h.IzE.a(13798, new Object[] { Integer.valueOf(4), paramAnonymous2DialogInterface, Integer.valueOf(0), ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this), Long.valueOf(Util.nowSecond()) });
                      AppMethodBeat.o(33707);
                      return;
                    }
                    com.tencent.mm.plugin.report.service.h.IzE.a(13796, new Object[] { Integer.valueOf(12), paramAnonymous2DialogInterface, "", Integer.valueOf(0), Long.valueOf(Util.nowSecond()) });
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
            }, R.e.green_text_color);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33708);
            return;
            i = R.l.eOr;
            break;
          }
        }
      };
      paramContext = new c.a();
      paramContext.kPz = true;
      paramContext.lRT = com.tencent.mm.modelappbrand.a.a.bhg();
      this.VQC = paramContext.bmL();
      AppMethodBeat.o(33709);
    }
    
    private a auj(int paramInt)
    {
      AppMethodBeat.i(33711);
      a locala = (a)this.VQz.get(paramInt);
      AppMethodBeat.o(33711);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(33710);
      int i = this.VQz.size();
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
      a locala = auj(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = this.mLayoutInflater.inflate(R.i.ekN, paramViewGroup, false);
        paramView = new b((byte)0);
        paramView.jiu = ((ImageView)localView.findViewById(R.h.avatarIv));
        paramView.titleTv = ((TextView)localView.findViewById(R.h.titleTv));
        paramView.Wer = ((TextView)localView.findViewById(R.h.dSS));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        com.tencent.mm.ay.q.bml().a(locala.url, paramViewGroup.jiu, this.VQC);
        paramViewGroup.titleTv.setText(locala.title);
        if (this.mMode != 1) {
          break label193;
        }
        paramViewGroup.Wer.setText(this.mContext.getString(R.l.eOg));
      }
      for (;;)
      {
        paramViewGroup.Wer.setTag(locala.username);
        paramViewGroup.Wer.setOnClickListener(this.mOnClickListener);
        AppMethodBeat.o(33712);
        return localView;
        paramViewGroup = (b)paramView.getTag();
        localView = paramView;
        break;
        label193:
        paramViewGroup.Wer.setText(this.mContext.getString(R.l.eOh));
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
      TextView Wer;
      ImageView jiu;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */