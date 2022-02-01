package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alv
  extends cwj
{
  public FinderContact GEh;
  public String GEi;
  public String GEj;
  public chl entranceInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189304);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GEh != null)
      {
        paramVarArgs.lJ(2, this.GEh.computeSize());
        this.GEh.writeFields(paramVarArgs);
      }
      if (this.GEi != null) {
        paramVarArgs.d(3, this.GEi);
      }
      if (this.GEj != null) {
        paramVarArgs.d(4, this.GEj);
      }
      if (this.entranceInfo != null)
      {
        paramVarArgs.lJ(5, this.entranceInfo.computeSize());
        this.entranceInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(189304);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GEh != null) {
        paramInt = i + f.a.a.a.lI(2, this.GEh.computeSize());
      }
      i = paramInt;
      if (this.GEi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GEi);
      }
      paramInt = i;
      if (this.GEj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GEj);
      }
      i = paramInt;
      if (this.entranceInfo != null) {
        i = paramInt + f.a.a.a.lI(5, this.entranceInfo.computeSize());
      }
      AppMethodBeat.o(189304);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189304);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        alv localalv = (alv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189304);
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
            localalv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189304);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalv.GEh = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189304);
          return 0;
        case 3: 
          localalv.GEi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189304);
          return 0;
        case 4: 
          localalv.GEj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189304);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalv.entranceInfo = ((chl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189304);
        return 0;
      }
      AppMethodBeat.o(189304);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alv
 * JD-Core Version:    0.7.0.1
 */