package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bto
  extends com.tencent.mm.bx.a
{
  public int ZEp;
  public LinkedList<FinderContact> aabr;
  public int aabs;
  
  public bto()
  {
    AppMethodBeat.i(169041);
    this.aabr = new LinkedList();
    AppMethodBeat.o(169041);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169042);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aabr);
      paramVarArgs.bS(2, this.ZEp);
      paramVarArgs.bS(3, this.aabs);
      AppMethodBeat.o(169042);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.aabr);
      i = i.a.a.b.b.a.cJ(2, this.ZEp);
      int j = i.a.a.b.b.a.cJ(3, this.aabs);
      AppMethodBeat.o(169042);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aabr.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169042);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bto localbto = (bto)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169042);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderContact localFinderContact = new FinderContact();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderContact.parseFrom((byte[])localObject);
          }
          localbto.aabr.add(localFinderContact);
          paramInt += 1;
        }
        AppMethodBeat.o(169042);
        return 0;
      case 2: 
        localbto.ZEp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169042);
        return 0;
      }
      localbto.aabs = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(169042);
      return 0;
    }
    AppMethodBeat.o(169042);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bto
 * JD-Core Version:    0.7.0.1
 */