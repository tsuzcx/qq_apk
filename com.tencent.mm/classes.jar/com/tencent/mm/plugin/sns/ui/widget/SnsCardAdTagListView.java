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
import com.tencent.mm.plugin.sns.storage.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;

public class SnsCardAdTagListView
  extends LinearLayout
{
  private volatile String ACT;
  private List<View> Ady;
  private Activity activity;
  private int stC;
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100491);
    this.Ady = new ArrayList();
    AppMethodBeat.o(100491);
  }
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100492);
    this.Ady = new ArrayList();
    AppMethodBeat.o(100492);
  }
  
  private void a(b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(198603);
    if (paramd == null)
    {
      AppMethodBeat.o(198603);
      return;
    }
    String str = paramd.zxa;
    if (al.isDarkMode()) {}
    for (paramd = paramd.zxc;; paramd = paramd.zxb)
    {
      if (!bt.isNullOrNil(str))
      {
        View localView = this.activity.getLayoutInflater().inflate(2131492937, null);
        TextView localTextView = (TextView)localView.findViewById(2131297726);
        WeImageView localWeImageView = (WeImageView)localView.findViewById(2131297724);
        localWeImageView.setVisibility(8);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (paramBoolean) {
          localLayoutParams.leftMargin = this.stC;
        }
        localTextView.setText(str);
        if ((!bt.isNullOrNil(paramd)) && (!TextUtils.equals((String)localWeImageView.getTag(2131304892), paramd)))
        {
          localWeImageView.setImageDrawable(null);
          if (!TextUtils.isEmpty(paramd))
          {
            ad.d("SnsCardAdTagUtils", "loadImage, hash=" + localWeImageView.hashCode() + ", url=" + paramd);
            localWeImageView.setTag(2131304892, paramd);
            h.a(paramd, false, new b.1(localWeImageView, paramd, localTextView));
          }
        }
        addView(localView, localLayoutParams);
        this.Ady.add(localView);
      }
      AppMethodBeat.o(198603);
      return;
    }
  }
  
  public String getOriginSnsId()
  {
    return this.ACT;
  }
  
  public final void gi(List<b.d> paramList)
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
      a((b.d)paramList.get(i), bool);
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
    if (paramInt1 < this.Ady.size())
    {
      if (paramInt1 <= 0) {
        break label218;
      }
      paramInt2 += this.stC;
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
        if ((i >= 0) && (i < this.Ady.size()))
        {
          final View localView = (View)this.Ady.get(i);
          final TextView localTextView = (TextView)localView.findViewById(2131297726);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(100490);
              if ((localTextView.getLayout() != null) && (!bt.ai(localTextView.getLayout().getText())) && (localTextView.getLayout().getText().charAt(0) == '…'))
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
            if (paramInt1 < this.Ady.size())
            {
              removeView((View)this.Ady.get(paramInt1));
              this.Ady.remove(paramInt1);
              paramInt1 += 1;
              continue;
              paramInt2 = ((View)this.Ady.get(paramInt1)).getMeasuredWidth() + paramInt2;
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
    this.Ady.clear();
    AppMethodBeat.o(100494);
  }
  
  public void setActivityContext(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setOriginSnsId(String paramString)
  {
    this.ACT = paramString;
  }
  
  public void setTagSpace(int paramInt)
  {
    this.stC = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView
 * JD-Core Version:    0.7.0.1
 */