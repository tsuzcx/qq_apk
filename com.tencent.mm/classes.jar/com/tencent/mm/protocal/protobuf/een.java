package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class een
  extends com.tencent.mm.bw.a
{
  public long FSD;
  public long IiS;
  public String IiT;
  public LinkedList<eeo> IiU;
  
  public een()
  {
    AppMethodBeat.i(32534);
    this.IiU = new LinkedList();
    AppMethodBeat.o(32534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32535);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IiT == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(32535);
        throw paramVarArgs;
      }
      paramVarArgs.aZ(1, this.IiS);
      paramVarArgs.aZ(2, this.FSD);
      if (this.IiT != null) {
        paramVarArgs.d(3, this.IiT);
      }
      paramVarArgs.e(4, 8, this.IiU);
      AppMethodBeat.o(32535);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.IiS) + 0 + f.a.a.b.b.a.p(2, this.FSD);
      paramInt = i;
      if (this.IiT != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.IiT);
      }
      i = f.a.a.a.c(4, 8, this.IiU);
      AppMethodBeat.o(32535);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IiU.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.IiT == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(32535);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32535);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      een localeen = (een)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32535);
        return -1;
      case 1: 
        localeen.IiS = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(32535);
        return 0;
      case 2: 
        localeen.FSD = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(32535);
        return 0;
      case 3: 
        localeen.IiT = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32535);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new eeo();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((eeo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localeen.IiU.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32535);
      return 0;
    }
    AppMethodBeat.o(32535);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.een
 * JD-Core Version:    0.7.0.1
 */