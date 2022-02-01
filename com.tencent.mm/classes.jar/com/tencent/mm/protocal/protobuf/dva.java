package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dva
  extends com.tencent.mm.bw.a
{
  public long GrE;
  public String GrF;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121106);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(121106);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      paramVarArgs.aZ(2, this.GrE);
      if (this.GrF != null) {
        paramVarArgs.d(3, this.GrF);
      }
      AppMethodBeat.o(121106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GrE);
      paramInt = i;
      if (this.GrF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GrF);
      }
      AppMethodBeat.o(121106);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(121106);
          throw paramVarArgs;
        }
        AppMethodBeat.o(121106);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dva localdva = (dva)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(121106);
          return -1;
        case 1: 
          localdva.key = locala.OmT.readString();
          AppMethodBeat.o(121106);
          return 0;
        case 2: 
          localdva.GrE = locala.OmT.zd();
          AppMethodBeat.o(121106);
          return 0;
        }
        localdva.GrF = locala.OmT.readString();
        AppMethodBeat.o(121106);
        return 0;
      }
      AppMethodBeat.o(121106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dva
 * JD-Core Version:    0.7.0.1
 */