package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ur
  extends com.tencent.mm.cd.a
{
  public int Sfi;
  public String Sfj;
  public String Sfk;
  public String Sfl;
  public int Sfm;
  public String Sfn;
  public up Sfo;
  public String Sfp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113967);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Sfi);
      if (this.Sfj != null) {
        paramVarArgs.f(2, this.Sfj);
      }
      if (this.Sfk != null) {
        paramVarArgs.f(3, this.Sfk);
      }
      if (this.Sfl != null) {
        paramVarArgs.f(4, this.Sfl);
      }
      paramVarArgs.aY(5, this.Sfm);
      if (this.Sfn != null) {
        paramVarArgs.f(6, this.Sfn);
      }
      if (this.Sfo != null)
      {
        paramVarArgs.oE(7, this.Sfo.computeSize());
        this.Sfo.writeFields(paramVarArgs);
      }
      if (this.Sfp != null) {
        paramVarArgs.f(8, this.Sfp);
      }
      AppMethodBeat.o(113967);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Sfi) + 0;
      paramInt = i;
      if (this.Sfj != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Sfj);
      }
      i = paramInt;
      if (this.Sfk != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sfk);
      }
      paramInt = i;
      if (this.Sfl != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sfl);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Sfm);
      paramInt = i;
      if (this.Sfn != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Sfn);
      }
      i = paramInt;
      if (this.Sfo != null) {
        i = paramInt + g.a.a.a.oD(7, this.Sfo.computeSize());
      }
      paramInt = i;
      if (this.Sfp != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Sfp);
      }
      AppMethodBeat.o(113967);
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
      AppMethodBeat.o(113967);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ur localur = (ur)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113967);
        return -1;
      case 1: 
        localur.Sfi = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(113967);
        return 0;
      case 2: 
        localur.Sfj = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 3: 
        localur.Sfk = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 4: 
        localur.Sfl = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 5: 
        localur.Sfm = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(113967);
        return 0;
      case 6: 
        localur.Sfn = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          up localup = new up();
          if ((localObject != null) && (localObject.length > 0)) {
            localup.parseFrom((byte[])localObject);
          }
          localur.Sfo = localup;
          paramInt += 1;
        }
        AppMethodBeat.o(113967);
        return 0;
      }
      localur.Sfp = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(113967);
      return 0;
    }
    AppMethodBeat.o(113967);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ur
 * JD-Core Version:    0.7.0.1
 */