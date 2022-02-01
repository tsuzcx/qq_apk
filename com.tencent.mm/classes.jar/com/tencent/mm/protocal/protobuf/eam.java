package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eam
  extends cvw
{
  public int GvC;
  public int HER;
  public long Idp;
  public eal Iek;
  public eal Igp;
  public eal Igq;
  public eal Igr;
  public eal Igs;
  public int Igt;
  public LinkedList<cxn> Igu;
  public LinkedList<cxn> Igv;
  public LinkedList<cxn> Igw;
  public int Igx;
  public LinkedList<cxn> Igy;
  
  public eam()
  {
    AppMethodBeat.i(115921);
    this.Igu = new LinkedList();
    this.Igv = new LinkedList();
    this.Igw = new LinkedList();
    this.Igy = new LinkedList();
    AppMethodBeat.o(115921);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115922);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Iek == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Iek != null)
      {
        paramVarArgs.lJ(2, this.Iek.computeSize());
        this.Iek.writeFields(paramVarArgs);
      }
      if (this.Igp != null)
      {
        paramVarArgs.lJ(3, this.Igp.computeSize());
        this.Igp.writeFields(paramVarArgs);
      }
      if (this.Igq != null)
      {
        paramVarArgs.lJ(4, this.Igq.computeSize());
        this.Igq.writeFields(paramVarArgs);
      }
      if (this.Igr != null)
      {
        paramVarArgs.lJ(5, this.Igr.computeSize());
        this.Igr.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.Idp);
      if (this.Igs != null)
      {
        paramVarArgs.lJ(7, this.Igs.computeSize());
        this.Igs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.Igt);
      paramVarArgs.e(9, 8, this.Igu);
      paramVarArgs.aS(10, this.GvC);
      paramVarArgs.e(11, 8, this.Igv);
      paramVarArgs.aS(12, this.HER);
      paramVarArgs.e(13, 8, this.Igw);
      paramVarArgs.aS(14, this.Igx);
      paramVarArgs.e(15, 8, this.Igy);
      AppMethodBeat.o(115922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1942;
      }
    }
    label1942:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Iek != null) {
        paramInt = i + f.a.a.a.lI(2, this.Iek.computeSize());
      }
      i = paramInt;
      if (this.Igp != null) {
        i = paramInt + f.a.a.a.lI(3, this.Igp.computeSize());
      }
      paramInt = i;
      if (this.Igq != null) {
        paramInt = i + f.a.a.a.lI(4, this.Igq.computeSize());
      }
      i = paramInt;
      if (this.Igr != null) {
        i = paramInt + f.a.a.a.lI(5, this.Igr.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.Idp);
      paramInt = i;
      if (this.Igs != null) {
        paramInt = i + f.a.a.a.lI(7, this.Igs.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.Igt);
      int j = f.a.a.a.c(9, 8, this.Igu);
      int k = f.a.a.b.b.a.bz(10, this.GvC);
      int m = f.a.a.a.c(11, 8, this.Igv);
      int n = f.a.a.b.b.a.bz(12, this.HER);
      int i1 = f.a.a.a.c(13, 8, this.Igw);
      int i2 = f.a.a.b.b.a.bz(14, this.Igx);
      int i3 = f.a.a.a.c(15, 8, this.Igy);
      AppMethodBeat.o(115922);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Igu.clear();
        this.Igv.clear();
        this.Igw.clear();
        this.Igy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Iek == null)
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
        eam localeam = (eam)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115922);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeam.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eal();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eal)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeam.Iek = ((eal)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eal();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eal)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeam.Igp = ((eal)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eal();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eal)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeam.Igq = ((eal)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eal();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eal)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeam.Igr = ((eal)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 6: 
          localeam.Idp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115922);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eal();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eal)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeam.Igs = ((eal)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 8: 
          localeam.Igt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115922);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeam.Igu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 10: 
          localeam.GvC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115922);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeam.Igv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 12: 
          localeam.HER = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115922);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeam.Igw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 14: 
          localeam.Igx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115922);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeam.Igy.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eam
 * JD-Core Version:    0.7.0.1
 */