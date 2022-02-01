package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.c.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;

public final class FriendSnsPreference
  extends IconPreference
{
  private String FKi = null;
  private Bitmap FKj = null;
  private long FKk;
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
  
  public final void aJY(String paramString)
  {
    AppMethodBeat.i(33138);
    this.FKj = null;
    this.FGP = -1;
    this.FKi = paramString;
    this.FKk = 0L;
    if (this.tto != null) {
      a.b.c(this.tto, paramString);
    }
    AppMethodBeat.o(33138);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(33140);
    super.onBindView(paramView);
    if ((this.FKi != null) && (g.afw())) {
      a.b.c(this.tto, this.FKi);
    }
    if ((this.FKk != 0L) && (this.tto != null)) {
      ((n)g.ab(n.class)).a(this.FKk, this.tto, this.mContext.hashCode());
    }
    AppMethodBeat.o(33140);
  }
  
  public final void ws(long paramLong)
  {
    AppMethodBeat.i(33139);
    this.FKi = null;
    this.FKj = null;
    this.FGP = -1;
    this.FKk = paramLong;
    if ((this.FKk != 0L) && (this.tto != null)) {
      ((n)g.ab(n.class)).a(this.FKk, this.tto, this.mContext.hashCode());
    }
    AppMethodBeat.o(33139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.FriendSnsPreference
 * JD-Core Version:    0.7.0.1
 */