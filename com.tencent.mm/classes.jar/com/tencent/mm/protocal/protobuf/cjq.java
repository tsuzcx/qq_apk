package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjq
  extends com.tencent.mm.cd.a
{
  public String businessId = "";
  public String dataPath;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122514);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.value != null) {
        paramVarArgs.f(1, this.value);
      }
      if (this.dataPath != null) {
        paramVarArgs.f(2, this.dataPath);
      }
      if (this.businessId != null) {
        paramVarArgs.f(3, this.businessId);
      }
      AppMethodBeat.o(122514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.value == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.value) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dataPath != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.dataPath);
      }
      i = paramInt;
      if (this.businessId != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.businessId);
      }
      AppMethodBeat.o(122514);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122514);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cjq localcjq = (cjq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122514);
          return -1;
        case 1: 
          localcjq.value = locala.abFh.readString();
          AppMethodBeat.o(122514);
          return 0;
        case 2: 
          localcjq.dataPath = locala.abFh.readString();
          AppMethodBeat.o(122514);
          return 0;
        }
        localcjq.businessId = locala.abFh.readString();
        AppMethodBeat.o(122514);
        return 0;
      }
      AppMethodBeat.o(122514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjq
 * JD-Core Version:    0.7.0.1
 */