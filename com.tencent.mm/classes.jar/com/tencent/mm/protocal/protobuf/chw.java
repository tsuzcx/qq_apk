package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chw
  extends com.tencent.mm.bw.a
{
  public ctg Mno;
  public LinkedList<chv> Mnp;
  public cht Mnq;
  
  public chw()
  {
    AppMethodBeat.i(200212);
    this.Mnp = new LinkedList();
    AppMethodBeat.o(200212);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200213);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mno != null)
      {
        paramVarArgs.ni(1, this.Mno.computeSize());
        this.Mno.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Mnp);
      if (this.Mnq != null)
      {
        paramVarArgs.ni(3, this.Mnq.computeSize());
        this.Mnq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200213);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mno == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = g.a.a.a.nh(1, this.Mno.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Mnp);
      paramInt = i;
      if (this.Mnq != null) {
        paramInt = i + g.a.a.a.nh(3, this.Mnq.computeSize());
      }
      AppMethodBeat.o(200213);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mnp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200213);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        chw localchw = (chw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200213);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchw.Mno = ((ctg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200213);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchw.Mnp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200213);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cht();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cht)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localchw.Mnq = ((cht)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(200213);
        return 0;
      }
      AppMethodBeat.o(200213);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chw
 * JD-Core Version:    0.7.0.1
 */