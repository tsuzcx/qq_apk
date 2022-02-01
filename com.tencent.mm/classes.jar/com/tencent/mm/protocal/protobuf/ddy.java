package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddy
  extends dop
{
  public int LVh;
  public boolean MIZ;
  public int Meg;
  public String dNI;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123636);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      if (this.dNI != null) {
        paramVarArgs.e(3, this.dNI);
      }
      paramVarArgs.aM(4, this.Meg);
      if (this.path != null) {
        paramVarArgs.e(5, this.path);
      }
      paramVarArgs.aM(6, this.LVh);
      paramVarArgs.cc(7, this.MIZ);
      AppMethodBeat.o(123636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label626;
      }
    }
    label626:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.username);
      }
      i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dNI);
      }
      i += g.a.a.b.b.a.bu(4, this.Meg);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.path);
      }
      i = g.a.a.b.b.a.bu(6, this.LVh);
      int j = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(123636);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ddy localddy = (ddy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123636);
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
            localddy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123636);
          return 0;
        case 2: 
          localddy.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 3: 
          localddy.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 4: 
          localddy.Meg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123636);
          return 0;
        case 5: 
          localddy.path = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 6: 
          localddy.LVh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123636);
          return 0;
        }
        localddy.MIZ = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(123636);
        return 0;
      }
      AppMethodBeat.o(123636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddy
 * JD-Core Version:    0.7.0.1
 */