package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class caa
  extends com.tencent.mm.bv.a
{
  public String sid;
  public String xLE;
  public String xLF;
  public String xLx;
  public LinkedList<cae> xLz;
  public String xkf;
  
  public caa()
  {
    AppMethodBeat.i(152457);
    this.xLz = new LinkedList();
    AppMethodBeat.o(152457);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152458);
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
      if (this.xLE != null) {
        paramVarArgs.e(4, this.xLE);
      }
      if (this.xLF != null) {
        paramVarArgs.e(5, this.xLF);
      }
      paramVarArgs.e(6, 8, this.xLz);
      AppMethodBeat.o(152458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sid == null) {
        break label598;
      }
    }
    label598:
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
      if (this.xLE != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xLE);
      }
      i = paramInt;
      if (this.xLF != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xLF);
      }
      paramInt = e.a.a.a.c(6, 8, this.xLz);
      AppMethodBeat.o(152458);
      return i + paramInt;
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
        AppMethodBeat.o(152458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        caa localcaa = (caa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152458);
          return -1;
        case 1: 
          localcaa.sid = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152458);
          return 0;
        case 2: 
          localcaa.xLx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152458);
          return 0;
        case 3: 
          localcaa.xkf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152458);
          return 0;
        case 4: 
          localcaa.xLE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152458);
          return 0;
        case 5: 
          localcaa.xLF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(152458);
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
          localcaa.xLz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152458);
        return 0;
      }
      AppMethodBeat.o(152458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caa
 * JD-Core Version:    0.7.0.1
 */