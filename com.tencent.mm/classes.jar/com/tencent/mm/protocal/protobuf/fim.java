package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fim
  extends com.tencent.mm.bx.a
{
  public int abJk;
  public String abJl;
  public String abJm;
  public String abJn;
  public String abJo;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168761);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abJk);
      if (this.abJl != null) {
        paramVarArgs.g(2, this.abJl);
      }
      if (this.abJm != null) {
        paramVarArgs.g(3, this.abJm);
      }
      paramVarArgs.bS(4, this.height);
      paramVarArgs.bS(5, this.width);
      if (this.abJn != null) {
        paramVarArgs.g(6, this.abJn);
      }
      if (this.abJo != null) {
        paramVarArgs.g(7, this.abJo);
      }
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abJk) + 0;
      paramInt = i;
      if (this.abJl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abJl);
      }
      i = paramInt;
      if (this.abJm != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abJm);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.height) + i.a.a.b.b.a.cJ(5, this.width);
      paramInt = i;
      if (this.abJn != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abJn);
      }
      i = paramInt;
      if (this.abJo != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abJo);
      }
      AppMethodBeat.o(168761);
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
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fim localfim = (fim)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168761);
        return -1;
      case 1: 
        localfim.abJk = locala.ajGk.aar();
        AppMethodBeat.o(168761);
        return 0;
      case 2: 
        localfim.abJl = locala.ajGk.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 3: 
        localfim.abJm = locala.ajGk.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 4: 
        localfim.height = locala.ajGk.aar();
        AppMethodBeat.o(168761);
        return 0;
      case 5: 
        localfim.width = locala.ajGk.aar();
        AppMethodBeat.o(168761);
        return 0;
      case 6: 
        localfim.abJn = locala.ajGk.readString();
        AppMethodBeat.o(168761);
        return 0;
      }
      localfim.abJo = locala.ajGk.readString();
      AppMethodBeat.o(168761);
      return 0;
    }
    AppMethodBeat.o(168761);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fim
 * JD-Core Version:    0.7.0.1
 */