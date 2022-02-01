package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aci
  extends cpx
{
  public int DOv;
  public String EuS;
  public int EuT;
  public int EuU;
  public int dbL;
  public String djj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147761);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      if (this.EuS != null) {
        paramVarArgs.d(3, this.EuS);
      }
      paramVarArgs.aR(4, this.EuT);
      paramVarArgs.aR(5, this.dbL);
      paramVarArgs.aR(6, this.EuU);
      paramVarArgs.aR(7, this.DOv);
      AppMethodBeat.o(147761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djj);
      }
      i = paramInt;
      if (this.EuS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EuS);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.EuT);
      int j = f.a.a.b.b.a.bx(5, this.dbL);
      int k = f.a.a.b.b.a.bx(6, this.EuU);
      int m = f.a.a.b.b.a.bx(7, this.DOv);
      AppMethodBeat.o(147761);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147761);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aci localaci = (aci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147761);
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
            localaci.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147761);
          return 0;
        case 2: 
          localaci.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147761);
          return 0;
        case 3: 
          localaci.EuS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147761);
          return 0;
        case 4: 
          localaci.EuT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(147761);
          return 0;
        case 5: 
          localaci.dbL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(147761);
          return 0;
        case 6: 
          localaci.EuU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(147761);
          return 0;
        }
        localaci.DOv = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(147761);
        return 0;
      }
      AppMethodBeat.o(147761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aci
 * JD-Core Version:    0.7.0.1
 */