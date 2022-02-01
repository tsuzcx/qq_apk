package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class azd
  extends cpx
{
  public long DMV;
  public String DMW;
  public b EQB;
  public boolean EQC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190860);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EQB != null) {
        paramVarArgs.c(2, this.EQB);
      }
      paramVarArgs.aO(3, this.DMV);
      if (this.DMW != null) {
        paramVarArgs.d(4, this.DMW);
      }
      paramVarArgs.bl(5, this.EQC);
      AppMethodBeat.o(190860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EQB != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.EQB);
      }
      i += f.a.a.b.b.a.p(3, this.DMV);
      paramInt = i;
      if (this.DMW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DMW);
      }
      i = f.a.a.b.b.a.fK(5);
      AppMethodBeat.o(190860);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(190860);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azd localazd = (azd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190860);
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
            localazd.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190860);
          return 0;
        case 2: 
          localazd.EQB = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(190860);
          return 0;
        case 3: 
          localazd.DMV = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(190860);
          return 0;
        case 4: 
          localazd.DMW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(190860);
          return 0;
        }
        localazd.EQC = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(190860);
        return 0;
      }
      AppMethodBeat.o(190860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azd
 * JD-Core Version:    0.7.0.1
 */