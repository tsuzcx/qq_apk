package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aqa
  extends cld
{
  public String Drh;
  public int dcG;
  public String nTK;
  public LinkedList<String> zVX;
  
  public aqa()
  {
    AppMethodBeat.i(91484);
    this.zVX = new LinkedList();
    AppMethodBeat.o(91484);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.zVX);
      paramVarArgs.aR(3, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(4, this.nTK);
      }
      if (this.Drh != null) {
        paramVarArgs.d(5, this.Drh);
      }
      AppMethodBeat.o(91485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.zVX) + f.a.a.b.b.a.bA(3, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nTK);
      }
      i = paramInt;
      if (this.Drh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Drh);
      }
      AppMethodBeat.o(91485);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.zVX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqa localaqa = (aqa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91485);
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
            localaqa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91485);
          return 0;
        case 2: 
          localaqa.zVX.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(91485);
          return 0;
        case 3: 
          localaqa.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91485);
          return 0;
        case 4: 
          localaqa.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91485);
          return 0;
        }
        localaqa.Drh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91485);
        return 0;
      }
      AppMethodBeat.o(91485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqa
 * JD-Core Version:    0.7.0.1
 */