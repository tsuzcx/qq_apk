package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cpy
  extends cpx
{
  public String DTk;
  public int Efa;
  public int FCS;
  public String FCT;
  public int FCU;
  public int FCV;
  public b FCW;
  public String FpO;
  public String cZz;
  public int wEF;
  public String wES;
  public String wET;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72581);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wES != null) {
        paramVarArgs.d(2, this.wES);
      }
      if (this.wET != null) {
        paramVarArgs.d(3, this.wET);
      }
      if (this.cZz != null) {
        paramVarArgs.d(4, this.cZz);
      }
      paramVarArgs.aR(5, this.wEF);
      paramVarArgs.aR(6, this.FCS);
      if (this.FCT != null) {
        paramVarArgs.d(7, this.FCT);
      }
      paramVarArgs.aR(8, this.FCU);
      paramVarArgs.aR(9, this.FCV);
      if (this.DTk != null) {
        paramVarArgs.d(10, this.DTk);
      }
      if (this.FpO != null) {
        paramVarArgs.d(11, this.FpO);
      }
      if (this.FCW != null) {
        paramVarArgs.c(12, this.FCW);
      }
      paramVarArgs.aR(13, this.Efa);
      AppMethodBeat.o(72581);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wES != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wES);
      }
      i = paramInt;
      if (this.wET != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wET);
      }
      paramInt = i;
      if (this.cZz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.cZz);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.wEF) + f.a.a.b.b.a.bx(6, this.FCS);
      paramInt = i;
      if (this.FCT != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FCT);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.FCU) + f.a.a.b.b.a.bx(9, this.FCV);
      paramInt = i;
      if (this.DTk != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DTk);
      }
      i = paramInt;
      if (this.FpO != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FpO);
      }
      paramInt = i;
      if (this.FCW != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.FCW);
      }
      i = f.a.a.b.b.a.bx(13, this.Efa);
      AppMethodBeat.o(72581);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72581);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpy localcpy = (cpy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72581);
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
            localcpy.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72581);
          return 0;
        case 2: 
          localcpy.wES = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 3: 
          localcpy.wET = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 4: 
          localcpy.cZz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 5: 
          localcpy.wEF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72581);
          return 0;
        case 6: 
          localcpy.FCS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72581);
          return 0;
        case 7: 
          localcpy.FCT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 8: 
          localcpy.FCU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72581);
          return 0;
        case 9: 
          localcpy.FCV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72581);
          return 0;
        case 10: 
          localcpy.DTk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 11: 
          localcpy.FpO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 12: 
          localcpy.FCW = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(72581);
          return 0;
        }
        localcpy.Efa = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(72581);
        return 0;
      }
      AppMethodBeat.o(72581);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpy
 * JD-Core Version:    0.7.0.1
 */