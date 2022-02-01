package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public String HcE;
  public String HcF;
  public int HcG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91745);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HcE != null) {
        paramVarArgs.d(1, this.HcE);
      }
      if (this.HcF != null) {
        paramVarArgs.d(2, this.HcF);
      }
      paramVarArgs.aS(3, this.HcG);
      AppMethodBeat.o(91745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HcE == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.HcE) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HcF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HcF);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HcG);
      AppMethodBeat.o(91745);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91745);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91745);
          return -1;
        case 1: 
          localg.HcE = locala.NPN.readString();
          AppMethodBeat.o(91745);
          return 0;
        case 2: 
          localg.HcF = locala.NPN.readString();
          AppMethodBeat.o(91745);
          return 0;
        }
        localg.HcG = locala.NPN.zc();
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