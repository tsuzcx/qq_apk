package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boq
  extends dop
{
  public ahc KCP;
  public String KCy;
  public String wOK;
  public String wOL;
  public String wOM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32243);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wOK != null) {
        paramVarArgs.e(2, this.wOK);
      }
      if (this.wOL != null) {
        paramVarArgs.e(3, this.wOL);
      }
      if (this.wOM != null) {
        paramVarArgs.e(4, this.wOM);
      }
      if (this.KCy != null) {
        paramVarArgs.e(5, this.KCy);
      }
      if (this.KCP != null)
      {
        paramVarArgs.ni(6, this.KCP.computeSize());
        this.KCP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wOK != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.wOK);
      }
      i = paramInt;
      if (this.wOL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.wOL);
      }
      paramInt = i;
      if (this.wOM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.wOM);
      }
      i = paramInt;
      if (this.KCy != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KCy);
      }
      paramInt = i;
      if (this.KCP != null) {
        paramInt = i + g.a.a.a.nh(6, this.KCP.computeSize());
      }
      AppMethodBeat.o(32243);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        boq localboq = (boq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32243);
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
            localboq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32243);
          return 0;
        case 2: 
          localboq.wOK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 3: 
          localboq.wOL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 4: 
          localboq.wOM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 5: 
          localboq.KCy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32243);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localboq.KCP = ((ahc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32243);
        return 0;
      }
      AppMethodBeat.o(32243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boq
 * JD-Core Version:    0.7.0.1
 */