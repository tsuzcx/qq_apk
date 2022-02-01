package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoodsObject
  extends com.tencent.mm.bx.a
{
  public float center_x;
  public float center_y;
  public int maxx;
  public int maxy;
  public int minx;
  public int miny;
  public float obj_h;
  public float obj_w;
  public float relative_maxx;
  public float relative_maxy;
  public float relative_minx;
  public float relative_miny;
  public float score;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124513);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.relative_minx);
      paramVarArgs.l(2, this.relative_miny);
      paramVarArgs.l(3, this.relative_maxx);
      paramVarArgs.l(4, this.relative_maxy);
      paramVarArgs.l(5, this.score);
      paramVarArgs.bS(11, this.minx);
      paramVarArgs.bS(12, this.miny);
      paramVarArgs.bS(13, this.maxx);
      paramVarArgs.bS(14, this.maxy);
      paramVarArgs.l(21, this.center_x);
      paramVarArgs.l(22, this.center_y);
      paramVarArgs.l(23, this.obj_w);
      paramVarArgs.l(24, this.obj_h);
      AppMethodBeat.o(124513);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      int n = i.a.a.b.b.a.cJ(11, this.minx);
      int i1 = i.a.a.b.b.a.cJ(12, this.miny);
      int i2 = i.a.a.b.b.a.cJ(13, this.maxx);
      int i3 = i.a.a.b.b.a.cJ(14, this.maxy);
      int i4 = i.a.a.b.b.a.ko(21);
      int i5 = i.a.a.b.b.a.ko(22);
      int i6 = i.a.a.b.b.a.ko(23);
      int i7 = i.a.a.b.b.a.ko(24);
      AppMethodBeat.o(124513);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + (m + 4) + n + i1 + i2 + i3 + (i4 + 4) + (i5 + 4) + (i6 + 4) + (i7 + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(124513);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      GoodsObject localGoodsObject = (GoodsObject)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      default: 
        AppMethodBeat.o(124513);
        return -1;
      case 1: 
        localGoodsObject.relative_minx = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(124513);
        return 0;
      case 2: 
        localGoodsObject.relative_miny = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(124513);
        return 0;
      case 3: 
        localGoodsObject.relative_maxx = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(124513);
        return 0;
      case 4: 
        localGoodsObject.relative_maxy = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(124513);
        return 0;
      case 5: 
        localGoodsObject.score = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(124513);
        return 0;
      case 11: 
        localGoodsObject.minx = locala.ajGk.aar();
        AppMethodBeat.o(124513);
        return 0;
      case 12: 
        localGoodsObject.miny = locala.ajGk.aar();
        AppMethodBeat.o(124513);
        return 0;
      case 13: 
        localGoodsObject.maxx = locala.ajGk.aar();
        AppMethodBeat.o(124513);
        return 0;
      case 14: 
        localGoodsObject.maxy = locala.ajGk.aar();
        AppMethodBeat.o(124513);
        return 0;
      case 21: 
        localGoodsObject.center_x = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(124513);
        return 0;
      case 22: 
        localGoodsObject.center_y = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(124513);
        return 0;
      case 23: 
        localGoodsObject.obj_w = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(124513);
        return 0;
      }
      localGoodsObject.obj_h = Float.intBitsToFloat(locala.ajGk.aax());
      AppMethodBeat.o(124513);
      return 0;
    }
    AppMethodBeat.o(124513);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.GoodsObject
 * JD-Core Version:    0.7.0.1
 */