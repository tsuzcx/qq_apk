package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.cd.a
{
  public String TQP;
  public String TQQ;
  public int TQR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91745);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TQP != null) {
        paramVarArgs.f(1, this.TQP);
      }
      if (this.TQQ != null) {
        paramVarArgs.f(2, this.TQQ);
      }
      paramVarArgs.aY(3, this.TQR);
      AppMethodBeat.o(91745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TQP == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.TQP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TQQ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TQQ);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.TQR);
      AppMethodBeat.o(91745);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
          localg.TQP = locala.abFh.readString();
          AppMethodBeat.o(91745);
          return 0;
        case 2: 
          localg.TQQ = locala.abFh.readString();
          AppMethodBeat.o(91745);
          return 0;
        }
        localg.TQR = locala.abFh.AK();
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