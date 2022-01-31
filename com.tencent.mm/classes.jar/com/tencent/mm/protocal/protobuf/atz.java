package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atz
  extends com.tencent.mm.bv.a
{
  public String cDz;
  public String url;
  public String xiQ;
  public String xiR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48863);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xiQ != null) {
        paramVarArgs.e(1, this.xiQ);
      }
      if (this.xiR != null) {
        paramVarArgs.e(2, this.xiR);
      }
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      if (this.cDz != null) {
        paramVarArgs.e(4, this.cDz);
      }
      AppMethodBeat.o(48863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xiQ == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.xiQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xiR != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xiR);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.url);
      }
      paramInt = i;
      if (this.cDz != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.cDz);
      }
      AppMethodBeat.o(48863);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48863);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        atz localatz = (atz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48863);
          return -1;
        case 1: 
          localatz.xiQ = locala.CLY.readString();
          AppMethodBeat.o(48863);
          return 0;
        case 2: 
          localatz.xiR = locala.CLY.readString();
          AppMethodBeat.o(48863);
          return 0;
        case 3: 
          localatz.url = locala.CLY.readString();
          AppMethodBeat.o(48863);
          return 0;
        }
        localatz.cDz = locala.CLY.readString();
        AppMethodBeat.o(48863);
        return 0;
      }
      AppMethodBeat.o(48863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atz
 * JD-Core Version:    0.7.0.1
 */