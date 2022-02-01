package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zu
  extends cpx
{
  public String Eph;
  public String Epl;
  public String Eua;
  public long Eub;
  public int lRv;
  public String ugH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Eua != null) {
        paramVarArgs.d(2, this.Eua);
      }
      paramVarArgs.aO(3, this.Eub);
      if (this.Eph != null) {
        paramVarArgs.d(4, this.Eph);
      }
      if (this.Epl != null) {
        paramVarArgs.d(5, this.Epl);
      }
      paramVarArgs.aR(6, this.lRv);
      if (this.ugH != null) {
        paramVarArgs.d(7, this.ugH);
      }
      AppMethodBeat.o(72466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eua != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eua);
      }
      i += f.a.a.b.b.a.p(3, this.Eub);
      paramInt = i;
      if (this.Eph != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eph);
      }
      i = paramInt;
      if (this.Epl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Epl);
      }
      i += f.a.a.b.b.a.bx(6, this.lRv);
      paramInt = i;
      if (this.ugH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ugH);
      }
      AppMethodBeat.o(72466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zu localzu = (zu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72466);
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
            localzu.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72466);
          return 0;
        case 2: 
          localzu.Eua = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 3: 
          localzu.Eub = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(72466);
          return 0;
        case 4: 
          localzu.Eph = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 5: 
          localzu.Epl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 6: 
          localzu.lRv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72466);
          return 0;
        }
        localzu.ugH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72466);
        return 0;
      }
      AppMethodBeat.o(72466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zu
 * JD-Core Version:    0.7.0.1
 */