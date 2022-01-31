package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  extends b
{
  private c hCe;
  private View jGC;
  private View jGD;
  private TextView pbv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(105058);
    if (this.view != null)
    {
      this.pbv = ((TextView)this.view.findViewById(2131826445));
      this.jGC = this.view.findViewById(2131826444);
      this.jGD = this.view.findViewById(2131821667);
      this.pbv.setTextSize(0, com.tencent.mm.cb.a.ao(ah.getContext(), 2131427758));
      this.view.setOnClickListener(new a.1(this));
    }
    this.hCe = new a.2(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.hCe);
    AppMethodBeat.o(105058);
  }
  
  private void VG(String paramString)
  {
    AppMethodBeat.i(105062);
    if (this.pbv != null) {
      this.pbv.setText(paramString);
    }
    AppMethodBeat.o(105062);
  }
  
  private boolean bWm()
  {
    AppMethodBeat.i(105063);
    e locale;
    if ((this.nwf) && (this.eUx))
    {
      this.jGD.setBackgroundResource(2130840583);
      this.jGC.setBackground(null);
      this.pbv.setBackground(null);
      if (!com.tencent.mm.aw.a.aiw()) {
        break label240;
      }
      locale = com.tencent.mm.aw.a.aiz();
      VG(ah.getContext().getString(2131301721) + ah.getContext().getString(2131301722) + locale.fKl);
      if (!locale.fKF) {
        break label228;
      }
    }
    label228:
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      if (locale.fKF) {
        break label233;
      }
      AppMethodBeat.o(105063);
      return true;
      if (this.nwf)
      {
        this.jGD.setBackgroundResource(2130839279);
        this.jGC.setBackgroundResource(2130839278);
        this.pbv.setBackgroundResource(2130839276);
        break;
      }
      if (this.eUx)
      {
        this.jGD.setBackgroundResource(2130839279);
        this.jGC.setBackgroundResource(2130839276);
        this.pbv.setBackground(null);
        break;
      }
      this.jGD.setBackgroundResource(2130839279);
      this.jGC.setBackground(null);
      this.pbv.setBackgroundResource(2130839276);
      break;
    }
    label233:
    AppMethodBeat.o(105063);
    return false;
    label240:
    if (com.tencent.mm.aw.a.aix())
    {
      setVisibility(0);
      AppMethodBeat.o(105063);
      return true;
    }
    setVisibility(8);
    AppMethodBeat.o(105063);
    return false;
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(105060);
    boolean bool = bWm();
    AppMethodBeat.o(105060);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105061);
    com.tencent.mm.sdk.b.a.ymk.d(this.hCe);
    AppMethodBeat.o(105061);
  }
  
  public final int getLayoutId()
  {
    return 2130970326;
  }
  
  public final int getOrder()
  {
    return 1;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(105059);
    if (this.view != null) {
      this.view.findViewById(2131826444).setVisibility(paramInt);
    }
    AppMethodBeat.o(105059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a
 * JD-Core Version:    0.7.0.1
 */