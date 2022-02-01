package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tw
  extends cpx
{
  public String DOK;
  public String EnV;
  public boolean EnW;
  public int EnX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DOK != null) {
        paramVarArgs.d(2, this.DOK);
      }
      if (this.EnV != null) {
        paramVarArgs.d(3, this.EnV);
      }
      paramVarArgs.bl(4, this.EnW);
      paramVarArgs.aR(5, this.EnX);
      AppMethodBeat.o(125716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DOK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DOK);
      }
      i = paramInt;
      if (this.EnV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EnV);
      }
      paramInt = f.a.a.b.b.a.fK(4);
      int j = f.a.a.b.b.a.bx(5, this.EnX);
      AppMethodBeat.o(125716);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125716);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tw localtw = (tw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125716);
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
            localtw.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125716);
          return 0;
        case 2: 
          localtw.DOK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125716);
          return 0;
        case 3: 
          localtw.EnV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125716);
          return 0;
        case 4: 
          localtw.EnW = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(125716);
          return 0;
        }
        localtw.EnX = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125716);
        return 0;
      }
      AppMethodBeat.o(125716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tw
 * JD-Core Version:    0.7.0.1
 */