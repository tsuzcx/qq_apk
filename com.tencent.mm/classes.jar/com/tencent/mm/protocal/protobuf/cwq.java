package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwq
  extends cvw
{
  public int CreateTime;
  public String FOR;
  public int HHv;
  public int HHw;
  public int HHx;
  public long HHy;
  public String uvF;
  public String uvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FOR != null) {
        paramVarArgs.d(2, this.FOR);
      }
      paramVarArgs.aS(3, this.HHv);
      paramVarArgs.aS(4, this.CreateTime);
      paramVarArgs.aS(5, this.HHw);
      if (this.uvG != null) {
        paramVarArgs.d(6, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(7, this.uvF);
      }
      paramVarArgs.aS(8, this.HHx);
      paramVarArgs.aZ(9, this.HHy);
      AppMethodBeat.o(32415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label733;
      }
    }
    label733:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FOR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FOR);
      }
      i = i + f.a.a.b.b.a.bz(3, this.HHv) + f.a.a.b.b.a.bz(4, this.CreateTime) + f.a.a.b.b.a.bz(5, this.HHw);
      paramInt = i;
      if (this.uvG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uvG);
      }
      i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.uvF);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.HHx);
      int j = f.a.a.b.b.a.p(9, this.HHy);
      AppMethodBeat.o(32415);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwq localcwq = (cwq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32415);
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
            localcwq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32415);
          return 0;
        case 2: 
          localcwq.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 3: 
          localcwq.HHv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32415);
          return 0;
        case 4: 
          localcwq.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32415);
          return 0;
        case 5: 
          localcwq.HHw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32415);
          return 0;
        case 6: 
          localcwq.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 7: 
          localcwq.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 8: 
          localcwq.HHx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32415);
          return 0;
        }
        localcwq.HHy = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(32415);
        return 0;
      }
      AppMethodBeat.o(32415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwq
 * JD-Core Version:    0.7.0.1
 */