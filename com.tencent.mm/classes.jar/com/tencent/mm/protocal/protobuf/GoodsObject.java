package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoodsObject
  extends com.tencent.mm.bw.a
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(1, this.relative_minx);
      paramVarArgs.y(2, this.relative_miny);
      paramVarArgs.y(3, this.relative_maxx);
      paramVarArgs.y(4, this.relative_maxy);
      paramVarArgs.y(5, this.score);
      paramVarArgs.aS(11, this.minx);
      paramVarArgs.aS(12, this.miny);
      paramVarArgs.aS(13, this.maxx);
      paramVarArgs.aS(14, this.maxy);
      paramVarArgs.y(21, this.center_x);
      paramVarArgs.y(22, this.center_y);
      paramVarArgs.y(23, this.obj_w);
      paramVarArgs.y(24, this.obj_h);
      AppMethodBeat.o(124513);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amE(1);
      int i = f.a.a.b.b.a.amE(2);
      int j = f.a.a.b.b.a.amE(3);
      int k = f.a.a.b.b.a.amE(4);
      int m = f.a.a.b.b.a.amE(5);
      int n = f.a.a.b.b.a.bz(11, this.minx);
      int i1 = f.a.a.b.b.a.bz(12, this.miny);
      int i2 = f.a.a.b.b.a.bz(13, this.maxx);
      int i3 = f.a.a.b.b.a.bz(14, this.maxy);
      int i4 = f.a.a.b.b.a.amE(21);
      int i5 = f.a.a.b.b.a.amE(22);
      int i6 = f.a.a.b.b.a.amE(23);
      int i7 = f.a.a.b.b.a.amE(24);
      AppMethodBeat.o(124513);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124513);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
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
        localGoodsObject.relative_minx = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(124513);
        return 0;
      case 2: 
        localGoodsObject.relative_miny = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(124513);
        return 0;
      case 3: 
        localGoodsObject.relative_maxx = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(124513);
        return 0;
      case 4: 
        localGoodsObject.relative_maxy = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(124513);
        return 0;
      case 5: 
        localGoodsObject.score = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(124513);
        return 0;
      case 11: 
        localGoodsObject.minx = locala.OmT.zc();
        AppMethodBeat.o(124513);
        return 0;
      case 12: 
        localGoodsObject.miny = locala.OmT.zc();
        AppMethodBeat.o(124513);
        return 0;
      case 13: 
        localGoodsObject.maxx = locala.OmT.zc();
        AppMethodBeat.o(124513);
        return 0;
      case 14: 
        localGoodsObject.maxy = locala.OmT.zc();
        AppMethodBeat.o(124513);
        return 0;
      case 21: 
        localGoodsObject.center_x = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(124513);
        return 0;
      case 22: 
        localGoodsObject.center_y = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(124513);
        return 0;
      case 23: 
        localGoodsObject.obj_w = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(124513);
        return 0;
      }
      localGoodsObject.obj_h = Float.intBitsToFloat(locala.OmT.gwb());
      AppMethodBeat.o(124513);
      return 0;
    }
    AppMethodBeat.o(124513);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.GoodsObject
 * JD-Core Version:    0.7.0.1
 */