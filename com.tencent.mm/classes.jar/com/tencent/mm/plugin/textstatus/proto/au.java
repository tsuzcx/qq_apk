package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class au
  extends com.tencent.mm.bx.a
{
  public int TpY;
  public String TpZ;
  public LinkedList<TextStatusJumpInfo> jumpInfos;
  
  public au()
  {
    AppMethodBeat.i(289936);
    this.jumpInfos = new LinkedList();
    AppMethodBeat.o(289936);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289948);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.TpY);
      if (this.TpZ != null) {
        paramVarArgs.g(2, this.TpZ);
      }
      paramVarArgs.e(3, 8, this.jumpInfos);
      AppMethodBeat.o(289948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.TpY) + 0;
      paramInt = i;
      if (this.TpZ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.TpZ);
      }
      i = i.a.a.a.c(3, 8, this.jumpInfos);
      AppMethodBeat.o(289948);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.jumpInfos.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(289948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      au localau = (au)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(289948);
        return -1;
      case 1: 
        localau.TpY = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(289948);
        return 0;
      case 2: 
        localau.TpZ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(289948);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        TextStatusJumpInfo localTextStatusJumpInfo = new TextStatusJumpInfo();
        if ((localObject != null) && (localObject.length > 0)) {
          localTextStatusJumpInfo.parseFrom((byte[])localObject);
        }
        localau.jumpInfos.add(localTextStatusJumpInfo);
        paramInt += 1;
      }
      AppMethodBeat.o(289948);
      return 0;
    }
    AppMethodBeat.o(289948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.au
 * JD-Core Version:    0.7.0.1
 */