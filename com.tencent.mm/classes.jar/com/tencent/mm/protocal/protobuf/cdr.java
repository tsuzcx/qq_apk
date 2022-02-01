package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdr
  extends com.tencent.mm.bx.a
{
  public String Vyi;
  public awq YGb;
  public String YIZ;
  public String aanS;
  public fvf aaob;
  public long mMJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257408);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGb != null)
      {
        paramVarArgs.qD(1, this.YGb.computeSize());
        this.YGb.writeFields(paramVarArgs);
      }
      if (this.Vyi != null) {
        paramVarArgs.g(2, this.Vyi);
      }
      if (this.aaob != null)
      {
        paramVarArgs.qD(3, this.aaob.computeSize());
        this.aaob.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(4, this.mMJ);
      if (this.YIZ != null) {
        paramVarArgs.g(5, this.YIZ);
      }
      if (this.aanS != null) {
        paramVarArgs.g(6, this.aanS);
      }
      AppMethodBeat.o(257408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGb == null) {
        break label642;
      }
    }
    label642:
    for (int i = i.a.a.a.qC(1, this.YGb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Vyi != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Vyi);
      }
      i = paramInt;
      if (this.aaob != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaob.computeSize());
      }
      i += i.a.a.b.b.a.q(4, this.mMJ);
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YIZ);
      }
      i = paramInt;
      if (this.aanS != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aanS);
      }
      AppMethodBeat.o(257408);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cdr localcdr = (cdr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257408);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awq)localObject2).parseFrom((byte[])localObject1);
            }
            localcdr.YGb = ((awq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257408);
          return 0;
        case 2: 
          localcdr.Vyi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257408);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fvf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fvf)localObject2).parseFrom((byte[])localObject1);
            }
            localcdr.aaob = ((fvf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257408);
          return 0;
        case 4: 
          localcdr.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257408);
          return 0;
        case 5: 
          localcdr.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257408);
          return 0;
        }
        localcdr.aanS = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257408);
        return 0;
      }
      AppMethodBeat.o(257408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdr
 * JD-Core Version:    0.7.0.1
 */