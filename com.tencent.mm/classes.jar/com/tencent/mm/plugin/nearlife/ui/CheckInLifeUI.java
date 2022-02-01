package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI
  extends BaseLifeUI
  implements g
{
  private String evA;
  String gHT;
  private View.OnClickListener olC;
  private String ucE;
  private b ucK;
  private b ucL;
  private ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> ucM;
  private c ucN;
  private blc ucO;
  private View.OnClickListener ucP;
  private c.a ucQ;
  private boolean ucu;
  
  public CheckInLifeUI()
  {
    AppMethodBeat.i(26580);
    this.ucN = null;
    this.evA = "";
    this.ucE = "";
    this.ucu = false;
    this.olC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26577);
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousView, false);
        AppMethodBeat.o(26577);
      }
    };
    this.ucP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26578);
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousView, true);
        AppMethodBeat.o(26578);
      }
    };
    this.ucQ = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(26579);
        ad.i("MicroMsg.CheckInLifeUI", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!bt.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this)))
        {
          AppMethodBeat.o(26579);
          return;
        }
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousAddr.hdS);
        if (!bt.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this))) {
          CheckInLifeUI.b(CheckInLifeUI.this).hI(CheckInLifeUI.a(CheckInLifeUI.this), paramAnonymousAddr.hea);
        }
        AppMethodBeat.o(26579);
      }
    };
    AppMethodBeat.o(26580);
  }
  
  private static ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> ae(ArrayList<String> paramArrayList)
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
    ad.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + localArrayList.size());
    AppMethodBeat.o(26589);
    return localArrayList;
  }
  
  public final a cWl()
  {
    AppMethodBeat.i(26586);
    if (this.ucM == null) {
      this.ucM = ae(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (getIntent().getStringExtra("select_radio_icon_color") != null) {
      this.gHT = getIntent().getStringExtra("select_radio_icon_color");
    }
    if ((getIntent().getStringExtra("select_radio_icon_color") != null) && (getIntent().getStringExtra("get_poi_from_scene").equals("story")))
    {
      this.ucu = true;
      this.ucu = true;
    }
    if (this.ucK == null)
    {
      this.ucK = new b(this, this.olC, "viewlist", this.ucv, false, this.gHT);
      if ((this.ucM != null) && (this.ucM.size() != 0))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.ucM.get(this.ucM.size() - 1));
        this.ucK.ad((ArrayList)localObject);
        this.ucK.ubV = false;
      }
      localObject = this.ucK;
      AppMethodBeat.o(26586);
      return localObject;
    }
    Object localObject = this.ucK;
    AppMethodBeat.o(26586);
    return localObject;
  }
  
  public final a cWm()
  {
    AppMethodBeat.i(26587);
    if (this.ucM == null) {
      this.ucM = ae(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (this.ucL == null)
    {
      this.ucL = new b(this, this.ucP, "searchlist", this.ucv, true, this.gHT);
      this.ucL.ad(this.ucM);
      this.ucL.ubV = true;
      localb = this.ucL;
      AppMethodBeat.o(26587);
      return localb;
    }
    b localb = this.ucL;
    AppMethodBeat.o(26587);
    return localb;
  }
  
  public final void cWn()
  {
    AppMethodBeat.i(26582);
    super.cWn();
    AppMethodBeat.o(26582);
  }
  
  public int getLayoutId()
  {
    return 2131494998;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26581);
    super.onCreate(paramBundle);
    setMMTitle(2131761485);
    this.ucN = c.axQ();
    this.ucO = new blc();
    this.ucE = getIntent().getStringExtra("get_poi_classify_id");
    try
    {
      this.ucO = ((blc)this.ucO.parseFrom(getIntent().getByteArrayExtra("get_poi_item_buf")));
      if (this.ucO != null) {
        this.ucE = this.ucO.ubw;
      }
      if (bt.isNullOrNil(this.ucE)) {
        this.evA = getIntent().getStringExtra("get_city");
      }
      if (!bt.isNullOrNil(this.evA)) {
        this.ucE = this.ucK.hI(this.evA, "").ubw;
      }
      this.ucK.ucE = this.ucE;
      if ((this.ucO != null) && (!bt.isNullOrNil(this.ucO.ubw)))
      {
        paramBundle = this.ucK;
        localb = new com.tencent.mm.plugin.nearlife.b.b("", this.ucO);
        if (paramBundle.ucC == null)
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
        ad.printErrStackTrace("MicroMsg.CheckInLifeUI", paramBundle, "", new Object[0]);
        this.ucO = null;
      }
      paramBundle.a(localb, 2);
      AppMethodBeat.o(26581);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26584);
    super.onDestroy();
    if (this.ucN != null) {
      this.ucN.a(this.ucQ);
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
    ad.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    if ((this.ucN != null) && (bt.isNullOrNil(this.evA))) {
      this.ucN.a(paramDouble1, paramDouble2, this.ucQ);
    }
    AppMethodBeat.o(26588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI
 * JD-Core Version:    0.7.0.1
 */