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
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

@com.tencent.mm.ui.base.a(3)
public class ProfileHdHeadImg
  extends MMActivity
{
  private GetHdHeadImageGalleryView CZq;
  private f CZr;
  private String KcQ = null;
  private String dMf = null;
  private String username = null;
  
  private void d(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(31230);
    try
    {
      Object localObject = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, 0.1F);
      a.a.NAL.p(this.username, (Bitmap)localObject);
      if (paramBitmap.getWidth() < 480)
      {
        float f = 480 / paramBitmap.getWidth();
        localObject = new Matrix();
        ((Matrix)localObject).postScale(f, f);
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      }
      Log.d("MicroMsg.ProfileHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
      this.CZq.setHdHeadImage((Bitmap)localObject);
      this.CZq.setHdHeadImagePath(paramString);
      AppMethodBeat.o(31230);
      return;
    }
    catch (Exception paramBitmap)
    {
      Log.printErrStackTrace("MicroMsg.ProfileHdHeadImg", paramBitmap, "", new Object[0]);
      AppMethodBeat.o(31230);
    }
  }
  
  public int getLayoutId()
  {
    return 2131494981;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(31228);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.username = getIntent().getStringExtra("username");
    this.dMf = getIntent().getStringExtra("brand_icon_url");
    setActionbarColor(getResources().getColor(2131099654));
    setNavigationbarColor(getResources().getColor(2131099654));
    this.CZq = ((GetHdHeadImageGalleryView)findViewById(2131301853));
    this.CZq.setUsername(this.username);
    this.CZq.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void bmt()
      {
        AppMethodBeat.i(31226);
        ProfileHdHeadImg.this.finish();
        AppMethodBeat.o(31226);
      }
    });
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      u.g(this, null);
      d(p.aYn().cW(this), null);
      AppMethodBeat.o(31228);
      return;
    }
    Object localObject;
    if (!Util.isNullOrNil(this.dMf))
    {
      paramBundle = o.bg(this.username, this.dMf);
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = BitmapFactory.decodeResource(getResources(), 2131231957);
      }
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label322;
      }
      Log.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.CZq.setThumbImage((Bitmap)localObject);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.KcQ)) {
        this.username = this.KcQ;
      }
      p.aYn();
      paramBundle = e.Mo(this.username);
      if ((paramBundle == null) || (paramBundle.isRecycled())) {
        break label344;
      }
      Log.i("MicroMsg.ProfileHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      p.aYn();
      d(paramBundle, e.L(this.username, true));
      AppMethodBeat.o(31228);
      return;
      paramBundle = com.tencent.mm.aj.c.a(this.username, true, -1, null);
      break;
      label322:
      Log.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    label344:
    this.CZr = new f();
    this.CZr.a(this.username, new f.c()
    {
      public final int dp(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(31227);
        ProfileHdHeadImg.a(ProfileHdHeadImg.this).sQ();
        Log.i("MicroMsg.ProfileHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          p.aYn();
          Bitmap localBitmap = e.Mo(ProfileHdHeadImg.b(ProfileHdHeadImg.this));
          if (localBitmap != null)
          {
            ProfileHdHeadImg localProfileHdHeadImg = ProfileHdHeadImg.this;
            p.aYn();
            ProfileHdHeadImg.a(localProfileHdHeadImg, localBitmap, e.L(ProfileHdHeadImg.b(ProfileHdHeadImg.this), true));
          }
          for (;;)
          {
            AppMethodBeat.o(31227);
            return 0;
            ProfileHdHeadImg.a(ProfileHdHeadImg.this, this.CZv, null);
          }
        }
        ProfileHdHeadImg.a(ProfileHdHeadImg.this, this.CZv, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg
 * JD-Core Version:    0.7.0.1
 */