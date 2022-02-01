package com.tencent.mm.ui.component.support;

import kotlin.Metadata;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.b.x;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/support/IStateTransform;", "T", "", "asSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "replay", "", "asStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "defaultValue", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b<T>
{
  public abstract w<T> a(aq paramaq, int paramInt);
  
  public abstract x<T> a(aq paramaq, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.support.b
 * JD-Core Version:    0.7.0.1
 */