package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asl
  extends cld
{
  public LinkedList<ob> CAD;
  public int CBp;
  public int CNq;
  public int CNt;
  public long Dql;
  public int DsD;
  
  public asl()
  {
    AppMethodBeat.i(117869);
    this.CAD = new LinkedList();
    AppMethodBeat.o(117869);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117870);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.CAD);
      paramVarArgs.aR(3, this.CNq);
      paramVarArgs.aR(4, this.DsD);
      paramVarArgs.aR(5, this.CBp);
      paramVarArgs.aG(6, this.Dql);
      paramVarArgs.aR(7, this.CNt);
      AppMethodBeat.o(117870);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.CAD);
      int j = f.a.a.b.b.a.bA(3, this.CNq);
      int k = f.a.a.b.b.a.bA(4, this.DsD);
      int m = f.a.a.b.b.a.bA(5, this.CBp);
      int n = f.a.a.b.b.a.q(6, this.Dql);
      int i1 = f.a.a.b.b.a.bA(7, this.CNt);
      AppMethodBeat.o(117870);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CAD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117870);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asl localasl = (asl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117870);
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
            localasl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ob();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasl.CAD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 3: 
          localasl.CNq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117870);
          return 0;
        case 4: 
          localasl.DsD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117870);
          return 0;
        case 5: 
          localasl.CBp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117870);
          return 0;
        case 6: 
          localasl.Dql = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(117870);
          return 0;
        }
        localasl.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117870);
        return 0;
      }
      AppMethodBeat.o(117870);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asl
 * JD-Core Version:    0.7.0.1
 */