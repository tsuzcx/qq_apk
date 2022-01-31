package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axa
  extends com.tencent.mm.bv.a
{
  public String wug;
  public cjw xml;
  public LinkedList<cje> xmm;
  public cjw xmn;
  
  public axa()
  {
    AppMethodBeat.i(48879);
    this.xmm = new LinkedList();
    AppMethodBeat.o(48879);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48880);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xml != null)
      {
        paramVarArgs.iQ(1, this.xml.computeSize());
        this.xml.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.xmm);
      if (this.xmn != null)
      {
        paramVarArgs.iQ(3, this.xmn.computeSize());
        this.xmn.writeFields(paramVarArgs);
      }
      if (this.wug != null) {
        paramVarArgs.e(4, this.wug);
      }
      AppMethodBeat.o(48880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xml == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = e.a.a.a.iP(1, this.xml.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.xmm);
      paramInt = i;
      if (this.xmn != null) {
        paramInt = i + e.a.a.a.iP(3, this.xmn.computeSize());
      }
      i = paramInt;
      if (this.wug != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wug);
      }
      AppMethodBeat.o(48880);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xmm.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48880);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axa localaxa = (axa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48880);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxa.xml = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48880);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cje();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cje)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxa.xmm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48880);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxa.xmn = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48880);
          return 0;
        }
        localaxa.wug = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48880);
        return 0;
      }
      AppMethodBeat.o(48880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axa
 * JD-Core Version:    0.7.0.1
 */