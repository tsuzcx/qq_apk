package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ISqlObj;", "", "params", "", "", "()[Ljava/lang/String;", "toSql", "ConditionBitOperation", "ConditionConnectOperation", "ConditionOperation", "TableJoinOperation", "wechat-sdk_release"})
public abstract interface ISqlObj
{
  public abstract String[] params();
  
  public abstract String toSql();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionConnectOperation;", "", "(Ljava/lang/String;I)V", "AND", "OR", "wechat-sdk_release"})
  public static enum ConditionConnectOperation
  {
    static
    {
      AppMethodBeat.i(189226);
      ConditionConnectOperation localConditionConnectOperation1 = new ConditionConnectOperation("AND", 0);
      AND = localConditionConnectOperation1;
      ConditionConnectOperation localConditionConnectOperation2 = new ConditionConnectOperation("OR", 1);
      OR = localConditionConnectOperation2;
      $VALUES = new ConditionConnectOperation[] { localConditionConnectOperation1, localConditionConnectOperation2 };
      AppMethodBeat.o(189226);
    }
    
    private ConditionConnectOperation() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionOperation;", "", "opName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getOpName", "()Ljava/lang/String;", "toString", "Equal", "NotEqual", "LargerThan", "SmallerThan", "LargerEqual", "SmallerEqual", "wechat-sdk_release"})
  public static enum ConditionOperation
  {
    private final String opName;
    
    static
    {
      AppMethodBeat.i(194575);
      ConditionOperation localConditionOperation1 = new ConditionOperation("Equal", 0, "=");
      Equal = localConditionOperation1;
      ConditionOperation localConditionOperation2 = new ConditionOperation("NotEqual", 1, "<>");
      NotEqual = localConditionOperation2;
      ConditionOperation localConditionOperation3 = new ConditionOperation("LargerThan", 2, ">");
      LargerThan = localConditionOperation3;
      ConditionOperation localConditionOperation4 = new ConditionOperation("SmallerThan", 3, "<");
      SmallerThan = localConditionOperation4;
      ConditionOperation localConditionOperation5 = new ConditionOperation("LargerEqual", 4, ">=");
      LargerEqual = localConditionOperation5;
      ConditionOperation localConditionOperation6 = new ConditionOperation("SmallerEqual", 5, "<=");
      SmallerEqual = localConditionOperation6;
      $VALUES = new ConditionOperation[] { localConditionOperation1, localConditionOperation2, localConditionOperation3, localConditionOperation4, localConditionOperation5, localConditionOperation6 };
      AppMethodBeat.o(194575);
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
  
  @l(iBK={1, 1, 16})
  public static final class DefaultImpls
  {
    public static String[] params(ISqlObj paramISqlObj)
    {
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ISqlObj$TableJoinOperation;", "", "(Ljava/lang/String;I)V", "InnerJoin", "LeftJoin", "RightJoin", "wechat-sdk_release"})
  public static enum TableJoinOperation
  {
    static
    {
      AppMethodBeat.i(190786);
      TableJoinOperation localTableJoinOperation1 = new TableJoinOperation("InnerJoin", 0);
      InnerJoin = localTableJoinOperation1;
      TableJoinOperation localTableJoinOperation2 = new TableJoinOperation("LeftJoin", 1);
      LeftJoin = localTableJoinOperation2;
      TableJoinOperation localTableJoinOperation3 = new TableJoinOperation("RightJoin", 2);
      RightJoin = localTableJoinOperation3;
      $VALUES = new TableJoinOperation[] { localTableJoinOperation1, localTableJoinOperation2, localTableJoinOperation3 };
      AppMethodBeat.o(190786);
    }
    
    private TableJoinOperation() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.ISqlObj
 * JD-Core Version:    0.7.0.1
 */