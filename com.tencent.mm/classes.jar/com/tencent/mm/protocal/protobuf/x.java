package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class x
  extends dop
{
  public String KBs;
  public String KBt;
  public int scene;
  public String sign;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91333);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KBs != null) {
        paramVarArgs.e(2, this.KBs);
      }
      paramVarArgs.aM(3, this.scene);
      if (this.KBt != null) {
        paramVarArgs.e(4, this.KBt);
      }
      if (this.sign != null) {
        paramVarArgs.e(5, this.sign);
      }
      paramVarArgs.aM(6, this.ver);
      AppMethodBeat.o(91333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KBs != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KBs);
      }
      i += g.a.a.b.b.a.bu(3, this.scene);
      paramInt = i;
      if (this.KBt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KBt);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.sign);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.ver);
      AppMethodBeat.o(91333);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91333);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91333);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91333);
          return 0;
        case 2: 
          localx.KBs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91333);
          return 0;
        case 3: 
          localx.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91333);
          return 0;
        case 4: 
          localx.KBt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91333);
          return 0;
        case 5: 
          localx.sign = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91333);
          return 0;
        }
        localx.ver = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91333);
        return 0;
      }
      AppMethodBeat.o(91333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.x
 * JD-Core Version:    0.7.0.1
 */