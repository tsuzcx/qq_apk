package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/ISqlObj;", "", "params", "", "", "()[Ljava/lang/String;", "toSql", "ConditionBitOperation", "ConditionConnectOperation", "ConditionOperation", "TableJoinOperation", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ISqlObj
{
  public abstract String[] params();
  
  public abstract String toSql();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionOperation;", "", "opName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getOpName", "()Ljava/lang/String;", "toString", "Equal", "NotEqual", "LargerThan", "SmallerThan", "LargerEqual", "SmallerEqual", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum ConditionOperation
  {
    private final String opName;
    
    static
    {
      AppMethodBeat.i(244409);
      Equal = new ConditionOperation("Equal", 0, "=");
      NotEqual = new ConditionOperation("NotEqual", 1, "<>");
      LargerThan = new ConditionOperation("LargerThan", 2, ">");
      SmallerThan = new ConditionOperation("SmallerThan", 3, "<");
      LargerEqual = new ConditionOperation("LargerEqual", 4, ">=");
      SmallerEqual = new ConditionOperation("SmallerEqual", 5, "<=");
      $VALUES = $values();
      AppMethodBeat.o(244409);
    }
    
    private ConditionOperation(String paramString)
    {
      this.opName = paramString;
    }
    
    public final String getOpName()
    {
      return this.opName;
    }
    
    public final String toString()
    {
      return this.opName;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class DefaultImpls
  {
    public static String[] params(ISqlObj paramISqlObj)
    {
      AppMethodBeat.i(244359);
      s.u(paramISqlObj, "this");
      AppMethodBeat.o(244359);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/ISqlObj$TableJoinOperation;", "", "(Ljava/lang/String;I)V", "InnerJoin", "LeftJoin", "RightJoin", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum TableJoinOperation
  {
    static
    {
      AppMethodBeat.i(244403);
      InnerJoin = new TableJoinOperation("InnerJoin", 0);
      LeftJoin = new TableJoinOperation("LeftJoin", 1);
      RightJoin = new TableJoinOperation("RightJoin", 2);
      $VALUES = $values();
      AppMethodBeat.o(244403);
    }
    
    private TableJoinOperation() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.ISqlObj
 * JD-Core Version:    0.7.0.1
 */