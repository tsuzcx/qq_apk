package com.tencent.mm.v;

import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.storage.bs;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/executor/IOpExecutor;", "", "execute", "", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsg", "newXmlCreateTime", "", "onTaskExpired", "timer", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "plugin-functionmsg_release"})
public abstract interface b
{
  public abstract void a(e parame, s params, bs parambs, i parami1, i parami2, long paramLong);
  
  public abstract void a(e parame, s params, d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.v.b
 * JD-Core Version:    0.7.0.1
 */