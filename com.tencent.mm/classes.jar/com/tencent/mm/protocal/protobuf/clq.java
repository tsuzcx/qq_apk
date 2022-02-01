package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clq
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public cmc Cvq;
  public dbp Dah;
  public int EgS;
  public int EgT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91674);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EgS);
      paramVarArgs.aR(2, this.EgT);
      if (this.Cvq != null)
      {
        paramVarArgs.kX(3, this.Cvq.computeSize());
        this.Cvq.writeFields(paramVarArgs);
      }
      if (this.Dah != null)
      {
        paramVarArgs.kX(4, this.Dah.computeSize());
        this.Dah.writeFields(paramVarArgs);
      }
      if (this.CDW != null) {
        paramVarArgs.d(5, this.CDW);
      }
      AppMethodBeat.o(91674);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.EgS) + 0 + f.a.a.b.b.a.bA(2, this.EgT);
      paramInt = i;
      if (this.Cvq != null) {
        paramInt = i + f.a.a.a.kW(3, this.Cvq.computeSize());
      }
      i = paramInt;
      if (this.Dah != null) {
        i = paramInt + f.a.a.a.kW(4, this.Dah.computeSize());
      }
      paramInt = i;
      if (this.CDW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CDW);
      }
      AppMethodBeat.o(91674);
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
      AppMethodBeat.o(91674);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      clq localclq = (clq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91674);
        return -1;
      case 1: 
        localclq.EgS = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91674);
        return 0;
      case 2: 
        localclq.EgT = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91674);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclq.Cvq = ((cmc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclq.Dah = ((dbp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      }
      localclq.CDW = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(91674);
      return 0;
    }
    AppMethodBeat.o(91674);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clq
 * JD-Core Version:    0.7.0.1
 */