package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wt
  extends cwj
{
  public LinkedList<wu> Gos;
  public String dqk;
  public String gRf;
  public int jsH;
  
  public wt()
  {
    AppMethodBeat.i(218193);
    this.Gos = new LinkedList();
    AppMethodBeat.o(218193);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218194);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Gos);
      if (this.dqk != null) {
        paramVarArgs.d(3, this.dqk);
      }
      paramVarArgs.aS(4, this.jsH);
      if (this.gRf != null) {
        paramVarArgs.d(5, this.gRf);
      }
      AppMethodBeat.o(218194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Gos);
      paramInt = i;
      if (this.dqk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dqk);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.jsH);
      paramInt = i;
      if (this.gRf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gRf);
      }
      AppMethodBeat.o(218194);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gos.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wt localwt = (wt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218194);
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
            localwt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218194);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwt.Gos.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218194);
          return 0;
        case 3: 
          localwt.dqk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218194);
          return 0;
        case 4: 
          localwt.jsH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218194);
          return 0;
        }
        localwt.gRf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(218194);
        return 0;
      }
      AppMethodBeat.o(218194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wt
 * JD-Core Version:    0.7.0.1
 */