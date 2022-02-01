package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ba
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public int YBU;
  public String YBV;
  public String YBW;
  public int YBX;
  public int YBY;
  public String YBZ;
  public int YCa;
  public String YCb;
  public String YCc;
  public int YCd;
  public String YCe;
  public String YCf;
  public int YCg;
  public gnr YCh;
  public gno YCi;
  public String pSk;
  public String vhX;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133142);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      paramVarArgs.bS(3, this.YBU);
      if (this.YBV != null) {
        paramVarArgs.g(4, this.YBV);
      }
      if (this.YBW != null) {
        paramVarArgs.g(5, this.YBW);
      }
      if (this.pSk != null) {
        paramVarArgs.g(6, this.pSk);
      }
      paramVarArgs.bS(8, this.vhk);
      paramVarArgs.bS(9, this.YBX);
      paramVarArgs.bS(10, this.YBY);
      if (this.YBZ != null) {
        paramVarArgs.g(11, this.YBZ);
      }
      paramVarArgs.bS(12, this.YCa);
      if (this.YCb != null) {
        paramVarArgs.g(13, this.YCb);
      }
      if (this.YCc != null) {
        paramVarArgs.g(14, this.YCc);
      }
      paramVarArgs.bS(15, this.YCd);
      if (this.YCe != null) {
        paramVarArgs.g(16, this.YCe);
      }
      if (this.YCf != null) {
        paramVarArgs.g(17, this.YCf);
      }
      paramVarArgs.bS(18, this.YCg);
      if (this.YCh != null)
      {
        paramVarArgs.qD(19, this.YCh.computeSize());
        this.YCh.writeFields(paramVarArgs);
      }
      if (this.YCi != null)
      {
        paramVarArgs.qD(20, this.YCi.computeSize());
        this.YCi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133142);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1354;
      }
    }
    label1354:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.vhX);
      }
      i += i.a.a.b.b.a.cJ(3, this.YBU);
      paramInt = i;
      if (this.YBV != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YBV);
      }
      i = paramInt;
      if (this.YBW != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YBW);
      }
      paramInt = i;
      if (this.pSk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.pSk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.vhk) + i.a.a.b.b.a.cJ(9, this.YBX) + i.a.a.b.b.a.cJ(10, this.YBY);
      paramInt = i;
      if (this.YBZ != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YBZ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.YCa);
      paramInt = i;
      if (this.YCb != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.YCb);
      }
      i = paramInt;
      if (this.YCc != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.YCc);
      }
      i += i.a.a.b.b.a.cJ(15, this.YCd);
      paramInt = i;
      if (this.YCe != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.YCe);
      }
      i = paramInt;
      if (this.YCf != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.YCf);
      }
      i += i.a.a.b.b.a.cJ(18, this.YCg);
      paramInt = i;
      if (this.YCh != null) {
        paramInt = i + i.a.a.a.qC(19, this.YCh.computeSize());
      }
      i = paramInt;
      if (this.YCi != null) {
        i = paramInt + i.a.a.a.qC(20, this.YCi.computeSize());
      }
      AppMethodBeat.o(133142);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(133142);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ba localba = (ba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(133142);
          return -1;
        case 1: 
          localba.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 2: 
          localba.vhX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 3: 
          localba.YBU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133142);
          return 0;
        case 4: 
          localba.YBV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 5: 
          localba.YBW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 6: 
          localba.pSk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 8: 
          localba.vhk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133142);
          return 0;
        case 9: 
          localba.YBX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133142);
          return 0;
        case 10: 
          localba.YBY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133142);
          return 0;
        case 11: 
          localba.YBZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 12: 
          localba.YCa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133142);
          return 0;
        case 13: 
          localba.YCb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 14: 
          localba.YCc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 15: 
          localba.YCd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133142);
          return 0;
        case 16: 
          localba.YCe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 17: 
          localba.YCf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 18: 
          localba.YCg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133142);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gnr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gnr)localObject2).parseFrom((byte[])localObject1);
            }
            localba.YCh = ((gnr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133142);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gno();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gno)localObject2).parseFrom((byte[])localObject1);
          }
          localba.YCi = ((gno)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133142);
        return 0;
      }
      AppMethodBeat.o(133142);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ba
 * JD-Core Version:    0.7.0.1
 */