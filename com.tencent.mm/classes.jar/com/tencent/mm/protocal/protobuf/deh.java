package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class deh
  extends dyy
{
  public String OmF;
  public ctc TLK;
  public String TLL;
  public ani TLM;
  public int TLP;
  public int TLQ;
  public LinkedList<aib> TLR;
  public LinkedList<dvo> TLS;
  public LinkedList<iu> TLT;
  public dmu TLU;
  public int TLV;
  public String TLW;
  public dmt TLX;
  public dmt TLY;
  public String TLZ;
  public acs TMa;
  public dmt TMb;
  public boolean TwU;
  public int dta;
  public ctd fZQ;
  public int tqa;
  public String tqb;
  
  public deh()
  {
    AppMethodBeat.i(91561);
    this.TLR = new LinkedList();
    this.TLS = new LinkedList();
    this.TLT = new LinkedList();
    AppMethodBeat.o(91561);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91562);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91562);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.aY(4, this.dta);
      paramVarArgs.aY(5, this.TLP);
      paramVarArgs.aY(6, this.TLQ);
      paramVarArgs.e(8, 8, this.TLR);
      if (this.TLK != null)
      {
        paramVarArgs.oE(9, this.TLK.computeSize());
        this.TLK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.TLS);
      paramVarArgs.e(11, 8, this.TLT);
      paramVarArgs.co(12, this.TwU);
      if (this.TLU != null)
      {
        paramVarArgs.oE(13, this.TLU.computeSize());
        this.TLU.writeFields(paramVarArgs);
      }
      if (this.TLL != null) {
        paramVarArgs.f(14, this.TLL);
      }
      if (this.TLM != null)
      {
        paramVarArgs.oE(15, this.TLM.computeSize());
        this.TLM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(16, this.TLV);
      if (this.TLW != null) {
        paramVarArgs.f(17, this.TLW);
      }
      if (this.TLX != null)
      {
        paramVarArgs.oE(18, this.TLX.computeSize());
        this.TLX.writeFields(paramVarArgs);
      }
      if (this.TLY != null)
      {
        paramVarArgs.oE(19, this.TLY.computeSize());
        this.TLY.writeFields(paramVarArgs);
      }
      if (this.TLZ != null) {
        paramVarArgs.f(20, this.TLZ);
      }
      if (this.TMa != null)
      {
        paramVarArgs.oE(21, this.TMa.computeSize());
        this.TMa.writeFields(paramVarArgs);
      }
      if (this.TMb != null)
      {
        paramVarArgs.oE(22, this.TMb.computeSize());
        this.TMb.writeFields(paramVarArgs);
      }
      if (this.fZQ != null)
      {
        paramVarArgs.oE(99, this.fZQ.computeSize());
        this.fZQ.writeFields(paramVarArgs);
      }
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(91562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2422;
      }
    }
    label2422:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.dta) + g.a.a.b.b.a.bM(5, this.TLP) + g.a.a.b.b.a.bM(6, this.TLQ) + g.a.a.a.c(8, 8, this.TLR);
      paramInt = i;
      if (this.TLK != null) {
        paramInt = i + g.a.a.a.oD(9, this.TLK.computeSize());
      }
      i = paramInt + g.a.a.a.c(10, 8, this.TLS) + g.a.a.a.c(11, 8, this.TLT) + (g.a.a.b.b.a.gL(12) + 1);
      paramInt = i;
      if (this.TLU != null) {
        paramInt = i + g.a.a.a.oD(13, this.TLU.computeSize());
      }
      i = paramInt;
      if (this.TLL != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.TLL);
      }
      paramInt = i;
      if (this.TLM != null) {
        paramInt = i + g.a.a.a.oD(15, this.TLM.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.TLV);
      paramInt = i;
      if (this.TLW != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.TLW);
      }
      i = paramInt;
      if (this.TLX != null) {
        i = paramInt + g.a.a.a.oD(18, this.TLX.computeSize());
      }
      paramInt = i;
      if (this.TLY != null) {
        paramInt = i + g.a.a.a.oD(19, this.TLY.computeSize());
      }
      i = paramInt;
      if (this.TLZ != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.TLZ);
      }
      paramInt = i;
      if (this.TMa != null) {
        paramInt = i + g.a.a.a.oD(21, this.TMa.computeSize());
      }
      i = paramInt;
      if (this.TMb != null) {
        i = paramInt + g.a.a.a.oD(22, this.TMb.computeSize());
      }
      paramInt = i;
      if (this.fZQ != null) {
        paramInt = i + g.a.a.a.oD(99, this.fZQ.computeSize());
      }
      i = paramInt;
      if (this.OmF != null) {
        i = paramInt + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(91562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TLR.clear();
        this.TLS.clear();
        this.TLT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        deh localdeh = (deh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91562);
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
            localdeh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 2: 
          localdeh.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91562);
          return 0;
        case 3: 
          localdeh.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 4: 
          localdeh.dta = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91562);
          return 0;
        case 5: 
          localdeh.TLP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91562);
          return 0;
        case 6: 
          localdeh.TLQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91562);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aib();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aib)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.TLR.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ctc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ctc)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.TLK = ((ctc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dvo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dvo)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.TLS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new iu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((iu)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.TLT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 12: 
          localdeh.TwU = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91562);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmu)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.TLU = ((dmu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 14: 
          localdeh.TLL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ani();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ani)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.TLM = ((ani)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 16: 
          localdeh.TLV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91562);
          return 0;
        case 17: 
          localdeh.TLW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmt)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.TLX = ((dmt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmt)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.TLY = ((dmt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 20: 
          localdeh.TLZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new acs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((acs)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.TMa = ((acs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmt)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.TMb = ((dmt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 99: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ctd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ctd)localObject2).parseFrom((byte[])localObject1);
            }
            localdeh.fZQ = ((ctd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        }
        localdeh.OmF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91562);
        return 0;
      }
      AppMethodBeat.o(91562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deh
 * JD-Core Version:    0.7.0.1
 */