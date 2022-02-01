package com.tencent.mm.w;

import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.storage.bm;
import com.tencent.mm.v.d;
import com.tencent.mm.v.e;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/executor/IOpExecutor;", "", "execute", "", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsg", "newXmlCreateTime", "", "onTaskExpired", "timer", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "plugin-functionmsg_release"})
public abstract interface b
{
  public abstract void a(e parame, q paramq, bm parambm, h paramh1, h paramh2, long paramLong);
  
  public abstract void a(e parame, q paramq, d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.w.b
 * JD-Core Version:    0.7.0.1
 */