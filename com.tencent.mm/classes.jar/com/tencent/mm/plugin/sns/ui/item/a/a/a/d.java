package com.tencent.mm.plugin.sns.ui.item.a.a.a;

import android.widget.FrameLayout.LayoutParams;
import kotlin.Metadata;
import kotlin.ah;
import kotlinx.coroutines.b.ab;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/IVideoControllerForBreakFrame;", "", "completionFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "", "getCompletionFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "getCurrentPosInMills", "", "pause", "", "prepare", "videoPath", "", "layoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "(Ljava/lang/String;Landroid/widget/FrameLayout$LayoutParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resume", "seek", "to", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekToAsync", "start", "stop", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public abstract Object a(String paramString, FrameLayout.LayoutParams paramLayoutParams, kotlin.d.d<? super ah> paramd);
  
  public abstract Object d(long paramLong, kotlin.d.d<? super ah> paramd);
  
  public abstract ab<Boolean> getCompletionFlow();
  
  public abstract long getCurrentPosInMills();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */