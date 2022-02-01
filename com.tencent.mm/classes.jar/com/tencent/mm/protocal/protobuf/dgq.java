package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dgq
  extends dyy
{
  public int EtH;
  public int EtI;
  public String EtJ;
  public String EtK;
  public String EtL;
  public long InT;
  public int RDl;
  public dtj Sih;
  public int TNk;
  public int TNl;
  public int TNm;
  public long TNn;
  public LinkedList<cih> TNo;
  public String TNp;
  public String TNq;
  public String TNr;
  public int TNs;
  public int TNt;
  public String TNu;
  public long gbJ;
  
  public dgq()
  {
    AppMethodBeat.i(91566);
    this.TNo = new LinkedList();
    AppMethodBeat.o(91566);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91567);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TNk);
      paramVarArgs.aY(3, this.TNl);
      paramVarArgs.aY(4, this.EtH);
      paramVarArgs.bm(5, this.gbJ);
      paramVarArgs.aY(6, this.TNm);
      paramVarArgs.bm(7, this.TNn);
      paramVarArgs.aY(8, this.RDl);
      paramVarArgs.bm(9, this.InT);
      paramVarArgs.aY(10, this.EtI);
      paramVarArgs.e(11, 8, this.TNo);
      if (this.EtJ != null) {
        paramVarArgs.f(12, this.EtJ);
      }
      if (this.TNp != null) {
        paramVarArgs.f(13, this.TNp);
      }
      if (this.TNq != null) {
        paramVarArgs.f(14, this.TNq);
      }
      if (this.TNr != null) {
        paramVarArgs.f(15, this.TNr);
      }
      paramVarArgs.aY(16, this.TNs);
      if (this.EtL != null) {
        paramVarArgs.f(17, this.EtL);
      }
      paramVarArgs.aY(18, this.TNt);
      if (this.EtK != null) {
        paramVarArgs.f(19, this.EtK);
      }
      if (this.Sih != null)
      {
        paramVarArgs.oE(20, this.Sih.computeSize());
        this.Sih.writeFields(paramVarArgs);
      }
      if (this.TNu != null) {
        paramVarArgs.f(21, this.TNu);
      }
      AppMethodBeat.o(91567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1504;
      }
    }
    label1504:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TNk) + g.a.a.b.b.a.bM(3, this.TNl) + g.a.a.b.b.a.bM(4, this.EtH) + g.a.a.b.b.a.p(5, this.gbJ) + g.a.a.b.b.a.bM(6, this.TNm) + g.a.a.b.b.a.p(7, this.TNn) + g.a.a.b.b.a.bM(8, this.RDl) + g.a.a.b.b.a.p(9, this.InT) + g.a.a.b.b.a.bM(10, this.EtI) + g.a.a.a.c(11, 8, this.TNo);
      paramInt = i;
      if (this.EtJ != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.EtJ);
      }
      i = paramInt;
      if (this.TNp != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.TNp);
      }
      paramInt = i;
      if (this.TNq != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.TNq);
      }
      i = paramInt;
      if (this.TNr != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.TNr);
      }
      i += g.a.a.b.b.a.bM(16, this.TNs);
      paramInt = i;
      if (this.EtL != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.EtL);
      }
      i = paramInt + g.a.a.b.b.a.bM(18, this.TNt);
      paramInt = i;
      if (this.EtK != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.EtK);
      }
      i = paramInt;
      if (this.Sih != null) {
        i = paramInt + g.a.a.a.oD(20, this.Sih.computeSize());
      }
      paramInt = i;
      if (this.TNu != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.TNu);
      }
      AppMethodBeat.o(91567);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TNo.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dgq localdgq = (dgq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91567);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localdgq.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 2: 
          localdgq.TNk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91567);
          return 0;
        case 3: 
          localdgq.TNl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91567);
          return 0;
        case 4: 
          localdgq.EtH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91567);
          return 0;
        case 5: 
          localdgq.gbJ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91567);
          return 0;
        case 6: 
          localdgq.TNm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91567);
          return 0;
        case 7: 
          localdgq.TNn = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91567);
          return 0;
        case 8: 
          localdgq.RDl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91567);
          return 0;
        case 9: 
          localdgq.InT = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91567);
          return 0;
        case 10: 
          localdgq.EtI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91567);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cih();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cih)localObject2).parseFrom((byte[])localObject1);
            }
            localdgq.TNo.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 12: 
          localdgq.EtJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 13: 
          localdgq.TNp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 14: 
          localdgq.TNq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 15: 
          localdgq.TNr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 16: 
          localdgq.TNs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91567);
          return 0;
        case 17: 
          localdgq.EtL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 18: 
          localdgq.TNt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91567);
          return 0;
        case 19: 
          localdgq.EtK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtj)localObject2).parseFrom((byte[])localObject1);
            }
            localdgq.Sih = ((dtj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        }
        localdgq.TNu = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91567);
        return 0;
      }
      AppMethodBeat.o(91567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgq
 * JD-Core Version:    0.7.0.1
 */