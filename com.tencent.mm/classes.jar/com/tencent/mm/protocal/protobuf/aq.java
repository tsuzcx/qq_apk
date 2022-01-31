package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq
  extends com.tencent.mm.bv.a
{
  public String knk;
  public String knl;
  public String knm;
  public String knn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89002);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.knk != null) {
        paramVarArgs.e(1, this.knk);
      }
      if (this.knl != null) {
        paramVarArgs.e(2, this.knl);
      }
      if (this.knm != null) {
        paramVarArgs.e(3, this.knm);
      }
      if (this.knn != null) {
        paramVarArgs.e(4, this.knn);
      }
      AppMethodBeat.o(89002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.knk == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.knk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.knl != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.knl);
      }
      i = paramInt;
      if (this.knm != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.knm);
      }
      paramInt = i;
      if (this.knn != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.knn);
      }
      AppMethodBeat.o(89002);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89002);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aq localaq = (aq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89002);
          return -1;
        case 1: 
          localaq.knk = locala.CLY.readString();
          AppMethodBeat.o(89002);
          return 0;
        case 2: 
          localaq.knl = locala.CLY.readString();
          AppMethodBeat.o(89002);
          return 0;
        case 3: 
          localaq.knm = locala.CLY.readString();
          AppMethodBeat.o(89002);
          return 0;
        }
        localaq.knn = locala.CLY.readString();
        AppMethodBeat.o(89002);
        return 0;
      }
      AppMethodBeat.o(89002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aq
 * JD-Core Version:    0.7.0.1
 */