package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class nb
  extends dop
{
  public int KND;
  public long KRC;
  public String KRD;
  public String KRE;
  public nd KRG;
  public String KRH;
  public String KRI;
  public int KRJ;
  public int KRK;
  public b KRc;
  public long KRi;
  public GoodsObject KRl;
  public mu KRo;
  public int mode;
  public int type;
  public String xve;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212229);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KRc != null) {
        paramVarArgs.c(2, this.KRc);
      }
      paramVarArgs.aM(11, this.type);
      paramVarArgs.aM(12, this.mode);
      paramVarArgs.bb(18, this.KRi);
      if (this.KRl != null)
      {
        paramVarArgs.ni(21, this.KRl.computeSize());
        this.KRl.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(22, this.KND);
      if (this.KRG != null)
      {
        paramVarArgs.ni(23, this.KRG.computeSize());
        this.KRG.writeFields(paramVarArgs);
      }
      if (this.KRo != null)
      {
        paramVarArgs.ni(26, this.KRo.computeSize());
        this.KRo.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(27, this.KRC);
      if (this.KRD != null) {
        paramVarArgs.e(28, this.KRD);
      }
      if (this.KRE != null) {
        paramVarArgs.e(29, this.KRE);
      }
      if (this.xve != null) {
        paramVarArgs.e(30, this.xve);
      }
      if (this.KRH != null) {
        paramVarArgs.e(31, this.KRH);
      }
      if (this.KRI != null) {
        paramVarArgs.e(32, this.KRI);
      }
      paramVarArgs.aM(33, this.KRJ);
      paramVarArgs.aM(34, this.KRK);
      AppMethodBeat.o(212229);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1538;
      }
    }
    label1538:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KRc != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.KRc);
      }
      i = i + g.a.a.b.b.a.bu(11, this.type) + g.a.a.b.b.a.bu(12, this.mode) + g.a.a.b.b.a.r(18, this.KRi);
      paramInt = i;
      if (this.KRl != null) {
        paramInt = i + g.a.a.a.nh(21, this.KRl.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(22, this.KND);
      paramInt = i;
      if (this.KRG != null) {
        paramInt = i + g.a.a.a.nh(23, this.KRG.computeSize());
      }
      i = paramInt;
      if (this.KRo != null) {
        i = paramInt + g.a.a.a.nh(26, this.KRo.computeSize());
      }
      i += g.a.a.b.b.a.r(27, this.KRC);
      paramInt = i;
      if (this.KRD != null) {
        paramInt = i + g.a.a.b.b.a.f(28, this.KRD);
      }
      i = paramInt;
      if (this.KRE != null) {
        i = paramInt + g.a.a.b.b.a.f(29, this.KRE);
      }
      paramInt = i;
      if (this.xve != null) {
        paramInt = i + g.a.a.b.b.a.f(30, this.xve);
      }
      i = paramInt;
      if (this.KRH != null) {
        i = paramInt + g.a.a.b.b.a.f(31, this.KRH);
      }
      paramInt = i;
      if (this.KRI != null) {
        paramInt = i + g.a.a.b.b.a.f(32, this.KRI);
      }
      i = g.a.a.b.b.a.bu(33, this.KRJ);
      int j = g.a.a.b.b.a.bu(34, this.KRK);
      AppMethodBeat.o(212229);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212229);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        nb localnb = (nb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 19: 
        case 20: 
        case 24: 
        case 25: 
        default: 
          AppMethodBeat.o(212229);
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
            localnb.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212229);
          return 0;
        case 2: 
          localnb.KRc = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(212229);
          return 0;
        case 11: 
          localnb.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212229);
          return 0;
        case 12: 
          localnb.mode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212229);
          return 0;
        case 18: 
          localnb.KRi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(212229);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localnb.KRl = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212229);
          return 0;
        case 22: 
          localnb.KND = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212229);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localnb.KRG = ((nd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212229);
          return 0;
        case 26: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localnb.KRo = ((mu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212229);
          return 0;
        case 27: 
          localnb.KRC = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(212229);
          return 0;
        case 28: 
          localnb.KRD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212229);
          return 0;
        case 29: 
          localnb.KRE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212229);
          return 0;
        case 30: 
          localnb.xve = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212229);
          return 0;
        case 31: 
          localnb.KRH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212229);
          return 0;
        case 32: 
          localnb.KRI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212229);
          return 0;
        case 33: 
          localnb.KRJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212229);
          return 0;
        }
        localnb.KRK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(212229);
        return 0;
      }
      AppMethodBeat.o(212229);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nb
 * JD-Core Version:    0.7.0.1
 */