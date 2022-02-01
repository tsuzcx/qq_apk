package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epw
  extends com.tencent.mm.cd.a
{
  public String ROQ;
  public int TYJ;
  public int Uss;
  public ahr Ust;
  public ahr Usu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91706);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TYJ);
      paramVarArgs.aY(2, this.Uss);
      if (this.ROQ != null) {
        paramVarArgs.f(3, this.ROQ);
      }
      if (this.Ust != null)
      {
        paramVarArgs.oE(4, this.Ust.computeSize());
        this.Ust.writeFields(paramVarArgs);
      }
      if (this.Usu != null)
      {
        paramVarArgs.oE(5, this.Usu.computeSize());
        this.Usu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TYJ) + 0 + g.a.a.b.b.a.bM(2, this.Uss);
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ROQ);
      }
      i = paramInt;
      if (this.Ust != null) {
        i = paramInt + g.a.a.a.oD(4, this.Ust.computeSize());
      }
      paramInt = i;
      if (this.Usu != null) {
        paramInt = i + g.a.a.a.oD(5, this.Usu.computeSize());
      }
      AppMethodBeat.o(91706);
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
      AppMethodBeat.o(91706);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      epw localepw = (epw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      ahr localahr;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91706);
        return -1;
      case 1: 
        localepw.TYJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91706);
        return 0;
      case 2: 
        localepw.Uss = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91706);
        return 0;
      case 3: 
        localepw.ROQ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91706);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localahr = new ahr();
          if ((localObject != null) && (localObject.length > 0)) {
            localahr.parseFrom((byte[])localObject);
          }
          localepw.Ust = localahr;
          paramInt += 1;
        }
        AppMethodBeat.o(91706);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localahr = new ahr();
        if ((localObject != null) && (localObject.length > 0)) {
          localahr.parseFrom((byte[])localObject);
        }
        localepw.Usu = localahr;
        paramInt += 1;
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    AppMethodBeat.o(91706);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epw
 * JD-Core Version:    0.7.0.1
 */