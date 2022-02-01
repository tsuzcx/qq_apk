package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akt
  extends com.tencent.mm.bx.a
{
  public LinkedList<aku> FLh;
  public String FUv;
  public String Gke;
  public long Gkf;
  public long Gkg;
  public String Gkh;
  public long Gki;
  public String xXz;
  
  public akt()
  {
    AppMethodBeat.i(91458);
    this.FLh = new LinkedList();
    AppMethodBeat.o(91458);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gke != null) {
        paramVarArgs.d(1, this.Gke);
      }
      paramVarArgs.e(2, 8, this.FLh);
      paramVarArgs.aY(3, this.Gkf);
      paramVarArgs.aY(4, this.Gkg);
      if (this.Gkh != null) {
        paramVarArgs.d(5, this.Gkh);
      }
      if (this.xXz != null) {
        paramVarArgs.d(6, this.xXz);
      }
      paramVarArgs.aY(7, this.Gki);
      if (this.FUv != null) {
        paramVarArgs.d(8, this.FUv);
      }
      AppMethodBeat.o(91459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gke == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gke) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FLh) + f.a.a.b.b.a.p(3, this.Gkf) + f.a.a.b.b.a.p(4, this.Gkg);
      paramInt = i;
      if (this.Gkh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gkh);
      }
      i = paramInt;
      if (this.xXz != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.xXz);
      }
      i += f.a.a.b.b.a.p(7, this.Gki);
      paramInt = i;
      if (this.FUv != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FUv);
      }
      AppMethodBeat.o(91459);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FLh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akt localakt = (akt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91459);
          return -1;
        case 1: 
          localakt.Gke = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aku();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aku)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakt.FLh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91459);
          return 0;
        case 3: 
          localakt.Gkf = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91459);
          return 0;
        case 4: 
          localakt.Gkg = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91459);
          return 0;
        case 5: 
          localakt.Gkh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 6: 
          localakt.xXz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 7: 
          localakt.Gki = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91459);
          return 0;
        }
        localakt.FUv = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91459);
        return 0;
      }
      AppMethodBeat.o(91459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akt
 * JD-Core Version:    0.7.0.1
 */