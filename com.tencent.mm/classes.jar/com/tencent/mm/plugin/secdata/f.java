package com.tencent.mm.plugin.secdata;

import com.tencent.mm.bw.a;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/IListSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "copyItemObj", "", "fromKey", "", "toKey", "getItemObj", "key", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getListItemObjMap", "", "getType", "", "moveItemObj", "putItemObj", "value", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "plugin-sec-data_release"})
public abstract interface f<T extends a>
{
  public abstract void c(String paramString, T paramT);
  
  public abstract Map<String, T> eSo();
  
  public abstract int getType();
  
  public abstract void jS(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.f
 * JD-Core Version:    0.7.0.1
 */