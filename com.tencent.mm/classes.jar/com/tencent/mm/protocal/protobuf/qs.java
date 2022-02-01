package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qs
  extends com.tencent.mm.bw.a
{
  public qu GeK;
  public czn GeN;
  public rb GeO;
  public String nJO;
  public String uqf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nJO == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.GeN == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactItem");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.nJO != null) {
        paramVarArgs.d(1, this.nJO);
      }
      if (this.GeK != null)
      {
        paramVarArgs.lJ(2, this.GeK.computeSize());
        this.GeK.writeFields(paramVarArgs);
      }
      if (this.GeN != null)
      {
        paramVarArgs.lJ(3, this.GeN.computeSize());
        this.GeN.writeFields(paramVarArgs);
      }
      if (this.GeO != null)
      {
        paramVarArgs.lJ(4, this.GeO.computeSize());
        this.GeO.writeFields(paramVarArgs);
      }
      if (this.uqf != null) {
        paramVarArgs.d(5, this.uqf);
      }
      AppMethodBeat.o(117841);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nJO == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.b.b.a.e(1, this.nJO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GeK != null) {
        paramInt = i + f.a.a.a.lI(2, this.GeK.computeSize());
      }
      i = paramInt;
      if (this.GeN != null) {
        i = paramInt + f.a.a.a.lI(3, this.GeN.computeSize());
      }
      paramInt = i;
      if (this.GeO != null) {
        paramInt = i + f.a.a.a.lI(4, this.GeO.computeSize());
      }
      i = paramInt;
      if (this.uqf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uqf);
      }
      AppMethodBeat.o(117841);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.nJO == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        if (this.GeN == null)
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
        qs localqs = (qs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117841);
          return -1;
        case 1: 
          localqs.nJO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117841);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqs.GeK = ((qu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqs.GeN = ((czn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqs.GeO = ((rb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        }
        localqs.uqf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117841);
        return 0;
      }
      AppMethodBeat.o(117841);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qs
 * JD-Core Version:    0.7.0.1
 */