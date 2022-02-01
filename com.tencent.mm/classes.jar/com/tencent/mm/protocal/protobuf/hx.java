package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hx
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> FSP;
  public int FSQ;
  public int uqG;
  
  public hx()
  {
    AppMethodBeat.i(104747);
    this.FSP = new LinkedList();
    AppMethodBeat.o(104747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104748);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.FSP);
      paramVarArgs.aS(2, this.FSQ);
      paramVarArgs.aS(3, this.uqG);
      AppMethodBeat.o(104748);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.FSP);
      int i = f.a.a.b.b.a.bz(2, this.FSQ);
      int j = f.a.a.b.b.a.bz(3, this.uqG);
      AppMethodBeat.o(104748);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FSP.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(104748);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      hx localhx = (hx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104748);
        return -1;
      case 1: 
        localhx.FSP.add(locala.OmT.readString());
        AppMethodBeat.o(104748);
        return 0;
      case 2: 
        localhx.FSQ = locala.OmT.zc();
        AppMethodBeat.o(104748);
        return 0;
      }
      localhx.uqG = locala.OmT.zc();
      AppMethodBeat.o(104748);
      return 0;
    }
    AppMethodBeat.o(104748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hx
 * JD-Core Version:    0.7.0.1
 */