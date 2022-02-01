package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvp
  extends com.tencent.mm.cd.a
{
  public String UbG;
  public String appid;
  public String jDV;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91668);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      if (this.UbG != null) {
        paramVarArgs.f(3, this.UbG);
      }
      if (this.path != null) {
        paramVarArgs.f(4, this.path);
      }
      if (this.jDV != null) {
        paramVarArgs.f(5, this.jDV);
      }
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appid);
      }
      i = paramInt;
      if (this.UbG != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UbG);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.path);
      }
      i = paramInt;
      if (this.jDV != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.jDV);
      }
      AppMethodBeat.o(91668);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dvp localdvp = (dvp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91668);
        return -1;
      case 1: 
        localdvp.type = locala.abFh.AK();
        AppMethodBeat.o(91668);
        return 0;
      case 2: 
        localdvp.appid = locala.abFh.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 3: 
        localdvp.UbG = locala.abFh.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 4: 
        localdvp.path = locala.abFh.readString();
        AppMethodBeat.o(91668);
        return 0;
      }
      localdvp.jDV = locala.abFh.readString();
      AppMethodBeat.o(91668);
      return 0;
    }
    AppMethodBeat.o(91668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvp
 * JD-Core Version:    0.7.0.1
 */