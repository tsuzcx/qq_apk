package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class amf
  extends cwj
{
  public LinkedList<FinderCommentInfo> GEA;
  public long GEy;
  public FinderObject GEz;
  public String iqo;
  
  public amf()
  {
    AppMethodBeat.i(168943);
    this.GEA = new LinkedList();
    AppMethodBeat.o(168943);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168944);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168944);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.GEy);
      if (this.iqo != null) {
        paramVarArgs.d(3, this.iqo);
      }
      if (this.GEz != null)
      {
        paramVarArgs.lJ(4, this.GEz.computeSize());
        this.GEz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.GEA);
      AppMethodBeat.o(168944);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GEy);
      paramInt = i;
      if (this.iqo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.iqo);
      }
      i = paramInt;
      if (this.GEz != null) {
        i = paramInt + f.a.a.a.lI(4, this.GEz.computeSize());
      }
      paramInt = f.a.a.a.c(5, 8, this.GEA);
      AppMethodBeat.o(168944);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GEA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168944);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168944);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amf localamf = (amf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168944);
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
            localamf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168944);
          return 0;
        case 2: 
          localamf.GEy = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168944);
          return 0;
        case 3: 
          localamf.iqo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168944);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamf.GEz = ((FinderObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168944);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderCommentInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderCommentInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamf.GEA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168944);
        return 0;
      }
      AppMethodBeat.o(168944);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amf
 * JD-Core Version:    0.7.0.1
 */