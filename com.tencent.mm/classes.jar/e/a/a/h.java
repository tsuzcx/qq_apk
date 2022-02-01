package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bw.a
{
  public String OmK;
  public String OmL;
  public String OmM;
  public String OmN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91746);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.OmK != null) {
        paramVarArgs.d(1, this.OmK);
      }
      if (this.OmL != null) {
        paramVarArgs.d(2, this.OmL);
      }
      if (this.OmM != null) {
        paramVarArgs.d(3, this.OmM);
      }
      if (this.OmN != null) {
        paramVarArgs.d(4, this.OmN);
      }
      AppMethodBeat.o(91746);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OmK == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.OmK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.OmL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.OmL);
      }
      i = paramInt;
      if (this.OmM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.OmM);
      }
      paramInt = i;
      if (this.OmN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.OmN);
      }
      AppMethodBeat.o(91746);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localh.OmK = locala.OmT.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 2: 
          localh.OmL = locala.OmT.readString();
          AppMethodBeat.o(91746);
          return 0;
        case 3: 
          localh.OmM = locala.OmT.readString();
          AppMethodBeat.o(91746);
          return 0;
        }
        localh.OmN = locala.OmT.readString();
        AppMethodBeat.o(91746);
        return 0;
      }
      AppMethodBeat.o(91746);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     e.a.a.h
 * JD-Core Version:    0.7.0.1
 */