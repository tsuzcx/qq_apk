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
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.f.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.o;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

@com.tencent.mm.ui.base.a(3)
public class ProfileHdHeadImg
  extends MMActivity
{
  private String FlY = null;
  private String duL = null;
  private String username = null;
  private GetHdHeadImageGalleryView yUA;
  private f yUB;
  
  private void d(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(31230);
    try
    {
      Object localObject = h.a(paramBitmap, false, 0.1F);
      a.a.InF.p(this.username, (Bitmap)localObject);
      if (paramBitmap.getWidth() < 480)
      {
        float f = 480 / paramBitmap.getWidth();
        localObject = new Matrix();
        ((Matrix)localObject).postScale(f, f);
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      }
      ae.d("MicroMsg.ProfileHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
      this.yUA.setHdHeadImage((Bitmap)localObject);
      this.yUA.setHdHeadImagePath(paramString);
      AppMethodBeat.o(31230);
      return;
    }
    catch (Exception paramBitmap)
    {
      ae.printErrStackTrace("MicroMsg.ProfileHdHeadImg", paramBitmap, "", new Object[0]);
      AppMethodBeat.o(31230);
    }
  }
  
  public int getLayoutId()
  {
    return 2131494409;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(31228);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.username = getIntent().getStringExtra("username");
    this.duL = getIntent().getStringExtra("brand_icon_url");
    setActionbarColor(getResources().getColor(2131099654));
    setNavigationbarColor(getResources().getColor(2131099654));
    this.yUA = ((GetHdHeadImageGalleryView)findViewById(2131300335));
    this.yUA.setUsername(this.username);
    this.yUA.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void aRO()
      {
        AppMethodBeat.i(31226);
        ProfileHdHeadImg.this.finish();
        AppMethodBeat.o(31226);
      }
    });
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(this, null);
      d(p.aEA().cA(this), null);
      AppMethodBeat.o(31228);
      return;
    }
    Object localObject;
    if (!bu.isNullOrNil(this.duL))
    {
      paramBundle = o.bc(this.username, this.duL);
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = BitmapFactory.decodeResource(getResources(), 2131231875);
      }
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label322;
      }
      ae.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.yUA.setThumbImage((Bitmap)localObject);
    }
    for (;;)
    {
      if (!bu.isNullOrNil(this.FlY)) {
        this.username = this.FlY;
      }
      p.aEA();
      paramBundle = e.DD(this.username);
      if ((paramBundle == null) || (paramBundle.isRecycled())) {
        break label344;
      }
      ae.i("MicroMsg.ProfileHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      p.aEA();
      d(paramBundle, e.J(this.username, true));
      AppMethodBeat.o(31228);
      return;
      paramBundle = com.tencent.mm.aj.c.a(this.username, true, -1, null);
      break;
      label322:
      ae.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    label344:
    this.yUB = new f();
    this.yUB.a(this.username, new f.c()
    {
      public final int df(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(31227);
        ProfileHdHeadImg.a(ProfileHdHeadImg.this).sN();
        ae.i("MicroMsg.ProfileHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          p.aEA();
          Bitmap localBitmap = e.DD(ProfileHdHeadImg.b(ProfileHdHeadImg.this));
          if (localBitmap != null)
          {
            ProfileHdHeadImg localProfileHdHeadImg = ProfileHdHeadImg.this;
            p.aEA();
            ProfileHdHeadImg.a(localProfileHdHeadImg, localBitmap, e.J(ProfileHdHeadImg.b(ProfileHdHeadImg.this), true));
          }
          for (;;)
          {
            AppMethodBeat.o(31227);
            return 0;
            ProfileHdHeadImg.a(ProfileHdHeadImg.this, this.yUF, null);
          }
        }
        ProfileHdHeadImg.a(ProfileHdHeadImg.this, this.yUF, null);
        AppMethodBeat.o(31227);
        return 0;
      }
    });
    AppMethodBeat.o(31228);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(31229);
    super.onDestroy();
    AppMethodBeat.o(31229);
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