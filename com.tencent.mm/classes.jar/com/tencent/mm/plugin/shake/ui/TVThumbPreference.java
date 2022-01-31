package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TVThumbPreference
  extends Preference
  implements x.a
{
  f hcp;
  private ImageView odK;
  private ImageView odL;
  private ImageView odM;
  List<String> odN = null;
  
  public TVThumbPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TVThumbPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TVThumbPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.tv_thumb_preference);
    setWidgetLayoutResource(0);
    x.a(this);
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramBitmap == null) || (paramBitmap.isRecycled())) {}
    do
    {
      return;
      if ((this.odK != null) && (this.odK.getTag() != null) && (paramString.equals((String)this.odK.getTag())))
      {
        this.odK.post(new TVThumbPreference.1(this, paramBitmap));
        return;
      }
      if ((this.odL != null) && (this.odL.getTag() != null) && (paramString.equals((String)this.odL.getTag())))
      {
        this.odL.post(new TVThumbPreference.2(this, paramBitmap));
        return;
      }
    } while ((this.odM == null) || (this.odM.getTag() == null) || (!paramString.equals((String)this.odM.getTag())));
    this.odM.post(new TVThumbPreference.3(this, paramBitmap));
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.odK = ((ImageView)paramView.findViewById(R.h.thumb_1));
    this.odL = ((ImageView)paramView.findViewById(R.h.thumb_2));
    this.odM = ((ImageView)paramView.findViewById(R.h.thumb_3));
    if ((this.odN == null) || (this.odN.size() <= 0)) {}
    do
    {
      do
      {
        return;
        paramView = new b((String)this.odN.get(0));
        this.odK.setTag(paramView.UQ());
        paramView = x.a(paramView);
        if ((paramView != null) && (!paramView.isRecycled())) {
          this.odK.setImageBitmap(paramView);
        }
        this.odK.setVisibility(0);
      } while (1 >= this.odN.size());
      paramView = new b((String)this.odN.get(1));
      this.odL.setTag(paramView.UQ());
      paramView = x.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.odL.setImageBitmap(paramView);
      }
      this.odL.setVisibility(0);
    } while (2 >= this.odN.size());
    paramView = new b((String)this.odN.get(2));
    this.odM.setTag(paramView.UQ());
    paramView = x.a(paramView);
    if ((paramView != null) && (!paramView.isRecycled())) {
      this.odM.setImageBitmap(paramView);
    }
    this.odM.setVisibility(0);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    return super.onCreateView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVThumbPreference
 * JD-Core Version:    0.7.0.1
 */