package com.tencent.mm.plugin.secdata;

import android.content.Intent;
import com.tencent.mm.cd.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/secdata/ISecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "check", "", "intent", "Landroid/content/Intent;", "getTransformData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getType", "", "reuse", "plugin-sec-data_release"})
public abstract interface h<T extends a>
{
  public abstract boolean aR(Intent paramIntent);
  
  public abstract T fFn();
  
  public abstract boolean fFo();
  
  public abstract int getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.h
 * JD-Core Version:    0.7.0.1
 */