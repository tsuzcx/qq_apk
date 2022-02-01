package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI
  extends BaseLifeUI
  implements f
{
  private String eRg;
  String hDr;
  private View.OnClickListener pzq;
  private String wGE;
  private b wGK;
  private b wGL;
  private ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> wGM;
  private c wGN;
  private buf wGO;
  private View.OnClickListener wGP;
  private c.a wGQ;
  private boolean wGu;
  
  public CheckInLifeUI()
  {
    AppMethodBeat.i(26580);
    this.wGN = null;
    this.eRg = "";
    this.wGE = "";
    this.wGu = false;
    this.pzq = new CheckInLifeUI.1(this);
    this.wGP = new CheckInLifeUI.2(this);
    this.wGQ = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(26579);
        ae.i("MicroMsg.CheckInLifeUI", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!bu.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this)))
        {
          AppMethodBeat.o(26579);
          return;
        }
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousAddr.hZS);
        if (!bu.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this))) {
          CheckInLifeUI.b(CheckInLifeUI.this).is(CheckInLifeUI.a(CheckInLifeUI.this), paramAnonymousAddr.iaa);
        }
        AppMethodBeat.o(26579);
      }
    };
    AppMethodBeat.o(26580);
  }
  
  private static ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> ap(ArrayList<String> paramArrayList)
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
    ae.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + localArrayList.size());
    AppMethodBeat.o(26589);
    return localArrayList;
  }
  
  public final a dxu()
  {
    AppMethodBeat.i(26586);
    if (this.wGM == null) {
      this.wGM = ap(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (getIntent().getStringExtra("select_radio_icon_color") != null) {
      this.hDr = getIntent().getStringExtra("select_radio_icon_color");
    }
    if ((getIntent().getStringExtra("select_radio_icon_color") != null) && (getIntent().getStringExtra("get_poi_from_scene").equals("story")))
    {
      this.wGu = true;
      this.wGu = true;
    }
    if (this.wGK == null)
    {
      this.wGK = new b(this, this.pzq, "viewlist", this.wGv, false, this.hDr);
      if ((this.wGM != null) && (this.wGM.size() != 0))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.wGM.get(this.wGM.size() - 1));
        this.wGK.ao((ArrayList)localObject);
        this.wGK.wFV = false;
      }
      localObject = this.wGK;
      AppMethodBeat.o(26586);
      return localObject;
    }
    Object localObject = this.wGK;
    AppMethodBeat.o(26586);
    return localObject;
  }
  
  public final a dxv()
  {
    AppMethodBeat.i(26587);
    if (this.wGM == null) {
      this.wGM = ap(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (this.wGL == null)
    {
      this.wGL = new b(this, this.wGP, "searchlist", this.wGv, true, this.hDr);
      this.wGL.ao(this.wGM);
      this.wGL.wFV = true;
      localb = this.wGL;
      AppMethodBeat.o(26587);
      return localb;
    }
    b localb = this.wGL;
    AppMethodBeat.o(26587);
    return localb;
  }
  
  public final void dxw()
  {
    AppMethodBeat.i(26582);
    super.dxw();
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
    this.wGN = c.aIe();
    this.wGO = new buf();
    this.wGE = getIntent().getStringExtra("get_poi_classify_id");
    try
    {
      this.wGO = ((buf)this.wGO.parseFrom(getIntent().getByteArrayExtra("get_poi_item_buf")));
      if (this.wGO != null) {
        this.wGE = this.wGO.wFv;
      }
      if (bu.isNullOrNil(this.wGE)) {
        this.eRg = getIntent().getStringExtra("get_city");
      }
      if (!bu.isNullOrNil(this.eRg)) {
        this.wGE = this.wGK.is(this.eRg, "").wFv;
      }
      this.wGK.wGE = this.wGE;
      if ((this.wGO != null) && (!bu.isNullOrNil(this.wGO.wFv)))
      {
        paramBundle = this.wGK;
        localb = new com.tencent.mm.plugin.nearlife.b.b("", this.wGO);
        if (paramBundle.wGC == null)
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
        ae.printErrStackTrace("MicroMsg.CheckInLifeUI", paramBundle, "", new Object[0]);
        this.wGO = null;
      }
      paramBundle.a(localb, 2);
      AppMethodBeat.o(26581);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26584);
    super.onDestroy();
    if (this.wGN != null) {
      this.wGN.a(this.wGQ);
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
    ae.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    if ((this.wGN != null) && (bu.isNullOrNil(this.eRg))) {
      this.wGN.a(paramDouble1, paramDouble2, this.wGQ);
    }
    AppMethodBeat.o(26588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI
 * JD-Core Version:    0.7.0.1
 */