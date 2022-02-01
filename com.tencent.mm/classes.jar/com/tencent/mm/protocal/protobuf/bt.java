package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bt
  extends com.tencent.mm.bx.a
{
  public fns YDs;
  public String YDt = "";
  public String YDu = "";
  public String YDv = "";
  public long YDw = 0L;
  public int YDx = 0;
  public int flags = -1;
  public int state = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122482);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YDs != null)
      {
        paramVarArgs.qD(1, this.YDs.computeSize());
        this.YDs.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.flags);
      paramVarArgs.bS(3, this.state);
      if (this.YDt != null) {
        paramVarArgs.g(4, this.YDt);
      }
      if (this.YDu != null) {
        paramVarArgs.g(5, this.YDu);
      }
      if (this.YDv != null) {
        paramVarArgs.g(6, this.YDv);
      }
      paramVarArgs.bv(7, this.YDw);
      paramVarArgs.bS(8, this.YDx);
      AppMethodBeat.o(122482);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YDs == null) {
        break label648;
      }
    }
    label648:
    for (paramInt = i.a.a.a.qC(1, this.YDs.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.flags) + i.a.a.b.b.a.cJ(3, this.state);
      paramInt = i;
      if (this.YDt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YDt);
      }
      i = paramInt;
      if (this.YDu != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YDu);
      }
      paramInt = i;
      if (this.YDv != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YDv);
      }
      i = i.a.a.b.b.a.q(7, this.YDw);
      int j = i.a.a.b.b.a.cJ(8, this.YDx);
      AppMethodBeat.o(122482);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122482);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bt localbt = (bt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122482);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fns localfns = new fns();
            if ((localObject != null) && (localObject.length > 0)) {
              localfns.parseFrom((byte[])localObject);
            }
            localbt.YDs = localfns;
            paramInt += 1;
          }
          AppMethodBeat.o(122482);
          return 0;
        case 2: 
          localbt.flags = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122482);
          return 0;
        case 3: 
          localbt.state = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122482);
          return 0;
        case 4: 
          localbt.YDt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 5: 
          localbt.YDu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 6: 
          localbt.YDv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 7: 
          localbt.YDw = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(122482);
          return 0;
        }
        localbt.YDx = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(122482);
        return 0;
      }
      AppMethodBeat.o(122482);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bt
 * JD-Core Version:    0.7.0.1
 */