package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvx
  extends cpx
{
  public String Fls;
  public int Flt;
  public int Flu;
  public int Flv;
  public String djj;
  public int dvQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74664);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      if (this.Fls != null) {
        paramVarArgs.d(3, this.Fls);
      }
      paramVarArgs.aR(4, this.Flt);
      paramVarArgs.aR(5, this.Flu);
      paramVarArgs.aR(6, this.Flv);
      paramVarArgs.aR(7, this.dvQ);
      AppMethodBeat.o(74664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djj);
      }
      i = paramInt;
      if (this.Fls != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fls);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.Flt);
      int j = f.a.a.b.b.a.bx(5, this.Flu);
      int k = f.a.a.b.b.a.bx(6, this.Flv);
      int m = f.a.a.b.b.a.bx(7, this.dvQ);
      AppMethodBeat.o(74664);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(74664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvx localbvx = (bvx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74664);
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
            localbvx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74664);
          return 0;
        case 2: 
          localbvx.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(74664);
          return 0;
        case 3: 
          localbvx.Fls = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(74664);
          return 0;
        case 4: 
          localbvx.Flt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(74664);
          return 0;
        case 5: 
          localbvx.Flu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(74664);
          return 0;
        case 6: 
          localbvx.Flv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(74664);
          return 0;
        }
        localbvx.dvQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(74664);
        return 0;
      }
      AppMethodBeat.o(74664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvx
 * JD-Core Version:    0.7.0.1
 */