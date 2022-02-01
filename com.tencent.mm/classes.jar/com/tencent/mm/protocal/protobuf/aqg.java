package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqg
  extends cld
{
  public long Drr;
  public com.tencent.mm.bx.b Drs;
  public bsv Drt;
  public lh Dru;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104368);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104368);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.Drr);
      if (this.Drs != null) {
        paramVarArgs.c(3, this.Drs);
      }
      if (this.Drt != null)
      {
        paramVarArgs.kX(4, this.Drt.computeSize());
        this.Drt.writeFields(paramVarArgs);
      }
      if (this.Dru != null)
      {
        paramVarArgs.kX(5, this.Dru.computeSize());
        this.Dru.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104368);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.Drr);
      paramInt = i;
      if (this.Drs != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Drs);
      }
      i = paramInt;
      if (this.Drt != null) {
        i = paramInt + f.a.a.a.kW(4, this.Drt.computeSize());
      }
      paramInt = i;
      if (this.Dru != null) {
        paramInt = i + f.a.a.a.kW(5, this.Dru.computeSize());
      }
      AppMethodBeat.o(104368);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104368);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104368);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqg localaqg = (aqg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104368);
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
            localaqg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        case 2: 
          localaqg.Drr = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(104368);
          return 0;
        case 3: 
          localaqg.Drs = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(104368);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqg.Drt = ((bsv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((lh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaqg.Dru = ((lh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104368);
        return 0;
      }
      AppMethodBeat.o(104368);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqg
 * JD-Core Version:    0.7.0.1
 */