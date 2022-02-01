package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azg
  extends erp
{
  public String ACm;
  public atz CJv;
  public String YIZ;
  public aur ZDQ;
  public long ZJD;
  public int hJx;
  public b lastBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168985);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.ZJD);
      if (this.YIZ != null) {
        paramVarArgs.g(3, this.YIZ);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.d(4, this.lastBuffer);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(5, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      if (this.ACm != null) {
        paramVarArgs.g(6, this.ACm);
      }
      paramVarArgs.bS(7, this.hJx);
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(8, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label824;
      }
    }
    label824:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.ZJD);
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YIZ);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.lastBuffer);
      }
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(5, this.CJv.computeSize());
      }
      i = paramInt;
      if (this.ACm != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ACm);
      }
      i += i.a.a.b.b.a.cJ(7, this.hJx);
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZDQ.computeSize());
      }
      AppMethodBeat.o(168985);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azg localazg = (azg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168985);
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
            localazg.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        case 2: 
          localazg.ZJD = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168985);
          return 0;
        case 3: 
          localazg.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168985);
          return 0;
        case 4: 
          localazg.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168985);
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
            localazg.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        case 6: 
          localazg.ACm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168985);
          return 0;
        case 7: 
          localazg.hJx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168985);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aur();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aur)localObject2).parseFrom((byte[])localObject1);
          }
          localazg.ZDQ = ((aur)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168985);
        return 0;
      }
      AppMethodBeat.o(168985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azg
 * JD-Core Version:    0.7.0.1
 */