package com.tencent.mm.plugin.record.ui.viewWrappers;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.ContextMenu.ContextMenuInfo;
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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.record.model.w;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.pluginsdk.ui.span.x.b;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.base.u.i;

public final class d
  implements h.b
{
  com.tencent.mm.ui.widget.b.a GAa;
  Context context;
  cc hTm;
  int x_down;
  int y_down;
  
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        localObject1 = (TextView)paramAnonymousView;
        Object localObject2 = new SpannableString(((TextView)localObject1).getText());
        ((SpannableString)localObject2).setSpan(new BackgroundColorSpan(d.this.context.getResources().getColor(R.e.FG_3)), 0, ((TextView)localObject1).getText().length(), 33);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        localObject2 = ((TextView)localObject1).getResources();
        d.this.GAa = new com.tencent.mm.ui.widget.b.a(d.this.context, (View)localObject1);
        d.this.GAa.agjw = true;
        d.this.GAa.agju = new u.f()
        {
          public final void OnCreateContextMMMenu(s paramAnonymous2s, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(305303);
            paramAnonymous2s.a(0, 0, d.this.context.getString(R.l.app_copy), R.k.icons_filled_copy);
            if ((!com.tencent.mm.app.plugin.d.aDO()) || (d.2.this.NCS == null))
            {
              AppMethodBeat.o(305303);
              return;
            }
            if (d.2.this.NCT) {
              if (d.2.this.NCU.status != 2) {
                paramAnonymous2s.a(0, 1, d.this.context.getString(R.l.gyI), R.k.icons_filled_translate);
              }
            }
            for (;;)
            {
              com.tencent.mm.ui.chatting.m.a.a(d.this.GAa, paramAnonymous2s, this.NCV, d.2.this.NCF.hIy.desc, d.this.hTm, 2);
              AppMethodBeat.o(305303);
              return;
              paramAnonymous2s.a(0, 2, d.this.context.getString(R.l.gyG), R.k.icons_filled_eyes_off);
              if (d.2.this.NCU.ieR == 1) {
                paramAnonymous2s.a(0, 3, d.this.context.getString(R.l.gyz), R.k.icons_filled_refresh);
              }
            }
          }
        };
        d.this.GAa.GAC = new u.i()
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
              ClipboardHelper.setText(this.lKF.getText());
              k.cY(d.this.context, d.this.context.getString(R.l.app_copy_ok));
              AppMethodBeat.o(28035);
              return;
              if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.lKF.getContext()))
              {
                paramAnonymous2MenuItem = d.2.this.NCS;
                paramAnonymous2Int = d.2.this.pSH;
                if (!d.2.this.NCT) {}
                for (;;)
                {
                  paramAnonymous2MenuItem.bt(paramAnonymous2Int, bool1);
                  AppMethodBeat.o(28035);
                  return;
                  bool1 = false;
                }
                paramAnonymous2MenuItem = d.2.this.NCS;
                w localw = paramAnonymous2MenuItem.agt(d.2.this.pSH);
                if (localw.status == 2)
                {
                  localw.status = 0;
                  paramAnonymous2MenuItem.NCl.notifyDataSetChanged();
                }
                AppMethodBeat.o(28035);
                return;
                paramAnonymous2MenuItem = d.2.this.NCS;
                paramAnonymous2Int = d.2.this.pSH;
                if (!d.2.this.NCT) {}
                for (bool1 = bool2;; bool1 = false)
                {
                  paramAnonymous2MenuItem.bt(paramAnonymous2Int, bool1);
                  AppMethodBeat.o(28035);
                  return;
                }
                com.tencent.mm.ui.chatting.m.a.a(d.this.context, d.2.this.NCF.hIy.desc, d.this.hTm, 2, true);
              }
            }
          }
        };
        d.this.GAa.afLp = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(28036);
            TextView localTextView = this.lKF;
            if (d.2.this.NCT) {}
            for (String str = d.2.this.NCF.hIy.desc;; str = d.2.this.NCU.NAZ)
            {
              localTextView.setText(str);
              int i = d.e(d.2.this.NCF);
              p.u(this.lKF, i);
              AppMethodBeat.o(28036);
              return;
            }
          }
        };
        if ((paramAnonymousView.getTag(R.h.touch_loc) instanceof int[]))
        {
          paramAnonymousView = (int[])paramAnonymousView.getTag(R.h.touch_loc);
          d.this.GAa.fQ(paramAnonymousView[0], paramAnonymousView[1]);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(28037);
          return true;
          d.this.GAa.fQ(d.this.x_down, d.this.y_down);
        }
      }
    });
    AppMethodBeat.o(28040);
  }
  
  static int e(com.tencent.mm.plugin.record.ui.a.b paramb)
  {
    int i = 0;
    if (paramb.dataType == 1) {
      i = 6;
    }
    while (paramb.dataType != 0) {
      return i;
    }
    return 4;
  }
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28039);
    TextView localTextView1 = (TextView)paramView.findViewById(R.h.fUs);
    localTextView1.setText(paramb.hIy.desc);
    Object localObject1 = null;
    bh.bCz();
    this.hTm = c.bzD().sl(paramb.msgId);
    Object localObject2;
    boolean bool;
    label167:
    com.tencent.mm.plugin.record.ui.i locali;
    if (paramb.NBB == 1)
    {
      localObject1 = x.b.YpO.awY(com.tencent.mm.modelappbrand.a.KG(this.hTm.field_talker));
      if (localObject1 != null)
      {
        ((Bundle)localObject1).putString("msgUsername", paramb.NBq);
        ((Bundle)localObject1).putString("serverMsgID", paramb.NCx);
        ((Bundle)localObject1).putString("geta8key_username", this.hTm.field_talker);
        ((Bundle)localObject1).putInt("KMsgType", 1);
        Log.i("MicroMsg.TextViewWrapper", "span extraData = ".concat(String.valueOf(localObject1)));
      }
      int i = e(paramb);
      localObject2 = p.YoF;
      if (bt.U(this.hTm)) {
        break label434;
      }
      bool = true;
      p.a(localTextView1, 1, i, localObject1, (p.a)localObject2, bool);
      localObject2 = (TextView)paramView.findViewById(R.h.fUy);
      localObject1 = paramView.findViewById(R.h.fUz);
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(R.h.fUw);
      ((TextView)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(8);
      localLinearLayout.setVisibility(8);
      locali = (com.tencent.mm.plugin.record.ui.i)paramObject;
      if (locali == null) {
        break label440;
      }
      paramObject = locali.agt(paramInt);
      label256:
      if ((paramObject == null) || (paramObject.status != 2)) {
        break label456;
      }
      ((TextView)localObject2).setText(paramObject.NAZ);
      ((TextView)localObject2).setVisibility(0);
      TextView localTextView2 = (TextView)paramView.findViewById(R.h.fUx);
      if (!Util.isNullOrNil(paramObject.brand)) {
        break label446;
      }
      localObject1 = paramView.getResources().getString(R.l.gXo);
      label321:
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
            d.this.x_down = ((int)paramAnonymousMotionEvent.getRawX());
            d.this.y_down = ((int)paramAnonymousMotionEvent.getRawY());
          }
          AppMethodBeat.o(28033);
          return false;
        }
      });
      AppMethodBeat.o(28039);
      return;
      if (paramb.NBB == 2)
      {
        localObject1 = x.b.YpP.awY(com.tencent.mm.modelappbrand.a.KG(this.hTm.field_talker));
        break;
      }
      if (paramb.NBB != 15) {
        break;
      }
      localObject1 = x.b.YpN.awY(-1);
      break;
      label434:
      bool = false;
      break label167;
      label440:
      paramObject = null;
      break label256;
      label446:
      localObject1 = paramObject.brand;
      break label321;
      label456:
      if ((paramObject != null) && (paramObject.status == 1)) {
        ((View)localObject1).setVisibility(0);
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28038);
    paramContext = View.inflate(paramContext, R.i.gnv, null);
    AppMethodBeat.o(28038);
    return paramContext;
  }
  
  public final void destroy()
  {
    this.context = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.viewWrappers.d
 * JD-Core Version:    0.7.0.1
 */