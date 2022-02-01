package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bx.a
{
  public String NPI;
  public String NPJ;
  public String NPK;
  public String NPL;
  public String NPM;
  public String wMR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91747);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wMR != null) {
        paramVarArgs.d(1, this.wMR);
      }
      if (this.NPI != null) {
        paramVarArgs.d(2, this.NPI);
      }
      if (this.NPJ != null) {
        paramVarArgs.d(3, this.NPJ);
      }
      if (this.NPK != null) {
        paramVarArgs.d(4, this.NPK);
      }
      if (this.NPL != null) {
        paramVarArgs.d(5, this.NPL);
      }
      if (this.NPM != null) {
        paramVarArgs.d(6, this.NPM);
      }
      AppMethodBeat.o(91747);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wMR == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.wMR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NPI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.NPI);
      }
      i = paramInt;
      if (this.NPJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.NPJ);
      }
      paramInt = i;
      if (this.NPK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.NPK);
      }
      i = paramInt;
      if (this.NPL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.NPL);
      }
      paramInt = i;
      if (this.NPM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.NPM);
      }
      AppMethodBeat.o(91747);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          locali.wMR = locala.NPN.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 2: 
          locali.NPI = locala.NPN.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 3: 
          locali.NPJ = locala.NPN.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 4: 
          locali.NPK = locala.NPN.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 5: 
          locali.NPL = locala.NPN.readString();
          AppMethodBeat.o(91747);
          return 0;
        }
        locali.NPM = locala.NPN.readString();
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