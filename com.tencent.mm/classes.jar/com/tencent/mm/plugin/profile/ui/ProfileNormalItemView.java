package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.n;
import com.tencent.mm.pluginsdk.ui.ProfileItemView;
import com.tencent.mm.sdk.platformtools.Util;

public class ProfileNormalItemView
  extends ProfileItemView
{
  TextView MRV;
  CharSequence Naa;
  View.OnClickListener Nab;
  private View Nac;
  String mTitle;
  private TextView sUt;
  
  public ProfileNormalItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27381);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.haz);
    this.mTitle = paramContext.getString(R.n.haA);
    paramContext.recycle();
    AppMethodBeat.o(27381);
  }
  
  public ProfileNormalItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final ProfileNormalItemView afO(int paramInt)
  {
    AppMethodBeat.i(27383);
    this.mTitle = getContext().getString(paramInt);
    AppMethodBeat.o(27383);
    return this;
  }
  
  public final ProfileNormalItemView afP(int paramInt)
  {
    AppMethodBeat.i(27384);
    this.Naa = getContext().getString(paramInt);
    AppMethodBeat.o(27384);
    return this;
  }
  
  public final ProfileNormalItemView afQ(int paramInt)
  {
    AppMethodBeat.i(27385);
    this.MRV.setTextColor(paramInt);
    AppMethodBeat.o(27385);
    return this;
  }
  
  public final ProfileNormalItemView gCd()
  {
    AppMethodBeat.i(305459);
    this.Nac.setVisibility(0);
    AppMethodBeat.o(305459);
    return this;
  }
  
  public final boolean gCe()
  {
    AppMethodBeat.i(27386);
    this.sUt.setText(this.mTitle);
    if (Util.isNullOrNil(this.Naa))
    {
      setVisibility(8);
      AppMethodBeat.o(27386);
      return false;
    }
    setVisibility(0);
    this.MRV.setText(this.Naa);
    setOnClickListener(this.Nab);
    AppMethodBeat.o(27386);
    return true;
  }
  
  public int getLayout()
  {
    return R.i.gni;
  }
  
  public final void init()
  {
    AppMethodBeat.i(27382);
    this.sUt = ((TextView)findViewById(R.h.fDe));
    this.MRV = ((TextView)findViewById(R.h.fDd));
    this.Nac = findViewById(R.h.right_arrow);
    AppMethodBeat.o(27382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ProfileNormalItemView
 * JD-Core Version:    0.7.0.1
 */