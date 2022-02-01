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
import com.tencent.mm.sdk.platformtools.bu;

public class ProfileNormalItemView
  extends ProfileItemView
{
  private TextView lHk;
  String mTitle;
  TextView xcS;
  CharSequence xkf;
  View.OnClickListener xkg;
  View xkh;
  
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
  
  public final ProfileNormalItemView NB(int paramInt)
  {
    AppMethodBeat.i(27383);
    this.mTitle = getContext().getString(paramInt);
    AppMethodBeat.o(27383);
    return this;
  }
  
  public final ProfileNormalItemView NC(int paramInt)
  {
    AppMethodBeat.i(27384);
    this.xkf = getContext().getString(paramInt);
    AppMethodBeat.o(27384);
    return this;
  }
  
  public final ProfileNormalItemView ND(int paramInt)
  {
    AppMethodBeat.i(27385);
    this.xcS.setTextColor(paramInt);
    AppMethodBeat.o(27385);
    return this;
  }
  
  public final boolean dEA()
  {
    AppMethodBeat.i(27386);
    this.lHk.setText(this.mTitle);
    if (bu.ah(this.xkf))
    {
      setVisibility(8);
      AppMethodBeat.o(27386);
      return false;
    }
    setVisibility(0);
    this.xcS.setText(this.xkf);
    setOnClickListener(this.xkg);
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
    this.lHk = ((TextView)findViewById(2131298680));
    this.xcS = ((TextView)findViewById(2131298679));
    this.xkh = findViewById(2131304172);
    AppMethodBeat.o(27382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ProfileNormalItemView
 * JD-Core Version:    0.7.0.1
 */