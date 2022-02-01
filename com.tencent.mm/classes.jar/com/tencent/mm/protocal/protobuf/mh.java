package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mh
  extends cvw
{
  public int FTU;
  public long FXP;
  public String FXQ;
  public String FXR;
  public long FXv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188917);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.FXP);
      if (this.FXQ != null) {
        paramVarArgs.d(4, this.FXQ);
      }
      if (this.FXR != null) {
        paramVarArgs.d(5, this.FXR);
      }
      paramVarArgs.aZ(18, this.FXv);
      paramVarArgs.aS(22, this.FTU);
      AppMethodBeat.o(188917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.FXP);
      paramInt = i;
      if (this.FXQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FXQ);
      }
      i = paramInt;
      if (this.FXR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FXR);
      }
      paramInt = f.a.a.b.b.a.p(18, this.FXv);
      int j = f.a.a.b.b.a.bz(22, this.FTU);
      AppMethodBeat.o(188917);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(188917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mh localmh = (mh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(188917);
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
            localmh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188917);
          return 0;
        case 2: 
          localmh.FXP = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(188917);
          return 0;
        case 4: 
          localmh.FXQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188917);
          return 0;
        case 5: 
          localmh.FXR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188917);
          return 0;
        case 18: 
          localmh.FXv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(188917);
          return 0;
        }
        localmh.FTU = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(188917);
        return 0;
      }
      AppMethodBeat.o(188917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mh
 * JD-Core Version:    0.7.0.1
 */