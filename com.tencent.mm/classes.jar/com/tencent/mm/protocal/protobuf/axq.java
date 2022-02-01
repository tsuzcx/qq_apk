package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axq
  extends cpx
{
  public String EPt;
  public String EPu;
  public String hOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125730);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      if (this.EPt != null) {
        paramVarArgs.d(3, this.EPt);
      }
      if (this.EPu != null) {
        paramVarArgs.d(4, this.EPu);
      }
      AppMethodBeat.o(125730);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt;
      if (this.EPt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EPt);
      }
      paramInt = i;
      if (this.EPu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EPu);
      }
      AppMethodBeat.o(125730);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125730);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axq localaxq = (axq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125730);
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
            localaxq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125730);
          return 0;
        case 2: 
          localaxq.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125730);
          return 0;
        case 3: 
          localaxq.EPt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125730);
          return 0;
        }
        localaxq.EPu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125730);
        return 0;
      }
      AppMethodBeat.o(125730);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axq
 * JD-Core Version:    0.7.0.1
 */