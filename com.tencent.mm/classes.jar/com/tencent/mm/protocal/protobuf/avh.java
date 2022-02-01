package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avh
  extends cvp
{
  public int FCF;
  public LinkedList<com.tencent.mm.bx.b> GtC;
  public LinkedList<Integer> GtN;
  public LinkedList<avg> GtO;
  public LinkedList<avb> GtP;
  
  public avh()
  {
    AppMethodBeat.i(152550);
    this.GtN = new LinkedList();
    this.GtO = new LinkedList();
    this.GtP = new LinkedList();
    this.GtC = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FCF);
      paramVarArgs.e(3, 2, this.GtN);
      paramVarArgs.e(4, 8, this.GtO);
      paramVarArgs.e(5, 8, this.GtP);
      paramVarArgs.e(7, 6, this.GtC);
      AppMethodBeat.o(152551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label817;
      }
    }
    label817:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FCF);
      int j = f.a.a.a.c(3, 2, this.GtN);
      int k = f.a.a.a.c(4, 8, this.GtO);
      int m = f.a.a.a.c(5, 8, this.GtP);
      int n = f.a.a.a.c(7, 6, this.GtC);
      AppMethodBeat.o(152551);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GtN.clear();
        this.GtO.clear();
        this.GtP.clear();
        this.GtC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        avh localavh = (avh)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 2: 
          localavh.FCF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152551);
          return 0;
        case 3: 
          localavh.GtN.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(152551);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavh.GtO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavh.GtP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        }
        localavh.GtC.add(((f.a.a.a.a)localObject1).NPN.gxI());
        AppMethodBeat.o(152551);
        return 0;
      }
      AppMethodBeat.o(152551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avh
 * JD-Core Version:    0.7.0.1
 */