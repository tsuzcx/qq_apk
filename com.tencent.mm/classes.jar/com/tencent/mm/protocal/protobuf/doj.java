package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doj
  extends com.tencent.mm.cd.a
{
  public String ROQ;
  public boolean TVC;
  public eir TVD;
  public eir TVE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91632);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.TVC);
      if (this.TVD != null)
      {
        paramVarArgs.oE(2, this.TVD.computeSize());
        this.TVD.writeFields(paramVarArgs);
      }
      if (this.TVE != null)
      {
        paramVarArgs.oE(3, this.TVE.computeSize());
        this.TVE.writeFields(paramVarArgs);
      }
      if (this.ROQ != null) {
        paramVarArgs.f(4, this.ROQ);
      }
      AppMethodBeat.o(91632);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.gL(1) + 1 + 0;
      paramInt = i;
      if (this.TVD != null) {
        paramInt = i + g.a.a.a.oD(2, this.TVD.computeSize());
      }
      i = paramInt;
      if (this.TVE != null) {
        i = paramInt + g.a.a.a.oD(3, this.TVE.computeSize());
      }
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ROQ);
      }
      AppMethodBeat.o(91632);
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
      AppMethodBeat.o(91632);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      doj localdoj = (doj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      eir localeir;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91632);
        return -1;
      case 1: 
        localdoj.TVC = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(91632);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeir = new eir();
          if ((localObject != null) && (localObject.length > 0)) {
            localeir.parseFrom((byte[])localObject);
          }
          localdoj.TVD = localeir;
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeir = new eir();
          if ((localObject != null) && (localObject.length > 0)) {
            localeir.parseFrom((byte[])localObject);
          }
          localdoj.TVE = localeir;
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      }
      localdoj.ROQ = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(91632);
      return 0;
    }
    AppMethodBeat.o(91632);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doj
 * JD-Core Version:    0.7.0.1
 */