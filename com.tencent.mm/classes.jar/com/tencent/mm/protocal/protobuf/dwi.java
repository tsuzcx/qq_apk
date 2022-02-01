package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwi
  extends com.tencent.mm.cd.a
{
  public int SFZ;
  public String appid;
  public String xaL;
  public String xaM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210188);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.xaM != null) {
        paramVarArgs.f(2, this.xaM);
      }
      if (this.xaL != null) {
        paramVarArgs.f(3, this.xaL);
      }
      paramVarArgs.aY(4, this.SFZ);
      AppMethodBeat.o(210188);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xaM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.xaM);
      }
      i = paramInt;
      if (this.xaL != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.xaL);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.SFZ);
      AppMethodBeat.o(210188);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(210188);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dwi localdwi = (dwi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(210188);
          return -1;
        case 1: 
          localdwi.appid = locala.abFh.readString();
          AppMethodBeat.o(210188);
          return 0;
        case 2: 
          localdwi.xaM = locala.abFh.readString();
          AppMethodBeat.o(210188);
          return 0;
        case 3: 
          localdwi.xaL = locala.abFh.readString();
          AppMethodBeat.o(210188);
          return 0;
        }
        localdwi.SFZ = locala.abFh.AK();
        AppMethodBeat.o(210188);
        return 0;
      }
      AppMethodBeat.o(210188);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwi
 * JD-Core Version:    0.7.0.1
 */