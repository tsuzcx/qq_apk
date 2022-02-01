package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class pl
  extends com.tencent.mm.bw.a
{
  public pn EfM;
  public ctj EfP;
  public pu EfQ;
  public String ndW;
  public String thh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ndW == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.EfP == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactItem");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.ndW != null) {
        paramVarArgs.d(1, this.ndW);
      }
      if (this.EfM != null)
      {
        paramVarArgs.ln(2, this.EfM.computeSize());
        this.EfM.writeFields(paramVarArgs);
      }
      if (this.EfP != null)
      {
        paramVarArgs.ln(3, this.EfP.computeSize());
        this.EfP.writeFields(paramVarArgs);
      }
      if (this.EfQ != null)
      {
        paramVarArgs.ln(4, this.EfQ.computeSize());
        this.EfQ.writeFields(paramVarArgs);
      }
      if (this.thh != null) {
        paramVarArgs.d(5, this.thh);
      }
      AppMethodBeat.o(117841);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ndW == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.b.b.a.e(1, this.ndW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EfM != null) {
        paramInt = i + f.a.a.a.lm(2, this.EfM.computeSize());
      }
      i = paramInt;
      if (this.EfP != null) {
        i = paramInt + f.a.a.a.lm(3, this.EfP.computeSize());
      }
      paramInt = i;
      if (this.EfQ != null) {
        paramInt = i + f.a.a.a.lm(4, this.EfQ.computeSize());
      }
      i = paramInt;
      if (this.thh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.thh);
      }
      AppMethodBeat.o(117841);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ndW == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        if (this.EfP == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactItem");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117841);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pl localpl = (pl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117841);
          return -1;
        case 1: 
          localpl.ndW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117841);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpl.EfM = ((pn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpl.EfP = ((ctj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpl.EfQ = ((pu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        }
        localpl.thh = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117841);
        return 0;
      }
      AppMethodBeat.o(117841);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pl
 * JD-Core Version:    0.7.0.1
 */