package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cks
  extends cld
{
  public String CNj;
  public dk EfX;
  public int dcG;
  public String nTK;
  public String rcq;
  public String szi;
  public String vuO;
  public String vuP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72582);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72582);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      if (this.rcq != null) {
        paramVarArgs.d(4, this.rcq);
      }
      if (this.CNj != null) {
        paramVarArgs.d(5, this.CNj);
      }
      if (this.vuO != null) {
        paramVarArgs.d(6, this.vuO);
      }
      if (this.vuP != null) {
        paramVarArgs.d(7, this.vuP);
      }
      if (this.szi != null) {
        paramVarArgs.d(8, this.szi);
      }
      if (this.EfX != null)
      {
        paramVarArgs.kX(9, this.EfX.computeSize());
        this.EfX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72582);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.rcq != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.rcq);
      }
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CNj);
      }
      i = paramInt;
      if (this.vuO != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.vuO);
      }
      paramInt = i;
      if (this.vuP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vuP);
      }
      i = paramInt;
      if (this.szi != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.szi);
      }
      paramInt = i;
      if (this.EfX != null) {
        paramInt = i + f.a.a.a.kW(9, this.EfX.computeSize());
      }
      AppMethodBeat.o(72582);
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
          AppMethodBeat.o(72582);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cks localcks = (cks)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72582);
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
            localcks.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72582);
          return 0;
        case 2: 
          localcks.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72582);
          return 0;
        case 3: 
          localcks.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 4: 
          localcks.rcq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 5: 
          localcks.CNj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 6: 
          localcks.vuO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 7: 
          localcks.vuP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 8: 
          localcks.szi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72582);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcks.EfX = ((dk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      AppMethodBeat.o(72582);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cks
 * JD-Core Version:    0.7.0.1
 */