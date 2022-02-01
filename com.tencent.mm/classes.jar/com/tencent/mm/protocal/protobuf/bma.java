package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bma
  extends cld
{
  public int DJu;
  public int DJw;
  public LinkedList<bly> DJy;
  public LinkedList<bly> DJz;
  public String Ddo;
  
  public bma()
  {
    AppMethodBeat.i(155436);
    this.DJy = new LinkedList();
    this.DJz = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ddo != null) {
        paramVarArgs.d(2, this.Ddo);
      }
      paramVarArgs.aR(3, this.DJu);
      paramVarArgs.e(4, 8, this.DJy);
      paramVarArgs.aR(5, this.DJw);
      paramVarArgs.e(6, 8, this.DJz);
      AppMethodBeat.o(155437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ddo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ddo);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.DJu);
      int j = f.a.a.a.c(4, 8, this.DJy);
      int k = f.a.a.b.b.a.bA(5, this.DJw);
      int m = f.a.a.a.c(6, 8, this.DJz);
      AppMethodBeat.o(155437);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DJy.clear();
        this.DJz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        bma localbma = (bma)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155437);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbma.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 2: 
          localbma.Ddo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155437);
          return 0;
        case 3: 
          localbma.DJu = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155437);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bly();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bly)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbma.DJy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 5: 
          localbma.DJw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155437);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bly();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bly)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbma.DJz.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bma
 * JD-Core Version:    0.7.0.1
 */