package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axh
  extends com.tencent.mm.bx.a
  implements ctq
{
  public bvm Dwn;
  public int ret;
  
  public final int getRet()
  {
    return this.ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152581);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ret);
      if (this.Dwn != null)
      {
        paramVarArgs.kX(2, this.Dwn.computeSize());
        this.Dwn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152581);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.ret) + 0;
      paramInt = i;
      if (this.Dwn != null) {
        paramInt = i + f.a.a.a.kW(2, this.Dwn.computeSize());
      }
      AppMethodBeat.o(152581);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152581);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      axh localaxh = (axh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152581);
        return -1;
      case 1: 
        localaxh.ret = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152581);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bvm();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bvm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaxh.Dwn = ((bvm)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152581);
      return 0;
    }
    AppMethodBeat.o(152581);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axh
 * JD-Core Version:    0.7.0.1
 */