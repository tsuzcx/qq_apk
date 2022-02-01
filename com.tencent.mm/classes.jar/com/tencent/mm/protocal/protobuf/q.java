package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class q
  extends cpx
{
  public String DKA;
  public String DKB;
  public long DKR;
  public String DKS;
  public int scene;
  public String wLA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91328);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DKA != null) {
        paramVarArgs.d(2, this.DKA);
      }
      paramVarArgs.aO(3, this.DKR);
      paramVarArgs.aR(4, this.scene);
      if (this.DKB != null) {
        paramVarArgs.d(5, this.DKB);
      }
      if (this.DKS != null) {
        paramVarArgs.d(6, this.DKS);
      }
      if (this.wLA != null) {
        paramVarArgs.d(7, this.wLA);
      }
      AppMethodBeat.o(91328);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DKA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DKA);
      }
      i = i + f.a.a.b.b.a.p(3, this.DKR) + f.a.a.b.b.a.bx(4, this.scene);
      paramInt = i;
      if (this.DKB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DKB);
      }
      i = paramInt;
      if (this.DKS != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DKS);
      }
      paramInt = i;
      if (this.wLA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wLA);
      }
      AppMethodBeat.o(91328);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91328);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91328);
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
            localq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91328);
          return 0;
        case 2: 
          localq.DKA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91328);
          return 0;
        case 3: 
          localq.DKR = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91328);
          return 0;
        case 4: 
          localq.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91328);
          return 0;
        case 5: 
          localq.DKB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91328);
          return 0;
        case 6: 
          localq.DKS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91328);
          return 0;
        }
        localq.wLA = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91328);
        return 0;
      }
      AppMethodBeat.o(91328);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.q
 * JD-Core Version:    0.7.0.1
 */