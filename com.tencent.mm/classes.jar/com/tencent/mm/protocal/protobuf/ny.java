package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ny
  extends com.tencent.mm.bx.a
{
  public aah FIT;
  public pf FIU;
  public nu FIV;
  public pk FIW;
  public pi FIX;
  public mo FIY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FIT != null)
      {
        paramVarArgs.lC(1, this.FIT.computeSize());
        this.FIT.writeFields(paramVarArgs);
      }
      if (this.FIU != null)
      {
        paramVarArgs.lC(2, this.FIU.computeSize());
        this.FIU.writeFields(paramVarArgs);
      }
      if (this.FIV != null)
      {
        paramVarArgs.lC(3, this.FIV.computeSize());
        this.FIV.writeFields(paramVarArgs);
      }
      if (this.FIW != null)
      {
        paramVarArgs.lC(4, this.FIW.computeSize());
        this.FIW.writeFields(paramVarArgs);
      }
      if (this.FIX != null)
      {
        paramVarArgs.lC(5, this.FIX.computeSize());
        this.FIX.writeFields(paramVarArgs);
      }
      if (this.FIY != null)
      {
        paramVarArgs.lC(6, this.FIY.computeSize());
        this.FIY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FIT == null) {
        break label1082;
      }
    }
    label1082:
    for (int i = f.a.a.a.lB(1, this.FIT.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FIU != null) {
        paramInt = i + f.a.a.a.lB(2, this.FIU.computeSize());
      }
      i = paramInt;
      if (this.FIV != null) {
        i = paramInt + f.a.a.a.lB(3, this.FIV.computeSize());
      }
      paramInt = i;
      if (this.FIW != null) {
        paramInt = i + f.a.a.a.lB(4, this.FIW.computeSize());
      }
      i = paramInt;
      if (this.FIX != null) {
        i = paramInt + f.a.a.a.lB(5, this.FIX.computeSize());
      }
      paramInt = i;
      if (this.FIY != null) {
        paramInt = i + f.a.a.a.lB(6, this.FIY.computeSize());
      }
      AppMethodBeat.o(124434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ny localny = (ny)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124434);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aah();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aah)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localny.FIT = ((aah)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localny.FIU = ((pf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localny.FIV = ((nu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localny.FIW = ((pk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localny.FIX = ((pi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localny.FIY = ((mo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      AppMethodBeat.o(124434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ny
 * JD-Core Version:    0.7.0.1
 */