package com.tencent.mm.plugin.record.ui.b;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.plugin.c;
import com.tencent.mm.plugin.record.b.w;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.plugin.record.ui.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;

public final class d
  implements h.b
{
  Context context;
  int nYw;
  int nYx;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void a(View paramView, final int paramInt, final com.tencent.mm.plugin.record.ui.a.b paramb, final i parami, final w paramw, final boolean paramBoolean)
  {
    AppMethodBeat.i(28040);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28037);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        localObject1 = (TextView)paramAnonymousView;
        Object localObject2 = new SpannableString(((TextView)localObject1).getText());
        ((SpannableString)localObject2).setSpan(new BackgroundColorSpan(d.this.context.getResources().getColor(2131099736)), 0, ((TextView)localObject1).getText().length(), 33);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        localObject2 = new com.tencent.mm.ui.widget.b.a(d.this.context, (View)localObject1);
        ((com.tencent.mm.ui.widget.b.a)localObject2).Lal = true;
        ((com.tencent.mm.ui.widget.b.a)localObject2).Laj = new n.c()
        {
          public final void a(l paramAnonymous2l, View paramAnonymous2View)
          {
            AppMethodBeat.i(193350);
            paramAnonymous2l.a(0, 0, d.this.context.getString(2131755701), 2131690381);
            if ((!c.Ng()) || (d.2.this.xth == null))
            {
              AppMethodBeat.o(193350);
              return;
            }
            if (d.2.this.xti)
            {
              if (d.2.this.xtj.status != 2)
              {
                paramAnonymous2l.a(0, 1, d.this.context.getString(2131757242), 2131690491);
                AppMethodBeat.o(193350);
              }
            }
            else
            {
              paramAnonymous2l.a(0, 2, d.this.context.getString(2131757240), 2131690398);
              if (d.2.this.xtj.dLt == 1) {
                paramAnonymous2l.a(0, 3, d.this.context.getString(2131757233), 2131690467);
              }
            }
            AppMethodBeat.o(193350);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject2).KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            boolean bool2 = true;
            boolean bool1 = true;
            AppMethodBeat.i(28035);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              AppMethodBeat.o(28035);
              return;
            case 0: 
              ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setText(this.fQY.getText());
              h.ck(d.this.context, d.this.context.getString(2131755702));
              AppMethodBeat.o(28035);
              return;
            case 1: 
              paramAnonymous2MenuItem = d.2.this.xth;
              paramAnonymous2Int = d.2.this.jdE;
              if (!d.2.this.xti) {}
              for (;;)
              {
                paramAnonymous2MenuItem.at(paramAnonymous2Int, bool1);
                AppMethodBeat.o(28035);
                return;
                bool1 = false;
              }
            case 2: 
              paramAnonymous2MenuItem = d.2.this.xth;
              w localw = paramAnonymous2MenuItem.NC(d.2.this.jdE);
              if (localw.status == 2)
              {
                localw.status = 0;
                paramAnonymous2MenuItem.ocf.notifyDataSetChanged();
              }
              AppMethodBeat.o(28035);
              return;
            }
            paramAnonymous2MenuItem = d.2.this.xth;
            paramAnonymous2Int = d.2.this.jdE;
            if (!d.2.this.xti) {}
            for (bool1 = bool2;; bool1 = false)
            {
              paramAnonymous2MenuItem.at(paramAnonymous2Int, bool1);
              break;
            }
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject2).KLB = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(28036);
            TextView localTextView = this.fQY;
            if (d.2.this.xti) {}
            for (String str = d.2.this.xsV.dsC.desc;; str = d.2.this.xtj.xrv)
            {
              localTextView.setText(str);
              k.n(this.fQY, 1);
              AppMethodBeat.o(28036);
              return;
            }
          }
        };
        if ((paramAnonymousView.getTag(2131306044) instanceof int[]))
        {
          paramAnonymousView = (int[])paramAnonymousView.getTag(2131306044);
          ((com.tencent.mm.ui.widget.b.a)localObject2).el(paramAnonymousView[0], paramAnonymousView[1]);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(28037);
          return true;
          ((com.tencent.mm.ui.widget.b.a)localObject2).el(d.this.nYw, d.this.nYx);
        }
      }
    });
    AppMethodBeat.o(28040);
  }
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28039);
    TextView localTextView1 = (TextView)paramView.findViewById(2131303893);
    localTextView1.setText(paramb.dsC.desc);
    k.n(localTextView1, 1);
    TextView localTextView2 = (TextView)paramView.findViewById(2131303900);
    Object localObject = paramView.findViewById(2131303901);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131303897);
    localTextView2.setVisibility(8);
    ((View)localObject).setVisibility(8);
    localLinearLayout.setVisibility(8);
    i locali = (i)paramObject;
    if (locali != null)
    {
      paramObject = locali.NC(paramInt);
      if ((paramObject == null) || (paramObject.status != 2)) {
        break label249;
      }
      localTextView2.setText(paramObject.xrv);
      localTextView2.setVisibility(0);
      TextView localTextView3 = (TextView)paramView.findViewById(2131303899);
      if (!bt.isNullOrNil(paramObject.hQG)) {
        break label239;
      }
      localObject = paramView.getResources().getString(2131764409);
      label170:
      localTextView3.setText((CharSequence)localObject);
      localLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      a(localTextView1, paramInt, paramb, locali, paramObject, true);
      if (locali != null) {
        a(localTextView2, paramInt, paramb, locali, paramObject, false);
      }
      paramView.setOnTouchListener(new d.1(this));
      AppMethodBeat.o(28039);
      return;
      paramObject = null;
      break;
      label239:
      localObject = paramObject.hQG;
      break label170;
      label249:
      if ((paramObject != null) && (paramObject.status == 1)) {
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28038);
    paramContext = View.inflate(paramContext, 2131495218, null);
    AppMethodBeat.o(28038);
    return paramContext;
  }
  
  public final void destroy()
  {
    this.context = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d
 * JD-Core Version:    0.7.0.1
 */