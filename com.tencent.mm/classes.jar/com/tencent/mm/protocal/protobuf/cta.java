package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cta
  extends com.tencent.mm.bw.a
{
  public String dyI;
  public int number;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72576);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.type != null) {
        paramVarArgs.d(1, this.type);
      }
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      paramVarArgs.aS(3, this.number);
      AppMethodBeat.o(72576);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dyI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dyI);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.number);
      AppMethodBeat.o(72576);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72576);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cta localcta = (cta)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72576);
          return -1;
        case 1: 
          localcta.type = locala.OmT.readString();
          AppMethodBeat.o(72576);
          return 0;
        case 2: 
          localcta.dyI = locala.OmT.readString();
          AppMethodBeat.o(72576);
          return 0;
        }
        localcta.number = locala.OmT.zc();
        AppMethodBeat.o(72576);
        return 0;
      }
      AppMethodBeat.o(72576);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cta
 * JD-Core Version:    0.7.0.1
 */