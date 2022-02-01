package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class akk
  extends cqk
{
  public long EEF;
  public LinkedList<ajs> EEG;
  public int continueFlag;
  public LinkedList<FinderContact> rHC;
  public b rmJ;
  
  public akk()
  {
    AppMethodBeat.i(168977);
    this.rHC = new LinkedList();
    this.EEG = new LinkedList();
    AppMethodBeat.o(168977);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168978);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.rHC);
      paramVarArgs.aR(3, this.continueFlag);
      paramVarArgs.aO(4, this.EEF);
      if (this.rmJ != null) {
        paramVarArgs.c(5, this.rmJ);
      }
      paramVarArgs.e(6, 8, this.EEG);
      AppMethodBeat.o(168978);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.rHC) + f.a.a.b.b.a.bx(3, this.continueFlag) + f.a.a.b.b.a.p(4, this.EEF);
      paramInt = i;
      if (this.rmJ != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.rmJ);
      }
      i = f.a.a.a.c(6, 8, this.EEG);
      AppMethodBeat.o(168978);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rHC.clear();
        this.EEG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168978);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akk localakk = (akk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168978);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168978);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakk.rHC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168978);
          return 0;
        case 3: 
          localakk.continueFlag = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168978);
          return 0;
        case 4: 
          localakk.EEF = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168978);
          return 0;
        case 5: 
          localakk.rmJ = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(168978);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ajs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ajs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakk.EEG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168978);
        return 0;
      }
      AppMethodBeat.o(168978);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akk
 * JD-Core Version:    0.7.0.1
 */