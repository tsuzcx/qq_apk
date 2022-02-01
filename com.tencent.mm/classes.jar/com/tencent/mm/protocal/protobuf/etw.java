package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class etw
  extends dop
{
  public int Llx;
  public int LsZ;
  public long Lta;
  public String MKC;
  public int MKg;
  public int NbR;
  public euk NpJ;
  public euk NpK;
  public long NpN;
  public int NpO;
  public int NpP;
  public LinkedList<csu> NpQ;
  public int NqJ;
  public int NqV;
  public LinkedList<dqi> NqW;
  public int NqX;
  
  public etw()
  {
    AppMethodBeat.i(115883);
    this.NqW = new LinkedList();
    this.NpQ = new LinkedList();
    AppMethodBeat.o(115883);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115884);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NpJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115884);
        throw paramVarArgs;
      }
      if (this.NpK == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115884);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MKC != null) {
        paramVarArgs.e(2, this.MKC);
      }
      paramVarArgs.aM(3, this.NqV);
      paramVarArgs.e(4, 8, this.NqW);
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
      paramVarArgs.aM(9, this.NbR);
      paramVarArgs.aM(10, this.LsZ);
      paramVarArgs.bb(11, this.Lta);
      paramVarArgs.aM(12, this.NqJ);
      paramVarArgs.bb(13, this.NpN);
      paramVarArgs.aM(14, this.NqX);
      paramVarArgs.aM(15, this.MKg);
      paramVarArgs.aM(16, this.NpO);
      paramVarArgs.aM(17, this.NpP);
      paramVarArgs.e(18, 8, this.NpQ);
      AppMethodBeat.o(115884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1586;
      }
    }
    label1586:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MKC != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MKC);
      }
      i = i + g.a.a.b.b.a.bu(3, this.NqV) + g.a.a.a.c(4, 8, this.NqW);
      paramInt = i;
      if (this.NpJ != null) {
        paramInt = i + g.a.a.a.nh(6, this.NpJ.computeSize());
      }
      i = paramInt;
      if (this.NpK != null) {
        i = paramInt + g.a.a.a.nh(7, this.NpK.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(8, this.Llx);
      int j = g.a.a.b.b.a.bu(9, this.NbR);
      int k = g.a.a.b.b.a.bu(10, this.LsZ);
      int m = g.a.a.b.b.a.r(11, this.Lta);
      int n = g.a.a.b.b.a.bu(12, this.NqJ);
      int i1 = g.a.a.b.b.a.r(13, this.NpN);
      int i2 = g.a.a.b.b.a.bu(14, this.NqX);
      int i3 = g.a.a.b.b.a.bu(15, this.MKg);
      int i4 = g.a.a.b.b.a.bu(16, this.NpO);
      int i5 = g.a.a.b.b.a.bu(17, this.NpP);
      int i6 = g.a.a.a.c(18, 8, this.NpQ);
      AppMethodBeat.o(115884);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NqW.clear();
        this.NpQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NpJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        if (this.NpK == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115884);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        etw localetw = (etw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115884);
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
            localetw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 2: 
          localetw.MKC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115884);
          return 0;
        case 3: 
          localetw.NqV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115884);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localetw.NqW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
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
            localetw.NpJ = ((euk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
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
            localetw.NpK = ((euk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 8: 
          localetw.Llx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115884);
          return 0;
        case 9: 
          localetw.NbR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115884);
          return 0;
        case 10: 
          localetw.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115884);
          return 0;
        case 11: 
          localetw.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115884);
          return 0;
        case 12: 
          localetw.NqJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115884);
          return 0;
        case 13: 
          localetw.NpN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115884);
          return 0;
        case 14: 
          localetw.NqX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115884);
          return 0;
        case 15: 
          localetw.MKg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115884);
          return 0;
        case 16: 
          localetw.NpO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115884);
          return 0;
        case 17: 
          localetw.NpP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115884);
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
          localetw.NpQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115884);
        return 0;
      }
      AppMethodBeat.o(115884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etw
 * JD-Core Version:    0.7.0.1
 */