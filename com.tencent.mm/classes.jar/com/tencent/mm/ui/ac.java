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

public final class ac
  extends LinearLayout
  implements i.a
{
  private HeaderContainer HpP;
  private ImageView HpQ;
  private ImageView fuY;
  private TextView nBF;
  private TextView xhj;
  
  public ac(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33518);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494944, this, true);
    this.fuY = ((ImageView)findViewById(2131297008));
    this.HpQ = ((ImageView)findViewById(2131303625));
    this.nBF = ((TextView)findViewById(2131302860));
    this.xhj = ((TextView)findViewById(2131306244));
    AppMethodBeat.o(33518);
  }
  
  public final TextView getNickNameTV()
  {
    return this.nBF;
  }
  
  public final ImageView getQrCodeIv()
  {
    return this.HpQ;
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
    if (this.xhj != null) {
      this.xhj.setText(getResources().getString(2131755271, new Object[] { paramString }));
    }
    AppMethodBeat.o(33520);
  }
  
  public final void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.HpP = paramHeaderContainer;
  }
  
  public final void setNickNameTV(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(33521);
    if (this.nBF != null) {
      this.nBF.setText(paramSpannableString);
    }
    AppMethodBeat.o(33521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ac
 * JD-Core Version:    0.7.0.1
 */