package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI
  extends BaseLifeUI
  implements i
{
  private boolean ABE;
  private String ABO;
  private b ABU;
  private b ABV;
  private ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> ABW;
  private c ABX;
  private chj ABY;
  private View.OnClickListener ABZ;
  private c.a ACa;
  private String fuK;
  String ixw;
  private View.OnClickListener qOH;
  
  public CheckInLifeUI()
  {
    AppMethodBeat.i(26580);
    this.ABX = null;
    this.fuK = "";
    this.ABO = "";
    this.ABE = false;
    this.qOH = new CheckInLifeUI.1(this);
    this.ABZ = new CheckInLifeUI.2(this);
    this.ACa = new c.a()
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
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousAddr.iUQ);
        if (!Util.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this))) {
          CheckInLifeUI.b(CheckInLifeUI.this).jd(CheckInLifeUI.a(CheckInLifeUI.this), paramAnonymousAddr.request_id);
        }
        AppMethodBeat.o(26579);
      }
    };
    AppMethodBeat.o(26580);
  }
  
  private static ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> aG(ArrayList<String> paramArrayList)
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
  
  public final a exc()
  {
    AppMethodBeat.i(26586);
    if (this.ABW == null) {
      this.ABW = aG(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (getIntent().getStringExtra("select_radio_icon_color") != null) {
      this.ixw = getIntent().getStringExtra("select_radio_icon_color");
    }
    if ((getIntent().getStringExtra("select_radio_icon_color") != null) && (getIntent().getStringExtra("get_poi_from_scene").equals("story")))
    {
      this.ABE = true;
      this.ABE = true;
    }
    if (this.ABU == null)
    {
      this.ABU = new b(this, this.qOH, "viewlist", this.ABF, false, this.ixw);
      if ((this.ABW != null) && (this.ABW.size() != 0))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.ABW.get(this.ABW.size() - 1));
        this.ABU.aF((ArrayList)localObject);
        this.ABU.ABg = false;
      }
      localObject = this.ABU;
      AppMethodBeat.o(26586);
      return localObject;
    }
    Object localObject = this.ABU;
    AppMethodBeat.o(26586);
    return localObject;
  }
  
  public final a exd()
  {
    AppMethodBeat.i(26587);
    if (this.ABW == null) {
      this.ABW = aG(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (this.ABV == null)
    {
      this.ABV = new b(this, this.ABZ, "searchlist", this.ABF, true, this.ixw);
      this.ABV.aF(this.ABW);
      this.ABV.ABg = true;
      localb = this.ABV;
      AppMethodBeat.o(26587);
      return localb;
    }
    b localb = this.ABV;
    AppMethodBeat.o(26587);
    return localb;
  }
  
  public final void exe()
  {
    AppMethodBeat.i(26582);
    super.exe();
    AppMethodBeat.o(26582);
  }
  
  public int getLayoutId()
  {
    return 2131495811;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26581);
    super.onCreate(paramBundle);
    setMMTitle(2131763427);
    this.ABX = c.bbX();
    this.ABY = new chj();
    this.ABO = getIntent().getStringExtra("get_poi_classify_id");
    try
    {
      this.ABY = ((chj)this.ABY.parseFrom(getIntent().getByteArrayExtra("get_poi_item_buf")));
      if (this.ABY != null) {
        this.ABO = this.ABY.AAG;
      }
      if (Util.isNullOrNil(this.ABO)) {
        this.fuK = getIntent().getStringExtra("get_city");
      }
      if (!Util.isNullOrNil(this.fuK)) {
        this.ABO = this.ABU.jd(this.fuK, "").AAG;
      }
      this.ABU.ABO = this.ABO;
      if ((this.ABY != null) && (!Util.isNullOrNil(this.ABY.AAG)))
      {
        paramBundle = this.ABU;
        localb = new com.tencent.mm.plugin.nearlife.b.b("", this.ABY);
        if (paramBundle.ABM == null)
        {
          paramBundle.a(localb, 1);
          AppMethodBeat.o(26581);
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      com.tencent.mm.plugin.nearlife.b.b localb;
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.CheckInLifeUI", paramBundle, "", new Object[0]);
        this.ABY = null;
      }
      paramBundle.a(localb, 2);
      AppMethodBeat.o(26581);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26584);
    super.onDestroy();
    if (this.ABX != null) {
      this.ABX.a(this.ACa);
    }
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
  
  public final void p(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(26588);
    Log.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    if ((this.ABX != null) && (Util.isNullOrNil(this.fuK))) {
      this.ABX.a(paramDouble1, paramDouble2, this.ACa);
    }
    AppMethodBeat.o(26588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI
 * JD-Core Version:    0.7.0.1
 */