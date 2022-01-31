package com.tencent.mm.plugin.subapp.ui.openapi;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private ServicePreference sYW;
  private ServicePreference sYX;
  private PreferenceTitleCategory sYY;
  private PreferenceTitleCategory sYZ;
  private List<com.tencent.mm.pluginsdk.model.app.f> sZa;
  private List<com.tencent.mm.pluginsdk.model.app.f> sZb;
  private AdapterView.OnItemClickListener sZc;
  private AdapterView.OnItemClickListener sZd;
  private com.tencent.mm.ui.base.preference.f screen;
  private String talker;
  
  public ServiceAppUI()
  {
    AppMethodBeat.i(25474);
    this.sZa = new ArrayList();
    this.sZb = new ArrayList();
    AppMethodBeat.o(25474);
  }
  
  public int getResourceId()
  {
    return 2131165269;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25479);
    setMMTitle(2131303133);
    this.talker = getIntent().getStringExtra("service_app_talker_user");
    setBackBtn(new ServiceAppUI.1(this));
    this.sZa.clear();
    this.sZb.clear();
    Cursor localCursor;
    if (t.lA(this.talker))
    {
      localCursor = al.cac().eZ(0, 2);
      if (localCursor != null) {
        if (!localCursor.moveToFirst()) {}
      }
    }
    label510:
    for (;;)
    {
      com.tencent.mm.pluginsdk.model.app.f localf = new com.tencent.mm.pluginsdk.model.app.f();
      localf.convertFrom(localCursor);
      if (localf.field_serviceAppType == 1) {
        this.sZa.add(localf);
      }
      for (;;)
      {
        if (localCursor.moveToNext()) {
          break label510;
        }
        localCursor.close();
        ab.i("MicroMsg.ServiceAppUI", "initAppList: wxServiceList size %s, bizServiceList size %s", new Object[] { Integer.valueOf(this.sZa.size()), Integer.valueOf(this.sZb.size()) });
        if (this.sZc == null) {
          this.sZc = new ServiceAppUI.2(this);
        }
        if (this.sZd == null) {
          this.sZd = new ServiceAppUI.3(this);
        }
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        if (this.sZa.size() > 0)
        {
          this.sYW = new ServicePreference(this);
          this.sYW.qIG = this.sZa;
          if (this.sZc != null) {
            this.sYW.sYO = this.sZc;
          }
          if (this.sYY == null)
          {
            this.sYY = new PreferenceTitleCategory(this);
            this.sYY.setTitle(2131306049);
          }
          this.screen.b(this.sYY);
          this.screen.b(this.sYW);
        }
        if (this.sZb.size() > 0)
        {
          this.sYX = new ServicePreference(this);
          this.sYX.qIG = this.sZb;
          if (this.sZd != null) {
            this.sYX.sYO = this.sZd;
          }
          if (this.sYZ == null)
          {
            this.sYZ = new PreferenceTitleCategory(this);
            this.sYZ.setTitle(2131297685);
          }
          this.screen.b(this.sYZ);
          this.screen.b(this.sYX);
        }
        AppMethodBeat.o(25479);
        return;
        if (t.nU(this.talker))
        {
          localCursor = al.cac().eZ(0, 4);
          break;
        }
        localCursor = al.cac().eZ(0, 1);
        break;
        if (localf.field_serviceAppType == 2) {
          this.sZb.add(localf);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25475);
    super.onCreate(paramBundle);
    AppMethodBeat.o(25475);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25477);
    super.onPause();
    if (this.sYW != null) {
      this.sYW.onPause();
    }
    if (this.sYX != null) {
      this.sYX.onPause();
    }
    AppMethodBeat.o(25477);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25476);
    super.onResume();
    initView();
    if (this.sYW != null) {
      this.sYW.onResume();
    }
    if (this.sYX != null) {
      this.sYX.onResume();
    }
    AppMethodBeat.o(25476);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(25480);
    ab.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AppMethodBeat.o(25480);
      return;
    }
    ab.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(25480);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI
 * JD-Core Version:    0.7.0.1
 */