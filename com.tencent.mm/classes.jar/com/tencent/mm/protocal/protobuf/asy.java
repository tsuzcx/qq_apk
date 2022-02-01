package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class asy
  extends dpc
{
  public int KBv;
  public LinkedList<axa> LAj;
  public long LDN;
  public float LDT;
  public long LDU;
  public b LDs;
  public int tUC;
  
  public asy()
  {
    AppMethodBeat.i(209431);
    this.LAj = new LinkedList();
    AppMethodBeat.o(209431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209432);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KBv);
      paramVarArgs.E(3, this.LDT);
      if (this.LDs != null) {
        paramVarArgs.c(4, this.LDs);
      }
      paramVarArgs.aM(5, this.tUC);
      paramVarArgs.e(6, 8, this.LAj);
      paramVarArgs.bb(7, this.LDU);
      paramVarArgs.bb(8, this.LDN);
      AppMethodBeat.o(209432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label741;
      }
    }
    label741:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KBv) + (g.a.a.b.b.a.fS(3) + 4);
      paramInt = i;
      if (this.LDs != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.LDs);
      }
      i = g.a.a.b.b.a.bu(5, this.tUC);
      int j = g.a.a.a.c(6, 8, this.LAj);
      int k = g.a.a.b.b.a.r(7, this.LDU);
      int m = g.a.a.b.b.a.r(8, this.LDN);
      AppMethodBeat.o(209432);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LAj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        asy localasy = (asy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209432);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localasy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209432);
          return 0;
        case 2: 
          localasy.KBv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209432);
          return 0;
        case 3: 
          localasy.LDT = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209432);
          return 0;
        case 4: 
          localasy.LDs = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209432);
          return 0;
        case 5: 
          localasy.tUC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209432);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axa();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localasy.LAj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209432);
          return 0;
        case 7: 
          localasy.LDU = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209432);
          return 0;
        }
        localasy.LDN = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209432);
        return 0;
      }
      AppMethodBeat.o(209432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asy
 * JD-Core Version:    0.7.0.1
 */