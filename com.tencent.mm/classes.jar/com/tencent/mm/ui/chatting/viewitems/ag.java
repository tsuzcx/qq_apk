package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.PluginRingtone.a;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.a.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgRingtone;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "()V", "filling", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "isShowRemindMenu", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "support", "msgType", "Companion", "RingtoneMsgViewHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends c
{
  public static final ag.a aeRE;
  
  static
  {
    AppMethodBeat.i(255176);
    aeRE = new ag.a((byte)0);
    AppMethodBeat.o(255176);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(255185);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramLayoutInflater = new ap(paramLayoutInflater, R.i.gfi);
      paramLayoutInflater.setTag(new b().lI((View)paramLayoutInflater));
      paramLayoutInflater = (View)paramLayoutInflater;
      AppMethodBeat.o(255185);
      return paramLayoutInflater;
    }
    AppMethodBeat.o(255185);
    return paramView;
  }
  
  public final void a(c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, String paramString)
  {
    AppMethodBeat.i(255193);
    kotlin.g.b.s.u(parama, "holder");
    kotlin.g.b.s.u(parama1, "ui");
    kotlin.g.b.s.u(paramcc, "msg");
    kotlin.g.b.s.u(paramString, "userName");
    MMNeat7extView localMMNeat7extView1;
    MMNeat7extView localMMNeat7extView2;
    try
    {
      Log.i("MicroMsg.ChattingItemAppMsgRingtone", "fill item %d, msgId %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramcc.field_msgId) });
      localObject = parama1.aezO.getContext();
      localMMNeat7extView1 = ((b)parama).aeRG;
      if (localMMNeat7extView1 == null)
      {
        AppMethodBeat.o(255193);
        return;
      }
      localMMNeat7extView2 = ((b)parama).aeRF;
      if (localMMNeat7extView2 == null)
      {
        AppMethodBeat.o(255193);
        return;
      }
    }
    catch (Exception parama)
    {
      Log.e("MicroMsg.ChattingItemAppMsgRingtone", "error happened parse msg info");
      AppMethodBeat.o(255193);
      return;
    }
    float f = ((Activity)localObject).getResources().getDimensionPixelSize(R.f.HintTextSize);
    localMMNeat7extView1.setTextSize(0, com.tencent.mm.cd.a.getScaleSize((Context)localObject) * f);
    localMMNeat7extView1.setPadding(((Activity)localObject).getResources().getDimensionPixelSize(R.f.LittlePadding), ((Activity)localObject).getResources().getDimensionPixelSize(R.f.LittlePadding), ((Activity)localObject).getResources().getDimensionPixelSize(R.f.LittlePadding), ((Activity)localObject).getResources().getDimensionPixelSize(R.f.LittlePadding));
    localMMNeat7extView1.setTextGravity(1);
    localMMNeat7extView1.setClickable(true);
    f = ((Activity)localObject).getResources().getDimensionPixelSize(R.f.HintTextSize);
    localMMNeat7extView2.setTextSize(0, com.tencent.mm.cd.a.getScaleSize((Context)localObject) * f);
    localMMNeat7extView2.setPadding(((Activity)localObject).getResources().getDimensionPixelSize(R.f.LittlePadding), ((Activity)localObject).getResources().getDimensionPixelSize(R.f.LittlePadding), ((Activity)localObject).getResources().getDimensionPixelSize(R.f.LittlePadding), ((Activity)localObject).getResources().getDimensionPixelSize(R.f.LittlePadding));
    localMMNeat7extView2.setTextGravity(1);
    localMMNeat7extView2.setClickable(true);
    paramInt = parama1.aezO.getContext().getResources().getColor(R.e.link_color);
    final int i = parama1.aezO.getContext().getResources().getColor(R.e.link_color_pressed);
    if (paramcc.getType() == 85) {
      parama = com.tencent.mm.plugin.voip.f.c.ULf;
    }
    for (parama = com.tencent.mm.plugin.voip.f.c.iaX(); parama == null; parama = com.tencent.mm.plugin.voip.f.c.iaY())
    {
      AppMethodBeat.o(255193);
      return;
      parama = com.tencent.mm.plugin.voip.f.c.ULf;
    }
    Object localObject = (String)k.X(parama);
    parama = (String)k.Z(parama);
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable((CharSequence)parama);
    kotlin.g.b.s.s(localSpannable, "getInstance().newSpannable(linkText)");
    ch localch = new ch();
    localch.aeVf = ((ClickableSpan)new c(paramString, paramcc, parama1, paramInt, i));
    localch.start = 0;
    localch.end = parama.length();
    localSpannable.setSpan(localch.aeVf, localch.start, localch.end, 18);
    localMMNeat7extView2.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.FG_2));
    localMMNeat7extView2.a((CharSequence)localSpannable, TextView.BufferType.SPANNABLE);
    paramcc.setContent(kotlin.g.b.s.X((String)localObject, parama));
    localMMNeat7extView2.setTag(new bz(paramcc, false, 0, "", '\000'));
    localMMNeat7extView2.setBackground(parama1.aezO.getContext().getResources().getDrawable(R.g.fnn));
    localMMNeat7extView1.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.FG_2));
    localMMNeat7extView1.aZ((CharSequence)localObject);
    localMMNeat7extView1.setTag(new bz(paramcc, false, 0, "", '\000'));
    AppMethodBeat.o(255193);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255205);
    kotlin.g.b.s.u(paramMenuItem, "item");
    kotlin.g.b.s.u(parama, "ui");
    kotlin.g.b.s.u(paramcc, "msg");
    AppMethodBeat.o(255205);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255196);
    kotlin.g.b.s.u(params, "menu");
    kotlin.g.b.s.u(paramView, "v");
    kotlin.g.b.s.u(paramContextMenuInfo, "menuInfo");
    kotlin.g.b.s.u(paramcc, "msg");
    AppMethodBeat.o(255196);
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255200);
    kotlin.g.b.s.u(paramView, "v");
    kotlin.g.b.s.u(parama, "ui");
    kotlin.g.b.s.u(paramcc, "msg");
    AppMethodBeat.o(255200);
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 85) || (paramInt == 86);
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  public final boolean jxi()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgRingtone$RingtoneMsgViewHolder;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "()V", "msgLinker", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getMsgLinker", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setMsgLinker", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "msgTitle", "getMsgTitle", "setMsgTitle", "createViewHolder", "convertView", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends c.a
  {
    MMNeat7extView aeRF;
    MMNeat7extView aeRG;
    
    public final b lI(View paramView)
    {
      AppMethodBeat.i(255713);
      kotlin.g.b.s.u(paramView, "convertView");
      super.create(paramView);
      this.aeRG = ((MMNeat7extView)paramView.findViewById(R.h.fVc));
      this.aeRF = ((MMNeat7extView)paramView.findViewById(R.h.fVb));
      AppMethodBeat.o(255713);
      return this;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgRingtone$filling$1", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "onClick", "", "v", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends t
  {
    c(String paramString, cc paramcc, com.tencent.mm.ui.chatting.d.a parama, int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public final void onClick(View paramView)
    {
      int i = 0;
      int j = 1;
      AppMethodBeat.i(255711);
      kotlin.g.b.s.u(paramView, "v");
      Log.i("MicroMsg.ChattingItemAppMsgRingtone", "[onClick] app msg enter to ringtone setting ui");
      paramView = this.pmW;
      boolean bool;
      if (paramcc.getType() == 85)
      {
        bool = true;
        com.tencent.mm.plugin.voip.f.c.dx(paramView, bool);
        switch (paramcc.getType())
        {
        }
      }
      for (;;)
      {
        paramView = PluginRingtone.OBl;
        paramView = paramcc.field_content;
        kotlin.g.b.s.s(paramView, "msg.content");
        PluginRingtone.a.K(j, 2, paramView);
        paramView = PluginRingtone.OBl;
        paramView = parama1.aezO.getContext();
        kotlin.g.b.s.s(paramView, "ui.context");
        PluginRingtone.a.enterRingtoneSettingUI((Context)paramView, i);
        AppMethodBeat.o(255711);
        return;
        bool = false;
        break;
        i = 2;
        continue;
        i = 3;
        j = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag
 * JD-Core Version:    0.7.0.1
 */