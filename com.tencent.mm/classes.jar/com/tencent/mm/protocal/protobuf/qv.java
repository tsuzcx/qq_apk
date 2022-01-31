package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class qv
  extends bvk
{
  public int cnK;
  public String kNv;
  public int qkr;
  public String qrx;
  public String qry;
  public String wJa;
  public boolean wJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48811);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48811);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.cnK);
      if (this.kNv != null) {
        paramVarArgs.e(3, this.kNv);
      }
      if (this.wJa != null) {
        paramVarArgs.e(4, this.wJa);
      }
      if (this.qrx != null) {
        paramVarArgs.e(5, this.qrx);
      }
      paramVarArgs.aS(6, this.wJb);
      if (this.qry != null) {
        paramVarArgs.e(7, this.qry);
      }
      paramVarArgs.aO(8, this.qkr);
      AppMethodBeat.o(48811);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.wJa != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wJa);
      }
      paramInt = i;
      if (this.qrx != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.qrx);
      }
      i = paramInt + (e.a.a.b.b.a.eW(6) + 1);
      paramInt = i;
      if (this.qry != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.qry);
      }
      i = e.a.a.b.b.a.bl(8, this.qkr);
      AppMethodBeat.o(48811);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(48811);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48811);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qv localqv = (qv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48811);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localqv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48811);
          return 0;
        case 2: 
          localqv.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48811);
          return 0;
        case 3: 
          localqv.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48811);
          return 0;
        case 4: 
          localqv.wJa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48811);
          return 0;
        case 5: 
          localqv.qrx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48811);
          return 0;
        case 6: 
          localqv.wJb = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(48811);
          return 0;
        case 7: 
          localqv.qry = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48811);
          return 0;
        }
        localqv.qkr = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(48811);
        return 0;
      }
      AppMethodBeat.o(48811);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qv
 * JD-Core Version:    0.7.0.1
 */