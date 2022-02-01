package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gdn
  extends com.tencent.mm.bx.a
{
  public LinkedList<gdm> acbs;
  public int vgN;
  
  public gdn()
  {
    AppMethodBeat.i(32513);
    this.acbs = new LinkedList();
    AppMethodBeat.o(32513);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32514);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.acbs);
      paramVarArgs.bS(2, this.vgN);
      AppMethodBeat.o(32514);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.acbs);
      i = i.a.a.b.b.a.cJ(2, this.vgN);
      AppMethodBeat.o(32514);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.acbs.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32514);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gdn localgdn = (gdn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32514);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gdm localgdm = new gdm();
          if ((localObject != null) && (localObject.length > 0)) {
            localgdm.parseFrom((byte[])localObject);
          }
          localgdn.acbs.add(localgdm);
          paramInt += 1;
        }
        AppMethodBeat.o(32514);
        return 0;
      }
      localgdn.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(32514);
      return 0;
    }
    AppMethodBeat.o(32514);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdn
 * JD-Core Version:    0.7.0.1
 */