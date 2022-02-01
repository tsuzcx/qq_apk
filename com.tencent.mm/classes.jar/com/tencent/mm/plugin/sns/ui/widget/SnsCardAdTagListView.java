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
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.ADXml.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;

public class SnsCardAdTagListView
  extends LinearLayout
{
  private volatile String RWY;
  private List<View> RrK;
  private Activity activity;
  private int space;
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100491);
    this.RrK = new ArrayList();
    AppMethodBeat.o(100491);
  }
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100492);
    this.RrK = new ArrayList();
    AppMethodBeat.o(100492);
  }
  
  public String getOriginSnsId()
  {
    return this.RWY;
  }
  
  public final void lc(List<ADXml.d> paramList)
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
    label410:
    label491:
    label623:
    for (int n = 0;; n = 1)
    {
      int i;
      int k;
      int j;
      for (;;)
      {
        Object localObject1 = (ADXml.d)paramList.get(m);
        String str2;
        if (localObject1 != null)
        {
          str2 = ((ADXml.d)localObject1).QHv;
          if (aw.isDarkMode()) {
            str1 = ((ADXml.d)localObject1).QHx;
          }
        }
        else
        {
          try
          {
            if (Util.isNullOrNil(((ADXml.d)localObject1).QHB)) {}
            for (i = getContext().getResources().getColor(b.c.desc_text_color);; i = Color.parseColor(((ADXml.d)localObject1).QHB))
            {
              try
              {
                if (!Util.isNullOrNil(((ADXml.d)localObject1).QHz)) {
                  break label410;
                }
                k = getContext().getResources().getColor(b.c.sns_ad_tag_bg);
                j = i;
                i = k;
              }
              finally
              {
                for (;;)
                {
                  label125:
                  TextView localTextView;
                  WeImageView localWeImageView;
                  LinearLayout.LayoutParams localLayoutParams;
                  k = getContext().getResources().getColor(b.c.sns_ad_tag_bg);
                  Log.e("MicroMsg.SnsCardTagListView", localObject2.toString());
                  j = i;
                  i = k;
                }
              }
              if (!Util.isNullOrNil(str2))
              {
                localObject1 = this.activity.getLayoutInflater().inflate(b.g.ad_card_tag_item, null);
                ((View)localObject1).getBackground().setColorFilter(i, PorterDuff.Mode.SRC);
                localTextView = (TextView)((View)localObject1).findViewById(b.f.card_ad_tag_text);
                localWeImageView = (WeImageView)((View)localObject1).findViewById(b.f.card_ad_tag_icon);
                localWeImageView.setVisibility(8);
                localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (n != 0) {
                  localLayoutParams.leftMargin = this.space;
                }
                localTextView.setText(str2);
                localTextView.setTextColor(j);
                if ((!Util.isNullOrNil(str1)) && (!TextUtils.equals((String)localWeImageView.getTag(b.f.sns_ad_card_img_url), str1)))
                {
                  localWeImageView.setImageDrawable(null);
                  if (!TextUtils.isEmpty(str1))
                  {
                    Log.d("SnsCardAdTagUtils", "loadImage, hash=" + localWeImageView.hashCode() + ", url=" + str1);
                    localWeImageView.setTag(b.f.sns_ad_card_img_url, str1);
                    k.a(str1, false, new d.1(localWeImageView, str1, localTextView));
                  }
                }
                addView((View)localObject1, localLayoutParams);
                this.RrK.add(localObject1);
              }
              m += 1;
              break;
            }
          }
          finally
          {
            for (;;)
            {
              i = getContext().getResources().getColor(b.c.desc_text_color);
              Log.e("MicroMsg.SnsCardTagListView", localObject4.toString());
              continue;
              k = Color.parseColor(((ADXml.d)localObject1).QHz);
            }
          }
        }
      }
      String str1 = localObject2.QHw;
      try
      {
        if (Util.isNullOrNil(localObject2.QHA)) {
          i = getContext().getResources().getColor(b.c.desc_text_color);
        }
      }
      finally
      {
        try
        {
          if (Util.isNullOrNil(localObject2.QHy)) {}
          for (j = getContext().getResources().getColor(b.c.sns_ad_tag_bg);; j = Color.parseColor(localObject2.QHy))
          {
            k = i;
            i = j;
            j = k;
            break;
            i = Color.parseColor(localObject2.QHA);
            break label491;
            localObject5 = finally;
            i = getContext().getResources().getColor(b.c.desc_text_color);
            Log.e("MicroMsg.SnsCardTagListView", localObject5.toString());
            break label491;
          }
          break label125;
        }
        finally
        {
          k = getContext().getResources().getColor(b.c.sns_ad_tag_bg);
          Log.e("MicroMsg.SnsCardTagListView", localObject3.toString());
          j = i;
          i = k;
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
    if (paramInt1 < this.RrK.size())
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
        if ((i >= 0) && (i < this.RrK.size()))
        {
          final View localView = (View)this.RrK.get(i);
          final TextView localTextView = (TextView)localView.findViewById(b.f.card_ad_tag_text);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(100490);
              if (localTextView.getLayout() != null)
              {
                Object localObject = localTextView.getLayout().getText();
                if (localObject != null)
                {
                  localObject = ((CharSequence)localObject).toString();
                  if ((Util.isNullOrNil((String)localObject)) || (((String)localObject).indexOf('…') >= 0))
                  {
                    SnsCardAdTagListView.this.removeView(localView);
                    SnsCardAdTagListView.a(SnsCardAdTagListView.this).remove(localView);
                  }
                }
              }
              SnsCardAdTagListView.this.getViewTreeObserver().removeOnPreDrawListener(this);
              AppMethodBeat.o(100490);
              return true;
            }
          });
          paramInt1 = i + 1;
          for (;;)
          {
            if (paramInt1 < this.RrK.size())
            {
              removeView((View)this.RrK.get(paramInt1));
              this.RrK.remove(paramInt1);
              paramInt1 += 1;
              continue;
              paramInt2 = ((View)this.RrK.get(paramInt1)).getMeasuredWidth() + paramInt2;
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
    this.RrK.clear();
    AppMethodBeat.o(100494);
  }
  
  public void setActivityContext(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setOriginSnsId(String paramString)
  {
    this.RWY = paramString;
  }
  
  public void setTagSpace(int paramInt)
  {
    this.space = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView
 * JD-Core Version:    0.7.0.1
 */