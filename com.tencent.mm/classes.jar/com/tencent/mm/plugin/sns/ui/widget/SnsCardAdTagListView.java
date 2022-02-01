package com.tencent.mm.plugin.sns.ui.widget;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;

public class SnsCardAdTagListView
  extends LinearLayout
{
  private volatile String AUu;
  private List<View> AuK;
  private Activity activity;
  private int sDN;
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100491);
    this.AuK = new ArrayList();
    AppMethodBeat.o(100491);
  }
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100492);
    this.AuK = new ArrayList();
    AppMethodBeat.o(100492);
  }
  
  private void a(b.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(220150);
    if (parame == null)
    {
      AppMethodBeat.o(220150);
      return;
    }
    String str = parame.zOz;
    if (al.isDarkMode()) {}
    for (parame = parame.zOB;; parame = parame.zOA)
    {
      if (!bu.isNullOrNil(str))
      {
        View localView = this.activity.getLayoutInflater().inflate(2131492937, null);
        TextView localTextView = (TextView)localView.findViewById(2131297726);
        WeImageView localWeImageView = (WeImageView)localView.findViewById(2131297724);
        localWeImageView.setVisibility(8);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (paramBoolean) {
          localLayoutParams.leftMargin = this.sDN;
        }
        localTextView.setText(str);
        if ((!bu.isNullOrNil(parame)) && (!TextUtils.equals((String)localWeImageView.getTag(2131304892), parame)))
        {
          localWeImageView.setImageDrawable(null);
          if (!TextUtils.isEmpty(parame))
          {
            ae.d("SnsCardAdTagUtils", "loadImage, hash=" + localWeImageView.hashCode() + ", url=" + parame);
            localWeImageView.setTag(2131304892, parame);
            h.a(parame, false, new b.1(localWeImageView, parame, localTextView));
          }
        }
        addView(localView, localLayoutParams);
        this.AuK.add(localView);
      }
      AppMethodBeat.o(220150);
      return;
    }
  }
  
  public String getOriginSnsId()
  {
    return this.AUu;
  }
  
  public final void gr(List<b.e> paramList)
  {
    AppMethodBeat.i(100493);
    int i;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size()) {
        if (i != 0) {
          break label55;
        }
      }
    }
    label55:
    for (boolean bool = false;; bool = true)
    {
      a((b.e)paramList.get(i), bool);
      i += 1;
      break;
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
    if (paramInt1 < this.AuK.size())
    {
      if (paramInt1 <= 0) {
        break label218;
      }
      paramInt2 += this.sDN;
    }
    label53:
    label218:
    for (;;)
    {
      if (paramInt2 >= getMeasuredWidth()) {
        i = paramInt1 - 1;
      }
      for (;;)
      {
        if ((i >= 0) && (i < this.AuK.size()))
        {
          final View localView = (View)this.AuK.get(i);
          final TextView localTextView = (TextView)localView.findViewById(2131297726);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(100490);
              if ((localTextView.getLayout() != null) && (!bu.ah(localTextView.getLayout().getText())) && (localTextView.getLayout().getText().charAt(0) == '…'))
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
            if (paramInt1 < this.AuK.size())
            {
              removeView((View)this.AuK.get(paramInt1));
              this.AuK.remove(paramInt1);
              paramInt1 += 1;
              continue;
              paramInt2 = ((View)this.AuK.get(paramInt1)).getMeasuredWidth() + paramInt2;
              i = paramInt1;
              if (paramInt2 >= getMeasuredWidth()) {
                break label53;
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
    this.AuK.clear();
    AppMethodBeat.o(100494);
  }
  
  public void setActivityContext(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setOriginSnsId(String paramString)
  {
    this.AUu = paramString;
  }
  
  public void setTagSpace(int paramInt)
  {
    this.sDN = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView
 * JD-Core Version:    0.7.0.1
 */