package com.tencent.mm.plugin.sns.ad.timeline.helper;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class f
{
  public static void a(final ADXml.g paramg, int paramInt, final ImageView paramImageView1, final ImageView paramImageView2)
  {
    AppMethodBeat.i(311137);
    if (paramg == null)
    {
      AppMethodBeat.o(311137);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(311182);
        Log.d("FullCardCoverImageHelper", "curPlayTime:" + this.Qap + ", disppear=" + paramg.QHJ + ", appear=" + paramg.QHL);
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(paramg.QHI))
            {
              a.o(paramg.QHI, paramImageView1);
              if ((this.Qap >= this.Qas) && (this.Qas > 0))
              {
                ImageView localImageView = paramImageView1;
                AlphaAnimation localAlphaAnimation;
                if (localImageView.getVisibility() == 0)
                {
                  Log.d("FullCardCoverImageHelper", "animHideView:" + localImageView.hashCode());
                  localImageView.setVisibility(4);
                  localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
                  localAlphaAnimation.setDuration(300L);
                  localImageView.startAnimation(localAlphaAnimation);
                }
                if (TextUtils.isEmpty(paramg.QHK)) {
                  break label414;
                }
                a.o(paramg.QHK, paramImageView2);
                if (this.Qap < this.Qau) {
                  break;
                }
                localImageView = paramImageView2;
                if (localImageView.getVisibility() != 0)
                {
                  Log.d("FullCardCoverImageHelper", "animShowView:" + localImageView.hashCode());
                  localImageView.setVisibility(0);
                  localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
                  localAlphaAnimation.setDuration(300L);
                  localImageView.startAnimation(localAlphaAnimation);
                }
                AppMethodBeat.o(311182);
                return;
              }
              if (paramImageView1.getVisibility() == 0) {
                continue;
              }
              paramImageView1.setVisibility(0);
              Log.d("FullCardCoverImageHelper", "show frontCoverIv, hash=" + paramImageView1.hashCode());
              continue;
            }
            f.t(paramImageView1);
          }
          catch (Exception localException)
          {
            Log.e("FullCardCoverImageHelper", "checkCoverImageState exp=" + localException.toString());
            AppMethodBeat.o(311182);
            return;
          }
        }
        if (paramImageView2.getVisibility() == 0)
        {
          paramImageView2.setVisibility(4);
          Log.d("FullCardCoverImageHelper", "hide endCoverIv, hash=" + paramImageView2.hashCode());
          AppMethodBeat.o(311182);
          return;
          label414:
          f.t(paramImageView2);
        }
        AppMethodBeat.o(311182);
      }
    });
    AppMethodBeat.o(311137);
  }
  
  public static void n(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(311147);
    if (TextUtils.isEmpty(paramString))
    {
      t(paramImageView);
      AppMethodBeat.o(311147);
      return;
    }
    if (!paramString.equals((String)paramImageView.getTag(b.f.sns_ad_card_img_url))) {
      paramImageView.setImageDrawable(null);
    }
    AppMethodBeat.o(311147);
  }
  
  static void t(ImageView paramImageView)
  {
    AppMethodBeat.i(311144);
    paramImageView.setVisibility(4);
    paramImageView.setImageDrawable(null);
    paramImageView.setTag(b.f.sns_ad_card_img_url, "");
    AppMethodBeat.o(311144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.f
 * JD-Core Version:    0.7.0.1
 */