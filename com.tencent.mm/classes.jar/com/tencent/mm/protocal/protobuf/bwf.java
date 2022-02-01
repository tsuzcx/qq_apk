package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwf
  extends cpx
{
  public String EPH;
  public String Eua;
  public long Eub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72517);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.Eub);
      if (this.Eua != null) {
        paramVarArgs.d(3, this.Eua);
      }
      if (this.EPH != null) {
        paramVarArgs.d(4, this.EPH);
      }
      AppMethodBeat.o(72517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Eub);
      paramInt = i;
      if (this.Eua != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Eua);
      }
      i = paramInt;
      if (this.EPH != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EPH);
      }
      AppMethodBeat.o(72517);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72517);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwf localbwf = (bwf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72517);
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
            localbwf.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72517);
          return 0;
        case 2: 
          localbwf.Eub = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(72517);
          return 0;
        case 3: 
          localbwf.Eua = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72517);
          return 0;
        }
        localbwf.EPH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72517);
        return 0;
      }
      AppMethodBeat.o(72517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwf
 * JD-Core Version:    0.7.0.1
 */