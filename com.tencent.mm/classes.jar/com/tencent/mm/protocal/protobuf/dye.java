package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dye
  extends com.tencent.mm.bw.a
{
  public epg MXR;
  public String MXS;
  public String MXT;
  public String name;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200224);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.e(1, this.name);
      }
      if (this.value != null) {
        paramVarArgs.e(2, this.value);
      }
      if (this.MXR != null)
      {
        paramVarArgs.ni(3, this.MXR.computeSize());
        this.MXR.writeFields(paramVarArgs);
      }
      if (this.MXS != null) {
        paramVarArgs.e(4, this.MXS);
      }
      if (this.MXT != null) {
        paramVarArgs.e(5, this.MXT);
      }
      AppMethodBeat.o(200224);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label550;
      }
    }
    label550:
    for (int i = g.a.a.b.b.a.f(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.value != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.value);
      }
      i = paramInt;
      if (this.MXR != null) {
        i = paramInt + g.a.a.a.nh(3, this.MXR.computeSize());
      }
      paramInt = i;
      if (this.MXS != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MXS);
      }
      i = paramInt;
      if (this.MXT != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MXT);
      }
      AppMethodBeat.o(200224);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200224);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dye localdye = (dye)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200224);
          return -1;
        case 1: 
          localdye.name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200224);
          return 0;
        case 2: 
          localdye.value = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200224);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new epg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((epg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdye.MXR = ((epg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200224);
          return 0;
        case 4: 
          localdye.MXS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200224);
          return 0;
        }
        localdye.MXT = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(200224);
        return 0;
      }
      AppMethodBeat.o(200224);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dye
 * JD-Core Version:    0.7.0.1
 */