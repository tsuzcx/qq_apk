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
import com.tencent.mm.bs.d;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.dcz;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class b
  extends i
{
  private View contentView;
  private TextView wgK;
  private Set<ahk> yTb;
  private View yTc;
  private View yTd;
  private TextView yTe;
  private FlowLayout yTf;
  private final ahk yTg;
  
  public b(final Context paramContext, final ddb paramddb, final a parama)
  {
    super(paramContext, 2131821484);
    AppMethodBeat.i(126636);
    this.yTb = new HashSet();
    this.yTg = new ahk();
    this.yTg.id = "101";
    this.yTg.doh = paramContext.getString(2131764467);
    final ahk localahk;
    if (paramddb.Evd != null)
    {
      localIterator = paramddb.Evd.EuK.iterator();
      while (localIterator.hasNext())
      {
        localahk = (ahk)localIterator.next();
        if (localahk.Dkb)
        {
          this.yTg.id = localahk.id;
          this.yTg.doh = localahk.doh;
          paramddb.Evd.EuK.remove(localahk);
        }
      }
    }
    this.contentView = LayoutInflater.from(paramContext).inflate(2131495772, null, false);
    this.yTc = this.contentView.findViewById(2131299892);
    this.yTd = this.contentView.findViewById(2131299899);
    this.wgK = ((TextView)this.contentView.findViewById(2131299889));
    this.yTe = ((TextView)this.contentView.findViewById(2131306191));
    this.yTe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126632);
        if (b.a(b.this).isEmpty()) {
          b.a(b.this).add(b.b(b.this));
        }
        parama.h(b.a(b.this));
        b.this.dismiss();
        AppMethodBeat.o(126632);
      }
    });
    this.yTf = ((FlowLayout)this.contentView.findViewById(2131299894));
    Iterator localIterator = paramddb.Evd.EuK.iterator();
    while (localIterator.hasNext())
    {
      localahk = (ahk)localIterator.next();
      View localView = LayoutInflater.from(paramContext).inflate(2131495773, this.yTf, false);
      final TextView localTextView = (TextView)localView.findViewById(2131299896);
      localTextView.setText(localahk.doh);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126633);
          if (b.a(b.this).contains(localahk))
          {
            b.a(b.this).remove(localahk);
            localTextView.setTextColor(paramContext.getResources().getColor(2131101045));
            localTextView.setBackgroundResource(2131234409);
          }
          while (b.a(b.this).isEmpty())
          {
            b.c(b.this).setText(b.b(b.this).doh);
            AppMethodBeat.o(126633);
            return;
            b.a(b.this).add(localahk);
            localTextView.setTextColor(paramContext.getResources().getColor(2131101044));
            localTextView.setBackgroundResource(2131234408);
          }
          b.c(b.this).setText(paramContext.getString(2131764468));
          AppMethodBeat.o(126633);
        }
      });
      this.yTf.addView(localView);
    }
    this.wgK.setText(paramddb.Evd.EuI);
    this.wgK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126634);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", paramddb.Evd.EuJ);
        d.b(b.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
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
      AppMethodBeat.o(126637);
      return;
      this.yTd.setVisibility(8);
      this.yTc.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void h(Set<ahk> paramSet);
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */