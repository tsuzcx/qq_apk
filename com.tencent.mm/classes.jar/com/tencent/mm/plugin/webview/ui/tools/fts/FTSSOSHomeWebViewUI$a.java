package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.List;

final class FTSSOSHomeWebViewUI$a
  extends BaseAdapter
{
  private List<FTSSOSHomeWebViewUI.c> ruH = new ArrayList();
  
  private FTSSOSHomeWebViewUI$a(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final FTSSOSHomeWebViewUI.c CR(int paramInt)
  {
    return (FTSSOSHomeWebViewUI.c)this.ruH.get(paramInt);
  }
  
  public final void clear()
  {
    ai.d(new FTSSOSHomeWebViewUI.a.4(this));
  }
  
  public final int getCount()
  {
    if (this.ruH.size() > 6) {
      return 6;
    }
    return this.ruH.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FTSSOSHomeWebViewUI.c localc;
    if (paramView == null)
    {
      paramViewGroup = new FTSSOSHomeWebViewUI.a.a(this, (byte)0);
      paramView = LayoutInflater.from(this.ruD.mController.uMN).inflate(R.i.sos_suggest_item, null);
      paramViewGroup.gSx = ((ImageView)paramView.findViewById(R.h.icon_iv));
      paramViewGroup.dsy = ((TextView)paramView.findViewById(R.h.content_tv));
      paramViewGroup.ruL = ((ImageView)paramView.findViewById(R.h.tail_iv));
      paramView.setTag(paramViewGroup);
      localc = CR(paramInt);
      localc.position = paramInt;
      if (localc.icon == 0) {
        break label199;
      }
      paramViewGroup.gSx.setVisibility(0);
      paramViewGroup.gSx.setImageResource(localc.icon);
      label123:
      if (localc.ruS == 0) {
        break label210;
      }
      paramViewGroup.ruL.setVisibility(0);
      paramViewGroup.ruL.setImageResource(localc.ruS);
      paramViewGroup.ruL.setTag(localc);
      paramViewGroup.ruL.setOnClickListener(FTSSOSHomeWebViewUI.x(this.ruD));
    }
    for (;;)
    {
      paramViewGroup.dsy.setText(localc.content);
      return paramView;
      paramViewGroup = (FTSSOSHomeWebViewUI.a.a)paramView.getTag();
      break;
      label199:
      paramViewGroup.gSx.setVisibility(4);
      break label123;
      label210:
      paramViewGroup.ruL.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a
 * JD-Core Version:    0.7.0.1
 */