package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmb
  extends ckq
{
  public int DYV;
  public String DZr;
  public int DdZ;
  public long Dea;
  public long EAY;
  public dnj EBT;
  public int EBU;
  public int EBV;
  public String sdP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115868);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EBT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115868);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DZr != null) {
        paramVarArgs.d(2, this.DZr);
      }
      paramVarArgs.aR(3, this.DdZ);
      paramVarArgs.aG(4, this.Dea);
      if (this.sdP != null) {
        paramVarArgs.d(6, this.sdP);
      }
      if (this.EBT != null)
      {
        paramVarArgs.kX(8, this.EBT.computeSize());
        this.EBT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.EBU);
      paramVarArgs.aG(10, this.EAY);
      paramVarArgs.aR(11, this.DYV);
      paramVarArgs.aR(12, this.EBV);
      AppMethodBeat.o(115868);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DZr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DZr);
      }
      i = i + f.a.a.b.b.a.bA(3, this.DdZ) + f.a.a.b.b.a.q(4, this.Dea);
      paramInt = i;
      if (this.sdP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sdP);
      }
      i = paramInt;
      if (this.EBT != null) {
        i = paramInt + f.a.a.a.kW(8, this.EBT.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(9, this.EBU);
      int j = f.a.a.b.b.a.q(10, this.EAY);
      int k = f.a.a.b.b.a.bA(11, this.DYV);
      int m = f.a.a.b.b.a.bA(12, this.EBV);
      AppMethodBeat.o(115868);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EBT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115868);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115868);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmb localdmb = (dmb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(115868);
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
            localdmb.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 2: 
          localdmb.DZr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 3: 
          localdmb.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115868);
          return 0;
        case 4: 
          localdmb.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115868);
          return 0;
        case 6: 
          localdmb.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmb.EBT = ((dnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 9: 
          localdmb.EBU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115868);
          return 0;
        case 10: 
          localdmb.EAY = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115868);
          return 0;
        case 11: 
          localdmb.DYV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115868);
          return 0;
        }
        localdmb.EBV = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115868);
        return 0;
      }
      AppMethodBeat.o(115868);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmb
 * JD-Core Version:    0.7.0.1
 */