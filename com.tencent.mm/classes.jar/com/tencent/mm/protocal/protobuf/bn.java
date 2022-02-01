package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bn
  extends com.tencent.mm.bw.a
{
  public eih KFh;
  public String KFi = "";
  public String KFj = "";
  public String KFk = "";
  public long KFl = 0L;
  public int KFm = 0;
  public int flags = -1;
  public int state = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122482);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KFh != null)
      {
        paramVarArgs.ni(1, this.KFh.computeSize());
        this.KFh.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.flags);
      paramVarArgs.aM(3, this.state);
      if (this.KFi != null) {
        paramVarArgs.e(4, this.KFi);
      }
      if (this.KFj != null) {
        paramVarArgs.e(5, this.KFj);
      }
      if (this.KFk != null) {
        paramVarArgs.e(6, this.KFk);
      }
      paramVarArgs.bb(7, this.KFl);
      paramVarArgs.aM(8, this.KFm);
      AppMethodBeat.o(122482);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KFh == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = g.a.a.a.nh(1, this.KFh.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.flags) + g.a.a.b.b.a.bu(3, this.state);
      paramInt = i;
      if (this.KFi != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KFi);
      }
      i = paramInt;
      if (this.KFj != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KFj);
      }
      paramInt = i;
      if (this.KFk != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KFk);
      }
      i = g.a.a.b.b.a.r(7, this.KFl);
      int j = g.a.a.b.b.a.bu(8, this.KFm);
      AppMethodBeat.o(122482);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122482);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bn localbn = (bn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122482);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eih();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eih)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbn.KFh = ((eih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122482);
          return 0;
        case 2: 
          localbn.flags = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122482);
          return 0;
        case 3: 
          localbn.state = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122482);
          return 0;
        case 4: 
          localbn.KFi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 5: 
          localbn.KFj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 6: 
          localbn.KFk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 7: 
          localbn.KFl = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122482);
          return 0;
        }
        localbn.KFm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122482);
        return 0;
      }
      AppMethodBeat.o(122482);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bn
 * JD-Core Version:    0.7.0.1
 */