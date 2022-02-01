package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkt
  extends com.tencent.mm.bw.a
{
  public LinkedList<bkv> Far;
  public int major;
  public String uuid;
  
  public bkt()
  {
    AppMethodBeat.i(82427);
    this.Far = new LinkedList();
    AppMethodBeat.o(82427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.d(1, this.uuid);
      }
      paramVarArgs.aR(2, this.major);
      paramVarArgs.e(3, 8, this.Far);
      AppMethodBeat.o(82428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.b.b.a.e(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.major);
      int j = f.a.a.a.c(3, 8, this.Far);
      AppMethodBeat.o(82428);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Far.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkt localbkt = (bkt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82428);
          return -1;
        case 1: 
          localbkt.uuid = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82428);
          return 0;
        case 2: 
          localbkt.major = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82428);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bkv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbkt.Far.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82428);
        return 0;
      }
      AppMethodBeat.o(82428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkt
 * JD-Core Version:    0.7.0.1
 */