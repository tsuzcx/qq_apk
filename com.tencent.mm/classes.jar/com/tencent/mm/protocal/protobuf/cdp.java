package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdp
  extends com.tencent.mm.bx.a
{
  public LinkedList<cdo> DZS;
  public int Dxg;
  public int mAK;
  
  public cdp()
  {
    AppMethodBeat.i(155449);
    this.DZS = new LinkedList();
    AppMethodBeat.o(155449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155450);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dxg);
      paramVarArgs.aR(2, this.mAK);
      paramVarArgs.e(3, 8, this.DZS);
      AppMethodBeat.o(155450);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Dxg);
      i = f.a.a.b.b.a.bA(2, this.mAK);
      int j = f.a.a.a.c(3, 8, this.DZS);
      AppMethodBeat.o(155450);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DZS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(155450);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cdp localcdp = (cdp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155450);
        return -1;
      case 1: 
        localcdp.Dxg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(155450);
        return 0;
      case 2: 
        localcdp.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(155450);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cdo();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cdo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcdp.DZS.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(155450);
      return 0;
    }
    AppMethodBeat.o(155450);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdp
 * JD-Core Version:    0.7.0.1
 */