package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cud
  extends cpx
{
  public int ESL;
  public String FFO;
  public int FmW;
  public String hkR;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152688);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.hkR != null) {
        paramVarArgs.d(3, this.hkR);
      }
      paramVarArgs.aR(4, this.FmW);
      paramVarArgs.aR(5, this.ESL);
      if (this.FFO != null) {
        paramVarArgs.d(6, this.FFO);
      }
      AppMethodBeat.o(152688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.hkR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hkR);
      }
      i = i + f.a.a.b.b.a.bx(4, this.FmW) + f.a.a.b.b.a.bx(5, this.ESL);
      paramInt = i;
      if (this.FFO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FFO);
      }
      AppMethodBeat.o(152688);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152688);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cud localcud = (cud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152688);
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
            localcud.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152688);
          return 0;
        case 2: 
          localcud.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152688);
          return 0;
        case 3: 
          localcud.hkR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152688);
          return 0;
        case 4: 
          localcud.FmW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152688);
          return 0;
        case 5: 
          localcud.ESL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152688);
          return 0;
        }
        localcud.FFO = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152688);
        return 0;
      }
      AppMethodBeat.o(152688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cud
 * JD-Core Version:    0.7.0.1
 */