package com.tencent.mm.ui;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.t;

final class ab$a
  extends BaseAdapter
{
  private ab$a(ab paramab) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(29843);
    int i = ab.a(this.zeD).size();
    AppMethodBeat.o(29843);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29844);
    paramView = (ab.c)ab.a(this.zeD).get(paramInt);
    paramViewGroup = ab.b(this.zeD).inflate(2130970273, paramViewGroup, false);
    Object localObject = (TextView)paramViewGroup.findViewById(2131820680);
    if (!bo.isNullOrNil(paramView.zeH.zeI)) {
      ((TextView)localObject).setText(paramView.zeH.zeI);
    }
    if (paramView.zeH.textColor > 0) {
      ((TextView)localObject).setTextColor(a.m(ah.getContext(), paramView.zeH.textColor));
    }
    localObject = (ImageView)paramViewGroup.findViewById(2131820929);
    TextView localTextView;
    View localView;
    if (paramView.zeH.icon > 0)
    {
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageResource(((ab.c)ab.a(this.zeD).get(paramInt)).zeH.icon);
      if (!bo.isNullOrNil(paramView.zeH.zeJ)) {
        ((ImageView)localObject).setContentDescription(paramView.zeH.zeJ);
      }
      localObject = paramViewGroup.findViewById(2131823665);
      localTextView = (TextView)paramViewGroup.findViewById(2131826280);
      localTextView.setBackgroundResource(t.iF(ab.c(this.zeD)));
      localView = paramViewGroup.findViewById(2131825202);
      if (!paramView.zeF) {
        break label266;
      }
      ((View)localObject).setVisibility(0);
      label232:
      if (paramInt != getCount() - 1) {
        break label385;
      }
      paramViewGroup.setBackgroundResource(2130840493);
    }
    for (;;)
    {
      AppMethodBeat.o(29844);
      return paramViewGroup;
      ((ImageView)localObject).setVisibility(8);
      break;
      label266:
      if (paramView.cmy > 0)
      {
        localTextView.setVisibility(0);
        if (paramView.cmy > 99)
        {
          localTextView.setText("");
          localTextView.setBackgroundResource(2131230963);
          break label232;
        }
        localTextView.setText(paramView.cmy);
        localTextView.setBackgroundResource(t.iF(ab.c(this.zeD)));
        break label232;
      }
      if (paramView.zeG)
      {
        localView.setVisibility(0);
        break label232;
      }
      ((View)localObject).setVisibility(8);
      localTextView.setVisibility(8);
      localView.setVisibility(8);
      break label232;
      label385:
      paramViewGroup.setBackgroundResource(2130840492);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ab.a
 * JD-Core Version:    0.7.0.1
 */