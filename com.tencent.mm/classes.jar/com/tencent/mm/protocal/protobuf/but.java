package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class but
  extends buy
{
  public int Scene;
  public bwc xIA;
  public int xIx;
  public LinkedList<bwc> xIy;
  public bwc xIz;
  
  public but()
  {
    AppMethodBeat.i(116804);
    this.xIy = new LinkedList();
    AppMethodBeat.o(116804);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116805);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xIx);
      paramVarArgs.e(3, 8, this.xIy);
      if (this.xIz != null)
      {
        paramVarArgs.iQ(4, this.xIz.computeSize());
        this.xIz.writeFields(paramVarArgs);
      }
      if (this.xIA != null)
      {
        paramVarArgs.iQ(5, this.xIA.computeSize());
        this.xIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.Scene);
      AppMethodBeat.o(116805);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xIx) + e.a.a.a.c(3, 8, this.xIy);
      paramInt = i;
      if (this.xIz != null) {
        paramInt = i + e.a.a.a.iP(4, this.xIz.computeSize());
      }
      i = paramInt;
      if (this.xIA != null) {
        i = paramInt + e.a.a.a.iP(5, this.xIA.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(6, this.Scene);
      AppMethodBeat.o(116805);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xIy.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(116805);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        but localbut = (but)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116805);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbut.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116805);
          return 0;
        case 2: 
          localbut.xIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116805);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbut.xIy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116805);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbut.xIz = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116805);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbut.xIA = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116805);
          return 0;
        }
        localbut.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116805);
        return 0;
      }
      AppMethodBeat.o(116805);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.but
 * JD-Core Version:    0.7.0.1
 */