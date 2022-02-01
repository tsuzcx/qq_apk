package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arn
  extends com.tencent.mm.bx.a
{
  public String YMm;
  public aro ZBl;
  public int duration;
  public String hEE;
  public int nQm = -1;
  public int nQn;
  public int nQo = 0;
  public int nQp;
  public int nQq;
  public String nUF;
  public String nUM;
  public String vid;
  public int videoHeight;
  public String videoUrl;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127467);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.nQm);
      paramVarArgs.bS(2, this.nQo);
      paramVarArgs.bS(3, this.videoWidth);
      paramVarArgs.bS(4, this.videoHeight);
      paramVarArgs.bS(5, this.nQn);
      paramVarArgs.bS(6, this.duration);
      if (this.vid != null) {
        paramVarArgs.g(7, this.vid);
      }
      if (this.hEE != null) {
        paramVarArgs.g(8, this.hEE);
      }
      if (this.nUF != null) {
        paramVarArgs.g(9, this.nUF);
      }
      paramVarArgs.bS(10, this.nQq);
      if (this.ZBl != null)
      {
        paramVarArgs.qD(11, this.ZBl.computeSize());
        this.ZBl.writeFields(paramVarArgs);
      }
      if (this.nUM != null) {
        paramVarArgs.g(12, this.nUM);
      }
      if (this.YMm != null) {
        paramVarArgs.g(13, this.YMm);
      }
      if (this.videoUrl != null) {
        paramVarArgs.g(14, this.videoUrl);
      }
      paramVarArgs.bS(15, this.nQp);
      AppMethodBeat.o(127467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.nQm) + 0 + i.a.a.b.b.a.cJ(2, this.nQo) + i.a.a.b.b.a.cJ(3, this.videoWidth) + i.a.a.b.b.a.cJ(4, this.videoHeight) + i.a.a.b.b.a.cJ(5, this.nQn) + i.a.a.b.b.a.cJ(6, this.duration);
      paramInt = i;
      if (this.vid != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.vid);
      }
      i = paramInt;
      if (this.hEE != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.hEE);
      }
      paramInt = i;
      if (this.nUF != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.nUF);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.nQq);
      paramInt = i;
      if (this.ZBl != null) {
        paramInt = i + i.a.a.a.qC(11, this.ZBl.computeSize());
      }
      i = paramInt;
      if (this.nUM != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.nUM);
      }
      paramInt = i;
      if (this.YMm != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.YMm);
      }
      i = paramInt;
      if (this.videoUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.videoUrl);
      }
      paramInt = i.a.a.b.b.a.cJ(15, this.nQp);
      AppMethodBeat.o(127467);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      arn localarn = (arn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127467);
        return -1;
      case 1: 
        localarn.nQm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127467);
        return 0;
      case 2: 
        localarn.nQo = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127467);
        return 0;
      case 3: 
        localarn.videoWidth = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127467);
        return 0;
      case 4: 
        localarn.videoHeight = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127467);
        return 0;
      case 5: 
        localarn.nQn = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127467);
        return 0;
      case 6: 
        localarn.duration = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127467);
        return 0;
      case 7: 
        localarn.vid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 8: 
        localarn.hEE = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 9: 
        localarn.nUF = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 10: 
        localarn.nQq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127467);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aro localaro = new aro();
          if ((localObject != null) && (localObject.length > 0)) {
            localaro.parseFrom((byte[])localObject);
          }
          localarn.ZBl = localaro;
          paramInt += 1;
        }
        AppMethodBeat.o(127467);
        return 0;
      case 12: 
        localarn.nUM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 13: 
        localarn.YMm = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 14: 
        localarn.videoUrl = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127467);
        return 0;
      }
      localarn.nQp = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(127467);
      return 0;
    }
    AppMethodBeat.o(127467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arn
 * JD-Core Version:    0.7.0.1
 */