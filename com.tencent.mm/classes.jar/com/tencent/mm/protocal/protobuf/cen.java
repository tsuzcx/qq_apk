package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cen
  extends cld
{
  public int Eav;
  public String Eaw;
  public String Eax;
  public bew Eay;
  public int ntx;
  public String nty;
  public String zFY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91642);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91642);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.aR(4, this.Eav);
      if (this.Eaw != null) {
        paramVarArgs.d(5, this.Eaw);
      }
      if (this.Eax != null) {
        paramVarArgs.d(6, this.Eax);
      }
      if (this.Eay != null)
      {
        paramVarArgs.kX(7, this.Eay.computeSize());
        this.Eay.writeFields(paramVarArgs);
      }
      if (this.zFY != null) {
        paramVarArgs.d(100, this.zFY);
      }
      AppMethodBeat.o(91642);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Eav);
      paramInt = i;
      if (this.Eaw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Eaw);
      }
      i = paramInt;
      if (this.Eax != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Eax);
      }
      paramInt = i;
      if (this.Eay != null) {
        paramInt = i + f.a.a.a.kW(7, this.Eay.computeSize());
      }
      i = paramInt;
      if (this.zFY != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.zFY);
      }
      AppMethodBeat.o(91642);
      return i;
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
          AppMethodBeat.o(91642);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91642);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cen localcen = (cen)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91642);
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
            localcen.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        case 2: 
          localcen.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91642);
          return 0;
        case 3: 
          localcen.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 4: 
          localcen.Eav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91642);
          return 0;
        case 5: 
          localcen.Eaw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 6: 
          localcen.Eax = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bew();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bew)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcen.Eay = ((bew)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        }
        localcen.zFY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91642);
        return 0;
      }
      AppMethodBeat.o(91642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cen
 * JD-Core Version:    0.7.0.1
 */