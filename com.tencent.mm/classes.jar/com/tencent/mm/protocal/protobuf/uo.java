package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uo
  extends cwj
{
  public String DkG;
  public int Gmb;
  public LinkedList<bzq> Gmi;
  public bzq Gmj;
  public String Gmk;
  public boolean Gml;
  public String Gmm;
  public int Gmn;
  public bzx Gmo;
  public cru Gmp;
  public String Gmq;
  public String Gmr;
  public String Gms;
  public cop Gmt;
  public cop Gmu;
  public cop Gmv;
  public com.tencent.mm.bw.b Gmw;
  public int dmy;
  public String iWA;
  public String iWB;
  public String url;
  public int yoP;
  public String yoQ;
  public String yoR;
  
  public uo()
  {
    AppMethodBeat.i(91406);
    this.Gmi = new LinkedList();
    AppMethodBeat.o(91406);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91407);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91407);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.e(3, 8, this.Gmi);
      if (this.Gmj != null)
      {
        paramVarArgs.lJ(4, this.Gmj.computeSize());
        this.Gmj.writeFields(paramVarArgs);
      }
      if (this.DkG != null) {
        paramVarArgs.d(5, this.DkG);
      }
      if (this.Gmk != null) {
        paramVarArgs.d(6, this.Gmk);
      }
      paramVarArgs.bC(7, this.Gml);
      paramVarArgs.aS(8, this.yoP);
      if (this.Gmm != null) {
        paramVarArgs.d(9, this.Gmm);
      }
      if (this.yoQ != null) {
        paramVarArgs.d(10, this.yoQ);
      }
      if (this.yoR != null) {
        paramVarArgs.d(11, this.yoR);
      }
      paramVarArgs.aS(12, this.Gmn);
      if (this.Gmo != null)
      {
        paramVarArgs.lJ(13, this.Gmo.computeSize());
        this.Gmo.writeFields(paramVarArgs);
      }
      if (this.Gmp != null)
      {
        paramVarArgs.lJ(14, this.Gmp.computeSize());
        this.Gmp.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(15, this.dmy);
      paramVarArgs.aS(16, this.Gmb);
      if (this.iWA != null) {
        paramVarArgs.d(17, this.iWA);
      }
      if (this.iWB != null) {
        paramVarArgs.d(18, this.iWB);
      }
      if (this.Gmq != null) {
        paramVarArgs.d(19, this.Gmq);
      }
      if (this.Gmr != null) {
        paramVarArgs.d(20, this.Gmr);
      }
      if (this.Gms != null) {
        paramVarArgs.d(21, this.Gms);
      }
      if (this.Gmt != null)
      {
        paramVarArgs.lJ(22, this.Gmt.computeSize());
        this.Gmt.writeFields(paramVarArgs);
      }
      if (this.Gmu != null)
      {
        paramVarArgs.lJ(23, this.Gmu.computeSize());
        this.Gmu.writeFields(paramVarArgs);
      }
      if (this.Gmv != null)
      {
        paramVarArgs.lJ(24, this.Gmv.computeSize());
        this.Gmv.writeFields(paramVarArgs);
      }
      if (this.Gmw != null) {
        paramVarArgs.c(25, this.Gmw);
      }
      AppMethodBeat.o(91407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2394;
      }
    }
    label2394:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i += f.a.a.a.c(3, 8, this.Gmi);
      paramInt = i;
      if (this.Gmj != null) {
        paramInt = i + f.a.a.a.lI(4, this.Gmj.computeSize());
      }
      i = paramInt;
      if (this.DkG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DkG);
      }
      paramInt = i;
      if (this.Gmk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gmk);
      }
      i = paramInt + f.a.a.b.b.a.amF(7) + f.a.a.b.b.a.bz(8, this.yoP);
      paramInt = i;
      if (this.Gmm != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Gmm);
      }
      i = paramInt;
      if (this.yoQ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.yoQ);
      }
      paramInt = i;
      if (this.yoR != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.yoR);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.Gmn);
      paramInt = i;
      if (this.Gmo != null) {
        paramInt = i + f.a.a.a.lI(13, this.Gmo.computeSize());
      }
      i = paramInt;
      if (this.Gmp != null) {
        i = paramInt + f.a.a.a.lI(14, this.Gmp.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(15, this.dmy) + f.a.a.b.b.a.bz(16, this.Gmb);
      paramInt = i;
      if (this.iWA != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.iWA);
      }
      i = paramInt;
      if (this.iWB != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.iWB);
      }
      paramInt = i;
      if (this.Gmq != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.Gmq);
      }
      i = paramInt;
      if (this.Gmr != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.Gmr);
      }
      paramInt = i;
      if (this.Gms != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.Gms);
      }
      i = paramInt;
      if (this.Gmt != null) {
        i = paramInt + f.a.a.a.lI(22, this.Gmt.computeSize());
      }
      paramInt = i;
      if (this.Gmu != null) {
        paramInt = i + f.a.a.a.lI(23, this.Gmu.computeSize());
      }
      i = paramInt;
      if (this.Gmv != null) {
        i = paramInt + f.a.a.a.lI(24, this.Gmv.computeSize());
      }
      paramInt = i;
      if (this.Gmw != null) {
        paramInt = i + f.a.a.b.b.a.b(25, this.Gmw);
      }
      AppMethodBeat.o(91407);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gmi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91407);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uo localuo = (uo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91407);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 2: 
          localuo.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuo.Gmi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuo.Gmj = ((bzq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 5: 
          localuo.DkG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 6: 
          localuo.Gmk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 7: 
          localuo.Gml = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91407);
          return 0;
        case 8: 
          localuo.yoP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91407);
          return 0;
        case 9: 
          localuo.Gmm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 10: 
          localuo.yoQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 11: 
          localuo.yoR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 12: 
          localuo.Gmn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91407);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuo.Gmo = ((bzx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cru();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cru)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuo.Gmp = ((cru)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 15: 
          localuo.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91407);
          return 0;
        case 16: 
          localuo.Gmb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91407);
          return 0;
        case 17: 
          localuo.iWA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 18: 
          localuo.iWB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 19: 
          localuo.Gmq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 20: 
          localuo.Gmr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 21: 
          localuo.Gms = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cop();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cop)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuo.Gmt = ((cop)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cop();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cop)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuo.Gmu = ((cop)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cop();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cop)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuo.Gmv = ((cop)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        }
        localuo.Gmw = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(91407);
        return 0;
      }
      AppMethodBeat.o(91407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uo
 * JD-Core Version:    0.7.0.1
 */