package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhd
  extends cvp
{
  public boolean COK;
  public String CRx;
  public String CRy;
  public LinkedList<String> GCA;
  public brz GCB;
  public boolean GCC;
  public boolean GCD;
  public boolean GCE;
  public LinkedList<crb> GCF;
  public boolean GCG;
  public String GCk;
  public String GCl;
  public String GCm;
  public String GCn;
  public String GCo;
  public boolean GCp;
  public String GCq;
  public long GCr;
  public boolean GCs;
  public boolean GCt;
  public boolean GCu;
  public String GCv;
  public String GCw;
  public String GCx;
  public String GCy;
  public boolean GCz;
  public int dlw;
  public String paA;
  
  public bhd()
  {
    AppMethodBeat.i(91509);
    this.GCA = new LinkedList();
    this.GCF = new LinkedList();
    AppMethodBeat.o(91509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      if (this.GCk != null) {
        paramVarArgs.d(4, this.GCk);
      }
      if (this.GCl != null) {
        paramVarArgs.d(5, this.GCl);
      }
      if (this.GCm != null) {
        paramVarArgs.d(6, this.GCm);
      }
      if (this.GCn != null) {
        paramVarArgs.d(7, this.GCn);
      }
      if (this.GCo != null) {
        paramVarArgs.d(8, this.GCo);
      }
      paramVarArgs.bt(9, this.GCp);
      if (this.GCq != null) {
        paramVarArgs.d(10, this.GCq);
      }
      paramVarArgs.aY(11, this.GCr);
      paramVarArgs.bt(12, this.GCs);
      paramVarArgs.bt(13, this.GCt);
      paramVarArgs.bt(14, this.GCu);
      if (this.GCv != null) {
        paramVarArgs.d(15, this.GCv);
      }
      if (this.GCw != null) {
        paramVarArgs.d(16, this.GCw);
      }
      if (this.GCx != null) {
        paramVarArgs.d(17, this.GCx);
      }
      if (this.GCy != null) {
        paramVarArgs.d(18, this.GCy);
      }
      paramVarArgs.bt(19, this.GCz);
      paramVarArgs.e(20, 1, this.GCA);
      paramVarArgs.bt(21, this.COK);
      if (this.GCB != null)
      {
        paramVarArgs.lC(22, this.GCB.computeSize());
        this.GCB.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(23, this.GCC);
      paramVarArgs.bt(26, this.GCD);
      paramVarArgs.bt(27, this.GCE);
      paramVarArgs.e(28, 8, this.GCF);
      if (this.CRx != null) {
        paramVarArgs.d(29, this.CRx);
      }
      if (this.CRy != null) {
        paramVarArgs.d(30, this.CRy);
      }
      paramVarArgs.bt(31, this.GCG);
      AppMethodBeat.o(91510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2018;
      }
    }
    label2018:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.GCk != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GCk);
      }
      paramInt = i;
      if (this.GCl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GCl);
      }
      i = paramInt;
      if (this.GCm != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GCm);
      }
      paramInt = i;
      if (this.GCn != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GCn);
      }
      i = paramInt;
      if (this.GCo != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GCo);
      }
      i += f.a.a.b.b.a.alV(9);
      paramInt = i;
      if (this.GCq != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GCq);
      }
      i = paramInt + f.a.a.b.b.a.p(11, this.GCr) + f.a.a.b.b.a.alV(12) + f.a.a.b.b.a.alV(13) + f.a.a.b.b.a.alV(14);
      paramInt = i;
      if (this.GCv != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.GCv);
      }
      i = paramInt;
      if (this.GCw != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.GCw);
      }
      paramInt = i;
      if (this.GCx != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GCx);
      }
      i = paramInt;
      if (this.GCy != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.GCy);
      }
      i = i + f.a.a.b.b.a.alV(19) + f.a.a.a.c(20, 1, this.GCA) + f.a.a.b.b.a.alV(21);
      paramInt = i;
      if (this.GCB != null) {
        paramInt = i + f.a.a.a.lB(22, this.GCB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.alV(23) + f.a.a.b.b.a.alV(26) + f.a.a.b.b.a.alV(27) + f.a.a.a.c(28, 8, this.GCF);
      paramInt = i;
      if (this.CRx != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.CRx);
      }
      i = paramInt;
      if (this.CRy != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.CRy);
      }
      paramInt = f.a.a.b.b.a.alV(31);
      AppMethodBeat.o(91510);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GCA.clear();
        this.GCF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhd localbhd = (bhd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 24: 
        case 25: 
        default: 
          AppMethodBeat.o(91510);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 2: 
          localbhd.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91510);
          return 0;
        case 3: 
          localbhd.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 4: 
          localbhd.GCk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 5: 
          localbhd.GCl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 6: 
          localbhd.GCm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 7: 
          localbhd.GCn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 8: 
          localbhd.GCo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 9: 
          localbhd.GCp = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91510);
          return 0;
        case 10: 
          localbhd.GCq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 11: 
          localbhd.GCr = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91510);
          return 0;
        case 12: 
          localbhd.GCs = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91510);
          return 0;
        case 13: 
          localbhd.GCt = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91510);
          return 0;
        case 14: 
          localbhd.GCu = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91510);
          return 0;
        case 15: 
          localbhd.GCv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 16: 
          localbhd.GCw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 17: 
          localbhd.GCx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 18: 
          localbhd.GCy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 19: 
          localbhd.GCz = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91510);
          return 0;
        case 20: 
          localbhd.GCA.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(91510);
          return 0;
        case 21: 
          localbhd.COK = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91510);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhd.GCB = ((brz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 23: 
          localbhd.GCC = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91510);
          return 0;
        case 26: 
          localbhd.GCD = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91510);
          return 0;
        case 27: 
          localbhd.GCE = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91510);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhd.GCF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 29: 
          localbhd.CRx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 30: 
          localbhd.CRy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91510);
          return 0;
        }
        localbhd.GCG = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(91510);
        return 0;
      }
      AppMethodBeat.o(91510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhd
 * JD-Core Version:    0.7.0.1
 */