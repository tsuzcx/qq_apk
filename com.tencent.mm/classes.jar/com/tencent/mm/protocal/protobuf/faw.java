package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class faw
  extends com.tencent.mm.cd.a
{
  public String TsD;
  public String Tuh;
  public String UAM;
  public String appid;
  public String fdH;
  public String tyH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123678);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.fdH != null) {
        paramVarArgs.f(2, this.fdH);
      }
      if (this.Tuh != null) {
        paramVarArgs.f(3, this.Tuh);
      }
      if (this.UAM != null) {
        paramVarArgs.f(4, this.UAM);
      }
      if (this.tyH != null) {
        paramVarArgs.f(5, this.tyH);
      }
      if (this.TsD != null) {
        paramVarArgs.f(6, this.TsD);
      }
      AppMethodBeat.o(123678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fdH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fdH);
      }
      i = paramInt;
      if (this.Tuh != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tuh);
      }
      paramInt = i;
      if (this.UAM != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UAM);
      }
      i = paramInt;
      if (this.tyH != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.tyH);
      }
      paramInt = i;
      if (this.TsD != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TsD);
      }
      AppMethodBeat.o(123678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123678);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        faw localfaw = (faw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123678);
          return -1;
        case 1: 
          localfaw.appid = locala.abFh.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 2: 
          localfaw.fdH = locala.abFh.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 3: 
          localfaw.Tuh = locala.abFh.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 4: 
          localfaw.UAM = locala.abFh.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 5: 
          localfaw.tyH = locala.abFh.readString();
          AppMethodBeat.o(123678);
          return 0;
        }
        localfaw.TsD = locala.abFh.readString();
        AppMethodBeat.o(123678);
        return 0;
      }
      AppMethodBeat.o(123678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.faw
 * JD-Core Version:    0.7.0.1
 */