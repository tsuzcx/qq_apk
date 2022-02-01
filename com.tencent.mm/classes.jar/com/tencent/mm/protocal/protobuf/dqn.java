package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dqn
  extends cpx
{
  public int DTc;
  public int DTf;
  public int EfV;
  public String FUF;
  public int FUG;
  public int FUH;
  public int FXQ;
  public int FXR;
  public LinkedList<crm> FXS;
  public LinkedList<SKBuiltinBuffer_t> FXT;
  public int hNR;
  public String ncR;
  public SKBuiltinBuffer_t vTK;
  
  public dqn()
  {
    AppMethodBeat.i(148663);
    this.FXS = new LinkedList();
    this.FXT = new LinkedList();
    AppMethodBeat.o(148663);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148664);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148664);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.vTK != null)
      {
        paramVarArgs.ln(3, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.EfV);
      if (this.FUF != null) {
        paramVarArgs.d(5, this.FUF);
      }
      paramVarArgs.aR(6, this.hNR);
      paramVarArgs.aR(7, this.FUG);
      paramVarArgs.aR(8, this.DTf);
      paramVarArgs.aR(9, this.FUH);
      paramVarArgs.aR(10, this.DTc);
      paramVarArgs.aR(11, this.FXQ);
      paramVarArgs.aR(12, this.FXR);
      paramVarArgs.e(13, 8, this.FXS);
      paramVarArgs.e(14, 8, this.FXT);
      AppMethodBeat.o(148664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1298;
      }
    }
    label1298:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.vTK != null) {
        i = paramInt + f.a.a.a.lm(3, this.vTK.computeSize());
      }
      i += f.a.a.b.b.a.bx(4, this.EfV);
      paramInt = i;
      if (this.FUF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FUF);
      }
      i = f.a.a.b.b.a.bx(6, this.hNR);
      int j = f.a.a.b.b.a.bx(7, this.FUG);
      int k = f.a.a.b.b.a.bx(8, this.DTf);
      int m = f.a.a.b.b.a.bx(9, this.FUH);
      int n = f.a.a.b.b.a.bx(10, this.DTc);
      int i1 = f.a.a.b.b.a.bx(11, this.FXQ);
      int i2 = f.a.a.b.b.a.bx(12, this.FXR);
      int i3 = f.a.a.a.c(13, 8, this.FXS);
      int i4 = f.a.a.a.c(14, 8, this.FXT);
      AppMethodBeat.o(148664);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FXS.clear();
        this.FXT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.vTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148664);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqn localdqn = (dqn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148664);
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
            localdqn.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 2: 
          localdqn.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqn.vTK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 4: 
          localdqn.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148664);
          return 0;
        case 5: 
          localdqn.FUF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 6: 
          localdqn.hNR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148664);
          return 0;
        case 7: 
          localdqn.FUG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148664);
          return 0;
        case 8: 
          localdqn.DTf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148664);
          return 0;
        case 9: 
          localdqn.FUH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148664);
          return 0;
        case 10: 
          localdqn.DTc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148664);
          return 0;
        case 11: 
          localdqn.FXQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148664);
          return 0;
        case 12: 
          localdqn.FXR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148664);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqn.FXS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqn.FXT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      AppMethodBeat.o(148664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqn
 * JD-Core Version:    0.7.0.1
 */