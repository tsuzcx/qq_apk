package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agg
  extends com.tencent.mm.bx.a
{
  public String CEf;
  public agh Div;
  public String dfT;
  public int duration;
  public int gGA;
  public int gGB;
  public String gGC;
  public int gGx = -1;
  public int gGy;
  public int gGz = 0;
  public String gKD;
  public String gKv;
  public int videoHeight;
  public String videoUrl;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127467);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.gGx);
      paramVarArgs.aR(2, this.gGz);
      paramVarArgs.aR(3, this.videoWidth);
      paramVarArgs.aR(4, this.videoHeight);
      paramVarArgs.aR(5, this.gGy);
      paramVarArgs.aR(6, this.duration);
      if (this.gGC != null) {
        paramVarArgs.d(7, this.gGC);
      }
      if (this.dfT != null) {
        paramVarArgs.d(8, this.dfT);
      }
      if (this.gKv != null) {
        paramVarArgs.d(9, this.gKv);
      }
      paramVarArgs.aR(10, this.gGB);
      if (this.Div != null)
      {
        paramVarArgs.kX(11, this.Div.computeSize());
        this.Div.writeFields(paramVarArgs);
      }
      if (this.gKD != null) {
        paramVarArgs.d(12, this.gKD);
      }
      if (this.CEf != null) {
        paramVarArgs.d(13, this.CEf);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(14, this.videoUrl);
      }
      paramVarArgs.aR(15, this.gGA);
      AppMethodBeat.o(127467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.gGx) + 0 + f.a.a.b.b.a.bA(2, this.gGz) + f.a.a.b.b.a.bA(3, this.videoWidth) + f.a.a.b.b.a.bA(4, this.videoHeight) + f.a.a.b.b.a.bA(5, this.gGy) + f.a.a.b.b.a.bA(6, this.duration);
      paramInt = i;
      if (this.gGC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.gGC);
      }
      i = paramInt;
      if (this.dfT != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dfT);
      }
      paramInt = i;
      if (this.gKv != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.gKv);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.gGB);
      paramInt = i;
      if (this.Div != null) {
        paramInt = i + f.a.a.a.kW(11, this.Div.computeSize());
      }
      i = paramInt;
      if (this.gKD != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.gKD);
      }
      paramInt = i;
      if (this.CEf != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CEf);
      }
      i = paramInt;
      if (this.videoUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.videoUrl);
      }
      paramInt = f.a.a.b.b.a.bA(15, this.gGA);
      AppMethodBeat.o(127467);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(127467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      agg localagg = (agg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127467);
        return -1;
      case 1: 
        localagg.gGx = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127467);
        return 0;
      case 2: 
        localagg.gGz = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127467);
        return 0;
      case 3: 
        localagg.videoWidth = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127467);
        return 0;
      case 4: 
        localagg.videoHeight = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127467);
        return 0;
      case 5: 
        localagg.gGy = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127467);
        return 0;
      case 6: 
        localagg.duration = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127467);
        return 0;
      case 7: 
        localagg.gGC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 8: 
        localagg.dfT = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 9: 
        localagg.gKv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 10: 
        localagg.gGB = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(127467);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((agh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagg.Div = ((agh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127467);
        return 0;
      case 12: 
        localagg.gKD = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 13: 
        localagg.CEf = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 14: 
        localagg.videoUrl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127467);
        return 0;
      }
      localagg.gGA = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(127467);
      return 0;
    }
    AppMethodBeat.o(127467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agg
 * JD-Core Version:    0.7.0.1
 */