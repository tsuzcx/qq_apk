package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuc
  extends com.tencent.mm.bx.a
{
  public cmf ElK;
  public cmf ElM;
  public int ElN;
  public int rNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125764);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ElK != null)
      {
        paramVarArgs.kX(1, this.ElK.computeSize());
        this.ElK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.rNz);
      if (this.ElM != null)
      {
        paramVarArgs.kX(3, this.ElM.computeSize());
        this.ElM.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.ElN);
      AppMethodBeat.o(125764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ElK == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.kW(1, this.ElK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.rNz);
      paramInt = i;
      if (this.ElM != null) {
        paramInt = i + f.a.a.a.kW(3, this.ElM.computeSize());
      }
      i = f.a.a.b.b.a.bA(4, this.ElN);
      AppMethodBeat.o(125764);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cuc localcuc = (cuc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125764);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuc.ElK = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        case 2: 
          localcuc.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125764);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuc.ElM = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125764);
          return 0;
        }
        localcuc.ElN = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125764);
        return 0;
      }
      AppMethodBeat.o(125764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuc
 * JD-Core Version:    0.7.0.1
 */