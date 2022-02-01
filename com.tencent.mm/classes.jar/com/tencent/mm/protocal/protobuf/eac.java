package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eac
  extends cwj
{
  public int Gxq;
  public long Gxr;
  public int HzI;
  public LinkedList<dyj> Ied;
  public int IfV;
  public LinkedList<dyj> IfW;
  public int IfX;
  public LinkedList<dyj> IfY;
  public int IfZ;
  public int Iga;
  public int Igb;
  public dzw Igc;
  
  public eac()
  {
    AppMethodBeat.i(115907);
    this.IfW = new LinkedList();
    this.IfY = new LinkedList();
    this.Ied = new LinkedList();
    AppMethodBeat.o(115907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115908);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115908);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aS(3, this.IfV);
      paramVarArgs.e(4, 8, this.IfW);
      paramVarArgs.aS(5, this.IfX);
      paramVarArgs.e(6, 8, this.IfY);
      paramVarArgs.aZ(7, this.Gxr);
      paramVarArgs.aS(8, this.HzI);
      paramVarArgs.aS(9, this.IfZ);
      paramVarArgs.e(10, 8, this.Ied);
      paramVarArgs.aS(11, this.Iga);
      paramVarArgs.aS(12, this.Igb);
      if (this.Igc != null)
      {
        paramVarArgs.lJ(13, this.Igc.computeSize());
        this.Igc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115908);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1278;
      }
    }
    label1278:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gxq) + f.a.a.b.b.a.bz(3, this.IfV) + f.a.a.a.c(4, 8, this.IfW) + f.a.a.b.b.a.bz(5, this.IfX) + f.a.a.a.c(6, 8, this.IfY) + f.a.a.b.b.a.p(7, this.Gxr) + f.a.a.b.b.a.bz(8, this.HzI) + f.a.a.b.b.a.bz(9, this.IfZ) + f.a.a.a.c(10, 8, this.Ied) + f.a.a.b.b.a.bz(11, this.Iga) + f.a.a.b.b.a.bz(12, this.Igb);
      paramInt = i;
      if (this.Igc != null) {
        paramInt = i + f.a.a.a.lI(13, this.Igc.computeSize());
      }
      AppMethodBeat.o(115908);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IfW.clear();
        this.IfY.clear();
        this.Ied.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eac localeac = (eac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115908);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeac.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 2: 
          localeac.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 3: 
          localeac.IfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeac.IfW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 5: 
          localeac.IfX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeac.IfY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 7: 
          localeac.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115908);
          return 0;
        case 8: 
          localeac.HzI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 9: 
          localeac.IfZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeac.Ied.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 11: 
          localeac.Iga = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 12: 
          localeac.Igb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115908);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeac.Igc = ((dzw)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eac
 * JD-Core Version:    0.7.0.1
 */