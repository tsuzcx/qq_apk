package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzw
  extends cpx
{
  public String BoQ;
  public String DXS;
  public String DXT;
  public boolean FoH;
  public String FoI;
  public String FoJ;
  public int FoK;
  public String FoL;
  public String cZz;
  public int dql;
  public int dvQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72530);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DXS != null) {
        paramVarArgs.d(2, this.DXS);
      }
      if (this.DXT != null) {
        paramVarArgs.d(3, this.DXT);
      }
      if (this.FoI != null) {
        paramVarArgs.d(4, this.FoI);
      }
      if (this.FoJ != null) {
        paramVarArgs.d(5, this.FoJ);
      }
      if (this.BoQ != null) {
        paramVarArgs.d(6, this.BoQ);
      }
      if (this.cZz != null) {
        paramVarArgs.d(7, this.cZz);
      }
      paramVarArgs.aR(8, this.dql);
      paramVarArgs.aR(9, this.FoK);
      paramVarArgs.bl(10, this.FoH);
      paramVarArgs.aR(11, this.dvQ);
      if (this.FoL != null) {
        paramVarArgs.d(12, this.FoL);
      }
      AppMethodBeat.o(72530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label914;
      }
    }
    label914:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DXS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DXS);
      }
      i = paramInt;
      if (this.DXT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DXT);
      }
      paramInt = i;
      if (this.FoI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FoI);
      }
      i = paramInt;
      if (this.FoJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FoJ);
      }
      paramInt = i;
      if (this.BoQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.BoQ);
      }
      i = paramInt;
      if (this.cZz != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.cZz);
      }
      i = i + f.a.a.b.b.a.bx(8, this.dql) + f.a.a.b.b.a.bx(9, this.FoK) + (f.a.a.b.b.a.fK(10) + 1) + f.a.a.b.b.a.bx(11, this.dvQ);
      paramInt = i;
      if (this.FoL != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FoL);
      }
      AppMethodBeat.o(72530);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72530);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzw localbzw = (bzw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72530);
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
            localbzw.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72530);
          return 0;
        case 2: 
          localbzw.DXS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 3: 
          localbzw.DXT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 4: 
          localbzw.FoI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 5: 
          localbzw.FoJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 6: 
          localbzw.BoQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 7: 
          localbzw.cZz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 8: 
          localbzw.dql = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72530);
          return 0;
        case 9: 
          localbzw.FoK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72530);
          return 0;
        case 10: 
          localbzw.FoH = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(72530);
          return 0;
        case 11: 
          localbzw.dvQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72530);
          return 0;
        }
        localbzw.FoL = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72530);
        return 0;
      }
      AppMethodBeat.o(72530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzw
 * JD-Core Version:    0.7.0.1
 */