package com.tencent.toybrick.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.toybrick.c.f;
import java.util.HashMap;

public abstract class BaseToyUI<T extends f>
  extends BaseActivity
{
  private HashMap<String, f> mMap = new HashMap();
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mMap.clear();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(159984);
      SoG = new a("CHANGE", 0);
      SoH = new a("INSERT", 1);
      SoI = new a("REMOVE", 2);
      SoJ = new a[] { SoG, SoH, SoI };
      AppMethodBeat.o(159984);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.toybrick.ui.BaseToyUI
 * JD-Core Version:    0.7.0.1
 */