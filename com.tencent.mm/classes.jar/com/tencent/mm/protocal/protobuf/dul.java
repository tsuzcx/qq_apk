package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dul
  extends com.tencent.mm.bw.a
{
  public int Height;
  public b Iaa;
  public int Iab;
  public long Iac;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117938);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Iaa != null) {
        paramVarArgs.c(1, this.Iaa);
      }
      paramVarArgs.aS(2, this.Iab);
      paramVarArgs.aZ(3, this.Iac);
      paramVarArgs.aS(4, this.Width);
      paramVarArgs.aS(5, this.Height);
      AppMethodBeat.o(117938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Iaa == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.b(1, this.Iaa) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Iab);
      int j = f.a.a.b.b.a.p(3, this.Iac);
      int k = f.a.a.b.b.a.bz(4, this.Width);
      int m = f.a.a.b.b.a.bz(5, this.Height);
      AppMethodBeat.o(117938);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117938);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dul localdul = (dul)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117938);
          return -1;
        case 1: 
          localdul.Iaa = locala.OmT.gCk();
          AppMethodBeat.o(117938);
          return 0;
        case 2: 
          localdul.Iab = locala.OmT.zc();
          AppMethodBeat.o(117938);
          return 0;
        case 3: 
          localdul.Iac = locala.OmT.zd();
          AppMethodBeat.o(117938);
          return 0;
        case 4: 
          localdul.Width = locala.OmT.zc();
          AppMethodBeat.o(117938);
          return 0;
        }
        localdul.Height = locala.OmT.zc();
        AppMethodBeat.o(117938);
        return 0;
      }
      AppMethodBeat.o(117938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dul
 * JD-Core Version:    0.7.0.1
 */