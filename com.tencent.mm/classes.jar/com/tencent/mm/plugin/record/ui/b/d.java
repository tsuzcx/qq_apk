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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.record.b.w;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.l.a;
import com.tencent.mm.pluginsdk.ui.span.t.b;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.e;
import com.tencent.mm.ui.base.q.g;

public final class d
  implements h.b
{
  com.tencent.mm.ui.widget.b.a AYp;
  Context context;
  ca fNz;
  int syc;
  int syd;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void a(View paramView, final int paramInt, final com.tencent.mm.plugin.record.ui.a.b paramb, final com.tencent.mm.plugin.record.ui.i parami, final w paramw, final boolean paramBoolean)
  {
    AppMethodBeat.i(28040);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28037);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        localObject1 = (TextView)paramAnonymousView;
        Object localObject2 = new SpannableString(((TextView)localObject1).getText());
        ((SpannableString)localObject2).setSpan(new BackgroundColorSpan(d.this.context.getResources().getColor(R.e.FG_3)), 0, ((TextView)localObject1).getText().length(), 33);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        localObject2 = ((TextView)localObject1).getResources();
        d.this.AYp = new com.tencent.mm.ui.widget.b.a(d.this.context, (View)localObject1);
        d.this.AYp.Yri = true;
        d.this.AYp.Yrg = new q.e()
        {
          public final void a(o paramAnonymous2o, View paramAnonymous2View)
          {
            AppMethodBeat.i(281588);
            paramAnonymous2o.a(0, 0, d.this.context.getString(R.l.app_copy), R.k.icons_filled_copy);
            if ((!com.tencent.mm.app.plugin.d.abP()) || (d.2.this.HFq == null))
            {
              AppMethodBeat.o(281588);
              return;
            }
            if (d.2.this.HFr) {
              if (d.2.this.HFs.status != 2) {
                paramAnonymous2o.a(0, 1, d.this.context.getString(R.l.ewi), R.k.icons_filled_translate);
              }
            }
            for (;;)
            {
              com.tencent.mm.ui.chatting.q.a.a(d.this.AYp, paramAnonymous2o, this.HFt, d.2.this.HFd.fDI.desc, d.this.fNz, 2);
              AppMethodBeat.o(281588);
              return;
              paramAnonymous2o.a(0, 2, d.this.context.getString(R.l.ewg), R.k.icons_filled_eyes_off);
              if (d.2.this.HFs.fYP == 1) {
                paramAnonymous2o.a(0, 3, d.this.context.getString(R.l.evZ), R.k.icons_filled_refresh);
              }
            }
          }
        };
        d.this.AYp.ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            boolean bool2 = true;
            boolean bool1 = true;
            AppMethodBeat.i(28035);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(28035);
              return;
              ClipboardHelper.setText(this.jip.getText());
              h.cN(d.this.context, d.this.context.getString(R.l.app_copy_ok));
              AppMethodBeat.o(28035);
              return;
              if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.jip.getContext()))
              {
                paramAnonymous2MenuItem = d.2.this.HFq;
                paramAnonymous2Int = d.2.this.mWa;
                if (!d.2.this.HFr) {}
                for (;;)
                {
                  paramAnonymous2MenuItem.aR(paramAnonymous2Int, bool1);
                  AppMethodBeat.o(28035);
                  return;
                  bool1 = false;
                }
                paramAnonymous2MenuItem = d.2.this.HFq;
                w localw = paramAnonymous2MenuItem.acf(d.2.this.mWa);
                if (localw.status == 2)
                {
                  localw.status = 0;
                  paramAnonymous2MenuItem.HEJ.notifyDataSetChanged();
                }
                AppMethodBeat.o(28035);
                return;
                paramAnonymous2MenuItem = d.2.this.HFq;
                paramAnonymous2Int = d.2.this.mWa;
                if (!d.2.this.HFr) {}
                for (bool1 = bool2;; bool1 = false)
                {
                  paramAnonymous2MenuItem.aR(paramAnonymous2Int, bool1);
                  AppMethodBeat.o(28035);
                  return;
                }
                com.tencent.mm.ui.chatting.q.a.a(d.this.context, d.2.this.HFd.fDI.desc, d.this.fNz, 2, true);
              }
            }
          }
        };
        d.this.AYp.XVa = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(28036);
            TextView localTextView = this.jip;
            if (d.2.this.HFr) {}
            for (String str = d.2.this.HFd.fDI.desc;; str = d.2.this.HFs.HDx)
            {
              localTextView.setText(str);
              l.q(this.jip, 1);
              AppMethodBeat.o(28036);
              return;
            }
          }
        };
        if ((paramAnonymousView.getTag(R.h.touch_loc) instanceof int[]))
        {
          paramAnonymousView = (int[])paramAnonymousView.getTag(R.h.touch_loc);
          d.this.AYp.eY(paramAnonymousView[0], paramAnonymousView[1]);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(28037);
          return true;
          d.this.AYp.eY(d.this.syc, d.this.syd);
        }
      }
    });
    AppMethodBeat.o(28040);
  }
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28039);
    TextView localTextView1 = (TextView)paramView.findViewById(R.h.dSs);
    localTextView1.setText(paramb.fDI.desc);
    Object localObject1 = null;
    bh.beI();
    this.fNz = c.bbO().Oq(paramb.msgId);
    Object localObject2;
    boolean bool;
    label139:
    com.tencent.mm.plugin.record.ui.i locali;
    if (paramb.HDZ == 1)
    {
      localObject1 = t.b.Rts.aqS(com.tencent.mm.modelappbrand.a.SF(this.fNz.field_talker));
      if (localObject1 != null)
      {
        ((Bundle)localObject1).putString("msgUsername", paramb.HDO);
        ((Bundle)localObject1).putString("serverMsgID", paramb.HEV);
        Log.i("MicroMsg.TextViewWrapper", "span extraData = ".concat(String.valueOf(localObject1)));
      }
      localObject2 = l.Rsm;
      if (bs.Q(this.fNz)) {
        break label405;
      }
      bool = true;
      l.a(localTextView1, 1, 4, localObject1, (l.a)localObject2, bool);
      localObject2 = (TextView)paramView.findViewById(R.h.dSy);
      localObject1 = paramView.findViewById(R.h.dSz);
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(R.h.dSw);
      ((TextView)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(8);
      localLinearLayout.setVisibility(8);
      locali = (com.tencent.mm.plugin.record.ui.i)paramObject;
      if (locali == null) {
        break label411;
      }
      paramObject = locali.acf(paramInt);
      label227:
      if ((paramObject == null) || (paramObject.status != 2)) {
        break label427;
      }
      ((TextView)localObject2).setText(paramObject.HDx);
      ((TextView)localObject2).setVisibility(0);
      TextView localTextView2 = (TextView)paramView.findViewById(R.h.dSx);
      if (!Util.isNullOrNil(paramObject.brand)) {
        break label417;
      }
      localObject1 = paramView.getResources().getString(R.l.eUq);
      label292:
      localTextView2.setText((CharSequence)localObject1);
      localLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      a(localTextView1, paramInt, paramb, locali, paramObject, true);
      if (locali != null) {
        a((View)localObject2, paramInt, paramb, locali, paramObject, false);
      }
      paramView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(28033);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            d.this.syc = ((int)paramAnonymousMotionEvent.getRawX());
            d.this.syd = ((int)paramAnonymousMotionEvent.getRawY());
          }
          AppMethodBeat.o(28033);
          return false;
        }
      });
      AppMethodBeat.o(28039);
      return;
      if (paramb.HDZ == 2)
      {
        localObject1 = t.b.Rtt.aqS(com.tencent.mm.modelappbrand.a.SF(this.fNz.field_talker));
        break;
      }
      if (paramb.HDZ != 15) {
        break;
      }
      localObject1 = t.b.Rtr.aqS(-1);
      break;
      label405:
      bool = false;
      break label139;
      label411:
      paramObject = null;
      break label227;
      label417:
      localObject1 = paramObject.brand;
      break label292;
      label427:
      if ((paramObject != null) && (paramObject.status == 1)) {
        ((View)localObject1).setVisibility(0);
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28038);
    paramContext = View.inflate(paramContext, R.i.ekq, null);
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