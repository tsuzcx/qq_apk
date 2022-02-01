package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbo
  extends cqk
{
  public LinkedList<SnsObject> DXh;
  public SKBuiltinBuffer_t FIP;
  public String FJm;
  public int FJq;
  public int FJr;
  public dbd FJs;
  public int FKH;
  public int FKI;
  public LinkedList<di> FKJ;
  public int FKK;
  public LinkedList<cmj> FKL;
  public int FKM;
  public LinkedList<aan> FKN;
  public int FKO;
  public LinkedList<Long> FKP;
  public LinkedList<Integer> FKQ;
  public int Fli;
  
  public dbo()
  {
    AppMethodBeat.i(125828);
    this.DXh = new LinkedList();
    this.FKJ = new LinkedList();
    this.FKL = new LinkedList();
    this.FKN = new LinkedList();
    this.FKP = new LinkedList();
    this.FKQ = new LinkedList();
    AppMethodBeat.o(125828);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125829);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125829);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FJm != null) {
        paramVarArgs.d(2, this.FJm);
      }
      paramVarArgs.aR(3, this.Fli);
      paramVarArgs.e(4, 8, this.DXh);
      paramVarArgs.aR(5, this.FKH);
      paramVarArgs.aR(6, this.FJq);
      paramVarArgs.aR(7, this.FJr);
      if (this.FJs != null)
      {
        paramVarArgs.ln(8, this.FJs.computeSize());
        this.FJs.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.FKI);
      paramVarArgs.e(10, 8, this.FKJ);
      if (this.FIP != null)
      {
        paramVarArgs.ln(11, this.FIP.computeSize());
        this.FIP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.FKK);
      paramVarArgs.e(13, 8, this.FKL);
      paramVarArgs.aR(14, this.FKM);
      paramVarArgs.e(15, 8, this.FKN);
      paramVarArgs.aR(16, this.FKO);
      paramVarArgs.f(17, 3, this.FKP);
      paramVarArgs.f(18, 2, this.FKQ);
      AppMethodBeat.o(125829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1808;
      }
    }
    label1808:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FJm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FJm);
      }
      i = i + f.a.a.b.b.a.bx(3, this.Fli) + f.a.a.a.c(4, 8, this.DXh) + f.a.a.b.b.a.bx(5, this.FKH) + f.a.a.b.b.a.bx(6, this.FJq) + f.a.a.b.b.a.bx(7, this.FJr);
      paramInt = i;
      if (this.FJs != null) {
        paramInt = i + f.a.a.a.lm(8, this.FJs.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.FKI) + f.a.a.a.c(10, 8, this.FKJ);
      paramInt = i;
      if (this.FIP != null) {
        paramInt = i + f.a.a.a.lm(11, this.FIP.computeSize());
      }
      i = f.a.a.b.b.a.bx(12, this.FKK);
      int j = f.a.a.a.c(13, 8, this.FKL);
      int k = f.a.a.b.b.a.bx(14, this.FKM);
      int m = f.a.a.a.c(15, 8, this.FKN);
      int n = f.a.a.b.b.a.bx(16, this.FKO);
      int i1 = f.a.a.a.d(17, 3, this.FKP);
      int i2 = f.a.a.a.d(18, 2, this.FKQ);
      AppMethodBeat.o(125829);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DXh.clear();
        this.FKJ.clear();
        this.FKL.clear();
        this.FKN.clear();
        this.FKP.clear();
        this.FKQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125829);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbo localdbo = (dbo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125829);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 2: 
          localdbo.FJm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125829);
          return 0;
        case 3: 
          localdbo.Fli = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125829);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbo.DXh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 5: 
          localdbo.FKH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125829);
          return 0;
        case 6: 
          localdbo.FJq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125829);
          return 0;
        case 7: 
          localdbo.FJr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125829);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbo.FJs = ((dbd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 9: 
          localdbo.FKI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125829);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new di();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((di)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbo.FKJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbo.FIP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 12: 
          localdbo.FKK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125829);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbo.FKL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 14: 
          localdbo.FKM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125829);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aan();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aan)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbo.FKN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125829);
          return 0;
        case 16: 
          localdbo.FKO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125829);
          return 0;
        case 17: 
          localdbo.FKP = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfj();
          AppMethodBeat.o(125829);
          return 0;
        }
        localdbo.FKQ = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
        AppMethodBeat.o(125829);
        return 0;
      }
      AppMethodBeat.o(125829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbo
 * JD-Core Version:    0.7.0.1
 */