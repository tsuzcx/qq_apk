package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class acu
  extends com.tencent.mm.bx.a
{
  public dks Ddt;
  public dks Ddu;
  public String md5;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140926);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.Ddt == null)
      {
        paramVarArgs = new b("Not all required fields were included: editorMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.Ddu == null)
      {
        paramVarArgs = new b("Not all required fields were included: showMatrix");
        AppMethodBeat.o(140926);
        throw paramVarArgs;
      }
      if (this.md5 != null) {
        paramVarArgs.d(1, this.md5);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.Ddt != null)
      {
        paramVarArgs.kX(3, this.Ddt.computeSize());
        this.Ddt.writeFields(paramVarArgs);
      }
      if (this.Ddu != null)
      {
        paramVarArgs.kX(4, this.Ddu.computeSize());
        this.Ddu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.md5 == null) {
        break label730;
      }
    }
    label730:
    for (int i = f.a.a.b.b.a.e(1, this.md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.Ddt != null) {
        i = paramInt + f.a.a.a.kW(3, this.Ddt.computeSize());
      }
      paramInt = i;
      if (this.Ddu != null) {
        paramInt = i + f.a.a.a.kW(4, this.Ddu.computeSize());
      }
      AppMethodBeat.o(140926);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.Ddt == null)
        {
          paramVarArgs = new b("Not all required fields were included: editorMatrix");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        if (this.Ddu == null)
        {
          paramVarArgs = new b("Not all required fields were included: showMatrix");
          AppMethodBeat.o(140926);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140926);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acu localacu = (acu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140926);
          return -1;
        case 1: 
          localacu.md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 2: 
          localacu.name = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(140926);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dks();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dks)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacu.Ddt = ((dks)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140926);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dks();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dks)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localacu.Ddu = ((dks)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(140926);
        return 0;
      }
      AppMethodBeat.o(140926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acu
 * JD-Core Version:    0.7.0.1
 */