package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bvf
  extends cwj
{
  public int HhT;
  public int HhV;
  public LinkedList<bvd> HhX;
  public LinkedList<bvd> HhY;
  public String xrf;
  
  public bvf()
  {
    AppMethodBeat.i(155436);
    this.HhX = new LinkedList();
    this.HhY = new LinkedList();
    AppMethodBeat.o(155436);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xrf != null) {
        paramVarArgs.d(2, this.xrf);
      }
      paramVarArgs.aS(3, this.HhT);
      paramVarArgs.e(4, 8, this.HhX);
      paramVarArgs.aS(5, this.HhV);
      paramVarArgs.e(6, 8, this.HhY);
      AppMethodBeat.o(155437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xrf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xrf);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HhT);
      int j = f.a.a.a.c(4, 8, this.HhX);
      int k = f.a.a.b.b.a.bz(5, this.HhV);
      int m = f.a.a.a.c(6, 8, this.HhY);
      AppMethodBeat.o(155437);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HhX.clear();
        this.HhY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvf localbvf = (bvf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155437);
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
            localbvf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 2: 
          localbvf.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155437);
          return 0;
        case 3: 
          localbvf.HhT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155437);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvf.HhX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 5: 
          localbvf.HhV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155437);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvf.HhY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155437);
        return 0;
      }
      AppMethodBeat.o(155437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvf
 * JD-Core Version:    0.7.0.1
 */