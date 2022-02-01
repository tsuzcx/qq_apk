package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.List;

public final class y$d
  extends RecyclerView.a
{
  private y.a Gwj;
  private Context context;
  private List<GroupToolItem> frY;
  
  public y$d(Context paramContext, List<GroupToolItem> paramList, y.a parama)
  {
    this.context = paramContext;
    this.frY = paramList;
    this.Gwj = parama;
  }
  
  private static void a(y.b paramb, WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(179880);
    com.tencent.mm.aw.a.a locala = o.ayJ();
    Object localObject;
    if (paramWxaAttributes != null)
    {
      localObject = paramWxaAttributes.field_smallHeadURL;
      locala.a((String)localObject, paramb.fxT, y.b.frV);
      localObject = paramb.GvC;
      if (paramWxaAttributes == null) {
        break label61;
      }
    }
    label61:
    for (paramb = paramWxaAttributes.field_nickname;; paramb = "")
    {
      ((TextView)localObject).setText(paramb);
      AppMethodBeat.o(179880);
      return;
      localObject = "";
      break;
    }
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(179878);
    paramViewGroup = new y.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493405, paramViewGroup, false));
    AppMethodBeat.o(179878);
    return paramViewGroup;
  }
  
  public final void a(final RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(179879);
    GroupToolItem localGroupToolItem;
    if ((this.frY != null) && (paramInt >= 0) && (paramInt < this.frY.size()))
    {
      paramv = (y.b)paramv;
      localGroupToolItem = (GroupToolItem)this.frY.get(paramInt);
      paramv.frN.setVisibility(0);
      if (!localGroupToolItem.Va()) {
        break label110;
      }
      paramv.fxT.setImageResource(2131232617);
      paramv.GvC.setText(2131760128);
    }
    for (;;)
    {
      paramv.frN.setTag(localGroupToolItem);
      paramv.frN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179877);
          if (y.d.a(y.d.this) != null) {
            y.d.a(y.d.this).onClick(paramAnonymousView);
          }
          AppMethodBeat.o(179877);
        }
      });
      AppMethodBeat.o(179879);
      return;
      label110:
      if (localGroupToolItem.ccm())
      {
        paramv.fxT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691535));
        paramv.GvC.setText(2131756264);
      }
      else
      {
        WxaAttributes localWxaAttributes = ((m)g.ab(m.class)).FW(localGroupToolItem.username);
        if (localWxaAttributes == null) {
          ((m)g.ab(m.class)).a(localGroupToolItem.username, new m.a()
          {
            public final void b(final WxaAttributes paramAnonymousWxaAttributes)
            {
              AppMethodBeat.i(179876);
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179875);
                  y.d.b(y.d.1.this.Gwk, paramAnonymousWxaAttributes);
                  AppMethodBeat.o(179875);
                }
              });
              AppMethodBeat.o(179876);
            }
          });
        } else {
          a(paramv, localWxaAttributes);
        }
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(179881);
    int i = this.frY.size();
    AppMethodBeat.o(179881);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.y.d
 * JD-Core Version:    0.7.0.1
 */