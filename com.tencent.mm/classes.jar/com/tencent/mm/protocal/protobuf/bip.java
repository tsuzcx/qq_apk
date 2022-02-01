package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bip
  extends cpx
{
  public String owt;
  public String uhB;
  public String unZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91517);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uhB != null) {
        paramVarArgs.d(2, this.uhB);
      }
      if (this.owt != null) {
        paramVarArgs.d(3, this.owt);
      }
      if (this.unZ != null) {
        paramVarArgs.d(4, this.unZ);
      }
      AppMethodBeat.o(91517);
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
      if (this.uhB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uhB);
      }
      i = paramInt;
      if (this.owt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.owt);
      }
      paramInt = i;
      if (this.unZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.unZ);
      }
      AppMethodBeat.o(91517);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91517);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bip localbip = (bip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91517);
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
            localbip.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91517);
          return 0;
        case 2: 
          localbip.uhB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91517);
          return 0;
        case 3: 
          localbip.owt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91517);
          return 0;
        }
        localbip.unZ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91517);
        return 0;
      }
      AppMethodBeat.o(91517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bip
 * JD-Core Version:    0.7.0.1
 */