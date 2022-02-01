package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ts
  extends cqk
{
  public String EnI;
  public boolean EnJ;
  public int dae;
  public String oxf;
  public int wLy;
  public String wSM;
  public String wSN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72449);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72449);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      if (this.EnI != null) {
        paramVarArgs.d(4, this.EnI);
      }
      if (this.wSM != null) {
        paramVarArgs.d(5, this.wSM);
      }
      paramVarArgs.bl(6, this.EnJ);
      if (this.wSN != null) {
        paramVarArgs.d(7, this.wSN);
      }
      paramVarArgs.aR(8, this.wLy);
      AppMethodBeat.o(72449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.EnI != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EnI);
      }
      paramInt = i;
      if (this.wSM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wSM);
      }
      i = paramInt + (f.a.a.b.b.a.fK(6) + 1);
      paramInt = i;
      if (this.wSN != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wSN);
      }
      i = f.a.a.b.b.a.bx(8, this.wLy);
      AppMethodBeat.o(72449);
      return paramInt + i;
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
          AppMethodBeat.o(72449);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ts localts = (ts)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72449);
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
            localts.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72449);
          return 0;
        case 2: 
          localts.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72449);
          return 0;
        case 3: 
          localts.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 4: 
          localts.EnI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 5: 
          localts.wSM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 6: 
          localts.EnJ = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(72449);
          return 0;
        case 7: 
          localts.wSN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72449);
          return 0;
        }
        localts.wLy = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(72449);
        return 0;
      }
      AppMethodBeat.o(72449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ts
 * JD-Core Version:    0.7.0.1
 */