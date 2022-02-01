package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbs
  extends com.tencent.mm.bx.a
{
  public String Idi;
  public boolean ZSq;
  public int aakj;
  public bgy aala;
  public bof aalb;
  public int fZW;
  public String report_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258229);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.fZW);
      if (this.Idi != null) {
        paramVarArgs.g(2, this.Idi);
      }
      paramVarArgs.bS(3, this.aakj);
      if (this.aala != null)
      {
        paramVarArgs.qD(4, this.aala.computeSize());
        this.aala.writeFields(paramVarArgs);
      }
      if (this.aalb != null)
      {
        paramVarArgs.qD(5, this.aalb.computeSize());
        this.aalb.writeFields(paramVarArgs);
      }
      paramVarArgs.di(6, this.ZSq);
      if (this.report_info != null) {
        paramVarArgs.g(7, this.report_info);
      }
      AppMethodBeat.o(258229);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.fZW) + 0;
      paramInt = i;
      if (this.Idi != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Idi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.aakj);
      paramInt = i;
      if (this.aala != null) {
        paramInt = i + i.a.a.a.qC(4, this.aala.computeSize());
      }
      i = paramInt;
      if (this.aalb != null) {
        i = paramInt + i.a.a.a.qC(5, this.aalb.computeSize());
      }
      i += i.a.a.b.b.a.ko(6) + 1;
      paramInt = i;
      if (this.report_info != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.report_info);
      }
      AppMethodBeat.o(258229);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258229);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      cbs localcbs = (cbs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258229);
        return -1;
      case 1: 
        localcbs.fZW = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258229);
        return 0;
      case 2: 
        localcbs.Idi = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258229);
        return 0;
      case 3: 
        localcbs.aakj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258229);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bgy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bgy)localObject2).parseFrom((byte[])localObject1);
          }
          localcbs.aala = ((bgy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258229);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bof();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bof)localObject2).parseFrom((byte[])localObject1);
          }
          localcbs.aalb = ((bof)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258229);
        return 0;
      case 6: 
        localcbs.ZSq = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(258229);
        return 0;
      }
      localcbs.report_info = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(258229);
      return 0;
    }
    AppMethodBeat.o(258229);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbs
 * JD-Core Version:    0.7.0.1
 */