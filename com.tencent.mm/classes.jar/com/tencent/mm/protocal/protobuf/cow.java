package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cow
  extends cpx
{
  public int FBJ;
  public String dvO;
  public double latitude;
  public double longitude;
  public String nUr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114062);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.longitude);
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.aR(4, this.FBJ);
      if (this.nUr != null) {
        paramVarArgs.d(5, this.nUr);
      }
      if (this.dvO != null) {
        paramVarArgs.d(6, this.dvO);
      }
      AppMethodBeat.o(114062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label564;
      }
    }
    label564:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 8) + (f.a.a.b.b.a.fK(3) + 8) + f.a.a.b.b.a.bx(4, this.FBJ);
      paramInt = i;
      if (this.nUr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.nUr);
      }
      i = paramInt;
      if (this.dvO != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dvO);
      }
      AppMethodBeat.o(114062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114062);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cow localcow = (cow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114062);
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
            localcow.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114062);
          return 0;
        case 2: 
          localcow.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(114062);
          return 0;
        case 3: 
          localcow.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(114062);
          return 0;
        case 4: 
          localcow.FBJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114062);
          return 0;
        case 5: 
          localcow.nUr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114062);
          return 0;
        }
        localcow.dvO = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(114062);
        return 0;
      }
      AppMethodBeat.o(114062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cow
 * JD-Core Version:    0.7.0.1
 */