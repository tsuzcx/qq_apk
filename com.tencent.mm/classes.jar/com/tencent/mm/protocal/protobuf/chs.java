package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class chs
  extends esc
{
  public int IJG;
  public int YKK;
  public LinkedList<afx> YKL;
  public String YKM;
  public String YKN;
  public String YKO;
  public int YKS;
  public String YKT;
  public String YKU;
  public gol YKf;
  public String aaqq;
  public String vgy;
  public int vhJ;
  public long vhg;
  
  public chs()
  {
    AppMethodBeat.i(32227);
    this.YKL = new LinkedList();
    AppMethodBeat.o(32227);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32228);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.YKf == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.vgy != null) {
        paramVarArgs.g(2, this.vgy);
      }
      if (this.YKf != null)
      {
        paramVarArgs.qD(3, this.YKf.computeSize());
        this.YKf.writeFields(paramVarArgs);
      }
      if (this.YKT != null) {
        paramVarArgs.g(4, this.YKT);
      }
      if (this.YKU != null) {
        paramVarArgs.g(5, this.YKU);
      }
      paramVarArgs.bS(6, this.vhJ);
      paramVarArgs.bS(7, this.YKK);
      paramVarArgs.e(8, 8, this.YKL);
      if (this.aaqq != null) {
        paramVarArgs.g(9, this.aaqq);
      }
      if (this.YKM != null) {
        paramVarArgs.g(10, this.YKM);
      }
      if (this.YKN != null) {
        paramVarArgs.g(11, this.YKN);
      }
      paramVarArgs.bS(12, this.YKS);
      paramVarArgs.bS(13, this.IJG);
      paramVarArgs.bv(14, this.vhg);
      if (this.YKO != null) {
        paramVarArgs.g(15, this.YKO);
      }
      AppMethodBeat.o(32228);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1309;
      }
    }
    label1309:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vgy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vgy);
      }
      i = paramInt;
      if (this.YKf != null) {
        i = paramInt + i.a.a.a.qC(3, this.YKf.computeSize());
      }
      paramInt = i;
      if (this.YKT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YKT);
      }
      i = paramInt;
      if (this.YKU != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YKU);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.vhJ) + i.a.a.b.b.a.cJ(7, this.YKK) + i.a.a.a.c(8, 8, this.YKL);
      paramInt = i;
      if (this.aaqq != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaqq);
      }
      i = paramInt;
      if (this.YKM != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.YKM);
      }
      paramInt = i;
      if (this.YKN != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YKN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.YKS) + i.a.a.b.b.a.cJ(13, this.IJG) + i.a.a.b.b.a.q(14, this.vhg);
      paramInt = i;
      if (this.YKO != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.YKO);
      }
      AppMethodBeat.o(32228);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YKL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        if (this.YKf == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32228);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        chs localchs = (chs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32228);
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
            localchs.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 2: 
          localchs.vgy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localchs.YKf = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 4: 
          localchs.YKT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 5: 
          localchs.YKU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 6: 
          localchs.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32228);
          return 0;
        case 7: 
          localchs.YKK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32228);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new afx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((afx)localObject2).parseFrom((byte[])localObject1);
            }
            localchs.YKL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 9: 
          localchs.aaqq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 10: 
          localchs.YKM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 11: 
          localchs.YKN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 12: 
          localchs.YKS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32228);
          return 0;
        case 13: 
          localchs.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32228);
          return 0;
        case 14: 
          localchs.vhg = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(32228);
          return 0;
        }
        localchs.YKO = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32228);
        return 0;
      }
      AppMethodBeat.o(32228);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chs
 * JD-Core Version:    0.7.0.1
 */