package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aup
  extends cpx
{
  public String Eja;
  public long Ejn;
  public int Ekd;
  public double latitude;
  public double longitude;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114015);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Eja != null) {
        paramVarArgs.d(2, this.Eja);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.aO(5, this.Ejn);
      paramVarArgs.aR(6, this.Ekd);
      paramVarArgs.aR(7, this.scene);
      AppMethodBeat.o(114015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label608;
      }
    }
    label608:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eja != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eja);
      }
      paramInt = f.a.a.b.b.a.fK(3);
      int j = f.a.a.b.b.a.fK(4);
      int k = f.a.a.b.b.a.p(5, this.Ejn);
      int m = f.a.a.b.b.a.bx(6, this.Ekd);
      int n = f.a.a.b.b.a.bx(7, this.scene);
      AppMethodBeat.o(114015);
      return i + (paramInt + 8) + (j + 8) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114015);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aup localaup = (aup)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114015);
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
            localaup.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114015);
          return 0;
        case 2: 
          localaup.Eja = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114015);
          return 0;
        case 3: 
          localaup.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(114015);
          return 0;
        case 4: 
          localaup.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(114015);
          return 0;
        case 5: 
          localaup.Ejn = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(114015);
          return 0;
        case 6: 
          localaup.Ekd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114015);
          return 0;
        }
        localaup.scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(114015);
        return 0;
      }
      AppMethodBeat.o(114015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aup
 * JD-Core Version:    0.7.0.1
 */