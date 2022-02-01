package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwf
  extends com.tencent.mm.cd.a
{
  public int Ucg;
  public eae Uch;
  public eae Uci;
  public eae Ucj;
  public eae Uck;
  public long Ucl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125760);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Ucg);
      if (this.Uch != null)
      {
        paramVarArgs.oE(2, this.Uch.computeSize());
        this.Uch.writeFields(paramVarArgs);
      }
      if (this.Uci != null)
      {
        paramVarArgs.oE(3, this.Uci.computeSize());
        this.Uci.writeFields(paramVarArgs);
      }
      if (this.Ucj != null)
      {
        paramVarArgs.oE(4, this.Ucj.computeSize());
        this.Ucj.writeFields(paramVarArgs);
      }
      if (this.Uck != null)
      {
        paramVarArgs.oE(5, this.Uck.computeSize());
        this.Uck.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.Ucl);
      AppMethodBeat.o(125760);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Ucg) + 0;
      paramInt = i;
      if (this.Uch != null) {
        paramInt = i + g.a.a.a.oD(2, this.Uch.computeSize());
      }
      i = paramInt;
      if (this.Uci != null) {
        i = paramInt + g.a.a.a.oD(3, this.Uci.computeSize());
      }
      paramInt = i;
      if (this.Ucj != null) {
        paramInt = i + g.a.a.a.oD(4, this.Ucj.computeSize());
      }
      i = paramInt;
      if (this.Uck != null) {
        i = paramInt + g.a.a.a.oD(5, this.Uck.computeSize());
      }
      paramInt = g.a.a.b.b.a.p(6, this.Ucl);
      AppMethodBeat.o(125760);
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
      AppMethodBeat.o(125760);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dwf localdwf = (dwf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      eae localeae;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125760);
        return -1;
      case 1: 
        localdwf.Ucg = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125760);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localdwf.Uch = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localdwf.Uci = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localdwf.Ucj = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localdwf.Uck = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      }
      localdwf.Ucl = ((g.a.a.a.a)localObject).abFh.AN();
      AppMethodBeat.o(125760);
      return 0;
    }
    AppMethodBeat.o(125760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwf
 * JD-Core Version:    0.7.0.1
 */