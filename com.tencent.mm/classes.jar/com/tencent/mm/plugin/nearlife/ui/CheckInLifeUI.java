package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI
  extends BaseLifeUI
  implements f
{
  private String city;
  String color;
  private View.OnClickListener nyO;
  private boolean peV;
  private String pff;
  private b pfl;
  private b pfm;
  private ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> pfn;
  private c pfo;
  private azs pfp;
  private View.OnClickListener pfq;
  private c.a pfr;
  
  public CheckInLifeUI()
  {
    AppMethodBeat.i(22956);
    this.pfo = null;
    this.city = "";
    this.pff = "";
    this.peV = false;
    this.nyO = new CheckInLifeUI.1(this);
    this.pfq = new CheckInLifeUI.2(this);
    this.pfr = new c.a()
    {
      public final void b(Addr paramAnonymousAddr)
      {
        AppMethodBeat.i(22955);
        ab.i("MicroMsg.CheckInLifeUI", "get info %s", new Object[] { paramAnonymousAddr.toString() });
        if (!bo.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this)))
        {
          AppMethodBeat.o(22955);
          return;
        }
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousAddr.fBs);
        if (!bo.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this))) {
          CheckInLifeUI.b(CheckInLifeUI.this).fB(CheckInLifeUI.a(CheckInLifeUI.this), paramAnonymousAddr.fBA);
        }
        AppMethodBeat.o(22955);
      }
    };
    AppMethodBeat.o(22956);
  }
  
  private static ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> L(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(22965);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(22965);
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
    ab.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + localArrayList.size());
    AppMethodBeat.o(22965);
    return localArrayList;
  }
  
  public final a bWL()
  {
    AppMethodBeat.i(22962);
    if (this.pfn == null) {
      this.pfn = L(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (getIntent().getStringExtra("select_radio_icon_color") != null) {
      this.color = getIntent().getStringExtra("select_radio_icon_color");
    }
    if ((getIntent().getStringExtra("select_radio_icon_color") != null) && (getIntent().getStringExtra("get_poi_from_scene").equals("story")))
    {
      this.peV = true;
      this.peV = true;
    }
    if (this.pfl == null)
    {
      this.pfl = new b(this, this.nyO, "viewlist", this.peW, false, this.color);
      if ((this.pfn != null) && (this.pfn.size() != 0))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.pfn.get(this.pfn.size() - 1));
        this.pfl.K((ArrayList)localObject);
        this.pfl.pew = false;
      }
      localObject = this.pfl;
      AppMethodBeat.o(22962);
      return localObject;
    }
    Object localObject = this.pfl;
    AppMethodBeat.o(22962);
    return localObject;
  }
  
  public final a bWM()
  {
    AppMethodBeat.i(22963);
    if (this.pfn == null) {
      this.pfn = L(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (this.pfm == null)
    {
      this.pfm = new b(this, this.pfq, "searchlist", this.peW, true, this.color);
      this.pfm.K(this.pfn);
      this.pfm.pew = true;
      localb = this.pfm;
      AppMethodBeat.o(22963);
      return localb;
    }
    b localb = this.pfm;
    AppMethodBeat.o(22963);
    return localb;
  }
  
  public final void bWN()
  {
    AppMethodBeat.i(22958);
    super.bWN();
    AppMethodBeat.o(22958);
  }
  
  public int getLayoutId()
  {
    return 2130970341;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22957);
    super.onCreate(paramBundle);
    setMMTitle(2131301739);
    this.pfo = c.agN();
    this.pfp = new azs();
    this.pff = getIntent().getStringExtra("get_poi_classify_id");
    try
    {
      this.pfp = ((azs)this.pfp.parseFrom(getIntent().getByteArrayExtra("get_poi_item_buf")));
      if (this.pfp != null) {
        this.pff = this.pfp.pdW;
      }
      if (bo.isNullOrNil(this.pff)) {
        this.city = getIntent().getStringExtra("get_city");
      }
      if (!bo.isNullOrNil(this.city)) {
        this.pff = this.pfl.fB(this.city, "").pdW;
      }
      this.pfl.pff = this.pff;
      if ((this.pfp != null) && (!bo.isNullOrNil(this.pfp.pdW)))
      {
        paramBundle = this.pfl;
        locala = new com.tencent.mm.plugin.nearlife.b.a("", this.pfp);
        if (paramBundle.pfd == null)
        {
          paramBundle.a(locala, 1);
          AppMethodBeat.o(22957);
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      com.tencent.mm.plugin.nearlife.b.a locala;
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.CheckInLifeUI", paramBundle, "", new Object[0]);
        this.pfp = null;
      }
      paramBundle.a(locala, 2);
      AppMethodBeat.o(22957);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22960);
    super.onDestroy();
    if (this.pfo != null) {
      this.pfo.a(this.pfr);
    }
    AppMethodBeat.o(22960);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22961);
    super.onPause();
    AppMethodBeat.o(22961);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22959);
    super.onResume();
    AppMethodBeat.o(22959);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void p(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(22964);
    ab.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    if ((this.pfo != null) && (bo.isNullOrNil(this.city))) {
      this.pfo.a(paramDouble1, paramDouble2, this.pfr);
    }
    AppMethodBeat.o(22964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI
 * JD-Core Version:    0.7.0.1
 */