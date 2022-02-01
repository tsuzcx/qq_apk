package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czr
  extends cwj
{
  public com.tencent.mm.bw.b GXK;
  public LinkedList<dun> GXL;
  public int GXM;
  public dup GuN;
  
  public czr()
  {
    AppMethodBeat.i(74667);
    this.GXL = new LinkedList();
    AppMethodBeat.o(74667);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(74668);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GuN != null)
      {
        paramVarArgs.lJ(2, this.GuN.computeSize());
        this.GuN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.GXL);
      if (this.GXK != null) {
        paramVarArgs.c(4, this.GXK);
      }
      paramVarArgs.aS(5, this.GXM);
      AppMethodBeat.o(74668);
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
      int i = paramInt;
      if (this.GuN != null) {
        i = paramInt + f.a.a.a.lI(2, this.GuN.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.GXL);
      paramInt = i;
      if (this.GXK != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GXK);
      }
      i = f.a.a.b.b.a.bz(5, this.GXM);
      AppMethodBeat.o(74668);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GXL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(74668);
          throw paramVarArgs;
        }
        AppMethodBeat.o(74668);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czr localczr = (czr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74668);
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
            localczr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74668);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dup();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dup)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczr.GuN = ((dup)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74668);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dun();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dun)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczr.GXL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74668);
          return 0;
        case 4: 
          localczr.GXK = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(74668);
          return 0;
        }
        localczr.GXM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(74668);
        return 0;
      }
      AppMethodBeat.o(74668);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czr
 * JD-Core Version:    0.7.0.1
 */