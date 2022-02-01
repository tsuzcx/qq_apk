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
  private String JrF = null;
  private Bitmap JrG = null;
  private long JrH;
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
  
  public final void Ek(long paramLong)
  {
    AppMethodBeat.i(33139);
    this.JrF = null;
    this.JrG = null;
    this.JnV = -1;
    this.JrH = paramLong;
    if ((this.JrH != 0L) && (this.vQs != null)) {
      ((n)g.ab(n.class)).a(this.JrH, this.vQs, this.mContext.hashCode());
    }
    AppMethodBeat.o(33139);
  }
  
  public final void aWN(String paramString)
  {
    AppMethodBeat.i(33138);
    this.JrG = null;
    this.JnV = -1;
    this.JrF = paramString;
    this.JrH = 0L;
    if (this.vQs != null) {
      a.b.c(this.vQs, paramString);
    }
    AppMethodBeat.o(33138);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(33140);
    super.onBindView(paramView);
    if ((this.JrF != null) && (g.ajM())) {
      a.b.c(this.vQs, this.JrF);
    }
    if ((this.JrH != 0L) && (this.vQs != null)) {
      ((n)g.ab(n.class)).a(this.JrH, this.vQs, this.mContext.hashCode());
    }
    AppMethodBeat.o(33140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.FriendSnsPreference
 * JD-Core Version:    0.7.0.1
 */