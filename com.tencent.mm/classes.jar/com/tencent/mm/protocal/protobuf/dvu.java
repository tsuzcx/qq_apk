package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvu
  extends dop
{
  public int MWF;
  public String MWG;
  public String hik;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32434);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hik != null) {
        paramVarArgs.e(2, this.hik);
      }
      paramVarArgs.aM(3, this.MWF);
      if (this.MWG != null) {
        paramVarArgs.e(4, this.MWG);
      }
      AppMethodBeat.o(32434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hik != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.hik);
      }
      i += g.a.a.b.b.a.bu(3, this.MWF);
      paramInt = i;
      if (this.MWG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MWG);
      }
      AppMethodBeat.o(32434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvu localdvu = (dvu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32434);
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
            localdvu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32434);
          return 0;
        case 2: 
          localdvu.hik = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32434);
          return 0;
        case 3: 
          localdvu.MWF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32434);
          return 0;
        }
        localdvu.MWG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32434);
        return 0;
      }
      AppMethodBeat.o(32434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvu
 * JD-Core Version:    0.7.0.1
 */