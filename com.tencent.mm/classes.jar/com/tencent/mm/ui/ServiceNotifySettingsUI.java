package com.tencent.mm.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.abz;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.fku;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private w Sub;
  private a adJK;
  private String adJL;
  private DataSetObserver bxk;
  private ListView mListView;
  private int mMode;
  private String mSceneId;
  private MMSwitchBtn pkU;
  
  private boolean jkJ()
  {
    AppMethodBeat.i(33717);
    at.a locala = at.a.acOa;
    if (this.mMode == 1) {
      locala = at.a.acOb;
    }
    bh.bCz();
    boolean bool = com.tencent.mm.model.c.ban().getBoolean(locala, true);
    AppMethodBeat.o(33717);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return R.i.gnU;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33714);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.mMode = paramBundle.getIntExtra("mode", 0);
    this.mSceneId = paramBundle.getStringExtra("scene_id");
    this.adJL = paramBundle.getStringExtra("from_scene");
    paramBundle.putExtra("scene_id", this.mSceneId);
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle))
    {
      setMMTitle(R.l.gQP);
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
      this.pkU = ((MMSwitchBtn)findViewById(R.h.checkbox));
      this.mListView = ((ListView)findViewById(R.h.listview));
      paramBundle = (TextView)findViewById(R.h.fMT);
      if (this.mMode != 1) {
        break label409;
      }
      i = R.l.gQi;
      label141:
      paramBundle.setText(i);
      paramBundle = (TextView)findViewById(R.h.gaa);
      if (this.mMode != 1) {
        break label416;
      }
    }
    label409:
    label416:
    for (int i = R.l.gQk;; i = R.l.gQl)
    {
      paramBundle.setText(i);
      if ((this.mMode == 0) && (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvM, 0) == 1))
      {
        paramBundle = findViewById(R.h.gcJ);
        paramBundle.setVisibility(0);
        paramBundle = (MMSwitchBtn)paramBundle.findViewById(R.h.gcI);
        at.a locala = at.a.adhu;
        bh.bCz();
        paramBundle.setCheck(com.tencent.mm.model.c.ban().getBoolean(locala, true));
        paramBundle.setSwitchListener(new MMSwitchBtn.a()
        {
          public final void onStatusChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(249222);
            ServiceNotifySettingsUI.Lt(paramAnonymousBoolean);
            AppMethodBeat.o(249222);
          }
        });
      }
      this.adJK = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
      this.mListView.setAdapter(this.adJK);
      this.bxk = new DataSetObserver()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(33704);
          View localView = ServiceNotifySettingsUI.this.findViewById(R.h.fMT);
          if (ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            AppMethodBeat.o(33704);
            return;
          }
        }
      };
      this.adJK.registerDataSetObserver(this.bxk);
      if (this.mMode == 1)
      {
        bh.aZW().a(1145, this);
        bh.aZW().a(new com.tencent.mm.modelappbrand.r(12), 0);
        getString(R.l.app_tip);
        this.Sub = k.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(249211);
            ServiceNotifySettingsUI.this.finish();
            AppMethodBeat.o(249211);
          }
        });
      }
      this.pkU.setCheck(jkJ());
      AppMethodBeat.o(33714);
      return;
      setMMTitle(paramBundle);
      break;
      i = R.l.gQg;
      break label141;
    }
  }
  
  public void onDestroy()
  {
    int j = 3;
    AppMethodBeat.i(33715);
    bh.aZW().b(1145, this);
    final boolean bool3 = jkJ();
    final boolean bool1;
    final LinkedList localLinkedList;
    Object localObject2;
    final int i;
    label72:
    label88:
    boolean bool2;
    label110:
    Object localObject1;
    if (this.pkU.afTT != bool3)
    {
      bool1 = true;
      localLinkedList = new LinkedList();
      if (bool1)
      {
        localObject2 = new fku();
        if (!this.pkU.afTT) {
          break label521;
        }
        i = 1;
        ((fku)localObject2).abLt = i;
        if (this.mMode != 1) {
          break label526;
        }
        i = 2;
        ((fku)localObject2).vhJ = i;
        localLinkedList.add(localObject2);
        if (bool3) {
          break label531;
        }
        bool2 = true;
        localObject1 = at.a.acOa;
        if (this.mMode == 1) {
          localObject1 = at.a.acOb;
        }
        bh.bCz();
        com.tencent.mm.model.c.ban().set((at.a)localObject1, Boolean.valueOf(bool2));
        ((com.tencent.mm.u.b)MvvmEventCenter.getEvent(com.tencent.mm.u.b.class)).publish();
        if (this.mMode != 1) {
          break label542;
        }
        if (((fku)localObject2).abLt != 1) {
          break label537;
        }
        i = 3;
        label176:
        Log.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(i), this.mSceneId });
        com.tencent.mm.plugin.report.service.h.OAn.b(13798, new Object[] { Integer.valueOf(i), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(Util.nowSecond()) });
        if ("scene_service_notify_conversation".equals(this.adJL))
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
          long l = Util.nowSecond();
          if (!this.pkU.afTT) {
            break label611;
          }
          i = 1;
          label296:
          ((com.tencent.mm.plugin.report.service.h)localObject1).b(21825, new Object[] { Integer.valueOf(3), null, Long.valueOf(l), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
        }
      }
      if (this.mMode != 1) {
        break label616;
      }
      i = 2;
      label369:
      localObject1 = this.adJK.adJR;
      if ((localObject1 == null) || (((LinkedList)localObject1).isEmpty())) {
        break label626;
      }
      if (this.mMode != 1) {
        break label621;
      }
    }
    for (;;)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ServiceNotifySettingsUI.a.a)((Iterator)localObject1).next();
        Object localObject3 = new fku();
        ((fku)localObject3).abLu = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((fku)localObject3).vhJ = j;
        ((fku)localObject3).abLt = 1;
        localLinkedList.add(localObject3);
        localObject3 = new abz();
        ((abz)localObject3).ify.hzi = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((abz)localObject3).ify.action = 2;
        ((abz)localObject3).ify.option = i;
        ((abz)localObject3).publish();
      }
      bool1 = false;
      break;
      label521:
      i = 0;
      break label72;
      label526:
      i = 0;
      break label88;
      label531:
      bool2 = false;
      break label110;
      label537:
      i = 2;
      break label176;
      label542:
      if (((fku)localObject2).abLt == 1) {}
      for (i = 11;; i = 10)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(13796, new Object[] { Integer.valueOf(i), "", "", Integer.valueOf(0), Long.valueOf(Util.nowSecond()) });
        break;
      }
      label611:
      i = 2;
      break label296;
      label616:
      i = 1;
      break label369;
      label621:
      j = 1;
    }
    label626:
    if (!localLinkedList.isEmpty())
    {
      bh.aZW().a(1176, new com.tencent.mm.am.h()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(249217);
          bh.aZW().b(1176, this);
          Log.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          Object localObject;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            aa.makeText(ServiceNotifySettingsUI.this, R.l.gQH, 0).show();
            if (bool1)
            {
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acOa, Boolean.valueOf(bool3));
              ((com.tencent.mm.u.b)MvvmEventCenter.getEvent(com.tencent.mm.u.b.class)).publish();
            }
            paramAnonymousString = localLinkedList.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousp = (fku)paramAnonymousString.next();
              localObject = new abz();
              ((abz)localObject).ify.hzi = paramAnonymousp.abLu;
              ((abz)localObject).ify.action = 1;
              ((abz)localObject).ify.option = i;
              ((abz)localObject).publish();
            }
            AppMethodBeat.o(249217);
            return;
          }
          paramAnonymousString = com.tencent.mm.msgsubscription.api.b.piw;
          paramAnonymousString = com.tencent.mm.msgsubscription.api.b.QW("name_wxa");
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localLinkedList.size())
          {
            paramAnonymousp = (fku)localLinkedList.get(paramAnonymousInt1);
            if ((paramAnonymousString != null) && (paramAnonymousp != null) && (!Util.isNullOrNil(paramAnonymousp.abLu)))
            {
              localObject = paramAnonymousp.abLu;
              if (paramAnonymousp.abLt != 1) {
                break label280;
              }
            }
            label280:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousString.ag((String)localObject, bool);
              paramAnonymousInt1 += 1;
              break;
            }
          }
          AppMethodBeat.o(249217);
        }
      });
      bh.aZW().a(new q(localLinkedList), 0);
    }
    this.adJK.unregisterDataSetObserver(this.bxk);
    super.onDestroy();
    AppMethodBeat.o(33715);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(33716);
    if (this.Sub != null) {
      this.Sub.dismiss();
    }
    Log.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      aa.makeText(this, R.l.gQr, 0).show();
      AppMethodBeat.o(33716);
      return;
    }
    paramString = ((com.tencent.mm.modelappbrand.r)paramp).bEQ();
    if (this.mMode == 1) {
      this.pkU.setCheck(paramString.aays);
    }
    for (;;)
    {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(249192);
          if (ServiceNotifySettingsUI.b(ServiceNotifySettingsUI.this) == 1) {
            ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.aayt);
          }
          AppMethodBeat.o(249192);
        }
      });
      AppMethodBeat.o(33716);
      return;
      this.pkU.setCheck(paramString.YNn);
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
    LinkedList<a> adJR;
    LinkedList<a> aduH;
    private com.tencent.mm.modelimage.loader.a.c aduK;
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
      this.aduH = new LinkedList();
      this.adJR = new LinkedList();
      this.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33708);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/ServiceNotifySettingsUI$DefaultAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
            i = R.l.gQB;
            if (paramInt != 1) {
              break label159;
            }
          }
          label159:
          for (int j = R.l.gQC;; j = R.l.app_ok)
          {
            k.a(paramAnonymousView, i, 0, j, R.l.cancel, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(33707);
                paramAnonymous2Int = 0;
                while (paramAnonymous2Int < ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).size())
                {
                  paramAnonymous2DialogInterface = (ServiceNotifySettingsUI.a.a)ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).get(paramAnonymous2Int);
                  if ((paramAnonymous2DialogInterface != null) && (this.lzC.equals(paramAnonymous2DialogInterface.username)))
                  {
                    ServiceNotifySettingsUI.a.b(ServiceNotifySettingsUI.a.this).add((ServiceNotifySettingsUI.a.a)ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).remove(paramAnonymous2Int));
                    ServiceNotifySettingsUI.a.this.notifyDataSetChanged();
                    paramAnonymous2DialogInterface = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(this.lzC);
                    if (paramAnonymous2DialogInterface == null) {}
                    for (paramAnonymous2DialogInterface = ""; ServiceNotifySettingsUI.a.1.this.val$mode == 1; paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.field_appId)
                    {
                      Log.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(4), paramAnonymous2DialogInterface, ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this) });
                      com.tencent.mm.plugin.report.service.h.OAn.b(13798, new Object[] { Integer.valueOf(4), paramAnonymous2DialogInterface, Integer.valueOf(0), ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this), Long.valueOf(Util.nowSecond()) });
                      AppMethodBeat.o(33707);
                      return;
                    }
                    com.tencent.mm.plugin.report.service.h.OAn.b(13796, new Object[] { Integer.valueOf(12), paramAnonymous2DialogInterface, "", Integer.valueOf(0), Long.valueOf(Util.nowSecond()) });
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
            i = R.l.gQE;
            break;
          }
        }
      };
      paramContext = new com.tencent.mm.modelimage.loader.a.c.a();
      paramContext.nrc = true;
      paramContext.oKF = com.tencent.mm.modelappbrand.a.a.bEX();
      this.aduK = paramContext.bKx();
      AppMethodBeat.o(33709);
    }
    
    private a aAD(int paramInt)
    {
      AppMethodBeat.i(33711);
      a locala = (a)this.aduH.get(paramInt);
      AppMethodBeat.o(33711);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(33710);
      int i = this.aduH.size();
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
      a locala = aAD(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = this.mLayoutInflater.inflate(R.i.gnT, paramViewGroup, false);
        paramView = new b((byte)0);
        paramView.lKK = ((ImageView)localView.findViewById(R.h.avatarIv));
        paramView.titleTv = ((TextView)localView.findViewById(R.h.titleTv));
        paramView.adJU = ((TextView)localView.findViewById(R.h.fUV));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        com.tencent.mm.modelimage.r.bKe().a(locala.url, paramViewGroup.lKK, this.aduK);
        paramViewGroup.titleTv.setText(locala.title);
        if (this.mMode != 1) {
          break label193;
        }
        paramViewGroup.adJU.setText(this.mContext.getString(R.l.gQt));
      }
      for (;;)
      {
        paramViewGroup.adJU.setTag(locala.username);
        paramViewGroup.adJU.setOnClickListener(this.mOnClickListener);
        AppMethodBeat.o(33712);
        return localView;
        paramViewGroup = (b)paramView.getTag();
        localView = paramView;
        break;
        label193:
        paramViewGroup.adJU.setText(this.mContext.getString(R.l.gQu));
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
      TextView adJU;
      ImageView lKK;
      TextView titleTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */