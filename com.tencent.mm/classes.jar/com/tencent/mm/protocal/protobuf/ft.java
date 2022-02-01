package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ft
  extends dpc
{
  public fe KJA;
  public eqw KJB;
  public String KJC;
  public cmb KJD;
  public fp KJE;
  public LinkedList<String> KJF;
  public eb KJG;
  public LinkedList<ckn> KJH;
  public String KJI;
  public LinkedList<gh> KJu;
  public int KJv;
  public String KJw;
  public int KJx;
  public int KJy;
  public int KJz;
  public String url;
  public String vid;
  
  public ft()
  {
    AppMethodBeat.i(103195);
    this.KJu = new LinkedList();
    this.KJF = new LinkedList();
    this.KJH = new LinkedList();
    AppMethodBeat.o(103195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103196);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(103196);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.KJu);
      paramVarArgs.aM(3, this.KJv);
      if (this.KJw != null) {
        paramVarArgs.e(4, this.KJw);
      }
      paramVarArgs.aM(5, this.KJx);
      paramVarArgs.aM(6, this.KJy);
      paramVarArgs.aM(7, this.KJz);
      if (this.KJA != null)
      {
        paramVarArgs.ni(8, this.KJA.computeSize());
        this.KJA.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(9, this.url);
      }
      if (this.vid != null) {
        paramVarArgs.e(10, this.vid);
      }
      if (this.KJB != null)
      {
        paramVarArgs.ni(11, this.KJB.computeSize());
        this.KJB.writeFields(paramVarArgs);
      }
      if (this.KJC != null) {
        paramVarArgs.e(12, this.KJC);
      }
      if (this.KJD != null)
      {
        paramVarArgs.ni(13, this.KJD.computeSize());
        this.KJD.writeFields(paramVarArgs);
      }
      if (this.KJE != null)
      {
        paramVarArgs.ni(14, this.KJE.computeSize());
        this.KJE.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 1, this.KJF);
      if (this.KJG != null)
      {
        paramVarArgs.ni(16, this.KJG.computeSize());
        this.KJG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.KJH);
      if (this.KJI != null) {
        paramVarArgs.e(18, this.KJI);
      }
      AppMethodBeat.o(103196);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1962;
      }
    }
    label1962:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.KJu) + g.a.a.b.b.a.bu(3, this.KJv);
      paramInt = i;
      if (this.KJw != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KJw);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KJx) + g.a.a.b.b.a.bu(6, this.KJy) + g.a.a.b.b.a.bu(7, this.KJz);
      paramInt = i;
      if (this.KJA != null) {
        paramInt = i + g.a.a.a.nh(8, this.KJA.computeSize());
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.url);
      }
      paramInt = i;
      if (this.vid != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.vid);
      }
      i = paramInt;
      if (this.KJB != null) {
        i = paramInt + g.a.a.a.nh(11, this.KJB.computeSize());
      }
      paramInt = i;
      if (this.KJC != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KJC);
      }
      i = paramInt;
      if (this.KJD != null) {
        i = paramInt + g.a.a.a.nh(13, this.KJD.computeSize());
      }
      paramInt = i;
      if (this.KJE != null) {
        paramInt = i + g.a.a.a.nh(14, this.KJE.computeSize());
      }
      i = paramInt + g.a.a.a.c(15, 1, this.KJF);
      paramInt = i;
      if (this.KJG != null) {
        paramInt = i + g.a.a.a.nh(16, this.KJG.computeSize());
      }
      i = paramInt + g.a.a.a.c(17, 8, this.KJH);
      paramInt = i;
      if (this.KJI != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.KJI);
      }
      AppMethodBeat.o(103196);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KJu.clear();
        this.KJF.clear();
        this.KJH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(103196);
          throw paramVarArgs;
        }
        AppMethodBeat.o(103196);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ft localft = (ft)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103196);
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
            localft.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localft.KJu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 3: 
          localft.KJv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103196);
          return 0;
        case 4: 
          localft.KJw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 5: 
          localft.KJx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103196);
          return 0;
        case 6: 
          localft.KJy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103196);
          return 0;
        case 7: 
          localft.KJz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103196);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localft.KJA = ((fe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 9: 
          localft.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 10: 
          localft.vid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eqw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eqw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localft.KJB = ((eqw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 12: 
          localft.KJC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localft.KJD = ((cmb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localft.KJE = ((fp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 15: 
          localft.KJF.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(103196);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localft.KJG = ((eb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localft.KJH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        }
        localft.KJI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(103196);
        return 0;
      }
      AppMethodBeat.o(103196);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ft
 * JD-Core Version:    0.7.0.1
 */