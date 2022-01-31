package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cre
  extends com.tencent.mm.bv.a
{
  public int pIy;
  public int xZL;
  public int xZM;
  public SKBuiltinBuffer_t xZN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28702);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xZN == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(28702);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.pIy);
      paramVarArgs.aO(2, this.xZL);
      paramVarArgs.aO(3, this.xZM);
      if (this.xZN != null)
      {
        paramVarArgs.iQ(4, this.xZN.computeSize());
        this.xZN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28702);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.pIy) + 0 + e.a.a.b.b.a.bl(2, this.xZL) + e.a.a.b.b.a.bl(3, this.xZM);
      paramInt = i;
      if (this.xZN != null) {
        paramInt = i + e.a.a.a.iP(4, this.xZN.computeSize());
      }
      AppMethodBeat.o(28702);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xZN == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(28702);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28702);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cre localcre = (cre)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28702);
        return -1;
      case 1: 
        localcre.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28702);
        return 0;
      case 2: 
        localcre.xZL = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28702);
        return 0;
      case 3: 
        localcre.xZM = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28702);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localcre.xZN = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(28702);
      return 0;
    }
    AppMethodBeat.o(28702);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cre
 * JD-Core Version:    0.7.0.1
 */