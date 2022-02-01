package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ayq
  extends erp
{
  public b BgS;
  public atz CJv;
  public long GQt;
  public long ZJA;
  public String finderUsername;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168976);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.g(2, this.finderUsername);
      }
      paramVarArgs.bv(3, this.GQt);
      if (this.BgS != null) {
        paramVarArgs.d(4, this.BgS);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(5, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.ZJA);
      paramVarArgs.bS(7, this.scene);
      AppMethodBeat.o(168976);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.finderUsername);
      }
      i += i.a.a.b.b.a.q(3, this.GQt);
      paramInt = i;
      if (this.BgS != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.BgS);
      }
      i = paramInt;
      if (this.CJv != null) {
        i = paramInt + i.a.a.a.qC(5, this.CJv.computeSize());
      }
      paramInt = i.a.a.b.b.a.q(6, this.ZJA);
      int j = i.a.a.b.b.a.cJ(7, this.scene);
      AppMethodBeat.o(168976);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168976);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ayq localayq = (ayq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168976);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localayq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168976);
          return 0;
        case 2: 
          localayq.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168976);
          return 0;
        case 3: 
          localayq.GQt = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168976);
          return 0;
        case 4: 
          localayq.BgS = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168976);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localayq.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168976);
          return 0;
        case 6: 
          localayq.ZJA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168976);
          return 0;
        }
        localayq.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168976);
        return 0;
      }
      AppMethodBeat.o(168976);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayq
 * JD-Core Version:    0.7.0.1
 */