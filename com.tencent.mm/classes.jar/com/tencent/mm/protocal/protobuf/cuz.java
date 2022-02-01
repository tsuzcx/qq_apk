package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuz
  extends cvw
{
  public LinkedList<String> EmotionList;
  public String FZl;
  public cut HFD;
  public cvp HFE;
  public int nJA;
  
  public cuz()
  {
    AppMethodBeat.i(115964);
    this.EmotionList = new LinkedList();
    AppMethodBeat.o(115964);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nJA);
      if (this.HFD != null)
      {
        paramVarArgs.lJ(3, this.HFD.computeSize());
        this.HFD.writeFields(paramVarArgs);
      }
      if (this.HFE != null)
      {
        paramVarArgs.lJ(4, this.HFE.computeSize());
        this.HFE.writeFields(paramVarArgs);
      }
      if (this.FZl != null) {
        paramVarArgs.d(5, this.FZl);
      }
      paramVarArgs.e(6, 1, this.EmotionList);
      AppMethodBeat.o(115965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJA);
      paramInt = i;
      if (this.HFD != null) {
        paramInt = i + f.a.a.a.lI(3, this.HFD.computeSize());
      }
      i = paramInt;
      if (this.HFE != null) {
        i = paramInt + f.a.a.a.lI(4, this.HFE.computeSize());
      }
      paramInt = i;
      if (this.FZl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FZl);
      }
      i = f.a.a.a.c(6, 1, this.EmotionList);
      AppMethodBeat.o(115965);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmotionList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(115965);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cuz localcuz = (cuz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115965);
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
            localcuz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 2: 
          localcuz.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115965);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cut();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cut)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuz.HFD = ((cut)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuz.HFE = ((cvp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 5: 
          localcuz.FZl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115965);
          return 0;
        }
        localcuz.EmotionList.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(115965);
        return 0;
      }
      AppMethodBeat.o(115965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuz
 * JD-Core Version:    0.7.0.1
 */