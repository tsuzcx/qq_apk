package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class gk
  extends com.tencent.mm.bv.a
{
  public int wsK;
  public SKBuiltinBuffer_t wsL;
  public avk wsM;
  public int wsN;
  public SKBuiltinBuffer_t wsO;
  public String wsP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(154771);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wsL == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(154771);
        throw paramVarArgs;
      }
      if (this.wsO == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(154771);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.wsK);
      if (this.wsL != null)
      {
        paramVarArgs.iQ(2, this.wsL.computeSize());
        this.wsL.writeFields(paramVarArgs);
      }
      if (this.wsM != null)
      {
        paramVarArgs.iQ(3, this.wsM.computeSize());
        this.wsM.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wsN);
      if (this.wsO != null)
      {
        paramVarArgs.iQ(5, this.wsO.computeSize());
        this.wsO.writeFields(paramVarArgs);
      }
      if (this.wsP != null) {
        paramVarArgs.e(6, this.wsP);
      }
      AppMethodBeat.o(154771);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wsK) + 0;
      paramInt = i;
      if (this.wsL != null) {
        paramInt = i + e.a.a.a.iP(2, this.wsL.computeSize());
      }
      i = paramInt;
      if (this.wsM != null) {
        i = paramInt + e.a.a.a.iP(3, this.wsM.computeSize());
      }
      i += e.a.a.b.b.a.bl(4, this.wsN);
      paramInt = i;
      if (this.wsO != null) {
        paramInt = i + e.a.a.a.iP(5, this.wsO.computeSize());
      }
      i = paramInt;
      if (this.wsP != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wsP);
      }
      AppMethodBeat.o(154771);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wsL == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(154771);
        throw paramVarArgs;
      }
      if (this.wsO == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(154771);
        throw paramVarArgs;
      }
      AppMethodBeat.o(154771);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      gk localgk = (gk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(154771);
        return -1;
      case 1: 
        localgk.wsK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(154771);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgk.wsL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(154771);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgk.wsM = ((avk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(154771);
        return 0;
      case 4: 
        localgk.wsN = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(154771);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgk.wsO = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(154771);
        return 0;
      }
      localgk.wsP = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(154771);
      return 0;
    }
    AppMethodBeat.o(154771);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gk
 * JD-Core Version:    0.7.0.1
 */