package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dik
  extends cvw
{
  public int HPA;
  public String HPC;
  public String HPD;
  public String HPE;
  public int HPz;
  public String dxK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(130919);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HPD != null) {
        paramVarArgs.d(2, this.HPD);
      }
      if (this.HPC != null) {
        paramVarArgs.d(3, this.HPC);
      }
      if (this.HPE != null) {
        paramVarArgs.d(4, this.HPE);
      }
      if (this.dxK != null) {
        paramVarArgs.d(5, this.dxK);
      }
      paramVarArgs.aS(6, this.HPz);
      paramVarArgs.aS(7, this.HPA);
      AppMethodBeat.o(130919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HPD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HPD);
      }
      i = paramInt;
      if (this.HPC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HPC);
      }
      paramInt = i;
      if (this.HPE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HPE);
      }
      i = paramInt;
      if (this.dxK != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dxK);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.HPz);
      int j = f.a.a.b.b.a.bz(7, this.HPA);
      AppMethodBeat.o(130919);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(130919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dik localdik = (dik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(130919);
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
            localdik.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(130919);
          return 0;
        case 2: 
          localdik.HPD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 3: 
          localdik.HPC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 4: 
          localdik.HPE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 5: 
          localdik.dxK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 6: 
          localdik.HPz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(130919);
          return 0;
        }
        localdik.HPA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(130919);
        return 0;
      }
      AppMethodBeat.o(130919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dik
 * JD-Core Version:    0.7.0.1
 */