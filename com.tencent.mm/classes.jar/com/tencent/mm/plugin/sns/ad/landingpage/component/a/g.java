package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Outline;
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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.f;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends m
{
  Bitmap DdO;
  TextView EUI;
  TextView JBo;
  TextView JBp;
  TextView JBq;
  ImageView JBr;
  ImageView JBs;
  ImageView JBt;
  TextView JBu;
  FrameLayout JBv;
  LinearLayout JBw;
  TextView JBx;
  ViewOutlineProvider JBy;
  Handler JMp;
  Map<String, ImageView> OdG;
  boolean OdH;
  int mUIType;
  
  public g(Context paramContext, f paramf, ViewGroup paramViewGroup)
  {
    super(paramContext, paramf, paramViewGroup);
    AppMethodBeat.i(217260);
    this.mUIType = 1;
    this.JBy = new ViewOutlineProvider()
    {
      public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
      {
        AppMethodBeat.i(196189);
        try
        {
          paramAnonymousOutline.setOval(0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight());
          AppMethodBeat.o(196189);
          return;
        }
        catch (Throwable paramAnonymousView)
        {
          AppMethodBeat.o(196189);
        }
      }
    };
    this.OdG = new HashMap();
    this.OdH = true;
    this.JMp = new g.4(this);
    Log.i("AdLandingSocialCardComponent", "hash=" + hashCode() + ", info=" + paramf.toString());
    AppMethodBeat.o(217260);
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(217264);
    if (!super.by(paramJSONObject))
    {
      AppMethodBeat.o(217264);
      return false;
    }
    try
    {
      paramJSONObject.put("uiType", this.mUIType);
      AppMethodBeat.o(217264);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(217264);
    }
    return false;
  }
  
  public final void fKe()
  {
    AppMethodBeat.i(217265);
    if (this.contentView == null)
    {
      AppMethodBeat.o(217265);
      return;
    }
    final f localf = (f)this.KqB;
    if (localf == null)
    {
      AppMethodBeat.o(217265);
      return;
    }
    this.JBo.setText(localf.JBP);
    this.JBp.setText(localf.JBQ);
    this.JBq.setText(localf.JBR);
    this.EUI.setText(localf.desc);
    c.a(localf.JBU, this.JBs, 0.0F);
    String str = AdLandingPagesProxy.getInstance().getSelfUserName();
    Log.i("AdLandingSocialCardComponent", "fillItem, selfUserName=".concat(String.valueOf(str)));
    k(str, this.JBt);
    this.JBu.setText(localf.JBV);
    this.mUIType = 1;
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219361);
        Object localObject = localf.JBX;
        final ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          String str2 = AdLandingPagesProxy.getInstance().isFriend(str1);
          Log.i("AdLandingSocialCardComponent", "checkFriends, hashUserName=" + str1 + ", realUserName=" + str2);
          if (!TextUtils.isEmpty(str2)) {
            localArrayList.add(str2);
          }
        }
        if (!localArrayList.isEmpty()) {
          g.this.mUIType = 0;
        }
        for (;;)
        {
          Log.i("AdLandingSocialCardComponent", "uiType=" + g.this.mUIType);
          h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(230573);
              Object localObject2;
              Object localObject1;
              int j;
              if (g.this.mUIType == 1)
              {
                g.this.JBx.setText(g.1.this.JBz.JCa);
                c.a(g.1.this.JBz.JBT, g.this.JBr, 0.0F);
                localObject2 = g.this;
                localObject1 = g.1.this.JBz.JBW;
                Object localObject3 = g.1.this.JBz;
                ((g)localObject2).JBv.removeAllViews();
                ArrayList localArrayList = new ArrayList();
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  localArrayList.add(localObject1);
                }
                if ((((f)localObject3).JBY != null) && (((f)localObject3).JBY.size() > 0)) {
                  localArrayList.addAll(((f)localObject3).JBY);
                }
                Log.i("AdLandingSocialCardComponent", "addStrangerAvatar, count=" + localArrayList.size());
                int i = 0;
                j = 0;
                if (j < localArrayList.size())
                {
                  localObject1 = null;
                  switch (j)
                  {
                  default: 
                    label240:
                    if (localObject1 != null)
                    {
                      localObject3 = new ImageView(((g)localObject2).context);
                      ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
                      ((ImageView)localObject3).setImageBitmap(((g)localObject2).DdO);
                      ((ImageView)localObject3).setOutlineProvider(((g)localObject2).JBy);
                      ((ImageView)localObject3).setClipToOutline(true);
                      ((g)localObject2).JBv.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
                      c.a((String)localArrayList.get(j), (ImageView)localObject3, 1.0F);
                      i += 1;
                      if (i >= 6) {
                        break;
                      }
                    }
                    break;
                  }
                }
              }
              for (;;)
              {
                j += 1;
                break;
                int k = a.fromDPToPix(((g)localObject2).context, 36);
                localObject1 = new FrameLayout.LayoutParams(k, k);
                ((FrameLayout.LayoutParams)localObject1).gravity = 83;
                ((FrameLayout.LayoutParams)localObject1).leftMargin = a.fromDPToPix(((g)localObject2).context, 56);
                ((FrameLayout.LayoutParams)localObject1).bottomMargin = a.fromDPToPix(((g)localObject2).context, 9);
                break label240;
                k = a.fromDPToPix(((g)localObject2).context, 20);
                localObject1 = new FrameLayout.LayoutParams(k, k);
                ((FrameLayout.LayoutParams)localObject1).gravity = 83;
                ((FrameLayout.LayoutParams)localObject1).leftMargin = a.fromDPToPix(((g)localObject2).context, 22);
                ((FrameLayout.LayoutParams)localObject1).bottomMargin = a.fromDPToPix(((g)localObject2).context, 67);
                break label240;
                k = a.fromDPToPix(((g)localObject2).context, 32);
                localObject1 = new FrameLayout.LayoutParams(k, k);
                ((FrameLayout.LayoutParams)localObject1).gravity = 51;
                ((FrameLayout.LayoutParams)localObject1).leftMargin = a.fromDPToPix(((g)localObject2).context, 42);
                ((FrameLayout.LayoutParams)localObject1).topMargin = a.fromDPToPix(((g)localObject2).context, 20);
                break label240;
                k = a.fromDPToPix(((g)localObject2).context, 20);
                localObject1 = new FrameLayout.LayoutParams(k, k);
                ((FrameLayout.LayoutParams)localObject1).gravity = 53;
                ((FrameLayout.LayoutParams)localObject1).rightMargin = a.fromDPToPix(((g)localObject2).context, 77);
                ((FrameLayout.LayoutParams)localObject1).topMargin = a.fromDPToPix(((g)localObject2).context, 17);
                break label240;
                k = a.fromDPToPix(((g)localObject2).context, 34);
                localObject1 = new FrameLayout.LayoutParams(k, k);
                ((FrameLayout.LayoutParams)localObject1).gravity = 53;
                ((FrameLayout.LayoutParams)localObject1).rightMargin = a.fromDPToPix(((g)localObject2).context, 4);
                ((FrameLayout.LayoutParams)localObject1).topMargin = a.fromDPToPix(((g)localObject2).context, 28);
                break label240;
                k = a.fromDPToPix(((g)localObject2).context, 32);
                localObject1 = new FrameLayout.LayoutParams(k, k);
                ((FrameLayout.LayoutParams)localObject1).gravity = 85;
                ((FrameLayout.LayoutParams)localObject1).rightMargin = a.fromDPToPix(((g)localObject2).context, 33);
                ((FrameLayout.LayoutParams)localObject1).bottomMargin = a.fromDPToPix(((g)localObject2).context, 14);
                break label240;
                g.this.JBv.setVisibility(0);
                g.this.JBw.setVisibility(8);
                AppMethodBeat.o(230573);
                return;
                localObject2 = g.1.this.JBz.JBZ;
                Log.i("AdLandingSocialCardComponent", "desc raw=".concat(String.valueOf(localObject2)));
                localObject1 = localObject2;
                if (localObject2 != null)
                {
                  localObject1 = localObject2;
                  if (((String)localObject2).contains("_FRIENDS_COUNT_")) {
                    localObject1 = ((String)localObject2).replace("_FRIENDS_COUNT_", String.valueOf(localArrayList.size()));
                  }
                }
                Log.i("AdLandingSocialCardComponent", "desc after=".concat(String.valueOf(localObject1)));
                g.this.JBx.setText((CharSequence)localObject1);
                c.a(g.1.this.JBz.JBS, g.this.JBr, 0.0F);
                g.a(g.this, g.1.this.JBz.JBW, localArrayList);
                g.this.JBv.setVisibility(8);
                g.this.JBw.setVisibility(0);
                g.this.JMp.sendEmptyMessageDelayed(1, 3000L);
                AppMethodBeat.o(230573);
                return;
              }
            }
          });
          AppMethodBeat.o(219361);
          return;
          Log.w("AdLandingSocialCardComponent", "friends is empty");
        }
      }
    });
    AppMethodBeat.o(217265);
  }
  
  public final void fKi()
  {
    AppMethodBeat.i(217262);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((f)this.KqB).paddingLeft, (int)((f)this.KqB).paddingTop, (int)((f)this.KqB).paddingRight, (int)((f)this.KqB).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(217262);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(292917);
    super.fKl();
    this.JMp.removeCallbacksAndMessages(null);
    Log.d("AdLandingSocialCardComponent", "viewWillDisappear");
    AppMethodBeat.o(292917);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(217261);
    this.JBo = ((TextView)this.contentView.findViewById(i.f.title_prefix));
    this.JBp = ((TextView)this.contentView.findViewById(i.f.title_mid));
    this.JBq = ((TextView)this.contentView.findViewById(i.f.title_suffix));
    this.EUI = ((TextView)this.contentView.findViewById(i.f.desc));
    this.JBr = ((ImageView)this.contentView.findViewById(i.f.bg));
    this.JBs = ((ImageView)this.contentView.findViewById(i.f.avatar_mask));
    this.JBt = ((ImageView)this.contentView.findViewById(i.f.self_avatar));
    this.JBt.setOutlineProvider(this.JBy);
    this.JBt.setClipToOutline(true);
    this.JBu = ((TextView)this.contentView.findViewById(i.f.avatar_desc));
    this.JBv = ((FrameLayout)this.contentView.findViewById(i.f.stranger_avatar_container));
    this.JBw = ((LinearLayout)this.contentView.findViewById(i.f.friend_avatar_container));
    this.JBx = ((TextView)this.contentView.findViewById(i.f.bottom_desc));
    try
    {
      Bitmap localBitmap = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
      this.DdO = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth());
      AppMethodBeat.o(217261);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdLandingSocialCardComponent", "initDefaultAvatar exp=" + localThrowable.toString());
      AppMethodBeat.o(217261);
    }
  }
  
  public final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_social_card;
  }
  
  final void k(final String paramString, final ImageView paramImageView)
  {
    AppMethodBeat.i(217266);
    Log.i("AdLandingSocialCardComponent", "loadAvatarByUserName start, userName=".concat(String.valueOf(paramString)));
    paramImageView.setImageBitmap(this.DdO);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(217266);
      return;
    }
    paramImageView.setTag(paramString);
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205817);
        final Bitmap localBitmap = AdLandingPagesProxy.getInstance().getAvatarByUserName(paramString, false);
        h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(264432);
            if ((localBitmap != null) && (!localBitmap.isRecycled()))
            {
              g.3.this.JBD.setImageBitmap(localBitmap);
              ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(g.3.this.JBD, "alpha", new float[] { 0.5F, 1.0F });
              localObjectAnimator.setDuration(200L);
              localObjectAnimator.start();
              Log.i("AdLandingSocialCardComponent", "loadAvatarByUserName end, userName=" + g.3.this.iXL + ", w=" + localBitmap.getWidth() + ", h=" + localBitmap.getHeight());
              AppMethodBeat.o(264432);
              return;
            }
            if (g.this.OdH) {
              g.this.OdG.put(g.3.this.iXL, g.3.this.JBD);
            }
            Log.w("AdLandingSocialCardComponent", "loadAvatarByUserName end, userName=" + g.3.this.iXL + ", bmp=null, isNeedRetry=" + g.this.OdH);
            AppMethodBeat.o(264432);
          }
        });
        AppMethodBeat.o(205817);
      }
    });
    AppMethodBeat.o(217266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.g
 * JD-Core Version:    0.7.0.1
 */