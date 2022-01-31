package com.tencent.mm.plugin.websearch.widget.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class ServiceWidgetView$MyFragment
  extends Fragment
{
  b uMR;
  
  public ServiceWidgetView$MyFragment()
  {
    AppMethodBeat.i(91484);
    this.uMR = new b();
    AppMethodBeat.o(91484);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(91485);
    ab.i("ServiceWidgetView", "onCreateView %s", new Object[] { toString() });
    paramLayoutInflater = this.uMR;
    paramLayoutInflater.eyt = paramViewGroup;
    if (paramLayoutInflater.uMV == null)
    {
      if (paramLayoutInflater.view == null)
      {
        paramLayoutInflater.view = LayoutInflater.from(paramLayoutInflater.hwZ.getContext()).inflate(2130970679, paramLayoutInflater.eyt, false);
        paramLayoutInflater.uMU = ((LinearLayout)paramLayoutInflater.view.findViewById(2131821084));
        paramLayoutInflater.uMY = paramLayoutInflater.view.findViewById(2131826174);
        paramLayoutInflater.uMT = paramLayoutInflater.view.findViewById(2131827581);
        paramLayoutInflater.uNb = ((LinearLayout)paramLayoutInflater.view.findViewById(2131827587));
        paramLayoutInflater.uNc = ((MoreFooter)paramLayoutInflater.view.findViewById(2131827588));
        paramLayoutInflater.qhL = ((TextView)paramLayoutInflater.view.findViewById(2131822836));
        paramLayoutInflater.uMZ = paramLayoutInflater.view.findViewById(2131827586);
        paramLayoutInflater.uNj = paramLayoutInflater.view.findViewById(2131827580);
        paramLayoutInflater.uNi = ((ThreeDotsLoadingView)paramLayoutInflater.view.findViewById(2131821346));
        paramLayoutInflater.uNk = paramLayoutInflater.view.findViewById(2131827584);
        paramLayoutInflater.uMT.setVisibility(8);
        paramLayoutInflater.uMU.setVisibility(8);
        paramLayoutInflater.dal();
        paramLayoutInflater.view.findViewById(2131827585).setOnClickListener(new b.4(paramLayoutInflater));
        paramLayoutInflater.view.findViewById(2131827583).setOnClickListener(new b.5(paramLayoutInflater));
        paramLayoutInflater.uMU.setOnTouchListener(new b.6(paramLayoutInflater));
        paramLayoutInflater.uMU.setOnClickListener(new b.7(paramLayoutInflater));
        paramLayoutInflater.uNc.setOnClickLsn(paramLayoutInflater.uNm);
        paramLayoutInflater.qhL.setOnLongClickListener(new b.8(paramLayoutInflater));
      }
      paramLayoutInflater.uMV = ((h)g.E(h.class)).a(paramLayoutInflater.eyt.getContext(), new b.3(paramLayoutInflater));
      paramLayoutInflater.uMV.cZe();
    }
    paramLayoutInflater.bJ();
    if (paramLayoutInflater.gDG) {
      paramLayoutInflater.dam();
    }
    paramLayoutInflater = this.uMR.view;
    AppMethodBeat.o(91485);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(91488);
    super.onDestroy();
    if ((this.uMR != null) && (this.uMR.uNg != null)) {
      this.uMR.onDestroy();
    }
    AppMethodBeat.o(91488);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(91487);
    super.onPause();
    if ((this.uMR != null) && (this.uMR.uNg != null)) {
      this.uMR.onPause();
    }
    AppMethodBeat.o(91487);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(91486);
    super.onResume();
    if ((this.uMR != null) && (this.uMR.uNg != null)) {
      this.uMR.onResume();
    }
    AppMethodBeat.o(91486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView.MyFragment
 * JD-Core Version:    0.7.0.1
 */