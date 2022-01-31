package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzy
  extends com.tencent.mm.bv.a
{
  public String sid;
  public String xLx;
  public String xLy;
  public LinkedList<cae> xLz;
  public String xkf;
  
  public bzy()
  {
    AppMethodBeat.i(152453);
    this.xLz = new LinkedList();
    AppMethodBeat.o(152453);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152454);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.sid != null) {
        paramVarArgs.e(1, this.sid);
      }
      if (this.xLx != null) {
        paramVarArgs.e(2, this.xLx);
      }
      if (this.xkf != null) {
        paramVarArgs.e(3, this.xkf);
      }
      if (this.xLy != null) {
        paramVarArgs.e(4, this.xLy);
      }
      paramVarArgs.e(5, 8, this.xLz);
      AppMethodBeat.o(152454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sid == null) {
        break label538;
      }
    }
    label538:
    for (int i = e.a.a.b.b.a.f(1, this.sid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xLx != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xLx);
      }
      i = paramInt;
      if (this.xkf != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xkf);
      }
      paramInt = i;
      if (this.xLy != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xLy);
      }
      i = e.a.a.a.c(5, 8, this.xLz);
      AppMethodBeat.o(152454);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLz.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(152454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bzy localbzy = (bzy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152454);
          return -1;
        case 1: 
          localbzy.sid = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152454);
          return 0;
        case 2: 
          localbzy.xLx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152454);
          return 0;
        case 3: 
          localbzy.xkf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152454);
          return 0;
        case 4: 
          localbzy.xLy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152454);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cae();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cae)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbzy.xLz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152454);
        return 0;
      }
      AppMethodBeat.o(152454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzy
 * JD-Core Version:    0.7.0.1
 */