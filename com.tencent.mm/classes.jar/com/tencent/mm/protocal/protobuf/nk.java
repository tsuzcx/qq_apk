package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class nk
  extends cpx
{
  public long DWY;
  public String EaV;
  public b Edo;
  public int Edq;
  public int Edr;
  public int Eds;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124443);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EaV != null) {
        paramVarArgs.d(2, this.EaV);
      }
      paramVarArgs.aR(3, this.Edq);
      if (this.Edo != null) {
        paramVarArgs.c(4, this.Edo);
      }
      paramVarArgs.aR(5, this.Edr);
      paramVarArgs.aO(6, this.DWY);
      paramVarArgs.aR(7, this.Eds);
      paramVarArgs.aR(8, this.Scene);
      AppMethodBeat.o(124443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EaV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EaV);
      }
      i += f.a.a.b.b.a.bx(3, this.Edq);
      paramInt = i;
      if (this.Edo != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Edo);
      }
      i = f.a.a.b.b.a.bx(5, this.Edr);
      int j = f.a.a.b.b.a.p(6, this.DWY);
      int k = f.a.a.b.b.a.bx(7, this.Eds);
      int m = f.a.a.b.b.a.bx(8, this.Scene);
      AppMethodBeat.o(124443);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nk localnk = (nk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124443);
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
            localnk.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124443);
          return 0;
        case 2: 
          localnk.EaV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124443);
          return 0;
        case 3: 
          localnk.Edq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124443);
          return 0;
        case 4: 
          localnk.Edo = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(124443);
          return 0;
        case 5: 
          localnk.Edr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124443);
          return 0;
        case 6: 
          localnk.DWY = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124443);
          return 0;
        case 7: 
          localnk.Eds = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124443);
          return 0;
        }
        localnk.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124443);
        return 0;
      }
      AppMethodBeat.o(124443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nk
 * JD-Core Version:    0.7.0.1
 */