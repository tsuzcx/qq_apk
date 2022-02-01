package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eba
  extends com.tencent.mm.cd.a
{
  public String path;
  public int scene;
  public int type;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188320);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.f(2, this.path);
      }
      paramVarArgs.aY(3, this.version);
      paramVarArgs.aY(4, this.scene);
      paramVarArgs.aY(5, this.type);
      AppMethodBeat.o(188320);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.path);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.version);
      int j = g.a.a.b.b.a.bM(4, this.scene);
      int k = g.a.a.b.b.a.bM(5, this.type);
      AppMethodBeat.o(188320);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(188320);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eba localeba = (eba)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(188320);
          return -1;
        case 1: 
          localeba.username = locala.abFh.readString();
          AppMethodBeat.o(188320);
          return 0;
        case 2: 
          localeba.path = locala.abFh.readString();
          AppMethodBeat.o(188320);
          return 0;
        case 3: 
          localeba.version = locala.abFh.AK();
          AppMethodBeat.o(188320);
          return 0;
        case 4: 
          localeba.scene = locala.abFh.AK();
          AppMethodBeat.o(188320);
          return 0;
        }
        localeba.type = locala.abFh.AK();
        AppMethodBeat.o(188320);
        return 0;
      }
      AppMethodBeat.o(188320);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eba
 * JD-Core Version:    0.7.0.1
 */