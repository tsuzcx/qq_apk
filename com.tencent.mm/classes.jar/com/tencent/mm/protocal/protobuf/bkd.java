package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bkd
  extends cvp
{
  public LinkedList<atc> Fve;
  public boolean GEB;
  public LinkedList<eix> GEE;
  public LinkedList<eiy> GEF;
  public String GEG;
  public String GEH;
  public String GEI;
  public String GEJ;
  public boolean GEK;
  public int GEL;
  public String GEM;
  public LinkedList<String> GEx;
  public String GEy;
  public String GEz;
  public String hAy;
  public boolean qfl;
  
  public bkd()
  {
    AppMethodBeat.i(32282);
    this.GEE = new LinkedList();
    this.GEF = new LinkedList();
    this.GEx = new LinkedList();
    this.Fve = new LinkedList();
    AppMethodBeat.o(32282);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32283);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.GEG == null)
      {
        paramVarArgs = new b("Not all required fields were included: championcoverurl");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.GEH == null)
      {
        paramVarArgs = new b("Not all required fields were included: championmotto");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.hAy == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GEE);
      paramVarArgs.e(3, 8, this.GEF);
      paramVarArgs.e(4, 1, this.GEx);
      if (this.GEG != null) {
        paramVarArgs.d(5, this.GEG);
      }
      if (this.GEH != null) {
        paramVarArgs.d(6, this.GEH);
      }
      if (this.hAy != null) {
        paramVarArgs.d(7, this.hAy);
      }
      if (this.GEI != null) {
        paramVarArgs.d(8, this.GEI);
      }
      if (this.GEy != null) {
        paramVarArgs.d(9, this.GEy);
      }
      paramVarArgs.bt(10, this.qfl);
      if (this.GEz != null) {
        paramVarArgs.d(11, this.GEz);
      }
      paramVarArgs.e(12, 8, this.Fve);
      paramVarArgs.bt(13, this.GEB);
      if (this.GEJ != null) {
        paramVarArgs.d(14, this.GEJ);
      }
      paramVarArgs.bt(15, this.GEK);
      paramVarArgs.aS(16, this.GEL);
      if (this.GEM != null) {
        paramVarArgs.d(17, this.GEM);
      }
      AppMethodBeat.o(32283);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1669;
      }
    }
    label1669:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GEE) + f.a.a.a.c(3, 8, this.GEF) + f.a.a.a.c(4, 1, this.GEx);
      paramInt = i;
      if (this.GEG != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GEG);
      }
      i = paramInt;
      if (this.GEH != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GEH);
      }
      paramInt = i;
      if (this.hAy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hAy);
      }
      i = paramInt;
      if (this.GEI != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GEI);
      }
      paramInt = i;
      if (this.GEy != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GEy);
      }
      i = paramInt + f.a.a.b.b.a.alV(10);
      paramInt = i;
      if (this.GEz != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GEz);
      }
      i = paramInt + f.a.a.a.c(12, 8, this.Fve) + f.a.a.b.b.a.alV(13);
      paramInt = i;
      if (this.GEJ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GEJ);
      }
      i = paramInt + f.a.a.b.b.a.alV(15) + f.a.a.b.b.a.bz(16, this.GEL);
      paramInt = i;
      if (this.GEM != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GEM);
      }
      AppMethodBeat.o(32283);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GEE.clear();
        this.GEF.clear();
        this.GEx.clear();
        this.Fve.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.GEG == null)
        {
          paramVarArgs = new b("Not all required fields were included: championcoverurl");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.GEH == null)
        {
          paramVarArgs = new b("Not all required fields were included: championmotto");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.hAy == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32283);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkd localbkd = (bkd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32283);
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
            localbkd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eix();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkd.GEE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkd.GEF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 4: 
          localbkd.GEx.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(32283);
          return 0;
        case 5: 
          localbkd.GEG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 6: 
          localbkd.GEH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 7: 
          localbkd.hAy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 8: 
          localbkd.GEI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 9: 
          localbkd.GEy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 10: 
          localbkd.qfl = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(32283);
          return 0;
        case 11: 
          localbkd.GEz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkd.Fve.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 13: 
          localbkd.GEB = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(32283);
          return 0;
        case 14: 
          localbkd.GEJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 15: 
          localbkd.GEK = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(32283);
          return 0;
        case 16: 
          localbkd.GEL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32283);
          return 0;
        }
        localbkd.GEM = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32283);
        return 0;
      }
      AppMethodBeat.o(32283);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkd
 * JD-Core Version:    0.7.0.1
 */