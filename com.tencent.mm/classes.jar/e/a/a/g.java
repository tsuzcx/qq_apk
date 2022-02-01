package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bw.a
{
  public String Hwe;
  public String Hwf;
  public int Hwg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91745);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hwe != null) {
        paramVarArgs.d(1, this.Hwe);
      }
      if (this.Hwf != null) {
        paramVarArgs.d(2, this.Hwf);
      }
      paramVarArgs.aS(3, this.Hwg);
      AppMethodBeat.o(91745);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hwe == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hwe) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hwf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hwf);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Hwg);
      AppMethodBeat.o(91745);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localg.Hwe = locala.OmT.readString();
          AppMethodBeat.o(91745);
          return 0;
        case 2: 
          localg.Hwf = locala.OmT.readString();
          AppMethodBeat.o(91745);
          return 0;
        }
        localg.Hwg = locala.OmT.zc();
        AppMethodBeat.o(91745);
        return 0;
      }
      AppMethodBeat.o(91745);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     e.a.a.g
 * JD-Core Version:    0.7.0.1
 */