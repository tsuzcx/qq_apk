package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ebl
  extends dpc
{
  public LinkedList<SnsObject> KOH;
  public int MZF;
  public LinkedList<ebo> MZG;
  public String MZg;
  public int MZk;
  public eat MZl;
  public ebj MmQ;
  public int MvM;
  public int NaG;
  public int Nbf;
  public long Nbg;
  public long Nbh;
  public String Nbi;
  public boolean Nbj;
  
  public ebl()
  {
    AppMethodBeat.i(125836);
    this.KOH = new LinkedList();
    this.MZG = new LinkedList();
    AppMethodBeat.o(125836);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125837);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125837);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MZg != null) {
        paramVarArgs.e(2, this.MZg);
      }
      paramVarArgs.aM(3, this.MvM);
      paramVarArgs.e(4, 8, this.KOH);
      paramVarArgs.aM(5, this.Nbf);
      if (this.MmQ != null)
      {
        paramVarArgs.ni(6, this.MmQ.computeSize());
        this.MmQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.NaG);
      paramVarArgs.aM(8, this.MZk);
      if (this.MZl != null)
      {
        paramVarArgs.ni(9, this.MZl.computeSize());
        this.MZl.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(10, this.Nbg);
      paramVarArgs.bb(11, this.Nbh);
      if (this.Nbi != null) {
        paramVarArgs.e(12, this.Nbi);
      }
      paramVarArgs.aM(13, this.MZF);
      paramVarArgs.e(14, 8, this.MZG);
      paramVarArgs.cc(15, this.Nbj);
      AppMethodBeat.o(125837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1434;
      }
    }
    label1434:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MZg != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MZg);
      }
      i = i + g.a.a.b.b.a.bu(3, this.MvM) + g.a.a.a.c(4, 8, this.KOH) + g.a.a.b.b.a.bu(5, this.Nbf);
      paramInt = i;
      if (this.MmQ != null) {
        paramInt = i + g.a.a.a.nh(6, this.MmQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.NaG) + g.a.a.b.b.a.bu(8, this.MZk);
      paramInt = i;
      if (this.MZl != null) {
        paramInt = i + g.a.a.a.nh(9, this.MZl.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.r(10, this.Nbg) + g.a.a.b.b.a.r(11, this.Nbh);
      paramInt = i;
      if (this.Nbi != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.Nbi);
      }
      i = g.a.a.b.b.a.bu(13, this.MZF);
      int j = g.a.a.a.c(14, 8, this.MZG);
      int k = g.a.a.b.b.a.fS(15);
      AppMethodBeat.o(125837);
      return paramInt + i + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KOH.clear();
        this.MZG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125837);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebl localebl = (ebl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125837);
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
            localebl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 2: 
          localebl.MZg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 3: 
          localebl.MvM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125837);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebl.KOH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 5: 
          localebl.Nbf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125837);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebl.MmQ = ((ebj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 7: 
          localebl.NaG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125837);
          return 0;
        case 8: 
          localebl.MZk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125837);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eat();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebl.MZl = ((eat)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 10: 
          localebl.Nbg = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125837);
          return 0;
        case 11: 
          localebl.Nbh = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125837);
          return 0;
        case 12: 
          localebl.Nbi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 13: 
          localebl.MZF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125837);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebl.MZG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        }
        localebl.Nbj = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(125837);
        return 0;
      }
      AppMethodBeat.o(125837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebl
 * JD-Core Version:    0.7.0.1
 */