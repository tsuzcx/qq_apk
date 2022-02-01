package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcq
  extends com.tencent.mm.bx.a
{
  public int abCd;
  public fcr abCe;
  public fcv abCf;
  public fcs abCg;
  public LinkedList<fcr> abCh;
  
  public fcq()
  {
    AppMethodBeat.i(259057);
    this.abCh = new LinkedList();
    AppMethodBeat.o(259057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259062);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abCd);
      if (this.abCe != null)
      {
        paramVarArgs.qD(2, this.abCe.computeSize());
        this.abCe.writeFields(paramVarArgs);
      }
      if (this.abCf != null)
      {
        paramVarArgs.qD(3, this.abCf.computeSize());
        this.abCf.writeFields(paramVarArgs);
      }
      if (this.abCg != null)
      {
        paramVarArgs.qD(4, this.abCg.computeSize());
        this.abCg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.abCh);
      AppMethodBeat.o(259062);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abCd) + 0;
      paramInt = i;
      if (this.abCe != null) {
        paramInt = i + i.a.a.a.qC(2, this.abCe.computeSize());
      }
      i = paramInt;
      if (this.abCf != null) {
        i = paramInt + i.a.a.a.qC(3, this.abCf.computeSize());
      }
      paramInt = i;
      if (this.abCg != null) {
        paramInt = i + i.a.a.a.qC(4, this.abCg.computeSize());
      }
      i = i.a.a.a.c(5, 8, this.abCh);
      AppMethodBeat.o(259062);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abCh.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259062);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      fcq localfcq = (fcq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259062);
        return -1;
      case 1: 
        localfcq.abCd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259062);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fcr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fcr)localObject2).parseFrom((byte[])localObject1);
          }
          localfcq.abCe = ((fcr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259062);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fcv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fcv)localObject2).parseFrom((byte[])localObject1);
          }
          localfcq.abCf = ((fcv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259062);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fcs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fcs)localObject2).parseFrom((byte[])localObject1);
          }
          localfcq.abCg = ((fcs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259062);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fcr();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fcr)localObject2).parseFrom((byte[])localObject1);
        }
        localfcq.abCh.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259062);
      return 0;
    }
    AppMethodBeat.o(259062);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcq
 * JD-Core Version:    0.7.0.1
 */