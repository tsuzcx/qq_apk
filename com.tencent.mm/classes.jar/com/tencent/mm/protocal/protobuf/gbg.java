package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gbg
  extends esc
{
  public long ZvA;
  public int Zvz;
  public LinkedList<fzn> abXI;
  public int abZA;
  public LinkedList<fzn> abZB;
  public int abZC;
  public LinkedList<fzn> abZD;
  public int abZE;
  public int abZF;
  public int abZG;
  public gba abZH;
  public int abna;
  
  public gbg()
  {
    AppMethodBeat.i(115907);
    this.abZB = new LinkedList();
    this.abZD = new LinkedList();
    this.abXI = new LinkedList();
    AppMethodBeat.o(115907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115908);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115908);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bS(3, this.abZA);
      paramVarArgs.e(4, 8, this.abZB);
      paramVarArgs.bS(5, this.abZC);
      paramVarArgs.e(6, 8, this.abZD);
      paramVarArgs.bv(7, this.ZvA);
      paramVarArgs.bS(8, this.abna);
      paramVarArgs.bS(9, this.abZE);
      paramVarArgs.e(10, 8, this.abXI);
      paramVarArgs.bS(11, this.abZF);
      paramVarArgs.bS(12, this.abZG);
      if (this.abZH != null)
      {
        paramVarArgs.qD(13, this.abZH.computeSize());
        this.abZH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115908);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1168;
      }
    }
    label1168:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zvz) + i.a.a.b.b.a.cJ(3, this.abZA) + i.a.a.a.c(4, 8, this.abZB) + i.a.a.b.b.a.cJ(5, this.abZC) + i.a.a.a.c(6, 8, this.abZD) + i.a.a.b.b.a.q(7, this.ZvA) + i.a.a.b.b.a.cJ(8, this.abna) + i.a.a.b.b.a.cJ(9, this.abZE) + i.a.a.a.c(10, 8, this.abXI) + i.a.a.b.b.a.cJ(11, this.abZF) + i.a.a.b.b.a.cJ(12, this.abZG);
      paramInt = i;
      if (this.abZH != null) {
        paramInt = i + i.a.a.a.qC(13, this.abZH.computeSize());
      }
      AppMethodBeat.o(115908);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abZB.clear();
        this.abZD.clear();
        this.abXI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115908);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115908);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gbg localgbg = (gbg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115908);
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
            localgbg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 2: 
          localgbg.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115908);
          return 0;
        case 3: 
          localgbg.abZA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115908);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fzn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fzn)localObject2).parseFrom((byte[])localObject1);
            }
            localgbg.abZB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 5: 
          localgbg.abZC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115908);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fzn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fzn)localObject2).parseFrom((byte[])localObject1);
            }
            localgbg.abZD.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 7: 
          localgbg.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115908);
          return 0;
        case 8: 
          localgbg.abna = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115908);
          return 0;
        case 9: 
          localgbg.abZE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115908);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fzn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fzn)localObject2).parseFrom((byte[])localObject1);
            }
            localgbg.abXI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 11: 
          localgbg.abZF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115908);
          return 0;
        case 12: 
          localgbg.abZG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115908);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gba();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gba)localObject2).parseFrom((byte[])localObject1);
          }
          localgbg.abZH = ((gba)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115908);
        return 0;
      }
      AppMethodBeat.o(115908);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbg
 * JD-Core Version:    0.7.0.1
 */