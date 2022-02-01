package com.tencent.mm.v;

import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.s.d;
import com.tencent.mm.s.e;
import com.tencent.mm.storage.bu;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/executor/IOpExecutor;", "", "execute", "", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsg", "newXmlCreateTime", "", "onTaskExpired", "timer", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract void a(e parame, u paramu, d paramd);
  
  public abstract void a(e parame, u paramu, bu parambu, j paramj1, j paramj2, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.b
 * JD-Core Version:    0.7.0.1
 */