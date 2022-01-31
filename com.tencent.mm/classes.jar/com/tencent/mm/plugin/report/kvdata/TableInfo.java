package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public class TableInfo
  extends com.tencent.mm.bv.a
{
  public long count_;
  public String name_;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(79154);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.name_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: name_");
        AppMethodBeat.o(79154);
        throw paramVarArgs;
      }
      if (this.name_ != null) {
        paramVarArgs.e(1, this.name_);
      }
      paramVarArgs.am(2, this.count_);
      AppMethodBeat.o(79154);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name_ == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.name_) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.p(2, this.count_);
      AppMethodBeat.o(79154);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.name_ == null)
        {
          paramVarArgs = new b("Not all required fields were included: name_");
          AppMethodBeat.o(79154);
          throw paramVarArgs;
        }
        AppMethodBeat.o(79154);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        TableInfo localTableInfo = (TableInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(79154);
          return -1;
        case 1: 
          localTableInfo.name_ = locala.CLY.readString();
          AppMethodBeat.o(79154);
          return 0;
        }
        localTableInfo.count_ = locala.CLY.sm();
        AppMethodBeat.o(79154);
        return 0;
      }
      AppMethodBeat.o(79154);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.TableInfo
 * JD-Core Version:    0.7.0.1
 */