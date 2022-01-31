package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ReaderAppSubscribeUI$a
  extends BaseAdapter
{
  private final Context context;
  final int[] pTX;
  int pTY;
  private String[] pTZ;
  int pUa;
  
  public ReaderAppSubscribeUI$a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(76805);
    this.pTX = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
    this.pTZ = null;
    this.pUa = 0;
    this.context = paramContext;
    this.pTY = paramInt;
    this.pTZ = paramContext.getString(2131302303).split(";");
    this.pUa = Cf(paramInt);
    AppMethodBeat.o(76805);
  }
  
  private int Cf(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (j < this.pTX.length)
    {
      if ((this.pTX[j] & paramInt) == 0) {
        break label37;
      }
      i += 1;
    }
    label37:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  public final int getCount()
  {
    return this.pTZ.length;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(76806);
    if (paramView == null)
    {
      paramViewGroup = new ReaderAppSubscribeUI.a.a();
      paramView = View.inflate(this.context, 2130970519, null);
      paramViewGroup.gpL = ((TextView)paramView.findViewById(2131827043));
      paramViewGroup.gpN = ((CheckBox)paramView.findViewById(2131827044));
      paramView.setTag(paramViewGroup);
      paramViewGroup.gpL.setText(this.pTZ[paramInt]);
      paramViewGroup = paramViewGroup.gpN;
      if ((this.pTY & this.pTX[paramInt]) == 0) {
        break label118;
      }
    }
    label118:
    for (boolean bool = true;; bool = false)
    {
      paramViewGroup.setChecked(bool);
      AppMethodBeat.o(76806);
      return paramView;
      paramViewGroup = (ReaderAppSubscribeUI.a.a)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI.a
 * JD-Core Version:    0.7.0.1
 */