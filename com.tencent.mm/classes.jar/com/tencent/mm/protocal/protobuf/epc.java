package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class epc
  extends com.tencent.mm.bw.a
{
  public erh NmX;
  public int previewHeight;
  public int previewWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110915);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NmX == null)
      {
        paramVarArgs = new b("Not all required fields were included: materialResp");
        AppMethodBeat.o(110915);
        throw paramVarArgs;
      }
      if (this.NmX != null)
      {
        paramVarArgs.ni(1, this.NmX.computeSize());
        this.NmX.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.previewWidth);
      paramVarArgs.aM(3, this.previewHeight);
      AppMethodBeat.o(110915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NmX == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = g.a.a.a.nh(1, this.NmX.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.previewWidth);
      int j = g.a.a.b.b.a.bu(3, this.previewHeight);
      AppMethodBeat.o(110915);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NmX == null)
        {
          paramVarArgs = new b("Not all required fields were included: materialResp");
          AppMethodBeat.o(110915);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        epc localepc = (epc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110915);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new erh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((erh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localepc.NmX = ((erh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110915);
          return 0;
        case 2: 
          localepc.previewWidth = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(110915);
          return 0;
        }
        localepc.previewHeight = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(110915);
        return 0;
      }
      AppMethodBeat.o(110915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epc
 * JD-Core Version:    0.7.0.1
 */