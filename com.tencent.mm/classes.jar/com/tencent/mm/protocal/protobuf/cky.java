package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cky
  extends com.tencent.mm.bw.a
{
  public dnl FLn;
  public dnl FLo;
  public LinkedList<tl> GIN;
  public bqg Hxn;
  public ccy Hxo;
  
  public cky()
  {
    AppMethodBeat.i(91613);
    this.GIN = new LinkedList();
    AppMethodBeat.o(91613);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91614);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hxn != null)
      {
        paramVarArgs.lJ(1, this.Hxn.computeSize());
        this.Hxn.writeFields(paramVarArgs);
      }
      if (this.FLn != null)
      {
        paramVarArgs.lJ(2, this.FLn.computeSize());
        this.FLn.writeFields(paramVarArgs);
      }
      if (this.FLo != null)
      {
        paramVarArgs.lJ(3, this.FLo.computeSize());
        this.FLo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.GIN);
      if (this.Hxo != null)
      {
        paramVarArgs.lJ(5, this.Hxo.computeSize());
        this.Hxo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91614);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hxn == null) {
        break label914;
      }
    }
    label914:
    for (int i = f.a.a.a.lI(1, this.Hxn.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FLn != null) {
        paramInt = i + f.a.a.a.lI(2, this.FLn.computeSize());
      }
      i = paramInt;
      if (this.FLo != null) {
        i = paramInt + f.a.a.a.lI(3, this.FLo.computeSize());
      }
      i += f.a.a.a.c(4, 8, this.GIN);
      paramInt = i;
      if (this.Hxo != null) {
        paramInt = i + f.a.a.a.lI(5, this.Hxo.computeSize());
      }
      AppMethodBeat.o(91614);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GIN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cky localcky = (cky)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91614);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcky.Hxn = ((bqg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcky.FLn = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcky.FLo = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcky.GIN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcky.Hxo = ((ccy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      AppMethodBeat.o(91614);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cky
 * JD-Core Version:    0.7.0.1
 */