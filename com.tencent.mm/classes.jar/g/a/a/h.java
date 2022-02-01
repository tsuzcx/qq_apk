package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bx.a
{
  public String ajFY;
  public String ajFZ;
  public String ajGa;
  public String ajGb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91746);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ajFY != null) {
        paramVarArgs.g(1, this.ajFY);
      }
      if (this.ajFZ != null) {
        paramVarArgs.g(2, this.ajFZ);
      }
      if (this.ajGa != null) {
        paramVarArgs.g(3, this.ajGa);
      }
      if (this.ajGb != null) {
        paramVarArgs.g(4, this.ajGb);
      }
      AppMethodBeat.o(91746);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ajFY == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.ajFY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ajFZ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ajFZ);
      }
      i = paramInt;
      if (this.ajGa != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ajGa);
      }
      paramInt = i;
      if (this.ajGb != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ajGb);
      }
      AppMethodBeat.o(91746);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91746);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91746);
          return -1;
        case 1: 
          localh.ajFY = locala.ajGk.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 2: 
          localh.ajFZ = locala.ajGk.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 3: 
          localh.ajGa = locala.ajGk.readString();
          AppMethodBeat.o(91746);
          return 0;
        }
        localh.ajGb = locala.ajGk.readString();
        AppMethodBeat.o(91746);
        return 0;
      }
      AppMethodBeat.o(91746);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     g.a.a.h
 * JD-Core Version:    0.7.0.1
 */