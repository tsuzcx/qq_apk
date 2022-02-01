package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fkz
  extends com.tencent.mm.cd.a
{
  public String UJN;
  public int UJO;
  public String appId;
  public int fwM;
  public int opType;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214247);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.fwM);
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.appId != null) {
        paramVarArgs.f(3, this.appId);
      }
      paramVarArgs.aY(4, this.scene);
      if (this.UJN != null) {
        paramVarArgs.f(5, this.UJN);
      }
      paramVarArgs.aY(6, this.opType);
      paramVarArgs.aY(7, this.UJO);
      AppMethodBeat.o(214247);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.fwM) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.appId);
      }
      i += g.a.a.b.b.a.bM(4, this.scene);
      paramInt = i;
      if (this.UJN != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UJN);
      }
      i = g.a.a.b.b.a.bM(6, this.opType);
      int j = g.a.a.b.b.a.bM(7, this.UJO);
      AppMethodBeat.o(214247);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(214247);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fkz localfkz = (fkz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(214247);
        return -1;
      case 1: 
        localfkz.fwM = locala.abFh.AK();
        AppMethodBeat.o(214247);
        return 0;
      case 2: 
        localfkz.url = locala.abFh.readString();
        AppMethodBeat.o(214247);
        return 0;
      case 3: 
        localfkz.appId = locala.abFh.readString();
        AppMethodBeat.o(214247);
        return 0;
      case 4: 
        localfkz.scene = locala.abFh.AK();
        AppMethodBeat.o(214247);
        return 0;
      case 5: 
        localfkz.UJN = locala.abFh.readString();
        AppMethodBeat.o(214247);
        return 0;
      case 6: 
        localfkz.opType = locala.abFh.AK();
        AppMethodBeat.o(214247);
        return 0;
      }
      localfkz.UJO = locala.abFh.AK();
      AppMethodBeat.o(214247);
      return 0;
    }
    AppMethodBeat.o(214247);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkz
 * JD-Core Version:    0.7.0.1
 */