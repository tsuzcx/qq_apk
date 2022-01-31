package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpd
  extends buy
{
  public int wOS;
  public String xvQ;
  public int xvR;
  public LinkedList<String> xvS;
  
  public bpd()
  {
    AppMethodBeat.i(10228);
    this.xvS = new LinkedList();
    AppMethodBeat.o(10228);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10229);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xvQ != null) {
        paramVarArgs.e(2, this.xvQ);
      }
      paramVarArgs.aO(3, this.xvR);
      paramVarArgs.e(4, 1, this.xvS);
      paramVarArgs.aO(5, this.wOS);
      AppMethodBeat.o(10229);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label533;
      }
    }
    label533:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xvQ != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xvQ);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xvR);
      int j = e.a.a.a.c(4, 1, this.xvS);
      int k = e.a.a.b.b.a.bl(5, this.wOS);
      AppMethodBeat.o(10229);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xvS.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10229);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bpd localbpd = (bpd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10229);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpd.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10229);
          return 0;
        case 2: 
          localbpd.xvQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10229);
          return 0;
        case 3: 
          localbpd.xvR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(10229);
          return 0;
        case 4: 
          localbpd.xvS.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(10229);
          return 0;
        }
        localbpd.wOS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(10229);
        return 0;
      }
      AppMethodBeat.o(10229);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpd
 * JD-Core Version:    0.7.0.1
 */