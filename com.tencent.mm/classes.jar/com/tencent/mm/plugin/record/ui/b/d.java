package com.tencent.mm.plugin.record.ui.b;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.plugin.c;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.plugin.record.ui.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;

public final class d
  implements h.b
{
  Context context;
  int nwY;
  int nwZ;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void a(View paramView, final int paramInt, final b paramb, final i parami, final u paramu, final boolean paramBoolean)
  {
    AppMethodBeat.i(28040);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28037);
        final TextView localTextView = (TextView)paramAnonymousView;
        Object localObject = new SpannableString(localTextView.getText());
        ((SpannableString)localObject).setSpan(new BackgroundColorSpan(d.this.context.getResources().getColor(2131099736)), 0, localTextView.getText().length(), 33);
        localTextView.setText((CharSequence)localObject);
        localObject = new a(d.this.context, localTextView);
        ((a)localObject).JiR = new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(28034);
            paramAnonymous2ContextMenu.add(0, 0, 0, d.this.context.getString(2131755701));
            if ((!c.Ly()) || (d.2.this.wll == null))
            {
              AppMethodBeat.o(28034);
              return;
            }
            if (d.2.this.wlm)
            {
              if (d.2.this.wln.status != 2)
              {
                paramAnonymous2ContextMenu.add(0, 1, 0, d.this.context.getString(2131757242));
                AppMethodBeat.o(28034);
              }
            }
            else
            {
              paramAnonymous2ContextMenu.add(0, 2, 0, d.this.context.getString(2131757240));
              if (d.2.this.wln.dzh == 1) {
                paramAnonymous2ContextMenu.add(0, 3, 0, d.this.context.getString(2131757233));
              }
            }
            AppMethodBeat.o(28034);
          }
        };
        ((a)localObject).ISv = new n.d()
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
              ((ClipboardManager)ai.getContext().getSystemService("clipboard")).setText(localTextView.getText());
              h.cf(d.this.context, d.this.context.getString(2131755702));
              AppMethodBeat.o(28035);
              return;
            case 1: 
              paramAnonymous2MenuItem = d.2.this.wll;
              paramAnonymous2Int = d.2.this.iKv;
              if (!d.2.this.wlm) {}
              for (;;)
              {
                paramAnonymous2MenuItem.ao(paramAnonymous2Int, bool1);
                AppMethodBeat.o(28035);
                return;
                bool1 = false;
              }
            case 2: 
              paramAnonymous2MenuItem = d.2.this.wll;
              u localu = paramAnonymous2MenuItem.Md(d.2.this.iKv);
              if (localu.status == 2)
              {
                localu.status = 0;
                paramAnonymous2MenuItem.nAW.notifyDataSetChanged();
              }
              AppMethodBeat.o(28035);
              return;
            }
            paramAnonymous2MenuItem = d.2.this.wll;
            paramAnonymous2Int = d.2.this.iKv;
            if (!d.2.this.wlm) {}
            for (bool1 = bool2;; bool1 = false)
            {
              paramAnonymous2MenuItem.ao(paramAnonymous2Int, bool1);
              break;
            }
          }
        };
        ((a)localObject).IUx = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(28036);
            TextView localTextView = localTextView;
            if (d.2.this.wlm) {}
            for (String str = d.2.this.wla.dhe.desc;; str = d.2.this.wln.wjF)
            {
              localTextView.setText(str);
              k.m(localTextView, 1);
              AppMethodBeat.o(28036);
              return;
            }
          }
        };
        if ((paramAnonymousView.getTag(2131306044) instanceof int[]))
        {
          paramAnonymousView = (int[])paramAnonymousView.getTag(2131306044);
          ((a)localObject).ej(paramAnonymousView[0], paramAnonymousView[1]);
        }
        for (;;)
        {
          AppMethodBeat.o(28037);
          return true;
          ((a)localObject).ej(d.this.nwY, d.this.nwZ);
        }
      }
    });
    AppMethodBeat.o(28040);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(28039);
    TextView localTextView1 = (TextView)paramView.findViewById(2131303893);
    localTextView1.setText(paramb.dhe.desc);
    k.m(localTextView1, 1);
    TextView localTextView2 = (TextView)paramView.findViewById(2131303900);
    Object localObject = paramView.findViewById(2131303901);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131303897);
    localTextView2.setVisibility(8);
    ((View)localObject).setVisibility(8);
    localLinearLayout.setVisibility(8);
    i locali = (i)paramObject;
    if (locali != null)
    {
      paramObject = locali.Md(paramInt);
      if ((paramObject == null) || (paramObject.status != 2)) {
        break label249;
      }
      localTextView2.setText(paramObject.wjF);
      localTextView2.setVisibility(0);
      TextView localTextView3 = (TextView)paramView.findViewById(2131303899);
      if (!bs.isNullOrNil(paramObject.hym)) {
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
      paramView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(28033);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            d.this.nwY = ((int)paramAnonymousMotionEvent.getRawX());
            d.this.nwZ = ((int)paramAnonymousMotionEvent.getRawY());
          }
          AppMethodBeat.o(28033);
          return false;
        }
      });
      AppMethodBeat.o(28039);
      return;
      paramObject = null;
      break;
      label239:
      localObject = paramObject.hym;
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