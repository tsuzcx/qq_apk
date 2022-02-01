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
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;

public final class d
  implements h.b
{
  Context context;
  int mUE;
  int mUF;
  
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
        ((a)localObject).HIu = new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(28034);
            paramAnonymous2ContextMenu.add(0, 0, 0, d.this.context.getString(2131755701));
            if ((!c.LA()) || (d.2.this.vcs == null))
            {
              AppMethodBeat.o(28034);
              return;
            }
            if (d.2.this.vct)
            {
              if (d.2.this.vcu.status != 2)
              {
                paramAnonymous2ContextMenu.add(0, 1, 0, d.this.context.getString(2131757242));
                AppMethodBeat.o(28034);
              }
            }
            else
            {
              paramAnonymous2ContextMenu.add(0, 2, 0, d.this.context.getString(2131757240));
              if (d.2.this.vcu.dBt == 1) {
                paramAnonymous2ContextMenu.add(0, 3, 0, d.this.context.getString(2131757233));
              }
            }
            AppMethodBeat.o(28034);
          }
        };
        ((a)localObject).HrY = new n.d()
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
              ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setText(localTextView.getText());
              h.ce(d.this.context, d.this.context.getString(2131755702));
              AppMethodBeat.o(28035);
              return;
            case 1: 
              paramAnonymous2MenuItem = d.2.this.vcs;
              paramAnonymous2Int = d.2.this.iko;
              if (!d.2.this.vct) {}
              for (;;)
              {
                paramAnonymous2MenuItem.al(paramAnonymous2Int, bool1);
                AppMethodBeat.o(28035);
                return;
                bool1 = false;
              }
            case 2: 
              paramAnonymous2MenuItem = d.2.this.vcs;
              u localu = paramAnonymous2MenuItem.Ke(d.2.this.iko);
              if (localu.status == 2)
              {
                localu.status = 0;
                paramAnonymous2MenuItem.mYx.notifyDataSetChanged();
              }
              AppMethodBeat.o(28035);
              return;
            }
            paramAnonymous2MenuItem = d.2.this.vcs;
            paramAnonymous2Int = d.2.this.iko;
            if (!d.2.this.vct) {}
            for (bool1 = bool2;; bool1 = false)
            {
              paramAnonymous2MenuItem.al(paramAnonymous2Int, bool1);
              break;
            }
          }
        };
        ((a)localObject).Hua = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(28036);
            TextView localTextView = localTextView;
            if (d.2.this.vct) {}
            for (String str = d.2.this.vch.djJ.desc;; str = d.2.this.vcu.vaR)
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
          ((a)localObject).eh(paramAnonymousView[0], paramAnonymousView[1]);
        }
        for (;;)
        {
          AppMethodBeat.o(28037);
          return true;
          ((a)localObject).eh(d.this.mUE, d.this.mUF);
        }
      }
    });
    AppMethodBeat.o(28040);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(28039);
    TextView localTextView1 = (TextView)paramView.findViewById(2131303893);
    localTextView1.setText(paramb.djJ.desc);
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
      paramObject = locali.Ke(paramInt);
      if ((paramObject == null) || (paramObject.status != 2)) {
        break label249;
      }
      localTextView2.setText(paramObject.vaR);
      localTextView2.setVisibility(0);
      TextView localTextView3 = (TextView)paramView.findViewById(2131303899);
      if (!bt.isNullOrNil(paramObject.gXN)) {
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
            d.this.mUE = ((int)paramAnonymousMotionEvent.getRawX());
            d.this.mUF = ((int)paramAnonymousMotionEvent.getRawY());
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
      localObject = paramObject.gXN;
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