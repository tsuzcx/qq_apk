package com.tencent.mm.v;

import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.storage.bd;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/executor/IOpExecutor;", "", "execute", "", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsg", "newXmlCreateTime", "", "onTaskExpired", "timer", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "plugin-functionmsg_release"})
public abstract interface b
{
  public abstract void a(e parame, q paramq, bd parambd, h paramh1, h paramh2, long paramLong);
  
  public abstract void a(e parame, q paramq, d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.b
 * JD-Core Version:    0.7.0.1
 */