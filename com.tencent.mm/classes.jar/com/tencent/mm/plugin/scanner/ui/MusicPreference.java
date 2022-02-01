package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.preference.Preference;

public class MusicPreference
  extends Preference
{
  private View.OnClickListener km;
  private boolean lVw;
  private View mView;
  public String yCa;
  public String yCb;
  public String yCc;
  private ImageButton yGT;
  a yGU;
  
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
    this.yGT = null;
    this.yCa = "";
    this.yCb = "";
    this.yCc = "";
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
    if (this.km == null) {
      this.km = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51807);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (MusicPreference.a(MusicPreference.this) == null)
          {
            a.a(this, "com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51807);
            return;
          }
          if (paramAnonymousView.getId() == 2131303376)
          {
            if (!MusicPreference.b(MusicPreference.this)) {
              break label136;
            }
            MusicPreference.a(MusicPreference.this, false);
            MusicPreference.c(MusicPreference.this).setImageResource(2131233641);
          }
          for (;;)
          {
            MusicPreference.a(MusicPreference.this).d(MusicPreference.this);
            a.a(this, "com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51807);
            return;
            label136:
            MusicPreference.a(MusicPreference.this, true);
            MusicPreference.c(MusicPreference.this).setImageResource(2131233642);
          }
        }
      };
    }
    this.yGT = ((ImageButton)paramView.findViewById(2131303376));
    this.yGT.setOnClickListener(this.km);
    if (this.lVw)
    {
      this.yGT.setImageResource(2131233642);
      AppMethodBeat.o(51811);
      return;
    }
    this.yGT.setImageResource(2131233641);
    AppMethodBeat.o(51811);
  }
  
  public final void qD(boolean paramBoolean)
  {
    AppMethodBeat.i(51810);
    this.lVw = paramBoolean;
    if (this.yGT != null)
    {
      if (paramBoolean)
      {
        this.yGT.setImageResource(2131233642);
        AppMethodBeat.o(51810);
        return;
      }
      this.yGT.setImageResource(2131233641);
    }
    AppMethodBeat.o(51810);
  }
  
  public static abstract interface a
  {
    public abstract void d(MusicPreference paramMusicPreference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.MusicPreference
 * JD-Core Version:    0.7.0.1
 */