package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fbg
  extends com.tencent.mm.bw.a
{
  public String Md5;
  public int NxA;
  public int NxB;
  public fbj NxC;
  public String xuc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110857);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.xuc == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.e(1, this.Md5);
      }
      if (this.xuc != null) {
        paramVarArgs.e(2, this.xuc);
      }
      paramVarArgs.aM(3, this.NxA);
      paramVarArgs.aM(4, this.NxB);
      if (this.NxC != null)
      {
        paramVarArgs.ni(5, this.NxC.computeSize());
        this.NxC.writeFields(paramVarArgs);
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
    for (paramInt = g.a.a.b.b.a.f(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xuc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xuc);
      }
      i = i + g.a.a.b.b.a.bu(3, this.NxA) + g.a.a.b.b.a.bu(4, this.NxB);
      paramInt = i;
      if (this.NxC != null) {
        paramInt = i + g.a.a.a.nh(5, this.NxC.computeSize());
      }
      AppMethodBeat.o(110857);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        if (this.xuc == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fbg localfbg = (fbg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110857);
          return -1;
        case 1: 
          localfbg.Md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 2: 
          localfbg.xuc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 3: 
          localfbg.NxA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(110857);
          return 0;
        case 4: 
          localfbg.NxB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(110857);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fbj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((fbj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfbg.NxC = ((fbj)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbg
 * JD-Core Version:    0.7.0.1
 */