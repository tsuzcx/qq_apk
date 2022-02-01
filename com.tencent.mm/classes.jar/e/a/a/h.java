package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bw.a
{
  public String LVf;
  public String LVg;
  public String LVh;
  public String LVi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91746);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.LVf != null) {
        paramVarArgs.d(1, this.LVf);
      }
      if (this.LVg != null) {
        paramVarArgs.d(2, this.LVg);
      }
      if (this.LVh != null) {
        paramVarArgs.d(3, this.LVh);
      }
      if (this.LVi != null) {
        paramVarArgs.d(4, this.LVi);
      }
      AppMethodBeat.o(91746);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LVf == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.LVf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LVg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.LVg);
      }
      i = paramInt;
      if (this.LVh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.LVh);
      }
      paramInt = i;
      if (this.LVi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.LVi);
      }
      AppMethodBeat.o(91746);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localh.LVf = locala.LVo.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 2: 
          localh.LVg = locala.LVo.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 3: 
          localh.LVh = locala.LVo.readString();
          AppMethodBeat.o(91746);
          return 0;
        }
        localh.LVi = locala.LVo.readString();
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