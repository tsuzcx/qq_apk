package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bmx
  extends com.tencent.mm.bx.a
{
  public b ZKL;
  public b ZKM;
  public LinkedList<Long> ZVD;
  
  public bmx()
  {
    AppMethodBeat.i(258903);
    this.ZVD = new LinkedList();
    AppMethodBeat.o(258903);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258906);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 3, this.ZVD);
      if (this.ZKL != null) {
        paramVarArgs.d(2, this.ZKL);
      }
      if (this.ZKM != null) {
        paramVarArgs.d(3, this.ZKM);
      }
      AppMethodBeat.o(258906);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.a.c(1, 3, this.ZVD) + 0;
      paramInt = i;
      if (this.ZKL != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZKL);
      }
      i = paramInt;
      if (this.ZKM != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZKM);
      }
      AppMethodBeat.o(258906);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZVD.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258906);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bmx localbmx = (bmx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258906);
        return -1;
      case 1: 
        localbmx.ZVD.add(Long.valueOf(locala.ajGk.aaw()));
        AppMethodBeat.o(258906);
        return 0;
      case 2: 
        localbmx.ZKL = locala.ajGk.kFX();
        AppMethodBeat.o(258906);
        return 0;
      }
      localbmx.ZKM = locala.ajGk.kFX();
      AppMethodBeat.o(258906);
      return 0;
    }
    AppMethodBeat.o(258906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmx
 * JD-Core Version:    0.7.0.1
 */