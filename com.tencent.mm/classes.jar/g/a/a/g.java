package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public String abho;
  public String abhp;
  public int abhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91745);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abho != null) {
        paramVarArgs.g(1, this.abho);
      }
      if (this.abhp != null) {
        paramVarArgs.g(2, this.abhp);
      }
      paramVarArgs.bS(3, this.abhq);
      AppMethodBeat.o(91745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abho == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.abho) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abhp != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abhp);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abhq);
      AppMethodBeat.o(91745);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91745);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91745);
          return -1;
        case 1: 
          localg.abho = locala.ajGk.readString();
          AppMethodBeat.o(91745);
          return 0;
        case 2: 
          localg.abhp = locala.ajGk.readString();
          AppMethodBeat.o(91745);
          return 0;
        }
        localg.abhq = locala.ajGk.aar();
        AppMethodBeat.o(91745);
        return 0;
      }
      AppMethodBeat.o(91745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     g.a.a.g
 * JD-Core Version:    0.7.0.1
 */