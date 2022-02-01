package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qs
  extends com.tencent.mm.bx.a
{
  public int CQA;
  public int CQB;
  public long CQC;
  public int CQf;
  public String CQg;
  public rc CQh;
  public String CQi;
  public String CQp;
  public String CQq;
  public String CQr;
  public String CQs;
  public LinkedList<qr> CQt;
  public LinkedList<qq> CQu;
  public String CQv;
  public String CQw;
  public rc CQx;
  public qr CQy;
  public int CQz;
  
  public qs()
  {
    AppMethodBeat.i(113954);
    this.CQt = new LinkedList();
    this.CQu = new LinkedList();
    AppMethodBeat.o(113954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CQp != null) {
        paramVarArgs.d(1, this.CQp);
      }
      if (this.CQq != null) {
        paramVarArgs.d(2, this.CQq);
      }
      if (this.CQr != null) {
        paramVarArgs.d(3, this.CQr);
      }
      if (this.CQs != null) {
        paramVarArgs.d(4, this.CQs);
      }
      paramVarArgs.e(5, 8, this.CQt);
      paramVarArgs.aR(6, this.CQf);
      if (this.CQg != null) {
        paramVarArgs.d(7, this.CQg);
      }
      if (this.CQh != null)
      {
        paramVarArgs.kX(8, this.CQh.computeSize());
        this.CQh.writeFields(paramVarArgs);
      }
      if (this.CQi != null) {
        paramVarArgs.d(9, this.CQi);
      }
      paramVarArgs.e(10, 8, this.CQu);
      if (this.CQv != null) {
        paramVarArgs.d(11, this.CQv);
      }
      if (this.CQw != null) {
        paramVarArgs.d(12, this.CQw);
      }
      if (this.CQx != null)
      {
        paramVarArgs.kX(13, this.CQx.computeSize());
        this.CQx.writeFields(paramVarArgs);
      }
      if (this.CQy != null)
      {
        paramVarArgs.kX(14, this.CQy.computeSize());
        this.CQy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(15, this.CQz);
      paramVarArgs.aR(16, this.CQA);
      paramVarArgs.aR(17, this.CQB);
      paramVarArgs.aG(18, this.CQC);
      AppMethodBeat.o(113955);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CQp == null) {
        break label1630;
      }
    }
    label1630:
    for (int i = f.a.a.b.b.a.e(1, this.CQp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CQq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CQq);
      }
      i = paramInt;
      if (this.CQr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CQr);
      }
      paramInt = i;
      if (this.CQs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CQs);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.CQt) + f.a.a.b.b.a.bA(6, this.CQf);
      paramInt = i;
      if (this.CQg != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CQg);
      }
      i = paramInt;
      if (this.CQh != null) {
        i = paramInt + f.a.a.a.kW(8, this.CQh.computeSize());
      }
      paramInt = i;
      if (this.CQi != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CQi);
      }
      i = paramInt + f.a.a.a.c(10, 8, this.CQu);
      paramInt = i;
      if (this.CQv != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CQv);
      }
      i = paramInt;
      if (this.CQw != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.CQw);
      }
      paramInt = i;
      if (this.CQx != null) {
        paramInt = i + f.a.a.a.kW(13, this.CQx.computeSize());
      }
      i = paramInt;
      if (this.CQy != null) {
        i = paramInt + f.a.a.a.kW(14, this.CQy.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(15, this.CQz);
      int j = f.a.a.b.b.a.bA(16, this.CQA);
      int k = f.a.a.b.b.a.bA(17, this.CQB);
      int m = f.a.a.b.b.a.q(18, this.CQC);
      AppMethodBeat.o(113955);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CQt.clear();
        this.CQu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113955);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qs localqs = (qs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113955);
          return -1;
        case 1: 
          localqs.CQp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 2: 
          localqs.CQq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 3: 
          localqs.CQr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 4: 
          localqs.CQs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqs.CQt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 6: 
          localqs.CQf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113955);
          return 0;
        case 7: 
          localqs.CQg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqs.CQh = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 9: 
          localqs.CQi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqs.CQu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 11: 
          localqs.CQv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 12: 
          localqs.CQw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqs.CQx = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqs.CQy = ((qr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 15: 
          localqs.CQz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113955);
          return 0;
        case 16: 
          localqs.CQA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113955);
          return 0;
        case 17: 
          localqs.CQB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113955);
          return 0;
        }
        localqs.CQC = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(113955);
        return 0;
      }
      AppMethodBeat.o(113955);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qs
 * JD-Core Version:    0.7.0.1
 */