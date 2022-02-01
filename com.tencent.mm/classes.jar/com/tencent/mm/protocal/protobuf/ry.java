package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ry
  extends com.tencent.mm.bx.a
{
  public int FOu;
  public LinkedList<Integer> FOv;
  
  public ry()
  {
    AppMethodBeat.i(133164);
    this.FOv = new LinkedList();
    AppMethodBeat.o(133164);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133165);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FOu);
      paramVarArgs.f(2, 2, this.FOv);
      AppMethodBeat.o(133165);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FOu);
      int i = f.a.a.a.d(2, 2, this.FOv);
      AppMethodBeat.o(133165);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FOv.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(133165);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ry localry = (ry)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133165);
        return -1;
      case 1: 
        localry.FOu = locala.NPN.zc();
        AppMethodBeat.o(133165);
        return 0;
      }
      localry.FOv = new f.a.a.a.a(locala.NPN.gxI().zr, unknownTagHandler).NPN.gxG();
      AppMethodBeat.o(133165);
      return 0;
    }
    AppMethodBeat.o(133165);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ry
 * JD-Core Version:    0.7.0.1
 */