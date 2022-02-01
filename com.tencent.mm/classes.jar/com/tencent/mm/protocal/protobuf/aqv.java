package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqv
  extends cpx
{
  public int DLC;
  public String DYh;
  public String EJO;
  public String EJR;
  public String EJS;
  public int EJT;
  public String EJU;
  public bb EhT;
  public String EoO;
  public String EpT;
  public String EpU;
  public String EpV;
  public String EpW;
  public int Scene;
  public String hOf;
  public String tlX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91473);
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
      if (this.EJR != null) {
        paramVarArgs.d(12, this.EJR);
      }
      if (this.EJS != null) {
        paramVarArgs.d(13, this.EJS);
      }
      if (this.EhT != null)
      {
        paramVarArgs.ln(14, this.EhT.computeSize());
        this.EhT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(15, this.Scene);
      paramVarArgs.aR(16, this.EJT);
      if (this.EJU != null) {
        paramVarArgs.d(17, this.EJU);
      }
      AppMethodBeat.o(91473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1338;
      }
    }
    label1338:
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
      i = paramInt;
      if (this.EJR != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.EJR);
      }
      paramInt = i;
      if (this.EJS != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.EJS);
      }
      i = paramInt;
      if (this.EhT != null) {
        i = paramInt + f.a.a.a.lm(14, this.EhT.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(15, this.Scene) + f.a.a.b.b.a.bx(16, this.EJT);
      paramInt = i;
      if (this.EJU != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.EJU);
      }
      AppMethodBeat.o(91473);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqv localaqv = (aqv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91473);
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
            localaqv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 2: 
          localaqv.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 3: 
          localaqv.EpT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 4: 
          localaqv.DYh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 5: 
          localaqv.EpU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 6: 
          localaqv.EpV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 7: 
          localaqv.EpW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 8: 
          localaqv.EoO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 9: 
          localaqv.EJO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 10: 
          localaqv.DLC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91473);
          return 0;
        case 11: 
          localaqv.tlX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 12: 
          localaqv.EJR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 13: 
          localaqv.EJS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqv.EhT = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 15: 
          localaqv.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91473);
          return 0;
        case 16: 
          localaqv.EJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91473);
          return 0;
        }
        localaqv.EJU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91473);
        return 0;
      }
      AppMethodBeat.o(91473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqv
 * JD-Core Version:    0.7.0.1
 */