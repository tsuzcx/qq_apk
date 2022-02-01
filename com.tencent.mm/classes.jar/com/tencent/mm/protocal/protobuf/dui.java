package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dui
  extends com.tencent.mm.cd.a
{
  public aji UaH;
  public String UaI;
  public String UaJ;
  public int emoji_from;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104830);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UaH != null)
      {
        paramVarArgs.oE(1, this.UaH.computeSize());
        this.UaH.writeFields(paramVarArgs);
      }
      if (this.UaI != null) {
        paramVarArgs.f(2, this.UaI);
      }
      paramVarArgs.aY(3, this.type);
      if (this.UaJ != null) {
        paramVarArgs.f(4, this.UaJ);
      }
      paramVarArgs.aY(5, this.emoji_from);
      AppMethodBeat.o(104830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UaH == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = g.a.a.a.oD(1, this.UaH.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UaI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UaI);
      }
      i += g.a.a.b.b.a.bM(3, this.type);
      paramInt = i;
      if (this.UaJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UaJ);
      }
      i = g.a.a.b.b.a.bM(5, this.emoji_from);
      AppMethodBeat.o(104830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dui localdui = (dui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104830);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aji localaji = new aji();
            if ((localObject != null) && (localObject.length > 0)) {
              localaji.parseFrom((byte[])localObject);
            }
            localdui.UaH = localaji;
            paramInt += 1;
          }
          AppMethodBeat.o(104830);
          return 0;
        case 2: 
          localdui.UaI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104830);
          return 0;
        case 3: 
          localdui.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104830);
          return 0;
        case 4: 
          localdui.UaJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104830);
          return 0;
        }
        localdui.emoji_from = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(104830);
        return 0;
      }
      AppMethodBeat.o(104830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dui
 * JD-Core Version:    0.7.0.1
 */