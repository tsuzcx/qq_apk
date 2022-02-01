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
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.c;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.topstory.ui.c.h;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.esw;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class b
  extends i
{
  private TextView Jhl;
  private Set<aoz> Ndt;
  private View Ndu;
  private View Ndv;
  private TextView Ndw;
  private FlowLayout Ndx;
  private final aoz Ndy;
  private View contentView;
  
  public b(final Context paramContext, final esy paramesy, final a parama)
  {
    super(paramContext, c.h.TopstoryFeedbackDialog);
    AppMethodBeat.i(126636);
    this.Ndt = new HashSet();
    this.Ndy = new aoz();
    this.Ndy.id = "101";
    this.Ndy.wording = paramContext.getString(c.g.top_story_feedback_unlike);
    final aoz localaoz;
    if (paramesy.Uvj != null)
    {
      localIterator = paramesy.Uvj.UuT.iterator();
      while (localIterator.hasNext())
      {
        localaoz = (aoz)localIterator.next();
        if (localaoz.SCd)
        {
          this.Ndy.id = localaoz.id;
          this.Ndy.wording = localaoz.wording;
          paramesy.Uvj.UuT.remove(localaoz);
        }
      }
    }
    this.contentView = LayoutInflater.from(paramContext).inflate(c.e.top_story_feedback_dialog, null, false);
    this.Ndu = this.contentView.findViewById(c.d.feedback_down_iv);
    this.Ndv = this.contentView.findViewById(c.d.feedback_up_iv);
    this.Jhl = ((TextView)this.contentView.findViewById(c.d.feedback_detail_tv));
    this.Ndw = ((TextView)this.contentView.findViewById(c.d.unlike_btn));
    this.Ndw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126632);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (b.a(b.this).isEmpty()) {
          b.a(b.this).add(b.b(b.this));
        }
        parama.v(b.a(b.this));
        b.this.dismiss();
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126632);
      }
    });
    this.Ndx = ((FlowLayout)this.contentView.findViewById(c.d.feedback_flowLayout));
    Iterator localIterator = paramesy.Uvj.UuT.iterator();
    while (localIterator.hasNext())
    {
      localaoz = (aoz)localIterator.next();
      View localView = LayoutInflater.from(paramContext).inflate(c.e.top_story_feedback_reason_btn, this.Ndx, false);
      final TextView localTextView = (TextView)localView.findViewById(c.d.feedback_reason_btn);
      localTextView.setText(localaoz.wording);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126633);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (b.a(b.this).contains(localaoz))
          {
            b.a(b.this).remove(localaoz);
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
            b.a(b.this).add(localaoz);
            localTextView.setTextColor(paramContext.getResources().getColor(c.a.top_story_feedback_reason_selected));
            localTextView.setBackgroundResource(c.c.top_story_feedback_reason_selected);
            break;
            label203:
            b.c(b.this).setText(paramContext.getString(c.g.top_story_feedback_unlike2));
          }
        }
      });
      this.Ndx.addView(localView);
    }
    this.Jhl.setText(paramesy.Uvj.UuR);
    this.Jhl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126634);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/FeedbackPopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", paramesy.Uvj.UuS);
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
      this.Ndv.setVisibility(0);
      this.Ndu.setVisibility(8);
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
      this.Ndv.setVisibility(8);
      this.Ndu.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
    
    public abstract void v(Set<aoz> paramSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */