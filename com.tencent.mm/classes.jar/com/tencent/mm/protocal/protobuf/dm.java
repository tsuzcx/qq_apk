package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dm
  extends com.tencent.mm.bw.a
{
  public gr FOm;
  public LinkedList<bni> GroupList;
  public String usS;
  
  public dm()
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FOm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ArtisAuthor");
        AppMethodBeat.o(125707);
        throw paramVarArgs;
      }
      if (this.FOm != null)
      {
        paramVarArgs.lJ(1, this.FOm.computeSize());
        this.FOm.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GroupList);
      if (this.usS != null) {
        paramVarArgs.d(3, this.usS);
      }
      AppMethodBeat.o(125707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FOm == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = f.a.a.a.lI(1, this.FOm.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GroupList);
      paramInt = i;
      if (this.usS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.usS);
      }
      AppMethodBeat.o(125707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GroupList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FOm == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dm localdm = (dm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125707);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdm.FOm = ((gr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125707);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bni();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bni)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdm.GroupList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125707);
          return 0;
        }
        localdm.usS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125707);
        return 0;
      }
      AppMethodBeat.o(125707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dm
 * JD-Core Version:    0.7.0.1
 */