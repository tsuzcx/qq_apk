package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

final class x$e
  extends RecyclerView.a
{
  private List<com.tencent.mm.chatroom.storage.a> GvG;
  private x.b Gvu;
  private Context context;
  
  public x$e(Context paramContext, List<com.tencent.mm.chatroom.storage.a> paramList, x.b paramb)
  {
    this.context = paramContext;
    this.GvG = paramList;
    this.Gvu = paramb;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(184987);
    paramViewGroup = new x.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493401, paramViewGroup, false));
    AppMethodBeat.o(184987);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(184988);
    final x.d locald;
    final com.tencent.mm.chatroom.storage.a locala;
    if ((this.GvG != null) && (paramInt >= 0) && (paramInt < this.GvG.size()))
    {
      locald = (x.d)paramv;
      locala = (com.tencent.mm.chatroom.storage.a)this.GvG.get(paramInt);
      ad.d("MicroMsg.roomTodo.GroupTodoComponent", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
      locald.frN.setVisibility(0);
      if (!locala.UY()) {
        break label263;
      }
      locald.fxT.setImageResource(2131231596);
      locald.GvC.setText(bt.by(locala.field_title, this.context.getString(2131757057)));
      if (paramInt != 0) {
        break label406;
      }
      paramv = (RelativeLayout.LayoutParams)locald.GvB.getLayoutParams();
      if (paramv.leftMargin == 0)
      {
        paramv.leftMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 2);
        locald.GvB.setLayoutParams(paramv);
      }
      label158:
      if (locala.field_state != 0) {
        break label452;
      }
      locald.GvD.setVisibility(8);
      if (locala.field_nreply <= 0) {
        break label440;
      }
      locald.GvE.setVisibility(0);
      locald.GvF.setText(locala.field_nreply);
    }
    for (;;)
    {
      locald.GvB.setTag(locala);
      locald.GvB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184985);
          if (x.e.a(x.e.this) != null) {
            x.e.a(x.e.this).M(paramAnonymousView, locald.ln());
          }
          AppMethodBeat.o(184985);
        }
      });
      locald.GvB.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(184986);
          if (x.e.a(x.e.this) != null)
          {
            boolean bool = x.e.a(x.e.this).az(paramAnonymousView, locald.ln());
            AppMethodBeat.o(184986);
            return bool;
          }
          AppMethodBeat.o(184986);
          return false;
        }
      });
      AppMethodBeat.o(184988);
      return;
      label263:
      WxaAttributes localWxaAttributes = ((m)g.ab(m.class)).FW(locala.field_username);
      if (localWxaAttributes == null)
      {
        ((m)g.ab(m.class)).a(locala.field_username, new m.a()
        {
          public final void b(final WxaAttributes paramAnonymousWxaAttributes)
          {
            AppMethodBeat.i(184983);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(184982);
                com.tencent.mm.aw.a.a locala = o.ayJ();
                if (paramAnonymousWxaAttributes != null) {}
                for (String str = paramAnonymousWxaAttributes.field_smallHeadURL;; str = "")
                {
                  locala.a(str, x.e.1.this.GvH.fxT, x.d.frV);
                  if ((bt.isNullOrNil(x.e.1.this.Gvz.field_title)) && (paramAnonymousWxaAttributes != null)) {
                    x.e.1.this.GvH.GvC.setText(paramAnonymousWxaAttributes.field_nickname);
                  }
                  AppMethodBeat.o(184982);
                  return;
                }
              }
            });
            AppMethodBeat.o(184983);
          }
        });
        if (bt.isNullOrNil(locala.field_title)) {
          break;
        }
        locald.GvC.setText(bt.by(locala.field_title, ""));
        break;
      }
      com.tencent.mm.aw.a.a locala1 = o.ayJ();
      if (localWxaAttributes != null) {}
      for (paramv = localWxaAttributes.field_smallHeadURL;; paramv = "")
      {
        locala1.a(paramv, locald.fxT, x.d.frV);
        locald.GvC.setText(bt.by(locala.field_title, localWxaAttributes.field_nickname));
        break;
      }
      label406:
      paramv = (RelativeLayout.LayoutParams)locald.GvB.getLayoutParams();
      if (paramv.leftMargin == 0) {
        break label158;
      }
      paramv.leftMargin = 0;
      locald.GvB.setLayoutParams(paramv);
      break label158;
      label440:
      locald.GvE.setVisibility(8);
      continue;
      label452:
      if (locala.field_state == 1)
      {
        locald.GvD.setVisibility(0);
        locald.GvE.setVisibility(8);
        locald.GvD.setTag(locala);
        locald.GvD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(184984);
            if (x.e.a(x.e.this) != null) {
              x.e.a(x.e.this).aA(paramAnonymousView, locald.ln());
            }
            AppMethodBeat.o(184984);
          }
        });
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(184989);
    int i = this.GvG.size();
    AppMethodBeat.o(184989);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.x.e
 * JD-Core Version:    0.7.0.1
 */