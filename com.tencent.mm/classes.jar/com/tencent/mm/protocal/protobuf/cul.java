package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cul
  extends com.tencent.mm.bv.a
{
  public cuh ydl;
  public ctx ydm;
  public String ydn;
  public String ydo;
  public String ydp;
  public int ydq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102420);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ydl != null)
      {
        paramVarArgs.iQ(1, this.ydl.computeSize());
        this.ydl.writeFields(paramVarArgs);
      }
      if (this.ydm != null)
      {
        paramVarArgs.iQ(2, this.ydm.computeSize());
        this.ydm.writeFields(paramVarArgs);
      }
      if (this.ydn != null) {
        paramVarArgs.e(3, this.ydn);
      }
      if (this.ydo != null) {
        paramVarArgs.e(4, this.ydo);
      }
      if (this.ydp != null) {
        paramVarArgs.e(5, this.ydp);
      }
      paramVarArgs.aO(6, this.ydq);
      AppMethodBeat.o(102420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ydl == null) {
        break label690;
      }
    }
    label690:
    for (int i = e.a.a.a.iP(1, this.ydl.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ydm != null) {
        paramInt = i + e.a.a.a.iP(2, this.ydm.computeSize());
      }
      i = paramInt;
      if (this.ydn != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ydn);
      }
      paramInt = i;
      if (this.ydo != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ydo);
      }
      i = paramInt;
      if (this.ydp != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ydp);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.ydq);
      AppMethodBeat.o(102420);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(102420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cul localcul = (cul)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(102420);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cuh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cuh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcul.ydl = ((cuh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(102420);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcul.ydm = ((ctx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(102420);
          return 0;
        case 3: 
          localcul.ydn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(102420);
          return 0;
        case 4: 
          localcul.ydo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(102420);
          return 0;
        case 5: 
          localcul.ydp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(102420);
          return 0;
        }
        localcul.ydq = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(102420);
        return 0;
      }
      AppMethodBeat.o(102420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cul
 * JD-Core Version:    0.7.0.1
 */