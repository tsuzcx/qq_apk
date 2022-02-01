package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpm
  extends cpx
{
  public long FCA;
  public long FCv;
  public String FCw;
  public int FCx;
  public int FCy;
  public int FCz;
  public int FeH;
  public long FvQ;
  public int Scene;
  public String hOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117902);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.FCv);
      if (this.FCw != null) {
        paramVarArgs.d(3, this.FCw);
      }
      paramVarArgs.aR(4, this.Scene);
      paramVarArgs.aR(5, this.FCx);
      paramVarArgs.aR(6, this.FeH);
      paramVarArgs.aR(7, this.FCy);
      paramVarArgs.aO(8, this.FvQ);
      paramVarArgs.aR(9, this.FCz);
      if (this.hOf != null) {
        paramVarArgs.d(10, this.hOf);
      }
      paramVarArgs.aO(11, this.FCA);
      AppMethodBeat.o(117902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.FCv);
      paramInt = i;
      if (this.FCw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FCw);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.Scene) + f.a.a.b.b.a.bx(5, this.FCx) + f.a.a.b.b.a.bx(6, this.FeH) + f.a.a.b.b.a.bx(7, this.FCy) + f.a.a.b.b.a.p(8, this.FvQ) + f.a.a.b.b.a.bx(9, this.FCz);
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.hOf);
      }
      i = f.a.a.b.b.a.p(11, this.FCA);
      AppMethodBeat.o(117902);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117902);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpm localcpm = (cpm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117902);
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
            localcpm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117902);
          return 0;
        case 2: 
          localcpm.FCv = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(117902);
          return 0;
        case 3: 
          localcpm.FCw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117902);
          return 0;
        case 4: 
          localcpm.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117902);
          return 0;
        case 5: 
          localcpm.FCx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117902);
          return 0;
        case 6: 
          localcpm.FeH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117902);
          return 0;
        case 7: 
          localcpm.FCy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117902);
          return 0;
        case 8: 
          localcpm.FvQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(117902);
          return 0;
        case 9: 
          localcpm.FCz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117902);
          return 0;
        case 10: 
          localcpm.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117902);
          return 0;
        }
        localcpm.FCA = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(117902);
        return 0;
      }
      AppMethodBeat.o(117902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpm
 * JD-Core Version:    0.7.0.1
 */