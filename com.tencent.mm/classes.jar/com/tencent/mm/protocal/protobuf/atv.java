package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class atv
  extends cld
{
  public LinkedList<ef> CAD;
  public int DtN;
  public int DtO;
  public LinkedList<Integer> DtP;
  public LinkedList<aef> DtQ;
  public int DtR;
  
  public atv()
  {
    AppMethodBeat.i(122505);
    this.DtP = new LinkedList();
    this.DtQ = new LinkedList();
    this.CAD = new LinkedList();
    AppMethodBeat.o(122505);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(122506);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DtN);
      paramVarArgs.aR(3, this.DtO);
      paramVarArgs.e(4, 2, this.DtP);
      paramVarArgs.e(5, 8, this.DtQ);
      paramVarArgs.aR(6, this.DtR);
      paramVarArgs.e(7, 8, this.CAD);
      AppMethodBeat.o(122506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label845;
      }
    }
    label845:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DtN);
      int j = f.a.a.b.b.a.bA(3, this.DtO);
      int k = f.a.a.a.c(4, 2, this.DtP);
      int m = f.a.a.a.c(5, 8, this.DtQ);
      int n = f.a.a.b.b.a.bA(6, this.DtR);
      int i1 = f.a.a.a.c(7, 8, this.CAD);
      AppMethodBeat.o(122506);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DtP.clear();
        this.DtQ.clear();
        this.CAD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(122506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atv localatv = (atv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122506);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 2: 
          localatv.DtN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122506);
          return 0;
        case 3: 
          localatv.DtO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122506);
          return 0;
        case 4: 
          localatv.DtP.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(122506);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aef();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aef)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localatv.DtQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 6: 
          localatv.DtR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122506);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ef();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ef)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localatv.CAD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      AppMethodBeat.o(122506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atv
 * JD-Core Version:    0.7.0.1
 */