package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.un;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.protocal.protobuf.apq;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI
  extends MMActivity
  implements f
{
  private DataSetObserver Jv;
  private ListView mListView;
  private int mMode;
  private String mSceneId;
  private MMSwitchBtn ozl;
  private com.tencent.mm.ui.base.p sHO;
  private ServiceNotifySettingsUI.a zeP;
  
  private boolean dDg()
  {
    AppMethodBeat.i(29865);
    ac.a locala = ac.a.yDB;
    if (this.mMode == 1) {
      locala = ac.a.yDC;
    }
    aw.aaz();
    boolean bool = c.Ru().getBoolean(locala, true);
    AppMethodBeat.o(29865);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return 2130970678;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29862);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.mMode = paramBundle.getIntExtra("mode", 0);
    this.mSceneId = paramBundle.getStringExtra("scene_id");
    paramBundle.putExtra("scene_id", this.mSceneId);
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle))
    {
      setMMTitle(2131301991);
      setBackBtn(new ServiceNotifySettingsUI.1(this));
      this.ozl = ((MMSwitchBtn)findViewById(2131820950));
      this.mListView = ((ListView)findViewById(2131821736));
      paramBundle = (TextView)findViewById(2131827579);
      if (this.mMode != 1) {
        break label311;
      }
      i = 2131301974;
      label127:
      paramBundle.setText(i);
      paramBundle = (TextView)findViewById(2131827578);
      if (this.mMode != 1) {
        break label318;
      }
    }
    label311:
    label318:
    for (int i = 2131301975;; i = 2131301977)
    {
      paramBundle.setText(i);
      this.zeP = new ServiceNotifySettingsUI.a(this, getLayoutInflater(), this.mMode, this.mSceneId);
      this.mListView.setAdapter(this.zeP);
      getString(2131297087);
      this.sHO = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, new ServiceNotifySettingsUI.2(this));
      this.Jv = new ServiceNotifySettingsUI.3(this);
      this.zeP.registerDataSetObserver(this.Jv);
      i = 3;
      if (this.mMode == 1) {
        i = 12;
      }
      aw.Rc().a(1145, this);
      aw.Rc().a(new com.tencent.mm.modelappbrand.p(i), 0);
      this.ozl.setCheck(dDg());
      AppMethodBeat.o(29862);
      return;
      setMMTitle(paramBundle);
      break;
      i = 2131301971;
      break label127;
    }
  }
  
  public void onDestroy()
  {
    int j = 3;
    AppMethodBeat.i(29863);
    aw.Rc().b(1145, this);
    boolean bool3 = dDg();
    boolean bool1;
    LinkedList localLinkedList;
    Object localObject2;
    int i;
    label72:
    label88:
    boolean bool2;
    label110:
    Object localObject1;
    if (this.ozl.ADA != bool3)
    {
      bool1 = true;
      localLinkedList = new LinkedList();
      if (bool1)
      {
        localObject2 = new ciy();
        if (!this.ozl.ADA) {
          break label428;
        }
        i = 1;
        ((ciy)localObject2).xTg = i;
        if (this.mMode != 1) {
          break label433;
        }
        i = 2;
        ((ciy)localObject2).jKs = i;
        localLinkedList.add(localObject2);
        if (bool3) {
          break label438;
        }
        bool2 = true;
        localObject1 = ac.a.yDB;
        if (this.mMode == 1) {
          localObject1 = ac.a.yDC;
        }
        aw.aaz();
        c.Ru().set((ac.a)localObject1, Boolean.valueOf(bool2));
        a.ymk.l(new oe());
        if (this.mMode != 1) {
          break label449;
        }
        if (((ciy)localObject2).xTg != 1) {
          break label444;
        }
        i = 3;
        label178:
        ab.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(i), this.mSceneId });
        com.tencent.mm.plugin.report.service.h.qsU.e(13798, new Object[] { Integer.valueOf(i), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(bo.aox()) });
      }
      if (this.mMode != 1) {
        break label518;
      }
      i = 2;
      label273:
      localObject1 = this.zeP.zeW;
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
        Object localObject3 = new ciy();
        ((ciy)localObject3).xTh = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((ciy)localObject3).jKs = j;
        ((ciy)localObject3).xTg = 1;
        localLinkedList.add(localObject3);
        localObject3 = new un();
        ((un)localObject3).cLa.cmx = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((un)localObject3).cLa.action = 2;
        ((un)localObject3).cLa.option = i;
        a.ymk.l((b)localObject3);
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
      if (((ciy)localObject2).xTg == 1) {}
      for (i = 11;; i = 10)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(13796, new Object[] { Integer.valueOf(i), "", "", Integer.valueOf(0), Long.valueOf(bo.aox()) });
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
      aw.Rc().a(1176, new ServiceNotifySettingsUI.4(this, bool1, bool3, localLinkedList, i));
      aw.Rc().a(new o(localLinkedList), 0);
    }
    this.zeP.unregisterDataSetObserver(this.Jv);
    super.onDestroy();
    AppMethodBeat.o(29863);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(29864);
    if (this.sHO != null) {
      this.sHO.dismiss();
    }
    ab.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(this, 2131301980, 0).show();
      AppMethodBeat.o(29864);
      return;
    }
    paramString = ((com.tencent.mm.modelappbrand.p)paramm).acs();
    if (this.mMode == 1) {
      this.ozl.setCheck(paramString.xft);
    }
    for (;;)
    {
      runOnUiThread(new ServiceNotifySettingsUI.5(this, paramString));
      AppMethodBeat.o(29864);
      return;
      this.ozl.setCheck(paramString.wvc);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a$b
  {
    ImageView ehv;
    TextView titleTv;
    TextView zfb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI
 * JD-Core Version:    0.7.0.1
 */