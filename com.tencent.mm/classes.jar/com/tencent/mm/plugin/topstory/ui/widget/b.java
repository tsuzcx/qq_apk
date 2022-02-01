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
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.dim;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class b
  extends i
{
  private Set<aij> AgQ;
  private View AgR;
  private View AgS;
  private TextView AgT;
  private FlowLayout AgU;
  private final aij AgV;
  private View contentView;
  private TextView xsa;
  
  public b(final Context paramContext, final dio paramdio, final a parama)
  {
    super(paramContext, 2131821484);
    AppMethodBeat.i(126636);
    this.AgQ = new HashSet();
    this.AgV = new aij();
    this.AgV.id = "101";
    this.AgV.dlQ = paramContext.getString(2131764467);
    final aij localaij;
    if (paramdio.FSe != null)
    {
      localIterator = paramdio.FSe.FRL.iterator();
      while (localIterator.hasNext())
      {
        localaij = (aij)localIterator.next();
        if (localaij.EDh)
        {
          this.AgV.id = localaij.id;
          this.AgV.dlQ = localaij.dlQ;
          paramdio.FSe.FRL.remove(localaij);
        }
      }
    }
    this.contentView = LayoutInflater.from(paramContext).inflate(2131495772, null, false);
    this.AgR = this.contentView.findViewById(2131299892);
    this.AgS = this.contentView.findViewById(2131299899);
    this.xsa = ((TextView)this.contentView.findViewById(2131299889));
    this.AgT = ((TextView)this.contentView.findViewById(2131306191));
    this.AgT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126632);
        if (b.a(b.this).isEmpty()) {
          b.a(b.this).add(b.b(b.this));
        }
        parama.i(b.a(b.this));
        b.this.dismiss();
        AppMethodBeat.o(126632);
      }
    });
    this.AgU = ((FlowLayout)this.contentView.findViewById(2131299894));
    Iterator localIterator = paramdio.FSe.FRL.iterator();
    while (localIterator.hasNext())
    {
      localaij = (aij)localIterator.next();
      View localView = LayoutInflater.from(paramContext).inflate(2131495773, this.AgU, false);
      final TextView localTextView = (TextView)localView.findViewById(2131299896);
      localTextView.setText(localaij.dlQ);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126633);
          if (b.a(b.this).contains(localaij))
          {
            b.a(b.this).remove(localaij);
            localTextView.setTextColor(paramContext.getResources().getColor(2131101045));
            localTextView.setBackgroundResource(2131234409);
          }
          while (b.a(b.this).isEmpty())
          {
            b.c(b.this).setText(b.b(b.this).dlQ);
            AppMethodBeat.o(126633);
            return;
            b.a(b.this).add(localaij);
            localTextView.setTextColor(paramContext.getResources().getColor(2131101044));
            localTextView.setBackgroundResource(2131234408);
          }
          b.c(b.this).setText(paramContext.getString(2131764468));
          AppMethodBeat.o(126633);
        }
      });
      this.AgU.addView(localView);
    }
    this.xsa.setText(paramdio.FSe.FRJ);
    this.xsa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126634);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", paramdio.FSe.FRK);
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
      this.AgS.setVisibility(0);
      this.AgR.setVisibility(8);
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
      this.AgS.setVisibility(8);
      this.AgR.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void i(Set<aij> paramSet);
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */