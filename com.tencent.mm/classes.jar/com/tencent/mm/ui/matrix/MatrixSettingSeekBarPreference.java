package com.tencent.mm.ui.matrix;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class MatrixSettingSeekBarPreference
  extends Preference
{
  int Edg = 700;
  MatrixSettingSeekBarPreference.a IKw;
  private SeekBar mJE;
  
  public MatrixSettingSeekBarPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MatrixSettingSeekBarPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(38885);
    super.onBindView(paramView);
    this.mJE = ((SeekBar)paramView.findViewById(2131305791));
    this.mJE.setProgress((int)(100.0F * this.Edg / 5000.0F));
    paramView = (TextView)paramView.findViewById(2131301227);
    paramView.setText(this.mContext.getResources().getString(2131761200, new Object[] { Integer.valueOf(this.Edg) }));
    this.mJE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(38883);
        MatrixSettingSeekBarPreference.a(MatrixSettingSeekBarPreference.this, Math.max(17, (int)(5000.0F * paramAnonymousInt / 100.0F)));
        paramView.setText(MatrixSettingSeekBarPreference.this.mContext.getResources().getString(2131761200, new Object[] { Integer.valueOf(MatrixSettingSeekBarPreference.a(MatrixSettingSeekBarPreference.this)) }));
        AppMethodBeat.o(38883);
      }
      
      public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        AppMethodBeat.i(38884);
        if (MatrixSettingSeekBarPreference.b(MatrixSettingSeekBarPreference.this) != null) {
          MatrixSettingSeekBarPreference.b(MatrixSettingSeekBarPreference.this).acq(MatrixSettingSeekBarPreference.a(MatrixSettingSeekBarPreference.this));
        }
        AppMethodBeat.o(38884);
      }
    });
    AppMethodBeat.o(38885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingSeekBarPreference
 * JD-Core Version:    0.7.0.1
 */