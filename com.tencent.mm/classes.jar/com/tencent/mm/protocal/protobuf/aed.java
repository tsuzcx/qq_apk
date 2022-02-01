package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aed
  extends dop
{
  public LinkedList<con> KGQ;
  public dqi Lpx;
  public SKBuiltinBuffer_t Lpy;
  public String Lpz;
  public int Scene;
  public int gsq;
  public String jfi;
  
  public aed()
  {
    AppMethodBeat.i(101797);
    this.KGQ = new LinkedList();
    AppMethodBeat.o(101797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101798);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lpx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101798);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Lpx != null)
      {
        paramVarArgs.ni(2, this.Lpx.computeSize());
        this.Lpx.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.gsq);
      paramVarArgs.e(4, 8, this.KGQ);
      paramVarArgs.aM(5, this.Scene);
      if (this.Lpy != null)
      {
        paramVarArgs.ni(6, this.Lpy.computeSize());
        this.Lpy.writeFields(paramVarArgs);
      }
      if (this.Lpz != null) {
        paramVarArgs.e(7, this.Lpz);
      }
      if (this.jfi != null) {
        paramVarArgs.e(8, this.jfi);
      }
      AppMethodBeat.o(101798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1018;
      }
    }
    label1018:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lpx != null) {
        i = paramInt + g.a.a.a.nh(2, this.Lpx.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(3, this.gsq) + g.a.a.a.c(4, 8, this.KGQ) + g.a.a.b.b.a.bu(5, this.Scene);
      paramInt = i;
      if (this.Lpy != null) {
        paramInt = i + g.a.a.a.nh(6, this.Lpy.computeSize());
      }
      i = paramInt;
      if (this.Lpz != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lpz);
      }
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.jfi);
      }
      AppMethodBeat.o(101798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KGQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lpx == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(101798);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101798);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aed localaed = (aed)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101798);
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
            localaed.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaed.Lpx = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 3: 
          localaed.gsq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101798);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new con();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((con)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaed.KGQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 5: 
          localaed.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101798);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaed.Lpy = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101798);
          return 0;
        case 7: 
          localaed.Lpz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101798);
          return 0;
        }
        localaed.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(101798);
        return 0;
      }
      AppMethodBeat.o(101798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aed
 * JD-Core Version:    0.7.0.1
 */