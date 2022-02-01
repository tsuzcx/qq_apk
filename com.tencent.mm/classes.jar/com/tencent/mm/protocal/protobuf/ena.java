package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ena
  extends dop
{
  public int BsF;
  public int BsG;
  public int BsH;
  public SKBuiltinBuffer_t BsI;
  public String Lqx;
  public String izX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90777);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(90777);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.izX != null) {
        paramVarArgs.e(2, this.izX);
      }
      paramVarArgs.aM(3, this.BsF);
      paramVarArgs.aM(4, this.BsG);
      paramVarArgs.aM(5, this.BsH);
      if (this.BsI != null)
      {
        paramVarArgs.ni(6, this.BsI.computeSize());
        this.BsI.writeFields(paramVarArgs);
      }
      if (this.Lqx != null) {
        paramVarArgs.e(7, this.Lqx);
      }
      AppMethodBeat.o(90777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.izX != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.izX);
      }
      i = i + g.a.a.b.b.a.bu(3, this.BsF) + g.a.a.b.b.a.bu(4, this.BsG) + g.a.a.b.b.a.bu(5, this.BsH);
      paramInt = i;
      if (this.BsI != null) {
        paramInt = i + g.a.a.a.nh(6, this.BsI.computeSize());
      }
      i = paramInt;
      if (this.Lqx != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lqx);
      }
      AppMethodBeat.o(90777);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BsI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(90777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(90777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ena localena = (ena)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90777);
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
            localena.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        case 2: 
          localena.izX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(90777);
          return 0;
        case 3: 
          localena.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(90777);
          return 0;
        case 4: 
          localena.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(90777);
          return 0;
        case 5: 
          localena.BsH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(90777);
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
            localena.BsI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        }
        localena.Lqx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(90777);
        return 0;
      }
      AppMethodBeat.o(90777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ena
 * JD-Core Version:    0.7.0.1
 */