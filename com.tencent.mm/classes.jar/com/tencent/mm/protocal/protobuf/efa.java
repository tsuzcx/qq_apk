package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class efa
  extends com.tencent.mm.bx.a
{
  public String GkU;
  public String GkW;
  public eez HQl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110858);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GkU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.GkW == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.HQl == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.GkU != null) {
        paramVarArgs.d(1, this.GkU);
      }
      if (this.GkW != null) {
        paramVarArgs.d(2, this.GkW);
      }
      if (this.HQl != null)
      {
        paramVarArgs.lC(3, this.HQl.computeSize());
        this.HQl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GkU == null) {
        break label574;
      }
    }
    label574:
    for (int i = f.a.a.b.b.a.e(1, this.GkU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GkW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GkW);
      }
      i = paramInt;
      if (this.HQl != null) {
        i = paramInt + f.a.a.a.lB(3, this.HQl.computeSize());
      }
      AppMethodBeat.o(110858);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GkU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.GkW == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.HQl == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        efa localefa = (efa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110858);
          return -1;
        case 1: 
          localefa.GkU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110858);
          return 0;
        case 2: 
          localefa.GkW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(110858);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eez();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eez)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localefa.HQl = ((eez)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110858);
        return 0;
      }
      AppMethodBeat.o(110858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efa
 * JD-Core Version:    0.7.0.1
 */