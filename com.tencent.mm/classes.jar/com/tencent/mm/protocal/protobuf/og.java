package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class og
  extends com.tencent.mm.bw.a
{
  public int KTD;
  public int KTO;
  public int KTP;
  public int KTQ;
  public int KTR;
  public long KTS;
  public long KTT;
  public boolean KTU;
  public int KTV;
  public boolean KTW;
  public ji KTX;
  public boolean KTY;
  public xd KTZ;
  public String KTt;
  public LinkedList<ewv> KUa;
  public boolean KUb;
  public LinkedList<String> KUc;
  public String KUd;
  public String KUe;
  
  public og()
  {
    AppMethodBeat.i(212233);
    this.KUa = new LinkedList();
    this.KUc = new LinkedList();
    AppMethodBeat.o(212233);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTt == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124426);
        throw paramVarArgs;
      }
      if (this.KTt != null) {
        paramVarArgs.e(1, this.KTt);
      }
      paramVarArgs.aM(2, this.KTO);
      paramVarArgs.aM(3, this.KTP);
      paramVarArgs.aM(4, this.KTQ);
      paramVarArgs.aM(5, this.KTR);
      paramVarArgs.bb(6, this.KTS);
      paramVarArgs.bb(7, this.KTT);
      paramVarArgs.aM(8, this.KTD);
      paramVarArgs.cc(9, this.KTU);
      paramVarArgs.aM(10, this.KTV);
      paramVarArgs.cc(11, this.KTW);
      if (this.KTX != null)
      {
        paramVarArgs.ni(12, this.KTX.computeSize());
        this.KTX.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(13, this.KTY);
      if (this.KTZ != null)
      {
        paramVarArgs.ni(14, this.KTZ.computeSize());
        this.KTZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.KUa);
      paramVarArgs.cc(16, this.KUb);
      paramVarArgs.e(17, 1, this.KUc);
      if (this.KUd != null) {
        paramVarArgs.e(18, this.KUd);
      }
      if (this.KUe != null) {
        paramVarArgs.e(19, this.KUe);
      }
      AppMethodBeat.o(124426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KTt == null) {
        break label1418;
      }
    }
    label1418:
    for (paramInt = g.a.a.b.b.a.f(1, this.KTt) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KTO) + g.a.a.b.b.a.bu(3, this.KTP) + g.a.a.b.b.a.bu(4, this.KTQ) + g.a.a.b.b.a.bu(5, this.KTR) + g.a.a.b.b.a.r(6, this.KTS) + g.a.a.b.b.a.r(7, this.KTT) + g.a.a.b.b.a.bu(8, this.KTD) + (g.a.a.b.b.a.fS(9) + 1) + g.a.a.b.b.a.bu(10, this.KTV) + (g.a.a.b.b.a.fS(11) + 1);
      paramInt = i;
      if (this.KTX != null) {
        paramInt = i + g.a.a.a.nh(12, this.KTX.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.fS(13) + 1);
      paramInt = i;
      if (this.KTZ != null) {
        paramInt = i + g.a.a.a.nh(14, this.KTZ.computeSize());
      }
      i = paramInt + g.a.a.a.c(15, 8, this.KUa) + (g.a.a.b.b.a.fS(16) + 1) + g.a.a.a.c(17, 1, this.KUc);
      paramInt = i;
      if (this.KUd != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.KUd);
      }
      i = paramInt;
      if (this.KUe != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.KUe);
      }
      AppMethodBeat.o(124426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KUa.clear();
        this.KUc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KTt == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        og localog = (og)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124426);
          return -1;
        case 1: 
          localog.KTt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124426);
          return 0;
        case 2: 
          localog.KTO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124426);
          return 0;
        case 3: 
          localog.KTP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124426);
          return 0;
        case 4: 
          localog.KTQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124426);
          return 0;
        case 5: 
          localog.KTR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124426);
          return 0;
        case 6: 
          localog.KTS = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124426);
          return 0;
        case 7: 
          localog.KTT = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124426);
          return 0;
        case 8: 
          localog.KTD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124426);
          return 0;
        case 9: 
          localog.KTU = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(124426);
          return 0;
        case 10: 
          localog.KTV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124426);
          return 0;
        case 11: 
          localog.KTW = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(124426);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ji();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ji)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localog.KTX = ((ji)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 13: 
          localog.KTY = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(124426);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localog.KTZ = ((xd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ewv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ewv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localog.KUa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 16: 
          localog.KUb = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(124426);
          return 0;
        case 17: 
          localog.KUc.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(124426);
          return 0;
        case 18: 
          localog.KUd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124426);
          return 0;
        }
        localog.KUe = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124426);
        return 0;
      }
      AppMethodBeat.o(124426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.og
 * JD-Core Version:    0.7.0.1
 */