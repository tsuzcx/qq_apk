package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cfz
  extends com.tencent.mm.bv.a
{
  public int xQI;
  public int xQJ;
  public int xQK;
  public int xQd;
  public crm xQe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5223);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xQe == null)
      {
        paramVarArgs = new b("Not all required fields were included: Addr");
        AppMethodBeat.o(5223);
        throw paramVarArgs;
      }
      if (this.xQe != null)
      {
        paramVarArgs.iQ(1, this.xQe.computeSize());
        this.xQe.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xQd);
      paramVarArgs.aO(3, this.xQI);
      paramVarArgs.aO(4, this.xQJ);
      paramVarArgs.aO(5, this.xQK);
      AppMethodBeat.o(5223);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xQe == null) {
        break label553;
      }
    }
    label553:
    for (paramInt = e.a.a.a.iP(1, this.xQe.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xQd);
      int j = e.a.a.b.b.a.bl(3, this.xQI);
      int k = e.a.a.b.b.a.bl(4, this.xQJ);
      int m = e.a.a.b.b.a.bl(5, this.xQK);
      AppMethodBeat.o(5223);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xQe == null)
        {
          paramVarArgs = new b("Not all required fields were included: Addr");
          AppMethodBeat.o(5223);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5223);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cfz localcfz = (cfz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5223);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfz.xQe = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5223);
          return 0;
        case 2: 
          localcfz.xQd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5223);
          return 0;
        case 3: 
          localcfz.xQI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5223);
          return 0;
        case 4: 
          localcfz.xQJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5223);
          return 0;
        }
        localcfz.xQK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5223);
        return 0;
      }
      AppMethodBeat.o(5223);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfz
 * JD-Core Version:    0.7.0.1
 */