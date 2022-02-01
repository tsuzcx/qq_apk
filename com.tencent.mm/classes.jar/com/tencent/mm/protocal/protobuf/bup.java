package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bup
  extends com.tencent.mm.bw.a
{
  public String AWA;
  public boolean AWz;
  public LinkedList<Integer> Fky;
  
  public bup()
  {
    AppMethodBeat.i(91541);
    this.Fky = new LinkedList();
    AppMethodBeat.o(91541);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.AWz);
      if (this.AWA != null) {
        paramVarArgs.d(2, this.AWA);
      }
      paramVarArgs.e(3, 2, this.Fky);
      AppMethodBeat.o(91542);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 1 + 0;
      paramInt = i;
      if (this.AWA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.AWA);
      }
      i = f.a.a.a.c(3, 2, this.Fky);
      AppMethodBeat.o(91542);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Fky.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91542);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bup localbup = (bup)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91542);
        return -1;
      case 1: 
        localbup.AWz = locala.LVo.fZX();
        AppMethodBeat.o(91542);
        return 0;
      case 2: 
        localbup.AWA = locala.LVo.readString();
        AppMethodBeat.o(91542);
        return 0;
      }
      localbup.Fky.add(Integer.valueOf(locala.LVo.xF()));
      AppMethodBeat.o(91542);
      return 0;
    }
    AppMethodBeat.o(91542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bup
 * JD-Core Version:    0.7.0.1
 */