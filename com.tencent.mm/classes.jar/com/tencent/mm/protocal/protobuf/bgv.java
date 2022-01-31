package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgv
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String iEA;
  public String scope;
  public int xwa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10227);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.e(1, this.scope);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      paramVarArgs.aO(3, this.xwa);
      if (this.iEA != null) {
        paramVarArgs.e(4, this.iEA);
      }
      AppMethodBeat.o(10227);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = e.a.a.b.b.a.f(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.desc);
      }
      i += e.a.a.b.b.a.bl(3, this.xwa);
      paramInt = i;
      if (this.iEA != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.iEA);
      }
      AppMethodBeat.o(10227);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10227);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bgv localbgv = (bgv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(10227);
          return -1;
        case 1: 
          localbgv.scope = locala.CLY.readString();
          AppMethodBeat.o(10227);
          return 0;
        case 2: 
          localbgv.desc = locala.CLY.readString();
          AppMethodBeat.o(10227);
          return 0;
        case 3: 
          localbgv.xwa = locala.CLY.sl();
          AppMethodBeat.o(10227);
          return 0;
        }
        localbgv.iEA = locala.CLY.readString();
        AppMethodBeat.o(10227);
        return 0;
      }
      AppMethodBeat.o(10227);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgv
 * JD-Core Version:    0.7.0.1
 */