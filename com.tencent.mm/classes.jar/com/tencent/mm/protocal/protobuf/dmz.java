package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmz
  extends ckq
{
  public int DZg;
  public int DdZ;
  public long Dea;
  public int EBa;
  public LinkedList<bso> EBb;
  public LinkedList<dnc> EDA;
  public int EDB;
  public int EDC;
  public int EDD;
  public int EDy;
  public int EDz;
  
  public dmz()
  {
    AppMethodBeat.i(115905);
    this.EDA = new LinkedList();
    this.EBb = new LinkedList();
    AppMethodBeat.o(115905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115906);
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
      paramVarArgs.aR(4, this.DZg);
      paramVarArgs.aR(5, this.EDy);
      paramVarArgs.aR(6, this.EDz);
      paramVarArgs.e(7, 8, this.EDA);
      paramVarArgs.aR(8, this.EDB);
      paramVarArgs.aR(9, this.EBa);
      paramVarArgs.e(10, 8, this.EBb);
      paramVarArgs.aR(11, this.EDC);
      paramVarArgs.aR(12, this.EDD);
      AppMethodBeat.o(115906);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DdZ);
      int j = f.a.a.b.b.a.q(3, this.Dea);
      int k = f.a.a.b.b.a.bA(4, this.DZg);
      int m = f.a.a.b.b.a.bA(5, this.EDy);
      int n = f.a.a.b.b.a.bA(6, this.EDz);
      int i1 = f.a.a.a.c(7, 8, this.EDA);
      int i2 = f.a.a.b.b.a.bA(8, this.EDB);
      int i3 = f.a.a.b.b.a.bA(9, this.EBa);
      int i4 = f.a.a.a.c(10, 8, this.EBb);
      int i5 = f.a.a.b.b.a.bA(11, this.EDC);
      int i6 = f.a.a.b.b.a.bA(12, this.EDD);
      AppMethodBeat.o(115906);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EDA.clear();
        this.EBb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(115906);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmz localdmz = (dmz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115906);
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
            localdmz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 2: 
          localdmz.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115906);
          return 0;
        case 3: 
          localdmz.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115906);
          return 0;
        case 4: 
          localdmz.DZg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115906);
          return 0;
        case 5: 
          localdmz.EDy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115906);
          return 0;
        case 6: 
          localdmz.EDz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115906);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmz.EDA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 8: 
          localdmz.EDB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115906);
          return 0;
        case 9: 
          localdmz.EBa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115906);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bso();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bso)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmz.EBb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 11: 
          localdmz.EDC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115906);
          return 0;
        }
        localdmz.EDD = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115906);
        return 0;
      }
      AppMethodBeat.o(115906);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmz
 * JD-Core Version:    0.7.0.1
 */