package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amp
  extends com.tencent.mm.bx.a
{
  public String DnJ;
  public long DnK;
  public int dhR;
  public String id;
  public int rik;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32213);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      paramVarArgs.aR(2, this.rik);
      if (this.DnJ != null) {
        paramVarArgs.d(3, this.DnJ);
      }
      paramVarArgs.aG(4, this.DnK);
      paramVarArgs.aR(5, this.dhR);
      AppMethodBeat.o(32213);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label421;
      }
    }
    label421:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.rik);
      paramInt = i;
      if (this.DnJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DnJ);
      }
      i = f.a.a.b.b.a.q(4, this.DnK);
      int j = f.a.a.b.b.a.bA(5, this.dhR);
      AppMethodBeat.o(32213);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32213);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        amp localamp = (amp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32213);
          return -1;
        case 1: 
          localamp.id = locala.KhF.readString();
          AppMethodBeat.o(32213);
          return 0;
        case 2: 
          localamp.rik = locala.KhF.xS();
          AppMethodBeat.o(32213);
          return 0;
        case 3: 
          localamp.DnJ = locala.KhF.readString();
          AppMethodBeat.o(32213);
          return 0;
        case 4: 
          localamp.DnK = locala.KhF.xT();
          AppMethodBeat.o(32213);
          return 0;
        }
        localamp.dhR = locala.KhF.xS();
        AppMethodBeat.o(32213);
        return 0;
      }
      AppMethodBeat.o(32213);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amp
 * JD-Core Version:    0.7.0.1
 */