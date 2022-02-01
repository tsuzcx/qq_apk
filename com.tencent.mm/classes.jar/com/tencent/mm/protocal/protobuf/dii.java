package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dii
  extends com.tencent.mm.bx.a
{
  public b Eyx;
  public int Eyy;
  public long Eyz;
  public int Height;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117938);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eyx != null) {
        paramVarArgs.c(1, this.Eyx);
      }
      paramVarArgs.aR(2, this.Eyy);
      paramVarArgs.aG(3, this.Eyz);
      paramVarArgs.aR(4, this.Width);
      paramVarArgs.aR(5, this.Height);
      AppMethodBeat.o(117938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eyx == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.b(1, this.Eyx) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.Eyy);
      int j = f.a.a.b.b.a.q(3, this.Eyz);
      int k = f.a.a.b.b.a.bA(4, this.Width);
      int m = f.a.a.b.b.a.bA(5, this.Height);
      AppMethodBeat.o(117938);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117938);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dii localdii = (dii)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117938);
          return -1;
        case 1: 
          localdii.Eyx = locala.KhF.fMu();
          AppMethodBeat.o(117938);
          return 0;
        case 2: 
          localdii.Eyy = locala.KhF.xS();
          AppMethodBeat.o(117938);
          return 0;
        case 3: 
          localdii.Eyz = locala.KhF.xT();
          AppMethodBeat.o(117938);
          return 0;
        case 4: 
          localdii.Width = locala.KhF.xS();
          AppMethodBeat.o(117938);
          return 0;
        }
        localdii.Height = locala.KhF.xS();
        AppMethodBeat.o(117938);
        return 0;
      }
      AppMethodBeat.o(117938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dii
 * JD-Core Version:    0.7.0.1
 */