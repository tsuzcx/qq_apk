package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hh
  extends com.tencent.mm.bx.a
{
  public int CCp;
  public SKBuiltinBuffer_t CCq;
  public bgp CCr;
  public int CCs;
  public SKBuiltinBuffer_t CCt;
  public String CCu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133152);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CCq == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.CCt == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.CCp);
      if (this.CCq != null)
      {
        paramVarArgs.kX(2, this.CCq.computeSize());
        this.CCq.writeFields(paramVarArgs);
      }
      if (this.CCr != null)
      {
        paramVarArgs.kX(3, this.CCr.computeSize());
        this.CCr.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.CCs);
      if (this.CCt != null)
      {
        paramVarArgs.kX(5, this.CCt.computeSize());
        this.CCt.writeFields(paramVarArgs);
      }
      if (this.CCu != null) {
        paramVarArgs.d(6, this.CCu);
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CCp) + 0;
      paramInt = i;
      if (this.CCq != null) {
        paramInt = i + f.a.a.a.kW(2, this.CCq.computeSize());
      }
      i = paramInt;
      if (this.CCr != null) {
        i = paramInt + f.a.a.a.kW(3, this.CCr.computeSize());
      }
      i += f.a.a.b.b.a.bA(4, this.CCs);
      paramInt = i;
      if (this.CCt != null) {
        paramInt = i + f.a.a.a.kW(5, this.CCt.computeSize());
      }
      i = paramInt;
      if (this.CCu != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CCu);
      }
      AppMethodBeat.o(133152);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.CCq == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.CCt == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      hh localhh = (hh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133152);
        return -1;
      case 1: 
        localhh.CCp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133152);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhh.CCq = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhh.CCr = ((bgp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 4: 
        localhh.CCs = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133152);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhh.CCt = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      }
      localhh.CCu = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(133152);
      return 0;
    }
    AppMethodBeat.o(133152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hh
 * JD-Core Version:    0.7.0.1
 */