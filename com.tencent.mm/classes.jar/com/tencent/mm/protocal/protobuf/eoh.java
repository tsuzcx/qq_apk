package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eoh
  extends dop
{
  public int Brl;
  public long Brn;
  public SKBuiltinBuffer_t BsI;
  public String KHq;
  public String KIz;
  public int KUy;
  public int KXq;
  public int KZk;
  public String LbN;
  public int LrF;
  public int LsF;
  public int Msa;
  public int Nmf;
  public int Nmg;
  public int jeU;
  public String xNG;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148661);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148661);
        throw paramVarArgs;
      }
      if (this.xNH != null) {
        paramVarArgs.e(1, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(2, this.xNG);
      }
      paramVarArgs.aM(3, this.KZk);
      paramVarArgs.aM(4, this.KUy);
      if (this.KIz != null) {
        paramVarArgs.e(5, this.KIz);
      }
      paramVarArgs.aM(6, this.Brl);
      paramVarArgs.aM(7, this.KXq);
      if (this.BsI != null)
      {
        paramVarArgs.ni(8, this.BsI.computeSize());
        this.BsI.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.jeU);
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(10, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.LrF);
      if (this.KHq != null) {
        paramVarArgs.e(12, this.KHq);
      }
      paramVarArgs.aM(13, this.Msa);
      paramVarArgs.aM(14, this.Nmf);
      paramVarArgs.aM(15, this.Nmg);
      paramVarArgs.bb(16, this.Brn);
      paramVarArgs.aM(17, this.LsF);
      if (this.LbN != null) {
        paramVarArgs.e(19, this.LbN);
      }
      AppMethodBeat.o(148661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xNH == null) {
        break label1314;
      }
    }
    label1314:
    for (paramInt = g.a.a.b.b.a.f(1, this.xNH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xNG != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xNG);
      }
      i = i + g.a.a.b.b.a.bu(3, this.KZk) + g.a.a.b.b.a.bu(4, this.KUy);
      paramInt = i;
      if (this.KIz != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KIz);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.Brl) + g.a.a.b.b.a.bu(7, this.KXq);
      paramInt = i;
      if (this.BsI != null) {
        paramInt = i + g.a.a.a.nh(8, this.BsI.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.jeU);
      paramInt = i;
      if (this.BaseRequest != null) {
        paramInt = i + g.a.a.a.nh(10, this.BaseRequest.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.LrF);
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KHq);
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.Msa) + g.a.a.b.b.a.bu(14, this.Nmf) + g.a.a.b.b.a.bu(15, this.Nmg) + g.a.a.b.b.a.r(16, this.Brn) + g.a.a.b.b.a.bu(17, this.LsF);
      paramInt = i;
      if (this.LbN != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.LbN);
      }
      AppMethodBeat.o(148661);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BsI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148661);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148661);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eoh localeoh = (eoh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(148661);
          return -1;
        case 1: 
          localeoh.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 2: 
          localeoh.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 3: 
          localeoh.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148661);
          return 0;
        case 4: 
          localeoh.KUy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148661);
          return 0;
        case 5: 
          localeoh.KIz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 6: 
          localeoh.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148661);
          return 0;
        case 7: 
          localeoh.KXq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148661);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeoh.BsI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 9: 
          localeoh.jeU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148661);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeoh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 11: 
          localeoh.LrF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148661);
          return 0;
        case 12: 
          localeoh.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 13: 
          localeoh.Msa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148661);
          return 0;
        case 14: 
          localeoh.Nmf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148661);
          return 0;
        case 15: 
          localeoh.Nmg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148661);
          return 0;
        case 16: 
          localeoh.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(148661);
          return 0;
        case 17: 
          localeoh.LsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(148661);
          return 0;
        }
        localeoh.LbN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(148661);
        return 0;
      }
      AppMethodBeat.o(148661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoh
 * JD-Core Version:    0.7.0.1
 */