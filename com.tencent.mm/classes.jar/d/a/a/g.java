package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bv.a
{
  public String xzC;
  public String xzD;
  public int xzE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(57011);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xzC != null) {
        paramVarArgs.e(1, this.xzC);
      }
      if (this.xzD != null) {
        paramVarArgs.e(2, this.xzD);
      }
      paramVarArgs.aO(3, this.xzE);
      AppMethodBeat.o(57011);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xzC == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.xzC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xzD != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xzD);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xzE);
      AppMethodBeat.o(57011);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(57011);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(57011);
          return -1;
        case 1: 
          localg.xzC = locala.CLY.readString();
          AppMethodBeat.o(57011);
          return 0;
        case 2: 
          localg.xzD = locala.CLY.readString();
          AppMethodBeat.o(57011);
          return 0;
        }
        localg.xzE = locala.CLY.sl();
        AppMethodBeat.o(57011);
        return 0;
      }
      AppMethodBeat.o(57011);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.a.a.g
 * JD-Core Version:    0.7.0.1
 */