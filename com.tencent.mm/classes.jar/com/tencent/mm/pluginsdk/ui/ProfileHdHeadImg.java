package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.an.o;
import com.tencent.mm.by.a.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelavatar.f;
import com.tencent.mm.modelavatar.f.d;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

@com.tencent.mm.ui.base.a(3)
public class ProfileHdHeadImg
  extends MMActivity
{
  private GetHdHeadImageGalleryView Ppo;
  private f Ppp;
  private String XZC = null;
  private String hJL = null;
  private String username = null;
  
  private void g(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(31230);
    try
    {
      Object localObject = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, 0.1F);
      a.a.acjy.p(this.username, (Bitmap)localObject);
      if (paramBitmap.getWidth() < 480)
      {
        float f = 480 / paramBitmap.getWidth();
        localObject = new Matrix();
        ((Matrix)localObject).postScale(f, f);
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      }
      Log.d("MicroMsg.ProfileHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
      this.Ppo.setHdHeadImage((Bitmap)localObject);
      this.Ppo.setHdHeadImagePath(paramString);
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
    return R.i.get_hd_head_image_gallery_view;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(31228);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.username = getIntent().getStringExtra("username");
    this.hJL = getIntent().getStringExtra("brand_icon_url");
    setActionbarColor(getResources().getColor(R.e.BW_0));
    setNavigationbarColor(getResources().getColor(R.e.BW_0));
    this.Ppo = ((GetHdHeadImageGalleryView)findViewById(R.h.gallery));
    this.Ppo.setUsername(this.username);
    this.Ppo.setSingleClickOverListener(new MMGestureGallery.f()
    {
      public final void singleClickOver()
      {
        AppMethodBeat.i(31226);
        ProfileHdHeadImg.this.finish();
        AppMethodBeat.o(31226);
      }
    });
    bh.bCz();
    if (!c.isSDCardAvailable())
    {
      aa.j(this, null);
      g(q.bFp().dO(this), null);
      AppMethodBeat.o(31228);
      return;
    }
    if (!Util.isNullOrNil(this.hJL))
    {
      paramBundle = o.n(this.username, this.hJL, R.g.nosdcard_headimg);
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = BitmapFactory.decodeResource(getResources(), R.g.default_avatar);
      }
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label331;
      }
      Log.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.Ppo.setThumbImage((Bitmap)localObject);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(this.XZC)) {
        this.username = this.XZC;
      }
      q.bFp();
      paramBundle = AvatarStorage.LJ(this.username);
      if ((paramBundle == null) || (paramBundle.isRecycled())) {
        break label353;
      }
      Log.i("MicroMsg.ProfileHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      q.bFp();
      g(paramBundle, AvatarStorage.Q(this.username, true));
      AppMethodBeat.o(31228);
      return;
      paramBundle = d.a(this.username, true, -1, null);
      break;
      label331:
      Log.i("MicroMsg.ProfileHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    label353:
    this.Ppp = new f();
    f localf = this.Ppp;
    String str = this.username;
    Object localObject = new f.d()
    {
      public final int resultCallback(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(31227);
        ProfileHdHeadImg.a(ProfileHdHeadImg.this).Qh();
        Log.i("MicroMsg.ProfileHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          q.bFp();
          Bitmap localBitmap = AvatarStorage.LJ(ProfileHdHeadImg.b(ProfileHdHeadImg.this));
          if (localBitmap != null)
          {
            ProfileHdHeadImg localProfileHdHeadImg = ProfileHdHeadImg.this;
            q.bFp();
            ProfileHdHeadImg.a(localProfileHdHeadImg, localBitmap, AvatarStorage.Q(ProfileHdHeadImg.b(ProfileHdHeadImg.this), true));
          }
          for (;;)
          {
            AppMethodBeat.o(31227);
            return 0;
            ProfileHdHeadImg.a(ProfileHdHeadImg.this, this.Ppt, null);
          }
        }
        ProfileHdHeadImg.a(ProfileHdHeadImg.this, this.Ppt, null);
        AppMethodBeat.o(31227);
        return 0;
      }
    };
    if (au.bwY(this.username)) {}
    for (paramBundle = ((r)h.ax(r.class)).bdq(this.username);; paramBundle = "")
    {
      localf.a(str, (f.d)localObject, paramBundle);
      AppMethodBeat.o(31228);
      return;
    }
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