package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adc
  extends cpx
{
  public int DRa;
  public String EvQ;
  public int EvR;
  public int EvS;
  public String hOf;
  public String hOi;
  public String ncR;
  public int ndI;
  public int vTH;
  public int vTI;
  public int vTJ;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9590);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      paramVarArgs.aR(3, this.DRa);
      if (this.hOi != null) {
        paramVarArgs.d(4, this.hOi);
      }
      if (this.ncR != null) {
        paramVarArgs.d(5, this.ncR);
      }
      paramVarArgs.aR(6, this.vTH);
      paramVarArgs.aR(7, this.vTI);
      paramVarArgs.aR(8, this.vTJ);
      if (this.EvQ != null) {
        paramVarArgs.d(9, this.EvQ);
      }
      paramVarArgs.aR(10, this.EvR);
      paramVarArgs.aR(11, this.ndI);
      paramVarArgs.aR(12, this.EvS);
      paramVarArgs.aO(13, this.vTQ);
      AppMethodBeat.o(9590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label941;
      }
    }
    label941:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hOf);
      }
      i += f.a.a.b.b.a.bx(3, this.DRa);
      paramInt = i;
      if (this.hOi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hOi);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ncR);
      }
      i = i + f.a.a.b.b.a.bx(6, this.vTH) + f.a.a.b.b.a.bx(7, this.vTI) + f.a.a.b.b.a.bx(8, this.vTJ);
      paramInt = i;
      if (this.EvQ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EvQ);
      }
      i = f.a.a.b.b.a.bx(10, this.EvR);
      int j = f.a.a.b.b.a.bx(11, this.ndI);
      int k = f.a.a.b.b.a.bx(12, this.EvS);
      int m = f.a.a.b.b.a.p(13, this.vTQ);
      AppMethodBeat.o(9590);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(9590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adc localadc = (adc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9590);
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
            localadc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9590);
          return 0;
        case 2: 
          localadc.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 3: 
          localadc.DRa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(9590);
          return 0;
        case 4: 
          localadc.hOi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 5: 
          localadc.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 6: 
          localadc.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(9590);
          return 0;
        case 7: 
          localadc.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(9590);
          return 0;
        case 8: 
          localadc.vTJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(9590);
          return 0;
        case 9: 
          localadc.EvQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 10: 
          localadc.EvR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(9590);
          return 0;
        case 11: 
          localadc.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(9590);
          return 0;
        case 12: 
          localadc.EvS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(9590);
          return 0;
        }
        localadc.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(9590);
        return 0;
      }
      AppMethodBeat.o(9590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adc
 * JD-Core Version:    0.7.0.1
 */