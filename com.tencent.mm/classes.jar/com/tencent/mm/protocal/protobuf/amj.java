package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amj
  extends com.tencent.mm.bw.a
{
  public String Lve;
  public String appId;
  public String dCx;
  public int dMe;
  public String eda;
  public String iconUrl;
  public int leb;
  public int lyE;
  public int subType;
  public int type;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.appId != null) {
        paramVarArgs.e(2, this.appId);
      }
      paramVarArgs.aM(3, this.dMe);
      if (this.iconUrl != null) {
        paramVarArgs.e(4, this.iconUrl);
      }
      paramVarArgs.aM(5, this.type);
      if (this.dCx != null) {
        paramVarArgs.e(6, this.dCx);
      }
      if (this.Lve != null) {
        paramVarArgs.e(7, this.Lve);
      }
      paramVarArgs.aM(8, this.version);
      paramVarArgs.aM(9, this.lyE);
      paramVarArgs.aM(10, this.leb);
      if (this.eda != null) {
        paramVarArgs.e(11, this.eda);
      }
      paramVarArgs.aM(12, this.subType);
      AppMethodBeat.o(127455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appId != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.appId);
      }
      i += g.a.a.b.b.a.bu(3, this.dMe);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.iconUrl);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.type);
      paramInt = i;
      if (this.dCx != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dCx);
      }
      i = paramInt;
      if (this.Lve != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lve);
      }
      i = i + g.a.a.b.b.a.bu(8, this.version) + g.a.a.b.b.a.bu(9, this.lyE) + g.a.a.b.b.a.bu(10, this.leb);
      paramInt = i;
      if (this.eda != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.eda);
      }
      i = g.a.a.b.b.a.bu(12, this.subType);
      AppMethodBeat.o(127455);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127455);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        amj localamj = (amj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127455);
          return -1;
        case 1: 
          localamj.username = locala.UbS.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 2: 
          localamj.appId = locala.UbS.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 3: 
          localamj.dMe = locala.UbS.zi();
          AppMethodBeat.o(127455);
          return 0;
        case 4: 
          localamj.iconUrl = locala.UbS.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 5: 
          localamj.type = locala.UbS.zi();
          AppMethodBeat.o(127455);
          return 0;
        case 6: 
          localamj.dCx = locala.UbS.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 7: 
          localamj.Lve = locala.UbS.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 8: 
          localamj.version = locala.UbS.zi();
          AppMethodBeat.o(127455);
          return 0;
        case 9: 
          localamj.lyE = locala.UbS.zi();
          AppMethodBeat.o(127455);
          return 0;
        case 10: 
          localamj.leb = locala.UbS.zi();
          AppMethodBeat.o(127455);
          return 0;
        case 11: 
          localamj.eda = locala.UbS.readString();
          AppMethodBeat.o(127455);
          return 0;
        }
        localamj.subType = locala.UbS.zi();
        AppMethodBeat.o(127455);
        return 0;
      }
      AppMethodBeat.o(127455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amj
 * JD-Core Version:    0.7.0.1
 */