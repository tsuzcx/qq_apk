package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class if
  extends com.tencent.mm.cd.a
{
  public int CqV;
  public String ID;
  public eae RNC;
  public String RND;
  public int RNE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32135);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RNC == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32135);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.CqV);
      if (this.RNC != null)
      {
        paramVarArgs.oE(2, this.RNC.computeSize());
        this.RNC.writeFields(paramVarArgs);
      }
      if (this.RND != null) {
        paramVarArgs.f(3, this.RND);
      }
      paramVarArgs.aY(4, this.RNE);
      if (this.ID != null) {
        paramVarArgs.f(5, this.ID);
      }
      AppMethodBeat.o(32135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CqV) + 0;
      paramInt = i;
      if (this.RNC != null) {
        paramInt = i + g.a.a.a.oD(2, this.RNC.computeSize());
      }
      i = paramInt;
      if (this.RND != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RND);
      }
      i += g.a.a.b.b.a.bM(4, this.RNE);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ID);
      }
      AppMethodBeat.o(32135);
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
      if (this.RNC == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32135);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32135);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      if localif = (if)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32135);
        return -1;
      case 1: 
        localif.CqV = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32135);
        return 0;
      case 2: 
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
          localif.RNC = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(32135);
        return 0;
      case 3: 
        localif.RND = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32135);
        return 0;
      case 4: 
        localif.RNE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32135);
        return 0;
      }
      localif.ID = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(32135);
      return 0;
    }
    AppMethodBeat.o(32135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.if
 * JD-Core Version:    0.7.0.1
 */