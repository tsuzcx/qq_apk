package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;

public final class FriendSnsPreference
  extends IconPreference
{
  private String VVo = null;
  private Bitmap VVp = null;
  private long VVq;
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
  
  public final void Vv(long paramLong)
  {
    AppMethodBeat.i(33139);
    this.VVo = null;
    this.VVp = null;
    this.VQS = -1;
    this.VVq = paramLong;
    if ((this.VVq != 0L) && (this.EPM != null)) {
      ((o)h.ae(o.class)).a(this.VVq, this.EPM, this.mContext.hashCode());
    }
    AppMethodBeat.o(33139);
  }
  
  public final void byl(String paramString)
  {
    AppMethodBeat.i(33138);
    this.VVp = null;
    this.VQS = -1;
    this.VVo = paramString;
    this.VVq = 0L;
    if (this.EPM != null) {
      a.b.c(this.EPM, paramString);
    }
    AppMethodBeat.o(33138);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(33140);
    super.onBindView(paramView);
    if ((this.VVo != null) && (h.aHB())) {
      a.b.c(this.EPM, this.VVo);
    }
    if ((this.VVq != 0L) && (this.EPM != null)) {
      ((o)h.ae(o.class)).a(this.VVq, this.EPM, this.mContext.hashCode());
    }
    AppMethodBeat.o(33140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FriendSnsPreference
 * JD-Core Version:    0.7.0.1
 */