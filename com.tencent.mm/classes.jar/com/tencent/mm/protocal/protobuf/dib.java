package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dib
  extends cvw
{
  public String HNx;
  public long HNy;
  public long HOJ;
  public int HOK;
  public int HOP;
  public int HPo;
  public String Username;
  public int ucK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125835);
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
      if (this.Username != null) {
        paramVarArgs.d(3, this.Username);
      }
      paramVarArgs.aZ(4, this.HNy);
      paramVarArgs.aS(5, this.ucK);
      paramVarArgs.aZ(6, this.HOJ);
      paramVarArgs.aS(7, this.HOK);
      paramVarArgs.aS(8, this.HPo);
      paramVarArgs.aS(9, this.HOP);
      AppMethodBeat.o(125835);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HNx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HNx);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Username);
      }
      paramInt = f.a.a.b.b.a.p(4, this.HNy);
      int j = f.a.a.b.b.a.bz(5, this.ucK);
      int k = f.a.a.b.b.a.p(6, this.HOJ);
      int m = f.a.a.b.b.a.bz(7, this.HOK);
      int n = f.a.a.b.b.a.bz(8, this.HPo);
      int i1 = f.a.a.b.b.a.bz(9, this.HOP);
      AppMethodBeat.o(125835);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125835);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dib localdib = (dib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125835);
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
            localdib.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125835);
          return 0;
        case 2: 
          localdib.HNx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125835);
          return 0;
        case 3: 
          localdib.Username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125835);
          return 0;
        case 4: 
          localdib.HNy = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125835);
          return 0;
        case 5: 
          localdib.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125835);
          return 0;
        case 6: 
          localdib.HOJ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125835);
          return 0;
        case 7: 
          localdib.HOK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125835);
          return 0;
        case 8: 
          localdib.HPo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125835);
          return 0;
        }
        localdib.HOP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125835);
        return 0;
      }
      AppMethodBeat.o(125835);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dib
 * JD-Core Version:    0.7.0.1
 */