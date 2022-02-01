package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjt
  extends ckq
{
  public String CIE;
  public cjn EeO;
  public ckj EeP;
  public LinkedList<String> EmotionList;
  public int mBH;
  
  public cjt()
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.mBH);
      if (this.EeO != null)
      {
        paramVarArgs.kX(3, this.EeO.computeSize());
        this.EeO.writeFields(paramVarArgs);
      }
      if (this.EeP != null)
      {
        paramVarArgs.kX(4, this.EeP.computeSize());
        this.EeP.writeFields(paramVarArgs);
      }
      if (this.CIE != null) {
        paramVarArgs.d(5, this.CIE);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBH);
      paramInt = i;
      if (this.EeO != null) {
        paramInt = i + f.a.a.a.kW(3, this.EeO.computeSize());
      }
      i = paramInt;
      if (this.EeP != null) {
        i = paramInt + f.a.a.a.kW(4, this.EeP.computeSize());
      }
      paramInt = i;
      if (this.CIE != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CIE);
      }
      i = f.a.a.a.c(6, 1, this.EmotionList);
      AppMethodBeat.o(115965);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmotionList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(115965);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjt localcjt = (cjt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115965);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjt.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 2: 
          localcjt.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115965);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjt.EeO = ((cjn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjt.EeP = ((ckj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 5: 
          localcjt.CIE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115965);
          return 0;
        }
        localcjt.EmotionList.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(115965);
        return 0;
      }
      AppMethodBeat.o(115965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjt
 * JD-Core Version:    0.7.0.1
 */