package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yf
  extends com.tencent.mm.bv.a
{
  public String kmn;
  public String title;
  public int wPm;
  public LinkedList<uo> wPn;
  
  public yf()
  {
    AppMethodBeat.i(89063);
    this.wPn = new LinkedList();
    AppMethodBeat.o(89063);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89064);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.kmn != null) {
        paramVarArgs.e(2, this.kmn);
      }
      paramVarArgs.aO(3, this.wPm);
      paramVarArgs.e(4, 8, this.wPn);
      AppMethodBeat.o(89064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = e.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kmn != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.kmn);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.wPm);
      int j = e.a.a.a.c(4, 8, this.wPn);
      AppMethodBeat.o(89064);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wPn.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        yf localyf = (yf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89064);
          return -1;
        case 1: 
          localyf.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89064);
          return 0;
        case 2: 
          localyf.kmn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89064);
          return 0;
        case 3: 
          localyf.wPm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89064);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((uo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localyf.wPn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89064);
        return 0;
      }
      AppMethodBeat.o(89064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yf
 * JD-Core Version:    0.7.0.1
 */