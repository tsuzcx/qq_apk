package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI
  extends BaseLifeUI
  implements g
{
  private String exW;
  String hiu;
  private View.OnClickListener oPc;
  private String vlD;
  private b vlJ;
  private b vlK;
  private ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> vlL;
  private c vlM;
  private boy vlN;
  private View.OnClickListener vlO;
  private c.a vlP;
  private boolean vlt;
  
  public CheckInLifeUI()
  {
    AppMethodBeat.i(26580);
    this.vlM = null;
    this.exW = "";
    this.vlD = "";
    this.vlt = false;
    this.oPc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26577);
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousView, false);
        AppMethodBeat.o(26577);
      }
    };
    this.vlO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26578);
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousView, true);
        AppMethodBeat.o(26578);
      }
    };
    this.vlP = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(26579);
        ac.i("MicroMsg.CheckInLifeUI", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!bs.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this)))
        {
          AppMethodBeat.o(26579);
          return;
        }
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousAddr.hEv);
        if (!bs.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this))) {
          CheckInLifeUI.b(CheckInLifeUI.this).ib(CheckInLifeUI.a(CheckInLifeUI.this), paramAnonymousAddr.hED);
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
    ac.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + localArrayList.size());
    AppMethodBeat.o(26589);
    return localArrayList;
  }
  
  public final a djT()
  {
    AppMethodBeat.i(26586);
    if (this.vlL == null) {
      this.vlL = ap(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (getIntent().getStringExtra("select_radio_icon_color") != null) {
      this.hiu = getIntent().getStringExtra("select_radio_icon_color");
    }
    if ((getIntent().getStringExtra("select_radio_icon_color") != null) && (getIntent().getStringExtra("get_poi_from_scene").equals("story")))
    {
      this.vlt = true;
      this.vlt = true;
    }
    if (this.vlJ == null)
    {
      this.vlJ = new b(this, this.oPc, "viewlist", this.vlu, false, this.hiu);
      if ((this.vlL != null) && (this.vlL.size() != 0))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.vlL.get(this.vlL.size() - 1));
        this.vlJ.ao((ArrayList)localObject);
        this.vlJ.vkU = false;
      }
      localObject = this.vlJ;
      AppMethodBeat.o(26586);
      return localObject;
    }
    Object localObject = this.vlJ;
    AppMethodBeat.o(26586);
    return localObject;
  }
  
  public final a djU()
  {
    AppMethodBeat.i(26587);
    if (this.vlL == null) {
      this.vlL = ap(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (this.vlK == null)
    {
      this.vlK = new b(this, this.vlO, "searchlist", this.vlu, true, this.hiu);
      this.vlK.ao(this.vlL);
      this.vlK.vkU = true;
      localb = this.vlK;
      AppMethodBeat.o(26587);
      return localb;
    }
    b localb = this.vlK;
    AppMethodBeat.o(26587);
    return localb;
  }
  
  public final void djV()
  {
    AppMethodBeat.i(26582);
    super.djV();
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
    this.vlM = c.aEI();
    this.vlN = new boy();
    this.vlD = getIntent().getStringExtra("get_poi_classify_id");
    try
    {
      this.vlN = ((boy)this.vlN.parseFrom(getIntent().getByteArrayExtra("get_poi_item_buf")));
      if (this.vlN != null) {
        this.vlD = this.vlN.vku;
      }
      if (bs.isNullOrNil(this.vlD)) {
        this.exW = getIntent().getStringExtra("get_city");
      }
      if (!bs.isNullOrNil(this.exW)) {
        this.vlD = this.vlJ.ib(this.exW, "").vku;
      }
      this.vlJ.vlD = this.vlD;
      if ((this.vlN != null) && (!bs.isNullOrNil(this.vlN.vku)))
      {
        paramBundle = this.vlJ;
        localb = new com.tencent.mm.plugin.nearlife.b.b("", this.vlN);
        if (paramBundle.vlB == null)
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
        ac.printErrStackTrace("MicroMsg.CheckInLifeUI", paramBundle, "", new Object[0]);
        this.vlN = null;
      }
      paramBundle.a(localb, 2);
      AppMethodBeat.o(26581);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26584);
    super.onDestroy();
    if (this.vlM != null) {
      this.vlM.a(this.vlP);
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
    ac.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    if ((this.vlM != null) && (bs.isNullOrNil(this.exW))) {
      this.vlM.a(paramDouble1, paramDouble2, this.vlP);
    }
    AppMethodBeat.o(26588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI
 * JD-Core Version:    0.7.0.1
 */