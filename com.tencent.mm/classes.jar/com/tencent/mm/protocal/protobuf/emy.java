package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class emy
  extends dop
{
  public int BsF;
  public int BsG;
  public int BsH;
  public SKBuiltinBuffer_t BsI;
  public int KIy;
  public String MD5;
  public String NkS;
  public String UserName;
  public String jfi;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32484);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BsI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32484);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      paramVarArgs.aM(3, this.KIy);
      if (this.NkS != null) {
        paramVarArgs.e(4, this.NkS);
      }
      if (this.UserName != null) {
        paramVarArgs.e(5, this.UserName);
      }
      paramVarArgs.aM(6, this.BsF);
      paramVarArgs.aM(7, this.BsG);
      paramVarArgs.aM(8, this.BsH);
      if (this.BsI != null)
      {
        paramVarArgs.ni(9, this.BsI.computeSize());
        this.BsI.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(10, this.oUv);
      if (this.MD5 != null) {
        paramVarArgs.e(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label999;
      }
    }
    label999:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.jfi);
      }
      i += g.a.a.b.b.a.bu(3, this.KIy);
      paramInt = i;
      if (this.NkS != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NkS);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.UserName);
      }
      i = i + g.a.a.b.b.a.bu(6, this.BsF) + g.a.a.b.b.a.bu(7, this.BsG) + g.a.a.b.b.a.bu(8, this.BsH);
      paramInt = i;
      if (this.BsI != null) {
        paramInt = i + g.a.a.a.nh(9, this.BsI.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.oUv);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return paramInt;
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
          AppMethodBeat.o(32484);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32484);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        emy localemy = (emy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32484);
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
            localemy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 2: 
          localemy.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 3: 
          localemy.KIy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32484);
          return 0;
        case 4: 
          localemy.NkS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 5: 
          localemy.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 6: 
          localemy.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32484);
          return 0;
        case 7: 
          localemy.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32484);
          return 0;
        case 8: 
          localemy.BsH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32484);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localemy.BsI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 10: 
          localemy.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32484);
          return 0;
        }
        localemy.MD5 = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32484);
        return 0;
      }
      AppMethodBeat.o(32484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emy
 * JD-Core Version:    0.7.0.1
 */