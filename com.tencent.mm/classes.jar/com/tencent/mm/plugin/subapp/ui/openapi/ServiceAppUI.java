package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private ServicePreference pxi;
  private ServicePreference pxj;
  private PreferenceTitleCategory pxk;
  private PreferenceTitleCategory pxl;
  private List<com.tencent.mm.pluginsdk.model.app.f> pxm = new ArrayList();
  private List<com.tencent.mm.pluginsdk.model.app.f> pxn = new ArrayList();
  private AdapterView.OnItemClickListener pxo;
  private AdapterView.OnItemClickListener pxp;
  private String talker;
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.service_app_list);
    this.talker = getIntent().getStringExtra("service_app_talker_user");
    setBackBtn(new ServiceAppUI.1(this));
    this.pxm.clear();
    this.pxn.clear();
    Cursor localCursor;
    if (s.fn(this.talker))
    {
      localCursor = ap.brn().dz(0, 2);
      if (localCursor != null) {
        if (!localCursor.moveToFirst()) {}
      }
    }
    label456:
    for (;;)
    {
      com.tencent.mm.pluginsdk.model.app.f localf = new com.tencent.mm.pluginsdk.model.app.f();
      localf.d(localCursor);
      if (localf.field_serviceAppType == 1) {
        this.pxm.add(localf);
      }
      for (;;)
      {
        if (localCursor.moveToNext()) {
          break label456;
        }
        localCursor.close();
        if (this.pxo == null) {
          this.pxo = new ServiceAppUI.2(this);
        }
        if (this.pxp == null) {
          this.pxp = new ServiceAppUI.3(this);
        }
        this.dnn = this.vdd;
        this.dnn.removeAll();
        if (this.pxm.size() > 0)
        {
          this.pxi = new ServicePreference(this);
          this.pxi.nUB = this.pxm;
          if (this.pxo != null) {
            this.pxi.pwZ = this.pxo;
          }
          if (this.pxk == null)
          {
            this.pxk = new PreferenceTitleCategory(this);
            this.pxk.setTitle(R.l.wx_service_app_list);
          }
          this.dnn.a(this.pxk);
          this.dnn.a(this.pxi);
        }
        if (this.pxn.size() > 0)
        {
          this.pxj = new ServicePreference(this);
          this.pxj.nUB = this.pxn;
          if (this.pxp != null) {
            this.pxj.pwZ = this.pxp;
          }
          if (this.pxl == null)
          {
            this.pxl = new PreferenceTitleCategory(this);
            this.pxl.setTitle(R.l.biz_service_app_list);
          }
          this.dnn.a(this.pxl);
          this.dnn.a(this.pxj);
        }
        return;
        if (s.hl(this.talker))
        {
          localCursor = ap.brn().dz(0, 4);
          break;
        }
        localCursor = ap.brn().dz(0, 1);
        break;
        if (localf.field_serviceAppType == 2) {
          this.pxn.add(localf);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.pxi != null) {
      this.pxi.onPause();
    }
    if (this.pxj != null) {
      this.pxj.onPause();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
    if (this.pxi != null) {
      this.pxi.onResume();
    }
    if (this.pxj != null) {
      this.pxj.onResume();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    y.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
  }
  
  public final int xj()
  {
    return R.o.service_app_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI
 * JD-Core Version:    0.7.0.1
 */