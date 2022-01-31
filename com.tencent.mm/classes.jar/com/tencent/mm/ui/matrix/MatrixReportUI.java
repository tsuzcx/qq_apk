package com.tencent.mm.ui.matrix;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class MatrixReportUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2130970129;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(156160);
    super.onCreate(paramBundle);
    setBackBtn(new MatrixReportUI.1(this));
    AppMethodBeat.o(156160);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixReportUI
 * JD-Core Version:    0.7.0.1
 */