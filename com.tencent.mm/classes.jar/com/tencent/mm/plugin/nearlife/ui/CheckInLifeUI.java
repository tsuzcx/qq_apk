package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI
  extends BaseLifeUI
  implements f
{
  private String ePv;
  String hAD;
  private View.OnClickListener psK;
  private boolean wqL;
  private String wqV;
  private b wrb;
  private b wrc;
  private ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> wrd;
  private c wre;
  private btl wrf;
  private View.OnClickListener wrg;
  private c.a wrh;
  
  public CheckInLifeUI()
  {
    AppMethodBeat.i(26580);
    this.wre = null;
    this.ePv = "";
    this.wqV = "";
    this.wqL = false;
    this.psK = new CheckInLifeUI.1(this);
    this.wrg = new CheckInLifeUI.2(this);
    this.wrh = new c.a()
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
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousAddr.hXa);
        if (!bt.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this))) {
          CheckInLifeUI.b(CheckInLifeUI.this).im(CheckInLifeUI.a(CheckInLifeUI.this), paramAnonymousAddr.hXi);
        }
        AppMethodBeat.o(26579);
      }
    };
    AppMethodBeat.o(26580);
  }
  
  private static ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> ao(ArrayList<String> paramArrayList)
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
  
  public final a duf()
  {
    AppMethodBeat.i(26586);
    if (this.wrd == null) {
      this.wrd = ao(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (getIntent().getStringExtra("select_radio_icon_color") != null) {
      this.hAD = getIntent().getStringExtra("select_radio_icon_color");
    }
    if ((getIntent().getStringExtra("select_radio_icon_color") != null) && (getIntent().getStringExtra("get_poi_from_scene").equals("story")))
    {
      this.wqL = true;
      this.wqL = true;
    }
    if (this.wrb == null)
    {
      this.wrb = new b(this, this.psK, "viewlist", this.wqM, false, this.hAD);
      if ((this.wrd != null) && (this.wrd.size() != 0))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.wrd.get(this.wrd.size() - 1));
        this.wrb.an((ArrayList)localObject);
        this.wrb.wqm = false;
      }
      localObject = this.wrb;
      AppMethodBeat.o(26586);
      return localObject;
    }
    Object localObject = this.wrb;
    AppMethodBeat.o(26586);
    return localObject;
  }
  
  public final a dug()
  {
    AppMethodBeat.i(26587);
    if (this.wrd == null) {
      this.wrd = ao(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (this.wrc == null)
    {
      this.wrc = new b(this, this.wrg, "searchlist", this.wqM, true, this.hAD);
      this.wrc.an(this.wrd);
      this.wrc.wqm = true;
      localb = this.wrc;
      AppMethodBeat.o(26587);
      return localb;
    }
    b localb = this.wrc;
    AppMethodBeat.o(26587);
    return localb;
  }
  
  public final void duh()
  {
    AppMethodBeat.i(26582);
    super.duh();
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
    this.wre = c.aHN();
    this.wrf = new btl();
    this.wqV = getIntent().getStringExtra("get_poi_classify_id");
    try
    {
      this.wrf = ((btl)this.wrf.parseFrom(getIntent().getByteArrayExtra("get_poi_item_buf")));
      if (this.wrf != null) {
        this.wqV = this.wrf.wpM;
      }
      if (bt.isNullOrNil(this.wqV)) {
        this.ePv = getIntent().getStringExtra("get_city");
      }
      if (!bt.isNullOrNil(this.ePv)) {
        this.wqV = this.wrb.im(this.ePv, "").wpM;
      }
      this.wrb.wqV = this.wqV;
      if ((this.wrf != null) && (!bt.isNullOrNil(this.wrf.wpM)))
      {
        paramBundle = this.wrb;
        localb = new com.tencent.mm.plugin.nearlife.b.b("", this.wrf);
        if (paramBundle.wqT == null)
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
        this.wrf = null;
      }
      paramBundle.a(localb, 2);
      AppMethodBeat.o(26581);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26584);
    super.onDestroy();
    if (this.wre != null) {
      this.wre.a(this.wrh);
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
    if ((this.wre != null) && (bt.isNullOrNil(this.ePv))) {
      this.wre.a(paramDouble1, paramDouble2, this.wrh);
    }
    AppMethodBeat.o(26588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI
 * JD-Core Version:    0.7.0.1
 */