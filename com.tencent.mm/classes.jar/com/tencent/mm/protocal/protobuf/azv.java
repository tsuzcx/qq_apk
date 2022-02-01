package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azv
  extends esc
{
  public int EdW;
  public int EdX;
  public int ZKA;
  public bgh ZKB;
  public LinkedList<blq> ZKC;
  public b ZKu;
  public LinkedList<bgh> ZKw;
  public LinkedList<bgh> ZKx;
  public long ZKy;
  public int ZKz;
  public long mMJ;
  
  public azv()
  {
    AppMethodBeat.i(258922);
    this.ZKw = new LinkedList();
    this.ZKx = new LinkedList();
    this.ZKC = new LinkedList();
    AppMethodBeat.o(258922);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258932);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZKw);
      paramVarArgs.bv(3, this.mMJ);
      paramVarArgs.e(4, 8, this.ZKx);
      paramVarArgs.bv(5, this.ZKy);
      paramVarArgs.bS(6, this.ZKz);
      paramVarArgs.bS(7, this.ZKA);
      if (this.ZKB != null)
      {
        paramVarArgs.qD(8, this.ZKB.computeSize());
        this.ZKB.writeFields(paramVarArgs);
      }
      if (this.ZKu != null) {
        paramVarArgs.d(9, this.ZKu);
      }
      paramVarArgs.bS(10, this.EdW);
      paramVarArgs.bS(11, this.EdX);
      paramVarArgs.e(12, 8, this.ZKC);
      AppMethodBeat.o(258932);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1104;
      }
    }
    label1104:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZKw) + i.a.a.b.b.a.q(3, this.mMJ) + i.a.a.a.c(4, 8, this.ZKx) + i.a.a.b.b.a.q(5, this.ZKy) + i.a.a.b.b.a.cJ(6, this.ZKz) + i.a.a.b.b.a.cJ(7, this.ZKA);
      paramInt = i;
      if (this.ZKB != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZKB.computeSize());
      }
      i = paramInt;
      if (this.ZKu != null) {
        i = paramInt + i.a.a.b.b.a.c(9, this.ZKu);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.EdW);
      int j = i.a.a.b.b.a.cJ(11, this.EdX);
      int k = i.a.a.a.c(12, 8, this.ZKC);
      AppMethodBeat.o(258932);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZKw.clear();
        this.ZKx.clear();
        this.ZKC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258932);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azv localazv = (azv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258932);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localazv.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258932);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgh)localObject2).parseFrom((byte[])localObject1);
            }
            localazv.ZKw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258932);
          return 0;
        case 3: 
          localazv.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258932);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgh)localObject2).parseFrom((byte[])localObject1);
            }
            localazv.ZKx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258932);
          return 0;
        case 5: 
          localazv.ZKy = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258932);
          return 0;
        case 6: 
          localazv.ZKz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258932);
          return 0;
        case 7: 
          localazv.ZKA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258932);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgh)localObject2).parseFrom((byte[])localObject1);
            }
            localazv.ZKB = ((bgh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258932);
          return 0;
        case 9: 
          localazv.ZKu = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258932);
          return 0;
        case 10: 
          localazv.EdW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258932);
          return 0;
        case 11: 
          localazv.EdX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258932);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new blq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((blq)localObject2).parseFrom((byte[])localObject1);
          }
          localazv.ZKC.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258932);
        return 0;
      }
      AppMethodBeat.o(258932);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azv
 * JD-Core Version:    0.7.0.1
 */