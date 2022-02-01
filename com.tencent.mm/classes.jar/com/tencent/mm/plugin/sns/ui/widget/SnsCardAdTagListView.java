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
import com.tencent.mm.plugin.sns.storage.ADXml.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;

public class SnsCardAdTagListView
  extends LinearLayout
{
  private List<View> EDW;
  private volatile String Ffa;
  private Activity activity;
  private int tCv;
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100491);
    this.EDW = new ArrayList();
    AppMethodBeat.o(100491);
  }
  
  public SnsCardAdTagListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100492);
    this.EDW = new ArrayList();
    AppMethodBeat.o(100492);
  }
  
  private void a(ADXml.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(203995);
    if (paramd == null)
    {
      AppMethodBeat.o(203995);
      return;
    }
    String str = paramd.DWn;
    Object localObject;
    if (ao.isDarkMode()) {
      localObject = paramd.DWp;
    }
    for (;;)
    {
      int i;
      int k;
      int j;
      try
      {
        if (Util.isNullOrNil(paramd.DWt)) {
          i = getContext().getResources().getColor(2131100245);
        }
        try
        {
          if (!Util.isNullOrNil(paramd.DWr)) {
            continue;
          }
          k = getContext().getResources().getColor(2131101114);
          paramd = (ADXml.d)localObject;
          j = i;
          i = k;
        }
        catch (Throwable paramd)
        {
          TextView localTextView;
          WeImageView localWeImageView;
          LinearLayout.LayoutParams localLayoutParams;
          k = getContext().getResources().getColor(2131101114);
          Log.e("MicroMsg.SnsCardTagListView", paramd.toString());
          j = i;
          i = k;
          paramd = (ADXml.d)localObject;
          continue;
        }
        if (!Util.isNullOrNil(str))
        {
          localObject = this.activity.getLayoutInflater().inflate(2131492968, null);
          ((View)localObject).getBackground().setColorFilter(i, PorterDuff.Mode.SRC);
          localTextView = (TextView)((View)localObject).findViewById(2131298030);
          localWeImageView = (WeImageView)((View)localObject).findViewById(2131298028);
          localWeImageView.setVisibility(8);
          localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          if (paramBoolean) {
            localLayoutParams.leftMargin = this.tCv;
          }
          localTextView.setText(str);
          localTextView.setTextColor(j);
          if ((!Util.isNullOrNil(paramd)) && (!TextUtils.equals((String)localWeImageView.getTag(2131307979), paramd)))
          {
            localWeImageView.setImageDrawable(null);
            if (!TextUtils.isEmpty(paramd))
            {
              Log.d("SnsCardAdTagUtils", "loadImage, hash=" + localWeImageView.hashCode() + ", url=" + paramd);
              localWeImageView.setTag(2131307979, paramd);
              h.a(paramd, false, new b.1(localWeImageView, paramd, localTextView));
            }
          }
          addView((View)localObject, localLayoutParams);
          this.EDW.add(localObject);
        }
        AppMethodBeat.o(203995);
        return;
        i = Color.parseColor(paramd.DWt);
        continue;
      }
      catch (Throwable localThrowable1)
      {
        i = getContext().getResources().getColor(2131100245);
        Log.e("MicroMsg.SnsCardTagListView", localThrowable1.toString());
        continue;
        k = Color.parseColor(paramd.DWr);
        continue;
      }
      localObject = paramd.DWo;
      try
      {
        if (Util.isNullOrNil(paramd.DWs)) {
          i = getContext().getResources().getColor(2131100245);
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          label433:
          if (Util.isNullOrNil(paramd.DWq)) {}
          for (j = getContext().getResources().getColor(2131101114);; j = Color.parseColor(paramd.DWq))
          {
            k = i;
            i = j;
            j = k;
            paramd = (ADXml.d)localObject;
            break;
            i = Color.parseColor(paramd.DWs);
            break label433;
            localThrowable2 = localThrowable2;
            i = getContext().getResources().getColor(2131100245);
            Log.e("MicroMsg.SnsCardTagListView", localThrowable2.toString());
            break label433;
          }
        }
        catch (Throwable paramd)
        {
          k = getContext().getResources().getColor(2131101114);
          Log.e("MicroMsg.SnsCardTagListView", paramd.toString());
          j = i;
          i = k;
          paramd = (ADXml.d)localObject;
        }
      }
    }
  }
  
  public String getOriginSnsId()
  {
    return this.Ffa;
  }
  
  public final void ho(List<ADXml.d> paramList)
  {
    AppMethodBeat.i(100493);
    int i;
    if (paramList != null)
    {
      i = 0;
      if (i < paramList.size()) {
        if (i != 0) {
          break label57;
        }
      }
    }
    label57:
    for (boolean bool = false;; bool = true)
    {
      a((ADXml.d)paramList.get(i), bool);
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
    if (paramInt1 < this.EDW.size())
    {
      if (paramInt1 <= 0) {
        break label220;
      }
      paramInt2 += this.tCv;
    }
    label54:
    label220:
    for (;;)
    {
      if (paramInt2 >= getMeasuredWidth()) {
        i = paramInt1 - 1;
      }
      for (;;)
      {
        if ((i >= 0) && (i < this.EDW.size()))
        {
          final View localView = (View)this.EDW.get(i);
          final TextView localTextView = (TextView)localView.findViewById(2131298030);
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
            if (paramInt1 < this.EDW.size())
            {
              removeView((View)this.EDW.get(paramInt1));
              this.EDW.remove(paramInt1);
              paramInt1 += 1;
              continue;
              paramInt2 = ((View)this.EDW.get(paramInt1)).getMeasuredWidth() + paramInt2;
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
    this.EDW.clear();
    AppMethodBeat.o(100494);
  }
  
  public void setActivityContext(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setOriginSnsId(String paramString)
  {
    this.Ffa = paramString;
  }
  
  public void setTagSpace(int paramInt)
  {
    this.tCv = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView
 * JD-Core Version:    0.7.0.1
 */