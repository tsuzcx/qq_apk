package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epl
  extends dop
{
  public SKBuiltinBuffer_t KPW;
  public String LSY;
  public long LTb;
  public String MPK;
  public String MPL;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104379);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LSY != null) {
        paramVarArgs.e(2, this.LSY);
      }
      paramVarArgs.bb(3, this.LTb);
      if (this.KPW != null)
      {
        paramVarArgs.ni(4, this.KPW.computeSize());
        this.KPW.writeFields(paramVarArgs);
      }
      if (this.MPK != null) {
        paramVarArgs.e(5, this.MPK);
      }
      if (this.MPL != null) {
        paramVarArgs.e(6, this.MPL);
      }
      paramVarArgs.aM(7, this.Scene);
      AppMethodBeat.o(104379);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LSY != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LSY);
      }
      i += g.a.a.b.b.a.r(3, this.LTb);
      paramInt = i;
      if (this.KPW != null) {
        paramInt = i + g.a.a.a.nh(4, this.KPW.computeSize());
      }
      i = paramInt;
      if (this.MPK != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MPK);
      }
      paramInt = i;
      if (this.MPL != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MPL);
      }
      i = g.a.a.b.b.a.bu(7, this.Scene);
      AppMethodBeat.o(104379);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104379);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        epl localepl = (epl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104379);
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
            localepl.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104379);
          return 0;
        case 2: 
          localepl.LSY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104379);
          return 0;
        case 3: 
          localepl.LTb = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(104379);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localepl.KPW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104379);
          return 0;
        case 5: 
          localepl.MPK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104379);
          return 0;
        case 6: 
          localepl.MPL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104379);
          return 0;
        }
        localepl.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104379);
        return 0;
      }
      AppMethodBeat.o(104379);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epl
 * JD-Core Version:    0.7.0.1
 */