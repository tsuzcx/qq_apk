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

public final class ab
  extends LinearLayout
  implements i.a
{
  private HeaderContainer FQe;
  private ImageView FQf;
  private ImageView frr;
  private TextView mZh;
  private TextView vWw;
  
  public ab(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33518);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131494944, this, true);
    this.frr = ((ImageView)findViewById(2131297008));
    this.FQf = ((ImageView)findViewById(2131303625));
    this.mZh = ((TextView)findViewById(2131302860));
    this.vWw = ((TextView)findViewById(2131306244));
    AppMethodBeat.o(33518);
  }
  
  public final TextView getNickNameTV()
  {
    return this.mZh;
  }
  
  public final ImageView getQrCodeIv()
  {
    return this.FQf;
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
    if (this.vWw != null) {
      this.vWw.setText(getResources().getString(2131755271, new Object[] { paramString }));
    }
    AppMethodBeat.o(33520);
  }
  
  public final void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.FQe = paramHeaderContainer;
  }
  
  public final void setNickNameTV(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(33521);
    if (this.mZh != null) {
      this.mZh.setText(paramSpannableString);
    }
    AppMethodBeat.o(33521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ab
 * JD-Core Version:    0.7.0.1
 */