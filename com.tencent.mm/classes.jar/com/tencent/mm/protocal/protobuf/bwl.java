package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bwl
  extends com.tencent.mm.bx.a
{
  public b JaK;
  public int ZFJ;
  public LinkedList<dvl> ZIQ;
  
  public bwl()
  {
    AppMethodBeat.i(258636);
    this.ZIQ = new LinkedList();
    AppMethodBeat.o(258636);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258638);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZIQ);
      paramVarArgs.bS(2, this.ZFJ);
      if (this.JaK != null) {
        paramVarArgs.d(3, this.JaK);
      }
      AppMethodBeat.o(258638);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ZIQ) + 0 + i.a.a.b.b.a.cJ(2, this.ZFJ);
      paramInt = i;
      if (this.JaK != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.JaK);
      }
      AppMethodBeat.o(258638);
      return paramInt;
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
      AppMethodBeat.o(258638);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bwl localbwl = (bwl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258638);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dvl localdvl = new dvl();
          if ((localObject != null) && (localObject.length > 0)) {
            localdvl.parseFrom((byte[])localObject);
          }
          localbwl.ZIQ.add(localdvl);
          paramInt += 1;
        }
        AppMethodBeat.o(258638);
        return 0;
      case 2: 
        localbwl.ZFJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258638);
        return 0;
      }
      localbwl.JaK = ((i.a.a.a.a)localObject).ajGk.kFX();
      AppMethodBeat.o(258638);
      return 0;
    }
    AppMethodBeat.o(258638);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwl
 * JD-Core Version:    0.7.0.1
 */