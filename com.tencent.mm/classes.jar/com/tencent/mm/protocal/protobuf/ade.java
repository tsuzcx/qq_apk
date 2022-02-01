package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ade
  extends com.tencent.mm.bx.a
{
  public String Md5;
  public int mAK;
  public LinkedList<bks> mAL;
  
  public ade()
  {
    AppMethodBeat.i(104773);
    this.mAL = new LinkedList();
    AppMethodBeat.o(104773);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104774);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      paramVarArgs.aR(2, this.mAK);
      paramVarArgs.e(3, 8, this.mAL);
      AppMethodBeat.o(104774);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.b.b.a.e(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.mAK);
      int j = f.a.a.a.c(3, 8, this.mAL);
      AppMethodBeat.o(104774);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mAL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104774);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ade localade = (ade)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104774);
          return -1;
        case 1: 
          localade.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104774);
          return 0;
        case 2: 
          localade.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104774);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bks();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bks)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localade.mAL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104774);
        return 0;
      }
      AppMethodBeat.o(104774);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ade
 * JD-Core Version:    0.7.0.1
 */