package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dls
  extends com.tencent.mm.bx.a
{
  public String ZTw;
  public int aaRI;
  public float aaRM;
  public float aaRN;
  public String aaRO;
  public LinkedList<String> aaRP;
  public LinkedList<String> aaRQ;
  public LinkedList<dlt> aaRR;
  public LinkedList<dlq> aaRS;
  public int aaRT;
  public int duration;
  public int hMx;
  public String nUZ;
  public String pic_url;
  
  public dls()
  {
    AppMethodBeat.i(169924);
    this.aaRP = new LinkedList();
    this.aaRQ = new LinkedList();
    this.aaRR = new LinkedList();
    this.aaRS = new LinkedList();
    this.aaRT = 1;
    AppMethodBeat.o(169924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169925);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaRO == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.aaRI);
      paramVarArgs.l(2, this.aaRM);
      paramVarArgs.l(3, this.aaRN);
      if (this.aaRO != null) {
        paramVarArgs.g(4, this.aaRO);
      }
      paramVarArgs.e(5, 1, this.aaRP);
      if (this.ZTw != null) {
        paramVarArgs.g(6, this.ZTw);
      }
      paramVarArgs.e(7, 1, this.aaRQ);
      paramVarArgs.e(8, 8, this.aaRR);
      if (this.pic_url != null) {
        paramVarArgs.g(9, this.pic_url);
      }
      if (this.nUZ != null) {
        paramVarArgs.g(10, this.nUZ);
      }
      paramVarArgs.e(11, 8, this.aaRS);
      paramVarArgs.bS(12, this.hMx);
      paramVarArgs.bS(13, this.duration);
      paramVarArgs.bS(14, this.aaRT);
      AppMethodBeat.o(169925);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaRI) + 0 + (i.a.a.b.b.a.ko(2) + 4) + (i.a.a.b.b.a.ko(3) + 4);
      paramInt = i;
      if (this.aaRO != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaRO);
      }
      i = paramInt + i.a.a.a.c(5, 1, this.aaRP);
      paramInt = i;
      if (this.ZTw != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZTw);
      }
      i = paramInt + i.a.a.a.c(7, 1, this.aaRQ) + i.a.a.a.c(8, 8, this.aaRR);
      paramInt = i;
      if (this.pic_url != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.pic_url);
      }
      i = paramInt;
      if (this.nUZ != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.nUZ);
      }
      paramInt = i.a.a.a.c(11, 8, this.aaRS);
      int j = i.a.a.b.b.a.cJ(12, this.hMx);
      int k = i.a.a.b.b.a.cJ(13, this.duration);
      int m = i.a.a.b.b.a.cJ(14, this.aaRT);
      AppMethodBeat.o(169925);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaRP.clear();
      this.aaRQ.clear();
      this.aaRR.clear();
      this.aaRS.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.aaRO == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      AppMethodBeat.o(169925);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dls localdls = (dls)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169925);
        return -1;
      case 1: 
        localdls.aaRI = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169925);
        return 0;
      case 2: 
        localdls.aaRM = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
        AppMethodBeat.o(169925);
        return 0;
      case 3: 
        localdls.aaRN = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
        AppMethodBeat.o(169925);
        return 0;
      case 4: 
        localdls.aaRO = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 5: 
        localdls.aaRP.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 6: 
        localdls.ZTw = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 7: 
        localdls.aaRQ.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dlt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dlt)localObject2).parseFrom((byte[])localObject1);
          }
          localdls.aaRR.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 9: 
        localdls.pic_url = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 10: 
        localdls.nUZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dlq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dlq)localObject2).parseFrom((byte[])localObject1);
          }
          localdls.aaRS.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 12: 
        localdls.hMx = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169925);
        return 0;
      case 13: 
        localdls.duration = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169925);
        return 0;
      }
      localdls.aaRT = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(169925);
      return 0;
    }
    AppMethodBeat.o(169925);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dls
 * JD-Core Version:    0.7.0.1
 */