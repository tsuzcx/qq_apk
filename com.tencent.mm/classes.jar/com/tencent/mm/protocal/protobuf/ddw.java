package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ddw
  extends cqk
{
  public int DLH;
  public String FJm;
  public int FKH;
  public LinkedList<ddu> FNA;
  public long FNn;
  public int FNz;
  
  public ddw()
  {
    AppMethodBeat.i(118450);
    this.FNA = new LinkedList();
    AppMethodBeat.o(118450);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118451);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FJm != null) {
        paramVarArgs.d(2, this.FJm);
      }
      paramVarArgs.aR(3, this.FNz);
      paramVarArgs.e(4, 8, this.FNA);
      paramVarArgs.aR(5, this.FKH);
      paramVarArgs.aO(6, this.FNn);
      paramVarArgs.aR(7, this.DLH);
      AppMethodBeat.o(118451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FJm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FJm);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FNz);
      int j = f.a.a.a.c(4, 8, this.FNA);
      int k = f.a.a.b.b.a.bx(5, this.FKH);
      int m = f.a.a.b.b.a.p(6, this.FNn);
      int n = f.a.a.b.b.a.bx(7, this.DLH);
      AppMethodBeat.o(118451);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FNA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118451);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddw localddw = (ddw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118451);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 2: 
          localddw.FJm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118451);
          return 0;
        case 3: 
          localddw.FNz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118451);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddw.FNA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 5: 
          localddw.FKH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118451);
          return 0;
        case 6: 
          localddw.FNn = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(118451);
          return 0;
        }
        localddw.DLH = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118451);
        return 0;
      }
      AppMethodBeat.o(118451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddw
 * JD-Core Version:    0.7.0.1
 */