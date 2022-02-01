package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmw
  extends com.tencent.mm.cd.a
{
  public String TsD;
  public String ULw;
  public String appid;
  public String fdH;
  public String tyH;
  public String tyJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(247488);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.ULw != null) {
        paramVarArgs.f(2, this.ULw);
      }
      if (this.tyH != null) {
        paramVarArgs.f(3, this.tyH);
      }
      if (this.fdH != null) {
        paramVarArgs.f(4, this.fdH);
      }
      if (this.TsD != null) {
        paramVarArgs.f(5, this.TsD);
      }
      if (this.tyJ != null) {
        paramVarArgs.f(6, this.tyJ);
      }
      AppMethodBeat.o(247488);
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
      if (this.ULw != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ULw);
      }
      i = paramInt;
      if (this.tyH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.tyH);
      }
      paramInt = i;
      if (this.fdH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fdH);
      }
      i = paramInt;
      if (this.TsD != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TsD);
      }
      paramInt = i;
      if (this.tyJ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.tyJ);
      }
      AppMethodBeat.o(247488);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(247488);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fmw localfmw = (fmw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(247488);
          return -1;
        case 1: 
          localfmw.appid = locala.abFh.readString();
          AppMethodBeat.o(247488);
          return 0;
        case 2: 
          localfmw.ULw = locala.abFh.readString();
          AppMethodBeat.o(247488);
          return 0;
        case 3: 
          localfmw.tyH = locala.abFh.readString();
          AppMethodBeat.o(247488);
          return 0;
        case 4: 
          localfmw.fdH = locala.abFh.readString();
          AppMethodBeat.o(247488);
          return 0;
        case 5: 
          localfmw.TsD = locala.abFh.readString();
          AppMethodBeat.o(247488);
          return 0;
        }
        localfmw.tyJ = locala.abFh.readString();
        AppMethodBeat.o(247488);
        return 0;
      }
      AppMethodBeat.o(247488);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmw
 * JD-Core Version:    0.7.0.1
 */