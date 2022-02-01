package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dnk
  extends ckq
{
  public int Dcs;
  public long EAY;
  public dnj EBT;
  public dnj EDY;
  public dnj EDZ;
  public dnj EEa;
  public dnj EEb;
  public int EEc;
  public LinkedList<cmf> EEd;
  public LinkedList<cmf> EEe;
  public LinkedList<cmf> EEf;
  public int EEg;
  public LinkedList<cmf> EEh;
  public int Eee;
  
  public dnk()
  {
    AppMethodBeat.i(115921);
    this.EEd = new LinkedList();
    this.EEe = new LinkedList();
    this.EEf = new LinkedList();
    this.EEh = new LinkedList();
    AppMethodBeat.o(115921);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115922);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EBT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EBT != null)
      {
        paramVarArgs.kX(2, this.EBT.computeSize());
        this.EBT.writeFields(paramVarArgs);
      }
      if (this.EDY != null)
      {
        paramVarArgs.kX(3, this.EDY.computeSize());
        this.EDY.writeFields(paramVarArgs);
      }
      if (this.EDZ != null)
      {
        paramVarArgs.kX(4, this.EDZ.computeSize());
        this.EDZ.writeFields(paramVarArgs);
      }
      if (this.EEa != null)
      {
        paramVarArgs.kX(5, this.EEa.computeSize());
        this.EEa.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.EAY);
      if (this.EEb != null)
      {
        paramVarArgs.kX(7, this.EEb.computeSize());
        this.EEb.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.EEc);
      paramVarArgs.e(9, 8, this.EEd);
      paramVarArgs.aR(10, this.Dcs);
      paramVarArgs.e(11, 8, this.EEe);
      paramVarArgs.aR(12, this.Eee);
      paramVarArgs.e(13, 8, this.EEf);
      paramVarArgs.aR(14, this.EEg);
      paramVarArgs.e(15, 8, this.EEh);
      AppMethodBeat.o(115922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1942;
      }
    }
    label1942:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EBT != null) {
        paramInt = i + f.a.a.a.kW(2, this.EBT.computeSize());
      }
      i = paramInt;
      if (this.EDY != null) {
        i = paramInt + f.a.a.a.kW(3, this.EDY.computeSize());
      }
      paramInt = i;
      if (this.EDZ != null) {
        paramInt = i + f.a.a.a.kW(4, this.EDZ.computeSize());
      }
      i = paramInt;
      if (this.EEa != null) {
        i = paramInt + f.a.a.a.kW(5, this.EEa.computeSize());
      }
      i += f.a.a.b.b.a.q(6, this.EAY);
      paramInt = i;
      if (this.EEb != null) {
        paramInt = i + f.a.a.a.kW(7, this.EEb.computeSize());
      }
      i = f.a.a.b.b.a.bA(8, this.EEc);
      int j = f.a.a.a.c(9, 8, this.EEd);
      int k = f.a.a.b.b.a.bA(10, this.Dcs);
      int m = f.a.a.a.c(11, 8, this.EEe);
      int n = f.a.a.b.b.a.bA(12, this.Eee);
      int i1 = f.a.a.a.c(13, 8, this.EEf);
      int i2 = f.a.a.b.b.a.bA(14, this.EEg);
      int i3 = f.a.a.a.c(15, 8, this.EEh);
      AppMethodBeat.o(115922);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EEd.clear();
        this.EEe.clear();
        this.EEf.clear();
        this.EEh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EBT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnk localdnk = (dnk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115922);
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
            localdnk.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnk.EBT = ((dnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnk.EDY = ((dnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnk.EDZ = ((dnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnk.EEa = ((dnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 6: 
          localdnk.EAY = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115922);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnk.EEb = ((dnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 8: 
          localdnk.EEc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115922);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnk.EEd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 10: 
          localdnk.Dcs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115922);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnk.EEe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 12: 
          localdnk.Eee = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115922);
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
            localdnk.EEf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 14: 
          localdnk.EEg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115922);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdnk.EEh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115922);
        return 0;
      }
      AppMethodBeat.o(115922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnk
 * JD-Core Version:    0.7.0.1
 */