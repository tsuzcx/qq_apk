package com.tencent.mm.ui.chatting.viewitems.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.au.a;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl;", "", "filling", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemFinderLiveNotifyTmpl$FinderLiveNotifyHolder;", "values", "", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "getHolder", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "ITmplHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public abstract void a(au.a parama, Map<String, String> paramMap, cc paramcc, a parama1);
  
  public abstract a jxK();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "", "hideOrShow", "", "isShow", "", "initView", "view", "Landroid/view/View;", "setOnLongClickListener", "listener", "Landroid/view/View$OnLongClickListener;", "tagObject", "setOnTouchListener", "ls", "Landroid/view/View$OnTouchListener;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void Mv(boolean paramBoolean);
    
    public abstract void a(View.OnLongClickListener paramOnLongClickListener, Object paramObject);
    
    public abstract void iS(View paramView);
    
    public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.d
 * JD-Core Version:    0.7.0.1
 */