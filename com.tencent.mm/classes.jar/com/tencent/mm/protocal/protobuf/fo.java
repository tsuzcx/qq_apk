package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class fo
  extends com.tencent.mm.bv.a
{
  public String Name;
  public String Title;
  public String woO;
  public String wrD;
  public fp wrE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94510);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wrE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ArtisIcon");
        AppMethodBeat.o(94510);
        throw paramVarArgs;
      }
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.wrD != null) {
        paramVarArgs.e(3, this.wrD);
      }
      if (this.woO != null) {
        paramVarArgs.e(4, this.woO);
      }
      if (this.wrE != null)
      {
        paramVarArgs.iQ(5, this.wrE.computeSize());
        this.wrE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label598;
      }
    }
    label598:
    for (int i = e.a.a.b.b.a.f(1, this.Name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.wrD != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wrD);
      }
      paramInt = i;
      if (this.woO != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.woO);
      }
      i = paramInt;
      if (this.wrE != null) {
        i = paramInt + e.a.a.a.iP(5, this.wrE.computeSize());
      }
      AppMethodBeat.o(94510);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wrE == null)
        {
          paramVarArgs = new b("Not all required fields were included: ArtisIcon");
          AppMethodBeat.o(94510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        fo localfo = (fo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94510);
          return -1;
        case 1: 
          localfo.Name = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94510);
          return 0;
        case 2: 
          localfo.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94510);
          return 0;
        case 3: 
          localfo.wrD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94510);
          return 0;
        case 4: 
          localfo.woO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94510);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fp();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((fp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localfo.wrE = ((fp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94510);
        return 0;
      }
      AppMethodBeat.o(94510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fo
 * JD-Core Version:    0.7.0.1
 */