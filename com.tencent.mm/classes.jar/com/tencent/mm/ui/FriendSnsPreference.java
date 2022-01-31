package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;

public final class FriendSnsPreference
  extends IconPreference
{
  private Context context;
  String uJx = null;
  Bitmap uJy = null;
  long uJz;
  
  public FriendSnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FriendSnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    if ((this.uJx != null) && (g.DK())) {
      a.b.a(this.lZf, this.uJx);
    }
    if ((this.uJz != 0L) && (this.lZf != null)) {
      ((m)g.r(m.class)).a(this.uJz, this.lZf, this.mContext.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.FriendSnsPreference
 * JD-Core Version:    0.7.0.1
 */