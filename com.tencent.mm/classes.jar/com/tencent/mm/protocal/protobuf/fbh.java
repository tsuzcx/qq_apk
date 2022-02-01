package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fbh
  extends com.tencent.mm.bw.a
{
  public String LzG;
  public String LzI;
  public fbg Nxt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110858);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LzG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.LzI == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.Nxt == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.LzG != null) {
        paramVarArgs.e(1, this.LzG);
      }
      if (this.LzI != null) {
        paramVarArgs.e(2, this.LzI);
      }
      if (this.Nxt != null)
      {
        paramVarArgs.ni(3, this.Nxt.computeSize());
        this.Nxt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LzG == null) {
        break label574;
      }
    }
    label574:
    for (int i = g.a.a.b.b.a.f(1, this.LzG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LzI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LzI);
      }
      i = paramInt;
      if (this.Nxt != null) {
        i = paramInt + g.a.a.a.nh(3, this.Nxt.computeSize());
      }
      AppMethodBeat.o(110858);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LzG == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.LzI == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.Nxt == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fbh localfbh = (fbh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110858);
          return -1;
        case 1: 
          localfbh.LzG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110858);
          return 0;
        case 2: 
          localfbh.LzI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110858);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fbg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((fbg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfbh.Nxt = ((fbg)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbh
 * JD-Core Version:    0.7.0.1
 */