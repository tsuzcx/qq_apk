package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlf
  extends ckq
{
  public int CYi;
  public String DZr;
  public int DdZ;
  public long Dea;
  public int EAT;
  public dnb EAU;
  public dnb EAV;
  public String EAW;
  public int EAX;
  public long EAY;
  public int EAZ;
  public int EBa;
  public LinkedList<bso> EBb;
  
  public dlf()
  {
    AppMethodBeat.i(115857);
    this.EBb = new LinkedList();
    AppMethodBeat.o(115857);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115858);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DdZ);
      paramVarArgs.aG(3, this.Dea);
      if (this.DZr != null) {
        paramVarArgs.d(4, this.DZr);
      }
      paramVarArgs.aR(5, this.EAT);
      if (this.EAU != null)
      {
        paramVarArgs.kX(6, this.EAU.computeSize());
        this.EAU.writeFields(paramVarArgs);
      }
      if (this.EAV != null)
      {
        paramVarArgs.kX(7, this.EAV.computeSize());
        this.EAV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.CYi);
      if (this.EAW != null) {
        paramVarArgs.d(9, this.EAW);
      }
      paramVarArgs.aR(10, this.EAX);
      paramVarArgs.aG(11, this.EAY);
      paramVarArgs.aR(12, this.EAZ);
      paramVarArgs.aR(13, this.EBa);
      paramVarArgs.e(14, 8, this.EBb);
      AppMethodBeat.o(115858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1254;
      }
    }
    label1254:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DdZ) + f.a.a.b.b.a.q(3, this.Dea);
      paramInt = i;
      if (this.DZr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DZr);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.EAT);
      paramInt = i;
      if (this.EAU != null) {
        paramInt = i + f.a.a.a.kW(6, this.EAU.computeSize());
      }
      i = paramInt;
      if (this.EAV != null) {
        i = paramInt + f.a.a.a.kW(7, this.EAV.computeSize());
      }
      i += f.a.a.b.b.a.bA(8, this.CYi);
      paramInt = i;
      if (this.EAW != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EAW);
      }
      i = f.a.a.b.b.a.bA(10, this.EAX);
      int j = f.a.a.b.b.a.q(11, this.EAY);
      int k = f.a.a.b.b.a.bA(12, this.EAZ);
      int m = f.a.a.b.b.a.bA(13, this.EBa);
      int n = f.a.a.a.c(14, 8, this.EBb);
      AppMethodBeat.o(115858);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EBb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(115858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlf localdlf = (dlf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115858);
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
            localdlf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 2: 
          localdlf.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115858);
          return 0;
        case 3: 
          localdlf.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115858);
          return 0;
        case 4: 
          localdlf.DZr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 5: 
          localdlf.EAT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115858);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlf.EAU = ((dnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlf.EAV = ((dnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 8: 
          localdlf.CYi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115858);
          return 0;
        case 9: 
          localdlf.EAW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 10: 
          localdlf.EAX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115858);
          return 0;
        case 11: 
          localdlf.EAY = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115858);
          return 0;
        case 12: 
          localdlf.EAZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115858);
          return 0;
        case 13: 
          localdlf.EBa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115858);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bso();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bso)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdlf.EBb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115858);
        return 0;
      }
      AppMethodBeat.o(115858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlf
 * JD-Core Version:    0.7.0.1
 */