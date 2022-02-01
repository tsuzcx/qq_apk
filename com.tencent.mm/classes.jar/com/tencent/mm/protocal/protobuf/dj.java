package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dj
  extends com.tencent.mm.bx.a
{
  public gg Cyd;
  public LinkedList<beq> GroupList;
  public String sbA;
  
  public dj()
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
      if (this.Cyd == null)
      {
        paramVarArgs = new b("Not all required fields were included: ArtisAuthor");
        AppMethodBeat.o(125707);
        throw paramVarArgs;
      }
      if (this.Cyd != null)
      {
        paramVarArgs.kX(1, this.Cyd.computeSize());
        this.Cyd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GroupList);
      if (this.sbA != null) {
        paramVarArgs.d(3, this.sbA);
      }
      AppMethodBeat.o(125707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cyd == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = f.a.a.a.kW(1, this.Cyd.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GroupList);
      paramInt = i;
      if (this.sbA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.sbA);
      }
      AppMethodBeat.o(125707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GroupList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Cyd == null)
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
        dj localdj = (dj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125707);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdj.Cyd = ((gg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125707);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new beq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((beq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdj.GroupList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125707);
          return 0;
        }
        localdj.sbA = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125707);
        return 0;
      }
      AppMethodBeat.o(125707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dj
 * JD-Core Version:    0.7.0.1
 */