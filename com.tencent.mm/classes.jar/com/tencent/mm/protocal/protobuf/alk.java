package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alk
  extends com.tencent.mm.bx.a
{
  public String DmF;
  public long DmG;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169059);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DmF != null) {
        paramVarArgs.d(1, this.DmF);
      }
      paramVarArgs.aR(2, this.type);
      paramVarArgs.aG(3, this.DmG);
      AppMethodBeat.o(169059);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DmF == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.DmF) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.type);
      int j = f.a.a.b.b.a.q(3, this.DmG);
      AppMethodBeat.o(169059);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169059);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        alk localalk = (alk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169059);
          return -1;
        case 1: 
          localalk.DmF = locala.KhF.readString();
          AppMethodBeat.o(169059);
          return 0;
        case 2: 
          localalk.type = locala.KhF.xS();
          AppMethodBeat.o(169059);
          return 0;
        }
        localalk.DmG = locala.KhF.xT();
        AppMethodBeat.o(169059);
        return 0;
      }
      AppMethodBeat.o(169059);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alk
 * JD-Core Version:    0.7.0.1
 */