package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.h.a.nh;
import com.tencent.mm.h.a.su;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.protocal.c.bwq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI
  extends MMActivity
  implements f
{
  private DataSetObserver JP;
  private ListView Nn;
  private int mMode;
  private String mSceneId;
  private MMSwitchBtn qmV;
  private a uQE;
  private com.tencent.mm.ui.base.p uQF;
  
  private boolean cAe()
  {
    ac.a locala = ac.a.uty;
    if (this.mMode == 1) {
      locala = ac.a.utz;
    }
    au.Hx();
    return com.tencent.mm.model.c.Dz().getBoolean(locala, true);
  }
  
  protected final int getLayoutId()
  {
    return R.i.service_notify_settings_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.mMode = paramBundle.getIntExtra("mode", 0);
    this.mSceneId = paramBundle.getStringExtra("scene_id");
    paramBundle.putExtra("scene_id", this.mSceneId);
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle))
    {
      setMMTitle(R.l.notify_message_settings_title);
      setBackBtn(new ServiceNotifySettingsUI.1(this));
      this.qmV = ((MMSwitchBtn)findViewById(R.h.checkbox));
      this.Nn = ((ListView)findViewById(R.h.listview));
      paramBundle = (TextView)findViewById(R.h.listTitleTv);
      if (this.mMode != 1) {
        break label308;
      }
      i = R.l.notify_message_settings_ban_wxa_custom_session_notify;
      label126:
      paramBundle.setText(i);
      paramBundle = (TextView)findViewById(R.h.tips_view);
      if (this.mMode != 1) {
        break label315;
      }
    }
    label308:
    label315:
    for (int i = R.l.notify_message_settings_close_custom_session_push_tips;; i = R.l.notify_message_settings_close_push_tips)
    {
      paramBundle.setText(i);
      this.uQE = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
      this.Nn.setAdapter(this.uQE);
      getString(R.l.app_tip);
      this.uQF = com.tencent.mm.ui.base.h.b(this, getString(R.l.app_waiting), true, new ServiceNotifySettingsUI.2(this));
      this.JP = new ServiceNotifySettingsUI.3(this);
      this.uQE.registerDataSetObserver(this.JP);
      i = 3;
      if (this.mMode == 1) {
        i = 12;
      }
      au.Dk().a(1145, this);
      au.Dk().a(new com.tencent.mm.modelappbrand.p(i), 0);
      this.qmV.setCheck(cAe());
      return;
      setMMTitle(paramBundle);
      break;
      i = R.l.notify_message_settings_ban_app_brand_notify;
      break label126;
    }
  }
  
  protected void onDestroy()
  {
    int j = 3;
    au.Dk().b(1145, this);
    boolean bool3 = cAe();
    boolean bool1;
    LinkedList localLinkedList;
    Object localObject2;
    int i;
    label66:
    label82:
    boolean bool2;
    label104:
    Object localObject1;
    if (this.qmV.wjS != bool3)
    {
      bool1 = true;
      localLinkedList = new LinkedList();
      if (bool1)
      {
        localObject2 = new bwq();
        if (!this.qmV.wjS) {
          break label422;
        }
        i = 1;
        ((bwq)localObject2).tMW = i;
        if (this.mMode != 1) {
          break label427;
        }
        i = 2;
        ((bwq)localObject2).hQR = i;
        localLinkedList.add(localObject2);
        if (bool3) {
          break label432;
        }
        bool2 = true;
        localObject1 = ac.a.uty;
        if (this.mMode == 1) {
          localObject1 = ac.a.utz;
        }
        au.Hx();
        com.tencent.mm.model.c.Dz().c((ac.a)localObject1, Boolean.valueOf(bool2));
        com.tencent.mm.sdk.b.a.udP.m(new nh());
        if (this.mMode != 1) {
          break label443;
        }
        if (((bwq)localObject2).tMW != 1) {
          break label438;
        }
        i = 3;
        label172:
        y.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(i), this.mSceneId });
        com.tencent.mm.plugin.report.service.h.nFQ.f(13798, new Object[] { Integer.valueOf(i), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(bk.UX()) });
      }
      if (this.mMode != 1) {
        break label512;
      }
      i = 2;
      label267:
      localObject1 = this.uQE.uQM;
      if ((localObject1 == null) || (((LinkedList)localObject1).isEmpty())) {
        break label522;
      }
      if (this.mMode != 1) {
        break label517;
      }
    }
    for (;;)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ServiceNotifySettingsUI.a.a)((Iterator)localObject1).next();
        Object localObject3 = new bwq();
        ((bwq)localObject3).tMX = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((bwq)localObject3).hQR = j;
        ((bwq)localObject3).tMW = 1;
        localLinkedList.add(localObject3);
        localObject3 = new su();
        ((su)localObject3).ccq.bFn = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((su)localObject3).ccq.action = 2;
        ((su)localObject3).ccq.ccs = i;
        com.tencent.mm.sdk.b.a.udP.m((b)localObject3);
      }
      bool1 = false;
      break;
      label422:
      i = 0;
      break label66;
      label427:
      i = 0;
      break label82;
      label432:
      bool2 = false;
      break label104;
      label438:
      i = 2;
      break label172;
      label443:
      if (((bwq)localObject2).tMW == 1) {}
      for (i = 11;; i = 10)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13796, new Object[] { Integer.valueOf(i), "", "", Integer.valueOf(0), Long.valueOf(bk.UX()) });
        break;
      }
      label512:
      i = 1;
      break label267;
      label517:
      j = 1;
    }
    label522:
    if (!localLinkedList.isEmpty())
    {
      au.Dk().a(1176, new ServiceNotifySettingsUI.4(this, bool1, bool3, localLinkedList, i));
      au.Dk().a(new com.tencent.mm.modelappbrand.o(localLinkedList), 0);
    }
    this.uQE.unregisterDataSetObserver(this.JP);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    if (this.uQF != null) {
      this.uQF.dismiss();
    }
    y.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      s.makeText(this, R.l.notify_message_settings_get_data_failed, 0).show();
      return;
    }
    paramString = ((com.tencent.mm.modelappbrand.p)paramm).Ju();
    if (this.mMode == 1) {
      this.qmV.setCheck(paramString.tgL);
    }
    for (;;)
    {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          if (ServiceNotifySettingsUI.b(ServiceNotifySettingsUI.this) == 1)
          {
            ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.tgM);
            return;
          }
          ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.sAO);
        }
      });
      return;
      this.qmV.setCheck(paramString.sAN);
    }
  }
  
  private static final class a
    extends BaseAdapter
  {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int mMode;
    private View.OnClickListener mOnClickListener;
    private String mSceneId;
    LinkedList<ServiceNotifySettingsUI.a.a> uQL;
    LinkedList<ServiceNotifySettingsUI.a.a> uQM;
    private com.tencent.mm.as.a.a.c uQN;
    
    public a(Context paramContext, LayoutInflater paramLayoutInflater, int paramInt, String paramString)
    {
      this.mContext = paramContext;
      this.mMode = paramInt;
      this.mSceneId = paramString;
      this.mLayoutInflater = paramLayoutInflater;
      this.uQL = new LinkedList();
      this.uQM = new LinkedList();
      this.mOnClickListener = new ServiceNotifySettingsUI.a.1(this, paramInt);
      paramContext = new c.a();
      paramContext.erD = true;
      paramContext.erz = com.tencent.mm.modelappbrand.a.a.JC();
      this.uQN = paramContext.OV();
    }
    
    private ServiceNotifySettingsUI.a.a Ge(int paramInt)
    {
      return (ServiceNotifySettingsUI.a.a)this.uQL.get(paramInt);
    }
    
    public final int getCount()
    {
      return this.uQL.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ServiceNotifySettingsUI.a.a locala = Ge(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = this.mLayoutInflater.inflate(R.i.service_notify_settings_app_brand_item, paramViewGroup, false);
        paramView = new ServiceNotifySettingsUI.a.b((byte)0);
        paramView.dpY = ((ImageView)localView.findViewById(R.h.avatarIv));
        paramView.eXr = ((TextView)localView.findViewById(R.h.titleTv));
        paramView.uQR = ((TextView)localView.findViewById(R.h.resumeReceiveBtn));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        com.tencent.mm.as.o.ON().a(locala.url, paramViewGroup.dpY, this.uQN);
        paramViewGroup.eXr.setText(locala.title);
        if (this.mMode != 1) {
          break label183;
        }
        paramViewGroup.uQR.setText(this.mContext.getString(R.l.notify_message_settings_item_custom_session_resume_receive));
      }
      for (;;)
      {
        paramViewGroup.uQR.setTag(locala.username);
        paramViewGroup.uQR.setOnClickListener(this.mOnClickListener);
        return localView;
        paramViewGroup = (ServiceNotifySettingsUI.a.b)paramView.getTag();
        localView = paramView;
        break;
        label183:
        paramViewGroup.uQR.setText(this.mContext.getString(R.l.notify_message_settings_item_resume_receive));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */