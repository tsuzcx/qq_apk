package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bib
  extends esc
{
  public bjc Bhm;
  public bjf ZRh;
  public int ZRi;
  public int continueFlag;
  public b lastBuffer;
  public long liveId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257523);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Bhm != null)
      {
        paramVarArgs.qD(2, this.Bhm.computeSize());
        this.Bhm.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(3, this.lastBuffer);
      }
      paramVarArgs.bS(4, this.continueFlag);
      if (this.ZRh != null)
      {
        paramVarArgs.qD(5, this.ZRh.computeSize());
        this.ZRh.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.liveId);
      paramVarArgs.bS(7, this.ZRi);
      AppMethodBeat.o(257523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label748;
      }
    }
    label748:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Bhm != null) {
        paramInt = i + i.a.a.a.qC(2, this.Bhm.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      i += i.a.a.b.b.a.cJ(4, this.continueFlag);
      paramInt = i;
      if (this.ZRh != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZRh.computeSize());
      }
      i = i.a.a.b.b.a.q(6, this.liveId);
      int j = i.a.a.b.b.a.cJ(7, this.ZRi);
      AppMethodBeat.o(257523);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257523);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bib localbib = (bib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257523);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbib.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257523);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjc)localObject2).parseFrom((byte[])localObject1);
            }
            localbib.Bhm = ((bjc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257523);
          return 0;
        case 3: 
          localbib.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257523);
          return 0;
        case 4: 
          localbib.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257523);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjf)localObject2).parseFrom((byte[])localObject1);
            }
            localbib.ZRh = ((bjf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257523);
          return 0;
        case 6: 
          localbib.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257523);
          return 0;
        }
        localbib.ZRi = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257523);
        return 0;
      }
      AppMethodBeat.o(257523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bib
 * JD-Core Version:    0.7.0.1
 */