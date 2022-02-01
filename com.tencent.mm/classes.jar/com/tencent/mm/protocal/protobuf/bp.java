package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bp
  extends com.tencent.mm.bx.a
{
  public dii YDj;
  public int YDk;
  public long ihV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259504);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YDj != null)
      {
        paramVarArgs.qD(1, this.YDj.computeSize());
        this.YDj.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.ihV);
      paramVarArgs.bS(3, this.YDk);
      AppMethodBeat.o(259504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YDj == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = i.a.a.a.qC(1, this.YDj.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.ihV);
      int j = i.a.a.b.b.a.cJ(3, this.YDk);
      AppMethodBeat.o(259504);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bp localbp = (bp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259504);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dii localdii = new dii();
            if ((localObject != null) && (localObject.length > 0)) {
              localdii.parseFrom((byte[])localObject);
            }
            localbp.YDj = localdii;
            paramInt += 1;
          }
          AppMethodBeat.o(259504);
          return 0;
        case 2: 
          localbp.ihV = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259504);
          return 0;
        }
        localbp.YDk = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259504);
        return 0;
      }
      AppMethodBeat.o(259504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bp
 * JD-Core Version:    0.7.0.1
 */