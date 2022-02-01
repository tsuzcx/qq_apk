package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class chz
  extends com.tencent.mm.bw.a
{
  public dww GhB;
  public String text;
  public String yeY;
  public agg yfj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200141);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yeY == null)
      {
        paramVarArgs = new b("Not all required fields were included: pagPath");
        AppMethodBeat.o(200141);
        throw paramVarArgs;
      }
      if (this.GhB == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(200141);
        throw paramVarArgs;
      }
      if (this.yeY != null) {
        paramVarArgs.d(1, this.yeY);
      }
      if (this.text != null) {
        paramVarArgs.d(2, this.text);
      }
      if (this.GhB != null)
      {
        paramVarArgs.lJ(3, this.GhB.computeSize());
        this.GhB.writeFields(paramVarArgs);
      }
      if (this.yfj != null)
      {
        paramVarArgs.lJ(4, this.yfj.computeSize());
        this.yfj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200141);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yeY == null) {
        break label682;
      }
    }
    label682:
    for (int i = f.a.a.b.b.a.e(1, this.yeY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.text);
      }
      i = paramInt;
      if (this.GhB != null) {
        i = paramInt + f.a.a.a.lI(3, this.GhB.computeSize());
      }
      paramInt = i;
      if (this.yfj != null) {
        paramInt = i + f.a.a.a.lI(4, this.yfj.computeSize());
      }
      AppMethodBeat.o(200141);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.yeY == null)
        {
          paramVarArgs = new b("Not all required fields were included: pagPath");
          AppMethodBeat.o(200141);
          throw paramVarArgs;
        }
        if (this.GhB == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(200141);
          throw paramVarArgs;
        }
        AppMethodBeat.o(200141);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chz localchz = (chz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200141);
          return -1;
        case 1: 
          localchz.yeY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(200141);
          return 0;
        case 2: 
          localchz.text = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(200141);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dww();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchz.GhB = ((dww)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200141);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((agg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localchz.yfj = ((agg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200141);
        return 0;
      }
      AppMethodBeat.o(200141);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chz
 * JD-Core Version:    0.7.0.1
 */