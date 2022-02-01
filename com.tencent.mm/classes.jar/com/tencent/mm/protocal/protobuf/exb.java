package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exb
  extends com.tencent.mm.bw.a
{
  public String Nuw;
  public String Nux;
  public exn Nuy;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200235);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nuw != null) {
        paramVarArgs.e(1, this.Nuw);
      }
      if (this.Nux != null) {
        paramVarArgs.e(2, this.Nux);
      }
      if (this.Nuy != null)
      {
        paramVarArgs.ni(3, this.Nuy.computeSize());
        this.Nuy.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.type);
      AppMethodBeat.o(200235);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nuw == null) {
        break label474;
      }
    }
    label474:
    for (int i = g.a.a.b.b.a.f(1, this.Nuw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nux != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nux);
      }
      i = paramInt;
      if (this.Nuy != null) {
        i = paramInt + g.a.a.a.nh(3, this.Nuy.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(4, this.type);
      AppMethodBeat.o(200235);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200235);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        exb localexb = (exb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200235);
          return -1;
        case 1: 
          localexb.Nuw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200235);
          return 0;
        case 2: 
          localexb.Nux = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200235);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new exn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((exn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localexb.Nuy = ((exn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200235);
          return 0;
        }
        localexb.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(200235);
        return 0;
      }
      AppMethodBeat.o(200235);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exb
 * JD-Core Version:    0.7.0.1
 */