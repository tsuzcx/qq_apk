package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dsf
  extends dyy
{
  public int EtH;
  public int EtI;
  public String EtJ;
  public String EtK;
  public String EtL;
  public long InT;
  public int RDl;
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
  
  public dsf()
  {
    AppMethodBeat.i(91656);
    this.TNo = new LinkedList();
    AppMethodBeat.o(91656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91657);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91657);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.gbJ);
      paramVarArgs.aY(3, this.TNm);
      paramVarArgs.bm(4, this.TNn);
      paramVarArgs.aY(5, this.RDl);
      paramVarArgs.bm(6, this.InT);
      paramVarArgs.aY(9, this.EtI);
      paramVarArgs.e(10, 8, this.TNo);
      if (this.EtJ != null) {
        paramVarArgs.f(11, this.EtJ);
      }
      if (this.TNp != null) {
        paramVarArgs.f(12, this.TNp);
      }
      if (this.TNq != null) {
        paramVarArgs.f(13, this.TNq);
      }
      if (this.TNr != null) {
        paramVarArgs.f(14, this.TNr);
      }
      paramVarArgs.aY(15, this.TNs);
      if (this.EtL != null) {
        paramVarArgs.f(16, this.EtL);
      }
      paramVarArgs.aY(17, this.TNt);
      if (this.EtK != null) {
        paramVarArgs.f(18, this.EtK);
      }
      paramVarArgs.aY(19, this.TNl);
      paramVarArgs.aY(20, this.EtH);
      paramVarArgs.aY(21, this.TNk);
      if (this.TNu != null) {
        paramVarArgs.f(22, this.TNu);
      }
      AppMethodBeat.o(91657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1382;
      }
    }
    label1382:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.gbJ) + g.a.a.b.b.a.bM(3, this.TNm) + g.a.a.b.b.a.p(4, this.TNn) + g.a.a.b.b.a.bM(5, this.RDl) + g.a.a.b.b.a.p(6, this.InT) + g.a.a.b.b.a.bM(9, this.EtI) + g.a.a.a.c(10, 8, this.TNo);
      paramInt = i;
      if (this.EtJ != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.EtJ);
      }
      i = paramInt;
      if (this.TNp != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TNp);
      }
      paramInt = i;
      if (this.TNq != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.TNq);
      }
      i = paramInt;
      if (this.TNr != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.TNr);
      }
      i += g.a.a.b.b.a.bM(15, this.TNs);
      paramInt = i;
      if (this.EtL != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.EtL);
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.TNt);
      paramInt = i;
      if (this.EtK != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.EtK);
      }
      i = paramInt + g.a.a.b.b.a.bM(19, this.TNl) + g.a.a.b.b.a.bM(20, this.EtH) + g.a.a.b.b.a.bM(21, this.TNk);
      paramInt = i;
      if (this.TNu != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.TNu);
      }
      AppMethodBeat.o(91657);
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
          AppMethodBeat.o(91657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dsf localdsf = (dsf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(91657);
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
            localdsf.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 2: 
          localdsf.gbJ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91657);
          return 0;
        case 3: 
          localdsf.TNm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91657);
          return 0;
        case 4: 
          localdsf.TNn = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91657);
          return 0;
        case 5: 
          localdsf.RDl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91657);
          return 0;
        case 6: 
          localdsf.InT = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91657);
          return 0;
        case 9: 
          localdsf.EtI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91657);
          return 0;
        case 10: 
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
            localdsf.TNo.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 11: 
          localdsf.EtJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 12: 
          localdsf.TNp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 13: 
          localdsf.TNq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 14: 
          localdsf.TNr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 15: 
          localdsf.TNs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91657);
          return 0;
        case 16: 
          localdsf.EtL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 17: 
          localdsf.TNt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91657);
          return 0;
        case 18: 
          localdsf.EtK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 19: 
          localdsf.TNl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91657);
          return 0;
        case 20: 
          localdsf.EtH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91657);
          return 0;
        case 21: 
          localdsf.TNk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91657);
          return 0;
        }
        localdsf.TNu = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91657);
        return 0;
      }
      AppMethodBeat.o(91657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsf
 * JD-Core Version:    0.7.0.1
 */