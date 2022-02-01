package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class adh
  extends cqk
{
  public String DRb;
  public int Eck;
  public int Eed;
  public int EfV;
  public int EvW;
  public int hNR;
  public SKBuiltinBuffer_t vTK;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148653);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vTK == null)
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
      paramVarArgs.aR(1, this.vTO);
      paramVarArgs.aR(2, this.EfV);
      paramVarArgs.aR(3, this.Eck);
      paramVarArgs.aR(5, this.Eed);
      if (this.DRb != null) {
        paramVarArgs.d(6, this.DRb);
      }
      if (this.vTK != null)
      {
        paramVarArgs.ln(7, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.hNR);
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(9, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.EvW);
      paramVarArgs.aO(11, this.vTQ);
      AppMethodBeat.o(148653);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.vTO) + 0 + f.a.a.b.b.a.bx(2, this.EfV) + f.a.a.b.b.a.bx(3, this.Eck) + f.a.a.b.b.a.bx(5, this.Eed);
      paramInt = i;
      if (this.DRb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DRb);
      }
      i = paramInt;
      if (this.vTK != null) {
        i = paramInt + f.a.a.a.lm(7, this.vTK.computeSize());
      }
      i += f.a.a.b.b.a.bx(8, this.hNR);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.lm(9, this.BaseResponse.computeSize());
      }
      i = f.a.a.b.b.a.bx(10, this.EvW);
      int j = f.a.a.b.b.a.p(11, this.vTQ);
      AppMethodBeat.o(148653);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.vTK == null)
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
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      adh localadh = (adh)paramVarArgs[1];
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
        localadh.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148653);
        return 0;
      case 2: 
        localadh.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148653);
        return 0;
      case 3: 
        localadh.Eck = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148653);
        return 0;
      case 5: 
        localadh.Eed = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148653);
        return 0;
      case 6: 
        localadh.DRb = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(148653);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localadh.vTK = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 8: 
        localadh.hNR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148653);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new BaseResponse();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localadh.BaseResponse = ((BaseResponse)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148653);
        return 0;
      case 10: 
        localadh.EvW = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(148653);
        return 0;
      }
      localadh.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(148653);
      return 0;
    }
    AppMethodBeat.o(148653);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adh
 * JD-Core Version:    0.7.0.1
 */