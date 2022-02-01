package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkz
  extends cvw
{
  public String FNj;
  public String HNx;
  public long HNy;
  public long HOJ;
  public int HOK;
  public long HSD;
  public String nIJ;
  public int ucK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HNx != null) {
        paramVarArgs.d(2, this.HNx);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(3, this.nIJ);
      }
      paramVarArgs.aZ(4, this.HNy);
      paramVarArgs.aZ(5, this.HOJ);
      paramVarArgs.aS(6, this.HOK);
      paramVarArgs.aZ(7, this.HSD);
      paramVarArgs.aS(8, this.ucK);
      if (this.FNj != null) {
        paramVarArgs.d(9, this.FNj);
      }
      AppMethodBeat.o(118476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label710;
      }
    }
    label710:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HNx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HNx);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nIJ);
      }
      i = i + f.a.a.b.b.a.p(4, this.HNy) + f.a.a.b.b.a.p(5, this.HOJ) + f.a.a.b.b.a.bz(6, this.HOK) + f.a.a.b.b.a.p(7, this.HSD) + f.a.a.b.b.a.bz(8, this.ucK);
      paramInt = i;
      if (this.FNj != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FNj);
      }
      AppMethodBeat.o(118476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(118476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkz localdkz = (dkz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118476);
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
            localdkz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118476);
          return 0;
        case 2: 
          localdkz.HNx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118476);
          return 0;
        case 3: 
          localdkz.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118476);
          return 0;
        case 4: 
          localdkz.HNy = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(118476);
          return 0;
        case 5: 
          localdkz.HOJ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(118476);
          return 0;
        case 6: 
          localdkz.HOK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118476);
          return 0;
        case 7: 
          localdkz.HSD = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(118476);
          return 0;
        case 8: 
          localdkz.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118476);
          return 0;
        }
        localdkz.FNj = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(118476);
        return 0;
      }
      AppMethodBeat.o(118476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkz
 * JD-Core Version:    0.7.0.1
 */