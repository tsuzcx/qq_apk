package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ce
  extends cvw
{
  public b FNc;
  public int FNd;
  public String dwb;
  public String fileid;
  public String nickname;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.FNc != null) {
        paramVarArgs.c(3, this.FNc);
      }
      if (this.fileid != null) {
        paramVarArgs.d(4, this.fileid);
      }
      paramVarArgs.aS(5, this.FNd);
      if (this.dwb != null) {
        paramVarArgs.d(6, this.dwb);
      }
      AppMethodBeat.o(152481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.FNc != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.FNc);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fileid);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FNd);
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dwb);
      }
      AppMethodBeat.o(152481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ce localce = (ce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152481);
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
            localce.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152481);
          return 0;
        case 2: 
          localce.nickname = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 3: 
          localce.FNc = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(152481);
          return 0;
        case 4: 
          localce.fileid = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 5: 
          localce.FNd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152481);
          return 0;
        }
        localce.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152481);
        return 0;
      }
      AppMethodBeat.o(152481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ce
 * JD-Core Version:    0.7.0.1
 */