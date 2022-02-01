package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyv
  extends com.tencent.mm.bx.a
{
  public String IdD;
  public afb aaDI;
  public float height;
  public String thumbUrl;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259238);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.thumbUrl != null) {
        paramVarArgs.g(1, this.thumbUrl);
      }
      paramVarArgs.l(2, this.width);
      paramVarArgs.l(3, this.height);
      if (this.aaDI != null)
      {
        paramVarArgs.qD(4, this.aaDI.computeSize());
        this.aaDI.writeFields(paramVarArgs);
      }
      if (this.IdD != null) {
        paramVarArgs.g(5, this.IdD);
      }
      AppMethodBeat.o(259238);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thumbUrl == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = i.a.a.b.b.a.h(1, this.thumbUrl) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 4) + (i.a.a.b.b.a.ko(3) + 4);
      paramInt = i;
      if (this.aaDI != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaDI.computeSize());
      }
      i = paramInt;
      if (this.IdD != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IdD);
      }
      AppMethodBeat.o(259238);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259238);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cyv localcyv = (cyv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259238);
          return -1;
        case 1: 
          localcyv.thumbUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259238);
          return 0;
        case 2: 
          localcyv.width = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(259238);
          return 0;
        case 3: 
          localcyv.height = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(259238);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            afb localafb = new afb();
            if ((localObject != null) && (localObject.length > 0)) {
              localafb.parseFrom((byte[])localObject);
            }
            localcyv.aaDI = localafb;
            paramInt += 1;
          }
          AppMethodBeat.o(259238);
          return 0;
        }
        localcyv.IdD = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259238);
        return 0;
      }
      AppMethodBeat.o(259238);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyv
 * JD-Core Version:    0.7.0.1
 */