package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddg
  extends com.tencent.mm.cd.a
{
  public String desc;
  public int id;
  public String nickname;
  public String oDV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152630);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.id);
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      if (this.oDV != null) {
        paramVarArgs.f(3, this.oDV);
      }
      if (this.desc != null) {
        paramVarArgs.f(4, this.desc);
      }
      AppMethodBeat.o(152630);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.id) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickname);
      }
      i = paramInt;
      if (this.oDV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.oDV);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.desc);
      }
      AppMethodBeat.o(152630);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152630);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ddg localddg = (ddg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152630);
        return -1;
      case 1: 
        localddg.id = locala.abFh.AK();
        AppMethodBeat.o(152630);
        return 0;
      case 2: 
        localddg.nickname = locala.abFh.readString();
        AppMethodBeat.o(152630);
        return 0;
      case 3: 
        localddg.oDV = locala.abFh.readString();
        AppMethodBeat.o(152630);
        return 0;
      }
      localddg.desc = locala.abFh.readString();
      AppMethodBeat.o(152630);
      return 0;
    }
    AppMethodBeat.o(152630);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddg
 * JD-Core Version:    0.7.0.1
 */