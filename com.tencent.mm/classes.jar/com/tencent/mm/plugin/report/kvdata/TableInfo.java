package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class TableInfo
  extends com.tencent.mm.cd.a
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
        paramVarArgs.f(1, this.name_);
      }
      paramVarArgs.bm(2, this.count_);
      AppMethodBeat.o(151540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name_ == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.name_) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.count_);
      AppMethodBeat.o(151540);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
          localTableInfo.name_ = locala.abFh.readString();
          AppMethodBeat.o(151540);
          return 0;
        }
        localTableInfo.count_ = locala.abFh.AN();
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