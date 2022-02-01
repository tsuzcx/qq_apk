package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fkd
  extends erp
{
  public LinkedList<fkc> IIU;
  public int IJG;
  public String SessionId;
  public int YRD;
  public String YRs;
  public int YVh;
  public b aaxD;
  public int abKK;
  public String abKL;
  public efk abKM;
  public int abKN;
  public String abKO;
  public int abKz;
  public String oOI;
  
  public fkd()
  {
    AppMethodBeat.i(152704);
    this.IIU = new LinkedList();
    AppMethodBeat.o(152704);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152705);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YRs != null) {
        paramVarArgs.g(2, this.YRs);
      }
      paramVarArgs.bS(3, this.YVh);
      paramVarArgs.e(4, 8, this.IIU);
      paramVarArgs.bS(5, this.abKK);
      if (this.oOI != null) {
        paramVarArgs.g(6, this.oOI);
      }
      paramVarArgs.bS(7, this.YRD);
      paramVarArgs.bS(8, this.abKz);
      if (this.abKL != null) {
        paramVarArgs.g(9, this.abKL);
      }
      if (this.aaxD != null) {
        paramVarArgs.d(10, this.aaxD);
      }
      if (this.abKM != null)
      {
        paramVarArgs.qD(11, this.abKM.computeSize());
        this.abKM.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.IJG);
      paramVarArgs.bS(13, this.abKN);
      if (this.SessionId != null) {
        paramVarArgs.g(14, this.SessionId);
      }
      if (this.abKO != null) {
        paramVarArgs.g(15, this.abKO);
      }
      AppMethodBeat.o(152705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1172;
      }
    }
    label1172:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YRs != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YRs);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.YVh) + i.a.a.a.c(4, 8, this.IIU) + i.a.a.b.b.a.cJ(5, this.abKK);
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.oOI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.YRD) + i.a.a.b.b.a.cJ(8, this.abKz);
      paramInt = i;
      if (this.abKL != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abKL);
      }
      i = paramInt;
      if (this.aaxD != null) {
        i = paramInt + i.a.a.b.b.a.c(10, this.aaxD);
      }
      paramInt = i;
      if (this.abKM != null) {
        paramInt = i + i.a.a.a.qC(11, this.abKM.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.IJG) + i.a.a.b.b.a.cJ(13, this.abKN);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.SessionId);
      }
      i = paramInt;
      if (this.abKO != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.abKO);
      }
      AppMethodBeat.o(152705);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IIU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fkd localfkd = (fkd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152705);
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
            localfkd.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 2: 
          localfkd.YRs = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 3: 
          localfkd.YVh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152705);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fkc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fkc)localObject2).parseFrom((byte[])localObject1);
            }
            localfkd.IIU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 5: 
          localfkd.abKK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152705);
          return 0;
        case 6: 
          localfkd.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 7: 
          localfkd.YRD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152705);
          return 0;
        case 8: 
          localfkd.abKz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152705);
          return 0;
        case 9: 
          localfkd.abKL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 10: 
          localfkd.aaxD = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(152705);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efk)localObject2).parseFrom((byte[])localObject1);
            }
            localfkd.abKM = ((efk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 12: 
          localfkd.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152705);
          return 0;
        case 13: 
          localfkd.abKN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152705);
          return 0;
        case 14: 
          localfkd.SessionId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152705);
          return 0;
        }
        localfkd.abKO = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(152705);
        return 0;
      }
      AppMethodBeat.o(152705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkd
 * JD-Core Version:    0.7.0.1
 */