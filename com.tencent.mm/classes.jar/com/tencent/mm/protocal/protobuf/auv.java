package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auv
  extends cpx
{
  public String EMV;
  public double latitude;
  public double longitude;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114022);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.latitude);
      paramVarArgs.e(3, this.longitude);
      paramVarArgs.aR(4, this.scene);
      if (this.EMV != null) {
        paramVarArgs.d(5, this.EMV);
      }
      AppMethodBeat.o(114022);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label504;
      }
    }
    label504:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 8) + (f.a.a.b.b.a.fK(3) + 8) + f.a.a.b.b.a.bx(4, this.scene);
      paramInt = i;
      if (this.EMV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EMV);
      }
      AppMethodBeat.o(114022);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114022);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auv localauv = (auv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114022);
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
            localauv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114022);
          return 0;
        case 2: 
          localauv.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(114022);
          return 0;
        case 3: 
          localauv.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(114022);
          return 0;
        case 4: 
          localauv.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114022);
          return 0;
        }
        localauv.EMV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(114022);
        return 0;
      }
      AppMethodBeat.o(114022);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auv
 * JD-Core Version:    0.7.0.1
 */