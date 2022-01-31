package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference
  extends Preference
{
  private View contentView;
  public TextView mXQ;
  public String uME = null;
  private Drawable vcR = null;
  public boolean vcS = true;
  private boolean vcT = false;
  private boolean vcU = false;
  public boolean vcV = false;
  private int vcW = 17;
  public int vcX = 17;
  public int vcY = 0;
  public ImageView vcZ = null;
  public Drawable vda = null;
  private List<View> vdb = new LinkedList();
  
  public KeyValuePreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KeyValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public KeyValuePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.h.mm_preference);
  }
  
  public final void cBv()
  {
    this.vdb.clear();
  }
  
  public final void cBw()
  {
    this.vcU = true;
    this.vcW = 49;
  }
  
  public final void dF(View paramView)
  {
    this.vdb.add(paramView);
  }
  
  public final void nf(boolean paramBoolean)
  {
    this.vcT = paramBoolean;
    if (this.vcT) {
      setWidgetLayoutResource(a.h.mm_preference_submenu);
    }
  }
  
  public void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.contentView = paramView.findViewById(a.g.content);
    if (this.vdC != null) {
      this.contentView.setOnClickListener(new KeyValuePreference.1(this));
    }
    if (this.vdD != null) {
      paramView.setOnLongClickListener(new KeyValuePreference.2(this));
    }
    this.mXQ = ((TextView)paramView.findViewById(16908304));
    this.mXQ.setSingleLine(this.vcS);
    if (this.vcT) {
      setWidgetLayoutResource(a.h.mm_preference_submenu);
    }
    Object localObject2;
    if (this.vcV)
    {
      localObject2 = (LinearLayout)paramView.findViewById(a.g.container);
      localObject1 = (LinearLayout.LayoutParams)((LinearLayout)localObject2).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).width = -1;
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject2 = (LinearLayout)paramView.findViewById(a.g.summary_container);
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((LinearLayout)localObject2).getChildAt(0).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.mXQ.setGravity(this.vcX);
    }
    Object localObject1 = (TextView)paramView.findViewById(16908310);
    if (!bk.bl(this.uME)) {
      ((TextView)localObject1).setText(this.uME);
    }
    if (localObject1 != null)
    {
      localObject2 = ((TextView)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = a.aa(this.mContext, a.e.FixedTitleWidth);
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    if (this.vcR != null) {
      ((ImageView)paramView.findViewById(a.g.icon_preference_imageview)).setImageDrawable(this.vcR);
    }
    this.vcZ = ((ImageView)paramView.findViewById(a.g.image_iv));
    if (this.vda != null)
    {
      this.vcZ.setVisibility(this.vcY);
      this.vcZ.setImageDrawable(this.vda);
    }
    for (;;)
    {
      if (this.vcU)
      {
        localObject1 = (LinearLayout)paramView.findViewById(a.g.container);
        if (localObject1 != null) {
          ((LinearLayout)localObject1).setGravity(this.vcW);
        }
      }
      if (this.vdb.size() <= 0) {
        break;
      }
      paramView = (LinearLayout)paramView.findViewById(a.g.summary_container);
      paramView.removeAllViews();
      localObject1 = this.vdb.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (View)((Iterator)localObject1).next();
        ViewGroup localViewGroup = (ViewGroup)((View)localObject2).getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView((View)localObject2);
        }
        paramView.addView((View)localObject2);
      }
      this.vcZ.setVisibility(8);
    }
  }
  
  public View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(a.h.mm_preference_content_keyvalue, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.KeyValuePreference
 * JD-Core Version:    0.7.0.1
 */