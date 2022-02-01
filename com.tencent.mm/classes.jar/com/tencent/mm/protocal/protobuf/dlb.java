package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dlb
  extends cqk
{
  public int FTQ;
  public gq FTR;
  public aw FTS;
  public bxm FTT;
  public hm FTU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133205);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FTQ);
      if (this.FTR != null)
      {
        paramVarArgs.ln(3, this.FTR.computeSize());
        this.FTR.writeFields(paramVarArgs);
      }
      if (this.FTS != null)
      {
        paramVarArgs.ln(4, this.FTS.computeSize());
        this.FTS.writeFields(paramVarArgs);
      }
      if (this.FTT != null)
      {
        paramVarArgs.ln(5, this.FTT.computeSize());
        this.FTT.writeFields(paramVarArgs);
      }
      if (this.FTU != null)
      {
        paramVarArgs.ln(6, this.FTU.computeSize());
        this.FTU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FTQ);
      paramInt = i;
      if (this.FTR != null) {
        paramInt = i + f.a.a.a.lm(3, this.FTR.computeSize());
      }
      i = paramInt;
      if (this.FTS != null) {
        i = paramInt + f.a.a.a.lm(4, this.FTS.computeSize());
      }
      paramInt = i;
      if (this.FTT != null) {
        paramInt = i + f.a.a.a.lm(5, this.FTT.computeSize());
      }
      i = paramInt;
      if (this.FTU != null) {
        i = paramInt + f.a.a.a.lm(6, this.FTU.computeSize());
      }
      AppMethodBeat.o(133205);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133205);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133205);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlb localdlb = (dlb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133205);
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
            localdlb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 2: 
          localdlb.FTQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133205);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlb.FTR = ((gq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlb.FTS = ((aw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlb.FTT = ((bxm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdlb.FTU = ((hm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133205);
        return 0;
      }
      AppMethodBeat.o(133205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlb
 * JD-Core Version:    0.7.0.1
 */