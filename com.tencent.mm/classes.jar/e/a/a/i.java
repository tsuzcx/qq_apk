package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.cd.a
{
  public String GUf;
  public String abEZ;
  public String abFa;
  public String abFb;
  public String abFc;
  public String abFd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91747);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GUf != null) {
        paramVarArgs.f(1, this.GUf);
      }
      if (this.abEZ != null) {
        paramVarArgs.f(2, this.abEZ);
      }
      if (this.abFa != null) {
        paramVarArgs.f(3, this.abFa);
      }
      if (this.abFb != null) {
        paramVarArgs.f(4, this.abFb);
      }
      if (this.abFc != null) {
        paramVarArgs.f(5, this.abFc);
      }
      if (this.abFd != null) {
        paramVarArgs.f(6, this.abFd);
      }
      AppMethodBeat.o(91747);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GUf == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.g(1, this.GUf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abEZ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.abEZ);
      }
      i = paramInt;
      if (this.abFa != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.abFa);
      }
      paramInt = i;
      if (this.abFb != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.abFb);
      }
      i = paramInt;
      if (this.abFc != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.abFc);
      }
      paramInt = i;
      if (this.abFd != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.abFd);
      }
      AppMethodBeat.o(91747);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91747);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91747);
          return -1;
        case 1: 
          locali.GUf = locala.abFh.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 2: 
          locali.abEZ = locala.abFh.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 3: 
          locali.abFa = locala.abFh.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 4: 
          locali.abFb = locala.abFh.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 5: 
          locali.abFc = locala.abFh.readString();
          AppMethodBeat.o(91747);
          return 0;
        }
        locali.abFd = locala.abFh.readString();
        AppMethodBeat.o(91747);
        return 0;
      }
      AppMethodBeat.o(91747);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.i
 * JD-Core Version:    0.7.0.1
 */