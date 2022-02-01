package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxm
  extends com.tencent.mm.bx.a
{
  public String abdw;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258213);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.scene);
      if (this.abdw != null) {
        paramVarArgs.g(2, this.abdw);
      }
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      AppMethodBeat.o(258213);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.scene) + 0;
      paramInt = i;
      if (this.abdw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abdw);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.url);
      }
      AppMethodBeat.o(258213);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258213);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dxm localdxm = (dxm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258213);
        return -1;
      case 1: 
        localdxm.scene = locala.ajGk.aar();
        AppMethodBeat.o(258213);
        return 0;
      case 2: 
        localdxm.abdw = locala.ajGk.readString();
        AppMethodBeat.o(258213);
        return 0;
      }
      localdxm.url = locala.ajGk.readString();
      AppMethodBeat.o(258213);
      return 0;
    }
    AppMethodBeat.o(258213);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxm
 * JD-Core Version:    0.7.0.1
 */