package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class b
  extends i
{
  private Set<alj> BQa;
  private View BQb;
  private View BQc;
  private TextView BQd;
  private FlowLayout BQe;
  private final alj BQf;
  private View contentView;
  private TextView yWS;
  
  public b(final Context paramContext, final dpa paramdpa, final a parama)
  {
    super(paramContext, 2131821484);
    AppMethodBeat.i(126636);
    this.BQa = new HashSet();
    this.BQf = new alj();
    this.BQf.id = "101";
    this.BQf.dyI = paramContext.getString(2131764467);
    final alj localalj;
    if (paramdpa.HWx != null)
    {
      localIterator = paramdpa.HWx.HWe.iterator();
      while (localIterator.hasNext())
      {
        localalj = (alj)localIterator.next();
        if (localalj.GDB)
        {
          this.BQf.id = localalj.id;
          this.BQf.dyI = localalj.dyI;
          paramdpa.HWx.HWe.remove(localalj);
        }
      }
    }
    this.contentView = LayoutInflater.from(paramContext).inflate(2131495772, null, false);
    this.BQb = this.contentView.findViewById(2131299892);
    this.BQc = this.contentView.findViewById(2131299899);
    this.yWS = ((TextView)this.contentView.findViewById(2131299889));
    this.BQd = ((TextView)this.contentView.findViewById(2131306191));
    this.BQd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126632);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (b.a(b.this).isEmpty()) {
          b.a(b.this).add(b.b(b.this));
        }
        parama.p(b.a(b.this));
        b.this.dismiss();
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126632);
      }
    });
    this.BQe = ((FlowLayout)this.contentView.findViewById(2131299894));
    Iterator localIterator = paramdpa.HWx.HWe.iterator();
    while (localIterator.hasNext())
    {
      localalj = (alj)localIterator.next();
      View localView = LayoutInflater.from(paramContext).inflate(2131495773, this.BQe, false);
      final TextView localTextView = (TextView)localView.findViewById(2131299896);
      localTextView.setText(localalj.dyI);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126633);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (b.a(b.this).contains(localalj))
          {
            b.a(b.this).remove(localalj);
            localTextView.setTextColor(paramContext.getResources().getColor(2131101045));
            localTextView.setBackgroundResource(2131234409);
            if (!b.a(b.this).isEmpty()) {
              break label199;
            }
            b.c(b.this).setText(b.b(b.this).dyI);
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126633);
            return;
            b.a(b.this).add(localalj);
            localTextView.setTextColor(paramContext.getResources().getColor(2131101044));
            localTextView.setBackgroundResource(2131234408);
            break;
            label199:
            b.c(b.this).setText(paramContext.getString(2131764468));
          }
        }
      });
      this.BQe.addView(localView);
    }
    this.yWS.setText(paramdpa.HWx.HWc);
    this.yWS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126634);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", paramdpa.HWx.HWd);
        d.b(b.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126634);
      }
    });
    setContentView(this.contentView);
    setCanceledOnTouchOutside(true);
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(126635);
        parama.onDismiss();
        AppMethodBeat.o(126635);
      }
    });
    AppMethodBeat.o(126636);
  }
  
  public final void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126637);
    super.show();
    paramView = e.a(paramView.getContext(), paramView, this.contentView, paramBoolean);
    if (paramBoolean)
    {
      this.BQc.setVisibility(0);
      this.BQb.setVisibility(8);
    }
    for (;;)
    {
      paramView[0] += paramInt1;
      paramView[1] += paramInt2;
      Window localWindow = getWindow();
      localWindow.setLayout(-2, -2);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.x = paramView[0];
      localLayoutParams.y = paramView[1];
      localLayoutParams.gravity = 8388659;
      localWindow.setAttributes(localLayoutParams);
      AppMethodBeat.o(126637);
      return;
      this.BQc.setVisibility(8);
      this.BQb.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
    
    public abstract void p(Set<alj> paramSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */