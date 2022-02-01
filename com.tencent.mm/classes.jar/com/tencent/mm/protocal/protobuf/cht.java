package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cht
  extends cpx
{
  public String FvU;
  public String FvV;
  public String FvW;
  public String FvX;
  public String FvY;
  public int FvZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32374);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FvU != null) {
        paramVarArgs.d(2, this.FvU);
      }
      if (this.FvV != null) {
        paramVarArgs.d(3, this.FvV);
      }
      if (this.FvW != null) {
        paramVarArgs.d(4, this.FvW);
      }
      if (this.FvX != null) {
        paramVarArgs.d(5, this.FvX);
      }
      if (this.FvY != null) {
        paramVarArgs.d(6, this.FvY);
      }
      paramVarArgs.aR(7, this.FvZ);
      AppMethodBeat.o(32374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label671;
      }
    }
    label671:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FvU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FvU);
      }
      i = paramInt;
      if (this.FvV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FvV);
      }
      paramInt = i;
      if (this.FvW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FvW);
      }
      i = paramInt;
      if (this.FvX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FvX);
      }
      paramInt = i;
      if (this.FvY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FvY);
      }
      i = f.a.a.b.b.a.bx(7, this.FvZ);
      AppMethodBeat.o(32374);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cht localcht = (cht)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32374);
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
            localcht.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32374);
          return 0;
        case 2: 
          localcht.FvU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 3: 
          localcht.FvV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 4: 
          localcht.FvW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 5: 
          localcht.FvX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 6: 
          localcht.FvY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32374);
          return 0;
        }
        localcht.FvZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32374);
        return 0;
      }
      AppMethodBeat.o(32374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cht
 * JD-Core Version:    0.7.0.1
 */