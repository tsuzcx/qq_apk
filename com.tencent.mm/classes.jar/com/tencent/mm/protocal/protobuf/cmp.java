package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cmp
  extends dop
{
  public int LYt;
  public int LbA;
  public int Lbz;
  public String MrM;
  public String MrN;
  public String MrO;
  public int MrP;
  public SKBuiltinBuffer_t MrQ;
  public int MrR;
  public int MrS;
  public int MrT;
  public int MrU;
  public SKBuiltinBuffer_t MrV;
  public int MrW;
  public int MrX;
  public int MrY;
  public int MrZ;
  public int Msa;
  public String Msb;
  public String Msc;
  public String ThumbUrl;
  public int xKb;
  public String xLk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32345);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MrQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataBuffer");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.MrV == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MrM != null) {
        paramVarArgs.e(2, this.MrM);
      }
      if (this.MrN != null) {
        paramVarArgs.e(3, this.MrN);
      }
      if (this.MrO != null) {
        paramVarArgs.e(4, this.MrO);
      }
      paramVarArgs.aM(5, this.xKb);
      paramVarArgs.aM(6, this.MrP);
      if (this.MrQ != null)
      {
        paramVarArgs.ni(7, this.MrQ.computeSize());
        this.MrQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.MrR);
      paramVarArgs.aM(9, this.MrS);
      paramVarArgs.aM(10, this.MrT);
      paramVarArgs.aM(11, this.MrU);
      if (this.MrV != null)
      {
        paramVarArgs.ni(12, this.MrV.computeSize());
        this.MrV.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(13, this.MrW);
      paramVarArgs.aM(14, this.MrX);
      paramVarArgs.aM(15, this.MrY);
      paramVarArgs.aM(16, this.MrZ);
      paramVarArgs.aM(17, this.LYt);
      paramVarArgs.aM(18, this.Msa);
      if (this.xLk != null) {
        paramVarArgs.e(19, this.xLk);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(20, this.ThumbUrl);
      }
      paramVarArgs.aM(21, this.LbA);
      paramVarArgs.aM(22, this.Lbz);
      if (this.Msb != null) {
        paramVarArgs.e(23, this.Msb);
      }
      if (this.Msc != null) {
        paramVarArgs.e(24, this.Msc);
      }
      AppMethodBeat.o(32345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1804;
      }
    }
    label1804:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MrM != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MrM);
      }
      i = paramInt;
      if (this.MrN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MrN);
      }
      paramInt = i;
      if (this.MrO != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MrO);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.xKb) + g.a.a.b.b.a.bu(6, this.MrP);
      paramInt = i;
      if (this.MrQ != null) {
        paramInt = i + g.a.a.a.nh(7, this.MrQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.MrR) + g.a.a.b.b.a.bu(9, this.MrS) + g.a.a.b.b.a.bu(10, this.MrT) + g.a.a.b.b.a.bu(11, this.MrU);
      paramInt = i;
      if (this.MrV != null) {
        paramInt = i + g.a.a.a.nh(12, this.MrV.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.MrW) + g.a.a.b.b.a.bu(14, this.MrX) + g.a.a.b.b.a.bu(15, this.MrY) + g.a.a.b.b.a.bu(16, this.MrZ) + g.a.a.b.b.a.bu(17, this.LYt) + g.a.a.b.b.a.bu(18, this.Msa);
      paramInt = i;
      if (this.xLk != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.xLk);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.ThumbUrl);
      }
      i = i + g.a.a.b.b.a.bu(21, this.LbA) + g.a.a.b.b.a.bu(22, this.Lbz);
      paramInt = i;
      if (this.Msb != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.Msb);
      }
      i = paramInt;
      if (this.Msc != null) {
        i = paramInt + g.a.a.b.b.a.f(24, this.Msc);
      }
      AppMethodBeat.o(32345);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MrQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataBuffer");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        if (this.MrV == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32345);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cmp localcmp = (cmp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32345);
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
            localcmp.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 2: 
          localcmp.MrM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 3: 
          localcmp.MrN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 4: 
          localcmp.MrO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 5: 
          localcmp.xKb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 6: 
          localcmp.MrP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
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
            localcmp.MrQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 8: 
          localcmp.MrR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 9: 
          localcmp.MrS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 10: 
          localcmp.MrT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 11: 
          localcmp.MrU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcmp.MrV = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 13: 
          localcmp.MrW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 14: 
          localcmp.MrX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 15: 
          localcmp.MrY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 16: 
          localcmp.MrZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 17: 
          localcmp.LYt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 18: 
          localcmp.Msa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 19: 
          localcmp.xLk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 20: 
          localcmp.ThumbUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 21: 
          localcmp.LbA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 22: 
          localcmp.Lbz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32345);
          return 0;
        case 23: 
          localcmp.Msb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32345);
          return 0;
        }
        localcmp.Msc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32345);
        return 0;
      }
      AppMethodBeat.o(32345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmp
 * JD-Core Version:    0.7.0.1
 */