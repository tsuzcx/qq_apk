package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aje
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String LsI;
  public int LsJ;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104767);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(2, this.IconUrl);
      }
      if (this.LsI != null) {
        paramVarArgs.e(3, this.LsI);
      }
      paramVarArgs.aM(4, this.LsJ);
      AppMethodBeat.o(104767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.Name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.IconUrl);
      }
      i = paramInt;
      if (this.LsI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LsI);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.LsJ);
      AppMethodBeat.o(104767);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104767);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aje localaje = (aje)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104767);
          return -1;
        case 1: 
          localaje.Name = locala.UbS.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 2: 
          localaje.IconUrl = locala.UbS.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 3: 
          localaje.LsI = locala.UbS.readString();
          AppMethodBeat.o(104767);
          return 0;
        }
        localaje.LsJ = locala.UbS.zi();
        AppMethodBeat.o(104767);
        return 0;
      }
      AppMethodBeat.o(104767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aje
 * JD-Core Version:    0.7.0.1
 */