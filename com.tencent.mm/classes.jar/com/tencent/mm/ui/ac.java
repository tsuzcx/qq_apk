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
  private HeaderContainer Jdv;
  private ImageView Jdw;
  private ImageView fOf;
  private TextView odU;
  private TextView yvk;
  
  public ac(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33518);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494944, this, true);
    this.fOf = ((ImageView)findViewById(2131297008));
    this.Jdw = ((ImageView)findViewById(2131303625));
    this.odU = ((TextView)findViewById(2131302860));
    this.yvk = ((TextView)findViewById(2131306244));
    AppMethodBeat.o(33518);
  }
  
  public final TextView getNickNameTV()
  {
    return this.odU;
  }
  
  public final ImageView getQrCodeIv()
  {
    return this.Jdw;
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
    if (this.yvk != null) {
      this.yvk.setText(getResources().getString(2131755271, new Object[] { paramString }));
    }
    AppMethodBeat.o(33520);
  }
  
  public final void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.Jdv = paramHeaderContainer;
  }
  
  public final void setNickNameTV(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(33521);
    if (this.odU != null) {
      this.odU.setText(paramSpannableString);
    }
    AppMethodBeat.o(33521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ac
 * JD-Core Version:    0.7.0.1
 */