package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class nb
  extends com.tencent.mm.bv.a
{
  public String jKG;
  public String npR;
  public nd wBR;
  public bya wBU;
  public nj wBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124293);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jKG == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(124293);
        throw paramVarArgs;
      }
      if (this.wBU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactItem");
        AppMethodBeat.o(124293);
        throw paramVarArgs;
      }
      if (this.jKG != null) {
        paramVarArgs.e(1, this.jKG);
      }
      if (this.wBR != null)
      {
        paramVarArgs.iQ(2, this.wBR.computeSize());
        this.wBR.writeFields(paramVarArgs);
      }
      if (this.wBU != null)
      {
        paramVarArgs.iQ(3, this.wBU.computeSize());
        this.wBU.writeFields(paramVarArgs);
      }
      if (this.wBV != null)
      {
        paramVarArgs.iQ(4, this.wBV.computeSize());
        this.wBV.writeFields(paramVarArgs);
      }
      if (this.npR != null) {
        paramVarArgs.e(5, this.npR);
      }
      AppMethodBeat.o(124293);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jKG == null) {
        break label834;
      }
    }
    label834:
    for (int i = e.a.a.b.b.a.f(1, this.jKG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wBR != null) {
        paramInt = i + e.a.a.a.iP(2, this.wBR.computeSize());
      }
      i = paramInt;
      if (this.wBU != null) {
        i = paramInt + e.a.a.a.iP(3, this.wBU.computeSize());
      }
      paramInt = i;
      if (this.wBV != null) {
        paramInt = i + e.a.a.a.iP(4, this.wBV.computeSize());
      }
      i = paramInt;
      if (this.npR != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.npR);
      }
      AppMethodBeat.o(124293);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jKG == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(124293);
          throw paramVarArgs;
        }
        if (this.wBU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactItem");
          AppMethodBeat.o(124293);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124293);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        nb localnb = (nb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124293);
          return -1;
        case 1: 
          localnb.jKG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124293);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localnb.wBR = ((nd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124293);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bya();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bya)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localnb.wBU = ((bya)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124293);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localnb.wBV = ((nj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124293);
          return 0;
        }
        localnb.npR = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124293);
        return 0;
      }
      AppMethodBeat.o(124293);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nb
 * JD-Core Version:    0.7.0.1
 */