package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eso
  extends dop
{
  public int Llx;
  public int LsZ;
  public long Lta;
  public String MKC;
  public int NpI;
  public euk NpJ;
  public euk NpK;
  public String NpL;
  public int NpM;
  public long NpN;
  public int NpO;
  public int NpP;
  public LinkedList<csu> NpQ;
  
  public eso()
  {
    AppMethodBeat.i(115857);
    this.NpQ = new LinkedList();
    AppMethodBeat.o(115857);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115858);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.bb(3, this.Lta);
      if (this.MKC != null) {
        paramVarArgs.e(4, this.MKC);
      }
      paramVarArgs.aM(5, this.NpI);
      if (this.NpJ != null)
      {
        paramVarArgs.ni(6, this.NpJ.computeSize());
        this.NpJ.writeFields(paramVarArgs);
      }
      if (this.NpK != null)
      {
        paramVarArgs.ni(7, this.NpK.computeSize());
        this.NpK.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.Llx);
      if (this.NpL != null) {
        paramVarArgs.e(9, this.NpL);
      }
      paramVarArgs.aM(10, this.NpM);
      paramVarArgs.bb(11, this.NpN);
      paramVarArgs.aM(12, this.NpO);
      paramVarArgs.aM(13, this.NpP);
      paramVarArgs.e(14, 8, this.NpQ);
      AppMethodBeat.o(115858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1254;
      }
    }
    label1254:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta);
      paramInt = i;
      if (this.MKC != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MKC);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.NpI);
      paramInt = i;
      if (this.NpJ != null) {
        paramInt = i + g.a.a.a.nh(6, this.NpJ.computeSize());
      }
      i = paramInt;
      if (this.NpK != null) {
        i = paramInt + g.a.a.a.nh(7, this.NpK.computeSize());
      }
      i += g.a.a.b.b.a.bu(8, this.Llx);
      paramInt = i;
      if (this.NpL != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.NpL);
      }
      i = g.a.a.b.b.a.bu(10, this.NpM);
      int j = g.a.a.b.b.a.r(11, this.NpN);
      int k = g.a.a.b.b.a.bu(12, this.NpO);
      int m = g.a.a.b.b.a.bu(13, this.NpP);
      int n = g.a.a.a.c(14, 8, this.NpQ);
      AppMethodBeat.o(115858);
      return paramInt + i + j + k + m + n;
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
        AppMethodBeat.o(115858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eso localeso = (eso)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115858);
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
            localeso.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 2: 
          localeso.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115858);
          return 0;
        case 3: 
          localeso.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115858);
          return 0;
        case 4: 
          localeso.MKC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 5: 
          localeso.NpI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115858);
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
            localeso.NpJ = ((euk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new euk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((euk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeso.NpK = ((euk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 8: 
          localeso.Llx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115858);
          return 0;
        case 9: 
          localeso.NpL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 10: 
          localeso.NpM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115858);
          return 0;
        case 11: 
          localeso.NpN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115858);
          return 0;
        case 12: 
          localeso.NpO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115858);
          return 0;
        case 13: 
          localeso.NpP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115858);
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
          localeso.NpQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115858);
        return 0;
      }
      AppMethodBeat.o(115858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eso
 * JD-Core Version:    0.7.0.1
 */