package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ss
  extends cpx
{
  public int EgR;
  public b EmP;
  public b EmQ;
  public String oxD;
  public int uiK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.uiK);
      if (this.EmP != null) {
        paramVarArgs.c(3, this.EmP);
      }
      if (this.EmQ != null) {
        paramVarArgs.c(4, this.EmQ);
      }
      if (this.oxD != null) {
        paramVarArgs.d(5, this.oxD);
      }
      paramVarArgs.aR(6, this.EgR);
      AppMethodBeat.o(91408);
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
      int i = paramInt + f.a.a.b.b.a.bx(2, this.uiK);
      paramInt = i;
      if (this.EmP != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.EmP);
      }
      i = paramInt;
      if (this.EmQ != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.EmQ);
      }
      paramInt = i;
      if (this.oxD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.oxD);
      }
      i = f.a.a.b.b.a.bx(6, this.EgR);
      AppMethodBeat.o(91408);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ss localss = (ss)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91408);
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
            localss.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91408);
          return 0;
        case 2: 
          localss.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91408);
          return 0;
        case 3: 
          localss.EmP = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(91408);
          return 0;
        case 4: 
          localss.EmQ = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(91408);
          return 0;
        case 5: 
          localss.oxD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91408);
          return 0;
        }
        localss.EgR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91408);
        return 0;
      }
      AppMethodBeat.o(91408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ss
 * JD-Core Version:    0.7.0.1
 */