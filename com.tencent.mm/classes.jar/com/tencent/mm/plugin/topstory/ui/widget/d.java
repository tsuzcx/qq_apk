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
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.i;

public final class d
  extends i
{
  private View contentView;
  private View yTc;
  private View yTd;
  private View yTp;
  private View yTq;
  
  public d(Context paramContext, final ddb paramddb, final a parama)
  {
    super(paramContext, 2131821484);
    AppMethodBeat.i(126644);
    this.contentView = LayoutInflater.from(paramContext).inflate(2131495796, null, false);
    this.yTc = this.contentView.findViewById(2131302465);
    this.yTd = this.contentView.findViewById(2131302484);
    this.yTp = this.contentView.findViewById(2131306192);
    this.yTq = this.contentView.findViewById(2131299865);
    this.yTp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126641);
        ad.i("MicroMsg.TopStory.MorePopupWindow", "onClick unlike");
        if (parama != null) {
          parama.e(paramddb);
        }
        AppMethodBeat.o(126641);
      }
    });
    this.yTq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126642);
        ad.i("MicroMsg.TopStory.MorePopupWindow", "onClick favorite");
        if (parama != null) {
          parama.f(paramddb);
        }
        AppMethodBeat.o(126642);
      }
    });
    this.yTq.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164130);
        ad.i("MicroMsg.TopStory.MorePopupWindow", "onLongClick favorite");
        if (parama != null) {
          parama.g(paramddb);
        }
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
      this.yTd.setVisibility(0);
      this.yTc.setVisibility(8);
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
      this.yTd.setVisibility(8);
      this.yTc.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void e(ddb paramddb);
    
    public abstract void f(ddb paramddb);
    
    public abstract void g(ddb paramddb);
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */