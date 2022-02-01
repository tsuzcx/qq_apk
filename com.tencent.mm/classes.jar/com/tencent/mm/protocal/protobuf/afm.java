package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afm
  extends cvw
{
  public int FOQ;
  public String GvT;
  public int GvU;
  public int GvV;
  public String ikm;
  public String ikp;
  public String nIJ;
  public int nJA;
  public long xrk;
  public int xsB;
  public int xsC;
  public int xsD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9590);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      paramVarArgs.aS(3, this.FOQ);
      if (this.ikp != null) {
        paramVarArgs.d(4, this.ikp);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(5, this.nIJ);
      }
      paramVarArgs.aS(6, this.xsB);
      paramVarArgs.aS(7, this.xsC);
      paramVarArgs.aS(8, this.xsD);
      if (this.GvT != null) {
        paramVarArgs.d(9, this.GvT);
      }
      paramVarArgs.aS(10, this.GvU);
      paramVarArgs.aS(11, this.nJA);
      paramVarArgs.aS(12, this.GvV);
      paramVarArgs.aZ(13, this.xrk);
      AppMethodBeat.o(9590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label941;
      }
    }
    label941:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ikm);
      }
      i += f.a.a.b.b.a.bz(3, this.FOQ);
      paramInt = i;
      if (this.ikp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ikp);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nIJ);
      }
      i = i + f.a.a.b.b.a.bz(6, this.xsB) + f.a.a.b.b.a.bz(7, this.xsC) + f.a.a.b.b.a.bz(8, this.xsD);
      paramInt = i;
      if (this.GvT != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GvT);
      }
      i = f.a.a.b.b.a.bz(10, this.GvU);
      int j = f.a.a.b.b.a.bz(11, this.nJA);
      int k = f.a.a.b.b.a.bz(12, this.GvV);
      int m = f.a.a.b.b.a.p(13, this.xrk);
      AppMethodBeat.o(9590);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(9590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afm localafm = (afm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9590);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9590);
          return 0;
        case 2: 
          localafm.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 3: 
          localafm.FOQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 4: 
          localafm.ikp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 5: 
          localafm.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 6: 
          localafm.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 7: 
          localafm.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 8: 
          localafm.xsD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 9: 
          localafm.GvT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 10: 
          localafm.GvU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 11: 
          localafm.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 12: 
          localafm.GvV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(9590);
          return 0;
        }
        localafm.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(9590);
        return 0;
      }
      AppMethodBeat.o(9590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afm
 * JD-Core Version:    0.7.0.1
 */