package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ang
  extends com.tencent.mm.bw.a
{
  public int GFk;
  public LinkedList<ars> GFl;
  public int continueFlag;
  public String dyb;
  public int offset;
  public String query;
  public LinkedList<FinderObject> rBY;
  public b skw;
  
  public ang()
  {
    AppMethodBeat.i(168958);
    this.rBY = new LinkedList();
    this.GFl = new LinkedList();
    AppMethodBeat.o(168958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.query != null) {
        paramVarArgs.d(1, this.query);
      }
      paramVarArgs.aS(2, this.offset);
      paramVarArgs.aS(3, this.continueFlag);
      paramVarArgs.e(4, 8, this.rBY);
      if (this.skw != null) {
        paramVarArgs.c(5, this.skw);
      }
      paramVarArgs.aS(6, this.GFk);
      if (this.dyb != null) {
        paramVarArgs.d(7, this.dyb);
      }
      paramVarArgs.e(8, 8, this.GFl);
      AppMethodBeat.o(168959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.query == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = f.a.a.b.b.a.e(1, this.query) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.offset) + f.a.a.b.b.a.bz(3, this.continueFlag) + f.a.a.a.c(4, 8, this.rBY);
      paramInt = i;
      if (this.skw != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.skw);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GFk);
      paramInt = i;
      if (this.dyb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dyb);
      }
      i = f.a.a.a.c(8, 8, this.GFl);
      AppMethodBeat.o(168959);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rBY.clear();
        this.GFl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ang localang = (ang)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168959);
          return -1;
        case 1: 
          localang.query = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168959);
          return 0;
        case 2: 
          localang.offset = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168959);
          return 0;
        case 3: 
          localang.continueFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168959);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localang.rBY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168959);
          return 0;
        case 5: 
          localang.skw = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168959);
          return 0;
        case 6: 
          localang.GFk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168959);
          return 0;
        case 7: 
          localang.dyb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168959);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ars();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ars)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localang.GFl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168959);
        return 0;
      }
      AppMethodBeat.o(168959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ang
 * JD-Core Version:    0.7.0.1
 */