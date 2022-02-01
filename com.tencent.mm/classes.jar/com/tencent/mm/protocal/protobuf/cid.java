package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cid
  extends com.tencent.mm.bx.a
{
  public int FAh;
  public String FKK;
  public String FxN;
  public int GDa;
  public btn GRt;
  public String HbS;
  public String HbT;
  public int HbU;
  public int HbV;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117889);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FKK != null) {
        paramVarArgs.d(1, this.FKK);
      }
      if (this.GRt != null)
      {
        paramVarArgs.lC(2, this.GRt.computeSize());
        this.GRt.writeFields(paramVarArgs);
      }
      if (this.FxN != null) {
        paramVarArgs.d(3, this.FxN);
      }
      if (this.HbT != null) {
        paramVarArgs.d(4, this.HbT);
      }
      if (this.HbS != null) {
        paramVarArgs.d(5, this.HbS);
      }
      paramVarArgs.aS(6, this.HbU);
      paramVarArgs.aS(7, this.GDa);
      paramVarArgs.aS(8, this.HbV);
      paramVarArgs.aS(9, this.Scene);
      paramVarArgs.aS(10, this.FAh);
      AppMethodBeat.o(117889);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FKK == null) {
        break label790;
      }
    }
    label790:
    for (int i = f.a.a.b.b.a.e(1, this.FKK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GRt != null) {
        paramInt = i + f.a.a.a.lB(2, this.GRt.computeSize());
      }
      i = paramInt;
      if (this.FxN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FxN);
      }
      paramInt = i;
      if (this.HbT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HbT);
      }
      i = paramInt;
      if (this.HbS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HbS);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.HbU);
      int j = f.a.a.b.b.a.bz(7, this.GDa);
      int k = f.a.a.b.b.a.bz(8, this.HbV);
      int m = f.a.a.b.b.a.bz(9, this.Scene);
      int n = f.a.a.b.b.a.bz(10, this.FAh);
      AppMethodBeat.o(117889);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117889);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cid localcid = (cid)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117889);
          return -1;
        case 1: 
          localcid.FKK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((btn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcid.GRt = ((btn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117889);
          return 0;
        case 3: 
          localcid.FxN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 4: 
          localcid.HbT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 5: 
          localcid.HbS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 6: 
          localcid.HbU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117889);
          return 0;
        case 7: 
          localcid.GDa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117889);
          return 0;
        case 8: 
          localcid.HbV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117889);
          return 0;
        case 9: 
          localcid.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117889);
          return 0;
        }
        localcid.FAh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117889);
        return 0;
      }
      AppMethodBeat.o(117889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cid
 * JD-Core Version:    0.7.0.1
 */