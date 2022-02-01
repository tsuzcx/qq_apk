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
  private String OBW = null;
  private Bitmap OBX = null;
  private long OBY;
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
  
  public final void No(long paramLong)
  {
    AppMethodBeat.i(33139);
    this.OBW = null;
    this.OBX = null;
    this.OxP = -1;
    this.OBY = paramLong;
    if ((this.OBY != 0L) && (this.zkw != null)) {
      ((n)g.af(n.class)).a(this.OBY, this.zkw, this.mContext.hashCode());
    }
    AppMethodBeat.o(33139);
  }
  
  public final void blM(String paramString)
  {
    AppMethodBeat.i(33138);
    this.OBX = null;
    this.OxP = -1;
    this.OBW = paramString;
    this.OBY = 0L;
    if (this.zkw != null) {
      a.b.c(this.zkw, paramString);
    }
    AppMethodBeat.o(33138);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(33140);
    super.onBindView(paramView);
    if ((this.OBW != null) && (g.aAc())) {
      a.b.c(this.zkw, this.OBW);
    }
    if ((this.OBY != 0L) && (this.zkw != null)) {
      ((n)g.af(n.class)).a(this.OBY, this.zkw, this.mContext.hashCode());
    }
    AppMethodBeat.o(33140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FriendSnsPreference
 * JD-Core Version:    0.7.0.1
 */