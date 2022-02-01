package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.ad.j.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends n
{
  Bitmap IYf;
  TextView KPG;
  ImageView PRA;
  TextView PRB;
  FrameLayout PRC;
  LinearLayout PRD;
  TextView PRE;
  int PRF;
  ViewOutlineProvider PRG;
  Map<String, ImageView> PRH;
  boolean PRI;
  Handler PRJ;
  TextView PRv;
  TextView PRw;
  TextView PRx;
  ImageView PRy;
  ImageView PRz;
  
  public h(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.info.h paramh, ViewGroup paramViewGroup)
  {
    super(paramContext, paramh, paramViewGroup);
    AppMethodBeat.i(310701);
    this.PRF = 1;
    this.PRG = new h.2(this);
    this.PRH = new HashMap();
    this.PRI = true;
    this.PRJ = new h.4(this);
    Log.i("AdLandingSocialCardComponent", "hash=" + hashCode() + ", info=" + paramh.toString());
    AppMethodBeat.o(310701);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(310731);
    this.PRv = ((TextView)this.contentView.findViewById(b.f.title_prefix));
    this.PRw = ((TextView)this.contentView.findViewById(b.f.title_mid));
    this.PRx = ((TextView)this.contentView.findViewById(b.f.title_suffix));
    this.KPG = ((TextView)this.contentView.findViewById(b.f.desc));
    this.PRy = ((ImageView)this.contentView.findViewById(b.f.bg));
    this.PRz = ((ImageView)this.contentView.findViewById(b.f.avatar_mask));
    this.PRA = ((ImageView)this.contentView.findViewById(b.f.self_avatar));
    this.PRA.setOutlineProvider(this.PRG);
    this.PRA.setClipToOutline(true);
    this.PRB = ((TextView)this.contentView.findViewById(b.f.avatar_desc));
    this.PRC = ((FrameLayout)this.contentView.findViewById(b.f.stranger_avatar_container));
    this.PRD = ((LinearLayout)this.contentView.findViewById(b.f.friend_avatar_container));
    this.PRE = ((TextView)this.contentView.findViewById(b.f.bottom_desc));
    try
    {
      Bitmap localBitmap = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
      this.IYf = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth());
      AppMethodBeat.o(310731);
      return;
    }
    finally
    {
      Log.e("AdLandingSocialCardComponent", "initDefaultAvatar exp=" + localObject.toString());
      AppMethodBeat.o(310731);
    }
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(310747);
    if (!super.bP(paramJSONObject))
    {
      AppMethodBeat.o(310747);
      return false;
    }
    try
    {
      paramJSONObject.put("uiType", this.PRF);
      AppMethodBeat.o(310747);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(310747);
    }
    return false;
  }
  
  public final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_social_card;
  }
  
  public final void had()
  {
    AppMethodBeat.i(310754);
    if (this.contentView == null)
    {
      AppMethodBeat.o(310754);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.sns.ad.landingpage.component.info.h)this.QOV;
    if (localObject == null)
    {
      AppMethodBeat.o(310754);
      return;
    }
    c.a(((com.tencent.mm.plugin.sns.ad.landingpage.component.info.h)localObject).PSq, this.PRz, 0.0F);
    localObject = AdLandingPagesProxy.getInstance().getSelfUserName();
    Log.i("AdLandingSocialCardComponent", "fillItem, selfUserName=".concat(String.valueOf(localObject)));
    m((String)localObject, this.PRA);
    AppMethodBeat.o(310754);
  }
  
  public final void hal()
  {
    AppMethodBeat.i(310739);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((com.tencent.mm.plugin.sns.ad.landingpage.component.info.h)this.QOV).paddingLeft, (int)((com.tencent.mm.plugin.sns.ad.landingpage.component.info.h)this.QOV).paddingTop, (int)((com.tencent.mm.plugin.sns.ad.landingpage.component.info.h)this.QOV).paddingRight, (int)((com.tencent.mm.plugin.sns.ad.landingpage.component.info.h)this.QOV).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(310739);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(310770);
    super.hap();
    this.PRJ.removeCallbacksAndMessages(null);
    Log.d("AdLandingSocialCardComponent", "viewWillDisappear");
    AppMethodBeat.o(310770);
  }
  
  final void m(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(310762);
    Log.i("AdLandingSocialCardComponent", "loadAvatarByUserName start, userName=".concat(String.valueOf(paramString)));
    paramImageView.setImageBitmap(this.IYf);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(310762);
      return;
    }
    paramImageView.setTag(paramString);
    com.tencent.threadpool.h.ahAA.bm(new h.3(this, paramString, paramImageView));
    AppMethodBeat.o(310762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.h
 * JD-Core Version:    0.7.0.1
 */