package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awn
  extends com.tencent.mm.bv.a
{
  public String xlY;
  public String xlZ;
  public yd xma;
  public yd xmb;
  public String xmc;
  public String xmd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48876);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlY != null) {
        paramVarArgs.e(1, this.xlY);
      }
      if (this.xlZ != null) {
        paramVarArgs.e(2, this.xlZ);
      }
      if (this.xma != null)
      {
        paramVarArgs.iQ(3, this.xma.computeSize());
        this.xma.writeFields(paramVarArgs);
      }
      if (this.xmb != null)
      {
        paramVarArgs.iQ(4, this.xmb.computeSize());
        this.xmb.writeFields(paramVarArgs);
      }
      if (this.xmc != null) {
        paramVarArgs.e(5, this.xmc);
      }
      if (this.xmd != null) {
        paramVarArgs.e(6, this.xmd);
      }
      AppMethodBeat.o(48876);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlY == null) {
        break label706;
      }
    }
    label706:
    for (int i = e.a.a.b.b.a.f(1, this.xlY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xlZ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xlZ);
      }
      i = paramInt;
      if (this.xma != null) {
        i = paramInt + e.a.a.a.iP(3, this.xma.computeSize());
      }
      paramInt = i;
      if (this.xmb != null) {
        paramInt = i + e.a.a.a.iP(4, this.xmb.computeSize());
      }
      i = paramInt;
      if (this.xmc != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xmc);
      }
      paramInt = i;
      if (this.xmd != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xmd);
      }
      AppMethodBeat.o(48876);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48876);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        awn localawn = (awn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48876);
          return -1;
        case 1: 
          localawn.xlY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48876);
          return 0;
        case 2: 
          localawn.xlZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48876);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localawn.xma = ((yd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48876);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localawn.xmb = ((yd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48876);
          return 0;
        case 5: 
          localawn.xmc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48876);
          return 0;
        }
        localawn.xmd = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48876);
        return 0;
      }
      AppMethodBeat.o(48876);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awn
 * JD-Core Version:    0.7.0.1
 */