package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class iv
  extends com.tencent.mm.bx.a
{
  public int IHj;
  public LinkedList<String> YKG;
  public int YKH;
  
  public iv()
  {
    AppMethodBeat.i(104747);
    this.YKG = new LinkedList();
    AppMethodBeat.o(104747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104748);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.YKG);
      paramVarArgs.bS(2, this.YKH);
      paramVarArgs.bS(3, this.IHj);
      AppMethodBeat.o(104748);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 1, this.YKG);
      int i = i.a.a.b.b.a.cJ(2, this.YKH);
      int j = i.a.a.b.b.a.cJ(3, this.IHj);
      AppMethodBeat.o(104748);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YKG.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(104748);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      iv localiv = (iv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104748);
        return -1;
      case 1: 
        localiv.YKG.add(locala.ajGk.readString());
        AppMethodBeat.o(104748);
        return 0;
      case 2: 
        localiv.YKH = locala.ajGk.aar();
        AppMethodBeat.o(104748);
        return 0;
      }
      localiv.IHj = locala.ajGk.aar();
      AppMethodBeat.o(104748);
      return 0;
    }
    AppMethodBeat.o(104748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iv
 * JD-Core Version:    0.7.0.1
 */