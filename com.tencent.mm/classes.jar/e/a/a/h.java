package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bw.a
{
  public String UbG;
  public String UbH;
  public String UbI;
  public String UbJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91746);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UbG != null) {
        paramVarArgs.e(1, this.UbG);
      }
      if (this.UbH != null) {
        paramVarArgs.e(2, this.UbH);
      }
      if (this.UbI != null) {
        paramVarArgs.e(3, this.UbI);
      }
      if (this.UbJ != null) {
        paramVarArgs.e(4, this.UbJ);
      }
      AppMethodBeat.o(91746);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UbG == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.UbG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UbH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UbH);
      }
      i = paramInt;
      if (this.UbI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.UbI);
      }
      paramInt = i;
      if (this.UbJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.UbJ);
      }
      AppMethodBeat.o(91746);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
          localh.UbG = locala.UbS.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 2: 
          localh.UbH = locala.UbS.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 3: 
          localh.UbI = locala.UbS.readString();
          AppMethodBeat.o(91746);
          return 0;
        }
        localh.UbJ = locala.UbS.readString();
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