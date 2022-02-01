package com.tencent.mm.ui.chatting.component.api;

import android.os.Bundle;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.aj;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/api/IOpenIMKefuComponent;", "Lcom/tencent/mm/ui/chatting/component/IChattingComponent;", "dealWithResendMsg", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "handleNameCardClick", "", "username", "", "extraData", "Landroid/os/Bundle;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface am
  extends aj
{
  public abstract boolean cU(cc paramcc);
  
  public abstract void x(String paramString, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.api.am
 * JD-Core Version:    0.7.0.1
 */