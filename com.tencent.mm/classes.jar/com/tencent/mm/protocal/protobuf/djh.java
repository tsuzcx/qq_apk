package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djh
  extends com.tencent.mm.bx.a
{
  public String FSU;
  public String FSW;
  public boolean GZQ;
  public boolean GZR;
  public bqj aaOZ;
  public String aaPa;
  public boolean aaPb;
  public LinkedList<dji> mediaList;
  public String musicFeedId;
  public int soundTrackType;
  
  public djh()
  {
    AppMethodBeat.i(169078);
    this.mediaList = new LinkedList();
    AppMethodBeat.o(169078);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169079);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.mediaList);
      if (this.aaOZ != null)
      {
        paramVarArgs.qD(2, this.aaOZ.computeSize());
        this.aaOZ.writeFields(paramVarArgs);
      }
      if (this.FSW != null) {
        paramVarArgs.g(3, this.FSW);
      }
      if (this.FSU != null) {
        paramVarArgs.g(4, this.FSU);
      }
      if (this.aaPa != null) {
        paramVarArgs.g(5, this.aaPa);
      }
      paramVarArgs.di(6, this.GZQ);
      paramVarArgs.di(7, this.GZR);
      paramVarArgs.bS(8, this.soundTrackType);
      if (this.musicFeedId != null) {
        paramVarArgs.g(9, this.musicFeedId);
      }
      paramVarArgs.di(10, this.aaPb);
      AppMethodBeat.o(169079);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.mediaList) + 0;
      paramInt = i;
      if (this.aaOZ != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaOZ.computeSize());
      }
      i = paramInt;
      if (this.FSW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.FSW);
      }
      paramInt = i;
      if (this.FSU != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.FSU);
      }
      i = paramInt;
      if (this.aaPa != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaPa);
      }
      i = i + (i.a.a.b.b.a.ko(6) + 1) + (i.a.a.b.b.a.ko(7) + 1) + i.a.a.b.b.a.cJ(8, this.soundTrackType);
      paramInt = i;
      if (this.musicFeedId != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.musicFeedId);
      }
      i = i.a.a.b.b.a.ko(10);
      AppMethodBeat.o(169079);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.mediaList.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169079);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      djh localdjh = (djh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169079);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dji();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dji)localObject2).parseFrom((byte[])localObject1);
          }
          localdjh.mediaList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169079);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bqj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bqj)localObject2).parseFrom((byte[])localObject1);
          }
          localdjh.aaOZ = ((bqj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169079);
        return 0;
      case 3: 
        localdjh.FSW = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169079);
        return 0;
      case 4: 
        localdjh.FSU = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169079);
        return 0;
      case 5: 
        localdjh.aaPa = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169079);
        return 0;
      case 6: 
        localdjh.GZQ = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(169079);
        return 0;
      case 7: 
        localdjh.GZR = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(169079);
        return 0;
      case 8: 
        localdjh.soundTrackType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169079);
        return 0;
      case 9: 
        localdjh.musicFeedId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169079);
        return 0;
      }
      localdjh.aaPb = ((i.a.a.a.a)localObject1).ajGk.aai();
      AppMethodBeat.o(169079);
      return 0;
    }
    AppMethodBeat.o(169079);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djh
 * JD-Core Version:    0.7.0.1
 */