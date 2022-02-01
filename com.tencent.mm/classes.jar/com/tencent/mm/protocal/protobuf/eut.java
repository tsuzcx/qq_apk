package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eut
  extends dop
{
  public int Lri;
  public int MPZ;
  public long NpN;
  public eus NqI;
  public eus NsN;
  public eus NsO;
  public eus NsP;
  public eus NsQ;
  public int NsR;
  public LinkedList<dqi> NsS;
  public LinkedList<dqi> NsT;
  public LinkedList<dqi> NsU;
  public int NsV;
  public LinkedList<dqi> NsW;
  
  public eut()
  {
    AppMethodBeat.i(115921);
    this.NsS = new LinkedList();
    this.NsT = new LinkedList();
    this.NsU = new LinkedList();
    this.NsW = new LinkedList();
    AppMethodBeat.o(115921);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115922);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NqI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.NqI != null)
      {
        paramVarArgs.ni(2, this.NqI.computeSize());
        this.NqI.writeFields(paramVarArgs);
      }
      if (this.NsN != null)
      {
        paramVarArgs.ni(3, this.NsN.computeSize());
        this.NsN.writeFields(paramVarArgs);
      }
      if (this.NsO != null)
      {
        paramVarArgs.ni(4, this.NsO.computeSize());
        this.NsO.writeFields(paramVarArgs);
      }
      if (this.NsP != null)
      {
        paramVarArgs.ni(5, this.NsP.computeSize());
        this.NsP.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.NpN);
      if (this.NsQ != null)
      {
        paramVarArgs.ni(7, this.NsQ.computeSize());
        this.NsQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.NsR);
      paramVarArgs.e(9, 8, this.NsS);
      paramVarArgs.aM(10, this.Lri);
      paramVarArgs.e(11, 8, this.NsT);
      paramVarArgs.aM(12, this.MPZ);
      paramVarArgs.e(13, 8, this.NsU);
      paramVarArgs.aM(14, this.NsV);
      paramVarArgs.e(15, 8, this.NsW);
      AppMethodBeat.o(115922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1942;
      }
    }
    label1942:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NqI != null) {
        paramInt = i + g.a.a.a.nh(2, this.NqI.computeSize());
      }
      i = paramInt;
      if (this.NsN != null) {
        i = paramInt + g.a.a.a.nh(3, this.NsN.computeSize());
      }
      paramInt = i;
      if (this.NsO != null) {
        paramInt = i + g.a.a.a.nh(4, this.NsO.computeSize());
      }
      i = paramInt;
      if (this.NsP != null) {
        i = paramInt + g.a.a.a.nh(5, this.NsP.computeSize());
      }
      i += g.a.a.b.b.a.r(6, this.NpN);
      paramInt = i;
      if (this.NsQ != null) {
        paramInt = i + g.a.a.a.nh(7, this.NsQ.computeSize());
      }
      i = g.a.a.b.b.a.bu(8, this.NsR);
      int j = g.a.a.a.c(9, 8, this.NsS);
      int k = g.a.a.b.b.a.bu(10, this.Lri);
      int m = g.a.a.a.c(11, 8, this.NsT);
      int n = g.a.a.b.b.a.bu(12, this.MPZ);
      int i1 = g.a.a.a.c(13, 8, this.NsU);
      int i2 = g.a.a.b.b.a.bu(14, this.NsV);
      int i3 = g.a.a.a.c(15, 8, this.NsW);
      AppMethodBeat.o(115922);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NsS.clear();
        this.NsT.clear();
        this.NsU.clear();
        this.NsW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NqI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eut localeut = (eut)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115922);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeut.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eus();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eus)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeut.NqI = ((eus)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eus();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eus)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeut.NsN = ((eus)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eus();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eus)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeut.NsO = ((eus)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eus();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eus)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeut.NsP = ((eus)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 6: 
          localeut.NpN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115922);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eus();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eus)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeut.NsQ = ((eus)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 8: 
          localeut.NsR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115922);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeut.NsS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 10: 
          localeut.Lri = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115922);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeut.NsT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 12: 
          localeut.MPZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115922);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeut.NsU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 14: 
          localeut.NsV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115922);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeut.NsW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115922);
        return 0;
      }
      AppMethodBeat.o(115922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eut
 * JD-Core Version:    0.7.0.1
 */