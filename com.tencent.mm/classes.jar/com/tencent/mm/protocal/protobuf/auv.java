package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auv
  extends esc
{
  public int ZFj;
  public int ZFk;
  public int ZFl;
  public int ZFm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257806);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZFj);
      paramVarArgs.bS(3, this.ZFk);
      paramVarArgs.bS(4, this.ZFl);
      paramVarArgs.bS(5, this.ZFm);
      AppMethodBeat.o(257806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label468;
      }
    }
    label468:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZFj);
      int j = i.a.a.b.b.a.cJ(3, this.ZFk);
      int k = i.a.a.b.b.a.cJ(4, this.ZFl);
      int m = i.a.a.b.b.a.cJ(5, this.ZFm);
      AppMethodBeat.o(257806);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257806);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        auv localauv = (auv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257806);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localauv.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(257806);
          return 0;
        case 2: 
          localauv.ZFj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257806);
          return 0;
        case 3: 
          localauv.ZFk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257806);
          return 0;
        case 4: 
          localauv.ZFl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257806);
          return 0;
        }
        localauv.ZFm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257806);
        return 0;
      }
      AppMethodBeat.o(257806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auv
 * JD-Core Version:    0.7.0.1
 */