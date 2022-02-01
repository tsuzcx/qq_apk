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
  private String Hjq = null;
  private Bitmap Hjr = null;
  private long Hjs;
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
  
  public final void AV(long paramLong)
  {
    AppMethodBeat.i(33139);
    this.Hjq = null;
    this.Hjr = null;
    this.HfX = -1;
    this.Hjs = paramLong;
    if ((this.Hjs != 0L) && (this.uBH != null)) {
      ((n)g.ab(n.class)).a(this.Hjs, this.uBH, this.mContext.hashCode());
    }
    AppMethodBeat.o(33139);
  }
  
  public final void aPw(String paramString)
  {
    AppMethodBeat.i(33138);
    this.Hjr = null;
    this.HfX = -1;
    this.Hjq = paramString;
    this.Hjs = 0L;
    if (this.uBH != null) {
      a.b.c(this.uBH, paramString);
    }
    AppMethodBeat.o(33138);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(33140);
    super.onBindView(paramView);
    if ((this.Hjq != null) && (g.agM())) {
      a.b.c(this.uBH, this.Hjq);
    }
    if ((this.Hjs != 0L) && (this.uBH != null)) {
      ((n)g.ab(n.class)).a(this.Hjs, this.uBH, this.mContext.hashCode());
    }
    AppMethodBeat.o(33140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.FriendSnsPreference
 * JD-Core Version:    0.7.0.1
 */