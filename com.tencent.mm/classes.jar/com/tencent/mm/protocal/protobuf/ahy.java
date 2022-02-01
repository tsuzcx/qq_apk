package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ahy
  extends dpc
{
  public int Brl;
  public long Brn;
  public SKBuiltinBuffer_t BsI;
  public String KIz;
  public int KUy;
  public int KXq;
  public int KZk;
  public int LrF;
  public int jeU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148653);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Brl);
      paramVarArgs.aM(2, this.KZk);
      paramVarArgs.aM(3, this.KUy);
      paramVarArgs.aM(5, this.KXq);
      if (this.KIz != null) {
        paramVarArgs.e(6, this.KIz);
      }
      if (this.BsI != null)
      {
        paramVarArgs.ni(7, this.BsI.computeSize());
        this.BsI.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.jeU);
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(9, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(10, this.LrF);
      paramVarArgs.bb(11, this.Brn);
      AppMethodBeat.o(148653);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Brl) + 0 + g.a.a.b.b.a.bu(2, this.KZk) + g.a.a.b.b.a.bu(3, this.KUy) + g.a.a.b.b.a.bu(5, this.KXq);
      paramInt = i;
      if (this.KIz != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KIz);
      }
      i = paramInt;
      if (this.BsI != null) {
        i = paramInt + g.a.a.a.nh(7, this.BsI.computeSize());
      }
      i += g.a.a.b.b.a.bu(8, this.jeU);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + g.a.a.a.nh(9, this.BaseResponse.computeSize());
      }
      i = g.a.a.b.b.a.bu(10, this.LrF);
      int j = g.a.a.b.b.a.r(11, this.Brn);
      AppMethodBeat.o(148653);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148653);
        throw paramVarArgs;
      }
      AppMethodBeat.o(148653);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ahy localahy = (ahy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(148653);
        return -1;
      case 1: 
        localahy.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148653);
        return 0;
      case 2: 
        localahy.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148653);
        return 0;
      case 3: 
        localahy.KUy = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148653);
        return 0;
      case 5: 
        localahy.KXq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148653);
        return 0;
      case 6: 
        localahy.KIz = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(148653);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localahy.BsI = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 8: 
        localahy.jeU = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148653);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new BaseResponse();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localahy.BaseResponse = ((BaseResponse)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 10: 
        localahy.LrF = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148653);
        return 0;
      }
      localahy.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(148653);
      return 0;
    }
    AppMethodBeat.o(148653);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahy
 * JD-Core Version:    0.7.0.1
 */