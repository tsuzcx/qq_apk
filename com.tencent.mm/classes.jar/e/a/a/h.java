package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bx.a
{
  public String Khw;
  public String Khx;
  public String Khy;
  public String Khz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91746);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Khw != null) {
        paramVarArgs.d(1, this.Khw);
      }
      if (this.Khx != null) {
        paramVarArgs.d(2, this.Khx);
      }
      if (this.Khy != null) {
        paramVarArgs.d(3, this.Khy);
      }
      if (this.Khz != null) {
        paramVarArgs.d(4, this.Khz);
      }
      AppMethodBeat.o(91746);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Khw == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.Khw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Khx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Khx);
      }
      i = paramInt;
      if (this.Khy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Khy);
      }
      paramInt = i;
      if (this.Khz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Khz);
      }
      AppMethodBeat.o(91746);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          localh.Khw = locala.KhF.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 2: 
          localh.Khx = locala.KhF.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 3: 
          localh.Khy = locala.KhF.readString();
          AppMethodBeat.o(91746);
          return 0;
        }
        localh.Khz = locala.KhF.readString();
        AppMethodBeat.o(91746);
        return 0;
      }
      AppMethodBeat.o(91746);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     e.a.a.h
 * JD-Core Version:    0.7.0.1
 */