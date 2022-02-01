package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgv
  extends cpx
{
  public String AYl;
  public int ErG;
  public int FuS;
  public int FuT;
  public ig FuU;
  public int FuV;
  public String FuW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91624);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FuS);
      paramVarArgs.aR(3, this.FuT);
      if (this.FuU != null)
      {
        paramVarArgs.ln(4, this.FuU.computeSize());
        this.FuU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.ErG);
      paramVarArgs.aR(6, this.FuV);
      if (this.FuW != null) {
        paramVarArgs.d(7, this.FuW);
      }
      if (this.AYl != null) {
        paramVarArgs.d(100, this.AYl);
      }
      AppMethodBeat.o(91624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FuS) + f.a.a.b.b.a.bx(3, this.FuT);
      paramInt = i;
      if (this.FuU != null) {
        paramInt = i + f.a.a.a.lm(4, this.FuU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.ErG) + f.a.a.b.b.a.bx(6, this.FuV);
      paramInt = i;
      if (this.FuW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FuW);
      }
      i = paramInt;
      if (this.AYl != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.AYl);
      }
      AppMethodBeat.o(91624);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgv localcgv = (cgv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91624);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 2: 
          localcgv.FuS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91624);
          return 0;
        case 3: 
          localcgv.FuT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91624);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ig();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ig)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgv.FuU = ((ig)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 5: 
          localcgv.ErG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91624);
          return 0;
        case 6: 
          localcgv.FuV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91624);
          return 0;
        case 7: 
          localcgv.FuW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91624);
          return 0;
        }
        localcgv.AYl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91624);
        return 0;
      }
      AppMethodBeat.o(91624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgv
 * JD-Core Version:    0.7.0.1
 */