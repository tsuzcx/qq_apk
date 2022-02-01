package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ctk
  extends dpc
{
  public int KCX;
  public int KZh;
  public SKBuiltinBuffer_t Myi;
  public SKBuiltinBuffer_t Myj;
  public int Myk;
  public int Myl;
  public LinkedList<abn> Mym;
  
  public ctk()
  {
    AppMethodBeat.i(133182);
    this.Mym = new LinkedList();
    AppMethodBeat.o(133182);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133183);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.Myi == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.Myj == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Myi != null)
      {
        paramVarArgs.ni(2, this.Myi.computeSize());
        this.Myi.writeFields(paramVarArgs);
      }
      if (this.Myj != null)
      {
        paramVarArgs.ni(3, this.Myj.computeSize());
        this.Myj.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.KZh);
      paramVarArgs.aM(5, this.Myk);
      paramVarArgs.aM(6, this.Myl);
      paramVarArgs.e(7, 8, this.Mym);
      paramVarArgs.aM(8, this.KCX);
      AppMethodBeat.o(133183);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Myi != null) {
        paramInt = i + g.a.a.a.nh(2, this.Myi.computeSize());
      }
      i = paramInt;
      if (this.Myj != null) {
        i = paramInt + g.a.a.a.nh(3, this.Myj.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(4, this.KZh);
      int j = g.a.a.b.b.a.bu(5, this.Myk);
      int k = g.a.a.b.b.a.bu(6, this.Myl);
      int m = g.a.a.a.c(7, 8, this.Mym);
      int n = g.a.a.b.b.a.bu(8, this.KCX);
      AppMethodBeat.o(133183);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mym.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.Myi == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.Myj == null)
        {
          paramVarArgs = new b("Not all required fields were included: MaxSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133183);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ctk localctk = (ctk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133183);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctk.Myi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctk.Myj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 4: 
          localctk.KZh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133183);
          return 0;
        case 5: 
          localctk.Myk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133183);
          return 0;
        case 6: 
          localctk.Myl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133183);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctk.Mym.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        }
        localctk.KCX = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133183);
        return 0;
      }
      AppMethodBeat.o(133183);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctk
 * JD-Core Version:    0.7.0.1
 */