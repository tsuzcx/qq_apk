package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class awj
  extends com.tencent.mm.bw.a
{
  public b LDs;
  public int LHd;
  public LinkedList<awi> LHe;
  public long hFK;
  public long liveId;
  public String objectNonceId;
  public int tUC;
  
  public awj()
  {
    AppMethodBeat.i(209530);
    this.LHe = new LinkedList();
    AppMethodBeat.o(209530);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209531);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LHd);
      paramVarArgs.e(2, 8, this.LHe);
      paramVarArgs.bb(3, this.liveId);
      paramVarArgs.bb(4, this.hFK);
      if (this.objectNonceId != null) {
        paramVarArgs.e(5, this.objectNonceId);
      }
      paramVarArgs.aM(7, this.tUC);
      if (this.LDs != null) {
        paramVarArgs.c(8, this.LDs);
      }
      AppMethodBeat.o(209531);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LHd) + 0 + g.a.a.a.c(2, 8, this.LHe) + g.a.a.b.b.a.r(3, this.liveId) + g.a.a.b.b.a.r(4, this.hFK);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.objectNonceId);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.tUC);
      paramInt = i;
      if (this.LDs != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.LDs);
      }
      AppMethodBeat.o(209531);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LHe.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209531);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      awj localawj = (awj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 6: 
      default: 
        AppMethodBeat.o(209531);
        return -1;
      case 1: 
        localawj.LHd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209531);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((awi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localawj.LHe.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209531);
        return 0;
      case 3: 
        localawj.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209531);
        return 0;
      case 4: 
        localawj.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209531);
        return 0;
      case 5: 
        localawj.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209531);
        return 0;
      case 7: 
        localawj.tUC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209531);
        return 0;
      }
      localawj.LDs = ((g.a.a.a.a)localObject1).UbS.hPo();
      AppMethodBeat.o(209531);
      return 0;
    }
    AppMethodBeat.o(209531);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awj
 * JD-Core Version:    0.7.0.1
 */