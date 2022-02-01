package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahd
  extends com.tencent.mm.bw.a
{
  public String LqN;
  public String LqO;
  public String ljQ;
  public String model;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220686);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ljQ != null) {
        paramVarArgs.e(1, this.ljQ);
      }
      if (this.model != null) {
        paramVarArgs.e(2, this.model);
      }
      if (this.LqN != null) {
        paramVarArgs.e(3, this.LqN);
      }
      if (this.LqO != null) {
        paramVarArgs.e(4, this.LqO);
      }
      AppMethodBeat.o(220686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ljQ == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.ljQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.model != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.model);
      }
      i = paramInt;
      if (this.LqN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LqN);
      }
      paramInt = i;
      if (this.LqO != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LqO);
      }
      AppMethodBeat.o(220686);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(220686);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ahd localahd = (ahd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(220686);
          return -1;
        case 1: 
          localahd.ljQ = locala.UbS.readString();
          AppMethodBeat.o(220686);
          return 0;
        case 2: 
          localahd.model = locala.UbS.readString();
          AppMethodBeat.o(220686);
          return 0;
        case 3: 
          localahd.LqN = locala.UbS.readString();
          AppMethodBeat.o(220686);
          return 0;
        }
        localahd.LqO = locala.UbS.readString();
        AppMethodBeat.o(220686);
        return 0;
      }
      AppMethodBeat.o(220686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahd
 * JD-Core Version:    0.7.0.1
 */