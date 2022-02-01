package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bx.a
{
  public String KhA;
  public String KhB;
  public String KhC;
  public String KhD;
  public String KhE;
  public String uwS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91747);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uwS != null) {
        paramVarArgs.d(1, this.uwS);
      }
      if (this.KhA != null) {
        paramVarArgs.d(2, this.KhA);
      }
      if (this.KhB != null) {
        paramVarArgs.d(3, this.KhB);
      }
      if (this.KhC != null) {
        paramVarArgs.d(4, this.KhC);
      }
      if (this.KhD != null) {
        paramVarArgs.d(5, this.KhD);
      }
      if (this.KhE != null) {
        paramVarArgs.d(6, this.KhE);
      }
      AppMethodBeat.o(91747);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uwS == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.uwS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KhA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.KhA);
      }
      i = paramInt;
      if (this.KhB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.KhB);
      }
      paramInt = i;
      if (this.KhC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.KhC);
      }
      i = paramInt;
      if (this.KhD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.KhD);
      }
      paramInt = i;
      if (this.KhE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.KhE);
      }
      AppMethodBeat.o(91747);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          locali.uwS = locala.KhF.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 2: 
          locali.KhA = locala.KhF.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 3: 
          locali.KhB = locala.KhF.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 4: 
          locali.KhC = locala.KhF.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 5: 
          locali.KhD = locala.KhF.readString();
          AppMethodBeat.o(91747);
          return 0;
        }
        locali.KhE = locala.KhF.readString();
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