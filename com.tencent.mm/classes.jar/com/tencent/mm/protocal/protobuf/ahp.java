package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahp
  extends com.tencent.mm.cd.a
{
  public int Ssm;
  public ahn Ssn;
  public ahn Sso;
  public int Ssp;
  public int Ssq;
  public int Ssr;
  public int Sss;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90966);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Ssm);
      if (this.Ssn != null)
      {
        paramVarArgs.oE(2, this.Ssn.computeSize());
        this.Ssn.writeFields(paramVarArgs);
      }
      if (this.Sso != null)
      {
        paramVarArgs.oE(3, this.Sso.computeSize());
        this.Sso.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.Ssp);
      paramVarArgs.aY(5, this.Ssq);
      paramVarArgs.aY(6, this.Ssr);
      paramVarArgs.aY(7, this.Sss);
      AppMethodBeat.o(90966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Ssm) + 0;
      paramInt = i;
      if (this.Ssn != null) {
        paramInt = i + g.a.a.a.oD(2, this.Ssn.computeSize());
      }
      i = paramInt;
      if (this.Sso != null) {
        i = paramInt + g.a.a.a.oD(3, this.Sso.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.Ssp);
      int j = g.a.a.b.b.a.bM(5, this.Ssq);
      int k = g.a.a.b.b.a.bM(6, this.Ssr);
      int m = g.a.a.b.b.a.bM(7, this.Sss);
      AppMethodBeat.o(90966);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(90966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ahp localahp = (ahp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      ahn localahn;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90966);
        return -1;
      case 1: 
        localahp.Ssm = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(90966);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localahn = new ahn();
          if ((localObject != null) && (localObject.length > 0)) {
            localahn.parseFrom((byte[])localObject);
          }
          localahp.Ssn = localahn;
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localahn = new ahn();
          if ((localObject != null) && (localObject.length > 0)) {
            localahn.parseFrom((byte[])localObject);
          }
          localahp.Sso = localahn;
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 4: 
        localahp.Ssp = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(90966);
        return 0;
      case 5: 
        localahp.Ssq = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(90966);
        return 0;
      case 6: 
        localahp.Ssr = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(90966);
        return 0;
      }
      localahp.Sss = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(90966);
      return 0;
    }
    AppMethodBeat.o(90966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahp
 * JD-Core Version:    0.7.0.1
 */