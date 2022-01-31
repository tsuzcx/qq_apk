package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class db
  extends com.tencent.mm.bv.a
{
  public LinkedList<atp> GroupList;
  public String nsa;
  public fo wpx;
  
  public db()
  {
    AppMethodBeat.i(94504);
    this.GroupList = new LinkedList();
    AppMethodBeat.o(94504);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94505);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wpx == null)
      {
        paramVarArgs = new b("Not all required fields were included: ArtisAuthor");
        AppMethodBeat.o(94505);
        throw paramVarArgs;
      }
      if (this.wpx != null)
      {
        paramVarArgs.iQ(1, this.wpx.computeSize());
        this.wpx.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GroupList);
      if (this.nsa != null) {
        paramVarArgs.e(3, this.nsa);
      }
      AppMethodBeat.o(94505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wpx == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = e.a.a.a.iP(1, this.wpx.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.GroupList);
      paramInt = i;
      if (this.nsa != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nsa);
      }
      AppMethodBeat.o(94505);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GroupList.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wpx == null)
        {
          paramVarArgs = new b("Not all required fields were included: ArtisAuthor");
          AppMethodBeat.o(94505);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        db localdb = (db)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94505);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fo();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdb.wpx = ((fo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94505);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdb.GroupList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94505);
          return 0;
        }
        localdb.nsa = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94505);
        return 0;
      }
      AppMethodBeat.o(94505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.db
 * JD-Core Version:    0.7.0.1
 */