package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI
  extends BaseLifeUI
  implements f
{
  private String cCB = "";
  private View.OnClickListener laS = new CheckInLifeUI.1(this);
  private String mEZ = "";
  private b mFf;
  private b mFg;
  private ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> mFh;
  private com.tencent.mm.modelgeo.b mFi = null;
  private atn mFj;
  private View.OnClickListener mFk = new CheckInLifeUI.2(this);
  private b.a mFl = new b.a()
  {
    public final void b(Addr paramAnonymousAddr)
    {
      y.i("MicroMsg.CheckInLifeUI", "get info %s", new Object[] { paramAnonymousAddr.toString() });
      if (!bk.bl(CheckInLifeUI.a(CheckInLifeUI.this))) {}
      do
      {
        return;
        CheckInLifeUI.a(CheckInLifeUI.this, paramAnonymousAddr.elb);
      } while (bk.bl(CheckInLifeUI.a(CheckInLifeUI.this)));
      CheckInLifeUI.b(CheckInLifeUI.this).eh(CheckInLifeUI.a(CheckInLifeUI.this), paramAnonymousAddr.elj);
    }
  };
  
  private static ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> J(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
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
    y.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + localArrayList.size());
    return localArrayList;
  }
  
  public final a bom()
  {
    if (this.mFh == null) {
      this.mFh = J(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (this.mFf == null)
    {
      this.mFf = new b(this, this.laS, "viewlist", false);
      if ((this.mFh != null) && (this.mFh.size() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.mFh.get(this.mFh.size() - 1));
        this.mFf.I(localArrayList);
        this.mFf.mEt = false;
      }
      return this.mFf;
    }
    return this.mFf;
  }
  
  public final a bon()
  {
    if (this.mFh == null) {
      this.mFh = J(getIntent().getStringArrayListExtra("lat_long_list"));
    }
    if (this.mFg == null)
    {
      this.mFg = new b(this, this.mFk, "searchlist", true);
      this.mFg.I(this.mFh);
      this.mFg.mEt = true;
      return this.mFg;
    }
    return this.mFg;
  }
  
  public final void boo()
  {
    super.boo();
  }
  
  protected final int getLayoutId()
  {
    return R.i.near_life_ui;
  }
  
  public final void m(double paramDouble1, double paramDouble2)
  {
    y.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    if ((this.mFi != null) && (bk.bl(this.cCB))) {
      this.mFi.a(paramDouble1, paramDouble2, this.mFl);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.near_check_list);
    this.mFi = com.tencent.mm.modelgeo.b.NZ();
    this.mFj = new atn();
    this.mEZ = getIntent().getStringExtra("get_poi_classify_id");
    try
    {
      this.mFj = ((atn)this.mFj.aH(getIntent().getByteArrayExtra("get_poi_item_buf")));
      if (this.mFj != null) {
        this.mEZ = this.mFj.mDU;
      }
      if (bk.bl(this.mEZ)) {
        this.cCB = getIntent().getStringExtra("get_city");
      }
      if (!bk.bl(this.cCB)) {
        this.mEZ = this.mFf.eh(this.cCB, "").mDU;
      }
      this.mFf.mEZ = this.mEZ;
      if ((this.mFj != null) && (!bk.bl(this.mFj.mDU)))
      {
        paramBundle = this.mFf;
        locala = new com.tencent.mm.plugin.nearlife.b.a("", this.mFj);
        if (paramBundle.mEX == null) {
          paramBundle.a(locala, 1);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception paramBundle)
    {
      com.tencent.mm.plugin.nearlife.b.a locala;
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.CheckInLifeUI", paramBundle, "", new Object[0]);
        this.mFj = null;
      }
      paramBundle.a(locala, 2);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mFi != null) {
      this.mFi.a(this.mFl);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI
 * JD-Core Version:    0.7.0.1
 */