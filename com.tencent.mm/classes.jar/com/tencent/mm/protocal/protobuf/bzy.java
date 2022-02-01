package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzy
  extends com.tencent.mm.bw.a
{
  public boolean COn;
  public String COo;
  public LinkedList<Integer> HnH;
  
  public bzy()
  {
    AppMethodBeat.i(91541);
    this.HnH = new LinkedList();
    AppMethodBeat.o(91541);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.COn);
      if (this.COo != null) {
        paramVarArgs.d(2, this.COo);
      }
      paramVarArgs.e(3, 2, this.HnH);
      AppMethodBeat.o(91542);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0;
      paramInt = i;
      if (this.COo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.COo);
      }
      i = f.a.a.a.c(3, 2, this.HnH);
      AppMethodBeat.o(91542);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HnH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91542);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bzy localbzy = (bzy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91542);
        return -1;
      case 1: 
        localbzy.COn = locala.OmT.gvY();
        AppMethodBeat.o(91542);
        return 0;
      case 2: 
        localbzy.COo = locala.OmT.readString();
        AppMethodBeat.o(91542);
        return 0;
      }
      localbzy.HnH.add(Integer.valueOf(locala.OmT.zc()));
      AppMethodBeat.o(91542);
      return 0;
    }
    AppMethodBeat.o(91542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzy
 * JD-Core Version:    0.7.0.1
 */