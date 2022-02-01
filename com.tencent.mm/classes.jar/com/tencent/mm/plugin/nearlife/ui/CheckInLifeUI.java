package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.c.a;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI
  extends BaseLifeUI
  implements i
{
  private boolean AZM;
  private boolean GuG;
  private String GuQ;
  private b GuW;
  private b GuX;
  private ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> GuY;
  private c GuZ;
  private cqf Gva;
  private boolean Gvb;
  private View.OnClickListener Gvc;
  private c.a Gvd;
  private String city;
  String lmL;
  private View.OnClickListener uqL;
  
  public CheckInLifeUI()
  {
    AppMethodBeat.i(26580);
    this.GuZ = null;
    this.city = "";
    this.GuQ = "";
    this.GuG = false;
    this.AZM = false;
    this.Gvb = true;
    this.uqL = new CheckInLifeUI.1(this);
    this.Gvc = new CheckInLifeUI.2(this);
    this.Gvd = new c.a()
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
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousAddr.lLi);
        if ((!Util.isNullOrNil(CheckInLifeUI.a(CheckInLifeUI.this))) && (CheckInLifeUI.b(CheckInLifeUI.this))) {
          CheckInLifeUI.c(CheckInLifeUI.this).jp(CheckInLifeUI.a(CheckInLifeUI.this), paramAnonymousAddr.request_id);
        }
        AppMethodBeat.o(26579);
      }
    };
    AppMethodBeat.o(26580);
  }
  
  private static ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> aO(ArrayList<String> paramArrayList)
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
  
  public final a fiF()
  {
    AppMethodBeat.i(26586);
    if (this.GuY == null) {
      this.GuY = aO(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (getIntent().getStringExtra("select_radio_icon_color") != null) {
      this.lmL = getIntent().getStringExtra("select_radio_icon_color");
    }
    if ((getIntent().getStringExtra("select_radio_icon_color") != null) && (getIntent().getStringExtra("get_poi_from_scene").equals("story")))
    {
      this.GuG = true;
      this.GuG = true;
    }
    if (this.GuW == null)
    {
      this.GuW = new b(this, this.uqL, "viewlist", this.GuH, false, this.lmL, this.AZM);
      if ((this.GuY != null) && (this.GuY.size() != 0))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.GuY.get(this.GuY.size() - 1));
        this.GuW.aN((ArrayList)localObject);
        this.GuW.Gui = false;
      }
      localObject = this.GuW;
      AppMethodBeat.o(26586);
      return localObject;
    }
    Object localObject = this.GuW;
    AppMethodBeat.o(26586);
    return localObject;
  }
  
  public final a fiG()
  {
    AppMethodBeat.i(26587);
    if (this.GuY == null) {
      this.GuY = aO(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (this.GuX == null)
    {
      this.GuX = new b(this, this.Gvc, "searchlist", this.GuH, true, this.lmL, this.AZM);
      this.GuX.aN(this.GuY);
      this.GuX.Gui = true;
      localb = this.GuX;
      AppMethodBeat.o(26587);
      return localb;
    }
    b localb = this.GuX;
    AppMethodBeat.o(26587);
    return localb;
  }
  
  public final void fiH()
  {
    AppMethodBeat.i(26582);
    super.fiH();
    AppMethodBeat.o(26582);
  }
  
  protected final boolean gBE()
  {
    AppMethodBeat.i(293326);
    boolean bool = getIntent().getBooleanExtra("can_show_create_poi_tips", true);
    AppMethodBeat.o(293326);
    return bool;
  }
  
  public int getLayoutId()
  {
    return R.i.ejq;
  }
  
  public final void n(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(26588);
    Log.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    if ((this.GuZ != null) && (Util.isNullOrNil(this.city))) {
      this.GuZ.a(paramDouble1, paramDouble2, this.Gvd);
    }
    AppMethodBeat.o(26588);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26581);
    this.AZM = getIntent().getBooleanExtra("is_force_dark_mode", false);
    this.Gvb = getIntent().getBooleanExtra("show_city", true);
    super.onCreate(paramBundle);
    setMMTitle(R.l.eMl);
    this.GuZ = c.bln();
    this.Gva = new cqf();
    this.GuQ = getIntent().getStringExtra("get_poi_classify_id");
    try
    {
      this.Gva = ((cqf)this.Gva.parseFrom(getIntent().getByteArrayExtra("get_poi_item_buf")));
      if (this.Gva != null) {
        this.GuQ = this.Gva.GtI;
      }
      if (Util.isNullOrNil(this.GuQ)) {
        this.city = getIntent().getStringExtra("get_city");
      }
      if ((!Util.isNullOrNil(this.city)) && (this.Gvb)) {
        this.GuQ = this.GuW.jp(this.city, "").GtI;
      }
      this.GuW.GuQ = this.GuQ;
      if ((this.Gva != null) && (!Util.isNullOrNil(this.Gva.GtI)))
      {
        paramBundle = this.GuW;
        localb = new com.tencent.mm.plugin.nearlife.b.b("", this.Gva);
        if (paramBundle.GuO == null) {
          paramBundle.a(localb, 1);
        }
      }
      else
      {
        if (this.AZM)
        {
          setActionbarColor(getContext().getResources().getColor(a.d.dark_actionbar_color));
          setBackBtnColorFilter(-1);
          setMMTitleColor(-1);
          this.Epk.setBackgroundColor(getContext().getResources().getColor(R.e.Dark_0));
          setBackGroundColorResource(R.e.Dark_0);
          setIsDarkActionbarBg(true);
          this.jjS.xUe = true;
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
        this.Gva = null;
        continue;
        paramBundle.a(localb, 2);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26584);
    super.onDestroy();
    if (this.GuZ != null) {
      this.GuZ.a(this.Gvd);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI
 * JD-Core Version:    0.7.0.1
 */