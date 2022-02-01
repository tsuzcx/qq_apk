package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class hx
  extends dop
{
  public int KCx;
  public String KFu;
  public SKBuiltinBuffer_t KKZ;
  public jk KLK;
  public String KLL;
  public int KLM;
  public String KLN;
  public String KLO;
  public SKBuiltinBuffer_t KLP;
  public SKBuiltinBuffer_t KLQ;
  public String KLR;
  public dfx KLS;
  public String keb;
  public String oTI;
  public String rBH;
  public String rBI;
  public String yiZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133146);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KKZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133146);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KLK != null)
      {
        paramVarArgs.ni(2, this.KLK.computeSize());
        this.KLK.writeFields(paramVarArgs);
      }
      if (this.KKZ != null)
      {
        paramVarArgs.ni(3, this.KKZ.computeSize());
        this.KKZ.writeFields(paramVarArgs);
      }
      if (this.yiZ != null) {
        paramVarArgs.e(4, this.yiZ);
      }
      if (this.KLL != null) {
        paramVarArgs.e(5, this.KLL);
      }
      paramVarArgs.aM(6, this.KLM);
      if (this.KLN != null) {
        paramVarArgs.e(7, this.KLN);
      }
      if (this.keb != null) {
        paramVarArgs.e(8, this.keb);
      }
      if (this.oTI != null) {
        paramVarArgs.e(9, this.oTI);
      }
      if (this.KLO != null) {
        paramVarArgs.e(10, this.KLO);
      }
      if (this.rBI != null) {
        paramVarArgs.e(11, this.rBI);
      }
      if (this.rBH != null) {
        paramVarArgs.e(12, this.rBH);
      }
      paramVarArgs.aM(13, this.KCx);
      if (this.KLP != null)
      {
        paramVarArgs.ni(14, this.KLP.computeSize());
        this.KLP.writeFields(paramVarArgs);
      }
      if (this.KLQ != null)
      {
        paramVarArgs.ni(15, this.KLQ.computeSize());
        this.KLQ.writeFields(paramVarArgs);
      }
      if (this.KLR != null) {
        paramVarArgs.e(16, this.KLR);
      }
      if (this.KFu != null) {
        paramVarArgs.e(17, this.KFu);
      }
      if (this.KLS != null)
      {
        paramVarArgs.ni(18, this.KLS.computeSize());
        this.KLS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1842;
      }
    }
    label1842:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KLK != null) {
        paramInt = i + g.a.a.a.nh(2, this.KLK.computeSize());
      }
      i = paramInt;
      if (this.KKZ != null) {
        i = paramInt + g.a.a.a.nh(3, this.KKZ.computeSize());
      }
      paramInt = i;
      if (this.yiZ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.yiZ);
      }
      i = paramInt;
      if (this.KLL != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KLL);
      }
      i += g.a.a.b.b.a.bu(6, this.KLM);
      paramInt = i;
      if (this.KLN != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KLN);
      }
      i = paramInt;
      if (this.keb != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.keb);
      }
      paramInt = i;
      if (this.oTI != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.oTI);
      }
      i = paramInt;
      if (this.KLO != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.KLO);
      }
      paramInt = i;
      if (this.rBI != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.rBI);
      }
      i = paramInt;
      if (this.rBH != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.rBH);
      }
      i += g.a.a.b.b.a.bu(13, this.KCx);
      paramInt = i;
      if (this.KLP != null) {
        paramInt = i + g.a.a.a.nh(14, this.KLP.computeSize());
      }
      i = paramInt;
      if (this.KLQ != null) {
        i = paramInt + g.a.a.a.nh(15, this.KLQ.computeSize());
      }
      paramInt = i;
      if (this.KLR != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.KLR);
      }
      i = paramInt;
      if (this.KFu != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.KFu);
      }
      paramInt = i;
      if (this.KLS != null) {
        paramInt = i + g.a.a.a.nh(18, this.KLS.computeSize());
      }
      AppMethodBeat.o(133146);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KKZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
          AppMethodBeat.o(133146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        hx localhx = (hx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133146);
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
            localhx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localhx.KLK = ((jk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
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
            localhx.KKZ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 4: 
          localhx.yiZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 5: 
          localhx.KLL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 6: 
          localhx.KLM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133146);
          return 0;
        case 7: 
          localhx.KLN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 8: 
          localhx.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 9: 
          localhx.oTI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 10: 
          localhx.KLO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 11: 
          localhx.rBI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 12: 
          localhx.rBH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 13: 
          localhx.KCx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133146);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localhx.KLP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localhx.KLQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133146);
          return 0;
        case 16: 
          localhx.KLR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133146);
          return 0;
        case 17: 
          localhx.KFu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133146);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhx.KLS = ((dfx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133146);
        return 0;
      }
      AppMethodBeat.o(133146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hx
 * JD-Core Version:    0.7.0.1
 */