package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bv.a
{
  public String CLP;
  public String CLQ;
  public String CLR;
  public String CLS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(141138);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.CLP != null) {
        paramVarArgs.e(1, this.CLP);
      }
      if (this.CLQ != null) {
        paramVarArgs.e(2, this.CLQ);
      }
      if (this.CLR != null) {
        paramVarArgs.e(3, this.CLR);
      }
      if (this.CLS != null) {
        paramVarArgs.e(4, this.CLS);
      }
      AppMethodBeat.o(141138);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLP == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.CLP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CLQ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.CLQ);
      }
      i = paramInt;
      if (this.CLR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.CLR);
      }
      paramInt = i;
      if (this.CLS != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.CLS);
      }
      AppMethodBeat.o(141138);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(141138);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(141138);
          return -1;
        case 1: 
          localh.CLP = locala.CLY.readString();
          AppMethodBeat.o(141138);
          return 0;
        case 2: 
          localh.CLQ = locala.CLY.readString();
          AppMethodBeat.o(141138);
          return 0;
        case 3: 
          localh.CLR = locala.CLY.readString();
          AppMethodBeat.o(141138);
          return 0;
        }
        localh.CLS = locala.CLY.readString();
        AppMethodBeat.o(141138);
        return 0;
      }
      AppMethodBeat.o(141138);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     d.a.a.h
 * JD-Core Version:    0.7.0.1
 */