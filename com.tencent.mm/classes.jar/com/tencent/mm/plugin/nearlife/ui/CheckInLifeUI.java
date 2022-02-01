package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.am.h;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI
  extends BaseLifeUI
  implements h
{
  private boolean FyH;
  private boolean MqF;
  private String MqP;
  private b MqV;
  private b MqW;
  private ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> MqX;
  private com.tencent.mm.modelgeo.c MqY;
  private dgz MqZ;
  private boolean Mra;
  private View.OnClickListener Mrb;
  private c.a Mrc;
  private String city;
  String nRQ;
  private View.OnClickListener xxi;
  
  public CheckInLifeUI()
  {
    AppMethodBeat.i(26580);
    this.MqY = null;
    this.city = "";
    this.MqP = "";
    this.MqF = false;
    this.FyH = false;
    this.Mra = true;
    this.xxi = new CheckInLifeUI.1(this);
    this.Mrb = new CheckInLifeUI.2(this);
    this.Mrc = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(26579);
        Log.i("MicroMsg.CheckInLifeUI", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!Util.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this)))
        {
          AppMethodBeat.o(26579);
          return;
        }
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousAddr.oDK);
        if ((!Util.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this))) && (CheckInLifeUI.b(CheckInLifeUI.this))) {
          CheckInLifeUI.c(CheckInLifeUI.this).kG(CheckInLifeUI.a(CheckInLifeUI.this), paramAnonymousAddr.request_id);
        }
        AppMethodBeat.o(26579);
      }
    };
    AppMethodBeat.o(26580);
  }
  
  private static ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> bk(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(26589);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(26589);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String[] arrayOfString = ((String)paramArrayList.next()).split("\n");
      if (2 == arrayOfString.length) {
        try
        {
          localArrayList.add(new BackwardSupportUtil.ExifHelper.LatLongData(Float.valueOf(arrayOfString[0]).floatValue(), Float.valueOf(arrayOfString[1]).floatValue()));
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
    Log.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + localArrayList.size());
    AppMethodBeat.o(26589);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return R.i.gmr;
  }
  
  public final a gsW()
  {
    AppMethodBeat.i(26586);
    if (this.MqX == null) {
      this.MqX = bk(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (getIntent().getStringExtra("select_radio_icon_color") != null) {
      this.nRQ = getIntent().getStringExtra("select_radio_icon_color");
    }
    if ((getIntent().getStringExtra("select_radio_icon_color") != null) && (getIntent().getStringExtra("get_poi_from_scene").equals("story")))
    {
      this.MqF = true;
      this.MqF = true;
    }
    if (this.MqV == null)
    {
      this.MqV = new b(this, this.xxi, "viewlist", this.MqG, false, this.nRQ, this.FyH);
      if ((this.MqX != null) && (this.MqX.size() != 0))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add((BackwardSupportUtil.ExifHelper.LatLongData)this.MqX.get(this.MqX.size() - 1));
        this.MqV.bj((ArrayList)localObject);
        this.MqV.Mqh = false;
      }
      localObject = this.MqV;
      AppMethodBeat.o(26586);
      return localObject;
    }
    Object localObject = this.MqV;
    AppMethodBeat.o(26586);
    return localObject;
  }
  
  public final a gsX()
  {
    AppMethodBeat.i(26587);
    if (this.MqX == null) {
      this.MqX = bk(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (this.MqW == null)
    {
      this.MqW = new b(this, this.Mrb, "searchlist", this.MqG, true, this.nRQ, this.FyH);
      this.MqW.bj(this.MqX);
      this.MqW.Mqh = true;
      localb = this.MqW;
      AppMethodBeat.o(26587);
      return localb;
    }
    b localb = this.MqW;
    AppMethodBeat.o(26587);
    return localb;
  }
  
  public final void gsY()
  {
    AppMethodBeat.i(26582);
    super.gsY();
    AppMethodBeat.o(26582);
  }
  
  protected final boolean gta()
  {
    AppMethodBeat.i(267289);
    boolean bool = getIntent().getBooleanExtra("can_show_create_poi_tips", true);
    AppMethodBeat.o(267289);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26581);
    this.FyH = getIntent().getBooleanExtra("is_force_dark_mode", false);
    this.Mra = getIntent().getBooleanExtra("show_city", true);
    super.onCreate(paramBundle);
    setMMTitle(R.l.gOj);
    this.MqY = com.tencent.mm.modelgeo.c.bJh();
    this.MqZ = new dgz();
    this.MqP = getIntent().getStringExtra("get_poi_classify_id");
    try
    {
      this.MqZ = ((dgz)this.MqZ.parseFrom(getIntent().getByteArrayExtra("get_poi_item_buf")));
      if (this.MqZ != null) {
        this.MqP = this.MqZ.MpI;
      }
      if (Util.isNullOrNil(this.MqP)) {
        this.city = getIntent().getStringExtra("get_city");
      }
      if ((!Util.isNullOrNil(this.city)) && (this.Mra)) {
        this.MqP = this.MqV.kG(this.city, "").MpI;
      }
      this.MqV.MqP = this.MqP;
      if ((this.MqZ != null) && (!Util.isNullOrNil(this.MqZ.MpI)))
      {
        paramBundle = this.MqV;
        localb = new com.tencent.mm.plugin.nearlife.b.b("", this.MqZ);
        if (paramBundle.MqN == null) {
          paramBundle.a(localb, 1);
        }
      }
      else
      {
        if (this.FyH)
        {
          setActionbarColor(getContext().getResources().getColor(a.d.dark_actionbar_color));
          setBackBtnColorFilter(R.e.White);
          setMMTitleColor(R.e.White);
          this.KhR.setBackgroundColor(getContext().getResources().getColor(R.e.Dark_0));
          setBackGroundColorResource(R.e.Dark_0);
          setIsDarkActionbarBg(true);
          this.lMw.Bva = true;
        }
        AppMethodBeat.o(26581);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        com.tencent.mm.plugin.nearlife.b.b localb;
        Log.printErrStackTrace("MicroMsg.CheckInLifeUI", paramBundle, "", new Object[0]);
        this.MqZ = null;
        continue;
        paramBundle.a(localb, 2);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26584);
    super.onDestroy();
    if (this.MqY != null) {
      this.MqY.a(this.Mrc);
    }
    e.xfd.a("SnsPublishProcess", "poiPageStaytime_", Long.valueOf(getActivityBrowseTimeMs()), com.tencent.mm.plugin.comm.b.c.xeT);
    AppMethodBeat.o(26584);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26585);
    super.onPause();
    AppMethodBeat.o(26585);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26583);
    super.onResume();
    AppMethodBeat.o(26583);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void r(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(26588);
    Log.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    if ((this.MqY != null) && (Util.isNullOrNil(this.city))) {
      this.MqY.a(paramDouble1, paramDouble2, this.Mrc);
    }
    AppMethodBeat.o(26588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI
 * JD-Core Version:    0.7.0.1
 */