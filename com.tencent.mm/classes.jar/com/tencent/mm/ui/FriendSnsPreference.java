package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;

public final class FriendSnsPreference
  extends IconPreference
{
  private String IWX = null;
  private Bitmap IWY = null;
  private long IWZ;
  private Context context;
  
  public FriendSnsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FriendSnsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  public final void DL(long paramLong)
  {
    AppMethodBeat.i(33139);
    this.IWX = null;
    this.IWY = null;
    this.ITn = -1;
    this.IWZ = paramLong;
    if ((this.IWZ != 0L) && (this.vEo != null)) {
      ((n)g.ab(n.class)).a(this.IWZ, this.vEo, this.mContext.hashCode());
    }
    AppMethodBeat.o(33139);
  }
  
  public final void aVm(String paramString)
  {
    AppMethodBeat.i(33138);
    this.IWY = null;
    this.ITn = -1;
    this.IWX = paramString;
    this.IWZ = 0L;
    if (this.vEo != null) {
      a.b.c(this.vEo, paramString);
    }
    AppMethodBeat.o(33138);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(33140);
    super.onBindView(paramView);
    if ((this.IWX != null) && (g.ajx())) {
      a.b.c(this.vEo, this.IWX);
    }
    if ((this.IWZ != 0L) && (this.vEo != null)) {
      ((n)g.ab(n.class)).a(this.IWZ, this.vEo, this.mContext.hashCode());
    }
    AppMethodBeat.o(33140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.FriendSnsPreference
 * JD-Core Version:    0.7.0.1
 */