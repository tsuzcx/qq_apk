package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eux
  extends com.tencent.mm.cd.a
{
  public int CqV;
  public String TJZ;
  public eae Taj;
  public int UwE;
  public String UwH;
  public int UwI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152716);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UwE);
      if (this.UwH != null) {
        paramVarArgs.f(2, this.UwH);
      }
      paramVarArgs.aY(3, this.CqV);
      if (this.TJZ != null) {
        paramVarArgs.f(4, this.TJZ);
      }
      if (this.Taj != null)
      {
        paramVarArgs.oE(5, this.Taj.computeSize());
        this.Taj.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.UwI);
      AppMethodBeat.o(152716);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.UwE) + 0;
      paramInt = i;
      if (this.UwH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UwH);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.CqV);
      paramInt = i;
      if (this.TJZ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TJZ);
      }
      i = paramInt;
      if (this.Taj != null) {
        i = paramInt + g.a.a.a.oD(5, this.Taj.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(6, this.UwI);
      AppMethodBeat.o(152716);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152716);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eux localeux = (eux)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152716);
        return -1;
      case 1: 
        localeux.UwE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152716);
        return 0;
      case 2: 
        localeux.UwH = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 3: 
        localeux.CqV = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152716);
        return 0;
      case 4: 
        localeux.TJZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 5: 
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
          localeux.Taj = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(152716);
        return 0;
      }
      localeux.UwI = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(152716);
      return 0;
    }
    AppMethodBeat.o(152716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eux
 * JD-Core Version:    0.7.0.1
 */