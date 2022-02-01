package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arq
  extends cqk
{
  public LinkedList<com.tencent.mm.bw.b> ELr;
  public int ELs;
  public LinkedList<Integer> ELt;
  public int Timestamp;
  
  public arq()
  {
    AppMethodBeat.i(153147);
    this.ELr = new LinkedList();
    this.ELt = new LinkedList();
    AppMethodBeat.o(153147);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153148);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153148);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 6, this.ELr);
      paramVarArgs.aR(3, this.ELs);
      paramVarArgs.aR(4, this.Timestamp);
      paramVarArgs.e(5, 2, this.ELt);
      AppMethodBeat.o(153148);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label573;
      }
    }
    label573:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 6, this.ELr);
      int j = f.a.a.b.b.a.bx(3, this.ELs);
      int k = f.a.a.b.b.a.bx(4, this.Timestamp);
      int m = f.a.a.a.c(5, 2, this.ELt);
      AppMethodBeat.o(153148);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ELr.clear();
        this.ELt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153148);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153148);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arq localarq = (arq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153148);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153148);
          return 0;
        case 2: 
          localarq.ELr.add(((f.a.a.a.a)localObject1).LVo.gfk());
          AppMethodBeat.o(153148);
          return 0;
        case 3: 
          localarq.ELs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153148);
          return 0;
        case 4: 
          localarq.Timestamp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153148);
          return 0;
        }
        localarq.ELt.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
        AppMethodBeat.o(153148);
        return 0;
      }
      AppMethodBeat.o(153148);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arq
 * JD-Core Version:    0.7.0.1
 */