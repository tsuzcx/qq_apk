package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aib
  extends com.tencent.mm.bw.a
{
  public LinkedList<aic> hFT;
  public String key;
  public String title;
  
  public aib()
  {
    AppMethodBeat.i(218921);
    this.hFT = new LinkedList();
    AppMethodBeat.o(218921);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218922);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.hFT);
      if (this.key != null) {
        paramVarArgs.d(2, this.key);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      AppMethodBeat.o(218922);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.hFT) + 0;
      paramInt = i;
      if (this.key != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.key);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      AppMethodBeat.o(218922);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hFT.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(218922);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aib localaib = (aib)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(218922);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aic();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aic)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaib.hFT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(218922);
        return 0;
      case 2: 
        localaib.key = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(218922);
        return 0;
      }
      localaib.title = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(218922);
      return 0;
    }
    AppMethodBeat.o(218922);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aib
 * JD-Core Version:    0.7.0.1
 */