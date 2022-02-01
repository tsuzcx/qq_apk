package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eyd
  extends com.tencent.mm.bw.a
{
  public String Nvm;
  public String dCC;
  public String eda;
  public int isGame;
  public int nbf;
  public String path;
  public int subType;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125852);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.e(2, this.path);
      }
      paramVarArgs.aM(3, this.version);
      paramVarArgs.aM(4, this.nbf);
      if (this.dCC != null) {
        paramVarArgs.e(5, this.dCC);
      }
      paramVarArgs.aM(6, this.isGame);
      if (this.eda != null) {
        paramVarArgs.e(7, this.eda);
      }
      paramVarArgs.aM(8, this.subType);
      if (this.Nvm != null) {
        paramVarArgs.e(9, this.Nvm);
      }
      AppMethodBeat.o(125852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.path);
      }
      i = i + g.a.a.b.b.a.bu(3, this.version) + g.a.a.b.b.a.bu(4, this.nbf);
      paramInt = i;
      if (this.dCC != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dCC);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.isGame);
      paramInt = i;
      if (this.eda != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.eda);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.subType);
      paramInt = i;
      if (this.Nvm != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Nvm);
      }
      AppMethodBeat.o(125852);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125852);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eyd localeyd = (eyd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125852);
          return -1;
        case 1: 
          localeyd.username = locala.UbS.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 2: 
          localeyd.path = locala.UbS.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 3: 
          localeyd.version = locala.UbS.zi();
          AppMethodBeat.o(125852);
          return 0;
        case 4: 
          localeyd.nbf = locala.UbS.zi();
          AppMethodBeat.o(125852);
          return 0;
        case 5: 
          localeyd.dCC = locala.UbS.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 6: 
          localeyd.isGame = locala.UbS.zi();
          AppMethodBeat.o(125852);
          return 0;
        case 7: 
          localeyd.eda = locala.UbS.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 8: 
          localeyd.subType = locala.UbS.zi();
          AppMethodBeat.o(125852);
          return 0;
        }
        localeyd.Nvm = locala.UbS.readString();
        AppMethodBeat.o(125852);
        return 0;
      }
      AppMethodBeat.o(125852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyd
 * JD-Core Version:    0.7.0.1
 */