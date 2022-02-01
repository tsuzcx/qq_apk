package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class efy
  extends esc
{
  public int UZF;
  public String UZz;
  public String aaPY;
  public boolean aaPZ;
  public LinkedList<xe> aaoI;
  public dcc abli;
  public ehr ablj;
  public String ablk;
  public int abll;
  public long ablm;
  public String abln;
  public String ablo;
  public String ablp;
  public String ablq;
  public LinkedList<env> ablr;
  public String wuA;
  public int wuz;
  
  public efy()
  {
    AppMethodBeat.i(91622);
    this.aaoI = new LinkedList();
    this.aaPZ = true;
    this.ablr = new LinkedList();
    AppMethodBeat.o(91622);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91623);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91623);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.abli != null)
      {
        paramVarArgs.qD(4, this.abli.computeSize());
        this.abli.writeFields(paramVarArgs);
      }
      if (this.ablj != null)
      {
        paramVarArgs.qD(5, this.ablj.computeSize());
        this.ablj.writeFields(paramVarArgs);
      }
      if (this.aaPY != null) {
        paramVarArgs.g(6, this.aaPY);
      }
      paramVarArgs.e(7, 8, this.aaoI);
      paramVarArgs.di(8, this.aaPZ);
      paramVarArgs.bS(9, this.UZF);
      if (this.ablk != null) {
        paramVarArgs.g(10, this.ablk);
      }
      paramVarArgs.bS(11, this.abll);
      paramVarArgs.bv(12, this.ablm);
      if (this.UZz != null) {
        paramVarArgs.g(13, this.UZz);
      }
      if (this.abln != null) {
        paramVarArgs.g(14, this.abln);
      }
      if (this.ablo != null) {
        paramVarArgs.g(15, this.ablo);
      }
      if (this.ablp != null) {
        paramVarArgs.g(16, this.ablp);
      }
      if (this.ablq != null) {
        paramVarArgs.g(17, this.ablq);
      }
      paramVarArgs.e(18, 8, this.ablr);
      AppMethodBeat.o(91623);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1552;
      }
    }
    label1552:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.abli != null) {
        i = paramInt + i.a.a.a.qC(4, this.abli.computeSize());
      }
      paramInt = i;
      if (this.ablj != null) {
        paramInt = i + i.a.a.a.qC(5, this.ablj.computeSize());
      }
      i = paramInt;
      if (this.aaPY != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aaPY);
      }
      i = i + i.a.a.a.c(7, 8, this.aaoI) + (i.a.a.b.b.a.ko(8) + 1) + i.a.a.b.b.a.cJ(9, this.UZF);
      paramInt = i;
      if (this.ablk != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ablk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.abll) + i.a.a.b.b.a.q(12, this.ablm);
      paramInt = i;
      if (this.UZz != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.UZz);
      }
      i = paramInt;
      if (this.abln != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.abln);
      }
      paramInt = i;
      if (this.ablo != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.ablo);
      }
      i = paramInt;
      if (this.ablp != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.ablp);
      }
      paramInt = i;
      if (this.ablq != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.ablq);
      }
      i = i.a.a.a.c(18, 8, this.ablr);
      AppMethodBeat.o(91623);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaoI.clear();
        this.ablr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91623);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        efy localefy = (efy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91623);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localefy.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 2: 
          localefy.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91623);
          return 0;
        case 3: 
          localefy.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcc)localObject2).parseFrom((byte[])localObject1);
            }
            localefy.abli = ((dcc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehr)localObject2).parseFrom((byte[])localObject1);
            }
            localefy.ablj = ((ehr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 6: 
          localefy.aaPY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new xe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((xe)localObject2).parseFrom((byte[])localObject1);
            }
            localefy.aaoI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 8: 
          localefy.aaPZ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91623);
          return 0;
        case 9: 
          localefy.UZF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91623);
          return 0;
        case 10: 
          localefy.ablk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 11: 
          localefy.abll = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91623);
          return 0;
        case 12: 
          localefy.ablm = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91623);
          return 0;
        case 13: 
          localefy.UZz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 14: 
          localefy.abln = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 15: 
          localefy.ablo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 16: 
          localefy.ablp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 17: 
          localefy.ablq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91623);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new env();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((env)localObject2).parseFrom((byte[])localObject1);
          }
          localefy.ablr.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      AppMethodBeat.o(91623);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efy
 * JD-Core Version:    0.7.0.1
 */