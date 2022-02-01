package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eoj
  extends esc
{
  public String JFk;
  public String MEp;
  public String Vbl;
  public int ablD;
  public boolean absF;
  public boolean absG;
  public String absH;
  public String absI;
  public String absJ;
  public String absK;
  public dkf ifY;
  public int status;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91666);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91666);
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
      paramVarArgs.di(4, this.absF);
      paramVarArgs.di(5, this.absG);
      paramVarArgs.bS(6, this.status);
      if (this.absH != null) {
        paramVarArgs.g(7, this.absH);
      }
      if (this.absI != null) {
        paramVarArgs.g(8, this.absI);
      }
      paramVarArgs.bS(9, this.ablD);
      if (this.JFk != null) {
        paramVarArgs.g(10, this.JFk);
      }
      if (this.MEp != null) {
        paramVarArgs.g(11, this.MEp);
      }
      if (this.absJ != null) {
        paramVarArgs.g(12, this.absJ);
      }
      if (this.absK != null) {
        paramVarArgs.g(13, this.absK);
      }
      if (this.ifY != null)
      {
        paramVarArgs.qD(99, this.ifY.computeSize());
        this.ifY.writeFields(paramVarArgs);
      }
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(91666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1234;
      }
    }
    label1234:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + (i.a.a.b.b.a.ko(4) + 1) + (i.a.a.b.b.a.ko(5) + 1) + i.a.a.b.b.a.cJ(6, this.status);
      paramInt = i;
      if (this.absH != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.absH);
      }
      i = paramInt;
      if (this.absI != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.absI);
      }
      i += i.a.a.b.b.a.cJ(9, this.ablD);
      paramInt = i;
      if (this.JFk != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.JFk);
      }
      i = paramInt;
      if (this.MEp != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.MEp);
      }
      paramInt = i;
      if (this.absJ != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.absJ);
      }
      i = paramInt;
      if (this.absK != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.absK);
      }
      paramInt = i;
      if (this.ifY != null) {
        paramInt = i + i.a.a.a.qC(99, this.ifY.computeSize());
      }
      i = paramInt;
      if (this.Vbl != null) {
        i = paramInt + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(91666);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91666);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eoj localeoj = (eoj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91666);
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
            localeoj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91666);
          return 0;
        case 2: 
          localeoj.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91666);
          return 0;
        case 3: 
          localeoj.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 4: 
          localeoj.absF = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91666);
          return 0;
        case 5: 
          localeoj.absG = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91666);
          return 0;
        case 6: 
          localeoj.status = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91666);
          return 0;
        case 7: 
          localeoj.absH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 8: 
          localeoj.absI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 9: 
          localeoj.ablD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91666);
          return 0;
        case 10: 
          localeoj.JFk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 11: 
          localeoj.MEp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 12: 
          localeoj.absJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 13: 
          localeoj.absK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 99: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dkf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dkf)localObject2).parseFrom((byte[])localObject1);
            }
            localeoj.ifY = ((dkf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91666);
          return 0;
        }
        localeoj.Vbl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91666);
        return 0;
      }
      AppMethodBeat.o(91666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoj
 * JD-Core Version:    0.7.0.1
 */