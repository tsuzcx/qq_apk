package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gje
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> acfu;
  public LinkedList<gjd> acfv;
  public int version;
  
  public gje()
  {
    AppMethodBeat.i(258295);
    this.acfu = new LinkedList();
    this.acfv = new LinkedList();
    AppMethodBeat.o(258295);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258297);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.version);
      paramVarArgs.e(2, 1, this.acfu);
      paramVarArgs.e(3, 8, this.acfv);
      AppMethodBeat.o(258297);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.version);
      i = i.a.a.a.c(2, 1, this.acfu);
      int j = i.a.a.a.c(3, 8, this.acfv);
      AppMethodBeat.o(258297);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.acfu.clear();
      this.acfv.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258297);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gje localgje = (gje)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258297);
        return -1;
      case 1: 
        localgje.version = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258297);
        return 0;
      case 2: 
        localgje.acfu.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(258297);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gjd localgjd = new gjd();
        if ((localObject != null) && (localObject.length > 0)) {
          localgjd.parseFrom((byte[])localObject);
        }
        localgje.acfv.add(localgjd);
        paramInt += 1;
      }
      AppMethodBeat.o(258297);
      return 0;
    }
    AppMethodBeat.o(258297);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gje
 * JD-Core Version:    0.7.0.1
 */