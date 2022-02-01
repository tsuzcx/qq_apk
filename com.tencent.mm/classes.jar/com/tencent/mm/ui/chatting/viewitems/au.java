package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.viewitems.a.b;
import com.tencent.mm.ui.chatting.viewitems.a.d;
import com.tencent.mm.ui.chatting.viewitems.a.d.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemFinderLiveNotifyTmpl;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "selectors", "Ljava/util/HashMap;", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl;", "Lkotlin/collections/HashMap;", "getSelectors", "()Ljava/util/HashMap;", "setSelectors", "(Ljava/util/HashMap;)V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "filling", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "isShowRemindMenu", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "support", "msgType", "FinderLiveNotifyHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  extends c
{
  private final String TAG;
  private HashMap<String, d> aeUi;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public au()
  {
    AppMethodBeat.i(255113);
    this.TAG = "ChattingItemFinderLiveNotifyTmpl";
    this.aeUi = new HashMap();
    HashMap localHashMap = this.aeUi;
    Object localObject = com.tencent.mm.ui.chatting.viewitems.a.c.aeZm;
    localHashMap.put(com.tencent.mm.ui.chatting.viewitems.a.c.jxE(), new com.tencent.mm.ui.chatting.viewitems.a.c());
    localHashMap = this.aeUi;
    localObject = com.tencent.mm.ui.chatting.viewitems.a.a.aeZh;
    localHashMap.put(com.tencent.mm.ui.chatting.viewitems.a.a.jxE(), new com.tencent.mm.ui.chatting.viewitems.a.a());
    localHashMap = this.aeUi;
    localObject = b.aeZl;
    localHashMap.put(b.jxE(), new b());
    AppMethodBeat.o(255113);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(255121);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = (View)new ap(paramLayoutInflater, R.i.gfu);
      paramLayoutInflater = (ap)localView;
      paramView = new a(this.aeUi);
      kotlin.g.b.s.u(localView, "view");
      paramView.caK = localView.findViewById(R.h.fxA);
      Object localObject = localView.findViewById(R.h.fxt);
      if (localObject == null)
      {
        paramLayoutInflater = new NullPointerException("null cannot be cast to non-null type android.widget.CheckBox");
        AppMethodBeat.o(255121);
        throw paramLayoutInflater;
      }
      paramView.checkBox = ((CheckBox)localObject);
      paramView.maskView = localView.findViewById(R.h.fzn);
      localObject = localView.findViewById(R.h.fAm);
      if (localObject == null)
      {
        paramLayoutInflater = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(255121);
        throw paramLayoutInflater;
      }
      paramView.timeTV = ((TextView)localObject);
      localObject = paramView.aeUj.entrySet();
      kotlin.g.b.s.s(localObject, "holders.entries");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((d.a)((Map.Entry)((Iterator)localObject).next()).getValue()).iS(localView);
      }
      paramLayoutInflater.setTag((c.a)paramView);
    }
    AppMethodBeat.o(255121);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(255138);
    kotlin.g.b.s.u(parama1, "ui");
    this.aeiK = parama1;
    kotlin.g.b.s.checkNotNull(paramcc);
    paramString = XmlParser.parseXml(paramcc.field_content, "msg", null);
    Object localObject1 = (String)paramString.get(".msg.appmsg.extinfo.notifymsg.templateid");
    kotlin.g.b.s.X("tmplId = ", localObject1);
    h.jXD();
    Object localObject3 = Util.nullAsNil((String)paramString.get(".msg.fromusername"));
    localObject1 = (d)((Map)this.aeUi).get(localObject1);
    if (localObject1 != null)
    {
      Object localObject2 = ((d)localObject1).jxK();
      Object localObject4 = c(parama1);
      kotlin.g.b.s.s(localObject4, "getLongClickListener(ui)");
      localObject4 = (View.OnLongClickListener)localObject4;
      localObject3 = new bz(paramcc, (String)localObject3);
      ((bz)localObject3).position = paramInt;
      ah localah = ah.aiuX;
      ((d.a)localObject2).a((View.OnLongClickListener)localObject4, localObject3);
      localObject2 = (m)parama1.cm(m.class);
      if (localObject2 != null)
      {
        localObject2 = ((m)localObject2).jqv();
        if (localObject2 != null) {
          ((d)localObject1).jxK().setOnTouchListener((View.OnTouchListener)localObject2);
        }
      }
      if (parama == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ChattingItemFinderLiveNotifyTmpl.FinderLiveNotifyHolder");
        AppMethodBeat.o(255138);
        throw parama;
      }
      parama = (a)parama;
      kotlin.g.b.s.s(paramString, "values");
      ((d)localObject1).a(parama, paramString, paramcc, parama1);
    }
    AppMethodBeat.o(255138);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255118);
    kotlin.g.b.s.checkNotNull(paramView);
    paramContextMenuInfo = paramView.getTag();
    if (paramContextMenuInfo == null)
    {
      params = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
      AppMethodBeat.o(255118);
      throw params;
    }
    int j = ((bz)paramContextMenuInfo).position;
    paramContextMenuInfo = this.aeiK;
    if ((paramContextMenuInfo != null) && (!paramContextMenuInfo.juH())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        kotlin.g.b.s.checkNotNull(params);
        params.a(j, 100, (CharSequence)paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
      }
      AppMethodBeat.o(255118);
      return true;
    }
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return paramInt == 1075839025;
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  protected final boolean jxi()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemFinderLiveNotifyTmpl$FinderLiveNotifyHolder;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "selectors", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "holders", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "getHolders", "()Ljava/util/HashMap;", "setHolders", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "createHolder", "view", "getHolder", "T", "tmplId", "(Ljava/lang/String;)Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends c.a
  {
    HashMap<String, d.a> aeUj;
    View caK;
    
    public a(HashMap<String, d> paramHashMap)
    {
      AppMethodBeat.i(255324);
      this.aeUj = new HashMap();
      paramHashMap = paramHashMap.entrySet();
      kotlin.g.b.s.s(paramHashMap, "selectors.entries");
      paramHashMap = ((Iterable)paramHashMap).iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        Map localMap = (Map)this.aeUj;
        Object localObject = localEntry.getKey();
        kotlin.g.b.s.s(localObject, "it.key");
        localMap.put(localObject, ((d)localEntry.getValue()).jxK());
      }
      AppMethodBeat.o(255324);
    }
    
    public final <T extends d.a> T bBB(String paramString)
    {
      AppMethodBeat.i(255328);
      kotlin.g.b.s.u(paramString, "tmplId");
      d.a locala = (d.a)this.aeUj.get(paramString);
      Object localObject1 = this.aeUj.entrySet();
      kotlin.g.b.s.s(localObject1, "holders.entries");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label125:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (!kotlin.g.b.s.p(((Map.Entry)localObject3).getKey(), paramString)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label125;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      paramString = ((Iterable)localObject1).iterator();
      while (paramString.hasNext()) {
        ((d.a)((Map.Entry)paramString.next()).getValue()).Mv(false);
      }
      if (locala != null) {
        locala.Mv(true);
      }
      AppMethodBeat.o(255328);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.au
 * JD-Core Version:    0.7.0.1
 */