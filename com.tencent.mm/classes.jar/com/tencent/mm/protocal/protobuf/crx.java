package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crx
  extends com.tencent.mm.cd.a
{
  public cry Tzt;
  public cru Tzu;
  public crv Tzv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(253427);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tzt != null)
      {
        paramVarArgs.oE(1, this.Tzt.computeSize());
        this.Tzt.writeFields(paramVarArgs);
      }
      if (this.Tzu != null)
      {
        paramVarArgs.oE(2, this.Tzu.computeSize());
        this.Tzu.writeFields(paramVarArgs);
      }
      if (this.Tzv != null)
      {
        paramVarArgs.oE(3, this.Tzv.computeSize());
        this.Tzv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(253427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tzt == null) {
        break label552;
      }
    }
    label552:
    for (int i = g.a.a.a.oD(1, this.Tzt.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tzu != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tzu.computeSize());
      }
      i = paramInt;
      if (this.Tzv != null) {
        i = paramInt + g.a.a.a.oD(3, this.Tzv.computeSize());
      }
      AppMethodBeat.o(253427);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(253427);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        crx localcrx = (crx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(253427);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cry();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cry)localObject2).parseFrom((byte[])localObject1);
            }
            localcrx.Tzt = ((cry)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(253427);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cru();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cru)localObject2).parseFrom((byte[])localObject1);
            }
            localcrx.Tzu = ((cru)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(253427);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new crv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((crv)localObject2).parseFrom((byte[])localObject1);
          }
          localcrx.Tzv = ((crv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(253427);
        return 0;
      }
      AppMethodBeat.o(253427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crx
 * JD-Core Version:    0.7.0.1
 */