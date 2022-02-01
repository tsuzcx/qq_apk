package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bw.a
{
  public String MFd;
  public String MFe;
  public int MFf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91745);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MFd != null) {
        paramVarArgs.e(1, this.MFd);
      }
      if (this.MFe != null) {
        paramVarArgs.e(2, this.MFe);
      }
      paramVarArgs.aM(3, this.MFf);
      AppMethodBeat.o(91745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MFd == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.MFd) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MFe != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MFe);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.MFf);
      AppMethodBeat.o(91745);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91745);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91745);
          return -1;
        case 1: 
          localg.MFd = locala.UbS.readString();
          AppMethodBeat.o(91745);
          return 0;
        case 2: 
          localg.MFe = locala.UbS.readString();
          AppMethodBeat.o(91745);
          return 0;
        }
        localg.MFf = locala.UbS.zi();
        AppMethodBeat.o(91745);
        return 0;
      }
      AppMethodBeat.o(91745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.g
 * JD-Core Version:    0.7.0.1
 */