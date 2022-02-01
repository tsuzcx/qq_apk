package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class caw
  extends dpc
{
  public SKBuiltinBuffer_t KKY;
  public SKBuiltinBuffer_t Mgl;
  public SKBuiltinBuffer_t Mgm;
  public int Mgn;
  public int Mgo;
  public int Mgp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32319);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.KKY == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.Mgl == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionBuffer");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.Mgm == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuffer");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KKY != null)
      {
        paramVarArgs.ni(2, this.KKY.computeSize());
        this.KKY.writeFields(paramVarArgs);
      }
      if (this.Mgl != null)
      {
        paramVarArgs.ni(3, this.Mgl.computeSize());
        this.Mgl.writeFields(paramVarArgs);
      }
      if (this.Mgm != null)
      {
        paramVarArgs.ni(4, this.Mgm.computeSize());
        this.Mgm.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.Mgn);
      paramVarArgs.aM(6, this.Mgo);
      paramVarArgs.aM(7, this.Mgp);
      AppMethodBeat.o(32319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1127;
      }
    }
    label1127:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KKY != null) {
        paramInt = i + g.a.a.a.nh(2, this.KKY.computeSize());
      }
      i = paramInt;
      if (this.Mgl != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mgl.computeSize());
      }
      paramInt = i;
      if (this.Mgm != null) {
        paramInt = i + g.a.a.a.nh(4, this.Mgm.computeSize());
      }
      i = g.a.a.b.b.a.bu(5, this.Mgn);
      int j = g.a.a.b.b.a.bu(6, this.Mgo);
      int k = g.a.a.b.b.a.bu(7, this.Mgp);
      AppMethodBeat.o(32319);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.KKY == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionKey");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.Mgl == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionBuffer");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.Mgm == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuffer");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        caw localcaw = (caw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32319);
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
            localcaw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
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
            localcaw.KKY = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
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
            localcaw.Mgl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcaw.Mgm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
          return 0;
        case 5: 
          localcaw.Mgn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32319);
          return 0;
        case 6: 
          localcaw.Mgo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32319);
          return 0;
        }
        localcaw.Mgp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32319);
        return 0;
      }
      AppMethodBeat.o(32319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caw
 * JD-Core Version:    0.7.0.1
 */