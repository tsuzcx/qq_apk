package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ess
  extends dop
{
  public int Llx;
  public int LsZ;
  public long Lta;
  public String MKC;
  public euk NpJ;
  public euk NpK;
  public long NpN;
  public int NpO;
  public int NpP;
  public LinkedList<csu> NpQ;
  public int Nqa;
  public int Nqb;
  
  public ess()
  {
    AppMethodBeat.i(115863);
    this.NpQ = new LinkedList();
    AppMethodBeat.o(115863);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115864);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MKC != null) {
        paramVarArgs.e(2, this.MKC);
      }
      paramVarArgs.aM(3, this.LsZ);
      paramVarArgs.aM(4, this.Nqa);
      if (this.NpJ != null)
      {
        paramVarArgs.ni(5, this.NpJ.computeSize());
        this.NpJ.writeFields(paramVarArgs);
      }
      if (this.NpK != null)
      {
        paramVarArgs.ni(6, this.NpK.computeSize());
        this.NpK.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(7, this.Lta);
      paramVarArgs.aM(8, this.Llx);
      paramVarArgs.bb(9, this.NpN);
      paramVarArgs.aM(10, this.Nqb);
      paramVarArgs.aM(11, this.NpO);
      paramVarArgs.aM(12, this.NpP);
      paramVarArgs.e(13, 8, this.NpQ);
      AppMethodBeat.o(115864);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MKC != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MKC);
      }
      i = i + g.a.a.b.b.a.bu(3, this.LsZ) + g.a.a.b.b.a.bu(4, this.Nqa);
      paramInt = i;
      if (this.NpJ != null) {
        paramInt = i + g.a.a.a.nh(5, this.NpJ.computeSize());
      }
      i = paramInt;
      if (this.NpK != null) {
        i = paramInt + g.a.a.a.nh(6, this.NpK.computeSize());
      }
      paramInt = g.a.a.b.b.a.r(7, this.Lta);
      int j = g.a.a.b.b.a.bu(8, this.Llx);
      int k = g.a.a.b.b.a.r(9, this.NpN);
      int m = g.a.a.b.b.a.bu(10, this.Nqb);
      int n = g.a.a.b.b.a.bu(11, this.NpO);
      int i1 = g.a.a.b.b.a.bu(12, this.NpP);
      int i2 = g.a.a.a.c(13, 8, this.NpQ);
      AppMethodBeat.o(115864);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NpQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(115864);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ess localess = (ess)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115864);
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
            localess.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 2: 
          localess.MKC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115864);
          return 0;
        case 3: 
          localess.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115864);
          return 0;
        case 4: 
          localess.Nqa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115864);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new euk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((euk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localess.NpJ = ((euk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new euk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((euk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localess.NpK = ((euk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 7: 
          localess.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115864);
          return 0;
        case 8: 
          localess.Llx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115864);
          return 0;
        case 9: 
          localess.NpN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115864);
          return 0;
        case 10: 
          localess.Nqb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115864);
          return 0;
        case 11: 
          localess.NpO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115864);
          return 0;
        case 12: 
          localess.NpP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115864);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csu();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localess.NpQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115864);
        return 0;
      }
      AppMethodBeat.o(115864);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ess
 * JD-Core Version:    0.7.0.1
 */