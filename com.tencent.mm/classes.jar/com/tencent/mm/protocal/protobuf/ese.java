package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ese
  extends dop
{
  public SKBuiltinBuffer_t BsI;
  public int KKA;
  public int KKD;
  public int KZk;
  public String Nln;
  public int Nlo;
  public int Nlp;
  public int Nps;
  public int Npt;
  public LinkedList<dqi> Npu;
  public LinkedList<SKBuiltinBuffer_t> Npv;
  public String UserName;
  public int jeU;
  
  public ese()
  {
    AppMethodBeat.i(148663);
    this.Npu = new LinkedList();
    this.Npv = new LinkedList();
    AppMethodBeat.o(148663);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148664);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148664);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.BsI != null)
      {
        paramVarArgs.ni(3, this.BsI.computeSize());
        this.BsI.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.KZk);
      if (this.Nln != null) {
        paramVarArgs.e(5, this.Nln);
      }
      paramVarArgs.aM(6, this.jeU);
      paramVarArgs.aM(7, this.Nlo);
      paramVarArgs.aM(8, this.KKD);
      paramVarArgs.aM(9, this.Nlp);
      paramVarArgs.aM(10, this.KKA);
      paramVarArgs.aM(11, this.Nps);
      paramVarArgs.aM(12, this.Npt);
      paramVarArgs.e(13, 8, this.Npu);
      paramVarArgs.e(14, 8, this.Npv);
      AppMethodBeat.o(148664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1298;
      }
    }
    label1298:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.BsI != null) {
        i = paramInt + g.a.a.a.nh(3, this.BsI.computeSize());
      }
      i += g.a.a.b.b.a.bu(4, this.KZk);
      paramInt = i;
      if (this.Nln != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Nln);
      }
      i = g.a.a.b.b.a.bu(6, this.jeU);
      int j = g.a.a.b.b.a.bu(7, this.Nlo);
      int k = g.a.a.b.b.a.bu(8, this.KKD);
      int m = g.a.a.b.b.a.bu(9, this.Nlp);
      int n = g.a.a.b.b.a.bu(10, this.KKA);
      int i1 = g.a.a.b.b.a.bu(11, this.Nps);
      int i2 = g.a.a.b.b.a.bu(12, this.Npt);
      int i3 = g.a.a.a.c(13, 8, this.Npu);
      int i4 = g.a.a.a.c(14, 8, this.Npv);
      AppMethodBeat.o(148664);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Npu.clear();
        this.Npv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BsI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148664);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ese localese = (ese)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148664);
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
            localese.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 2: 
          localese.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localese.BsI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 4: 
          localese.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148664);
          return 0;
        case 5: 
          localese.Nln = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 6: 
          localese.jeU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148664);
          return 0;
        case 7: 
          localese.Nlo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148664);
          return 0;
        case 8: 
          localese.KKD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148664);
          return 0;
        case 9: 
          localese.Nlp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148664);
          return 0;
        case 10: 
          localese.KKA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148664);
          return 0;
        case 11: 
          localese.Nps = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148664);
          return 0;
        case 12: 
          localese.Npt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148664);
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
            localese.Npu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localese.Npv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      AppMethodBeat.o(148664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ese
 * JD-Core Version:    0.7.0.1
 */