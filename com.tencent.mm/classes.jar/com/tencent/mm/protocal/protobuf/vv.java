package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vv
  extends com.tencent.mm.bx.a
{
  public LinkedList<vw> FVk;
  public int FVl;
  public cwt FVm;
  public int fLb;
  
  public vv()
  {
    AppMethodBeat.i(43085);
    this.FVk = new LinkedList();
    AppMethodBeat.o(43085);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43086);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.fLb);
      paramVarArgs.e(2, 8, this.FVk);
      paramVarArgs.aS(3, this.FVl);
      if (this.FVm != null)
      {
        paramVarArgs.lC(4, this.FVm.computeSize());
        this.FVm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.fLb) + 0 + f.a.a.a.c(2, 8, this.FVk) + f.a.a.b.b.a.bz(3, this.FVl);
      paramInt = i;
      if (this.FVm != null) {
        paramInt = i + f.a.a.a.lB(4, this.FVm.computeSize());
      }
      AppMethodBeat.o(43086);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FVk.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      vv localvv = (vv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43086);
        return -1;
      case 1: 
        localvv.fLb = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43086);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localvv.FVk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43086);
        return 0;
      case 3: 
        localvv.FVl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43086);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cwt();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localvv.FVm = ((cwt)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    AppMethodBeat.o(43086);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vv
 * JD-Core Version:    0.7.0.1
 */