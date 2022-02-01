package com.tencent.mm.plugin.secdata;

import android.content.Intent;
import com.tencent.mm.bw.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/ISecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "check", "", "intent", "Landroid/content/Intent;", "getTransformData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getType", "", "reuse", "plugin-sec-data_release"})
public abstract interface h<T extends a>
{
  public abstract boolean aS(Intent paramIntent);
  
  public abstract T eSl();
  
  public abstract boolean eSm();
  
  public abstract int getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.h
 * JD-Core Version:    0.7.0.1
 */