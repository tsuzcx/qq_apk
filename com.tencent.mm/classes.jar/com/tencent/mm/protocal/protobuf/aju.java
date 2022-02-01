package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aju
  extends cpx
{
  public aiu EDu;
  public int dtJ;
  public String objectNonceId;
  public long qIs;
  public long qXP;
  public String rfC;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195061);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EDu != null)
      {
        paramVarArgs.ln(2, this.EDu.computeSize());
        this.EDu.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.qXP);
      paramVarArgs.aR(4, this.dtJ);
      if (this.objectNonceId != null) {
        paramVarArgs.d(5, this.objectNonceId);
      }
      paramVarArgs.aO(6, this.qIs);
      if (this.rfC != null) {
        paramVarArgs.d(7, this.rfC);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(8, this.sessionBuffer);
      }
      AppMethodBeat.o(195061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EDu != null) {
        i = paramInt + f.a.a.a.lm(2, this.EDu.computeSize());
      }
      i = i + f.a.a.b.b.a.p(3, this.qXP) + f.a.a.b.b.a.bx(4, this.dtJ);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.objectNonceId);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.qIs);
      paramInt = i;
      if (this.rfC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.rfC);
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.sessionBuffer);
      }
      AppMethodBeat.o(195061);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aju localaju = (aju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195061);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaju.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195061);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaju.EDu = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195061);
          return 0;
        case 3: 
          localaju.qXP = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(195061);
          return 0;
        case 4: 
          localaju.dtJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195061);
          return 0;
        case 5: 
          localaju.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195061);
          return 0;
        case 6: 
          localaju.qIs = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(195061);
          return 0;
        case 7: 
          localaju.rfC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195061);
          return 0;
        }
        localaju.sessionBuffer = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(195061);
        return 0;
      }
      AppMethodBeat.o(195061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aju
 * JD-Core Version:    0.7.0.1
 */