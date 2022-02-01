package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad
  extends LinearLayout
  implements j.a
{
  private TextView COX;
  private HeaderContainer OIA;
  private ImageView OIB;
  private ImageView gvv;
  private TextView pvG;
  
  public ad(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33518);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131495686, this, true);
    this.gvv = ((ImageView)findViewById(2131297134));
    this.OIB = ((ImageView)findViewById(2131306403));
    this.pvG = ((TextView)findViewById(2131305433));
    this.COX = ((TextView)findViewById(2131309643));
    AppMethodBeat.o(33518);
  }
  
  public final TextView getNickNameTV()
  {
    return this.pvG;
  }
  
  public final ImageView getQrCodeIv()
  {
    return this.OIB;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33519);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(33519);
  }
  
  public final void setAccountName(String paramString)
  {
    AppMethodBeat.i(33520);
    if (this.COX != null) {
      this.COX.setText(getResources().getString(2131755306, new Object[] { paramString }));
    }
    AppMethodBeat.o(33520);
  }
  
  public final void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.OIA = paramHeaderContainer;
  }
  
  public final void setNickNameTV(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(33521);
    if (this.pvG != null) {
      this.pvG.setText(paramSpannableString);
    }
    AppMethodBeat.o(33521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ad
 * JD-Core Version:    0.7.0.1
 */