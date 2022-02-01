package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blq
  extends cwj
{
  public int CellCount;
  public LinkedList<ebz> CellList;
  public String GYE;
  public String GYG;
  public int GYH;
  public String GYI;
  public String GYJ;
  public String GYK;
  
  public blq()
  {
    AppMethodBeat.i(32305);
    this.CellList = new LinkedList();
    AppMethodBeat.o(32305);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32306);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32306);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.CellCount);
      paramVarArgs.e(3, 8, this.CellList);
      if (this.GYG != null) {
        paramVarArgs.d(4, this.GYG);
      }
      if (this.GYE != null) {
        paramVarArgs.d(5, this.GYE);
      }
      paramVarArgs.aS(6, this.GYH);
      if (this.GYI != null) {
        paramVarArgs.d(7, this.GYI);
      }
      if (this.GYJ != null) {
        paramVarArgs.d(8, this.GYJ);
      }
      if (this.GYK != null) {
        paramVarArgs.d(9, this.GYK);
      }
      AppMethodBeat.o(32306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label909;
      }
    }
    label909:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.CellCount) + f.a.a.a.c(3, 8, this.CellList);
      paramInt = i;
      if (this.GYG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GYG);
      }
      i = paramInt;
      if (this.GYE != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GYE);
      }
      i += f.a.a.b.b.a.bz(6, this.GYH);
      paramInt = i;
      if (this.GYI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GYI);
      }
      i = paramInt;
      if (this.GYJ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GYJ);
      }
      paramInt = i;
      if (this.GYK != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GYK);
      }
      AppMethodBeat.o(32306);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CellList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32306);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32306);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blq localblq = (blq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32306);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 2: 
          localblq.CellCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32306);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblq.CellList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 4: 
          localblq.GYG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 5: 
          localblq.GYE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 6: 
          localblq.GYH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32306);
          return 0;
        case 7: 
          localblq.GYI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 8: 
          localblq.GYJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32306);
          return 0;
        }
        localblq.GYK = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32306);
        return 0;
      }
      AppMethodBeat.o(32306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blq
 * JD-Core Version:    0.7.0.1
 */