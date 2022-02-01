package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dqt
  extends cpx
{
  public int EeA;
  public int EfV;
  public crm FCP;
  public String FUF;
  public int FUH;
  public int FXZ;
  public LinkedList<crm> FYa;
  public int FYb;
  public int Scene;
  public int hNR;
  public SKBuiltinBuffer_t vTK;
  
  public dqt()
  {
    AppMethodBeat.i(148668);
    this.FYa = new LinkedList();
    AppMethodBeat.o(148668);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148669);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148669);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vTK != null)
      {
        paramVarArgs.ln(2, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EfV);
      if (this.FUF != null) {
        paramVarArgs.d(4, this.FUF);
      }
      paramVarArgs.aR(5, this.hNR);
      paramVarArgs.aR(6, this.FUH);
      paramVarArgs.aR(7, this.EeA);
      paramVarArgs.aR(8, this.FXZ);
      paramVarArgs.e(9, 8, this.FYa);
      if (this.FCP != null)
      {
        paramVarArgs.ln(10, this.FCP.computeSize());
        this.FCP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.FYb);
      paramVarArgs.aR(12, this.Scene);
      AppMethodBeat.o(148669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1182;
      }
    }
    label1182:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vTK != null) {
        i = paramInt + f.a.a.a.lm(2, this.vTK.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.EfV);
      paramInt = i;
      if (this.FUF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUF);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.hNR) + f.a.a.b.b.a.bx(6, this.FUH) + f.a.a.b.b.a.bx(7, this.EeA) + f.a.a.b.b.a.bx(8, this.FXZ) + f.a.a.a.c(9, 8, this.FYa);
      paramInt = i;
      if (this.FCP != null) {
        paramInt = i + f.a.a.a.lm(10, this.FCP.computeSize());
      }
      i = f.a.a.b.b.a.bx(11, this.FYb);
      int j = f.a.a.b.b.a.bx(12, this.Scene);
      AppMethodBeat.o(148669);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FYa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.vTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148669);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148669);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqt localdqt = (dqt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148669);
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
            localdqt.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqt.vTK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 3: 
          localdqt.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148669);
          return 0;
        case 4: 
          localdqt.FUF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(148669);
          return 0;
        case 5: 
          localdqt.hNR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148669);
          return 0;
        case 6: 
          localdqt.FUH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148669);
          return 0;
        case 7: 
          localdqt.EeA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148669);
          return 0;
        case 8: 
          localdqt.FXZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148669);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqt.FYa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqt.FCP = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 11: 
          localdqt.FYb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(148669);
          return 0;
        }
        localdqt.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148669);
        return 0;
      }
      AppMethodBeat.o(148669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqt
 * JD-Core Version:    0.7.0.1
 */