package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxi
  extends cpx
{
  public String FGV;
  public float dmL;
  public float doB;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32438);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.x(2, this.doB);
      paramVarArgs.x(3, this.dmL);
      paramVarArgs.aR(4, this.scene);
      if (this.FGV != null) {
        paramVarArgs.d(5, this.FGV);
      }
      AppMethodBeat.o(32438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label511;
      }
    }
    label511:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 4) + (f.a.a.b.b.a.fK(3) + 4) + f.a.a.b.b.a.bx(4, this.scene);
      paramInt = i;
      if (this.FGV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FGV);
      }
      AppMethodBeat.o(32438);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxi localcxi = (cxi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32438);
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
            localcxi.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32438);
          return 0;
        case 2: 
          localcxi.doB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(32438);
          return 0;
        case 3: 
          localcxi.dmL = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(32438);
          return 0;
        case 4: 
          localcxi.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32438);
          return 0;
        }
        localcxi.FGV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32438);
        return 0;
      }
      AppMethodBeat.o(32438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxi
 * JD-Core Version:    0.7.0.1
 */