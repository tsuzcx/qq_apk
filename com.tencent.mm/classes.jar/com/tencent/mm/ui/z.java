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

public final class z
  extends LinearLayout
  implements i.a
{
  private ImageView egq;
  private TextView jXY;
  private TextView qBO;
  private HeaderContainer zcW;
  private ImageView zcX;
  
  public z(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(29684);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130970300, this, true);
    this.egq = ((ImageView)findViewById(2131821210));
    this.zcX = ((ImageView)findViewById(2131826330));
    this.jXY = ((TextView)findViewById(2131821854));
    this.qBO = ((TextView)findViewById(2131826331));
    AppMethodBeat.o(29684);
  }
  
  public final TextView getNickNameTV()
  {
    return this.jXY;
  }
  
  public final ImageView getQrCodeIv()
  {
    return this.zcX;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(29685);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(29685);
  }
  
  public final void setAccountName(String paramString)
  {
    AppMethodBeat.i(29686);
    if (this.qBO != null) {
      this.qBO.setText(getResources().getString(2131296536, new Object[] { paramString }));
    }
    AppMethodBeat.o(29686);
  }
  
  public final void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.zcW = paramHeaderContainer;
  }
  
  public final void setNickNameTV(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(29687);
    if (this.jXY != null) {
      this.jXY.setText(paramSpannableString);
    }
    AppMethodBeat.o(29687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.z
 * JD-Core Version:    0.7.0.1
 */