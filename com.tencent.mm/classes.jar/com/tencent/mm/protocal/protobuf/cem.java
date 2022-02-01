package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cem
  extends com.tencent.mm.bw.a
{
  public int Gdy;
  public String dzr;
  public String nIJ;
  public String nJO;
  public String xrf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184131);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.xrf != null) {
        paramVarArgs.d(2, this.xrf);
      }
      paramVarArgs.aS(3, this.Gdy);
      if (this.nJO != null) {
        paramVarArgs.d(4, this.nJO);
      }
      if (this.dzr != null) {
        paramVarArgs.d(5, this.dzr);
      }
      AppMethodBeat.o(184131);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xrf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xrf);
      }
      i += f.a.a.b.b.a.bz(3, this.Gdy);
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nJO);
      }
      i = paramInt;
      if (this.dzr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dzr);
      }
      AppMethodBeat.o(184131);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(184131);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cem localcem = (cem)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184131);
          return -1;
        case 1: 
          localcem.nIJ = locala.OmT.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 2: 
          localcem.xrf = locala.OmT.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 3: 
          localcem.Gdy = locala.OmT.zc();
          AppMethodBeat.o(184131);
          return 0;
        case 4: 
          localcem.nJO = locala.OmT.readString();
          AppMethodBeat.o(184131);
          return 0;
        }
        localcem.dzr = locala.OmT.readString();
        AppMethodBeat.o(184131);
        return 0;
      }
      AppMethodBeat.o(184131);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cem
 * JD-Core Version:    0.7.0.1
 */