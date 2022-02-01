package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmo
  extends cvw
{
  public String CPZ;
  public int HyA;
  public String HyB;
  public int Hyx;
  public int Hyy;
  public in Hyz;
  public int uIM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91624);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hyx);
      paramVarArgs.aS(3, this.Hyy);
      if (this.Hyz != null)
      {
        paramVarArgs.lJ(4, this.Hyz.computeSize());
        this.Hyz.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.uIM);
      paramVarArgs.aS(6, this.HyA);
      if (this.HyB != null) {
        paramVarArgs.d(7, this.HyB);
      }
      if (this.CPZ != null) {
        paramVarArgs.d(100, this.CPZ);
      }
      AppMethodBeat.o(91624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hyx) + f.a.a.b.b.a.bz(3, this.Hyy);
      paramInt = i;
      if (this.Hyz != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hyz.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.uIM) + f.a.a.b.b.a.bz(6, this.HyA);
      paramInt = i;
      if (this.HyB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HyB);
      }
      i = paramInt;
      if (this.CPZ != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.CPZ);
      }
      AppMethodBeat.o(91624);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmo localcmo = (cmo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91624);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 2: 
          localcmo.Hyx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91624);
          return 0;
        case 3: 
          localcmo.Hyy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91624);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new in();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((in)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmo.Hyz = ((in)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 5: 
          localcmo.uIM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91624);
          return 0;
        case 6: 
          localcmo.HyA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91624);
          return 0;
        case 7: 
          localcmo.HyB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91624);
          return 0;
        }
        localcmo.CPZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91624);
        return 0;
      }
      AppMethodBeat.o(91624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmo
 * JD-Core Version:    0.7.0.1
 */