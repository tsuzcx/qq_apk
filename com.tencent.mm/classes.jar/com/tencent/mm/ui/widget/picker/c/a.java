package com.tencent.mm.ui.widget.picker.c;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView.b;
import com.tencent.mm.ui.widget.picker.d.d;
import com.tencent.mm.ui.widget.picker.d.e;
import com.tencent.mm.ui.widget.picker.d.f;
import com.tencent.mm.ui.widget.picker.d.g;
import java.util.Calendar;

public final class a
{
  public WheelView.b Lbw;
  public e Lci;
  public g Lcj;
  public f Lck;
  public d Lcl;
  public ViewGroup Zi;
  public Context context;
  public int endYear;
  public boolean iKG;
  public int iKN;
  public int iLA;
  public String iLB;
  public String iLC;
  public String iLD;
  public int iLE;
  public int iLF;
  public int iLG;
  public int iLH;
  public int iLI;
  public int iLJ;
  public int iLK;
  public int iLL;
  public float iLM;
  public boolean iLN;
  public boolean iLn;
  public boolean iLo;
  public boolean[] iLp;
  public Calendar iLq;
  public Calendar iLr;
  public Calendar iLs;
  public String iLt;
  public String iLu;
  public String iLv;
  public String iLw;
  public String iLx;
  public String iLy;
  public int iLz;
  public int kl;
  public Typeface lA;
  public String label;
  public int option;
  public boolean ov;
  public int startYear;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(192785);
    this.iLn = false;
    this.iLo = false;
    this.iLp = new boolean[] { 1, 1, 1, 0, 0, 0 };
    this.iLA = 17;
    this.iLE = -15028967;
    this.iLF = -1979711488;
    this.iLG = -16777216;
    this.iLH = -1;
    this.iLI = -657931;
    this.iLJ = 24;
    this.iLK = 24;
    this.iKN = 0;
    this.iLL = -1;
    this.iLM = 1.6F;
    this.ov = true;
    this.iKG = false;
    this.lA = Typeface.DEFAULT;
    this.Lbw = WheelView.b.LbH;
    this.kl = 0;
    if (paramInt == 1)
    {
      this.iLz = 2131496155;
      AppMethodBeat.o(192785);
      return;
    }
    this.iLz = 2131496156;
    AppMethodBeat.o(192785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.c.a
 * JD-Core Version:    0.7.0.1
 */