package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.n;
import com.tencent.mm.pluginsdk.ui.ProfileItemView;
import com.tencent.mm.sdk.platformtools.bk;

public class ProfileNormalItemView
  extends ProfileItemView
{
  private TextView haW;
  private String mTitle;
  TextView mTp;
  CharSequence mYY;
  View.OnClickListener mYZ;
  
  public ProfileNormalItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.ProfileNormalItemView);
    this.mTitle = paramContext.getString(R.n.ProfileNormalItemView_title);
    paramContext.recycle();
  }
  
  public ProfileNormalItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean bsP()
  {
    this.haW.setText(this.mTitle);
    if (bk.L(this.mYY))
    {
      setVisibility(8);
      return false;
    }
    setVisibility(0);
    this.mTp.setText(this.mYY);
    setOnClickListener(this.mYZ);
    return true;
  }
  
  public int getLayout()
  {
    return R.i.profile_normal_item_layout;
  }
  
  public final void init()
  {
    this.haW = ((TextView)findViewById(R.h.contact_normal_item_title));
    this.mTp = ((TextView)findViewById(R.h.contact_normal_item_summary));
  }
  
  public final ProfileNormalItemView wc(int paramInt)
  {
    this.mTitle = getContext().getString(paramInt);
    return this;
  }
  
  public final ProfileNormalItemView wd(int paramInt)
  {
    this.mYY = getContext().getString(paramInt);
    return this;
  }
  
  public final ProfileNormalItemView we(int paramInt)
  {
    this.mTp.setTextColor(paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ProfileNormalItemView
 * JD-Core Version:    0.7.0.1
 */