package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dkw
  extends ckq
{
  public int CAG;
  public int CAJ;
  public int CNt;
  public int EAD;
  public int EAE;
  public LinkedList<cmf> EAF;
  public LinkedList<SKBuiltinBuffer_t> EAG;
  public String ExD;
  public int ExE;
  public int ExF;
  public int hno;
  public String mAQ;
  public SKBuiltinBuffer_t uKT;
  
  public dkw()
  {
    AppMethodBeat.i(148663);
    this.EAF = new LinkedList();
    this.EAG = new LinkedList();
    AppMethodBeat.o(148663);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148664);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148664);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      if (this.uKT != null)
      {
        paramVarArgs.kX(3, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.CNt);
      if (this.ExD != null) {
        paramVarArgs.d(5, this.ExD);
      }
      paramVarArgs.aR(6, this.hno);
      paramVarArgs.aR(7, this.ExE);
      paramVarArgs.aR(8, this.CAJ);
      paramVarArgs.aR(9, this.ExF);
      paramVarArgs.aR(10, this.CAG);
      paramVarArgs.aR(11, this.EAD);
      paramVarArgs.aR(12, this.EAE);
      paramVarArgs.e(13, 8, this.EAF);
      paramVarArgs.e(14, 8, this.EAG);
      AppMethodBeat.o(148664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1298;
      }
    }
    label1298:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = paramInt;
      if (this.uKT != null) {
        i = paramInt + f.a.a.a.kW(3, this.uKT.computeSize());
      }
      i += f.a.a.b.b.a.bA(4, this.CNt);
      paramInt = i;
      if (this.ExD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ExD);
      }
      i = f.a.a.b.b.a.bA(6, this.hno);
      int j = f.a.a.b.b.a.bA(7, this.ExE);
      int k = f.a.a.b.b.a.bA(8, this.CAJ);
      int m = f.a.a.b.b.a.bA(9, this.ExF);
      int n = f.a.a.b.b.a.bA(10, this.CAG);
      int i1 = f.a.a.b.b.a.bA(11, this.EAD);
      int i2 = f.a.a.b.b.a.bA(12, this.EAE);
      int i3 = f.a.a.a.c(13, 8, this.EAF);
      int i4 = f.a.a.a.c(14, 8, this.EAG);
      AppMethodBeat.o(148664);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EAF.clear();
        this.EAG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.uKT == null)
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
        dkw localdkw = (dkw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148664);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkw.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 2: 
          localdkw.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkw.uKT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 4: 
          localdkw.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148664);
          return 0;
        case 5: 
          localdkw.ExD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 6: 
          localdkw.hno = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148664);
          return 0;
        case 7: 
          localdkw.ExE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148664);
          return 0;
        case 8: 
          localdkw.CAJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148664);
          return 0;
        case 9: 
          localdkw.ExF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148664);
          return 0;
        case 10: 
          localdkw.CAG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148664);
          return 0;
        case 11: 
          localdkw.EAD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148664);
          return 0;
        case 12: 
          localdkw.EAE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148664);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkw.EAF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkw.EAG.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkw
 * JD-Core Version:    0.7.0.1
 */