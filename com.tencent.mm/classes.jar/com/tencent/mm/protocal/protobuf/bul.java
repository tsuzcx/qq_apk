package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bul
  extends cvp
{
  public int GOt;
  public int GOv;
  public LinkedList<buj> GOx;
  public LinkedList<buj> GOy;
  public String xbo;
  
  public bul()
  {
    AppMethodBeat.i(155436);
    this.GOx = new LinkedList();
    this.GOy = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xbo != null) {
        paramVarArgs.d(2, this.xbo);
      }
      paramVarArgs.aS(3, this.GOt);
      paramVarArgs.e(4, 8, this.GOx);
      paramVarArgs.aS(5, this.GOv);
      paramVarArgs.e(6, 8, this.GOy);
      AppMethodBeat.o(155437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xbo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xbo);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GOt);
      int j = f.a.a.a.c(4, 8, this.GOx);
      int k = f.a.a.b.b.a.bz(5, this.GOv);
      int m = f.a.a.a.c(6, 8, this.GOy);
      AppMethodBeat.o(155437);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GOx.clear();
        this.GOy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        bul localbul = (bul)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155437);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbul.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 2: 
          localbul.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155437);
          return 0;
        case 3: 
          localbul.GOt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155437);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbul.GOx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 5: 
          localbul.GOv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155437);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new buj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((buj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbul.GOy.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bul
 * JD-Core Version:    0.7.0.1
 */