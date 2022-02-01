package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class euw
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public eae Taj;
  public int UwE;
  public String UwF;
  public String UwG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152715);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UwE);
      if (this.UwF != null) {
        paramVarArgs.f(2, this.UwF);
      }
      if (this.UwG != null) {
        paramVarArgs.f(3, this.UwG);
      }
      paramVarArgs.aY(4, this.CPw);
      if (this.Taj != null)
      {
        paramVarArgs.oE(5, this.Taj.computeSize());
        this.Taj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.UwE) + 0;
      paramInt = i;
      if (this.UwF != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UwF);
      }
      i = paramInt;
      if (this.UwG != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UwG);
      }
      i += g.a.a.b.b.a.bM(4, this.CPw);
      paramInt = i;
      if (this.Taj != null) {
        paramInt = i + g.a.a.a.oD(5, this.Taj.computeSize());
      }
      AppMethodBeat.o(152715);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      euw localeuw = (euw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152715);
        return -1;
      case 1: 
        localeuw.UwE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152715);
        return 0;
      case 2: 
        localeuw.UwF = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152715);
        return 0;
      case 3: 
        localeuw.UwG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152715);
        return 0;
      case 4: 
        localeuw.CPw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152715);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        eae localeae = new eae();
        if ((localObject != null) && (localObject.length > 0)) {
          localeae.dd((byte[])localObject);
        }
        localeuw.Taj = localeae;
        paramInt += 1;
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    AppMethodBeat.o(152715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euw
 * JD-Core Version:    0.7.0.1
 */