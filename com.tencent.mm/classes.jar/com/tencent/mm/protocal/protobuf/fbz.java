package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbz
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> abBA;
  public LinkedList<String> abBB;
  public LinkedList<Integer> abBC;
  public LinkedList<Integer> abBD;
  
  public fbz()
  {
    AppMethodBeat.i(114079);
    this.abBA = new LinkedList();
    this.abBB = new LinkedList();
    this.abBC = new LinkedList();
    this.abBD = new LinkedList();
    AppMethodBeat.o(114079);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114080);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.abBA);
      paramVarArgs.e(2, 1, this.abBB);
      paramVarArgs.e(3, 2, this.abBC);
      paramVarArgs.e(4, 2, this.abBD);
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 1, this.abBA);
      int i = i.a.a.a.c(2, 1, this.abBB);
      int j = i.a.a.a.c(3, 2, this.abBC);
      int k = i.a.a.a.c(4, 2, this.abBD);
      AppMethodBeat.o(114080);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abBA.clear();
      this.abBB.clear();
      this.abBC.clear();
      this.abBD.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fbz localfbz = (fbz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(114080);
        return -1;
      case 1: 
        localfbz.abBA.add(locala.ajGk.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 2: 
        localfbz.abBB.add(locala.ajGk.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 3: 
        localfbz.abBC.add(Integer.valueOf(locala.ajGk.aar()));
        AppMethodBeat.o(114080);
        return 0;
      }
      localfbz.abBD.add(Integer.valueOf(locala.ajGk.aar()));
      AppMethodBeat.o(114080);
      return 0;
    }
    AppMethodBeat.o(114080);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbz
 * JD-Core Version:    0.7.0.1
 */