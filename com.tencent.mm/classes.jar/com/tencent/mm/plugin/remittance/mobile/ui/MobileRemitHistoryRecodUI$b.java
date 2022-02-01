package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class MobileRemitHistoryRecodUI$b
  extends RecyclerView.a
{
  private List<cjs> IjB;
  private int IjC;
  private int IjD;
  private int IjE;
  private MobileRemitHistoryRecodUI.d IjF;
  private Context context;
  boolean eYG;
  
  public MobileRemitHistoryRecodUI$b(Context paramContext, boolean paramBoolean, List<cjs> paramList, MobileRemitHistoryRecodUI.d paramd)
  {
    AppMethodBeat.i(67697);
    this.context = paramContext;
    this.eYG = paramBoolean;
    this.IjB = paramList;
    this.IjF = paramd;
    this.IjC = paramContext.getResources().getColor(a.c.black_text_color);
    this.IjD = paramContext.getResources().getColor(a.c.BW_0_Alpha_0_5);
    this.IjE = paramContext.getResources().getColor(a.c.BW_0_Alpha_0_3);
    AppMethodBeat.o(67697);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(271090);
    if (paramInt == 0)
    {
      paramViewGroup = new MobileRemitHistoryRecodUI.e(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.g.mobile_remit_hitory_record_data_item, paramViewGroup, false));
      AppMethodBeat.o(271090);
      return paramViewGroup;
    }
    paramViewGroup = new MobileRemitHistoryRecodUI.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.g.mobile_remit_hitory_record_loading_footer, paramViewGroup, false));
    AppMethodBeat.o(271090);
    return paramViewGroup;
  }
  
  public final void d(final RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(271091);
    if ((paramv instanceof MobileRemitHistoryRecodUI.e))
    {
      if ((this.IjB != null) && (paramInt >= 0) && (paramInt < this.IjB.size()))
      {
        paramv = (MobileRemitHistoryRecodUI.e)paramv;
        final cjs localcjs = (cjs)this.IjB.get(paramInt);
        Log.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onBindViewHolder() i:%s invalid:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localcjs.IiP) });
        paramv.jac.setVisibility(0);
        paramv.IjI.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(67694);
            int i = paramv.IjI.getMeasuredWidth();
            if (i != 0)
            {
              float f1 = paramv.mUy.getPaint().measureText(localcjs.IiN);
              float f2 = paramv.IjJ.getPaint().measureText(localcjs.IiO);
              int j = com.tencent.mm.ci.a.fromDPToPix(MobileRemitHistoryRecodUI.b.a(MobileRemitHistoryRecodUI.b.this), 14);
              if (f1 + f2 + j > i)
              {
                LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramv.mUy.getLayoutParams();
                localLayoutParams.width = ((int)(i - f2 - j));
                paramv.mUy.setLayoutParams(localLayoutParams);
              }
            }
            paramv.mUy.setText(localcjs.IiN);
            paramv.IjJ.setText(localcjs.IiO);
            AppMethodBeat.o(67694);
          }
        });
        paramv.qBs.setText(localcjs.tol);
        if (localcjs.IiP == 0)
        {
          paramv.mUy.setTextColor(this.IjC);
          paramv.IjJ.setTextColor(this.IjC);
          paramv.qBs.setTextColor(this.IjD);
          paramv.yVc.setVisibility(8);
        }
        for (;;)
        {
          paramv.jac.setTag(localcjs);
          paramv.jac.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(67695);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this) != null) {
                MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this).onClick(paramAnonymousView);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(67695);
            }
          });
          paramv.jac.setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(67696);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
              if (MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this) != null)
              {
                boolean bool = MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this).onLongClick(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(67696);
                return bool;
              }
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(67696);
              return false;
            }
          });
          AppMethodBeat.o(271091);
          return;
          paramv.mUy.setTextColor(this.IjE);
          paramv.IjJ.setTextColor(this.IjE);
          paramv.qBs.setTextColor(this.IjE);
          paramv.yVc.setVisibility(0);
        }
      }
    }
    else
    {
      paramv = (MobileRemitHistoryRecodUI.a)paramv;
      if (this.eYG)
      {
        paramv.jac.setVisibility(8);
        AppMethodBeat.o(271091);
        return;
      }
      paramv.jac.setVisibility(0);
    }
    AppMethodBeat.o(271091);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(67701);
    if (this.eYG)
    {
      i = this.IjB.size();
      AppMethodBeat.o(67701);
      return i;
    }
    int i = this.IjB.size();
    AppMethodBeat.o(67701);
    return i + 1;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(67700);
    if (this.eYG)
    {
      AppMethodBeat.o(67700);
      return 0;
    }
    if (paramInt == getItemCount() - 1)
    {
      AppMethodBeat.o(67700);
      return 1;
    }
    AppMethodBeat.o(67700);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI.b
 * JD-Core Version:    0.7.0.1
 */