package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayo
  extends cpx
{
  public String EOI;
  public int EPT;
  public String xID;
  public int yiF;
  public long yiH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125732);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.yiH);
      paramVarArgs.aR(3, this.EPT);
      if (this.EOI != null) {
        paramVarArgs.d(4, this.EOI);
      }
      if (this.xID != null) {
        paramVarArgs.d(5, this.xID);
      }
      paramVarArgs.aR(6, this.yiF);
      AppMethodBeat.o(125732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.yiH) + f.a.a.b.b.a.bx(3, this.EPT);
      paramInt = i;
      if (this.EOI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EOI);
      }
      i = paramInt;
      if (this.xID != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.xID);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.yiF);
      AppMethodBeat.o(125732);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125732);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayo localayo = (ayo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125732);
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
            localayo.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125732);
          return 0;
        case 2: 
          localayo.yiH = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125732);
          return 0;
        case 3: 
          localayo.EPT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125732);
          return 0;
        case 4: 
          localayo.EOI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125732);
          return 0;
        case 5: 
          localayo.xID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125732);
          return 0;
        }
        localayo.yiF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125732);
        return 0;
      }
      AppMethodBeat.o(125732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayo
 * JD-Core Version:    0.7.0.1
 */