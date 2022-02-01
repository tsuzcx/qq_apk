package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuq
  extends cpx
{
  public String DRb;
  public String FFU;
  public String FFV;
  public String Fwn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198622);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fwn != null) {
        paramVarArgs.d(2, this.Fwn);
      }
      if (this.FFU != null) {
        paramVarArgs.d(3, this.FFU);
      }
      if (this.FFV != null) {
        paramVarArgs.d(4, this.FFV);
      }
      if (this.DRb != null) {
        paramVarArgs.d(5, this.DRb);
      }
      AppMethodBeat.o(198622);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fwn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fwn);
      }
      i = paramInt;
      if (this.FFU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FFU);
      }
      paramInt = i;
      if (this.FFV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FFV);
      }
      i = paramInt;
      if (this.DRb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DRb);
      }
      AppMethodBeat.o(198622);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(198622);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cuq localcuq = (cuq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198622);
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
            localcuq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(198622);
          return 0;
        case 2: 
          localcuq.Fwn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(198622);
          return 0;
        case 3: 
          localcuq.FFU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(198622);
          return 0;
        case 4: 
          localcuq.FFV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(198622);
          return 0;
        }
        localcuq.DRb = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(198622);
        return 0;
      }
      AppMethodBeat.o(198622);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuq
 * JD-Core Version:    0.7.0.1
 */