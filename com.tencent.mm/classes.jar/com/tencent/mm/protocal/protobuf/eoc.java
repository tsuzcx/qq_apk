package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eoc
  extends com.tencent.mm.cd.a
{
  public long UpP;
  public eae UqT;
  public int jUk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118463);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UqT == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpContent");
        AppMethodBeat.o(118463);
        throw paramVarArgs;
      }
      paramVarArgs.bm(1, this.UpP);
      paramVarArgs.aY(2, this.jUk);
      if (this.UqT != null)
      {
        paramVarArgs.oE(3, this.UqT.computeSize());
        this.UqT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.UpP) + 0 + g.a.a.b.b.a.bM(2, this.jUk);
      paramInt = i;
      if (this.UqT != null) {
        paramInt = i + g.a.a.a.oD(3, this.UqT.computeSize());
      }
      AppMethodBeat.o(118463);
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
      if (this.UqT == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpContent");
        AppMethodBeat.o(118463);
        throw paramVarArgs;
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eoc localeoc = (eoc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118463);
        return -1;
      case 1: 
        localeoc.UpP = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(118463);
        return 0;
      case 2: 
        localeoc.jUk = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118463);
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
        localeoc.UqT = localeae;
        paramInt += 1;
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    AppMethodBeat.o(118463);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoc
 * JD-Core Version:    0.7.0.1
 */