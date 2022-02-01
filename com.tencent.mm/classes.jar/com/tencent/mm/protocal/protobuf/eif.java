package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eif
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b FZb;
  public LinkedList<eic> FZc;
  public String Hhh;
  
  public eif()
  {
    AppMethodBeat.i(123701);
    this.FZc = new LinkedList();
    AppMethodBeat.o(123701);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123702);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hhh == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(123702);
        throw paramVarArgs;
      }
      if (this.Hhh != null) {
        paramVarArgs.d(1, this.Hhh);
      }
      if (this.FZb != null) {
        paramVarArgs.c(2, this.FZb);
      }
      paramVarArgs.e(3, 8, this.FZc);
      AppMethodBeat.o(123702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hhh == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hhh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FZb != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FZb);
      }
      paramInt = f.a.a.a.c(3, 8, this.FZc);
      AppMethodBeat.o(123702);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FZc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Hhh == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(123702);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123702);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eif localeif = (eif)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123702);
          return -1;
        case 1: 
          localeif.Hhh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123702);
          return 0;
        case 2: 
          localeif.FZb = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(123702);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eic();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eic)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeif.FZc.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123702);
        return 0;
      }
      AppMethodBeat.o(123702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eif
 * JD-Core Version:    0.7.0.1
 */