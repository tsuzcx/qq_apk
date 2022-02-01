package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cck
  extends erp
{
  public int IJG;
  public String IMu;
  public int YJZ;
  public String YNW;
  public bi Zbi;
  public String ZiL;
  public String ZjI;
  public String ZjJ;
  public String ZjK;
  public String ZjL;
  public String aalN;
  public String aalQ;
  public String aalR;
  public int aalS;
  public String aalT;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91473);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.ZjI != null) {
        paramVarArgs.g(3, this.ZjI);
      }
      if (this.YNW != null) {
        paramVarArgs.g(4, this.YNW);
      }
      if (this.ZjJ != null) {
        paramVarArgs.g(5, this.ZjJ);
      }
      if (this.ZjK != null) {
        paramVarArgs.g(6, this.ZjK);
      }
      if (this.ZjL != null) {
        paramVarArgs.g(7, this.ZjL);
      }
      if (this.ZiL != null) {
        paramVarArgs.g(8, this.ZiL);
      }
      if (this.aalN != null) {
        paramVarArgs.g(9, this.aalN);
      }
      paramVarArgs.bS(10, this.YJZ);
      if (this.IMu != null) {
        paramVarArgs.g(11, this.IMu);
      }
      if (this.aalQ != null) {
        paramVarArgs.g(12, this.aalQ);
      }
      if (this.aalR != null) {
        paramVarArgs.g(13, this.aalR);
      }
      if (this.Zbi != null)
      {
        paramVarArgs.qD(14, this.Zbi.computeSize());
        this.Zbi.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(15, this.IJG);
      paramVarArgs.bS(16, this.aalS);
      if (this.aalT != null) {
        paramVarArgs.g(17, this.aalT);
      }
      AppMethodBeat.o(91473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1290;
      }
    }
    label1290:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.ZjI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZjI);
      }
      paramInt = i;
      if (this.YNW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YNW);
      }
      i = paramInt;
      if (this.ZjJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZjJ);
      }
      paramInt = i;
      if (this.ZjK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZjK);
      }
      i = paramInt;
      if (this.ZjL != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZjL);
      }
      paramInt = i;
      if (this.ZiL != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZiL);
      }
      i = paramInt;
      if (this.aalN != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aalN);
      }
      i += i.a.a.b.b.a.cJ(10, this.YJZ);
      paramInt = i;
      if (this.IMu != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.IMu);
      }
      i = paramInt;
      if (this.aalQ != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aalQ);
      }
      paramInt = i;
      if (this.aalR != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.aalR);
      }
      i = paramInt;
      if (this.Zbi != null) {
        i = paramInt + i.a.a.a.qC(14, this.Zbi.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(15, this.IJG) + i.a.a.b.b.a.cJ(16, this.aalS);
      paramInt = i;
      if (this.aalT != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.aalT);
      }
      AppMethodBeat.o(91473);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cck localcck = (cck)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91473);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localcck.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 2: 
          localcck.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 3: 
          localcck.ZjI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 4: 
          localcck.YNW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 5: 
          localcck.ZjJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 6: 
          localcck.ZjK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 7: 
          localcck.ZjL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 8: 
          localcck.ZiL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 9: 
          localcck.aalN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 10: 
          localcck.YJZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91473);
          return 0;
        case 11: 
          localcck.IMu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 12: 
          localcck.aalQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 13: 
          localcck.aalR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bi)localObject2).parseFrom((byte[])localObject1);
            }
            localcck.Zbi = ((bi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 15: 
          localcck.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91473);
          return 0;
        case 16: 
          localcck.aalS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91473);
          return 0;
        }
        localcck.aalT = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91473);
        return 0;
      }
      AppMethodBeat.o(91473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cck
 * JD-Core Version:    0.7.0.1
 */