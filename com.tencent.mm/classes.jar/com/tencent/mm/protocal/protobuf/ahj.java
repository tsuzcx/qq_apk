package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahj
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> DjZ;
  public int Dka;
  
  public ahj()
  {
    AppMethodBeat.i(124487);
    this.DjZ = new LinkedList();
    this.Dka = 1;
    AppMethodBeat.o(124487);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124488);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.DjZ);
      paramVarArgs.aR(2, this.Dka);
      AppMethodBeat.o(124488);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.DjZ);
      int i = f.a.a.b.b.a.bA(2, this.Dka);
      AppMethodBeat.o(124488);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DjZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124488);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahj localahj = (ahj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124488);
        return -1;
      case 1: 
        localahj.DjZ.add(locala.KhF.readString());
        AppMethodBeat.o(124488);
        return 0;
      }
      localahj.Dka = locala.KhF.xS();
      AppMethodBeat.o(124488);
      return 0;
    }
    AppMethodBeat.o(124488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahj
 * JD-Core Version:    0.7.0.1
 */