package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csf
  extends bvk
{
  public long wQQ;
  public long xSP;
  public int yaP;
  public int yaQ;
  public int yaR;
  public int yaS;
  public com.tencent.mm.bv.b yaT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135459);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(135459);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.am(2, this.xSP);
      paramVarArgs.am(3, this.wQQ);
      paramVarArgs.aO(4, this.yaP);
      paramVarArgs.aO(5, this.yaQ);
      paramVarArgs.aO(6, this.yaR);
      paramVarArgs.aO(7, this.yaS);
      if (this.yaT != null) {
        paramVarArgs.c(8, this.yaT);
      }
      AppMethodBeat.o(135459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.xSP) + e.a.a.b.b.a.p(3, this.wQQ) + e.a.a.b.b.a.bl(4, this.yaP) + e.a.a.b.b.a.bl(5, this.yaQ) + e.a.a.b.b.a.bl(6, this.yaR) + e.a.a.b.b.a.bl(7, this.yaS);
      paramInt = i;
      if (this.yaT != null) {
        paramInt = i + e.a.a.b.b.a.b(8, this.yaT);
      }
      AppMethodBeat.o(135459);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(135459);
          throw paramVarArgs;
        }
        AppMethodBeat.o(135459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        csf localcsf = (csf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(135459);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(135459);
          return 0;
        case 2: 
          localcsf.xSP = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(135459);
          return 0;
        case 3: 
          localcsf.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(135459);
          return 0;
        case 4: 
          localcsf.yaP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135459);
          return 0;
        case 5: 
          localcsf.yaQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135459);
          return 0;
        case 6: 
          localcsf.yaR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135459);
          return 0;
        case 7: 
          localcsf.yaS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135459);
          return 0;
        }
        localcsf.yaT = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(135459);
        return 0;
      }
      AppMethodBeat.o(135459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csf
 * JD-Core Version:    0.7.0.1
 */