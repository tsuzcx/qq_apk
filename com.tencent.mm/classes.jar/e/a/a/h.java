package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.cd.a
{
  public String abEV;
  public String abEW;
  public String abEX;
  public String abEY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91746);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.abEV != null) {
        paramVarArgs.f(1, this.abEV);
      }
      if (this.abEW != null) {
        paramVarArgs.f(2, this.abEW);
      }
      if (this.abEX != null) {
        paramVarArgs.f(3, this.abEX);
      }
      if (this.abEY != null) {
        paramVarArgs.f(4, this.abEY);
      }
      AppMethodBeat.o(91746);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abEV == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.abEV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abEW != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.abEW);
      }
      i = paramInt;
      if (this.abEX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.abEX);
      }
      paramInt = i;
      if (this.abEY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.abEY);
      }
      AppMethodBeat.o(91746);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91746);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91746);
          return -1;
        case 1: 
          localh.abEV = locala.abFh.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 2: 
          localh.abEW = locala.abFh.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 3: 
          localh.abEX = locala.abFh.readString();
          AppMethodBeat.o(91746);
          return 0;
        }
        localh.abEY = locala.abFh.readString();
        AppMethodBeat.o(91746);
        return 0;
      }
      AppMethodBeat.o(91746);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.h
 * JD-Core Version:    0.7.0.1
 */