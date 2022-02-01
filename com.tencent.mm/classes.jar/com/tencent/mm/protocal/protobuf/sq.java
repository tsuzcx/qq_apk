package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class sq
  extends com.tencent.mm.bw.a
{
  public LinkedList<rv> Ggy;
  public dww GhB;
  public int GhC;
  public int GhD;
  public String ydG;
  
  public sq()
  {
    AppMethodBeat.i(217519);
    this.Ggy = new LinkedList();
    AppMethodBeat.o(217519);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217520);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GhB == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(217520);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.Ggy);
      if (this.GhB != null)
      {
        paramVarArgs.lJ(2, this.GhB.computeSize());
        this.GhB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GhC);
      paramVarArgs.aS(4, this.GhD);
      if (this.ydG != null) {
        paramVarArgs.d(5, this.ydG);
      }
      AppMethodBeat.o(217520);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Ggy) + 0;
      paramInt = i;
      if (this.GhB != null) {
        paramInt = i + f.a.a.a.lI(2, this.GhB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.GhC) + f.a.a.b.b.a.bz(4, this.GhD);
      paramInt = i;
      if (this.ydG != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ydG);
      }
      AppMethodBeat.o(217520);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ggy.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GhB == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(217520);
        throw paramVarArgs;
      }
      AppMethodBeat.o(217520);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      sq localsq = (sq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(217520);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsq.Ggy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217520);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dww();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsq.GhB = ((dww)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(217520);
        return 0;
      case 3: 
        localsq.GhC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(217520);
        return 0;
      case 4: 
        localsq.GhD = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(217520);
        return 0;
      }
      localsq.ydG = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(217520);
      return 0;
    }
    AppMethodBeat.o(217520);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sq
 * JD-Core Version:    0.7.0.1
 */