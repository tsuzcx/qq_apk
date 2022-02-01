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
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.ui.base.preference.Preference;

public class MusicPreference
  extends Preference
{
  public String IKi;
  public String IKj;
  public String IKk;
  private ImageButton IQi;
  a IQj;
  private View.OnClickListener bwV;
  private boolean fGh;
  private View mView;
  
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
    this.IQi = null;
    this.IKi = "";
    this.IKj = "";
    this.IKk = "";
    setLayoutResource(l.g.IEg);
    AppMethodBeat.o(51808);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
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
    if (this.bwV == null) {
      this.bwV = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51807);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (MusicPreference.a(MusicPreference.this) == null)
          {
            a.a(this, "com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51807);
            return;
          }
          if (paramAnonymousView.getId() == l.f.ICO)
          {
            if (!MusicPreference.b(MusicPreference.this)) {
              break label138;
            }
            MusicPreference.a(MusicPreference.this, false);
            MusicPreference.c(MusicPreference.this).setImageResource(l.e.ICl);
          }
          for (;;)
          {
            MusicPreference.a(MusicPreference.this).d(MusicPreference.this);
            a.a(this, "com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51807);
            return;
            label138:
            MusicPreference.a(MusicPreference.this, true);
            MusicPreference.c(MusicPreference.this).setImageResource(l.e.ICm);
          }
        }
      };
    }
    this.IQi = ((ImageButton)paramView.findViewById(l.f.ICO));
    this.IQi.setOnClickListener(this.bwV);
    if (this.fGh)
    {
      this.IQi.setImageResource(l.e.ICm);
      AppMethodBeat.o(51811);
      return;
    }
    this.IQi.setImageResource(l.e.ICl);
    AppMethodBeat.o(51811);
  }
  
  public final void xt(boolean paramBoolean)
  {
    AppMethodBeat.i(51810);
    this.fGh = paramBoolean;
    if (this.IQi != null)
    {
      if (paramBoolean)
      {
        this.IQi.setImageResource(l.e.ICm);
        AppMethodBeat.o(51810);
        return;
      }
      this.IQi.setImageResource(l.e.ICl);
    }
    AppMethodBeat.o(51810);
  }
  
  public static abstract interface a
  {
    public abstract void d(MusicPreference paramMusicPreference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.MusicPreference
 * JD-Core Version:    0.7.0.1
 */