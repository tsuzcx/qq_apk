package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class euj
  extends dpc
{
  public int LsZ;
  public long Lta;
  public int MKr;
  public LinkedList<esq> NqB;
  public eud NsA;
  public int Nst;
  public LinkedList<esq> Nsu;
  public int Nsv;
  public LinkedList<esq> Nsw;
  public int Nsx;
  public int Nsy;
  public int Nsz;
  
  public euj()
  {
    AppMethodBeat.i(115907);
    this.Nsu = new LinkedList();
    this.Nsw = new LinkedList();
    this.NqB = new LinkedList();
    AppMethodBeat.o(115907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115908);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115908);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.aM(3, this.Nst);
      paramVarArgs.e(4, 8, this.Nsu);
      paramVarArgs.aM(5, this.Nsv);
      paramVarArgs.e(6, 8, this.Nsw);
      paramVarArgs.bb(7, this.Lta);
      paramVarArgs.aM(8, this.MKr);
      paramVarArgs.aM(9, this.Nsx);
      paramVarArgs.e(10, 8, this.NqB);
      paramVarArgs.aM(11, this.Nsy);
      paramVarArgs.aM(12, this.Nsz);
      if (this.NsA != null)
      {
        paramVarArgs.ni(13, this.NsA.computeSize());
        this.NsA.writeFields(paramVarArgs);
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
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.bu(3, this.Nst) + g.a.a.a.c(4, 8, this.Nsu) + g.a.a.b.b.a.bu(5, this.Nsv) + g.a.a.a.c(6, 8, this.Nsw) + g.a.a.b.b.a.r(7, this.Lta) + g.a.a.b.b.a.bu(8, this.MKr) + g.a.a.b.b.a.bu(9, this.Nsx) + g.a.a.a.c(10, 8, this.NqB) + g.a.a.b.b.a.bu(11, this.Nsy) + g.a.a.b.b.a.bu(12, this.Nsz);
      paramInt = i;
      if (this.NsA != null) {
        paramInt = i + g.a.a.a.nh(13, this.NsA.computeSize());
      }
      AppMethodBeat.o(115908);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nsu.clear();
        this.Nsw.clear();
        this.NqB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        euj localeuj = (euj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115908);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeuj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 2: 
          localeuj.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115908);
          return 0;
        case 3: 
          localeuj.Nst = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115908);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeuj.Nsu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 5: 
          localeuj.Nsv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115908);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeuj.Nsw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 7: 
          localeuj.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115908);
          return 0;
        case 8: 
          localeuj.MKr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115908);
          return 0;
        case 9: 
          localeuj.Nsx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115908);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeuj.NqB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 11: 
          localeuj.Nsy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115908);
          return 0;
        case 12: 
          localeuj.Nsz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115908);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eud();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eud)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeuj.NsA = ((eud)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euj
 * JD-Core Version:    0.7.0.1
 */