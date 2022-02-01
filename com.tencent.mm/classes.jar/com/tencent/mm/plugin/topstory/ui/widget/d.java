package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.h;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.i;

public final class d
  extends i
{
  private View TQi;
  private View TQj;
  private View TQu;
  private View TQv;
  private View contentView;
  
  public d(Context paramContext, final foh paramfoh, final a parama)
  {
    super(paramContext, c.h.TopstoryFeedbackDialog);
    AppMethodBeat.i(126644);
    this.contentView = LayoutInflater.from(paramContext).inflate(c.e.top_story_more_dialog, null, false);
    this.TQi = this.contentView.findViewById(c.d.more_down_iv);
    this.TQj = this.contentView.findViewById(c.d.more_up_iv);
    this.TQu = this.contentView.findViewById(c.d.unlike_layout);
    this.TQv = this.contentView.findViewById(c.d.favorite_layout);
    this.TQu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126641);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.TopStory.MorePopupWindow", "onClick unlike");
        if (parama != null) {
          parama.e(paramfoh);
        }
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126641);
      }
    });
    this.TQv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126642);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.TopStory.MorePopupWindow", "onClick favorite");
        if (parama != null) {
          parama.f(paramfoh);
        }
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126642);
      }
    });
    this.TQv.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164130);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        Log.i("MicroMsg.TopStory.MorePopupWindow", "onLongClick favorite");
        if (parama != null) {
          parama.g(paramfoh);
        }
        a.a(false, this, "com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(164130);
        return false;
      }
    });
    setContentView(this.contentView);
    setCanceledOnTouchOutside(true);
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(164131);
        if (parama != null) {
          parama.onDismiss();
        }
        AppMethodBeat.o(164131);
      }
    });
    AppMethodBeat.o(126644);
  }
  
  public final void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126645);
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
      AppMethodBeat.o(126645);
      return;
      this.TQj.setVisibility(8);
      this.TQi.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void e(foh paramfoh);
    
    public abstract void f(foh paramfoh);
    
    public abstract void g(foh paramfoh);
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */