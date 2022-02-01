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
import com.tencent.mm.sdk.platformtools.Util;

public class ProfileNormalItemView
  extends ProfileItemView
{
  TextView Bau;
  CharSequence Bic;
  View.OnClickListener Bid;
  View Bie;
  private TextView mPa;
  String mTitle;
  
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
  
  public final ProfileNormalItemView UO(int paramInt)
  {
    AppMethodBeat.i(27383);
    this.mTitle = getContext().getString(paramInt);
    AppMethodBeat.o(27383);
    return this;
  }
  
  public final ProfileNormalItemView UP(int paramInt)
  {
    AppMethodBeat.i(27384);
    this.Bic = getContext().getString(paramInt);
    AppMethodBeat.o(27384);
    return this;
  }
  
  public final ProfileNormalItemView UQ(int paramInt)
  {
    AppMethodBeat.i(27385);
    this.Bau.setTextColor(paramInt);
    AppMethodBeat.o(27385);
    return this;
  }
  
  public final boolean eEV()
  {
    AppMethodBeat.i(27386);
    this.mPa.setText(this.mTitle);
    if (Util.isNullOrNil(this.Bic))
    {
      setVisibility(8);
      AppMethodBeat.o(27386);
      return false;
    }
    setVisibility(0);
    this.Bau.setText(this.Bic);
    setOnClickListener(this.Bid);
    AppMethodBeat.o(27386);
    return true;
  }
  
  public int getLayout()
  {
    return 2131495984;
  }
  
  public final void init()
  {
    AppMethodBeat.i(27382);
    this.mPa = ((TextView)findViewById(2131299118));
    this.Bau = ((TextView)findViewById(2131299117));
    this.Bie = findViewById(2131307076);
    AppMethodBeat.o(27382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ProfileNormalItemView
 * JD-Core Version:    0.7.0.1
 */