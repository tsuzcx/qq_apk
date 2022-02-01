package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class TableInfo
  extends com.tencent.mm.bw.a
{
  public long count_;
  public String name_;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151540);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name_ == null)
      {
        paramVarArgs = new b("Not all required fields were included: name_");
        AppMethodBeat.o(151540);
        throw paramVarArgs;
      }
      if (this.name_ != null) {
        paramVarArgs.e(1, this.name_);
      }
      paramVarArgs.bb(2, this.count_);
      AppMethodBeat.o(151540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name_ == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.name_) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.count_);
      AppMethodBeat.o(151540);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.name_ == null)
        {
          paramVarArgs = new b("Not all required fields were included: name_");
          AppMethodBeat.o(151540);
          throw paramVarArgs;
        }
        AppMethodBeat.o(151540);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        TableInfo localTableInfo = (TableInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(151540);
          return -1;
        case 1: 
          localTableInfo.name_ = locala.UbS.readString();
          AppMethodBeat.o(151540);
          return 0;
        }
        localTableInfo.count_ = locala.UbS.zl();
        AppMethodBeat.o(151540);
        return 0;
      }
      AppMethodBeat.o(151540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.TableInfo
 * JD-Core Version:    0.7.0.1
 */