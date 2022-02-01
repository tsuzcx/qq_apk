package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dud
  extends cld
{
  public int DZz;
  public int EIB;
  public int EIC;
  public String dnK;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123686);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123686);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aR(4, this.version);
      paramVarArgs.aR(5, this.EIB);
      paramVarArgs.aR(6, this.DZz);
      paramVarArgs.aR(7, this.EIC);
      if (this.dnK != null) {
        paramVarArgs.d(8, this.dnK);
      }
      AppMethodBeat.o(123686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bA(4, this.version) + f.a.a.b.b.a.bA(5, this.EIB) + f.a.a.b.b.a.bA(6, this.DZz) + f.a.a.b.b.a.bA(7, this.EIC);
      paramInt = i;
      if (this.dnK != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dnK);
      }
      AppMethodBeat.o(123686);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123686);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123686);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dud localdud = (dud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123686);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdud.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123686);
          return 0;
        case 2: 
          localdud.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 3: 
          localdud.md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 4: 
          localdud.version = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123686);
          return 0;
        case 5: 
          localdud.EIB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123686);
          return 0;
        case 6: 
          localdud.DZz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123686);
          return 0;
        case 7: 
          localdud.EIC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123686);
          return 0;
        }
        localdud.dnK = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123686);
        return 0;
      }
      AppMethodBeat.o(123686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dud
 * JD-Core Version:    0.7.0.1
 */