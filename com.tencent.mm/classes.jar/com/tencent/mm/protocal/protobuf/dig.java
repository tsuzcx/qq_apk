package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dig
  extends ckq
{
  public int CJI;
  public int CLA;
  public int CNt;
  public String COT;
  public String CxC;
  public String CyF;
  public int DMv;
  public int DcP;
  public int DdJ;
  public int Eyv;
  public int Eyw;
  public int hno;
  public String sdP;
  public String sdQ;
  public SKBuiltinBuffer_t uKT;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148661);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148661);
        throw paramVarArgs;
      }
      if (this.sdQ != null) {
        paramVarArgs.d(1, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(2, this.sdP);
      }
      paramVarArgs.aR(3, this.CNt);
      paramVarArgs.aR(4, this.CJI);
      if (this.CyF != null) {
        paramVarArgs.d(5, this.CyF);
      }
      paramVarArgs.aR(6, this.uKX);
      paramVarArgs.aR(7, this.CLA);
      if (this.uKT != null)
      {
        paramVarArgs.kX(8, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.hno);
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(10, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.DcP);
      if (this.CxC != null) {
        paramVarArgs.d(12, this.CxC);
      }
      paramVarArgs.aR(13, this.DMv);
      paramVarArgs.aR(14, this.Eyv);
      paramVarArgs.aR(15, this.Eyw);
      paramVarArgs.aG(16, this.uKZ);
      paramVarArgs.aR(17, this.DdJ);
      if (this.COT != null) {
        paramVarArgs.d(19, this.COT);
      }
      AppMethodBeat.o(148661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sdQ == null) {
        break label1314;
      }
    }
    label1314:
    for (paramInt = f.a.a.b.b.a.e(1, this.sdQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sdP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sdP);
      }
      i = i + f.a.a.b.b.a.bA(3, this.CNt) + f.a.a.b.b.a.bA(4, this.CJI);
      paramInt = i;
      if (this.CyF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CyF);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.uKX) + f.a.a.b.b.a.bA(7, this.CLA);
      paramInt = i;
      if (this.uKT != null) {
        paramInt = i + f.a.a.a.kW(8, this.uKT.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.hno);
      paramInt = i;
      if (this.BaseRequest != null) {
        paramInt = i + f.a.a.a.kW(10, this.BaseRequest.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.DcP);
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CxC);
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.DMv) + f.a.a.b.b.a.bA(14, this.Eyv) + f.a.a.b.b.a.bA(15, this.Eyw) + f.a.a.b.b.a.q(16, this.uKZ) + f.a.a.b.b.a.bA(17, this.DdJ);
      paramInt = i;
      if (this.COT != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.COT);
      }
      AppMethodBeat.o(148661);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.uKT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148661);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148661);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dig localdig = (dig)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(148661);
          return -1;
        case 1: 
          localdig.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 2: 
          localdig.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 3: 
          localdig.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148661);
          return 0;
        case 4: 
          localdig.CJI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148661);
          return 0;
        case 5: 
          localdig.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 6: 
          localdig.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148661);
          return 0;
        case 7: 
          localdig.CLA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148661);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdig.uKT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 9: 
          localdig.hno = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148661);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdig.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 11: 
          localdig.DcP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148661);
          return 0;
        case 12: 
          localdig.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 13: 
          localdig.DMv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148661);
          return 0;
        case 14: 
          localdig.Eyv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148661);
          return 0;
        case 15: 
          localdig.Eyw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148661);
          return 0;
        case 16: 
          localdig.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(148661);
          return 0;
        case 17: 
          localdig.DdJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(148661);
          return 0;
        }
        localdig.COT = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(148661);
        return 0;
      }
      AppMethodBeat.o(148661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dig
 * JD-Core Version:    0.7.0.1
 */