package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;

public final class FriendSnsPreference
  extends IconPreference
{
  private Context context;
  private String yXd = null;
  private Bitmap yXe = null;
  private long yXf;
  
  public FriendSnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FriendSnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  public final void atm(String paramString)
  {
    AppMethodBeat.i(29303);
    this.yXe = null;
    this.yUb = -1;
    this.yXd = paramString;
    this.yXf = 0L;
    if (this.oyN != null) {
      a.b.c(this.oyN, paramString);
    }
    AppMethodBeat.o(29303);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29305);
    super.onBindView(paramView);
    if ((this.yXd != null) && (g.RG())) {
      a.b.c(this.oyN, this.yXd);
    }
    if ((this.yXf != 0L) && (this.oyN != null)) {
      ((m)g.E(m.class)).a(this.yXf, this.oyN, this.mContext.hashCode());
    }
    AppMethodBeat.o(29305);
  }
  
  public final void ou(long paramLong)
  {
    AppMethodBeat.i(29304);
    this.yXd = null;
    this.yXe = null;
    this.yUb = -1;
    this.yXf = paramLong;
    if ((this.yXf != 0L) && (this.oyN != null)) {
      ((m)g.E(m.class)).a(this.yXf, this.oyN, this.mContext.hashCode());
    }
    AppMethodBeat.o(29304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FriendSnsPreference
 * JD-Core Version:    0.7.0.1
 */