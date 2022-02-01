package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bw.a
{
  public String Bah;
  public String UbK;
  public String UbL;
  public String UbM;
  public String UbN;
  public String UbO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91747);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Bah != null) {
        paramVarArgs.e(1, this.Bah);
      }
      if (this.UbK != null) {
        paramVarArgs.e(2, this.UbK);
      }
      if (this.UbL != null) {
        paramVarArgs.e(3, this.UbL);
      }
      if (this.UbM != null) {
        paramVarArgs.e(4, this.UbM);
      }
      if (this.UbN != null) {
        paramVarArgs.e(5, this.UbN);
      }
      if (this.UbO != null) {
        paramVarArgs.e(6, this.UbO);
      }
      AppMethodBeat.o(91747);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Bah == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.f(1, this.Bah) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UbK != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UbK);
      }
      i = paramInt;
      if (this.UbL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.UbL);
      }
      paramInt = i;
      if (this.UbM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.UbM);
      }
      i = paramInt;
      if (this.UbN != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.UbN);
      }
      paramInt = i;
      if (this.UbO != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.UbO);
      }
      AppMethodBeat.o(91747);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91747);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91747);
          return -1;
        case 1: 
          locali.Bah = locala.UbS.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 2: 
          locali.UbK = locala.UbS.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 3: 
          locali.UbL = locala.UbS.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 4: 
          locali.UbM = locala.UbS.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 5: 
          locali.UbN = locala.UbS.readString();
          AppMethodBeat.o(91747);
          return 0;
        }
        locali.UbO = locala.UbS.readString();
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