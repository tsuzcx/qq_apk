package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.a.a.a;
import com.tencent.mm.ui.chatting.viewitems.a.b;
import com.tencent.mm.ui.chatting.viewitems.a.b.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemFinderLiveNotifyTmpl;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "selectors", "Ljava/util/HashMap;", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl;", "Lkotlin/collections/HashMap;", "getSelectors", "()Ljava/util/HashMap;", "setSelectors", "(Ljava/util/HashMap;)V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "filling", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "isShowRemindMenu", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "support", "msgType", "FinderLiveNotifyHolder", "app_release"})
public final class av
  extends c
{
  private final String TAG;
  private com.tencent.mm.ui.chatting.e.a WBq;
  private HashMap<String, b> XjQ;
  
  public av()
  {
    AppMethodBeat.i(232458);
    this.TAG = "ChattingItemFinderLiveNotifyTmpl";
    this.XjQ = new HashMap();
    HashMap localHashMap = this.XjQ;
    a.a locala = com.tencent.mm.ui.chatting.viewitems.a.a.Xoc;
    localHashMap.put(com.tencent.mm.ui.chatting.viewitems.a.a.hUa(), new com.tencent.mm.ui.chatting.viewitems.a.a());
    AppMethodBeat.o(232458);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(232452);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = (View)new aq(paramLayoutInflater, R.i.ecE);
      paramLayoutInflater = new a(this.XjQ);
      p.k(localView, "view");
      paramLayoutInflater.amk = localView.findViewById(R.h.dxf);
      paramView = localView.findViewById(R.h.dwZ);
      if (paramView == null)
      {
        paramLayoutInflater = new t("null cannot be cast to non-null type android.widget.CheckBox");
        AppMethodBeat.o(232452);
        throw paramLayoutInflater;
      }
      paramLayoutInflater.checkBox = ((CheckBox)paramView);
      paramLayoutInflater.maskView = localView.findViewById(R.h.dyD);
      paramView = localView.findViewById(R.h.dzs);
      if (paramView == null)
      {
        paramLayoutInflater = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(232452);
        throw paramLayoutInflater;
      }
      paramLayoutInflater.timeTV = ((TextView)paramView);
      paramView = paramLayoutInflater.XjR.entrySet();
      p.j(paramView, "holders.entries");
      paramView = ((Iterable)paramView).iterator();
      while (paramView.hasNext()) {
        ((b.a)((Map.Entry)paramView.next()).getValue()).ix(localView);
      }
      localView.setTag((c.a)paramLayoutInflater);
    }
    AppMethodBeat.o(232452);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(232457);
    p.k(parama1, "ui");
    this.WBq = parama1;
    if (paramca == null) {
      p.iCn();
    }
    paramString = XmlParser.parseXml(paramca.getContent(), "msg", null);
    Object localObject1 = (String)paramString.get(".msg.appmsg.extinfo.notifymsg.templateid");
    "tmplId = ".concat(String.valueOf(localObject1));
    h.ioq();
    Object localObject2 = Util.nullAsNil((String)paramString.get(".msg.fromusername"));
    localObject1 = (b)((Map)this.XjQ).get(localObject1);
    if (localObject1 != null)
    {
      Object localObject3 = ((b)localObject1).hTZ();
      Object localObject4 = c(parama1);
      p.j(localObject4, "getLongClickListener(ui)");
      localObject4 = (View.OnLongClickListener)localObject4;
      localObject2 = new by(paramca, (String)localObject2);
      ((by)localObject2).position = paramInt;
      ((b.a)localObject3).a((View.OnLongClickListener)localObject4, localObject2);
      localObject2 = ((b)localObject1).hTZ();
      localObject3 = parama1.bC(k.class);
      p.j(localObject3, "ui.component(IChattingLi…terComponent::class.java)");
      localObject3 = ((k)localObject3).hNO();
      p.j(localObject3, "ui.component(IChattingLi…class.java).touchListener");
      ((b.a)localObject2).setOnTouchListener((View.OnTouchListener)localObject3);
      if (parama == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ChattingItemFinderLiveNotifyTmpl.FinderLiveNotifyHolder");
        AppMethodBeat.o(232457);
        throw parama;
      }
      parama = (a)parama;
      p.j(paramString, "values");
      ((b)localObject1).a(parama, paramString, paramca, parama1);
      AppMethodBeat.o(232457);
      return;
    }
    AppMethodBeat.o(232457);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(232450);
    if (paramView == null) {
      p.iCn();
    }
    paramca = paramView.getTag();
    if (paramca == null)
    {
      paramo = new t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
      AppMethodBeat.o(232450);
      throw paramo;
    }
    paramca = (by)paramca;
    if (paramca == null)
    {
      AppMethodBeat.o(232450);
      return false;
    }
    int i = paramca.position;
    paramca = this.WBq;
    if ((paramca != null) && (!paramca.hRj()))
    {
      if (paramo == null) {
        p.iCn();
      }
      paramo.a(i, 100, (CharSequence)paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(232450);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return paramInt == 1075839025;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  protected final boolean hTF()
  {
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemFinderLiveNotifyTmpl$FinderLiveNotifyHolder;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "selectors", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "holders", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "getHolders", "()Ljava/util/HashMap;", "setHolders", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "createHolder", "view", "getHolder", "T", "tmplId", "(Ljava/lang/String;)Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "app_release"})
  public static final class a
    extends c.a
  {
    public HashMap<String, b.a> XjR;
    View amk;
    
    public a(HashMap<String, b> paramHashMap)
    {
      AppMethodBeat.i(271284);
      this.XjR = new HashMap();
      paramHashMap = paramHashMap.entrySet();
      p.j(paramHashMap, "selectors.entries");
      paramHashMap = ((Iterable)paramHashMap).iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        Map localMap = (Map)this.XjR;
        Object localObject = localEntry.getKey();
        p.j(localObject, "it.key");
        localMap.put(localObject, ((b)localEntry.getValue()).hTZ());
      }
      AppMethodBeat.o(271284);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.av
 * JD-Core Version:    0.7.0.1
 */