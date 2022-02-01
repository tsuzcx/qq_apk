package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.pluginsdk.ui.ProfileItemView;
import com.tencent.mm.sdk.platformtools.bs;

public class ProfileNormalItemView
  extends ProfileItemView
{
  private TextView lfN;
  String mTitle;
  TextView vFY;
  CharSequence vNf;
  View.OnClickListener vNg;
  View vNh;
  
  public ProfileNormalItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27381);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.ProfileNormalItemView);
    this.mTitle = paramContext.getString(0);
    paramContext.recycle();
    AppMethodBeat.o(27381);
  }
  
  public ProfileNormalItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final ProfileNormalItemView Lt(int paramInt)
  {
    AppMethodBeat.i(27383);
    this.mTitle = getContext().getString(paramInt);
    AppMethodBeat.o(27383);
    return this;
  }
  
  public final ProfileNormalItemView Lu(int paramInt)
  {
    AppMethodBeat.i(27384);
    this.vNf = getContext().getString(paramInt);
    AppMethodBeat.o(27384);
    return this;
  }
  
  public final ProfileNormalItemView Lv(int paramInt)
  {
    AppMethodBeat.i(27385);
    this.vFY.setTextColor(paramInt);
    AppMethodBeat.o(27385);
    return this;
  }
  
  public final boolean dqG()
  {
    AppMethodBeat.i(27386);
    this.lfN.setText(this.mTitle);
    if (bs.aj(this.vNf))
    {
      setVisibility(8);
      AppMethodBeat.o(27386);
      return false;
    }
    setVisibility(0);
    this.vFY.setText(this.vNf);
    setOnClickListener(this.vNg);
    AppMethodBeat.o(27386);
    return true;
  }
  
  public int getLayout()
  {
    return 2131495141;
  }
  
  public final void init()
  {
    AppMethodBeat.i(27382);
    this.lfN = ((TextView)findViewById(2131298680));
    this.vFY = ((TextView)findViewById(2131298679));
    this.vNh = findViewById(2131304172);
    AppMethodBeat.o(27382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ProfileNormalItemView
 * JD-Core Version:    0.7.0.1
 */