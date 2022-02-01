package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbt
  extends cwj
{
  public float GRI;
  public String GRJ;
  public String GoW;
  public String action_data;
  public int oGt;
  public String oGu;
  public String person_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104370);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104370);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      if (this.person_id != null) {
        paramVarArgs.d(4, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.d(5, this.action_data);
      }
      paramVarArgs.y(6, this.GRI);
      if (this.GoW != null) {
        paramVarArgs.d(7, this.GoW);
      }
      if (this.GRJ != null) {
        paramVarArgs.d(8, this.GRJ);
      }
      AppMethodBeat.o(104370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label753;
      }
    }
    label753:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.person_id != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.person_id);
      }
      paramInt = i;
      if (this.action_data != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.action_data);
      }
      i = paramInt + f.a.a.b.b.a.amE(6);
      paramInt = i;
      if (this.GoW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GoW);
      }
      i = paramInt;
      if (this.GRJ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GRJ);
      }
      AppMethodBeat.o(104370);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104370);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbt localbbt = (bbt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104370);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104370);
          return 0;
        case 2: 
          localbbt.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104370);
          return 0;
        case 3: 
          localbbt.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 4: 
          localbbt.person_id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 5: 
          localbbt.action_data = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 6: 
          localbbt.GRI = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(104370);
          return 0;
        case 7: 
          localbbt.GoW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104370);
          return 0;
        }
        localbbt.GRJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(104370);
        return 0;
      }
      AppMethodBeat.o(104370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbt
 * JD-Core Version:    0.7.0.1
 */