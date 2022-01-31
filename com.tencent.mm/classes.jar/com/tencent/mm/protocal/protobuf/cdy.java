package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdy
  extends com.tencent.mm.bv.a
{
  public boolean bTs;
  public long endTime;
  public String feedId;
  public int height;
  public int iiX;
  public int lCk;
  public int lPs;
  public int qZo;
  public int sbb;
  public long startTime;
  public double xOA;
  public int xOB;
  public int xOv;
  public int xOw;
  public LinkedList<adk> xOx;
  public long xOy;
  public double xOz;
  public int y;
  
  public cdy()
  {
    AppMethodBeat.i(73655);
    this.y = -1;
    this.height = -1;
    this.iiX = -1;
    this.xOv = 0;
    this.qZo = -1;
    this.xOw = -1;
    this.lCk = 0;
    this.sbb = 0;
    this.bTs = false;
    this.startTime = -1L;
    this.endTime = -1L;
    this.xOx = new LinkedList();
    this.xOy = 0L;
    this.xOz = 0.0D;
    this.xOA = 0.0D;
    AppMethodBeat.o(73655);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73656);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.feedId != null) {
        paramVarArgs.e(1, this.feedId);
      }
      paramVarArgs.aO(2, this.y);
      paramVarArgs.aO(3, this.height);
      paramVarArgs.aO(4, this.iiX);
      paramVarArgs.aO(5, this.xOv);
      paramVarArgs.aO(6, this.qZo);
      paramVarArgs.aO(7, this.xOw);
      paramVarArgs.aO(8, this.lCk);
      paramVarArgs.aO(9, this.sbb);
      paramVarArgs.aS(10, this.bTs);
      paramVarArgs.am(11, this.startTime);
      paramVarArgs.am(12, this.endTime);
      paramVarArgs.e(13, 8, this.xOx);
      paramVarArgs.am(14, this.xOy);
      paramVarArgs.f(15, this.xOz);
      paramVarArgs.f(16, this.xOA);
      paramVarArgs.aO(17, this.xOB);
      paramVarArgs.aO(18, this.lPs);
      AppMethodBeat.o(73656);
      return 0;
    }
    if (paramInt == 1) {
      if (this.feedId == null) {
        break label1120;
      }
    }
    label1120:
    for (paramInt = e.a.a.b.b.a.f(1, this.feedId) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.y);
      int j = e.a.a.b.b.a.bl(3, this.height);
      int k = e.a.a.b.b.a.bl(4, this.iiX);
      int m = e.a.a.b.b.a.bl(5, this.xOv);
      int n = e.a.a.b.b.a.bl(6, this.qZo);
      int i1 = e.a.a.b.b.a.bl(7, this.xOw);
      int i2 = e.a.a.b.b.a.bl(8, this.lCk);
      int i3 = e.a.a.b.b.a.bl(9, this.sbb);
      int i4 = e.a.a.b.b.a.eW(10);
      int i5 = e.a.a.b.b.a.p(11, this.startTime);
      int i6 = e.a.a.b.b.a.p(12, this.endTime);
      int i7 = e.a.a.a.c(13, 8, this.xOx);
      int i8 = e.a.a.b.b.a.p(14, this.xOy);
      int i9 = e.a.a.b.b.a.eW(15);
      int i10 = e.a.a.b.b.a.eW(16);
      int i11 = e.a.a.b.b.a.bl(17, this.xOB);
      int i12 = e.a.a.b.b.a.bl(18, this.lPs);
      AppMethodBeat.o(73656);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5 + i6 + i7 + i8 + (i9 + 8) + (i10 + 8) + i11 + i12;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xOx.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73656);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cdy localcdy = (cdy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73656);
          return -1;
        case 1: 
          localcdy.feedId = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73656);
          return 0;
        case 2: 
          localcdy.y = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73656);
          return 0;
        case 3: 
          localcdy.height = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73656);
          return 0;
        case 4: 
          localcdy.iiX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73656);
          return 0;
        case 5: 
          localcdy.xOv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73656);
          return 0;
        case 6: 
          localcdy.qZo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73656);
          return 0;
        case 7: 
          localcdy.xOw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73656);
          return 0;
        case 8: 
          localcdy.lCk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73656);
          return 0;
        case 9: 
          localcdy.sbb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73656);
          return 0;
        case 10: 
          localcdy.bTs = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(73656);
          return 0;
        case 11: 
          localcdy.startTime = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(73656);
          return 0;
        case 12: 
          localcdy.endTime = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(73656);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adk();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((adk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcdy.xOx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73656);
          return 0;
        case 14: 
          localcdy.xOy = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(73656);
          return 0;
        case 15: 
          localcdy.xOz = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(73656);
          return 0;
        case 16: 
          localcdy.xOA = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(73656);
          return 0;
        case 17: 
          localcdy.xOB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73656);
          return 0;
        }
        localcdy.lPs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(73656);
        return 0;
      }
      AppMethodBeat.o(73656);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdy
 * JD-Core Version:    0.7.0.1
 */