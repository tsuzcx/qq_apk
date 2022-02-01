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
  private HeaderContainer Jyg;
  private ImageView Jyh;
  private ImageView fQl;
  private TextView ojK;
  private TextView yLk;
  
  public ac(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33518);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494944, this, true);
    this.fQl = ((ImageView)findViewById(2131297008));
    this.Jyh = ((ImageView)findViewById(2131303625));
    this.ojK = ((TextView)findViewById(2131302860));
    this.yLk = ((TextView)findViewById(2131306244));
    AppMethodBeat.o(33518);
  }
  
  public final TextView getNickNameTV()
  {
    return this.ojK;
  }
  
  public final ImageView getQrCodeIv()
  {
    return this.Jyh;
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
    if (this.yLk != null) {
      this.yLk.setText(getResources().getString(2131755271, new Object[] { paramString }));
    }
    AppMethodBeat.o(33520);
  }
  
  public final void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.Jyg = paramHeaderContainer;
  }
  
  public final void setNickNameTV(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(33521);
    if (this.ojK != null) {
      this.ojK.setText(paramSpannableString);
    }
    AppMethodBeat.o(33521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ac
 * JD-Core Version:    0.7.0.1
 */