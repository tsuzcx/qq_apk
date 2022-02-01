package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bw.a
{
  public String Fsx;
  public String Fsy;
  public int Fsz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91745);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fsx != null) {
        paramVarArgs.d(1, this.Fsx);
      }
      if (this.Fsy != null) {
        paramVarArgs.d(2, this.Fsy);
      }
      paramVarArgs.aR(3, this.Fsz);
      AppMethodBeat.o(91745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fsx == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fsx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fsy != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fsy);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Fsz);
      AppMethodBeat.o(91745);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localg.Fsx = locala.LVo.readString();
          AppMethodBeat.o(91745);
          return 0;
        case 2: 
          localg.Fsy = locala.LVo.readString();
          AppMethodBeat.o(91745);
          return 0;
        }
        localg.Fsz = locala.LVo.xF();
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