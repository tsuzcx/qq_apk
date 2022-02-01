package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avx
  extends cwj
{
  public int FVa;
  public LinkedList<com.tencent.mm.bw.b> GNb;
  public LinkedList<Integer> GNm;
  public LinkedList<avw> GNn;
  public LinkedList<avr> GNo;
  
  public avx()
  {
    AppMethodBeat.i(152550);
    this.GNm = new LinkedList();
    this.GNn = new LinkedList();
    this.GNo = new LinkedList();
    this.GNb = new LinkedList();
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
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FVa);
      paramVarArgs.e(3, 2, this.GNm);
      paramVarArgs.e(4, 8, this.GNn);
      paramVarArgs.e(5, 8, this.GNo);
      paramVarArgs.e(7, 6, this.GNb);
      AppMethodBeat.o(152551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label817;
      }
    }
    label817:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FVa);
      int j = f.a.a.a.c(3, 2, this.GNm);
      int k = f.a.a.a.c(4, 8, this.GNn);
      int m = f.a.a.a.c(5, 8, this.GNo);
      int n = f.a.a.a.c(7, 6, this.GNb);
      AppMethodBeat.o(152551);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GNm.clear();
        this.GNn.clear();
        this.GNo.clear();
        this.GNb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        avx localavx = (avx)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 2: 
          localavx.FVa = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152551);
          return 0;
        case 3: 
          localavx.GNm.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(152551);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavx.GNn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavx.GNo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        }
        localavx.GNb.add(((f.a.a.a.a)localObject1).OmT.gCk());
        AppMethodBeat.o(152551);
        return 0;
      }
      AppMethodBeat.o(152551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avx
 * JD-Core Version:    0.7.0.1
 */