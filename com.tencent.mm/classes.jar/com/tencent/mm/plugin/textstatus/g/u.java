package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bw.a
{
  public String GaS;
  public long GaT;
  public int Gaz;
  public String nickname;
  public String qFV;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222843);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.e(1, this.nickname);
      }
      if (this.qFV != null) {
        paramVarArgs.e(2, this.qFV);
      }
      if (this.GaS != null) {
        paramVarArgs.e(3, this.GaS);
      }
      paramVarArgs.aM(4, this.type);
      paramVarArgs.aM(5, this.Gaz);
      paramVarArgs.bb(6, this.GaT);
      AppMethodBeat.o(222843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label474;
      }
    }
    label474:
    for (int i = g.a.a.b.b.a.f(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qFV != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.qFV);
      }
      i = paramInt;
      if (this.GaS != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.GaS);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.type);
      int j = g.a.a.b.b.a.bu(5, this.Gaz);
      int k = g.a.a.b.b.a.r(6, this.GaT);
      AppMethodBeat.o(222843);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(222843);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(222843);
          return -1;
        case 1: 
          localu.nickname = locala.UbS.readString();
          AppMethodBeat.o(222843);
          return 0;
        case 2: 
          localu.qFV = locala.UbS.readString();
          AppMethodBeat.o(222843);
          return 0;
        case 3: 
          localu.GaS = locala.UbS.readString();
          AppMethodBeat.o(222843);
          return 0;
        case 4: 
          localu.type = locala.UbS.zi();
          AppMethodBeat.o(222843);
          return 0;
        case 5: 
          localu.Gaz = locala.UbS.zi();
          AppMethodBeat.o(222843);
          return 0;
        }
        localu.GaT = locala.UbS.zl();
        AppMethodBeat.o(222843);
        return 0;
      }
      AppMethodBeat.o(222843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.u
 * JD-Core Version:    0.7.0.1
 */