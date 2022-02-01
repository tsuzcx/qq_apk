package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fln
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public eqm Pyd;
  public String SYn;
  public long Sap;
  public String Sas;
  public int Sat;
  public int TQc;
  public cqh TwK;
  public aam TwL;
  public LinkedList<aci> UIj;
  public int UJW;
  public String UJX;
  public int UKl;
  public String UKm;
  public String UKn;
  public int UKo;
  public LinkedList<String> UKp;
  public LinkedList<ddb> UKq;
  public com.tencent.mm.cd.b UKr;
  public com.tencent.mm.cd.b UKs;
  public ejr UKt;
  public afe UKu;
  public dly UKv;
  public eqj UKw;
  public int Udh;
  public int Udl;
  public LinkedList<ezc> UgB;
  public String vhq;
  
  public fln()
  {
    AppMethodBeat.i(117954);
    this.UgB = new LinkedList();
    this.UKp = new LinkedList();
    this.UJW = 2;
    this.UIj = new LinkedList();
    this.UKq = new LinkedList();
    AppMethodBeat.o(117954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117955);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SYn == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Udh);
      if (this.SYn != null) {
        paramVarArgs.f(2, this.SYn);
      }
      paramVarArgs.aY(3, this.Sat);
      paramVarArgs.bm(4, this.Sap);
      paramVarArgs.aY(5, this.UKl);
      if (this.TwK != null)
      {
        paramVarArgs.oE(6, this.TwK.computeSize());
        this.TwK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.UgB);
      paramVarArgs.aY(8, this.CPw);
      if (this.Sas != null) {
        paramVarArgs.f(9, this.Sas);
      }
      paramVarArgs.aY(10, this.Udl);
      if (this.UKm != null) {
        paramVarArgs.f(11, this.UKm);
      }
      if (this.UKn != null) {
        paramVarArgs.f(12, this.UKn);
      }
      paramVarArgs.aY(13, this.UKo);
      paramVarArgs.e(14, 1, this.UKp);
      paramVarArgs.aY(15, this.UJW);
      if (this.Pyd != null)
      {
        paramVarArgs.oE(16, this.Pyd.computeSize());
        this.Pyd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.UIj);
      paramVarArgs.e(18, 8, this.UKq);
      if (this.vhq != null) {
        paramVarArgs.f(19, this.vhq);
      }
      if (this.UKr != null) {
        paramVarArgs.c(20, this.UKr);
      }
      if (this.UJX != null) {
        paramVarArgs.f(21, this.UJX);
      }
      if (this.UKs != null) {
        paramVarArgs.c(22, this.UKs);
      }
      if (this.UKt != null)
      {
        paramVarArgs.oE(23, this.UKt.computeSize());
        this.UKt.writeFields(paramVarArgs);
      }
      if (this.UKu != null)
      {
        paramVarArgs.oE(24, this.UKu.computeSize());
        this.UKu.writeFields(paramVarArgs);
      }
      if (this.UKv != null)
      {
        paramVarArgs.oE(25, this.UKv.computeSize());
        this.UKv.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(26, this.TQc);
      if (this.TwL != null)
      {
        paramVarArgs.oE(27, this.TwL.computeSize());
        this.TwL.writeFields(paramVarArgs);
      }
      if (this.UKw != null)
      {
        paramVarArgs.oE(28, this.UKw.computeSize());
        this.UKw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Udh) + 0;
      paramInt = i;
      if (this.SYn != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SYn);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.Sat) + g.a.a.b.b.a.p(4, this.Sap) + g.a.a.b.b.a.bM(5, this.UKl);
      paramInt = i;
      if (this.TwK != null) {
        paramInt = i + g.a.a.a.oD(6, this.TwK.computeSize());
      }
      i = paramInt + g.a.a.a.c(7, 8, this.UgB) + g.a.a.b.b.a.bM(8, this.CPw);
      paramInt = i;
      if (this.Sas != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Sas);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.Udl);
      paramInt = i;
      if (this.UKm != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.UKm);
      }
      i = paramInt;
      if (this.UKn != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.UKn);
      }
      i = i + g.a.a.b.b.a.bM(13, this.UKo) + g.a.a.a.c(14, 1, this.UKp) + g.a.a.b.b.a.bM(15, this.UJW);
      paramInt = i;
      if (this.Pyd != null) {
        paramInt = i + g.a.a.a.oD(16, this.Pyd.computeSize());
      }
      i = paramInt + g.a.a.a.c(17, 8, this.UIj) + g.a.a.a.c(18, 8, this.UKq);
      paramInt = i;
      if (this.vhq != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.vhq);
      }
      i = paramInt;
      if (this.UKr != null) {
        i = paramInt + g.a.a.b.b.a.b(20, this.UKr);
      }
      paramInt = i;
      if (this.UJX != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.UJX);
      }
      i = paramInt;
      if (this.UKs != null) {
        i = paramInt + g.a.a.b.b.a.b(22, this.UKs);
      }
      paramInt = i;
      if (this.UKt != null) {
        paramInt = i + g.a.a.a.oD(23, this.UKt.computeSize());
      }
      i = paramInt;
      if (this.UKu != null) {
        i = paramInt + g.a.a.a.oD(24, this.UKu.computeSize());
      }
      paramInt = i;
      if (this.UKv != null) {
        paramInt = i + g.a.a.a.oD(25, this.UKv.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(26, this.TQc);
      paramInt = i;
      if (this.TwL != null) {
        paramInt = i + g.a.a.a.oD(27, this.TwL.computeSize());
      }
      i = paramInt;
      if (this.UKw != null) {
        i = paramInt + g.a.a.a.oD(28, this.UKw.computeSize());
      }
      AppMethodBeat.o(117955);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UgB.clear();
      this.UKp.clear();
      this.UIj.clear();
      this.UKq.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.SYn == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      fln localfln = (fln)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117955);
        return -1;
      case 1: 
        localfln.Udh = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117955);
        return 0;
      case 2: 
        localfln.SYn = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 3: 
        localfln.Sat = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117955);
        return 0;
      case 4: 
        localfln.Sap = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(117955);
        return 0;
      case 5: 
        localfln.UKl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117955);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cqh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cqh)localObject2).parseFrom((byte[])localObject1);
          }
          localfln.TwK = ((cqh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ezc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ezc)localObject2).parseFrom((byte[])localObject1);
          }
          localfln.UgB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 8: 
        localfln.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117955);
        return 0;
      case 9: 
        localfln.Sas = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 10: 
        localfln.Udl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117955);
        return 0;
      case 11: 
        localfln.UKm = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 12: 
        localfln.UKn = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 13: 
        localfln.UKo = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117955);
        return 0;
      case 14: 
        localfln.UKp.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(117955);
        return 0;
      case 15: 
        localfln.UJW = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117955);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eqm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eqm)localObject2).parseFrom((byte[])localObject1);
          }
          localfln.Pyd = ((eqm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 17: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aci();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aci)localObject2).parseFrom((byte[])localObject1);
          }
          localfln.UIj.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 18: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ddb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ddb)localObject2).parseFrom((byte[])localObject1);
          }
          localfln.UKq.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 19: 
        localfln.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 20: 
        localfln.UKr = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(117955);
        return 0;
      case 21: 
        localfln.UJX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 22: 
        localfln.UKs = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(117955);
        return 0;
      case 23: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ejr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ejr)localObject2).parseFrom((byte[])localObject1);
          }
          localfln.UKt = ((ejr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 24: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new afe();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((afe)localObject2).parseFrom((byte[])localObject1);
          }
          localfln.UKu = ((afe)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 25: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dly();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dly)localObject2).parseFrom((byte[])localObject1);
          }
          localfln.UKv = ((dly)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 26: 
        localfln.TQc = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117955);
        return 0;
      case 27: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aam();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aam)localObject2).parseFrom((byte[])localObject1);
          }
          localfln.TwL = ((aam)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new eqj();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((eqj)localObject2).parseFrom((byte[])localObject1);
        }
        localfln.UKw = ((eqj)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    AppMethodBeat.o(117955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fln
 * JD-Core Version:    0.7.0.1
 */