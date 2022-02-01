package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xl
  extends cpx
{
  public long DMV;
  public String DMW;
  public String DMX;
  public String DMY;
  public String ErH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190852);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.DMV);
      if (this.DMW != null) {
        paramVarArgs.d(3, this.DMW);
      }
      if (this.DMX != null) {
        paramVarArgs.d(4, this.DMX);
      }
      if (this.DMY != null) {
        paramVarArgs.d(5, this.DMY);
      }
      if (this.ErH != null) {
        paramVarArgs.d(6, this.ErH);
      }
      AppMethodBeat.o(190852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.DMV);
      paramInt = i;
      if (this.DMW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DMW);
      }
      i = paramInt;
      if (this.DMX != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DMX);
      }
      paramInt = i;
      if (this.DMY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DMY);
      }
      i = paramInt;
      if (this.ErH != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ErH);
      }
      AppMethodBeat.o(190852);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(190852);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xl localxl = (xl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190852);
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
            localxl.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190852);
          return 0;
        case 2: 
          localxl.DMV = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(190852);
          return 0;
        case 3: 
          localxl.DMW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(190852);
          return 0;
        case 4: 
          localxl.DMX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(190852);
          return 0;
        case 5: 
          localxl.DMY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(190852);
          return 0;
        }
        localxl.ErH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(190852);
        return 0;
      }
      AppMethodBeat.o(190852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xl
 * JD-Core Version:    0.7.0.1
 */