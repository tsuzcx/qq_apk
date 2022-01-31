package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kt
  extends com.tencent.mm.bv.a
{
  public kw wyk;
  public String wyl;
  public String wym;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11705);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyk != null)
      {
        paramVarArgs.iQ(1, this.wyk.computeSize());
        this.wyk.writeFields(paramVarArgs);
      }
      if (this.wyl != null) {
        paramVarArgs.e(2, this.wyl);
      }
      if (this.wym != null) {
        paramVarArgs.e(3, this.wym);
      }
      AppMethodBeat.o(11705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wyk == null) {
        break label439;
      }
    }
    label439:
    for (int i = e.a.a.a.iP(1, this.wyk.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wyl != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wyl);
      }
      i = paramInt;
      if (this.wym != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wym);
      }
      AppMethodBeat.o(11705);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        kt localkt = (kt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11705);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new kw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((kw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localkt.wyk = ((kw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11705);
          return 0;
        case 2: 
          localkt.wyl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11705);
          return 0;
        }
        localkt.wym = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(11705);
        return 0;
      }
      AppMethodBeat.o(11705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kt
 * JD-Core Version:    0.7.0.1
 */