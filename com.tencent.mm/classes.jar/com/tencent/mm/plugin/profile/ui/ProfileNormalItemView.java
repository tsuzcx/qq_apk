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
import com.tencent.mm.sdk.platformtools.bo;

public class ProfileNormalItemView
  extends ProfileItemView
{
  private TextView iJG;
  String mTitle;
  View pCA;
  CharSequence pCy;
  View.OnClickListener pCz;
  TextView pvv;
  
  public ProfileNormalItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23753);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.ProfileNormalItemView);
    this.mTitle = paramContext.getString(0);
    paramContext.recycle();
    AppMethodBeat.o(23753);
  }
  
  public ProfileNormalItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final ProfileNormalItemView BH(int paramInt)
  {
    AppMethodBeat.i(23755);
    this.mTitle = getContext().getString(paramInt);
    AppMethodBeat.o(23755);
    return this;
  }
  
  public final ProfileNormalItemView BI(int paramInt)
  {
    AppMethodBeat.i(23756);
    this.pCy = getContext().getString(paramInt);
    AppMethodBeat.o(23756);
    return this;
  }
  
  public final ProfileNormalItemView BJ(int paramInt)
  {
    AppMethodBeat.i(23757);
    this.pvv.setTextColor(paramInt);
    AppMethodBeat.o(23757);
    return this;
  }
  
  public final boolean ccG()
  {
    AppMethodBeat.i(23760);
    this.iJG.setText(this.mTitle);
    if (bo.aa(this.pCy))
    {
      setVisibility(8);
      AppMethodBeat.o(23760);
      return false;
    }
    setVisibility(0);
    this.pvv.setText(this.pCy);
    setOnClickListener(this.pCz);
    AppMethodBeat.o(23760);
    return true;
  }
  
  public int getLayout()
  {
    return 2130970468;
  }
  
  public final void init()
  {
    AppMethodBeat.i(23754);
    this.iJG = ((TextView)findViewById(2131826859));
    this.pvv = ((TextView)findViewById(2131826860));
    this.pCA = findViewById(2131821555);
    AppMethodBeat.o(23754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ProfileNormalItemView
 * JD-Core Version:    0.7.0.1
 */