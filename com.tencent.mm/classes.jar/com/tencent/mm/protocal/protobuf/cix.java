package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cix
  extends com.tencent.mm.bw.a
{
  public String FQl;
  public int GWA;
  public String Gdj;
  public buh HkU;
  public String Hvs;
  public String Hvt;
  public int Hvu;
  public int Hvv;
  public int Scene;
  public int uuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117889);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gdj != null) {
        paramVarArgs.d(1, this.Gdj);
      }
      if (this.HkU != null)
      {
        paramVarArgs.lJ(2, this.HkU.computeSize());
        this.HkU.writeFields(paramVarArgs);
      }
      if (this.FQl != null) {
        paramVarArgs.d(3, this.FQl);
      }
      if (this.Hvt != null) {
        paramVarArgs.d(4, this.Hvt);
      }
      if (this.Hvs != null) {
        paramVarArgs.d(5, this.Hvs);
      }
      paramVarArgs.aS(6, this.Hvu);
      paramVarArgs.aS(7, this.GWA);
      paramVarArgs.aS(8, this.Hvv);
      paramVarArgs.aS(9, this.Scene);
      paramVarArgs.aS(10, this.uuz);
      AppMethodBeat.o(117889);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gdj == null) {
        break label790;
      }
    }
    label790:
    for (int i = f.a.a.b.b.a.e(1, this.Gdj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HkU != null) {
        paramInt = i + f.a.a.a.lI(2, this.HkU.computeSize());
      }
      i = paramInt;
      if (this.FQl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FQl);
      }
      paramInt = i;
      if (this.Hvt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hvt);
      }
      i = paramInt;
      if (this.Hvs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hvs);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Hvu);
      int j = f.a.a.b.b.a.bz(7, this.GWA);
      int k = f.a.a.b.b.a.bz(8, this.Hvv);
      int m = f.a.a.b.b.a.bz(9, this.Scene);
      int n = f.a.a.b.b.a.bz(10, this.uuz);
      AppMethodBeat.o(117889);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117889);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cix localcix = (cix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117889);
          return -1;
        case 1: 
          localcix.Gdj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((buh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcix.HkU = ((buh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117889);
          return 0;
        case 3: 
          localcix.FQl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 4: 
          localcix.Hvt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 5: 
          localcix.Hvs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 6: 
          localcix.Hvu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117889);
          return 0;
        case 7: 
          localcix.GWA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117889);
          return 0;
        case 8: 
          localcix.Hvv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117889);
          return 0;
        case 9: 
          localcix.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117889);
          return 0;
        }
        localcix.uuz = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117889);
        return 0;
      }
      AppMethodBeat.o(117889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cix
 * JD-Core Version:    0.7.0.1
 */