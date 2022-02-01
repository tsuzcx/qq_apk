package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bza
  extends dpc
{
  public String KNV;
  public String KYV;
  public fcd Ljo;
  public String MeA;
  public String MeB;
  public int MeC;
  public String MeD;
  public int MeE;
  public int MeF;
  public csy MeG;
  public String Mev;
  public int Mew;
  public String Mex;
  public LinkedList<csy> Mey;
  public int Mez;
  public String dQx;
  public int oKX;
  
  public bza()
  {
    AppMethodBeat.i(123591);
    this.Mey = new LinkedList();
    AppMethodBeat.o(123591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123592);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ljo != null)
      {
        paramVarArgs.ni(2, this.Ljo.computeSize());
        this.Ljo.writeFields(paramVarArgs);
      }
      if (this.Mev != null) {
        paramVarArgs.e(3, this.Mev);
      }
      paramVarArgs.aM(4, this.Mew);
      paramVarArgs.aM(5, this.oKX);
      if (this.Mex != null) {
        paramVarArgs.e(6, this.Mex);
      }
      paramVarArgs.e(7, 8, this.Mey);
      paramVarArgs.aM(8, this.Mez);
      if (this.MeA != null) {
        paramVarArgs.e(9, this.MeA);
      }
      if (this.MeB != null) {
        paramVarArgs.e(10, this.MeB);
      }
      paramVarArgs.aM(11, this.MeC);
      if (this.dQx != null) {
        paramVarArgs.e(12, this.dQx);
      }
      if (this.KNV != null) {
        paramVarArgs.e(13, this.KNV);
      }
      if (this.KYV != null) {
        paramVarArgs.e(14, this.KYV);
      }
      if (this.MeD != null) {
        paramVarArgs.e(15, this.MeD);
      }
      paramVarArgs.aM(16, this.MeE);
      paramVarArgs.aM(17, this.MeF);
      if (this.MeG != null)
      {
        paramVarArgs.ni(18, this.MeG.computeSize());
        this.MeG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ljo != null) {
        paramInt = i + g.a.a.a.nh(2, this.Ljo.computeSize());
      }
      i = paramInt;
      if (this.Mev != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mev);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Mew) + g.a.a.b.b.a.bu(5, this.oKX);
      paramInt = i;
      if (this.Mex != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mex);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.Mey) + g.a.a.b.b.a.bu(8, this.Mez);
      paramInt = i;
      if (this.MeA != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MeA);
      }
      i = paramInt;
      if (this.MeB != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MeB);
      }
      i += g.a.a.b.b.a.bu(11, this.MeC);
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.dQx);
      }
      i = paramInt;
      if (this.KNV != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.KNV);
      }
      paramInt = i;
      if (this.KYV != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.KYV);
      }
      i = paramInt;
      if (this.MeD != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.MeD);
      }
      i = i + g.a.a.b.b.a.bu(16, this.MeE) + g.a.a.b.b.a.bu(17, this.MeF);
      paramInt = i;
      if (this.MeG != null) {
        paramInt = i + g.a.a.a.nh(18, this.MeG.computeSize());
      }
      AppMethodBeat.o(123592);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mey.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bza localbza = (bza)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123592);
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
            localbza.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fcd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fcd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbza.Ljo = ((fcd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 3: 
          localbza.Mev = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 4: 
          localbza.Mew = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123592);
          return 0;
        case 5: 
          localbza.oKX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123592);
          return 0;
        case 6: 
          localbza.Mex = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbza.Mey.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123592);
          return 0;
        case 8: 
          localbza.Mez = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123592);
          return 0;
        case 9: 
          localbza.MeA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 10: 
          localbza.MeB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 11: 
          localbza.MeC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123592);
          return 0;
        case 12: 
          localbza.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 13: 
          localbza.KNV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 14: 
          localbza.KYV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 15: 
          localbza.MeD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123592);
          return 0;
        case 16: 
          localbza.MeE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123592);
          return 0;
        case 17: 
          localbza.MeF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123592);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbza.MeG = ((csy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123592);
        return 0;
      }
      AppMethodBeat.o(123592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bza
 * JD-Core Version:    0.7.0.1
 */