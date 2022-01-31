package com.tencent.mm.plugin.report.kvdata;

import d.a.a.b;

public class TableInfo
  extends com.tencent.mm.bv.a
{
  public long count_;
  public String name_;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.name_ == null) {
        throw new b("Not all required fields were included: name_");
      }
      if (this.name_ != null) {
        paramVarArgs.d(1, this.name_);
      }
      paramVarArgs.Y(2, this.count_);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name_ == null) {
        break label244;
      }
    }
    label244:
    for (paramInt = d.a.a.b.b.a.e(1, this.name_) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.X(2, this.count_);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.name_ != null) {
          break;
        }
        throw new b("Not all required fields were included: name_");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        TableInfo localTableInfo = (TableInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localTableInfo.name_ = locala.xpH.readString();
          return 0;
        }
        localTableInfo.count_ = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.TableInfo
 * JD-Core Version:    0.7.0.1
 */