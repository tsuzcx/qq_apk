package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bsm
  extends cpx
{
  public int Fht;
  public LinkedList<b> Fhu;
  public long Fhv;
  public long Fhw;
  public float dmL;
  public float doB;
  public long wrn;
  
  public bsm()
  {
    AppMethodBeat.i(169918);
    this.Fhu = new LinkedList();
    AppMethodBeat.o(169918);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169919);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Fht);
      paramVarArgs.x(3, this.dmL);
      paramVarArgs.x(4, this.doB);
      paramVarArgs.e(5, 6, this.Fhu);
      paramVarArgs.aO(6, this.wrn);
      paramVarArgs.aO(7, this.Fhv);
      paramVarArgs.aO(8, this.Fhw);
      AppMethodBeat.o(169919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label656;
      }
    }
    label656:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.Fht);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.a.c(5, 6, this.Fhu);
      int n = f.a.a.b.b.a.p(6, this.wrn);
      int i1 = f.a.a.b.b.a.p(7, this.Fhv);
      int i2 = f.a.a.b.b.a.p(8, this.Fhw);
      AppMethodBeat.o(169919);
      return paramInt + i + (j + 4) + (k + 4) + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fhu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bsm localbsm = (bsm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169919);
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
            localbsm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169919);
          return 0;
        case 2: 
          localbsm.Fht = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169919);
          return 0;
        case 3: 
          localbsm.dmL = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(169919);
          return 0;
        case 4: 
          localbsm.doB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(169919);
          return 0;
        case 5: 
          localbsm.Fhu.add(((f.a.a.a.a)localObject1).LVo.gfk());
          AppMethodBeat.o(169919);
          return 0;
        case 6: 
          localbsm.wrn = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169919);
          return 0;
        case 7: 
          localbsm.Fhv = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169919);
          return 0;
        }
        localbsm.Fhw = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(169919);
        return 0;
      }
      AppMethodBeat.o(169919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsm
 * JD-Core Version:    0.7.0.1
 */