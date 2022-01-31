package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public final class l
  extends b
{
  protected bd AmP;
  private TextView AmQ;
  private View jGC;
  private View jGD;
  
  public l(Context paramContext, bd parambd)
  {
    super(paramContext);
    AppMethodBeat.i(34685);
    this.AmP = null;
    this.AmP = parambd;
    final int i;
    final int j;
    if (this.view != null)
    {
      this.jGC = this.view.findViewById(2131824232);
      this.jGD = this.view.findViewById(2131821667);
      paramContext = (WeImageView)this.view.findViewById(2131825905);
      paramContext.setIconColor(((Context)this.vUD.get()).getResources().getColor(2131690589));
      this.AmQ = ((TextView)this.view.findViewById(2131825906));
      switch (this.AmP.type)
      {
      case 5: 
      default: 
        parambd = this.view;
        i = this.AmP.type;
        j = this.AmP.showType;
        switch (i)
        {
        case 5: 
        default: 
          paramContext = null;
        }
        break;
      }
    }
    for (;;)
    {
      parambd.setOnClickListener(paramContext);
      AppMethodBeat.o(34685);
      return;
      paramContext.setImageResource(2131231491);
      this.AmQ.setText(2131297527);
      break;
      paramContext.setImageResource(2131231498);
      this.AmQ.setText(2131299925);
      break;
      paramContext.setImageResource(2131231487);
      this.AmQ.setText(2131297536);
      break;
      paramContext.setImageResource(2131232151);
      this.AmQ.setText(2131297530);
      break;
      paramContext.setImageResource(2131232146);
      this.AmQ.setText(2131297534);
      break;
      paramContext.setImageResource(2131232147);
      this.AmQ.setText(2131297533);
      break;
      paramContext.setImageResource(2131232149);
      this.AmQ.setText(2131297535);
      break;
      paramContext.setImageResource(2131232150);
      this.AmQ.setText(2131297531);
      break;
      paramContext.setImageResource(2131232145);
      this.AmQ.setText(2131297524);
      break;
      paramContext = new l.1(this, i, j);
      continue;
      paramContext = new l.2(this, i, j);
      continue;
      paramContext = new l.3(this, i, j);
      continue;
      paramContext = new l.4(this, i, j);
      continue;
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(34680);
          be.aaG().cs(i, j);
          paramAnonymousView = (Context)l.this.vUD.get();
          Intent localIntent = new Intent();
          localIntent.putExtra("preceding_scence", 17);
          d.b(paramAnonymousView, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
          h.qsU.e(11002, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
          h.qsU.e(12065, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(34680);
        }
      };
      continue;
      paramContext = new l.6(this, i, j);
      continue;
      paramContext = new l.7(this, i, j);
      continue;
      paramContext = new l.8(this, i, j);
      continue;
      paramContext = new l.9(this, i, j);
    }
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(34686);
    if ((this.nwf) && (this.eUx))
    {
      this.jGD.setBackgroundResource(2130840583);
      this.jGC.setBackground(null);
      this.AmQ.setBackground(null);
    }
    for (;;)
    {
      boolean bool = super.aMK();
      AppMethodBeat.o(34686);
      return bool;
      if (this.nwf)
      {
        this.jGD.setBackgroundResource(2130839279);
        this.jGC.setBackgroundResource(2130839278);
        this.AmQ.setBackgroundResource(2130839276);
      }
      else if (this.eUx)
      {
        this.jGD.setBackgroundResource(2130839279);
        this.jGC.setBackgroundResource(2130839276);
        this.AmQ.setBackground(null);
      }
      else
      {
        this.jGD.setBackgroundResource(2130839279);
        this.jGC.setBackground(null);
        this.AmQ.setBackgroundResource(2130839276);
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2130970072;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(34687);
    if (this.jGC != null) {
      this.jGC.setVisibility(paramInt);
    }
    AppMethodBeat.o(34687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l
 * JD-Core Version:    0.7.0.1
 */