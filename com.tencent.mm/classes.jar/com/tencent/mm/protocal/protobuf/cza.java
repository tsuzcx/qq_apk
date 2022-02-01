package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cza
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int ElZ;
  public int Ema;
  public String EpY;
  public String EpZ;
  public int Eqb;
  public cyt Eqj;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public String gKr;
  public int mBH;
  public String sdP;
  public String sdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Id);
      if (this.sdQ != null) {
        paramVarArgs.d(2, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(3, this.sdP);
      }
      if (this.EpY != null) {
        paramVarArgs.d(4, this.EpY);
      }
      if (this.EpZ != null) {
        paramVarArgs.d(5, this.EpZ);
      }
      if (this.gKr != null) {
        paramVarArgs.d(6, this.gKr);
      }
      paramVarArgs.aR(7, this.mBH);
      paramVarArgs.aR(8, this.CreateTime);
      paramVarArgs.aR(9, this.Ema);
      paramVarArgs.aR(10, this.ElZ);
      paramVarArgs.aR(11, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(12, this.ThumbUrl);
      }
      if (this.Eqj != null)
      {
        paramVarArgs.kX(13, this.Eqj.computeSize());
        this.Eqj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.Eqb);
      AppMethodBeat.o(118472);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.Id) + 0;
      paramInt = i;
      if (this.sdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sdQ);
      }
      i = paramInt;
      if (this.sdP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdP);
      }
      paramInt = i;
      if (this.EpY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EpY);
      }
      i = paramInt;
      if (this.EpZ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EpZ);
      }
      paramInt = i;
      if (this.gKr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gKr);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.mBH) + f.a.a.b.b.a.bA(8, this.CreateTime) + f.a.a.b.b.a.bA(9, this.Ema) + f.a.a.b.b.a.bA(10, this.ElZ) + f.a.a.b.b.a.bA(11, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ThumbUrl);
      }
      i = paramInt;
      if (this.Eqj != null) {
        i = paramInt + f.a.a.a.kW(13, this.Eqj.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(14, this.Eqb);
      AppMethodBeat.o(118472);
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
      AppMethodBeat.o(118472);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cza localcza = (cza)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118472);
        return -1;
      case 1: 
        localcza.Id = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(118472);
        return 0;
      case 2: 
        localcza.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 3: 
        localcza.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 4: 
        localcza.EpY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 5: 
        localcza.EpZ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 6: 
        localcza.gKr = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 7: 
        localcza.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118472);
        return 0;
      case 8: 
        localcza.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118472);
        return 0;
      case 9: 
        localcza.Ema = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118472);
        return 0;
      case 10: 
        localcza.ElZ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118472);
        return 0;
      case 11: 
        localcza.IsNotRichText = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118472);
        return 0;
      case 12: 
        localcza.ThumbUrl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cyt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcza.Eqj = ((cyt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118472);
        return 0;
      }
      localcza.Eqb = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(118472);
      return 0;
    }
    AppMethodBeat.o(118472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cza
 * JD-Core Version:    0.7.0.1
 */