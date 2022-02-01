package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class td
  extends com.tencent.mm.bw.a
{
  public String Gje;
  public String Gjf;
  public String Gjg;
  public int Gjh;
  public String Gji;
  public ti Gjj;
  public String Gjk;
  public int Gjl;
  public int Gjm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gje != null) {
        paramVarArgs.d(1, this.Gje);
      }
      if (this.Gjf != null) {
        paramVarArgs.d(2, this.Gjf);
      }
      if (this.Gjg != null) {
        paramVarArgs.d(3, this.Gjg);
      }
      paramVarArgs.aS(4, this.Gjh);
      if (this.Gji != null) {
        paramVarArgs.d(5, this.Gji);
      }
      if (this.Gjj != null)
      {
        paramVarArgs.lJ(6, this.Gjj.computeSize());
        this.Gjj.writeFields(paramVarArgs);
      }
      if (this.Gjk != null) {
        paramVarArgs.d(7, this.Gjk);
      }
      paramVarArgs.aS(8, this.Gjl);
      paramVarArgs.aS(9, this.Gjm);
      AppMethodBeat.o(113959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gje == null) {
        break label754;
      }
    }
    label754:
    for (int i = f.a.a.b.b.a.e(1, this.Gje) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gjf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gjf);
      }
      i = paramInt;
      if (this.Gjg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gjg);
      }
      i += f.a.a.b.b.a.bz(4, this.Gjh);
      paramInt = i;
      if (this.Gji != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gji);
      }
      i = paramInt;
      if (this.Gjj != null) {
        i = paramInt + f.a.a.a.lI(6, this.Gjj.computeSize());
      }
      paramInt = i;
      if (this.Gjk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gjk);
      }
      i = f.a.a.b.b.a.bz(8, this.Gjl);
      int j = f.a.a.b.b.a.bz(9, this.Gjm);
      AppMethodBeat.o(113959);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        td localtd = (td)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113959);
          return -1;
        case 1: 
          localtd.Gje = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 2: 
          localtd.Gjf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 3: 
          localtd.Gjg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 4: 
          localtd.Gjh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113959);
          return 0;
        case 5: 
          localtd.Gji = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtd.Gjj = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113959);
          return 0;
        case 7: 
          localtd.Gjk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 8: 
          localtd.Gjl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113959);
          return 0;
        }
        localtd.Gjm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113959);
        return 0;
      }
      AppMethodBeat.o(113959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.td
 * JD-Core Version:    0.7.0.1
 */