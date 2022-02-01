package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mh
  extends dop
{
  public String KLN;
  public SKBuiltinBuffer_t KLQ;
  public String KLk;
  public int KMz;
  public String KPP;
  public String KPQ;
  public int KPR;
  public String KPS;
  public int KPT;
  public String KPU;
  public String KPV;
  public SKBuiltinBuffer_t KPW;
  public int KPX;
  public int KPY;
  public int KPZ;
  public String KQa;
  public SKBuiltinBuffer_t KQb;
  public String KQc;
  public dyx KQd;
  public cta KQe;
  public String KQf;
  public String UserName;
  public String rBI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134243);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.KPP != null) {
        paramVarArgs.e(3, this.KPP);
      }
      paramVarArgs.aM(4, this.KMz);
      if (this.KPQ != null) {
        paramVarArgs.e(5, this.KPQ);
      }
      paramVarArgs.aM(6, this.KPR);
      if (this.KPS != null) {
        paramVarArgs.e(7, this.KPS);
      }
      if (this.KLk != null) {
        paramVarArgs.e(8, this.KLk);
      }
      paramVarArgs.aM(9, this.KPT);
      if (this.KPU != null) {
        paramVarArgs.e(10, this.KPU);
      }
      if (this.KPV != null) {
        paramVarArgs.e(11, this.KPV);
      }
      if (this.KPW != null)
      {
        paramVarArgs.ni(12, this.KPW.computeSize());
        this.KPW.writeFields(paramVarArgs);
      }
      if (this.rBI != null) {
        paramVarArgs.e(13, this.rBI);
      }
      paramVarArgs.aM(14, this.KPX);
      paramVarArgs.aM(15, this.KPY);
      if (this.KLN != null) {
        paramVarArgs.e(16, this.KLN);
      }
      paramVarArgs.aM(17, this.KPZ);
      if (this.KQa != null) {
        paramVarArgs.e(18, this.KQa);
      }
      if (this.KQb != null)
      {
        paramVarArgs.ni(19, this.KQb.computeSize());
        this.KQb.writeFields(paramVarArgs);
      }
      if (this.KLQ != null)
      {
        paramVarArgs.ni(20, this.KLQ.computeSize());
        this.KLQ.writeFields(paramVarArgs);
      }
      if (this.KQc != null) {
        paramVarArgs.e(21, this.KQc);
      }
      if (this.KQd != null)
      {
        paramVarArgs.ni(22, this.KQd.computeSize());
        this.KQd.writeFields(paramVarArgs);
      }
      if (this.KQe != null)
      {
        paramVarArgs.ni(23, this.KQe.computeSize());
        this.KQe.writeFields(paramVarArgs);
      }
      if (this.KQf != null) {
        paramVarArgs.e(24, this.KQf);
      }
      AppMethodBeat.o(134243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2102;
      }
    }
    label2102:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.KPP != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KPP);
      }
      i += g.a.a.b.b.a.bu(4, this.KMz);
      paramInt = i;
      if (this.KPQ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KPQ);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.KPR);
      paramInt = i;
      if (this.KPS != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KPS);
      }
      i = paramInt;
      if (this.KLk != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KLk);
      }
      i += g.a.a.b.b.a.bu(9, this.KPT);
      paramInt = i;
      if (this.KPU != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KPU);
      }
      i = paramInt;
      if (this.KPV != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.KPV);
      }
      paramInt = i;
      if (this.KPW != null) {
        paramInt = i + g.a.a.a.nh(12, this.KPW.computeSize());
      }
      i = paramInt;
      if (this.rBI != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.rBI);
      }
      i = i + g.a.a.b.b.a.bu(14, this.KPX) + g.a.a.b.b.a.bu(15, this.KPY);
      paramInt = i;
      if (this.KLN != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.KLN);
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.KPZ);
      paramInt = i;
      if (this.KQa != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.KQa);
      }
      i = paramInt;
      if (this.KQb != null) {
        i = paramInt + g.a.a.a.nh(19, this.KQb.computeSize());
      }
      paramInt = i;
      if (this.KLQ != null) {
        paramInt = i + g.a.a.a.nh(20, this.KLQ.computeSize());
      }
      i = paramInt;
      if (this.KQc != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.KQc);
      }
      paramInt = i;
      if (this.KQd != null) {
        paramInt = i + g.a.a.a.nh(22, this.KQd.computeSize());
      }
      i = paramInt;
      if (this.KQe != null) {
        i = paramInt + g.a.a.a.nh(23, this.KQe.computeSize());
      }
      paramInt = i;
      if (this.KQf != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.KQf);
      }
      AppMethodBeat.o(134243);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(134243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mh localmh = (mh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134243);
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
            localmh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 2: 
          localmh.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 3: 
          localmh.KPP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 4: 
          localmh.KMz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134243);
          return 0;
        case 5: 
          localmh.KPQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 6: 
          localmh.KPR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134243);
          return 0;
        case 7: 
          localmh.KPS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 8: 
          localmh.KLk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 9: 
          localmh.KPT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134243);
          return 0;
        case 10: 
          localmh.KPU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 11: 
          localmh.KPV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134243);
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
            localmh.KPW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 13: 
          localmh.rBI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 14: 
          localmh.KPX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134243);
          return 0;
        case 15: 
          localmh.KPY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134243);
          return 0;
        case 16: 
          localmh.KLN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 17: 
          localmh.KPZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(134243);
          return 0;
        case 18: 
          localmh.KQa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmh.KQb = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmh.KLQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 21: 
          localmh.KQc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmh.KQd = ((dyx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cta();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmh.KQe = ((cta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        }
        localmh.KQf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(134243);
        return 0;
      }
      AppMethodBeat.o(134243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mh
 * JD-Core Version:    0.7.0.1
 */