package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.m;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;

@com.tencent.mm.ui.base.a(3)
public class ProfileHdHeadImg
  extends MMActivity
{
  private String hkq = null;
  private GetHdHeadImageGalleryView qGl;
  private e qGm;
  private String username = null;
  private String vRz = null;
  
  private void d(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(27528);
    try
    {
      Object localObject = com.tencent.mm.sdk.platformtools.d.a(paramBitmap, false, 0.1F);
      a.a.yio.p(this.username, (Bitmap)localObject);
      if (paramBitmap.getWidth() < 480)
      {
        float f = 480 / paramBitmap.getWidth();
        localObject = new Matrix();
        ((Matrix)localObject).postScale(f, f);
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      }
      ab.d("MicroMsg.ProfileHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
      this.qGl.setHdHeadImage((Bitmap)localObject);
      this.qGl.setHdHeadImagePath(paramString);
      AppMethodBeat.o(27528);
      return;
    }
    catch (Exception paramBitmap)
    {
      ab.printErrStackTrace("MicroMsg.ProfileHdHeadImg", paramBitmap, "", new Object[0]);
      AppMethodBeat.o(27528);
    }
  }
  
  public int getLayoutId()
  {
    return 2130969838;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27526);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    this.username = getIntent().getStringExtra("username");
    this.hkq = getIntent().getStringExtra("brand_icon_url");
    setActionbarColor(getResources().getColor(2131689481));
    setNavigationbarColor(getResources().getColor(2131689481));
    this.qGl = ((GetHdHeadImageGalleryView)findViewById(2131822137));
    this.qGl.setUsername(this.username);
    this.qGl.setSingleClickOverListener(new ProfileHdHeadImg.1(this));
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      t.ii(this);
      d(o.acQ().bZ(this), null);
      AppMethodBeat.o(27526);
      return;
    }
    Object localObject;
    if (!bo.isNullOrNil(this.hkq))
    {
      paramBundle = m.aE(this.username, this.hkq);
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = BitmapFactory.decodeResource(getResources(), 2130838493);
      }
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label313;
      }
      ab.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.qGl.setThumbImage((Bitmap)localObject);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(this.vRz)) {
        this.username = this.vRz;
      }
      o.acQ();
      paramBundle = com.tencent.mm.ah.d.rb(this.username);
      if ((paramBundle == null) || (paramBundle.isRecycled())) {
        break label335;
      }
      ab.i("MicroMsg.ProfileHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      o.acQ();
      d(paramBundle, com.tencent.mm.ah.d.D(this.username, true));
      AppMethodBeat.o(27526);
      return;
      paramBundle = b.b(this.username, true, -1);
      break;
      label313:
      ab.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    label335:
    this.qGm = new e();
    this.qGm.a(this.username, new ProfileHdHeadImg.2(this, (Bitmap)localObject));
    AppMethodBeat.o(27526);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27527);
    super.onDestroy();
    AppMethodBeat.o(27527);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg
 * JD-Core Version:    0.7.0.1
 */