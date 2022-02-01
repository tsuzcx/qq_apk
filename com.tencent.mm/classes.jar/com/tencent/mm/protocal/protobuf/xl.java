package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class xl
  extends cvw
{
  public String Ggb;
  public int Gpm;
  public String fileid;
  public String md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9588);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fileid == null)
      {
        paramVarArgs = new b("Not all required fields were included: fileid");
        AppMethodBeat.o(9588);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(9588);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fileid != null) {
        paramVarArgs.d(2, this.fileid);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      if (this.Ggb != null) {
        paramVarArgs.d(4, this.Ggb);
      }
      paramVarArgs.aS(5, this.Gpm);
      AppMethodBeat.o(9588);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label645;
      }
    }
    label645:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fileid);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      paramInt = i;
      if (this.Ggb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ggb);
      }
      i = f.a.a.b.b.a.bz(5, this.Gpm);
      AppMethodBeat.o(9588);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.fileid == null)
        {
          paramVarArgs = new b("Not all required fields were included: fileid");
          AppMethodBeat.o(9588);
          throw paramVarArgs;
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(9588);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9588);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xl localxl = (xl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9588);
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
            localxl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9588);
          return 0;
        case 2: 
          localxl.fileid = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9588);
          return 0;
        case 3: 
          localxl.md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9588);
          return 0;
        case 4: 
          localxl.Ggb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9588);
          return 0;
        }
        localxl.Gpm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(9588);
        return 0;
      }
      AppMethodBeat.o(9588);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xl
 * JD-Core Version:    0.7.0.1
 */