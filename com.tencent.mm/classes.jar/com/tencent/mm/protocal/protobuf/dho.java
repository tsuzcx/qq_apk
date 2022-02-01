package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dho
  extends com.tencent.mm.cd.a
{
  public String OPc;
  public String TOJ;
  public String app_id;
  public String tyH;
  public String tyJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72540);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.f(1, this.app_id);
      }
      if (this.OPc != null) {
        paramVarArgs.f(2, this.OPc);
      }
      if (this.tyJ != null) {
        paramVarArgs.f(3, this.tyJ);
      }
      if (this.tyH != null) {
        paramVarArgs.f(4, this.tyH);
      }
      if (this.TOJ != null) {
        paramVarArgs.f(5, this.TOJ);
      }
      AppMethodBeat.o(72540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.g(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.OPc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.OPc);
      }
      i = paramInt;
      if (this.tyJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.tyJ);
      }
      paramInt = i;
      if (this.tyH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.tyH);
      }
      i = paramInt;
      if (this.TOJ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TOJ);
      }
      AppMethodBeat.o(72540);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72540);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dho localdho = (dho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72540);
          return -1;
        case 1: 
          localdho.app_id = locala.abFh.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 2: 
          localdho.OPc = locala.abFh.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 3: 
          localdho.tyJ = locala.abFh.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 4: 
          localdho.tyH = locala.abFh.readString();
          AppMethodBeat.o(72540);
          return 0;
        }
        localdho.TOJ = locala.abFh.readString();
        AppMethodBeat.o(72540);
        return 0;
      }
      AppMethodBeat.o(72540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dho
 * JD-Core Version:    0.7.0.1
 */