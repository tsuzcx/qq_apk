package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkn
  extends com.tencent.mm.bw.a
{
  public ahh KVG;
  public int MOr;
  public int MOs;
  public String MOt;
  public String buffer;
  public String dQx;
  public String xml;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212290);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xml != null) {
        paramVarArgs.e(1, this.xml);
      }
      paramVarArgs.aM(2, this.MOr);
      paramVarArgs.aM(3, this.MOs);
      if (this.MOt != null) {
        paramVarArgs.e(4, this.MOt);
      }
      if (this.dQx != null) {
        paramVarArgs.e(5, this.dQx);
      }
      if (this.buffer != null) {
        paramVarArgs.e(6, this.buffer);
      }
      if (this.KVG != null)
      {
        paramVarArgs.ni(7, this.KVG.computeSize());
        this.KVG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(212290);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xml == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = g.a.a.b.b.a.f(1, this.xml) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MOr) + g.a.a.b.b.a.bu(3, this.MOs);
      paramInt = i;
      if (this.MOt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MOt);
      }
      i = paramInt;
      if (this.dQx != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dQx);
      }
      paramInt = i;
      if (this.buffer != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.buffer);
      }
      i = paramInt;
      if (this.KVG != null) {
        i = paramInt + g.a.a.a.nh(7, this.KVG.computeSize());
      }
      AppMethodBeat.o(212290);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212290);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dkn localdkn = (dkn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212290);
          return -1;
        case 1: 
          localdkn.xml = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212290);
          return 0;
        case 2: 
          localdkn.MOr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212290);
          return 0;
        case 3: 
          localdkn.MOs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212290);
          return 0;
        case 4: 
          localdkn.MOt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212290);
          return 0;
        case 5: 
          localdkn.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212290);
          return 0;
        case 6: 
          localdkn.buffer = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212290);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdkn.KVG = ((ahh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212290);
        return 0;
      }
      AppMethodBeat.o(212290);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkn
 * JD-Core Version:    0.7.0.1
 */