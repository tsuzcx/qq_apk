package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class awr
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public int lGw;
  public String wNM;
  public String wvs;
  public bwc xmi;
  public int xmj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73722);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xmi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(73722);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.lGw);
      if (this.xmi != null)
      {
        paramVarArgs.iQ(2, this.xmi.computeSize());
        this.xmi.writeFields(paramVarArgs);
      }
      if (this.wvs != null) {
        paramVarArgs.e(3, this.wvs);
      }
      if (this.wNM != null) {
        paramVarArgs.e(4, this.wNM);
      }
      if (this.jJA != null) {
        paramVarArgs.e(5, this.jJA);
      }
      paramVarArgs.aO(6, this.xmj);
      AppMethodBeat.o(73722);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.lGw) + 0;
      paramInt = i;
      if (this.xmi != null) {
        paramInt = i + e.a.a.a.iP(2, this.xmi.computeSize());
      }
      i = paramInt;
      if (this.wvs != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wvs);
      }
      paramInt = i;
      if (this.wNM != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wNM);
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.jJA);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.xmj);
      AppMethodBeat.o(73722);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xmi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(73722);
        throw paramVarArgs;
      }
      AppMethodBeat.o(73722);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      awr localawr = (awr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(73722);
        return -1;
      case 1: 
        localawr.lGw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(73722);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localawr.xmi = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73722);
        return 0;
      case 3: 
        localawr.wvs = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(73722);
        return 0;
      case 4: 
        localawr.wNM = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(73722);
        return 0;
      case 5: 
        localawr.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(73722);
        return 0;
      }
      localawr.xmj = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(73722);
      return 0;
    }
    AppMethodBeat.o(73722);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awr
 * JD-Core Version:    0.7.0.1
 */