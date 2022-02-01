package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eet
  extends com.tencent.mm.bw.a
{
  public boolean GUq;
  public LinkedList<eer> GXr;
  public boolean IiY;
  
  public eet()
  {
    AppMethodBeat.i(32541);
    this.GXr = new LinkedList();
    AppMethodBeat.o(32541);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.GUq);
      paramVarArgs.e(2, 8, this.GXr);
      paramVarArgs.bC(3, this.IiY);
      AppMethodBeat.o(32542);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amF(1);
      i = f.a.a.a.c(2, 8, this.GXr);
      int j = f.a.a.b.b.a.amF(3);
      AppMethodBeat.o(32542);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GXr.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32542);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      eet localeet = (eet)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32542);
        return -1;
      case 1: 
        localeet.GUq = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(32542);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eer();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eer)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeet.GXr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32542);
        return 0;
      }
      localeet.IiY = ((f.a.a.a.a)localObject1).OmT.gvY();
      AppMethodBeat.o(32542);
      return 0;
    }
    AppMethodBeat.o(32542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eet
 * JD-Core Version:    0.7.0.1
 */