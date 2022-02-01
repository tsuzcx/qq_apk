package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bx.a
{
  public String NPE;
  public String NPF;
  public String NPG;
  public String NPH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91746);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.NPE != null) {
        paramVarArgs.d(1, this.NPE);
      }
      if (this.NPF != null) {
        paramVarArgs.d(2, this.NPF);
      }
      if (this.NPG != null) {
        paramVarArgs.d(3, this.NPG);
      }
      if (this.NPH != null) {
        paramVarArgs.d(4, this.NPH);
      }
      AppMethodBeat.o(91746);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NPE == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.NPE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NPF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.NPF);
      }
      i = paramInt;
      if (this.NPG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.NPG);
      }
      paramInt = i;
      if (this.NPH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.NPH);
      }
      AppMethodBeat.o(91746);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91746);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91746);
          return -1;
        case 1: 
          localh.NPE = locala.NPN.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 2: 
          localh.NPF = locala.NPN.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 3: 
          localh.NPG = locala.NPN.readString();
          AppMethodBeat.o(91746);
          return 0;
        }
        localh.NPH = locala.NPN.readString();
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