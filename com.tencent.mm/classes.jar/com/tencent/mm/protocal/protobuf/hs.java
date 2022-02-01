package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hs
  extends com.tencent.mm.bx.a
{
  public int FAh;
  public SKBuiltinBuffer_t FAi;
  public bor FAj;
  public int FAk;
  public SKBuiltinBuffer_t FAl;
  public String FAm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133152);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.FAl == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.FAh);
      if (this.FAi != null)
      {
        paramVarArgs.lC(2, this.FAi.computeSize());
        this.FAi.writeFields(paramVarArgs);
      }
      if (this.FAj != null)
      {
        paramVarArgs.lC(3, this.FAj.computeSize());
        this.FAj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.FAk);
      if (this.FAl != null)
      {
        paramVarArgs.lC(5, this.FAl.computeSize());
        this.FAl.writeFields(paramVarArgs);
      }
      if (this.FAm != null) {
        paramVarArgs.d(6, this.FAm);
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FAh) + 0;
      paramInt = i;
      if (this.FAi != null) {
        paramInt = i + f.a.a.a.lB(2, this.FAi.computeSize());
      }
      i = paramInt;
      if (this.FAj != null) {
        i = paramInt + f.a.a.a.lB(3, this.FAj.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.FAk);
      paramInt = i;
      if (this.FAl != null) {
        paramInt = i + f.a.a.a.lB(5, this.FAl.computeSize());
      }
      i = paramInt;
      if (this.FAm != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FAm);
      }
      AppMethodBeat.o(133152);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.FAi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.FAl == null)
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
      hs localhs = (hs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133152);
        return -1;
      case 1: 
        localhs.FAh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133152);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhs.FAi = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bor();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bor)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhs.FAj = ((bor)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 4: 
        localhs.FAk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133152);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhs.FAl = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      }
      localhs.FAm = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(133152);
      return 0;
    }
    AppMethodBeat.o(133152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hs
 * JD-Core Version:    0.7.0.1
 */