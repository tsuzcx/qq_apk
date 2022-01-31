package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.o;

public final class a
{
  private static final int[] eMV = { R.g.amp1, R.g.amp2, R.g.amp3, R.g.amp4, R.g.amp5, R.g.amp6, R.g.amp7 };
  private static final int[] ibm = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private Context context;
  private final ah ibJ = new a.1(this);
  private ImageView ibu;
  private View kch;
  private View kci;
  private View kck;
  private o pBG;
  private TextView pBH;
  private ImageView pBI;
  private View pBJ;
  private int pBK;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.pBK = BackwardSupportUtil.b.b(paramContext, 180.0F);
    this.pBG = new o(((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.i.voice_rcd_hint_window, null), -1, -2);
    this.ibu = ((ImageView)this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_anim));
    this.kck = this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_cancel_area);
    this.pBH = ((TextView)this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_cancel_text));
    this.pBI = ((ImageView)this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_cancel_icon));
    this.pBJ = this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_loading);
    this.kch = this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_rcding);
    this.kci = this.pBG.getContentView().findViewById(R.h.voice_rcd_hint_tooshort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.a
 * JD-Core Version:    0.7.0.1
 */