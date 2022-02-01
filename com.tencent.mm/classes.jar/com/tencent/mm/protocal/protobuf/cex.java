package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cex
  extends cpx
{
  public int DLC;
  public String DYh;
  public String EJO;
  public String EoO;
  public String EpT;
  public String EpU;
  public String EpV;
  public String EpW;
  public String hOf;
  public String tlX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91606);
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
      if (this.EpT != null) {
        paramVarArgs.d(3, this.EpT);
      }
      if (this.DYh != null) {
        paramVarArgs.d(4, this.DYh);
      }
      if (this.EpU != null) {
        paramVarArgs.d(5, this.EpU);
      }
      if (this.EpV != null) {
        paramVarArgs.d(6, this.EpV);
      }
      if (this.EpW != null) {
        paramVarArgs.d(7, this.EpW);
      }
      if (this.EoO != null) {
        paramVarArgs.d(8, this.EoO);
      }
      if (this.EJO != null) {
        paramVarArgs.d(9, this.EJO);
      }
      paramVarArgs.aR(10, this.DLC);
      if (this.tlX != null) {
        paramVarArgs.d(11, this.tlX);
      }
      AppMethodBeat.o(91606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt;
      if (this.EpT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EpT);
      }
      paramInt = i;
      if (this.DYh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DYh);
      }
      i = paramInt;
      if (this.EpU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EpU);
      }
      paramInt = i;
      if (this.EpV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EpV);
      }
      i = paramInt;
      if (this.EpW != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EpW);
      }
      paramInt = i;
      if (this.EoO != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EoO);
      }
      i = paramInt;
      if (this.EJO != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EJO);
      }
      i += f.a.a.b.b.a.bx(10, this.DLC);
      paramInt = i;
      if (this.tlX != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.tlX);
      }
      AppMethodBeat.o(91606);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91606);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cex localcex = (cex)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91606);
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
            localcex.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91606);
          return 0;
        case 2: 
          localcex.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91606);
          return 0;
        case 3: 
          localcex.EpT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91606);
          return 0;
        case 4: 
          localcex.DYh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91606);
          return 0;
        case 5: 
          localcex.EpU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91606);
          return 0;
        case 6: 
          localcex.EpV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91606);
          return 0;
        case 7: 
          localcex.EpW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91606);
          return 0;
        case 8: 
          localcex.EoO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91606);
          return 0;
        case 9: 
          localcex.EJO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91606);
          return 0;
        case 10: 
          localcex.DLC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91606);
          return 0;
        }
        localcex.tlX = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91606);
        return 0;
      }
      AppMethodBeat.o(91606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cex
 * JD-Core Version:    0.7.0.1
 */