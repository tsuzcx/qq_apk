package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgc
  extends com.tencent.mm.bv.a
{
  public int scene;
  public cgb xQO;
  public cgb xQP;
  public cgb xQQ;
  public int xQR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96295);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xQO != null)
      {
        paramVarArgs.iQ(1, this.xQO.computeSize());
        this.xQO.writeFields(paramVarArgs);
      }
      if (this.xQP != null)
      {
        paramVarArgs.iQ(2, this.xQP.computeSize());
        this.xQP.writeFields(paramVarArgs);
      }
      if (this.xQQ != null)
      {
        paramVarArgs.iQ(3, this.xQQ.computeSize());
        this.xQQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.scene);
      paramVarArgs.aO(5, this.xQR);
      AppMethodBeat.o(96295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xQO == null) {
        break label710;
      }
    }
    label710:
    for (int i = e.a.a.a.iP(1, this.xQO.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xQP != null) {
        paramInt = i + e.a.a.a.iP(2, this.xQP.computeSize());
      }
      i = paramInt;
      if (this.xQQ != null) {
        i = paramInt + e.a.a.a.iP(3, this.xQQ.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(4, this.scene);
      int j = e.a.a.b.b.a.bl(5, this.xQR);
      AppMethodBeat.o(96295);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96295);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cgc localcgc = (cgc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96295);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcgc.xQO = ((cgb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96295);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcgc.xQP = ((cgb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96295);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcgc.xQQ = ((cgb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96295);
          return 0;
        case 4: 
          localcgc.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96295);
          return 0;
        }
        localcgc.xQR = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(96295);
        return 0;
      }
      AppMethodBeat.o(96295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgc
 * JD-Core Version:    0.7.0.1
 */