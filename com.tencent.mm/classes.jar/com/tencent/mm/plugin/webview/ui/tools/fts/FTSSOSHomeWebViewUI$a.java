package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.List;

final class FTSSOSHomeWebViewUI$a
  extends BaseAdapter
{
  private List<FTSSOSHomeWebViewUI.c> vkW;
  
  private FTSSOSHomeWebViewUI$a(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI)
  {
    AppMethodBeat.i(8452);
    this.vkW = new ArrayList();
    AppMethodBeat.o(8452);
  }
  
  public final FTSSOSHomeWebViewUI.c KM(int paramInt)
  {
    AppMethodBeat.i(8455);
    FTSSOSHomeWebViewUI.c localc = (FTSSOSHomeWebViewUI.c)this.vkW.get(paramInt);
    AppMethodBeat.o(8455);
    return localc;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(8453);
    al.d(new FTSSOSHomeWebViewUI.a.4(this));
    AppMethodBeat.o(8453);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(8454);
    if (this.vkW.size() > 6)
    {
      AppMethodBeat.o(8454);
      return 6;
    }
    int i = this.vkW.size();
    AppMethodBeat.o(8454);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(8456);
    FTSSOSHomeWebViewUI.c localc;
    if (paramView == null)
    {
      paramViewGroup = new FTSSOSHomeWebViewUI.a.a(this, (byte)0);
      paramView = LayoutInflater.from(this.vkS.getContext()).inflate(2130970905, null);
      paramViewGroup.ivs = ((ImageView)paramView.findViewById(2131821253));
      paramViewGroup.ekg = ((TextView)paramView.findViewById(2131823022));
      paramViewGroup.vla = ((ImageView)paramView.findViewById(2131828209));
      paramView.setTag(paramViewGroup);
      localc = KM(paramInt);
      localc.position = paramInt;
      if (localc.icon == 0) {
        break label204;
      }
      paramViewGroup.ivs.setVisibility(0);
      paramViewGroup.ivs.setImageResource(localc.icon);
      label122:
      if (localc.vlh == 0) {
        break label215;
      }
      paramViewGroup.vla.setVisibility(0);
      paramViewGroup.vla.setImageResource(localc.vlh);
      paramViewGroup.vla.setTag(localc);
      paramViewGroup.vla.setOnClickListener(FTSSOSHomeWebViewUI.u(this.vkS));
    }
    for (;;)
    {
      paramViewGroup.ekg.setText(localc.content);
      AppMethodBeat.o(8456);
      return paramView;
      paramViewGroup = (FTSSOSHomeWebViewUI.a.a)paramView.getTag();
      break;
      label204:
      paramViewGroup.ivs.setVisibility(4);
      break label122;
      label215:
      paramViewGroup.vla.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a
 * JD-Core Version:    0.7.0.1
 */