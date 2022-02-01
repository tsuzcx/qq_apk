package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmb
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public dbp Dah;
  public bxs Ehd;
  public float Ehe;
  public long Ehf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91675);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CDW != null) {
        paramVarArgs.d(1, this.CDW);
      }
      if (this.Dah != null)
      {
        paramVarArgs.kX(2, this.Dah.computeSize());
        this.Dah.writeFields(paramVarArgs);
      }
      if (this.Ehd != null)
      {
        paramVarArgs.kX(3, this.Ehd.computeSize());
        this.Ehd.writeFields(paramVarArgs);
      }
      paramVarArgs.x(4, this.Ehe);
      paramVarArgs.aG(5, this.Ehf);
      AppMethodBeat.o(91675);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CDW == null) {
        break label617;
      }
    }
    label617:
    for (int i = f.a.a.b.b.a.e(1, this.CDW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dah != null) {
        paramInt = i + f.a.a.a.kW(2, this.Dah.computeSize());
      }
      i = paramInt;
      if (this.Ehd != null) {
        i = paramInt + f.a.a.a.kW(3, this.Ehd.computeSize());
      }
      paramInt = f.a.a.b.b.a.fY(4);
      int j = f.a.a.b.b.a.q(5, this.Ehf);
      AppMethodBeat.o(91675);
      return i + (paramInt + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91675);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmb localcmb = (cmb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91675);
          return -1;
        case 1: 
          localcmb.CDW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91675);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmb.Dah = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmb.Ehd = ((bxs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 4: 
          localcmb.Ehe = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(91675);
          return 0;
        }
        localcmb.Ehf = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91675);
        return 0;
      }
      AppMethodBeat.o(91675);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmb
 * JD-Core Version:    0.7.0.1
 */