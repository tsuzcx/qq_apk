package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dqx
  extends cqk
{
  public int Exf;
  public long Exg;
  public int FYg;
  public int FYp;
  public dsm FYq;
  public int FYr;
  public int FYs;
  public int FYt;
  public int FYu;
  public SKBuiltinBuffer_t FYv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115859);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115859);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Exf);
      paramVarArgs.aO(3, this.Exg);
      paramVarArgs.aR(4, this.FYp);
      if (this.FYq != null)
      {
        paramVarArgs.ln(5, this.FYq.computeSize());
        this.FYq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.FYg);
      paramVarArgs.aR(7, this.FYr);
      paramVarArgs.aR(8, this.FYs);
      paramVarArgs.aR(9, this.FYt);
      paramVarArgs.aR(10, this.FYu);
      if (this.FYv != null)
      {
        paramVarArgs.ln(11, this.FYv.computeSize());
        this.FYv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1018;
      }
    }
    label1018:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Exf) + f.a.a.b.b.a.p(3, this.Exg) + f.a.a.b.b.a.bx(4, this.FYp);
      paramInt = i;
      if (this.FYq != null) {
        paramInt = i + f.a.a.a.lm(5, this.FYq.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.FYg) + f.a.a.b.b.a.bx(7, this.FYr) + f.a.a.b.b.a.bx(8, this.FYs) + f.a.a.b.b.a.bx(9, this.FYt) + f.a.a.b.b.a.bx(10, this.FYu);
      paramInt = i;
      if (this.FYv != null) {
        paramInt = i + f.a.a.a.lm(11, this.FYv.computeSize());
      }
      AppMethodBeat.o(115859);
      return paramInt;
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
          AppMethodBeat.o(115859);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqx localdqx = (dqx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115859);
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
            localdqx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 2: 
          localdqx.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115859);
          return 0;
        case 3: 
          localdqx.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115859);
          return 0;
        case 4: 
          localdqx.FYp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115859);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dsm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dsm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqx.FYq = ((dsm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 6: 
          localdqx.FYg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115859);
          return 0;
        case 7: 
          localdqx.FYr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115859);
          return 0;
        case 8: 
          localdqx.FYs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115859);
          return 0;
        case 9: 
          localdqx.FYt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115859);
          return 0;
        case 10: 
          localdqx.FYu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115859);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqx.FYv = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      AppMethodBeat.o(115859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqx
 * JD-Core Version:    0.7.0.1
 */