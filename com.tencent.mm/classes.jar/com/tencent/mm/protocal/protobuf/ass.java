package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ass
  extends com.tencent.mm.cd.a
{
  public int SFT;
  public LinkedList<bip> SFU;
  public int continueFlag;
  public String fIY;
  public int offset;
  public String query;
  public LinkedList<FinderObject> wHI;
  public b xHE;
  
  public ass()
  {
    AppMethodBeat.i(168958);
    this.wHI = new LinkedList();
    this.SFU = new LinkedList();
    AppMethodBeat.o(168958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.query != null) {
        paramVarArgs.f(1, this.query);
      }
      paramVarArgs.aY(2, this.offset);
      paramVarArgs.aY(3, this.continueFlag);
      paramVarArgs.e(4, 8, this.wHI);
      if (this.xHE != null) {
        paramVarArgs.c(5, this.xHE);
      }
      paramVarArgs.aY(6, this.SFT);
      if (this.fIY != null) {
        paramVarArgs.f(7, this.fIY);
      }
      paramVarArgs.e(8, 8, this.SFU);
      AppMethodBeat.o(168959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.query == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = g.a.a.b.b.a.g(1, this.query) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.offset) + g.a.a.b.b.a.bM(3, this.continueFlag) + g.a.a.a.c(4, 8, this.wHI);
      paramInt = i;
      if (this.xHE != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.xHE);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.SFT);
      paramInt = i;
      if (this.fIY != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.fIY);
      }
      i = g.a.a.a.c(8, 8, this.SFU);
      AppMethodBeat.o(168959);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wHI.clear();
        this.SFU.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ass localass = (ass)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168959);
          return -1;
        case 1: 
          localass.query = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168959);
          return 0;
        case 2: 
          localass.offset = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168959);
          return 0;
        case 3: 
          localass.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168959);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localass.wHI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168959);
          return 0;
        case 5: 
          localass.xHE = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168959);
          return 0;
        case 6: 
          localass.SFT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168959);
          return 0;
        case 7: 
          localass.fIY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168959);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bip();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bip)localObject2).parseFrom((byte[])localObject1);
          }
          localass.SFU.add(localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ass
 * JD-Core Version:    0.7.0.1
 */