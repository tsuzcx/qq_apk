package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class or
  extends cpx
{
  public String DQs;
  public String DQt;
  public String DQu;
  public int DQw;
  public b EeD;
  public String wLu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91365);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DQs != null) {
        paramVarArgs.d(2, this.DQs);
      }
      if (this.DQt != null) {
        paramVarArgs.d(3, this.DQt);
      }
      if (this.wLu != null) {
        paramVarArgs.d(4, this.wLu);
      }
      paramVarArgs.aR(5, this.DQw);
      if (this.EeD != null) {
        paramVarArgs.c(6, this.EeD);
      }
      if (this.DQu != null) {
        paramVarArgs.d(7, this.DQu);
      }
      AppMethodBeat.o(91365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DQs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DQs);
      }
      i = paramInt;
      if (this.DQt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DQt);
      }
      paramInt = i;
      if (this.wLu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wLu);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.DQw);
      paramInt = i;
      if (this.EeD != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.EeD);
      }
      i = paramInt;
      if (this.DQu != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DQu);
      }
      AppMethodBeat.o(91365);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        or localor = (or)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91365);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localor.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91365);
          return 0;
        case 2: 
          localor.DQs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 3: 
          localor.DQt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 4: 
          localor.wLu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 5: 
          localor.DQw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91365);
          return 0;
        case 6: 
          localor.EeD = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(91365);
          return 0;
        }
        localor.DQu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91365);
        return 0;
      }
      AppMethodBeat.o(91365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.or
 * JD-Core Version:    0.7.0.1
 */