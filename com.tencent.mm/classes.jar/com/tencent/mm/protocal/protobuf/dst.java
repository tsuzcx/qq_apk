package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dst
  extends cld
{
  public int CNt;
  public String DLy;
  public int EHo;
  public chh EHp;
  public chf EHq;
  public int EHr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117949);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EHo);
      paramVarArgs.aR(3, this.CNt);
      if (this.DLy != null) {
        paramVarArgs.d(4, this.DLy);
      }
      if (this.EHp != null)
      {
        paramVarArgs.kX(5, this.EHp.computeSize());
        this.EHp.writeFields(paramVarArgs);
      }
      if (this.EHq != null)
      {
        paramVarArgs.kX(6, this.EHq.computeSize());
        this.EHq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.EHr);
      AppMethodBeat.o(117949);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.EHo) + f.a.a.b.b.a.bA(3, this.CNt);
      paramInt = i;
      if (this.DLy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DLy);
      }
      i = paramInt;
      if (this.EHp != null) {
        i = paramInt + f.a.a.a.kW(5, this.EHp.computeSize());
      }
      paramInt = i;
      if (this.EHq != null) {
        paramInt = i + f.a.a.a.kW(6, this.EHq.computeSize());
      }
      i = f.a.a.b.b.a.bA(7, this.EHr);
      AppMethodBeat.o(117949);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117949);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dst localdst = (dst)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117949);
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
            localdst.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 2: 
          localdst.EHo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117949);
          return 0;
        case 3: 
          localdst.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117949);
          return 0;
        case 4: 
          localdst.DLy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117949);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdst.EHp = ((chh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdst.EHq = ((chf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        }
        localdst.EHr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117949);
        return 0;
      }
      AppMethodBeat.o(117949);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dst
 * JD-Core Version:    0.7.0.1
 */