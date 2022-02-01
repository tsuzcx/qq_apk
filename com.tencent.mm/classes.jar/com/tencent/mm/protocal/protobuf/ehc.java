package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehc
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> IkP;
  public int version;
  
  public ehc()
  {
    AppMethodBeat.i(208305);
    this.IkP = new LinkedList();
    AppMethodBeat.o(208305);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208306);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.version);
      paramVarArgs.e(2, 1, this.IkP);
      AppMethodBeat.o(208306);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.version);
      int i = f.a.a.a.c(2, 1, this.IkP);
      AppMethodBeat.o(208306);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IkP.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(208306);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ehc localehc = (ehc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208306);
        return -1;
      case 1: 
        localehc.version = locala.OmT.zc();
        AppMethodBeat.o(208306);
        return 0;
      }
      localehc.IkP.add(locala.OmT.readString());
      AppMethodBeat.o(208306);
      return 0;
    }
    AppMethodBeat.o(208306);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehc
 * JD-Core Version:    0.7.0.1
 */