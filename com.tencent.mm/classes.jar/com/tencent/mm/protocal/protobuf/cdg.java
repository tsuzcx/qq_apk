package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cdg
  extends cvw
{
  public b GTq;
  public int HpH;
  public int HpI;
  public b HpJ;
  public int HpK;
  public String HpL;
  public String HpM;
  public String HpN;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120957);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HpH);
      paramVarArgs.aS(3, this.HpI);
      if (this.HpJ != null) {
        paramVarArgs.c(4, this.HpJ);
      }
      paramVarArgs.aS(5, this.HpK);
      if (this.GTq != null) {
        paramVarArgs.c(6, this.GTq);
      }
      if (this.HpL != null) {
        paramVarArgs.d(7, this.HpL);
      }
      if (this.HpM != null) {
        paramVarArgs.d(8, this.HpM);
      }
      if (this.HpN != null) {
        paramVarArgs.d(9, this.HpN);
      }
      paramVarArgs.aS(10, this.Scene);
      AppMethodBeat.o(120957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HpH) + f.a.a.b.b.a.bz(3, this.HpI);
      paramInt = i;
      if (this.HpJ != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.HpJ);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HpK);
      paramInt = i;
      if (this.GTq != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.GTq);
      }
      i = paramInt;
      if (this.HpL != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HpL);
      }
      paramInt = i;
      if (this.HpM != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HpM);
      }
      i = paramInt;
      if (this.HpN != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HpN);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.Scene);
      AppMethodBeat.o(120957);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(120957);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdg localcdg = (cdg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120957);
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
            localcdg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120957);
          return 0;
        case 2: 
          localcdg.HpH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(120957);
          return 0;
        case 3: 
          localcdg.HpI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(120957);
          return 0;
        case 4: 
          localcdg.HpJ = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(120957);
          return 0;
        case 5: 
          localcdg.HpK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(120957);
          return 0;
        case 6: 
          localcdg.GTq = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(120957);
          return 0;
        case 7: 
          localcdg.HpL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 8: 
          localcdg.HpM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 9: 
          localcdg.HpN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(120957);
          return 0;
        }
        localcdg.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(120957);
        return 0;
      }
      AppMethodBeat.o(120957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdg
 * JD-Core Version:    0.7.0.1
 */