package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wg
  extends cpx
{
  public int DPL;
  public String DYh;
  public bb EhT;
  public String EoO;
  public String EpT;
  public String EpU;
  public String EpV;
  public String EpW;
  public int EpX;
  public int EpZ;
  public int EqE;
  public int EqF;
  public String Eqa;
  public String hOf;
  public String ncR;
  public String tlT;
  public String znE;
  public String znF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91418);
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
      paramVarArgs.aR(9, this.EpX);
      if (this.EhT != null)
      {
        paramVarArgs.ln(10, this.EhT.computeSize());
        this.EhT.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(11, this.ncR);
      }
      if (this.tlT != null) {
        paramVarArgs.d(12, this.tlT);
      }
      paramVarArgs.aR(13, this.DPL);
      paramVarArgs.aR(14, this.EqE);
      if (this.znE != null) {
        paramVarArgs.d(15, this.znE);
      }
      if (this.znF != null) {
        paramVarArgs.d(16, this.znF);
      }
      paramVarArgs.aR(17, this.EqF);
      paramVarArgs.aR(18, this.EpZ);
      if (this.Eqa != null) {
        paramVarArgs.d(19, this.Eqa);
      }
      AppMethodBeat.o(91418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1430;
      }
    }
    label1430:
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
      i = paramInt + f.a.a.b.b.a.bx(9, this.EpX);
      paramInt = i;
      if (this.EhT != null) {
        paramInt = i + f.a.a.a.lm(10, this.EhT.computeSize());
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ncR);
      }
      paramInt = i;
      if (this.tlT != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.tlT);
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.DPL) + f.a.a.b.b.a.bx(14, this.EqE);
      paramInt = i;
      if (this.znE != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.znE);
      }
      i = paramInt;
      if (this.znF != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.znF);
      }
      i = i + f.a.a.b.b.a.bx(17, this.EqF) + f.a.a.b.b.a.bx(18, this.EpZ);
      paramInt = i;
      if (this.Eqa != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.Eqa);
      }
      AppMethodBeat.o(91418);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wg localwg = (wg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91418);
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
            localwg.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91418);
          return 0;
        case 2: 
          localwg.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 3: 
          localwg.EpT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 4: 
          localwg.DYh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 5: 
          localwg.EpU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 6: 
          localwg.EpV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 7: 
          localwg.EpW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 8: 
          localwg.EoO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 9: 
          localwg.EpX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91418);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwg.EhT = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91418);
          return 0;
        case 11: 
          localwg.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 12: 
          localwg.tlT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 13: 
          localwg.DPL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91418);
          return 0;
        case 14: 
          localwg.EqE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91418);
          return 0;
        case 15: 
          localwg.znE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 16: 
          localwg.znF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 17: 
          localwg.EqF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91418);
          return 0;
        case 18: 
          localwg.EpZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91418);
          return 0;
        }
        localwg.Eqa = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91418);
        return 0;
      }
      AppMethodBeat.o(91418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wg
 * JD-Core Version:    0.7.0.1
 */