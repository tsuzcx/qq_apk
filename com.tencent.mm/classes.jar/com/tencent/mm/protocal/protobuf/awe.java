package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class awe
  extends com.tencent.mm.bv.a
{
  public int cCD;
  public String xlB;
  public String xlC;
  public String xlD;
  public bkb xlE;
  public String xlx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48874);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlx == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(48874);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.cCD);
      if (this.xlx != null) {
        paramVarArgs.e(2, this.xlx);
      }
      if (this.xlB != null) {
        paramVarArgs.e(3, this.xlB);
      }
      if (this.xlC != null) {
        paramVarArgs.e(4, this.xlC);
      }
      if (this.xlD != null) {
        paramVarArgs.e(5, this.xlD);
      }
      if (this.xlE != null)
      {
        paramVarArgs.iQ(6, this.xlE.computeSize());
        this.xlE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48874);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.cCD) + 0;
      paramInt = i;
      if (this.xlx != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xlx);
      }
      i = paramInt;
      if (this.xlB != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xlB);
      }
      paramInt = i;
      if (this.xlC != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xlC);
      }
      i = paramInt;
      if (this.xlD != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xlD);
      }
      paramInt = i;
      if (this.xlE != null) {
        paramInt = i + e.a.a.a.iP(6, this.xlE.computeSize());
      }
      AppMethodBeat.o(48874);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xlx == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(48874);
        throw paramVarArgs;
      }
      AppMethodBeat.o(48874);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      awe localawe = (awe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(48874);
        return -1;
      case 1: 
        localawe.cCD = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48874);
        return 0;
      case 2: 
        localawe.xlx = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48874);
        return 0;
      case 3: 
        localawe.xlB = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48874);
        return 0;
      case 4: 
        localawe.xlC = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48874);
        return 0;
      case 5: 
        localawe.xlD = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48874);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bkb();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bkb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localawe.xlE = ((bkb)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(48874);
      return 0;
    }
    AppMethodBeat.o(48874);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awe
 * JD-Core Version:    0.7.0.1
 */