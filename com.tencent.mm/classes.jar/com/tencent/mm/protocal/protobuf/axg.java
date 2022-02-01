package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class axg
  extends com.tencent.mm.bx.a
{
  public LinkedList<FinderObject> AdW;
  public b BgS;
  public int ERV;
  public LinkedList<buy> ZIt;
  public int continueFlag;
  public String hOG;
  public int offset;
  public String query;
  
  public axg()
  {
    AppMethodBeat.i(168958);
    this.AdW = new LinkedList();
    this.ZIt = new LinkedList();
    AppMethodBeat.o(168958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168959);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.query != null) {
        paramVarArgs.g(1, this.query);
      }
      paramVarArgs.bS(2, this.offset);
      paramVarArgs.bS(3, this.continueFlag);
      paramVarArgs.e(4, 8, this.AdW);
      if (this.BgS != null) {
        paramVarArgs.d(5, this.BgS);
      }
      paramVarArgs.bS(6, this.ERV);
      if (this.hOG != null) {
        paramVarArgs.g(7, this.hOG);
      }
      paramVarArgs.e(8, 8, this.ZIt);
      AppMethodBeat.o(168959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.query == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = i.a.a.b.b.a.h(1, this.query) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.offset) + i.a.a.b.b.a.cJ(3, this.continueFlag) + i.a.a.a.c(4, 8, this.AdW);
      paramInt = i;
      if (this.BgS != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.BgS);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.ERV);
      paramInt = i;
      if (this.hOG != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.hOG);
      }
      i = i.a.a.a.c(8, 8, this.ZIt);
      AppMethodBeat.o(168959);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.AdW.clear();
        this.ZIt.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        axg localaxg = (axg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168959);
          return -1;
        case 1: 
          localaxg.query = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168959);
          return 0;
        case 2: 
          localaxg.offset = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168959);
          return 0;
        case 3: 
          localaxg.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168959);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localaxg.AdW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168959);
          return 0;
        case 5: 
          localaxg.BgS = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168959);
          return 0;
        case 6: 
          localaxg.ERV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168959);
          return 0;
        case 7: 
          localaxg.hOG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168959);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new buy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((buy)localObject2).parseFrom((byte[])localObject1);
          }
          localaxg.ZIt.add(localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axg
 * JD-Core Version:    0.7.0.1
 */