package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eez
  extends com.tencent.mm.bx.a
{
  public int HQs;
  public int HQt;
  public efc HQu;
  public String Md5;
  public String tRU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110857);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.tRU == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.tRU != null) {
        paramVarArgs.d(2, this.tRU);
      }
      paramVarArgs.aS(3, this.HQs);
      paramVarArgs.aS(4, this.HQt);
      if (this.HQu != null)
      {
        paramVarArgs.lC(5, this.HQu.computeSize());
        this.HQu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.b.b.a.e(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tRU != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.tRU);
      }
      i = i + f.a.a.b.b.a.bz(3, this.HQs) + f.a.a.b.b.a.bz(4, this.HQt);
      paramInt = i;
      if (this.HQu != null) {
        paramInt = i + f.a.a.a.lB(5, this.HQu.computeSize());
      }
      AppMethodBeat.o(110857);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        if (this.tRU == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadUrl");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110857);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eez localeez = (eez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110857);
          return -1;
        case 1: 
          localeez.Md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 2: 
          localeez.tRU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 3: 
          localeez.HQs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(110857);
          return 0;
        case 4: 
          localeez.HQt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(110857);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new efc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((efc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeez.HQu = ((efc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110857);
        return 0;
      }
      AppMethodBeat.o(110857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eez
 * JD-Core Version:    0.7.0.1
 */