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
  public String OQS;
  public String OQT;
  public String OQU;
  private ImageButton OZe;
  a OZf;
  private View.OnClickListener dpY;
  private boolean hLy;
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
    this.OZe = null;
    this.OQS = "";
    this.OQT = "";
    this.OQU = "";
    setLayoutResource(l.g.OKj);
    AppMethodBeat.o(51808);
  }
  
  public final void Ch(boolean paramBoolean)
  {
    AppMethodBeat.i(51810);
    this.hLy = paramBoolean;
    if (this.OZe != null)
    {
      if (paramBoolean)
      {
        this.OZe.setImageResource(l.e.OIo);
        AppMethodBeat.o(51810);
        return;
      }
      this.OZe.setImageResource(l.e.OIn);
    }
    AppMethodBeat.o(51810);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
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
    if (this.dpY == null) {
      this.dpY = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(51807);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (MusicPreference.a(MusicPreference.this) == null)
          {
            a.a(this, "com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51807);
            return;
          }
          if (paramAnonymousView.getId() == l.f.OIP)
          {
            if (!MusicPreference.b(MusicPreference.this)) {
              break label138;
            }
            MusicPreference.a(MusicPreference.this, false);
            MusicPreference.c(MusicPreference.this).setImageResource(l.e.OIn);
          }
          for (;;)
          {
            MusicPreference.a(MusicPreference.this).d(MusicPreference.this);
            a.a(this, "com/tencent/mm/plugin/scanner/ui/MusicPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51807);
            return;
            label138:
            MusicPreference.a(MusicPreference.this, true);
            MusicPreference.c(MusicPreference.this).setImageResource(l.e.OIo);
          }
        }
      };
    }
    this.OZe = ((ImageButton)paramView.findViewById(l.f.OIP));
    this.OZe.setOnClickListener(this.dpY);
    if (this.hLy)
    {
      this.OZe.setImageResource(l.e.OIo);
      AppMethodBeat.o(51811);
      return;
    }
    this.OZe.setImageResource(l.e.OIn);
    AppMethodBeat.o(51811);
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