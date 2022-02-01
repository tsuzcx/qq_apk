package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dih
  extends com.tencent.mm.bx.a
{
  public dii Hxa;
  public dig Hxb;
  public dif Hxc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125844);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hxa != null)
      {
        paramVarArgs.lC(1, this.Hxa.computeSize());
        this.Hxa.writeFields(paramVarArgs);
      }
      if (this.Hxb != null)
      {
        paramVarArgs.lC(2, this.Hxb.computeSize());
        this.Hxb.writeFields(paramVarArgs);
      }
      if (this.Hxc != null)
      {
        paramVarArgs.lC(3, this.Hxc.computeSize());
        this.Hxc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hxa == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lB(1, this.Hxa.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hxb != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hxb.computeSize());
      }
      i = paramInt;
      if (this.Hxc != null) {
        i = paramInt + f.a.a.a.lB(3, this.Hxc.computeSize());
      }
      AppMethodBeat.o(125844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dih localdih = (dih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125844);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dii();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dii)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdih.Hxa = ((dii)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dig();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dig)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdih.Hxb = ((dig)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dif();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dif)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdih.Hxc = ((dif)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      AppMethodBeat.o(125844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dih
 * JD-Core Version:    0.7.0.1
 */