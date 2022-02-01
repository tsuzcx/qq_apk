package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ffm
  extends com.tencent.mm.cd.a
{
  public String UFX;
  public String UFY;
  public LinkedList<String> UFZ;
  public int UGa;
  
  public ffm()
  {
    AppMethodBeat.i(147784);
    this.UFZ = new LinkedList();
    AppMethodBeat.o(147784);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147785);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UFX != null) {
        paramVarArgs.f(1, this.UFX);
      }
      if (this.UFY != null) {
        paramVarArgs.f(2, this.UFY);
      }
      paramVarArgs.e(3, 1, this.UFZ);
      paramVarArgs.aY(4, this.UGa);
      AppMethodBeat.o(147785);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UFX == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.g(1, this.UFX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UFY != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UFY);
      }
      paramInt = g.a.a.a.c(3, 1, this.UFZ);
      int j = g.a.a.b.b.a.bM(4, this.UGa);
      AppMethodBeat.o(147785);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UFZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(147785);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ffm localffm = (ffm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147785);
          return -1;
        case 1: 
          localffm.UFX = locala.abFh.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 2: 
          localffm.UFY = locala.abFh.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 3: 
          localffm.UFZ.add(locala.abFh.readString());
          AppMethodBeat.o(147785);
          return 0;
        }
        localffm.UGa = locala.abFh.AK();
        AppMethodBeat.o(147785);
        return 0;
      }
      AppMethodBeat.o(147785);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffm
 * JD-Core Version:    0.7.0.1
 */