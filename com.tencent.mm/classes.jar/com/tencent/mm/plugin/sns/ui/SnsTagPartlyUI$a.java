package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.ui.p;

final class SnsTagPartlyUI$a
  extends p<t>
{
  private Context context;
  public boolean rWJ;
  
  public SnsTagPartlyUI$a(SnsTagPartlyUI paramSnsTagPartlyUI, Context paramContext)
  {
    super(paramContext, new t());
    AppMethodBeat.i(39381);
    this.rWJ = false;
    this.context = paramContext;
    AppMethodBeat.o(39381);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(39383);
    setCursor(ag.cpl().getCursor());
    notifyDataSetChanged();
    AppMethodBeat.o(39383);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(39384);
    bKb();
    Ku();
    AppMethodBeat.o(39384);
  }
  
  public final int bHs()
  {
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39382);
    int i;
    if (paramView == null)
    {
      paramViewGroup = new SnsTagPartlyUI.a.a(this);
      paramView = View.inflate(this.context, 2130970399, null);
      paramViewGroup.rWK = ((TextView)paramView.findViewById(2131826647));
      paramViewGroup.rWL = ((TextView)paramView.findViewById(2131826648));
      paramViewGroup.gBJ = ((Button)paramView.findViewById(2131822840));
      paramView.setTag(paramViewGroup);
      if (xj(paramInt)) {
        break label229;
      }
      Object localObject = (t)getItem(paramInt);
      paramViewGroup.rWK.setText(((t)localObject).field_tagName);
      paramViewGroup.rWL.setVisibility(0);
      paramViewGroup.rWL.setText(" (" + ((t)localObject).field_count + ") ");
      localObject = paramViewGroup.gBJ;
      if (!this.rWJ) {
        break label222;
      }
      i = 0;
      label172:
      ((Button)localObject).setVisibility(i);
      paramViewGroup.gBJ.setOnClickListener(SnsTagPartlyUI.b(this.rWH));
      paramViewGroup.gBJ.setTag(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      AppMethodBeat.o(39382);
      return paramView;
      paramViewGroup = (SnsTagPartlyUI.a.a)paramView.getTag();
      break;
      label222:
      i = 8;
      break label172;
      label229:
      paramViewGroup.rWK.setText(2131304226);
      paramViewGroup.rWL.setVisibility(8);
      paramViewGroup.gBJ.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI.a
 * JD-Core Version:    0.7.0.1
 */