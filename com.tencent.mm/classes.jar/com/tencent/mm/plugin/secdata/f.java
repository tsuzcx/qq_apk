package com.tencent.mm.plugin.secdata;

import com.tencent.mm.bx.a;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/secdata/IListSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "copyItemObj", "", "fromKey", "", "toKey", "getItemObj", "key", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getListItemObjMap", "", "getType", "", "moveItemObj", "putItemObj", "value", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "plugin-sec-data_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f<T extends a>
{
  public abstract void c(String paramString, T paramT);
  
  public abstract Map<String, T> gUy();
  
  public abstract int getType();
  
  public abstract void lJ(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.f
 * JD-Core Version:    0.7.0.1
 */