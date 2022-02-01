package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class coy
  extends cpx
{
  public float FBK;
  public b FBL;
  public boolean FBM;
  public boolean FBN;
  public float dmL;
  public float doB;
  public String dvO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114064);
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
      paramVarArgs.x(4, this.FBK);
      if (this.FBL != null) {
        paramVarArgs.c(5, this.FBL);
      }
      if (this.dvO != null) {
        paramVarArgs.d(6, this.dvO);
      }
      paramVarArgs.bl(7, this.FBM);
      paramVarArgs.bl(8, this.FBN);
      AppMethodBeat.o(114064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label655;
      }
    }
    label655:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 4) + (f.a.a.b.b.a.fK(3) + 4) + (f.a.a.b.b.a.fK(4) + 4);
      paramInt = i;
      if (this.FBL != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.FBL);
      }
      i = paramInt;
      if (this.dvO != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dvO);
      }
      paramInt = f.a.a.b.b.a.fK(7);
      int j = f.a.a.b.b.a.fK(8);
      AppMethodBeat.o(114064);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coy localcoy = (coy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114064);
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
            localcoy.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114064);
          return 0;
        case 2: 
          localcoy.doB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(114064);
          return 0;
        case 3: 
          localcoy.dmL = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(114064);
          return 0;
        case 4: 
          localcoy.FBK = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(114064);
          return 0;
        case 5: 
          localcoy.FBL = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(114064);
          return 0;
        case 6: 
          localcoy.dvO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114064);
          return 0;
        case 7: 
          localcoy.FBM = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(114064);
          return 0;
        }
        localcoy.FBN = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(114064);
        return 0;
      }
      AppMethodBeat.o(114064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coy
 * JD-Core Version:    0.7.0.1
 */