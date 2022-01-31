package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bv.a
{
  public String CLT;
  public String CLU;
  public String CLV;
  public String CLW;
  public String CLX;
  public String pvi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(57012);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pvi != null) {
        paramVarArgs.e(1, this.pvi);
      }
      if (this.CLT != null) {
        paramVarArgs.e(2, this.CLT);
      }
      if (this.CLU != null) {
        paramVarArgs.e(3, this.CLU);
      }
      if (this.CLV != null) {
        paramVarArgs.e(4, this.CLV);
      }
      if (this.CLW != null) {
        paramVarArgs.e(5, this.CLW);
      }
      if (this.CLX != null) {
        paramVarArgs.e(6, this.CLX);
      }
      AppMethodBeat.o(57012);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pvi == null) {
        break label518;
      }
    }
    label518:
    for (int i = e.a.a.b.b.a.f(1, this.pvi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CLT != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.CLT);
      }
      i = paramInt;
      if (this.CLU != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.CLU);
      }
      paramInt = i;
      if (this.CLV != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.CLV);
      }
      i = paramInt;
      if (this.CLW != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.CLW);
      }
      paramInt = i;
      if (this.CLX != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.CLX);
      }
      AppMethodBeat.o(57012);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(57012);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(57012);
          return -1;
        case 1: 
          locali.pvi = locala.CLY.readString();
          AppMethodBeat.o(57012);
          return 0;
        case 2: 
          locali.CLT = locala.CLY.readString();
          AppMethodBeat.o(57012);
          return 0;
        case 3: 
          locali.CLU = locala.CLY.readString();
          AppMethodBeat.o(57012);
          return 0;
        case 4: 
          locali.CLV = locala.CLY.readString();
          AppMethodBeat.o(57012);
          return 0;
        case 5: 
          locali.CLW = locala.CLY.readString();
          AppMethodBeat.o(57012);
          return 0;
        }
        locali.CLX = locala.CLY.readString();
        AppMethodBeat.o(57012);
        return 0;
      }
      AppMethodBeat.o(57012);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.a.a.i
 * JD-Core Version:    0.7.0.1
 */