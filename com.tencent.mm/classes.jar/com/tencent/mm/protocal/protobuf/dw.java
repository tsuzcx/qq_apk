package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dw
  extends com.tencent.mm.bw.a
{
  public LinkedList<bzz> GroupList;
  public he KHT;
  public String xLl;
  
  public dw()
  {
    AppMethodBeat.i(125706);
    this.GroupList = new LinkedList();
    AppMethodBeat.o(125706);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125707);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ArtisAuthor");
        AppMethodBeat.o(125707);
        throw paramVarArgs;
      }
      if (this.KHT != null)
      {
        paramVarArgs.ni(1, this.KHT.computeSize());
        this.KHT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GroupList);
      if (this.xLl != null) {
        paramVarArgs.e(3, this.xLl);
      }
      AppMethodBeat.o(125707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KHT == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = g.a.a.a.nh(1, this.KHT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.GroupList);
      paramInt = i;
      if (this.xLl != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xLl);
      }
      AppMethodBeat.o(125707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GroupList.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KHT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ArtisAuthor");
          AppMethodBeat.o(125707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dw localdw = (dw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125707);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new he();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((he)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdw.KHT = ((he)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125707);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdw.GroupList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125707);
          return 0;
        }
        localdw.xLl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125707);
        return 0;
      }
      AppMethodBeat.o(125707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dw
 * JD-Core Version:    0.7.0.1
 */