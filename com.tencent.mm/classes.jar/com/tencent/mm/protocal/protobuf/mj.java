package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mj
  extends dop
{
  public SKBuiltinBuffer_t KNX;
  public String KPU;
  public String KPV;
  public SKBuiltinBuffer_t KQA;
  public int KQB;
  public String KQi;
  public int KQu;
  public String KQv;
  public String KQw;
  public String KQx;
  public int KQy;
  public dqi KQz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155396);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KQu);
      if (this.KQi != null) {
        paramVarArgs.e(3, this.KQi);
      }
      if (this.KQv != null) {
        paramVarArgs.e(4, this.KQv);
      }
      if (this.KQw != null) {
        paramVarArgs.e(5, this.KQw);
      }
      if (this.KQx != null) {
        paramVarArgs.e(6, this.KQx);
      }
      paramVarArgs.aM(7, this.KQy);
      if (this.KQz != null)
      {
        paramVarArgs.ni(8, this.KQz.computeSize());
        this.KQz.writeFields(paramVarArgs);
      }
      if (this.KQA != null)
      {
        paramVarArgs.ni(9, this.KQA.computeSize());
        this.KQA.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(10, this.KQB);
      if (this.KPU != null) {
        paramVarArgs.e(11, this.KPU);
      }
      if (this.KPV != null) {
        paramVarArgs.e(12, this.KPV);
      }
      if (this.KNX != null)
      {
        paramVarArgs.ni(13, this.KNX.computeSize());
        this.KNX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1282;
      }
    }
    label1282:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KQu);
      paramInt = i;
      if (this.KQi != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KQi);
      }
      i = paramInt;
      if (this.KQv != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KQv);
      }
      paramInt = i;
      if (this.KQw != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KQw);
      }
      i = paramInt;
      if (this.KQx != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KQx);
      }
      i += g.a.a.b.b.a.bu(7, this.KQy);
      paramInt = i;
      if (this.KQz != null) {
        paramInt = i + g.a.a.a.nh(8, this.KQz.computeSize());
      }
      i = paramInt;
      if (this.KQA != null) {
        i = paramInt + g.a.a.a.nh(9, this.KQA.computeSize());
      }
      i += g.a.a.b.b.a.bu(10, this.KQB);
      paramInt = i;
      if (this.KPU != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KPU);
      }
      i = paramInt;
      if (this.KPV != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.KPV);
      }
      paramInt = i;
      if (this.KNX != null) {
        paramInt = i + g.a.a.a.nh(13, this.KNX.computeSize());
      }
      AppMethodBeat.o(155396);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mj localmj = (mj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155396);
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
            localmj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 2: 
          localmj.KQu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155396);
          return 0;
        case 3: 
          localmj.KQi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 4: 
          localmj.KQv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 5: 
          localmj.KQw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 6: 
          localmj.KQx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 7: 
          localmj.KQy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155396);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmj.KQz = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmj.KQA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 10: 
          localmj.KQB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155396);
          return 0;
        case 11: 
          localmj.KPU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 12: 
          localmj.KPV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155396);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localmj.KNX = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      AppMethodBeat.o(155396);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mj
 * JD-Core Version:    0.7.0.1
 */