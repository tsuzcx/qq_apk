package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ecw
  extends com.tencent.mm.bw.a
{
  public b IhX;
  public b IhY;
  public b IhZ;
  public b Iia;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91729);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IhX != null) {
        paramVarArgs.c(1, this.IhX);
      }
      if (this.IhY != null) {
        paramVarArgs.c(2, this.IhY);
      }
      if (this.IhZ != null) {
        paramVarArgs.c(3, this.IhZ);
      }
      if (this.Iia != null) {
        paramVarArgs.c(4, this.Iia);
      }
      AppMethodBeat.o(91729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IhX == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.b(1, this.IhX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IhY != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.IhY);
      }
      i = paramInt;
      if (this.IhZ != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.IhZ);
      }
      paramInt = i;
      if (this.Iia != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Iia);
      }
      AppMethodBeat.o(91729);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91729);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecw localecw = (ecw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91729);
          return -1;
        case 1: 
          localecw.IhX = locala.OmT.gCk();
          AppMethodBeat.o(91729);
          return 0;
        case 2: 
          localecw.IhY = locala.OmT.gCk();
          AppMethodBeat.o(91729);
          return 0;
        case 3: 
          localecw.IhZ = locala.OmT.gCk();
          AppMethodBeat.o(91729);
          return 0;
        }
        localecw.Iia = locala.OmT.gCk();
        AppMethodBeat.o(91729);
        return 0;
      }
      AppMethodBeat.o(91729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecw
 * JD-Core Version:    0.7.0.1
 */