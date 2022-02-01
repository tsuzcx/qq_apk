package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bys
  extends dop
{
  public SKBuiltinBuffer_t KLh;
  public SKBuiltinBuffer_t LRA;
  public String Mec;
  public int Scene;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32315);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KLh == null)
      {
        paramVarArgs = new b("Not all required fields were included: A2Key");
        AppMethodBeat.o(32315);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KLh != null)
      {
        paramVarArgs.ni(2, this.KLh.computeSize());
        this.KLh.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.e(3, this.UserName);
      }
      paramVarArgs.aM(4, this.Scene);
      if (this.Mec != null) {
        paramVarArgs.e(5, this.Mec);
      }
      if (this.LRA != null)
      {
        paramVarArgs.ni(6, this.LRA.computeSize());
        this.LRA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32315);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KLh != null) {
        paramInt = i + g.a.a.a.nh(2, this.KLh.computeSize());
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.UserName);
      }
      i += g.a.a.b.b.a.bu(4, this.Scene);
      paramInt = i;
      if (this.Mec != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Mec);
      }
      i = paramInt;
      if (this.LRA != null) {
        i = paramInt + g.a.a.a.nh(6, this.LRA.computeSize());
      }
      AppMethodBeat.o(32315);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KLh == null)
        {
          paramVarArgs = new b("Not all required fields were included: A2Key");
          AppMethodBeat.o(32315);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32315);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bys localbys = (bys)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32315);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbys.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32315);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbys.KLh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32315);
          return 0;
        case 3: 
          localbys.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32315);
          return 0;
        case 4: 
          localbys.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32315);
          return 0;
        case 5: 
          localbys.Mec = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32315);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbys.LRA = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32315);
        return 0;
      }
      AppMethodBeat.o(32315);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bys
 * JD-Core Version:    0.7.0.1
 */