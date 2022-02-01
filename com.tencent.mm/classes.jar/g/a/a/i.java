package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bx.a
{
  public String MRI;
  public String ajGc;
  public String ajGd;
  public String ajGe;
  public String ajGf;
  public String ajGg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91747);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.MRI != null) {
        paramVarArgs.g(1, this.MRI);
      }
      if (this.ajGc != null) {
        paramVarArgs.g(2, this.ajGc);
      }
      if (this.ajGd != null) {
        paramVarArgs.g(3, this.ajGd);
      }
      if (this.ajGe != null) {
        paramVarArgs.g(4, this.ajGe);
      }
      if (this.ajGf != null) {
        paramVarArgs.g(5, this.ajGf);
      }
      if (this.ajGg != null) {
        paramVarArgs.g(6, this.ajGg);
      }
      AppMethodBeat.o(91747);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MRI == null) {
        break label514;
      }
    }
    label514:
    for (int i = i.a.a.b.b.a.h(1, this.MRI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ajGc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ajGc);
      }
      i = paramInt;
      if (this.ajGd != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ajGd);
      }
      paramInt = i;
      if (this.ajGe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ajGe);
      }
      i = paramInt;
      if (this.ajGf != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ajGf);
      }
      paramInt = i;
      if (this.ajGg != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ajGg);
      }
      AppMethodBeat.o(91747);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91747);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91747);
          return -1;
        case 1: 
          locali.MRI = locala.ajGk.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 2: 
          locali.ajGc = locala.ajGk.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 3: 
          locali.ajGd = locala.ajGk.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 4: 
          locali.ajGe = locala.ajGk.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 5: 
          locali.ajGf = locala.ajGk.readString();
          AppMethodBeat.o(91747);
          return 0;
        }
        locali.ajGg = locala.ajGk.readString();
        AppMethodBeat.o(91747);
        return 0;
      }
      AppMethodBeat.o(91747);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     g.a.a.i
 * JD-Core Version:    0.7.0.1
 */