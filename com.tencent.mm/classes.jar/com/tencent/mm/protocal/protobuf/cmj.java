package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmj
  extends com.tencent.mm.bx.a
{
  public LinkedList<bmu> Ehr;
  public boolean Ehs;
  public boolean Eht;
  public boolean Ehu;
  public boolean Ehv;
  public boolean Ehw;
  
  public cmj()
  {
    AppMethodBeat.i(155454);
    this.Ehr = new LinkedList();
    AppMethodBeat.o(155454);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Ehr);
      paramVarArgs.bg(2, this.Ehs);
      paramVarArgs.bg(3, this.Eht);
      paramVarArgs.bg(4, this.Ehu);
      paramVarArgs.bg(5, this.Ehv);
      paramVarArgs.bg(6, this.Ehw);
      AppMethodBeat.o(155455);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.Ehr);
      i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.b.b.a.fY(5);
      int n = f.a.a.b.b.a.fY(6);
      AppMethodBeat.o(155455);
      return paramInt + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ehr.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(155455);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cmj localcmj = (cmj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155455);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bmu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmj.Ehr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155455);
        return 0;
      case 2: 
        localcmj.Ehs = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(155455);
        return 0;
      case 3: 
        localcmj.Eht = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(155455);
        return 0;
      case 4: 
        localcmj.Ehu = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(155455);
        return 0;
      case 5: 
        localcmj.Ehv = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(155455);
        return 0;
      }
      localcmj.Ehw = ((f.a.a.a.a)localObject1).KhF.fHu();
      AppMethodBeat.o(155455);
      return 0;
    }
    AppMethodBeat.o(155455);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmj
 * JD-Core Version:    0.7.0.1
 */