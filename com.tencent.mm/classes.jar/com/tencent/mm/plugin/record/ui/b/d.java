package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.plugin.c;
import com.tencent.mm.plugin.record.b.w;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.plugin.record.ui.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.t.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.e;
import com.tencent.mm.ui.base.o.g;

public final class d
  implements h.b
{
  Context context;
  int ppd;
  int ppe;
  
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        localObject1 = (TextView)paramAnonymousView;
        Object localObject2 = new SpannableString(((TextView)localObject1).getText());
        ((SpannableString)localObject2).setSpan(new BackgroundColorSpan(d.this.context.getResources().getColor(2131099750)), 0, ((TextView)localObject1).getText().length(), 33);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        localObject2 = new com.tencent.mm.ui.widget.b.a(d.this.context, (View)localObject1);
        ((com.tencent.mm.ui.widget.b.a)localObject2).QSv = true;
        ((com.tencent.mm.ui.widget.b.a)localObject2).QSt = new o.e()
        {
          public final void a(m paramAnonymous2m, View paramAnonymous2View)
          {
            AppMethodBeat.i(232054);
            paramAnonymous2m.a(0, 0, d.this.context.getString(2131755772), 2131690525);
            if ((!c.Xn()) || (d.2.this.BJh == null))
            {
              AppMethodBeat.o(232054);
              return;
            }
            if (d.2.this.BJi)
            {
              if (d.2.this.BJj.status != 2)
              {
                paramAnonymous2m.a(0, 1, d.this.context.getString(2131757455), 2131690699);
                AppMethodBeat.o(232054);
              }
            }
            else
            {
              paramAnonymous2m.a(0, 2, d.this.context.getString(2131757453), 2131690549);
              if (d.2.this.BJj.eeA == 1) {
                paramAnonymous2m.a(0, 3, d.this.context.getString(2131757445), 2131690658);
              }
            }
            AppMethodBeat.o(232054);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject2).HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            boolean bool2 = true;
            boolean bool1 = true;
            AppMethodBeat.i(28035);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
            case 0: 
            case 1: 
              do
              {
                AppMethodBeat.o(28035);
                return;
                ClipboardHelper.setText(this.gym.getText());
                h.cC(d.this.context, d.this.context.getString(2131755773));
                AppMethodBeat.o(28035);
                return;
              } while (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.gym.getContext()));
              paramAnonymous2MenuItem = d.2.this.BJh;
              paramAnonymous2Int = d.2.this.keB;
              if (!d.2.this.BJi) {}
              for (;;)
              {
                paramAnonymous2MenuItem.aK(paramAnonymous2Int, bool1);
                AppMethodBeat.o(28035);
                return;
                bool1 = false;
              }
            case 2: 
              paramAnonymous2MenuItem = d.2.this.BJh;
              w localw = paramAnonymous2MenuItem.Vx(d.2.this.keB);
              if (localw.status == 2)
              {
                localw.status = 0;
                paramAnonymous2MenuItem.BIB.notifyDataSetChanged();
              }
              AppMethodBeat.o(28035);
              return;
            }
            paramAnonymous2MenuItem = d.2.this.BJh;
            paramAnonymous2Int = d.2.this.keB;
            if (!d.2.this.BJi) {}
            for (bool1 = bool2;; bool1 = false)
            {
              paramAnonymous2MenuItem.aK(paramAnonymous2Int, bool1);
              break;
            }
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject2).QwU = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(28036);
            TextView localTextView = this.gym;
            if (d.2.this.BJi) {}
            for (String str = d.2.this.BIV.dKT.desc;; str = d.2.this.BJj.BHr)
            {
              localTextView.setText(str);
              l.p(this.gym, 1);
              AppMethodBeat.o(28036);
              return;
            }
          }
        };
        if ((paramAnonymousView.getTag(2131309367) instanceof int[]))
        {
          paramAnonymousView = (int[])paramAnonymousView.getTag(2131309367);
          ((com.tencent.mm.ui.widget.b.a)localObject2).ez(paramAnonymousView[0], paramAnonymousView[1]);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(28037);
          return true;
          ((com.tencent.mm.ui.widget.b.a)localObject2).ez(d.this.ppd, d.this.ppe);
        }
      }
    });
    AppMethodBeat.o(28040);
  }
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28039);
    TextView localTextView1 = (TextView)paramView.findViewById(2131306722);
    localTextView1.setText(paramb.dKT.desc);
    Object localObject = null;
    TextView localTextView2;
    i locali;
    if (paramb.BHS == 1)
    {
      localObject = t.b.Ksl.grZ();
      if (localObject != null)
      {
        ((Bundle)localObject).putString("msgUsername", paramb.BHK);
        ((Bundle)localObject).putString("serverMsgID", paramb.BIN);
        Log.i("MicroMsg.TextViewWrapper", "span extraData = ".concat(String.valueOf(localObject)));
      }
      l.a(localTextView1, 1, 4, localObject, l.Krf);
      localTextView2 = (TextView)paramView.findViewById(2131306729);
      localObject = paramView.findViewById(2131306730);
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131306726);
      localTextView2.setVisibility(8);
      ((View)localObject).setVisibility(8);
      localLinearLayout.setVisibility(8);
      locali = (i)paramObject;
      if (locali == null) {
        break label339;
      }
      paramObject = locali.Vx(paramInt);
      label174:
      if ((paramObject == null) || (paramObject.status != 2)) {
        break label355;
      }
      localTextView2.setText(paramObject.BHr);
      localTextView2.setVisibility(0);
      TextView localTextView3 = (TextView)paramView.findViewById(2131306728);
      if (!Util.isNullOrNil(paramObject.brand)) {
        break label345;
      }
      localObject = paramView.getResources().getString(2131766752);
      label237:
      localTextView3.setText((CharSequence)localObject);
      localLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      a(localTextView1, paramInt, paramb, locali, paramObject, true);
      if (locali != null) {
        a(localTextView2, paramInt, paramb, locali, paramObject, false);
      }
      paramView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(28033);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            d.this.ppd = ((int)paramAnonymousMotionEvent.getRawX());
            d.this.ppe = ((int)paramAnonymousMotionEvent.getRawY());
          }
          AppMethodBeat.o(28033);
          return false;
        }
      });
      AppMethodBeat.o(28039);
      return;
      if (paramb.BHS == 2)
      {
        localObject = t.b.Ksm.grZ();
        break;
      }
      if (paramb.BHS != 15) {
        break;
      }
      localObject = t.b.Ksk.grZ();
      break;
      label339:
      paramObject = null;
      break label174;
      label345:
      localObject = paramObject.brand;
      break label237;
      label355:
      if ((paramObject != null) && (paramObject.status == 1)) {
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28038);
    paramContext = View.inflate(paramContext, 2131496061, null);
    AppMethodBeat.o(28038);
    return paramContext;
  }
  
  public final void destroy()
  {
    this.context = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d
 * JD-Core Version:    0.7.0.1
 */