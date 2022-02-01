package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bvt
  extends dop
{
  public String KLN;
  public SKBuiltinBuffer_t KPW;
  public int LtW;
  public String MbG;
  public String MbH;
  public String MbI;
  public String MbJ;
  public String MbK;
  public String oUJ;
  public String rBI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155417);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KPW == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155417);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KPW != null)
      {
        paramVarArgs.ni(2, this.KPW.computeSize());
        this.KPW.writeFields(paramVarArgs);
      }
      if (this.MbG != null) {
        paramVarArgs.e(3, this.MbG);
      }
      if (this.MbH != null) {
        paramVarArgs.e(4, this.MbH);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(5, this.oUJ);
      }
      if (this.MbI != null) {
        paramVarArgs.e(6, this.MbI);
      }
      if (this.MbJ != null) {
        paramVarArgs.e(7, this.MbJ);
      }
      if (this.MbK != null) {
        paramVarArgs.e(8, this.MbK);
      }
      paramVarArgs.aM(9, this.LtW);
      if (this.rBI != null) {
        paramVarArgs.e(10, this.rBI);
      }
      if (this.KLN != null) {
        paramVarArgs.e(11, this.KLN);
      }
      AppMethodBeat.o(155417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1050;
      }
    }
    label1050:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KPW != null) {
        paramInt = i + g.a.a.a.nh(2, this.KPW.computeSize());
      }
      i = paramInt;
      if (this.MbG != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MbG);
      }
      paramInt = i;
      if (this.MbH != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MbH);
      }
      i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.oUJ);
      }
      paramInt = i;
      if (this.MbI != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MbI);
      }
      i = paramInt;
      if (this.MbJ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MbJ);
      }
      paramInt = i;
      if (this.MbK != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MbK);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.LtW);
      paramInt = i;
      if (this.rBI != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.rBI);
      }
      i = paramInt;
      if (this.KLN != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.KLN);
      }
      AppMethodBeat.o(155417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KPW == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(155417);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bvt localbvt = (bvt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155417);
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
            localbvt.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbvt.KPW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 3: 
          localbvt.MbG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 4: 
          localbvt.MbH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 5: 
          localbvt.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 6: 
          localbvt.MbI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 7: 
          localbvt.MbJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 8: 
          localbvt.MbK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 9: 
          localbvt.LtW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155417);
          return 0;
        case 10: 
          localbvt.rBI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155417);
          return 0;
        }
        localbvt.KLN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155417);
        return 0;
      }
      AppMethodBeat.o(155417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvt
 * JD-Core Version:    0.7.0.1
 */