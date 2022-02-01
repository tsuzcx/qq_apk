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
import com.tencent.mm.ui.base.r;

public final class a
{
  private static final int[] mmY = { R.g.amp1, R.g.amp2, R.g.amp3, R.g.amp4, R.g.amp5, R.g.amp6, R.g.amp7 };
  private static final int[] wLs = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private int LNi;
  private r MkT;
  private TextView MkU;
  private ImageView MkV;
  private View MkW;
  private Context context;
  private final MMHandler urD;
  private View wLm;
  private View wLn;
  private ImageView wLo;
  private View wLq;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(29571);
    this.urD = new MMHandler()
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
    this.LNi = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 180.0F);
    this.MkT = new r(((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.i.elU, null), -1, -2);
    this.wLo = ((ImageView)this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_anim));
    this.wLq = this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_cancel_area);
    this.MkU = ((TextView)this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_cancel_text));
    this.MkV = ((ImageView)this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_cancel_icon));
    this.MkW = this.MkT.getContentView().findViewById(R.h.eai);
    this.wLm = this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_rcding);
    this.wLn = this.MkT.getContentView().findViewById(R.h.voice_rcd_hint_tooshort);
    AppMethodBeat.o(29571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.a
 * JD-Core Version:    0.7.0.1
 */