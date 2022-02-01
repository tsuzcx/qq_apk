package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bho
  extends com.tencent.mm.cd.a
{
  public int SDr;
  public LinkedList<FinderContact> SSd;
  public int SSe;
  
  public bho()
  {
    AppMethodBeat.i(169041);
    this.SSd = new LinkedList();
    AppMethodBeat.o(169041);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169042);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SSd);
      paramVarArgs.aY(2, this.SDr);
      paramVarArgs.aY(3, this.SSe);
      AppMethodBeat.o(169042);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.SSd);
      i = g.a.a.b.b.a.bM(2, this.SDr);
      int j = g.a.a.b.b.a.bM(3, this.SSe);
      AppMethodBeat.o(169042);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SSd.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169042);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bho localbho = (bho)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169042);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderContact localFinderContact = new FinderContact();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderContact.parseFrom((byte[])localObject);
          }
          localbho.SSd.add(localFinderContact);
          paramInt += 1;
        }
        AppMethodBeat.o(169042);
        return 0;
      case 2: 
        localbho.SDr = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(169042);
        return 0;
      }
      localbho.SSe = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(169042);
      return 0;
    }
    AppMethodBeat.o(169042);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bho
 * JD-Core Version:    0.7.0.1
 */