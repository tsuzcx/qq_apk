package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aqw
  extends com.tencent.mm.bw.a
{
  public int LCH;
  public LinkedList<bbz> LCI;
  public int continueFlag;
  public String dPI;
  public int offset;
  public String query;
  public b tVM;
  public LinkedList<FinderObject> tbD;
  
  public aqw()
  {
    AppMethodBeat.i(168958);
    this.tbD = new LinkedList();
    this.LCI = new LinkedList();
    AppMethodBeat.o(168958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.query != null) {
        paramVarArgs.e(1, this.query);
      }
      paramVarArgs.aM(2, this.offset);
      paramVarArgs.aM(3, this.continueFlag);
      paramVarArgs.e(4, 8, this.tbD);
      if (this.tVM != null) {
        paramVarArgs.c(5, this.tVM);
      }
      paramVarArgs.aM(6, this.LCH);
      if (this.dPI != null) {
        paramVarArgs.e(7, this.dPI);
      }
      paramVarArgs.e(8, 8, this.LCI);
      AppMethodBeat.o(168959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.query == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = g.a.a.b.b.a.f(1, this.query) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.offset) + g.a.a.b.b.a.bu(3, this.continueFlag) + g.a.a.a.c(4, 8, this.tbD);
      paramInt = i;
      if (this.tVM != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.tVM);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.LCH);
      paramInt = i;
      if (this.dPI != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.dPI);
      }
      i = g.a.a.a.c(8, 8, this.LCI);
      AppMethodBeat.o(168959);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tbD.clear();
        this.LCI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqw localaqw = (aqw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168959);
          return -1;
        case 1: 
          localaqw.query = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168959);
          return 0;
        case 2: 
          localaqw.offset = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168959);
          return 0;
        case 3: 
          localaqw.continueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168959);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqw.tbD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168959);
          return 0;
        case 5: 
          localaqw.tVM = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168959);
          return 0;
        case 6: 
          localaqw.LCH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168959);
          return 0;
        case 7: 
          localaqw.dPI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168959);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bbz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bbz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaqw.LCI.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqw
 * JD-Core Version:    0.7.0.1
 */