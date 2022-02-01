package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bwz
  extends com.tencent.mm.bx.a
{
  public LinkedList<dik> aafO;
  public LinkedList<dik> aafP;
  
  public bwz()
  {
    AppMethodBeat.i(258462);
    this.aafO = new LinkedList();
    this.aafP = new LinkedList();
    AppMethodBeat.o(258462);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258465);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aafO);
      paramVarArgs.e(2, 8, this.aafP);
      AppMethodBeat.o(258465);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.aafO);
      i = i.a.a.a.c(2, 8, this.aafP);
      AppMethodBeat.o(258465);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aafO.clear();
      this.aafP.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258465);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bwz localbwz = (bwz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      dik localdik;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258465);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdik = new dik();
          if ((localObject != null) && (localObject.length > 0)) {
            localdik.parseFrom((byte[])localObject);
          }
          localbwz.aafO.add(localdik);
          paramInt += 1;
        }
        AppMethodBeat.o(258465);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localdik = new dik();
        if ((localObject != null) && (localObject.length > 0)) {
          localdik.parseFrom((byte[])localObject);
        }
        localbwz.aafP.add(localdik);
        paramInt += 1;
      }
      AppMethodBeat.o(258465);
      return 0;
    }
    AppMethodBeat.o(258465);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwz
 * JD-Core Version:    0.7.0.1
 */