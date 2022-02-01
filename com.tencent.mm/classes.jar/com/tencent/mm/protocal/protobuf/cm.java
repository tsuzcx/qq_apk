package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cm
  extends cpx
{
  public int DLC;
  public String DLD;
  public String DPF;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32106);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DPF != null) {
        paramVarArgs.d(2, this.DPF);
      }
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aR(4, this.DLC);
      if (this.DLD != null) {
        paramVarArgs.d(5, this.DLD);
      }
      AppMethodBeat.o(32106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label545;
      }
    }
    label545:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DPF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DPF);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Url);
      }
      i += f.a.a.b.b.a.bx(4, this.DLC);
      paramInt = i;
      if (this.DLD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DLD);
      }
      AppMethodBeat.o(32106);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32106);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cm localcm = (cm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32106);
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
            localcm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32106);
          return 0;
        case 2: 
          localcm.DPF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32106);
          return 0;
        case 3: 
          localcm.Url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32106);
          return 0;
        case 4: 
          localcm.DLC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32106);
          return 0;
        }
        localcm.DLD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32106);
        return 0;
      }
      AppMethodBeat.o(32106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cm
 * JD-Core Version:    0.7.0.1
 */