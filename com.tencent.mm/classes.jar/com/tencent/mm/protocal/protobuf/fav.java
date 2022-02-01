package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fav
  extends esc
{
  public int PzN;
  public int PzQ;
  public String PzR;
  public String PzS;
  public String PzT;
  public String PzU;
  public String PzV;
  public boolean PzW;
  public int end_time;
  public String iaJ;
  public String mee;
  public String nQG;
  public String nRQ;
  public String title;
  public String wsA;
  public String wsy;
  public String wsz;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32439);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32439);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuj);
      if (this.wsy != null) {
        paramVarArgs.g(3, this.wsy);
      }
      if (this.iaJ != null) {
        paramVarArgs.g(4, this.iaJ);
      }
      if (this.title != null) {
        paramVarArgs.g(5, this.title);
      }
      if (this.wsz != null) {
        paramVarArgs.g(6, this.wsz);
      }
      if (this.wsA != null) {
        paramVarArgs.g(7, this.wsA);
      }
      if (this.mee != null) {
        paramVarArgs.g(8, this.mee);
      }
      if (this.nQG != null) {
        paramVarArgs.g(9, this.nQG);
      }
      if (this.nRQ != null) {
        paramVarArgs.g(10, this.nRQ);
      }
      paramVarArgs.bS(11, this.PzN);
      paramVarArgs.bS(12, this.PzQ);
      if (this.PzR != null) {
        paramVarArgs.g(13, this.PzR);
      }
      if (this.PzS != null) {
        paramVarArgs.g(14, this.PzS);
      }
      if (this.PzT != null) {
        paramVarArgs.g(19, this.PzT);
      }
      if (this.PzU != null) {
        paramVarArgs.g(21, this.PzU);
      }
      paramVarArgs.bS(22, this.end_time);
      if (this.PzV != null) {
        paramVarArgs.g(23, this.PzV);
      }
      paramVarArgs.di(24, this.PzW);
      AppMethodBeat.o(32439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1405;
      }
    }
    label1405:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuj);
      paramInt = i;
      if (this.wsy != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wsy);
      }
      i = paramInt;
      if (this.iaJ != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.iaJ);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.title);
      }
      i = paramInt;
      if (this.wsz != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.wsz);
      }
      paramInt = i;
      if (this.wsA != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.wsA);
      }
      i = paramInt;
      if (this.mee != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.mee);
      }
      paramInt = i;
      if (this.nQG != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.nQG);
      }
      i = paramInt;
      if (this.nRQ != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.nRQ);
      }
      i = i + i.a.a.b.b.a.cJ(11, this.PzN) + i.a.a.b.b.a.cJ(12, this.PzQ);
      paramInt = i;
      if (this.PzR != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.PzR);
      }
      i = paramInt;
      if (this.PzS != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.PzS);
      }
      paramInt = i;
      if (this.PzT != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.PzT);
      }
      i = paramInt;
      if (this.PzU != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.PzU);
      }
      i += i.a.a.b.b.a.cJ(22, this.end_time);
      paramInt = i;
      if (this.PzV != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.PzV);
      }
      i = i.a.a.b.b.a.ko(24);
      AppMethodBeat.o(32439);
      return paramInt + (i + 1);
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
          AppMethodBeat.o(32439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fav localfav = (fav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 20: 
        default: 
          AppMethodBeat.o(32439);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localfav.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(32439);
          return 0;
        case 2: 
          localfav.wuj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32439);
          return 0;
        case 3: 
          localfav.wsy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 4: 
          localfav.iaJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 5: 
          localfav.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 6: 
          localfav.wsz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 7: 
          localfav.wsA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 8: 
          localfav.mee = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 9: 
          localfav.nQG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 10: 
          localfav.nRQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 11: 
          localfav.PzN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32439);
          return 0;
        case 12: 
          localfav.PzQ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32439);
          return 0;
        case 13: 
          localfav.PzR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 14: 
          localfav.PzS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 19: 
          localfav.PzT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 21: 
          localfav.PzU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        case 22: 
          localfav.end_time = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32439);
          return 0;
        case 23: 
          localfav.PzV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32439);
          return 0;
        }
        localfav.PzW = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(32439);
        return 0;
      }
      AppMethodBeat.o(32439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fav
 * JD-Core Version:    0.7.0.1
 */