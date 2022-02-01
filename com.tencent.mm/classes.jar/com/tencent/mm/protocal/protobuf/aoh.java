package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoh
  extends cld
{
  public int CEJ;
  public LinkedList<Integer> DpH;
  public LinkedList<aog> DpI;
  public LinkedList<aob> DpJ;
  public LinkedList<com.tencent.mm.bx.b> Dpz;
  
  public aoh()
  {
    AppMethodBeat.i(152550);
    this.DpH = new LinkedList();
    this.DpI = new LinkedList();
    this.DpJ = new LinkedList();
    this.Dpz = new LinkedList();
    AppMethodBeat.o(152550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152551);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152551);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CEJ);
      paramVarArgs.e(3, 2, this.DpH);
      paramVarArgs.e(4, 8, this.DpI);
      paramVarArgs.e(5, 8, this.DpJ);
      paramVarArgs.e(7, 6, this.Dpz);
      AppMethodBeat.o(152551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label817;
      }
    }
    label817:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.CEJ);
      int j = f.a.a.a.c(3, 2, this.DpH);
      int k = f.a.a.a.c(4, 8, this.DpI);
      int m = f.a.a.a.c(5, 8, this.DpJ);
      int n = f.a.a.a.c(7, 6, this.Dpz);
      AppMethodBeat.o(152551);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DpH.clear();
        this.DpI.clear();
        this.DpJ.clear();
        this.Dpz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152551);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoh localaoh = (aoh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(152551);
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
            localaoh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 2: 
          localaoh.CEJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152551);
          return 0;
        case 3: 
          localaoh.DpH.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(152551);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aog();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aog)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoh.DpI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aob();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoh.DpJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        }
        localaoh.Dpz.add(((f.a.a.a.a)localObject1).KhF.fMu());
        AppMethodBeat.o(152551);
        return 0;
      }
      AppMethodBeat.o(152551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoh
 * JD-Core Version:    0.7.0.1
 */