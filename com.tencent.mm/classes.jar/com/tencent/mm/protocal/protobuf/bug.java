package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bug
  extends com.tencent.mm.bx.a
{
  public int BeA;
  public b ZEQ;
  public LinkedList<FinderObject> ZIQ;
  public int aabZ;
  
  public bug()
  {
    AppMethodBeat.i(259326);
    this.ZIQ = new LinkedList();
    AppMethodBeat.o(259326);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259328);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZIQ);
      if (this.ZEQ != null) {
        paramVarArgs.d(2, this.ZEQ);
      }
      paramVarArgs.bS(3, this.BeA);
      paramVarArgs.bS(4, this.aabZ);
      AppMethodBeat.o(259328);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ZIQ) + 0;
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZEQ);
      }
      i = i.a.a.b.b.a.cJ(3, this.BeA);
      int j = i.a.a.b.b.a.cJ(4, this.aabZ);
      AppMethodBeat.o(259328);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZIQ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259328);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bug localbug = (bug)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259328);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderObject localFinderObject = new FinderObject();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderObject.parseFrom((byte[])localObject);
          }
          localbug.ZIQ.add(localFinderObject);
          paramInt += 1;
        }
        AppMethodBeat.o(259328);
        return 0;
      case 2: 
        localbug.ZEQ = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(259328);
        return 0;
      case 3: 
        localbug.BeA = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259328);
        return 0;
      }
      localbug.aabZ = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(259328);
      return 0;
    }
    AppMethodBeat.o(259328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bug
 * JD-Core Version:    0.7.0.1
 */