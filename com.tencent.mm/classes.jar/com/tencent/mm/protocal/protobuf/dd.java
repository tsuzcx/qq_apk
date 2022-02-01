package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dd
  extends cvw
{
  public int COB;
  public String COw;
  public String FNW;
  public long dPq;
  public String dlT;
  public int fMJ;
  public String wSp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91346);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.dPq);
      if (this.dlT != null) {
        paramVarArgs.d(3, this.dlT);
      }
      if (this.wSp != null) {
        paramVarArgs.d(4, this.wSp);
      }
      if (this.COw != null) {
        paramVarArgs.d(5, this.COw);
      }
      paramVarArgs.aS(6, this.fMJ);
      if (this.FNW != null) {
        paramVarArgs.d(7, this.FNW);
      }
      paramVarArgs.aS(8, this.COB);
      AppMethodBeat.o(91346);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.dPq);
      paramInt = i;
      if (this.dlT != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dlT);
      }
      i = paramInt;
      if (this.wSp != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.wSp);
      }
      paramInt = i;
      if (this.COw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.COw);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.fMJ);
      paramInt = i;
      if (this.FNW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FNW);
      }
      i = f.a.a.b.b.a.bz(8, this.COB);
      AppMethodBeat.o(91346);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91346);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dd localdd = (dd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91346);
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
            localdd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91346);
          return 0;
        case 2: 
          localdd.dPq = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91346);
          return 0;
        case 3: 
          localdd.dlT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91346);
          return 0;
        case 4: 
          localdd.wSp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91346);
          return 0;
        case 5: 
          localdd.COw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91346);
          return 0;
        case 6: 
          localdd.fMJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91346);
          return 0;
        case 7: 
          localdd.FNW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91346);
          return 0;
        }
        localdd.COB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91346);
        return 0;
      }
      AppMethodBeat.o(91346);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dd
 * JD-Core Version:    0.7.0.1
 */