package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bxc
  extends com.tencent.mm.bx.a
{
  public LinkedList<bwz> DTw;
  public LinkedList<Integer> DpH;
  public int mAK;
  
  public bxc()
  {
    AppMethodBeat.i(43120);
    this.DpH = new LinkedList();
    this.DTw = new LinkedList();
    AppMethodBeat.o(43120);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43121);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mAK);
      paramVarArgs.f(2, 2, this.DpH);
      paramVarArgs.e(3, 8, this.DTw);
      AppMethodBeat.o(43121);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.mAK);
      i = f.a.a.a.d(2, 2, this.DpH);
      int j = f.a.a.a.c(3, 8, this.DTw);
      AppMethodBeat.o(43121);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DpH.clear();
      this.DTw.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(43121);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bxc localbxc = (bxc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43121);
        return -1;
      case 1: 
        localbxc.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43121);
        return 0;
      case 2: 
        localbxc.DpH = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
        AppMethodBeat.o(43121);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bwz();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bwz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbxc.DTw.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43121);
      return 0;
    }
    AppMethodBeat.o(43121);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxc
 * JD-Core Version:    0.7.0.1
 */