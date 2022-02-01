package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bw.a
{
  public String OmO;
  public String OmP;
  public String OmQ;
  public String OmR;
  public String OmS;
  public String xcF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91747);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xcF != null) {
        paramVarArgs.d(1, this.xcF);
      }
      if (this.OmO != null) {
        paramVarArgs.d(2, this.OmO);
      }
      if (this.OmP != null) {
        paramVarArgs.d(3, this.OmP);
      }
      if (this.OmQ != null) {
        paramVarArgs.d(4, this.OmQ);
      }
      if (this.OmR != null) {
        paramVarArgs.d(5, this.OmR);
      }
      if (this.OmS != null) {
        paramVarArgs.d(6, this.OmS);
      }
      AppMethodBeat.o(91747);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xcF == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.xcF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.OmO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.OmO);
      }
      i = paramInt;
      if (this.OmP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.OmP);
      }
      paramInt = i;
      if (this.OmQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.OmQ);
      }
      i = paramInt;
      if (this.OmR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.OmR);
      }
      paramInt = i;
      if (this.OmS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.OmS);
      }
      AppMethodBeat.o(91747);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          locali.xcF = locala.OmT.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 2: 
          locali.OmO = locala.OmT.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 3: 
          locali.OmP = locala.OmT.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 4: 
          locali.OmQ = locala.OmT.readString();
          AppMethodBeat.o(91747);
          return 0;
        case 5: 
          locali.OmR = locala.OmT.readString();
          AppMethodBeat.o(91747);
          return 0;
        }
        locali.OmS = locala.OmT.readString();
        AppMethodBeat.o(91747);
        return 0;
      }
      AppMethodBeat.o(91747);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     e.a.a.i
 * JD-Core Version:    0.7.0.1
 */