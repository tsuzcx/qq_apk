package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.c.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;

public final class FriendSnsPreference
  extends IconPreference
{
  private String adzM = null;
  private Bitmap adzN = null;
  private long adzO;
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
  
  public final void bzH(String paramString)
  {
    AppMethodBeat.i(33138);
    this.adzN = null;
    this.adva = -1;
    this.adzM = paramString;
    this.adzO = 0L;
    if (this.KKj != null) {
      a.b.g(this.KKj, paramString);
    }
    AppMethodBeat.o(33138);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(33140);
    super.onBindView(paramView);
    if ((this.adzM != null) && (h.baz())) {
      a.b.g(this.KKj, this.adzM);
    }
    if ((this.adzO != 0L) && (this.KKj != null)) {
      ((p)h.ax(p.class)).a(this.adzO, this.KKj, this.mContext.hashCode());
    }
    AppMethodBeat.o(33140);
  }
  
  public final void zD(long paramLong)
  {
    AppMethodBeat.i(33139);
    this.adzM = null;
    this.adzN = null;
    this.adva = -1;
    this.adzO = paramLong;
    if ((this.adzO != 0L) && (this.KKj != null)) {
      ((p)h.ax(p.class)).a(this.adzO, this.KKj, this.mContext.hashCode());
    }
    AppMethodBeat.o(33139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FriendSnsPreference
 * JD-Core Version:    0.7.0.1
 */