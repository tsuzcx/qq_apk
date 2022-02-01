package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhi
  extends com.tencent.mm.bw.a
{
  public int HHc;
  public int HOt;
  public LinkedList<dgq> HOu;
  public int HOv;
  public int HOw;
  
  public dhi()
  {
    AppMethodBeat.i(125810);
    this.HOu = new LinkedList();
    AppMethodBeat.o(125810);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125811);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HOt);
      paramVarArgs.e(2, 8, this.HOu);
      paramVarArgs.aS(3, this.HOv);
      paramVarArgs.aS(4, this.HHc);
      paramVarArgs.aS(5, this.HOw);
      AppMethodBeat.o(125811);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HOt);
      i = f.a.a.a.c(2, 8, this.HOu);
      int j = f.a.a.b.b.a.bz(3, this.HOv);
      int k = f.a.a.b.b.a.bz(4, this.HHc);
      int m = f.a.a.b.b.a.bz(5, this.HOw);
      AppMethodBeat.o(125811);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HOu.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125811);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dhi localdhi = (dhi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125811);
        return -1;
      case 1: 
        localdhi.HOt = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125811);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dgq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdhi.HOu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125811);
        return 0;
      case 3: 
        localdhi.HOv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125811);
        return 0;
      case 4: 
        localdhi.HHc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125811);
        return 0;
      }
      localdhi.HOw = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(125811);
      return 0;
    }
    AppMethodBeat.o(125811);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhi
 * JD-Core Version:    0.7.0.1
 */