package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcy
  extends com.tencent.mm.bw.a
{
  public String KCU;
  public int MIe;
  public String MIf;
  public String Title;
  public String URL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209804);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.URL != null) {
        paramVarArgs.e(2, this.URL);
      }
      paramVarArgs.aM(3, this.MIe);
      if (this.MIf != null) {
        paramVarArgs.e(4, this.MIf);
      }
      if (this.KCU != null) {
        paramVarArgs.e(5, this.KCU);
      }
      AppMethodBeat.o(209804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.URL != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.URL);
      }
      i += g.a.a.b.b.a.bu(3, this.MIe);
      paramInt = i;
      if (this.MIf != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MIf);
      }
      i = paramInt;
      if (this.KCU != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KCU);
      }
      AppMethodBeat.o(209804);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209804);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dcy localdcy = (dcy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209804);
          return -1;
        case 1: 
          localdcy.Title = locala.UbS.readString();
          AppMethodBeat.o(209804);
          return 0;
        case 2: 
          localdcy.URL = locala.UbS.readString();
          AppMethodBeat.o(209804);
          return 0;
        case 3: 
          localdcy.MIe = locala.UbS.zi();
          AppMethodBeat.o(209804);
          return 0;
        case 4: 
          localdcy.MIf = locala.UbS.readString();
          AppMethodBeat.o(209804);
          return 0;
        }
        localdcy.KCU = locala.UbS.readString();
        AppMethodBeat.o(209804);
        return 0;
      }
      AppMethodBeat.o(209804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcy
 * JD-Core Version:    0.7.0.1
 */