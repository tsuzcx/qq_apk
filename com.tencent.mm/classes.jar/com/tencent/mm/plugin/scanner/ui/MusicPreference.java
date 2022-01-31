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
  private boolean isPlaying;
  private View mView;
  private View.OnClickListener qaq;
  public String qtT;
  public String qtU;
  public String qtV;
  private ImageButton qxm;
  MusicPreference.a qxn;
  
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
    AppMethodBeat.i(81036);
    this.mView = null;
    this.qxm = null;
    this.qtT = "";
    this.qtU = "";
    this.qtV = "";
    setLayoutResource(2130970247);
    AppMethodBeat.o(81036);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(81037);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(81037);
    return paramView;
  }
  
  public final void kB(boolean paramBoolean)
  {
    AppMethodBeat.i(81038);
    this.isPlaying = paramBoolean;
    if (this.qxm != null)
    {
      if (paramBoolean)
      {
        this.qxm.setImageResource(2130839970);
        AppMethodBeat.o(81038);
        return;
      }
      this.qxm.setImageResource(2130839969);
    }
    AppMethodBeat.o(81038);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(81039);
    super.onBindView(paramView);
    if (this.qaq == null) {
      this.qaq = new MusicPreference.1(this);
    }
    this.qxm = ((ImageButton)paramView.findViewById(2131826253));
    this.qxm.setOnClickListener(this.qaq);
    if (this.isPlaying)
    {
      this.qxm.setImageResource(2130839970);
      AppMethodBeat.o(81039);
      return;
    }
    this.qxm.setImageResource(2130839969);
    AppMethodBeat.o(81039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.MusicPreference
 * JD-Core Version:    0.7.0.1
 */