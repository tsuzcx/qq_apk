package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.c;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.c.h;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.fof;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.widget.a.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class b
  extends i
{
  private TextView PsQ;
  private Set<ass> TQh;
  private View TQi;
  private View TQj;
  private TextView TQk;
  private final ass TQl;
  private FlowLayout Tmg;
  private View contentView;
  
  public b(final Context paramContext, foh paramfoh, final a parama)
  {
    super(paramContext, c.h.TopstoryFeedbackDialog);
    AppMethodBeat.i(126636);
    this.TQh = new HashSet();
    this.TQl = new ass();
    this.TQl.id = "101";
    this.TQl.wording = paramContext.getString(c.g.top_story_feedback_unlike);
    final ass localass;
    if (paramfoh.abOK != null)
    {
      localIterator = paramfoh.abOK.abOv.iterator();
      while (localIterator.hasNext())
      {
        localass = (ass)localIterator.next();
        if (localass.ZCV)
        {
          this.TQl.id = localass.id;
          this.TQl.wording = localass.wording;
          paramfoh.abOK.abOv.remove(localass);
        }
      }
    }
    this.contentView = LayoutInflater.from(paramContext).inflate(c.e.top_story_feedback_dialog, null, false);
    this.TQi = this.contentView.findViewById(c.d.feedback_down_iv);
    this.TQj = this.contentView.findViewById(c.d.feedback_up_iv);
    this.PsQ = ((TextView)this.contentView.findViewById(c.d.feedback_detail_tv));
    this.TQk = ((TextView)this.contentView.findViewById(c.d.unlike_btn));
    this.TQk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126632);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (b.a(b.this).isEmpty()) {
          b.a(b.this).add(b.b(b.this));
        }
        parama.D(b.a(b.this));
        b.this.dismiss();
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126632);
      }
    });
    this.Tmg = ((FlowLayout)this.contentView.findViewById(c.d.feedback_flowLayout));
    Iterator localIterator = paramfoh.abOK.abOv.iterator();
    while (localIterator.hasNext())
    {
      localass = (ass)localIterator.next();
      View localView = LayoutInflater.from(paramContext).inflate(c.e.top_story_feedback_reason_btn, this.Tmg, false);
      final TextView localTextView = (TextView)localView.findViewById(c.d.feedback_reason_btn);
      localTextView.setText(localass.wording);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126633);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (b.a(b.this).contains(localass))
          {
            b.a(b.this).remove(localass);
            localTextView.setTextColor(paramContext.getResources().getColor(c.a.top_story_feedback_reason_unselected));
            localTextView.setBackgroundResource(c.c.top_story_feedback_reason_unselected);
            if (!b.a(b.this).isEmpty()) {
              break label203;
            }
            b.c(b.this).setText(b.b(b.this).wording);
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126633);
            return;
            b.a(b.this).add(localass);
            localTextView.setTextColor(paramContext.getResources().getColor(c.a.top_story_feedback_reason_selected));
            localTextView.setBackgroundResource(c.c.top_story_feedback_reason_selected);
            break;
            label203:
            b.c(b.this).setText(paramContext.getString(c.g.top_story_feedback_unlike2));
          }
        }
      });
      this.Tmg.addView(localView);
    }
    this.PsQ.setText(paramfoh.abOK.abOt);
    this.PsQ.setOnClickListener(new b.3(this, paramfoh));
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
      this.TQj.setVisibility(0);
      this.TQi.setVisibility(8);
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
      this.TQj.setVisibility(8);
      this.TQi.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void D(Set<ass> paramSet);
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */