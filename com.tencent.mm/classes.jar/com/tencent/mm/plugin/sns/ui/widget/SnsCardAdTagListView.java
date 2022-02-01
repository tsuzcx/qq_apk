package com.tencent.mm.plugin.sns.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.ADXml.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;

public class SnsCardAdTagListView
  extends LinearLayout
{
  private List<View> KRL;
  private volatile String LtF;
  private Activity activity;
  private int space;
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100491);
    this.KRL = new ArrayList();
    AppMethodBeat.o(100491);
  }
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100492);
    this.KRL = new ArrayList();
    AppMethodBeat.o(100492);
  }
  
  public String getOriginSnsId()
  {
    return this.LtF;
  }
  
  public final void hX(List<ADXml.d> paramList)
  {
    AppMethodBeat.i(100493);
    int m;
    if (paramList != null)
    {
      m = 0;
      if (m < paramList.size()) {
        if (m != 0) {
          break label623;
        }
      }
    }
    label459:
    label491:
    label623:
    for (int n = 0;; n = 1)
    {
      Object localObject = (ADXml.d)paramList.get(m);
      String str2;
      String str1;
      if (localObject != null)
      {
        str2 = ((ADXml.d)localObject).Kjy;
        if (!ar.isDarkMode()) {
          break label459;
        }
        str1 = ((ADXml.d)localObject).KjA;
      }
      for (;;)
      {
        int i;
        int k;
        int j;
        try
        {
          if (Util.isNullOrNil(((ADXml.d)localObject).KjE)) {
            i = getContext().getResources().getColor(i.c.desc_text_color);
          }
          try
          {
            if (!Util.isNullOrNil(((ADXml.d)localObject).KjC)) {
              continue;
            }
            k = getContext().getResources().getColor(i.c.sns_ad_tag_bg);
            j = i;
            i = k;
          }
          catch (Throwable localThrowable1)
          {
            TextView localTextView;
            WeImageView localWeImageView;
            LinearLayout.LayoutParams localLayoutParams;
            k = getContext().getResources().getColor(i.c.sns_ad_tag_bg);
            Log.e("MicroMsg.SnsCardTagListView", localThrowable1.toString());
            j = i;
            i = k;
            continue;
          }
          if (!Util.isNullOrNil(str2))
          {
            localObject = this.activity.getLayoutInflater().inflate(i.g.ad_card_tag_item, null);
            ((View)localObject).getBackground().setColorFilter(i, PorterDuff.Mode.SRC);
            localTextView = (TextView)((View)localObject).findViewById(i.f.card_ad_tag_text);
            localWeImageView = (WeImageView)((View)localObject).findViewById(i.f.card_ad_tag_icon);
            localWeImageView.setVisibility(8);
            localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (n != 0) {
              localLayoutParams.leftMargin = this.space;
            }
            localTextView.setText(str2);
            localTextView.setTextColor(j);
            if ((!Util.isNullOrNil(str1)) && (!TextUtils.equals((String)localWeImageView.getTag(i.f.sns_ad_card_img_url), str1)))
            {
              localWeImageView.setImageDrawable(null);
              if (!TextUtils.isEmpty(str1))
              {
                Log.d("SnsCardAdTagUtils", "loadImage, hash=" + localWeImageView.hashCode() + ", url=" + str1);
                localWeImageView.setTag(i.f.sns_ad_card_img_url, str1);
                h.a(str1, false, new b.1(localWeImageView, str1, localTextView));
              }
            }
            addView((View)localObject, localLayoutParams);
            this.KRL.add(localObject);
          }
          m += 1;
          break;
          i = Color.parseColor(((ADXml.d)localObject).KjE);
          continue;
        }
        catch (Throwable localThrowable3)
        {
          i = getContext().getResources().getColor(i.c.desc_text_color);
          Log.e("MicroMsg.SnsCardTagListView", localThrowable3.toString());
          continue;
          k = Color.parseColor(((ADXml.d)localObject).KjC);
          continue;
        }
        str1 = localThrowable1.Kjz;
        try
        {
          if (Util.isNullOrNil(localThrowable1.KjD)) {
            i = getContext().getResources().getColor(i.c.desc_text_color);
          }
        }
        catch (Throwable localThrowable4)
        {
          try
          {
            if (Util.isNullOrNil(localThrowable1.KjB)) {}
            for (j = getContext().getResources().getColor(i.c.sns_ad_tag_bg);; j = Color.parseColor(localThrowable1.KjB))
            {
              k = i;
              i = j;
              j = k;
              break;
              i = Color.parseColor(localThrowable1.KjD);
              break label491;
              localThrowable4 = localThrowable4;
              i = getContext().getResources().getColor(i.c.desc_text_color);
              Log.e("MicroMsg.SnsCardTagListView", localThrowable4.toString());
              break label491;
            }
          }
          catch (Throwable localThrowable2)
          {
            k = getContext().getResources().getColor(i.c.sns_ad_tag_bg);
            Log.e("MicroMsg.SnsCardTagListView", localThrowable2.toString());
            j = i;
            i = k;
          }
        }
      }
      AppMethodBeat.o(100493);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100495);
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = 0;
    paramInt1 = 0;
    int i = paramInt1;
    if (paramInt1 < this.KRL.size())
    {
      if (paramInt1 <= 0) {
        break label221;
      }
      paramInt2 += this.space;
    }
    label54:
    label221:
    for (;;)
    {
      if (paramInt2 >= getMeasuredWidth()) {
        i = paramInt1 - 1;
      }
      for (;;)
      {
        if ((i >= 0) && (i < this.KRL.size()))
        {
          final View localView = (View)this.KRL.get(i);
          final TextView localTextView = (TextView)localView.findViewById(i.f.card_ad_tag_text);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(100490);
              if ((localTextView.getLayout() != null) && (!Util.isNullOrNil(localTextView.getLayout().getText())) && (localTextView.getLayout().getText().charAt(0) == '…'))
              {
                SnsCardAdTagListView.this.removeView(localView);
                SnsCardAdTagListView.a(SnsCardAdTagListView.this).remove(localView);
              }
              SnsCardAdTagListView.this.getViewTreeObserver().removeOnPreDrawListener(this);
              AppMethodBeat.o(100490);
              return true;
            }
          });
          paramInt1 = i + 1;
          for (;;)
          {
            if (paramInt1 < this.KRL.size())
            {
              removeView((View)this.KRL.get(paramInt1));
              this.KRL.remove(paramInt1);
              paramInt1 += 1;
              continue;
              paramInt2 = ((View)this.KRL.get(paramInt1)).getMeasuredWidth() + paramInt2;
              i = paramInt1;
              if (paramInt2 >= getMeasuredWidth()) {
                break label54;
              }
              paramInt1 += 1;
              break;
            }
          }
        }
      }
      AppMethodBeat.o(100495);
      return;
    }
  }
  
  public void removeAllViews()
  {
    AppMethodBeat.i(100494);
    super.removeAllViews();
    this.KRL.clear();
    AppMethodBeat.o(100494);
  }
  
  public void setActivityContext(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setOriginSnsId(String paramString)
  {
    this.LtF = paramString;
  }
  
  public void setTagSpace(int paramInt)
  {
    this.space = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView
 * JD-Core Version:    0.7.0.1
 */