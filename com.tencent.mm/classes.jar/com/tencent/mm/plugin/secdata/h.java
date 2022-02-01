package com.tencent.mm.plugin.secdata;

import android.content.Intent;
import com.tencent.mm.bx.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/secdata/ISecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "check", "", "intent", "Landroid/content/Intent;", "getTransformData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getType", "", "reuse", "plugin-sec-data_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h<T extends a>
{
  public abstract boolean bp(Intent paramIntent);
  
  public abstract T gUv();
  
  public abstract boolean gUw();
  
  public abstract int getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.h
 * JD-Core Version:    0.7.0.1
 */