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
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.eiu;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class b
  extends i
{
  private TextView DbK;
  private Set<any> GqI;
  private View GqJ;
  private View GqK;
  private TextView GqL;
  private FlowLayout GqM;
  private final any GqN;
  private View contentView;
  
  public b(final Context paramContext, final eiw parameiw, final a parama)
  {
    super(paramContext, 2131821530);
    AppMethodBeat.i(126636);
    this.GqI = new HashSet();
    this.GqN = new any();
    this.GqN.id = "101";
    this.GqN.dQx = paramContext.getString(2131766811);
    final any localany;
    if (parameiw.NiE != null)
    {
      localIterator = parameiw.NiE.Nin.iterator();
      while (localIterator.hasNext())
      {
        localany = (any)localIterator.next();
        if (localany.LzD)
        {
          this.GqN.id = localany.id;
          this.GqN.dQx = localany.dQx;
          parameiw.NiE.Nin.remove(localany);
        }
      }
    }
    this.contentView = LayoutInflater.from(paramContext).inflate(2131496730, null, false);
    this.GqJ = this.contentView.findViewById(2131300591);
    this.GqK = this.contentView.findViewById(2131300598);
    this.DbK = ((TextView)this.contentView.findViewById(2131300588));
    this.GqL = ((TextView)this.contentView.findViewById(2131309585));
    this.GqL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126632);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (b.a(b.this).isEmpty()) {
          b.a(b.this).add(b.b(b.this));
        }
        parama.v(b.a(b.this));
        b.this.dismiss();
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126632);
      }
    });
    this.GqM = ((FlowLayout)this.contentView.findViewById(2131300593));
    Iterator localIterator = parameiw.NiE.Nin.iterator();
    while (localIterator.hasNext())
    {
      localany = (any)localIterator.next();
      View localView = LayoutInflater.from(paramContext).inflate(2131496731, this.GqM, false);
      final TextView localTextView = (TextView)localView.findViewById(2131300595);
      localTextView.setText(localany.dQx);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126633);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (b.a(b.this).contains(localany))
          {
            b.a(b.this).remove(localany);
            localTextView.setTextColor(paramContext.getResources().getColor(2131101278));
            localTextView.setBackgroundResource(2131235334);
            if (!b.a(b.this).isEmpty()) {
              break label199;
            }
            b.c(b.this).setText(b.b(b.this).dQx);
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126633);
            return;
            b.a(b.this).add(localany);
            localTextView.setTextColor(paramContext.getResources().getColor(2131101277));
            localTextView.setBackgroundResource(2131235333);
            break;
            label199:
            b.c(b.this).setText(paramContext.getString(2131766812));
          }
        }
      });
      this.GqM.addView(localView);
    }
    this.DbK.setText(parameiw.NiE.Nil);
    this.DbK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126634);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", parameiw.NiE.Nim);
        c.b(b.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
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
      this.GqK.setVisibility(0);
      this.GqJ.setVisibility(8);
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
      this.GqK.setVisibility(8);
      this.GqJ.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
    
    public abstract void v(Set<any> paramSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */