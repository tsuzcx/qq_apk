package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bw.a
{
  public String LVj;
  public String LVk;
  public String LVl;
  public String LVm;
  public String LVn;
  public String vFL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91747);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vFL != null) {
        paramVarArgs.d(1, this.vFL);
      }
      if (this.LVj != null) {
        paramVarArgs.d(2, this.LVj);
      }
      if (this.LVk != null) {
        paramVarArgs.d(3, this.LVk);
      }
      if (this.LVl != null) {
        paramVarArgs.d(4, this.LVl);
      }
      if (this.LVm != null) {
        paramVarArgs.d(5, this.LVm);
      }
      if (this.LVn != null) {
        paramVarArgs.d(6, this.LVn);
      }
      AppMethodBeat.o(91747);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vFL == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.vFL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LVj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.LVj);
      }
      i = paramInt;
      if (this.LVk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.LVk);
      }
      paramInt = i;
      if (this.LVl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.LVl);
      }
      i = paramInt;
      if (this.LVm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.LVm);
      }
      paramInt = i;
      if (this.LVn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.LVn);
      }
      AppMethodBeat.o(91747);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91747);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91747);
          return -1;
        case 1: 
          locali.vFL = locala.LVo.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 2: 
          locali.LVj = locala.LVo.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 3: 
          locali.LVk = locala.LVo.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 4: 
          locali.LVl = locala.LVo.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 5: 
          locali.LVm = locala.LVo.readString();
          AppMethodBeat.o(91747);
          return 0;
        }
        locali.LVn = locala.LVo.readString();
        AppMethodBeat.o(91747);
        return 0;
      }
      AppMethodBeat.o(91747);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.i
 * JD-Core Version:    0.7.0.1
 */