package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cnu
  extends com.tencent.mm.bw.a
{
  public LinkedList<ayj> Mub;
  public int Muc;
  public int Mud;
  public int Mue;
  public LinkedList<FinderObject> Muf;
  public long Mug;
  public String key;
  public b lastBuffer;
  
  public cnu()
  {
    AppMethodBeat.i(209749);
    this.Mub = new LinkedList();
    this.Muf = new LinkedList();
    AppMethodBeat.o(209749);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209750);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      paramVarArgs.e(2, 8, this.Mub);
      paramVarArgs.aM(3, this.Muc);
      paramVarArgs.aM(4, this.Mud);
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      paramVarArgs.aM(6, this.Mue);
      paramVarArgs.e(7, 8, this.Muf);
      paramVarArgs.bb(8, this.Mug);
      AppMethodBeat.o(209750);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = g.a.a.b.b.a.f(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Mub) + g.a.a.b.b.a.bu(3, this.Muc) + g.a.a.b.b.a.bu(4, this.Mud);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.lastBuffer);
      }
      i = g.a.a.b.b.a.bu(6, this.Mue);
      int j = g.a.a.a.c(7, 8, this.Muf);
      int k = g.a.a.b.b.a.r(8, this.Mug);
      AppMethodBeat.o(209750);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mub.clear();
        this.Muf.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209750);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnu localcnu = (cnu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209750);
          return -1;
        case 1: 
          localcnu.key = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209750);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ayj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ayj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcnu.Mub.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209750);
          return 0;
        case 3: 
          localcnu.Muc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209750);
          return 0;
        case 4: 
          localcnu.Mud = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209750);
          return 0;
        case 5: 
          localcnu.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209750);
          return 0;
        case 6: 
          localcnu.Mue = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209750);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcnu.Muf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209750);
          return 0;
        }
        localcnu.Mug = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209750);
        return 0;
      }
      AppMethodBeat.o(209750);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnu
 * JD-Core Version:    0.7.0.1
 */