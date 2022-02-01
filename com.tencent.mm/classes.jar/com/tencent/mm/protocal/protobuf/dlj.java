package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlj
  extends ckq
{
  public int CYi;
  public String DZr;
  public int DdZ;
  public long Dea;
  public dnb EAU;
  public dnb EAV;
  public long EAY;
  public int EAZ;
  public int EBa;
  public LinkedList<bso> EBb;
  public int EBl;
  public int EBm;
  
  public dlj()
  {
    AppMethodBeat.i(115863);
    this.EBb = new LinkedList();
    AppMethodBeat.o(115863);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115864);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DZr != null) {
        paramVarArgs.d(2, this.DZr);
      }
      paramVarArgs.aR(3, this.DdZ);
      paramVarArgs.aR(4, this.EBl);
      if (this.EAU != null)
      {
        paramVarArgs.kX(5, this.EAU.computeSize());
        this.EAU.writeFields(paramVarArgs);
      }
      if (this.EAV != null)
      {
        paramVarArgs.kX(6, this.EAV.computeSize());
        this.EAV.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(7, this.Dea);
      paramVarArgs.aR(8, this.CYi);
      paramVarArgs.aG(9, this.EAY);
      paramVarArgs.aR(10, this.EBm);
      paramVarArgs.aR(11, this.EAZ);
      paramVarArgs.aR(12, this.EBa);
      paramVarArgs.e(13, 8, this.EBb);
      AppMethodBeat.o(115864);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DZr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DZr);
      }
      i = i + f.a.a.b.b.a.bA(3, this.DdZ) + f.a.a.b.b.a.bA(4, this.EBl);
      paramInt = i;
      if (this.EAU != null) {
        paramInt = i + f.a.a.a.kW(5, this.EAU.computeSize());
      }
      i = paramInt;
      if (this.EAV != null) {
        i = paramInt + f.a.a.a.kW(6, this.EAV.computeSize());
      }
      paramInt = f.a.a.b.b.a.q(7, this.Dea);
      int j = f.a.a.b.b.a.bA(8, this.CYi);
      int k = f.a.a.b.b.a.q(9, this.EAY);
      int m = f.a.a.b.b.a.bA(10, this.EBm);
      int n = f.a.a.b.b.a.bA(11, this.EAZ);
      int i1 = f.a.a.b.b.a.bA(12, this.EBa);
      int i2 = f.a.a.a.c(13, 8, this.EBb);
      AppMethodBeat.o(115864);
      return i + paramInt + j + k + m + n + i1 + i2;
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
        AppMethodBeat.o(115864);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlj localdlj = (dlj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115864);
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
            localdlj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 2: 
          localdlj.DZr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115864);
          return 0;
        case 3: 
          localdlj.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115864);
          return 0;
        case 4: 
          localdlj.EBl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115864);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlj.EAU = ((dnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
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
            localdlj.EAV = ((dnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 7: 
          localdlj.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115864);
          return 0;
        case 8: 
          localdlj.CYi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115864);
          return 0;
        case 9: 
          localdlj.EAY = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115864);
          return 0;
        case 10: 
          localdlj.EBm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115864);
          return 0;
        case 11: 
          localdlj.EAZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115864);
          return 0;
        case 12: 
          localdlj.EBa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115864);
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
          localdlj.EBb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115864);
        return 0;
      }
      AppMethodBeat.o(115864);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlj
 * JD-Core Version:    0.7.0.1
 */