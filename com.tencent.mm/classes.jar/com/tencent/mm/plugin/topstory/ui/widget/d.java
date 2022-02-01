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
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.i;

public final class d
  extends i
{
  private View BQb;
  private View BQc;
  private View BQo;
  private View BQp;
  private View contentView;
  
  public d(Context paramContext, final dpa paramdpa, final a parama)
  {
    super(paramContext, 2131821484);
    AppMethodBeat.i(126644);
    this.contentView = LayoutInflater.from(paramContext).inflate(2131495796, null, false);
    this.BQb = this.contentView.findViewById(2131302465);
    this.BQc = this.contentView.findViewById(2131302484);
    this.BQo = this.contentView.findViewById(2131306192);
    this.BQp = this.contentView.findViewById(2131299865);
    this.BQo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126641);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.TopStory.MorePopupWindow", "onClick unlike");
        if (parama != null) {
          parama.e(paramdpa);
        }
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126641);
      }
    });
    this.BQp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126642);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.TopStory.MorePopupWindow", "onClick favorite");
        if (parama != null) {
          parama.f(paramdpa);
        }
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126642);
      }
    });
    this.BQp.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164130);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/MorePopupWindow$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        ae.i("MicroMsg.TopStory.MorePopupWindow", "onLongClick favorite");
        if (parama != null) {
          parama.g(paramdpa);
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
      AppMethodBeat.o(126645);
      return;
      this.BQc.setVisibility(8);
      this.BQb.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void e(dpa paramdpa);
    
    public abstract void f(dpa paramdpa);
    
    public abstract void g(dpa paramdpa);
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */