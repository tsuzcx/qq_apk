package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eoc
  extends dop
{
  public String KHq;
  public String KIz;
  public int KTf;
  public String LbJ;
  public int LbK;
  public int LbL;
  public int LbM;
  public String LbN;
  public int LrC;
  public int LsF;
  public int MVx;
  public int MXo;
  public String Mip;
  public String Mir;
  public int MrT;
  public int MrU;
  public SKBuiltinBuffer_t MrV;
  public int MrW;
  public int NlH;
  public int NlI;
  public int NlJ;
  public int NlP;
  public int NlQ;
  public SKBuiltinBuffer_t NlR;
  public String NlS;
  public int NlT;
  public String NlU;
  public String NlV;
  public int NlW;
  public String NlX;
  public String NlY;
  public String NlZ;
  public String Nma;
  public String Nmb;
  public String Nmc;
  public String Nmd;
  public String Nme;
  public String xNG;
  public String xNH;
  public int xub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127180);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MrV == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.NlR == null)
      {
        paramVarArgs = new b("Not all required fields were included: VideoData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KIz != null) {
        paramVarArgs.e(2, this.KIz);
      }
      if (this.xNH != null) {
        paramVarArgs.e(3, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(4, this.xNG);
      }
      paramVarArgs.aM(5, this.MrT);
      paramVarArgs.aM(6, this.MrU);
      if (this.MrV != null)
      {
        paramVarArgs.ni(7, this.MrV.computeSize());
        this.MrV.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.NlP);
      paramVarArgs.aM(9, this.NlQ);
      if (this.NlR != null)
      {
        paramVarArgs.ni(10, this.NlR.computeSize());
        this.NlR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.MXo);
      paramVarArgs.aM(12, this.LrC);
      paramVarArgs.aM(13, this.MrW);
      paramVarArgs.aM(14, this.KTf);
      if (this.KHq != null) {
        paramVarArgs.e(15, this.KHq);
      }
      if (this.NlS != null) {
        paramVarArgs.e(16, this.NlS);
      }
      if (this.LbJ != null) {
        paramVarArgs.e(17, this.LbJ);
      }
      paramVarArgs.aM(18, this.LbK);
      if (this.Mip != null) {
        paramVarArgs.e(19, this.Mip);
      }
      paramVarArgs.aM(20, this.NlH);
      paramVarArgs.aM(21, this.NlI);
      paramVarArgs.aM(22, this.NlJ);
      if (this.Mir != null) {
        paramVarArgs.e(23, this.Mir);
      }
      paramVarArgs.aM(24, this.NlT);
      paramVarArgs.aM(25, this.LsF);
      if (this.NlU != null) {
        paramVarArgs.e(26, this.NlU);
      }
      if (this.NlV != null) {
        paramVarArgs.e(27, this.NlV);
      }
      paramVarArgs.aM(28, this.NlW);
      if (this.NlX != null) {
        paramVarArgs.e(29, this.NlX);
      }
      if (this.NlY != null) {
        paramVarArgs.e(30, this.NlY);
      }
      if (this.NlZ != null) {
        paramVarArgs.e(31, this.NlZ);
      }
      if (this.Nma != null) {
        paramVarArgs.e(32, this.Nma);
      }
      if (this.Nmb != null) {
        paramVarArgs.e(33, this.Nmb);
      }
      if (this.Nmc != null) {
        paramVarArgs.e(34, this.Nmc);
      }
      if (this.Nmd != null) {
        paramVarArgs.e(35, this.Nmd);
      }
      paramVarArgs.aM(36, this.MVx);
      if (this.Nme != null) {
        paramVarArgs.e(37, this.Nme);
      }
      paramVarArgs.aM(38, this.LbL);
      paramVarArgs.aM(39, this.LbM);
      paramVarArgs.aM(40, this.xub);
      if (this.LbN != null) {
        paramVarArgs.e(41, this.LbN);
      }
      AppMethodBeat.o(127180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2742;
      }
    }
    label2742:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KIz != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KIz);
      }
      i = paramInt;
      if (this.xNH != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNH);
      }
      paramInt = i;
      if (this.xNG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xNG);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MrT) + g.a.a.b.b.a.bu(6, this.MrU);
      paramInt = i;
      if (this.MrV != null) {
        paramInt = i + g.a.a.a.nh(7, this.MrV.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.NlP) + g.a.a.b.b.a.bu(9, this.NlQ);
      paramInt = i;
      if (this.NlR != null) {
        paramInt = i + g.a.a.a.nh(10, this.NlR.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.MXo) + g.a.a.b.b.a.bu(12, this.LrC) + g.a.a.b.b.a.bu(13, this.MrW) + g.a.a.b.b.a.bu(14, this.KTf);
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.KHq);
      }
      i = paramInt;
      if (this.NlS != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.NlS);
      }
      paramInt = i;
      if (this.LbJ != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.LbJ);
      }
      i = paramInt + g.a.a.b.b.a.bu(18, this.LbK);
      paramInt = i;
      if (this.Mip != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.Mip);
      }
      i = paramInt + g.a.a.b.b.a.bu(20, this.NlH) + g.a.a.b.b.a.bu(21, this.NlI) + g.a.a.b.b.a.bu(22, this.NlJ);
      paramInt = i;
      if (this.Mir != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.Mir);
      }
      i = paramInt + g.a.a.b.b.a.bu(24, this.NlT) + g.a.a.b.b.a.bu(25, this.LsF);
      paramInt = i;
      if (this.NlU != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.NlU);
      }
      i = paramInt;
      if (this.NlV != null) {
        i = paramInt + g.a.a.b.b.a.f(27, this.NlV);
      }
      i += g.a.a.b.b.a.bu(28, this.NlW);
      paramInt = i;
      if (this.NlX != null) {
        paramInt = i + g.a.a.b.b.a.f(29, this.NlX);
      }
      i = paramInt;
      if (this.NlY != null) {
        i = paramInt + g.a.a.b.b.a.f(30, this.NlY);
      }
      paramInt = i;
      if (this.NlZ != null) {
        paramInt = i + g.a.a.b.b.a.f(31, this.NlZ);
      }
      i = paramInt;
      if (this.Nma != null) {
        i = paramInt + g.a.a.b.b.a.f(32, this.Nma);
      }
      paramInt = i;
      if (this.Nmb != null) {
        paramInt = i + g.a.a.b.b.a.f(33, this.Nmb);
      }
      i = paramInt;
      if (this.Nmc != null) {
        i = paramInt + g.a.a.b.b.a.f(34, this.Nmc);
      }
      paramInt = i;
      if (this.Nmd != null) {
        paramInt = i + g.a.a.b.b.a.f(35, this.Nmd);
      }
      i = paramInt + g.a.a.b.b.a.bu(36, this.MVx);
      paramInt = i;
      if (this.Nme != null) {
        paramInt = i + g.a.a.b.b.a.f(37, this.Nme);
      }
      i = paramInt + g.a.a.b.b.a.bu(38, this.LbL) + g.a.a.b.b.a.bu(39, this.LbM) + g.a.a.b.b.a.bu(40, this.xub);
      paramInt = i;
      if (this.LbN != null) {
        paramInt = i + g.a.a.b.b.a.f(41, this.LbN);
      }
      AppMethodBeat.o(127180);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MrV == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        if (this.NlR == null)
        {
          paramVarArgs = new b("Not all required fields were included: VideoData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eoc localeoc = (eoc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127180);
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
            localeoc.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 2: 
          localeoc.KIz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 3: 
          localeoc.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 4: 
          localeoc.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 5: 
          localeoc.MrT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 6: 
          localeoc.MrU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeoc.MrV = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 8: 
          localeoc.NlP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 9: 
          localeoc.NlQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeoc.NlR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 11: 
          localeoc.MXo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 12: 
          localeoc.LrC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 13: 
          localeoc.MrW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 14: 
          localeoc.KTf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 15: 
          localeoc.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 16: 
          localeoc.NlS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 17: 
          localeoc.LbJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 18: 
          localeoc.LbK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 19: 
          localeoc.Mip = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 20: 
          localeoc.NlH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 21: 
          localeoc.NlI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 22: 
          localeoc.NlJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 23: 
          localeoc.Mir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 24: 
          localeoc.NlT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 25: 
          localeoc.LsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 26: 
          localeoc.NlU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 27: 
          localeoc.NlV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 28: 
          localeoc.NlW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 29: 
          localeoc.NlX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 30: 
          localeoc.NlY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 31: 
          localeoc.NlZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 32: 
          localeoc.Nma = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 33: 
          localeoc.Nmb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 34: 
          localeoc.Nmc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 35: 
          localeoc.Nmd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 36: 
          localeoc.MVx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 37: 
          localeoc.Nme = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 38: 
          localeoc.LbL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 39: 
          localeoc.LbM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        case 40: 
          localeoc.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127180);
          return 0;
        }
        localeoc.LbN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127180);
        return 0;
      }
      AppMethodBeat.o(127180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoc
 * JD-Core Version:    0.7.0.1
 */