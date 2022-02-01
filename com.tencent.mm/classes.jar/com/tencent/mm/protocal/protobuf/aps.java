package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aps
  extends com.tencent.mm.bx.a
{
  public String ZwW;
  public apt ZwX;
  public String finderUsername;
  public long hKN;
  public int mediaType;
  public String sessionBuffer;
  public int videoDuration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259359);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.hKN);
      if (this.finderUsername != null) {
        paramVarArgs.g(2, this.finderUsername);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.g(3, this.sessionBuffer);
      }
      if (this.ZwW != null) {
        paramVarArgs.g(4, this.ZwW);
      }
      paramVarArgs.bS(5, this.videoDuration);
      paramVarArgs.bS(6, this.mediaType);
      if (this.ZwX != null)
      {
        paramVarArgs.qD(7, this.ZwX.computeSize());
        this.ZwX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259359);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.hKN) + 0;
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.finderUsername);
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.sessionBuffer);
      }
      paramInt = i;
      if (this.ZwW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZwW);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.videoDuration) + i.a.a.b.b.a.cJ(6, this.mediaType);
      paramInt = i;
      if (this.ZwX != null) {
        paramInt = i + i.a.a.a.qC(7, this.ZwX.computeSize());
      }
      AppMethodBeat.o(259359);
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
      AppMethodBeat.o(259359);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      aps localaps = (aps)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259359);
        return -1;
      case 1: 
        localaps.hKN = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259359);
        return 0;
      case 2: 
        localaps.finderUsername = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259359);
        return 0;
      case 3: 
        localaps.sessionBuffer = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259359);
        return 0;
      case 4: 
        localaps.ZwW = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259359);
        return 0;
      case 5: 
        localaps.videoDuration = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259359);
        return 0;
      case 6: 
        localaps.mediaType = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259359);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        apt localapt = new apt();
        if ((localObject != null) && (localObject.length > 0)) {
          localapt.parseFrom((byte[])localObject);
        }
        localaps.ZwX = localapt;
        paramInt += 1;
      }
      AppMethodBeat.o(259359);
      return 0;
    }
    AppMethodBeat.o(259359);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aps
 * JD-Core Version:    0.7.0.1
 */