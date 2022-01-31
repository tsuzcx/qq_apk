package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmk
  extends com.tencent.mm.bv.a
{
  public String content;
  public String title;
  public bae xWd;
  public bae xWe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48978);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.content != null) {
        paramVarArgs.e(2, this.content);
      }
      if (this.xWd != null)
      {
        paramVarArgs.iQ(3, this.xWd.computeSize());
        this.xWd.writeFields(paramVarArgs);
      }
      if (this.xWe != null)
      {
        paramVarArgs.iQ(4, this.xWe.computeSize());
        this.xWe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48978);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label586;
      }
    }
    label586:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.content != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.content);
      }
      i = paramInt;
      if (this.xWd != null) {
        i = paramInt + e.a.a.a.iP(3, this.xWd.computeSize());
      }
      paramInt = i;
      if (this.xWe != null) {
        paramInt = i + e.a.a.a.iP(4, this.xWe.computeSize());
      }
      AppMethodBeat.o(48978);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48978);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cmk localcmk = (cmk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48978);
          return -1;
        case 1: 
          localcmk.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48978);
          return 0;
        case 2: 
          localcmk.content = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48978);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bae();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bae)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcmk.xWd = ((bae)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48978);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bae();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bae)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcmk.xWe = ((bae)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48978);
        return 0;
      }
      AppMethodBeat.o(48978);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmk
 * JD-Core Version:    0.7.0.1
 */