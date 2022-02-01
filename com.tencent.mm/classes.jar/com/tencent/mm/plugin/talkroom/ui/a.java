package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.v;

public final class a
{
  private static final int[] AhQ = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private static final int[] pgL = { R.g.amp1, R.g.amp2, R.g.amp3, R.g.amp4, R.g.amp5, R.g.amp6, R.g.amp7 };
  private View AhJ;
  private View AhK;
  private ImageView AhL;
  private View AhN;
  private v SOn;
  private TextView SOo;
  private ImageView SOp;
  private View SOq;
  private int SpY;
  private Context context;
  private final MMHandler xxY;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(29571);
    this.xxY = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29570);
        super.handleMessage(paramAnonymousMessage);
        a.a(a.this).dismiss();
        AppMethodBeat.o(29570);
      }
    };
    this.context = paramContext;
    this.SpY = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 180.0F);
    this.SOn = new v(((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.i.goY, null), -1, -2);
    this.AhL = ((ImageView)this.SOn.getContentView().findViewById(R.h.voice_rcd_hint_anim));
    this.AhN = this.SOn.getContentView().findViewById(R.h.voice_rcd_hint_cancel_area);
    this.SOo = ((TextView)this.SOn.getContentView().findViewById(R.h.voice_rcd_hint_cancel_text));
    this.SOp = ((ImageView)this.SOn.getContentView().findViewById(R.h.voice_rcd_hint_cancel_icon));
    this.SOq = this.SOn.getContentView().findViewById(R.h.gcY);
    this.AhJ = this.SOn.getContentView().findViewById(R.h.voice_rcd_hint_rcding);
    this.AhK = this.SOn.getContentView().findViewById(R.h.voice_rcd_hint_tooshort);
    AppMethodBeat.o(29571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.a
 * JD-Core Version:    0.7.0.1
 */