package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class arx
  extends dop
{
  public long Gcy;
  public long LDo;
  public String finderUsername;
  public int scene;
  public b tVM;
  public aov uli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168976);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.e(2, this.finderUsername);
      }
      paramVarArgs.bb(3, this.Gcy);
      if (this.tVM != null) {
        paramVarArgs.c(4, this.tVM);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(5, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.LDo);
      paramVarArgs.aM(7, this.scene);
      AppMethodBeat.o(168976);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.finderUsername);
      }
      i += g.a.a.b.b.a.r(3, this.Gcy);
      paramInt = i;
      if (this.tVM != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.tVM);
      }
      i = paramInt;
      if (this.uli != null) {
        i = paramInt + g.a.a.a.nh(5, this.uli.computeSize());
      }
      paramInt = g.a.a.b.b.a.r(6, this.LDo);
      int j = g.a.a.b.b.a.bu(7, this.scene);
      AppMethodBeat.o(168976);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168976);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        arx localarx = (arx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168976);
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
            localarx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168976);
          return 0;
        case 2: 
          localarx.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168976);
          return 0;
        case 3: 
          localarx.Gcy = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168976);
          return 0;
        case 4: 
          localarx.tVM = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168976);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localarx.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168976);
          return 0;
        case 6: 
          localarx.LDo = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168976);
          return 0;
        }
        localarx.scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168976);
        return 0;
      }
      AppMethodBeat.o(168976);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arx
 * JD-Core Version:    0.7.0.1
 */