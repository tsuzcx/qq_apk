package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dg
  extends com.tencent.mm.bx.a
{
  public cud CxS;
  public cmf CxT;
  public int CxU;
  public ciu CxV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125705);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CxS == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsADObject");
        AppMethodBeat.o(125705);
        throw paramVarArgs;
      }
      if (this.CxS != null)
      {
        paramVarArgs.kX(1, this.CxS.computeSize());
        this.CxS.writeFields(paramVarArgs);
      }
      if (this.CxT != null)
      {
        paramVarArgs.kX(2, this.CxT.computeSize());
        this.CxT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.CxU);
      if (this.CxV != null)
      {
        paramVarArgs.kX(4, this.CxV.computeSize());
        this.CxV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CxS == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = f.a.a.a.kW(1, this.CxS.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CxT != null) {
        i = paramInt + f.a.a.a.kW(2, this.CxT.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.CxU);
      paramInt = i;
      if (this.CxV != null) {
        paramInt = i + f.a.a.a.kW(4, this.CxV.computeSize());
      }
      AppMethodBeat.o(125705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CxS == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsADObject");
          AppMethodBeat.o(125705);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dg localdg = (dg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125705);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cud();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cud)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdg.CxS = ((cud)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdg.CxT = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 3: 
          localdg.CxU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125705);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ciu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ciu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdg.CxV = ((ciu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      AppMethodBeat.o(125705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dg
 * JD-Core Version:    0.7.0.1
 */