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
import com.tencent.mm.sdk.platformtools.bt;

public class ProfileNormalItemView
  extends ProfileItemView
{
  private TextView kEu;
  String mTitle;
  CharSequence uEo;
  View.OnClickListener uEp;
  View uEq;
  TextView uxf;
  
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
  
  public final ProfileNormalItemView Ju(int paramInt)
  {
    AppMethodBeat.i(27383);
    this.mTitle = getContext().getString(paramInt);
    AppMethodBeat.o(27383);
    return this;
  }
  
  public final ProfileNormalItemView Jv(int paramInt)
  {
    AppMethodBeat.i(27384);
    this.uEo = getContext().getString(paramInt);
    AppMethodBeat.o(27384);
    return this;
  }
  
  public final ProfileNormalItemView Jw(int paramInt)
  {
    AppMethodBeat.i(27385);
    this.uxf.setTextColor(paramInt);
    AppMethodBeat.o(27385);
    return this;
  }
  
  public final boolean dcY()
  {
    AppMethodBeat.i(27386);
    this.kEu.setText(this.mTitle);
    if (bt.ai(this.uEo))
    {
      setVisibility(8);
      AppMethodBeat.o(27386);
      return false;
    }
    setVisibility(0);
    this.uxf.setText(this.uEo);
    setOnClickListener(this.uEp);
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
    this.kEu = ((TextView)findViewById(2131298680));
    this.uxf = ((TextView)findViewById(2131298679));
    this.uEq = findViewById(2131304172);
    AppMethodBeat.o(27382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ProfileNormalItemView
 * JD-Core Version:    0.7.0.1
 */