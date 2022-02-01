package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwl
  extends cpx
{
  public String AWI;
  public int AWN;
  public String DQj;
  public String cZz;
  public long dBN;
  public int fsg;
  public String vxk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.AWN);
      if (this.cZz != null) {
        paramVarArgs.d(3, this.cZz);
      }
      if (this.vxk != null) {
        paramVarArgs.d(4, this.vxk);
      }
      if (this.AWI != null) {
        paramVarArgs.d(5, this.AWI);
      }
      paramVarArgs.aO(6, this.dBN);
      paramVarArgs.aR(7, this.fsg);
      if (this.DQj != null) {
        paramVarArgs.d(8, this.DQj);
      }
      AppMethodBeat.o(91545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.AWN);
      paramInt = i;
      if (this.cZz != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.cZz);
      }
      i = paramInt;
      if (this.vxk != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vxk);
      }
      paramInt = i;
      if (this.AWI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.AWI);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.dBN) + f.a.a.b.b.a.bx(7, this.fsg);
      paramInt = i;
      if (this.DQj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DQj);
      }
      AppMethodBeat.o(91545);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwl localbwl = (bwl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91545);
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
            localbwl.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91545);
          return 0;
        case 2: 
          localbwl.AWN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91545);
          return 0;
        case 3: 
          localbwl.cZz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 4: 
          localbwl.vxk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 5: 
          localbwl.AWI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 6: 
          localbwl.dBN = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91545);
          return 0;
        case 7: 
          localbwl.fsg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91545);
          return 0;
        }
        localbwl.DQj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91545);
        return 0;
      }
      AppMethodBeat.o(91545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwl
 * JD-Core Version:    0.7.0.1
 */