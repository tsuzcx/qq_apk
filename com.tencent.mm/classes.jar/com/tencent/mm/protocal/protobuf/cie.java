package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cie
  extends cpx
{
  public int Exf;
  public long Exg;
  public long FvQ;
  public long FvT;
  public int ndj;
  public String tlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32388);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlK == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32388);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.tlK != null) {
        paramVarArgs.d(2, this.tlK);
      }
      paramVarArgs.aR(3, this.Exf);
      paramVarArgs.aO(4, this.Exg);
      paramVarArgs.aO(5, this.FvQ);
      paramVarArgs.aO(6, this.FvT);
      paramVarArgs.aR(7, this.ndj);
      AppMethodBeat.o(32388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label667;
      }
    }
    label667:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tlK != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.tlK);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Exf);
      int j = f.a.a.b.b.a.p(4, this.Exg);
      int k = f.a.a.b.b.a.p(5, this.FvQ);
      int m = f.a.a.b.b.a.p(6, this.FvT);
      int n = f.a.a.b.b.a.bx(7, this.ndj);
      AppMethodBeat.o(32388);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.tlK == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(32388);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32388);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cie localcie = (cie)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32388);
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
            localcie.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32388);
          return 0;
        case 2: 
          localcie.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32388);
          return 0;
        case 3: 
          localcie.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32388);
          return 0;
        case 4: 
          localcie.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32388);
          return 0;
        case 5: 
          localcie.FvQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32388);
          return 0;
        case 6: 
          localcie.FvT = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32388);
          return 0;
        }
        localcie.ndj = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32388);
        return 0;
      }
      AppMethodBeat.o(32388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cie
 * JD-Core Version:    0.7.0.1
 */