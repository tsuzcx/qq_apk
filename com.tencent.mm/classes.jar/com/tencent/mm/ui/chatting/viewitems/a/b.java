package com.tencent.mm.ui.chatting.viewitems.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.av.a;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl;", "", "filling", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemFinderLiveNotifyTmpl$FinderLiveNotifyHolder;", "values", "", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "getHolder", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "ITmplHolder", "app_release"})
public abstract interface b
{
  public abstract void a(av.a parama, Map<String, String> paramMap, ca paramca, a parama1);
  
  public abstract a hTZ();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "", "hideOrShow", "", "isShow", "", "initView", "view", "Landroid/view/View;", "setOnLongClickListener", "listener", "Landroid/view/View$OnLongClickListener;", "tagObject", "setOnTouchListener", "ls", "Landroid/view/View$OnTouchListener;", "app_release"})
  public static abstract interface a
  {
    public abstract void GG(boolean paramBoolean);
    
    public abstract void a(View.OnLongClickListener paramOnLongClickListener, Object paramObject);
    
    public abstract void ix(View paramView);
    
    public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.b
 * JD-Core Version:    0.7.0.1
 */