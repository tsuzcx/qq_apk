package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhi
  extends dop
{
  public int KHa;
  public int KJS;
  public String KLR;
  public SKBuiltinBuffer_t KLh;
  public int KMd;
  public SKBuiltinBuffer_t LRA;
  public int LRB;
  public String LRC;
  public int LRD;
  public SKBuiltinBuffer_t LRE;
  public String LRF;
  public String LRG;
  public String LRa;
  public String LRb;
  public int LRd;
  public String LRe;
  public dqi LRu;
  public dqi LRv;
  public dqi LRw;
  public dqi LRx;
  public String LRy;
  public int LRz;
  public int Ljb;
  public int Ljc;
  public int OpCode;
  public int Scene;
  public String UserName;
  public String pLm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152552);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.OpCode);
      if (this.KLh != null)
      {
        paramVarArgs.ni(3, this.KLh.computeSize());
        this.KLh.writeFields(paramVarArgs);
      }
      if (this.LRu != null)
      {
        paramVarArgs.ni(4, this.LRu.computeSize());
        this.LRu.writeFields(paramVarArgs);
      }
      if (this.LRv != null)
      {
        paramVarArgs.ni(5, this.LRv.computeSize());
        this.LRv.writeFields(paramVarArgs);
      }
      if (this.LRw != null)
      {
        paramVarArgs.ni(6, this.LRw.computeSize());
        this.LRw.writeFields(paramVarArgs);
      }
      if (this.LRx != null)
      {
        paramVarArgs.ni(7, this.LRx.computeSize());
        this.LRx.writeFields(paramVarArgs);
      }
      if (this.LRy != null) {
        paramVarArgs.e(8, this.LRy);
      }
      paramVarArgs.aM(9, this.LRz);
      paramVarArgs.aM(10, this.Scene);
      if (this.UserName != null) {
        paramVarArgs.e(11, this.UserName);
      }
      if (this.KLR != null) {
        paramVarArgs.e(12, this.KLR);
      }
      if (this.LRA != null)
      {
        paramVarArgs.ni(13, this.LRA.computeSize());
        this.LRA.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.KMd);
      paramVarArgs.aM(15, this.LRd);
      paramVarArgs.aM(16, this.KHa);
      if (this.pLm != null) {
        paramVarArgs.e(17, this.pLm);
      }
      paramVarArgs.aM(18, this.Ljb);
      paramVarArgs.aM(19, this.Ljc);
      paramVarArgs.aM(20, this.LRB);
      if (this.LRC != null) {
        paramVarArgs.e(21, this.LRC);
      }
      paramVarArgs.aM(22, this.LRD);
      if (this.LRE != null)
      {
        paramVarArgs.ni(23, this.LRE.computeSize());
        this.LRE.writeFields(paramVarArgs);
      }
      if (this.LRe != null) {
        paramVarArgs.e(24, this.LRe);
      }
      paramVarArgs.aM(25, this.KJS);
      if (this.LRa != null) {
        paramVarArgs.e(26, this.LRa);
      }
      if (this.LRb != null) {
        paramVarArgs.e(27, this.LRb);
      }
      if (this.LRF != null) {
        paramVarArgs.e(28, this.LRF);
      }
      if (this.LRG != null) {
        paramVarArgs.e(29, this.LRG);
      }
      AppMethodBeat.o(152552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2510;
      }
    }
    label2510:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.OpCode);
      paramInt = i;
      if (this.KLh != null) {
        paramInt = i + g.a.a.a.nh(3, this.KLh.computeSize());
      }
      i = paramInt;
      if (this.LRu != null) {
        i = paramInt + g.a.a.a.nh(4, this.LRu.computeSize());
      }
      paramInt = i;
      if (this.LRv != null) {
        paramInt = i + g.a.a.a.nh(5, this.LRv.computeSize());
      }
      i = paramInt;
      if (this.LRw != null) {
        i = paramInt + g.a.a.a.nh(6, this.LRw.computeSize());
      }
      paramInt = i;
      if (this.LRx != null) {
        paramInt = i + g.a.a.a.nh(7, this.LRx.computeSize());
      }
      i = paramInt;
      if (this.LRy != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.LRy);
      }
      i = i + g.a.a.b.b.a.bu(9, this.LRz) + g.a.a.b.b.a.bu(10, this.Scene);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.UserName);
      }
      i = paramInt;
      if (this.KLR != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.KLR);
      }
      paramInt = i;
      if (this.LRA != null) {
        paramInt = i + g.a.a.a.nh(13, this.LRA.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.KMd) + g.a.a.b.b.a.bu(15, this.LRd) + g.a.a.b.b.a.bu(16, this.KHa);
      paramInt = i;
      if (this.pLm != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.pLm);
      }
      i = paramInt + g.a.a.b.b.a.bu(18, this.Ljb) + g.a.a.b.b.a.bu(19, this.Ljc) + g.a.a.b.b.a.bu(20, this.LRB);
      paramInt = i;
      if (this.LRC != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.LRC);
      }
      i = paramInt + g.a.a.b.b.a.bu(22, this.LRD);
      paramInt = i;
      if (this.LRE != null) {
        paramInt = i + g.a.a.a.nh(23, this.LRE.computeSize());
      }
      i = paramInt;
      if (this.LRe != null) {
        i = paramInt + g.a.a.b.b.a.f(24, this.LRe);
      }
      i += g.a.a.b.b.a.bu(25, this.KJS);
      paramInt = i;
      if (this.LRa != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.LRa);
      }
      i = paramInt;
      if (this.LRb != null) {
        i = paramInt + g.a.a.b.b.a.f(27, this.LRb);
      }
      paramInt = i;
      if (this.LRF != null) {
        paramInt = i + g.a.a.b.b.a.f(28, this.LRF);
      }
      i = paramInt;
      if (this.LRG != null) {
        i = paramInt + g.a.a.b.b.a.f(29, this.LRG);
      }
      AppMethodBeat.o(152552);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152552);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bhi localbhi = (bhi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152552);
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
            localbhi.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 2: 
          localbhi.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152552);
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
            localbhi.KLh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
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
            localbhi.LRu = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhi.LRv = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhi.LRw = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhi.LRx = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 8: 
          localbhi.LRy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 9: 
          localbhi.LRz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152552);
          return 0;
        case 10: 
          localbhi.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152552);
          return 0;
        case 11: 
          localbhi.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 12: 
          localbhi.KLR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhi.LRA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 14: 
          localbhi.KMd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152552);
          return 0;
        case 15: 
          localbhi.LRd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152552);
          return 0;
        case 16: 
          localbhi.KHa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152552);
          return 0;
        case 17: 
          localbhi.pLm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 18: 
          localbhi.Ljb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152552);
          return 0;
        case 19: 
          localbhi.Ljc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152552);
          return 0;
        case 20: 
          localbhi.LRB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152552);
          return 0;
        case 21: 
          localbhi.LRC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 22: 
          localbhi.LRD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152552);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhi.LRE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 24: 
          localbhi.LRe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 25: 
          localbhi.KJS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152552);
          return 0;
        case 26: 
          localbhi.LRa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 27: 
          localbhi.LRb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 28: 
          localbhi.LRF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152552);
          return 0;
        }
        localbhi.LRG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152552);
        return 0;
      }
      AppMethodBeat.o(152552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhi
 * JD-Core Version:    0.7.0.1
 */