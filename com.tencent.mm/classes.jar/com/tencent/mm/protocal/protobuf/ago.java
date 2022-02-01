package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ago
  extends cpx
{
  public long EyA;
  public String EyB;
  public String EyI;
  public int dbL;
  public String djj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104365);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.EyA);
      if (this.EyI != null) {
        paramVarArgs.d(3, this.EyI);
      }
      if (this.djj != null) {
        paramVarArgs.d(4, this.djj);
      }
      if (this.EyB != null) {
        paramVarArgs.d(5, this.EyB);
      }
      paramVarArgs.aR(6, this.dbL);
      AppMethodBeat.o(104365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.EyA);
      paramInt = i;
      if (this.EyI != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EyI);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.djj);
      }
      paramInt = i;
      if (this.EyB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EyB);
      }
      i = f.a.a.b.b.a.bx(6, this.dbL);
      AppMethodBeat.o(104365);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ago localago = (ago)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104365);
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
            localago.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104365);
          return 0;
        case 2: 
          localago.EyA = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(104365);
          return 0;
        case 3: 
          localago.EyI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104365);
          return 0;
        case 4: 
          localago.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104365);
          return 0;
        case 5: 
          localago.EyB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104365);
          return 0;
        }
        localago.dbL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104365);
        return 0;
      }
      AppMethodBeat.o(104365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ago
 * JD-Core Version:    0.7.0.1
 */