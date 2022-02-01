package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class MusicPreference
  extends Preference
{
  private View.OnClickListener iu;
  private boolean lrL;
  private View mView;
  public String wYs;
  public String wYt;
  public String wYu;
  private ImageButton xcR;
  a xcS;
  
  public MusicPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MusicPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51808);
    this.mView = null;
    this.xcR = null;
    this.wYs = "";
    this.wYt = "";
    this.wYu = "";
    setLayoutResource(2131494875);
    AppMethodBeat.o(51808);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51809);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(51809);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(51811);
    super.onBindView(paramView);
    if (this.iu == null) {
      this.iu = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51807);
          if (MusicPreference.a(MusicPreference.this) == null)
          {
            AppMethodBeat.o(51807);
            return;
          }
          if (paramAnonymousView.getId() == 2131303376)
          {
            if (!MusicPreference.b(MusicPreference.this)) {
              break label83;
            }
            MusicPreference.a(MusicPreference.this, false);
            MusicPreference.c(MusicPreference.this).setImageResource(2131233641);
          }
          for (;;)
          {
            MusicPreference.a(MusicPreference.this).d(MusicPreference.this);
            AppMethodBeat.o(51807);
            return;
            label83:
            MusicPreference.a(MusicPreference.this, true);
            MusicPreference.c(MusicPreference.this).setImageResource(2131233642);
          }
        }
      };
    }
    this.xcR = ((ImageButton)paramView.findViewById(2131303376));
    this.xcR.setOnClickListener(this.iu);
    if (this.lrL)
    {
      this.xcR.setImageResource(2131233642);
      AppMethodBeat.o(51811);
      return;
    }
    this.xcR.setImageResource(2131233641);
    AppMethodBeat.o(51811);
  }
  
  public final void pY(boolean paramBoolean)
  {
    AppMethodBeat.i(51810);
    this.lrL = paramBoolean;
    if (this.xcR != null)
    {
      if (paramBoolean)
      {
        this.xcR.setImageResource(2131233642);
        AppMethodBeat.o(51810);
        return;
      }
      this.xcR.setImageResource(2131233641);
    }
    AppMethodBeat.o(51810);
  }
  
  public static abstract interface a
  {
    public abstract void d(MusicPreference paramMusicPreference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.MusicPreference
 * JD-Core Version:    0.7.0.1
 */