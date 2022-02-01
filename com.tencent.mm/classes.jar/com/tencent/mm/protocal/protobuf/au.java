package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class au
  extends com.tencent.mm.bw.a
{
  public String oFv;
  public String oFw;
  public String oFx;
  public String oFy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113931);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oFv != null) {
        paramVarArgs.d(1, this.oFv);
      }
      if (this.oFw != null) {
        paramVarArgs.d(2, this.oFw);
      }
      if (this.oFx != null) {
        paramVarArgs.d(3, this.oFx);
      }
      if (this.oFy != null) {
        paramVarArgs.d(4, this.oFy);
      }
      AppMethodBeat.o(113931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oFv == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.oFv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oFw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oFw);
      }
      i = paramInt;
      if (this.oFx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oFx);
      }
      paramInt = i;
      if (this.oFy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oFy);
      }
      AppMethodBeat.o(113931);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113931);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        au localau = (au)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113931);
          return -1;
        case 1: 
          localau.oFv = locala.OmT.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 2: 
          localau.oFw = locala.OmT.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 3: 
          localau.oFx = locala.OmT.readString();
          AppMethodBeat.o(113931);
          return 0;
        }
        localau.oFy = locala.OmT.readString();
        AppMethodBeat.o(113931);
        return 0;
      }
      AppMethodBeat.o(113931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.au
 * JD-Core Version:    0.7.0.1
 */